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

import java.util.Date;
import java.util.List;

import org.hibernate.FetchMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.MyCalendarEvent;
import my.com.cmg.iwp.maintenance.service.MyCalendarEventService;

/**
 * EN: Service implementation for methods that depends on
 * <b>MyCalendarEvents</b>.<br>
 * DE: Service Methoden Implementierung betreffend <b>MyCalendarEvents</b>.<br>
 * 
 * @author bbruhns
 * @author sgerth
 */
@Service
public class MyCalendarEventServiceImpl implements MyCalendarEventService {

	private BasisNextidDaoImpl<MyCalendarEvent> calendarEventDAO;

	public void setCalendarEventDAO(
			BasisNextidDaoImpl<MyCalendarEvent> calendarEventDAO) {
		this.calendarEventDAO = calendarEventDAO;
	}

	public BasisNextidDaoImpl<MyCalendarEvent> getCalendarEventDAO() {
		return calendarEventDAO;
	}

	@Override
	public void delete(MyCalendarEvent calendarEvent) {
		getCalendarEventDAO().delete(calendarEvent);
	}

	@Override
	public List<MyCalendarEvent> getAllCalendarEventsByUserId(long usrId) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(MyCalendarEvent.class);
		criteria.add(Restrictions.eq("secUser.id", usrId));
		criteria.setFetchMode("secUser", FetchMode.JOIN);

		return getCalendarEventDAO().findByCriteria(criteria);
	}

	@Override
	public MyCalendarEvent getCalendarEventByID(long id) {
		return getCalendarEventDAO().get(MyCalendarEvent.class, id);
	}

	@Override
	public List<MyCalendarEvent> getCalendarEventsForBeginDate(Date beginDate,
			long usrId) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(MyCalendarEvent.class);
		criteria.add(Restrictions.eq("beginDate", beginDate));
		criteria.add(Restrictions.eq("secUser.id", usrId));
		criteria.setFetchMode("secUser", FetchMode.JOIN);

		return getCalendarEventDAO().findByCriteria(criteria);
	}

	@Override
	public List<MyCalendarEvent> getCalendarEventsFromToDate(Date beginDate,
			Date endDate, long usrId) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(MyCalendarEvent.class);
		criteria.add(Restrictions.ge("beginDate", beginDate));
		criteria.add(Restrictions.le("endDate", endDate));
		criteria.add(Restrictions.eq("secUser.id", usrId));
		criteria.setFetchMode("secUser", FetchMode.JOIN);

		return getCalendarEventDAO().findByCriteria(criteria);
	}

	@Override
	public int getCountAllCalendarEvents() {
		return DataAccessUtils.intResult(getCalendarEventDAO().find(
				"select count(*) from MyCalendarEvent"));
	}

	@Override
	public MyCalendarEvent getNewCalendarEvent() {
		return new MyCalendarEvent();
	}

	@Override
	public void save(MyCalendarEvent calendarEvent) {
		getCalendarEventDAO().save(calendarEvent);
	}

	@Override
	public void saveOrUpdate(MyCalendarEvent calendarEvent) {
		getCalendarEventDAO().saveOrUpdate(calendarEvent);
	}

}
