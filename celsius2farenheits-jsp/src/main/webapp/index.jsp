<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Celsius para Farenheits usando JSP!</title>
    <meta charset="UTF-8">
</head>

<body>
    <form name="Celsius para Farenheits" action="conversor.jsp" method="POST">
        <fieldset>
            <legend>Formulário de Envio</legend>
            Valor mínimo: <input type="text" name="minimum" /> <br />
            Valor máximo: <input type="text" name="maximum" /> <br />
            Incremento: <input type="text" name="increment" /> <br />
            <input type="submit" name="enviar" value="Solicitar Conversão" />
        </fieldset>
    </form>
</body>

</html>

