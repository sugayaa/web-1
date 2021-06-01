<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Espaço ADMIN</title>
</head>
<body>
	<%String contextPath = request.getContextPath().replace("/", ""); %>
	<h1 align="center">Lista de Profissionais</h1><br>
	<h2 align="center"> 
		<a href="/<%=contextPath%>/admin/CRUD/profissional/cadastro">Cadastrar Novo Profissional</a>&nbsp;&nbsp;&nbsp; 
		<a href="/<%=contextPath%>/logout.jsp">Sair</a> 
	</h2><br>
	
	<div align="center">
		<table border="1">
			<caption>Lista Profissionais</caption>
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>E-mail</th>
				<th>Senha</th>
				<th>CPF</th>
				<th>Especialidade</th>
				<th>Currículo</th>
				<th>Papel</th>
			</tr>
			<c:forEach var="profissional" items="${requestScope.listaProfissionais}">
				<tr>
					<th>${profissional.id}</th>
					<th>${profissional.nome}</th>
					<th>${profissional.email}</th>
					<th>${profissional.senha}</th>
					<th>${profissional.CPF}</th>
					<th>${profissional.especialidade}</th>
					<th><a href="/<%=contextPath%>/curriculo/${profissional.id}_curriculo" target="_blank">Currículo</a></th>
					<th>${profissional.papel}</th>
					<th> <a href="/<%=contextPath%>/admin/CRUD/profissional/edicao?id=${profissional.id}">Editar</a>&nbsp;&nbsp;&nbsp;
					    <a href="/<%=contextPath%>/admin/CRUD/profissional/remove?id=${profissional.id}"
					      onclick="return confirm('Tem certeza de que deseja excluir este item?');">Remover</a> </th>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>