package my.com.cmg.iwp.maintenance.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "t_non_moh_allergies", uniqueConstraints = @UniqueConstraint(columnNames = "non_moh_allergies_seqno"))
public class NonMohDrugAllergy implements java.io.Serializable {

	
	private static final long serialVersionUID = -8254788970317207113L;
	private long nonmohAllergySeqNo = Long.MIN_VALUE;
	private String allergenCode;
	private String allergenType;
	private String allergenDescription;
	private String mohDescription;
	private Character activeFlag = 'A';
	private long createdBy;
	private Date createdDate;
	private long updatedBy;
	private Date updatedDate;
	
	public NonMohDrugAllergy()	{
	}

	@Id
	@Column(name = "non_moh_allergies_seqno", unique = true, nullable = false)
	@SequenceGenerator(name = "nonMohAllergySEQ", sequenceName = "t_non_moh_allergies_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nonMohAllergySEQ")
	public long getNonmohAllergySeqNo() {
		return nonmohAllergySeqNo;
	}

	public void setNonmohAllergySeqNo(long nonmohAllergySeqNo) {
		this.nonmohAllergySeqNo = nonmohAllergySeqNo;
	}

	@Column(name = "allergen_code", length = 20)
	public String getAllergenCode() {
		return allergenCode;
	}

	public void setAllergenCode(String allergenCode) {
		this.allergenCode = allergenCode;
	}
	
	@Column(name = "allergen_type", length = 20)
	public String getAllergenType() {
		return allergenType;
	}

	public void setAllergenType(String allergenType) {
		this.allergenType = allergenType;
	}

	@Column(name = "non_allergies_description", length = 100)
	public String getAllergenDescription() {
		return allergenDescription;
	}

	public void setAllergenDescription(String allergenDescription) {
		this.allergenDescription = allergenDescription;
	}
	
	@Column(name = "non_moh_description", length = 100)
	public String getMohDescription() {
		return mohDescription;
	}

	public void setMohDescription(String mohDescription) {
		this.mohDescription = mohDescription;
	}

	@Column(name = "active_flag")
	public Character getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(Character activeFlag) {
		this.activeFlag = activeFlag;
	}

	@Column(name = "created_by")
	public long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", nullable = false, length = 29)
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "updated_by")
	public long getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(long updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_date", nullable = false, length = 29)
	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

}
