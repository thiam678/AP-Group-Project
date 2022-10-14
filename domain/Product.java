package domain;

public class Product {
	 private String productCode;
	 private String productName;
	 private String shortDescription;
	 private String longDescription; 
	 private int itemsInStock;
	 private float unitPrice;
	
	 public Product() {
		 this.productCode="";
		 this.productName="";
		 this.shortDescription="";
		 this.longDescription="";
		 this.itemsInStock=0;
		 this.unitPrice=0;
	}

	public Product(String productCode, String name, String shortDescription, String longDescription, int itemsInStock,
			float unitPrice) {
		super();
		this.productCode = productCode;
		productName = name;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
		this.itemsInStock = itemsInStock;
		this.unitPrice = unitPrice;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getproductName() {
		return productName;
	}

	public void setproductName(String name) {
		productName = name;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	public int getItemsInStock() {
		return itemsInStock;
	}

	public void setItemsInStock(int itemsInStock) {
		this.itemsInStock = itemsInStock;
	}

	public float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}
    public void insertNewProduct() {
		
	}
	
	public void updateProductInfo(){
		
	}
	public void deleteProductInfo() {
		
	}
	


	@Override
	public String toString() {
		return "Product [productCode=" + productCode + ", Name=" + productName + ", shortDescription=" + shortDescription
				+ ", longDescription=" + longDescription + ", itemsInStock=" + itemsInStock + ", unitPrice=" + unitPrice
				+ "]";
	}
	
	
	 
	 


}
