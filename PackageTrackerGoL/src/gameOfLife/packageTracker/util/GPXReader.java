package gameOfLife.packageTracker.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Stack;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class GPXReader
{
   public static void main1(String[] args) throws FileNotFoundException, XMLStreamException
   {
      load("");
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
   
   public static class Point {
      public final double longtitude , latitude;
      public final String timeStamp;
      
      public Point(double longtitude , double latitude , String timeStamp)
      {
         this.latitude = latitude;
         this.longtitude = longtitude;
         this.timeStamp = timeStamp;
      }
   }
   
   private static class Tag
   {
      static String name , longtitude , latitude , timeStamp;
      static Stack<Point> points;
      static Stack<Point> wayPoints;
   }
   
   private static void load() throws FileNotFoundException, XMLStreamException
   {
      reader = factory.createXMLStreamReader(new FileInputStream(xmlfile));
      int event;
      String text = null;
      while(reader.hasNext())
      {
         event = reader.next();
         switch(event)
         {
            case XMLStreamConstants.START_ELEMENT:
               break;
            case XMLStreamConstants.CHARACTERS:
               text = reader.getText().trim();
               break;
            case XMLStreamConstants.END_ELEMENT:
               break;
         }
      }
   }
   
}
