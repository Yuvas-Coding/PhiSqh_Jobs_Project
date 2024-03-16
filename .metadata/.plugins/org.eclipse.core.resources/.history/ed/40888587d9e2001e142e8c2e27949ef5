package my.com.cmg.iwp.maintenance.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "T_PO_CF")
public class PoCfHdr implements java.io.Serializable  {
	
	private static final long serialVersionUID = 1L;	
	
	private long poHdrSeqno;
	private String activeFlag;
	private long createdBy;
	private Date createdDate;
	private BigDecimal delToSeqno;
	private String facilityCode;	
	private String financialYear;
	private String lpoNo;
	private Date orderDate;
	private String orderStatus;
	private String ptjCode;
	private String purchaseOrderNo;
	private String transactionNo;
	private String approvedBy;
	private String purchaseOrderType;
	private Date approvedDate;	
	private String remarks;
	private Double totalOrderAmount;
	private long updatedBy;
	private Date updatedDate;
	private String supplier_code;
	private DeliveredTo deliveredTo;
	private Supplier supplier;  
	private Set<PoCfDtl> poCfDtls= new HashSet<PoCfDtl>(0);
	private String sendFlag;
	
	public PoCfHdr(){}
	
	public PoCfHdr(long poHdrSeqno, String activeFlag, long createdBy, Date createdDate, BigDecimal delToSeqno,
			String facilityCode, String financialYear, String lpoNo, Date orderDate, String orderStatus, String ptjCode,
			String purchaseOrderNo, String transactionNo, String approvedBy, String purchaseOrderType,
			Date approvedDate, String remarks, Double totalOrderAmount, long updatedBy, Date updatedDate,
			String supplier_code, DeliveredTo deliveredTo, Supplier supplier, 
			Set<PoCfDtl> poCfDtls, SecUser createdUser, SecUser updatedUser) {
		super();
		this.poHdrSeqno = poHdrSeqno;
		this.activeFlag = activeFlag;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.delToSeqno = delToSeqno;
		this.facilityCode = facilityCode;
		this.financialYear = financialYear;
		this.lpoNo = lpoNo;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
		this.ptjCode = ptjCode;
		this.purchaseOrderNo = purchaseOrderNo;
		this.transactionNo = transactionNo;
		this.approvedBy = approvedBy;
		this.purchaseOrderType = purchaseOrderType;
		this.approvedDate = approvedDate;
		this.remarks = remarks;
		this.totalOrderAmount = totalOrderAmount;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.supplier_code = supplier_code;
		this.deliveredTo = deliveredTo;
		this.supplier = supplier;
		this.poCfDtls = poCfDtls;
		this.createdUser = createdUser;
		this.updatedUser = updatedUser;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "poCfHdr" ,cascade=CascadeType.ALL)
	@Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.DELETE_ORPHAN })
	public Set<PoCfDtl> getPoCfDtls() {
		return poCfDtls;
	}

	public void setPoCfDtls(Set<PoCfDtl> poCfDtls) {
		this.poCfDtls = poCfDtls;
	}
	
	@Id
	@SequenceGenerator(name="T_POCFHDRSEQNO_GENERATOR", sequenceName="t_po_cf_seq", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="T_POCFHDRSEQNO_GENERATOR")
	@Column(name="PO_HDR_SEQNO")
	public long getPoHdrSeqno() {
		return poHdrSeqno;
	}

	public void setPoHdrSeqno(long poHdrSeqno) {
		this.poHdrSeqno = poHdrSeqno;
	}


	@Column(name="ACTIVE_FLAG")
	public String getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}

	
	@Column(name="CREATED_BY",nullable = false)
	public long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}


    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="CREATED_DATE")
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}


	@Column(name="DEL_TO_SEQNO", insertable=false, updatable=false)
	public BigDecimal getDelToSeqno() {
		return this.delToSeqno;
	}

	public void setDelToSeqno(BigDecimal delToSeqno) {
		this.delToSeqno = delToSeqno;
	}

	
	@Column(name="FACILITY_CODE")
	public String getFacilityCode() {
		return facilityCode;
	}

	public void setFacilityCode(String facilityCode) {
		this.facilityCode = facilityCode;
	}

	@Column(name="financial_year")
	public String getFinancialYear() {
		return financialYear;
	}

	public void setFinancialYear(String financialYear) {
		this.financialYear = financialYear;
	}

	
	@Column(name="LPO_NO")
	public String getLpoNo() {
		return lpoNo;
	}

	public void setLpoNo(String lpoNo) {
		this.lpoNo = lpoNo;
	}

	
	@Temporal( TemporalType.TIMESTAMP)
	@Column(name="ORDER_DATE")
	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}


	@Column(name="ORDER_STATUS")
	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	@Column(name="PTJ_CODE")
	public String getPtjCode() {
		return ptjCode;
	}

	public void setPtjCode(String ptjCode) {
		this.ptjCode = ptjCode;
	}


	@Column(name="PURCHASE_ORDER_NO")
	public String getPurchaseOrderNo() {
		return purchaseOrderNo;
	}

	public void setPurchaseOrderNo(String purchaseOrderNo) {
		this.purchaseOrderNo = purchaseOrderNo;
	}

	
	@Column(name="APPROVED_BY")
	public String getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	
	@Temporal( TemporalType.TIMESTAMP)
	@Column(name="APPROVED_DATE")
	public Date getApprovedDate() {
		return approvedDate;
	}

	public void setApprovedDate(Date approvedDate) {
		this.approvedDate = approvedDate;
	}

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DEL_TO_SEQNO", insertable=true, updatable=true)
	public DeliveredTo getDeliveredTo() {
		return deliveredTo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "spr_seqno")
	public Supplier getSupplier() {
		return supplier;
	}

	public void setDeliveredTo(DeliveredTo deliveredTo) {
		this.deliveredTo = deliveredTo;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	@Column(name="remarks")
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	
	@Column(name="TOTAL_ORDER_AMOUNT")
	public Double getTotalOrderAmount() {
		return totalOrderAmount;
	}

	public void setTotalOrderAmount(Double totalOrderAmount) {
		this.totalOrderAmount = totalOrderAmount;
	}

	
	@Column(name="UPDATED_BY",nullable = false)
	public long getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(long updatedBy) {
		this.updatedBy = updatedBy;
	}


    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="UPDATED_DATE")
	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

    
    @Column(name="SUPPLIER_CODE")
	public String getSupplier_code() {
		return supplier_code;
	}

	public void setSupplier_code(String supplier_code) {
		this.supplier_code = supplier_code;
	}

	
	@Column(name="TRANSACTION_NO")
	public String getTransactionNo() {
		return transactionNo;
	}

	public void setTransactionNo(String transactionNo) {
		this.transactionNo = transactionNo;
	}
	
	@Column(name="PURCHASE_ORDER_TYPE")    
	public String getPurchaseOrderType() {
		return this.purchaseOrderType;
	}

	public void setPurchaseOrderType(String purchaseOrderType) {
		this.purchaseOrderType = purchaseOrderType;
	}
	private SecUser createdUser;
	private SecUser updatedUser;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UPDATED_BY", insertable = false, updatable = false)
	@JsonIgnore
	public SecUser getUpdatedUser() {
		return this.updatedUser;
	}

	public void setUpdatedUser(SecUser updatedUser) {
		this.updatedUser = updatedUser;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CREATED_BY", insertable = false, updatable = false)
	@JsonIgnore
	public SecUser getCreatedUser() {
		return this.createdUser;
	}

	public void setCreatedUser(SecUser createdUser) {
		this.createdUser = createdUser;
	}

	@Column(name="send_flag")    
	public String getSendFlag() {
		return sendFlag;
	}

	public void setSendFlag(String sendFlag) {
		this.sendFlag = sendFlag;
	}

	
}
