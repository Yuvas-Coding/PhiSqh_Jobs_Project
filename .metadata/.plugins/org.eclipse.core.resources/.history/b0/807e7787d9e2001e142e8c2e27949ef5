package my.com.cmg.iwp.maintenance.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "t_penalty_incident_cal_dtls")
@JsonIgnoreProperties(ignoreUnknown = true)
public class PenaltyIncidentCalDtls implements  Comparable<PenaltyIncidentCalDtls>, java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private long incidentCalSeqno;
	private String formulaCode;
	private String formulaDesc;
	private BigDecimal percentage;
	private Integer duration;
	private String status;
	private String parameter1;
	private String parameter2;
	private BigDecimal parameter3;
	private BigDecimal parameter4;
	private Date parameter5;
	private Character activeFlag = 'A';
	private long createdBy;
	private Date createdDate;
	private Long updatedBy;
	private Date updatedDate;
	private PenaltyIncident penaltyIncident;
	private Integer minPayment;

	public PenaltyIncidentCalDtls() {
	}

	public PenaltyIncidentCalDtls(long incidentCalSeqno, String formulaCode, String formulaDesc, BigDecimal percentage,
			Integer duration, String status, String parameter1, String parameter2, BigDecimal parameter3,
			BigDecimal parameter4, Date parameter5, Character activeFlag, long createdBy, Date createdDate,
			Long updatedBy, Date updatedDate, PenaltyIncident penaltyIncident) {
		super();
		this.incidentCalSeqno = incidentCalSeqno;
		this.formulaCode = formulaCode;
		this.formulaDesc = formulaDesc;
		this.percentage = percentage;
		this.duration = duration;
		this.status = status;
		this.parameter1 = parameter1;
		this.parameter2 = parameter2;
		this.parameter3 = parameter3;
		this.parameter4 = parameter4;
		this.parameter5 = parameter5;
		this.activeFlag = activeFlag;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.penaltyIncident = penaltyIncident;
	}

	@Id
	@Column(name = "incident_cal_seqno", unique = true, nullable = false)
	@SequenceGenerator(name = "incident_cal_seqno", sequenceName = "t_incident_cal_seq", allocationSize = 1)
	@GeneratedValue(generator = "incident_cal_seqno")
	public long getIncidentCalSeqno() {
		return this.incidentCalSeqno;
	}

	public void setIncidentCalSeqno(long incidentCalSeqno) {
		this.incidentCalSeqno = incidentCalSeqno;
	}

	@Column(name = "formula_code", length = 20)
	public String getFormulaCode() {
		return this.formulaCode;
	}

	public void setFormulaCode(String formulaCode) {
		this.formulaCode = formulaCode;
	}

	@Column(name = "formula_desc")
	public String getFormulaDesc() {
		return this.formulaDesc;
	}

	public void setFormulaDesc(String formulaDesc) {
		this.formulaDesc = formulaDesc;
	}

	@Column(name = "percentage")
	public BigDecimal getPercentage() {
		return this.percentage;
	}

	public void setPercentage(BigDecimal percentage) {
		this.percentage = percentage;
	}

	@Column(name = "duration")
	public Integer getDuration() {
		return this.duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	@Column(name = "status")
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "parameter1", length = 100)
	public String getParameter1() {
		return this.parameter1;
	}

	public void setParameter1(String parameter1) {
		this.parameter1 = parameter1;
	}

	@Column(name = "parameter2", length = 100)
	public String getParameter2() {
		return this.parameter2;
	}

	public void setParameter2(String parameter2) {
		this.parameter2 = parameter2;
	}

	@Column(name = "parameter3")
	public BigDecimal getParameter3() {
		return this.parameter3;
	}

	public void setParameter3(BigDecimal parameter3) {
		this.parameter3 = parameter3;
	}

	@Column(name = "parameter4")
	public BigDecimal getParameter4() {
		return this.parameter4;
	}

	public void setParameter4(BigDecimal parameter4) {
		this.parameter4 = parameter4;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "parameter5", length = 13)
	public Date getParameter5() {
		return this.parameter5;
	}

	public void setParameter5(Date parameter5) {
		this.parameter5 = parameter5;
	}

	@Column(name = "active_flag", nullable = false)
	public Character getActiveFlag() {
		return this.activeFlag;
	}

	public void setActiveFlag(Character activeFlag) {
		this.activeFlag = activeFlag;
	}

	@Column(name = "created_by", nullable = false)
	public long getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", nullable = false, length = 29)
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "incident_seqno")
	public PenaltyIncident getPenaltyIncident() {
		return this.penaltyIncident;
	}

	public void setPenaltyIncident(PenaltyIncident penaltyIncident) {
		this.penaltyIncident = penaltyIncident;
	}

	@Column(name = "min_payment")
	public Integer getMinPayment() {
		return minPayment;
	}

	public void setMinPayment(Integer minPayment) {
		this.minPayment = minPayment;
	}

	@Override
	public int compareTo(PenaltyIncidentCalDtls penaltyIncidentCalDtls) {
		int val = 0;
		if (penaltyIncidentCalDtls.getFormulaCode() != null) {
			val = this.getFormulaCode().compareTo(penaltyIncidentCalDtls.getFormulaCode());
		} else {
			val = this.getFormulaDesc().compareTo(penaltyIncidentCalDtls.getFormulaDesc());
		}
		return val;
	}

}
