package my.com.cmg.iwp.maintenance.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "T_AUTH_VALIDITY", uniqueConstraints = @UniqueConstraint(columnNames = "SEQ_NO"))
public class AuthValidity implements Serializable {
	private static final long serialVersionUID = 1L;
	private long authSeqNo = Long.MIN_VALUE;
	private String sid;
	private int validity;
	private Date effectiveDateTime;
	private Date createDate;
	private String createBy;
	private Date updateDate;
	private String updateBy;

	public AuthValidity() {
	}

	public AuthValidity(long authSeqNo, String sid, int validity,
			Date effectiveDateTime, String createBy, Date createDate,
			String updateBy, Date updateDate) {
		this.authSeqNo = authSeqNo;
		this.sid = sid;
		this.validity = validity;
		this.effectiveDateTime = effectiveDateTime;
		this.createBy = createBy;
		this.createDate = createDate;
		this.updateBy = updateBy;
		this.updateDate = updateDate;
	}

	@Id
	@Column(name = "SEQ_NO", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "authValidSEQ")
	public long getAuthSeqNo() {
		return this.authSeqNo;
	}

	public void setAuthSeqNo(long authSeqNo) {
		this.authSeqNo = authSeqNo;
	}

	@Column(name = "SID")
	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	@Column(name = "VALIDITY")
	public int getValidity() {
		return validity;
	}

	public void setValidity(int validity) {
		this.validity = validity;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EFFECTIVE_TIME")
	public Date getEffectiveDateTime() {
		return effectiveDateTime;
	}

	public void setEffectiveDateTime(Date effectiveDateTime) {
		this.effectiveDateTime = effectiveDateTime;
	}

	@Column(name = "CREATE_BY")
	public String getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_DATE", nullable = false, length = 29)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name = "LAST_UPD_BY")
	public String getUpdateBy() {
		return this.updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_UPD_DATE", nullable = true, length = 29)
	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}