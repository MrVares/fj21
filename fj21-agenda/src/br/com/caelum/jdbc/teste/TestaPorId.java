package br.com.caelum.jdbc.teste;

import java.text.SimpleDateFormat;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaPorId {

	public static void main(String[] args) {
		Contato contato = new Contato();
		contato.setId(1);

		ContatoDao dao = new ContatoDao();
		Contato contatoR = dao.porId(contato);

		System.out.println("Id: " + contatoR.getId());
		System.out.println("Nome: " + contatoR.getName());
		System.out.println("Email: " + contatoR.getEmail());
		System.out.println("Endereco: " + contatoR.getEndereco());
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
		String strDate = sdf.format(contatoR.getDataNascimento().getTime());
		System.out.println("Data de Nascimento " + strDate + "\n");
	}

}
