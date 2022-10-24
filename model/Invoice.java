package model;

public class Invoice
{
	private int invoiceNum;
	private Date billingDate;
	private String item;
	private int itemQuantity;
	private String cashier;
	private String customer;
	
	//Default Constructor
	public Invoice()
	{
		invoiceNum = 0;
		billingDate = new Date();
		item = "";
		itemQuantity = 0;
		cashier = "";
		customer = "";
	}

	//Primary Constructor
	public Invoice(int invoiceNum, Date billingDate, String item, int itemQuantity, String cashier, String customer) 
	{
		this.invoiceNum = invoiceNum;
		this.billingDate = billingDate;
		this.item = item;
		this.itemQuantity = itemQuantity;
		this.cashier = cashier;
		this.customer = customer;
	}

	public int getInvoiceNum()
	{
		return invoiceNum;
	}

	public void setInvoiceNum(int invoiceNum) 
	{
		this.invoiceNum = invoiceNum;
	}

	public Date getBillingDate()
	{
		return billingDate;
	}

	public void setBillingDate(Date billingDate) 
	{
		this.billingDate = billingDate;
	}

	public String getItem() 
	{
		return item;
	}

	public void setItem(String item) 
	{
		this.item = item;
	}

	public int getItemQuantity() 
	{
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) 
	{
		this.itemQuantity = itemQuantity;
	}

	public String getCashier() 
	{
		return cashier;
	}

	public void setCashier(String cashier) 
	{
		this.cashier = cashier;
	}

	public String getCustomer() 
	{
		return customer;
	}

	public void setCustomer(String customer) 
	{
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Invoice [invoiceNum=" + invoiceNum + ", billingDate=" + billingDate + ", item=" + item
				+ ", itemQuantity=" + itemQuantity + ", cashier=" + cashier + ", customer=" + customer + "]";
	}
	
	
	
	
	
}
