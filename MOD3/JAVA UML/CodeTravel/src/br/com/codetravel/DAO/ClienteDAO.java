package br.com.codetravel.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import br.com.codetravel.model.Cliente;
import br.com.codetravel.factory.ConnectionFactory;

public class ClienteDAO {
	
	public void save(Cliente cliente) {
		String sql = "INSERT INTO Cliente(nome, cpf, telefone, cep, rua, numero, bairro, cidade)" + 	"VALUES(?,?,?,?,?,?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, cliente.getNome());

			pstm.setString(2, cliente.getCpf());
			
			pstm.setString(3, cliente.getTelefone());
			
			pstm.setInt(4, cliente.getCep());

			pstm.setString(5, cliente.getRua());
			
			pstm.setInt(6, cliente.getNumero());
			
			pstm.setString(7, cliente.getBairro());
			
			pstm.setString(8, cliente.getCidade());
			
			pstm.execute();

			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
			if(pstm != null) {
			pstm.close();	
			}
			
			if(conn != null) {
				conn.close();
			}
			}catch(Exception e) {
			e.printStackTrace();	
			}
			}
			}
	
	public List<Cliente> getCliente(){
		
		String sql = "SELECT  * FROM cliente";
			List<Cliente> cliente = new ArrayList<Cliente>();
			
			Connection conn = null;
			PreparedStatement pstm = null;
			
			ResultSet rset = null;
			
			try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				
				Cliente clientes = new Cliente();
				
				
				clientes.setNome(rset.getString("nome"));
				clientes.setCpf(rset.getString("cpf"));
				clientes.setTelefone(rset.getString("telefone"));
				clientes.setCep(rset.getInt("cep"));
				clientes.setRua(rset.getString("rua"));
				clientes.setNumero(rset.getInt("numero"));
				clientes.setBairro(rset.getString("bairro"));
				clientes.setCidade(rset.getString("cidade"));
				
				cliente.add(clientes);
			}
			}catch (Exception e) {
			e.printStackTrace();	
			}finally {
			
			try {
			if(rset != null) {
			rset.close();	
			}
			
			if(pstm != null) {
			pstm.close();	
			}
			if(conn != null) {
			conn.close();	
			}
			}catch(Exception e) {
			e.printStackTrace();	
			}
			}
			return cliente;
			}
	

	public void update(Cliente cliente) {
	
	
	String sql = "UPDATE cliente SET nome = ?, cpf = ?, telefone = ?, cep = ?, rua = ?, numero = ?, bairro = ?, cidade = ?" + "WHERE idCliente = ?";
	
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			
		conn = ConnectionFactory.createConnectionToMySQL();
		pstm = conn.prepareStatement(sql);
		
		
		pstm.setString(1, cliente.getNome());
		pstm.setString(2, cliente.getCpf());
		pstm.setString(3, cliente.getTelefone());
		pstm.setInt(4, cliente.getCep());
		pstm.setString(5, cliente.getRua());
		pstm.setInt(6, cliente.getNumero());
		pstm.setString(7, cliente.getBairro());
		pstm.setString(8, cliente.getCidade());
		
		pstm.setInt(9, cliente.getIdCliente());
		
		pstm.execute();
		
		}catch (Exception e) {
		e.printStackTrace();	
		}finally {
			
		try {
		if(pstm != null) {
		pstm.close();
		}
		
		if(conn != null) {
		conn.close();	
		}
		
		}catch(Exception e) {
		e.printStackTrace();	
		}
		}
		}
	
	public void removeById(int id) {
		String sql = "DELETE FROM cliente WHERE idCliente = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
		conn = ConnectionFactory.createConnectionToMySQL();
		
		pstm = conn.prepareStatement(sql);
		
		pstm.setInt(1, id);
		
		pstm.execute();
		}catch (Exception e) {
		e.printStackTrace();
		}finally {
			
			try {
			if(pstm != null) {
			pstm.close();	
			}
			if(conn != null) {
			conn.close();	
			}
			}catch(Exception e) {
			e.printStackTrace();	
			}
			}
			}
}
		

