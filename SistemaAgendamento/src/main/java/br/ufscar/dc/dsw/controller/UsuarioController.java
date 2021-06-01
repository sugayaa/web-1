package br.ufscar.dc.dsw.controller;

import java.util.List;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.mail.internet.InternetAddress;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufscar.dc.dsw.dao.ConsultaDAO;
import br.ufscar.dc.dsw.dao.ProfissionalDAO;
import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.domain.Consulta;
import br.ufscar.dc.dsw.domain.Profissional;
import br.ufscar.dc.dsw.email.EmailService;
import br.ufscar.dc.dsw.utill.Erros;

@WebServlet(urlPatterns = "/usuario/*")
public class UsuarioController extends HttpServlet{
	
	Erros erros;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		doGet(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		this.erros =  new Erros();
		String action = request.getPathInfo();
		System.out.println(action);
		if(action == null)
			action = "";
		try {
			switch(action) {
				case "/marcarConsulta": apresentaFormMarcarConsulta(request, response); break;
				case "/agendarConsulta": confirmarAgendamento(request, response); break;
				case "/mostraConsulta": listaConsultas(request, response); break;
				default: request.getRequestDispatcher("/logado/usuario/index.jsp").forward(request, response);
			}
		}catch (Exception e) {
			new Exception(e);
		}
	}
	
	protected void apresentaFormMarcarConsulta(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		ProfissionalDAO dao = new ProfissionalDAO();
		Profissional profissional = dao.getById(id);
		request.setAttribute("profissional", profissional);
		
		request.getRequestDispatcher("/logado/usuario/agendaConsulta.jsp").forward(request, response);
	}
	
	protected void confirmarAgendamento(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, ParseException{

		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
		String data = request.getParameter("data");
		String horario = request.getParameter("horario");
		Long id_profissional = Long.parseLong(request.getParameter("id"));
		Cliente cliente = (Cliente) request.getSession().getAttribute("clienteLogado");
		ProfissionalDAO daoP = new ProfissionalDAO();
		Profissional profissional = daoP.getById(id_profissional);
		
		java.sql.Date data_aux = new java.sql.Date(sdf.parse(data).getTime());
		java.sql.Time horario_aux = new java.sql.Time(sdf2.parse(horario).getTime());
		ConsultaDAO dao = new ConsultaDAO();
		
		if(dao.getByIdCliente(cliente.getId(), data_aux, horario_aux)) {
			erros.add("Você já possui uma consulta marcada para esse horário, escolha outro horário");
			request.setAttribute("mensagem", erros);
		}
		if(dao.getByIdProfissisonal(id_profissional, data_aux, horario_aux)) {
			erros.add("O profissional já tem uma consulta marcada para este horário, escolha outro horário");
			request.setAttribute("mensagem", erros);
		}
		
		if(!erros.isExisteErro()) {
			dao.insert(data_aux, horario_aux, cliente.getId(), id_profissional);
			try {
				//Enviando e-mail
				
				EmailService email = new EmailService();
				InternetAddress to = new InternetAddress(profissional.getEmail());
				InternetAddress to2 = new InternetAddress(cliente.getEmail());
				email.send(to, "Agendamento de Consulta", "Consulta marcada com o cliente "+cliente.getNome()+" no dia "+data+" às "+horario+"\nLink da reunião: https://meet.google.com/vwy-wfwg-dfm");
				email.send(to2, "Agendamento de Consulta", "Consulta marcada com o profissional "+profissional.getNome()+" no dia "+data+" às "+horario+"\nLink da reunião: https://meet.google.com/vwy-wfwg-dfm");
				
			}catch(Exception e){
				e.printStackTrace();
			}
			request.getRequestDispatcher("/logado/usuario/index.jsp").forward(request, response);
		}
		else {
			request.setAttribute("profissional", profissional);
			request.getRequestDispatcher("/logado/usuario/agendaConsulta.jsp").forward(request, response);
		}
	}
	
	protected void listaConsultas(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
		Cliente cliente = (Cliente) request.getSession().getAttribute("clienteLogado");
		ConsultaDAO dao = new ConsultaDAO();
		List<Consulta> listaConsulta = dao.getAllByIdCliente(cliente.getId());
		request.setAttribute("listaConsulta", listaConsulta);
		request.getRequestDispatcher("/logado/usuario/listaConsulta.jsp").forward(request, response);
	}

}
