package my.com.cmg.iwp.backend.model.integration;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


/**
 * The persistent class for the ph_patient_allergies_int database table.
 * 
 */
@Entity
@Table(name="t_patient_allergies_int")
@JsonIgnoreProperties(ignoreUnknown=true)
public class PatientAllergiesInt implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long patientAllergiesIntSeqno;
	private String allergenType;
	private String allergyCode;
	private String allergyConfirmedBy;
	private Date allergyConfirmedDate;
	private String allergyDesc;
	private Date allergyReslovedDate;
	private String allergyResolvedBy;
	private String allergySeverity;
	private String allergyStatus;
	private String allergySuspectedBy;
	private Date allergySuspectedDate;
	private String atcCode;
	private String brandCode;
	private Long createdBy;
	private Date createdDate;
	private String drugAllergyNonmoh;
	private String drugCode;
	private String genericCode;
	private Date identificationDate;
	private Long orderIntSeqno;
	private String otherAllergen;
	private String reaction;
	private Long updatedBy;
	private Date updatedDate;
	private Integer version;
	
	private OutsourceOrderInt outsourceOrderInt;

	public PatientAllergiesInt() {
	}

	@Id
	@SequenceGenerator(name="PH_PATIENT_ALLERGIES_INT_PATIENTALLERGIESINTSEQNO_GENERATOR", sequenceName="t_patient_allergies_int_seq", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PH_PATIENT_ALLERGIES_INT_PATIENTALLERGIESINTSEQNO_GENERATOR")
	@Column(name="patient_allergies_int_seqno")
	@JsonIgnore
	public Long getPatientAllergiesIntSeqno() {
		return this.patientAllergiesIntSeqno;
	}

	public void setPatientAllergiesIntSeqno(Long patientAllergiesIntSeqno) {
		this.patientAllergiesIntSeqno = patientAllergiesIntSeqno;
	}
	
	@Column(name="allergen_type")
	public String getAllergenType() {
		return this.allergenType;
	}

	public void setAllergenType(String allergenType) {
		this.allergenType = allergenType;
	}


	@Column(name="allergy_code")
	public String getAllergyCode() {
		return this.allergyCode;
	}

	public void setAllergyCode(String allergyCode) {
		this.allergyCode = allergyCode;
	}


	@Column(name="allergy_confirmed_by")
	public String getAllergyConfirmedBy() {
		return this.allergyConfirmedBy;
	}

	public void setAllergyConfirmedBy(String allergyConfirmedBy) {
		this.allergyConfirmedBy = allergyConfirmedBy;
	}


	@Column(name="allergy_confirmed_date")
	@Temporal(TemporalType.DATE)
	public Date getAllergyConfirmedDate() {
		return this.allergyConfirmedDate;
	}

	public void setAllergyConfirmedDate(Date allergyConfirmedDate) {
		this.allergyConfirmedDate = allergyConfirmedDate;
	}


	@Column(name="allergy_desc")
	public String getAllergyDesc() {
		return this.allergyDesc;
	}

	public void setAllergyDesc(String allergyDesc) {
		this.allergyDesc = allergyDesc;
	}


	@Column(name="allergy_resloved_date")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getAllergyReslovedDate() {
		return this.allergyReslovedDate;
	}

	public void setAllergyReslovedDate(Date allergyReslovedDate) {
		this.allergyReslovedDate = allergyReslovedDate;
	}


	@Column(name="allergy_resolved_by")
	public String getAllergyResolvedBy() {
		return this.allergyResolvedBy;
	}

	public void setAllergyResolvedBy(String allergyResolvedBy) {
		this.allergyResolvedBy = allergyResolvedBy;
	}


	@Column(name="allergy_severity")
	public String getAllergySeverity() {
		return this.allergySeverity;
	}

	public void setAllergySeverity(String allergySeverity) {
		this.allergySeverity = allergySeverity;
	}


	@Column(name="allergy_status")
	public String getAllergyStatus() {
		return this.allergyStatus;
	}

	public void setAllergyStatus(String allergyStatus) {
		this.allergyStatus = allergyStatus;
	}


	@Column(name="allergy_suspected_by")
	public String getAllergySuspectedBy() {
		return this.allergySuspectedBy;
	}

	public void setAllergySuspectedBy(String allergySuspectedBy) {
		this.allergySuspectedBy = allergySuspectedBy;
	}


	@Column(name="allergy_suspected_date")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getAllergySuspectedDate() {
		return this.allergySuspectedDate;
	}

	public void setAllergySuspectedDate(Date allergySuspectedDate) {
		this.allergySuspectedDate = allergySuspectedDate;
	}


	@Column(name="atc_code")
	public String getAtcCode() {
		return this.atcCode;
	}

	public void setAtcCode(String atcCode) {
		this.atcCode = atcCode;
	}


	@Column(name="brand_code")
	public String getBrandCode() {
		return this.brandCode;
	}

	public void setBrandCode(String brandCode) {
		this.brandCode = brandCode;
	}


	@Column(name="created_by")
	public Long getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}


	@Column(name="created_date")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}


	@Column(name="drug_allergy_nonmoh")
	public String getDrugAllergyNonmoh() {
		return this.drugAllergyNonmoh;
	}

	public void setDrugAllergyNonmoh(String drugAllergyNonmoh) {
		this.drugAllergyNonmoh = drugAllergyNonmoh;
	}


	@Column(name="drug_code")
	public String getDrugCode() {
		return this.drugCode;
	}

	public void setDrugCode(String drugCode) {
		this.drugCode = drugCode;
	}


	@Column(name="generic_code")
	public String getGenericCode() {
		return this.genericCode;
	}

	public void setGenericCode(String genericCode) {
		this.genericCode = genericCode;
	}


    @Temporal( TemporalType.DATE)
	@Column(name="identification_date")
	public Date getIdentificationDate() {
		return this.identificationDate;
	}

	public void setIdentificationDate(Date identificationDate) {
		this.identificationDate = identificationDate;
	}


	@Column(name="order_int_seqno", insertable = false, updatable = false)
	public Long getOrderIntSeqno() {
		return this.orderIntSeqno;
	}

	public void setOrderIntSeqno(Long orderIntSeqno) {
		this.orderIntSeqno = orderIntSeqno;
	}


	@Column(name="other_allergen")
	public String getOtherAllergen() {
		return this.otherAllergen;
	}

	public void setOtherAllergen(String otherAllergen) {
		this.otherAllergen = otherAllergen;
	}

	@Column(name="reaction")
	public String getReaction() {
		return this.reaction;
	}

	public void setReaction(String reaction) {
		this.reaction = reaction;
	}


	@Column(name="updated_by")
	public Long getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}


	@Column(name="updated_date")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}


	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	
	@ManyToOne
	@JoinColumn(name="order_int_seqno", referencedColumnName = "outsource_int_seqno")
	@XmlElement
	@JsonBackReference("PatientAllergiesOutsourceOrderInt")
	public OutsourceOrderInt getOutsourceOrderInt() {
		return outsourceOrderInt;
	}

	public void setOutsourceOrderInt(OutsourceOrderInt outsourceOrderInt) {
		this.outsourceOrderInt = outsourceOrderInt;
	}

}