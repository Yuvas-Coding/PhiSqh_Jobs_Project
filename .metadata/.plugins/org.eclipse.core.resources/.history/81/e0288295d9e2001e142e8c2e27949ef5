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
 * EN: Model class for <b>SecGroupright</b>.<br>
 * DE: Model Klasse fuer <b>Gruppenrechte</b>.<br>
 * 
 * @author bbruhns
 * @author sgerth
 */
@Entity
@Table(name = "T_FAC_SEC_GROUPRIGHT", uniqueConstraints = @UniqueConstraint(columnNames = { "grp_id", "rig_id" }))
public class FcSecGrouprights implements java.io.Serializable {

	private static final long serialVersionUID = 9206102047641563556L;

	private long id = Long.MIN_VALUE;
	private int version;
	private FcSecGroups secGroup;
	private FcSecRights secRight;

	/*
	 * private long createBy; private Date createDate; private long updateBy; private Date updateDate;
	 */
	public FcSecGrouprights() {
	}

	public FcSecGrouprights(long id) {
		this.setId(id);
	}

	public FcSecGrouprights(long id, FcSecGroups secGroup, FcSecRights secRight) {
		this.setId(id);
		this.secGroup = secGroup;
		this.secRight = secRight;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Id
	@Column(name = "gri_id", unique = true, nullable = false)
	@SequenceGenerator(name = "groupRightSEQ", sequenceName = "T_FAC_SEC_GROUPRIGHT_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "groupRightSEQ")
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
	@JoinColumn(name = "grp_id", nullable = false)
	public FcSecGroups getSecGroup() {
		return this.secGroup;
	}

	public void setSecGroup(FcSecGroups secGroup) {
		this.secGroup = secGroup;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rig_id", nullable = false)
	public FcSecRights getSecRight() {
		return this.secRight;
	}

	public void setSecRight(FcSecRights secRight) {
		this.secRight = secRight;
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

	public boolean equals(FcSecGrouprights secGroupright) {
		return getId() == secGroupright.getId();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj instanceof FcSecGrouprights) {
			FcSecGrouprights secGroupright = (FcSecGrouprights) obj;
			return equals(secGroupright);
		}

		return false;
	}

	public String toString() {
		return new ToStringBuilder(this).append("id", getId()).toString();
	}

}
