package com.pp.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.pp.bo.ProductBo;
import com.pp.dao.ProductDao;
import com.pp.entities.Product;

@Service
@EnableTransactionManagement(proxyTargetClass = true)
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao dao;

	public int addProduct(ProductBo productBo) {

		List<Double> prices = productBo.getPrices();
		Double price = prices.get(0);

		StringBuilder builder = new StringBuilder();
		builder.append(price).append("-").append(productBo.getStore());

		int barNumber = (int) (Math.random() * 100_00_00_000 + 1);
		String barcode = barNumber + "";

		Product product = new Product(productBo.getProductId(), barcode, productBo.getStore(),
				productBo.getDescription(), productBo.getNotes(), builder.toString());

		return dao.addProduct(product);
	}

	public int updateProduct(ProductBo productBo) {

		String allPrices = dao.getProduct(productBo.getBarcode()).getAllPrices();

		StringBuilder builder = new StringBuilder();
		builder.append(allPrices).append(",").append(productBo.getPrices().get(0)).append("-")
				.append(productBo.getStore());

		Product product = new Product(productBo.getProductId(), productBo.getBarcode(), productBo.getStore(),
				productBo.getDescription(), productBo.getNotes(), builder.toString());

		return dao.updateProduct(product);
	}

	public List<Product> getProducts() {
		return dao.getProducts();
	}

	public ProductBo getProduct(String barcode) {

		Product product = dao.getProduct(barcode);
		String price_store_string = product.getAllPrices();

		ProductBo bo = null;

		Double avgPrice = 0.0, lowest = 0.0, higest = 0.0, idealprice = 0.0, sum = 0.0;
		int i = 0;
		List<Double> prices = new ArrayList<Double>();

		String[] allPricesWithStores = price_store_string.split(",");

		if (allPricesWithStores.length > 1) {

			Map<Double, String> allPricesWithStoresMap = new TreeMap<>();
			for (String string : allPricesWithStores) {
				allPricesWithStoresMap.put(Double.parseDouble(string.split("-")[0]), string.split("-")[1]);
			}

			@SuppressWarnings("unused")
			Collection<String> stores = allPricesWithStoresMap.values();

			Set<Double> pricesSet = allPricesWithStoresMap.keySet();

			Double[] pricesArray = new Double[pricesSet.size()];

			for (Iterator<Double> iterator2 = pricesSet.iterator(); iterator2.hasNext();) {
				Double double1 = (Double) iterator2.next();
				pricesArray[i++] = double1;
			}

			for (Double price : pricesArray) {
				sum += price;
			}

			avgPrice = (sum / pricesSet.size());

			prices.add(avgPrice);

			lowest = pricesArray[0];
			prices.add(lowest);

			int priceCount = pricesArray.length;

			higest = (priceCount >= 2) ? pricesArray[pricesArray.length - 1] : pricesArray[0];
			prices.add(higest);

			idealprice = (priceCount >= 5)
					? ((((sum - (pricesArray[0] + pricesArray[1] + pricesArray[priceCount - 2]
							+ pricesArray[priceCount - 1])) / (priceCount - 4)) * 120) / 100)
					: (sum / priceCount);

			prices.add(idealprice);

		} else {
			for (int j = 0; j < 4; j++) {
				prices.add(Double.parseDouble(allPricesWithStores[0].split("-")[0]));
			}
		}

		bo = new ProductBo(product.getProductId(), product.getBarcode(), product.getStoreId(), product.getDescription(),
				product.getNotes(), prices);

		return bo;
	}

}
