package br.com.caelum.jdbc.teste;

import java.util.Calendar;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaAltera {

	public static void main(String[] args) {
		Contato contato = new Contato();
		contato.setId(1);
		contato.setName("Caelumlum");
		contato.setEmail("contato@caelum.com.br.nasa");
		contato.setEndereco("R. Vergueiro 3185 blog");
		contato.setDataNascimento(Calendar.getInstance());

		ContatoDao dao = new ContatoDao();
		dao.altera(contato);
		System.out.println("Alterado com sucesso!");
	}

}
