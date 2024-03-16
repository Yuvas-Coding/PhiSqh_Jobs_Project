package my.com.cmg.iwp.backend.model.integration.hqcontract;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import my.com.cmg.iwp.maintenance.model.ContractDtl;

/**
 * The persistent class for the ph_hq_contract_dtls_int database table.
 * 
 */
@XmlRootElement(name="HqContractDtlsInt")
@JsonIgnoreProperties(ignoreUnknown=true)
public class HqContractDtlsInt implements Serializable {

	private Long hqDtlIntSeqno;
	private Long accumulatedPurchaseQty;
	private String brdCode;
	private Long createdBy;
	private Date createdDate;
	private Date effectiveEndDate;
	private Date effectiveStartDate;
	private String itemCode;
	private String parameter1;
	private String parameter2;
	private BigDecimal parameter3;
	private BigDecimal parameter4;
	private Date parameter5;
	private String supplierCode;
	private BigDecimal unitPriceSkuWithFi;
	private BigDecimal unitPriceSkuWoFi;
	private Long updatedBy;
	private Date updatedDate;
	private HqContractHdrsInt hqContractHdrsInt;

	public HqContractDtlsInt() {
	}

	public HqContractDtlsInt(final Long hqDtlIntSeqno) {
		super();
		this.hqDtlIntSeqno = hqDtlIntSeqno;
	}

	public HqContractDtlsInt(final ContractDtl contractDtl, final HqContractHdrsInt hqContractHdrsInt) {
		this.hqDtlIntSeqno = contractDtl.getHqDtlSeqno();
		this.accumulatedPurchaseQty = contractDtl.getAccumulatedPurchaseQty();
		this.brdCode = contractDtl.getBrand().getBrdCode();
		this.createdBy = contractDtl.getCreateBy();
		this.createdDate = contractDtl.getCreateDate();
		this.effectiveEndDate = contractDtl.getEffectiveEndDate();
		this.effectiveStartDate = contractDtl.getEffectivestartDate();
		this.itemCode = contractDtl.getItem().getItemCode();
		this.supplierCode = contractDtl.getSupplier().getSupplierCode();
		this.unitPriceSkuWithFi = contractDtl.getUnitPriceSkuWithFi();
		this.unitPriceSkuWoFi = contractDtl.getUnitPriceSkuWOFi();
		this.updatedBy = contractDtl.getUpdateBy();
		this.updatedDate = contractDtl.getUpdateDate();
		this.hqContractHdrsInt = hqContractHdrsInt;
	}

	@JsonIgnore
	public Long getHqDtlIntSeqno() {
		return this.hqDtlIntSeqno;
	}

	public void setHqDtlIntSeqno(final Long hqDtlIntSeqno) {
		this.hqDtlIntSeqno = hqDtlIntSeqno;
	}


	public Long getAccumulatedPurchaseQty() {
		return this.accumulatedPurchaseQty;
	}

	public void setAccumulatedPurchaseQty(final Long accumulatedPurchaseQty) {
		this.accumulatedPurchaseQty = accumulatedPurchaseQty;
	}


	public String getBrdCode() {
		return this.brdCode;
	}

	public void setBrdCode(final String brdCode) {
		this.brdCode = brdCode;
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


	public Date getEffectiveEndDate() {
		return this.effectiveEndDate;
	}

	public void setEffectiveEndDate(final Date effectiveEndDate) {
		this.effectiveEndDate = effectiveEndDate;
	}


	public Date getEffectiveStartDate() {
		return this.effectiveStartDate;
	}

	public void setEffectiveStartDate(final Date effectiveStartDate) {
		this.effectiveStartDate = effectiveStartDate;
	}


	public String getItemCode() {
		return this.itemCode;
	}

	public void setItemCode(final String itemCode) {
		this.itemCode = itemCode;
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


	public String getSupplierCode() {
		return this.supplierCode;
	}

	public void setSupplierCode(final String supplierCode) {
		this.supplierCode = supplierCode;
	}


	public BigDecimal getUnitPriceSkuWithFi() {
		return this.unitPriceSkuWithFi;
	}

	public void setUnitPriceSkuWithFi(final BigDecimal unitPriceSkuWithFi) {
		this.unitPriceSkuWithFi = unitPriceSkuWithFi;
	}


	public BigDecimal getUnitPriceSkuWoFi() {
		return this.unitPriceSkuWoFi;
	}

	public void setUnitPriceSkuWoFi(final BigDecimal unitPriceSkuWoFi) {
		this.unitPriceSkuWoFi = unitPriceSkuWoFi;
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

	@XmlElement
	@JsonBackReference("HqContractDtlsInt")
	public HqContractHdrsInt getHqContractHdrsInt() {
		return this.hqContractHdrsInt;
	}

	public void setHqContractHdrsInt(final HqContractHdrsInt hqContractHdrsInt) {
		this.hqContractHdrsInt = hqContractHdrsInt;
	}

}