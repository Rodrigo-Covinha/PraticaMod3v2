package br.com.codetravel.application;
import br.com.codetravel.DAO.ClienteDAO;
import br.com.codetravel.model.Cliente;



public class Main {
	
	//CREATE - SAVE// 

	public static void main(String[] args) {

		ClienteDAO clienteDAO = new ClienteDAO();
		
		Cliente cliente = new Cliente();
		cliente.setNome("Neo");
		cliente.setCpf("12345678912");
		cliente.setTelefone("54321");
		cliente.setCep(22785091);
		cliente.setRua("New road");
		cliente.setNumero(9999);
		cliente.setBairro("insert");
		cliente.setCidade("Matrix");
		
		
		 clienteDAO.save(cliente);
		
	// READ - SELECT //
		
		for(Cliente c : clienteDAO.getCliente()) {
			System.out.println("Cliente: " + c.getNome());
			
	// UPDATE - UPDATE //
			Cliente client = new Cliente();
			
			client.setNome("Uzumaki Naruto");
			client.setCpf("05824851714");
			client.setTelefone("21964811218");
			client.setCep(22988010);
			client.setRua("Rua Ichikako");
			client.setNumero(555);
			client.setBairro("Konoha");
			client.setCidade("Terra Ninja");
			client.setIdCliente(2);

			// clienteDAO.update(client);	
			
			
	// DELETE - DELETE //
			
			// clienteDAO.removeById(3);
			
		}

	}

}
