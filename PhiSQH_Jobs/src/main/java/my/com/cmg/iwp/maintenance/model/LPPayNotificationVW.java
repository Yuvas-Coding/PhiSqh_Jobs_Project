package my.com.cmg.iwp.maintenance.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_LP_PAYMT_NOTICF_VW ")
public class LPPayNotificationVW {
	
	@Id
	@Column(name="PO_HDR_SEQNO", nullable = false)
	private String poHdrSeqno;
	
	@Column(name="PURCHASE_ORDER_TYPE")
	private String purchaseOrderType;
	
	@Column(name="PURCHASE_ORDER_NO")
	private String purchaseOrderNo;
	
	@Temporal(TemporalType.DATE)
	@Column(name="CREATED_DATE")
	private Date createdDate;
	
	@Column(name="FACILITY_CODE")
	private String facilityCode;
	
	@Column(name="LPO_NO")
	private String lpoNo;
	
	@Column(name="PAYMENT_STATUS")
	private String paymentStatus;

	
	public String getPoHdrSeqno() {
		return poHdrSeqno;
	}

	public void setPoHdrSeqno(String poHdrSeqno) {
		this.poHdrSeqno = poHdrSeqno;
	}

	public String getPurchaseOrderType() {
		return purchaseOrderType;
	}

	public void setPurchaseOrderType(String purchaseOrderType) {
		this.purchaseOrderType = purchaseOrderType;
	}

	public String getPurchaseOrderNo() {
		return purchaseOrderNo;
	}

	public void setPurchaseOrderNo(String purchaseOrderNo) {
		this.purchaseOrderNo = purchaseOrderNo;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getFacilityCode() {
		return facilityCode;
	}

	public void setFacilityCode(String facilityCode) {
		this.facilityCode = facilityCode;
	}

	public String getLpoNo() {
		return lpoNo;
	}

	public void setLpoNo(String lpoNo) {
		this.lpoNo = lpoNo;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
}
