package my.com.cmg.iwp.backend.model.integration.cdr;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * The persistent class for the ph_cdr_hdr_int database table.
 * 
 */
@Entity
@Table(name = "t_cdr_hdr_int")
@XmlRootElement(name = "CdrHdrInt")
@JsonIgnoreProperties(ignoreUnknown=true)
public class CdrHdrInt implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long cdrHdrSeqno;
	// private Long outsourceIntSeqno;
	private BigDecimal bodyWeight;
	private String city;
	private String country;
	private Long createdBy;
	private Date createdDate;
	private Date cycleEndDate;
	private Integer cycleNo;
	private Date cycleStartDate;
	private String doseCalculationMethod;
	private Integer durationCycle;
	private String facCode;
	private BigDecimal height;
	private String homeContactNo;
	private String mobileContactNo;
	private String nationality;
	private String officeContactNo;
	private String orderNumber;
	private Long orderSeqno;
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
	private String ptjCode;
	private String referredPtjTo;
	private String referredTo;
	private String religion;
	private String remarks;
	private Date requestDate;
	private String rgmCode;
	private String sendFlag;
	private String state;
	private Long updatedBy;
	private Date updatedDate;
	private Date visitDate;
	private String visitNumber;
	private BigDecimal weight;
	private Set<CdrInfusionDrugsInt> cdrInfusionDrugsInts = new HashSet<CdrInfusionDrugsInt>(
			0);
	private Set<CdrNormalDrugsInt> cdrNormalDrugsInts = new HashSet<CdrNormalDrugsInt>(
			0);
	private String refPatientMrn;

	// private ArrayList<HashMap<String,Object>> cdrInfusionDrugMap;
	// private ArrayList<HashMap<String,Object>> cdrNormalDrugsMap;
	// private OutsourceOrderInt outsourceOrderInt;
	public CdrHdrInt() {
	}

	@Id
	@SequenceGenerator(name = "PH_CDR_HDR_INT_CDRHDRSEQNO_GENERATOR", sequenceName = "t_cdr_hdr_int_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PH_CDR_HDR_INT_CDRHDRSEQNO_GENERATOR")
	@Column(name = "cdr_hdr_seqno")
	public Long getCdrHdrSeqno() {
		return this.cdrHdrSeqno;
	}

	public void setCdrHdrSeqno(Long cdrHdrSeqno) {
		this.cdrHdrSeqno = cdrHdrSeqno;
	}

	@Column(name = "body_weight")
	public BigDecimal getBodyWeight() {
		return this.bodyWeight;
	}

	public void setBodyWeight(BigDecimal bodyWeight) {
		this.bodyWeight = bodyWeight;
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

	@Temporal(TemporalType.DATE)
	@Column(name = "created_date")
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "cycle_end_date")
	public Date getCycleEndDate() {
		return this.cycleEndDate;
	}

	public void setCycleEndDate(Date cycleEndDate) {
		this.cycleEndDate = cycleEndDate;
	}

	@Column(name = "cycle_no")
	public Integer getCycleNo() {
		return this.cycleNo;
	}

	public void setCycleNo(Integer cycleNo) {
		this.cycleNo = cycleNo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "cycle_start_date")
	public Date getCycleStartDate() {
		return this.cycleStartDate;
	}

	public void setCycleStartDate(Date cycleStartDate) {
		this.cycleStartDate = cycleStartDate;
	}

	@Column(name = "dose_calculation_method")
	public String getDoseCalculationMethod() {
		return this.doseCalculationMethod;
	}

	public void setDoseCalculationMethod(String doseCalculationMethod) {
		this.doseCalculationMethod = doseCalculationMethod;
	}

	@Column(name = "duration_cycle")
	public Integer getDurationCycle() {
		return this.durationCycle;
	}

	public void setDurationCycle(Integer durationCycle) {
		this.durationCycle = durationCycle;
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

	@Column(name = "office_contact_no")
	public String getOfficeContactNo() {
		return this.officeContactNo;
	}

	public void setOfficeContactNo(String officeContactNo) {
		this.officeContactNo = officeContactNo;
	}

	@Column(name = "order_number")
	public String getOrderNumber() {
		return this.orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	@Column(name = "order_seqno")
	public Long getOrderSeqno() {
		return this.orderSeqno;
	}

	public void setOrderSeqno(Long orderSeqno) {
		this.orderSeqno = orderSeqno;
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

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "request_date")
	public Date getRequestDate() {
		return this.requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	@Column(name = "rgm_code")
	public String getRgmCode() {
		return this.rgmCode;
	}

	public void setRgmCode(String rgmCode) {
		this.rgmCode = rgmCode;
	}

	@Column(name = "send_flag")
	public String getSendFlag() {
		return this.sendFlag;
	}

	public void setSendFlag(String sendFlag) {
		this.sendFlag = sendFlag;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "updated_by")
	public Long getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Temporal(TemporalType.DATE)
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

	// bi-directional many-to-one association to CdrInfusionDrugsInt
	@OneToMany(mappedBy = "cdrHdrInt")
	@XmlElement
	@JsonManagedReference
	// @JsonIgnore
	public Set<CdrInfusionDrugsInt> getCdrInfusionDrugsInts() {
		return this.cdrInfusionDrugsInts;
	}

	public void setCdrInfusionDrugsInts(
			Set<CdrInfusionDrugsInt> cdrInfusionDrugsInts) {
		this.cdrInfusionDrugsInts = cdrInfusionDrugsInts;
	}

	// bi-directional many-to-one association to CdrNormalDrugsInt
	@OneToMany(mappedBy = "cdrHdrInt")
	@XmlElement
	@JsonManagedReference
	// @JsonIgnore
	public Set<CdrNormalDrugsInt> getCdrNormalDrugsInts() {
		return this.cdrNormalDrugsInts;
	}

	public void setCdrNormalDrugsInts(Set<CdrNormalDrugsInt> cdrNormalDrugsInts) {
		this.cdrNormalDrugsInts = cdrNormalDrugsInts;
	}
	
	@Column(name = "ref_patient_mrn")
	public String getRefPatientMrn() {
		return refPatientMrn;
	}

	public void setRefPatientMrn(String refPatientMrn) {
		this.refPatientMrn = refPatientMrn;
	}

	// @OneToOne
	// @JoinColumn(name="outsource_int_seqno", referencedColumnName=
	// "outsource_int_seqno")
	// @XmlElement
	// @JsonManagedReference("OutsourceOrderInt")
	// public OutsourceOrderInt getOutsourceOrderInt() {
	// return outsourceOrderInt;
	// }
	//
	//
	// public void setOutsourceOrderInt(OutsourceOrderInt outsourceOrderInt) {
	// this.outsourceOrderInt = outsourceOrderInt;
	// }

	// @Transient
	// @JsonIgnore
	// public ArrayList<HashMap<String,Object>> getCdrInfusionDrugMap() {
	// return cdrInfusionDrugMap;
	// }
	//
	// public void setCdrInfusionDrugMap(ArrayList<HashMap<String,Object>>
	// cdrInfusionDrugMap) {
	// this.cdrInfusionDrugMap = cdrInfusionDrugMap;
	// }
	//
	// @Transient
	// @JsonIgnore
	// public ArrayList<HashMap<String,Object>> getCdrNormalDrugsMap() {
	// return cdrNormalDrugsMap;
	// }
	//
	// public void setCdrNormalDrugsMap(ArrayList<HashMap<String,Object>>
	// cdrNormalDrugsMap) {
	// this.cdrNormalDrugsMap = cdrNormalDrugsMap;
	// }

	// @Column(name="outsource_int_seqno")
	// public Long getOutsourceIntSeqno() {
	// return outsourceIntSeqno;
	// }
	//
	// public void setOutsourceIntSeqno(Long outsourceIntSeqno) {
	// this.outsourceIntSeqno = outsourceIntSeqno;
	// }

}