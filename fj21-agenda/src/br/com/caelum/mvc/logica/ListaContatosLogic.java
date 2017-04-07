package br.com.caelum.mvc.logica;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class ListaContatosLogic implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		System.out.println("antes do connection");
		Connection connection = (Connection) req.getAttribute("connection");
		if(connection == null){
			System.out.println("Connection é null");
		}else{
			System.out.println("Connection não é null");
		}
		ContatoDao dao = new ContatoDao(connection);
		System.out.println("instanciou o connection");
		List<Contato> contatos = dao.getLista();
		System.out.println("pegou a lista do banco");
		
		req.setAttribute("contatos", contatos);
		return "/WEB-INF/jsp/lista-contatos.jsp";
	}

}
