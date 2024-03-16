package my.com.cmg.iwp.backend.model.integration.tdm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;


/**
 * The persistent class for the ph_tdm_order_int database table.
 * 
 */
@Entity
@Table(name="t_tdm_order_int")
@XmlRootElement(name = "TdmOrderInt")
@JsonIgnoreProperties(ignoreUnknown=true)
public class TdmOrderInt implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long tdmOrderIntSeqno;
	private String city;
	private String country;
	private Long createdBy;
	private Date createdDate;
	private String dashboardInd;
	private String fromFacilityCode;
	private String fromPtjCode;
	private BigDecimal height;
	private String homeContactNo;
	private String mobileContactNo;
	private String nationality;
	private String officeContactNo;
	private String patientAddress1;
	private String patientAddress2;
	private String patientAddress3;
	private Date patientDob;
	private String patientGender;
	private String patientId;
	private String patientIdType;
	private String patientMrn;
	private String patientName;
	private String religion;
	private Long sampleSentBy;
	private Date sampleSentDate;
	private String sampleType;
	private String sendFlag;
	private String state;
	private String tdmDrug;
	private String tdmOrderNo;
	private String toFacilityCode;
	private String toPtjCode;
	private Long updatedBy;
	private Date updatedDate;
	private Date visitDate;
	private String visitNumber;
	private BigDecimal weight;
	private String extTdmNo;
	private String indicationRequest;
	private String outsourceStatus;
	private Set<SamplingDetailsInt> samplingDetailsInts;
	
	private String refPatientMrn;

    public TdmOrderInt() {
    }


	@Id
	@SequenceGenerator(name="T_TDM_ORDER_INT_TDMORDERINTSEQNO_GENERATOR", sequenceName="T_TDM_ORDER_INT_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="T_TDM_ORDER_INT_TDMORDERINTSEQNO_GENERATOR")
	@Column(name="tdm_order_int_seqno")
	public Long getTdmOrderIntSeqno() {
		return this.tdmOrderIntSeqno;
	}

	public void setTdmOrderIntSeqno(Long tdmOrderIntSeqno) {
		this.tdmOrderIntSeqno = tdmOrderIntSeqno;
	}


	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}


	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}


	@Column(name="created_by")
	public Long getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_date")
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}


	@Column(name="dashboard_ind")
	public String getDashboardInd() {
		return this.dashboardInd;
	}

	public void setDashboardInd(String dashboardInd) {
		this.dashboardInd = dashboardInd;
	}


	@Column(name="from_facility_code")
	public String getFromFacilityCode() {
		return this.fromFacilityCode;
	}

	public void setFromFacilityCode(String fromFacilityCode) {
		this.fromFacilityCode = fromFacilityCode;
	}


	@Column(name="from_ptj_code")
	public String getFromPtjCode() {
		return this.fromPtjCode;
	}

	public void setFromPtjCode(String fromPtjCode) {
		this.fromPtjCode = fromPtjCode;
	}


	public BigDecimal getHeight() {
		return this.height;
	}

	public void setHeight(BigDecimal height) {
		this.height = height;
	}


	@Column(name="home_contact_no")
	public String getHomeContactNo() {
		return this.homeContactNo;
	}

	public void setHomeContactNo(String homeContactNo) {
		this.homeContactNo = homeContactNo;
	}


	@Column(name="mobile_contact_no")
	public String getMobileContactNo() {
		return this.mobileContactNo;
	}

	public void setMobileContactNo(String mobileContactNo) {
		this.mobileContactNo = mobileContactNo;
	}


	public String getNationality() {
		return this.nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	@Column(name="office_contact_no")
	public String getOfficeContactNo() {
		return this.officeContactNo;
	}

	public void setOfficeContactNo(String officeContactNo) {
		this.officeContactNo = officeContactNo;
	}


	@Column(name="patient_address1")
	public String getPatientAddress1() {
		return this.patientAddress1;
	}

	public void setPatientAddress1(String patientAddress1) {
		this.patientAddress1 = patientAddress1;
	}


	@Column(name="patient_address2")
	public String getPatientAddress2() {
		return this.patientAddress2;
	}

	public void setPatientAddress2(String patientAddress2) {
		this.patientAddress2 = patientAddress2;
	}


	@Column(name="patient_address3")
	public String getPatientAddress3() {
		return this.patientAddress3;
	}

	public void setPatientAddress3(String patientAddress3) {
		this.patientAddress3 = patientAddress3;
	}


    @Temporal( TemporalType.DATE)
	@Column(name="patient_dob")
	public Date getPatientDob() {
		return this.patientDob;
	}

	public void setPatientDob(Date patientDob) {
		this.patientDob = patientDob;
	}


	@Column(name="patient_gender")
	public String getPatientGender() {
		return this.patientGender;
	}

	public void setPatientGender(String patientGender) {
		this.patientGender = patientGender;
	}


	@Column(name="patient_id")
	public String getPatientId() {
		return this.patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}


	@Column(name="patient_id_type")
	public String getPatientIdType() {
		return this.patientIdType;
	}

	public void setPatientIdType(String patientIdType) {
		this.patientIdType = patientIdType;
	}


	@Column(name="patient_mrn")
	public String getPatientMrn() {
		return this.patientMrn;
	}

	public void setPatientMrn(String patientMrn) {
		this.patientMrn = patientMrn;
	}


	@Column(name="patient_name")
	public String getPatientName() {
		return this.patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}


	public String getReligion() {
		return this.religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}


	@Column(name="sample_sent_by")
	public Long getSampleSentBy() {
		return this.sampleSentBy;
	}

	public void setSampleSentBy(Long sampleSentBy) {
		this.sampleSentBy = sampleSentBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="sample_sent_date")
	public Date getSampleSentDate() {
		return this.sampleSentDate;
	}

	public void setSampleSentDate(Date sampleSentDate) {
		this.sampleSentDate = sampleSentDate;
	}


	@Column(name="sample_type")
	public String getSampleType() {
		return this.sampleType;
	}

	public void setSampleType(String sampleType) {
		this.sampleType = sampleType;
	}


	@Column(name="send_flag")
	public String getSendFlag() {
		return this.sendFlag;
	}

	public void setSendFlag(String sendFlag) {
		this.sendFlag = sendFlag;
	}


	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}


	@Column(name="tdm_drug")
	public String getTdmDrug() {
		return this.tdmDrug;
	}

	public void setTdmDrug(String tdmDrug) {
		this.tdmDrug = tdmDrug;
	}


	@Column(name="tdm_order_no")
	public String getTdmOrderNo() {
		return this.tdmOrderNo;
	}

	public void setTdmOrderNo(String tdmOrderNo) {
		this.tdmOrderNo = tdmOrderNo;
	}


	@Column(name="to_facility_code")
	public String getToFacilityCode() {
		return this.toFacilityCode;
	}

	public void setToFacilityCode(String toFacilityCode) {
		this.toFacilityCode = toFacilityCode;
	}


	@Column(name="to_ptj_code")
	public String getToPtjCode() {
		return this.toPtjCode;
	}

	public void setToPtjCode(String toPtjCode) {
		this.toPtjCode = toPtjCode;
	}


	@Column(name="updated_by")
	public Long getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_date")
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}


    @Temporal( TemporalType.DATE)
	@Column(name="visit_date")
	public Date getVisitDate() {
		return this.visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}


	@Column(name="visit_number")
	public String getVisitNumber() {
		return this.visitNumber;
	}

	public void setVisitNumber(String visitNumber) {
		this.visitNumber = visitNumber;
	}


	public BigDecimal getWeight() {
		return this.weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}


	//bi-directional many-to-one association to SamplingDetailsInt
	@OneToMany(mappedBy="tdmOrderInt")
	@JsonManagedReference
	public Set<SamplingDetailsInt> getSamplingDetailsInts() {
		return this.samplingDetailsInts;
	}

	public void setSamplingDetailsInts(Set<SamplingDetailsInt> samplingDetailsInts) {
		this.samplingDetailsInts = samplingDetailsInts;
	}


	@Column(name="ext_tdm_no")
	public String getExtTdmNo() {
		return extTdmNo;
	}


	public void setExtTdmNo(String extTdmNo) {
		this.extTdmNo = extTdmNo;
	}


	@Column(name="indication_request")
	public String getIndicationRequest() {
		return indicationRequest;
	}


	public void setIndicationRequest(String indicationRequest) {
		this.indicationRequest = indicationRequest;
	}
	
	@Column(name = "ref_patient_mrn")
	public String getRefPatientMrn() {
		return refPatientMrn;
	}

	public void setRefPatientMrn(String refPatientMrn) {
		this.refPatientMrn = refPatientMrn;
	}
	
	@Column(name = "outsource_status")
	public String getOutsourceStatus() {
		return outsourceStatus;
	}

	public void setOutsourceStatus(String outsourceStatus) {
		this.outsourceStatus = outsourceStatus;
	}
}