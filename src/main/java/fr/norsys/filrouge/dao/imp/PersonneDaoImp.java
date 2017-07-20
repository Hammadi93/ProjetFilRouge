
package fr.norsys.filrouge.dao.imp;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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

import fr.norsys.filrouge.dao.PersonneDao;
import fr.norsys.filrouge.entities.Personne;
import fr.norsys.filrouge.util.SingletonConnexion;

@Repository
@Transactional
public class PersonneDaoImp implements PersonneDao {

	private final Connection connection;
	final static Logger logger = Logger.getLogger(PersonneDaoImp.class);

	public PersonneDaoImp() {
		this.connection = SingletonConnexion.getConnexion();
	}

	public PersonneDaoImp(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<Personne> getAllPersonnes() {
		List<Personne> listPersonne = new ArrayList<Personne>();

		try {
			Statement statement = this.connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from personne order by scoreGlobal DESC");
			while (resultSet.next()) {
				int idPersonne = resultSet.getInt(1);
				listPersonne.add(this.getPersonneById(idPersonne).get());
			}
		} catch (SQLException e) {
			logger.error("getAllPersonnes SQLException " + e.getMessage());
		}

		return listPersonne;
	}

	@Override
	public Optional<Personne> getPersonneById(int id) {
		Personne personne = new Personne();
		try {
			PreparedStatement preparedStatement = this.connection
					.prepareStatement("select * from personne where idPersonne = ?");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				int idPersonne = resultSet.getInt(1);
				String nomPersonne = resultSet.getString(2);
				String prenomPersonne = resultSet.getString(3);
				String emailPersonne = resultSet.getString(4);
				String passwordPersonne = resultSet.getString(5);
				String rolePersonne = resultSet.getString(6);
				int scoreGlobal = resultSet.getInt(7);
				personne = new Personne(idPersonne, nomPersonne, prenomPersonne, emailPersonne, passwordPersonne,
						rolePersonne, scoreGlobal);
				personne.setScoreGlobal(resultSet.getInt(7));
			}
		} catch (SQLException e) {
			logger.error("getPersonneById SQLException " + e.getMessage());
		}

		return Optional.of(personne);
	}

	@Override
	public Optional<Personne> getPersonneByEmail(String email) {
		Personne personne = new Personne();
		try {
			PreparedStatement preparedStatement = this.connection
					.prepareStatement("select * from personne where email = ?");
			preparedStatement.setString(1, email);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				personne = this.getPersonneById(resultSet.getInt(1)).get();
			}
		} catch (SQLException e) {
			logger.error("getPersonneById SQLException " + e.getMessage());
		}

		return Optional.of(personne);
	}

	@Override
	public void setScoreGlobal(Personne personne) {
		try {
			PreparedStatement preparedStatement = this.connection
					.prepareStatement("update personne set scoreGlobal=? where idPersonne=?");
			preparedStatement.setInt(1, personne.getScoreGlobal());
			preparedStatement.setInt(2, personne.getIdPersonne());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			logger.error("setScoreGlobal SQLException " + e.getMessage());
		}

	}

	@Override
	public boolean validerUtilusateur(String user, String password) {
		boolean status = false;
		try {
			// String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
			MessageDigest md5Algorithme = MessageDigest.getInstance("MD5");
			md5Algorithme.update(password.getBytes(), 0, password.length());
			String hashedPassword = new BigInteger(1, md5Algorithme.digest()).toString(16);

			PreparedStatement preparedStatement = this.connection
					.prepareStatement("select * from personne where email = ? and passwd = ?");
			preparedStatement.setString(1, user);
			preparedStatement.setString(2, hashedPassword);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				status = true;
			}
			return status;
		} catch (NoSuchAlgorithmException e) {
			logger.error(" NoSuchAlgorithmException " + e.getMessage());
			return status;
		} catch (SQLException e) {
			logger.error("validateUser SQLException " + e.getMessage());
			return status;
		}
	}

}
