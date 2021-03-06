//Main class
package salealert;

import java.util.Scanner;
import com.google.gson.Gson;

public class Main {	
	
	public static void main(String [] args) throws Exception{
		String email, productString, queryUrl, json;         
		boolean isProductId = true;
		ResultStyle lastResult,buffer;   
		ProdData lastProduct, newProduct;
		
		//setup external classes
		Gson gson = new Gson();   
		QueryBuilder queryBuilder = new QueryBuilder();
		JsonReader jsonReader = new JsonReader();	
		Scanner in = new Scanner(System.in);
		
		//get user email
		System.out.print("Please enter your email address: ");
		email = in.nextLine();
		
		//get product information
		System.out.print("Please the product ID or product name: ");
		productString = in.nextLine();
		System.out.println();
		
		//close scanner
		in.close();
		
		//check if user input is a product id or name		
		try{  
			//don't really care about what this is, just that productId can be converted into a number
			Double.parseDouble(productString);  
		}catch(NumberFormatException nfe){  
			//user input is not a number, assume it is product name
			isProductId = false;		    
		}  
		
		//process productId query
		if(isProductId){
			queryUrl = queryBuilder.makeQueryString(QueryEnum.PRODUCT, productString);
			json = jsonReader.getJsonQuery(queryUrl);
			
			//get initial json
			buffer = gson.fromJson(json, ResultStyle.class);
		}
		/*
		 * look for productId, going to assume user entered exact name or 
		 * close enough for API to return correct first result
		*/
		else{
			queryUrl = queryBuilder.makeQueryString(QueryEnum.SEARCH, productString);
			json = jsonReader.getJsonQuery(queryUrl);
			
			//download result json
			ResultSearch searchQuery = gson.fromJson(json, ResultSearch.class);
			
			//extract productId
			productString =  searchQuery.getIterator().next().getProductId();
		
			//get new json by productId
			queryUrl = queryBuilder.makeQueryString(QueryEnum.PRODUCT, productString);
			json = jsonReader.getJsonQuery(queryUrl);
			buffer = gson.fromJson(json, ResultStyle.class);
		}		

	    //process fist json in order to prime the loop	    
	    newProduct = buffer.getIterator().next();
	    newProduct.convertSaleStrings();
	    newProduct.checkNewSales(null);
	    newProduct.notifyCustomer(email);
	    
	    //For demonstration purposes the loop will only run three times
	    for(int i = 0; i < 3; i ++) {		    
		    
	    	//wait for 10 seconds before next request
	    	Thread.sleep(10000);
	    	
	    	//store last result
	    	lastResult = buffer;
	    	lastProduct = lastResult.getIterator().next();
	    	
	    	//get the next query and convert sale strings
	    	buffer = gson.fromJson(json, ResultStyle.class);
	    	newProduct = buffer.getIterator().next();
	    	newProduct.convertSaleStrings();
		    
	    	//check for new sales
	    	lastProduct.checkNewSales(newProduct.getIterator());
	    	lastProduct.notifyCustomer(email);	
		    }  
	}
}
