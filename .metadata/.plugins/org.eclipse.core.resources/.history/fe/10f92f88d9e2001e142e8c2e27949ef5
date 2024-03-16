package my.com.cmg.iwp.maintenance.model;

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

@Entity
@Table(name = "t_sec_group", uniqueConstraints = @UniqueConstraint(columnNames = "grp_shortdescription"))
public class SecGroup implements java.io.Serializable {

	private static final long serialVersionUID = -3284638212223216652L;

	private long id = Long.MIN_VALUE;
	private int version;
	private String grpShortdescription;
	private String grpLongdescription;
	/*
	 * private long createBy; private Date createDate; private long updateBy;
	 * private Date updateDate;
	 */
	private Set<SecGroupright> secGrouprights = new HashSet<SecGroupright>(0);
	private Set<SecRolegroup> secRolegroups = new HashSet<SecRolegroup>(0);

	public SecGroup() {
	}

	public SecGroup(long id, String grpShortdescription) {
		this.setId(id);
		this.grpShortdescription = grpShortdescription;
	}

	public SecGroup(long id, String grpShortdescription,
			String grpLongdescription, Set<SecGroupright> secGrouprights,
			Set<SecRolegroup> secRolegroups) {
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
	@SequenceGenerator(name = "groupSEQ", sequenceName = "t_sec_group_seq", allocationSize = 1)
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
	public Set<SecGroupright> getSecGrouprights() {
		return this.secGrouprights;
	}

	public void setSecGrouprights(Set<SecGroupright> secGrouprights) {
		this.secGrouprights = secGrouprights;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "secGroup")
	public Set<SecRolegroup> getSecRolegroups() {
		return this.secRolegroups;
	}

	public void setSecRolegroups(Set<SecRolegroup> secRolegroups) {
		this.secRolegroups = secRolegroups;
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

	public boolean equals(SecGroup secGroup) {
		return getId() == secGroup.getId();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj instanceof SecGroup) {
			SecGroup secGroup = (SecGroup) obj;
			return equals(secGroup);
		}

		return false;
	}

	public String toString() {
		return new ToStringBuilder(this).append("id", getId()).toString();
	}

}
