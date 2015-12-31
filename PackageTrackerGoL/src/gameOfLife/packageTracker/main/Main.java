package gameOfLife.packageTracker.main;

import java.io.FileNotFoundException;

import javax.xml.stream.XMLStreamException;

import gameOfLife.packageTracker.exceptions.InvalidUserNameException;
import gameOfLife.packageTracker.shipping.Package;
import gameOfLife.packageTracker.shipping.User;
import gameOfLife.packageTracker.tracking.GPS;
import gameOfLife.packageTracker.util.GPXReader;

/**
 * Main method only<br>
 * Starts the application
 * 
 * @author Krishna
 *         
 */
public class Main
{
   /**
    * <b><i>Only</b></i> to start the application
    * 
    * @param args
    */
   public static void main(String[] args)
   {
      try
      {
         User user = new User("Krishna", "Ozaren", "Password");
         String gpxLocation = "E:\\Dropbox\\IDT\\Competition Info\\IDT_Winter_2016_Contest_Code\\gpx_files\\Annapolis_to_WestPoint_10sec.gpx";
         GPS gps = GPXReader.load(gpxLocation);
         Package pack = new Package(user, "Music CD", 153481438, gps);
         System.out.println(user + "\n");
         System.out.println(pack.getGps() + "\n");
         System.out.println(pack + "\n");
      }
      catch(InvalidUserNameException | FileNotFoundException | XMLStreamException e)
      {
         e.printStackTrace();
         return;
      }
   }
}
