package my.com.cmg.iwp.maintenance.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "t_ep_vot", uniqueConstraints = @UniqueConstraint(columnNames = "kod_vot"))
public class NePVote implements Serializable {

	private static final long serialVersionUID = 1L;
	private long voteSeqno;
	private int financialYear;
	private String voteCode;
	private String voteGroup;
	private String voteDescription;
	private Character voteStatus;
	private Character isAllowedInPhis;
	private Date createdDate;
	private Long createdBy;
	private Date updatedDate;
	private Long updatedBy;
	private Character activeFlag = 'A';		
	private List<VoteActivity> voteActivity;
	private List<VoteCode> voteCodes;
	private Character defaultYn = 'N';
	@Id
	@Column(name = "vot_seqno", unique = true, nullable = false)	
	@SequenceGenerator(name = "ph_ep_vot_seq", sequenceName = "t_ep_vot_seq", allocationSize = 1)
	@GeneratedValue(generator = "ph_ep_vot_seq")	
	public long getVoteSeqno() {
		return voteSeqno;
	}
	public void setVoteSeqno(long voteSeqno) {
		this.voteSeqno = voteSeqno;
	}
	
	@Column(name = "tahun_kewangan", length = 5)	
	public int getFinancialYear() {
		return financialYear;
	}
	public void setFinancialYear(int financialYear) {
		this.financialYear = financialYear;
	}
	
	@Column(name = "kod_vot", length = 5)	
	public String getVoteCode() {
		return voteCode;
	}
	public void setVoteCode(String voteCode) {
		this.voteCode = voteCode;
	}
	
	@Column(name = "group_vot", length = 3)	
	public String getVoteGroup() {
		return voteGroup;
	}
	public void setVoteGroup(String voteGroup) {
		this.voteGroup = voteGroup;
	}
	
	@Column(name = "perihal", length = 260)	
	public String getVoteDescription() {
		return voteDescription;
	}
	public void setVoteDescription(String voteDescription) {
		this.voteDescription = voteDescription;
	}
	
	@Column(name = "status_kod", length = 1)	
	public Character getVoteStatus() {
		return voteStatus;
	}
	public void setVoteStatus(Character voteStatus) {
		this.voteStatus = voteStatus;
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
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "nepVote")
	public List<VoteActivity> getVoteActivity() {
		return voteActivity;
	}
	public void setVoteActivity(List<VoteActivity> voteActivity) {
		this.voteActivity = voteActivity;
	}		
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "nePVote")
	public List<VoteCode> getVoteCodes() {
		return voteCodes;
	}
	public void setVoteCodes(List<VoteCode> voteCodes) {
		this.voteCodes = voteCodes;
	}
	
	@Column(name = "default_yn")
	public Character getDefaultYn() {
		return defaultYn;
	}
	public void setDefaultYn(Character defaultYn) {
		this.defaultYn = defaultYn;
	}
}
