package com.pan;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.pan.model.Product;

//in the old days we make an interface and annotate it instead of the real class (this is called SEI too)

@WebService(name = "MyCatalog", targetNamespace = "http://pan.com.test")
public interface ProductCatalogInterface {

	@WebMethod(action = "fetch___", operationName = "fetch_categories")
	public abstract List<String> getProductCategories();
	@WebMethod
	public abstract List<String> getProducts(String catagory);
	@WebMethod
	public abstract boolean addProduct(String category, String product);
	@WebMethod
	@WebResult(name="Product")
	public abstract List<Product> getProductsv2(String catagory);

}