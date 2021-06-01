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
	<h1 align="center"><fmt:message key="profissional.register"/></h1>
	<div align="center">
		<form action="insere" method="POST" enctype="multipart/form-data">
			<fieldset>
				<input type="hidden" name="papel" value="profi"/>
				<label><fmt:message key="cadastro.nome"/></label>&nbsp;&nbsp;
				<input type="text" name="nome" /><br><br>
				<label><fmt:message key="cadastro.email"/></label>&nbsp;&nbsp;
				<input type="email" name="email" /><br><br>
				<label><fmt:message key="cadastro.pass"/></label>&nbsp;&nbsp;
				<input type="password" name="senha" /><br><br>
				<label>CPF:</label>&nbsp;&nbsp;
				<input type="text" name="CPF" /><br><br>
				<label><fmt:message key="cadastro.specialty"/></label>&nbsp;&nbsp;
				<input type="text" name="especialidade" /><br><br>
				<label><fmt:message key="cadastro.curriculum"/></label>&nbsp;&nbsp;
				<input type="file" name="curriculo" accept=".pdf"/><br><br><br><br><br>
				<input type="submit" name="cadastrar" value="<fmt:message key="cadastro.go"/>"/>	

			</fieldset>
		</form>
	
	</div>
	
</body>
</html>