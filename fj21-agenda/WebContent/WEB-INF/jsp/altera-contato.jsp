<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="caelum"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/jquery-ui.css"/>">
<script type="text/javascript" src="<c:url value="/js/jquery.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/jquery-ui.js"/>"></script>
</head>
<body>
	<c:import url="cabecalho.jsp" />
	<h1>Altera Contatos</h1>
	<hr />
	<form action="mvc">
		Nome: <input type="text" name="nome" value="${contato.name}" /><br />
		E-mail: <input type="text" name="email" value="${contato.email}" /><br />
		Endereço: <input type="text" name="endereco"
			value="${contato.endereco}" /><br /> Data Nascimento:
		<caelum:campoData id="dataNascimento"
			value="${dataNascimento}"/>
			<input type="hidden" name="logica" value="AlteraContatoLogic"/>
			<input type="hidden" name="id" value="${contato.id}"/>
		<br /> <input type="submit" value="Alterar" />
	</form>
	<c:import url="rodape.jsp" />
</body>
</html>