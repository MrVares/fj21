package br.com.caelum.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.mvc.logica.Logica;

@WebServlet("/mvc")
public class ControllerServlet extends HttpServlet {
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Chegou no mvc");
		String parametro = request.getParameter("logica");
		System.out.println(parametro);
		String nomeDaClasse = "br.com.caelum.mvc.logica." + parametro;
		try{
			Class classe = Class.forName(nomeDaClasse);
			Logica logica = (Logica) classe.newInstance();
			String pagina = logica.executa(request, response);
			System.out.println("antes de dispachar");
			request.getRequestDispatcher(pagina).forward(request, response);
			System.out.println("depois de dispachar");
		}catch(Exception e){
			throw new ServletException(
					"A l�gica de neg�cios causou uma exce��o", e);
		}
	}
}
