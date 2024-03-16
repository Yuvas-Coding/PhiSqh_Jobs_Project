package my.com.cmg.iwp.maintenance.model;

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
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "T_PO_CF_DTL")
public class PoCfDtl implements java.io.Serializable {
	private Long poDtlSeqno;
	private Item item;
	private PoCfHdr poCfHdr;
	private Double amount;
	private Character activeFlag;
	private Long createdBy;
	private Date createdDate;
	private Long updatedBy;
	private Date updatedDate;
	private String votecode;
	private String votename;
	private String budgetType;
	private CBMaster cbMaster;
	private VoteCode voteCode;
	private NePVote nePVote;
	private VoteCode newVoteCode;
	private CBMaster newCurrentBudgetMaster;
	private String facilityCode;
	private String ptjCode;


	@Transient
	public String getVotename() {
		return votename;
	}

	public void setVotename(String votename) {
		this.votename = votename;
	}

	
	@Id
	@Column(name = "po_dtl_seqno", unique = true, nullable = false)
	@SequenceGenerator(name = "ph_po_cfdtl_seq", sequenceName = "t_po_cfdtl_seq", allocationSize = 1)
	@GeneratedValue(generator = "ph_po_cfdtl_seq")
	public Long getPoDtlSeqno() {
		return this.poDtlSeqno;
	}

	public void setPoDtlSeqno(Long poDtlSeqno) {
		this.poDtlSeqno = poDtlSeqno;
	}

	@Column(name = "amount", nullable = false, precision = 15, scale = 4)
	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Column(name = "active_flag", nullable = false, length = 1)
	public Character getActiveFlag() {
		return this.activeFlag;
	}

	public void setActiveFlag(Character activeFlag) {
		this.activeFlag = activeFlag;
	}

	@Column(name = "created_by", nullable = false, insertable=true, updatable=true)
	public Long getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", nullable = false, length = 50)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "updated_by", insertable=true, updatable=true)
	public Long getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_date", nullable = false, length = 50)
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "item_seqno", insertable=true, updatable=true, nullable=false)
	public Item getItem() {
		return item;
	}

	public void setItem(Item items) {
		this.item = items;
	}
	@Column(name = "VOTE_CODE")
	public String getVotecode() {
		return votecode;
	}	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "po_hdr_seqno", nullable = false)
	public PoCfHdr getPoCfHdr() {
		return poCfHdr;
	}

	public void setPoCfHdr(PoCfHdr poCfHdr) {
		this.poCfHdr = poCfHdr;
	}

	public void setVotecode(String votecode) {
		this.votecode = votecode;
	}

	@Column(name = "BUDGET_TYPE")
	public String getBudgetType() {
		return budgetType;
	}

	public void setBudgetType(String budgetType) {
		this.budgetType = budgetType;
	}


	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "CB_MSTR_SEQNO")
	public CBMaster getCbMaster() {
		return cbMaster;
	}

	public void setCbMaster(CBMaster cbMaster) {
		this.cbMaster = cbMaster;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="vot_seqno")
	public NePVote getNePVote() {
		return nePVote;
	}

	public void setNePVote(NePVote nePVote) {
		this.nePVote = nePVote;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="new_vote_seqno")
	public VoteCode getNewVoteCode() {
		return newVoteCode;
	}

	public void setNewVoteCode(VoteCode newVoteCode) {
		this.newVoteCode = newVoteCode;
	}


	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="cb_mstr_seqno_new")
	public CBMaster getNewCurrentBudgetMaster() {
		return newCurrentBudgetMaster;
	}

	public void setNewCurrentBudgetMaster(CBMaster newCurrentBudgetMaster) {
		this.newCurrentBudgetMaster = newCurrentBudgetMaster;
	}


	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "VOTE_SEQNO")
	public VoteCode getVoteCode() {
		return voteCode;
	}

	public void setVoteCode(VoteCode voteCode) {
		this.voteCode = voteCode;
	}	
	private SecUser createdUser;
	private SecUser updatedUser;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "updated_by", insertable = false, updatable = false)
	@JsonIgnore
	public SecUser getUpdatedUser() {
		return this.updatedUser;
	}

	public void setUpdatedUser(SecUser updatedUser) {
		this.updatedUser = updatedUser;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "created_by", insertable = false, updatable = false)
	@JsonIgnore
	public SecUser getCreatedUser() {
		return this.createdUser;
	}

	public void setCreatedUser(SecUser createdUser) {
		this.createdUser = createdUser;
	}

	@Column(name="facility_code")
	public String getFacilityCode() {
		return facilityCode;
	}
	
	public void setFacilityCode(String facilityCode) {
		this.facilityCode = facilityCode;
	}


	@Column(name="ptj_code")
	public String getPtjCode() {
		return ptjCode;
	}

	public void setPtjCode(String ptjCode) {
		this.ptjCode = ptjCode;
	}
	
}
