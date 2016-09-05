package com.pan.business;

import java.util.List;

public interface IProductService {
	public List<String> getProductCategories();
	public List<String> getProducts(String catagory);
	public boolean addProduct(String category, String product);
}
