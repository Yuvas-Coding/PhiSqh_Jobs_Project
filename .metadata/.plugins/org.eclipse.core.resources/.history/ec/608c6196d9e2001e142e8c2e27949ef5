package my.com.cmg.iwp.backend.model.integration.issue;

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
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The persistent class for the ph_issue_batches_int database table.
 * 
 */
@Entity
@Table(name = "t_issue_batches_int")
@XmlRootElement(name = "IssueBatchesInt")
@JsonIgnoreProperties(ignoreUnknown=true)
public class IssueBatchesInt implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long imbIntSeqno;
	private String batchNo;
	private Long createdBy;
	private Date createdDate;
	private Date expiryDate;
	private Long issueQty;
	private String itemCode;
	private String brandCode;
	private String packagingDesc;
	private String parameter1;
	private String parameter2;
	private BigDecimal parameter3;
	private BigDecimal parameter4;
	private Date parameter5;
	private Long pkuQty;
	private String sku;
	private BigDecimal unitPrice;
	private Long updatedBy;
	private Date updatedDate;
	private IssueDtlsInt issueDtlsInt;

	public IssueBatchesInt() {
	}

	@Id
	@SequenceGenerator(name = "PH_ISSUE_BATCHES_INT_IMBINTSEQNO_GENERATOR", sequenceName = "t_issue_batches_int_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PH_ISSUE_BATCHES_INT_IMBINTSEQNO_GENERATOR")
	@Column(name = "imb_int_seqno")
	public Long getImbIntSeqno() {
		return this.imbIntSeqno;
	}

	public void setImbIntSeqno(Long imbIntSeqno) {
		this.imbIntSeqno = imbIntSeqno;
	}

	@Column(name = "batch_no")
	public String getBatchNo() {
		return this.batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
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

	@Temporal(TemporalType.DATE)
	@Column(name = "expiry_date")
	public Date getExpiryDate() {
		return this.expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	@Column(name = "issue_qty")
	public Long getIssueQty() {
		return this.issueQty;
	}

	public void setIssueQty(Long issueQty) {
		this.issueQty = issueQty;
	}

	@Column(name = "item_code")
	public String getItemCode() {
		return this.itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	@Column(name = "brand_code")
	public String getBrandCode() {
	    return brandCode;
	}

	public void setBrandCode(String brandCode) {
	    this.brandCode = brandCode;
	}

	@Column(name = "packaging_desc")
	public String getPackagingDesc() {
		return this.packagingDesc;
	}

	public void setPackagingDesc(String packagingDesc) {
		this.packagingDesc = packagingDesc;
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

	@Column(name = "pku_qty")
	public Long getPkuQty() {
		return this.pkuQty;
	}

	public void setPkuQty(Long pkuQty) {
		this.pkuQty = pkuQty;
	}

	public String getSku() {
		return this.sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	@Column(name = "unit_price")
	public BigDecimal getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
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

	// bi-directional many-to-one association to IssueDtlsInt
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "imd_int_seqno")
	public IssueDtlsInt getIssueDtlsInt() {
		return this.issueDtlsInt;
	}

	public void setIssueDtlsInt(IssueDtlsInt issueDtlsInt) {
		this.issueDtlsInt = issueDtlsInt;
	}

}