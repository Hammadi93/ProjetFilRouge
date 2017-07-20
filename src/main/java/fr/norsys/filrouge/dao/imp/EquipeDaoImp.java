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
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.norsys.filrouge.dao.EquipeDao;
import fr.norsys.filrouge.entities.Equipe;
import fr.norsys.filrouge.entities.Poule;
import fr.norsys.filrouge.util.SingletonConnexion;

@Repository
@Transactional
public class EquipeDaoImp implements EquipeDao {
	private final Connection	connection;
	final static Logger			logger	= Logger.getLogger(EquipeDaoImp.class);

	public EquipeDaoImp() {
		this.connection = SingletonConnexion.getConnexion();
	}

	public EquipeDaoImp(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<Equipe> getAllEquipes() {
		ArrayList<Equipe> listEquipe = new ArrayList<Equipe>();

		try {
			Statement statement = this.connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from equipe");
			while (resultSet.next()) {
				int idEquipe = resultSet.getInt(1);
				listEquipe.add(this.getEquipeById(idEquipe).get());
			}
		} catch (SQLException e) {
			logger.error("getAllEquipes SQLException " + e.getMessage());
		}

		return listEquipe;
	}

	@Override
	public List<Equipe> getAllByPoulle(Poule poulle) {
		List<Equipe> lstEquipe = new ArrayList<Equipe>();
		try {
			PreparedStatement requetePrepare = this.connection
			        .prepareStatement("select * from equipe where poulle = ?");
			requetePrepare.setInt(1, poulle.getIdPoulle());
			ResultSet rs = requetePrepare.executeQuery();
			while (rs.next()) {
				int idEquipe = rs.getInt(1);
				lstEquipe.add(this.getEquipeById(idEquipe).get());
			}
		} catch (SQLException e) {
			logger.error("getAllByPoulle SQLException " + e.getMessage());
		}

		return lstEquipe;
	}

	@Override
	public Optional<Equipe> getEquipeById(int id) {
		Equipe equipe = new Equipe();
		try {
			PreparedStatement preparedStatement = this.connection
			        .prepareStatement("select * from equipe where idEquipe = ?");
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				int idEquipe = rs.getInt(1);
				String libelleEquipe = rs.getString(2);
				String image = rs.getString(3);
				int idPoulle = rs.getInt(4);
				equipe = new Equipe(idEquipe, libelleEquipe, image, idPoulle);
			}
		} catch (SQLException e) {
			logger.error("getEquipeById SQLException " + e.getMessage());
		}
		return Optional.of(equipe);
	}

	@Override
	public int createEquipe(Equipe equipe) {
		try {
			PreparedStatement preparedStatement = this.connection
			        .prepareStatement("insert into equipe values(?,?,?,?)");
			preparedStatement.setInt(1, equipe.getIdEquipe());
			preparedStatement.setString(2, equipe.getLibelleEquipe());
			preparedStatement.setString(3, equipe.getImgEquipe());
			preparedStatement.setInt(4, equipe.getIdPoulle());
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			logger.error("getEquipeById SQLException " + e.getMessage());
		}
		return 0;
	}

}
