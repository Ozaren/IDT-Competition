package gameOfLife.packageTracker.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.omg.PortableInterceptor.ORBInitInfoPackage.DuplicateName;

import gameOfLife.packageTracker.shipping.Point;
import gameOfLife.packageTracker.tracking.GPS;

public class GPXReader
{
   public static void main(String[] args) throws FileNotFoundException, XMLStreamException
   {
      load("E:\\Dropbox\\IDT\\Competition Info\\IDT_Winter_2016_Contest_Code\\gpx_files\\Annapolis_to_WestPoint_10sec.gpx");
   }
   
   private static XMLStreamReader reader;
   private static File            xmlfile;
   private static XMLInputFactory factory;
                                  
   public static GPS load(String xmlloc) throws FileNotFoundException, XMLStreamException
   {
      return load(new File(xmlloc));
   }
   
   private static GPS load(File file) throws FileNotFoundException, XMLStreamException
   {
      xmlfile = file;
      factory = XMLInputFactory.newFactory();
      return load();
   }
   
   private static class Tag
   {
      static String longtitude, latitude, timeStamp;
   }
   
   private static GPS load() throws FileNotFoundException, XMLStreamException
   {
      GPS gps = null;
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
                  case "name":
                     gps = new GPS(text);
                     break;
                  case "time":
                     Tag.timeStamp = text;
                     break;
                  case "trkpt":
                     try
                     {
                        gps.addPoint(new Point(Double.valueOf(Tag.latitude), Double.valueOf(Tag.longtitude), Tag.timeStamp));
                     }
                     catch(NumberFormatException | DuplicateName e)
                     {
                        e.printStackTrace();
                     }
                     break;
               }
               break;
         }
      }
      return gps;
   }
}
