package br.com.lojalegal.store.system.model;

public class Funcionario extends Pessoa {  
   
	private String matricula;
	
	 
 
 	public Funcionario(String nome, String cpf, String endereco, String matricula) {
	super(nome, cpf, endereco);
	this.matricula = matricula;
}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	   
    }
}