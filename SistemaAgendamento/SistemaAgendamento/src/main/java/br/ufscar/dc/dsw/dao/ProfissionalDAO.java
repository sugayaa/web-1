package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.management.RuntimeErrorException;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.PreparableStatement;

import br.ufscar.dc.dsw.domain.*;

public class ProfissionalDAO extends GenericDAO{
	
	public void insert(Profissional profissional) {
		String sql = "INSERT INTO Profissional (nome, email, senha, CPF, especialidade, curriculo, papel) ";
		sql += "VALUES(?, ?, ? ,?, ?, ?, ?)";
		
		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, profissional.getNome());
			statement.setString(2, profissional.getEmail());
			statement.setString(3, profissional.getSenha());
			statement.setString(4, profissional.getCPF());
			statement.setString(5, profissional.getEspecialidade());
			statement.setString(6, profissional.getCurriculo());
			statement.setString(7, profissional.getPapel());
			statement.executeUpdate();
			
			statement.close();
			conn.close();
		}catch (SQLException e) {
			throw new RuntimeException(e); 
		}
	}
	
	public void delete(Long id) {
		String sql = "DELETE FROM Profissional WHERE id = ?";
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
	
	public void update(Profissional profissional) {
		String sql = "UPDATE Profissional SET nome = ?, email = ?, senha = ?, CPF = ?, especialidade = ?, curriculo = ?, papel = ? WHERE id = ?";
		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, profissional.getNome());
			statement.setString(2, profissional.getEmail());
			statement.setString(3, profissional.getSenha());
			statement.setString(4, profissional.getCPF());
			statement.setString(5, profissional.getEspecialidade());
			statement.setString(6, profissional.getCurriculo());
			statement.setString(7, profissional.getPapel());
			statement.setLong(8, profissional.getId());
			statement.executeUpdate();
			
			statement.close();
			conn.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Profissional> getAll(){
		String sql = "SELECT * FROM Profissional";
		List<Profissional> listaProfissionais = new ArrayList<Profissional>();
		try {
			Connection conn = this.getConnection();
			Statement statement = conn.createStatement();
			ResultSet resultado = statement.executeQuery(sql);
			while(resultado.next()) {
				Long id = resultado.getLong("id");
				String nome = resultado.getString("nome");
				String email = resultado.getString("email");
				String senha = resultado.getString("senha");
				String CPF = resultado.getString("CPF");
				String especialidade = resultado.getString("especialidade");
				String curriculo = resultado.getString("curriculo");
				String papel = resultado.getString("papel");
				
				Profissional profissional = new Profissional(id, nome, email, senha, CPF, especialidade, curriculo, papel);
				listaProfissionais.add(profissional);
			}
			resultado.close();
			statement.close();
			conn.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return listaProfissionais;
	}
	
	public Profissional getById(Long id) {
		String sql = "SELECT * FROM Profissional WHERE id = ?";
		Profissional profissional = null;
		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, id);
			ResultSet resultado = statement.executeQuery();
			if(resultado.next()) {
				String nome = resultado.getString("nome");
				String email = resultado.getString("email");
				String senha = resultado.getString("senha");
				String CPF = resultado.getString("CPF");
				String especialidade = resultado.getString("especialidade");
				String curriculo = resultado.getString("curriculo");
				String papel = resultado.getString("papel");
				
				profissional = new Profissional(id, nome, email, senha, CPF, especialidade, curriculo, papel);
			}
			resultado.close();
			statement.close();
			conn.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return profissional;
	}
}
