package my.com.cmg.iwp.maintenance.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Formula;

@Entity
@Table(name = "T_REQ_NOTE_LOG")
public class RequestNoteLog  implements Serializable{
	private static final long serialVersionUID = 1L;
	private BigDecimal reqNoteSeq;
	private String facilityCode;
	private String purchaseOrderNo;
	private String jabatanCode;
	private String ptjCode;
	private String refNo;
	private String deliveryCode;
	private String pkuCode;
	private Integer orderedQty;
	private Date createDate;
	private String status;
	private Long count;
	
	private PoHdr poHdr;
	public RequestNoteLog() {
		
	}
	
	public RequestNoteLog(BigDecimal reqNoteSeq) {
		this.reqNoteSeq = reqNoteSeq;
	}
	
	public RequestNoteLog(BigDecimal reqNoteSeq, String facilityCode,
			String purchaseOrderNo, 
			String jabatanCode, String ptjCode, String refNo, 
			String deliveryCode, String pkuCode, Integer orderedQty, Date createDate) {
		this.reqNoteSeq = reqNoteSeq;
		this.facilityCode = facilityCode;
		this.purchaseOrderNo = purchaseOrderNo;
		this.jabatanCode = jabatanCode;
		this.ptjCode = ptjCode;
		this.refNo = refNo;
		this.deliveryCode = deliveryCode;
		this.pkuCode = pkuCode;
		this.orderedQty = orderedQty;
		this.createDate = createDate;
	}
	
	@Id
	@Column(name = "REQ_NOTE_SEQ", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getReqNoteSeq() {
		return reqNoteSeq;
	}
	public void setReqNoteSeq(BigDecimal reqNoteSeq) {
		this.reqNoteSeq = reqNoteSeq;
	}
	
	@Column(name = "FACILITY_CODE")
	public String getFacilityCode() {
		return facilityCode;
	}
	public void setFacilityCode(String facilityCode) {
		this.facilityCode = facilityCode;
	}
	
	@Column(name="PURCHASE_ORDER_NO")
	public String getPurchaseOrderNo() {
		return purchaseOrderNo;
	}
	public void setPurchaseOrderNo(String purchaseOrderNo) {
		this.purchaseOrderNo = purchaseOrderNo;
	}	
	
	@Column(name="JABATAN_CODE")
	public String getJabatanCode() {
		return jabatanCode;
	}
	public void setJabatanCode(String jabatanCode) {
		this.jabatanCode = jabatanCode;
	}
	
	@Column(name="PTJ_CODE")
	public String getPtjCode() {
		return ptjCode;
	}
	public void setPtjCode(String ptjCode) {
		this.ptjCode = ptjCode;
	}
	
	@Column(name="REFNO")
	public String getRefNo() {
		return refNo;
	}
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}
	
	@Column(name="DELIVERY_CODE")
	public String getDeliveryCode() {
		return deliveryCode;
	}
	public void setDeliveryCode(String deliveryCode) {
		this.deliveryCode = deliveryCode;
	}
	
	@Column(name="PKU_CODE")
	public String getPkuCode() {
		return pkuCode;
	}
	public void setPkuCode(String pkuCode) {
		this.pkuCode = pkuCode;
	}
	
	@Column(name="ORDERED_QTY")
	public Integer getOrderedQty() {
		return orderedQty;
	}
	public void setOrderedQty(Integer orderedQty) {
		this.orderedQty = orderedQty;
	}
	
	@Column(name="CREATE_DATE")
	@Formula(value="trunc(CREATE_DATE)")
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="PO_HDR_SEQNO", insertable=true, updatable=true)
	public PoHdr getPoHdr() {
		return poHdr;
	}

	public void setPoHdr(PoHdr poHdr) {
		this.poHdr = poHdr;
	}

	@Transient
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Transient
	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}
}