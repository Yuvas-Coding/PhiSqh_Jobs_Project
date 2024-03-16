package my.com.cmg.iwp.maintenance.model;

// Generated Nov 26, 2012 11:29:43 AM by Hibernate Tools 3.4.0.CR1

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

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * PhPpnSourceContent generated by hbm2java
 */
@Entity
@Table(name = "t_ppn_source_content")
public class PpnSourceContent implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private long ppnSourceContentSeqno = Long.MIN_VALUE;
	
	@JsonIgnore
	private Drug drug;
	
	private Character ppnFlag;
	private String source;
	private BigDecimal osmolarity;
	private Long sku;
	private Long skuUnit;
	private Long conversionFctr;
	private BigDecimal aminoAcidV1;
	private BigDecimal ppnDefaultVolumne;
	private BigDecimal glucodeV1;
	private BigDecimal lipidV1;
	private BigDecimal sodiumV1;
	private BigDecimal potassiumV1;
	private BigDecimal calciumV1;
	private BigDecimal magnesiumV1;
	private BigDecimal phosphateV1;
	private BigDecimal chlorideV1;
	private BigDecimal zincV1;
	private BigDecimal acetateV1;
	private String parameter1;
	private String parameter2;
	private BigDecimal parameter3;
	private BigDecimal parameter4;
	private Date parameter5;
	private Character activeFlag = 'A';
	private long createdBy;
	private Date createdDate;
	private long updatedBy;
	private Date updatedDate;
	private String generic;
	private BigDecimal glutamin;
	private BigDecimal calories;

	public PpnSourceContent() {
	}

	public PpnSourceContent(long ppnSourceContentSeqno, Drug drug,
			long createdBy, Date createdDate, long updatedBy, Date updatedDate) {
		this.ppnSourceContentSeqno = ppnSourceContentSeqno;
		this.drug = drug;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
	}

	public PpnSourceContent(long ppnSourceContentSeqno, Drug drug,
			Character ppnFlag, String source, BigDecimal osmolarity, Long sku,
			Long skuUnit, Long conversionFctr, BigDecimal aminoAcidV1,
			BigDecimal ppnDefaultVolumne, BigDecimal glucodeV1,
			BigDecimal lipidV1, BigDecimal sodiumV1, BigDecimal potassiumV1,
			BigDecimal calciumV1, BigDecimal magnesiumV1,
			BigDecimal phosphateV1, BigDecimal chlorideV1, BigDecimal zincV1,
			BigDecimal acetateV1, String parameter1, String parameter2,
			BigDecimal parameter3, BigDecimal parameter4, Date parameter5,
			Character activeFlag, long createdBy, Date createdDate,
			long updatedBy, Date updatedDate, BigDecimal glutamin) {
		this.ppnSourceContentSeqno = ppnSourceContentSeqno;
		this.drug = drug;
		this.ppnFlag = ppnFlag;
		this.source = source;
		this.osmolarity = osmolarity;
		this.sku = sku;
		this.skuUnit = skuUnit;
		this.conversionFctr = conversionFctr;
		this.aminoAcidV1 = aminoAcidV1;
		this.ppnDefaultVolumne = ppnDefaultVolumne;
		this.glucodeV1 = glucodeV1;
		this.lipidV1 = lipidV1;
		this.sodiumV1 = sodiumV1;
		this.potassiumV1 = potassiumV1;
		this.calciumV1 = calciumV1;
		this.magnesiumV1 = magnesiumV1;
		this.phosphateV1 = phosphateV1;
		this.chlorideV1 = chlorideV1;
		this.zincV1 = zincV1;
		this.acetateV1 = acetateV1;
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
		this.glutamin = glutamin;
	}

	@Id
	@Column(name = "ppn_source_content_seqno", unique = true, nullable = false)
	@SequenceGenerator(name = "ppn_source_content_seqno", sequenceName = "t_ppn_source_content_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ppn_source_content_seqno")
	public long getPpnSourceContentSeqno() {
		return this.ppnSourceContentSeqno;
	}

	public void setPpnSourceContentSeqno(long ppnSourceContentSeqno) {
		this.ppnSourceContentSeqno = ppnSourceContentSeqno;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "drug_seqno", nullable = false)
	public Drug getDrug() {
		return this.drug;
	}

	public void setDrug(Drug drug) {
		this.drug = drug;
	}

	@Column(name = "ppn_flag")
	public Character getPpnFlag() {
		return this.ppnFlag;
	}

	public void setPpnFlag(Character ppnFlag) {
		this.ppnFlag = ppnFlag;
	}

	@Column(name = "source", length = 20)
	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@Column(name = "osmolarity", precision = 8)
	public BigDecimal getOsmolarity() {
		return this.osmolarity;
	}

	public void setOsmolarity(BigDecimal osmolarity) {
		this.osmolarity = osmolarity;
	}

	@Column(name = "sku")
	public Long getSku() {
		return this.sku;
	}

	public void setSku(Long sku) {
		this.sku = sku;
	}

	@Column(name = "sku_unit")
	public Long getSkuUnit() {
		return this.skuUnit;
	}

	public void setSkuUnit(Long skuUnit) {
		this.skuUnit = skuUnit;
	}

	@Column(name = "conversion_fctr")
	public Long getConversionFctr() {
		return this.conversionFctr;
	}

	public void setConversionFctr(Long conversionFctr) {
		this.conversionFctr = conversionFctr;
	}

	@Column(name = "amino_acid_v1", precision = 8)
	public BigDecimal getAminoAcidV1() {
		return this.aminoAcidV1;
	}

	public void setAminoAcidV1(BigDecimal aminoAcidV1) {
		this.aminoAcidV1 = aminoAcidV1;
	}

	@Column(name = "ppn_default_volumne", precision = 8)
	public BigDecimal getPpnDefaultVolumne() {
		return this.ppnDefaultVolumne;
	}

	public void setPpnDefaultVolumne(BigDecimal ppnDefaultVolumne) {
		this.ppnDefaultVolumne = ppnDefaultVolumne;
	}

	@Column(name = "glucode_v1", precision = 8)
	public BigDecimal getGlucodeV1() {
		return this.glucodeV1;
	}

	public void setGlucodeV1(BigDecimal glucodeV1) {
		this.glucodeV1 = glucodeV1;
	}

	@Column(name = "lipid_v1", precision = 8)
	public BigDecimal getLipidV1() {
		return this.lipidV1;
	}

	public void setLipidV1(BigDecimal lipidV1) {
		this.lipidV1 = lipidV1;
	}

	@Column(name = "sodium_v1", precision = 8)
	public BigDecimal getSodiumV1() {
		return this.sodiumV1;
	}

	public void setSodiumV1(BigDecimal sodiumV1) {
		this.sodiumV1 = sodiumV1;
	}

	@Column(name = "potassium_v1", precision = 8)
	public BigDecimal getPotassiumV1() {
		return this.potassiumV1;
	}

	public void setPotassiumV1(BigDecimal potassiumV1) {
		this.potassiumV1 = potassiumV1;
	}

	@Column(name = "calcium_v1", precision = 8)
	public BigDecimal getCalciumV1() {
		return this.calciumV1;
	}

	public void setCalciumV1(BigDecimal calciumV1) {
		this.calciumV1 = calciumV1;
	}

	@Column(name = "magnesium_v1", precision = 8)
	public BigDecimal getMagnesiumV1() {
		return this.magnesiumV1;
	}

	public void setMagnesiumV1(BigDecimal magnesiumV1) {
		this.magnesiumV1 = magnesiumV1;
	}

	@Column(name = "phosphate_v1", precision = 8)
	public BigDecimal getPhosphateV1() {
		return this.phosphateV1;
	}

	public void setPhosphateV1(BigDecimal phosphateV1) {
		this.phosphateV1 = phosphateV1;
	}

	@Column(name = "chloride_v1", precision = 8)
	public BigDecimal getChlorideV1() {
		return this.chlorideV1;
	}

	public void setChlorideV1(BigDecimal chlorideV1) {
		this.chlorideV1 = chlorideV1;
	}

	@Column(name = "zinc_v1", precision = 8)
	public BigDecimal getZincV1() {
		return this.zincV1;
	}

	public void setZincV1(BigDecimal zincV1) {
		this.zincV1 = zincV1;
	}

	@Column(name = "acetate_v1", precision = 8)
	public BigDecimal getAcetateV1() {
		return this.acetateV1;
	}

	public void setAcetateV1(BigDecimal acetateV1) {
		this.acetateV1 = acetateV1;
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

	@Column(name = "updated_by", nullable = false)
	public long getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(long updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_date", nullable = false, length = 29)
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Column(name = "generic", length = 20)
	public String getGeneric() {
		return this.generic;
	}

	public void setGeneric(String generic) {
		this.generic = generic;
	}
	
	@Column(name = "glutamin", precision = 8)
	public BigDecimal getGlutamin() {
		return glutamin;
	}
	public void setGlutamin(BigDecimal glutamin) {
		this.glutamin = glutamin;
	}
	
	@Column(name = "calories", precision = 8)
	public BigDecimal getCalories() {
		return calories;
	}
	
	public void setCalories(BigDecimal calories) {
		this.calories = calories;
	}
	
}