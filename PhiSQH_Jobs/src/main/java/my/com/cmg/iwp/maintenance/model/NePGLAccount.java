package my.com.cmg.iwp.maintenance.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Cascade;


@Entity
@Table(name = "t_ep_akaun", uniqueConstraints = @UniqueConstraint(columnNames = "kod_akaun_gl"))
public class NePGLAccount implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private long accountSeqNo;
	private int financialYear;
	private String accountCode;
	private String accountDescription;
	private String satusCode;
	private String ptjCode;
	private Character isAllowedInPhis;
	private Date createdDate;
	private Long createdBy;
	private Date updatedDate;
	private Long updatedBy;
	private Character activeFlag = 'A';		
	private List<VoteObject> voteObject;
	private Set<VoteObjAccounts> voteObjAccounts = new HashSet<VoteObjAccounts>(0);
	
	@Id
	@Column(name = "akaun_seqno", unique = true, nullable = false)	
	@SequenceGenerator(name = "ph_ep_akaun_seq", sequenceName = "t_ep_akaun_seq", allocationSize = 1)
	@GeneratedValue(generator = "ph_ep_akaun_seq")	
	public long getAccountSeqNo() {
		return accountSeqNo;
	}
	public void setAccountSeqNo(long accountSeqNo) {
		this.accountSeqNo = accountSeqNo;
	}
	
	@Column(name = "tahun_kewangan", length = 5)	
	public int getFinancialYear() {
		return financialYear;
	}
	public void setFinancialYear(int financialYear) {
		this.financialYear = financialYear;
	}
	
	@Column(name = "kod_akaun_gl", length = 8)	
	public String getAccountCode() {
		return accountCode;
	}
	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}
	
	@Column(name = "perihal", length = 260)	
	public String getAccountDescription() {
		return accountDescription;
	}
	public void setAccountDescription(String accountDescription) {
		this.accountDescription = accountDescription;
	}
	
	@Column(name = "status_kod", length = 1) 	
	public String getSatusCode() {
		return satusCode;
	}
	public void setSatusCode(String satusCode) {
		this.satusCode = satusCode;
	}
	
	@Column(name = "kod_kump_ptj", length = 2)	
	public String getPtjCode() {
		return ptjCode;
	}
	public void setPtjCode(String ptjCode) {
		this.ptjCode = ptjCode;
	}
	
	@Column(name = "is_allowed", length = 1)	
	public Character getIsAllowedInPhis() {
		return isAllowedInPhis;
	}
	public void setIsAllowedInPhis(Character isAllowedInPhis) {
		this.isAllowedInPhis = isAllowedInPhis;
	}

	@Column(name = "created_date")	
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	@Column(name = "created_by")	
	public Long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	
	@Column(name = "updated_date")	
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	@Column(name = "updated_by")	
	public Long getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	@Column(name = "active_flag")	
	public Character getActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(Character activeFlag) {
		this.activeFlag = activeFlag;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "nePGLAccount")
	public List<VoteObject> getVoteObject() {
		return voteObject;
	}
	public void setVoteObject(List<VoteObject> voteObject) {
		this.voteObject = voteObject;
	}	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "nePGLAccount",cascade=CascadeType.ALL)
	@Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE,
		org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
	public Set<VoteObjAccounts> getVoteObjAccounts() {
		return voteObjAccounts;
	}

	public void setVoteObjAccounts(Set<VoteObjAccounts> voteObjAccounts) {
		this.voteObjAccounts = voteObjAccounts;
	}
}
