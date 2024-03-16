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
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * EN: Model class for <b>SecUserrole</b>.<br>
 * DE: Model Klasse fuer <b>UserRolle</b>.<br>
 * 
 * @author bbruhns
 * @author sgerth
 */
@Entity
@Table(name = "t_sec_userrole", uniqueConstraints = @UniqueConstraint(columnNames = {
		"usr_id", "rol_id" }))
public class SecUserrole implements java.io.Serializable {

	private static final long serialVersionUID = 6613720067926409622L;

	private long id = Long.MIN_VALUE;
	private int version;
	private SecUser secUser;
	private SecRole secRole;

	/*
	 * private long createBy; private Date createDate; private long updateBy;
	 * private Date updateDate;
	 */

	public SecUserrole() {
	}

	public SecUserrole(long id) {
		this.setId(id);
	}

	public SecUserrole(long id, SecUser secUser, SecRole secRole) {
		this.setId(id);
		this.secUser = secUser;
		this.secRole = secRole;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Id
	@Column(name = "urr_id", unique = true, nullable = false)
	@SequenceGenerator(name = "userRoleSEQ", sequenceName = "t_sec_userrole_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userRoleSEQ")
	public long getId() {
		return id;
	}

	@Version
	@Column(name = "version", nullable = false)
	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usr_id", nullable = false)
	public SecUser getSecUser() {
		return this.secUser;
	}

	public void setSecUser(SecUser secUser) {
		this.secUser = secUser;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rol_id", nullable = false)
	public SecRole getSecRole() {
		return this.secRole;
	}

	public void setSecRole(SecRole secRole) {
		this.secRole = secRole;
	}

	/*
	 * @Column(name = "create_by") public long getCreateBy() { return
	 * this.createBy; }
	 * 
	 * public void setCreateBy(long createBy) { this.createBy = createBy; }
	 * 
	 * @Temporal(TemporalType.TIMESTAMP)
	 * 
	 * @Column(name = "create_date", length = 29) public Date getCreateDate() {
	 * return this.createDate; }
	 * 
	 * public void setCreateDate(Date createDate) { this.createDate =
	 * createDate; }
	 * 
	 * @Column(name = "update_by") public long getUpdateBy() { return
	 * this.updateBy; }
	 * 
	 * public void setUpdateBy(long updateBy) { this.updateBy = updateBy; }
	 * 
	 * @Temporal(TemporalType.TIMESTAMP)
	 * 
	 * @Column(name = "update_date", length = 29) public Date getUpdateDate() {
	 * return this.updateDate; }
	 * 
	 * public void setUpdateDate(Date updateDate) { this.updateDate =
	 * updateDate; }
	 */
	@Override
	public int hashCode() {
		return Long.valueOf(getId()).hashCode();
	}

	public boolean equals(SecUserrole secUserrole) {
		return getId() == secUserrole.getId();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj instanceof SecUserrole) {
			SecUserrole secUserrole = (SecUserrole) obj;
			return equals(secUserrole);
		}

		return false;
	}

	public String toString() {
		return new ToStringBuilder(this).append("id", getId()).toString();
	}

}
