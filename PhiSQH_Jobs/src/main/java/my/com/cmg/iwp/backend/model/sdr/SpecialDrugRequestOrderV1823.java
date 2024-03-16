package my.com.cmg.iwp.backend.model.sdr;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import my.com.cmg.iwp.maintenance.model.Drug;
import my.com.cmg.iwp.maintenance.model.ExternalFacility;
import my.com.cmg.iwp.webui.constant.RefCodeConstant;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonManagedReference;

@XmlRootElement(name = "SpecialDrugRequestOrder")
@JsonIgnoreProperties(ignoreUnknown=true)
public class SpecialDrugRequestOrderV1823 implements java.io.Serializable {

	private long sdrOrderSeqno;
	private Integer version;
	private String ptjCode;
	private String facCode;
	private long drugreqSeqno;
	private String hosRequestNo;
	private String hospitalName;
	private Date requestDate;
	private String genericName;
	private String bpfRegisterNo;
	private String state;
	private String requestType;
	private String status;
	private String pbkdRegisteredMal;
	private String pbkdIndication;
	private String pbkdManufacturedBy;
	private String pbkdImportedBy;
	private String pbkdFukkmIndication;
	private String pbkdFukkmListedIndication;
	private String notExistinFUKKM;
	private String existInKKMDrug;
	private String pbkdRegimenTreatment;
	private long pbkdRequestQuantity;
	private String pbkdTreatmentDuration;
	private double pbkdActualCost;
	private String pbkdTreatmentReason;
	private String pbkdPatientIndicationHist;
	private byte[] pbkdAttachment1;
	private byte[] pbkdAttachment2;
	private byte[] pbkdAttachment3;
	private byte[] pbkdAttachment4;
	private byte[] pbkdAttachment5;
	private String additionalRef;
	private String specialistRemarks;
	private String specialistRequestedBy;
	private String specialistDesignation;
	private Date specialistRequestDate;
	private String hodRemarks;
	private String hodEndorsedBy;
	private Date hodDate;
	private String cpoRemarks;
	private String cpoApprovedBy;
	private String cpoAllocationRequired;
	private Date cpoDate;
	private String cpoExistingAllocation;
	private byte[] cpoAttachment;
	private String hdVerifiedBy;
	private String hdRemarks;
	private Date hdDate;
	private String kpkRemarks;
	private String kpkStatus;
	private long kpkApprovedQuantity;
	private String kpkVerifiedBy;
	private String kpkRecoomendedBy;
	private byte[] kpkAttachment;
	private Date kpkDate;
	private String sourceIp;
	private String sourceHost;
	private String sourcePort;
	private long createdBy;
	private Date createdDate;
	private long updatedBy;
	private Date updatedDate;
	private String kpkRefCode;
	private String drugCode;
	private String itemCode;
	private String jkn;
	private String activeIngredient;
	private Double newDrugStrength;
	private String newDrugUom;
	private String newDrugDosageForm;
	private String requestBy;
	private String pharmacistRemarks;
	private String pharmacistRequestedBy;
	private String pharmacistDesignation;
	private Date pharmacistRequestedDatetime;
	private String sendFlag;
	private String packagingDescription;
	private BigDecimal packagingQty;
	private BigDecimal costPerPack;
	private BigDecimal totalCost;
	private String regStatus;
	private String indicationRegisteredMal;
	private String secretariatRemarks;
	private Date secretariatDate;
	private String indicationTreatment;
	private String requesterDesignation;
	private String fullDrugName;
	private Drug drug;
	private String requestQtyUomCode;
	private String pkpfStatus;
	private String pkpfRemarks;
	private String pkpfName;
	private Date pkpfDate;
	private Character completeForm = RefCodeConstant.BOOLEAN_FALSE;
	private Date completeFormDate;
	private String kpkName;
	private Double approvedCost;
	private String specialistDiscipline;
	private String repeatNo;
	private Date submissionDate;
	private Date actionDate;
	private String serialNo;
    private String approved_indication;
	private ExternalFacility externalFacility;
	private String attachment1Name;
	private String attachment4Name;
	private String attachment2Name;
	private String attachment3Name;
	private String attachment5Name;
	private String approvalattachment_name;
	private String kpkattachment_name;

