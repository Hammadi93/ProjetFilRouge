
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

import fr.norsys.filrouge.dao.PersonneDao;
import fr.norsys.filrouge.dao.PronosticDao;
import fr.norsys.filrouge.dao.RencontreDao;
import fr.norsys.filrouge.entities.Personne;
import fr.norsys.filrouge.entities.Pronostic;
import fr.norsys.filrouge.entities.Rencontre;
import fr.norsys.filrouge.util.SingletonConnexion;

@Repository
@Transactional
public class PronosticsDaoImp implements PronosticDao {

	final static Logger logger = Logger.getLogger(PronosticsDaoImp.class);
	private final Connection connection;
	@Autowired
	private RencontreDao rencontreDao;
	@Autowired
	private PersonneDao personneDao;

	public PronosticsDaoImp() {
		this.connection = SingletonConnexion.getConnexion();
		
	}

	public PronosticsDaoImp(Connection connection) {
		this.connection = connection;
		this.personneDao=new PersonneDaoImp(connection);
		this.rencontreDao=new RencontreDaoImp(connection);
	}

	@Override
	public void createPronostic(Pronostic pronostic) {
		try {
			PreparedStatement preparedStatement = this.connection
					.prepareStatement("insert into pronostic values(?,?,?,?,?,?)");
			preparedStatement.setInt(1, pronostic.getIdPronostic());
			preparedStatement.setInt(2, pronostic.getRencontre().getIdRencontre());
			preparedStatement.setInt(3, pronostic.getPersonne().getIdPersonne());
			preparedStatement.setInt(4, pronostic.getButEquipe1());
			preparedStatement.setInt(5, pronostic.getButEquipe2());
			preparedStatement.setInt(6, pronostic.getScore());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			logger.error("createPronostic SQLException " + e.getMessage());
		}
	}

	@Override
	public ArrayList<Pronostic> getAllPronostics() {
		ArrayList<Pronostic> listPronostic = new ArrayList<Pronostic>();
		try {
			Statement statement = this.connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from pronostic");
			while (resultSet.next()) {
				listPronostic.add(this.getPronosticById(resultSet.getInt(1)).get());
			}
		} catch (SQLException e) {
			logger.error("getAllPronostics SQLException " + e.getMessage());
		}
		return listPronostic;
	}

	@Override
	public Optional<Pronostic> getPronosticById(int id) {
		Pronostic pronostic = new Pronostic();
		Rencontre rencontre = new Rencontre();
		Personne personne = new Personne();

		try {
			PreparedStatement preparedStatement = this.connection
					.prepareStatement("select * from pronostic where idPronostic = ?");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				int idPronostic = resultSet.getInt(1);
				int idRencontre = resultSet.getInt(2);
				int idPersonne = resultSet.getInt(3);
				int butEquipe1 = resultSet.getInt(4);
				int butEquipe2 = resultSet.getInt(5);
				int scorePronostic = resultSet.getInt(6);
				rencontre = this.rencontreDao.getRencontreById(idRencontre).get();
				personne = this.personneDao.getPersonneById(idPersonne).get();
				pronostic = new Pronostic(idPronostic, butEquipe1, butEquipe2, scorePronostic, rencontre, personne);
			}

		} catch (SQLException e) {
			logger.error("getPronosticsById SQLException " + e.getMessage());
		}
		return Optional.of(pronostic);
	}

	@Override
	public void setScore(int id, Pronostic pronostic) {

		try {
			PreparedStatement preparedStatement = this.connection
					.prepareStatement("update pronostic set  score=? where idPronostic=?");
			preparedStatement.setInt(1, pronostic.getScore());
			preparedStatement.setInt(2, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			logger.error("setScore SQLException " + e.getMessage());
		}

	}

	@Override
	public List<Pronostic> getPronosticsByPersonne(Personne personne) {
		List<Pronostic> listPronostic = new ArrayList<Pronostic>();
		try {
			PreparedStatement preparedStatement = this.connection
					.prepareStatement("select * from pronostic where idPersonne = ? ");
			preparedStatement.setInt(1, personne.getIdPersonne());
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int idPronostic = resultSet.getInt(1);
				listPronostic.add(this.getPronosticById(idPronostic).get());
			}
		} catch (SQLException e) {
			logger.error("getPronosticsByPersonne SQLException " + e.getMessage());
		}
		return listPronostic;
	}

	@Override
	public boolean isPronosticsExist(Personne personne, Rencontre rencontre) {
		boolean test = false;
		try {
			PreparedStatement preparedStatement = this.connection
					.prepareStatement("select * from pronostic where idPersonne = ? and idRencontre = ?");
			preparedStatement.setInt(1, personne.getIdPersonne());
			preparedStatement.setInt(2, rencontre.getIdRencontre());
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				test = true;
			}
		} catch (SQLException e) {
			logger.error("Pronostic Exist SQLException " + e.getMessage());
		}

		return test;
	}

	@Override
	public void deletePronostic(int idPronostic) {
		try {
			PreparedStatement preparedStatement = this.connection
					.prepareStatement("delete from pronostic where idPronostic=?");
			preparedStatement.setInt(1, idPronostic);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			logger.error("deletePronostic SQLException " + e.getMessage());
		}
	}

	@Override
	public boolean dejaJouer(Rencontre rencontre) {
		boolean testJoue = false;
		try {
			PreparedStatement preparedStatement = this.connection
					.prepareStatement("select * from rencontre where  idRencontre=? and status=1");
			preparedStatement.setInt(1, rencontre.getIdRencontre());
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.first()) {
				testJoue = true;
			}

		} catch (SQLException e) {
			logger.error("Pronostic Exist SQLException " + e.getMessage());
		}

		return testJoue;
	}
}
