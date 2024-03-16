package my.com.cmg.iwp.maintenance.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_REF_CODES")
public class RefCodes implements Serializable {
	private static final long serialVersionUID = 1L;
	private long rcSeq = Long.MIN_VALUE;
	private String rcDomain;
	private String rcValue;
	private String rcDesc;
	private String rcStatus;
	private String rcRemarks;
	private String createdBy;
	private Date createdDate;
	private String updatedBy;
	private Date updatedDate;
	private String paramter1;
	private String rcSmrpValue;
	
	public RefCodes() {
	}

	public RefCodes(long rcSeq) {
		this.rcSeq = rcSeq;
	}

	@Id
	@Column(name = "rc_seq", unique = true, nullable = false)
	@SequenceGenerator(name = "refCodeSeq", sequenceName = "T_REF_CODES_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "refCodeSeq")
	public long getRcSeq() {
		return this.rcSeq;
	}

	public void setRcSeq(long rcSeq) {
		this.rcSeq = rcSeq;
	}

	@Column(name = "rc_domain", length = 50)
	public String getRcDomain() {
		return rcDomain;
	}

	public void setRcDomain(String rcDomain) {
		this.rcDomain = rcDomain;
	}

	@Column(name = "rc_value", length = 20)
	public String getRcValue() {
		return rcValue;
	}

	public void setRcValue(String rcValue) {
		this.rcValue = rcValue;
	}

	@Column(name = "rc_desc", length = 500)
	public String getRcDesc() {
		return rcDesc;
	}

	public void setRcDesc(String rcDesc) {
		this.rcDesc = rcDesc;
	}

	@Column(name = "active_flag", length = 1)
	public String getRcStatus() {
		return rcStatus;
	}

	public void setRcStatus(String rcStatus) {
		this.rcStatus = rcStatus;
	}

	@Column(name = "rc_remarks", length = 200)
	public String getRcRemarks() {
		return this.rcRemarks;
	}

	public void setRcRemarks(String rcRemarks) {
		this.rcRemarks = rcRemarks;
	}

	@Column(name = "created_by", nullable = false)
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", nullable = false, length = 29)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "updated_by", nullable = false)
	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_date", nullable = false, length = 29)
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Column(name = "parameter1", length = 200)
	public String getParamter1() {
		return paramter1;
	}

	public void setParamter1(String paramter1) {
		this.paramter1 = paramter1;
	}

	@Column(name = "rc_smrp_value")
	public String getRcSmrpValue() {
		return rcSmrpValue;
	}

	public void setRcSmrpValue(String rcSmrpValue) {
		this.rcSmrpValue = rcSmrpValue;
	}
}