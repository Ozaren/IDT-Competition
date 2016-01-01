package gameOfLife.packageTracker.util;

import gameOfLife.packageTracker.shipping.Point;

public class Utilities
{
   public static ConvertDistance convertDistance = ConvertDistance.METER;
   public static ConvertTime     convertTime     = ConvertTime.SECOND;
                                                 
   public static double measureDistance(Point p1, Point p2)
   {
      return measureDistance(p1.getLatitude(), p1.getLongtitude(), p2.getLatitude(), p2.getLongtitude());
   }
   
   public static double measureSpeed(Point p1, Point p2)
   {
      double dt = p1.getTimeStamp().toMillisecondsSeconds() - p2.getTimeStamp().toMillisecondsSeconds();
      dt /= convertTime.convert;
      return Math.abs(measureDistance(p1.getLatitude(), p1.getLongtitude(), p2.getLatitude(), p2.getLongtitude()) / dt);
   }
   
   public static double measureDistance(double lat1, double lon1, double lat2, double lon2)
   {
      double R = 6378.137; // Radius of earth in KM
      double dLat = (lat2 - lat1) * Math.PI / 180;
      double dLon = (lon2 - lon1) * Math.PI / 180;
      double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.cos(lat1 * Math.PI / 180) * Math.cos(lat2 * Math.PI / 180) * Math.sin(dLon / 2) * Math.sin(dLon / 2);
      double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
      double d = R * c;
      return d * 1000 * convertDistance.convert;
   }
   
   public static enum ConvertDistance
   {
      METER(1) , KILOMETER(1 / 1000.0) , MILE(0.000621371);
      public final double convert;
      
      private ConvertDistance(double convert)
      {
         this.convert = convert;
      }
   }
   
   public static enum ConvertTime
   {
      MILLISECOND(1) , SECOND(1000.0 * MILLISECOND.convert) , MINUTE(60 * SECOND.convert) , HOUR(60 * MINUTE.convert);
      public final double convert;
      
      private ConvertTime(double convert)
      {
         this.convert = convert;
      }
   }
}
