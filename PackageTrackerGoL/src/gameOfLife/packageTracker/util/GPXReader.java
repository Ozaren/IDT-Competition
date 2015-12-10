package gameOfLife.packageTracker.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Stack;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import gameOfLife.packageTracker.shipping.Point;

public class GPXReader
{
   public static void main(String[] args) throws FileNotFoundException, XMLStreamException
   {
      load("C:\\Users\\Krishna\\Desktop\\testGPX.gpx");
   }
   
   private static XMLStreamReader reader;
   private static File            xmlfile;
   private static XMLInputFactory factory;
                                  
   public static void load(String xmlloc) throws FileNotFoundException, XMLStreamException
   {
      load(new File(xmlloc));
   }
   
   private static void load(File file) throws FileNotFoundException, XMLStreamException
   {
      xmlfile = file;
      factory = XMLInputFactory.newFactory();
      load();
   }
   
   public static class Point
   {
      public final double longtitude, latitude;
      public final String timeStamp;
                          
      public Point(double longtitude, double latitude, String timeStamp)
      {
         this.latitude = latitude;
         this.longtitude = longtitude;
         this.timeStamp = timeStamp;
      }
   }
   
   private static class Tag
   {
      static String       longtitude, latitude, timeStamp;
      static Stack<Point> points;
      static Stack<Point> wayPoints;
                          
      public static void printAll()
      {
         System.out.println("Longtitude: " + longtitude);
         System.out.println("Latitude: " + latitude);
         System.out.println("Time Stamp: " + timeStamp);
         System.out.println("Points: " + points);
         System.out.println("Way Points: " + wayPoints);
      }
   }
   
   private static void load() throws FileNotFoundException, XMLStreamException
   {
      Point gps;
      reader = factory.createXMLStreamReader(new FileInputStream(xmlfile));
      int event;
      String text = null;
      while(reader.hasNext())
      {
         event = reader.next();
         switch(event)
         {
            case XMLStreamConstants.START_ELEMENT:
               Tag.timeStamp = null;
               switch(reader.getLocalName())
               {
                  case "gpx":
                     Tag.points = new Stack<>();
                     Tag.wayPoints = new Stack<>();
                     break;
                  case "trkpt":
                  case "wpt":
                     for(int i = 0; i < reader.getAttributeCount(); i++)
                     {
                        text = reader.getAttributeValue(i);
                        switch(reader.getAttributeLocalName(i))
                        {
                           case "lat":
                              Tag.latitude = text;
                              break;
                           case "lon":
                              Tag.longtitude = text;
                              break;
                        }
                     }
                     break;
               }
               break;
            case XMLStreamConstants.CHARACTERS:
               text = reader.getText().trim();
               break;
            case XMLStreamConstants.END_ELEMENT:
               switch(reader.getLocalName())
               {
                  case "trkpt":
                     Tag.timeStamp = text;
                     break;
               }
               Tag.printAll();
               System.out.println();
               break;
         }
      }
   }
}
