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
package my.com.cmg.iwp.maintenance.model.fcSecurityModel;

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
@Table(name = "T_FAC_SEC_ROLE", uniqueConstraints = @UniqueConstraint(columnNames = "rol_shortdescription"))
public class FcSecRoles implements java.io.Serializable {

	private static final long serialVersionUID = -7966378689254650569L;
	private long id = Long.MIN_VALUE;
	private int version;
	private String rolShortdescription;
	private String rolLongdescription;
	private Character activeFlag = RefCodeConstant.ACTIVE_FLAG_TRUE;
	private Long createdBy;
	private Date createdDate;
	private Long updatedBy;
	private Date updatedDate;
	/*
	 * private long createBy; private Date createDate; private long updateBy; private Date updateDate;
	 */
	/* private Set<SecUserrole> secUserroles = new HashSet<SecUserrole>(0); */
	private Set<FcSecRolegroups> secRolegroups = new HashSet<FcSecRolegroups>(0);

	public FcSecRoles() {
	}

	public FcSecRoles(long id, String rolShortdescription) {
		this.setId(id);
		this.rolShortdescription = rolShortdescription;
	}

	public FcSecRoles(long id, String rolShortdescription, String rolLongdescription, Set<FcSecRolegroups> secRolegroups) {
		this.setId(id);
		this.rolShortdescription = rolShortdescription;
		this.rolLongdescription = rolLongdescription;
		// this.secUserroles = secUserroles;
		this.secRolegroups = secRolegroups;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Id
	@Column(name = "rol_id", unique = true, nullable = false)
	@SequenceGenerator(name = "roleSEQ", sequenceName = "T_FAC_SEC_ROLE_SEQ", allocationSize = 1)
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

	/*
	 * @OneToMany(fetch = FetchType.LAZY, mappedBy = "secRole") public Set<SecUserrole> getSecUserroles() { return this.secUserroles; } public void setSecUserroles(Set<SecUserrole> secUserroles) { this.secUserroles = secUserroles; }
	 */

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "secRole")
	public Set<FcSecRolegroups> getSecRolegroups() {
		return this.secRolegroups;
	}

	public void setSecRolegroups(Set<FcSecRolegroups> secRolegroups) {
		this.secRolegroups = secRolegroups;
	}
	
	@Column(name="ACTIVE_FLAG") 
	public Character getActiveFlag() { 
		return activeFlag; 
	}
	
	public void setActiveFlag(Character activeFlag) { 
		this.activeFlag = activeFlag; 
	}
	
	@Column(name="CREATED_BY")
	public Long getCreatedBy() { 
		return createdBy; 
	}
	public void setCreatedBy(Long createdBy) { 
		this.createdBy = createdBy; 
	}

	@Temporal( TemporalType.TIMESTAMP)
	@Column(name="CREATED_DATE", nullable = false, length = 29)
	public Date getCreatedDate() { 
		return createdDate; 
	}
	public void setCreatedDate(Date createdDate) { 
		this.createdDate = createdDate; 
	}
	
	 @Column(name="UPDATED_BY")
	public Long getUpdatedBy() { 
		 return this.updatedBy; 
		}
	public void setUpdatedBy(Long updatedBy) { 
		this.updatedBy = updatedBy; 
	}
	
	@Temporal( TemporalType.TIMESTAMP)
	@Column(name="UPDATED_DATE", nullable = false, length = 29)
	public Date getUpdatedDate() { 
		return updatedDate; 
	}
	public void setUpdatedDate(Date updatedDate) { 
		this.updatedDate = updatedDate; 
	}

	/*
	 * @Column(name = "create_by") public long getCreateBy() { return this.createBy; } public void setCreateBy(long createBy) { this.createBy = createBy; }
	 * @Temporal(TemporalType.TIMESTAMP)
	 * @Column(name = "create_date", length = 29) public Date getCreateDate() { return this.createDate; } public void setCreateDate(Date createDate) { this.createDate = createDate; }
	 * @Column(name = "update_by") public long getUpdateBy() { return this.updateBy; } public void setUpdateBy(long updateBy) { this.updateBy = updateBy; }
	 * @Temporal(TemporalType.TIMESTAMP)
	 * @Column(name = "update_date", length = 29) public Date getUpdateDate() { return this.updateDate; } public void setUpdateDate(Date updateDate) { this.updateDate = updateDate; }
	 */
	@Override
	public int hashCode() {
		return Long.valueOf(getId()).hashCode();
	}

	public boolean equals(FcSecRoles secRole) {
		return getId() == secRole.getId();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj instanceof FcSecRoles) {
			FcSecRoles secRole = (FcSecRoles) obj;
			return equals(secRole);
		}

		return false;
	}

	public String toString() {
		return new ToStringBuilder(this).append("id", getId()).toString();
	}

}
