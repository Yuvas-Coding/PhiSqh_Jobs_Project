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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_PAYMENTS")
public class Payment implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long paymentSeqno;
	private String paymentNo;
	private String lpoNo;
	private Supplier suppliers;
	private Date createdDate;
	private String paymentType;
	private String status;
	private PoHdr poHdr;
	private ExternalFacility externalFacility;
	private String supplyType;
	private Integer financialYear;
	private BigDecimal totalCurrentPayment;
	private BigDecimal totalOutstandingAmount;
	private String voucherNo;
	private String noKilompok;
	private Character activeFlag;
	private String parameter1;
	private String parameter2;
	private BigDecimal parameter3;
	private BigDecimal parameter4;
	private Date parameter5;
	private long createdBy;
	private Long updatedBy;
	private Date updatedDate;
	private String rejectReason;
	private String paymentRemark;
	private String invoiceNo;
	private String creditNoteNo;
	private String ptjCode;
	private String facilityCode;
	private Date invoiceDate;
	private Date eGRNDate;
	private SecUser createdUser;
	private Set<PaymentDtl> paymentDtls = new HashSet<PaymentDtl>(0);
	private Set<PaymentByVotecode> paymentByVotecodes = new HashSet<PaymentByVotecode>(0);

	public Payment() {
	}

	public Payment(long paymentSeqno, String paymentNo, String supplyType,
			String paymentType, int financialYear,
			BigDecimal totalCurrentPayment, BigDecimal totalOutstandingAmount,
			Character activeFl, long createdBy, Date createdDate,
			Date updatedDate) {
		this.paymentSeqno = paymentSeqno;
		this.paymentNo = paymentNo;
		this.supplyType = supplyType;
		this.paymentType = paymentType;
		this.financialYear = financialYear;
		this.totalCurrentPayment = totalCurrentPayment;
		this.totalOutstandingAmount = totalOutstandingAmount;
		this.activeFlag = activeFl;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	public Payment(long paymentSeqno, Supplier suppliers, PoHdr poHdr,
			String paymentNo, String supplyType, String lpoNo,
			String paymentType, int financialYear,
			BigDecimal totalCurrentPayment, BigDecimal totalOutstandingAmount,
			String voucherNo, String noKilompok, Character activeFl,
			String parameter1, String parameter2, BigDecimal parameter3,
			BigDecimal parameter4, Date parameter5, long createdBy,
			Date createdDate, Long updatedBy, Date updatedDate, String status) {
		this.paymentSeqno = paymentSeqno;
		this.suppliers = suppliers;
		this.poHdr = poHdr;
		this.paymentNo = paymentNo;
		this.supplyType = supplyType;
		this.lpoNo = lpoNo;
		this.paymentType = paymentType;
		this.financialYear = financialYear;
		this.totalCurrentPayment = totalCurrentPayment;
		this.totalOutstandingAmount = totalOutstandingAmount;
		this.voucherNo = voucherNo;
		this.noKilompok = noKilompok;
		this.activeFlag = activeFl;
		this.parameter1 = parameter1;
		this.parameter2 = parameter2;
		this.parameter3 = parameter3;
		this.parameter4 = parameter4;
		this.parameter5 = parameter5;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.status = status;
	}

	@Id
	@Column(name = "PAYMENT_SEQNO", unique = true, nullable = false)
	@SequenceGenerator(name = "PAYMENT_SEQNO", sequenceName = "T_PAYMENTS_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "PAYMENT_SEQNO")
	public long getPaymentSeqno() {
		return this.paymentSeqno;
	}

	public void setPaymentSeqno(long paymentSeqno) {
		this.paymentSeqno = paymentSeqno;
	}
	
	@Column(name = "PAYMENT_NO", nullable = false, length = 20)
	public String getPaymentNo() {
		return this.paymentNo;
	}

	public void setPaymentNo(String paymentNo) {
		this.paymentNo = paymentNo;
	}
	
	@Column(name = "LPO_NO", length = 20)
	public String getLpoNo() {
		return this.lpoNo;
	}

	public void setLpoNo(String lpoNo) {
		this.lpoNo = lpoNo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SPR_SEQNO")
	public Supplier getSuppliers() {
		return this.suppliers;
	}

	public void setSuppliers(Supplier suppliers) {
		this.suppliers = suppliers;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE", nullable = false, length = 29)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	@Column(name = "PAYMENT_TYPE", nullable = false, length = 20)
	public String getPaymentType() {
		return this.paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	
	@Column(name = "STATUS", length = 20)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name = "PO_HDR_SEQ")
	public PoHdr getPoHdr() {
		return this.poHdr;
	}

	public void setPoHdr(PoHdr poHdr) {
		this.poHdr = poHdr;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EXTERNAL_SEQ")
	public ExternalFacility getExternalFacility() {
		return externalFacility;
	}

	public void setExternalFacility(ExternalFacility externalFacility) {
		this.externalFacility = externalFacility;
	}
	
	@Column(name = "SUPPLY_TYPE", nullable = false, length = 20)
	public String getSupplyType() {
		return this.supplyType;
	}

	public void setSupplyType(String supplyType) {
		this.supplyType = supplyType;
	}

	@Column(name = "FINANCIAL_YEAR", nullable = false)
	public Integer getFinancialYear() {
		return this.financialYear;
	}

	public void setFinancialYear(Integer financialYear) {
		this.financialYear = financialYear;
	}
	
	@Column(name = "TOTAL_CURRENT_PAYMENT", nullable = false, precision = 15, scale = 4)
	public BigDecimal getTotalCurrentPayment() {
		return this.totalCurrentPayment;
	}

	public void setTotalCurrentPayment(BigDecimal totalCurrentPayment) {
		this.totalCurrentPayment = totalCurrentPayment;
	}

	@Column(name = "TOTAL_OUTSTANDING_AMOUNT", nullable = false, precision = 15, scale = 4)
	public BigDecimal getTotalOutstandingAmount() {
		return this.totalOutstandingAmount;
	}

	public void setTotalOutstandingAmount(BigDecimal totalOutstandingAmount) {
		this.totalOutstandingAmount = totalOutstandingAmount;
	}
	
	@Column(name = "VOUCHER_NO", length = 20)
	public String getVoucherNo() {
		return this.voucherNo;
	}

	public void setVoucherNo(String voucherNo) {
		this.voucherNo = voucherNo;
	}

	@Column(name = "NO_KILOMPOK", length = 10)
	public String getNoKilompok() {
		return this.noKilompok;
	}

	public void setNoKilompok(String noKilompok) {
		this.noKilompok = noKilompok;
	}
	
	@Column(name = "ACTIVE_FLAG", nullable = false, length = 1)
	public Character getActiveFlag() {
		return this.activeFlag;
	}

	public void setActiveFlag(Character activeFlag) {
		this.activeFlag = activeFlag;
	}
	
	@Column(name = "PARAMETER1", length = 100)
	public String getParameter1() {
		return this.parameter1;
	}

	public void setParameter1(String parameter1) {
		this.parameter1 = parameter1;
	}

	@Column(name = "PARAMETER2", length = 100)
	public String getParameter2() {
		return this.parameter2;
	}

	public void setParameter2(String parameter2) {
		this.parameter2 = parameter2;
	}

	@Column(name = "PARAMETER3", precision = 8, scale = 4)
	public BigDecimal getParameter3() {
		return this.parameter3;
	}

	public void setParameter3(BigDecimal parameter3) {
		this.parameter3 = parameter3;
	}

	@Column(name = "PARAMETER4", precision = 8, scale = 4)
	public BigDecimal getParameter4() {
		return this.parameter4;
	}

	public void setParameter4(BigDecimal parameter4) {
		this.parameter4 = parameter4;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "PARAMETER5", length = 13)
	public Date getParameter5() {
		return this.parameter5;
	}

	public void setParameter5(Date parameter5) {
		this.parameter5 = parameter5;
	}
	
	@Column(name = "CREATED_BY", nullable = false)
	public long getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "UPDATED_BY")
	public Long getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATED_DATE", nullable = false, length = 29)
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	@Column(name = "REJECT_REASON", length = 500)
	public String getRejectReason() {
		return this.rejectReason;
	}

	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}

	@Column(name = "PAYMENT_REMARKS", length = 500)
	public String getPaymentRemark() {
		return this.paymentRemark;
	}

	public void setPaymentRemark(String paymentRemark) {
		this.paymentRemark = paymentRemark;
	}

	@Column(name = "INVOICE_NO", length = 50)
	public String getInvoiceNo() {
		return this.invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	
	@Column(name = "CREDIT_NOTE_NO", length = 50)
	public String getCreditNoteNo() {
		return this.creditNoteNo;
	}

	public void setCreditNoteNo(String creditNoteNo) {
		this.creditNoteNo = creditNoteNo;
	}

	@Column(name = "PTJ_CODE", nullable = false, length = 50)
	public String getPtjCode() {
		return ptjCode;
	}

	public void setPtjCode(String ptjCode) {
		this.ptjCode = ptjCode;
	}

	@Column(name = "FACILITY_CODE", nullable = false, length = 50)
	public String getFacilityCode() {
		return facilityCode;
	}

	public void setFacilityCode(String facilityCode) {
		this.facilityCode = facilityCode;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "INVOICE_DATE")
	public Date getInvoiceDate() {
		return this.invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "egrn_date")
	public Date getEGRNDate() {
		return this.eGRNDate;
	}
	
	public void setEGRNDate(Date eGRNDate) {
		this.eGRNDate = eGRNDate;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CREATED_BY", insertable = false, updatable = false)
	public SecUser getCreatedUser() {
		return this.createdUser;
	}

	public void setCreatedUser(SecUser secUser) {
		this.createdUser = secUser;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "payment", cascade = CascadeType.ALL)
	public Set<PaymentByVotecode> getPaymentByVotecodes() {
		return this.paymentByVotecodes;
	}

	public void setPaymentByVotecodes(Set<PaymentByVotecode> paymentByVotecodes) {
		this.paymentByVotecodes = paymentByVotecodes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "payment", cascade = CascadeType.ALL)
	public Set<PaymentDtl> getPaymentDtls() {
		return paymentDtls;
	}

	public void setPaymentDtls(Set<PaymentDtl> paymentDtls) {
		this.paymentDtls = paymentDtls;
	}

}
