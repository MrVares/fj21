<%@page import="java.text.SimpleDateFormat"%>
<%@	page
	import="java.util.List, br.com.caelum.jdbc.dao.ContatoDao, br.com.caelum.jdbc.modelo.Contato "%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Tem coisa errada nessa pagina!</h1>
	<table>
		<tr>
			<th>Nome</th>
			<th>Email</th>
			<th>Endereco</th>
			<th>Data de Nascimento</th>
		</tr>
		<%
			ContatoDao dao = new ContatoDao();
			List<Contato> contatos = dao.getLista();
			for (Contato c : contatos) {
		%>
		<tr>
			<td><%=c.getName()%></td>
			<td><%=c.getEmail()%></td>
			<td><%=c.getEndereco()%></td>
			<%
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					String strData = sdf.format(c.getDataNascimento().getTime());
			%>
			<td><%=strData%></td>
		</tr>
		<%}%>
	</table>
</body>
</html>