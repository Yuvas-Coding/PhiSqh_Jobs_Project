package my.com.cmg.iwp.maintenance.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_DO_IN_OUT_VW")
public class DoInOutVW implements Serializable {

	@Id
	@Column(name="DO_SEQ_NO", nullable = false)
	private String doSeqNo;
	
	@Column(name="PURCHASE_ORDER_TYPE")
	private String purchaseOrderType;
	
	@Column(name="PURCHASE_ORDER_NO")
	private String purchaseOrderNo;
	
	@Temporal(TemporalType.DATE)
	@Column(name="CREATED_DATE")
	private Date createdDate;
	
	@Column(name="SENDTO_EP_DATE")
	private String sendToEPDate;
	
	@Column(name="FACILITY_CODE")
	private String facilityCode;
	
	@Column(name="LPO_NO")
	private String lpoNo;

	public String getDoSeqNo() {
		return doSeqNo;
	}

	public void setDoSeqNo(String doSeqNo) {
		this.doSeqNo = doSeqNo;
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

	public String getSendToEPDate() {
		return sendToEPDate;
	}

	public void setSendToEPDate(String sendToEPDate) {
		this.sendToEPDate = sendToEPDate;
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
}

