package fr.norsys.filrouge.dao.rencontre.impl;

import java.sql.Connection;
import java.sql.SQLException;


import org.junit.Before;
import org.junit.BeforeClass;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import fr.norsys.filrouge.dao.CompetitionDao;
import fr.norsys.filrouge.dao.EquipeDao;
import fr.norsys.filrouge.dao.PouleDao;
import fr.norsys.filrouge.dao.RencontreDao;
import fr.norsys.filrouge.dao.imp.CompetitionDaoImp;
import fr.norsys.filrouge.dao.imp.EquipeDaoImp;
import fr.norsys.filrouge.dao.imp.PouleDaoImp;
import fr.norsys.filrouge.dao.imp.RencontreDaoImp;


public abstract class ARencontreTest {
	private static Connection	connection;
	protected RencontreDao		rencontreDao;

	protected PouleDao	pouleDao;
	protected EquipeDao equipeDao;
	protected CompetitionDao competitionDao;

	@BeforeClass
	public static void init() throws SQLException {
		connection = (Connection) new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
		        .addScript("db/createBase.sql").addScript("db/insertData.sql").build().getConnection();
	}

	@Before
	public void setUp() throws Exception {
		rencontreDao = new RencontreDaoImp(connection);
	      pouleDao=new PouleDaoImp(connection);
	      equipeDao=new EquipeDaoImp(connection);
	      competitionDao=new CompetitionDaoImp(connection);
	}


}
