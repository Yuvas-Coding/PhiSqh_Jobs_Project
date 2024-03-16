package my.com.cmg.iwp.maintenance.model.report.stg;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_DRUG_ALLERGY_REPORT_STG")
public class DrugAllergyReportStg implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long drugAllergyReportSeqno;
	private String jknDesc;
	private String facilityName;
	private String facilityCode;
	private Date reportedDate;
	private String dacSerialNo;
	private String dacUniversalSerialNo;
	private String patientName;
	private String patientIdNo;
	private String age;
	private String activeIngrediant;
	private String drugNonAllergyMoh;
	private String allergenOthers;
	private String brandName;
	private String allergenSeverity;
	private String allergenReactionDetails;
	private String status;
	private Character printFlag;
	private long createdBy;
	private String allergyDescription;
	
	
	
	
	@Id
	@Column(name = "DRUG_ALLERGIY_REPORT_SEQNO", unique = true, nullable = false)
	public long getDrugAllergyReportSeqno() {
		return drugAllergyReportSeqno;
	}
	public void setDrugAllergyReportSeqno(long drugAllergyReportSeqno) {
		this.drugAllergyReportSeqno = drugAllergyReportSeqno;
	}
	
	@Column(name = "JKN_DESC", length = 500)
	public String getJknDesc() {
		return jknDesc;
	}
	public void setJknDesc(String jknDesc) {
		this.jknDesc = jknDesc;
	}
	
	@Column(name = "FACILITY_NAME", length = 50)
	public String getFacilityName() {
		return facilityName;
	}
	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}
	
	@Column(name = "FACILITY_CODE", length = 20)
	public String getFacilityCode() {
		return facilityCode;
	}
	public void setFacilityCode(String facilityCode) {
		this.facilityCode = facilityCode;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "REPORTED_DATE", nullable = false, length = 29)
	public Date getReportedDate() {
		return reportedDate;
	}
	public void setReportedDate(Date reportedDate) {
		this.reportedDate = reportedDate;
	}
	
	@Column(name = "DAC_SERIAL_NO", length = 30)
	public String getDacSerialNo() {
		return dacSerialNo;
	}
	public void setDacSerialNo(String dacSerialNo) {
		this.dacSerialNo = dacSerialNo;
	}
	
	@Column(name = "DAC_UNIVERSAL_SERIAL_NO", length = 24)
	public String getDacUniversalSerialNo() {
		return dacUniversalSerialNo;
	}
	public void setDacUniversalSerialNo(String dacUniversalSerialNo) {
		this.dacUniversalSerialNo = dacUniversalSerialNo;
	}
	
	@Column(name = "PATIENT_NAME", length = 100)
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	
	@Column(name = "PATIENT_IDNO", length = 100)
	public String getPatientIdNo() {
		return patientIdNo;
	}
	public void setPatientIdNo(String patientIdNo) {
		this.patientIdNo = patientIdNo;
	}
	
	@Column(name = "AGE", length = 100)
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	/*@Column(name = "ALLERGY_DESCRIPTION", length = 100)*/
	@Column(name = "GENERIC_DESC", length = 500)
	public String getActiveIngrediant() {
		return activeIngrediant;
	}
	public void setActiveIngrediant(String activeIngrediant) {
		this.activeIngrediant = activeIngrediant;
	}
	
	@Column(name = "DRUG_ALLERGY_NONMOH", length = 250)
	public String getDrugNonAllergyMoh() {
		return drugNonAllergyMoh;
	}
	public void setDrugNonAllergyMoh(String drugNonAllergyMoh) {
		this.drugNonAllergyMoh = drugNonAllergyMoh;
	}
	
	@Column(name = "ALLERGEN_OTHERS", length = 100)
	public String getAllergenOthers() {
		return allergenOthers;
	}
	public void setAllergenOthers(String allergenOthers) {
		this.allergenOthers = allergenOthers;
	}
	
	@Column(name = "BRD_NAME", length = 250)
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	
	@Column(name = "ALLERGEN_SEVERITY", length = 500)
	public String getAllergenSeverity() {
		return allergenSeverity;
	}
	public void setAllergenSeverity(String allergenSeverity) {
		this.allergenSeverity = allergenSeverity;
	}
	
	@Column(name = "REACTION_DETAILS", length = 200)
	public String getAllergenReactionDetails() {
		return allergenReactionDetails;
	}
	public void setAllergenReactionDetails(String allergenReactionDetails) {
		this.allergenReactionDetails = allergenReactionDetails;
	}
	
	@Column(name = "ALLERGY_STATUS", length = 500)
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Column(name = "PRINT_FLAG")
	public Character getPrintFlag() {
		return printFlag;
	}
	public void setPrintFlag(Character printFlag) {
		this.printFlag = printFlag;
	}
	
	@Column(name = "created_by", nullable = false)
	public long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}
	
	@Column(name = "ALLERGY_DESCRIPTION", length = 100)
	public String getAllergyDescription() {
		return allergyDescription;
	}
	public void setAllergyDescription(String allergyDescription) {
		this.allergyDescription = allergyDescription;
	}
	
	
}
