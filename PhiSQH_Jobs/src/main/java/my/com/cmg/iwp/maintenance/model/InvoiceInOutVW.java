package my.com.cmg.iwp.maintenance.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_INVOICE_IN_OUT_VW")
public class InvoiceInOutVW {
	
	@Id
	@Column(name="PO_HDR_SEQNO", nullable = false)
	private String poHdrSeqNo;
	
	@Column(name="PURCHASE_ORDER_NO")
	private String purchaseOrderNo;
	
	@Column(name="LPO_NO")
	private String lpoNo;
	
	@Column(name="FACILITY_CODE")
	private String facilityCode;
	
	@Column(name="PURCHASE_ORDER_TYPE")
	private String purchaseOrderType;
	
	@Column(name="INVOICE_SEND_TO_EP")
	private String invoiceSendToEP;
	
	@Temporal(TemporalType.DATE)
	@Column(name="CREATED_DATE")
	private Date createdDate;

	public String getPoHdrSeqNo() {
		return poHdrSeqNo;
	}

	public void setPoHdrSeqNo(String poHdrSeqNo) {
		this.poHdrSeqNo = poHdrSeqNo;
	}

	public String getPurchaseOrderNo() {
		return purchaseOrderNo;
	}

	public void setPurchaseOrderNo(String purchaseOrderNo) {
		this.purchaseOrderNo = purchaseOrderNo;
	}

	public String getLpoNo() {
		return lpoNo;
	}

	public void setLpoNo(String lpoNo) {
		this.lpoNo = lpoNo;
	}

	public String getFacilityCode() {
		return facilityCode;
	}

	public void setFacilityCode(String facilityCode) {
		this.facilityCode = facilityCode;
	}

	public String getPurchaseOrderType() {
		return purchaseOrderType;
	}

	public void setPurchaseOrderType(String purchaseOrderType) {
		this.purchaseOrderType = purchaseOrderType;
	}

	public String getInvoiceSendToEP() {
		return invoiceSendToEP;
	}

	public void setInvoiceSendToEP(String invoiceSendToEP) {
		this.invoiceSendToEP = invoiceSendToEP;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
}

