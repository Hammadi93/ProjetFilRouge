package fr.norsys.filrouge.dao.equipe.impl;

import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import fr.norsys.filrouge.dao.EquipeDao;
import fr.norsys.filrouge.dao.PouleDao;
import fr.norsys.filrouge.dao.imp.EquipeDaoImp;
import fr.norsys.filrouge.dao.imp.PouleDaoImp;



public abstract class AEquipeTest {

	private static Connection	connection;
	protected EquipeDao			equipeDao;
	protected PouleDao pouleDao;

	@BeforeClass
	public static void init() throws SQLException {
		connection = (Connection) new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
		        .addScript("db/createBase.sql").addScript("db/insertData.sql").build().getConnection();
	}

	@Before
	public void setUp() throws Exception {
		equipeDao = new EquipeDaoImp(connection);
		pouleDao=new PouleDaoImp(connection);
	}
	


}
