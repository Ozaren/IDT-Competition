package gameOfLife.packageTracker.util;

import gameOfLife.packageTracker.shipping.updated.Event;

public class Calculator {
	public static double getSpeed(Event e1 , Event e2) {
		if(e1.getTime() > e2.getTime())
			return getDistance(e1.getLat() , e1.getLon() , e2.getLat() , e2.getLon()) / (e2.getTime() - e1.getTime());
		else
			return -1;
	}
	
	public static double getDistance(Event e1 , Event e2) {
		return getDistance(e1.getLat() , e1.getLon() , e2.getLat() , e2.getLon());
	}
	
	public static double getDistance(Event e1 , Event e2 , String unit) {
		return getDistance(e1.getLat() , e1.getLon() , e2.getLat() , e2.getLon() , unit);
	}
	
	//'M' is statute miles (default)                     
	//'K' is kilometers                                    
	//'N' is nautical miles
	public static double getDistance(double lat1 , double lon1 , double lat2 , double lon2 , String unit) {
		double theta = lon1 - lon2;
		double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist *= 60 * 1.1515;
		if(unit == "K") {
			dist *= 1.609344;
		}
		else if(unit == "N") {
			dist *= 0.8684;
		}
		return dist;
	}
	
	public static double getDistance(double lat1 , double lon1 , double lat2 , double lon2) {
		return getDistance(lat1 , lon1 , lat2 , lon2 , "M");
	}
	
	//convert decimal degrees to radians
	private static double deg2rad(double deg) {
		return(deg * Math.PI / 180.0);
	}
	
	//convert radians to decimal degrees
	private static double rad2deg(double rad) {
		return(rad * 180 / Math.PI);
	}
}
