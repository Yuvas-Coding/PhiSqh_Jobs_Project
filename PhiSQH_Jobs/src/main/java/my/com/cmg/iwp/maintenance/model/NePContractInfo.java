package my.com.cmg.iwp.maintenance.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "t_ep_contract_info", uniqueConstraints = @UniqueConstraint(columnNames = "ep_contract_no"))
public class NePContractInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	long contractSeqNo;
	String action;
	String ePContractNo;
	String physicalContractNo;
	Date effectiveDate;
	Date expiredDate;
	int contractStatus;
	int isZonal;
	String noZonal;
	int numberOfItem;
	Character isAllowedInPhis;
	private Date createdDate;
	private Long createdBy;
	private Date updatedDate;
	private Long updatedBy;
	private Character activeFlag = 'A';		

	@Id
	@Column(name = "contract_seqno", unique = true, nullable = false)	
	@SequenceGenerator(name = "ph_ep_contract_info_seq", sequenceName = "t_ep_contract_info_seq", allocationSize = 1)
	@GeneratedValue(generator = "ph_ep_contract_info_seq")		
	public long getContractSeqNo() {
		return contractSeqNo;
	}

	public void setContractSeqNo(long contractSeqNo) {
		this.contractSeqNo = contractSeqNo;
	}

	@Column(name = "action", length = 3)	
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	@Column(name = "ep_contract_no", length = 17)
	public String getePContractNo() {
		return ePContractNo;
	}

	public void setePContractNo(String ePContractNo) {
		this.ePContractNo = ePContractNo;
	}

	@Column(name = "physical_contract_no", length = 30)
	public String getPhysicalContractNo() {
		return physicalContractNo;
	}

	public void setPhysicalContractNo(String physicalContractNo) {
		this.physicalContractNo = physicalContractNo;
	}

	@Column(name = "effective_date")
	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	@Column(name = "expired_date")	
	public Date getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(Date expiredDate) {
		this.expiredDate = expiredDate;
	}

	@Column(name = "contract_status")	
	public int getContractStatus() {
		return contractStatus;
	}

	public void setContractStatus(int contractStatus) {
		this.contractStatus = contractStatus;
	}

	@Column(name = "iszonal")
	public int getIsZonal() {
		return isZonal;
	}

	public void setIsZonal(int isZonal) {
		this.isZonal = isZonal;
	}

	@Column(name = "nozonal")	
	public String getNoZonal() {
		return noZonal;
	}

	public void setNoZonal(String noZonal) {
		this.noZonal = noZonal;
	}

	@Column(name = "no_of_item")	
	public int getNumberOfItem() {
		return numberOfItem;
	}

	public void setNumberOfItem(int numberOfItem) {
		this.numberOfItem = numberOfItem;
	}

	@Column(name = "is_allowed")	
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

}
