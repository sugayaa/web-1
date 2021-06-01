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
	<h1 align="center"><fmt:message key="profissional.edit"/></h1>
	<div align="center">
		<form action="atualiza" method="POST" enctype="multipart/form-data">
			<fieldset>
				<input type="hidden" name="id" value="${profissional.id}"/>
				<label><fmt:message key="cadastro.nome"/></label>&nbsp;&nbsp;
				<input type="text" name="nome" value="${profissional.nome}"/><br><br>
				<label><fmt:message key="cadastro.email"/></label>&nbsp;&nbsp;
				<input type="email" name="email" value="${profissional.email}"/><br><br>
				<label><fmt:message key="cadastro.pass"/></label>&nbsp;&nbsp;
				<input type="text" name="senha" value="${profissional.senha}"/><br><br>
				<label>CPF:</label>&nbsp;&nbsp;
				<input type="text" name="CPF" value="${profissional.CPF}"/><br><br>
				<label><fmt:message key="cadastro.specialty"/></label>&nbsp;&nbsp;
				<input type="text" name="especialidade" value="${profissional.especialidade}"/><br><br>
				<label><fmt:message key="cadastro.curriculum"/></label>&nbsp;&nbsp;
				<input type="file" name="curriculo" accept=".pdf"/><br><br><br><br><br>
				<input type="submit" name="editar" value="<fmt:message key="cadastro.save"/>"/>
				
				
			</fieldset>
		</form>
	
	</div>
	
</body>
</html>