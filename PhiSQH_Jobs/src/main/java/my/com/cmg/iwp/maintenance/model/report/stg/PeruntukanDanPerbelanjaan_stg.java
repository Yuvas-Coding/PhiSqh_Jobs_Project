package my.com.cmg.iwp.maintenance.model.report.stg;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_PRUNTUKN_DA_PRBEL_STG")
public class PeruntukanDanPerbelanjaan_stg implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public long seqno;
	public String votecode;
	public Double allocation_ded_amt;
	public Double current_uti_amt;
	public Double current_lia_amt;
	public Double current_actual_amt;
	public Double total_drug_amt;
	public Double viramintOut;
	public long created_by;
	public String session_id;
	public String drug_nond_flag;
	public String facilityName;
	public String activityCode;
	public String pendingAmount;
	
	
	@Id
	@Column(name = "Peruntukan_Dan_Perbel_SEQNO", nullable = false, unique = true)
	public long getSeqno() {
		return seqno;
	}
	public void setSeqno(long seqno) {
		this.seqno = seqno;
	}
	
	@Column(name = "VOTE_OBJECT_CODE")
	public String getVotecode() {
		return votecode;
	}
	public void setVotecode(String votecode) {
		this.votecode = votecode;
	}
	
	@Column(name = "ALLOCATION_DEDUCTION_AMOUNT")
	public Double getAllocation_ded_amt() {
		return allocation_ded_amt;
	}
	public void setAllocation_ded_amt(Double allocation_ded_amt) {
		this.allocation_ded_amt = allocation_ded_amt;
	}
	
	@Column(name = "CURRENT_UTILIZED_AMOUNT")
	public Double getCurrent_uti_amt() {
		return current_uti_amt;
	}
	public void setCurrent_uti_amt(Double current_uti_amt) {
		this.current_uti_amt = current_uti_amt;
	}
	
	@Column(name = "CURRENT_LIABILITY_AMOUNT")
	public Double getCurrent_lia_amt() {
		return current_lia_amt;
	}
	public void setCurrent_lia_amt(Double current_lia_amt) {
		this.current_lia_amt = current_lia_amt;
	}
	
	@Column(name = "CURRENT_ACTUAL_AMOUNT")
	public Double getCurrent_actual_amt() {
		return current_actual_amt;
	}
	public void setCurrent_actual_amt(Double current_actual_amt) {
		this.current_actual_amt = current_actual_amt;
	}
	
	@Column(name = "TOTAL_DRUG_AMOUNT")
	public Double getTotal_drug_amt() {
		return total_drug_amt;
	}
	public void setTotal_drug_amt(Double total_drug_amt) {
		this.total_drug_amt = total_drug_amt;
	}
	
	@Column(name = "CREATED_BY")
	public long getCreated_by() {
		return created_by;
	}
	public void setCreated_by(long created_by) {
		this.created_by = created_by;
	}
	
	@Column(name = "SESSION_ID")
	public String getSession_id() {
		return session_id;
	}
	public void setSession_id(String session_id) {
		this.session_id = session_id;
	}
	
	@Column(name = "DRUG_NONDRUG_FLAG")
	public String getDrug_nond_flag() {
		return drug_nond_flag;
	}
	public void setDrug_nond_flag(String drug_nond_flag) {
		this.drug_nond_flag = drug_nond_flag;
	}
	
	@Column(name="facility_name")
	public String getFacilityName() {
		return facilityName;
	}
	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}
	
	@Column(name="activity_name")
	public String getActivityCode() {
		return activityCode;
	}
	public void setActivityCode(String activityCode) {
		this.activityCode = activityCode;
	}
	
	@Column(name="pending_amount")
	public String getPendingAmount() {
		return pendingAmount;
	}
	public void setPendingAmount(String pendingAmount) {
		this.pendingAmount = pendingAmount;
	}
	
	@Column(name="viremint_out")
	public Double getViramintOut() {
		return viramintOut;
	}
	public void setViramintOut(Double viramintOut) {
		this.viramintOut = viramintOut;
	}
	
}
