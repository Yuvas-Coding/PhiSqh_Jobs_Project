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
@Table(name = "T_INVOICE_LOG")
public class InvoiceLog implements Serializable {
	private static final long serialVersionUID = 1L;
	private BigDecimal seqNo;
	private String lpoNo;
	private String invoiceNo;
	private Date createDate;
	private String status;
	
	private PoHdr poHdr;

	public InvoiceLog() {
		super();
	}

	public InvoiceLog(BigDecimal seqNo) {
		super();
		this.seqNo = seqNo;
	}

	public InvoiceLog(BigDecimal seqNo, String lpoNo, String invoiceNo, Date createDate, String status) {
		super();
		this.seqNo = seqNo;
		this.lpoNo = lpoNo;
		this.invoiceNo = invoiceNo;
		this.createDate = createDate;
		this.status = status;
	}

	@Id
	@Column(name = "SEQ_NO", nullable = false, unique = true)
	public BigDecimal getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(BigDecimal seqNo) {
		this.seqNo = seqNo;
	}

	@Column(name = "LPO_NO")
	public String getLpoNo() {
		return lpoNo;
	}

	public void setLpoNo(String lpoNo) {
		this.lpoNo = lpoNo;
	}

	@Column(name = "INV_NO")
	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	@Column(name = "CREATE_DATE")
	@Formula(value = "trunc(CREATE_DATE)")
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name = "STATUS")
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