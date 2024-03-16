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
 * The persistent class for the ph_patient_diagnosis_int database table.
 * 
 */
@Entity
@Table(name="t_patient_diagnosis_int")
@JsonIgnoreProperties(ignoreUnknown=true)
public class PatientDiagnosisInt implements Serializable {
	private static final long serialVersionUID = 1L;	
	private Long pdIntSeqno;
	private String codingMethod;
	private Long createdBy;
	private Date createdDate;
	private String description;
	private String diagnosisCode;
	private Date diagnosisDate;
	private String diagnosisType;
	private Long orderIntSeqno;
	private String status;
	private Long updatedBy;
	private Date updatedDate;
	private Integer version;

	private OutsourceOrderInt outsourceOrderInt;

	public PatientDiagnosisInt() {
	}
	
	@Id
	@SequenceGenerator(name="PH_PATIENT_DIAGNOSIS_INT_PDINTSEQNO_GENERATOR", sequenceName="t_patient_diagnosis_int_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PH_PATIENT_DIAGNOSIS_INT_PDINTSEQNO_GENERATOR")
	@Column(name="pd_int_seqno")
	@JsonIgnore
	public Long getPdIntSeqno() {
		return this.pdIntSeqno;
	}

	public void setPdIntSeqno(Long pdIntSeqno) {
		this.pdIntSeqno = pdIntSeqno;
	}
	
	@Column(name="coding_method")
	public String getCodingMethod() {
		return this.codingMethod;
	}

	public void setCodingMethod(String codingMethod) {
		this.codingMethod = codingMethod;
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

	@Column(name="description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	@Column(name="diagnosis_code")
	public String getDiagnosisCode() {
		return this.diagnosisCode;
	}

	public void setDiagnosisCode(String diagnosisCode) {
		this.diagnosisCode = diagnosisCode;
	}


    @Temporal( TemporalType.DATE)
	@Column(name="diagnosis_date")
	public Date getDiagnosisDate() {
		return this.diagnosisDate;
	}

	public void setDiagnosisDate(Date diagnosisDate) {
		this.diagnosisDate = diagnosisDate;
	}


	@Column(name="diagnosis_type")
	public String getDiagnosisType() {
		return this.diagnosisType;
	}

	public void setDiagnosisType(String diagnosisType) {
		this.diagnosisType = diagnosisType;
	}


	@Column(name="order_int_seqno", insertable = false, updatable = false)
	public Long getOrderIntSeqno() {
		return this.orderIntSeqno;
	}

	public void setOrderIntSeqno(Long orderIntSeqno) {
		this.orderIntSeqno = orderIntSeqno;
	}

	@Column(name="status")
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
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
	@JsonBackReference("PatientDiagnosisOutsourceOrderInt")
	public OutsourceOrderInt getOutsourceOrderInt() {
		return outsourceOrderInt;
	}

	public void setOutsourceOrderInt(OutsourceOrderInt outsourceOrderInt) {
		this.outsourceOrderInt = outsourceOrderInt;
	}

}