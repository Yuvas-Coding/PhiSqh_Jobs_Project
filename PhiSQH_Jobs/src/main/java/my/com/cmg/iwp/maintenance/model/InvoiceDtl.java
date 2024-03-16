package my.com.cmg.iwp.maintenance.model;

import java.io.Serializable;

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

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the T_INVOICE_DTL database table.
 * 
 */
@Entity
@Table(name="T_INVOICE_DTL")
public class InvoiceDtl implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="T_INVOICE_DTL_SEQ", sequenceName="T_INVOICE_DTL_SEQ", allocationSize = 1)
	@GeneratedValue(generator="T_INVOICE_DTL_SEQ")
	@Column(name="INVOICE_SEQ", unique = true, nullable = false)
	private long invoiceSeq = Long.MIN_VALUE;

	@Column(name="CREATED_BY")
	private String createdBy;

	@Temporal(TemporalType.DATE)
	@Column(name="CREATED_DATE")
	private Date createdDate;

	@Column(name="FACILITY_CODE")
	private String facilityCode;

	/*@Column(name="HDR_SEQ_NO")
	private long hdrSeqNo;*/
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HDR_SEQ_NO")
	private PoHdr poHdr;
	public PoHdr getPoHdr() {
		return poHdr;
	}

	public void setPoHdr(PoHdr poHdr) {
		this.poHdr = poHdr;
	}

	@Column(name="INV_AMT")
	private BigDecimal invAmt;

	@Temporal(TemporalType.DATE)
	@Column(name="INV_DATE")
	private Date invDate;

	@Column(name="INV_NO")
	private String invNo;

	@Column(name="LPO_NO")
	private String lpoNo;

	@Column(name="PTJ_CODE")
	private String ptjCode;

	@Column(name="PURCHASE_ORDER_NO")
	private String purchaseOrderNo;

	@Column(name="SEND_TO_EP")
	private String sendToEp;

	@Temporal(TemporalType.DATE)
	@Column(name="SENDTO_EP_DATE")
	private Date sendtoEpDate;

	@Column(name="SHIP_TO_CODE")
	private String shipToCode;

	@Column(name="UPDATE_LOCAL")
	private String updateLocal;

	@Column(name="UPDATED_BY")
	private String updatedBy;

	@Temporal(TemporalType.DATE)
	@Column(name="UPDATED_DATE")
	private Date updatedDate;

	public InvoiceDtl() {
	}
	
	

	public long getInvoiceSeq() {
		return this.invoiceSeq;
	}

	public void setInvoiceSeq(long invoiceSeq) {
		this.invoiceSeq = invoiceSeq;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getFacilityCode() {
		return this.facilityCode;
	}

	public void setFacilityCode(String facilityCode) {
		this.facilityCode = facilityCode;
	}

	/*public long getHdrSeqNo() {
		return this.hdrSeqNo;
	}

	public void setHdrSeqNo(long hdrSeqNo) {
		this.hdrSeqNo = hdrSeqNo;
	}*/

	public BigDecimal getInvAmt() {
		return this.invAmt;
	}

	public void setInvAmt(BigDecimal invAmt) {
		this.invAmt = invAmt;
	}

	public Date getInvDate() {
		return this.invDate;
	}

	public void setInvDate(Date invDate) {
		this.invDate = invDate;
	}

	public String getInvNo() {
		return this.invNo;
	}

	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}

	public String getLpoNo() {
		return this.lpoNo;
	}

	public void setLpoNo(String lpoNo) {
		this.lpoNo = lpoNo;
	}

	public String getPtjCode() {
		return this.ptjCode;
	}

	public void setPtjCode(String ptjCode) {
		this.ptjCode = ptjCode;
	}

	public String getPurchaseOrderNo() {
		return this.purchaseOrderNo;
	}

	public void setPurchaseOrderNo(String purchaseOrderNo) {
		this.purchaseOrderNo = purchaseOrderNo;
	}

	public String getSendToEp() {
		return this.sendToEp;
	}

	public void setSendToEp(String sendToEp) {
		this.sendToEp = sendToEp;
	}

	public Date getSendtoEpDate() {
		return this.sendtoEpDate;
	}

	public void setSendtoEpDate(Date sendtoEpDate) {
		this.sendtoEpDate = sendtoEpDate;
	}

	public String getShipToCode() {
		return this.shipToCode;
	}

	public void setShipToCode(String shipToCode) {
		this.shipToCode = shipToCode;
	}

	public String getUpdateLocal() {
		return this.updateLocal;
	}

	public void setUpdateLocal(String updateLocal) {
		this.updateLocal = updateLocal;
	}

	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
}