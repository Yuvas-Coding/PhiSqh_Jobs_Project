package my.com.cmg.iwp.backend.model.integration.spub;

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
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * SpubCorInt table is spub cancel or Register information stored++++++
 */
@Entity
@Table(name = "t_spub_cor_int")
@XmlRootElement(name="SpubCorInt")
@JsonIgnoreProperties(ignoreUnknown=true)
public class SpubCorInt implements java.io.Serializable {

	private long spubCorSeqno;
	private String spubNo;
	private String referredFrom;
	private String referredTo;
	private Character spubStatus;
	private Character spubRegistered;
	private String sendFlag;
	private Long createdBy;
	private Date createdDate;
	private Long updatedBy;
	private Date updatedDate;
	

	public SpubCorInt() {
	}

	public SpubCorInt(SpubCorInt spubCorInt) {
		this.spubNo = spubCorInt.getSpubNo();
		this.referredFrom = spubCorInt.getReferredFrom();
		this.referredTo = spubCorInt.getReferredTo();
		this.spubStatus = spubCorInt.getSpubStatus();
		this. spubRegistered = spubCorInt.getSpubRegistered();
		this.sendFlag = spubCorInt.getSendFlag();
		this.createdBy = spubCorInt.getCreatedBy();
		this.createdDate = spubCorInt.getCreatedDate();
		this.updatedBy = spubCorInt.getUpdatedBy();
		this.updatedDate = spubCorInt.getUpdatedDate();
	}


	public SpubCorInt(long spubCorSeqno) {
		this.spubCorSeqno = spubCorSeqno;
	}

	@Id
	@Column(name = "spub_cor_seqno", unique = true, nullable = false)
	@SequenceGenerator(name = "spub_cor_generator", sequenceName = "t_spub_cor_int_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "spub_cor_generator")
	public long getSpubCorSeqno() {
		return this.spubCorSeqno;
	}

	public void setSpubCorSeqno(long spubCoSeqno) {
		this.spubCorSeqno = spubCoSeqno;
	}

	@Column(name = "spub_no", length = 40)
	public String getSpubNo() {
		return this.spubNo;
	}

	public void setSpubNo(String spubNo) {
		this.spubNo = spubNo;
	}
	
	@Column(name = "referred_to", length = 50)
	public String getReferredTo() {
		return this.referredTo;
	}

	public void setReferredTo(String referredTo) {
		this.referredTo = referredTo;
	}

	@Column(name = "created_by")
	public Long getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", length = 29)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "updated_by")
	public Long getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_date", length = 29)
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Column(name = "spub_status")
	public Character getSpubStatus() {
		return spubStatus;
	}

	public void setSpubStatus(Character spubStatus) {
		this.spubStatus = spubStatus;
	}

	@Column(name = "spub_registered")
	public Character getSpubRegistered() {
		return spubRegistered;
	}

	public void setSpubRegistered(Character spubRegistered) {
		this.spubRegistered = spubRegistered;
	}

	@Column(name = "referred_from", length = 50)
	public String getReferredFrom() {
		return referredFrom;
	}

	public void setReferredFrom(String referredFrom) {
		this.referredFrom = referredFrom;
	}

	@Column(name = "send_flag")
	public String getSendFlag() {
		return sendFlag;
	}

	public void setSendFlag(String sendFlag) {
		this.sendFlag = sendFlag;
	}
	
	
	
	

}
