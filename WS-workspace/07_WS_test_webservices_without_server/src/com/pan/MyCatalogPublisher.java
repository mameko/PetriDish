package com.pan;

import javax.xml.ws.Endpoint;

public class MyCatalogPublisher {
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:1234/mycatalogtest", new ProductCatalog());
	}
}
