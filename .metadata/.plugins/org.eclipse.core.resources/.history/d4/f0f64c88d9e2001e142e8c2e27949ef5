package my.com.cmg.iwp.maintenance.model;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "T_SPL_DRUG_APPROVERS_IMAGES")
public class SplDrugReqApproverImages implements java.io.Serializable {
	private static final long serialVersionUID = 846454440645312712L;
	
	private long reqImageSeqno  = Long.MIN_VALUE;
	private SplDrugReqApprover drugReqApprover;
	private byte[] reqImageData;
	private String reqImageName;
	private long createdBy;
	private Date createdDate;
	private long updatedBy;
	private Date updatedDate;
	
	
	
	public SplDrugReqApproverImages(long reqImageSeqno, SplDrugReqApprover drugReqApprover, byte[] reqImageData,
			String reqImageName, long createdBy, Date createdDate,
			long updatedBy, Date updatedDate) {
		super();
		this.reqImageSeqno = reqImageSeqno;
		this.drugReqApprover = drugReqApprover;
		this.reqImageData=reqImageData;
		this.reqImageName=reqImageName;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
	}
	
	public SplDrugReqApproverImages() {
	}

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "drugReqApprover"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "REQ_ITEM_SEQNO")
	public long getReqImageSeqno() {
		return reqImageSeqno;
	}

	public void setReqImageSeqno(long reqImageSeqno) {
		this.reqImageSeqno = reqImageSeqno;
	}
	
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public SplDrugReqApprover getDrugReqApprover() {
		return drugReqApprover;
	}

	public void setDrugReqApprover(SplDrugReqApprover drugReqApprover) {
		this.drugReqApprover = drugReqApprover;
	}
	
	@Column(name = "req_Image_Data", length = 200)
	public byte[] getReqImageData() {
		return reqImageData;
	}

	public void setReqImageData(byte[] reqImageData) {
		this.reqImageData = reqImageData;
	}

	
	@Column(name = "req_Image_Name", length = 100)
	public String getReqImageName() {
		return reqImageName;
	}

	public void setReqImageName(String reqImageName) {
		this.reqImageName = reqImageName;
	}
	
	@Column(name = "created_by", nullable = false)
	public long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", nullable = false, length = 29)
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	@Column(name = "updated_by", nullable = false)
	public long getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(long updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_date", nullable = false, length = 29)
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
}