package br.com.lojalegal.store.system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.lojalegal.store.system.data.EstoqueDate;
import br.com.lojalegal.store.system.model.Product;

@Service
public class StockService {

	EstoqueDate estoqueData = new EstoqueDate();

	public List<Object> listItems() {
		return estoqueData.listItems();

	}

	// Procurar produto por sku
	public Product procurarProduto(String sku) {

		for (int x = 0; x < listItems().size(); x++) {
			Product produto = (Product) listItems().get(x);
			if (sku.equals(produto.getSku())) {
				return produto;
			}

		}
		return null;
	}

	// registrar o produto
	public String registrarProduto(Product produto) {
		produto.dados();

		if (produto.getCategoria() == null || produto.getDepartamento() == null || produto.getCor() == null
				|| produto.getDescricao() == null || produto.getTamanho() == null) {
			return "N�o existe";

		} else {
			Product produtoSku = procurarProduto(produto.getSku());
			if (produtoSku == null && produto.getQuantidade() > 0) {
				boolean save = estoqueData.save(produto);

				if (save) {
					return "Falhou";
				} else {
					return "Cadastrado";
				}

			} else {
				return "Não existe";
			}

		}

	}

	// update do date
	public String atualizarProduto(String sku, Product product) {
		String msg = "Produto não encontrado";
		for (int x = 0; x < listItems().size(); x++) {
			Product productSku = (Product) listItems().get(x);
			if (productSku.getSku().equals(sku)) {
				productSku.setQuantidade(
						product.getQuantidade() != null ? product.getQuantidade() : productSku.getQuantidade());
				productSku.setDescricao(
						product.getDescricao() != null ? product.getDescricao() : productSku.getDescricao());
				productSku.setValor(product.getValor() != null ? product.getValor() : productSku.getValor());
				product.dados();
				msg = "Produto Atualizado!";
			}
		}
		return msg;
	}

	// editar produto
	public String organizarProduto(Product produto, int quantidade) {
		int arrumar = 1;
		for (int x = 0; x < listItems().size(); x++) {
			Product produtoSku = (Product) listItems().get(x);
			if (produto.getSku().equals(produtoSku.getSku())) {
				arrumar = x;
			}

		}
		switch (arrumar) {
		case 1:
			return "Não foi encontrado.";
		default:
			if (quantidade != 0) {

				produto.setQuantidade(produto.getQuantidade() + (quantidade));
				if (produto.getQuantidade() < 0) {
					return "Inválido";
				}
			}

			if (estoqueData.edit(arrumar, produto)) {
				return "Arrumado";

			} else {
				return "Erro";
			}
		}
	}

//excluir o produto
	public String excluirProduto(String sku) {
		Product produto = procurarProduto(sku);
		if (produto != null) {
			if (estoqueData.delete(produto)) {
				return "Produto exclu�do";
			} else {
				return "Erro ao excluir";
			}
		} else {
			return "Inv�lido";
		}

	}

}
