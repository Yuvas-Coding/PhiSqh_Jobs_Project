package my.com.cmg.iwp.maintenance.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class NotificationFacilityV1823 implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private long nfSeqno;
	private Character activeFlag;
	private Long createdBy;
	private Date createdDate;
	private String fromRqstrCode;
	private String fromFacilityCode;
	private String fromPtjCode;
	private String parameter1;
	private String parameter2;
	private BigDecimal parameter3;
	private BigDecimal parameter4;
	private Date parameter5;
	private String status;
	private String toRqstrCode;
	private String toFacilityCode;
	private String toPtjCode;
	private Long updatedBy;
	private Date updatedDate;
	private String requesterDesc;
	private NotificationHdrV1823 notificationHdr;
	private Long notificationHdrSeqno;

	public NotificationFacilityV1823() {
	}

	public NotificationFacilityV1823(long nfSeqno) {
		super();
		this.nfSeqno = nfSeqno;
	}



	@Id
	@SequenceGenerator(name = "NOTIFICATION_FACILITY_SEQ", sequenceName = "T_NOTIFICATION_FACILITY_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NOTIFICATION_FACILITY_SEQ")
	@Column(name = "NF_SEQNO", unique = true, nullable = false, precision = 38, scale = 0)
	public long getNfSeqno() {
		return this.nfSeqno;
	}

	public void setNfSeqno(long nfSeqno) {
		this.nfSeqno = nfSeqno;
	}

	@Column(name = "active_flag")
	public Character getActiveFlag() {
		return this.activeFlag;
	}

	public void setActiveFlag(Character activeFlag) {
		this.activeFlag = activeFlag;
	}

	@Column(name = "created_by")
	public Long getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date")
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "f_rqstr_code")
	public String getFromRqstrCode() {
		return this.fromRqstrCode;
	}

	public void setFromRqstrCode(String fromRqstrCode) {
		this.fromRqstrCode = fromRqstrCode;
	}

	@Column(name = "from_facility_code")
	public String getFromFacilityCode() {
		return this.fromFacilityCode;
	}

	public void setFromFacilityCode(String fromFacilityCode) {
		this.fromFacilityCode = fromFacilityCode;
	}

	@Column(name = "from_ptj_code")
	public String getFromPtjCode() {
		return this.fromPtjCode;
	}

	public void setFromPtjCode(String fromPtjCode) {
		this.fromPtjCode = fromPtjCode;
	}

	public String getParameter1() {
		return this.parameter1;
	}

	public void setParameter1(String parameter1) {
		this.parameter1 = parameter1;
	}

	public String getParameter2() {
		return this.parameter2;
	}

	public void setParameter2(String parameter2) {
		this.parameter2 = parameter2;
	}

	public BigDecimal getParameter3() {
		return this.parameter3;
	}

	public void setParameter3(BigDecimal parameter3) {
		this.parameter3 = parameter3;
	}

	public BigDecimal getParameter4() {
		return this.parameter4;
	}

	public void setParameter4(BigDecimal parameter4) {
		this.parameter4 = parameter4;
	}

	@Temporal(TemporalType.DATE)
	public Date getParameter5() {
		return this.parameter5;
	}

	public void setParameter5(Date parameter5) {
		this.parameter5 = parameter5;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "t_rqstr_code")
	public String getToRqstrCode() {
		return this.toRqstrCode;
	}

	public void setToRqstrCode(String toRqstrCode) {
		this.toRqstrCode = toRqstrCode;
	}

	@Column(name = "to_facility_code")
	public String getToFacilityCode() {
		return this.toFacilityCode;
	}

	public void setToFacilityCode(String toFacilityCode) {
		this.toFacilityCode = toFacilityCode;
	}

	@Column(name = "to_ptj_code")
	public String getToPtjCode() {
		return this.toPtjCode;
	}

	public void setToPtjCode(String toPtjCode) {
		this.toPtjCode = toPtjCode;
	}

	@Column(name = "updated_by")
	public Long getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_date")
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	// bi-directional many-to-one association to NotificationHdr
	@ManyToOne
	@JoinColumn(name = "n_hdr_seqno")
	@JsonBackReference
	public NotificationHdrV1823 getNotificationHdr() {
		return this.notificationHdr;
	}

	public void setNotificationHdr(NotificationHdrV1823 notificationHdr) {
		this.notificationHdr = notificationHdr;
	}
	@Column(name = "requester_desc", length = 50)
	public String getRequesterDesc() {
		return requesterDesc;
	}


	/**
	 * @param requesterDesc the requesterDesc to set
	 */
	public void setRequesterDesc(String requesterDesc) {
		this.requesterDesc = requesterDesc;
	}

	@Column(name = "n_hdr_seqno", insertable = false, updatable = false)
	public Long getNotificationHdrSeqno() {
		return notificationHdrSeqno;
	}

	public void setNotificationHdrSeqno(Long notificationHdrSeqno) {
		this.notificationHdrSeqno = notificationHdrSeqno;
	}
	
	
}