package my.com.cmg.iwp.maintenance.model;

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

@Entity
@Table(name = "T_CONTRACT_DELIVERY_PERIOD")
public class ContractDeliveryPeriod implements java.io.Serializable {

	private static final long serialVersionUID = -8862168629462120549L;
	private Long hqDeliveryPeriodSeqno;
	private ContractHdr hqContractHdr;
	private Date contractStartDate;
	private Date contractEndDate;
	private Integer deliveryPeriod;
	private String contractIncludeDays;
	private String contractMalaysiaDirection;
	private Date createDate;
	private Date updateDate;
	private long updateBy;
	private long createBy;
	
	

	public ContractDeliveryPeriod() {
		
	}


	@Id
	@Column(name = "delivery_period_seqno", unique = true, nullable = false)
	@SequenceGenerator(name = "delivery_period_seqno", sequenceName = "T_CONTRACT_DELI_PERIOD_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "delivery_period_seqno")
	public Long getHqDeliveryPeriodSeqno() {
		return this.hqDeliveryPeriodSeqno;
	}

	public void setHqDeliveryPeriodSeqno(Long hqDeliveryPeriodSeqno) {
		this.hqDeliveryPeriodSeqno = hqDeliveryPeriodSeqno;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hdr_seqno")
	public ContractHdr getHqContractHdr() {
		return this.hqContractHdr;
	}

	public void setHqContractHdr(ContractHdr hqContractHdr) {
		this.hqContractHdr = hqContractHdr;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "contract_start_date", length = 29)
	public Date getContractStartDate() {
		return this.contractStartDate;
	}

	public void setContractStartDate(Date contractStartDate) {
		this.contractStartDate = contractStartDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "contract_end_date", length = 29)
	public Date getContractEndDate() {
		return this.contractEndDate;
	}

	public void setContractEndDate(Date contractEndDate) {
		this.contractEndDate = contractEndDate;
	}

	@Column(name = "delivery_period")
	public Integer getDeliveryPeriod() {
		return this.deliveryPeriod;
	}

	public void setDeliveryPeriod(Integer deliveryPeriod) {
		this.deliveryPeriod = deliveryPeriod;
	}

	@Column(name = "contract_include_days", length = 20)
	public String getContractIncludeDays() {
		return this.contractIncludeDays;
	}

	public void setContractIncludeDays(String contractIncludeDays) {
		this.contractIncludeDays = contractIncludeDays;
	}

	@Column(name = "contract_Malaysia_Direction", length = 20)
	public String getContractMalaysiaDirection() {
		return this.contractMalaysiaDirection;
	}

	public void setContractMalaysiaDirection(String contractMalaysiaDirection) {
		this.contractMalaysiaDirection = contractMalaysiaDirection;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", nullable = false, length = 29)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(final Date createDate) {
		this.createDate = createDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_date", nullable = false, length = 29)
	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(final Date updateDate) {
		this.updateDate = updateDate;
	}

	@Column(name = "updated_by", nullable = false)
	public long getUpdateBy() {
		return this.updateBy;
	}

	public void setUpdateBy(final long updateBy) {
		this.updateBy = updateBy;
	}

	@Column(name = "created_by", nullable = false)
	public long getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(final long createBy) {
		this.createBy = createBy;
	}

}
