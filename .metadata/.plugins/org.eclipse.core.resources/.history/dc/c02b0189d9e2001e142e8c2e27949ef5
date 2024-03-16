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
package my.com.cmg.iwp.maintenance.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.management.Query;

import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.MyCalendar;
import my.com.cmg.iwp.maintenance.model.MyCalendarEvent;
import my.com.cmg.iwp.maintenance.service.CalendarService;
import my.com.cmg.iwp.webui.constant.RefCodeConstant;

/**
 * @author Asyraf
 * 
 */

@Service
public class CalendarServiceImpl implements CalendarService {

	private BasisNextidDaoImpl<MyCalendar> calendarDAO;

	@Override
	public void delete(MyCalendar calendar) {
		getCalendarDAO().delete(calendar);
	}

	@Override
	public List<MyCalendar> getAllCalendarEventsByUserId(long usrId) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(MyCalendarEvent.class);
		criteria.add(Restrictions.eq("secUser.id", usrId));
		criteria.setFetchMode("secUser", FetchMode.JOIN);

		return getCalendarDAO().findByCriteria(criteria);
	}

	@Override
	public MyCalendar getCalendarEventByID(long id) {
		return getCalendarDAO().get(MyCalendar.class, id);
	}

	@Override
	public List<MyCalendar> getCalendarEventsForBeginDate(Date beginDate,
			long usrId) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(MyCalendarEvent.class);
		criteria.add(Restrictions.eq("beginDate", beginDate));
		criteria.add(Restrictions.eq("secUser.id", usrId));
		criteria.setFetchMode("secUser", FetchMode.JOIN);

		return getCalendarDAO().findByCriteria(criteria);
	}

	@Override
	public List<MyCalendar> getCalendarFromToDate(Date beginDate, Date endDate,
			long usrId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(MyCalendar.class);
		criteria.add(Restrictions.ge("calDate", beginDate));
		criteria.add(Restrictions.le("calDate", endDate));
		criteria.add(Restrictions.eq("createdBy", usrId));
		// criteria.setFetchMode("secUser", FetchMode.JOIN);

		return getCalendarDAO().findByCriteria(criteria);
	}

	@Override
	public int getCountAllCalendarEvents() {
		return DataAccessUtils.intResult(getCalendarDAO().find(
				"select count(*) from Calendar"));
	}

	@Override
	public MyCalendar getNewCalendar() {
		return new MyCalendar();
	}

	@Override
	public void save(MyCalendar calendarEvent) {
		getCalendarDAO().save(calendarEvent);
	}

	@Override
	public void saveOrUpdate(MyCalendar calendar) {
		getCalendarDAO().saveOrUpdate(calendar);
	}

	public void setCalendarDAO(BasisNextidDaoImpl<MyCalendar> calendarDAO) {
		this.calendarDAO = calendarDAO;
	}

	public BasisNextidDaoImpl<MyCalendar> getCalendarDAO() {
		return calendarDAO;
	}

	@Override
	public List<MyCalendar> getCalendarsByStateCode(Date beginDate,
			Date endDate, String stateCode) {

		DetachedCriteria criteria = DetachedCriteria
				.forClass(MyCalendarEvent.class);
		criteria.add(Restrictions.ge("beginDate", beginDate));
		criteria.add(Restrictions.le("endDate", endDate));
		criteria.add(Restrictions.eq("stateCode", stateCode));
		return getCalendarDAO().findByCriteria(criteria);
	}

	@Override
	public List<MyCalendar> getCalendarsByStateCode1(Date beginDate,
			Date endDate, String stateCode) {

		DetachedCriteria criteria = DetachedCriteria.forClass(MyCalendar.class);
		criteria.add(Restrictions.ge("calDate", beginDate));
		criteria.add(Restrictions.le("calDate", endDate));
		criteria.add(Restrictions.eq("stateCode", stateCode));
		return getCalendarDAO().findByCriteria(criteria);
	}

	@Override
	public int bulkSave(Date beginDate, Date endDate, String[] stateCode,
			String holType, Date date, long userId, String desc,
			Character status_) {

		Session session = getCalendarDAO().getSessionFactory().openSession();
		int result = 0;
		try {

			int size = stateCode.length;
			int i = 0;
			String consQuery = "";
			do {

				if (size == 1) {
					consQuery = "'" + stateCode[i] + "'";
				} else if (size > 1) {
					if (i == 0) {

						consQuery = "'" + stateCode[i] + "',";
					} else if (i == size - 1) {

						consQuery = consQuery + "'" + stateCode[i] + "'";

					} else {
						consQuery = consQuery + "'" + stateCode[i] + "',";
					}
				}
				i++;
			} while (i < size);
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String endDateF = dateFormat.format(endDate);
			String beginDateF = dateFormat.format(beginDate);
			String sql = "UPDATE t_calendars SET holiday_type='" + holType
					+ "',working_yn='N',updated_date=SYSDATE,updated_by="
					+ userId + ",active_flag='" + status_ + "',holiday_desc='"
					+ desc + "' where state_code IN(" + consQuery
					+ ") AND (TO_CHAR(cal_date, 'yyyy-MM-dd') >='" + beginDateF
					+ "' AND TO_CHAR(cal_date, 'yyyy-MM-dd') <='" + endDateF
					+ "')";

			System.out.println("Query : " + sql);
			Transaction txn = session.beginTransaction();
			Query query = session.createSQLQuery(sql);
			result = query.executeUpdate();
			stateCode = null;
			txn.commit();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}

	@Override
	public int bulkSaveDay(String dValue, Character working,
			String[] stateCode, String holTypeValue, Date date, long userId,
			String desc, Character status_, int year) {

		Session session = getCalendarDAO().getSessionFactory().openSession();
		int result = 0;

		try {

			int size = stateCode.length;
			int i = 0;
			String consQuery = "";
			do {

				if (size == 1) {
					consQuery = "'" + stateCode[i] + "'";
				} else if (size > 1) {
					if (i == 0) {

						consQuery = "'" + stateCode[i] + "',";
					} else if (i == size - 1) {

						consQuery = consQuery + "'" + stateCode[i] + "'";

					} else {
						consQuery = consQuery + "'" + stateCode[i] + "',";
					}
				}
				i++;
			} while (i < size);

			String sql = "UPDATE t_calendars SET holiday_type='" + holTypeValue
					+ "'" + ",working_yn='" + working
					+ "',updated_date=SYSDATE,updated_by=" + userId
					+ ",active_flag='" + status_ + "',holiday_desc='" + desc
					+ "' where state_code IN(" + consQuery + ") AND cal_day='"
					+ dValue + "' AND cal_year=" + year;
			Transaction txn = session.beginTransaction();
			Query query = session.createSQLQuery(sql);
			result = query.executeUpdate();
			stateCode = null;
			txn.commit();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}

	@Override
	public List<MyCalendar> getCalendarFromToDateByWorkingStatus(
			Character workingYn, String state, String holType, String desc) {

		DetachedCriteria criteria = DetachedCriteria.forClass(MyCalendar.class);
		criteria.add(Restrictions.eq("workingYn", workingYn));
		criteria.add(Restrictions.eq("stateCode", state));
		if (holType != null) {

			criteria.add(Restrictions.eq("holidayType", holType).ignoreCase());
		}
		if (desc != null) {

			criteria.add(Restrictions.ilike("holidayDesc", desc,
					MatchMode.ANYWHERE));
		}

		criteria.addOrder(Order.asc("calSeqno"));
		return getCalendarDAO().findByCriteria(criteria);
	}

	@Override
	public List<MyCalendar> getStartAndEndDate(Character b, String holidayType,
			String holidayDesc) {
		DetachedCriteria criteria = DetachedCriteria.forClass(MyCalendar.class);
		criteria.add(Restrictions.eq("holidayType", holidayType));
		criteria.add(Restrictions.eq("workingYn", b));
		criteria.add(Restrictions.eq("holidayDesc", holidayDesc));
		criteria.addOrder(Order.asc("calSeqno"));
		return getCalendarDAO().findByCriteria(criteria);
	}

	@Override
	public List<MyCalendar> getStateCodeByDate(Character workingYn,
			String holType, String desc, String stateCode) {

		// String queryString =
		// "Select DISTINCT holidayType from MyCalendar where workingYn="
		// + workingYn
		// + " and  holidayType='"
		// + holType
		// + "' and holidayDesc='" + desc + "'";
		//
		// return getCalendarDAO().find(queryString);
		DetachedCriteria criteria = DetachedCriteria.forClass(MyCalendar.class);
		criteria.add(Restrictions.eq("holidayType", holType));
		criteria.add(Restrictions.eq("workingYn", workingYn));
		criteria.add(Restrictions.eq("holidayDesc", desc));
		criteria.add(Restrictions.eq("stateCode", stateCode));
		criteria.addOrder(Order.asc("calSeqno"));
		return getCalendarDAO().findByCriteria(criteria);

	}

	@Override
	public List<MyCalendar> getCalendarFromToDateByWorkingStatusMain(
			Character workingYn, String state) {

		DetachedCriteria criteria = DetachedCriteria.forClass(MyCalendar.class);
		Criterion criterion1 = Restrictions.eq("workingYn", workingYn);
		Criterion criterion2 = Restrictions.eq("stateCode", state).ignoreCase();
		criteria.add(Restrictions.and(criterion1, criterion2));
		criteria.addOrder(Order.asc("calSeqno"));
		return getCalendarDAO().findByCriteria(criteria);
	}
	
	@Override
	public List<MyCalendar> getCalendarbyCriteria(String stateCodes[], int month, int year, String holidayType) {
		DetachedCriteria criteria = DetachedCriteria.forClass(MyCalendar.class);
		if (null != holidayType) 
			criteria.add(Restrictions.eq("holidayType", holidayType));
		else
			criteria.add(Restrictions.isNotNull("holidayType"));
		if (month > 0 ) 
			criteria.add(Restrictions.eq("calMonth", new BigDecimal(month)));
		criteria.add(Restrictions.eq("calYear",  new BigDecimal(year)));
		criteria.add(Restrictions.in("stateCode", stateCodes));
		criteria.addOrder(Order.asc("calSeqno"));
		return getCalendarDAO().findByCriteria(criteria);

	}
	@Override
	public int updateCalendar(String stateCodes[], int month, int year, String holidayType, String fromStateCode) {
		StringBuffer queryBuffer =  new StringBuffer();
		queryBuffer.append(" MERGE INTO T_CALENDARS CAL USING( SELECT STATE_CODE, CAL_YEAR, CAL_MONTH, CAL_DATE, CAL_DAY, ");
		queryBuffer.append(" CAL_DATESTR, WORKING_YN, HOLIDAY_TYPE, HOLIDAY_DESC ");
		queryBuffer.append(" FROM T_CALENDARS WHERE CAL_YEAR = "+year+" AND STATE_CODE = '"+fromStateCode+"' ");
		if (null != holidayType) 
			queryBuffer.append(" AND HOLIDAY_TYPE = '"+holidayType+"' ");
		else 
			queryBuffer.append(" AND HOLIDAY_TYPE IS NOT NULL ");
		if (month > 0)
			queryBuffer.append(" AND CAL_MONTH = "+month+") CALC ");
		else
			queryBuffer.append(" AND CAL_MONTH IS NOT NULL ) CALC ");
		queryBuffer.append(" ON (CALC.CAL_YEAR = CAL.CAL_YEAR AND CALC.CAL_DATESTR =  CAL.CAL_DATESTR ");
		String consQuery = "";
		int size = stateCodes.length;
		int i = 0;
		do {

			if (size == 1) {
				consQuery = "'" + stateCodes[i] + "'";
			} else if (size > 1) {
				if (i == 0) {

					consQuery = "'" + stateCodes[i] + "',";
				} else if (i == size - 1) {

					consQuery = consQuery + "'" + stateCodes[i] + "'";

				} else {
					consQuery = consQuery + "'" + stateCodes[i] + "',";
				}
			}
			i++;
		} while (i < size);		
		queryBuffer.append(" AND CAL.STATE_CODE IN ("+consQuery+"))");
		queryBuffer.append(" WHEN MATCHED THEN UPDATE SET CAL.WORKING_YN = CALC.WORKING_YN, CAL.HOLIDAY_TYPE = CALC.HOLIDAY_TYPE, "
				+ " CAL.HOLIDAY_DESC= CALC.HOLIDAY_DESC, UPDATED_BY = 2, UPDATED_DATE = SYSDATE");
		int result = 0;
		Session session = null;
		try {
			session = getCalendarDAO().getSessionFactory().openSession();
			Transaction trx  = session.beginTransaction();
			Query query = session.createSQLQuery(queryBuffer.toString());
			result = query.executeUpdate();
			trx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {			
			session.close();
		}
		return result;
	}
	
	@Override
	public List<MyCalendar> getCalendarsByStateCode(Date beginDate, String stateCode) {

		Calendar cal = new GregorianCalendar();
		cal.setTime(beginDate);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		beginDate = cal.getTime();
		DetachedCriteria criteria = DetachedCriteria.forClass(MyCalendar.class);
		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		criteria.add(Restrictions.gt("calDate", beginDate));
		criteria.add(Restrictions.eq("workingYn", RefCodeConstant.BOOLEAN_TRUE));
		criteria.add(Restrictions.eq("stateCode", stateCode));
		criteria.addOrder(Order.asc("calDate"));
		return getCalendarDAO().findByCriteria(criteria);
	}

	@Override
	public MyCalendar getCalendarEventBySeqno(long seqno) {
		DetachedCriteria criteria = DetachedCriteria.forClass(MyCalendar.class);
		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		criteria.add(Restrictions.eq("calSeqno", seqno));
		List<MyCalendar>  calendars=getCalendarDAO().findByCriteria(criteria);
		if(calendars.size()>0)
		{
			return calendars.get(0);
		}
		else 
			return null;
	}
}
