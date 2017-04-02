package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.com.caelum.jdbc.dao.DAOException;

public class ConnectionPostgres {
	
	/**public Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/fj21",
					"postgres", "050466");
		} catch (SQLException e) {
			throw new DAOException(e.getMessage(), e.getCause());
		}

	}**/

}
