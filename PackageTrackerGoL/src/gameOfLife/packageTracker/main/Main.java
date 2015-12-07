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
         user = new User("Krishna", "Ozareb", "Password");
      }
      catch(InvalidUserNameException e)
      {
         e.printStackTrace();
         return;
      }
	   System.out.println(user.getPassword());
	   user.encryptPassword();
	   System.out.println(user.getPassword());
      user.decryptPassword();
	   System.out.println(user.getPassword());
	   
	}
}
