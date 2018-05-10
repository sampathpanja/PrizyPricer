package com.pp.bo;

import java.util.List;

public class ProductBo {
	protected int productId;
	protected String barcode;
	protected String store;
	protected String description;
	protected String notes;
	protected List<Double> prices;

	public ProductBo() {
		super();
	}

	public ProductBo(int productId, String barcode, String store, String description, String notes,
			List<Double> prices) {
		super();
		this.productId = productId;
		this.barcode = barcode;
		this.store = store;
		this.description = description;
		this.notes = notes;
		this.prices = prices;
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

	public List<Double> getPrices() {
		return prices;
	}

	public void setPrices(List<Double> prices) {
		this.prices = prices;
	}

}
