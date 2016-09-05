package com.pan;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.pan.business.IProductService;
import com.pan.business.ProductServiceImpl;

@WebService
public class ProductCatalog {
	// can use spring inject later
	IProductService iProductService = new ProductServiceImpl();

	@WebMethod
	// you can annotate this or omit it, because every public method in
	// @webservice class are transfer to a web service method anyway
	public List<String> getProductCategories() {
		return iProductService.getProductCategories();
	}

	@WebMethod(exclude = true)//you can use this to disable the webservice
	public List<String> getProducts(String catagory) {
		return iProductService.getProducts(catagory);
	}

	@WebMethod(exclude = true)
	public boolean addProduct(String category, String product) {
		return iProductService.addProduct(category, product);
	}
}
