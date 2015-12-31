package gameOfLife.packageTracker.tracking;

import java.util.ArrayList;

import org.omg.PortableInterceptor.ORBInitInfoPackage.DuplicateName;

import gameOfLife.packageTracker.shipping.Point;

public class GPS
{
   private static long nextID = 0;
   public final long id;
   public final String name;
   private ArrayList<Point> points, wayPoints;
   
   public GPS(String name)
   {
      id = ++nextID;
      points = new ArrayList<>();
      wayPoints = new ArrayList<>();
      this.name = name;
   }
   
   public Point getPoint(int i)
   {
      return points.get(i);
   }
   
   public Point getWayPoint(int i)
   {
      return wayPoints.get(i);
   }
   
   public void addPoint(Point point) throws DuplicateName
   {
      if(points.contains(point.getTimeStamp()))
         throw new DuplicateName("Duplicate Time Stamp");
      if(points.size() > 0 && point.getTimeStamp().compareTo(points.get(points.size() - 1).getTimeStamp()) < 0)
         throw new IllegalArgumentException("Invalid Time Stamp");
      points.add(point);
   }
   
   public void addWayPoint(Point point) throws DuplicateName
   {
      if(wayPoints.contains(point.getTimeStamp()))
         throw new DuplicateName("Duplicate Time Stamp");
      if(wayPoints.size() > 0 && point.getTimeStamp().compareTo(wayPoints.get(wayPoints.size() - 1).getTimeStamp()) < 0)
         throw new IllegalArgumentException("Invalid Time Stamp");
      wayPoints.add(point);
   }
   
   @Override
   public String toString()
   {
      return "GPS " + id + ":\nName: " + name + "\nNumber of Points: " + points.size() + "\nNumber of Way Points: " + wayPoints.size();
   }
}
