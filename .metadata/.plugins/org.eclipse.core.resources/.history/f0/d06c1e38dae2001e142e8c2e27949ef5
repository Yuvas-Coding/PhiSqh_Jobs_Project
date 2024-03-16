package my.com.cmg.iwp.maintenance.model;

import java.io.Serializable;
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
@Table(name="T_FULFILMNT_LOG")
public class FulfillmentLog  implements Serializable {
	private static final Long serialVersionUID = 1L;
	private Long seqNo;
	private String purchaseOrderNo;
	private Date createDate;
	private Long poHdrSeqno;
	
	private PoHdr poHdr;
	
	public FulfillmentLog() {
		
	}

	public FulfillmentLog(Long seqNo) {		
		this.seqNo = seqNo;
	}

	public FulfillmentLog(Long seqNo, String purchaseOrderNo, Date createDate) {
		super();
		this.seqNo = seqNo;
		this.purchaseOrderNo = purchaseOrderNo;
		this.createDate = createDate;
	}

	@Id
	@Column(name="SEQ_NO", nullable=false, unique=true)
	public Long getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(Long seqNo) {
		this.seqNo = seqNo;
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