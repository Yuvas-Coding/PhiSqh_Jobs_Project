package my.com.cmg.iwp.maintenance.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_PAYMENT_DTL")
public class PaymentDtl implements java.io.Serializable {

	private long paymentdtlSeqno;
	private Item item;
	private Payment payment;
	private Long receivedQty;
	private Long orderQty;
	private CBMaster cbMaster;
	private Long updatedBy;
	private Date updatedDate;
	private long createdBy;
	private Date createdDate;
	private String parameter1;
	private String parameter2;
	private BigDecimal parameter3;
	private BigDecimal parameter4;
	private Date parameter5;
	private Character activeFlag;
	private BigDecimal receiveAmount;
	private String ptjCode;
	private String facilityCode;

	@Id
	@Column(name = "PAY_DETAIL_SEQNO", unique = true, nullable = false)
	@SequenceGenerator(name = "PAY_DETAIL_SEQNO", sequenceName = "T_PAYMENT_DTL_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "PAY_DETAIL_SEQNO")
	public long getPaymentdtlSeqno() {
		return paymentdtlSeqno;
	}

	public void setPaymentdtlSeqno(long paymentdtlSeqno) {
		this.paymentdtlSeqno = paymentdtlSeqno;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ITEM_SEQNO")
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PAYMENT_SEQNO")
	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	@Column(name = "RECEIVED_QTY")
	public Long getReceivedQty() {
		return receivedQty;
	}

	public void setReceivedQty(Long receivedQty) {
		this.receivedQty = receivedQty;
	}

	@Column(name = "ORDER_QTY")
	public Long getOrderQty() {
		return orderQty;
	}

	public void setOrderQty(Long orderQty) {
		this.orderQty = orderQty;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CB_MSTR_SEQNO")
	public CBMaster getCbMaster() {
		return cbMaster;
	}

	public void setCbMaster(CBMaster cbMaster) {
		this.cbMaster = cbMaster;
	}

	@Column(name = "UPDATED_BY")
	public Long getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATED_DATE", nullable = false, length = 100)
	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Column(name = "CREATED_BY")
	public long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE", nullable = false, length = 100)
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "PARAMETER1", length = 100)
	public String getParameter1() {
		return parameter1;
	}

	public void setParameter1(String parameter1) {
		this.parameter1 = parameter1;
	}

	@Column(name = "PARAMETER2", length = 100)
	public String getParameter2() {
		return parameter2;
	}

	public void setParameter2(String parameter2) {
		this.parameter2 = parameter2;
	}

	@Column(name = "PARAMETER3", precision = 8, scale = 4)
	public BigDecimal getParameter3() {
		return parameter3;
	}

	public void setParameter3(BigDecimal parameter3) {
		this.parameter3 = parameter3;
	}

	@Column(name = "PARAMETER4", precision = 8, scale = 4)
	public BigDecimal getParameter4() {
		return parameter4;
	}

	public void setParameter4(BigDecimal parameter4) {
		this.parameter4 = parameter4;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "PARAMETER5", length = 13)
	public Date getParameter5() {
		return parameter5;
	}

	public void setParameter5(Date parameter5) {
		this.parameter5 = parameter5;
	}

	@Column(name = "ACTIVE_FLAG")
	public Character getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(Character activeFlag) {
		this.activeFlag = activeFlag;
	}

	@Column(name = "RECEIVE_AMT")
	public BigDecimal getReceiveAmount() {
		return receiveAmount;
	}

	public void setReceiveAmount(BigDecimal receiveAmount) {
		this.receiveAmount = receiveAmount;
	}

	@Column(name = "PTJ_CODE", nullable = false, length = 20)
	public String getPtjCode() {
		return ptjCode;
	}

	public void setPtjCode(String ptjCode) {
		this.ptjCode = ptjCode;
	}

	@Column(name = "FACILITY_CODE", nullable = false, length = 20)
	public String getFacilityCode() {
		return facilityCode;
	}

	public void setFacilityCode(String facilityCode) {
		this.facilityCode = facilityCode;
	}

}
