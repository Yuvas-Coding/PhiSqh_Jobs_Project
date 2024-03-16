package my.com.cmg.iwp.backend.model.kpk.reports;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "T_COMPLETE_REG_REPORT_STG")
public class CompleteRegistrationStg implements java.io.Serializable {

	private long completeRegRptSeqno = Long.MIN_VALUE;
	private String bpfRegisterNo;
	private Date sdrCreatedDate;
	private Date completedDate;
	private Date kpkDate;
	private String processingTimeDays;
	private String requestType;
	private String activeIngredient;
	private String patientName;
	private String hospitalName;
	private String state;
	private String indicationTreatment;
	private Long pbkdRequestQuantity;
	private String requestQtyUomCode;
	private BigDecimal totalCost;
	private String specialistRequestedBy;
	private String  pharmacistRequestedBy;
	private String pbkdManufacturedBy;
	private String pbkdImported_by;
	private String status;
	private long createdBy;
	private Date createdDate;
	private long updatedBy;
	private Date updatedDate;
	private Character activeFlag ;
	private long kpkApprovedQuantity;
	private String kpkApprovedUomCode;
	private Double approvedCost;
	private String kpkCategory;

	public CompleteRegistrationStg() {
	}

	
	@Id
	@Column(name = "COMPLETE_REG_RPT_SEQNO", unique = true, nullable = false)
	@SequenceGenerator(name = "T_COMPLETE_REG_REPORT_STG_SEQ", sequenceName = "T_COMPLETE_REG_REPORT_STG_SEQ", allocationSize = 1)
	public long getCompleteRegRptSeqno() {
		return completeRegRptSeqno;
	}

	public void setCompleteRegRptSeqno(long completeRegRptSeqno) {
		this.completeRegRptSeqno = completeRegRptSeqno;
	}

	@Column(name = "BPF_REGISTER_NO")
	public String getBpfRegisterNo() {
		return bpfRegisterNo;
	}

	public void setBpfRegisterNo(String bpfRegisterNo) {
		this.bpfRegisterNo = bpfRegisterNo;
	}

	@Column(name = "SDR_CREATED_DATE")
	public Date getSdrCreatedDate() {
		return sdrCreatedDate;
	}

	public void setSdrCreatedDate(Date sdrCreatedDate) {
		this.sdrCreatedDate = sdrCreatedDate;
	}
	
	@Column(name = "COMPLETE_FORM_DATE")
	public Date getCompletedDate() {
		return completedDate;
	}


	public void setCompletedDate(Date completedDate) {
		this.completedDate = completedDate;
	}
	
	@Column(name = "KPK_DATE")
	public Date getKpkDate() {
		return kpkDate;
	}

	public void setKpkDate(Date kpkDate) {
		this.kpkDate = kpkDate;
	}

	@Column(name = "PROCESSING_TIME_DAYS")
	public String getProcessingTimeDays() {
		return processingTimeDays;
	}

	public void setProcessingTimeDays(String processingTimeDays) {
		this.processingTimeDays = processingTimeDays;
	}

	@Column(name = "REQUEST_TYPE")
	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	@Column(name = "ACTIVE_INGREDIENT")
	public String getActiveIngredient() {
		return activeIngredient;
	}

	public void setActiveIngredient(String activeIngredient) {
		this.activeIngredient = activeIngredient;
	}

	@Column(name = "PATIENT_NAME")
	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	@Column(name = "HOSPITAL_NAME")
	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	@Column(name = "STATE")
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "INDICATION_TREATMENT")
	public String getIndicationTreatment() {
		return indicationTreatment;
	}

	public void setIndicationTreatment(String indicationTreatment) {
		this.indicationTreatment = indicationTreatment;
	}

	@Column(name = "PBKD_REQUEST_QUANTITY")
	public Long getPbkdRequestQuantity() {
		return pbkdRequestQuantity;
	}

	public void setPbkdRequestQuantity(Long pbkdRequestQuantity) {
		this.pbkdRequestQuantity = pbkdRequestQuantity;
	}

	@Column(name = "REQUEST_QTY_UOM_CODE")
	public String getRequestQtyUomCode() {
		return requestQtyUomCode;
	}

	public void setRequestQtyUomCode(String requestQtyUomCode) {
		this.requestQtyUomCode = requestQtyUomCode;
	}

	@Column(name = "TOTAL_COST")
	public BigDecimal getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
	}

	@Column(name = "SPECIALIST_REQUESTED_BY")
	public String getSpecialistRequestedBy() {
		return specialistRequestedBy;
	}

	public void setSpecialistRequestedBy(String specialistRequestedBy) {
		this.specialistRequestedBy = specialistRequestedBy;
	}
	
	@Column(name = "PHARMACIST_REQUESTED_BY")
	public String getPharmacistRequestedBy() {
		return pharmacistRequestedBy;
	}


	public void setPharmacistRequestedBy(String pharmacistRequestedBy) {
		this.pharmacistRequestedBy = pharmacistRequestedBy;
	}
	

	@Column(name = "PBKD_MANUFACTURED_BY")
	public String getPbkdManufacturedBy() {
		return pbkdManufacturedBy;
	}

	public void setPbkdManufacturedBy(String pbkdManufacturedBy) {
		this.pbkdManufacturedBy = pbkdManufacturedBy;
	}

	@Column(name = "PBKD_IMPORTED_BY")
	public String getPbkdImported_by() {
		return pbkdImported_by;
	}

	public void setPbkdImported_by(String pbkdImported_by) {
		this.pbkdImported_by = pbkdImported_by;
	}

	@Column(name = "STATUS")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "CREATED_BY")
	public long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "CREATED_DATE")
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "UPDATED_BY")
	public long getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(long updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Column(name = "UPDATED_DATE")
	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Column(name = "ACTIVE_FLAG")
	public Character getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(Character activeFlag) {
		this.activeFlag = activeFlag;
	}

	@Column(name = "KPK_APPROVED_QUANTITY", precision = 38, scale = 0)
	public long getKpkApprovedQuantity() {
		return kpkApprovedQuantity;
	}


	public void setKpkApprovedQuantity(long kpkApprovedQuantity) {
		this.kpkApprovedQuantity = kpkApprovedQuantity;
	}

	@Column(name="KPK_APPROVED_UOM")
	public String getKpkApprovedUomCode() {
		return kpkApprovedUomCode;
	}

	public void setKpkApprovedUomCode(String kpkApprovedUomCode) {
		this.kpkApprovedUomCode = kpkApprovedUomCode;
	}

	@Column(name = "approved_cost")
	public Double getApprovedCost() {
		return approvedCost;
	}


	public void setApprovedCost(Double approvedCost) {
		this.approvedCost = approvedCost;
	}

	@Column(name = "kpk_category")
	public String getKpkCategory() {
		return kpkCategory;
	}


	public void setKpkCategory(String kpkCategory) {
		this.kpkCategory = kpkCategory;
	}

	
}