	private Set<SpecialDrugPatientV1823> specialDrugPatients = new HashSet<SpecialDrugPatientV1823>(
			0);

	public SpecialDrugRequestOrderV1823() {
	}

	@Id
	@Column(name = "SDR_ORDER_SEQNO", unique = true, nullable = false, precision = 38, scale = 0)
	@SequenceGenerator(name = "sdrOrderSeqno", sequenceName = "T_SPL_DRUG_REQUEST_INT_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sdrOrderSeqno")
	public long getSdrOrderSeqno() {
		return this.sdrOrderSeqno;
	}

	public void setSdrOrderSeqno(long sdrOrderSeqno) {
		this.sdrOrderSeqno = sdrOrderSeqno;
	}

	@Version
	@Column(name = "VERSION")
	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@Column(name = "PTJ_CODE", nullable = false)
	public String getPtjCode() {
		return this.ptjCode;
	}

	public void setPtjCode(String ptjCode) {
		this.ptjCode = ptjCode;
	}

	@Column(name = "FAC_CODE", nullable = false)
	public String getFacCode() {
		return this.facCode;
	}

	public void setFacCode(String facCode) {
		this.facCode = facCode;
	}

	@Column(name = "DRUGREQ_SEQNO", nullable = false, precision = 38, scale = 0)
	public long getDrugreqSeqno() {
		return this.drugreqSeqno;
	}

	public void setDrugreqSeqno(long drugreqSeqno) {
		this.drugreqSeqno = drugreqSeqno;
	}

	@Column(name = "HOS_REQUEST_NO")
	public String getHosRequestNo() {
		return this.hosRequestNo;
	}

	public void setHosRequestNo(String hosRequestNo) {
		this.hosRequestNo = hosRequestNo;
	}

	@Column(name = "HOSPITAL_NAME")
	public String getHospitalName() {
		return this.hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "REQUEST_DATE")
	public Date getRequestDate() {
		return this.requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	@Column(name = "GENERIC_NAME")
	public String getGenericName() {
		return this.genericName;
	}

	public void setGenericName(String genericName) {
		this.genericName = genericName;
	}

	@Column(name = "BPF_REGISTER_NO")
	public String getBpfRegisterNo() {
		return this.bpfRegisterNo;
	}

	public void setBpfRegisterNo(String bpfRegisterNo) {
		this.bpfRegisterNo = bpfRegisterNo;
	}

	@Column(name = "STATE")
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "REQUEST_TYPE")
	public String getRequestType() {
		return this.requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	@Column(name = "STATUS")
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "PBKD_REGISTERED_MAL")
	public String getPbkdRegisteredMal() {
		return this.pbkdRegisteredMal;
	}

	public void setPbkdRegisteredMal(String pbkdRegisteredMal) {
		this.pbkdRegisteredMal = pbkdRegisteredMal;
	}

	@Column(name = "PBKD_INDICATION")
	public String getPbkdIndication() {
		return this.pbkdIndication;
	}

	public void setPbkdIndication(String pbkdIndication) {
		this.pbkdIndication = pbkdIndication;
	}

	@Column(name = "PBKD_MANUFACTURED_BY")
	public String getPbkdManufacturedBy() {
		return this.pbkdManufacturedBy;
	}

	public void setPbkdManufacturedBy(String pbkdManufacturedBy) {
		this.pbkdManufacturedBy = pbkdManufacturedBy;
	}

	@Column(name = "PBKD_IMPORTED_BY")
	public String getPbkdImportedBy() {
		return this.pbkdImportedBy;
	}

	public void setPbkdImportedBy(String pbkdImportedBy) {
		this.pbkdImportedBy = pbkdImportedBy;
	}

