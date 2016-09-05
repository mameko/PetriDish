package com.pan.business;

import java.util.List;

import com.pan.model.Product;

public interface IProductService {
	public List<String> getProductCategories();
	public List<String> getProducts(String catagory);
	public boolean addProduct(String category, String product);
	public List<Product> getProductsv2(String catagory);
}
