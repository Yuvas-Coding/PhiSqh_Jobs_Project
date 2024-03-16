package my.com.cmg.iwp.backend.model.integration.spub;

// default package
// Generated Nov 5, 2012 10:47:34 AM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "t_spub_alternate_int")
@XmlRootElement(name = "SpubAlternateInt")
@JsonIgnoreProperties(ignoreUnknown=true)
public class SpubAlternateInt implements java.io.Serializable{

	private long spubAlternateSeqno;
	private SpubDtlsInt spubDtlsInt;
	private String drugName;
	private String drugCode;
	private String dispenseUom;
	private BigDecimal orderDose;
	private String orderDoseUom;
	private BigDecimal qtyPerDose;
	private String qtyPerDoseUom;
	private BigDecimal altDrugDosage;
	private BigDecimal altDrugTotalDosage;
	private String altDrugDosageUom;
	private Integer duration = 0;
	private String durationUnit;
	private Double drugPrice;
	private Double drugAvgPrice;
	private Character fppYn = 'N';
	private Long createdBy;
	private Date createdDate;
	private Long updatedBy;
	private Date updatedDate;
	private Set<NormalDoseFreqAlternateInt> normalDoseFreqAlternateInts = new HashSet<NormalDoseFreqAlternateInt>();
	
	public SpubAlternateInt() {
	}
	
	@Id
	@Column(name = "spub_alternate_seqno", unique = true, nullable = false)
	@SequenceGenerator(name = "spub_alternate_seqno", sequenceName = "t_spub_alternate_int_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "spub_alternate_seqno")
	@JsonIgnore
	public long getSpubAlternateSeqno() {
		return spubAlternateSeqno;
	}
	public void setSpubAlternateSeqno(long spubAlternateSeqno) {
		this.spubAlternateSeqno = spubAlternateSeqno;
	}
	@Column(name = "drug_name")
	public String getDrugName() {
		return drugName;
	}
	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}
	@Column(name = "drug_code")
	public String getDrugCode() {
		return drugCode;
	}
	public void setDrugCode(String drugCode) {
		this.drugCode = drugCode;
	}
	@Column(name = "dispense_uom")
	public String getDispenseUom() {
		return dispenseUom;
	}
	public void setDispenseUom(String dispenseUom) {
		this.dispenseUom = dispenseUom;
	}
	@Column(name = "order_dose")
	public BigDecimal getOrderDose() {
		return orderDose;
	}
	public void setOrderDose(BigDecimal orderDose) {
		this.orderDose = orderDose;
	}
	@Column(name = "order_dose_uom")
	public String getOrderDoseUom() {
		return orderDoseUom;
	}
	public void setOrderDoseUom(String orderDoseUom) {
		this.orderDoseUom = orderDoseUom;
	}
	@Column(name = "qty_per_dose")
	public BigDecimal getQtyPerDose() {
		return qtyPerDose;
	}
	public void setQtyPerDose(BigDecimal qtyPerDose) {
		this.qtyPerDose = qtyPerDose;
	}
	@Column(name = "qty_per_dose_uom")
	public String getQtyPerDoseUom() {
		return qtyPerDoseUom;
	}
	public void setQtyPerDoseUom(String qtyPerDoseUom) {
		this.qtyPerDoseUom = qtyPerDoseUom;
	}
	@Column(name = "alt_drug_dosage")
	public BigDecimal getAltDrugDosage() {
		return altDrugDosage;
	}
	public void setAltDrugDosage(BigDecimal altDrugDosage) {
		this.altDrugDosage = altDrugDosage;
	}
	@Column(name = "alt_drug_total_dosage")
	public BigDecimal getAltDrugTotalDosage() {
		return altDrugTotalDosage;
	}
	public void setAltDrugTotalDosage(BigDecimal altDrugTotalDosage) {
		this.altDrugTotalDosage = altDrugTotalDosage;
	}
	@Column(name = "alt_drug_dosage_uom")
	public String getAltDrugDosageUom() {
		return altDrugDosageUom;
	}
	public void setAltDrugDosageUom(String altDrugDosageUom) {
		this.altDrugDosageUom = altDrugDosageUom;
	}
	@Column(name = "duration")
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	@Column(name = "duration_unit")
	public String getDurationUnit() {
		return durationUnit;
	}
	public void setDurationUnit(String durationUnit) {
		this.durationUnit = durationUnit;
	}
	@Column(name = "drug_price")
	public Double getDrugPrice() {
		return drugPrice;
	}
	public void setDrugPrice(Double drugPrice) {
		this.drugPrice = drugPrice;
	}
	@Column(name = "drug_avg_price")
	public Double getDrugAvgPrice() {
		return drugAvgPrice;
	}
	public void setDrugAvgPrice(Double drugAvgPrice) {
		this.drugAvgPrice = drugAvgPrice;
	}
	@Column(name = "fpp_yn")
	public Character getFppYn() {
		return fppYn;
	}
	public void setFppYn(Character fppYn) {
		this.fppYn = fppYn;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "spub_dtls_seqno")
	@JsonBackReference("SpubAlternateInt")
	public SpubDtlsInt getSpubDtlsInt() {
		return spubDtlsInt;
	}
	public void setSpubDtlsInt(SpubDtlsInt spubDtlsInt) {
		this.spubDtlsInt = spubDtlsInt;
	}

	@Column(name = "created_by")
	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "created_date")
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "updated_by")
	public Long getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Column(name = "updated_date")
	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	@OneToMany(mappedBy = "spubAlternateInt")
	@JsonManagedReference("NormalDoseFreqAlternateInt")
	public Set<NormalDoseFreqAlternateInt> getNormalDoseFreqAlternateInts() {
		return normalDoseFreqAlternateInts;
	}
	public void setNormalDoseFreqAlternateInts(Set<NormalDoseFreqAlternateInt> normalDoseFreqAlternateInts) {
		this.normalDoseFreqAlternateInts = normalDoseFreqAlternateInts;
	}
	
	
}