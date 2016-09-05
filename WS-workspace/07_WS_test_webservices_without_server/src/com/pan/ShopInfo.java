package com.pan;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
public class ShopInfo {
	
	@WebMethod
	@WebResult(partName="lookupOutput")//specify the name you want for the output
	public String getShopInfo(@WebParam(partName="lookupInput") String property) {//specify the name you want for the input
		String response = "Invalid Property";
		if ("shopName".equals(property)) {
			response = "Pan's awesome shop";
		} else if ("since".equals(property)) {
			response = "2014";
		}
		return response;
	}
}
