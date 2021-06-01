<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title><fmt:message key="index.bar"/></title>
</head>
<body>
	<%String contextPath = request.getContextPath().replace("/", ""); %>
	<h1 align="center"><fmt:message key="admin.clientList"/></h1><br>
	<h2 align="center"> 
		<a href="/<%=contextPath%>/admin/CRUD/cliente/cadastro"><fmt:message key="admin.newClient"/></a>&nbsp;&nbsp;&nbsp; 
		<a href="/<%=contextPath%>/logout.jsp"><fmt:message key="listaCP.logout"/></a> 
	</h2><br>
	
	<div align="center">
		<table border="1">
			<caption><fmt:message key="admin.clientList"/></caption>
			<tr>
				<th>ID</th>
				<th><fmt:message key="cliente.name"/></th>
				<th><fmt:message key="lista.email"/></th>
				<th><fmt:message key="login.password"/></th>
				<th><fmt:message key="cadastro.CPF"/></th>
				<th><fmt:message key="cliente.tel"/></th>
				<th><fmt:message key="cliente.sex"/></th>
				<th><fmt:message key="cliente.date"/></th>
				<th><fmt:message key="admin.function"/></th>
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
					<th> <a href="/<%=contextPath%>/admin/CRUD/cliente/edicao?id=${cliente.id}"><fmt:message key="admin.edit"/></a>&nbsp;&nbsp;&nbsp;
					     <a href="/<%=contextPath%>/admin/CRUD/cliente/remove?id=${cliente.id}"
					        onclick="return confirm('<fmt:message key="admin.confirm"/>');"><fmt:message key="admin.remove"/></a> </th>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>