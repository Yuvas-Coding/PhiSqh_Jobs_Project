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
 * EN: Model class for <b>SecRight</b>.<br>
 * DE: Model Klasse fuer <b>Recht</b>.<br>
 * 
 * @author bbruhns
 * @author sgerth
 */
@Entity
@Table(name = "T_FAC_SEC_RIGHT", uniqueConstraints = @UniqueConstraint(columnNames = "rig_name"))
public class FcSecRights implements java.io.Serializable {

	private static final long serialVersionUID = -1574628715506591010L;

	private Long id;
	private int version;
	private Integer rigType;
	private String rigName;
	private String rigDesc;
	/*
	 * private long createBy; private Date createDate; private long updateBy; private Date updateDate;
	 */
	private Set<FcSecGrouprights> secGrouprights = new HashSet<FcSecGrouprights>(0);

	public FcSecRights() {
	}

	public FcSecRights(Long id, String rigName) {
		this.setId(id);
		this.rigName = rigName;
	}

	public FcSecRights(Long id, Integer rigType, String rigName, Set<FcSecGrouprights> secGrouprights, String rigDesc) {
		this.setId(id);
		this.rigType = rigType;
		this.rigName = rigName;
		this.secGrouprights = secGrouprights;
		this.rigDesc = rigDesc;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Id
	@Column(name = "rig_id", unique = true, nullable = false)
	@SequenceGenerator(name = "rightSEQ", sequenceName = "T_FAC_SEC_RIGHT_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rightSEQ")
	public Long getId() {
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

	@Column(name = "rig_type")
	public Integer getRigType() {
		return this.rigType;
	}

	public void setRigType(Integer rigType) {
		this.rigType = rigType;
	}

	@Column(name = "rig_name", unique = true, nullable = false, length = 100)
	public String getRigName() {
		return this.rigName;
	}

	public void setRigName(String rigName) {
		this.rigName = rigName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "secRight")
	public Set<FcSecGrouprights> getSecGrouprights() {
		return this.secGrouprights;
	}

	public void setSecGrouprights(Set<FcSecGrouprights> secGrouprights) {
		this.secGrouprights = secGrouprights;
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

	public boolean equals(FcSecRights secRight) {
		return getId() == secRight.getId();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj instanceof FcSecRights) {
			FcSecRights secRight = (FcSecRights) obj;
			return equals(secRight);
		}

		return false;
	}

	public String toString() {
		return new ToStringBuilder(this).append("id", getId()).toString();
	}

	public void setRigDesc(String rigDesc) {
		this.rigDesc = rigDesc;
	}

	@Column(name = "rig_desc")
	public String getRigDesc() {
		return rigDesc;
	}
}
