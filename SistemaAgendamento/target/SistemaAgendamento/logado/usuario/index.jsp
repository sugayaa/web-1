<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="br.ufscar.dc.dsw.dao.ProfissionalDAO" %>
<%@page import="java.util.List" %>
<%@page import="br.ufscar.dc.dsw.domain.Profissional" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <title><fmt:message key="login.bar"/></title>
</head>
<body>
	<%
	   String contextPath = request.getContextPath().replace("/", "");
	   ProfissionalDAO dao = new ProfissionalDAO();
	   List<Profissional> listaProfissionais =  dao.getAll();
	   request.setAttribute("listaProfissionais", listaProfissionais);
	%>
	<div align="center">
		<h1><fmt:message key="listaCP.bar"/></h1>
		<h2> <a href="/<%=contextPath%>/usuario/mostraConsulta"><fmt:message key="listaCP.title"/></a>&nbsp;&nbsp;&nbsp;
			 <a href="/<%=contextPath%>/logout.jsp"><fmt:message key="listaCP.logout"/></a>
		 </h2>
	</div>
	<div align="center">
		<table border="1">
			<caption><fmt:message key="lista.bar"/></caption>
		    <tr>
		       <th><fmt:message key="lista.name"/></th>
		       <th><fmt:message key="lista.email"/></th>
		       <th><fmt:message key="lista.specialty"/>e</th>
		       <th><fmt:message key="lista.curriculum"/></th>
		       <th>&nbsp;&nbsp;&nbsp;</th>
		    </tr>
		    <c:forEach var="profissional" items="${requestScope.listaProfissionais}">
		    	<tr>
		    	   <th>${profissional.nome}</th>
		    	   <th>${profissional.email}</th>
		    	   <th>${profissional.especialidade}</th>
		    	   <th><a href="/<%=contextPath%>/curriculo/${profissional.curriculo}" target="_blank"><fmt:message key="lista.download"/></a></th>
		    	   <th><a href="/<%=contextPath%>/usuario/marcarConsulta?id=${profissional.id}"><fmt:message key="listaCC.new"/></a> </th>
		    	</tr>
		    </c:forEach>
		</table>
	</div>
</body>
</html>