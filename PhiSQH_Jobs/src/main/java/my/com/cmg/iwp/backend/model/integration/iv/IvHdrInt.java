package my.com.cmg.iwp.backend.model.integration.iv;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * The persistent class for the ph_iv_hdr_int database table.
 * 
 */
@Entity
@Table(name = "t_iv_hdr_int")
@XmlRootElement(name = "IvHdrInt")
@JsonIgnoreProperties(ignoreUnknown=true)
public class IvHdrInt implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long ivHdrIntSeqno;
	private String city;
	private String country;
	private Long createdBy;
	private Date createdDate;
	private String facCode;
	private BigDecimal height;
	private String homeContactNo;
	private String isProcessed;
	private String mobileContactNo;
	private String nationality;
	private String occupation;
	private String officeContactNo;
	private String orderType;
	private String parameter1;
	private String parameter2;
	private BigDecimal parameter3;
	private BigDecimal parameter4;
	private Date parameter5;
	private String patientAddress1;
	private String patientAddress2;
	private String patientAddress3;
	private Date patientDob;
	private String patientGender;
	private String patientId;
	private String patientIdType;
	private String patientMrn;
	private String patientName;
	private String patientRemarks;
	private String patientState;
	private String ptjCode;
	private String referredPtjTo;
	private String referredTo;
	private String religion;
	private Date requestDate;
	private String sendFlag;
	private Long updatedBy;
	private Date updatedDate;
	private Date visitDate;
	private String visitNumber;
	private BigDecimal weight;
	// private OutsourceOrderInt outsourceOrderInt;
	private List<OrderIvInt> orderIvInts;

	public IvHdrInt() {
	}

	@Id
	@SequenceGenerator(name = "PH_IV_HDR_INT_IVHDRINTSEQNO_GENERATOR", sequenceName = "t_iv_hdr_int_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PH_IV_HDR_INT_IVHDRINTSEQNO_GENERATOR")
	@Column(name = "iv_hdr_int_seqno")
	public Long getIvHdrIntSeqno() {
		return this.ivHdrIntSeqno;
	}

	public void setIvHdrIntSeqno(Long ivHdrIntSeqno) {
		this.ivHdrIntSeqno = ivHdrIntSeqno;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
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

	@Column(name = "fac_code")
	public String getFacCode() {
		return this.facCode;
	}

	public void setFacCode(String facCode) {
		this.facCode = facCode;
	}

	public BigDecimal getHeight() {
		return this.height;
	}

	public void setHeight(BigDecimal height) {
		this.height = height;
	}

	@Column(name = "home_contact_no")
	public String getHomeContactNo() {
		return this.homeContactNo;
	}

	public void setHomeContactNo(String homeContactNo) {
		this.homeContactNo = homeContactNo;
	}

	@Column(name = "is_processed")
	public String getIsProcessed() {
		return this.isProcessed;
	}

	public void setIsProcessed(String isProcessed) {
		this.isProcessed = isProcessed;
	}

	@Column(name = "mobile_contact_no")
	public String getMobileContactNo() {
		return this.mobileContactNo;
	}

	public void setMobileContactNo(String mobileContactNo) {
		this.mobileContactNo = mobileContactNo;
	}

	public String getNationality() {
		return this.nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getOccupation() {
		return this.occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	@Column(name = "office_contact_no")
	public String getOfficeContactNo() {
		return this.officeContactNo;
	}

	public void setOfficeContactNo(String officeContactNo) {
		this.officeContactNo = officeContactNo;
	}

	@Column(name = "order_type")
	public String getOrderType() {
		return this.orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
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

	@Column(name = "patient_address1")
	public String getPatientAddress1() {
		return this.patientAddress1;
	}

	public void setPatientAddress1(String patientAddress1) {
		this.patientAddress1 = patientAddress1;
	}

	@Column(name = "patient_address2")
	public String getPatientAddress2() {
		return this.patientAddress2;
	}

	public void setPatientAddress2(String patientAddress2) {
		this.patientAddress2 = patientAddress2;
	}

	@Column(name = "patient_address3")
	public String getPatientAddress3() {
		return this.patientAddress3;
	}

	public void setPatientAddress3(String patientAddress3) {
		this.patientAddress3 = patientAddress3;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "patient_dob")
	public Date getPatientDob() {
		return this.patientDob;
	}

	public void setPatientDob(Date patientDob) {
		this.patientDob = patientDob;
	}

	@Column(name = "patient_gender")
	public String getPatientGender() {
		return this.patientGender;
	}

	public void setPatientGender(String patientGender) {
		this.patientGender = patientGender;
	}

	@Column(name = "patient_id")
	public String getPatientId() {
		return this.patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	@Column(name = "patient_id_type")
	public String getPatientIdType() {
		return this.patientIdType;
	}

	public void setPatientIdType(String patientIdType) {
		this.patientIdType = patientIdType;
	}

	@Column(name = "patient_mrn")
	public String getPatientMrn() {
		return this.patientMrn;
	}

	public void setPatientMrn(String patientMrn) {
		this.patientMrn = patientMrn;
	}

	@Column(name = "patient_name")
	public String getPatientName() {
		return this.patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	@Column(name = "patient_remarks")
	public String getPatientRemarks() {
		return this.patientRemarks;
	}

	public void setPatientRemarks(String patientRemarks) {
		this.patientRemarks = patientRemarks;
	}

	@Column(name = "patient_state")
	public String getPatientState() {
		return this.patientState;
	}

	public void setPatientState(String patientState) {
		this.patientState = patientState;
	}

	@Column(name = "ptj_code")
	public String getPtjCode() {
		return this.ptjCode;
	}

	public void setPtjCode(String ptjCode) {
		this.ptjCode = ptjCode;
	}

	@Column(name = "referred_ptj_to")
	public String getReferredPtjTo() {
		return this.referredPtjTo;
	}

	public void setReferredPtjTo(String referredPtjTo) {
		this.referredPtjTo = referredPtjTo;
	}

	@Column(name = "referred_to")
	public String getReferredTo() {
		return this.referredTo;
	}

	public void setReferredTo(String referredTo) {
		this.referredTo = referredTo;
	}

	public String getReligion() {
		return this.religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "request_date")
	public Date getRequestDate() {
		return this.requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	@Column(name = "send_flag")
	public String getSendFlag() {
		return this.sendFlag;
	}

	public void setSendFlag(String sendFlag) {
		this.sendFlag = sendFlag;
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

	@Temporal(TemporalType.DATE)
	@Column(name = "visit_date")
	public Date getVisitDate() {
		return this.visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}

	@Column(name = "visit_number")
	public String getVisitNumber() {
		return this.visitNumber;
	}

	public void setVisitNumber(String visitNumber) {
		this.visitNumber = visitNumber;
	}

	public BigDecimal getWeight() {
		return this.weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	// //bi-directional one-to-one association to OutsourceOrderInt
	// @ManyToOne
	// @JoinColumn(name="outsource_int_seqno", referencedColumnName =
	// "outsource_int_seqno")
	// @JsonBackReference
	// public OutsourceOrderInt getOutsourceOrderInt() {
	// return this.outsourceOrderInt;
	// }
	//
	// public void setOutsourceOrderInt(OutsourceOrderInt outsourceOrderInt) {
	// this.outsourceOrderInt = outsourceOrderInt;
	// }

	// bi-directional many-to-one association to OrderIvInt
	@OneToMany(mappedBy = "ivHdrInt")
	@XmlElement
	@JsonManagedReference
	public List<OrderIvInt> getOrderIvInts() {
		return this.orderIvInts;
	}

	public void setOrderIvInts(List<OrderIvInt> orderIvInts) {
		this.orderIvInts = orderIvInts;
	}

}