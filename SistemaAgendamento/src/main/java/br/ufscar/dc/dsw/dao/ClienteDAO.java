package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import javax.management.RuntimeErrorException;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.PreparableStatement;

import br.ufscar.dc.dsw.domain.*;

public class ClienteDAO extends GenericDAO{
	
	public void insert(Cliente cliente) {
		String sql = "INSERT INTO Cliente (nome, email, senha, CPF, telefone, sexo, dataNascimento, papel) ";
		sql += "VALUES(?, ?, ? ,?, ?, ?, ?, ?)";
		
		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, cliente.getNome());
			statement.setString(2, cliente.getEmail());
			statement.setString(3, cliente.getSenha());
			statement.setString(4, cliente.getCPF());
			statement.setString(5, cliente.getTelefone());
			statement.setString(6, cliente.getSexo());
			statement.setDate(7, cliente.getDataNascimento());
			statement.setString(8, cliente.getPapel());
			statement.executeUpdate();
			
			statement.close();
			conn.close();
		}catch (SQLException e) {
			throw new RuntimeException(e); 
		}
	}
	
	public void delete(Long id) {
		String sql = "DELETE FROM Cliente where id = ?";
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

	public void update(Cliente cliente) {
		String sql = "UPDATE Cliente SET nome = ?, email = ?, senha = ?, CPF = ?, telefone = ?, sexo = ?, dataNascimento = ?, papel = ? WHERE id = ?";
		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, cliente.getNome());
			statement.setString(2, cliente.getEmail());
			statement.setString(3, cliente.getSenha());
			statement.setString(4, cliente.getCPF());
			statement.setString(5, cliente.getTelefone());
			statement.setString(6, cliente.getSexo());
			statement.setDate(7, cliente.getDataNascimento());
			statement.setString(8, cliente.getPapel());
			statement.setLong(9, cliente.getId());
			statement.executeUpdate();
			
			statement.close();
			conn.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Cliente> getAll(){
		String sql = "SELECT * FROM Cliente";
		List<Cliente> listaClientes = new ArrayList<Cliente>();
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
				String telefone = resultado.getString("telefone");
				String sexo = resultado.getString("sexo");
				Date dataNascimento = resultado.getDate("dataNascimento");
				String papel = resultado.getString("papel");
				
				Cliente cliente = new Cliente(id, nome, email, senha, CPF, telefone, sexo, dataNascimento, papel);
				listaClientes.add(cliente);
			}
			resultado.close();
			statement.close();
			conn.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return listaClientes;
	}
	
	public Cliente getByEmail(String email) {
		String sql = "SELECT * FROM Cliente WHERE email = ?";
		Cliente cliente = null;
		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, email);
			ResultSet resultado = statement.executeQuery();
			if(resultado.next()) {
				Long id = resultado.getLong("id");
				String nome = resultado.getString("nome");
				String senha = resultado.getString("senha");
				String CPF = resultado.getString("CPF");
				String telefone = resultado.getString("telefone");
				String sexo = resultado.getString("sexo");
				Date dataNascimento = resultado.getDate("dataNascimento");
				String papel = resultado.getString("papel");
				cliente = new Cliente(id, nome, email, senha, CPF, telefone, sexo, dataNascimento, papel);
			}
			resultado.close();
			statement.close();
			conn.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return cliente;
	}
	
	public Cliente getById(Long id) {
		String sql = "SELECT * FROM Cliente WHERE id = ?";
		Cliente cliente = null;
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
				String telefone = resultado.getString("telefone");
				String sexo = resultado.getString("sexo");
				Date dataNascimento = resultado.getDate("dataNascimento");
				String papel = resultado.getString("papel");
				cliente = new Cliente(id, nome, email, senha, CPF, telefone, sexo, dataNascimento, papel);
			}
			resultado.close();
			statement.close();
			conn.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return cliente;
	}
}
