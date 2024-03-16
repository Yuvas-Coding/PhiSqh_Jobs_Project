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
package my.com.cmg.iwp.maintenance.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * EN: Model class for <b>Calendar Event</b>.<br>
 * DE: Model Klasse fuer <b>Kalender Termin</b>.<br>
 * 
 * @author bbruhns
 * @author sgerth
 */
@Entity
@Table(name = "phisprod.calendar_event", uniqueConstraints = @UniqueConstraint(columnNames = "cle_id"))
public class MyCalendarEvent implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private long id = Long.MIN_VALUE;
	private int version;
	private String title;
	private String content;
	private Date beginDate;
	private Date endDate;
	private String headerColor;
	private String contentColor;
	private SecUser secUser;
	private Character locked = 'N';

	public MyCalendarEvent() {
	}

	public MyCalendarEvent(long id, String content, Date beginDate,
			Date endDate, SecUser secUser) {
		this.setId(id);
		this.content = content;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.secUser = secUser;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Id
	@Column(name = "cle_id", unique = true, nullable = false)
	@SequenceGenerator(name = "calendarEventSEQ", sequenceName = "phisprod.calendar_event_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "calendarEventSEQ")
	public long getId() {
		return id;
	}

	/**
	 * EN: Hibernate version field. Do not touch this!.<br>
	 * DE: Hibernate Versions Info. Bitte nicht benutzen!<br>
	 */
	@Version
	@Column(name = "version", nullable = false)
	public int getVersion() {
		return this.version;
	}

	/**
	 * EN: Hibernate version field. Do not touch this!.<br>
	 * DE: Hibernate Versions Info. Bitte nicht benutzen!<br>
	 */
	public void setVersion(int version) {
		this.version = version;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "cle_title", length = 30)
	public String getTitle() {
		return title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "cle_content", nullable = false, length = 300)
	public String getContent() {
		return content;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "cle_begin_date", nullable = false, length = 29)
	public Date getBeginDate() {
		return beginDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "cle_end_date", nullable = false, length = 29)
	public Date getEndDate() {
		return endDate;
	}

	public void setHeaderColor(String headerColor) {
		this.headerColor = headerColor;
	}

	@Column(name = "cle_header_color", length = 10)
	public String getHeaderColor() {
		return headerColor;
	}

	public void setContentColor(String contentColor) {
		this.contentColor = contentColor;
	}

	@Column(name = "cle_content_color", length = 10)
	public String getContentColor() {
		return contentColor;
	}

	public void setSecUser(SecUser secUser) {
		this.secUser = secUser;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cle_usr_id", nullable = false)
	public SecUser getSecUser() {
		return secUser;
	}

	public void setLocked(Character locked) {
		this.locked = locked;
	}

	@Column(name = "cle_locked", nullable = false)
	public Character isLocked() {
		return locked;
	}

	@Override
	public int hashCode() {
		return Long.valueOf(getId()).hashCode();
	}

	public boolean equals(MyCalendarEvent calendarEvent) {
		return getId() == calendarEvent.getId();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj instanceof MyCalendarEvent) {
			MyCalendarEvent calendarEvent = (MyCalendarEvent) obj;
			return equals(calendarEvent);
		}

		return false;
	}

	public String toString() {
		return new ToStringBuilder(this).append("id", getId()).toString();
	}

}
