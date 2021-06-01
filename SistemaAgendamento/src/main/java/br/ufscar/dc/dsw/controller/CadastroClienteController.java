package br.ufscar.dc.dsw.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.google.protobuf.TextFormat.ParseException;

import br.ufscar.dc.dsw.dao.ClienteDAO;
import br.ufscar.dc.dsw.dao.ProfissionalDAO;
import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.domain.Profissional;


@WebServlet(urlPatterns = "/cadastroCliente")

public class CadastroClienteController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		doGet(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, ParseException {
		
			String nome = request.getParameter("nome");
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			String CPF = request.getParameter("CPF");
			String telefone = request.getParameter("telefone");
			String sexo = request.getParameter("sexo");
			String dataNascimento = request.getParameter("dataNascimento"); // converter data antes de enviar para o banco
			SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
			Date data = null;
			try {
				data = new Date(sdf.parse(dataNascimento).getTime());
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String papel = request.getParameter("papel");
			
			ClienteDAO dao = new ClienteDAO();
			Cliente cliente = new Cliente(nome, email, senha, CPF, telefone, sexo, data, papel);
			dao.insert(cliente);
			response.sendRedirect("index.jsp");
	}

}
