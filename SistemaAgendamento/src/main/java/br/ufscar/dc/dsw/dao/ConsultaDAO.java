package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import br.ufscar.dc.dsw.domain.Consulta;

public class ConsultaDAO extends GenericDAO {
	public void insert(Date data, Time horario, Long id_cliente, Long id_profissional) {
		String sql = "INSERT INTO Consulta (data, horario, id_cliente, id_profissional, url) ";
		sql += "VALUES(?, ?, ? ,?, ?)";
		
		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setDate(1, data);
			statement.setTime(2, horario);
			statement.setLong(3, id_cliente);
			statement.setLong(4, id_profissional);
			statement.setString(5, "https://meet.google.com/vwy-wfwg-dfm");
			statement.executeUpdate();
			
			statement.close();
			conn.close();
		}catch (SQLException e) {
			throw new RuntimeException(e); 
		}
	}
	
	public void delete(Long id) {
		String sql = "DELETE FROM Consulta where id = ?";
		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, id);
			statement.executeUpdate();
			statement.close();
			conn.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public boolean getByIdCliente(Long id, Date data, Time horario) {
		String sql = "SELECT * FROM Consulta WHERE id_cliente = ? and data = ? and horario = ?";
		boolean marcado = true;
		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, id);
			statement.setDate(2, data);
			statement.setTime(3, horario);
			ResultSet resultado = statement.executeQuery();
			if(!resultado.next()) {
				marcado = false;
			}
			resultado.close();
			statement.close();
			conn.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return marcado;
	}
	
	public boolean getByIdProfissisonal(Long id, Date data, Time horario) {
		String sql = "SELECT * FROM Consulta WHERE id_profissional = ? and data = ? and horario = ?";
		boolean marcado = true;
		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, id);
			statement.setDate(2, data);
			statement.setTime(3, horario);
			ResultSet resultado = statement.executeQuery();
			if(!resultado.next()) {
				marcado = false;
			}
			resultado.close();
			statement.close();
			conn.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return marcado;
	}
	
	public List<Consulta> getAllByIdCliente(Long id){
		String sql = "SELECT Profissional.nome, Consulta.data, Consulta.horario, Consulta.url FROM Consulta JOIN Profissional ON Profissional.id = Consulta.id_profissional WHERE Consulta.id_cliente = ?";
		List<Consulta> listaConsulta = new ArrayList<Consulta>();
		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, id);
			ResultSet resultado = statement.executeQuery();
			while(resultado.next()) {
				String nome = resultado.getString("nome");
				Date data = resultado.getDate("data");
				Time horario = resultado.getTime("horario");
				String url = resultado.getString("url");
				Consulta consulta = new Consulta(nome, data, horario, url);
				listaConsulta.add(consulta);
			}
			resultado.close();
			statement.close();
			conn.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return listaConsulta;
	}
	
	public List<Consulta> getAllByIdProfissional(Long id){
		String sql = "SELECT Cliente.nome, Consulta.data, Consulta.horario, Consulta.url FROM Consulta JOIN Cliente ON Cliente.id = Consulta.id_cliente WHERE Consulta.id_Profissional = ?";
		List<Consulta> listaConsulta = new ArrayList<Consulta>();
		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, id);
			ResultSet resultado = statement.executeQuery();
			while(resultado.next()) {
				String nome = resultado.getString("nome");
				Date data = resultado.getDate("data");
				Time horario = resultado.getTime("horario");
				String url = resultado.getString("url");
				Consulta consulta = new Consulta(nome, data, horario, url);
				listaConsulta.add(consulta);
			}
			resultado.close();
			statement.close();
			conn.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return listaConsulta;
	}
}
