package gameOfLife.packageTracker.shipping;

import java.util.HashMap;
import java.util.Random;

import gameOfLife.packageTracker.exceptions.InvalidUserNameException;
import gameOfLife.packageTracker.exceptions.InvalidUserNameException.InvalidUserNameType;

public class User
{
   private static final HashMap<String , User> users = new HashMap<>();
                                              
   //never return a decrypted password
   private String                       password;
   private String                       name, userName;
   private boolean                      isPasswordEncrypted;
                                        
   public User(String name, String userName, String password) throws InvalidUserNameException
   {
      this(name, userName, password, false);
   }
   
   public User(String name, String userName, String password, boolean encryptPassword) throws InvalidUserNameException
   {
      if(users.containsKey(userName))
         throw new InvalidUserNameException(InvalidUserNameType.DUPLICATE);
      this.name = name;
      this.userName = userName;
      this.password = password;
      if(encryptPassword)
         encryptPassword();
      isPasswordEncrypted = encryptPassword;
      users.put(userName, this);
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
   
   /**
    * Only returns encryted passwords
    * 
    * @return encrypted password or null if password is not encrypted
    */
   public String getPassword()
   {
      if(isPasswordEncrypted)
         return password;
      else
         return null;
   }
   
   public boolean isPasswordEncrypted()
   {
      return isPasswordEncrypted;
   }
   
   public String encryptPassword() // psuedo-random char-shift
   {
      if(isPasswordEncrypted)
         return password;
      Random random = new Random(userName.hashCode()); // for encrypting password the seed must be something unique, say the username's hashcode, that's unique
      
      char[] password = this.password.toCharArray();
      for(int i = 0; i < password.length; i++)
      {
         password[i] += random.nextInt() % Character.MAX_VALUE;
         password[i] %= Character.MAX_VALUE;
      }
      this.password = new String(password);
      return this.password;
   }
   
   public void decryptPassword()
   {
      if(!isPasswordEncrypted)
         return;
      Random random = new Random(userName.hashCode()); // for encrypting password the seed must be something unique, say the username's hashcode, that's unique
      
      char[] password = this.password.toCharArray();
      for(int i = 0; i < password.length; i++)
      {
         password[i] -= random.nextInt() % Character.MAX_VALUE;
         password[i] += Character.MAX_VALUE + 1;
         password[i] %= Character.MAX_VALUE;
      }
      this.password = new String(password);
   }
   
   @Override
   public String toString()
   {
      return String.format("User Name: %s\nName: %s\nPassword: %s", userName, name, password.replaceAll(".", "*"));
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
