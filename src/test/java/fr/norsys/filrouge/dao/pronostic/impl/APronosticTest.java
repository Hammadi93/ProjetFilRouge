package fr.norsys.filrouge.dao.pronostic.impl;

import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import fr.norsys.filrouge.dao.PersonneDao;
import fr.norsys.filrouge.dao.PronosticDao;
import fr.norsys.filrouge.dao.RencontreDao;
import fr.norsys.filrouge.dao.imp.PersonneDaoImp;
import fr.norsys.filrouge.dao.imp.PronosticsDaoImp;
import fr.norsys.filrouge.dao.imp.RencontreDaoImp;


public abstract class APronosticTest {
	private static Connection	connection;
	protected PronosticDao		pronosticDao;
	protected PersonneDao		personneDao;
	protected RencontreDao		rencontreDao;

	@BeforeClass
	public static void init() throws SQLException {
		connection = (Connection) new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
		        .addScript("db/createBase.sql").addScript("db/insertData.sql").build().getConnection();
	}

	@Before
	public void setUp() throws Exception {
		pronosticDao = new PronosticsDaoImp(connection);
		personneDao = new PersonneDaoImp(connection);
		rencontreDao = new RencontreDaoImp(connection);
	}
	
/*	
	


	

	public void setScore(int id, Pronostic pronostic);




*/
}