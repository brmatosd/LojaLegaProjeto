package br.com.lojalegal.store.system.model;

public class Dinheiro extends Venda {

	private static String cpf;
	public static String total;
	 

	public Dinheiro() {
		super(cpf, total, total);
		
		 this.setCpf(cpf);
		 this.setTotal(total);
	}

	@Override
	 public String toString() {
		 return "CPF: " +getCpf() + "\n Total: " + getTotal() + "\nFormas de pagamento: Dinheiro\n";
		 
	 }

	 
}
