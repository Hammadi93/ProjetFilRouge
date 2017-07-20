package fr.norsys.filrouge.dao.personne.impl;

import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import fr.norsys.filrouge.dao.PersonneDao;
import fr.norsys.filrouge.dao.imp.PersonneDaoImp;


public abstract class ApersonneTest {
	private static Connection	connection;
	protected PersonneDao		personneDao;

	@BeforeClass
	public static void init() throws SQLException {
		connection = (Connection) new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
		        .addScript("db/createBase.sql").addScript("db/insertData.sql").build().getConnection();
	}

	@Before
	public void setUp() throws Exception {
		personneDao = new PersonneDaoImp(connection);
	}
	

}
