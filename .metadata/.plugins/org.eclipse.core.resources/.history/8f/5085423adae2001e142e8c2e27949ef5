/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.com.cmg.iwp.webui.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.lang3.time.DateUtils;



/**
 * 
 * @author dzung
 */
public class DateUtil {

	/**
	 * This method is used to remove Hour, Minute, Second
	 * 
	 * @param date
	 *            date need to remove Hour, Minute, Second
	 * @return date this date is removed Hour, Minute, Second
	 */
	public static Date removeHMS(Date date) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}
	
	public static final String DATE_FORMAT_STR_1 = "dd/MM/yyyy";
	public static final String DATE_FORMAT_STR_2 = "yyyy-MM-dd";
	public static final String DATE_FORMAT_STR_3 = "yyyy-MM-dd HH:mm:ss";
	public static final String DATE_FORMAT_STR_4 = "MM/dd/yyyy";
	public static final String DATE_FORMAT_STR_5 = "dd/MM/yyyy hh:mm a";
	public static final String DATE_FORMAT_STR_6 = "h:mm a";
	public static final String DATE_FORMAT_STR_7 = "dd-MM-yyyy";
	public static final DateFormat dateFormat_AM_PM = new SimpleDateFormat("dd/MM/yyyy hh:mm a");
	
	public static final DateFormat DATE_FORMAT_1 = new SimpleDateFormat(DATE_FORMAT_STR_1);
	public static final DateFormat DATE_FORMAT_2 = new SimpleDateFormat(DATE_FORMAT_STR_2);
	public static final DateFormat DATE_FORMAT_3 = new SimpleDateFormat(DATE_FORMAT_STR_3);
	public static final DateFormat DATE_FORMAT_4 = new SimpleDateFormat(DATE_FORMAT_STR_4);
	public static final DateFormat DATE_FORMAT_5 = new SimpleDateFormat(DATE_FORMAT_STR_5);
	public static final DateFormat DATE_FORMAT_6 = new SimpleDateFormat(DATE_FORMAT_STR_6);

	public static final DateFormat format_time_only = new SimpleDateFormat("h:mm a");
	public static final DateFormat ddMMyy = new SimpleDateFormat("ddMMyy");
	
	public static Date adjustDate(Date date, int daysNo) {
		Date dateWithoutHSM = removeHMS(date);
		Calendar cal = new GregorianCalendar();
		cal.setTime(dateWithoutHSM);
		cal.add(Calendar.DAY_OF_YEAR, daysNo);
		return cal.getTime();
	}

	public static Date startDate(Date date) {
		return DateUtils.truncate(date, Calendar.DATE);
	}
	public static Date createDate(int year, int month, int date, int hour,
			int minute) {
		Calendar cal = new GregorianCalendar();
		cal.set(year, month, date, hour, minute);
		return cal.getTime();
	}

	public static int getAge(Date dobDate) {
		Calendar dob = Calendar.getInstance();
		dob.setTime(dobDate);
		Calendar today = Calendar.getInstance();
		int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
		if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)) {
			age--;
		}
		return age;

	}

	public static int getInterval(Date newerDate, Date olderDate) {
		int diffInDays = (int) ((newerDate.getTime() - olderDate.getTime()) / (1000 * 60 * 60 * 24));
		return diffInDays;
	}

	public static String getFormattedDateFrom(Date dateFrom,String dateFormatStr) {
		SimpleDateFormat format = new SimpleDateFormat(dateFormatStr);
		final Calendar calFrom = Calendar.getInstance();
		calFrom.setTime(dateFrom);
		calFrom.set(Calendar.AM_PM, 0);
		calFrom.set(Calendar.HOUR, 0);
		calFrom.set(Calendar.MINUTE, 0);
		calFrom.set(Calendar.SECOND, 0);

		return format.format(calFrom.getTime());
	}

	public static String getFormattedDateTo(Date dateTo,String dateFormatStr) {
		SimpleDateFormat format = new SimpleDateFormat(dateFormatStr);
		final Calendar calTo = Calendar.getInstance();
		calTo.setTime(dateTo);
		calTo.set(Calendar.AM_PM, 1);
		calTo.set(Calendar.HOUR, 11);
		calTo.set(Calendar.MINUTE, 59);
		calTo.set(Calendar.SECOND, 59);

		return format.format(calTo.getTime());
	}
	
	public static String getFormattedDateFrom1(Date dateFrom) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		final Calendar calFrom = Calendar.getInstance();
		calFrom.setTime(dateFrom);
		calFrom.set(Calendar.AM_PM, 0);
		calFrom.set(Calendar.HOUR, 0);
		calFrom.set(Calendar.MINUTE, 0);
		calFrom.set(Calendar.SECOND, 0);

		return format.format(calFrom.getTime());
	}

	public static String getFormattedDateFrom2(Date dateFrom) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		final Calendar calFrom = Calendar.getInstance();
		calFrom.setTime(dateFrom);
		calFrom.set(Calendar.AM_PM, 0);
		calFrom.set(Calendar.HOUR, 0);
		calFrom.set(Calendar.MINUTE, 0);
		calFrom.set(Calendar.SECOND, 0);

		return format.format(calFrom.getTime());
	}
	
	public static String getFormattedDateTo2(Date dateTo) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		final Calendar calTo = Calendar.getInstance();
		calTo.setTime(dateTo);
		calTo.set(Calendar.AM_PM, 1);
		calTo.set(Calendar.HOUR, 11);
		calTo.set(Calendar.MINUTE, 59);
		calTo.set(Calendar.SECOND, 59);
