package salealert;

import java.util.Iterator;
import java.util.List;

import salealert.ProdData;

public class ResultStyle {
	/*
	 * list of products from query,
	 * necessary even for a specific product query because 
	 * the json always returns a list of products even
	 * though there will always be one product returned
	 * and gson requires that classes need to be in the exact same
	 * format as the provided json				
	 */
	private List<ProdData> product;

	//getter functions
	public List<ProdData> getProduct() {
		return product;
	}
	public Iterator<ProdData> getIterator(){
		return product.iterator();
	}
	
}
