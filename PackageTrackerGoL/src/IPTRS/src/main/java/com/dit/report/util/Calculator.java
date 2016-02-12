package com.dit.report.util;

import com.dit.report.domain.Event; //KS code
import java.util.*;
import java.lang.*;
import java.util.concurrent.TimeUnit;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

 
public class Calculator {
    
	//KS start
	public static double getDistance(Event e1 , Event e2) {
		return getDistance(e1.getLat() , e1.getLon() , e2.getLat() , e2.getLon(), "M");
	}
	
	public static double getDistance(Event e1 , Event e2 , String unit) {
		return getDistance(e1.getLat() , e1.getLon() , e2.getLat() , e2.getLon() , unit);
	}
	//KS end
	
               //'M' is statute miles (default)                     
               //'K' is kilometers                                    
               //'N' is nautical miles                                
               public static double getDistance(double lat1, double lon1, double lat2, double lon2, String unit){
                              double theta = lon1 - lon2;
                              double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
                              dist = Math.acos(dist);
                              dist = rad2deg(dist);
                              dist = dist * 60 * 1.1515;
                              if (unit == "K") {
                                             dist = dist * 1.609344;
                              } else if (unit == "N") {
                                             dist = dist * 0.8684;
                              }
 
                              return (dist);
 
               }
               
               public static Long getEventInterval(String time1, String time2){
            	   //DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZZZ");
            	   DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            	   //Long tIntervalInMS = null;
            	   Long tInterval = null;
				try {
					Date pDate = df.parse(time1.substring(0,19));
					Date cDate = df.parse(time2.substring(0,19));
					tInterval = cDate.getTime() - pDate.getTime(); //interval in MILLISECONDS
					//tInterval = TimeUnit.MILLISECONDS.toSeconds(tInterval);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	   return tInterval;
               }               
             
               public static String getEstimatedDTime(String cTime, long duration){
            	   //DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZZZ");
            	   DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            	   String strEstimatedDTime ="";
   				try {					
					Date cDate = df.parse(cTime.substring(0,19));
					Date estimatedDTime = new Date(cDate.getTime() + duration);
					strEstimatedDTime = df.format(estimatedDTime);					
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	   return strEstimatedDTime;
               }                       
               
               
               
               //convert decimal degrees to radians
               private static double deg2rad(double deg) {
                              return (deg * Math.PI / 180.0);
               }
 
 
               //convert radians to decimal degrees
               private static double rad2deg(double rad) {
                              return (rad * 180 / Math.PI);
               }
 
              
}