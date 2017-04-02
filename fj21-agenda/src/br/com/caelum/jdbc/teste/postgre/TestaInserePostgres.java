package br.com.caelum.jdbc.teste.postgre;

import java.util.Calendar;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaInserePostgres {

	public static void main(String[] args) {
	Contato contato = new Contato();
		
		contato.setName("Fatec");
		contato.setEmail("fatec@edu.com.br");
		contato.setEndereco("R. Avenida Aguia de Haia 2000");
		contato.setDataNascimento(Calendar.getInstance());
		
       	//ContatoDao dao = new ContatoDao();
		//dao.adicionaNoPostgres(contato);
		
		//System.out.println("Gravado com sucesso!");
		

	}

}
