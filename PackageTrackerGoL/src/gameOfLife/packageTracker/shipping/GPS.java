package gameOfLife.packageTracker.shipping;

/**
 * May be deleted
 * 
 * @author Krishna
 *         
 */
public class GPS
{
   private double latitude , longtitude;
   
   public GPS()
   {
      this(0 , 0);
   }
   
   public GPS(double latitude , double longtitude)
   {
      this.latitude = latitude;
      this.longtitude = longtitude;
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
      return String.format("%.3f %s  %.3f %s" , Math.abs(latitude) ,
            latitude > 0 ? "E" : "W" , Math.abs(longtitude) , longtitude > 0 ? "N" : "S");
   }
}
