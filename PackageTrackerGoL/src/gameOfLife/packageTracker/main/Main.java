package gameOfLife.packageTracker.main;

import gameOfLife.packageTracker.exceptions.InvalidUserNameException;
import gameOfLife.packageTracker.shipping.GPS;
import gameOfLife.packageTracker.shipping.Package;
import gameOfLife.packageTracker.shipping.User;

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
      User user = null;
      try
      {
         user = new User("Krishna", "Ozaren", "Password");
         Package pack = new Package(user, "Music CD", 153481438, new GPS());
         System.out.println(user + "\n");
         System.out.println(pack);
      }
      catch(InvalidUserNameException e)
      {
         e.printStackTrace();
         return;
      }
      
   }
}
