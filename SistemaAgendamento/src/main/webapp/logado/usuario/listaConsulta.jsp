<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <title><fmt:message key="listaCP.title"/></title>
</head>
<body>
	<%
	   String contextPath = request.getContextPath().replace("/", "");
	   
	%>
	<div align="center">
		<h1><fmt:message key="listaCP.title"/></h1>
		<h2> <a href="/<%=contextPath%>/usuario"><fmt:message key="listaCC.new"/></a>&nbsp;&nbsp;&nbsp;
			 <a href="/<%=contextPath%>/logout.jsp"><fmt:message key="listaCP.logout"/></a>
		 </h2>
	</div>
	<div align="center">
		<table border="1">
			<caption><fmt:message key="listaCP.list"/></caption>
		    <tr>
		       <th><fmt:message key="listaCC.profName"/></th>
		       <th><fmt:message key="listaCP.date"/></th>
		       <th><fmt:message key="listaCP.hour"/></th>
		       <th><fmt:message key="listaCP.link"/></th>
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