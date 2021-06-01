<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <title><fmt:message key="lista.bar"/></title>
   <script src="js/ajaxEspecialidade.js"></script>
</head>
<body>
	<%
	   String contextPath = request.getContextPath().replace("/", "");   
	%>
	<jsp:useBean id='bean' class="br.ufscar.dc.dsw.bean.buscaPorEspecialidadeBean" />
	
	<div align="center">
		<h1> <fmt:message key="lista.title"/> </h1>
		<h2> <a href="/<%=contextPath%>/login.jsp"><fmt:message key="lista.login"/></a>&nbsp;&nbsp;&nbsp;
			 <a href="/<%=contextPath%>/cadastro.jsp"><fmt:message key="lista.register"/></a>
		 </h2>
	</div>	
	<div align="center">
		<label><fmt:message key="lista.filter"/></label>
		<input type="text" id="especialidade" name="especialidade" style="width: 200px;" placeholder="<fmt:message key="lista.filterDescription"/>" onkeyUp="getEspecialidades()"/>
		<br><br>
		<div id = "profissionais">
			<table border="1" style="border: 1px solid black; width: 400px;">
				<caption><fmt:message key="lista.bar"/></caption>
			    <tr>
			       <th><fmt:message key="lista.name"/></th>
			       <th><fmt:message key="lista.email"/></th>
			       <th><fmt:message key="lista.specialty"/></th>
			       <th><fmt:message key="lista.curriculum"/></th>
			    </tr>
			    <c:forEach var="profissional" items="${bean.especialidades}">
			    	<tr>
			    	   <th>${profissional.nome}</th>
			    	   <th>${profissional.email}</th>
			    	   <th>${profissional.especialidade}</th>
			    	   <th><a href="/<%=contextPath%>/curriculo/${profissional.id}_curriculo" target="_blank"><fmt:message key="lista.download"/></a></th>
			    	</tr>
			    </c:forEach>
			</table>
		</div>
	</div>
</body>
</html>