package my.com.cmg.iwp.backend.model.integration.cdr;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import my.com.cmg.iwp.backend.model.integration.OutsourceOrderInt;
import my.com.cmg.iwp.webui.constant.RefCodeConstant;


/**
 * The persistent class for the ph_cdr_drugs_int database table.
 * 
 */
@Entity
@Table(name="t_cdr_drugs_int")
@JsonIgnoreProperties(ignoreUnknown=true)
public class CdrDrugsInt implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long cdrDrugIntSeqno;
	private String cdrInfusionDrugYn;
	private Long createdBy;
	private Date createdDate;
	private String days;
	private String diluentDrugCode;
	private BigDecimal diluentOrderQty;
	private Integer dispensedQtyDiluent;
	private Integer dispensedQtyDrug;
	private String dispensedUomAbbreviation;
	private BigDecimal dosage;
	private String dosageCdrUom;
	private String dosageUnit;
	private String drugCode;
	private BigDecimal drugOrderQty;
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
	private String orderStatus;
	private Long outsourceIntSeqno;
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
	private String totalFluidUnit;
	private BigDecimal totalFluidVolume;
	private Long updatedBy;
	private Date updatedDate;
	private OutsourceOrderInt outsourceOrderInt;
	private Set<CdrDrugsScheduleInt> cdrDrugsScheduleInts = new HashSet<CdrDrugsScheduleInt>();
	private Set<CdrDispensingInt> cdrDispensingInts = new HashSet<CdrDispensingInt>();
	private String verificationStageRemark;
	private String dispenseStageRemark;
	private String preparationStageRemark;
	private BigDecimal drugBalQty;
	private BigDecimal diluentBalQty;
	
	private String doseDesc;
	private Character splitDoseYn = RefCodeConstant.BOOLEAN_FALSE;

	public CdrDrugsInt() {
	}

	public CdrDrugsInt(Long cdrDrugIntSeqno) {
		super();
		this.cdrDrugIntSeqno = cdrDrugIntSeqno;
	}

	@Id
	@SequenceGenerator(name="PH_CDR_DRUGS_INT_CDRDRUGINTSEQNO_GENERATOR", sequenceName="t_cdr_drugs_int_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PH_CDR_DRUGS_INT_CDRDRUGINTSEQNO_GENERATOR")
	@Column(name="cdr_drug_int_seqno")
	@JsonIgnore
	public Long getCdrDrugIntSeqno() {
		return this.cdrDrugIntSeqno;
	}

	public void setCdrDrugIntSeqno(Long cdrDrugIntSeqno) {
		this.cdrDrugIntSeqno = cdrDrugIntSeqno;
	}


	@Column(name="cdr_infusion_drug_yn")
	public String getCdrInfusionDrugYn() {
		return this.cdrInfusionDrugYn;
	}

	public void setCdrInfusionDrugYn(String cdrInfusionDrugYn) {
		this.cdrInfusionDrugYn = cdrInfusionDrugYn;
	}


	@Column(name="created_by")
	public Long getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}


	@Temporal( TemporalType.TIMESTAMP)
	@Column(name="created_date")
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


	@Column(name="diluent_drug_code")
	public String getDiluentDrugCode() {
		return this.diluentDrugCode;
	}

	public void setDiluentDrugCode(String diluentDrugCode) {
		this.diluentDrugCode = diluentDrugCode;
	}


	@Column(name="diluent_order_qty")
	public BigDecimal getDiluentOrderQty() {
		return this.diluentOrderQty;
	}

	public void setDiluentOrderQty(BigDecimal diluentOrderQty) {
		this.diluentOrderQty = diluentOrderQty;
	}


	@Column(name="dispensed_qty_diluent")
	public Integer getDispensedQtyDiluent() {
		return this.dispensedQtyDiluent;
	}

	public void setDispensedQtyDiluent(Integer dispensedQtyDiluent) {
		this.dispensedQtyDiluent = dispensedQtyDiluent;
	}


	@Column(name="dispensed_qty_drug")
	public Integer getDispensedQtyDrug() {
		return this.dispensedQtyDrug;
	}

	public void setDispensedQtyDrug(Integer dispensedQtyDrug) {
		this.dispensedQtyDrug = dispensedQtyDrug;
	}


	@Column(name="dispensed_uom_abbreviation")
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


	@Column(name="dosage_cdr_uom")
	public String getDosageCdrUom() {
		return this.dosageCdrUom;
	}

	public void setDosageCdrUom(String dosageCdrUom) {
		this.dosageCdrUom = dosageCdrUom;
	}


	@Column(name="dosage_unit")
	public String getDosageUnit() {
		return this.dosageUnit;
	}

	public void setDosageUnit(String dosageUnit) {
		this.dosageUnit = dosageUnit;
	}


	@Column(name="drug_code")
	public String getDrugCode() {
		return this.drugCode;
	}

	public void setDrugCode(String drugCode) {
		this.drugCode = drugCode;
	}


	@Column(name="drug_order_qty")
	public BigDecimal getDrugOrderQty() {
		return this.drugOrderQty;
	}

	public void setDrugOrderQty(BigDecimal drugOrderQty) {
		this.drugOrderQty = drugOrderQty;
	}


	@Column(name="drug_qty_uom_abbreviation")
	public String getDrugQtyUomAbbreviation() {
		return this.drugQtyUomAbbreviation;
	}

	public void setDrugQtyUomAbbreviation(String drugQtyUomAbbreviation) {
		this.drugQtyUomAbbreviation = drugQtyUomAbbreviation;
	}


	@Column(name="drug_remarks")
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


	@Column(name="duration_unit")
	public String getDurationUnit() {
		return this.durationUnit;
	}

	public void setDurationUnit(String durationUnit) {
		this.durationUnit = durationUnit;
	}


	@Temporal( TemporalType.TIMESTAMP)
	@Column(name="end_date_time")
	public Date getEndDateTime() {
		return this.endDateTime;
	}

	public void setEndDateTime(Date endDateTime) {
		this.endDateTime = endDateTime;
	}


	@Column(name="freq_code")
	public String getFreqCode() {
		return this.freqCode;
	}

	public void setFreqCode(String freqCode) {
		this.freqCode = freqCode;
	}


	@Column(name="indication_code")
	public String getIndicationCode() {
		return this.indicationCode;
	}

	public void setIndicationCode(String indicationCode) {
		this.indicationCode = indicationCode;
	}


	@Column(name="infusion_over_hour")
	public Integer getInfusionOverHour() {
		return this.infusionOverHour;
	}

	public void setInfusionOverHour(Integer infusionOverHour) {
		this.infusionOverHour = infusionOverHour;
	}


	@Column(name="infusion_over_miniute")
	public Integer getInfusionOverMiniute() {
		return this.infusionOverMiniute;
	}

	public void setInfusionOverMiniute(Integer infusionOverMiniute) {
		this.infusionOverMiniute = infusionOverMiniute;
	}


	@Column(name="infusion_rate")
	public BigDecimal getInfusionRate() {
		return this.infusionRate;
	}

	public void setInfusionRate(BigDecimal infusionRate) {
		this.infusionRate = infusionRate;
	}


	@Column(name="infusion_rate_unit")
	public String getInfusionRateUnit() {
		return this.infusionRateUnit;
	}

	public void setInfusionRateUnit(String infusionRateUnit) {
		this.infusionRateUnit = infusionRateUnit;
	}


	@Column(name="order_status")
	public String getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}


	@Column(name="outsource_int_seqno", insertable=false, updatable=false)
	public Long getOutsourceIntSeqno() {
		return this.outsourceIntSeqno;
	}

	public void setOutsourceIntSeqno(Long outsourceIntSeqno) {
		this.outsourceIntSeqno = outsourceIntSeqno;
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


	@Temporal( TemporalType.DATE)
	public Date getParameter5() {
		return this.parameter5;
	}

	public void setParameter5(Date parameter5) {
		this.parameter5 = parameter5;
	}


	@Column(name="prn_remarks")
	public String getPrnRemarks() {
		return this.prnRemarks;
	}

	public void setPrnRemarks(String prnRemarks) {
		this.prnRemarks = prnRemarks;
	}


	@Column(name="route_code")
	public String getRouteCode() {
		return this.routeCode;
	}

	public void setRouteCode(String routeCode) {
		this.routeCode = routeCode;
	}


	@Temporal( TemporalType.TIMESTAMP)
	@Column(name="start_date_time")
	public Date getStartDateTime() {
		return this.startDateTime;
	}

	public void setStartDateTime(Date startDateTime) {
		this.startDateTime = startDateTime;
	}


	@Column(name="total_dose")
	public BigDecimal getTotalDose() {
		return this.totalDose;
	}

	public void setTotalDose(BigDecimal totalDose) {
		this.totalDose = totalDose;
	}


	@Column(name="total_drug_qty")
	public BigDecimal getTotalDrugQty() {
		return this.totalDrugQty;
	}

	public void setTotalDrugQty(BigDecimal totalDrugQty) {
		this.totalDrugQty = totalDrugQty;
	}


	@Column(name="total_fluid_unit")
	public String getTotalFluidUnit() {
		return this.totalFluidUnit;
	}

	public void setTotalFluidUnit(String totalFluidUnit) {
		this.totalFluidUnit = totalFluidUnit;
	}


	@Column(name="total_fluid_volume")
	public BigDecimal getTotalFluidVolume() {
		return this.totalFluidVolume;
	}

	public void setTotalFluidVolume(BigDecimal totalFluidVolume) {
		this.totalFluidVolume = totalFluidVolume;
	}


	@Column(name="updated_by")
	public Long getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}


	@Column(name="updated_date")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Column(name="verification_stage_remark")
	public String getVerificationStageRemark() {
		return this.verificationStageRemark;
	}

	@Column(name="dispense_stage_remark")
	public String getDispenseStageRemark() {
		return this.dispenseStageRemark;
	}

	@Column(name="preparation_stage_remark")
	public String getPreparationStageRemark() {
		return this.preparationStageRemark;
	}

	public void setVerificationStageRemark(String verificationStageRemark) {
		this.verificationStageRemark = verificationStageRemark;
	}

	public void setDispenseStageRemark(String dispenseStageRemark) {
		this.dispenseStageRemark = dispenseStageRemark;
	}

	public void setPreparationStageRemark(String preparationStageRemark) {
		this.preparationStageRemark = preparationStageRemark;
	}

	@Column(name="drug_bal_qty")
	public BigDecimal getDrugBalQty() {
		return this.drugBalQty;
	}

	public void setDrugBalQty(BigDecimal drugBalQty) {
		this.drugBalQty = drugBalQty;
	}

	@Column(name="diluent_bal_qty")
	public BigDecimal getDiluentBalQty() {
		return this.diluentBalQty;
	}

	public void setDiluentBalQty(BigDecimal diluentBalQty) {
		this.diluentBalQty = diluentBalQty;
	}


	//bi-directional many-to-one association to CdrDrugsScheduleInt
	@OneToMany(mappedBy="cdrDrugsInt", cascade=CascadeType.ALL)
	@JsonManagedReference("CdrDrugsScheduleInt")
	public Set<CdrDrugsScheduleInt> getCdrDrugsScheduleInts() {
		return this.cdrDrugsScheduleInts;
	}

	public void setCdrDrugsScheduleInts(Set<CdrDrugsScheduleInt> cdrDrugsScheduleInts) {
		this.cdrDrugsScheduleInts = cdrDrugsScheduleInts;
	}

	@ManyToOne
	@JoinColumn(name="outsource_int_seqno", referencedColumnName="outsource_int_seqno")
	@JsonBackReference("CdrDrugsInt")
	public OutsourceOrderInt getOutsourceOrderInt() {
		return this.outsourceOrderInt;
	}

	public void setOutsourceOrderInt(OutsourceOrderInt outsourceOrderInt) {
		this.outsourceOrderInt = outsourceOrderInt;
	}

	@OneToMany(mappedBy="cdrDrugsInt", cascade=CascadeType.ALL)
	@JsonManagedReference("CdrDispensingInt")
	public Set<CdrDispensingInt> getCdrDispensingInts() {
		return this.cdrDispensingInts;
	}

	public void setCdrDispensingInts(Set<CdrDispensingInt> cdrDispensingInts) {
		this.cdrDispensingInts = cdrDispensingInts;
	}

	@Column(name="dose_desc")
	public String getDoseDesc() {
		return doseDesc;
	}

	public void setDoseDesc(String doseDesc) {
		this.doseDesc = doseDesc;
	}

	@Column(name="split_dose_yn")
	public Character getSplitDoseYn() {
		return splitDoseYn;
	}

	public void setSplitDoseYn(Character splitDoseYn) {
		this.splitDoseYn = splitDoseYn;
	}
	
	
	
	
	
}