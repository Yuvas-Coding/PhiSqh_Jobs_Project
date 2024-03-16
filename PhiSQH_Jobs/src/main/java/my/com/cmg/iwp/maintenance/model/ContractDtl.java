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

@Entity
@Table(name = "T_CONTRACT_DTLS")
public class ContractDtl implements java.io.Serializable {

	private static final long serialVersionUID = 1321191533622580495L;

	private Long hqDtlSeqno;
	private Brand brand;
	private ContractHdr hqContractHdr;
	private Supplier supplier;
	private Item item;
	private String packagingDescription;
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
	private Date effectivestartDate;
	private Date effectiveEndDate;
	private BigDecimal unitPriceSkuWOFi;
	private BigDecimal unitPriceSkuWithFi;
	private Long accumulatedPurchaseQty;
	private String drugNondrugCode;
	private String drugNondrugName;

	public ContractDtl() {
	}

	public ContractDtl(Long hqDtlSeqno,

	ContractHdr hqContractHdr, Date createDate, Date updateDate,
			long updateBy, long createBy) {
		this.hqDtlSeqno = hqDtlSeqno;
		// this.FacilityDetail = phFacilityDetails;
		this.hqContractHdr = hqContractHdr;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.updateBy = updateBy;
		this.createBy = createBy;
	}

	public ContractDtl(Long hqDtlSeqno, Brand brand,
			ContractHdr hqContractHdr, String itemCode,
			String contractNo, String parameter1, String parameter2,
			BigDecimal parameter3, BigDecimal parameter4, Date parameter5,
			Character activeFlag, Date createDate, Date updateDate,
			long updateBy, long createBy) {
		this.hqDtlSeqno = hqDtlSeqno;
		this.brand = brand;
		this.hqContractHdr = hqContractHdr;
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
	}

	@Id
	@Column(name = "dtl_seqno", unique = true, nullable = false)
	@SequenceGenerator(name = "dtl_seqno", sequenceName = "T_CONTRACT_DTLS_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "dtl_seqno")
	public Long getHqDtlSeqno() {
		return this.hqDtlSeqno;
	}

	public void setHqDtlSeqno(Long dtlSeqno) {
		this.hqDtlSeqno = dtlSeqno;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "brd_seqno")
	public Brand getBrand() {
		return this.brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hdr_seqno", nullable = false)
	public ContractHdr getHqContractHdr() {
		return this.hqContractHdr;
	}

	public void setHqContractHdr(ContractHdr hqContractHdr) {
		this.hqContractHdr = hqContractHdr;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "spr_seqno")
	public Supplier getSupplier() {
		return this.supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
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

	@Column(name = "parameter3", precision = 8, scale = 4)
	public BigDecimal getParameter3() {
		return this.parameter3;
	}

	public void setParameter3(BigDecimal parameter3) {
		this.parameter3 = parameter3;
	}

	@Column(name = "parameter4", precision = 8, scale = 4)
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

	@Column(name = "active_flag")
	public Character getActiveFlag() {
		return this.activeFlag;
	}

	public void setActiveFlag(Character activeFlag) {
		this.activeFlag = activeFlag;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", nullable = false, length = 29)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_date", nullable = false, length = 29)
	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Column(name = "updated_by", nullable = false)
	public long getUpdateBy() {
		return this.updateBy;
	}

	public void setUpdateBy(long updateBy) {
		this.updateBy = updateBy;
	}

	@Column(name = "created_by", nullable = false)
	public long getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(long createBy) {
		this.createBy = createBy;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "itm_seqno")
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "effective_start_date", nullable = false, length = 29)
	public Date getEffectivestartDate() {
		return effectivestartDate;
	}

	public void setEffectivestartDate(Date effectivestartDate) {
		this.effectivestartDate = effectivestartDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "effective_end_date", nullable = false, length = 29)
	public Date getEffectiveEndDate() {
		return effectiveEndDate;
	}

	public void setEffectiveEndDate(Date effectiveEndDate) {
		this.effectiveEndDate = effectiveEndDate;
	}

	@Column(name = "unit_price_sku_WO_fi", precision = 15, scale = 4)
	public BigDecimal getUnitPriceSkuWOFi() {
		return unitPriceSkuWOFi;
	}

	public void setUnitPriceSkuWOFi(BigDecimal unitPriceSkuWOFi) {
		this.unitPriceSkuWOFi = unitPriceSkuWOFi;
	}

	@Column(name = "unit_price_sku_with_fi", precision = 15, scale = 4)
	public BigDecimal getUnitPriceSkuWithFi() {
		return unitPriceSkuWithFi;
	}

	public void setUnitPriceSkuWithFi(BigDecimal unitPriceSkuWithFi) {
		this.unitPriceSkuWithFi = unitPriceSkuWithFi;
	}
	
	@Column(name = "accumulated_purchase_qty")
	public Long getAccumulatedPurchaseQty() {
		return accumulatedPurchaseQty;
	}

	public void setAccumulatedPurchaseQty(Long accumulatedPurchaseQty) {
		this.accumulatedPurchaseQty = accumulatedPurchaseQty;
	}
	
	@Transient
	public String getDrugNondrugCode() {
		return drugNondrugCode;
	}

	public void setDrugNondrugCode(String drugNondrugCode) {
		this.drugNondrugCode = drugNondrugCode;
	}

	@Transient
	public String getDrugNondrugName() {
		return drugNondrugName;
	}

	public void setDrugNondrugName(String drugNondrugName) {
		this.drugNondrugName = drugNondrugName;
	}

	@Transient
	public String getPackagingDescription() {
		return packagingDescription;
	}

	public void setPackagingDescription(String packagingDescription) {
		this.packagingDescription = packagingDescription;
	}

}
