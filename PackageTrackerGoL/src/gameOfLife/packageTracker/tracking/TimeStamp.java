package gameOfLife.packageTracker.tracking;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeStamp
{
   private DateFormat dateFormat;
   private Calendar   stamp;
   private Date       timeStamp;
                      
   public TimeStamp(String stamp)
   {
      this(stamp, "MM/dd/yyyy hh:mm:ss");
   }
   
   public TimeStamp(String stamp, String format)
   {
      dateFormat = new SimpleDateFormat(format);
      String[] deconstucted = stamp.split("[-:TZ]");
      int year = Integer.valueOf(deconstucted[0]);
      int month = Integer.valueOf(deconstucted[1]);
      int date = Integer.valueOf(deconstucted[2]);
      int hour = Integer.valueOf(deconstucted[3]);
      int minute = Integer.valueOf(deconstucted[4]);
      int second = Integer.valueOf(deconstucted[5]);
      this.stamp = Calendar.getInstance();
      this.stamp.set(Calendar.YEAR, year);
      this.stamp.set(Calendar.MONTH, month);
      this.stamp.set(Calendar.DATE, date);
      this.stamp.set(Calendar.HOUR, hour);
      this.stamp.set(Calendar.MINUTE, minute);
      this.stamp.set(Calendar.SECOND, second);
      timeStamp = this.stamp.getTime();
      System.out.println(this);
   }
   
   public int get(int field)
   {
      return stamp.get(field);
   }
   
   public int getSecond()
   {
      return get(Calendar.SECOND);
   }
   
   public int getMinute()
   {
      return get(Calendar.MINUTE);
   }
   
   public int getHour()
   {
      return get(Calendar.HOUR);
   }
   
   public int getDate()
   {
      return get(Calendar.DATE);
   }
   
   public int getMonth()
   {
      return get(Calendar.MONTH);
   }
   
   public int getYear()
   {
      return get(Calendar.YEAR);
   }
   
   public DateFormat getDateFormat()
   {
      return dateFormat;
   }
   
   public void setDateFormat(DateFormat dateFormat)
   {
      if(dateFormat != null)
         this.dateFormat = dateFormat;
   }
   
   public void setDateFormat(String dateFormat)
   {
      if(dateFormat != null)
         setDateFormat(new SimpleDateFormat(dateFormat));
   }
   
   @Override
   public String toString()
   {
      return dateFormat.format(timeStamp);
   }
}
