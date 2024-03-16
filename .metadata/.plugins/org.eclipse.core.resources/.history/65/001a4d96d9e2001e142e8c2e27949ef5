package my.com.cmg.iwp.backend.model.integration.hqcontract;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import my.com.cmg.iwp.maintenance.model.ContractHdr;
import my.com.cmg.iwp.webui.constant.RefCodeConstant;

/**
 * The persistent class for the ph_hq_contract_hdrs_int database table.
 * 
 */
@XmlRootElement(name="HqContractHdrsInt")
@JsonIgnoreProperties(ignoreUnknown=true)
public class HqContractHdrsInt implements Serializable {

	private Long hqHdrIntSeqno;
	private BigDecimal contractAmount;
	private Date contractEndDate;
	private String contractNo;
	private Date contractStartDate;
	private String contractStatus;
	private Long createdBy;
	private Date createdDate;
	private Integer deliveryPeriod;
	private String enforceQuota;
	private String itemGroup;
	private String itmSubgroupCode;
	private String parameter1;
	private String parameter2;
	private BigDecimal parameter3;
	private BigDecimal parameter4;
	private Date parameter5;
	private String remark;
	private BigDecimal revisedNo;
	private String sendFlag;
	private String title;
	private Long updatedBy;
	private Date updatedDate;
	private Set<HqContractDtlsInt> hqContractDtlsInts = new HashSet<HqContractDtlsInt>();
	private Set<HqContractItemQtyInt> hqContractItemQtyInts = new HashSet<HqContractItemQtyInt>();

	public HqContractHdrsInt() {
	}

	public HqContractHdrsInt(final Long hqHdrIntSeqno) {
		super();
		this.hqHdrIntSeqno = hqHdrIntSeqno;
	}

	public HqContractHdrsInt(final ContractHdr contractHdr) {
		this.hqHdrIntSeqno = contractHdr.getHqHdrSeqno();
		this.contractAmount = contractHdr.getContractAmount();
		this.contractEndDate = contractHdr.getContractEndDate();
		this.contractNo = contractHdr.getContractNo();
		this.contractStartDate = contractHdr.getContractStartDate();
		this.contractStatus = contractHdr.getContractStatus();
		this.createdBy = contractHdr.getCreateBy();
		this.createdDate = contractHdr.getCreateDate();
		this.deliveryPeriod = contractHdr.getDeliveryPeriod();
		this.enforceQuota = contractHdr.getEnforceQuota() == null ? "" : contractHdr.getEnforceQuota().toString();
		this.itemGroup = contractHdr.getItemGroup();
		if (contractHdr.getItemSubGroup() != null) {
			this.itmSubgroupCode = contractHdr.getItemSubGroup().getItmGroupCode();
		}
		this.remark = contractHdr.getRemark();
		this.revisedNo = BigDecimal.valueOf(contractHdr.getRevisedNo());
		this.sendFlag = RefCodeConstant.BOOLEAN_YES;
		this.title = contractHdr.getTitle();
		this.updatedBy = contractHdr.getUpdateBy();
		this.updatedDate = contractHdr.getUpdateDate();
	}

	@JsonIgnore
	public Long getHqHdrIntSeqno() {
		return this.hqHdrIntSeqno;
	}

	public void setHqHdrIntSeqno(final Long hqHdrIntSeqno) {
		this.hqHdrIntSeqno = hqHdrIntSeqno;
	}


	public BigDecimal getContractAmount() {
		return this.contractAmount;
	}

	public void setContractAmount(final BigDecimal contractAmount) {
		this.contractAmount = contractAmount;
	}

	public Date getContractEndDate() {
		return this.contractEndDate;
	}

	public void setContractEndDate(final Date contractEndDate) {
		this.contractEndDate = contractEndDate;
	}

	public String getContractNo() {
		return this.contractNo;
	}

	public void setContractNo(final String contractNo) {
		this.contractNo = contractNo;
	}


	public Date getContractStartDate() {
		return this.contractStartDate;
	}

	public void setContractStartDate(final Date contractStartDate) {
		this.contractStartDate = contractStartDate;
	}


	public String getContractStatus() {
		return this.contractStatus;
	}

	public void setContractStatus(final String contractStatus) {
		this.contractStatus = contractStatus;
	}


	public Long getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(final Long createdBy) {
		this.createdBy = createdBy;
	}


	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(final Date createdDate) {
		this.createdDate = createdDate;
	}


	public Integer getDeliveryPeriod() {
		return this.deliveryPeriod;
	}

	public void setDeliveryPeriod(final Integer deliveryPeriod) {
		this.deliveryPeriod = deliveryPeriod;
	}


	public String getEnforceQuota() {
		return this.enforceQuota;
	}

	public void setEnforceQuota(final String enforceQuota) {
		this.enforceQuota = enforceQuota;
	}

	public String getItemGroup() {
		return this.itemGroup;
	}

	public void setItemGroup(final String itemGroup) {
		this.itemGroup = itemGroup;
	}


	public String getItmSubgroupCode() {
		return this.itmSubgroupCode;
	}

	public void setItmSubgroupCode(final String itmSubgroupCode) {
		this.itmSubgroupCode = itmSubgroupCode;
	}


	public String getParameter1() {
		return this.parameter1;
	}

	public void setParameter1(final String parameter1) {
		this.parameter1 = parameter1;
	}


	public String getParameter2() {
		return this.parameter2;
	}

	public void setParameter2(final String parameter2) {
		this.parameter2 = parameter2;
	}


	public BigDecimal getParameter3() {
		return this.parameter3;
	}

	public void setParameter3(final BigDecimal parameter3) {
		this.parameter3 = parameter3;
	}


	public BigDecimal getParameter4() {
		return this.parameter4;
	}

	public void setParameter4(final BigDecimal parameter4) {
		this.parameter4 = parameter4;
	}


	public Date getParameter5() {
		return this.parameter5;
	}

	public void setParameter5(final Date parameter5) {
		this.parameter5 = parameter5;
	}


	public String getRemark() {
		return this.remark;
	}

	public void setRemark(final String remark) {
		this.remark = remark;
	}


	public BigDecimal getRevisedNo() {
		return this.revisedNo;
	}

	public void setRevisedNo(final BigDecimal revisedNo) {
		this.revisedNo = revisedNo;
	}


	public String getSendFlag() {
		return this.sendFlag;
	}

	public void setSendFlag(final String sendFlag) {
		this.sendFlag = sendFlag;
	}


	public String getTitle() {
		return this.title;
	}

	public void setTitle(final String title) {
		this.title = title;
	}


	public Long getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(final Long updatedBy) {
		this.updatedBy = updatedBy;
	}


	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(final Date updatedDate) {
		this.updatedDate = updatedDate;
	}


	//bi-directional many-to-one association to HqContractDtlsInt
	@XmlElement
	@JsonManagedReference("HqContractDtlsInt")
	public Set<HqContractDtlsInt> getHqContractDtlsInts() {
		return this.hqContractDtlsInts;
	}

	public void setHqContractDtlsInts(final Set<HqContractDtlsInt> hqContractDtlsInts) {
		this.hqContractDtlsInts = hqContractDtlsInts;
	}


	//bi-directional many-to-one association to HqContractItemQtyInt
	@XmlElement
	@JsonManagedReference("HqContractItemQtyInt")
	public Set<HqContractItemQtyInt> getHqContractItemQtyInts() {
		return this.hqContractItemQtyInts;
	}

	public void setHqContractItemQtyInts(final Set<HqContractItemQtyInt> hqContractItemQtyInts) {
		this.hqContractItemQtyInts = hqContractItemQtyInts;
	}

}