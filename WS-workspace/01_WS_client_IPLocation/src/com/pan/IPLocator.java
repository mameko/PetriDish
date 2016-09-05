package com.pan;

import net.webservicex.GeoIP;
import net.webservicex.GeoIPService;
import net.webservicex.GeoIPServiceSoap;

public class IPLocator {

	public static void main(String[] args) {
//		String ipAddr = "74.125.239.142";
		String ipAddr = "212.58.246.104";
		GeoIPService goIp = new GeoIPService();
		GeoIPServiceSoap gosoap = goIp.getGeoIPServiceSoap();
		GeoIP geoIP = gosoap.getGeoIP(ipAddr);
		System.out.println(geoIP.getCountryName());
	}

}
