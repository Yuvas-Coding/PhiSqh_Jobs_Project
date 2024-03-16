package my.com.cmg.iwp.maintenance.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonManagedReference;

@XmlRootElement(name = "NotificationHdr")
@JsonIgnoreProperties(ignoreUnknown=true)
public class NotificationHdrV1823 implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long notificationHdrSeqno;
	private Character activeFlag;
	private Long createdBy;
	private Date createdDate;
	private String extNRefNoPk;
	private String fromFacilityCode;
	private String fromPtjCode;
	private String categories;
	private Date notificationEndDate;
	private String itemGroup;
	private Date notificationDate;
	private String notificationHdrNo;
	private String period;
	private String prodRecallDegree;
	private String reasonCode;
	private Long refNoPk;
	private String remarks;
	private Date notificationStartDate;
	private String status;
	private String title;
	private String typeOfRecall;
	private String where;
	private String parameter1;
	private String parameter2;
	private BigDecimal parameter3;
	private BigDecimal parameter4;
	private Date parameter5;
	private Long updatedBy;
	private Date updatedDate;
	private String notificationUrl;
	private Date manufacturerLetterDate;
	private String notificationReference;
	private String contactPreson;
	private String usrContact;
	private String emailId;
	private Date extCreatedDate;
	private byte[] hdrAttachment;
	private Set<NotificationDtlV1823> notificationDtls = new HashSet<NotificationDtlV1823>(0);
	private Set<NotificationFacilityV1823> notificationFacilities = new HashSet<NotificationFacilityV1823>(0);
	private Date biroNotiDate;
	private Date expNotiDate;
	private String othersReason;
	private String drugNondrugDesc;
	private String drugNondrugCode;
	private String hdrAttachment_name;
	
	public NotificationHdrV1823() {
	}

	public NotificationHdrV1823(Long notificationHdrSeqno) {
		this.notificationHdrSeqno = notificationHdrSeqno;
	}

	@Id
	@SequenceGenerator(name = "NOTIFICATION_HDR_SEQ", sequenceName = "T_NOTIFICATION_HDR_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NOTIFICATION_HDR_SEQ")
	@Column(name = "N_HDR_SEQNO", unique = true, nullable = false, precision = 38, scale = 0)
	public Long getNotificationHdrSeqno() {
		return this.notificationHdrSeqno;
	}

	public void setNotificationHdrSeqno(Long notificationHdrSeqno) {
		this.notificationHdrSeqno = notificationHdrSeqno;
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

	@Column(name = "ext_n_ref_no_pk")
	public String getExtNRefNoPk() {
		return this.extNRefNoPk;
	}

	public void setExtNRefNoPk(String extNRefNoPk) {
		this.extNRefNoPk = extNRefNoPk;
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

	@Column(name = "n_categories")
	public String getCategories() {
		return this.categories;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "n_end_date")
	public Date getNotificationEndDate() {
		return this.notificationEndDate;
	}

	public void setNotificationEndDate(Date notificationEndDate) {
		this.notificationEndDate = notificationEndDate;
	}

	@Column(name = "n_item_group")
	public String getItemGroup() {
		return this.itemGroup;
	}

	public void setItemGroup(String itemGroup) {
		this.itemGroup = itemGroup;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "n_notification_date")
	public Date getNotificationDate() {
		return this.notificationDate;
	}

	public void setNotificationDate(Date notificationDate) {
		this.notificationDate = notificationDate;
	}

	@Column(name = "n_notification_hdr_no")
	public String getNotificationHdrNo() {
		return this.notificationHdrNo;
	}

	public void setNotificationHdrNo(String notificationHdrNo) {
		this.notificationHdrNo = notificationHdrNo;
	}

	@Column(name = "n_period")
	public String getPeriod() {
		return this.period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	@Column(name = "n_prod_recall_degree")
	public String getProdRecallDegree() {
		return this.prodRecallDegree;
	}

	public void setProdRecallDegree(String prodRecallDegree) {
		this.prodRecallDegree = prodRecallDegree;
	}

	@Column(name = "n_reason_code")
	public String getReasonCode() {
		return this.reasonCode;
	}

	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}

	@Column(name = "n_ref_no_pk")
	public Long getRefNoPk() {
		return this.refNoPk;
	}

	public void setRefNoPk(Long refNoPk) {
		this.refNoPk = refNoPk;
	}

	@Column(name = "n_remarks")
	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "n_start_date")
	public Date getNotificationStartDate() {
		return this.notificationStartDate;
	}

	public void setNotificationStartDate(Date notificationStartDate) {
		this.notificationStartDate = notificationStartDate;
	}

	@Column(name = "n_status")
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "n_title")
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "n_type_of_recall")
	public String getTypeOfRecall() {
		return this.typeOfRecall;
	}

	public void setTypeOfRecall(String typeOfRecall) {
		this.typeOfRecall = typeOfRecall;
	}

	@Column(name = "n_where")
	public String getWhere() {
		return this.where;
	}

	public void setWhere(String where) {
		this.where = where;
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

	// bi-directional many-to-one association to NotificationDtl
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "notificationHdr")
	@JsonManagedReference
	public Set<NotificationDtlV1823> getNotificationDtls() {
		return this.notificationDtls;
	}

	public void setNotificationDtls(Set<NotificationDtlV1823> notificationDtls) {
		this.notificationDtls = notificationDtls;
	}

	// bi-directional many-to-one association to NotificationFacility
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "notificationHdr",cascade=CascadeType.ALL)
	@JsonManagedReference
	public Set<NotificationFacilityV1823> getNotificationFacilities() {
		return this.notificationFacilities;
	}

	public void setNotificationFacilities(
			Set<NotificationFacilityV1823> notificationFacilities) {
		this.notificationFacilities = notificationFacilities;
	}

	@Column(name = "notification_url")
	public String getNotificationUrl() {
		return notificationUrl;
	}

	public void setNotificationUrl(String notificationUrl) {
		this.notificationUrl = notificationUrl;
	}

	@Column(name = "NOTIFY_LETTER_DATE")
	@JsonIgnore
	public Date getManufacturerLetterDate() {
		return manufacturerLetterDate;
	}

	public void setManufacturerLetterDate(Date manufacturerLetterDate) {
		this.manufacturerLetterDate = manufacturerLetterDate;
	}
	@Column(name = "REFRENCE_NO")
	@JsonIgnore
	public String getNotificationReference() {
		return notificationReference;
	}

	public void setNotificationReference(String notificationReference) {
		this.notificationReference = notificationReference;
	}

	@Column(name="contact_person")
	public String getContactPreson() {
		return contactPreson;
	}

	public void setContactPreson(String contactPreson) {
		this.contactPreson = contactPreson;
	}

	@Column(name="user_contact")
	public String getUsrContact() {
		return usrContact;
	}

	public void setUsrContact(String usrContact) {
		this.usrContact = usrContact;
	}
	@Column(name="email_id")
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Column(name="ext_created_date")
	public Date getExtCreatedDate() {
		return extCreatedDate;
	}

	public void setExtCreatedDate(Date extCreatedDate) {
		this.extCreatedDate = extCreatedDate;
	}
	@Column(name="NHDR_ATTACHMENT")
	public byte[] getHdrAttachment() {
		return hdrAttachment;
	}

	public void setHdrAttachment(byte[] hdrAttachment) {
		this.hdrAttachment = hdrAttachment;
	}

	@Column(name = "biro_noti_date")
	public Date getBiroNotiDate() {
		return biroNotiDate;
	}

	public void setBiroNotiDate(Date biroNotiDate) {
		this.biroNotiDate = biroNotiDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "exp_notifi_date")
	public Date getExpNotiDate() {
		return expNotiDate;
	}

	public void setExpNotiDate(Date expNotiDate) {
		this.expNotiDate = expNotiDate;
	}

	@Column(name = "n_others_reason")
	@JsonIgnore
	public String getOthersReason() {
		return othersReason;
	}

	public void setOthersReason(String othersReason) {
		this.othersReason = othersReason;
	}

	@Column(name = "n_drug_nondrug_desc")
	@JsonIgnore
	public String getDrugNondrugDesc() {
		return drugNondrugDesc;
	}

	public void setDrugNondrugDesc(String drugNondrugDesc) {
		this.drugNondrugDesc = drugNondrugDesc;
	}

	@Column(name = "n_drug_nondrug_code")
	@JsonIgnore
	public String getDrugNondrugCode() {
		return drugNondrugCode;
	}

	public void setDrugNondrugCode(String drugNondrugCode) {
		this.drugNondrugCode = drugNondrugCode;
	}
	
	@Column(name = "hdrAttachment_name")
	@JsonIgnore
	public String getHdrAttachment_name() {
		return hdrAttachment_name;
	}

	public void setHdrAttachment_name(String hdrAttachment_name) {
		this.hdrAttachment_name = hdrAttachment_name;
	}

}
