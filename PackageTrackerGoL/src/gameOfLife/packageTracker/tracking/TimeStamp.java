package gameOfLife.packageTracker.tracking;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeStamp {
	private DateFormat	dateFormat;
	private Date		stamp;
						
	public TimeStamp(String stamp) {
		this(stamp , "MM/dd/yyyy hh:mm:ss");
	}
	
	public TimeStamp(String stamp , String format) {
		dateFormat = new SimpleDateFormat(format);
		String[] deconstucted = stamp.split("[-:TZ]");
		int year = Integer.valueOf(deconstucted[0]);
		int month = Integer.valueOf(deconstucted[1]);
		int date = Integer.valueOf(deconstucted[2]);
		int hour = Integer.valueOf(deconstucted[3]);
		int minute = Integer.valueOf(deconstucted[4]);
		int second = Integer.valueOf(deconstucted[5]);
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR , year);
		calendar.set(Calendar.MONTH , month);
		calendar.set(Calendar.DATE , date);
		calendar.set(Calendar.HOUR , hour);
		calendar.set(Calendar.MINUTE , minute);
		calendar.set(Calendar.SECOND , second);
		this.stamp = calendar.getTime();
		System.out.println(dateFormat.format(this.stamp));
	}
	
	@Override
	public String toString() {
		return dateFormat.format(stamp);
	}
}
