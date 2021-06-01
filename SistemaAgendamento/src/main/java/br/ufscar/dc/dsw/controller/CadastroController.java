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


@WebServlet(urlPatterns = "/cadastroProfissional")

public class CadastroController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		doGet(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, ParseException {
		
		if(ServletFileUpload.isMultipartContent(request)){
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(1024*1024*3);
			factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
			
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setFileSizeMax(1024*1024*40);
			upload.setSizeMax(1024*1024*50);
			
			String uploadPath = getServletContext().getRealPath("") + File.separator + "curriculo";
			File uploadDir = new File(uploadPath);
			if(!uploadDir.exists())
				uploadDir.mkdir();
			try {
				ProfissionalDAO dao = new ProfissionalDAO();
				String filePath = null;
				Profissional profissional_aux = new Profissional();
				dao.insert(profissional_aux);
				Long id = dao.getMaxId();
				if(id != null) {
					System.out.println("id = "+id);
				}
				List<FileItem> formItems = upload.parseRequest(request);
				HashMap<String, String> field = new HashMap<String, String>();
				if(formItems != null && formItems.size() > 0) {
					for(FileItem item : formItems) {
						if(!item.isFormField()) {
							filePath = uploadPath + File.separator + id +"_curriculo";
							System.out.println("fiePath = "+filePath);
							File storeFile  = new File(filePath);
							item.write(storeFile);
						}
						else {
							String fieldName = item.getFieldName();
							String fieldValue = item.getString();
							field.put(fieldName, fieldValue);
						}
					}
				}
				System.out.println("filepath = "+filePath);
				Profissional profissional = new Profissional(field.get("nome"), field.get("email"), field.get("senha"), field.get("CPF"), 
						                   field.get("especialidade"), id.toString()+"_curriculo", field.get("papel"));
				id = dao.getMaxId();
				profissional.setCurriculo(id.toString()+"_curriculo");
				profissional.setId(id);
				dao.update(profissional);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		response.sendRedirect("index.jsp");
	}

}
