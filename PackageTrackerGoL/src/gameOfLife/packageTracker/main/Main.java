package gameOfLife.packageTracker.main;

import static gameOfLife.packageTracker.util.Utilities.convertDistance;
import static gameOfLife.packageTracker.util.Utilities.convertTime;

import java.io.FileNotFoundException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.UUID;

import javax.xml.stream.XMLStreamException;

import gameOfLife.packageTracker.exceptions.InvalidUserNameException;
import gameOfLife.packageTracker.shipping.Package;
import gameOfLife.packageTracker.shipping.User;
import gameOfLife.packageTracker.tracking.GPS;
import gameOfLife.packageTracker.util.GPXReader;
import gameOfLife.packageTracker.util.Utilities.ConvertDistance;
import gameOfLife.packageTracker.util.Utilities.ConvertTime;
import gameOfLife.packageTracker.util.ui.guiComputer.PackageTrackerFrame;

/**
 * Main method only<br>
 * Starts the application. Currently implements a test User and test GPS files
 *
 * @author Krishna
 */
public class Main
{
   /**
    * <b><i>Only</b></i> to start the application.
    *
    * @param args the arguments
    */
   public static void main(String[] args) throws SocketException, UnknownHostException
   {
      byte[] byteMac;
      Enumeration<NetworkInterface> enumeration = NetworkInterface.getNetworkInterfaces();
      do
      {
         NetworkInterface networkInterface = enumeration.nextElement();
         byteMac = networkInterface.getHardwareAddress();
      } while(byteMac == null && enumeration.hasMoreElements());
      UUID uuid2 = UUID.nameUUIDFromBytes(byteMac);
      NetworkInterface inter = NetworkInterface.getByInetAddress(InetAddress.getLocalHost());
      UUID uuid1 = UUID.nameUUIDFromBytes(inter.getHardwareAddress());
      System.out.println(new java.rmi.dgc.VMID().toString());
      new PackageTrackerFrame();
      try
      {
         User user = new User("Krishna", "Ozaren", "Password");
//       for the gpx files, if you want to test other ones just put in the name of the file instead of the <name>.gpx
         String gpxLocation = "..\\..\\..\\..\\gpx_files\\Annapolis_to_WestPoint_10sec.gpx";
         GPS gps = GPXReader.load(gpxLocation);
         Package pack = new Package(user, "Music CD", 153481438, gps);
         convertDistance = ConvertDistance.MILE;// from Utilities
         convertTime = ConvertTime.HOUR;// from Utilities
         for(double d : pack.getGps().getSpeeds())
         {
            System.out.printf("%8.5f\n", d);
         }
      }
      catch(InvalidUserNameException | FileNotFoundException | XMLStreamException e)
      {
         e.printStackTrace();
         return;
      }
   }
}
