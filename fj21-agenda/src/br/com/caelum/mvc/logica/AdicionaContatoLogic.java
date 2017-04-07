package br.com.caelum.mvc.logica;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class AdicionaContatoLogic implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String endereco = req.getParameter("endereco");
		String dataEmTexto = req.getParameter("dataNascimento");
		Calendar dataNascimento = null;

		// fazendo a conversão da data

		try {
			System.out.println("Chegou aki!");
			Date data = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(data);
		} catch (ParseException e) {
			System.out.println("Problemas na convesão da data");
		}

		// Montando um contato da agenda
		Contato contato = new Contato();
		contato.setName(nome);
		contato.setEmail(email);
		contato.setEndereco(endereco);
		contato.setDataNascimento(dataNascimento);
		System.out.println("montou o objeto");

		// Salva o contato
		System.out.println("Pegando conexão da requisição");
		Connection connection = (Connection) req
				.getAttribute("connection");
		ContatoDao dao = new ContatoDao(connection);
		System.out.println("passou da instancia do contatoDAO");
		dao.adiciona(contato);
		System.out.println("Adicionado com sucesso!");
		return "mvc?logica=ListaContatosLogic";
		
	}

}
