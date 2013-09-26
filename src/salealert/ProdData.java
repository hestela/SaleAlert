package salealert;

import java.util.Iterator;
import java.util.List;

import salealert.Style;

public class ProdData {
	/*
	 * this class contains information for a single product
	 */
    private String productId,
	productName,
	brandId,
	brandName,
	defualtProductUrl,
	defualtImageUrl;	
    //list of styles for each product
    private List<Style> styles;
    
	//tells each style to convert its percentOff string into an integer representation
	public void convertSaleStrings(){
		for(Style currStyle : styles){
			currStyle.saleStringToInt();
		}
	}
	public void checkNewSales(Iterator<Style> rhs){
		Style rhsStyle;
		//if this is the first check when rhs is null then do this instead
		if(rhs == null){
			for(Style currStyle : styles){
				if(currStyle.getSalePercent() >= 20){
					currStyle.setEmailSent(false);
				}
			}
		}
		else{	
			//iterate through each style to see if there is a new sale
			for(Style currStyle : styles){
				//going to assume that styles are not added or removed during execution of the program
				rhsStyle = rhs.next();
	
				//if there is a new or better sale, set emailSent to false
				if(rhsStyle.getSalePercent() > currStyle.getSalePercent() ){
					rhsStyle.setEmailSent(false);
			//System.out.println(rhsStyle.toString());
				}
				//if the sale has been reduced or is the same, don't send a new email
				else if(rhsStyle.getSalePercent() <= currStyle.getSalePercent()){
					rhsStyle.setEmailSent(true);
				}
			}
		}
		
	}
	public void notifyCustomer(String emailAddr){
		String stylesOnSale = "";
		boolean newSale = false;
		//iterate though list of styles and check if an email was already sent
		for(Style currStyle : styles){
			if(!currStyle.emailSent()){
				//add to list of styles that have come on sale
				stylesOnSale = stylesOnSale + currStyle.toString() + "\n";
				newSale = true;
				//say that the email has been sent
				currStyle.setEmailSent(true);
			}
		}
		if(newSale){
			sendEmail(stylesOnSale, emailAddr);
		}
		else{
			//tell user there was no email sent
			System.out.println("no new sales, no email sent");
		}
		
	}
	//Currently just outputs some text
	public void sendEmail(String saleItems, String emailAddr){
		/* NOTE: the Zappos API does not define how to send an email
		 * And the specifications of the program do not define how to send an email.
		 * It is also not possible for me to create and test email sending
		 * functionality by using the javax.mail package because it requires
		 * that I have access to an SMTP server. 
		 */
		System.out.println("Hello, " + emailAddr);
		System.out.println();
		System.out.println("The following styles for item: " + brandName + " " + productName + " are on sale");
		System.out.println(saleItems);
	}
    //Getter functions
	public String getProductId() {
		return productId;
	}
	public String getProductName() {
		return productName;
	}
	public String getBrandId() {
		return brandId;
	}
	public String getBrandName() {
		return brandName;
	}
	public String getDefualtProductUrl() {
		return defualtProductUrl;
	}
	public String getDefualtImageUrl() {
		return defualtImageUrl;
	}
	public Iterator<Style> getIterator(){
		return styles.iterator();
	}
}