//		calTo.add(Calendar.DATE, 1);

		return format.format(calTo.getTime());
	}

	
	public static String getFormattedDateTo1(Date dateTo) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		final Calendar calTo = Calendar.getInstance();
		calTo.setTime(dateTo);
		calTo.set(Calendar.AM_PM, 1);
		calTo.set(Calendar.HOUR, 11);
		calTo.set(Calendar.MINUTE, 59);
		calTo.set(Calendar.SECOND, 59);

		return format.format(calTo.getTime());
	}
	
	public static String getFormattedDate(Date dateTo,String format) {
		if(dateTo != null) {
			SimpleDateFormat simpleDateFrmt = new SimpleDateFormat(format);
			return simpleDateFrmt.format(dateTo);
		} else {
			return null;
		}
	}
	
	public static Date getFormattedDate(String dateTo,String format) {
		if(dateTo != null) {
			SimpleDateFormat simpleDateFrmt = new SimpleDateFormat(format);
			try {
				return simpleDateFrmt.parse(dateTo);
			} catch (ParseException e) {
				e.printStackTrace();
				return null;
			}
		} else {
			return null;
		}
	}
	
	public static String getFormattedDate(String dateStr,String inFormat,String outFormat) {
		if(dateStr != null) {
			SimpleDateFormat simpleDateFrmt = new SimpleDateFormat(inFormat);
			try {
				return new SimpleDateFormat(outFormat).format(simpleDateFrmt.parse(dateStr));
			} catch (ParseException e) {
				e.printStackTrace();
				return null;
			}
		} else {
			return null;
		}
	}
	
	public static Date getFormattedDateFrom(Date dateFrom) {
		final Calendar calFrom = Calendar.getInstance();
		calFrom.setTime(dateFrom);
		calFrom.set(Calendar.AM_PM, 0);
		calFrom.set(Calendar.HOUR, 0);
		calFrom.set(Calendar.MINUTE, 0);
		calFrom.set(Calendar.SECOND, 0);

		return calFrom.getTime();
	}

	public static Date getFormattedDateTo(Date dateTo) {
		final Calendar calTo = Calendar.getInstance();
		calTo.setTime(dateTo);
		calTo.set(Calendar.AM_PM, 1);
		calTo.set(Calendar.HOUR, 11);
		calTo.set(Calendar.MINUTE, 59);
		calTo.set(Calendar.SECOND, 59);

		return calTo.getTime();
	}
	
	public static Date increaseDate(Date date,Integer addDays) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE,addDays);
		return c.getTime();
	}
}
