<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="br.ufscar.dc.dsw.dao.ProfissionalDAO" %>
<%@page import="java.util.List" %>
<%@page import="br.ufscar.dc.dsw.domain.Profissional" %>


<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <title>Lista de Profissionais</title>
</head>
<body>
	<%
	   String contextPath = request.getContextPath().replace("/", "");
	   ProfissionalDAO dao = new ProfissionalDAO();
	   List<Profissional> listaProfissionais =  dao.getAll();
	   request.setAttribute("listaProfissionais", listaProfissionais);
	%>
	<div align="center">
		<h1>Profissionais Liberais</h1>
		<h2> <a href="/<%=contextPath%>/usuario/mostraConsulta">Consultas Marcadas</a>&nbsp;&nbsp;&nbsp;
			 <a href="/<%=contextPath%>/logout.jsp">Sair</a>
		 </h2>
	</div>
	<div align="center">
		<table border="1">
			<caption>Lista de profissionais</caption>
		    <tr>
		       <th>Nome</th>
		       <th>Email</th>
		       <th>Especialidade</th>
		       <th>Currículo</th>
		       <th>&nbsp;&nbsp;&nbsp;</th>
		    </tr>
		    <c:forEach var="profissional" items="${requestScope.listaProfissionais}">
		    	<tr>
		    	   <th>${profissional.nome}</th>
		    	   <th>${profissional.email}</th>
		    	   <th>${profissional.especialidade}</th>
		    	   <th><a href="/<%=contextPath%>/curriculo/${profissional.curriculo}" target="_blank">Currículo</a></th>
		    	   <th><a href="/<%=contextPath%>/usuario/marcarConsulta?id=${profissional.id}">Marcar Consulta</a> </th>
		    	</tr>
		    </c:forEach>
		</table>
	</div>
</body>
</html>