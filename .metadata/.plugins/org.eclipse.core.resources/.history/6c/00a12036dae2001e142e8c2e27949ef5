package my.com.cmg.iwp.backend.model.integration.indent;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import my.com.cmg.iwp.webui.constant.RefCodeConstant;

/**
 * The persistent class for the ph_indent_dtls_int database table.
 * 
 */
@Entity
@Table(name = "t_indent_dtls_int")
@XmlRootElement(name = "IndentDtlsInt")
@JsonIgnoreProperties(ignoreUnknown=true)
public class IndentDtlsInt implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long dtlsSeqno;
	private String approvalRemarks;
	private Long approvedQty;
	private BigDecimal avgUnitPrice;
	private long avgUsage;
	private Long createdBy;
	private Date createdDate;
	private String drugCode;
	private Long goodStk;
	private Long indentQty;
	private Date indentRoa;
	private String issueFlag;
	private Long nearExpQty;
	private String nondrugCode;
	private String parameter1;
	private String parameter2;
	private BigDecimal parameter3;
	private BigDecimal parameter4;
	private Date parameter5;
	private Long pendingQty;
	private String skuCode;
	private Long specialistSeqno;
	private Long suppliedQty;
	private Long updatedBy;
	private Date updatedDate;
	private String urgent;
	private Long preferedItem;
	private IndentHdrsInt indentHdrsInt;
	private String drugStatus;
	private Character reject_Status_Flag = RefCodeConstant.BOOLEAN_FALSE;
	//private List<SpubPatientInfoInt> spubPatientInfoInts = new ArrayList<SpubPatientInfoInt>();
	private Set<SpubPatientInfoInt> spubPatientInfoInts = new HashSet<SpubPatientInfoInt>(0);
	
	public IndentDtlsInt() {
	}

	@Id
	@SequenceGenerator(name = "PH_INDENT_DTLS_INT_DTLSSEQNO_GENERATOR", sequenceName = "t_indent_dtls_int_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PH_INDENT_DTLS_INT_DTLSSEQNO_GENERATOR")
	@Column(name = "dtls_seqno", unique = true, nullable = false)
	public Long getDtlsSeqno() {
		return this.dtlsSeqno;
	}

	public void setDtlsSeqno(Long dtlsSeqno) {
		this.dtlsSeqno = dtlsSeqno;
	}

	@Column(name = "approval_remarks", length = 50)
	public String getApprovalRemarks() {
		return this.approvalRemarks;
	}

	public void setApprovalRemarks(String approvalRemarks) {
		this.approvalRemarks = approvalRemarks;
	}

	@Column(name = "approved_qty")
	public Long getApprovedQty() {
		return this.approvedQty;
	}

	public void setApprovedQty(Long approvedQty) {
		this.approvedQty = approvedQty;
	}

	@Column(name = "avg_unit_price", nullable = false, precision = 15, scale = 3)
	public BigDecimal getAvgUnitPrice() {
		return this.avgUnitPrice;
	}

	public void setAvgUnitPrice(BigDecimal avgUnitPrice) {
		this.avgUnitPrice = avgUnitPrice;
	}

	@Column(name = "avg_usage", nullable = false)
	public long getAvgUsage() {
		return this.avgUsage;
	}

	public void setAvgUsage(long avgUsage) {
		this.avgUsage = avgUsage;
	}

	@Column(name = "created_by")
	public Long getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date")
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "drug_code", length = 20)
	public String getDrugCode() {
		return this.drugCode;
	}

	public void setDrugCode(String drugCode) {
		this.drugCode = drugCode;
	}

	@Column(name = "good_stk", nullable = false)
	public Long getGoodStk() {
		return this.goodStk;
	}

	public void setGoodStk(Long goodStk) {
		this.goodStk = goodStk;
	}

	@Column(name = "indent_qty", nullable = false)
	public Long getIndentQty() {
		return this.indentQty;
	}

	public void setIndentQty(Long indentQty) {
		this.indentQty = indentQty;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "indent_roa")
	public Date getIndentRoa() {
		return this.indentRoa;
	}

	public void setIndentRoa(Date indentRoa) {
		this.indentRoa = indentRoa;
	}

	@Column(name = "issue_flag")
	public String getIssueFlag() {
		return this.issueFlag;
	}

	public void setIssueFlag(String issueFlag) {
		this.issueFlag = issueFlag;
	}

	@Column(name = "near_exp_qty")
	public Long getNearExpQty() {
		return this.nearExpQty;
	}

	public void setNearExpQty(Long nearExpQty) {
		this.nearExpQty = nearExpQty;
	}

	@Column(name = "nondrug_code")
	public String getNondrugCode() {
		return this.nondrugCode;
	}

	public void setNondrugCode(String nondrugCode) {
		this.nondrugCode = nondrugCode;
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

	@Column(name = "pending_qty", nullable = false)
	public Long getPendingQty() {
		return this.pendingQty;
	}

	public void setPendingQty(Long pendingQty) {
		this.pendingQty = pendingQty;
	}

	@Column(name = "sku_code", nullable = false, length = 10)
	public String getSkuCode() {
		return this.skuCode;
	}

	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}

	@Column(name = "specialist_seqno")
	public Long getSpecialistSeqno() {
		return this.specialistSeqno;
	}

	public void setSpecialistSeqno(Long specialistSeqno) {
		this.specialistSeqno = specialistSeqno;
	}

	@Column(name = "supplied_qty", nullable = false)
	public Long getSuppliedQty() {
		return this.suppliedQty;
	}

	public void setSuppliedQty(Long suppliedQty) {
		this.suppliedQty = suppliedQty;
	}

	@Column(name = "updated_by")
	public Long getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_date")
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getUrgent() {
		return this.urgent;
	}

	public void setUrgent(String urgent) {
		this.urgent = urgent;
	}

	// bi-directional many-to-one association to IndentHdrsInt
	@ManyToOne
	@JoinColumn(name = "indent_hdrs_seqno", nullable = false)
	@JsonBackReference
	public IndentHdrsInt getIndentHdrsInt() {
		return this.indentHdrsInt;
	}

	public void setIndentHdrsInt(IndentHdrsInt indentHdrsInt) {
		this.indentHdrsInt = indentHdrsInt;
	}

	@Column(name = "item_seqno")
	public Long getPreferedItem() {
		return preferedItem;
	}

	public void setPreferedItem(Long preferedItem) {
		this.preferedItem = preferedItem;
	}

	@Column(name ="drug_status")
	public String getDrugStatus() {
		return drugStatus;
	}

	public void setDrugStatus(String drugStatus) {
		this.drugStatus = drugStatus;
	}
	
	@Column(name ="reject_flag")
	public Character getReject_Status_Flag() {
		return reject_Status_Flag;
	}

	public void setReject_Status_Flag(Character reject_Status_Flag) {
		this.reject_Status_Flag = reject_Status_Flag;
	}

	
	@OneToMany(mappedBy = "indentDtlsInt",cascade=CascadeType.ALL)
	@XmlElement
	@JsonManagedReference
	public Set<SpubPatientInfoInt> getSpubPatientInfoInts() {
		return spubPatientInfoInts;
	}

	public void setSpubPatientInfoInts(Set<SpubPatientInfoInt> spubPatientInfoInts) {
		this.spubPatientInfoInts = spubPatientInfoInts;
	}
	/*public List<SpubPatientInfoInt> getSpubPatientInfoInts() {
		return spubPatientInfoInts;
	}*/
	

	
}
