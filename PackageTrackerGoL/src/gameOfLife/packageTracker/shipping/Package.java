package gameOfLife.packageTracker.shipping;

/**
 * A package
 * 
 */

public class Package
{
   private User   owner;
   private GPS    gps;
   private String item;
   private final long   id;
                  
   public Package(User owner, String item, long id)
   {
      this(owner, item, id, null);
   }
   
   public Package(User owner, String item, long id, GPS gps)
   {
      this.owner = owner;
      this.id = id;
      this.item = item;
      this.gps = gps;
   }
   
   public GPS getGps()
   {
      return gps;
   }
   
   public long getId()
   {
      return id;
   }
   
   public String getItem()
   {
      return item;
   }
   
   public User getOwner()
   {
      return owner;
   }
   
   @Override
   public String toString()
   {
      return super.toString();
   }
   
   @Override
   public boolean equals(Object obj)
   {
      if(obj instanceof Package)
      {
         Package other = (Package) obj;
         boolean gpstest = true;
         if(gps != null)
            gpstest = gps.equals(other.gps);
         return id == other.id && owner.equals(other.owner) && item.equals(other.item) && gpstest;
      }
      else
      {
         return false;
      }
   }
}
