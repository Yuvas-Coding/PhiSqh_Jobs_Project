package my.com.cmg.iwp.backend.model.integration.issue;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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

/**
 * The persistent class for the ph_issue_dtls_int database table.
 * 
 */
@Entity
@Table(name = "t_issue_dtls_int")
@XmlRootElement(name = "IssueDtlsInt")
@JsonIgnoreProperties(ignoreUnknown=true)
public class IssueDtlsInt implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long imdIntSeqno;
	private Long approvedQty;
	private Long indentQty;
	private BigDecimal avgUnitPrice;
//	private String brandCode;
	private Long createdBy;
	private Date createdDate;
	private String drugCode;
	private String drugStatus;
	private Long goodStkQty;
	private Long issueQty;
	private String nonDrugCode;
	private String noteSent;
	private String parameter1;
	private String parameter2;
	private BigDecimal parameter3;
	private BigDecimal parameter4;
	private Date parameter5;
	private Long pendingQty;
	private Long requestQty;
	private String sku;
	private Long updatedBy;
	private Date updatedDate;
	private Set<IssueBatchesInt> issueBatchesInts = new HashSet<IssueBatchesInt>();
	private IssueHdrsInt issueHdrsInt;

	public IssueDtlsInt() {
	}

	@Id
	@SequenceGenerator(name = "PH_ISSUE_DTLS_INT_IMDINTSEQNO_GENERATOR", sequenceName = "t_issue_dtls_int_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PH_ISSUE_DTLS_INT_IMDINTSEQNO_GENERATOR")
	@Column(name = "imd_int_seqno")
	public Long getImdIntSeqno() {
		return this.imdIntSeqno;
	}

	public void setImdIntSeqno(Long imdIntSeqno) {
		this.imdIntSeqno = imdIntSeqno;
	}

	@Column(name = "approved_qty")
	public Long getApprovedQty() {
		return this.approvedQty;
	}

	public void setApprovedQty(Long approvedQty) {
		this.approvedQty = approvedQty;
	}

	@Column(name = "indent_qty")
	public Long getIndentQty() {
	    return indentQty;
	}

	public void setIndentQty(Long indentQty) {
	    this.indentQty = indentQty;
	}

	@Column(name = "avg_unit_price")
	public BigDecimal getAvgUnitPrice() {
		return this.avgUnitPrice;
	}

	public void setAvgUnitPrice(BigDecimal avgUnitPrice) {
		this.avgUnitPrice = avgUnitPrice;
	}

	/*@Column(name = "brand_code")
	public String getBrandCode() {
		return this.brandCode;
	}

	public void setBrandCode(String brandCode) {
		this.brandCode = brandCode;
	}*/

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

	@Column(name = "drug_code")
	public String getDrugCode() {
		return this.drugCode;
	}

	public void setDrugCode(String drugCode) {
		this.drugCode = drugCode;
	}

	@Column(name = "drug_status")
	public String getDrugStatus() {
		return this.drugStatus;
	}

	public void setDrugStatus(String drugStatus) {
		this.drugStatus = drugStatus;
	}

	@Column(name = "good_stk_qty")
	public Long getGoodStkQty() {
		return this.goodStkQty;
	}

	public void setGoodStkQty(Long goodStkQty) {
		this.goodStkQty = goodStkQty;
	}

	@Column(name = "issue_qty")
	public Long getIssueQty() {
		return this.issueQty;
	}

	public void setIssueQty(Long issueQty) {
		this.issueQty = issueQty;
	}

	@Column(name = "non_drug_code")
	public String getNonDrugCode() {
		return this.nonDrugCode;
	}

	public void setNonDrugCode(String nonDrugCode) {
		this.nonDrugCode = nonDrugCode;
	}

	@Column(name = "note_sent")
	public String getNoteSent() {
		return this.noteSent;
	}

	public void setNoteSent(String noteSent) {
		this.noteSent = noteSent;
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

	@Column(name = "pending_qty")
	public Long getPendingQty() {
		return this.pendingQty;
	}

	public void setPendingQty(Long pendingQty) {
		this.pendingQty = pendingQty;
	}

	@Column(name = "request_qty")
	public Long getRequestQty() {
		return this.requestQty;
	}

	public void setRequestQty(Long requestQty) {
		this.requestQty = requestQty;
	}

	public String getSku() {
		return this.sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
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

	// bi-directional many-to-one association to IssueBatchesInt
	@JsonManagedReference
	@OneToMany(mappedBy = "issueDtlsInt")
	@XmlElement
	public Set<IssueBatchesInt> getIssueBatchesInts() {
		return this.issueBatchesInts;
	}

	public void setIssueBatchesInts(Set<IssueBatchesInt> issueBatchesInts) {
		this.issueBatchesInts = issueBatchesInts;
	}

	// bi-directional many-to-one association to IssueHdrsInt
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "imh_int_seqno")
	public IssueHdrsInt getIssueHdrsInt() {
		return this.issueHdrsInt;
	}

	public void setIssueHdrsInt(IssueHdrsInt issueHdrsInt) {
		this.issueHdrsInt = issueHdrsInt;
	}

}