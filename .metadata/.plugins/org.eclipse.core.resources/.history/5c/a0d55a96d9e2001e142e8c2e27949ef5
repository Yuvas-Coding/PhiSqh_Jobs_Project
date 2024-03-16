package my.com.cmg.iwp.backend.model.integration.indent;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
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

@Entity
@Table(name = "t_spubpatientinfo_int")
@XmlRootElement(name = "SpubPatientInfoInt")
@JsonIgnoreProperties(ignoreUnknown=true)
public class SpubPatientInfoInt implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long spubPatientSeqno;
	private String spubNo;
	private String referredFrom;
	private String patientIdno;
	private String fullName;
	//private Drug drug;
	private String drugCode;
	private long orderQty;
	private long dispensedQty;
	private long balQty;
	private long indentQty;
	private IndentDtlsInt indentDtlsInt;
	private Long updatedBy;
	private Date updatedDate;
	private String parameter1;
	private String parameter2;
	private BigDecimal parameter3;
	private BigDecimal parameter4;
	private Date parameter5;
	private Long createdBy;
	private Date createdDate;
	
	@Id
	@Column(name = "spubPatient_int_seq", unique = true, nullable = false)
	@SequenceGenerator(name = "t_spubPatient_int_seq", sequenceName = "t_spubPatient_int_seq", allocationSize = 1)
	@GeneratedValue(generator = "t_spubPatient_int_seq")
	public Long getSpubPatientSeqno() {
		return spubPatientSeqno;
	}
	public void setSpubPatientSeqno(Long spubPatientSeqno) {
		this.spubPatientSeqno = spubPatientSeqno;
	}
	
	@Column(name = "spub_no", length = 40)
	public String getSpubNo() {
		return spubNo;
	}
	
	public void setSpubNo(String spubNo) {
		this.spubNo = spubNo;
	}
	
	@Column(name = "referred_from", length = 50)
	public String getReferredFrom() {
		return referredFrom;
	}
	public void setReferredFrom(String referredFrom) {
		this.referredFrom = referredFrom;
	}
	
	@Column(name = "patient_idno", length = 20)
	public String getPatientIdno() {
		return patientIdno;
	}
	public void setPatientIdno(String patientIdno) {
		this.patientIdno = patientIdno;
	}
	
	@Column(name = "full_name", length = 130)
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "drug_seqno", insertable = true, updatable = true)
	public Drug getDrug() {
		return drug;
	}
	public void setDrug(Drug drug) {
		this.drug = drug;
	}*/
	
	@Column(name = "drug_code",length = 20)
	public String getDrugCode() {
		return drugCode;
	}
	public void setDrugCode(String drugCode) {
		this.drugCode = drugCode;
	}
	
	@Column(name = "order_qty")
	public long getOrderQty() {
		return orderQty;
	}
	public void setOrderQty(long orderQty) {
		this.orderQty = orderQty;
	}
	
	@Column(name = "dispensed_qty")
	public long getDispensedQty() {
		return dispensedQty;
	}
	public void setDispensedQty(long dispensedQty) {
		this.dispensedQty = dispensedQty;
	}
	
	@Column(name = "balance_qty")
	public long getBalQty() {
		return balQty;
	}
	public void setBalQty(long balQty) {
		this.balQty = balQty;
	}
	
	@Column(name = "indent_qty")
	public long getIndentQty() {
		return indentQty;
	}
	public void setIndentQty(long indentQty) {
		this.indentQty = indentQty;
	}
	
	@ManyToOne
	@JoinColumn(name = "dtls_seqno", nullable = false)
	@JsonBackReference
	public IndentDtlsInt getIndentDtlsInt() {
		return indentDtlsInt;
	}
	public void setIndentDtlsInt(IndentDtlsInt indentDtlsInt) {
		this.indentDtlsInt = indentDtlsInt;
	}
	
	@Column(name = "updated_by")
	public Long getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	
	@Column(length = 100)
	public String getParameter1() {
		return this.parameter1;
	}

	public void setParameter1(String parameter1) {
		this.parameter1 = parameter1;
	}

	@Column(length = 100)
	public String getParameter2() {
		return this.parameter2;
	}

	public void setParameter2(String parameter2) {
		this.parameter2 = parameter2;
	}

	@Column(precision = 8, scale = 4)
	public BigDecimal getParameter3() {
		return this.parameter3;
	}

	public void setParameter3(BigDecimal parameter3) {
		this.parameter3 = parameter3;
	}

	@Column(precision = 8, scale = 4)
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

	
	@Column(name = "created_by")
	public Long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date")
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_date")
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	
	
	
}
