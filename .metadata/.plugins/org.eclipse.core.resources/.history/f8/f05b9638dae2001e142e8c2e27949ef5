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
@Table(name = "t_contract_penalty_dtl")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContractPenaltyDtl implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Long contractPenaltySeqno;
	private String formulaCode;
	private String formulaDesc;
	private BigDecimal percentage;
	private Integer duration;
	private String incidentCode;
	private String incidentDesc;
	private Long createdBy;
	private Date createdDate;
	private Long updatedBy;
	private Date updatedDate;
	private ContractHdr hqContractHdr;
	private Integer minPayment;

	public ContractPenaltyDtl() {
	}

	public ContractPenaltyDtl(Long contractPenaltySeqno, String formulaCode, String formulaDesc, BigDecimal percentage,
			Integer duration, String parameter1, String parameter2, BigDecimal parameter3,
			BigDecimal parameter4, Date parameter5, Character activeFlag, Long createdBy, Date createdDate,
			Long updatedBy, Date updatedDate) {
		super();
		this.contractPenaltySeqno = contractPenaltySeqno;
		this.formulaCode = formulaCode;
		this.formulaDesc = formulaDesc;
		this.percentage = percentage;
		this.duration = duration;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
	}

	@Id
	@Column(name = "contract_penalty_seqno", unique = true, nullable = false)
	@SequenceGenerator(name = "contract_penalty_seqno", sequenceName = "t_contract_penalty_dtl_seq", allocationSize = 1)
	@GeneratedValue(generator = "contract_penalty_seqno")
	public Long getContractPenaltySeqno() {
		return contractPenaltySeqno;
	}

	public void setContractPenaltySeqno(Long contractPenaltySeqno) {
		this.contractPenaltySeqno = contractPenaltySeqno;
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
	
	@Column(name = "incident_code")
	public String getIncidentCode() {
		return this.incidentCode;
	}

	public void setIncidentCode(String incidentCode) {
		this.incidentCode = incidentCode;
	}

	@Column(name = "incident_desc")
	public String getIncidentDesc() {
		return incidentDesc;
	}

	public void setIncidentDesc(String incidentDesc) {
		this.incidentDesc = incidentDesc;
	}

	@Column(name = "percentage")
	public BigDecimal getPercentage() {
		return this.percentage;
	}

	public void setPercentage(BigDecimal percentage) {
		this.percentage = percentage;
	}
	
	@Column(name = "created_by", nullable = false)
	public Long getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Long createdBy) {
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
	@JoinColumn(name = "hdr_seqno")
	public ContractHdr getHqContractHdr() {
		return this.hqContractHdr;
	}

	public void setHqContractHdr(ContractHdr hqContractHdr) {
		this.hqContractHdr = hqContractHdr;
	}

	@Column(name = "duration")
	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	@Column(name = "min_payment")
	public Integer getMinPayment() {
		return minPayment;
	}

	public void setMinPayment(Integer minPayment) {
		this.minPayment = minPayment;
	}
	
	
	
}