	@Column(name = "PBKD_FUKKM_INDICATION")
	public String getPbkdFukkmIndication() {
		return this.pbkdFukkmIndication;
	}

	public void setPbkdFukkmIndication(String pbkdFukkmIndication) {
		this.pbkdFukkmIndication = pbkdFukkmIndication;
	}

	@Column(name = "PBKD_REGIMEN_TREATMENT")
	public String getPbkdRegimenTreatment() {
		return this.pbkdRegimenTreatment;
	}

	public void setPbkdRegimenTreatment(String pbkdRegimenTreatment) {
		this.pbkdRegimenTreatment = pbkdRegimenTreatment;
	}

	@Column(name = "PBKD_REQUEST_QUANTITY", precision = 38, scale = 0)
	public long getPbkdRequestQuantity() {
		return this.pbkdRequestQuantity;
	}

	public void setPbkdRequestQuantity(long pbkdRequestQuantity) {
		this.pbkdRequestQuantity = pbkdRequestQuantity;
	}

	@Column(name = "PBKD_TREATMENT_DURATION")
	public String getPbkdTreatmentDuration() {
		return this.pbkdTreatmentDuration;
	}

	public void setPbkdTreatmentDuration(String pbkdTreatmentDuration) {
		this.pbkdTreatmentDuration = pbkdTreatmentDuration;
	}

	@Column(name = "PBKD_ACTUAL_COST", precision = 10)
	public double getPbkdActualCost() {
		return this.pbkdActualCost;
	}

	public void setPbkdActualCost(double pbkdActualCost) {
		this.pbkdActualCost = pbkdActualCost;
	}

	@Column(name = "PBKD_TREATMENT_REASON")
	public String getPbkdTreatmentReason() {
		return this.pbkdTreatmentReason;
	}

	public void setPbkdTreatmentReason(String pbkdTreatmentReason) {
		this.pbkdTreatmentReason = pbkdTreatmentReason;
	}

	@Column(name = "PBKD_PATIENT_INDICATION_HIST")
	public String getPbkdPatientIndicationHist() {
		return this.pbkdPatientIndicationHist;
	}

	public void setPbkdPatientIndicationHist(String pbkdPatientIndicationHist) {
		this.pbkdPatientIndicationHist = pbkdPatientIndicationHist;
	}

	@Column(name = "PBKD_ATTACHMENT1")
	public byte[] getPbkdAttachment1() {
		return this.pbkdAttachment1;
	}

	public void setPbkdAttachment1(byte[] pbkdAttachment1) {
		this.pbkdAttachment1 = pbkdAttachment1;
	}

	@Column(name = "PBKD_ATTACHMENT2")
	public byte[] getPbkdAttachment2() {
		return this.pbkdAttachment2;
	}

	public void setPbkdAttachment2(byte[] pbkdAttachment2) {
		this.pbkdAttachment2 = pbkdAttachment2;
	}

	@Column(name = "PBKD_ATTACHMENT3")
	public byte[] getPbkdAttachment3() {
		return this.pbkdAttachment3;
	}

	public void setPbkdAttachment3(byte[] pbkdAttachment3) {
		this.pbkdAttachment3 = pbkdAttachment3;
	}
	
	@Column(name = "PBKD_ATTACHMENT4")
	public byte[] getPbkdAttachment4() {
		return pbkdAttachment4;
	}

	public void setPbkdAttachment4(byte[] pbkdAttachment4) {
		this.pbkdAttachment4 = pbkdAttachment4;
	}

	@Column(name = "PBKD_ATTACHMENT5")
	public byte[] getPbkdAttachment5() {
		return pbkdAttachment5;
	}

	public void setPbkdAttachment5(byte[] pbkdAttachment5) {
		this.pbkdAttachment5 = pbkdAttachment5;
	}

	@Column(name = "additionl_ref")
	public String getAdditionalRef() {
		return additionalRef;
	}

