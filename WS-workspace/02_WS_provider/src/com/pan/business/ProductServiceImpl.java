package com.pan.business;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements IProductService {
	// not using database, inplug some hard coded dummy data
	List<String> booklist = new ArrayList<String>();
	List<String> musiclist = new ArrayList<String>();
	List<String> movielist = new ArrayList<String>();

	public ProductServiceImpl() {
		booklist.add("book 1");
		booklist.add("book 2");
		booklist.add("book 3");

		musiclist.add("music 1");
		musiclist.add("music 2");
		musiclist.add("music 3");

		movielist.add("movie 1");
		movielist.add("movie 2");
		movielist.add("movie 3");
	}

	@Override
	public List<String> getProductCategories() {
		List<String> catagories = new ArrayList<String>();
		catagories.add("Books");
		catagories.add("Music");
		catagories.add("Movies");
		return catagories;
	}

	public List<String> getProducts(String catagory) {
		switch (catagory) {
		case "books":
			return booklist;
		case "musics":
			return musiclist;
		case "movies":
			return movielist;
		default:
			return null;
		}
	}

	public boolean addProduct(String category, String product) {
		switch (category) {
		case "books":
			booklist.add(product);
			return true;
		case "musics":
			musiclist.add(product);
			return true;
		case "movies":
			movielist.add(product);
			return true;
		default:
			return false;
		}
	}
}
