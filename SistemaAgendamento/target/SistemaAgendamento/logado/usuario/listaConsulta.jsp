<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <title>Consultas Marcadas</title>
</head>
<body>
	<%
	   String contextPath = request.getContextPath().replace("/", "");
	   
	%>
	<div align="center">
		<h1>Lista de Consultas Marcadas</h1>
		<h2> <a href="/<%=contextPath%>/usuario">Marcar Nova Consulta</a>&nbsp;&nbsp;&nbsp;
			 <a href="/<%=contextPath%>/logout.jsp">Sair</a>
		 </h2>
	</div>
	<div align="center">
		<table border="1">
			<caption>Lista de consultas</caption>
		    <tr>
		       <th>Nome do Profissional</th>
		       <th>Data</th>
		       <th>Horário</th>
		       <th>Link para Reunião</th>
		    </tr>
		    <c:forEach var="consulta" items="${requestScope.listaConsulta}">
		    	<tr>
		    	   <th>${consulta.nome}</th>
		    	   <th>${consulta.data}</th>
		    	   <th>${consulta.horario}</th>
		    	   <th><a href="${consulta.url}" target="_blank">Meet</a></th>
		    	</tr>
		    </c:forEach>
		</table>
	</div>
</body>
</html>