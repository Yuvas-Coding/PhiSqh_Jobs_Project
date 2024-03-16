package my.com.cmg.iwp.maintenance.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "T_CONTRACT_HDRS")
public class ContractHdr implements java.io.Serializable, Comparable<ContractHdr> {

	private static final long serialVersionUID = -1337012867206879338L;
	
	private Long hqHdrSeqno;
	private String contractNo;
	private String title;
	private Date contractStartDate;
	private Date contractEndDate;
	private BigDecimal contractAmount;
	private Integer deliveryPeriod;
	private String contractStatus;
	private String remark;
	private Character enforceQuota;
	private String parameter1;
	private String parameter2;
	private BigDecimal parameter3;
	private BigDecimal parameter4;
	private Date parameter5;
	private Character activeFlag;
	private Date createDate;
	private Date updateDate;
	private long updateBy;
	private long createBy;
	private Long revisedNo = 1l;
	private Set<ContractDtl> hqContractDtlses = new HashSet<ContractDtl>(0);
	private Set<ContractFacility> hqContractFacilities = new HashSet<ContractFacility>(0);
	private Set<ContractItemQty> hqContractItemQty = new HashSet<ContractItemQty>(0);
	private Set<ContractDeliveryPeriod> hqContractDeliveryPeriod = new HashSet<ContractDeliveryPeriod>(0);
	private Set<ContractPenaltyDtl> hqContractPenaltyDtl = new HashSet<ContractPenaltyDtl>(0);
	private String itemGroup;
	private ItemSubgroup itemSubGroup;
	private String rejectRemark;
	private ContractDtl activeItem;
	private VoteCode voteCode;
	private BigDecimal purchasePrice;
	private Long totalAllocatedQty;
	private Character deleteFlag;
	private Long itmSubgroupSeqno;
	private Character capdFlag;
	//private String facilityType;

	@Column(name = "item_group", length = 20)
	public String getItemGroup() {
		return this.itemGroup;
	}

	public void setItemGroup(final String itemGroup) {
		this.itemGroup = itemGroup;
	}

	@Transient
	public ContractDtl getActiveItem() {
		return this.activeItem;
	}

	public void setActiveItem(final ContractDtl activeItem) {
		this.activeItem = activeItem;
	}

	@Transient
	public VoteCode getVoteCode() {
		return this.voteCode;
	}

	public void setVoteCode(final VoteCode voteCode) {
		this.voteCode = voteCode;
	}

	@Transient
	public BigDecimal getPurchasePrice() {
		return this.purchasePrice;
	}

