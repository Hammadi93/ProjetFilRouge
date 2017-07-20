package fr.norsys.filrouge.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.norsys.filrouge.dao.CompetitionDao;
import fr.norsys.filrouge.dao.EquipeDao;
import fr.norsys.filrouge.dao.PouleDao;
import fr.norsys.filrouge.entities.Poule;
import fr.norsys.filrouge.util.SingletonConnexion;

@Repository
@Transactional
public class PouleDaoImp implements PouleDao {
	@Autowired
	private CompetitionDao		competitionDao;
	@Autowired
	private EquipeDao			equipeDao;
	private final Connection	connection;
	final static Logger			logger	= Logger.getLogger(PouleDaoImp.class);

	public PouleDaoImp() {
		this.connection = SingletonConnexion.getConnexion();
	}

	public PouleDaoImp(Connection connection) {
		this.connection = connection;
		this.equipeDao=new EquipeDaoImp(connection);
		this.competitionDao=new CompetitionDaoImp(connection);
	}

	@Override
	public List<Poule> getAllPoulles() {
		ArrayList<Poule> listPoulles = new ArrayList<Poule>();
		try {
			Statement statement = this.connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from poulle");
			while (resultSet.next()) {
				listPoulles.add(this.getPoulleById(resultSet.getInt(1)).get());
			}
		} catch (SQLException e) {
			logger.error("getAllEquipes SQLException " + e.getMessage());
		}
		return listPoulles;
	}

	@Override
	public List<Poule> getAllPoullesByCompetition(int idCompetition) {
		ArrayList<Poule> listPoulles = new ArrayList<Poule>();

		try {
			Statement statement = this.connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from poulle where competition = " + idCompetition);
			while (resultSet.next()) {
				listPoulles.add(this.getPoulleById(resultSet.getInt(1)).get());
			}
		} catch (SQLException e) {
			logger.error("getAllPoulles SQLException " + e.getMessage());
		}

		return listPoulles;
	}

	@Override
	public Optional<Poule> getPoulleById(int id) {
		Poule poule = new Poule();
		try {
			PreparedStatement preparedStatement = this.connection
			        .prepareStatement("select * from poulle where idPoulle = ?");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				int idPoulle = resultSet.getInt(1);
				String libelle = resultSet.getString(2);
				int idCompetition = resultSet.getInt(3);
				poule = new Poule(idPoulle, libelle, (this.competitionDao.getCompetitionById(idCompetition).get()));
				poule.setListEquipe(this.equipeDao.getAllByPoulle(poule));
			}
		} catch (SQLException e) {
			logger.error("getPoulleById SQLException " + e.getMessage());
		}
		return Optional.of(poule);
	}

}
