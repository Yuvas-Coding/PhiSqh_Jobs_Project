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
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import org.apache.commons.lang3.builder.ToStringBuilder;

import my.com.cmg.iwp.webui.constant.RefCodeConstant;

/**
 * EN: Model class for <b>SecRole</b>.<br>
 * DE: Model Klasse fuer <b>Rolle</b>.<br>
 * 
 * @author bbruhns
 * @author sgerth
 */
@Entity
@Table(name = "t_sec_role", uniqueConstraints = @UniqueConstraint(columnNames = "rol_shortdescription"))
public class SecRole implements java.io.Serializable {

	private static final long serialVersionUID = -7966378689254650569L;
	private long id = Long.MIN_VALUE;	
	private int version;
	private String rolShortdescription;
	private String rolLongdescription;
	private Character activeFlag = RefCodeConstant.ACTIVE_FLAG_TRUE;
	private String createBy;
	private Date createDate;
	private String updateBy;
	private Date updateDate;
	/*
	 * private long createBy; private Date createDate; private long updateBy;
	 * private Date updateDate;
	 */
	private Set<SecUserrole> secUserroles = new HashSet<SecUserrole>(0);
	private Set<SecRolegroup> secRolegroups = new HashSet<SecRolegroup>(0);

	public SecRole() {
	}

	public SecRole(long id, String rolShortdescription) {
		this.setId(id);
		this.rolShortdescription = rolShortdescription;
	}

	public SecRole(long id, String rolShortdescription,
			String rolLongdescription, Set<SecUserrole> secUserroles,
			Set<SecRolegroup> secRolegroups) {
		this.setId(id);
		this.rolShortdescription = rolShortdescription;
		this.rolLongdescription = rolLongdescription;
		this.secUserroles = secUserroles;
		this.secRolegroups = secRolegroups;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Id
	@Column(name = "rol_id", unique = true, nullable = false)
	@SequenceGenerator(name = "roleSEQ", sequenceName = "t_sec_role_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roleSEQ")
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

	@Column(name = "rol_shortdescription", unique = true, nullable = false, length = 30)
	public String getRolShortdescription() {
		return this.rolShortdescription;
	}

	public void setRolShortdescription(String rolShortdescription) {
		this.rolShortdescription = rolShortdescription;
	}

	@Column(name = "rol_longdescription", length = 1000)
	public String getRolLongdescription() {
		return this.rolLongdescription;
	}

	public void setRolLongdescription(String rolLongdescription) {
		this.rolLongdescription = rolLongdescription;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "secRole")
	public Set<SecUserrole> getSecUserroles() {
		return this.secUserroles;
	}

	public void setSecUserroles(Set<SecUserrole> secUserroles) {
		this.secUserroles = secUserroles;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "secRole")
	public Set<SecRolegroup> getSecRolegroups() {
		return this.secRolegroups;
	}

	public void setSecRolegroups(Set<SecRolegroup> secRolegroups) {
		this.secRolegroups = secRolegroups;
	}
	
	@Column(name="ACTIVE_FLAG") 
	public Character getActiveFlag() { 
		return activeFlag; 
	}
	
	public void setActiveFlag(Character activeFlag) { 
		this.activeFlag = activeFlag; 
	}
	
	@Column(name="CREATE_BY")
	public String getCreateBy() { 
		return createBy; 
	}
	public void setCreateBy(String createBy) { 
		this.createBy = createBy; 
	}

	@Temporal( TemporalType.TIMESTAMP)
	@Column(name="CREATE_DATE", nullable = false, length = 29)
	public Date getCreateDate() { 
		return createDate; 
	}
	public void setCreateDate(Date createDate) { 
		this.createDate = createDate; 
	}
	
	 @Column(name="UPDATE_BY")
	public String getUpdateBy() { 
		 return this.updateBy; 
		}
	public void setUpdateBy(String updateBy) { 
		this.updateBy = updateBy; 
	}
	
	@Temporal( TemporalType.TIMESTAMP)
	@Column(name="UPDATE_DATE", nullable = false, length = 29)
	public Date getUpdateDate() { 
		return updateDate; 
	}
	public void setUpdateDate(Date updateDate) { 
		this.updateDate = updateDate; 
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

	public boolean equals(SecRole secRole) {
		return getId() == secRole.getId();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj instanceof SecRole) {
			SecRole secRole = (SecRole) obj;
			return equals(secRole);
		}

		return false;
	}

	public String toString() {
		return new ToStringBuilder(this).append("id", getId()).toString();
	}

}
