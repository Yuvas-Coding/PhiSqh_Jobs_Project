package my.com.cmg.iwp.backend.model.inventory.reports.budget;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "t_perincian_mengikut_stg")
public class PerincianMengikutObjekLanjutStg implements java.io.Serializable {

	private long perincianMengikutSeqno;
	private String voteCode;
	private String voteName;
	private String voteObjectCode;
	private String voteActivityCode;
	private BigDecimal currentAallocationAmount;
	private long createdBy;
	private String sessionId;
	private String facilityName;
	private String remarks;

	public PerincianMengikutObjekLanjutStg() {
	}

	public PerincianMengikutObjekLanjutStg(long perincianMengikutSeqno, long createdBy) {
		this.perincianMengikutSeqno = perincianMengikutSeqno;
		this.createdBy = createdBy;
	}

	public PerincianMengikutObjekLanjutStg(long perincianMengikutSeqno,
			String voteObjectCode, String voteCode, String voteName,
			String voteActivityCode, BigDecimal currentAallocationAmount,
			long createdBy, String sessionId) {
		this.perincianMengikutSeqno = perincianMengikutSeqno;
		this.voteObjectCode = voteObjectCode;
		this.voteCode = voteCode;
		this.voteName = voteName;
		this.voteActivityCode = voteActivityCode;
		this.currentAallocationAmount = currentAallocationAmount;
		this.createdBy = createdBy;
		this.sessionId = sessionId;
	}

	@Id
	@Column(name = "tl_perincian_mengikut_seqno", unique = true, nullable = false)
	@SequenceGenerator(name = "t_perincian_mengikut_stg_seq", sequenceName = "t_perincian_mengikut_stg_seq", allocationSize = 1)
	public long getPerincianMengikutSeqno() {
		return perincianMengikutSeqno;
	}

	public void setPerincianMengikutSeqno(long perincianMengikutSeqno) {
		this.perincianMengikutSeqno = perincianMengikutSeqno;
	}

	@Column(name = "tl_vote_code", length = 33)
	public String getVoteCode() {
		return voteCode;
	}

	public void setVoteCode(String voteCode) {
		this.voteCode = voteCode;
	}

	@Column(name = "tl_vote_name", length = 50)
	public String getVoteName() {
		return voteName;
	}

	public void setVoteName(String voteName) {
		this.voteName = voteName;
	}

	@Column(name = "tl_vote_object_code", length = 6)
	public String getVoteObjectCode() {
		return voteObjectCode;
	}

	public void setVoteObjectCode(String voteObjectCode) {
		this.voteObjectCode = voteObjectCode;
	}

	@Column(name = "tl_vote_activity_code", length = 6)
	public String getVoteActivityCode() {
		return voteActivityCode;
	}

	public void setVoteActivityCode(String voteActivityCode) {
		this.voteActivityCode = voteActivityCode;
	}

	@Column(name = "tl_current_allocation_amount", precision = 15, scale = 4)
	public BigDecimal getCurrentAallocationAmount() {
		return currentAallocationAmount;
	}

	public void setCurrentAallocationAmount(BigDecimal currentAallocationAmount) {
		this.currentAallocationAmount = currentAallocationAmount;
	}

	@Column(name = "tl_created_by", nullable = false)
	public long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "tl_session_id", length = 50)
	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	@Transient
	public String getFacilityName() {
		return facilityName;
	}

	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}

	@Column(name = "tl_remarks", length = 100)
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
