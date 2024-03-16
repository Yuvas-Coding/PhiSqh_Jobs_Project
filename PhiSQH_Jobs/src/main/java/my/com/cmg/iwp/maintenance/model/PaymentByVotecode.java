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
@Table(name = "T_PAYMENT_BY_VOTECODE")
public class PaymentByVotecode implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private long paymentByVotecodeSeqno;
	private CBMaster cbMaster;
	private Payment payment;
	private BigDecimal voteAmount;
	private BigDecimal creditNoteAmount;
	private Character activeFlag;
	private String parameter1;
	private String parameter2;
	private BigDecimal parameter3;
	private BigDecimal parameter4;
	private Date parameter5;
	private long createdBy;
	private Date createdDate;
	private Long updatedBy;
	private Date updatedDate;
	private String ptjCode;
	private String facilityCode;

	public PaymentByVotecode() {
	}

	public PaymentByVotecode(long paymentByVotecodeSeqno,
			Payment payment,
			String paymentReferenceNo, BigDecimal paymentAmount,
			BigDecimal orderAmount, long createdBy,
			Date createdDate, Date updatedDate) {
		this.paymentByVotecodeSeqno = paymentByVotecodeSeqno;
		this.payment = payment;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	public PaymentByVotecode(long paymentByVotecodeSeqno,
			Payment payment,
			String paymentReferenceNo, BigDecimal paymentAmount,
			String creditNoteReferenceNo, BigDecimal creditNoteAmount,
			BigDecimal receivedAmout, BigDecimal orderAmount, 
			String parameter1, String parameter2, BigDecimal parameter3,
			BigDecimal parameter4, Date parameter5, long createBy,
			Date createDate, Long updateBy, Date updateDate) {
		this.paymentByVotecodeSeqno = paymentByVotecodeSeqno;
		this.payment = payment;
		this.creditNoteAmount = creditNoteAmount;
		this.parameter1 = parameter1;
		this.parameter2 = parameter2;
		this.parameter3 = parameter3;
		this.parameter4 = parameter4;
		this.parameter5 = parameter5;
		this.createdBy = createBy;
		this.createdDate = createDate;
		this.updatedBy = updateBy;
		this.updatedDate = updateDate;
	}

	@Id
	@Column(name = "PAYMENT_BY_VOTECODE_SEQNO", unique = true, nullable = false)
	@SequenceGenerator(name="PAYMENT_BY_VOTECODE_SEQNO", sequenceName="T_PAYMENT_BY_VOTECODE_SEQ", allocationSize = 1)
	@GeneratedValue(generator="PAYMENT_BY_VOTECODE_SEQNO")
	public long getPaymentByVotecodeSeqno() {
		return this.paymentByVotecodeSeqno;
	}

	public void setPaymentByVotecodeSeqno(long paymentByVotecodeSeqno) {
		this.paymentByVotecodeSeqno = paymentByVotecodeSeqno;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CB_MSTR_SEQNO", nullable = false)
	public CBMaster getCbMaster() {
		return cbMaster;
	}

	public void setCbMaster(CBMaster cbMaster) {
		this.cbMaster = cbMaster;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PAYMENT_SEQNO", nullable = false)
	public Payment getPayment() {
		return this.payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	@Column(name = "VOTE_AMOUNTPAYMENT_AMOUNT", nullable = false, precision = 15, scale = 4)
	public BigDecimal getVoteAmount() {
		return voteAmount;
	}

	public void setVoteAmount(BigDecimal voteAmount) {
		this.voteAmount = voteAmount;
	}

	@Column(name = "CREDIT_NOTE_AMOUNT", precision = 15, scale = 4)
	public BigDecimal getCreditNoteAmount() {
		return this.creditNoteAmount;
	}

	public void setCreditNoteAmount(BigDecimal creditNoteAmount) {
		this.creditNoteAmount = creditNoteAmount;
	}

	@Column(name = "ACTIVE_FLAG", nullable = false, length = 1)
	public Character getActiveFlag() {
		return this.activeFlag;
	}

	public void setActiveFlag(Character activeFlag) {
		this.activeFlag = activeFlag;
	}

	@Column(name = "PARAMETER1", length = 100)
	public String getParameter1() {
		return this.parameter1;
	}

	public void setParameter1(String parameter1) {
		this.parameter1 = parameter1;
	}

	@Column(name = "PARAMETER2", length = 100)
	public String getParameter2() {
		return this.parameter2;
	}

	public void setParameter2(String parameter2) {
		this.parameter2 = parameter2;
	}

	@Column(name = "PARAMETER3", precision = 8, scale = 4)
	public BigDecimal getParameter3() {
		return this.parameter3;
	}

	public void setParameter3(BigDecimal parameter3) {
		this.parameter3 = parameter3;
	}

	@Column(name = "PARAMETER4", precision = 8, scale = 4)
	public BigDecimal getParameter4() {
		return this.parameter4;
	}

	public void setParameter4(BigDecimal parameter4) {
		this.parameter4 = parameter4;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "PARAMETER5", length = 13)
	public Date getParameter5() {
		return this.parameter5;
	}

	public void setParameter5(Date parameter5) {
		this.parameter5 = parameter5;
	}

	@Column(name = "CREATED_BY", nullable = false)
	public long getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(long createBy) {
		this.createdBy = createBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE", nullable = false, length = 29)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createDate) {
		this.createdDate = createDate;
	}

	@Column(name = "UPDATED_BY")
	public Long getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(Long updateBy) {
		this.updatedBy = updateBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATED_DATE", nullable = false, length = 29)
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updateDate) {
		this.updatedDate = updateDate;
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
