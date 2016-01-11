package gameOfLife.packageTracker.exceptions;

/**
 * The Class InvalidUserNameException is 
 */
@SuppressWarnings("serial")
public class InvalidUserNameException extends Exception
{

   /**
    * Instantiates a new invalid user name exception that throws an exception
    * depending on the error the user made with the user name.
    *
    * @param type the type of error the user made
    */
   public InvalidUserNameException(InvalidUserNameType type)
   {
      super("Invalid User Name: " + type);
   }
   
   /**
    * The Enum InvalidUserNameType contains the types of errors the user
    * can make when entering the user name.
    */
   public static enum InvalidUserNameType
   {
      
      /** There is already a user name inside the database that matches the entered user name. */
      DUPLICATE , 
      /** The user name breaks the rules that are set about the user name. */
      INVALID;
   }
}
