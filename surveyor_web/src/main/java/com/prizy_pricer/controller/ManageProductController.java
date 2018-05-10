package com.prizy_pricer.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.pp.bo.ProductBo;
import com.pp.entities.Product;
import com.pp.service.ProductService;
import com.prizy_pricer.command.ProductCommand;

@Controller
@EnableWebMvc
public class ManageProductController {

	@Autowired
	ProductService service;

	@ModelAttribute("products")
	public List<Product> getProducts() {
		return (List<Product>) service.getProducts();
	}

	@RequestMapping(path = "/product-list.htm", method = RequestMethod.GET)
	public String renderProductPage(Model model) {
		return "product-list";
	}

	@RequestMapping(path = "/update-product.htm", method = RequestMethod.GET)
	public String getProductForupdateing(Model model, @ModelAttribute("barcode") String barcode) {
		ProductBo productBo = service.getProduct(barcode);

		ProductCommand command = new ProductCommand(productBo.getProductId(), productBo.getBarcode(),
				productBo.getStore(), productBo.getDescription(), productBo.getNotes(), productBo.getPrices().get(3));

		model.addAttribute("product", command);

		return "update-product";
	}

	@RequestMapping(path = "/update-product.htm", method = RequestMethod.POST)
	public String updateProduct(Model model, @ModelAttribute("product") ProductCommand command) {

		List<Double> price = new ArrayList<>();
		price.add(command.getPrice());

		ProductBo productBo = new ProductBo(command.getProductId(), command.getBarcode(), command.getStore(),
				command.getDescription(), command.getNotes(), price);

		service.updateProduct(productBo);

		ProductBo productBo2 = service.getProduct(command.getBarcode());

		ProductCommand command2 = new ProductCommand(productBo2.getProductId(), productBo2.getBarcode(),
				productBo2.getStore(), productBo2.getDescription(), productBo2.getNotes(),
				productBo2.getPrices().get(3));

		model.addAttribute("product", command2);

		return "modified-product-details";
	}

}
