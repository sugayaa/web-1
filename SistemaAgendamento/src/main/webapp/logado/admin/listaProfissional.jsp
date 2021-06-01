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
	<h1 align="center"><fmt:message key="index.bar"/></h1><br>
	<h2 align="center"> 
		<a href="/<%=contextPath%>/admin/CRUD/profissional/cadastro"><fmt:message key="admin.newProf"/></a>&nbsp;&nbsp;&nbsp; 
		<a href="/<%=contextPath%>/logout.jsp"><fmt:message key="listaCP.logout"/></a> 
	</h2><br>
	
	<div align="center">
		<table border="1">
			<caption><fmt:message key="lista.bar"/></caption>
			<tr>
				<th>ID</th>
				<th><fmt:message key="lista.name"/></th>
				<th><fmt:message key="lista.email"/></th>
				<th><fmt:message key="login.password"/></th>
				<th><fmt:message key="cadastro.CPF"/></th>
				<th><fmt:message key="lista.specialty"/></th>
				<th><fmt:message key="lista.curriculum"/></th>
				<th><fmt:message key="admin.function"/></th>
			</tr>
			<c:forEach var="profissional" items="${requestScope.listaProfissionais}">
				<tr>
					<th>${profissional.id}</th>
					<th>${profissional.nome}</th>
					<th>${profissional.email}</th>
					<th>${profissional.senha}</th>
					<th>${profissional.CPF}</th>
					<th>${profissional.especialidade}</th>
					<th><a href="/<%=contextPath%>/curriculo/${profissional.id}_curriculo" target="_blank"><fmt:message key="lista.download"/></a></th>
					<th>${profissional.papel}</th>
					<th> <a href="/<%=contextPath%>/admin/CRUD/profissional/edicao?id=${profissional.id}"><fmt:message key="admin.edit"/></a>&nbsp;&nbsp;&nbsp;
					    <a href="/<%=contextPath%>/admin/CRUD/profissional/remove?id=${profissional.id}"
					      onclick="return confirm('<fmt:message key="admin.confirm"/>');"><fmt:message key="admin.remove"/></a> </th>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>