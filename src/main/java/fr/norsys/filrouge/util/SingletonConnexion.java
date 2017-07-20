package fr.norsys.filrouge.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

public class SingletonConnexion {
	final static Logger logger = Logger.getLogger(SingletonConnexion.class);

	public static Connection getConnexion() {
		Context context = null;
		Connection connexion = null;

		try {
			context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:/comp/env/jdbc/tpFillRouge");
			connexion = dataSource.getConnection();

		} catch (NamingException | SQLException e) {
			logger.error("getting Connection Exception " + e.getMessage());
		}
		return connexion;
	}

}