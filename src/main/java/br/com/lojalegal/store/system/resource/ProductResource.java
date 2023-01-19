package br.com.lojalegal.store.system.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lojalegal.store.system.model.Product;
import br.com.lojalegal.store.system.service.StockService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

	@Autowired
	private StockService stockService;

	@GetMapping
	public List<Object> getProducts() {
		return stockService.listItems();
	}

	@GetMapping(value = "/{sku}")
	public Product findBySKU(@PathVariable(value = "sku") String sku) {
		return stockService.procurarProduto(sku);
	}

	@PostMapping
	public ResponseEntity<String> saveProduct(@RequestBody Product product) {
		return ResponseEntity.status(HttpStatus.CREATED).body(stockService.registrarProduto(product));
	}

	@DeleteMapping("/{sku}")
	public ResponseEntity <String>  daleteProduct(@PathVariable (value= "sku") String sku) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(stockService.excluirProduto(sku));
	}

	@PatchMapping(value="/{sku}")
	public ResponseEntity<String> updateProduct(@PathVariable (value="sku") String sku, @RequestBody Product product) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(stockService.atualizarProduto(sku, product));
	}
	
}
