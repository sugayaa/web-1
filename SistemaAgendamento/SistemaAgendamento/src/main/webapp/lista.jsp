<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <title>Lista de Profissionais</title>
</head>
<body>
	<%
	   String contextPath = request.getContextPath().replace("/", "");
	%>
	<div align="center">
		<h1>Profissionais Liberais</h1>
		<h2> <a href="/<%=contextPath%>/login.jsp">LOGIN</a>&nbsp;&nbsp;&nbsp;
			 <a href="/<%=contextPath%>/cadastro.jsp">Realizar Cadastro</a>
		 </h2>
	</div>
	<div align="center">
		<table border="1">
			<caption>Lista de profissionais</caption>
		    <tr>
		       <th>ID</th>
		       <th>Nome</th>
		       <th>Email</th>
		       <th>Especialidade</th>
		       <th>Currículo</th>
		    </tr>
		    <c:forEach var="profissional" items="${requestScope.listaProfissionais}">
		    	<tr>
		    	   <th>${profissional.id}</th>
		    	   <th>${profissional.nome}</th>
		    	   <th>${profissional.email}</th>
		    	   <th>${profissional.especialidade}</th>
		    	   <th>${profissional.curriculo}</th>
		    	</tr>
		    </c:forEach>
		</table>
	</div>
</body>
</html>