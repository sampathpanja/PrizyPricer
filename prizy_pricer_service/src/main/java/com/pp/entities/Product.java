package com.pp.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	protected int productId;
	@Column(name = "barcode")
	protected String barcode;
	@Column(name = "store_id")
	protected String storeId;
	@Column(name = "description")
	protected String description;
	@Column(name = "notes")
	protected String notes;
	@Column(name = "all_prices")
	protected String allPrices;

	// many to many extra columns
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pk.product", fetch = FetchType.LAZY)
	protected Set<ProductStore> productStore = new HashSet<ProductStore>();

	public Set<ProductStore> getProductStore() {
		return productStore;
	}

	public void setProductStore(Set<ProductStore> productStore) {
		this.productStore = productStore;
	}

	public Product() {
		super();
	}

	public Product(int productId, String barcode, String storeId, String description, String notes, String allPrices) {
		super();
		this.productId = productId;
		this.barcode = barcode;
		this.storeId = storeId;
		this.description = description;
		this.notes = notes;
		this.allPrices = allPrices;
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

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
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

	public String getAllPrices() {
		return allPrices;
	}

	public void setAllPrices(String allPrices) {
		this.allPrices = allPrices;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", barcode=" + barcode + ", storeId=" + storeId + ", description="
				+ description + ", notes=" + notes + ", allPrices=" + allPrices + ", productStore=" + productStore
				+ "]";
	}

}
