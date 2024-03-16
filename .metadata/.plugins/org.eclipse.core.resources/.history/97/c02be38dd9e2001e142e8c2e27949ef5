package my.com.cmg.iwp.backend.model.sdr;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonManagedReference;

@XmlRootElement(name = "SpecialDrugPatient")
@JsonIgnoreProperties(ignoreUnknown=true)
public class SpecialDrugPatientV1823 implements java.io.Serializable {

	private long sdPatientSeqno;
	private Integer version;
	private SpecialDrugRequestOrderV1823 specialDrugRequestOrder;
	private String patientMrn;
	private String patientName;
	private String idType;
	private String icNo;
	private long createdBy;
	private Date createdDate;
	private long updatedBy;
	private Date updatedDate;
	private Double dose;
	private String uomDesc;
	private String freqDesc;
	private Double duration;
	private String durationUnit;
	private String diagnosis;
	private String summaryPatIndHist;
	private String remarks;
	/*private String dosageFreq;
	private String durationwithUnit;*/
	private Set<SpecialDrugTreatmentV1823> specialDrugTreatments= new HashSet<SpecialDrugTreatmentV1823>(0);

	public SpecialDrugPatientV1823() {
	}

	@Id
	@Column(name = "SD_PATIENT_SEQNO", unique = true, nullable = false, precision = 38, scale = 0)
	@SequenceGenerator(name = "sdPatientSeqno", sequenceName = "T_SPL_DRUG_PATIENT_INT_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sdPatientSeqno")
	public long getSdPatientSeqno() {
		return this.sdPatientSeqno;
	}

	public void setSdPatientSeqno(long sdPatientSeqno) {
		this.sdPatientSeqno = sdPatientSeqno;
	}

	@Version
	@Column(name = "VERSION")
	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SDR_ORDER_SEQNO", nullable = false)
	@JsonBackReference
	public SpecialDrugRequestOrderV1823 getSpecialDrugRequestOrder() {
		return this.specialDrugRequestOrder;
	}

	public void setSpecialDrugRequestOrder(
			SpecialDrugRequestOrderV1823 specialDrugRequestOrder) {
		this.specialDrugRequestOrder = specialDrugRequestOrder;
//		if (specialDrugRequestOrder != null)
//			this.setSdrOrderSeqno(specialDrugRequestOrder.getSdrOrderSeqno());
	}

	@Column(name = "PATIENT_MRN", length = 20)
	public String getPatientMrn() {
		return this.patientMrn;
	}

	public void setPatientMrn(String patientMrn) {
		this.patientMrn = patientMrn;
	}

	@Column(name = "PATIENT_NAME", length = 130)
	public String getPatientName() {
		return this.patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	@Column(name = "ID_TYPE", length = 20)
	public String getIdType() {
		return this.idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	@Column(name = "IC_NO", length = 20)
	public String getIcNo() {
		return this.icNo;
	}

	public void setIcNo(String icNo) {
		this.icNo = icNo;
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

	@Column(name = "dose")
	public Double getDose() {
		return dose;
	}

	public void setDose(Double dose) {
		this.dose = dose;
	}

	@Column(name = "uom_desc")
	public String getUomDesc() {
		return uomDesc;
	}

	public void setUomDesc(String uomDesc) {
		this.uomDesc = uomDesc;
	}

	@Column(name = "freq_desc")
	public String getFreqDesc() {
		return freqDesc;
	}

	public void setFreqDesc(String freqDesc) {
		this.freqDesc = freqDesc;
	}

	@Column(name = "duration")
	public Double getDuration() {
		return duration;
	}

	public void setDuration(Double duration) {
		this.duration = duration;
	}

	@Column(name = "duration_unit")
	public String getDurationUnit() {
		return durationUnit;
	}

	public void setDurationUnit(String durationUnit) {
		this.durationUnit = durationUnit;
	}

	@Column(name = "diagnosis")
	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	
	@Column(name = "summary_pat_ind_hist")
	public String getSummaryPatIndHist() {
		return summaryPatIndHist;
	}

	public void setSummaryPatIndHist(String summaryPatIndHist) {
		this.summaryPatIndHist = summaryPatIndHist;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "specialDrugPatient")
	@JsonManagedReference
	public Set<SpecialDrugTreatmentV1823> getSpecialDrugTreatments() {
		return specialDrugTreatments;
	}

	public void setSpecialDrugTreatments(Set<SpecialDrugTreatmentV1823> specialDrugTreatments) {
		this.specialDrugTreatments = specialDrugTreatments;
	}

	@Column(name = "remarks")
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	/*@JsonIgnore
	@Column(name = "dosage_Freq")
	public String getDosageFreq() {
		return dosageFreq;
	}

	public void setDosageFreq(String dosageFreq) {
		this.dosageFreq = dosageFreq;
	}
	
	@JsonIgnore
	@Column(name = "durationwithUnit")
	public String getDurationwithUnit() {
		return durationwithUnit;
	}

	public void setDurationwithUnit(String durationwithUnit) {
		this.durationwithUnit = durationwithUnit;
	}*/

}
