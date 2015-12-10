package gameOfLife.packageTracker.shipping;

/**
 * May be deleted
 * 
 * @author Krishna
 *         
 */
public class Point
{
   private double latitude, longtitude;
   private String timeStamp;
   
   public Point()
   {
      this(0, 0 , null);
   }
   
   public Point(double latitude, double longtitude , String timeStamp)
   {
      this.latitude = latitude;
      this.longtitude = longtitude;
      this.timeStamp = timeStamp;
   }
   
   public double getLatitude()
   {
      return latitude;
   }
   
   public double getLongtitude()
   {
      return longtitude;
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
      return String.format("%.3f %s  %.3f %s", Math.abs(latitude), latitude > 0 ? "E" : "W", Math.abs(longtitude), longtitude > 0 ? "N" : "S");
   }
}
