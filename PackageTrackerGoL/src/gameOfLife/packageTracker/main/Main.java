package gameOfLife.packageTracker.main;

import gameOfLife.packageTracker.exceptions.InvalidUserNameException;
import gameOfLife.packageTracker.shipping.User;

/**Main method only<br>
 * Starts the application
 * 
 * @author Krishna
 *
 */

public class Main {
	
	/**<b><i>Only</b></i> to start the application
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
	   User user = null;
	   try
      {
         user = new User("Krishna", "Ozaren", "Password");
         System.out.println(user);
      }
      catch(InvalidUserNameException e)
      {
         e.printStackTrace();
         return;
      }
	   
	}
}
