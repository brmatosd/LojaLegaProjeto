package br.com.lojalegal.store.system.service;

import java.util.ArrayList;
import java.util.List;
 
import br.com.lojalegal.store.system.model.Product;

public class Vendas { 

	 List<Product> lista = new ArrayList<Product>();
	 StockService estoqueProduto;
	 
	 //Dados do list
	 public void produtos(StockService produtos) {
		 estoqueProduto = produtos;
		  
	 }
	 
	 //listar produto no carrinho  
	 public List<Product> getLista() {
		 return lista;
		 
		 
	 }
	 //procurar produto no carrinho  
	 public Product procurandoSku(String sku) {
		 
		for(int x = 0; x<lista.size(); x++) {
			Product produto = (Product) lista.get(x);
			if(sku.equals(produto.getSku())) {
				return produto;
			}
		}
		 return null;
		 
	 }
	 
	//Colocar no carrinho usando do sku
	 public String colocarNoCarrinho(String sku, int quantidade) { 
		 
		 Product produto = estoqueProduto.procurarProduto(sku); 
		
		 if (produto == null) {
			 return "N�o existe";
			 
			 
		 }else if(produto.getQuantidade() <= 0) {  
			
			 return "N�o temos";
			 
 		 }else if(quantidade <=  0) {
             
 			 return "Qual Quantidade?"; 
 	 		  
 		 }
 		 else {
 			 //Remover do estoque
 			  if (tirandoProdutoDoEstoque(produto, quantidade) == 2) { 
 				  produto.setQuantidade(quantidade);
 				  Product itemProduto = procurandoSku(sku);
 				  if(itemProduto == null) {
 					  
 					 lista.add(produto);
 					 
 					 return "Produto no carrinho";
 				   
 				  }else {
 					  
 					 itemProduto.setQuantidade(itemProduto.getQuantidade() + quantidade);
 					  if(arrumandoProdutonoCarrinho(itemProduto) == 0) {
 						
 						  return "Colocou no carrinho";
 						  
 					  }else {
 						  return "N�o foi poss�vel";
 						  
 					  }
 			 	  }
 				 
 			  }else {
 				  
 				  return "N�o existe essa quantidade";
 			  }
 			  
 		 }
		 
	 }
 	 
	 //editar produto no carrinho  
	 private int arrumandoProdutonoCarrinho(Product produto) { 
		 int arrumar = 1;
		 for(int x= 0; x<getLista().size(); x++) {
			 Product produtoSku = getLista().get(x);
			 if(produto.getSku().equals(produtoSku.getSku())) {
				 arrumar = x; 
			 }
			 
		 }
		 switch(arrumar) {
		 case 1:
			 return 2;  
		 
		 default:
		if(lista.set(arrumar, produto) != null) {
			conferindoProdutos();  
			return 0;
		
		}else {
			return 2;
    }
			 
   } 
 }
	//verificar os produtos  
	 private void conferindoProdutos() {
		 for(int x = 0; x<lista.size(); x++) {
			 Product produto = lista.get(x);
			 if(produto.getQuantidade() <= 0) {
				 lista.remove(produto);
			 }
		 }
	}
	 //retirar produto do carrinho  
	 public String removerDoCarrinho(String sku, int quantidade) {
		 Product produto = procurandoSku(sku);
		 
		 if(produto == null) {
			 return "N�o existe";
		 
		 }else if(produto.getQuantidade() < quantidade) {
			 return "N�o tem essa quantidade";
			 
		 }else if(quantidade <= 0) {
			 return "Digite de novo";
		 }else {
			 devolverProdutoAoEstoque(produto.getSku(), quantidade);
		     produto.setQuantidade(produto.getQuantidade() - quantidade);
			 return "Removido";
		 } 
	 	 
	 }
	 //Devolver produto  
	 public void devolverProdutoAoEstoque(String sku, int quantidade) {
		 Product produtoNoEstoque =  estoqueProduto.procurarProduto(sku);
		 if(produtoNoEstoque == null) {
			 estoqueProduto.registrarProduto(produtoNoEstoque);
		 }else {
			 quantidade = produtoNoEstoque.getQuantidade() + quantidade;
			 Product mostrarPoduto = new Product(produtoNoEstoque.getSku(), produtoNoEstoque.getQuantidade(), produtoNoEstoque.getValor(), produtoNoEstoque.getDescricao());
			 estoqueProduto.organizarProduto(mostrarPoduto, 0);
		 }
 		  
	 }
 	 
	 private int excluirProdutoEstoqueDate(Product produto, int quantidade) {
		 
		 if(produto.getQuantidade() < quantidade) {
			 return 1;
		 }else {
			 quantidade = produto.getQuantidade() - quantidade;
			 Product produtoRt = new Product(produto.getSku(), produto.getQuantidade(), produto.getValor(), produto.getDescricao());
			 estoqueProduto.organizarProduto(produtoRt, 0);
		 return 2;
		  }
		 	
	}
	//retirar produto do estoque  
	  
	 public int tirandoProdutoDoEstoque(Product produto, int quantidade) {
		 
		 if(produto.getQuantidade() < quantidade) {
			 return 1;
	 	 } else {
	 		 quantidade = produto.getQuantidade() - quantidade;
	 		 Product mostrar = new Product(produto.getSku(), produto.getQuantidade(), produto.getValor(), produto.getDescricao());
	 		estoqueProduto.organizarProduto(mostrar, 0);
	 		return 2; 
	 		 
	 	 }
		   
	 }
	 //valor total  
 	 public  double valorFinal( ) {
 		 Double valorFinal = 0.0;
 		 for(int x = 0; x<lista.size(); x++) {
 			valorFinal = valorFinal + (lista.get(x).getValor() + lista.get(x).getQuantidade());
 		  }
 		 return valorFinal;
 	 }
 	 //Esvaziar carrinho
public String cancelarCompra() {
	
	for (int x = 0; x<getLista().size(); x++) {
		Product produto = getLista().get(x);
		removerDoCarrinho(produto.getSku(), produto.getQuantidade());
		
	}
	     return "Desistindo de compra";
  }
}
