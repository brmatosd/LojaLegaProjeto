package br.com.lojalegal.store.system.model;

public class Pix extends Venda {
 
	private String chavePix;
	public static String total;
	
	public Pix(String cpf, String total) {
		super(cpf, total, total);
		this.setCpf(cpf);
		this.setTotal(total);
		this.chavePix = chavePix;
		 
	}
 

	public Pix(String nome, String cpf, String endereco, String chavePix) {
		super(nome, cpf, endereco);
		this.chavePix = chavePix;
	}


	public String getChavePix() {
		return chavePix;
	}


	public void setChavePix(String chavePix) {
		this.chavePix = chavePix;
	}

	@Override
	public String toString() {
		return "CPF: " +getCpf() + "\nTotal: " + getTotal() + "Chave pix: " + getChavePix()+ "\nFormas de pagamento: Tranferencia por pix: " + chavePix;
		
	}
	
	
}
