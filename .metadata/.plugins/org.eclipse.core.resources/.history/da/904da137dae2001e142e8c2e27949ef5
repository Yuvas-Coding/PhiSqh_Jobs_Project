package my.com.cmg.iwp.maintenance.model;

import java.io.Serializable;
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
@Table(name = "T_PPUSS_NAME")
public class PPUSSName implements Serializable {
	
	private Long ppussSeqno;
	private String ppussCode;
	private String ppussState;
	private String ppussName;
	private String activeFlag;
	private Long createdBy;
	private Date createdDate;
	private Long updatedBy;
	private Date updatedDate;
	
	public PPUSSName(){
		
	}

	@Id
	@Column(name= "ppuss_seqno")
	@SequenceGenerator(name = "ppuss_name_seq", sequenceName = "t_ppuss_name_seq", allocationSize = 1)
	@GeneratedValue(generator = "ppuss_name_seq", strategy = GenerationType.SEQUENCE)
	public Long getPpussSeqno() {
		return ppussSeqno;
	}

	public void setPpussSeqno(Long ppussSeqno) {
		this.ppussSeqno = ppussSeqno;
	}

	@Column(name = "ppuss_code")
	public String getPpussCode() {
		return ppussCode;
	}

	public void setPpussCode(String ppussCode) {
		this.ppussCode = ppussCode;
	}

	@Column(name = "ppuss_state")
	public String getPpussState() {
		return ppussState;
	}

	public void setPpussState(String ppussState) {
		this.ppussState = ppussState;
	}

	@Column(name = "ppuss_name", length = 500)
	public String getPpussName() {
		return ppussName;
	}

	public void setPpussName(String ppussName) {
		this.ppussName = ppussName;
	}

	@Column(name = "active_flag")
	public String getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}

	@Column(name = "created_by", nullable = false)
	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "created_date", nullable = false)
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "updated_by", nullable = false)
	public Long getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Column(name = "updated_date", nullable = false)
	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	
}