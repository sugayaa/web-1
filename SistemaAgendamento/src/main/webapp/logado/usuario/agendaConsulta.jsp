<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agendamento de Consulta</title>
</head>
<body>
	<h1 align="center">Escolha o dia e horário do agendamento com o profissional ${profissional.nome}</h1>
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
				<label>Data: </label>
				<input type="date" name="data"/><br><br>
				<label>Horário: </label>
				<select name="horario">
					<option value="1:00:00">1:00</option>
					<option value="2:00:00">2:00</option>
					<option value="3:00:00">3:00</option>
					<option value="4:00:00">4:00</option>
					<option value="5:00:00">5:00</option>
					<option value="6:00:00">6:00</option>
					<option value="7:00:00">7:00</option>
					<option value="8:00:00">8:00</option>
					<option value="9:00:00">9:00</option>
					<option value="10:00:00">10:00</option>
					<option value="11:00:00">11:00</option>
					<option value="12:00:00">12:00</option>
					<option value="13:00:00">13:00</option>
					<option value="14:00:00">14:00</option>
					<option value="15:00:00">15:00</option>
					<option value="16:00:00">16:00</option>
					<option value="17:00:00">17:00</option>
					<option value="18:00:00">18:00</option>
					<option value="19:00:00">19:00</option>
					<option value="20:00:00">20:00</option>
					<option value="21:00:00">21:00</option>
					<option value="22:00:00">22:00</option>
					<option value="23:00:00">23:00</option>
					<option value="0:00:00">00:00</option>
				</select><br><br>
				<input type="hidden" name="id" value="${profissional.id}"/>
				<input type="submit" name="agendar" value="Agendar"/>
			</fieldset>
		</form>
	</div>
</body>
</html>