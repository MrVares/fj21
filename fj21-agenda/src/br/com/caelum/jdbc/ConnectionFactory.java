package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.com.caelum.jdbc.dao.DAOException;

public class ConnectionFactory {

	public Connection getConnection() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/fj21",
					"root", "050466");
		} catch (SQLException | ClassNotFoundException e) {
			throw new DAOException(e.getMessage(), e.getCause());
		}

	}

}
