package br.com.lojalegal.store.system.model;

import java.util.ArrayList;
import java.util.List;

public class Venda extends Pessoa {

	
	 
	private String total;
	
 	private List<Product> vender = new ArrayList<Product>();
	
	 
 	
 	public Venda(String nome, String cpf, String endereco) {
		super(nome, cpf, endereco);
		 
	}
  
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public List<Product> getVender() { 
		return  vender;
	}
	public void setVender(List<Product> vender) {
		this.vender = vender;
	}
}
