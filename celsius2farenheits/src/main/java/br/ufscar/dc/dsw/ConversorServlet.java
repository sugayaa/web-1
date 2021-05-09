package br.ufscar.dc.dsw;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/ConversorServlet"})
public class ConversorServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private class Params { private int minimum, maximum, increment; }

    protected void generateTable(PrintWriter destination, Params p)
    {
        destination.println("<table>");
        destination.println("<tr>");
        destination.println("<th>Celsius</th>");
        destination.println("<th>Farenheits</th>");
        destination.println("</tr>");
        for (int temp = p.minimum; temp <= p.maximum; temp += p.increment)
        {
            destination.println("<tr>");
            destination.println("<td>" + temp + "</td>");
            destination.println("<td>" + temp * 1.8 + 32 + "</td>");
            destination.println("</tr>");
        }
        destination.println("</table>");
    }

    protected boolean checkParameters(Params p)
    {
        int minimum = p.minimum, maximum = p.maximum, increment = p.increment;

        if ( minimum != 0 || maximum != 0 || increment != 0 )
        {
            if (minimum <= maximum && increment > 0)
            {
                return true;
            }
        }
        return false;
    }

    protected void showError(PrintWriter destination)
    {
        destination.println("<b>Internal Server Error</b><br>");
        destination.println("Are all values 0?<br>");
        destination.println("Is maximum value larger than the minimum value?<br>");
        destination.println("Is increment larger than 0?<br>");
    }

    protected void getMinimum(HttpServletRequest request, Params p){
        try {
            p.minimum = Integer.parseInt(request.getParameter("minimum"));
        } catch (Exception e) {
            p.minimum = -100;
        }
    }

    protected void getMaximum(HttpServletRequest request, Params p){
        try {
            p.maximum = Integer.parseInt(request.getParameter("maximum"));
        } catch (Exception e){
            p.maximum = 100;
        }
    }

    protected void getIncrement(HttpServletRequest request, Params p){
        try {
            p.increment = Integer.parseInt(request.getParameter("increment"));
        } catch (Exception e){
            p.increment = 5;
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response, String metodo)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>C to F converter</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Celsius to Farenheits conversion table</h2>");

            Params params = new Params();

            getMinimum(request, params);
            getMaximum(request, params);
            getIncrement(request, params);

            if ( checkParameters(params) )
            {
                generateTable(out, params);
            }
            else
            {
                showError(out);
            }
            
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response, "POST");
    }
}
