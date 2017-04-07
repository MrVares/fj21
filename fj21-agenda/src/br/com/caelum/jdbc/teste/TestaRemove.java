package br.com.caelum.jdbc.teste;

import java.sql.Connection;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaRemove {

	public static void main(String[] args) {
		Contato contato = new Contato();
		contato.setId(1);

		Connection connection = new ConnectionFactory().getConnection();
		ContatoDao dao = new ContatoDao(connection);
		dao.remove(contato);
		
		System.out.println("Contato removido!");

	}

}
