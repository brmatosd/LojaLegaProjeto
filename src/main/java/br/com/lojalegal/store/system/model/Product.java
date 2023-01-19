package br.com.lojalegal.store.system.model;

import br.com.lojalegal.store.system.enums.CategoriaEnum;
import br.com.lojalegal.store.system.enums.CorEnum;
import br.com.lojalegal.store.system.enums.DepartamentoEnum;
import br.com.lojalegal.store.system.enums.TamanhoEnum;


public class Product {
	 
	 
	private String sku;
	private Integer quantidade;
	private Double valor;
	private String descricao;
	private DepartamentoEnum departamento;
	private CategoriaEnum categoria;
	private CorEnum cor;
	private TamanhoEnum tamanho;
    
     
	public Product(String sku, Integer quantidade, Double valor, String descricao) {
		super();
		this.sku = sku;
		this.quantidade = quantidade;
		this.valor = valor;
		this.descricao = descricao;
		dados();
	}
 
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
		dados();
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
 
	public DepartamentoEnum getDepartamento() {
		return departamento;
	}

	 
	public CategoriaEnum getCategoria() {
		return categoria;
	}
 
	public CorEnum getCor() {
		return cor;
	}
 

	public TamanhoEnum getTamanho() {
		return tamanho;
	}

  
	public void dados() {
		 this.categoria = CategoriaEnum.getCategoriaEnum(sku.substring(0,3));
		 this.cor = CorEnum.getCorEnum(sku.substring(3,5)); 
		 this. departamento = DepartamentoEnum.getDepartamentoEnum(sku.substring(5,8));
         this.tamanho = TamanhoEnum.getTamanhoEnum(sku.substring(8));
	}
   @Override
    public String toString() {
	return "\nSKU:" + sku + "\nQuantidade:" +quantidade +"\nValor:" + valor + "\nDescricao:" +descricao + 
			", " + categoria + ", " + cor + "," + departamento + ", " + tamanho + "\n";
  } 
  
}









