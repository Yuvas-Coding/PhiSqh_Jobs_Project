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
 * EN: Model class for <b>SecRolegroup</b>.<br>
 * DE: Model Klasse fuer <b>RolenGruppe</b>.<br>
 * 
 * @author bbruhns
 * @author sgerth
 */
@Entity
@Table(name = "t_sec_rolegroup", uniqueConstraints = @UniqueConstraint(columnNames = {
		"grp_id", "rol_id" }))
public class SecRolegroup implements java.io.Serializable {

	private static final long serialVersionUID = -8173065939240678650L;

	private long id = Long.MIN_VALUE;
	private int version;
	private SecRole secRole;
	private SecGroup secGroup;

	/*
	 * private long createBy; private Date createDate; private long updateBy;
	 * private Date updateDate;
	 */
	public SecRolegroup() {
	}

	public SecRolegroup(long id) {
		this.setId(id);
	}

	public SecRolegroup(long id, SecRole secRole, SecGroup secGroup) {
		this.setId(id);
		this.secRole = secRole;
		this.secGroup = secGroup;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Id
	@Column(name = "rlg_id", unique = true, nullable = false)
	@SequenceGenerator(name = "roleGroupSEQ", sequenceName = "t_sec_rolegroup_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roleGroupSEQ")
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
	@JoinColumn(name = "rol_id", nullable = false)
	public SecRole getSecRole() {
		return this.secRole;
	}

	public void setSecRole(SecRole secRole) {
		this.secRole = secRole;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "grp_id", nullable = false)
	public SecGroup getSecGroup() {
		return this.secGroup;
	}

	public void setSecGroup(SecGroup secGroup) {
		this.secGroup = secGroup;
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

	public boolean equals(SecRolegroup secRolegroup) {
		return getId() == secRolegroup.getId();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj instanceof SecRolegroup) {
			SecRolegroup secRolegroup = (SecRolegroup) obj;
			return equals(secRolegroup);
		}

		return false;
	}

	public String toString() {
		return new ToStringBuilder(this).append("id", getId()).toString();
	}

}
