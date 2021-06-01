<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>
		<%-- Para mudar a lingua da página, adicione 'lingua=en_US' após o site.jsp --%>
		<c:if test="${not empty param.lingua}">
  			<fmt:setLocale value="${param.lingua}" scope="session"/>
		</c:if>
		<fmt:message key="login.bar"/>
	</title>
</head>
<body>

	<a href="lista.jsp"><fmt:message key="login.profissionals"/></a>
	<h2 align="center">
		<fmt:message key="login.title"/>
	</h2>
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
				<label> <fmt:message key="login.email"/> </label>
				<input type="email" name="email" /><br><br>
				<label> <fmt:message key="login.password"/> </label>
				<input type="password" name="senha" /><br><br>
				<input type="submit" name="submitLogin" value="<fmt:message key="login.go"/>">
			</fieldset>
		</form>
	</div>
</body>
</html>