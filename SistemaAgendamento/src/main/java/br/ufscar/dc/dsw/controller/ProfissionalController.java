package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufscar.dc.dsw.dao.ConsultaDAO;
import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.domain.Consulta;
import br.ufscar.dc.dsw.domain.Profissional;

@WebServlet(urlPatterns = "/profissional/*")
public class ProfissionalController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		doGet(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
		Profissional profissional = (Profissional) request.getSession().getAttribute("clienteLogado");
		ConsultaDAO dao = new ConsultaDAO();
		List<Consulta> listaConsulta = dao.getAllByIdProfissional(profissional.getId());
		request.setAttribute("listaConsulta", listaConsulta);
		request.getRequestDispatcher("/logado/profissional/listaConsulta.jsp").forward(request, response);
	}
}
