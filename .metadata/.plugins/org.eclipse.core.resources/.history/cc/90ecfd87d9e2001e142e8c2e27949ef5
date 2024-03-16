package my.com.cmg.iwp.maintenance.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;

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
@Table(name="T_REQ_CANCEL_LOG")
public class ReqCancelLog implements Serializable {
	private static final long serialVersionUID = 1L;
	private BigDecimal reqSeqNo;
	private String purchaseOrderNo;
	private String ptjCode;
	private String refNo;
	private String shipToCode;
	private Date cancellationDate;
	private Date createDate;
	private String remarks;
	private String status;
	private Long poHdrSeqno;	
	
	private PoHdr poHdr;
	
	public ReqCancelLog() {
		
	}
	
	public ReqCancelLog(BigDecimal reqSeqNo) {
		this.reqSeqNo = reqSeqNo;
	}
	
	public ReqCancelLog(BigDecimal reqSeqNo, String purchaseOrderNo, String ptjCode, String refNo, 
			String shipToCode, Date cancellationDate, Date createDate, String remarks, String status) {
		this.reqSeqNo = reqSeqNo;
		this.ptjCode = ptjCode;
		this.purchaseOrderNo = purchaseOrderNo;
		this.refNo = refNo;
		this.shipToCode = shipToCode;
		this.cancellationDate = cancellationDate;
		this.createDate = createDate;
		this.remarks = remarks;
		this.status = status;
	}

	@Id
	@Column(name="REQ_SEQ_NO", nullable=false, unique=false)
	public BigDecimal getReqSeqNo() {
		return reqSeqNo;
	}

	public void setReqSeqNo(BigDecimal reqSeqNo) {
		this.reqSeqNo = reqSeqNo;
	}

	@Column(name="PURCHASE_ORDER_NO")
	public String getPurchaseOrderNo() {
		return purchaseOrderNo;
	}

	public void setPurchaseOrderNo(String purchaseOrderNo) {
		this.purchaseOrderNo = purchaseOrderNo;
	}

	@Column(name="FACILITY_CODE")
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

	/*@Column(name="SHIP_TO_CODE")
	public String getShipToCode() {
		return shipToCode;
	}

	public void setShipToCode(String shipToCode) {
		this.shipToCode = shipToCode;
	}
*/
	@Column(name="CANCELLATION_DATE")
	@Formula(value="trunc(CANCELLATION_DATE)")
	public Date getCancellationDate() {
		return cancellationDate;
	}

	public void setCancellationDate(Date cancellationDate) {
		this.cancellationDate = cancellationDate;
	}

	@Column(name="CREATE_DATE")
	//@Formula(value="trunc(CREATE_DATE)")
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name="REMARK")
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Column(name="STATUS")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="PO_HDR_SEQNO", insertable=true, updatable=true)
	public PoHdr getPoHdr() {
		return poHdr;
	}

	public void setPoHdr(PoHdr poHdr) {
		this.poHdr = poHdr;
	}

	@Column(name="PO_HDR_SEQNO", insertable=false, updatable=false)
	public Long getPoHdrSeqno() {
		return poHdrSeqno;
	}

	public void setPoHdrSeqno(Long poHdrSeqno) {
		this.poHdrSeqno = poHdrSeqno;
	}
}