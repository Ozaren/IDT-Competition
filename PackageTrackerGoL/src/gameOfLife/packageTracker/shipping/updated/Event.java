package gameOfLife.packageTracker.shipping.updated;

import java.time.ZonedDateTime;
//import com.fasterxml.jackson.annotation.JsonFilter;
//import com.google.common.base.Objects;

//@JsonFilter("eventFilter")
public class Event
{
   public final PackageData packageData;
   private String           name;
   private String           uuid;
   private long             time;
   private double           lat;
   private double           lon;
   private int              ele;
   
   public Event(PackageData packageData)
   {
      this.packageData = packageData;
   }
   
   public Event(PackageData packageData, double lat, double lon)
   {
      this(packageData, lat, lon, 0, null);
   }
   
   public Event(PackageData packageData, double lat, double lon, int ele, ZonedDateTime dateTime)
   {
      this.lat = lat;
      this.lon = lon;
      this.ele = ele;
      this.packageData = packageData;
      if(dateTime != null)
         this.time = dateTime.toEpochSecond() * 1000 + dateTime.getNano() / 1000000;
   }
   
   public boolean isNewPackage()
   {
      if(name != null)
         return true;
      else
         return false;
   }
   
   public String getName()
   {
      return name;
   }
   
   public void setName(String name)
   {
      this.name = name;
   }
   
   public String getUuid()
   {
      return uuid;
   }
   
   public void setUuid(String uuid)
   {
      this.uuid = uuid;
   }
   
   public double getLat()
   {
      return lat;
   }
   
   public void setLat(double lat)
   {
      this.lat = lat;
   }
   
   public double getLon()
   {
      return lon;
   }
   
   public void setLon(double lon)
   {
      this.lon = lon;
   }
   
   public int getEle()
   {
      return ele;
   }
   
   public void setEle(int ele)
   {
      this.ele = ele;
   }
   
   public long getTime()
   {
      return time;
   }
   
   public void setTime(int time)
   {
      this.time = time;
   }
//	@Override
//	public String toString() {
//		return Objects.toStringHelper(this).add("name" , name).add("uuid" , uuid).add("lat" , lat).add("lon" , lon).add("ele" , ele).add("time" , time).add("status" , status).add("delivered" , delivered).toString();
//	}
}
