package my.com.cmg.iwp.backend.model.integration.cdr;

import java.io.Serializable;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * The persistent class for the ph_cdr_infusion_drugs_int database table.
 * 
 */
@Entity
@Table(name = "t_cdr_infusion_drugs_int")
@XmlRootElement(name = "CdrInfusionDrugsInt")
@JsonIgnoreProperties(ignoreUnknown=true)
public class CdrInfusionDrugsInt implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long cdrInfusionIntSeqno;
	private String cancelReason;
	private Long createdBy;
	private Date createdDate;
	private String days;
	private Long diluent;
	private BigDecimal diluentOrderQty;
	private String diluentOrderQtyUomAbbreviation;
	private String dispenseLocationSetupCode;
	private String dispensedUomAbbreviation;
	private BigDecimal dosage;
	private String dosageCdrUom;
	private Long dosageUnit;
	private String drugCode;
	private BigDecimal drugOrderQty;
	private String drugOrderQtyUomAbbreviation;
	private String drugQtyUomAbbreviation;
	private String drugRemarks;
	private Integer duration;
	private String durationUnit;
	private Date endDateTime;
	private String freqCode;
	private String indicationCode;
	private Integer infusionOverHour;
	private Integer infusionOverMiniute;
	private BigDecimal infusionRate;
	private String infusionRateUnit;
	private Date nextCollectionDate;
	private Long nextDispenseLocation;
	private String orderStatus;
	private String parameter1;
	private String parameter2;
	private BigDecimal parameter3;
	private BigDecimal parameter4;
	private Date parameter5;
	private String prnRemarks;
	private String routeCode;
	private Date startDateTime;
	private BigDecimal totalDose;
	private BigDecimal totalDrugQty;
	private Long totalFluidUnit;
	private BigDecimal totalFluidVolume;
	private Long updatedBy;
	private Date updatedDate;
	private Set<CdrDoseFrequencyInt> cdrDoseFrequencyInts = new HashSet<CdrDoseFrequencyInt>(
			0);
	private CdrHdrInt cdrHdrInt;

	// private ArrayList<HashMap<String, Object>> cdrDoseFrequencyMap;
	public CdrInfusionDrugsInt() {
	}

	@Id
	@SequenceGenerator(name = "PH_CDR_INFUSION_DRUGS_INT_CDRINFUSIONINTSEQNO_GENERATOR", sequenceName = "t_cdr_infusion_drugs_int_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PH_CDR_INFUSION_DRUGS_INT_CDRINFUSIONINTSEQNO_GENERATOR")
	@Column(name = "cdr_infusion_int_seqno")
	public Long getCdrInfusionIntSeqno() {
		return this.cdrInfusionIntSeqno;
	}

	public void setCdrInfusionIntSeqno(Long cdrInfusionIntSeqno) {
		this.cdrInfusionIntSeqno = cdrInfusionIntSeqno;
	}

	@Column(name = "cancel_reason")
	public String getCancelReason() {
		return this.cancelReason;
	}

	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}

	@Column(name = "created_by")
	public Long getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "created_date")
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getDays() {
		return this.days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public Long getDiluent() {
		return this.diluent;
	}

	public void setDiluent(Long diluent) {
		this.diluent = diluent;
	}

	@Column(name = "diluent_order_qty")
	public BigDecimal getDiluentOrderQty() {
		return this.diluentOrderQty;
	}

	public void setDiluentOrderQty(BigDecimal diluentOrderQty) {
		this.diluentOrderQty = diluentOrderQty;
	}

	@Column(name = "diluent_order_qty_uom_abbr")
	public String getDiluentOrderQtyUomAbbreviation() {
		return this.diluentOrderQtyUomAbbreviation;
	}

	public void setDiluentOrderQtyUomAbbreviation(
			String diluentOrderQtyUomAbbreviation) {
		this.diluentOrderQtyUomAbbreviation = diluentOrderQtyUomAbbreviation;
	}

	@Column(name = "dispense_location_setup_code")
	public String getDispenseLocationSetupCode() {
		return this.dispenseLocationSetupCode;
	}

	public void setDispenseLocationSetupCode(String dispenseLocationSetupCode) {
		this.dispenseLocationSetupCode = dispenseLocationSetupCode;
	}

	@Column(name = "dispensed_uom_abbreviation")
	public String getDispensedUomAbbreviation() {
		return this.dispensedUomAbbreviation;
	}

	public void setDispensedUomAbbreviation(String dispensedUomAbbreviation) {
		this.dispensedUomAbbreviation = dispensedUomAbbreviation;
	}

	public BigDecimal getDosage() {
		return this.dosage;
	}

	public void setDosage(BigDecimal dosage) {
		this.dosage = dosage;
	}

	@Column(name = "dosage_cdr_uom")
	public String getDosageCdrUom() {
		return this.dosageCdrUom;
	}

	public void setDosageCdrUom(String dosageCdrUom) {
		this.dosageCdrUom = dosageCdrUom;
	}

	@Column(name = "dosage_unit")
	public Long getDosageUnit() {
		return this.dosageUnit;
	}

	public void setDosageUnit(Long dosageUnit) {
		this.dosageUnit = dosageUnit;
	}

	@Column(name = "drug_code")
	public String getDrugCode() {
		return this.drugCode;
	}

	public void setDrugCode(String drugCode) {
		this.drugCode = drugCode;
	}

	@Column(name = "drug_order_qty")
	public BigDecimal getDrugOrderQty() {
		return this.drugOrderQty;
	}

	public void setDrugOrderQty(BigDecimal drugOrderQty) {
		this.drugOrderQty = drugOrderQty;
	}

	@Column(name = "drug_order_qty_uom_abbr")
	public String getDrugOrderQtyUomAbbreviation() {
		return this.drugOrderQtyUomAbbreviation;
	}

	public void setDrugOrderQtyUomAbbreviation(
			String drugOrderQtyUomAbbreviation) {
		this.drugOrderQtyUomAbbreviation = drugOrderQtyUomAbbreviation;
	}

	@Column(name = "drug_qty_uom_abbreviation")
	public String getDrugQtyUomAbbreviation() {
		return this.drugQtyUomAbbreviation;
	}

	public void setDrugQtyUomAbbreviation(String drugQtyUomAbbreviation) {
		this.drugQtyUomAbbreviation = drugQtyUomAbbreviation;
	}

	@Column(name = "drug_remarks")
	public String getDrugRemarks() {
		return this.drugRemarks;
	}

	public void setDrugRemarks(String drugRemarks) {
		this.drugRemarks = drugRemarks;
	}

	public Integer getDuration() {
		return this.duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	@Column(name = "duration_unit")
	public String getDurationUnit() {
		return this.durationUnit;
	}

	public void setDurationUnit(String durationUnit) {
		this.durationUnit = durationUnit;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "end_date_time")
	public Date getEndDateTime() {
		return this.endDateTime;
	}

	public void setEndDateTime(Date endDateTime) {
		this.endDateTime = endDateTime;
	}

	@Column(name = "freq_code")
	public String getFreqCode() {
		return this.freqCode;
	}

	public void setFreqCode(String freqCode) {
		this.freqCode = freqCode;
	}

	@Column(name = "indication_code")
	public String getIndicationCode() {
		return this.indicationCode;
	}

	public void setIndicationCode(String indicationCode) {
		this.indicationCode = indicationCode;
	}

	@Column(name = "infusion_over_hour")
	public Integer getInfusionOverHour() {
		return this.infusionOverHour;
	}

	public void setInfusionOverHour(Integer infusionOverHour) {
		this.infusionOverHour = infusionOverHour;
	}

	@Column(name = "infusion_over_miniute")
	public Integer getInfusionOverMiniute() {
		return this.infusionOverMiniute;
	}

	public void setInfusionOverMiniute(Integer infusionOverMiniute) {
		this.infusionOverMiniute = infusionOverMiniute;
	}

	@Column(name = "infusion_rate")
	public BigDecimal getInfusionRate() {
		return this.infusionRate;
	}

	public void setInfusionRate(BigDecimal infusionRate) {
		this.infusionRate = infusionRate;
	}

	@Column(name = "infusion_rate_unit")
	public String getInfusionRateUnit() {
		return this.infusionRateUnit;
	}

	public void setInfusionRateUnit(String infusionRateUnit) {
		this.infusionRateUnit = infusionRateUnit;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "next_collection_date")
	public Date getNextCollectionDate() {
		return this.nextCollectionDate;
	}

	public void setNextCollectionDate(Date nextCollectionDate) {
		this.nextCollectionDate = nextCollectionDate;
	}

	@Column(name = "next_dispense_location")
	public Long getNextDispenseLocation() {
		return this.nextDispenseLocation;
	}

	public void setNextDispenseLocation(Long nextDispenseLocation) {
		this.nextDispenseLocation = nextDispenseLocation;
	}

	@Column(name = "order_status")
	public String getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getParameter1() {
		return this.parameter1;
	}

	public void setParameter1(String parameter1) {
		this.parameter1 = parameter1;
	}

	public String getParameter2() {
		return this.parameter2;
	}

	public void setParameter2(String parameter2) {
		this.parameter2 = parameter2;
	}

	public BigDecimal getParameter3() {
		return this.parameter3;
	}

	public void setParameter3(BigDecimal parameter3) {
		this.parameter3 = parameter3;
	}

	public BigDecimal getParameter4() {
		return this.parameter4;
	}

	public void setParameter4(BigDecimal parameter4) {
		this.parameter4 = parameter4;
	}

	@Temporal(TemporalType.DATE)
	public Date getParameter5() {
		return this.parameter5;
	}

	public void setParameter5(Date parameter5) {
		this.parameter5 = parameter5;
	}

	@Column(name = "prn_remarks")
	public String getPrnRemarks() {
		return this.prnRemarks;
	}

	public void setPrnRemarks(String prnRemarks) {
		this.prnRemarks = prnRemarks;
	}

	@Column(name = "route_code")
	public String getRouteCode() {
		return this.routeCode;
	}

	public void setRouteCode(String routeCode) {
		this.routeCode = routeCode;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "start_date_time")
	public Date getStartDateTime() {
		return this.startDateTime;
	}

	public void setStartDateTime(Date startDateTime) {
		this.startDateTime = startDateTime;
	}

	@Column(name = "total_dose")
	public BigDecimal getTotalDose() {
		return this.totalDose;
	}

	public void setTotalDose(BigDecimal totalDose) {
		this.totalDose = totalDose;
	}

	@Column(name = "total_drug_qty")
	public BigDecimal getTotalDrugQty() {
		return this.totalDrugQty;
	}

	public void setTotalDrugQty(BigDecimal totalDrugQty) {
		this.totalDrugQty = totalDrugQty;
	}

	@Column(name = "total_fluid_unit")
	public Long getTotalFluidUnit() {
		return this.totalFluidUnit;
	}

	public void setTotalFluidUnit(Long totalFluidUnit) {
		this.totalFluidUnit = totalFluidUnit;
	}

	@Column(name = "total_fluid_volume")
	public BigDecimal getTotalFluidVolume() {
		return this.totalFluidVolume;
	}

	public void setTotalFluidVolume(BigDecimal totalFluidVolume) {
		this.totalFluidVolume = totalFluidVolume;
	}

	@Column(name = "updated_by")
	public Long getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "updated_date")
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	// bi-directional many-to-one association to CdrDoseFrequencyInt
	@OneToMany(mappedBy = "cdrInfusionDrugsInt")
	@XmlElement
	@JsonManagedReference("CdrInfusionDoseFrequencyInt")
	public Set<CdrDoseFrequencyInt> getCdrDoseFrequencyInts() {
		return this.cdrDoseFrequencyInts;
	}

	public void setCdrDoseFrequencyInts(
			Set<CdrDoseFrequencyInt> cdrDoseFrequencyInts) {
		this.cdrDoseFrequencyInts = cdrDoseFrequencyInts;
	}

	// bi-directional many-to-one association to CdrHdrInt
	@ManyToOne
	@JoinColumn(name = "cdr_hdr_seqno")
	@XmlElement
	@JsonBackReference
	public CdrHdrInt getCdrHdrInt() {
		return this.cdrHdrInt;
	}

	public void setCdrHdrInt(CdrHdrInt cdrHdrInt) {
		this.cdrHdrInt = cdrHdrInt;
	}

	// /**
	// * @return the cdrDoseFrequencyMap
	// */
	// @Transient
	// @JsonIgnore
	// public ArrayList<HashMap<String, Object>> getCdrDoseFrequencyMap() {
	// return cdrDoseFrequencyMap;
	// }
	//
	// /**
	// * @param cdrDoseFrequencyMap the cdrDoseFrequencyMap to set
	// */
	// public void setCdrDoseFrequencyMap(ArrayList<HashMap<String, Object>>
	// cdrDoseFrequencyMap) {
	// this.cdrDoseFrequencyMap = cdrDoseFrequencyMap;
	// }

}