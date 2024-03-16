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
import org.hibernate.annotations.Loader;
import org.hibernate.annotations.NamedQuery;

/**
 * EN: Model class for <b>SecRight</b>.<br>
 * DE: Model Klasse fuer <b>Recht</b>.<br>
 */
@Entity
@Table(name = "t_sec_right", uniqueConstraints = @UniqueConstraint(columnNames = "rig_name"))
@Loader(namedQuery = "allRightFromUserSqlQuery")
@NamedQuery(name = "allRightFromUserSqlQuery", query = "SELECT distinct r FROM SecRight r JOIN r.secGrouprights AS gr JOIN gr.secGroup.secRolegroups AS rg JOIN rg.secRole.secUserroles AS ur JOIN ur.secUser AS u WHERE u.id = ? ")
public class SecRight implements java.io.Serializable {

	private static final long serialVersionUID = -1574628715506591010L;

	private long id = Long.MIN_VALUE;
	private int version;
	private Integer rigType;
	private String rigName;
	private String rigDesc;
	/*
	 * private long createBy; private Date createDate; private long updateBy;
	 * private Date updateDate;
	 */
	private Set<SecGroupright> secGrouprights = new HashSet<SecGroupright>(0);

	public SecRight() {
	}

	public SecRight(long id, String rigName) {
		this.setId(id);
		this.rigName = rigName;
	}

	public SecRight(long id, Integer rigType, String rigName,
			Set<SecGroupright> secGrouprights, String rigDesc) {
		this.setId(id);
		this.rigType = rigType;
		this.rigName = rigName;
		this.secGrouprights = secGrouprights;
		this.rigDesc = rigDesc;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Id
	@Column(name = "rig_id", unique = true, nullable = false)
	@SequenceGenerator(name = "rightSEQ", sequenceName = "t_sec_right_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rightSEQ")
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

	@Column(name = "rig_type")
	public Integer getRigType() {
		return this.rigType;
	}

	public void setRigType(Integer rigType) {
		this.rigType = rigType;
	}

	@Column(name = "rig_name", unique = true, nullable = false, length = 50)
	public String getRigName() {
		return this.rigName;
	}

	public void setRigName(String rigName) {
		this.rigName = rigName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "secRight")
	public Set<SecGroupright> getSecGrouprights() {
		return this.secGrouprights;
	}

	public void setSecGrouprights(Set<SecGroupright> secGrouprights) {
		this.secGrouprights = secGrouprights;
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

	public boolean equals(SecRight secRight) {
		return getId() == secRight.getId();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj instanceof SecRight) {
			SecRight secRight = (SecRight) obj;
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
