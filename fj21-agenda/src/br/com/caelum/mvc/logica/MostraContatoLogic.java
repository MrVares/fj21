package br.com.caelum.mvc.logica;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.modelo.Contato;

public class MostraContatoLogic implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		
		//descobre se tem parametro
		String TemParam = req.getParameter("id");
		if (TemParam == null) {
			return "adiciona-contato.jsp";
		} else {
			long id = Long.parseLong(req.getParameter("id"));
			String nome = req.getParameter("nome");
			String email = req.getParameter("email");
			String endereco = req.getParameter("endereco");
			String dataEmTexto = req.getParameter("dataNascimento");

			System.out.println("depois de pegar os parametros");

			// fazendo a conversão da data

			// Montando um contato da agenda
			Contato contato = new Contato();
			contato.setId(id);
			contato.setName(nome);
			contato.setEmail(email);
			contato.setEndereco(endereco);

			req.setAttribute("contato", contato);
			req.setAttribute("dataNascimento", dataEmTexto);
			System.out.println("passou do set attribute");
			return "altera-contato.jsp";
		}
	}

}
