/**
 * Copyright 2010 the original author or authors.
 * 
 * This file is part of Zksample2. http://zksample2.sourceforge.net/
 *
 * Zksample2 is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * Zksample2 is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Zksample2.  If not, see <http://www.gnu.org/licenses/gpl.html>.
 */
package my.com.cmg.iwp.maintenance.service;

import java.util.Date;
import java.util.List;

import my.com.cmg.iwp.maintenance.model.MyCalendar;

/**
 * @author Asyraf
 * 
 */
public interface CalendarService {

	public MyCalendar getNewCalendar();

	public List<MyCalendar> getAllCalendarEventsByUserId(long usrId);

	public int getCountAllCalendarEvents();

	public MyCalendar getCalendarEventByID(long id);

	public List<MyCalendar> getCalendarEventsForBeginDate(Date beginDate,
			long usrId);

	public List<MyCalendar> getCalendarFromToDate(Date beginDate, Date endDate,
			long usrId);

	public void saveOrUpdate(MyCalendar calendar);

	public void delete(MyCalendar calendar);

	public void save(MyCalendar calendar);

	public List<MyCalendar> getCalendarsByStateCode(Date beginDate,
			Date endDate, String stateCode);

	public List<MyCalendar> getCalendarsByStateCode1(Date beginDate,
			Date endDate, String stateCode);

	public int bulkSave(Date beginDate, Date endDate, String[] stateCode,
			String holType, Date currentDate, long userId, String desc,
			Character status_);

	public int bulkSaveDay(String dValue, Character working,
			String[] stateCode, String holTypeValue, Date date, long userId,
			String desc, Character status_, int year);

	public List<MyCalendar> getCalendarFromToDateByWorkingStatus(
			Character workingYn, String state, String holType, String desc);

	public List<MyCalendar> getStartAndEndDate(Character b, String holidayType,
			String holidayDesc);

	public List<MyCalendar> getStateCodeByDate(Character b, String holType,
			String desc, String stateCode);

	public List<MyCalendar> getCalendarFromToDateByWorkingStatusMain(
			Character b, String state);

	List<MyCalendar> getCalendarbyCriteria(String[] stateCodes, int month, int year, String holidayType);

	int updateCalendar(String[] stateCodes, int month, int year, String holidayType, String fromStateCode);

	List<MyCalendar> getCalendarsByStateCode(Date beginDate, String stateCode);
	
	public MyCalendar getCalendarEventBySeqno(long id);


}
