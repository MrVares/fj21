package br.com.caelum.jdbc.teste;

import java.text.SimpleDateFormat;
import java.util.List;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaPorNome {

	public static void main(String[] args) {
		Contato contato = new Contato();
		contato.setName("Caelum");

		ContatoDao dao = new ContatoDao();
		List<Contato> contatos = dao.porNome(contato);

		for (Contato contatoT : contatos) {
			System.out.println("Id: " + contatoT.getId());
			System.out.println("Nome: " + contatoT.getName());
			System.out.println("Email: " + contatoT.getEmail());
			System.out.println("Endereco: " + contatoT.getEndereco());
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
			String strDate = sdf.format(contatoT.getDataNascimento().getTime());
			System.out.println("Data de Nascimento " + strDate + "\n");
		}

	}

}
