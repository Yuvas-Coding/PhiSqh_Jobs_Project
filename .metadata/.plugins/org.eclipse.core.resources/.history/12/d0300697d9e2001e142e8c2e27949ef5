package my.com.cmg.iwp.backend.model.sdr;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "T_SPL_DRUG_REQUEST_INT_VW")
public class SpecialDrugRequestOrderVW implements Serializable{
	
	private String hosRequestNo;
	private String bpfRegisterNo;
	private String requestType;
	private String facCode;
	private Double newDrugStrength;
	private String activeIngredient;
	private String newDrugUom;
	private String newDrugDosageForm;
	private String fullDrugName;
	private String genericName;
	private Date submissionDate;
	private String facilityName;
	private String drugName;
	
	@Column(name = "STATUS")
	private String status;
	
	@Id
	@Column(name = "HOS_REQUEST_NO")
	public String getHosRequestNo() {
		return this.hosRequestNo;
	}

	public void setHosRequestNo(String hosRequestNo) {
		this.hosRequestNo = hosRequestNo;
	}
	
	@Column(name = "BPF_REGISTER_NO")
	public String getBpfRegisterNo() {
		return this.bpfRegisterNo;
	}

	public void setBpfRegisterNo(String bpfRegisterNo) {
		this.bpfRegisterNo = bpfRegisterNo;
	}

	@Column(name = "REQUEST_TYPE")
	public String getRequestType() {
		return this.requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}
	
	@Column(name = "FAC_CODE", nullable = false)
	public String getFacCode() {
		return this.facCode;
	}

	public void setFacCode(String facCode) {
		this.facCode = facCode;
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
	@Column(name = "GENERIC_NAME")
	public String getGenericName() {
		return this.genericName;
	}

	public void setGenericName(String genericName) {
		this.genericName = genericName;
	}
	
	@Column(name="FULL_DRUG_NAME")
	public String getFullDrugName() {
		return fullDrugName;
	}

	public void setFullDrugName(String fullDrugName) {
		this.fullDrugName = fullDrugName;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "submission_date")
	public Date getSubmissionDate() {
		return submissionDate;
	}

	public void setSubmissionDate(Date submissionDate) {
		this.submissionDate = submissionDate;
	}

	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "facility_name")
	public String getFacilityName() {
		return facilityName;
	}

	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}

	@Column(name = "drug_name")
	public String getDrugName() {
		return drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

}
