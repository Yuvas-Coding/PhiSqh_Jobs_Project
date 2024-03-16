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
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * EN: Model class for <b>SecGroup</b>.<br>
 * DE: Model Klasse fuer <b>Rechte Gruppen</b>.<br>
 * 
 * @author bbruhns
 * @author sgerth
 */
@Entity
@Table(name = "T_FAC_SEC_GROUP", uniqueConstraints = @UniqueConstraint(columnNames = "grp_shortdescription"))
public class FcSecGroups implements java.io.Serializable {

	private static final long serialVersionUID = -3284638212223216652L;

	private long id = Long.MIN_VALUE;
	private int version;
	private String grpShortdescription;
	private String grpLongdescription;
	/*
	 * private long createBy; private Date createDate; private long updateBy; private Date updateDate;
	 */
	private Set<FcSecGrouprights> secGrouprights = new HashSet<FcSecGrouprights>(0);
	private Set<FcSecRolegroups> secRolegroups = new HashSet<FcSecRolegroups>(0);

	public FcSecGroups() {
	}

	public FcSecGroups(long id, String grpShortdescription) {
		this.setId(id);
		this.grpShortdescription = grpShortdescription;
	}

	public FcSecGroups(long id, String grpShortdescription, String grpLongdescription, Set<FcSecGrouprights> secGrouprights, Set<FcSecRolegroups> secRolegroups) {
		this.setId(id);
		this.grpShortdescription = grpShortdescription;
		this.grpLongdescription = grpLongdescription;
		this.secGrouprights = secGrouprights;
		this.secRolegroups = secRolegroups;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Id
	@Column(name = "grp_id", unique = true, nullable = false)
	@SequenceGenerator(name = "groupSEQ", sequenceName = "T_FAC_SEC_GROUP_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "groupSEQ")
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

	@Column(name = "grp_shortdescription", unique = true, nullable = false, length = 30)
	public String getGrpShortdescription() {
		return this.grpShortdescription;
	}

	public void setGrpShortdescription(String grpShortdescription) {
		this.grpShortdescription = grpShortdescription;
	}

	@Column(name = "grp_longdescription", length = 1000)
	public String getGrpLongdescription() {
		return this.grpLongdescription;
	}

	public void setGrpLongdescription(String grpLongdescription) {
		this.grpLongdescription = grpLongdescription;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "secGroup")
	public Set<FcSecGrouprights> getSecGrouprights() {
		return this.secGrouprights;
	}

	public void setSecGrouprights(Set<FcSecGrouprights> secGrouprights) {
		this.secGrouprights = secGrouprights;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "secGroup")
	public Set<FcSecRolegroups> getSecRolegroups() {
		return this.secRolegroups;
	}

	public void setSecRolegroups(Set<FcSecRolegroups> secRolegroups) {
		this.secRolegroups = secRolegroups;
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

	public boolean equals(FcSecGroups secGroup) {
		return getId() == secGroup.getId();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj instanceof FcSecGroups) {
			FcSecGroups secGroup = (FcSecGroups) obj;
			return equals(secGroup);
		}

		return false;
	}

	public String toString() {
		return new ToStringBuilder(this).append("id", getId()).toString();
	}

}
