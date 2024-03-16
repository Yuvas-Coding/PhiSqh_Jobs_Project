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
 * EN: Model class for <b>SecGroupright</b>.<br>
 * DE: Model Klasse fuer <b>Gruppenrechte</b>.<br>
 */
@Entity
@Table(name = "t_sec_groupright", uniqueConstraints = @UniqueConstraint(columnNames = {
		"grp_id", "rig_id" }))
public class SecGroupright implements java.io.Serializable {

	private static final long serialVersionUID = 9206102047641563556L;

	private long id = Long.MIN_VALUE;
	private int version;
	private SecGroup secGroup;
	private SecRight secRight;

	/*
	 * private long createBy; private Date createDate; private long updateBy;
	 * private Date updateDate;
	 */
	public SecGroupright() {
	}

	public SecGroupright(long id) {
		this.setId(id);
	}

	public SecGroupright(long id, SecGroup secGroup, SecRight secRight) {
		this.setId(id);
		this.secGroup = secGroup;
		this.secRight = secRight;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Id
	@Column(name = "gri_id", unique = true, nullable = false)
	@SequenceGenerator(name = "groupRightSEQ", sequenceName = "t_sec_groupright_seq", allocationSize = 1)
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
	public SecGroup getSecGroup() {
		return this.secGroup;
	}

	public void setSecGroup(SecGroup secGroup) {
		this.secGroup = secGroup;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rig_id", nullable = false)
	public SecRight getSecRight() {
		return this.secRight;
	}

	public void setSecRight(SecRight secRight) {
		this.secRight = secRight;
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

	public boolean equals(SecGroupright secGroupright) {
		return getId() == secGroupright.getId();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj instanceof SecGroupright) {
			SecGroupright secGroupright = (SecGroupright) obj;
			return equals(secGroupright);
		}

		return false;
	}

	public String toString() {
		return new ToStringBuilder(this).append("id", getId()).toString();
	}

}
