<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <title>Lista de Profissionais</title>
   <script src="js/ajaxEspecialidade.js"></script>
</head>
<body>
	<%
	   String contextPath = request.getContextPath().replace("/", "");   
	%>
	<jsp:useBean id='bean' class="br.ufscar.dc.dsw.bean.buscaPorEspecialidadeBean" />
	
	<div align="center">
		<h1>Profissionais Liberais</h1>
		<h2> <a href="/<%=contextPath%>/login.jsp">LOGIN</a>&nbsp;&nbsp;&nbsp;
			 <a href="/<%=contextPath%>/cadastro.jsp">Realizar Cadastro</a>
		 </h2>
	</div>	
	<div align="center">
		<labe>Filtrar por especialidade:</labe>
		<input type="text" id="especialidade" name="especialidade" style="width: 200px;" placeholder="Digite a especialidade desejada" onkeyUp="getEspecialidades()"/>
		<br><br>
		<div id = "profissionais">
			<table border="1" style="border: 1px solid black; width: 400px;">
				<caption>Lista de profissionais</caption>
			    <tr>
			       <th>Nome</th>
			       <th>Email</th>
			       <th>Especialidade</th>
			       <th>Currículo</th>
			    </tr>
			    <c:forEach var="profissional" items="${bean.especialidades}">
			    	<tr>
			    	   <th>${profissional.nome}</th>
			    	   <th>${profissional.email}</th>
			    	   <th>${profissional.especialidade}</th>
			    	   <th><a href="/<%=contextPath%>/curriculo/${profissional.id}_curriculo" target="_blank">Currículo</a></th>
			    	</tr>
			    </c:forEach>
			</table>
		</div>
	</div>
</body>
</html>