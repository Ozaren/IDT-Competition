package gameOfLife.packageTracker.shipping;

import java.util.HashMap;

import gameOfLife.packageTracker.exceptions.InvalidUserNameException;
import gameOfLife.packageTracker.exceptions.InvalidUserNameException.InvalidUserNameType;

public class User
{
   private final HashMap<String , User> users = new HashMap<>();
   private String                       name, userName, password;
                                        
   public User(String name, String userName, String password) throws InvalidUserNameException
   {
      this(name, userName, password, false);
   }
   
   public User(String name, String userName, String password, boolean encryptPassword) throws InvalidUserNameException
   {
      if(users.containsKey(name))
         throw new InvalidUserNameException(InvalidUserNameType.DUPLICATE);
      this.name = name;
      this.userName = userName;
      this.password = password;
      if(encryptPassword)
         encryptPassword();
   }
   
   public boolean validatePassword(String validate)
   {
      return password.equals(validate);
   }
   
   private void encryptPassword() {
      
   }
}
