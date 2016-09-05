package com.pan;

import java.util.List;

import javax.jws.WebService;

import com.pan.business.IProductService;
import com.pan.business.ProductServiceImpl;
import com.pan.model.Product;

/**
 * in real world, we will use a class to generate that WSDL first After we
 * decided what name we should use, we will lock it down and modify our java
 * class to fit it
 */


@WebService(portName = "MyCataloPort", serviceName = "MyCatalogService", endpointInterface = "com.pan.ProductCatalogInterface")
// this specify what the SEI is, we only need this in this class in the old days
public class ProductCatalog implements ProductCatalogInterface {
	IProductService iProductService = new ProductServiceImpl();

	
	public List<String> getProductCategories() {
		return iProductService.getProductCategories();
	}


	public List<String> getProducts(String catagory) {
		return iProductService.getProducts(catagory);
	}

	public boolean addProduct(String category, String product) {
		return iProductService.addProduct(category, product);
	}

	public List<Product> getProductsv2(String catagory) {
		return iProductService.getProductsv2(catagory);
	}

}
