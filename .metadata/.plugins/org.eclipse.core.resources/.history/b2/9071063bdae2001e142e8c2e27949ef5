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
@Table(name = "t_ep_projek", uniqueConstraints = @UniqueConstraint(columnNames = "kod_projek"))
public class NePProject implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private long projectSeqno;
	private int financialYear;
	private String projectCode;
	private String projectGroup;
	private String projectDescription;
	private Character statusCode;
	private Character isAllowedInPhis;
	private Date createdDate;
	private Long createdBy;
	private Date updatedDate;
	private Long updatedBy;
	private Character activeFlag = 'A';	
	private List<VoteActivity> voteActivity;
	
	
	@Id
	@Column(name = "projek_seqno", unique = true, nullable = false)	
	@SequenceGenerator(name = "ph_ep_projek_seq", sequenceName = "t_ep_projek_seq", allocationSize = 1)
	@GeneratedValue(generator = "ph_ep_projek_seq")	
	public long getProjectSeqno() {
		return projectSeqno;
	}
	public void setProjectSeqno(long projectSeqno) {
		this.projectSeqno = projectSeqno;
	}
	
	@Column(name = "tahun_kewangan", length = 5)	
	public int getFinancialYear() {
		return financialYear;
	}
	public void setFinancialYear(int financialYear) {
		this.financialYear = financialYear;
	}
	
	@Column(name = "kod_projek", length = 16)	
	public String getProjectCode() {
		return projectCode;
	}
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	
	@Column(name = "group_projek", length = 3)	
	public String getProjectGroup() {
		return projectGroup;
	}
	public void setProjectGroup(String projectGroup) {
		this.projectGroup = projectGroup;
	}
	
	@Column(name = "perihal", length = 260)	
	public String getProjectDescription() {
		return projectDescription;
	}
	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}
	
	@Column(name = "status_kod", length = 1)	
	public Character getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Character statusCode) {
		this.statusCode = statusCode;
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
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "nepProject")
	public List<VoteActivity> getVoteActivity() {
		return voteActivity;
	}
	public void setVoteActivity(List<VoteActivity> voteActivity) {
		this.voteActivity = voteActivity;
	}			
}

