package my.com.cmg.iwp.maintenance.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "t_fpp_drug_price")
public class FppDrugPrice implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2241511567771603926L;
	
	private long fppDrugPriceSeqno = Long.MIN_VALUE;
	private Drug drug;
	private BigDecimal fppPrice;
	private Date effectiveDate;
	private Character activeFlag = 'A';
	private Integer versionNo;
	private String parameter1;
	private String parameter2;
	private BigDecimal parameter3;
	private BigDecimal parameter4;
	private Date parameter5;
	private long createdBy = 0;
	private Date createdDate;
	private long updatedBy = 0;
	private Date updatedDate;
	
	@Id
	@Column(name = "fpp_drug_price_seqno", unique = true, nullable = false)
	@SequenceGenerator(name = "fppDrugPriceSeq", sequenceName = "t_fpp_drug_price_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fppDrugPriceSeq")
	public long getFppDrugPriceSeqno() {
		return fppDrugPriceSeqno;
	}
	
	public void setFppDrugPriceSeqno(long fppDrugPriceSeqno) {
		this.fppDrugPriceSeqno = fppDrugPriceSeqno;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "drug_seqno")
	public Drug getDrug() {
		return drug;
	}
	
	public void setDrug(Drug drug) {
		this.drug = drug;
	}
	
	@Column(name="fpp_price", precision = 17, scale = 4)
	public BigDecimal getFppPrice() {
		return fppPrice;
	}
	
	public void setFppPrice(BigDecimal fppPrice) {
		this.fppPrice = fppPrice;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "effective_date", nullable = false, length = 29)
	public Date getEffectiveDate() {
		return effectiveDate;
	}
	
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	
	@Column(name = "active_flag")
	public Character getActiveFlag() {
		return activeFlag;
	}
	
	public void setActiveFlag(Character activeFlag) {
		this.activeFlag = activeFlag;
	}
	
	@Column(name = "version_no")
	public Integer getVersionNo() {
		return versionNo;
	}
	
	public void setVersionNo(Integer versionNo) {
		this.versionNo = versionNo;
	}
	
	@Column(name = "parameter1")
	public String getParameter1() {
		return parameter1;
	}
	
	public void setParameter1(String parameter1) {
		this.parameter1 = parameter1;
	}
	
	@Column(name = "parameter2")
	public String getParameter2() {
		return parameter2;
	}
	
	public void setParameter2(String parameter2) {
		this.parameter2 = parameter2;
	}
	
	@Column(name = "parameter3", precision = 8, scale = 4)
	public BigDecimal getParameter3() {
		return parameter3;
	}
	
	public void setParameter3(BigDecimal parameter3) {
		this.parameter3 = parameter3;
	}
	
	@Column(name = "parameter4", precision = 8, scale = 4)
	public BigDecimal getParameter4() {
		return parameter4;
	}
	
	public void setParameter4(BigDecimal parameter4) {
		this.parameter4 = parameter4;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "parameter5", length = 13)
	public Date getParameter5() {
		return parameter5;
	}
	
	public void setParameter5(Date parameter5) {
		this.parameter5 = parameter5;
	}
	
	@Column(name = "created_by", nullable = false)
	public long getCreatedBy() {
		return createdBy;
	}
	
	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", nullable = false, length = 29)
	public Date getCreatedDate() {
		return createdDate;
	}
	
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	@Column(name = "updated_by", nullable = false)
	public long getUpdatedBy() {
		return updatedBy;
	}
	
	public void setUpdatedBy(long updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_date", nullable = false, length = 29)
	public Date getUpdatedDate() {
		return updatedDate;
	}
	
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	

	
}
