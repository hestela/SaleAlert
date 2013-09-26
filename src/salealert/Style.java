package salealert;

import java.math.BigDecimal;

public class Style {
	/*
	 * this class contains information for each style of a specific product
	 */

    private String color,
	originalPrice,
	price,
	imageUrl,
	styleId,
	productUrl,
	percentOff;
    
    //flag to indicate whether the custom should be notified about a new sale
    boolean emailSent;
    //integer representation of the percentOff string, eg. if string was 20% then this would be 20
    int salePercent;

    public Style(){
    	//going to pretend we sent an email for new styles, because we send an email if this is false
    	emailSent = true;
    }

	public void saleStringToInt(){
		//takes out the % from the string to convert to bigdecimal and then an int
		BigDecimal d = new BigDecimal(percentOff.trim().replace("%", ""));
	    salePercent = d.intValueExact();
	}
	
	//function to set emailSent to true or false
	public void setEmailSent(boolean _emailSent){
		emailSent = _emailSent;
	}
	
	//convert style information to a string for sending an email
	public String toString(){
		return "Style Color: " + color + " Original Price: " + originalPrice + 
				" New Price: " + price + " " + percentOff + " off";
	}
	//Getter functions
	public String getColor() {
		return color;
	}

	public String getOriginalPrice() {
		return originalPrice;
	}

	public String getPrice() {
		return price;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public String getStyleId() {
		return styleId;
	}

	public String getProductUrl() {
		return productUrl;
	}

	public String getPercentOff() {
		return percentOff;
	}
	
	public int getSalePercent(){
		return salePercent;
	}
	
	public boolean emailSent(){
		return emailSent;
	}

}
