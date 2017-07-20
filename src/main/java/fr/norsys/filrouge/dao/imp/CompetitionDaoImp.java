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

import fr.norsys.filrouge.dao.CompetitionDao;
import fr.norsys.filrouge.entities.Competition;
import fr.norsys.filrouge.util.SingletonConnexion;

@Repository
@Transactional
public class CompetitionDaoImp implements CompetitionDao {

	private final Connection connection;
	final static Logger logger = Logger.getLogger(CompetitionDaoImp.class);

	public CompetitionDaoImp() {
		this.connection = SingletonConnexion.getConnexion();
	}

	public CompetitionDaoImp(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<Competition> getAllCompetitions() {
		ArrayList<Competition> listCompetitions = new ArrayList<Competition>();

		try {
			Statement statement = this.connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from competition");
			while (resultSet.next()) {
				listCompetitions.add(this.getCompetitionById(resultSet.getInt(1)).get());
			}
		} catch (SQLException e) {
			logger.error("getAllCometitions SQLException " + e.getMessage());
		}
		return listCompetitions;
	}

	@Override
	public Optional<Competition> getCompetitionById(int id) {
		Competition competition = new Competition();
		try {
			PreparedStatement preparedStatement = this.connection
					.prepareStatement("select * from competition where idCompetition = ?");
			preparedStatement.setInt(1, id);
			ResultSet rresultSet = preparedStatement.executeQuery();
			if (rresultSet.next()) {
				int idCompetition = rresultSet.getInt(1);
				String libelleCompetition = rresultSet.getString(2);
				competition = new Competition(idCompetition, libelleCompetition);
			}
		} catch (SQLException e) {
			logger.error("getCometitionById SQLException " + e.getMessage());
		}

		return Optional.of(competition);
	}

}
