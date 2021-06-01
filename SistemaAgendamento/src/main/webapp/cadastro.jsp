<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>
			<%-- Para mudar a lingua da página, adicione '?lingua=en_US' após o site.jsp --%>
		<c:if test="${not empty param.lingua}">
  			<fmt:setLocale value="${param.lingua}" scope="session"/>
		</c:if>
		<fmt:message key="cadastro.bar"/>
	</title>
	<script type="text/javascript" src="js/alteraForms.js"></script>
</head>
<body>
	<div align="center" id="cadastro">
		<p><fmt:message key="cadastro.how"/> </p>
		<select name="tipo" id="tipo" onchange="altera()">
			<option value="1"><fmt:message key="cadastro.professional"/></option>
			<option value="2"><fmt:message key="cadastro.client"/></option>
		</select><br>
		<div id="formCadastro">
			<h1 ><fmt:message key="cadastro.register"/></h1>
			<form action="cadastroProfissional" method="POST" enctype="multipart/form-data">
				<fieldset>
					<input type="hidden" name="papel" value="profi"/>
					<label><fmt:message key="cadastro.name"/></label>&nbsp;&nbsp;
					<input type="text" name="nome" /><br><br>
					<label><fmt:message key="cadastro.email"/></label>&nbsp;&nbsp;
					<input type="text" name="email" /><br><br>
					<label><fmt:message key="cadastro.pass"/></label>&nbsp;&nbsp;
					<input type="password" name="senha" /><br><br>
					<label><fmt:message key="cadastro.CPF"/></label>&nbsp;&nbsp;
					<input type="text" name="CPF" /><br><br>
					<label><fmt:message key="cadastro.specialty"/></label>&nbsp;&nbsp;
					<input type="text" name="especialidade" /><br><br>
					<label><fmt:message key="cadastro.curriculum"/></label>&nbsp;&nbsp;
					<input type="file" name="curriculo" accept=".pdf"/><br><br><br><br><br>
					<input type="submit" name="cadastrar" value="<fmt:message key="cadastro.go"/>"/>	
	
				</fieldset>
			</form>
		</div>
	</div>
</body>
</html>