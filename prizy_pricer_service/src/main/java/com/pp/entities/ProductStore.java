package com.pp.entities;

import java.io.Serializable;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "product_store")
@AssociationOverrides({ @AssociationOverride(name = "pk.product", joinColumns = @JoinColumn(name = "product_id")),
		@AssociationOverride(name = "pk.store", joinColumns = @JoinColumn(name = "store_id")) })
public class ProductStore implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "price")
	protected double price;
	@Column(name = "quality")
	protected String quality;

	@EmbeddedId
	ProductStorePK pk = new ProductStorePK();

	// protected Product product;
	// protected Store store;

	public ProductStorePK getPk() {
		return pk;
	}

	public void setPk(ProductStorePK pk) {
		this.pk = pk;
	}

	public Product getProduct() {
		return getPk().getProduct();
	}

	public void setProduct(Product product) {
		getPk().setProduct(product);
	}

	public Store getStore() {
		return getPk().getStore();
	}

	public void setStore(Store store) {
		getPk().setStore(store);
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getQuality() {
		return quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}

	@Override
	public String toString() {
		return "ProductStore [price=" + price + ", quality=" + quality + ", pk=" + pk + "]";
	}

}
