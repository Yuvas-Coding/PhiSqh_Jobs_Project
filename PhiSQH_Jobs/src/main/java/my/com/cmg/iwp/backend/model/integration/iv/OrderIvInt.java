package my.com.cmg.iwp.backend.model.integration.iv;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
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
 * The persistent class for the ph_order_iv_int database table.
 * 
 */
@Entity
@Table(name = "t_order_iv_int")
@XmlRootElement(name = "OrderIvInt")
@JsonIgnoreProperties(ignoreUnknown=true)
public class OrderIvInt implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long orderIvIntSeqno;
	private String cancelReason;
	private Long createdBy;
	private Date createdDate;
	private String diluentDrugCode;
	private Integer diluentOrderQty;
	private String diluentOrderQtyUomAbbr;
	private String dispenseLocationSetupCode;
	private Integer dispensedQtyDiluent;
	private Integer dispensedQtyDrug;
	private String dispensedUomAbbreviation;
	private BigDecimal dosage;
	private Long dosageUnit;
	private String drugCode;
	private Integer drugOrderQty;
	private String drugOrderQtyUomAbbr;
	private String drugQtyUomAbbreviation;
	private String drugRemarks;
	private Integer duration;
	private String durationUnit;
	private Date endDateTime;
	private Integer fluidVolume;
	private String freqCode;
	private String indicationCode;
	private Integer infuseOverHour;
	private Integer infuseOverMinute;
	private BigDecimal infuseRate;
	private String infuseRateUnit;
	private String inoDosageUom;
	private BigDecimal inoTotalDose;
	private String inotropeYn;
	private String ivFluidYn;
	private String orderStatus;
	private String parameter1;
	private String parameter2;
	private BigDecimal parameter3;
	private BigDecimal parameter4;
	private Date parameter5;
	private String prnRemarks;
	private String routeCode;
	private Date startDateTime;
	private BigDecimal strength;
	private String subOrderStatFlag;
	private BigDecimal totalDrugQty;
	private Long updatedBy;
	private Date updatedDate;
	private IvHdrInt ivHdrInt;
	private List<IvDoseFrequencyInt> ivDoseFrequencyInts;

	public OrderIvInt() {
	}

	@Id
	@SequenceGenerator(name = "PH_ORDER_IV_INT_ORDERIVINTSEQNO_GENERATOR", sequenceName = "t_order_iv_int_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PH_ORDER_IV_INT_ORDERIVINTSEQNO_GENERATOR")
	@Column(name = "order_iv_int_seqno")
	public Long getOrderIvIntSeqno() {
		return this.orderIvIntSeqno;
	}

	public void setOrderIvIntSeqno(Long orderIvIntSeqno) {
		this.orderIvIntSeqno = orderIvIntSeqno;
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

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date")
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "diluent_drug_code")
	public String getDiluentDrugCode() {
		return this.diluentDrugCode;
	}

	public void setDiluentDrugCode(String diluentDrugCode) {
		this.diluentDrugCode = diluentDrugCode;
	}

	@Column(name = "diluent_order_qty")
	public Integer getDiluentOrderQty() {
		return this.diluentOrderQty;
	}

	public void setDiluentOrderQty(Integer diluentOrderQty) {
		this.diluentOrderQty = diluentOrderQty;
	}

	@Column(name = "diluent_order_qty_uom_abbr")
	public String getDiluentOrderQtyUomAbbr() {
		return this.diluentOrderQtyUomAbbr;
	}

	public void setDiluentOrderQtyUomAbbr(String diluentOrderQtyUomAbbr) {
		this.diluentOrderQtyUomAbbr = diluentOrderQtyUomAbbr;
	}

	@Column(name = "dispense_location_setup_code")
	public String getDispenseLocationSetupCode() {
		return this.dispenseLocationSetupCode;
	}

	public void setDispenseLocationSetupCode(String dispenseLocationSetupCode) {
		this.dispenseLocationSetupCode = dispenseLocationSetupCode;
	}

	@Column(name = "dispensed_qty_diluent")
	public Integer getDispensedQtyDiluent() {
		return this.dispensedQtyDiluent;
	}

	public void setDispensedQtyDiluent(Integer dispensedQtyDiluent) {
		this.dispensedQtyDiluent = dispensedQtyDiluent;
	}

	@Column(name = "dispensed_qty_drug")
	public Integer getDispensedQtyDrug() {
		return this.dispensedQtyDrug;
	}

	public void setDispensedQtyDrug(Integer dispensedQtyDrug) {
		this.dispensedQtyDrug = dispensedQtyDrug;
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
	public Integer getDrugOrderQty() {
		return this.drugOrderQty;
	}

	public void setDrugOrderQty(Integer drugOrderQty) {
		this.drugOrderQty = drugOrderQty;
	}

	@Column(name = "drug_order_qty_uom_abbr")
	public String getDrugOrderQtyUomAbbr() {
		return this.drugOrderQtyUomAbbr;
	}

	public void setDrugOrderQtyUomAbbr(String drugOrderQtyUomAbbr) {
		this.drugOrderQtyUomAbbr = drugOrderQtyUomAbbr;
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

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end_date_time")
	public Date getEndDateTime() {
		return this.endDateTime;
	}

	public void setEndDateTime(Date endDateTime) {
		this.endDateTime = endDateTime;
	}

	@Column(name = "fluid_volume")
	public Integer getFluidVolume() {
		return this.fluidVolume;
	}

	public void setFluidVolume(Integer fluidVolume) {
		this.fluidVolume = fluidVolume;
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

	@Column(name = "infuse_over_hour")
	public Integer getInfuseOverHour() {
		return this.infuseOverHour;
	}

	public void setInfuseOverHour(Integer infuseOverHour) {
		this.infuseOverHour = infuseOverHour;
	}

	@Column(name = "infuse_over_minute")
	public Integer getInfuseOverMinute() {
		return this.infuseOverMinute;
	}

	public void setInfuseOverMinute(Integer infuseOverMinute) {
		this.infuseOverMinute = infuseOverMinute;
	}

	@Column(name = "infuse_rate")
	public BigDecimal getInfuseRate() {
		return this.infuseRate;
	}

	public void setInfuseRate(BigDecimal infuseRate) {
		this.infuseRate = infuseRate;
	}

	@Column(name = "infuse_rate_unit")
	public String getInfuseRateUnit() {
		return this.infuseRateUnit;
	}

	public void setInfuseRateUnit(String infuseRateUnit) {
		this.infuseRateUnit = infuseRateUnit;
	}

	@Column(name = "ino_dosage_uom")
	public String getInoDosageUom() {
		return this.inoDosageUom;
	}

	public void setInoDosageUom(String inoDosageUom) {
		this.inoDosageUom = inoDosageUom;
	}

	@Column(name = "ino_total_dose")
	public BigDecimal getInoTotalDose() {
		return this.inoTotalDose;
	}

	public void setInoTotalDose(BigDecimal inoTotalDose) {
		this.inoTotalDose = inoTotalDose;
	}

	@Column(name = "inotrope_yn")
	public String getInotropeYn() {
		return this.inotropeYn;
	}

	public void setInotropeYn(String inotropeYn) {
		this.inotropeYn = inotropeYn;
	}

	@Column(name = "iv_fluid_yn")
	public String getIvFluidYn() {
		return this.ivFluidYn;
	}

	public void setIvFluidYn(String ivFluidYn) {
		this.ivFluidYn = ivFluidYn;
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

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "start_date_time")
	public Date getStartDateTime() {
		return this.startDateTime;
	}

	public void setStartDateTime(Date startDateTime) {
		this.startDateTime = startDateTime;
	}

	public BigDecimal getStrength() {
		return this.strength;
	}

	public void setStrength(BigDecimal strength) {
		this.strength = strength;
	}

	@Column(name = "sub_order_stat_flag")
	public String getSubOrderStatFlag() {
		return this.subOrderStatFlag;
	}

	public void setSubOrderStatFlag(String subOrderStatFlag) {
		this.subOrderStatFlag = subOrderStatFlag;
	}

	@Column(name = "total_drug_qty")
	public BigDecimal getTotalDrugQty() {
		return this.totalDrugQty;
	}

	public void setTotalDrugQty(BigDecimal totalDrugQty) {
		this.totalDrugQty = totalDrugQty;
	}

	@Column(name = "updated_by")
	public Long getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_date")
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	// bi-directional many-to-one association to IvHdrInt
	@ManyToOne
	@JoinColumn(name = "iv_hdr_int_seqno")
	@JsonBackReference
	public IvHdrInt getIvHdrInt() {
		return this.ivHdrInt;
	}

	public void setIvHdrInt(IvHdrInt ivHdrInt) {
		this.ivHdrInt = ivHdrInt;
	}

	// bi-directional many-to-one association to IvDoseFrequencyInt
	@OneToMany(mappedBy = "orderIvInt")
	@XmlElement
	@JsonManagedReference
	public List<IvDoseFrequencyInt> getIvDoseFrequencyInts() {
		return this.ivDoseFrequencyInts;
	}

	public void setIvDoseFrequencyInts(
			List<IvDoseFrequencyInt> ivDoseFrequencyInts) {
		this.ivDoseFrequencyInts = ivDoseFrequencyInts;
	}

}