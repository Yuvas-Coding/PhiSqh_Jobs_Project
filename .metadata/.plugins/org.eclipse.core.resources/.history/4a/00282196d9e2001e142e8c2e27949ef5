package my.com.cmg.iwp.backend.model.integration.cdr;

import java.io.Serializable;
import java.math.BigDecimal;
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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * The persistent class for the ph_cdr_drugs_schedule_int database table.
 * 
 */
@Entity
@Table(name="t_cdr_drugs_schedule_int")
@JsonIgnoreProperties(ignoreUnknown=true)
public class CdrDrugsScheduleInt implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long drugScheduleIntSeqno;
	private Date adminTime;
	private Long createdBy;
	private Date createdDate;
	private Integer days;
	private Date doseDate;
	private String parameter1;
	private String parameter2;
	private BigDecimal parameter3;
	private BigDecimal parameter4;
	private Date parameter5;
	private Long updatedBy;
	private Date updatedDate;
	private CdrDrugsInt cdrDrugsInt;
	
	
	private Character supplied_yn;
	private String supplyStatus;
	private Double splitTotalDose;
	private Date prepareDate;
	
	private Character holdResumeDoseYn;
	private Double modifiedTotalDosePerDay;
	private BigDecimal modifiedDrugVolume;
	private BigDecimal modifiedTotalVolume;
	private BigDecimal modifiedInfusionRate;
	

	public CdrDrugsScheduleInt() {
	}


	@Id
	@SequenceGenerator(name="PH_CDR_DRUGS_SCHEDULE_INT_DRUGSCHEDULEINTSEQNO_GENERATOR", sequenceName="t_cdr_drugs_schedule_int_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PH_CDR_DRUGS_SCHEDULE_INT_DRUGSCHEDULEINTSEQNO_GENERATOR")
	@Column(name="drug_schedule_int_seqno")
	@JsonIgnore
	public Long getDrugScheduleIntSeqno() {
		return this.drugScheduleIntSeqno;
	}

	public void setDrugScheduleIntSeqno(Long drugScheduleIntSeqno) {
		this.drugScheduleIntSeqno = drugScheduleIntSeqno;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="admin_time")
	public Date getAdminTime() {
		return this.adminTime;
	}

	public void setAdminTime(Date adminTime) {
		this.adminTime = adminTime;
	}


	@Column(name="created_by")
	public Long getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}


	@Temporal( TemporalType.TIMESTAMP)
	@Column(name="created_date")
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}


	public Integer getDays() {
		return this.days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}


	@Temporal( TemporalType.DATE)
	@Column(name="dose_date")
	public Date getDoseDate() {
		return this.doseDate;
	}

	public void setDoseDate(Date doseDate) {
		this.doseDate = doseDate;
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


	@Temporal( TemporalType.DATE)
	public Date getParameter5() {
		return this.parameter5;
	}

	public void setParameter5(Date parameter5) {
		this.parameter5 = parameter5;
	}


	@Column(name="updated_by")
	public Long getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}


	@Temporal( TemporalType.TIMESTAMP)
	@Column(name="updated_date")
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}


	//bi-directional many-to-one association to CdrDrugsInt
	@ManyToOne
	@JoinColumn(name="cdr_drug_int_seqno")
	@JsonBackReference("CdrDrugsScheduleInt")
	public CdrDrugsInt getCdrDrugsInt() {
		return this.cdrDrugsInt;
	}

	public void setCdrDrugsInt(CdrDrugsInt cdrDrugsInt) {
		this.cdrDrugsInt = cdrDrugsInt;
	}
	
	@Column(name = "supplied_yn")
	public Character getSupplied_yn() {
		return supplied_yn;
	}

	public void setSupplied_yn(Character supplied_yn) {
		this.supplied_yn = supplied_yn;
	}

	@Column(name = "supply_status")
	public String getSupplyStatus() {
		return supplyStatus;
	}

	public void setSupplyStatus(String supplyStatus) {
		this.supplyStatus = supplyStatus;
	}

	@Column(name = "split_total_dose")
	public Double getSplitTotalDose() {
		return splitTotalDose;
	}

	public void setSplitTotalDose(Double splitTotalDose) {
		this.splitTotalDose = splitTotalDose;
	}

	@Temporal( TemporalType.DATE)
	@Column(name="prep_date")
	public Date getPrepareDate() {
		return prepareDate;
	}

	public void setPrepareDate(Date prepareDate) {
		this.prepareDate = prepareDate;
	}

	@Column(name = "hold_resume_dose_yn")
	public Character getHoldResumeDoseYn() {
		return holdResumeDoseYn;
	}

	public void setHoldResumeDoseYn(Character holdResumeDoseYn) {
		this.holdResumeDoseYn = holdResumeDoseYn;
	}

	@Column(name = "modified_totaldose_perday")
	public Double getModifiedTotalDosePerDay() {
		return modifiedTotalDosePerDay;
	}

	public void setModifiedTotalDosePerDay(Double modifiedTotalDosePerDay) {
		this.modifiedTotalDosePerDay = modifiedTotalDosePerDay;
	}

	@Column(name = "modified_drug_volume")
	public BigDecimal getModifiedDrugVolume() {
		return modifiedDrugVolume;
	}

	public void setModifiedDrugVolume(BigDecimal modifiedDrugVolume) {
		this.modifiedDrugVolume = modifiedDrugVolume;
	}

	@Column(name = "modified_total_volume")
	public BigDecimal getModifiedTotalVolume() {
		return modifiedTotalVolume;
	}

	public void setModifiedTotalVolume(BigDecimal modifiedTotalVolume) {
		this.modifiedTotalVolume = modifiedTotalVolume;
	}

	@Column(name = "modified_infusion_rate")
	public BigDecimal getModifiedInfusionRate() {
		return modifiedInfusionRate;
	}

	public void setModifiedInfusionRate(BigDecimal modifiedInfusionRate) {
		this.modifiedInfusionRate = modifiedInfusionRate;
	}
	
		
	

}