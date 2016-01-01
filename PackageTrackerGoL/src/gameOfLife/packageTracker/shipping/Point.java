package gameOfLife.packageTracker.shipping;

import gameOfLife.packageTracker.tracking.TimeStamp;

/**
 * May be deleted
 * 
 * @author Krishna
 *         
 */
public class Point
{
   private double    latitude, longtitude, elevation;
   private TimeStamp timeStamp;
                     
   public Point()
   {
      this(0, 0, 0, null);
   }
   
   public Point(double latitude, double longtitude, double elevation, String timeStamp)
   {
      this.latitude = latitude;
      this.longtitude = longtitude;
      this.elevation = elevation;
      this.timeStamp = new TimeStamp(timeStamp);
   }
   
   public double getLatitude()
   {
      return latitude;
   }
   
   public double getLongtitude()
   {
      return longtitude;
   }
   
   public double getElevation()
   {
      return elevation;
   }
   
   public TimeStamp getTimeStamp()
   {
      return timeStamp;
   }
   
   public void setLatitude(double latitude)
   {
      this.latitude = latitude;
   }
   
   public void setLongtitude(double longtitude)
   {
      this.longtitude = longtitude;
   }
   
   @Override
   public String toString()
   {
      return String.format("Location: %.3f %s  %.3f %s\tElevation: %.0f\tT-%s", Math.abs(latitude), latitude > 0 ? "E" : "W", Math.abs(longtitude), longtitude > 0 ? "N" : "S", elevation, timeStamp);
   }

   public double getDistance(Point last)
   {
      double dx , dy , dz;
      dx = longtitude - last.longtitude;
      dy = latitude - last.latitude;
      dz = elevation - last.elevation;
      return Math.sqrt(dx * dx + dy * dy + dz * dz);
   }
}
