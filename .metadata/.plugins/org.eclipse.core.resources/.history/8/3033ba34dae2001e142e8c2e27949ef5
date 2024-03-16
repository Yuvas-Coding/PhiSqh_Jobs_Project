package my.com.cmg.iwp.backend.model.integration.tdm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
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
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * The persistent class for the ph_sampling_details_int database table.
 * 
 */
@Entity
@Table(name="t_sampling_details_int")
@XmlRootElement(name = "SamplingDetailsInt")
@JsonIgnoreProperties(ignoreUnknown=true)
public class SamplingDetailsInt implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long samplingIntSeqno;
	private String acceptedBy;
	private Timestamp acceptedDateTime;
	private Long acknolwedgeBy;
	private Timestamp acknowledgeDate;
	private Timestamp actualAdminTime;
	private String afterBefore;
	private String collectedBy;
	private Timestamp collectionDateTime;
	private Long createdBy;
	private Timestamp createdDate;
	private String defaultTime;
	private String defaultTimeType;
	private Timestamp drugAdministrationDateTime;
	private String intervalDesc;
	private String labOrder;
	private Long labTestOrder;
	private String parameter1;
	private String parameter2;
	private BigDecimal parameter3;
	private BigDecimal parameter4;
	private Date parameter5;
	private String processType;
	private String receiveFlag;
	private String rejectFlag;
	private Long rejectedBy;
	private Timestamp rejectedDateTime;
	private String rejectedcode;
	private String remarks;
	//private BigDecimal result;
	private String result;
	private Long resultBy;
	private Timestamp resultDate;
	private String sampleId;
	private Timestamp samplingDateTime;
	private String samplingType;
	private Timestamp sendDateTime;
	private String sentBy;
	private String sentThrough;
	private String status;
	private BigDecimal tdmInterval;
	private String therapeuticRange;
	private String uomAbbr;
	private Long updatedBy;
	private Timestamp updatedDate;
	private Long verifiedBy;
	private Timestamp verifiedDate;
	private Character toxic; 
	private TdmOrderInt tdmOrderInt;

    public SamplingDetailsInt() {
    }


	@Id
	@SequenceGenerator(name="T_SAMPLING_DETAILS_INT_SAMPLINGINTSEQNO_GENERATOR", sequenceName="T_SAMPLING_DETAILS_INT_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="T_SAMPLING_DETAILS_INT_SAMPLINGINTSEQNO_GENERATOR")
	@Column(name="sampling_int_seqno")
	public Long getSamplingIntSeqno() {
		return this.samplingIntSeqno;
	}

	public void setSamplingIntSeqno(Long samplingIntSeqno) {
		this.samplingIntSeqno = samplingIntSeqno;
	}


	@Column(name="accepted_by")
	public String getAcceptedBy() {
		return this.acceptedBy;
	}

	public void setAcceptedBy(String acceptedBy) {
		this.acceptedBy = acceptedBy;
	}


	@Column(name="accepted_date_time")
	public Timestamp getAcceptedDateTime() {
		return this.acceptedDateTime;
	}

	public void setAcceptedDateTime(Timestamp acceptedDateTime) {
		this.acceptedDateTime = acceptedDateTime;
	}


	@Column(name="acknolwedge_by")
	public Long getAcknolwedgeBy() {
		return this.acknolwedgeBy;
	}

	public void setAcknolwedgeBy(Long acknolwedgeBy) {
		this.acknolwedgeBy = acknolwedgeBy;
	}


	@Column(name="acknowledge_date")
	public Timestamp getAcknowledgeDate() {
		return this.acknowledgeDate;
	}

	public void setAcknowledgeDate(Timestamp acknowledgeDate) {
		this.acknowledgeDate = acknowledgeDate;
	}


	@Column(name="actual_admin_time")
	public Timestamp getActualAdminTime() {
		return this.actualAdminTime;
	}

	public void setActualAdminTime(Timestamp actualAdminTime) {
		this.actualAdminTime = actualAdminTime;
	}


	@Column(name="after_before")
	public String getAfterBefore() {
		return this.afterBefore;
	}

	public void setAfterBefore(String afterBefore) {
		this.afterBefore = afterBefore;
	}


	@Column(name="collected_by")
	public String getCollectedBy() {
		return this.collectedBy;
	}

	public void setCollectedBy(String collectedBy) {
		this.collectedBy = collectedBy;
	}


	@Column(name="collection_date_time")
	public Timestamp getCollectionDateTime() {
		return this.collectionDateTime;
	}

	public void setCollectionDateTime(Timestamp collectionDateTime) {
		this.collectionDateTime = collectionDateTime;
	}


	@Column(name="created_by")
	public Long getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}


	@Column(name="created_date")
	public Timestamp getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}


	@Column(name="default_time")
	public String getDefaultTime() {
		return this.defaultTime;
	}

	public void setDefaultTime(String defaultTime) {
		this.defaultTime = defaultTime;
	}


	@Column(name="default_time_type")
	public String getDefaultTimeType() {
		return this.defaultTimeType;
	}

	public void setDefaultTimeType(String defaultTimeType) {
		this.defaultTimeType = defaultTimeType;
	}


	@Column(name="drug_administration_date_time")
	public Timestamp getDrugAdministrationDateTime() {
		return this.drugAdministrationDateTime;
	}

	public void setDrugAdministrationDateTime(Timestamp drugAdministrationDateTime) {
		this.drugAdministrationDateTime = drugAdministrationDateTime;
	}


	@Column(name="interval_desc")
	public String getIntervalDesc() {
		return this.intervalDesc;
	}

	public void setIntervalDesc(String intervalDesc) {
		this.intervalDesc = intervalDesc;
	}


	@Column(name="lab_order")
	public String getLabOrder() {
		return this.labOrder;
	}

	public void setLabOrder(String labOrder) {
		this.labOrder = labOrder;
	}


	@Column(name="lab_test_order")
	public Long getLabTestOrder() {
		return this.labTestOrder;
	}

	public void setLabTestOrder(Long labTestOrder) {
		this.labTestOrder = labTestOrder;
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


	@Column(name="process_type")
	public String getProcessType() {
		return this.processType;
	}

	public void setProcessType(String processType) {
		this.processType = processType;
	}


	@Column(name="receive_flag")
	public String getReceiveFlag() {
		return this.receiveFlag;
	}

	public void setReceiveFlag(String receiveFlag) {
		this.receiveFlag = receiveFlag;
	}


	@Column(name="reject_flag")
	public String getRejectFlag() {
		return this.rejectFlag;
	}

	public void setRejectFlag(String rejectFlag) {
		this.rejectFlag = rejectFlag;
	}


	@Column(name="rejected_by")
	public Long getRejectedBy() {
		return this.rejectedBy;
	}

	public void setRejectedBy(Long rejectedBy) {
		this.rejectedBy = rejectedBy;
	}


	@Column(name="rejected_date_time")
	public Timestamp getRejectedDateTime() {
		return this.rejectedDateTime;
	}

	public void setRejectedDateTime(Timestamp rejectedDateTime) {
		this.rejectedDateTime = rejectedDateTime;
	}


	public String getRejectedcode() {
		return this.rejectedcode;
	}

	public void setRejectedcode(String rejectedcode) {
		this.rejectedcode = rejectedcode;
	}


	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getResult() {
		return result;
	}


	public void setResult(String result) {
		this.result = result;
	}


	@Column(name="result_by")
	public Long getResultBy() {
		return this.resultBy;
	}

	public void setResultBy(Long resultBy) {
		this.resultBy = resultBy;
	}


	@Column(name="result_date")
	public Timestamp getResultDate() {
		return this.resultDate;
	}

	public void setResultDate(Timestamp resultDate) {
		this.resultDate = resultDate;
	}


	@Column(name="sample_id")
	public String getSampleId() {
		return this.sampleId;
	}

	public void setSampleId(String sampleId) {
		this.sampleId = sampleId;
	}


	@Column(name="sampling_date_time")
	public Timestamp getSamplingDateTime() {
		return this.samplingDateTime;
	}

	public void setSamplingDateTime(Timestamp samplingDateTime) {
		this.samplingDateTime = samplingDateTime;
	}


	@Column(name="sampling_type")
	public String getSamplingType() {
		return this.samplingType;
	}

	public void setSamplingType(String samplingType) {
		this.samplingType = samplingType;
	}


	@Column(name="send_date_time")
	public Timestamp getSendDateTime() {
		return this.sendDateTime;
	}

	public void setSendDateTime(Timestamp sendDateTime) {
		this.sendDateTime = sendDateTime;
	}


	@Column(name="sent_by")
	public String getSentBy() {
		return this.sentBy;
	}

	public void setSentBy(String sentBy) {
		this.sentBy = sentBy;
	}


	@Column(name="sent_through")
	public String getSentThrough() {
		return this.sentThrough;
	}

	public void setSentThrough(String sentThrough) {
		this.sentThrough = sentThrough;
	}


	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	@Column(name="tdm_interval")
	public BigDecimal getTdmInterval() {
		return this.tdmInterval;
	}

	public void setTdmInterval(BigDecimal tdmInterval) {
		this.tdmInterval = tdmInterval;
	}


	@Column(name="therapeutic_range")
	public String getTherapeuticRange() {
		return this.therapeuticRange;
	}

	public void setTherapeuticRange(String therapeuticRange) {
		this.therapeuticRange = therapeuticRange;
	}


	@Column(name="uom_abbr")
	public String getUomAbbr() {
		return this.uomAbbr;
	}

	public void setUomAbbr(String uomAbbr) {
		this.uomAbbr = uomAbbr;
	}


	@Column(name="updated_by")
	public Long getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}


	@Column(name="updated_date")
	public Timestamp getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}


	@Column(name="verified_by")
	public Long getVerifiedBy() {
		return this.verifiedBy;
	}

	public void setVerifiedBy(Long verifiedBy) {
		this.verifiedBy = verifiedBy;
	}


	@Column(name="verified_date")
	public Timestamp getVerifiedDate() {
		return this.verifiedDate;
	}

	public void setVerifiedDate(Timestamp verifiedDate) {
		this.verifiedDate = verifiedDate;
	}


	//bi-directional many-to-one association to TdmOrderInt
	@ManyToOne
	@JoinColumn(name="tdm_order_int_seqno")
	@JsonBackReference
	public TdmOrderInt getTdmOrderInt() {
		return this.tdmOrderInt;
	}

	public void setTdmOrderInt(TdmOrderInt tdmOrderInt) {
		this.tdmOrderInt = tdmOrderInt;
	}

	@Column(name="toxic")
	public Character getToxic() {
		return toxic;
	}


	public void setToxic(Character toxic) {
		this.toxic = toxic;
	}
	
}