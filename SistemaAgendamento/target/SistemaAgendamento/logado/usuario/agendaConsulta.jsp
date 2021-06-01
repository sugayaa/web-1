<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><fmt:message key="agendamento.bar"/></title>
</head>
<body>
	<h1 align="center"><fmt:message key="agendamento.tile"/> ${profissional.nome}</h1>
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
		<form action="agendarConsulta" method="POST">
			<fieldset>
				<label><fmt:message key="agendamento.date"/> </label>
				<input type="date" name="data"/><br><br>
				<label><fmt:message key="agendamento.hour"/> </label>
				<select name="horario">
					<option value="7:00:00"><fmt:message key="agendamento.7"/></option>
					<option value="8:00:00"><fmt:message key="agendamento.8"/></option>
					<option value="9:00:00"><fmt:message key="agendamento.9"/></option>
					<option value="10:00:00"><fmt:message key="agendamento.10"/></option>
					<option value="11:00:00"><fmt:message key="agendamento.11"/></option>
					<option value="12:00:00"><fmt:message key="agendamento.12"/></option>
					<option value="13:00:00"><fmt:message key="agendamento.13"/></option>
					<option value="14:00:00"><fmt:message key="agendamento.14"/></option>
					<option value="15:00:00"><fmt:message key="agendamento.15"/></option>
					<option value="16:00:00"><fmt:message key="agendamento.16"/></option>
					<option value="17:00:00"><fmt:message key="agendamento.17"/></option>
				</select><br><br>
				<input type="hidden" name="id" value="${profissional.id}"/>
				<input type="submit" name="agendar" value="<fmt:message key="agendamento.go"/>"/>
			</fieldset>
		</form>
	</div>
</body>
</html>