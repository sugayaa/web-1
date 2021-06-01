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
	<h1 align="center">Lista de Clientes</h1><br>
	<h2 align="center"> 
		<a href="/<%=contextPath%>/admin/CRUD/cliente/cadastro">Cadastrar Novo Cliente</a>&nbsp;&nbsp;&nbsp; 
		<a href="/<%=contextPath%>/logout.jsp">Sair</a> 
	</h2><br>
	
	<div align="center">
		<table border="1">
			<caption>Lista Clientes</caption>
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>E-mail</th>
				<th>Senha</th>
				<th>CPF</th>
				<th>Telefone</th>
				<th>Sexo</th>
				<th>Data Nascimento</th>
				<th>Papel</th>
			</tr>
			<c:forEach var="cliente" items="${requestScope.listaClientes}">
				<tr>
					<th>${cliente.id}</th>
					<th>${cliente.nome}</th>
					<th>${cliente.email}</th>
					<th>${cliente.senha}</th>
					<th>${cliente.CPF}</th>
					<th>${cliente.telefone}</th>
					<th>${cliente.sexo}</th>
					<th>${cliente.dataNascimento}</th>
					<th>${cliente.papel}</th>
					<th> <a href="/<%=contextPath%>/admin/CRUD/cliente/edicao?id=${cliente.id}">Editar</a>&nbsp;&nbsp;&nbsp;
					     <a href="/<%=contextPath%>/admin/CRUD/cliente/remove?id=${cliente.id}"
					        onclick="return confirm('Tem certeza de que deseja excluir este item?');">Remover</a> </th>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>