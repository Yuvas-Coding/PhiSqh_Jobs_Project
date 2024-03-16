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
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
* PNCronInt table is outsource_order pn type cancel or Register information stored++++++
*/
@Entity
@Table(name = "t_pn_cor_int")
@XmlRootElement(name = "PNCronInt")
@JsonIgnoreProperties(ignoreUnknown=true)
public class PNCronInt implements java.io.Serializable {

	private long pnCorSeqno;
	private String sourceOutsourceNo;
	private String referredFrom;
	private String referredTo;
	private Character pnStatus;
	private Character pnRegistered;
	private String sendFlag;
	private Long createdBy;
	private Date createdDate;
	private Long updatedBy;
	private Date updatedDate;

	public PNCronInt() {

	}

	public PNCronInt(PNCronInt pnCronInt) {
		this.sourceOutsourceNo = pnCronInt.getSourceOutsourceNo();
		this.referredFrom = pnCronInt.getReferredFrom();
		this.referredTo = pnCronInt.getReferredTo();
		this.pnStatus = pnCronInt.getPnStatus();
		this.pnRegistered = pnCronInt.getPnRegistered();
		this.sendFlag = pnCronInt.getSendFlag();
		this.createdBy = pnCronInt.getCreatedBy();
		this.createdDate = pnCronInt.getCreatedDate();
		this.updatedBy = pnCronInt.getUpdatedBy();
		this.updatedDate = pnCronInt.getUpdatedDate();
	}

	public PNCronInt(long pnCorSeqno) {
		this.pnCorSeqno = pnCorSeqno;
	}

	@Id
	@Column(name = "pn_corn_seqno", unique = true, nullable = false)
	@SequenceGenerator(name = "pn_corn_generator", sequenceName = "t_pn_cor_int_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pn_corn_generator")
	public long getPnCorSeqno() {
		return pnCorSeqno;
	}

	public void setPnCorSeqno(long pnCorSeqno) {
		this.pnCorSeqno = pnCorSeqno;
	}

	@Column(name = "source_outsource_no", length = 40)
	public String getSourceOutsourceNo() {
		return sourceOutsourceNo;
	}

	public void setSourceOutsourceNo(String sourceOutsourceNo) {
		this.sourceOutsourceNo = sourceOutsourceNo;
	}
	
	@Column(name = "referred_from", length = 50)
	public String getReferredFrom() {
		return referredFrom;
	}

	public void setReferredFrom(String referredFrom) {
		this.referredFrom = referredFrom;
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

	@Column(name = "pn_status")
	public Character getPnStatus() {
		return pnStatus;
	}

	public void setPnStatus(Character pnStatus) {
		this.pnStatus = pnStatus;
	}

	@Column(name = "pn_registered")
	public Character getPnRegistered() {
		return pnRegistered;
	}

	public void setPnRegistered(Character pnRegistered) {
		this.pnRegistered = pnRegistered;
	}

	@Column(name = "send_flag")
	public String getSendFlag() {
		return sendFlag;
	}

	public void setSendFlag(String sendFlag) {
		this.sendFlag = sendFlag;
	}

}


