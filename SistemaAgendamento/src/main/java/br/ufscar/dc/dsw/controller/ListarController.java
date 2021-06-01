package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufscar.dc.dsw.dao.ProfissionalDAO;
import br.ufscar.dc.dsw.domain.Profissional;

@WebServlet(urlPatterns = "/listaC.jsp")
public class ListarController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		doGet(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
		if(request.getSession().getAttribute("clienteLogado") != null) {
			request.getRequestDispatcher("/logado/usuario/index.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("/lista.jsp").forward(request, response);
		}
	}
	
}
