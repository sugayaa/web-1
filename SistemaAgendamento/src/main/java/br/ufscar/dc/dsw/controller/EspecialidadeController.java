package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.ufscar.dc.dsw.bean.buscaPorEspecialidadeBean;
import br.ufscar.dc.dsw.domain.Profissional;

@WebServlet(urlPatterns = {"/buscaPorEspecialidade"})
public class EspecialidadeController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		processRequest(request, response);
	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String nome = request.getParameter("term");
        System.out.println("term = "+nome);
        Gson gsonBuilder = new GsonBuilder().create();
        System.out.println("12");
        List<Profissional> profissionais = new ArrayList<>();
        for (Profissional profissional : new buscaPorEspecialidadeBean().getEspecialidades(nome)) {
            profissionais.add(profissional);
        }
        System.out.println("Realizou a busca por especialidade3");
        System.out.println(gsonBuilder.toJson(profissionais));       
        response.getWriter().write(gsonBuilder.toJson(profissionais));
    }
}
