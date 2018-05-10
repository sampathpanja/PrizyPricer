package com.pp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.pp.entities.Product;
import com.pp.entities.ProductStore;
import com.pp.entities.ProductStorePK;
import com.pp.entities.Store;

@Repository
public class ProductDao {
	private final String GET_PRODUCTS = "select new com.pp.entities.Product(p.productId, p.barcode, p.storeId, p.description, p.notes, p.allPrices) from Product as p";
	private final String GET_PRODUCT = "select new com.pp.entities.Product(p.productId, p.barcode, p.storeId, p.description, p.notes, p.allPrices) from Product as p where p.barcode = :barcode";
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@SuppressWarnings("unchecked")
	public List<Product> getProducts() {

		Session session = hibernateTemplate.getSessionFactory().openSession();

		Query<Product> query = session.createQuery(GET_PRODUCTS);

		List<Product> products = query.list();

		return products;
	}

	@SuppressWarnings("unchecked")
	public Product getProduct(String barcode) {
		Product product = new Product();

		Session session = hibernateTemplate.getSessionFactory().openSession();

		Query<Product> query = session.createQuery(GET_PRODUCT);
		query.setParameter("barcode", barcode);

		List<Product> products = query.list();

		product = (Product) products.get(0);

		return product;

	}

	@SuppressWarnings("unchecked")
	public int updateProduct(Product product) {
		String SQL_UPDATE_PRODUCT = "update Product set storeId=:storeId, description=:description, notes=:notes, allPrices=:allPrices where barcode=:barcode";

		Session session = hibernateTemplate.getSessionFactory().openSession();
		int executeUpdate;

		Transaction tx = null;
		Query<Integer> query = null;
		boolean flag = false;
		try {
			session = hibernateTemplate.getSessionFactory().openSession();
			tx = session.beginTransaction();
			query = session.createQuery(SQL_UPDATE_PRODUCT);
			query.setParameter("barcode", product.getBarcode());

			query.setParameter("storeId", product.getStoreId());
			query.setParameter("description", product.getDescription());
			query.setParameter("notes", product.getNotes());
			query.setParameter("allPrices", product.getAllPrices());

			executeUpdate = query.executeUpdate();

			flag = true;
		} finally {
			if (tx != null) {
				if (flag) {
					tx.commit();
				} else {
					tx.rollback();
				}
			}
		}
		return executeUpdate;
	}

	public int addProduct(Product product) {

		Store store = new Store(Integer.parseInt(product.getStoreId()), product.getStoreId());
		hibernateTemplate.save(store);

		int insertedProductNo = (int) hibernateTemplate.save(product);
		
		ProductStore productStore = new ProductStore();
		Double price = Double.parseDouble(product.getAllPrices().split("-")[0]);
		ProductStorePK pk= new ProductStorePK();
		pk.setProduct(product);
		pk.setStore(store);
		productStore.setPk(pk);
		productStore.setProduct(product);
		productStore.setStore(store);
		productStore.setPrice(price);
		productStore.setQuality(product.getNotes());
		hibernateTemplate.save(productStore);

		return insertedProductNo;
	}

}
