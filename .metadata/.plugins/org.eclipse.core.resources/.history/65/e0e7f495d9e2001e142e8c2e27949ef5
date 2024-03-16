package my.com.cmg.iwp.maintenance.model.adjustment;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import my.com.cmg.iwp.maintenance.model.CBMaster;
import my.com.cmg.iwp.maintenance.model.GetterBaseEntity;
import my.com.cmg.iwp.maintenance.model.VoteCode;

@Entity
@Table(name = "t_budget_adj_hdr")
public class BudgetAdjHdr  extends GetterBaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long budgetAdjSeqno;
	private String ptjCode;
	private String facilityCodeFrom;
	private String facilityCodeTo;
	private CBMaster adjFromSeqno;
	private CBMaster adjToSeqno;
	private String adjustmentNo;
	private Double adjustmentAmount;
	private String remarks;
	private String referenceNo;
	private String transactionStatus;
	private String budgetTypeFrom;
	private String budgetTypeTo;
	private VoteCode voteCode;
	private VoteCode toVoteCode;
	private Integer financialYear;
	private Double fromCurrentBalance;
	private Double fromNewBalance;
	private Double fromCurrentUtilized;
	private Double fromNewUtilizedBalance;
	private Double toCurrentUtilized;
	private Double toNewUtilizedBalance;
	private Double toCurrentBalance;
	private Double toNewBalance;
	private String rejectremarks;
	private String lpoNo;
	private String bdgtAdjType;
	private Set<BudgetAdjDtl> budgetAdjDtls = new HashSet<BudgetAdjDtl>(0);
	
	public BudgetAdjHdr(){}
	
	public BudgetAdjHdr(Long budgetAdjSeqno, String ptjCode, String facilityCodeFrom, String facilityCodeTo,
			CBMaster adjFromSeqno, CBMaster adjToSeqno, String adjustmentNo, Double adjustmentAmount, String remarks,
			String referenceNo, String transactionStatus, String budgetTypeFrom, String budgetTypeTo, VoteCode voteCode,
			VoteCode toVoteCode, Integer financialYear, Double fromCurrentBalance, Double fromNewBalance,
			Double toCurrentBalance, Double toNewBalance, String rejectremarks, String lpoNo) {
		super();
		this.budgetAdjSeqno = budgetAdjSeqno;
		this.ptjCode = ptjCode;
		this.facilityCodeFrom = facilityCodeFrom;
		this.facilityCodeTo = facilityCodeTo;
		this.adjFromSeqno = adjFromSeqno;
		this.adjToSeqno = adjToSeqno;
		this.adjustmentNo = adjustmentNo;
		this.adjustmentAmount = adjustmentAmount;
		this.remarks = remarks;
		this.referenceNo = referenceNo;
		this.transactionStatus = transactionStatus;
		this.budgetTypeFrom = budgetTypeFrom;
		this.budgetTypeTo = budgetTypeTo;
		this.voteCode = voteCode;
		this.toVoteCode = toVoteCode;
		this.financialYear = financialYear;
		this.fromCurrentBalance = fromCurrentBalance;
		this.fromNewBalance = fromNewBalance;
		this.toCurrentBalance = toCurrentBalance;
		this.toNewBalance = toNewBalance;
		this.rejectremarks = rejectremarks;
		this.lpoNo = lpoNo;
	}

	@Id
	@Column(name = "budget_adj_seqno", unique = true, nullable = false)
	@SequenceGenerator(name = "t_budget_adj_hdr_seq", sequenceName = "t_budget_adj_hdr_seq", allocationSize = 1)
	@GeneratedValue(generator = "t_budget_adj_hdr_seq")
	public Long getBudgetAdjSeqno() {
		return budgetAdjSeqno;
	}

	public void setBudgetAdjSeqno(Long budgetAdjSeqno) {
		this.budgetAdjSeqno = budgetAdjSeqno;
	}

	@Column(name = "FROM_CURRENT_BALANCE", precision = 15, scale = 4)
	public Double getFromCurrentBalance() {
		return fromCurrentBalance;
	}

	public void setFromCurrentBalance(Double fromCurrentBalance) {
		this.fromCurrentBalance = fromCurrentBalance;
	}

	@Column(name = "FROM_NEW_BALANCE", precision = 15, scale = 4)
	public Double getFromNewBalance() {
		return fromNewBalance;
	}

	public void setFromNewBalance(Double fromNewBalance) {
		this.fromNewBalance = fromNewBalance;
	}
	
	@Column(name = "TO_CURRENT_BALANCE", precision = 15, scale = 4)
	public Double getToCurrentBalance() {
		return toCurrentBalance;
	}

	public void setToCurrentBalance(Double toCurrentBalance) {
		this.toCurrentBalance = toCurrentBalance;
	}

	@Column(name = "TO_NEW_BALANCE", precision = 15, scale = 4)
	public Double getToNewBalance() {
		return toNewBalance;
	}

	public void setToNewBalance(Double toNewBalance) {
		this.toNewBalance = toNewBalance;
	}

	@Column(name = "finacial_year")
	public Integer getFinancialYear() {
		return this.financialYear;
	}

	public void setFinancialYear(Integer financialYear) {
		this.financialYear = financialYear;
	}
	
	@Column(name = "budget_type_from", length = 20)
	public String getBudgetTypeFrom() {
		return this.budgetTypeFrom;
	}
	
	public void setBudgetTypeFrom(String budgetTypeFrom) {
		this.budgetTypeFrom = budgetTypeFrom;
	}
	

	@Column(name = "budget_type_to", length = 20)
	public String getBudgetTypeTo() {
		return this.budgetTypeTo;
	}
	
	public void setBudgetTypeTo(String budgetTypeTo) {
		this.budgetTypeTo = budgetTypeTo;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "vote_seqno")
	public VoteCode getVoteCode() {
		return voteCode;
	}

	public void setVoteCode(VoteCode voteCode) {
		this.voteCode = voteCode;
	}
	

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ADJ_FROM_SEQNO")
	public CBMaster getAdjFromSeqno() {
		return this.adjFromSeqno;
	}

	public void setAdjFromSeqno(CBMaster adjFromSeqno) {
		this.adjFromSeqno = adjFromSeqno;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "TO_VOTE_SEQNO")
	public VoteCode getToVoteCode() {
		return toVoteCode;
	}

	public void setToVoteCode(VoteCode toVoteCode) {
		this.toVoteCode = toVoteCode;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ADJ_TO_SEQNO")
	public CBMaster getAdjToSeqno() {
		return this.adjToSeqno;
	}

	public void setAdjToSeqno(CBMaster adjToSeqno) {
		this.adjToSeqno = adjToSeqno;
	}

	@Column(name = "adjustment_no", nullable = false, length = 20)
	public String getAdjustmentNo() {
		return this.adjustmentNo;
	}

	public void setAdjustmentNo(String adjustmentNo) {
		this.adjustmentNo = adjustmentNo;
	}

	@Column(name = "source_ptj_code", nullable = false, length = 20)
	public String getPtjCode() {
		return ptjCode;
	}

	public void setPtjCode(String ptjCode) {
		this.ptjCode = ptjCode;
	}

	@Column(name = "adjustment_amount", precision = 15, scale = 4)
	public Double getAdjustmentAmount() {
		return this.adjustmentAmount;
	}

	public void setAdjustmentAmount(Double adjustmentAmount) {
		this.adjustmentAmount = adjustmentAmount;
	}

	@Column(name = "remarks", length = 50)
	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Column(name = "reference_no", length = 20)
	public String getReferenceNo() {
		return this.referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	@Column(name = "facility_code", nullable = false, length = 20)
	public String getFacilityCodeFrom() {
		return facilityCodeFrom;
	}

	public void setFacilityCodeFrom(String facilityCodeFrom) {
		this.facilityCodeFrom = facilityCodeFrom;
	}

	@Column(name = "facility_codeTo", nullable = false, length = 20)
	public String getFacilityCodeTo() {
		return facilityCodeTo;
	}
	public void setFacilityCodeTo(String facilityCodeTo) {
		this.facilityCodeTo = facilityCodeTo;
	}
	
	@Column(name = "transaction_status", length = 20)
	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}
	
	@Column(name = "reject_remark", length = 500)
	public String getRejectremarks() {
		return rejectremarks;
	}

	public void setRejectremarks(String rejectremarks) {
		this.rejectremarks = rejectremarks;
	}
	
	@Column(name="lpo_no")
	public String getLpoNo() {
		return lpoNo;
	}

	public void setLpoNo(String lpoNo) {
		this.lpoNo = lpoNo;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "budgetAdjHdr", cascade = CascadeType.ALL)
	public Set<BudgetAdjDtl> getBudgetAdjDtls() {
		return budgetAdjDtls;
	}

	public void setBudgetAdjDtls(Set<BudgetAdjDtl> budgetAdjDtls) {
		this.budgetAdjDtls = budgetAdjDtls;
	}

	@Column(name="bdgt_adj_type")
	public String getBdgtAdjType() {
		return bdgtAdjType;
	}

	public void setBdgtAdjType(String bdgtAdjType) {
		this.bdgtAdjType = bdgtAdjType;
	}

	@Column(name = "FROM_CURRENT_UTILIZED", precision = 15, scale = 4)
	public Double getFromCurrentUtilized() {
		return fromCurrentUtilized;
	}

	public void setFromCurrentUtilized(Double fromCurrentUtilized) {
		this.fromCurrentUtilized = fromCurrentUtilized;
	}

	@Column(name = "FROM_NEW_UTILIZED", precision = 15, scale = 4)
	public Double getFromNewUtilizedBalance() {
		return fromNewUtilizedBalance;
	}

	public void setFromNewUtilizedBalance(Double fromNewUtilizedBalance) {
		this.fromNewUtilizedBalance = fromNewUtilizedBalance;
	}

	@Column(name = "TO_CURRENT_UTILIZED", precision = 15, scale = 4)
	public Double getToCurrentUtilized() {
		return toCurrentUtilized;
	}

	public void setToCurrentUtilized(Double toCurrentUtilized) {
		this.toCurrentUtilized = toCurrentUtilized;
	}

	@Column(name = "TO_NEW_UTILIZED", precision = 15, scale = 4)
	public Double getToNewUtilizedBalance() {
		return toNewUtilizedBalance;
	}

	public void setToNewUtilizedBalance(Double toNewUtilizedBalance) {
		this.toNewUtilizedBalance = toNewUtilizedBalance;
	}	
	
}