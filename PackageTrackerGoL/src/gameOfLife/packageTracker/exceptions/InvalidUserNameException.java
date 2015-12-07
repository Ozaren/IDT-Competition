package gameOfLife.packageTracker.exceptions;

public class InvalidUserNameException extends Exception
{
   public InvalidUserNameException(InvalidUserNameType type)
   {
      super("Invalid User Name: " + type);
   }
   
   public static enum InvalidUserNameType
   {
      DUPLICATE , INVALID;
   }
}
