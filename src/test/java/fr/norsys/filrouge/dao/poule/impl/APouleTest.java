package fr.norsys.filrouge.dao.poule.impl;

import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import fr.norsys.filrouge.dao.PouleDao;
import fr.norsys.filrouge.dao.imp.PouleDaoImp;




public abstract class APouleTest {
	private static Connection	connection;
	protected PouleDao			pouleDao;

	@BeforeClass
	public static void init() throws SQLException {
		connection = (Connection) new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
		        .addScript("db/createBase.sql").addScript("db/insertData.sql").build().getConnection();
	}

	@Before
	public void setUp() throws Exception {
		pouleDao = new PouleDaoImp(connection);
	}
	

}