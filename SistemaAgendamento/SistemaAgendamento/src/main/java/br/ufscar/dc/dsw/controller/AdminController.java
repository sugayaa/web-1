package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletSecurityElement;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufscar.dc.dsw.dao.ClienteDAO;
import br.ufscar.dc.dsw.dao.ProfissionalDAO;
import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.domain.Profissional;

@WebServlet(urlPatterns = {"/admin/*"})
public class AdminController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		doGet(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
		String action = request.getPathInfo();
		System.out.println(action);
		if(action == null)
			action = "";
		
		try {
			switch(action) {
				case "/CRUD/cliente/cadastro": apresentaFormCadastroCliente(request, response); break;
				case "/CRUD/cliente/insere": insereCliente(request, response); break;
				case "/CRUD/profissional/cadastro": apresentaFormCadastroProfissional(request, response); break;
				case "/CRUD/profissional/insere": insereProfissional(request,response); break;
				case "/CRUD/cliente/edicao": apresentaFormEdicaoCliente(request, response); break;
				case "/CRUD/profissional/edicao": apresentaFormEdicaoProfissional(request, response); break; 
				case "/CRUD/cliente/atualiza": atualizaCliente(request, response); break;
				case "/CRUD/profissional/atualiza": atualizaProfissional(request, response); break;
				case "/CRUD/cliente/listaCliente": listaCliente(request, response); break;
				case "/CRUD/profissional/listaProfissional": listaProfissional(request, response); break;
				case "/CRUD/cliente/remove": removeCliente(request, response); break;
				case "/CRUD/profissional/remove": removeProfissional(request, response); break;
				
				default: request.getRequestDispatcher("/logado/admin/index.jsp").forward(request, response);
			}
		}catch (ServletException e) {
			throw new RuntimeException(e);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	protected void listaCliente(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		ClienteDAO dao = new ClienteDAO();
		List<Cliente> clientes = dao.getAll();
		request.setAttribute("listaClientes", clientes);
		request.getRequestDispatcher("/logado/admin/listaCliente.jsp").forward(request, response);
	}
	
	protected void listaProfissional(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		ProfissionalDAO dao = new ProfissionalDAO();
		List<Profissional> profissionais = dao.getAll();
		request.setAttribute("listaProfissionais", profissionais);
		request.getRequestDispatcher("/logado/admin/listaProfissional.jsp").forward(request, response);
	}
	
	protected void apresentaFormEdicaoCliente(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		ClienteDAO dao = new ClienteDAO();
		Cliente cliente = dao.getById((Long.parseLong(request.getParameter("id"))));
		request.setAttribute("cliente", cliente);
		request.getRequestDispatcher("/logado/admin/edicaoCliente.jsp").forward(request, response);
	}
	
	protected void apresentaFormEdicaoProfissional(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		ProfissionalDAO dao = new ProfissionalDAO();
		Profissional profissional = dao.getById(Long.parseLong(request.getParameter("id")));
		request.setAttribute("profissional", profissional);
		request.getRequestDispatcher("/logado/admin/edicaoProfissional.jsp").forward(request, response);
	}
	
	protected void removeCliente(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		ClienteDAO dao = new ClienteDAO();
		dao.delete(Long.parseLong(request.getParameter("id")));
		response.sendRedirect("listaCliente");
	}
	
	protected void removeProfissional(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		ProfissionalDAO dao = new ProfissionalDAO();
		dao.delete(Long.parseLong(request.getParameter("id")));
		response.sendRedirect("listaProfissional");
	}
	
	protected void atualizaCliente(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, ParseException{
		Long id = Long.parseLong(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String CPF = request.getParameter("CPF");
		String telefone = request.getParameter("telefone");
		String sexo = request.getParameter("sexo");
		String dataNascimento = request.getParameter("dataNascimento"); // converter data antes de enviar para o banco
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
		Date data = new Date(sdf.parse(dataNascimento).getTime());
		String papel = request.getParameter("papel");
		
		ClienteDAO dao = new ClienteDAO();
		Cliente cliente = new Cliente(id, nome, email, senha, CPF, telefone, sexo, data, papel);
		dao.update(cliente);
		response.sendRedirect("listaCliente");
	}
	
	protected void atualizaProfissional(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		Long id = Long.parseLong(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String CPF = request.getParameter("CPF");
		String especialidade = request.getParameter("especialidade");
		String curriculo = request.getParameter("curriculo");
		String papel = request.getParameter("papel");
		
		ProfissionalDAO dao = new ProfissionalDAO();
		Profissional profissional = new Profissional(id, nome, email, senha, CPF, especialidade, curriculo, papel);
		dao.update(profissional);
		response.sendRedirect("listaProfissional");
	}
	
	protected void apresentaFormCadastroCliente(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		request.getRequestDispatcher("/logado/admin/cadastroCliente.jsp").forward(request, response);
	}
	
	protected void insereCliente(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, ParseException{
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String CPF = request.getParameter("CPF");
		String telefone = request.getParameter("telefone");
		String sexo = request.getParameter("sexo");
		String dataNascimento = request.getParameter("dataNascimento"); // converter data antes de enviar para o banco
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
		Date data = new Date(sdf.parse(dataNascimento).getTime());
		String papel = request.getParameter("papel");
		
		ClienteDAO dao = new ClienteDAO();
		Cliente cliente = new Cliente(nome, email, senha, CPF, telefone, sexo, data, papel);
		dao.insert(cliente);
		response.sendRedirect("listaCliente");
	}
	
	protected void apresentaFormCadastroProfissional(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		request.getRequestDispatcher("/logado/admin/cadastroProfissional.jsp").forward(request, response);
	}
	
	protected void insereProfissional(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String CPF = request.getParameter("CPF");
		String especialidade = request.getParameter("especialidade");
		String curriculo = request.getParameter("curriculo");
		String papel = request.getParameter("papel");
		
		ProfissionalDAO dao = new ProfissionalDAO();
		Profissional profissional = new Profissional(nome, email, senha, CPF, especialidade, curriculo, papel);
		dao.insert(profissional);
		response.sendRedirect("listaProfissional");
	}
}
