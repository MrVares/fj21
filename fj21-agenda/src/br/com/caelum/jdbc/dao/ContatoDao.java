package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.ConnectionPostgres;
import br.com.caelum.jdbc.modelo.Contato;

public class ContatoDao {
	private Connection connection;

	// private Connection conPostgres;

	public ContatoDao() {
		this.connection = new ConnectionFactory().getConnection();
		// this.conPostgres = new ConnectionPostgres().getConnection();
	}

	public void adiciona(Contato contato) {
		String sql = "insert into contatos "
				+ "(nome,email,endereco,dataNascimento) " + "values (?,?,?,?)";

		PreparedStatement stmt;
		try {
			stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, contato.getName());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento()
					.getTimeInMillis()));

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new DAOException(e.getMessage(), e.getCause());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new DAOException(e.getMessage(), e.getCause());
			}
		}

	}

	public List<Contato> getLista() {
		try {
			List<Contato> contatos = new ArrayList<Contato>();
			PreparedStatement stmt = this.connection
					.prepareStatement("SELECT * FROM contatos");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setName(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));

				// Create a Calendar and set the "Time" with a "Date" of
				// respective bank.
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);

				contatos.add(contato);
			}
			rs.close();
			stmt.close();
			connection.close();
			return contatos;
		} catch (SQLException e) {
			throw new DAOException(e.getMessage(), e.getCause());
		}

	}

	public List<Contato> porNome(Contato c) {
		try {
			List<Contato> contatos = new ArrayList<Contato>();
			PreparedStatement stmt = this.connection
					.prepareStatement("SELECT * FROM contatos WHERE nome LIKE '"
							+ c.getName() + "%'");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setName(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));

				// Create a Calendar and set the "Time" with a "Date" of
				// respective bank.
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);

				contatos.add(contato);
			}
			rs.close();
			stmt.close();
			connection.close();
			return contatos;
		} catch (SQLException e) {
			throw new DAOException(e.getMessage(), e.getCause());
		}

	}

	public Contato porId(Contato c) {
		try {
			Contato contato = new Contato();
			PreparedStatement stmt = this.connection
					.prepareStatement("SELECT * FROM contatos WHERE id = ?");
			stmt.setLong(1, c.getId());
			ResultSet rs = stmt.executeQuery();
			if (rs.first()) {
				contato.setId(rs.getLong("id"));
				contato.setName(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));

				// Create a Calendar and set the "Time" with a "Date" of
				// respective bank.
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);
			}

			rs.close();
			stmt.close();

			return contato;
		} catch (SQLException e) {
			throw new DAOException(e.getMessage(), e.getCause());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {

				throw new DAOException(e.getMessage(), e.getCause());
			}
		}

	}

	public void remove(Contato contato) {
		try {
			PreparedStatement stmt = this.connection.prepareStatement("delete "
					+ "from contatos where id=?");
			stmt.setLong(1, contato.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(e.getMessage(), e.getCause());
		} finally {
			try {
				this.connection.close();
			} catch (SQLException e) {
				throw new DAOException(e.getMessage(), e.getCause());
			}
		}
	}

	public void altera(Contato contato) {
		String sql = "update contatos set nome=?, email=?, endereco=?, dataNascimento=? where id =?";
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, contato.getName());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento()
					.getTimeInMillis()));
			stmt.setLong(5, contato.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(e.getMessage(), e.getCause());
		} finally {
			try {
				this.connection.close();
			} catch (SQLException e) {
				throw new DAOException(e.getMessage(), e.getCause());
			}
		}
	}

	/**
	 * Methods of Postgres down here! The postgres have same specific things as:
	 * 1- You cannot name columns with UpperCase 2- Date, time and timestamp in
	 * postgres just accept with quotation marks
	 * Attention! postgres was commented in order to doesn't need start postgres but is working well.
	 * **/

	/**
	 * public void adicionaNoPostgres(Contato contato) {
	 * 
	 * Date data = new Date(contato.getDataNascimento().getTimeInMillis());
	 * String strData = data.toString(); System.out.println(strData); String sql
	 * = "insert into contatos " + "(nome,email,endereco,\"dataNascimento\") " +
	 * "values (?,?,?,'" + data + "')";
	 * 
	 * PreparedStatement stmt; try {
	 * 
	 * stmt = conPostgres.prepareStatement(sql); stmt.setString(1,
	 * contato.getName()); stmt.setString(2, contato.getEmail());
	 * stmt.setString(3, contato.getEndereco());
	 * 
	 * stmt.execute(); stmt.close();
	 * 
	 * } catch (SQLException e) { throw new DAOException(e.getMessage(),
	 * e.getCause()); } finally { try { conPostgres.close(); } catch
	 * (SQLException e) { throw new DAOException(e.getMessage(), e.getCause());
	 * } }
	 * 
	 * }
	 **/

}
