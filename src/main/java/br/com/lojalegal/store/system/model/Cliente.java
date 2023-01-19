package br.com.lojalegal.store.system.model;

public class Cliente extends Pessoa { 
  
	private String codigoCliente;
 
	
	public Cliente(String nome, String cpf, String endereco) {
		super(nome, cpf, endereco);
		 
	}
	public String getCodigoCliente() {
		return codigoCliente;
	}
	public void setCodigoCliente(String codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
 
}
