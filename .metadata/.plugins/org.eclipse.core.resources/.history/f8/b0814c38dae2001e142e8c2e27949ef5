package my.com.cmg.iwp.maintenance.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="t_invoice_ep")
public class InvoiceEp implements Serializable {
	private static final long serialVersionUID = 1L;

	private long invoiceEpSeqno;
	private String facilityCode;
	private String ptjCode;
	private String contractOrderNo;
	private String paymentRefNo;
	private String invoiceBillNo;
	private String invoiceRefNo;
	private Double amountPaid;
	private Date paymentDate;

	private Character activeFlag;
	private String parameter1;
	private String parameter2;
	private BigDecimal parameter3;
	private BigDecimal parameter4;
	private Date parameter5;
	private long createdBy;
	private Date createdDate;
	private Long updatedBy;
	private Date updatedDate;
	
	public InvoiceEp() {
		
	}
	
	public InvoiceEp(long invoiceEpSeqno, String facilityCode, String ptjCode, String contractOrderNo,
			String paymentRefNo, String invoiceBillNo, String invoiceRefNo, Double amountPaid, Date paymentDate) {
		super();
		this.invoiceEpSeqno = invoiceEpSeqno;
		this.facilityCode = facilityCode;
		this.ptjCode = ptjCode;
		this.contractOrderNo = contractOrderNo;
		this.paymentRefNo = paymentRefNo;
		this.invoiceBillNo = invoiceBillNo;
		this.invoiceRefNo = invoiceRefNo;
		this.amountPaid = amountPaid;
		this.paymentDate = paymentDate;
	}
	
	@Id
	@Column(name="INVOICE_EP_SEQNO")
	public long getInvoiceEpSeqno() {
		return invoiceEpSeqno;
	}
	public void setInvoiceEpSeqno(long invoiceEpSeqno) {
		this.invoiceEpSeqno = invoiceEpSeqno;
	}
	
	@Column(name="FACILITY_CODE")
	public String getFacilityCode() {
		return facilityCode;
	}
	public void setFacilityCode(String facilityCode) {
		this.facilityCode = facilityCode;
	}
	
	@Column(name="PTJ_CODE")
	public String getPtjCode() {
		return ptjCode;
	}
	public void setPtjCode(String ptjCode) {
		this.ptjCode = ptjCode;
	}
	
	@Column(name="CONTRACT_ORDER_NO")
	public String getContractOrderNo() {
		return contractOrderNo;
	}
	public void setContractOrderNo(String contractOrderNo) {
		this.contractOrderNo = contractOrderNo;
	}
	
	@Column(name="PAYMENT_REF_NO")
	public String getPaymentRefNo() {
		return paymentRefNo;
	}
	public void setPaymentRefNo(String paymentRefNo) {
		this.paymentRefNo = paymentRefNo;
	}
	
	@Column(name="INVOICE_BILL_NO")
	public String getInvoiceBillNo() {
		return invoiceBillNo;
	}
	public void setInvoiceBillNo(String invoiceBillNo) {
		this.invoiceBillNo = invoiceBillNo;
	}
	
	@Column(name="INVOICE_REF_NO")
	public String getInvoiceRefNo() {
		return invoiceRefNo;
	}
	public void setInvoiceRefNo(String invoiceRefNo) {
		this.invoiceRefNo = invoiceRefNo;
	}
	
	@Column(name="AMOUNT_PAID")
	public Double getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(Double amountPaid) {
		this.amountPaid = amountPaid;
	}
	
	@Column(name="PAYMENT_DATE")
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
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

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE", nullable = false, length = 29)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
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
}