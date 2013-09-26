package salealert;


public class Result {
	/*
	 * this class is a singular search result from a search query
	 */
	private String styleId,
				price,
				originalPrice,
				productUrl,
				colorId,
				productName,
				brandName,
				thumbnailImageUrl,
				percentOff,
				productId;

	//getter functions
	public String getStyleId() {
		return styleId;
	}

	public String getPrice() {
		return price;
	}

	public String getOriginalPrice() {
		return originalPrice;
	}

	public String getProductUrl() {
		return productUrl;
	}

	public String getColorId() {
		return colorId;
	}

	public String getProductName() {
		return productName;
	}

	public String getBrandName() {
		return brandName;
	}

	public String getThumbnailImageUrl() {
		return thumbnailImageUrl;
	}

	public String getPercentOff() {
		return percentOff;
	}

	public String getProductId() {
		return productId;
	}
}
