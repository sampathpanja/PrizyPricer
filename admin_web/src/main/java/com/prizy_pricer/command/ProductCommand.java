package com.prizy_pricer.command;

public class ProductCommand {
	protected int productId;
	protected String barcode;
	protected String store;
	protected String description;
	protected String notes;
	protected double price;

	public ProductCommand() {
		super();
	}

	public ProductCommand(int productId, String barcode, String store, String description, String notes, double price) {
		super();
		this.productId = productId;
		this.barcode = barcode;
		this.store = store;
		this.description = description;
		this.notes = notes;
		this.price = price;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProductCommand [productId=" + productId + ", barcode=" + barcode + ", store=" + store + ", description="
				+ description + ", notes=" + notes + ", price=" + price + "]";
	}

}
