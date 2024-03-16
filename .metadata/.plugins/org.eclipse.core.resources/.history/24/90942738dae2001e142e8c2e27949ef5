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
@Table(name = "t_ep_program", uniqueConstraints = @UniqueConstraint(columnNames = "kod_program"))
public class NePProgram implements Serializable {

	private static final long serialVersionUID = 1L;
	private long programSeqno;
	private int financialYear;
	private String programCode;
	private String programGroup;
	private String programDescription;
	private Character statusCode;
	private Character isAllowedInPhis;
	private Date createdDate;
	private Long createdBy;
	private Date updatedDate;
	private Long updatedBy;
	private Character activeFlag = 'A';	
	private List<VoteActivity> voteActivity;
	
	@Id
	@Column(name = "program_seqno", unique = true, nullable = false)	
	@SequenceGenerator(name = "ph_ep_program_seq", sequenceName = "t_ep_program_seq", allocationSize = 1)
	@GeneratedValue(generator = "ph_ep_program_seq")	
	public long getProgramSeqno() {
		return programSeqno;
	}
	public void setProgramSeqno(long programSeqno) {
		this.programSeqno = programSeqno;
	}
	
	@Column(name = "tahun_kewangan", length = 5)	
	public int getFinancialYear() {
		return financialYear;
	}
	public void setFinancialYear(int financialYear) {
		this.financialYear = financialYear;
	}
	
	@Column(name = "kod_program", length = 9)	
	public String getProgramCode() {
		return programCode;
	}
	public void setProgramCode(String programCode) {
		this.programCode = programCode;
	}
	
	@Column(name = "group_program", length = 3)	
	public String getProgramGroup() {
		return programGroup;
	}
	public void setProgramGroup(String programGroup) {
		this.programGroup = programGroup;
	}
	
	@Column(name = "perihal", length = 260)	
	public String getProgramDescription() {
		return programDescription;
	}
	public void setProgramDescription(String programDescription) {
		this.programDescription = programDescription;
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
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "nepProgram")
	public List<VoteActivity> getVoteActivity() {
		return voteActivity;
	}
	public void setVoteActivity(List<VoteActivity> voteActivity) {
		this.voteActivity = voteActivity;
	}
	
}
