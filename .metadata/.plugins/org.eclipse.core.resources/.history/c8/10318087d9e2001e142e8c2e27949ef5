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
@Table(name="T_PO_CANCEL_LOG")
public class PoCancelLog implements Serializable {
	private static final long serialVersionUID = 1L;
	private BigDecimal poSeqNo;
	private Date cancelDate;
	private Date createDate;
	private String cancelRemarks;
	private String customerRefNo;
	private String customerAccNo;
	private String poNo;
	private String refNo;
	private String shipToCode;
	private PoHdr poHdr;
	
	public PoCancelLog() {
		
	}
	
	public PoCancelLog(BigDecimal poSeqNo) {
		this.poSeqNo = poSeqNo;
	}
	
	public PoCancelLog(BigDecimal poSeqNo, Date cancelDate, Date createDate, String cancelRemarks, 
			String customerRefNo, String customerAccNo, String poNo, String refNo, String shipToCode) {
		this.poSeqNo = poSeqNo;
		this.cancelDate = cancelDate;
		this.createDate = createDate;
		this.cancelRemarks = cancelRemarks;
		this.customerRefNo = customerRefNo;
		this.customerAccNo = customerAccNo;
		this.poNo = poNo;
		this.refNo = refNo;
		this.shipToCode = shipToCode;
	}

	@Id
	@Column(name="PO_SEQ_NO", unique=true, nullable=false)
	public BigDecimal getPoSeqNo() {
		return poSeqNo;
	}

	public void setPoSeqNo(BigDecimal poSeqNo) {
		this.poSeqNo = poSeqNo;
	}

	@Column(name="CANCEL_DATE")
	@Formula(value="trunc(CANCEL_DATE)")
	public Date getCancelDate() {
		return cancelDate;
	}

	public void setCancelDate(Date cancelDate) {
		this.cancelDate = cancelDate;
	}

	@Column(name="CREATE_DATE")
	@Formula(value="trunc(CREATE_DATE)")
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name="CANCEL_REMARK")
	public String getCancelRemarks() {
		return cancelRemarks;
	}

	public void setCancelRemarks(String cancelRemarks) {
		this.cancelRemarks = cancelRemarks;
	}

	@Column(name="CUSTOMER_REF_NO")
	public String getCustomerRefNo() {
		return customerRefNo;
	}

	public void setCustomerRefNo(String customerRefNo) {
		this.customerRefNo = customerRefNo;
	}

	@Column(name="CUSTOMER_ACC_NO")
	public String getCustomerAccNo() {
		return customerAccNo;
	}

	public void setCustomerAccNo(String customerAccNo) {
		this.customerAccNo = customerAccNo;
	}

	@Column(name="PO_NO")
	public String getPoNo() {
		return poNo;
	}

	public void setPoNo(String poNo) {
		this.poNo = poNo;
	}

	@Column(name="REFNO")
	public String getRefNo() {
		return refNo;
	}

	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

	@Column(name="SHIP_TO_CODE")
	public String getShipToCode() {
		return shipToCode;
	}

	public void setShipToCode(String shipToCode) {
		this.shipToCode = shipToCode;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="PO_HDR_SEQNO", insertable=true, updatable=true)
	public PoHdr getPoHdr() {
		return poHdr;
	}
	public void setPoHdr(PoHdr poHdr) {
		this.poHdr = poHdr;
	}
}