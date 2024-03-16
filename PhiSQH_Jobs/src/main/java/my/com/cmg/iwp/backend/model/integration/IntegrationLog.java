package my.com.cmg.iwp.backend.model.integration;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_HQ_INTEGRATION_LOG")
public class IntegrationLog {

	private long batchNo = Long.MIN_VALUE;
	private String moduleCode;
	private String status;
	private Date startDate;
	private Date endDate;
	private int recordCount;
	private String errorMsg;
	private String remarks;
	private long createdBy;
	private Date createdDate;

	public IntegrationLog() {

	}

	public IntegrationLog(long batchNo, String moduleCode, String status, Date startDate, Date endDate, int recordCount, String errorMsg, String remarks, long createdBy, Date createdDate) {
		super();
		this.batchNo = batchNo;
		this.moduleCode = moduleCode;
		this.status = status;
		this.startDate = startDate;
		this.endDate = endDate;
		this.recordCount = recordCount;
		this.errorMsg = errorMsg;
		this.remarks = remarks;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
	}

	
	
	
	
	@Id
	@Column(name = "HQIL_batch_no", unique = true, nullable = false)
	@SequenceGenerator(name = "drug_int_seqno", sequenceName = "T_INTEGRATION_LOG_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "drug_int_seqno")
	public long getBatchNo() {
		return batchNo;
	}
	

	public void setBatchNo(long batchNo) {
		this.batchNo = batchNo;
	}

	@Column(name = "HQIL_module_code")
	public String getModuleCode() {
		return moduleCode;
	}

	public void setModuleCode(String moduleCode) {
		this.moduleCode = moduleCode;
	}

	@Column(name = "HQIL_status")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "HQIL_sync_start_date", length = 29)
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "HQIL_sync_end_date", length = 29)
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Column(name = "HQIL_sync_record_count")
	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	@Column(name = "HQIL_error_msg")
	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	@Column(name = "HQIL_remarks")
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Column(name = "HQIL_created_by")
	public long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "HQIL_created_date", length = 29)
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

}
