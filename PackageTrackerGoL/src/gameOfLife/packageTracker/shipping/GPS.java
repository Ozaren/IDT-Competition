package gameOfLife.packageTracker.shipping;

import java.util.ArrayList;

public class GPS
{
   private ArrayList<Point> points, wayPoints;
   
   public GPS()
   {
      points = new ArrayList<>();
      wayPoints = new ArrayList<>();
   }
   
   public Point getPoint(int i)
   {
      return points.get(i);
   }
   
   public Point getWayPoint(int i)
   {
      return wayPoints.get(i);
   }
   
   public void addPoint(Point point)
   {
      points.add(point);
   }
   
   public void addWayPoint(Point point)
   {
      wayPoints.add(point);
   }
   
   @Override
   public String toString()
   {
      return "Points: " + points + "\nWayPoints: " + wayPoints;
   }
}
