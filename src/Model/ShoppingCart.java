package Model;

import java.util.HashMap;
import java.util.List;

import Graphics.Window;

/**
 * Created by Bianca on 2/11/2017.
 */
public class ShoppingCart {
    private HashMap<Product, Integer> products;
    public HashMap<Product, Integer> getProducts(){return products;}
    
	public void add(Product p) {
		if(products.containsKey(p)) {
			
			products.put(p, products.get(p)+1);
			
		}else {
			products.put(p, 1);
		}
		for(Product q: Window.products) {
			if(q.getName().equals(p.getName())) {
				q.setStock(q.getStock()-1);
			}
		}
	}

	public ShoppingCart() {
		super();
		products = new HashMap<Product, Integer>();
	}

}
