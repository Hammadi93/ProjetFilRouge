package fr.norsys.filrouge.dao.competition.impl;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import fr.norsys.filrouge.dao.CompetitionDao;
import fr.norsys.filrouge.dao.imp.CompetitionDaoImp;

public abstract class ACompetitionDaoTest {
	
	private static Connection	connection;
	protected CompetitionDao	competitionDao;

	@BeforeClass
	public static void init() throws SQLException {
		connection = (Connection) new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
		        .addScript("db/createBase.sql").addScript("db/insertData.sql").build().getConnection();
	}

	@Before
	public void setUp() throws Exception {
		competitionDao = new CompetitionDaoImp(connection);
	}
}