	public void setAdditionalRef(String additionalRef) {
		this.additionalRef = additionalRef;
	}

	@Column(name = "SPECIALIST_REMARKS")
	public String getSpecialistRemarks() {
		return this.specialistRemarks;
	}

	public void setSpecialistRemarks(String specialistRemarks) {
		this.specialistRemarks = specialistRemarks;
	}

	@Column(name = "SPECIALIST_REQUESTED_BY")
	public String getSpecialistRequestedBy() {
		return this.specialistRequestedBy;
	}

	public void setSpecialistRequestedBy(String specialistRequestedBy) {
		this.specialistRequestedBy = specialistRequestedBy;
	}

	@Column(name = "SPECIALIST_DESIGNATION")
	public String getSpecialistDesignation() {
		return this.specialistDesignation;
	}

	public void setSpecialistDesignation(String specialistDesignation) {
		this.specialistDesignation = specialistDesignation;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "SPECIALIST_REQUEST_DATE")
	public Date getSpecialistRequestDate() {
		return this.specialistRequestDate;
	}

	public void setSpecialistRequestDate(Date specialistRequestDate) {
		this.specialistRequestDate = specialistRequestDate;
	}

	@Column(name = "HOD_REMARKS")
	public String getHodRemarks() {
		return this.hodRemarks;
	}

	public void setHodRemarks(String hodRemarks) {
		this.hodRemarks = hodRemarks;
	}

	@Column(name = "HOD_ENDORSED_BY")
	public String getHodEndorsedBy() {
		return this.hodEndorsedBy;
	}

	public void setHodEndorsedBy(String hodEndorsedBy) {
		this.hodEndorsedBy = hodEndorsedBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "HOD_DATE")
	public Date getHodDate() {
		return this.hodDate;
	}

	public void setHodDate(Date hodDate) {
		this.hodDate = hodDate;
	}

	@Column(name = "CPO_REMARKS")
	public String getCpoRemarks() {
		return this.cpoRemarks;
	}

	public void setCpoRemarks(String cpoRemarks) {
		this.cpoRemarks = cpoRemarks;
	}

	@Column(name = "CPO_APPROVED_BY")
	public String getCpoApprovedBy() {
		return this.cpoApprovedBy;
	}

	public void setCpoApprovedBy(String cpoApprovedBy) {
		this.cpoApprovedBy = cpoApprovedBy;
	}

	@Column(name = "CPO_ALLOCATION_REQUIRED")
	public String getCpoAllocationRequired() {
		return this.cpoAllocationRequired;
	}

