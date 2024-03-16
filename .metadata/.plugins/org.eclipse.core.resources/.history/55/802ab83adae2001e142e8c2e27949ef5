package my.com.cmg.iwp.maintenance.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;

@Entity
@Table(name="T_PO_ACK_LOG")
public class POAckLog  implements Serializable {
	private static final long serialVersionUID = 1L;
	private BigDecimal ackSeqNo;
	private String purchaseOrderNo;
	private Date createDate;
	private String status;
	
	private PoHdr poHdr;
	
	public POAckLog() {
		
	}
	public POAckLog(BigDecimal ackSeqNo) {
		this.ackSeqNo = ackSeqNo;
	}
	public POAckLog(BigDecimal ackSeqNo, String purchaseOrderNo, Date createDate, String status) {
		this.ackSeqNo = ackSeqNo;
		this.purchaseOrderNo = purchaseOrderNo;
		this.createDate = createDate;
		this.status = status;
	}
	@Id
	@Column(name="ACK_SEQ_NO", nullable=false, unique=true)
	public BigDecimal getAckSeqNo() {
		return ackSeqNo;
	}
	public void setAckSeqNo(BigDecimal ackSeqNo) {
		this.ackSeqNo = ackSeqNo;
	}
	
	@Column(name="PURCHASE_ORDER_NO", insertable=false, updatable=false)
	public String getPurchaseOrderNo() {
		return purchaseOrderNo;
	}
	public void setPurchaseOrderNo(String purchaseOrderNo) {
		this.purchaseOrderNo = purchaseOrderNo;
	}
	
	@Column(name="CREATE_DATE")
	@Formula(value="trunc(CREATE_DATE)")
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	@Column(name="STATUS")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="PURCHASE_ORDER_NO", insertable=true, updatable=true)
	public PoHdr getPoHdr() {
		return poHdr;
	}
	public void setPoHdr(PoHdr poHdr) {
		this.poHdr = poHdr;
	}
}