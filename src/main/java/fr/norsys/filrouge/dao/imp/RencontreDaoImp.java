package fr.norsys.filrouge.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
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
import fr.norsys.filrouge.dao.RencontreDao;
import fr.norsys.filrouge.entities.Poule;
import fr.norsys.filrouge.entities.Rencontre;
import fr.norsys.filrouge.util.SingletonConnexion;

@Repository
@Transactional
public class RencontreDaoImp implements RencontreDao {
	final static Logger logger = Logger.getLogger(RencontreDaoImp.class);
	private final Connection connection;
	@Autowired
	private PouleDao pouleDao;
	@Autowired
	private EquipeDao equipeDao;
	@Autowired
	private CompetitionDao competitionDao;

	public RencontreDaoImp() {
		this.connection = SingletonConnexion.getConnexion();
	}

	public RencontreDaoImp(Connection connection) {
		this.connection = connection;
		this.competitionDao=new CompetitionDaoImp(connection);
		this.equipeDao=new EquipeDaoImp(connection);
		this.pouleDao=new PouleDaoImp(connection);
	}

	@Override
	public List<Rencontre> getAllRencontres() {
		List<Rencontre> listRencontre = new ArrayList<Rencontre>();
		try {
			Statement statement = this.connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from rencontre");
			while (resultSet.next()) {
				listRencontre.add(this.getRencontreById(resultSet.getInt(1)).get());
			}
		} catch (SQLException e) {
			logger.error("getAllRencontres SQLException " + e.getMessage());
		}
		return listRencontre;
	}

	@Override
	public Optional<Rencontre> getRencontreById(int id) {
		Rencontre rencontre = new Rencontre();
		try {

			PreparedStatement preparedStatement = this.connection
					.prepareStatement("select * from rencontre where idRencontre = ?");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int idRencontre = resultSet.getInt(1);
				int idPoulle = resultSet.getInt(2);
				int idEquipe1 = resultSet.getInt(3);
				int idEquipe2 = resultSet.getInt(4);
				int idCompetition = resultSet.getInt(5);
				Timestamp dateDebut = resultSet.getTimestamp(6);
				Timestamp dateFin = resultSet.getTimestamp(7);
				int butEquipe1 = resultSet.getInt(8);
				int butEquipe2 = resultSet.getInt(9);
				int etat = resultSet.getInt(10);
				rencontre = new Rencontre(idRencontre, dateDebut, dateFin, butEquipe1, butEquipe2, etat,
						this.equipeDao.getEquipeById(idEquipe1).get(), this.equipeDao.getEquipeById(idEquipe2).get(),
						this.pouleDao.getPoulleById(idPoulle).get(),
						this.competitionDao.getCompetitionById(idCompetition).get());
			}

		} catch (SQLException e) {
			logger.error("getRencontreById SQLException " + e.getMessage());
		}
		return Optional.of(rencontre);
	}

	@Override
	public int createRencontre(Rencontre rencontre) {
		int status = 0;
		try {
			PreparedStatement preparedStatement = this.connection
					.prepareStatement("insert into rencontre values(?,?,?,?,?,?,DEFAULT,?,?,?)");
			preparedStatement.setInt(1, rencontre.getIdRencontre());
			preparedStatement.setInt(2, rencontre.getPoulle().getIdPoulle());
			preparedStatement.setInt(3, rencontre.getEquipe1().getIdEquipe());
			preparedStatement.setInt(4, rencontre.getEquipe2().getIdEquipe());
			preparedStatement.setInt(5, rencontre.getCompetition().getIdCompetition());
			preparedStatement.setTimestamp(6, new Timestamp(rencontre.getDateDebut().getTime()));
			preparedStatement.setInt(7, rencontre.getButEquipe1());
			preparedStatement.setInt(8, rencontre.getButEquipe2());
			preparedStatement.setInt(9, 0);

			status = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			logger.error("createRencontre SQLException " + e.getMessage());
		}
		return status;
	}

	@Override
	public int deleteRencontre(int id) {
		int status = 0;
		try {
			PreparedStatement preparedStatement = this.connection
					.prepareStatement("delete from rencontre where idRencontre=?");
			preparedStatement.setInt(1, id);
			status = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			logger.error("delete SQLException " + e.getMessage());
		}
		return status;
	}

	@Override
	public int updateRencontre(Rencontre rencontre) {
		int status = 0;
		try {
			PreparedStatement preparedStatement = this.connection
					.prepareStatement("update rencontre set butEquipe1=?,butEquipe2=?, status=? where idRencontre=?");
			preparedStatement.setInt(1, rencontre.getButEquipe1());
			preparedStatement.setInt(2, rencontre.getButEquipe2());
			preparedStatement.setInt(3, 1);
			preparedStatement.setInt(4, rencontre.getIdRencontre());
			status = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			logger.error("updatePronostic SQLException " + e.getMessage());
		}
		return status;
	}

	@Override
	public List<Rencontre> getAllRencontresByPolle(Poule polle) {
		List<Rencontre> listRencontre = new ArrayList<Rencontre>();

		try {
			PreparedStatement preparedStatement = this.connection
					.prepareStatement("select * from rencontre where idPoulle = ?");

			preparedStatement.setInt(1, polle.getIdPoulle());
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				listRencontre.add(this.getRencontreById(resultSet.getInt(1)).get());
			}
		} catch (SQLException e) {
			logger.error("getAllRencontres SQLException " + e.getMessage());
		}
		return listRencontre;
	}
}
