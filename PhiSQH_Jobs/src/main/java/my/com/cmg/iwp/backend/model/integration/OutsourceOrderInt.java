package my.com.cmg.iwp.backend.model.integration;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.IndexColumn;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;


import my.com.cmg.iwp.backend.model.integration.cdr.CdrDrugsInt;
import my.com.cmg.iwp.backend.model.integration.pn.PnOrderRegimenInt;
import my.com.cmg.iwp.backend.model.integration.pn.PnPrepCalHeaderInt;
import my.com.cmg.iwp.backend.model.integration.rp.OrderRpInt;

/**
 * The persistent class for the ph_outsource_order_int database table.
 * 
 */
@Entity
@Table(name = "t_outsource_order_int")
@XmlRootElement(name = "OutsourceOrderInt")
@JsonIgnoreProperties(ignoreUnknown=true)
public class OutsourceOrderInt implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long outsourceIntSeqno;
	private String contactNoFrom;
	private String contactNoTo;
	private String contactPersonFrom;
	private String contactPersonTo;
	private Long createdBy;
	private Date createdDate;
	private String extNoFrom;
	private String extNoTo;
	private String faxNoFrom;
	private String faxNoTo;
	private String isProcessed;
	private String parameter1;
	private String parameter2;
	private BigDecimal parameter3;
	private BigDecimal parameter4;
	private Date parameter5;
	private String preparationType;
	private Date receivedDate;
	private String receivedFlag;
	private String referredFactFrom;
	private String referredFactTo;
	private String referredPtjFrom;
	private String referredPtjTo;
	private String remarks;
	private Date requestDate;
	private String sendFlag;
	private String sourceOutsourceNo;
	private String specialInstruction;
	private Date tentativeReceiptDate;
	private Long updatedBy;
	private Date updatedDate;
	private Long version;
	private String rgmCode;
	private String doseCalculationMethod;
	private BigDecimal body_weight;
	private Integer durationCycle;
	private Integer cycleNo;
	private Integer orderSeqno;
	private Date cycleStartDate;
	private Date cycleEndDate;
	private String tnxNo;
	private Date tnxDate;

	private PatientInt patientInt;
	
	
	 private BigDecimal heightHistory;
	 private BigDecimal weightHistory;
	 private BigDecimal bsaHistory;
	 private Integer currentCycle;
	 private String orderCdrRemarks;
	 private Date endDateTime;
	
	


	// private List<IvHdrInt> ivHdrInts = new ArrayList<IvHdrInt>();
	// private List<CdrHdrInt> cdrHdrInts = new ArrayList<CdrHdrInt>();
	private Set<PnOrderRegimenInt> pnOrderRegimenInts = new HashSet<PnOrderRegimenInt>();
	private Set<OrderRpInt> orderRpInts = new HashSet<OrderRpInt>();
	private Set<PatientAllergiesInt> patientAllergiesInts = new HashSet<PatientAllergiesInt>();
	private Set<PatientDiagnosisInt> patientDiagnosisInts = new HashSet<PatientDiagnosisInt>();
	private Set<CurrentstkHdrsInt> currentstkHdrsInts= new HashSet<CurrentstkHdrsInt>();
	private Set<DispenseReasonsInt> dispenseReasonsInts= new HashSet<DispenseReasonsInt>();
	private Set<CdrDrugsInt> cdrDrugsInts = new HashSet<CdrDrugsInt>();
	private Set<PnPrepCalHeaderInt> pnPrepCalHeaderInts = new HashSet<PnPrepCalHeaderInt>();

	public OutsourceOrderInt() {
	}



	public OutsourceOrderInt(Long outsourceIntSeqno) {
		super();
		this.outsourceIntSeqno = outsourceIntSeqno;
	}



	@Id
	@SequenceGenerator(name = "PH_OUTSOURCE_ORDER_INT_OUTSOURCEINTSEQNO_GENERATOR", sequenceName = "t_outsource_order_int_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PH_OUTSOURCE_ORDER_INT_OUTSOURCEINTSEQNO_GENERATOR")
	@Column(name = "outsource_int_seqno")
	public Long getOutsourceIntSeqno() {
		return this.outsourceIntSeqno;
	}

	public void setOutsourceIntSeqno(Long outsourceIntSeqno) {
		this.outsourceIntSeqno = outsourceIntSeqno;
	}

	@Column(name = "contact_no_from")
	public String getContactNoFrom() {
		return this.contactNoFrom;
	}

	public void setContactNoFrom(String contactNoFrom) {
		this.contactNoFrom = contactNoFrom;
	}

	@Column(name = "contact_no_to")
	public String getContactNoTo() {
		return this.contactNoTo;
	}

	public void setContactNoTo(String contactNoTo) {
		this.contactNoTo = contactNoTo;
	}

	@Column(name = "contact_person_from")
	public String getContactPersonFrom() {
		return this.contactPersonFrom;
	}

	public void setContactPersonFrom(String contactPersonFrom) {
		this.contactPersonFrom = contactPersonFrom;
	}

	@Column(name = "contact_person_to")
	public String getContactPersonTo() {
		return this.contactPersonTo;
	}

	public void setContactPersonTo(String contactPersonTo) {
		this.contactPersonTo = contactPersonTo;
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

	@Column(name = "ext_no_from")
	public String getExtNoFrom() {
		return this.extNoFrom;
	}

	public void setExtNoFrom(String extNoFrom) {
		this.extNoFrom = extNoFrom;
	}

	@Column(name = "ext_no_to")
	public String getExtNoTo() {
		return this.extNoTo;
	}

	public void setExtNoTo(String extNoTo) {
		this.extNoTo = extNoTo;
	}

	@Column(name = "fax_no_from")
	public String getFaxNoFrom() {
		return this.faxNoFrom;
	}

	public void setFaxNoFrom(String faxNoFrom) {
		this.faxNoFrom = faxNoFrom;
	}

	@Column(name = "fax_no_to")
	public String getFaxNoTo() {
		return this.faxNoTo;
	}

	public void setFaxNoTo(String faxNoTo) {
		this.faxNoTo = faxNoTo;
	}

	@Column(name = "is_processed")
	public String getIsProcessed() {
		return this.isProcessed;
	}

	public void setIsProcessed(String isProcessed) {
		this.isProcessed = isProcessed;
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

	@Column(name = "preparation_type")
	public String getPreparationType() {
		return this.preparationType;
	}

	public void setPreparationType(String preparationType) {
		this.preparationType = preparationType;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "received_date")
	public Date getReceivedDate() {
		return this.receivedDate;
	}

	public void setReceivedDate(Date receivedDate) {
		this.receivedDate = receivedDate;
	}

	@Column(name = "received_flag")
	public String getReceivedFlag() {
		return this.receivedFlag;
	}

	public void setReceivedFlag(String receivedFlag) {
		this.receivedFlag = receivedFlag;
	}

	@Column(name = "referred_fact_from")
	public String getReferredFactFrom() {
		return this.referredFactFrom;
	}

	public void setReferredFactFrom(String referredFactFrom) {
		this.referredFactFrom = referredFactFrom;
	}

	@Column(name = "referred_fact_to")
	public String getReferredFactTo() {
		return this.referredFactTo;
	}

	public void setReferredFactTo(String referredFactTo) {
		this.referredFactTo = referredFactTo;
	}

	@Column(name = "referred_ptj_from")
	public String getReferredPtjFrom() {
		return this.referredPtjFrom;
	}

	public void setReferredPtjFrom(String referredPtjFrom) {
		this.referredPtjFrom = referredPtjFrom;
	}

	@Column(name = "referred_ptj_to")
	public String getReferredPtjTo() {
		return this.referredPtjTo;
	}

	public void setReferredPtjTo(String referredPtjTo) {
		this.referredPtjTo = referredPtjTo;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Temporal(TemporalType.TIMESTAMP)
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

	@Column(name = "source_outsource_no")
	public String getSourceOutsourceNo() {
		return this.sourceOutsourceNo;
	}

	public void setSourceOutsourceNo(String sourceOutsourceNo) {
		this.sourceOutsourceNo = sourceOutsourceNo;
	}

	@Column(name = "special_instruction")
	public String getSpecialInstruction() {
		return this.specialInstruction;
	}

	public void setSpecialInstruction(String specialInstruction) {
		this.specialInstruction = specialInstruction;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "tentative_receipt_date")
	public Date getTentativeReceiptDate() {
		return this.tentativeReceiptDate;
	}

	public void setTentativeReceiptDate(Date tentativeReceiptDate) {
		this.tentativeReceiptDate = tentativeReceiptDate;
	}

	@Column(name = "updated_by")
	public Long getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Column(name = "updated_date")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Long getVersion() {
		return this.version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	// @OneToMany(mappedBy="outsourceOrderInt",fetch=FetchType.LAZY)
	// // @XmlElement
	// @JsonIgnore
	// public List<IvHdrInt> getIvHdrInts() {
	// return ivHdrInts;
	// }
	//
	//
	// public void setIvHdrInts(List<IvHdrInt> ivHdrInts) {
	// this.ivHdrInts = ivHdrInts;
	// }

	@OneToMany(mappedBy = "outsourceOrderInt", cascade=CascadeType.ALL)
	@IndexColumn(name="regimen_int_seqno")
	@XmlElement
	@JsonManagedReference("outsource_PnOrderRegimenInt")
	public Set<PnOrderRegimenInt> getPnOrderRegimenInts() {
		return this.pnOrderRegimenInts;
	}

	public void setPnOrderRegimenInts(Set<PnOrderRegimenInt> pnOrderRegimenInts) {
		this.pnOrderRegimenInts = pnOrderRegimenInts;
	}

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name =  "patient_int_seqno", nullable = false)
	public PatientInt getPatientInt() {
		return this.patientInt;
	}


	public void setPatientInt(PatientInt patientInt) {
		this.patientInt = patientInt;
	}

	@OneToMany(mappedBy="outsourceOrderInt",  cascade = CascadeType.ALL)
	@IndexColumn(name="order_rp_seqno")
	@XmlElement
	@JsonManagedReference("RpOutsourceOrderInt")
	public Set<OrderRpInt> getOrderRpInts() {
		return this.orderRpInts;
	}


	public void setOrderRpInts(Set<OrderRpInt> orderRpInts) {
		this.orderRpInts = orderRpInts;
	}

	@OneToMany(mappedBy="outsourceOrderInt",  cascade=CascadeType.ALL)
	@IndexColumn(name="patient_allergies_int_seqno")
	@XmlElement
	@JsonManagedReference("PatientAllergiesOutsourceOrderInt")
	public Set<PatientAllergiesInt> getPatientAllergiesInts() {
		return this.patientAllergiesInts;
	}

	public void setPatientAllergiesInts(
			Set<PatientAllergiesInt> patientAllergiesInts) {
		this.patientAllergiesInts = patientAllergiesInts;
	}

	@OneToMany(mappedBy="outsourceOrderInt",  cascade=CascadeType.ALL)
	@IndexColumn(name="pd_int_seqno")
	@XmlElement
	@JsonManagedReference("PatientDiagnosisOutsourceOrderInt")
	public Set<PatientDiagnosisInt> getPatientDiagnosisInts() {
		return this.patientDiagnosisInts;
	}


	public void setPatientDiagnosisInts(
			Set<PatientDiagnosisInt> patientDiagnosisInts) {
		this.patientDiagnosisInts = patientDiagnosisInts;
	}

	@OneToMany(mappedBy="outsourceOrderInt",  cascade=CascadeType.ALL)
	@IndexColumn(name="stk_lot_int_no")
	@XmlElement
	@JsonManagedReference("CurrentstkHdrsOutsourceOrderInt")
	public Set<CurrentstkHdrsInt> getCurrentstkHdrsInts() {
		return this.currentstkHdrsInts;
	}

	public void setCurrentstkHdrsInts(Set<CurrentstkHdrsInt> currentstkHdrsInts) {
		this.currentstkHdrsInts = currentstkHdrsInts;
	}


	@OneToMany(mappedBy="outsourceOrderInt",  cascade=CascadeType.ALL)
	@IndexColumn(name="reason_int_seqno")
	@XmlElement
	@JsonManagedReference("DispenseReasonsOutsourceOrderInt")
	public Set<DispenseReasonsInt> getDispenseReasonsInts() {
		return this.dispenseReasonsInts;
	}

	public void setDispenseReasonsInts(Set<DispenseReasonsInt> dispenseReasonsInts) {
		this.dispenseReasonsInts = dispenseReasonsInts;
	}

	@OneToMany(mappedBy="outsourceOrderInt", cascade=CascadeType.ALL)
	@JsonManagedReference("CdrDrugsInt")
	public Set<CdrDrugsInt> getCdrDrugsInts() {
		return this.cdrDrugsInts;
	}

	public void setCdrDrugsInts(Set<CdrDrugsInt> cdrDrugsInts) {
		this.cdrDrugsInts = cdrDrugsInts;
	}

	@OneToMany(mappedBy="outsourceOrderInt", cascade=CascadeType.ALL)
	@JsonManagedReference("PnPrepCalHeaderInt")
	public Set<PnPrepCalHeaderInt> getPnPrepCalHeaderInts() {
		return this.pnPrepCalHeaderInts;
	}

	public void setPnPrepCalHeaderInts(Set<PnPrepCalHeaderInt> pnPrepCalHeaderInts) {
		this.pnPrepCalHeaderInts = pnPrepCalHeaderInts;
	}

	@Column(name="rgm_code")
	public String getRgmCode() {
		return this.rgmCode;
	}

	public void setRgmCode(String rgmCode) {
		this.rgmCode = rgmCode;
	}

	@Column(name="dose_calculation_method")
	public String getDoseCalculationMethod() {
		return this.doseCalculationMethod;
	}

	public void setDoseCalculationMethod(String doseCalculationMethod) {
		this.doseCalculationMethod = doseCalculationMethod;
	}

	@Column(name="body_weight")
	public BigDecimal getBody_weight() {
		return this.body_weight;
	}

	public void setBody_weight(BigDecimal body_weight) {
		this.body_weight = body_weight;
	}

	@Column(name="duration_cycle")
	public Integer getDurationCycle() {
		return this.durationCycle;
	}

	public void setDurationCycle(Integer durationCycle) {
		this.durationCycle = durationCycle;
	}

	@Column(name="cycle_no")
	public Integer getCycleNo() {
		return this.cycleNo;
	}

	public void setCycleNo(Integer cycleNo) {
		this.cycleNo = cycleNo;
	}

	@Column(name="order_seqno")
	public Integer getOrderSeqno() {
		return this.orderSeqno;
	}

	public void setOrderSeqno(Integer orderSeqno) {
		this.orderSeqno = orderSeqno;
	}

	@Column(name="cycle_start_date")
	public Date getCycleStartDate() {
		return this.cycleStartDate;
	}

	public void setCycleStartDate(Date cycleStartDate) {
		this.cycleStartDate = cycleStartDate;
	}

	@Column(name="cycle_end_date")
	public Date getCycleEndDate() {
		return this.cycleEndDate;
	}

	public void setCycleEndDate(Date cycleEndDate) {
		this.cycleEndDate = cycleEndDate;
	}

	@Column(name="tnx_no")
	public String getTnxNo() {
		return this.tnxNo;
	}

	public void setTnxNo(String tnxNo) {
		this.tnxNo = tnxNo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name="tnx_date")
	public Date getTnxDate() {
		return this.tnxDate;
	}

	public void setTnxDate(Date tnxDate) {
		this.tnxDate = tnxDate;
	}


	// @OneToMany(mappedBy= "outsourceOrderInt")
		// @XmlElement
		// @JsonManagedReference
		// public List<CdrHdrInt> getCdrHdrInts() {
		// return cdrHdrInts;
		// }
		//
		// public void setCdrHdrInts(List<CdrHdrInt> cdrHdrInts) {
		// this.cdrHdrInts = cdrHdrInts;
		// }
		

	@Column(name="height_history")
	public BigDecimal getHeightHistory() {
		return heightHistory;
	}

	public void setHeightHistory(BigDecimal heightHistory) {
		this.heightHistory = heightHistory;
	}

	@Column(name="weight_history")
	public BigDecimal getWeightHistory() {
		return weightHistory;
	}

	public void setWeightHistory(BigDecimal weightHistory) {
		this.weightHistory = weightHistory;
	}

	@Column(name="bsa_history")
	public BigDecimal getBsaHistory() {
		return bsaHistory;
	}

	public void setBsaHistory(BigDecimal bsaHistory) {
		this.bsaHistory = bsaHistory;
	}

	@Column(name="current_cycle")
	public Integer getCurrentCycle() {
		return currentCycle;
	}

	public void setCurrentCycle(Integer currentCycle) {
		this.currentCycle = currentCycle;
	}

	@Column(name="order_cdr_remarks")
	public String getOrderCdrRemarks() {
		return orderCdrRemarks;
	}

	public void setOrderCdrRemarks(String orderCdrRemarks) {
		this.orderCdrRemarks = orderCdrRemarks;
	}
	
	@Column(name="END_DATE_TIME_ORI")
	public Date getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(Date endDateTime) {
		this.endDateTime = endDateTime;
	}
	
	
	
	

}