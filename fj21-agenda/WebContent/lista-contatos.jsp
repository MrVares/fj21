<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
	<!-- cria o DAO <jsp:useBean id="dao" class="br.com.caelum.jdbc.dao.ContatoDao" /> -->

	<c:import url="cabecalho.jsp"></c:import>
	<br>
	<h1 style="margin: auto; text-align: center;">Todos os contatos:</h1>
	<br>
	<table style="margin: auto;">
		<tr>
			<th>Nome</th>
			<th>Email</th>
			<th>Endereco</th>
			<th>Data de Nascimento</th>
		</tr>

		<!-- Percorre contatos montando as linhas da tabela -->
		<c:forEach var="contato" items="${contatos}" varStatus="id">
			<tr bgcolor="#${id.count % 2 == 0 ? 'e6e6e6' : 'ffffff' }">
				<td>${contato.name}</td>
				<td><c:choose>
						<c:when test="${not empty contato.email}">
							<a href="mailto:${contato.email}">${contato.email}</a>
						</c:when>
						<c:otherwise>E-mail não confirmado</c:otherwise>
					</c:choose></td>
				<td>${contato.endereco}</td>
				<td><fmt:formatDate value="${contato.dataNascimento.time}"
						pattern="dd/MM/yyyy" /></td>
				<td><a href="mvc?logica=RemoveContatoLogic&id=${contato.id}">Remover</a></td>
				<td><a
					href="mvc?logica=MostraContatoLogic&id=${contato.id}&nome=${contato.name}&email=${contato.email}&endereco=${contato.endereco}&dataNascimento=<fmt:formatDate value="${contato.dataNascimento.time}"
						pattern="dd/MM/yyyy" />">Alterar</a></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<c:import url="rodape.jsp"></c:import>
</body>
</html>