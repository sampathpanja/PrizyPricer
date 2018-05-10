package com.pp.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.pp.bo.ProductBo;
import com.pp.entities.Product;

@Service
@EnableTransactionManagement(proxyTargetClass = true)
public interface ProductService {

	@Transactional(readOnly = false)
	public int addProduct(ProductBo productBo);

	@Transactional(readOnly = false)
	public int updateProduct(ProductBo productBo);

	@Transactional(readOnly = true)
	public List<Product> getProducts();

	@Transactional(readOnly = true)
	public ProductBo getProduct(String barcode);

}
