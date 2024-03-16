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
@Table(name="T_PMNT_NOTIFICATION_LOG")
public class PaymentLog implements Serializable {
	private static final long serialVersionUID = 1L;
	private BigDecimal pmntSeqNo;
	private String purchaseOrderNo;
	private Date createDate;
	private String status;
	
	private PoHdr poHdr;
	
	public PaymentLog() {
		super();
	}
	public PaymentLog(BigDecimal pmntSeqNo) {
		super();
		this.pmntSeqNo = pmntSeqNo;
	}
	public PaymentLog(BigDecimal pmntSeqNo, String purchaseOrderNo, Date createDate,
			String status) {
		super();
		this.pmntSeqNo = pmntSeqNo;
		this.purchaseOrderNo = purchaseOrderNo;
		this.createDate = createDate;
		this.status = status;
	}
	
	@Id
	@Column(name="PMNT_SEQ_NO", unique=true, nullable=false)
	public BigDecimal getPmntSeqNo() {
		return pmntSeqNo;
	}
	public void setPmntSeqNo(BigDecimal pmntSeqNo) {
		this.pmntSeqNo = pmntSeqNo;
	}
	
	@Column(name="PURCHASE_ORDER_NO")
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
	@JoinColumn(name="PO_HDR_SEQNO")
	public PoHdr getPoHdr() {
		return poHdr;
	}
	public void setPoHdr(PoHdr poHdr) {
		this.poHdr = poHdr;
	}
}