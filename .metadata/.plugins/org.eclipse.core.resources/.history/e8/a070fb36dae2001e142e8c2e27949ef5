package my.com.cmg.iwp.backend.model.integration.cdr;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * The persistent class for the ph_cdr_dose_frequency_int database table.
 * 
 */
@Entity
@Table(name = "t_cdr_dose_frequency_int")
@XmlRootElement(name = "CdrDoseFrequencyInt")
@JsonIgnoreProperties(ignoreUnknown=true)
public class CdrDoseFrequencyInt implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long doseFrequencyIntSeqno;
	private Date adminTime;
	private Long createdBy;
	private Date createdDate;
	private Integer days;
	private Date doseDate;
	private String drugCode;
	private String parameter1;
	private String parameter2;
	private BigDecimal parameter3;
	private BigDecimal parameter4;
	private Date parameter5;
	private Long updatedBy;
	private Date updatedDate;
	private CdrInfusionDrugsInt cdrInfusionDrugsInt;
	private CdrNormalDrugsInt cdrNormalDrugsInt;

	public CdrDoseFrequencyInt() {
	}

	@Id
	@SequenceGenerator(name = "PH_CDR_DOSE_FREQUENCY_INT_DOSEFREQUENCYINTSEQNO_GENERATOR", sequenceName = "t_cdr_dose_frequency_int_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PH_CDR_DOSE_FREQUENCY_INT_DOSEFREQUENCYINTSEQNO_GENERATOR")
	@Column(name = "dose_frequency_int_seqno")
	public Long getDoseFrequencyIntSeqno() {
		return this.doseFrequencyIntSeqno;
	}

	public void setDoseFrequencyIntSeqno(Long doseFrequencyIntSeqno) {
		this.doseFrequencyIntSeqno = doseFrequencyIntSeqno;
	}

	@Column(name = "admin_time")
	@Temporal(TemporalType.TIME)
	@JsonIgnore
	// TODO incompatible type...pending for dzung
	public Date getAdminTime() {
		return this.adminTime;
	}

	public void setAdminTime(Date adminTime) {
		this.adminTime = adminTime;
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

	public Integer getDays() {
		return this.days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dose_date")
	public Date getDoseDate() {
		return this.doseDate;
	}

	public void setDoseDate(Date doseDate) {
		this.doseDate = doseDate;
	}

	@Column(name = "drug_code")
	public String getDrugCode() {
		return this.drugCode;
	}

	public void setDrugCode(String drugCode) {
		this.drugCode = drugCode;
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

	// bi-directional many-to-one association to CdrInfusionDrugsInt
	@ManyToOne
	@JoinColumn(name = "cdr_infusion_int_seqno")
	@XmlElement
	@JsonBackReference("CdrInfusionDoseFrequencyInt")
	public CdrInfusionDrugsInt getCdrInfusionDrugsInt() {
		return this.cdrInfusionDrugsInt;
	}

	public void setCdrInfusionDrugsInt(CdrInfusionDrugsInt cdrInfusionDrugsInt) {
		this.cdrInfusionDrugsInt = cdrInfusionDrugsInt;
	}

	// bi-directional many-to-one association to CdrNormalDrugsInt
	@ManyToOne
	@JoinColumn(name = "cdr_normal_drug_int_seqno")
	@XmlElement
	@JsonBackReference("CdrDoseFrequencyInt")
	public CdrNormalDrugsInt getCdrNormalDrugsInt() {
		return this.cdrNormalDrugsInt;
	}

	public void setCdrNormalDrugsInt(CdrNormalDrugsInt cdrNormalDrugsInt) {
		this.cdrNormalDrugsInt = cdrNormalDrugsInt;
	}

}