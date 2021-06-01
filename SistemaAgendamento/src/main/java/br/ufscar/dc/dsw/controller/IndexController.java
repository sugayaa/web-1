package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufscar.dc.dsw.dao.ClienteDAO;
import br.ufscar.dc.dsw.dao.ProfissionalDAO;
import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.domain.Profissional;
import br.ufscar.dc.dsw.utill.Erros;

@WebServlet(urlPatterns = {"/index.jsp", "/logout.jsp"})
public class IndexController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		doGet(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		Erros erros = new Erros();
		if(request.getParameter("submitLogin") != null) {
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			if(email == null || email.isEmpty()) {
				erros.add("Email não informado");
			}
			if(senha == null || senha.isEmpty()) {
				erros.add("Senha não informada");
			}
			if(!erros.isExisteErro()) {
				ClienteDAO dao = new ClienteDAO();
				Cliente cliente = dao.getByEmail(email);
				
				if(cliente != null) {
					if(cliente.getSenha().equals(senha)) {
						if(cliente.getPapel().equals("user")) {
							request.getSession().setAttribute("clienteLogado", cliente);
							response.sendRedirect("usuario/");
						}
						else {
							request.getSession().setAttribute("clienteLogado", cliente);
							response.sendRedirect("admin/");
						}
						return;
					}
					else {
						erros.add("Senha inválida");
					}
				}
				else {
					ProfissionalDAO dao2 = new ProfissionalDAO();
					Profissional profissional = dao2.getByEmail(email);
					
					if(profissional != null) {
						if(profissional.getSenha().equals(senha)) {
							if(profissional.getPapel().equals("profi")) {
								request.getSession().setAttribute("clienteLogado", profissional);
								response.sendRedirect("profissional/");
							}
							return;
						}
						else {
							erros.add("Senha inválida");
						}
					}
					else
						erros.add("Usuário não encontrado");
				}
			}
		}
		
		request.getSession().invalidate();
		request.setAttribute("mensagem", erros);
		
		request.getRequestDispatcher("/login.jsp").forward(request, response);
		
	}
}
