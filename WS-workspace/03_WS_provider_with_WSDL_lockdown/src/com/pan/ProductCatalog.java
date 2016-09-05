package com.pan;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.pan.business.IProductService;
import com.pan.business.ProductServiceImpl;

/**
 * in real world, we will use a class to generate that WSDL first After we
 * decided what name we should use, we will lock it down and modify our java
 * class to fit it
 */

@WebService(name = "MyCatalog", portName = "MyCataloPort", serviceName = "MyCatalogService", targetNamespace="http://pan.com.test")
public class ProductCatalog {
	// can use spring inject later
	IProductService iProductService = new ProductServiceImpl();

	@WebMethod(action="fetch___", operationName="fetch_categories")
	// you can annotate this or omit it, because every public method in
	// @webservice class are transfer to a web service method anyway
	public List<String> getProductCategories() {
		return iProductService.getProductCategories();
	}

	@WebMethod(exclude = true)
	// you can use this to disable the webservice
	public List<String> getProducts(String catagory) {
		return iProductService.getProducts(catagory);
	}

	@WebMethod(exclude = true)
	public boolean addProduct(String category, String product) {
		return iProductService.addProduct(category, product);
	}
}
