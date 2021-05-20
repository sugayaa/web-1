<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <body>
        <h2>Conversor Celsius para Fahrenheits usando JSP!</h2>
        <%
        String min = request.getParameter("minimum");
        String max = request.getParameter("maximum");
        String inc = request.getParameter("increment");

        int min_temp = (min == null) ? -100 : Integer.parseInt(min);
        int max_temp = (max == null) ? 100 : Integer.parseInt(max);
        int inc_temp = (inc == null) ? 5 : Integer.parseInt(inc);

        if (min_temp <= max_temp && inc_temp > 0) {
        %>

        <table>
            <tr>
                <th>Celsius</th>
                <th>Fahrenheits</th>
            </tr>
            <%
            for (int temp = min_temp; temp <= max_temp; temp += inc_temp)
            {
            %>

            <tr>
                <td>
                    <%=temp%>
                </td>
                <td>
                    <%=temp*1.80+32%>
                </td>
            </tr>

            <%
            }
            %>
            </tr>
        </table>
        <%-- erro --%>
        <% } else { %>
        Erro de parâmetros:<br>&nbsp;- incremento negativo ? <br>&nbsp;- máximo menor que mínimo ?<br>
        <% } %>
    </body>
</html>
