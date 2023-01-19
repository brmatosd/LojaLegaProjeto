package br.com.lojalegal.store.system.data;

import java.util.ArrayList;
import java.util.List;

public class EstoqueDate implements Interface { 
	
	List<Object> estoqueDate = new ArrayList<Object>();
	
	
	@Override
	public boolean save(Object obj) {
		 
		 if(estoqueDate.add(obj)) {
				
			}
			else {
				return true;
			}
		return false; 
	}

	@Override
	public void update(Object obj) {
		((EstoqueDate) this.estoqueDate).update(obj);
		  
	}

	@Override
	public boolean delete(Object obj) {
		if (estoqueDate.remove(obj)) {
			return true;
	 	}
		else {
			return false;
		}
	}

	@Override
	public boolean edit(int arrumar, Object obj) {
		estoqueDate.set(arrumar, obj);
		return true;
	}

	@Override
	public List<Object> listItems() {
		 
		return estoqueDate;
	}

}