	public void setPurchasePrice(final BigDecimal purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	@Transient
	public Long getTotalAllocatedQty() {
		return this.totalAllocatedQty;
	}

	public void setTotalAllocatedQty(final Long totalAllocatedQty) {
		this.totalAllocatedQty = totalAllocatedQty;
	}

	@Transient
	public Character isDeleteFlag() {
		return this.deleteFlag;
	}

	public void setDeleteFlag(final Character deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public ContractHdr() {
	}

	public ContractHdr(final Long hqHdrSeqno, final String contractNo,
			final Date createDate, final Date updateDate, final long updateBy, final long createBy) {
		this.hqHdrSeqno = hqHdrSeqno;
		this.contractNo = contractNo;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.updateBy = updateBy;
		this.createBy = createBy;
	}

	public ContractHdr(final Long hqHdrSeqno, final String contractNo,
			final Date contractStartDate, final Date contractEndDate,
			final BigDecimal quotaPuchaseQty, final Integer additionalQty,
			final BigDecimal contractPrice, final Integer deliveryPeriod,
			final BigDecimal accumulatedPurchaseQty,
			final BigDecimal accumulatedPurchaseAmt, final BigDecimal revisedPrice,
			final String parameter1, final String parameter2, final BigDecimal parameter3,
			final BigDecimal parameter4, final Date parameter5, final Character activeFlag,
			final Date createDate, final Date updateDate, final long updateBy, final long createBy,
			final Set<ContractDtl> hqContractDtlses , final long revisedNo) {
		this.hqHdrSeqno = hqHdrSeqno;
		this.contractNo = contractNo;
		this.contractStartDate = contractStartDate;
		this.contractEndDate = contractEndDate;
		this.deliveryPeriod = deliveryPeriod;
		this.parameter1 = parameter1;
		this.parameter2 = parameter2;
		this.parameter3 = parameter3;
		this.parameter4 = parameter4;
		this.parameter5 = parameter5;
		this.activeFlag = activeFlag;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.updateBy = updateBy;
		this.createBy = createBy;
		this.hqContractDtlses = hqContractDtlses;
		this.revisedNo = revisedNo;
	}

	@Id
	@Column(name = "hdr_seqno", unique = true, nullable = false)
	@SequenceGenerator(name="hdr_seqno", sequenceName="T_CONTRACT_HDRS_SEQ", allocationSize = 1)
	@GeneratedValue(generator="hdr_seqno")


	public Long getHqHdrSeqno() {
		return this.hqHdrSeqno;
	}

	public void setHqHdrSeqno(final Long hqHdrSeqno) {
		this.hqHdrSeqno = hqHdrSeqno;
	}

	@Column(name = "contract_no", nullable = false, length = 50)
	public String getContractNo() {
		return this.contractNo;
	}

	public void setContractNo(final String contractNo) {
		this.contractNo = contractNo;
	}

	@Column(name = "title", length = 100)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(final String title) {
		this.title = title;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "contract_start_date", length = 29)
	public Date getContractStartDate() {
		return this.contractStartDate;
	}

	public void setContractStartDate(final Date contractStartDate) {
		this.contractStartDate = contractStartDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "contract_end_date", length = 29)
	public Date getContractEndDate() {
		return this.contractEndDate;
	}

	public void setContractEndDate(final Date contractEndDate) {
		this.contractEndDate = contractEndDate;
	}

	@Column(name = "contract_amount", precision = 15, scale = 4)
	public BigDecimal getContractAmount() {
		return this.contractAmount;
	}

	public void setContractAmount(final BigDecimal contractAmount) {
		this.contractAmount = contractAmount;
	}

	@Column(name = "delivery_period")
	public Integer getDeliveryPeriod() {
		return this.deliveryPeriod;
	}

	public void setDeliveryPeriod(final Integer deliveryPeriod) {
		this.deliveryPeriod = deliveryPeriod;
	}

	@Column(name = "parameter1", length = 100)
	public String getParameter1() {
		return this.parameter1;
	}

	public void setParameter1(final String parameter1) {
		this.parameter1 = parameter1;
	}

	@Column(name = "parameter2", length = 100)
	public String getParameter2() {
		return this.parameter2;
	}

	public void setParameter2(final String parameter2) {
		this.parameter2 = parameter2;
	}

	@Column(name = "parameter3", precision = 8, scale = 4)
	public BigDecimal getParameter3() {
		return this.parameter3;
	}

	public void setParameter3(final BigDecimal parameter3) {
		this.parameter3 = parameter3;
	}

	@Column(name = "parameter4", precision = 8, scale = 4)
	public BigDecimal getParameter4() {
		return this.parameter4;
	}

	public void setParameter4(final BigDecimal parameter4) {
		this.parameter4 = parameter4;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "parameter5", length = 13)
	public Date getParameter5() {
		return this.parameter5;
	}

	public void setParameter5(final Date parameter5) {
		this.parameter5 = parameter5;
	}

	@Column(name = "active_flag")
	public Character getActiveFlag() {
		return this.activeFlag;
	}

	public void setActiveFlag(final Character activeFlag) {
		this.activeFlag = activeFlag;
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

	@Column(name = "contract_status", length = 20)
	public String getContractStatus() {
		return this.contractStatus;
	}

	public void setContractStatus(final String contractStatus) {
		this.contractStatus = contractStatus;
	}

	@Column(name = "remark", length = 100)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(final String remark) {
		this.remark = remark;
	}

	@Column(name = "enforce_quota")
	public Character getEnforceQuota() {
		return this.enforceQuota;
	}

	public void setEnforceQuota(final Character enforceQuota) {
		this.enforceQuota = enforceQuota;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "hqContractHdr",cascade=CascadeType.ALL)
	@Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE,
		org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
	public Set<ContractDtl> getHqContractDtlses() {
		return this.hqContractDtlses;
	}

	public void setHqContractDtlses(Set<ContractDtl> hqContractDtlses) {
		this.hqContractDtlses = hqContractDtlses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "hqContractHdr",cascade=CascadeType.ALL)
	@Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE,
		org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
	public Set<ContractItemQty> getHqContractItemQty() {
		return this.hqContractItemQty;
	}

	public void setHqContractItemQty(Set<ContractItemQty> hqContractItemQty) {
		this.hqContractItemQty = hqContractItemQty;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "hqContractHdr",cascade=CascadeType.ALL)
	@Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE,
		org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
	public Set<ContractFacility> getHqContractFacilities() {
		return this.hqContractFacilities;
	}

	public void setHqContractFacilities(Set<ContractFacility> hqContractFacilities) {
		this.hqContractFacilities = hqContractFacilities;
	}

	@Column(name = "revised_no")
	public Long getRevisedNo() {
		return this.revisedNo;
	}

	public void setRevisedNo(final Long revisedNo) {
		this.revisedNo = revisedNo;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "itm_subgroup_seqno")
	public ItemSubgroup getItemSubGroup() {
		return this.itemSubGroup;
	}

	public void setItemSubGroup(final ItemSubgroup itemSubGroup) {
		this.itemSubGroup = itemSubGroup;
	}

	@Override
	public int compareTo(ContractHdr contHdr) {
		if(title!=null)
			return this.title.compareTo(contHdr.title);
		else
			return 0;
	}

	public void setRejectRemark(String rejectRemark) {
		this.rejectRemark = rejectRemark;
	}

	@Column(name = "reject_remark")
	public String getRejectRemark() {
		return rejectRemark;
	}
	@Column(name = "itm_subgroup_seqno", insertable = false, updatable = false)
	public Long getItmSubgroupSeqno() {
		return itmSubgroupSeqno;
	}

	public void setItmSubgroupSeqno(Long itmSubgroupSeqno) {
		this.itmSubgroupSeqno = itmSubgroupSeqno;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "hqContractHdr",cascade=CascadeType.ALL)
	@Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE,
		org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
	public Set<ContractDeliveryPeriod> getHqContractDeliveryPeriod() {
		return this.hqContractDeliveryPeriod;
	}

	public void setHqContractDeliveryPeriod(Set<ContractDeliveryPeriod> hqContractDeliveryPeriod) {
		this.hqContractDeliveryPeriod = hqContractDeliveryPeriod;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "hqContractHdr",cascade=CascadeType.ALL)
	@Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE,
		org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
	public Set<ContractPenaltyDtl> getHqContractPenaltyDtl() {
		return hqContractPenaltyDtl;
	}

	public void setHqContractPenaltyDtl(Set<ContractPenaltyDtl> hqContractPenaltyDtl) {
		this.hqContractPenaltyDtl = hqContractPenaltyDtl;
	}

	@Column(name="capd_flag")
	public Character getCapdFlag() {
		return capdFlag;
	}

	public void setCapdFlag(Character capdFlag) {
		this.capdFlag = capdFlag;
	}
		
}
