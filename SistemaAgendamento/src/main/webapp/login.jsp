<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login</title>
</head>
<body>
	<a href="listaC.jsp">Listar Profissionais</a>
	<h2 align="center">Login</h2>
	<c:if test="${mensagem.existeErro}">
		<div id=erro>
		  <ul>
			<c:forEach var="erro" items="${mensagem.erros}">
				<li>${erro}</li>
			</c:forEach>
		  </ul>
		</div>
	</c:if>
	<div align="center">
		<form action="index.jsp" method="POST">
			<fieldset>
				<label>E-mail:</label>
				<input type="email" name="email" /><br><br>
				<label>Senha: </label>
				<input type="password" name="senha" /><br><br>
				<input type="submit" name="submitLogin" value="Entrar">
			</fieldset>
		</form>
	</div>
</body>
</html>