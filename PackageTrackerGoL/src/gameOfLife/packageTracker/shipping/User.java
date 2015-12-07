package gameOfLife.packageTracker.shipping;

import java.util.HashMap;

import gameOfLife.packageTracker.exceptions.InvalidUserNameException;
import gameOfLife.packageTracker.exceptions.InvalidUserNameException.InvalidUserNameType;

public class User
{
   private final HashMap<String , User> users = new HashMap<>();
   //Do not add a getter for password, this defeats the purpose of password
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
   
   public String getUserName()
   {
      return userName;
   }
   
   public String getName()
   {
      return name;
   }
   
   public boolean validatePassword(String validate)
   {
      return password.equals(validate);
   }
   
   private void encryptPassword()
   {
   
   }
   
   @Override
   public String toString()
   {
      return super.toString();
   }
   
   @Override
   public boolean equals(Object obj)
   {
      if(obj instanceof User)
      {
         User other = (User) obj;
         return userName.equals(other.userName); // user names are unique so no need to check anything else
      }
      else
      {
         return false;
      }
   }
}