	public void setCpoAllocationRequired(String cpoAllocationRequired) {
		this.cpoAllocationRequired = cpoAllocationRequired;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CPO_DATE")
	public Date getCpoDate() {
		return this.cpoDate;
	}

	public void setCpoDate(Date cpoDate) {
		this.cpoDate = cpoDate;
	}

	@Column(name = "CPO_EXISTING_ALLOCATION")
	public String getCpoExistingAllocation() {
		return this.cpoExistingAllocation;
	}

	public void setCpoExistingAllocation(String cpoExistingAllocation) {
		this.cpoExistingAllocation = cpoExistingAllocation;
	}

	@Column(name = "CPO_ATTACHMENT")
	public byte[] getCpoAttachment() {
		return this.cpoAttachment;
	}

	public void setCpoAttachment(byte[] cpoAttachment) {
		this.cpoAttachment = cpoAttachment;
	}

	@Column(name = "HD_VERIFIED_BY")
	public String getHdVerifiedBy() {
		return this.hdVerifiedBy;
	}

	public void setHdVerifiedBy(String hdVerifiedBy) {
		this.hdVerifiedBy = hdVerifiedBy;
	}

	@Column(name = "HD_REMARKS")
	public String getHdRemarks() {
		return this.hdRemarks;
	}

	public void setHdRemarks(String hdRemarks) {
		this.hdRemarks = hdRemarks;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "HD_DATE")
	public Date getHdDate() {
		return this.hdDate;
	}

	public void setHdDate(Date hdDate) {
		this.hdDate = hdDate;
	}

	@Column(name = "KPK_REMARKS")
	public String getKpkRemarks() {
		return this.kpkRemarks;
	}

	public void setKpkRemarks(String kpkRemarks) {
		this.kpkRemarks = kpkRemarks;
	}

	@Column(name = "KPK_STATUS")
	public String getKpkStatus() {
		return this.kpkStatus;
	}

	public void setKpkStatus(String kpkStatus) {
		this.kpkStatus = kpkStatus;
	}

	@Column(name = "KPK_APPROVED_QUANTITY", precision = 38, scale = 0)
	public long getKpkApprovedQuantity() {
		return this.kpkApprovedQuantity;
	}

	public void setKpkApprovedQuantity(long kpkApprovedQuantity) {
		this.kpkApprovedQuantity = kpkApprovedQuantity;
	}

	@Column(name = "KPK_VERIFIED_BY")
	public String getKpkVerifiedBy() {
		return this.kpkVerifiedBy;
	}

	public void setKpkVerifiedBy(String kpkVerifiedBy) {
		this.kpkVerifiedBy = kpkVerifiedBy;
	}

	@Column(name = "KPK_ATTACHMENT")
	public byte[] getKpkAttachment() {
		return this.kpkAttachment;
	}

	public void setKpkAttachment(byte[] kpkAttachment) {
		this.kpkAttachment = kpkAttachment;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "KPK_DATE")
	public Date getKpkDate() {
		return this.kpkDate;
	}

	public void setKpkDate(Date kpkDate) {
		this.kpkDate = kpkDate;
	}

	@Column(name = "SOURCE_IP")
	public String getSourceIp() {
		return this.sourceIp;
	}

	public void setSourceIp(String sourceIp) {
		this.sourceIp = sourceIp;
	}

	@Column(name = "SOURCE_HOST")
	public String getSourceHost() {
		return this.sourceHost;
	}

	public void setSourceHost(String sourceHost) {
		this.sourceHost = sourceHost;
	}

	@Column(name = "SOURCE_PORT")
	public String getSourcePort() {
		return this.sourcePort;
	}

	public void setSourcePort(String sourcePort) {
		this.sourcePort = sourcePort;
	}

	@Column(name = "CREATED_BY", precision = 38, scale = 0)
	public long getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE", nullable = false)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "UPDATED_BY", precision = 38, scale = 0)
	public long getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(long updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATED_DATE", nullable = false)
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "specialDrugRequestOrder")
	@XmlElement(name = "SpecialDrugPatient")
	@JsonManagedReference
	public Set<SpecialDrugPatientV1823> getSpecialDrugPatients() {
		return this.specialDrugPatients;
	}

	public void setSpecialDrugPatients(
			Set<SpecialDrugPatientV1823> specialDrugPatients) {
		this.specialDrugPatients = specialDrugPatients;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ (int) (sdrOrderSeqno ^ (sdrOrderSeqno >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SpecialDrugRequestOrderV1823 other = (SpecialDrugRequestOrderV1823) obj;
		if (sdrOrderSeqno != other.sdrOrderSeqno)
			return false;
		return true;
	}

	@Column(name = "notExistinFUKKM")
	public String getNotExistinFUKKM() {
		return notExistinFUKKM;
	}

	public void setNotExistinFUKKM(String notExistinFUKKM) {
		this.notExistinFUKKM = notExistinFUKKM;
	}

	@Column(name = "existInKKMDrug")
	public String getExistInKKMDrug() {
		return existInKKMDrug;
	}

	public void setExistInKKMDrug(String existInKKMDrug) {
		this.existInKKMDrug = existInKKMDrug;
	}

	@Column(name = "KPK_REF_CODE")
	public String getKpkRefCode() {
		return kpkRefCode;
	}

	public void setKpkRefCode(String kpkRefCode) {
		this.kpkRefCode = kpkRefCode;
	}

	@Column(name = "DRUG_CODE")
	public String getDrugCode() {
		return drugCode;
	}

	public void setDrugCode(String drugCode) {
		this.drugCode = drugCode;
	}

	@Column(name = "ITEM_CODE")
	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	@Column(name = "active_ingredient")
	public String getActiveIngredient() {
		return activeIngredient;
	}

	public void setActiveIngredient(String activeIngredient) {
		this.activeIngredient = activeIngredient;
	}

	@Column(name = "new_drug_strength")
	public Double getNewDrugStrength() {
		return newDrugStrength;
	}

	public void setNewDrugStrength(Double newDrugStrength) {
		this.newDrugStrength = newDrugStrength;
	}

	@Column(name = "new_drug_uom")
	public String getNewDrugUom() {
		return newDrugUom;
	}

	public void setNewDrugUom(String newDrugUom) {
		this.newDrugUom = newDrugUom;
	}

	@Column(name = "new_drug_dosage_form")
	public String getNewDrugDosageForm() {
		return newDrugDosageForm;
	}

	public void setNewDrugDosageForm(String newDrugDosageForm) {
		this.newDrugDosageForm = newDrugDosageForm;
	}

	@Column(name = "pharmacist_remarks")
	public String getPharmacistRemarks() {
		return pharmacistRemarks;
	}

	public void setPharmacistRemarks(String pharmacistRemarks) {
		this.pharmacistRemarks = pharmacistRemarks;
	}

	@Column(name = "pharmacist_requested_by")
	public String getPharmacistRequestedBy() {
		return pharmacistRequestedBy;
	}

	public void setPharmacistRequestedBy(String pharmacistRequestedBy) {
		this.pharmacistRequestedBy = pharmacistRequestedBy;
	}

	@Column(name = "pharmacist_designation")
	public String getPharmacistDesignation() {
		return pharmacistDesignation;
	}

	public void setPharmacistDesignation(String pharmacistDesignation) {
		this.pharmacistDesignation = pharmacistDesignation;
	}

	@Column(name = "pharmacist_requested_datetime")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getPharmacistRequestedDatetime() {
		return pharmacistRequestedDatetime;
	}

	public void setPharmacistRequestedDatetime(Date pharmacistRequestedDatetime) {
		this.pharmacistRequestedDatetime = pharmacistRequestedDatetime;
	}

	@Column(name = "request_by")
	public String getRequestBy() {
		return requestBy;
	}

	public void setRequestBy(String requestBy) {
		this.requestBy = requestBy;
	}

	@Column(name = "jkn")
	public String getJkn() {
		return jkn;
	}

	public void setJkn(String jkn) {
		this.jkn = jkn;
	}

	@Column(name = "SEND_FLAG")
	@JsonIgnore
	public String getSendFlag() {
		return sendFlag;
	}

	public void setSendFlag(String sendFlag) {
		this.sendFlag = sendFlag;
	}

	@Column(name="packaging_description")
	public String getPackagingDescription() {
		return packagingDescription;
	}

	public void setPackagingDescription(String packagingDescription) {
		this.packagingDescription = packagingDescription;
	}
	
	@Column(name="packaging_qty")
	public BigDecimal getPackagingQty() {
		return packagingQty;
	}

	public void setPackagingQty(BigDecimal packagingQty) {
		this.packagingQty = packagingQty;
	}
	
	@Column(name="cost_per_pack")
	public BigDecimal getCostPerPack() {
		return costPerPack;
	}

	public void setCostPerPack(BigDecimal costPerPack) {
		this.costPerPack = costPerPack;
	}

	@Column(name="total_cost")
	public BigDecimal getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
	}
	
	@Column(name="reg_status")
	public String getRegStatus() {
		return regStatus;
	}

	public void setRegStatus(String regStatus) {
		this.regStatus = regStatus;
	}
	
	@Column(name="indication_registered_mal")
	public String getIndicationRegisteredMal() {
		return this.indicationRegisteredMal;
	}

	public void setIndicationRegisteredMal(String indicationRegisteredMal) {
		this.indicationRegisteredMal = indicationRegisteredMal;
	}
	
	@Column(name="secretariat_remarks")
	public String getSecretariatRemarks() {
		return secretariatRemarks;
	}

	public void setSecretariatRemarks(String secretariatRemarks) {
		this.secretariatRemarks = secretariatRemarks;
	}
	
	@Column(name="secretariat_date")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getSecretariatDate() {
		return secretariatDate;
	}

	public void setSecretariatDate(Date secretariatDate) {
		this.secretariatDate = secretariatDate;
	}

	@Column(name = "indication_treatment")
	public String getIndicationTreatment() {
		return indicationTreatment;
	}

	public void setIndicationTreatment(String indicationTreatment) {
		this.indicationTreatment = indicationTreatment;
	}
	

	@ManyToOne
	@JoinColumn(name="GENERIC_NAME", referencedColumnName="drug_code", insertable = false, updatable=false)
	@JsonIgnore
	public Drug getDrug() {
		return drug;
	}

	public void setDrug(Drug drug) {
		this.drug = drug;
	}
	
	@ManyToOne
	@JoinColumns({@JoinColumn(name="PTJ_CODE", referencedColumnName="ptj_code", insertable=false, updatable=false),
		@JoinColumn(name="FAC_CODE", referencedColumnName="facility_code", insertable=false, updatable=false)
	})
	@JsonIgnore
	public ExternalFacility getExternalFacility() {
		return externalFacility;
	}

	public void setExternalFacility(ExternalFacility externalFacility) {
		this.externalFacility = externalFacility;
	}
	
	@Column(name="requester_designation")
	public String getRequesterDesignation() {
		return requesterDesignation;
	}

	public void setRequesterDesignation(String requesterDesignation) {
		this.requesterDesignation = requesterDesignation;
	}
	
	@Column(name="FULL_DRUG_NAME")
	@JsonIgnore
	public String getFullDrugName() {
		return fullDrugName;
	}

	public void setFullDrugName(String fullDrugName) {
		this.fullDrugName = fullDrugName;
	}
	
	@Column(name="REQUEST_QTY_UOM_CODE")
	public String getRequestQtyUomCode() {
		return requestQtyUomCode;
	}

	public void setRequestQtyUomCode(String requestQtyUomCode) {
		this.requestQtyUomCode = requestQtyUomCode;
	}

	//Newly Added
	@Column(name = "pkpf_status")
	public String getPkpfStatus() {
		return pkpfStatus;
	}

	public void setPkpfStatus(String pkpfStatus) {
		this.pkpfStatus = pkpfStatus;
	}
	
	@Column(name = "pkpf_remarks")
	public String getPkpfRemarks() {
		return pkpfRemarks;
	}

	public void setPkpfRemarks(String pkpfRemarks) {
		this.pkpfRemarks = pkpfRemarks;
	}
	
	@Column(name = "pkpf_name")
	public String getPkpfName() {
		return pkpfName;
	}

	public void setPkpfName(String pkpfName) {
		this.pkpfName = pkpfName;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "pkpf_date")
	public Date getPkpfDate() {
		return pkpfDate;
	}

	public void setPkpfDate(Date pkpfDate) {
		this.pkpfDate = pkpfDate;
	}

	@Column(name = "complete_check")
	public Character getCompleteForm() {
		return completeForm;
	}

	public void setCompleteForm(Character completeForm) {
		this.completeForm = completeForm;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "complete_form_date")
	public Date getCompleteFormDate() {
		return completeFormDate;
	}

	public void setCompleteFormDate(Date completeFormDate) {
		this.completeFormDate = completeFormDate;
	}

	@Column(name = "kpk_name")
	public String getKpkName() {
		return kpkName;
	}

	public void setKpkName(String kpkName) {
		this.kpkName = kpkName;
	}

	@Column(name = "approved_cost")
	public Double getApprovedCost() {
		return approvedCost;
	}

	public void setApprovedCost(Double approvedCost) {
		this.approvedCost = approvedCost;
	}

	@Column(name = "specialist_discipline")
	public String getSpecialistDiscipline() {
		return specialistDiscipline;
	}
	
	public void setSpecialistDiscipline(String specialistDiscipline) {
		this.specialistDiscipline = specialistDiscipline;
	}

	@Column(name = "repeat_no")
	public String getRepeatNo() {
		return repeatNo;
	}

	public void setRepeatNo(String repeatNo) {
		this.repeatNo = repeatNo;
	}
	
	@JsonIgnore
	@Column(name = "kpk_recommended_by")
	public String getKpkRecoomendedBy() {
		return kpkRecoomendedBy;
	}

	public void setKpkRecoomendedBy(String kpkRecoomendedBy) {
		this.kpkRecoomendedBy = kpkRecoomendedBy;
	}

	@JsonIgnore
	@Column(name = "inidication_listed_fukkm")
	public String getPbkdFukkmListedIndication() {
		return pbkdFukkmListedIndication;
	}

	public void setPbkdFukkmListedIndication(String pbkdFukkmListedIndication) {
		this.pbkdFukkmListedIndication = pbkdFukkmListedIndication;
	}
	
	@JsonIgnore
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "submission_date")
	public Date getSubmissionDate() {
		return submissionDate;
	}

	public void setSubmissionDate(Date submissionDate) {
		this.submissionDate = submissionDate;
	}

	@JsonIgnore
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "action_date")
	public Date getActionDate() {
		return actionDate;
	}

