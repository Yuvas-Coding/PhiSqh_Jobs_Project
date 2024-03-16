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
import javax.persistence.Transient;

import my.com.cmg.iwp.webui.constant.RefCodeConstant;


@Entity
@Table(name = "T_CONTRACT_FACILITIES")
public class ContractFacility implements java.io.Serializable {

	private static final long serialVersionUID = -8926576391240861000L;
	
	private Long hqFacilitiesSeqno;
	private ContractHdr hqContractHdr;
	private BigDecimal allocatedQty;
	private Date createDate;
	private Date updateDate;
	private long updateBy;
	private long createBy;
	private VoteCode voteCode;
	private String facilityState;
	private String facilityStateName;
	private String facilityCode;
	private String facilityName;
	private String ptjCode;
	private String itemCode;
	private Long accumulated_purchase_qty;
	private String sendFlag = RefCodeConstant.BOOLEAN_YES;
	private Long remainingQty=0L;
	private Long hdrSeqno;
	
	@Transient
	public Long getRemainingQty() {
		return remainingQty;
	}

	public void setRemainingQty(Long remainingQty) {
		this.remainingQty = remainingQty;
	}

	@Transient
	public VoteCode getVoteCode() {
		return this.voteCode;
	}

	public void setVoteCode(final VoteCode voteCode) {
		this.voteCode = voteCode;
	}

	public ContractFacility() {
	}

	public ContractFacility(final Long hqFacilitiesSeqno,

			final ExternalFacility externalFacility) {
		this.hqFacilitiesSeqno = hqFacilitiesSeqno;

	}

	@Id
	@Column(name = "facilities_seqno", unique = true, nullable = false)
	@SequenceGenerator(name="facilities_seqno", sequenceName="T_CONTRACT_FACILITIES_SEQ", allocationSize = 1)
	@GeneratedValue(generator="facilities_seqno")
	public Long getHqFacilitiesSeqno() {
		return this.hqFacilitiesSeqno;
	}

	public void setHqFacilitiesSeqno(final Long hqFacilitiesSeqno) {
		this.hqFacilitiesSeqno = hqFacilitiesSeqno;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hdr_seqno", nullable = false)
	public ContractHdr getHqContractHdr() {
		return this.hqContractHdr;
	}

	public void setHqContractHdr(final ContractHdr hqContractHdr) {
		this.hqContractHdr = hqContractHdr;
	}
	
	@Column(name = "allocated_qty", precision = 7, scale = 0)
	public BigDecimal getAllocatedQty() {
		return this.allocatedQty;
	}

	public void setAllocatedQty(final BigDecimal allocatedQty) {
		this.allocatedQty = allocatedQty;
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

	@Column(name = "facility_state")
	public String getFacilityState() {
		return this.facilityState;
	}

	public void setFacilityState(final String facilityState) {
		this.facilityState = facilityState;
	}

	@Transient
	public String getFacilityStateName() {
		return this.facilityStateName;
	}

	public void setFacilityStateName(final String facilityStateName) {
		this.facilityStateName = facilityStateName;
	}

	@Column(name = "facility_code",length=20)
	public String getFacilityCode() {
		return this.facilityCode;
	}

	public void setFacilityCode(final String facilityCode) {
		this.facilityCode = facilityCode;
	}
	
	@Column(name = "item_code",length=20)
	public String getItemCode() {
		return this.itemCode;
	}

	public void setItemCode(final String itemCode) {
		this.itemCode = itemCode;
	}
	
	@Column(name = "accumulated_purchase_qty")
	public Long getAccumulated_purchase_qty() {
		return this.accumulated_purchase_qty;
	}

	public void setAccumulated_purchase_qty(final Long accumulated_purchase_qty) {
		this.accumulated_purchase_qty = accumulated_purchase_qty;
	}

	@Transient
	public String getFacilityName() {
		return this.facilityName;
	}

	public void setFacilityName(final String facilityName) {
		this.facilityName = facilityName;
	}

	@Column(name = "ptj_code",length=15)
	public String getPtjCode() {
		return this.ptjCode;
	}

	public void setPtjCode(final String ptjCode) {
		this.ptjCode = ptjCode;
	}

	@Column(name="SEND_FLAG")
	public String getSendFlag() {
		return this.sendFlag;
	}

	public void setSendFlag(final String sendFlag) {
		this.sendFlag = sendFlag;
	}

	@Column(name="hdr_seqno", insertable=false, updatable=false)
	public Long getHdrSeqno() {
		return hdrSeqno;
	}

	public void setHdrSeqno(Long hdrSeqno) {
		this.hdrSeqno = hdrSeqno;
	}

}
