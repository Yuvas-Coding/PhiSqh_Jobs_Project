package my.com.cmg.iwp.maintenance.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "t_fpp_drug_vw")
public class FppDrugVW {
	
	@Id
	@Column(name="view_seqno")
	private long viewSeqno;
	@Column(name="fpp_drug_price_seqno")
	private Long fppDrugPriceSeqno;	
	@Column(name="drug_code")
	private String drugCode;
	@Column(name="drug_name")
	private String drugName;
	@Column(name="drug_seqno")
	private long drugSeqno;
	@Column(name="fpp_yn")
	private Character fppYn;
	@Column(name="uom_desc")
	private String skuUomDesc;
	@Column(name="drug_price")
	private BigDecimal drugPrice; 
	@Column(name="fpp_price")
	private BigDecimal fppPrice;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="effective_date")
	private Date effectiveDate;
	@Column(name = "version_no")
	private Integer versionNo;
	
	
	public long getViewSeqno() {
		return viewSeqno;
	}
	public void setViewSeqno(long viewSeqno) {
		this.viewSeqno = viewSeqno;
	}
	public Long getFppDrugPriceSeqno() {
		return fppDrugPriceSeqno;
	}
	public void setFppDrugPriceSeqno(Long fppDrugPriceSeqno) {
		this.fppDrugPriceSeqno = fppDrugPriceSeqno;
	}
	public String getDrugCode() {
		return drugCode;
	}
	public void setDrugCode(String drugCode) {
		this.drugCode = drugCode;
	}
	public String getDrugName() {
		return drugName;
	}
	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}
	public long getDrugSeqno() {
		return drugSeqno;
	}
	public void setDrugSeqno(long drugSeqno) {
		this.drugSeqno = drugSeqno;
	}
	public Character getFppYn() {
		return fppYn;
	}
	public void setFppYn(Character fppYn) {
		this.fppYn = fppYn;
	}
	public String getSkuUomDesc() {
		return skuUomDesc;
	}
	public void setSkuUomDesc(String skuUomDesc) {
		this.skuUomDesc = skuUomDesc;
	}
	public BigDecimal getDrugPrice() {
		return drugPrice;
	}
	public void setDrugPrice(BigDecimal drugPrice) {
		this.drugPrice = drugPrice;
	}
	public BigDecimal getFppPrice() {
		return fppPrice;
	}
	public void setFppPrice(BigDecimal fppPrice) {
		this.fppPrice = fppPrice;
	}
	public Date getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	public Integer getVersionNo() {
		return versionNo;
	}
	public void setVersionNo(Integer versionNo) {
		this.versionNo = versionNo;
	}
	
	
	
}