	public void setActionDate(Date actionDate) {
		this.actionDate = actionDate;
	}
	
	@JsonIgnore
	@Column(name = "approved_indication")
	public String getApproved_indication() {
		return approved_indication;
	}

	public void setApproved_indication(String approved_indication) {
		this.approved_indication = approved_indication;
	}
	
	@JsonIgnore
	@Column(name = "serial_no")
	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	
	@JsonIgnore
	@Column(name = "attachment1_name")
	public String getAttachment1Name() {
		return attachment1Name;
	}

	public void setAttachment1Name(String attachment1Name) {
		this.attachment1Name = attachment1Name;
	}
	
	@JsonIgnore
	@Column(name = "attachment4_name")
	public String getAttachment4Name() {
		return attachment4Name;
	}

	public void setAttachment4Name(String attachment4Name) {
		this.attachment4Name = attachment4Name;
	}
	
	@JsonIgnore
	@Column(name = "attachment2_name")
	public String getAttachment2Name() {
		return attachment2Name;
	}

	public void setAttachment2Name(String attachment2Name) {
		this.attachment2Name = attachment2Name;
	}

	@JsonIgnore
	@Column(name = "attachment3_name")
	public String getAttachment3Name() {
		return attachment3Name;
	}

	public void setAttachment3Name(String attachment3Name) {
		this.attachment3Name = attachment3Name;
	}
	
	@JsonIgnore
	@Column(name = "attachment5_name")
	public String getAttachment5Name() {
		return attachment5Name;
	}

	public void setAttachment5Name(String attachment5Name) {
		this.attachment5Name = attachment5Name;
	}
	
	@JsonIgnore
	@Column(name = "approvalattachment_name")
	public String getApprovalattachment_name() {
		return approvalattachment_name;
	}

	public void setApprovalattachment_name(String approvalattachment_name) {
		this.approvalattachment_name = approvalattachment_name;
	}
	
	@JsonIgnore
	@Column(name = "kpkattachment_name")
	public String getKpkattachment_name() {
		return kpkattachment_name;
	}

	public void setKpkattachment_name(String kpkattachment_name) {
		this.kpkattachment_name = kpkattachment_name;
	}
	
}
