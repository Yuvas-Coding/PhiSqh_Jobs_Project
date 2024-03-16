package my.com.cmg.iwp.backend.model.integration.pn;

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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import my.com.cmg.iwp.backend.model.integration.OutsourceOrderInt;

/**
 * The persistent class for the ph_pn_order_regimen_int database table.
 * 
 */
@Entity
@Table(name = "T_PN_ORDER_REGIMEN_INT")
@XmlRootElement(name = "PnOrderRegimenInt")
@JsonIgnoreProperties(ignoreUnknown=true)
public class PnOrderRegimenInt implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long regimenIntSeqno;
	private BigDecimal acetateQtyPerWeightOri;
	private BigDecimal acetateQuantity;
	private BigDecimal acetateQuantityOri;
	private BigDecimal acetateQuantityPerWeight;
	private String addAdditive;
	private String addAdditiveOri;
	private String assignTo;
	private String authorizationStatus;
	private BigDecimal birthWeight;
	private BigDecimal bodyWeight;
	private String bodyWeightType;
	private BigDecimal calciumQtyPerWeightOri;
	private BigDecimal calciumQuantity;
	private BigDecimal calciumQuantityOri;
	private BigDecimal calciumQuantityPerWeight;
	private String cancelReason;
	private BigDecimal carbohydrate;
	private BigDecimal carbohydrateEnergy;
	private BigDecimal carbohydrateEnergyDisplay;
	private BigDecimal carbohydrateEnergyOri;
	private BigDecimal carbohydrateOri;
	private BigDecimal carbohydratePerkg;
	private BigDecimal carbohydratePerkgOri;
	private BigDecimal carbohydrateRatio;
	private String carbohydrateUnit;
	private String carbohydrateUnitOri;
	private BigDecimal chlorideQtyPerWeightOri;
	private BigDecimal chlorideQuantity;
	private BigDecimal chlorideQuantityOri;
	private BigDecimal chlorideQuantityPerWeight;
	private Long createdBy;
	private Date createdDate;
	private BigDecimal currentWeight;
	private BigDecimal dosageVol;
	private BigDecimal dosageVolOri;
	private String drugCode;
	private int duration;
	private int durationOri;
	private String durationUnit;
	private String durationUnitOri;
	private Date endDateTime;
	private Date endDateTimeOri;
	private BigDecimal fatSolubleQtyPerWeight;
	private BigDecimal fatSolubleQtyPerWeightOri;
	private BigDecimal fatSolubleQuantity;
	private BigDecimal fatSolubleQuantityOri;
	private String freqCode;
	private String freqCodeOri;
	private String holdByDctrYn;
	private String holdResumeBy;
	private BigDecimal infuseOver;
	private BigDecimal infuseOverOri;
	private String infuseOverUnit;
	private String infuseOverUnitOri;
	private String infusionLine;
	private String infusionLineOri;
	private BigDecimal infusionRate;
	private BigDecimal infusionRateOri;
	private String infusionRateUnit;
	private String ingredientsOthers;
	private BigDecimal ingredientsOthersPerWeight;
	private BigDecimal ingredientsOthersQuantity;
	private BigDecimal lipid;
	private BigDecimal lipidEnergy;
	private BigDecimal lipidEnergyDisplay;
	private BigDecimal lipidEnergyOri;
	private BigDecimal lipidOri;
	private BigDecimal lipidRatio;
	private BigDecimal lipidWeightPerkg;
	private BigDecimal lipidWeightPerkgOri;
	private BigDecimal magnesiumQtyPerWeightOri;
	private BigDecimal magnesiumQuantity;
	private BigDecimal magnesiumQuantityOri;
	private BigDecimal magnesiumQuantityPerWeight;
	private BigDecimal nRatio;
	private BigDecimal nitrogenContent;
	private BigDecimal npcRatio;
	private BigDecimal orderQuantity;
	private BigDecimal orderQuantityOri;
	private String orderStatus;
	private Long outsourceIntSeqno;
	private String parameter1;
	private String parameter2;
	private BigDecimal parameter3;
	private BigDecimal parameter4;
	private Date parameter5;
	private BigDecimal phosphateQtyPerWeightOri;
	private BigDecimal phosphateQuantity;
	private BigDecimal phosphateQuantityOri;
	private BigDecimal phosphateQuantityPerWeight;
	private String pnFor;
	private BigDecimal potassiumQtyPerWeightOri;
	private BigDecimal potassiumQuantity;
	private BigDecimal potassiumQuantityOri;
	private BigDecimal potassiumQuantityPerWeight;
	private BigDecimal protein;
	private BigDecimal proteinEnergy;
	private BigDecimal proteinEnergyDisplay;
	private BigDecimal proteinEnergyOri;
	private BigDecimal proteinOri;
	private BigDecimal proteinWeightPerkg;
	private BigDecimal proteinWeightPerkgOri;
	private String remarks;
	private String remarksOri;
	private String singleVitamin;
	private String singleVitaminOri;
	private BigDecimal sodiumQuantity;
	private BigDecimal sodiumQuantityOri;
	private BigDecimal sodiumQuantityPerWeight;
	private BigDecimal sodiumQuantityPerWeightOri;
	private Date startDate;
	private Date startDateOri;
	private BigDecimal totalEnergyPerday;
	private BigDecimal totalEnergyPerdayOri;
	private BigDecimal totalEnergyPerweight;
	private BigDecimal totalEnergyPerweightOri;
	private BigDecimal totalVolume;
	private BigDecimal totalVolumeOri;
	private BigDecimal traceEleQtyPerWeight;
	private BigDecimal traceEleQtyPerWeightOri;
	private BigDecimal traceElementQuantityOri;
	private BigDecimal traceElementsQuantity;
	private String typeOfPn;
	private Long updatedBy;
	private Date updatedDate;
	private BigDecimal vitaminSolQtyPerWeight;
	private BigDecimal vitaminSolQtyPerWeightOri;
	private BigDecimal vitaminSolutionQuantity;
	private BigDecimal vitaminSolutionQuantityOri;
	private BigDecimal volumePnperkg;
	private BigDecimal volumePnperkgOri;
	private BigDecimal waterSolQtyPerWeight;
	private BigDecimal waterSolQtyPerWeightOri;
	private BigDecimal waterSolubleQuantity;
	private BigDecimal waterSolubleQuantityOri;
	private String sendFlag;
	private BigDecimal glutaminEnergy;
	private BigDecimal glutaminEnergyOri;
	private BigDecimal glutaminQuantity;
	private BigDecimal glutaminQuantityOri;
	private BigDecimal glutaminWeightPerkg;
	private BigDecimal glutaminWeightPerkgOri;
	private BigDecimal oralFeedingPerkgOri;
	private BigDecimal oralFeedingPerkg;
	private BigDecimal oralFeedingOri;
	private BigDecimal oralFeeding;
	private BigDecimal tpnVolumePerkgOri;
	private BigDecimal tpnVolumePerkg;
	private BigDecimal tpnVolumeOri;
	private BigDecimal tpnVolume;
	
	private String indication;

	private Set<PnNutritionalAssmntInt> pnNutritionalAssmntInts = new HashSet<PnNutritionalAssmntInt>();
	private Set<PnOrderTotalEnergyInt> pnOrderTotalEnergyInts = new HashSet<PnOrderTotalEnergyInt>();
	private OutsourceOrderInt outsourceOrderInt;
	
	private String useFluidCalculator = "N";
	
	private String verificationRemarks;
	private String preparationRemarks;
	private String dispensingRemarks;
	
	private BigDecimal sodiumAdd;
	private BigDecimal sodiumAddOri;
	private BigDecimal potassiumAdd;
	private BigDecimal potassiumAddOri;
	private BigDecimal calciumAdd;
	private BigDecimal calciumAddOri;
	private BigDecimal magnesiumAdd;
	private BigDecimal magnesiumAddOri;
	private BigDecimal phosphateAdd;
	private BigDecimal phosphateAddOri;
	private BigDecimal acetateAdd;
	private BigDecimal acetateAddOri;
	private BigDecimal traceElmntAdd;
	private BigDecimal traceElmntAddOri;
	private BigDecimal glutaminAdd;
	private BigDecimal glutaminAddOri;
	private BigDecimal fatSolubleAdd;
	private BigDecimal fatSolubleAddOri;
	private BigDecimal waterSolubleAdd;
	private BigDecimal waterSolubleAddOri;
	private BigDecimal vitSolutionAdd;
	private BigDecimal vitSolutionAddOri;

	public PnOrderRegimenInt() {
	}

	@Id
	@SequenceGenerator(name = "PH_PN_ORDER_REGIMEN_INT_REGIMENINTSEQNO_GENERATOR", sequenceName = "T_PN_ORDER_REGIMEN_INT_SEQ", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PH_PN_ORDER_REGIMEN_INT_REGIMENINTSEQNO_GENERATOR")
	@Column(name = "regimen_int_seqno")
	public Long getRegimenIntSeqno() {
		return this.regimenIntSeqno;
	}

	public void setRegimenIntSeqno(Long regimenIntSeqno) {
		this.regimenIntSeqno = regimenIntSeqno;
	}

	@Column(name="acetate_qty_per_weight_ori")
	public BigDecimal getAcetateQtyPerWeightOri() {
		return this.acetateQtyPerWeightOri;
	}

	public void setAcetateQtyPerWeightOri(BigDecimal acetateQtyPerWeightOri) {
		this.acetateQtyPerWeightOri = acetateQtyPerWeightOri;
	}


	@Column(name="acetate_quantity")
	public BigDecimal getAcetateQuantity() {
		return this.acetateQuantity;
	}

	public void setAcetateQuantity(BigDecimal acetateQuantity) {
		this.acetateQuantity = acetateQuantity;
	}


	@Column(name="acetate_quantity_ori")
	public BigDecimal getAcetateQuantityOri() {
		return this.acetateQuantityOri;
	}

	public void setAcetateQuantityOri(BigDecimal acetateQuantityOri) {
		this.acetateQuantityOri = acetateQuantityOri;
	}


	@Column(name="acetate_quantity_per_weight")
	public BigDecimal getAcetateQuantityPerWeight() {
		return this.acetateQuantityPerWeight;
	}

	public void setAcetateQuantityPerWeight(BigDecimal acetateQuantityPerWeight) {
		this.acetateQuantityPerWeight = acetateQuantityPerWeight;
	}


	@Column(name="add_additive")
	public String getAddAdditive() {
		return this.addAdditive;
	}

	public void setAddAdditive(String addAdditive) {
		this.addAdditive = addAdditive;
	}


	@Column(name="add_additive_ori")
	public String getAddAdditiveOri() {
		return this.addAdditiveOri;
	}

	public void setAddAdditiveOri(String addAdditiveOri) {
		this.addAdditiveOri = addAdditiveOri;
	}


	@Column(name="assign_to")
	public String getAssignTo() {
		return this.assignTo;
	}

	public void setAssignTo(String assignTo) {
		this.assignTo = assignTo;
	}


	@Column(name="authorization_status")
	public String getAuthorizationStatus() {
		return this.authorizationStatus;
	}

	public void setAuthorizationStatus(String authorizationStatus) {
		this.authorizationStatus = authorizationStatus;
	}


	@Column(name="birth_weight")
	public BigDecimal getBirthWeight() {
		return this.birthWeight;
	}

	public void setBirthWeight(BigDecimal birthWeight) {
		this.birthWeight = birthWeight;
	}


	@Column(name="body_weight")
	public BigDecimal getBodyWeight() {
		return this.bodyWeight;
	}

	public void setBodyWeight(BigDecimal bodyWeight) {
		this.bodyWeight = bodyWeight;
	}


	@Column(name="body_weight_type")
	public String getBodyWeightType() {
		return this.bodyWeightType;
	}

	public void setBodyWeightType(String bodyWeightType) {
		this.bodyWeightType = bodyWeightType;
	}


	@Column(name="calcium_qty_per_weight_ori")
	public BigDecimal getCalciumQtyPerWeightOri() {
		return this.calciumQtyPerWeightOri;
	}

	public void setCalciumQtyPerWeightOri(BigDecimal calciumQtyPerWeightOri) {
		this.calciumQtyPerWeightOri = calciumQtyPerWeightOri;
	}


	@Column(name="calcium_quantity")
	public BigDecimal getCalciumQuantity() {
		return this.calciumQuantity;
	}

	public void setCalciumQuantity(BigDecimal calciumQuantity) {
		this.calciumQuantity = calciumQuantity;
	}


	@Column(name="calcium_quantity_ori")
	public BigDecimal getCalciumQuantityOri() {
		return this.calciumQuantityOri;
	}

	public void setCalciumQuantityOri(BigDecimal calciumQuantityOri) {
		this.calciumQuantityOri = calciumQuantityOri;
	}


	@Column(name="calcium_quantity_per_weight")
	public BigDecimal getCalciumQuantityPerWeight() {
		return this.calciumQuantityPerWeight;
	}

	public void setCalciumQuantityPerWeight(BigDecimal calciumQuantityPerWeight) {
		this.calciumQuantityPerWeight = calciumQuantityPerWeight;
	}


	@Column(name="cancel_reason")
	public String getCancelReason() {
		return this.cancelReason;
	}

	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}


	public BigDecimal getCarbohydrate() {
		return this.carbohydrate;
	}

	public void setCarbohydrate(BigDecimal carbohydrate) {
		this.carbohydrate = carbohydrate;
	}


	@Column(name="carbohydrate_energy")
	public BigDecimal getCarbohydrateEnergy() {
		return this.carbohydrateEnergy;
	}

	public void setCarbohydrateEnergy(BigDecimal carbohydrateEnergy) {
		this.carbohydrateEnergy = carbohydrateEnergy;
	}


	@Column(name="carbohydrate_energy_display")
	public BigDecimal getCarbohydrateEnergyDisplay() {
		return this.carbohydrateEnergyDisplay;
	}

	public void setCarbohydrateEnergyDisplay(BigDecimal carbohydrateEnergyDisplay) {
		this.carbohydrateEnergyDisplay = carbohydrateEnergyDisplay;
	}


	@Column(name="carbohydrate_energy_ori")
	public BigDecimal getCarbohydrateEnergyOri() {
		return this.carbohydrateEnergyOri;
	}

	public void setCarbohydrateEnergyOri(BigDecimal carbohydrateEnergyOri) {
		this.carbohydrateEnergyOri = carbohydrateEnergyOri;
	}


	@Column(name="carbohydrate_ori")
	public BigDecimal getCarbohydrateOri() {
		return this.carbohydrateOri;
	}

	public void setCarbohydrateOri(BigDecimal carbohydrateOri) {
		this.carbohydrateOri = carbohydrateOri;
	}


	@Column(name="carbohydrate_perkg")
	public BigDecimal getCarbohydratePerkg() {
		return this.carbohydratePerkg;
	}

	public void setCarbohydratePerkg(BigDecimal carbohydratePerkg) {
		this.carbohydratePerkg = carbohydratePerkg;
	}


	@Column(name="carbohydrate_perkg_ori")
	public BigDecimal getCarbohydratePerkgOri() {
		return this.carbohydratePerkgOri;
	}

	public void setCarbohydratePerkgOri(BigDecimal carbohydratePerkgOri) {
		this.carbohydratePerkgOri = carbohydratePerkgOri;
	}


	@Column(name="carbohydrate_ratio")
	public BigDecimal getCarbohydrateRatio() {
		return this.carbohydrateRatio;
	}

	public void setCarbohydrateRatio(BigDecimal carbohydrateRatio) {
		this.carbohydrateRatio = carbohydrateRatio;
	}


	@Column(name="carbohydrate_unit")
	public String getCarbohydrateUnit() {
		return this.carbohydrateUnit;
	}

	public void setCarbohydrateUnit(String carbohydrateUnit) {
		this.carbohydrateUnit = carbohydrateUnit;
	}


	@Column(name="carbohydrate_unit_ori")
	public String getCarbohydrateUnitOri() {
		return this.carbohydrateUnitOri;
	}

	public void setCarbohydrateUnitOri(String carbohydrateUnitOri) {
		this.carbohydrateUnitOri = carbohydrateUnitOri;
	}


	@Column(name="chloride_qty_per_weight_ori")
	public BigDecimal getChlorideQtyPerWeightOri() {
		return this.chlorideQtyPerWeightOri;
	}

	public void setChlorideQtyPerWeightOri(BigDecimal chlorideQtyPerWeightOri) {
		this.chlorideQtyPerWeightOri = chlorideQtyPerWeightOri;
	}


	@Column(name="chloride_quantity")
	public BigDecimal getChlorideQuantity() {
		return this.chlorideQuantity;
	}

	public void setChlorideQuantity(BigDecimal chlorideQuantity) {
		this.chlorideQuantity = chlorideQuantity;
	}


	@Column(name="chloride_quantity_ori")
	public BigDecimal getChlorideQuantityOri() {
		return this.chlorideQuantityOri;
	}

	public void setChlorideQuantityOri(BigDecimal chlorideQuantityOri) {
		this.chlorideQuantityOri = chlorideQuantityOri;
	}


	@Column(name="chloride_quantity_per_weight")
	public BigDecimal getChlorideQuantityPerWeight() {
		return this.chlorideQuantityPerWeight;
	}

	public void setChlorideQuantityPerWeight(BigDecimal chlorideQuantityPerWeight) {
		this.chlorideQuantityPerWeight = chlorideQuantityPerWeight;
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


	@Column(name="current_weight")
	public BigDecimal getCurrentWeight() {
		return this.currentWeight;
	}

	public void setCurrentWeight(BigDecimal currentWeight) {
		this.currentWeight = currentWeight;
	}


	@Column(name="dosage_vol")
	public BigDecimal getDosageVol() {
		return this.dosageVol;
	}

	public void setDosageVol(BigDecimal dosageVol) {
		this.dosageVol = dosageVol;
	}


	@Column(name="dosage_vol_ori")
	public BigDecimal getDosageVolOri() {
		return this.dosageVolOri;
	}

	public void setDosageVolOri(BigDecimal dosageVolOri) {
		this.dosageVolOri = dosageVolOri;
	}


	@Column(name="drug_code")
	public String getDrugCode() {
		return this.drugCode;
	}

	public void setDrugCode(String drugCode) {
		this.drugCode = drugCode;
	}

	
	@Column(name="duration")
	public int getDuration() {
		return this.duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}


	@Column(name="duration_ori")
	public int getDurationOri() {
		return this.durationOri;
	}

	public void setDurationOri(int durationOri) {
		this.durationOri = durationOri;
	}


	@Column(name="duration_unit")
	public String getDurationUnit() {
		return this.durationUnit;
	}

	public void setDurationUnit(String durationUnit) {
		this.durationUnit = durationUnit;
	}


	@Column(name="duration_unit_ori")
	public String getDurationUnitOri() {
		return this.durationUnitOri;
	}

	public void setDurationUnitOri(String durationUnitOri) {
		this.durationUnitOri = durationUnitOri;
	}


	@Temporal( TemporalType.TIMESTAMP)
	@Column(name="end_date_time")
	public Date getEndDateTime() {
		return this.endDateTime;
	}

	public void setEndDateTime(Date endDateTime) {
		this.endDateTime = endDateTime;
	}


	@Temporal( TemporalType.TIMESTAMP)
	@Column(name="end_date_time_ori")
	public Date getEndDateTimeOri() {
		return this.endDateTimeOri;
	}

	public void setEndDateTimeOri(Date endDateTimeOri) {
		this.endDateTimeOri = endDateTimeOri;
	}


	@Column(name="fat_soluble_qty_per_weight")
	public BigDecimal getFatSolubleQtyPerWeight() {
		return this.fatSolubleQtyPerWeight;
	}

	public void setFatSolubleQtyPerWeight(BigDecimal fatSolubleQtyPerWeight) {
		this.fatSolubleQtyPerWeight = fatSolubleQtyPerWeight;
	}


	@Column(name="fat_soluble_qty_per_weight_ori")
	public BigDecimal getFatSolubleQtyPerWeightOri() {
		return this.fatSolubleQtyPerWeightOri;
	}

	public void setFatSolubleQtyPerWeightOri(BigDecimal fatSolubleQtyPerWeightOri) {
		this.fatSolubleQtyPerWeightOri = fatSolubleQtyPerWeightOri;
	}


	@Column(name="fat_soluble_quantity")
	public BigDecimal getFatSolubleQuantity() {
		return this.fatSolubleQuantity;
	}

	public void setFatSolubleQuantity(BigDecimal fatSolubleQuantity) {
		this.fatSolubleQuantity = fatSolubleQuantity;
	}


	@Column(name="fat_soluble_quantity_ori")
	public BigDecimal getFatSolubleQuantityOri() {
		return this.fatSolubleQuantityOri;
	}

	public void setFatSolubleQuantityOri(BigDecimal fatSolubleQuantityOri) {
		this.fatSolubleQuantityOri = fatSolubleQuantityOri;
	}


	@Column(name="freq_code")
	public String getFreqCode() {
		return this.freqCode;
	}

	public void setFreqCode(String freqCode) {
		this.freqCode = freqCode;
	}


	@Column(name="freq_code_ori")
	public String getFreqCodeOri() {
		return this.freqCodeOri;
	}

	public void setFreqCodeOri(String freqCodeOri) {
		this.freqCodeOri = freqCodeOri;
	}


	@Column(name="hold_by_dctr_yn")
	public String getHoldByDctrYn() {
		return this.holdByDctrYn;
	}

	public void setHoldByDctrYn(String holdByDctrYn) {
		this.holdByDctrYn = holdByDctrYn;
	}


	@Column(name="hold_resume_by")
	public String getHoldResumeBy() {
		return this.holdResumeBy;
	}

	public void setHoldResumeBy(String holdResumeBy) {
		this.holdResumeBy = holdResumeBy;
	}


	@Column(name="infuse_over")
	public BigDecimal getInfuseOver() {
		return this.infuseOver;
	}

	public void setInfuseOver(BigDecimal infuseOver) {
		this.infuseOver = infuseOver;
	}


	@Column(name="infuse_over_ori")
	public BigDecimal getInfuseOverOri() {
		return this.infuseOverOri;
	}

	public void setInfuseOverOri(BigDecimal infuseOverOri) {
		this.infuseOverOri = infuseOverOri;
	}


	@Column(name="infuse_over_unit")
	public String getInfuseOverUnit() {
		return this.infuseOverUnit;
	}

	public void setInfuseOverUnit(String infuseOverUnit) {
		this.infuseOverUnit = infuseOverUnit;
	}


	@Column(name="infuse_over_unit_ori")
	public String getInfuseOverUnitOri() {
		return this.infuseOverUnitOri;
	}

	public void setInfuseOverUnitOri(String infuseOverUnitOri) {
		this.infuseOverUnitOri = infuseOverUnitOri;
	}


	@Column(name="infusion_line")
	public String getInfusionLine() {
		return this.infusionLine;
	}

	public void setInfusionLine(String infusionLine) {
		this.infusionLine = infusionLine;
	}


	@Column(name="infusion_line_ori")
	public String getInfusionLineOri() {
		return this.infusionLineOri;
	}

	public void setInfusionLineOri(String infusionLineOri) {
		this.infusionLineOri = infusionLineOri;
	}


	@Column(name="infusion_rate")
	public BigDecimal getInfusionRate() {
		return this.infusionRate;
	}

	public void setInfusionRate(BigDecimal infusionRate) {
		this.infusionRate = infusionRate;
	}


	@Column(name="infusion_rate_ori")
	public BigDecimal getInfusionRateOri() {
		return this.infusionRateOri;
	}

	public void setInfusionRateOri(BigDecimal infusionRateOri) {
		this.infusionRateOri = infusionRateOri;
	}


	@Column(name="infusion_rate_unit")
	public String getInfusionRateUnit() {
		return this.infusionRateUnit;
	}

	public void setInfusionRateUnit(String infusionRateUnit) {
		this.infusionRateUnit = infusionRateUnit;
	}


	@Column(name="ingredients_others")
	public String getIngredientsOthers() {
		return this.ingredientsOthers;
	}

	public void setIngredientsOthers(String ingredientsOthers) {
		this.ingredientsOthers = ingredientsOthers;
	}


	@Column(name="ingredients_others_per_weight")
	public BigDecimal getIngredientsOthersPerWeight() {
		return this.ingredientsOthersPerWeight;
	}

	public void setIngredientsOthersPerWeight(BigDecimal ingredientsOthersPerWeight) {
		this.ingredientsOthersPerWeight = ingredientsOthersPerWeight;
	}


	@Column(name="ingredients_others_quantity")
	public BigDecimal getIngredientsOthersQuantity() {
		return this.ingredientsOthersQuantity;
	}

	public void setIngredientsOthersQuantity(BigDecimal ingredientsOthersQuantity) {
		this.ingredientsOthersQuantity = ingredientsOthersQuantity;
	}


	public BigDecimal getLipid() {
		return this.lipid;
	}

	public void setLipid(BigDecimal lipid) {
		this.lipid = lipid;
	}


	@Column(name="lipid_energy")
	public BigDecimal getLipidEnergy() {
		return this.lipidEnergy;
	}

	public void setLipidEnergy(BigDecimal lipidEnergy) {
		this.lipidEnergy = lipidEnergy;
	}


	@Column(name="lipid_energy_display")
	public BigDecimal getLipidEnergyDisplay() {
		return this.lipidEnergyDisplay;
	}

	public void setLipidEnergyDisplay(BigDecimal lipidEnergyDisplay) {
		this.lipidEnergyDisplay = lipidEnergyDisplay;
	}


	@Column(name="lipid_energy_ori")
	public BigDecimal getLipidEnergyOri() {
		return this.lipidEnergyOri;
	}

	public void setLipidEnergyOri(BigDecimal lipidEnergyOri) {
		this.lipidEnergyOri = lipidEnergyOri;
	}


	@Column(name="lipid_ori")
	public BigDecimal getLipidOri() {
		return this.lipidOri;
	}

	public void setLipidOri(BigDecimal lipidOri) {
		this.lipidOri = lipidOri;
	}


	@Column(name="lipid_ratio")
	public BigDecimal getLipidRatio() {
		return this.lipidRatio;
	}

	public void setLipidRatio(BigDecimal lipidRatio) {
		this.lipidRatio = lipidRatio;
	}


	@Column(name="lipid_weight_perkg")
	public BigDecimal getLipidWeightPerkg() {
		return this.lipidWeightPerkg;
	}

	public void setLipidWeightPerkg(BigDecimal lipidWeightPerkg) {
		this.lipidWeightPerkg = lipidWeightPerkg;
	}


	@Column(name="lipid_weight_perkg_ori")
	public BigDecimal getLipidWeightPerkgOri() {
		return this.lipidWeightPerkgOri;
	}

	public void setLipidWeightPerkgOri(BigDecimal lipidWeightPerkgOri) {
		this.lipidWeightPerkgOri = lipidWeightPerkgOri;
	}


	@Column(name="magnesium_qty_per_weight_ori")
	public BigDecimal getMagnesiumQtyPerWeightOri() {
		return this.magnesiumQtyPerWeightOri;
	}

	public void setMagnesiumQtyPerWeightOri(BigDecimal magnesiumQtyPerWeightOri) {
		this.magnesiumQtyPerWeightOri = magnesiumQtyPerWeightOri;
	}


	@Column(name="magnesium_quantity")
	public BigDecimal getMagnesiumQuantity() {
		return this.magnesiumQuantity;
	}

	public void setMagnesiumQuantity(BigDecimal magnesiumQuantity) {
		this.magnesiumQuantity = magnesiumQuantity;
	}


	@Column(name="magnesium_quantity_ori")
	public BigDecimal getMagnesiumQuantityOri() {
		return this.magnesiumQuantityOri;
	}

	public void setMagnesiumQuantityOri(BigDecimal magnesiumQuantityOri) {
		this.magnesiumQuantityOri = magnesiumQuantityOri;
	}


	@Column(name="magnesium_quantity_per_weight")
	public BigDecimal getMagnesiumQuantityPerWeight() {
		return this.magnesiumQuantityPerWeight;
	}

	public void setMagnesiumQuantityPerWeight(BigDecimal magnesiumQuantityPerWeight) {
		this.magnesiumQuantityPerWeight = magnesiumQuantityPerWeight;
	}


	@Column(name="n_ratio")
	public BigDecimal getNRatio() {
		return this.nRatio;
	}

	public void setNRatio(BigDecimal nRatio) {
		this.nRatio = nRatio;
	}


	@Column(name="nitrogen_content")
	public BigDecimal getNitrogenContent() {
		return this.nitrogenContent;
	}

	public void setNitrogenContent(BigDecimal nitrogenContent) {
		this.nitrogenContent = nitrogenContent;
	}


	@Column(name="npc_ratio")
	public BigDecimal getNpcRatio() {
		return this.npcRatio;
	}

	public void setNpcRatio(BigDecimal npcRatio) {
		this.npcRatio = npcRatio;
	}


	@Column(name="order_quantity")
	public BigDecimal getOrderQuantity() {
		return this.orderQuantity;
	}

	public void setOrderQuantity(BigDecimal orderQuantity) {
		this.orderQuantity = orderQuantity;
	}


	@Column(name="order_quantity_ori")
	public BigDecimal getOrderQuantityOri() {
		return this.orderQuantityOri;
	}

	public void setOrderQuantityOri(BigDecimal orderQuantityOri) {
		this.orderQuantityOri = orderQuantityOri;
	}


	@Column(name="order_status")
	public String getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}


	@Column(name="outsource_int_seqno", insertable = false, updatable = false)
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


	@Column(name="phosphate_qty_per_weight_ori")
	public BigDecimal getPhosphateQtyPerWeightOri() {
		return this.phosphateQtyPerWeightOri;
	}

	public void setPhosphateQtyPerWeightOri(BigDecimal phosphateQtyPerWeightOri) {
		this.phosphateQtyPerWeightOri = phosphateQtyPerWeightOri;
	}


	@Column(name="phosphate_quantity")
	public BigDecimal getPhosphateQuantity() {
		return this.phosphateQuantity;
	}

	public void setPhosphateQuantity(BigDecimal phosphateQuantity) {
		this.phosphateQuantity = phosphateQuantity;
	}


	@Column(name="phosphate_quantity_ori")
	public BigDecimal getPhosphateQuantityOri() {
		return this.phosphateQuantityOri;
	}

	public void setPhosphateQuantityOri(BigDecimal phosphateQuantityOri) {
		this.phosphateQuantityOri = phosphateQuantityOri;
	}


	@Column(name="phosphate_quantity_per_weight")
	public BigDecimal getPhosphateQuantityPerWeight() {
		return this.phosphateQuantityPerWeight;
	}

	public void setPhosphateQuantityPerWeight(BigDecimal phosphateQuantityPerWeight) {
		this.phosphateQuantityPerWeight = phosphateQuantityPerWeight;
	}


	@Column(name="pn_for")
	public String getPnFor() {
		return this.pnFor;
	}

	public void setPnFor(String pnFor) {
		this.pnFor = pnFor;
	}


	@Column(name="potassium_qty_per_weight_ori")
	public BigDecimal getPotassiumQtyPerWeightOri() {
		return this.potassiumQtyPerWeightOri;
	}

	public void setPotassiumQtyPerWeightOri(BigDecimal potassiumQtyPerWeightOri) {
		this.potassiumQtyPerWeightOri = potassiumQtyPerWeightOri;
	}


	@Column(name="potassium_quantity")
	public BigDecimal getPotassiumQuantity() {
		return this.potassiumQuantity;
	}

	public void setPotassiumQuantity(BigDecimal potassiumQuantity) {
		this.potassiumQuantity = potassiumQuantity;
	}


	@Column(name="potassium_quantity_ori")
	public BigDecimal getPotassiumQuantityOri() {
		return this.potassiumQuantityOri;
	}

	public void setPotassiumQuantityOri(BigDecimal potassiumQuantityOri) {
		this.potassiumQuantityOri = potassiumQuantityOri;
	}


	@Column(name="potassium_quantity_per_weight")
	public BigDecimal getPotassiumQuantityPerWeight() {
		return this.potassiumQuantityPerWeight;
	}

	public void setPotassiumQuantityPerWeight(BigDecimal potassiumQuantityPerWeight) {
		this.potassiumQuantityPerWeight = potassiumQuantityPerWeight;
	}


	public BigDecimal getProtein() {
		return this.protein;
	}

	public void setProtein(BigDecimal protein) {
		this.protein = protein;
	}


	@Column(name="protein_energy")
	public BigDecimal getProteinEnergy() {
		return this.proteinEnergy;
	}

	public void setProteinEnergy(BigDecimal proteinEnergy) {
		this.proteinEnergy = proteinEnergy;
	}


	@Column(name="protein_energy_display")
	public BigDecimal getProteinEnergyDisplay() {
		return this.proteinEnergyDisplay;
	}

	public void setProteinEnergyDisplay(BigDecimal proteinEnergyDisplay) {
		this.proteinEnergyDisplay = proteinEnergyDisplay;
	}


	@Column(name="protein_energy_ori")
	public BigDecimal getProteinEnergyOri() {
		return this.proteinEnergyOri;
	}

	public void setProteinEnergyOri(BigDecimal proteinEnergyOri) {
		this.proteinEnergyOri = proteinEnergyOri;
	}


	@Column(name="protein_ori")
	public BigDecimal getProteinOri() {
		return this.proteinOri;
	}

	public void setProteinOri(BigDecimal proteinOri) {
		this.proteinOri = proteinOri;
	}


	@Column(name="protein_weight_perkg")
	public BigDecimal getProteinWeightPerkg() {
		return this.proteinWeightPerkg;
	}

	public void setProteinWeightPerkg(BigDecimal proteinWeightPerkg) {
		this.proteinWeightPerkg = proteinWeightPerkg;
	}


	@Column(name="protein_weight_perkg_ori")
	public BigDecimal getProteinWeightPerkgOri() {
		return this.proteinWeightPerkgOri;
	}

	public void setProteinWeightPerkgOri(BigDecimal proteinWeightPerkgOri) {
		this.proteinWeightPerkgOri = proteinWeightPerkgOri;
	}


	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


	@Column(name="remarks_ori")
	public String getRemarksOri() {
		return this.remarksOri;
	}

	public void setRemarksOri(String remarksOri) {
		this.remarksOri = remarksOri;
	}


	@Column(name="single_vitamin")
	public String getSingleVitamin() {
		return this.singleVitamin;
	}

	public void setSingleVitamin(String singleVitamin) {
		this.singleVitamin = singleVitamin;
	}


	@Column(name="single_vitamin_ori")
	public String getSingleVitaminOri() {
		return this.singleVitaminOri;
	}

	public void setSingleVitaminOri(String singleVitaminOri) {
		this.singleVitaminOri = singleVitaminOri;
	}


	@Column(name="sodium_quantity")
	public BigDecimal getSodiumQuantity() {
		return this.sodiumQuantity;
	}

	public void setSodiumQuantity(BigDecimal sodiumQuantity) {
		this.sodiumQuantity = sodiumQuantity;
	}


	@Column(name="sodium_quantity_ori")
	public BigDecimal getSodiumQuantityOri() {
		return this.sodiumQuantityOri;
	}

	public void setSodiumQuantityOri(BigDecimal sodiumQuantityOri) {
		this.sodiumQuantityOri = sodiumQuantityOri;
	}


	@Column(name="sodium_quantity_per_weight")
	public BigDecimal getSodiumQuantityPerWeight() {
		return this.sodiumQuantityPerWeight;
	}

	public void setSodiumQuantityPerWeight(BigDecimal sodiumQuantityPerWeight) {
		this.sodiumQuantityPerWeight = sodiumQuantityPerWeight;
	}


	@Column(name="sodium_quantity_per_weight_ori")
	public BigDecimal getSodiumQuantityPerWeightOri() {
		return this.sodiumQuantityPerWeightOri;
	}

	public void setSodiumQuantityPerWeightOri(BigDecimal sodiumQuantityPerWeightOri) {
		this.sodiumQuantityPerWeightOri = sodiumQuantityPerWeightOri;
	}


	@Temporal( TemporalType.TIMESTAMP)
	@Column(name="start_date")
	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	@Temporal( TemporalType.TIMESTAMP)
	@Column(name="start_date_ori")
	public Date getStartDateOri() {
		return this.startDateOri;
	}

	public void setStartDateOri(Date startDateOri) {
		this.startDateOri = startDateOri;
	}


	@Column(name="total_energy_perday")
	public BigDecimal getTotalEnergyPerday() {
		return this.totalEnergyPerday;
	}

	public void setTotalEnergyPerday(BigDecimal totalEnergyPerday) {
		this.totalEnergyPerday = totalEnergyPerday;
	}


	@Column(name="total_energy_perday_ori")
	public BigDecimal getTotalEnergyPerdayOri() {
		return this.totalEnergyPerdayOri;
	}

	public void setTotalEnergyPerdayOri(BigDecimal totalEnergyPerdayOri) {
		this.totalEnergyPerdayOri = totalEnergyPerdayOri;
	}


	@Column(name="total_energy_perweight")
	public BigDecimal getTotalEnergyPerweight() {
		return this.totalEnergyPerweight;
	}

	public void setTotalEnergyPerweight(BigDecimal totalEnergyPerweight) {
		this.totalEnergyPerweight = totalEnergyPerweight;
	}


	@Column(name="total_energy_perweight_ori")
	public BigDecimal getTotalEnergyPerweightOri() {
		return this.totalEnergyPerweightOri;
	}

	public void setTotalEnergyPerweightOri(BigDecimal totalEnergyPerweightOri) {
		this.totalEnergyPerweightOri = totalEnergyPerweightOri;
	}


	@Column(name="total_volume")
	public BigDecimal getTotalVolume() {
		return this.totalVolume;
	}

	public void setTotalVolume(BigDecimal totalVolume) {
		this.totalVolume = totalVolume;
	}


	@Column(name="total_volume_ori")
	public BigDecimal getTotalVolumeOri() {
		return this.totalVolumeOri;
	}

	public void setTotalVolumeOri(BigDecimal totalVolumeOri) {
		this.totalVolumeOri = totalVolumeOri;
	}


	@Column(name="trace_ele_qty_per_weight")
	public BigDecimal getTraceEleQtyPerWeight() {
		return this.traceEleQtyPerWeight;
	}

	public void setTraceEleQtyPerWeight(BigDecimal traceEleQtyPerWeight) {
		this.traceEleQtyPerWeight = traceEleQtyPerWeight;
	}


	@Column(name="trace_ele_qty_per_weight_ori")
	public BigDecimal getTraceEleQtyPerWeightOri() {
		return this.traceEleQtyPerWeightOri;
	}

	public void setTraceEleQtyPerWeightOri(BigDecimal traceEleQtyPerWeightOri) {
		this.traceEleQtyPerWeightOri = traceEleQtyPerWeightOri;
	}


	@Column(name="trace_element_quantity_ori")
	public BigDecimal getTraceElementQuantityOri() {
		return this.traceElementQuantityOri;
	}

	public void setTraceElementQuantityOri(BigDecimal traceElementQuantityOri) {
		this.traceElementQuantityOri = traceElementQuantityOri;
	}


	@Column(name="trace_elements_quantity")
	public BigDecimal getTraceElementsQuantity() {
		return this.traceElementsQuantity;
	}

	public void setTraceElementsQuantity(BigDecimal traceElementsQuantity) {
		this.traceElementsQuantity = traceElementsQuantity;
	}


	@Column(name="type_of_pn")
	public String getTypeOfPn() {
		return this.typeOfPn;
	}

	public void setTypeOfPn(String typeOfPn) {
		this.typeOfPn = typeOfPn;
	}


	@Column(name="updated_by")
	public Long getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}


	@Temporal( TemporalType.TIMESTAMP)
	@Column(name="updated_date")
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}


	@Column(name="vitamin_sol_qty_per_weight")
	public BigDecimal getVitaminSolQtyPerWeight() {
		return this.vitaminSolQtyPerWeight;
	}

	public void setVitaminSolQtyPerWeight(BigDecimal vitaminSolQtyPerWeight) {
		this.vitaminSolQtyPerWeight = vitaminSolQtyPerWeight;
	}


	@Column(name="vitamin_sol_qty_per_weight_ori")
	public BigDecimal getVitaminSolQtyPerWeightOri() {
		return this.vitaminSolQtyPerWeightOri;
	}

	public void setVitaminSolQtyPerWeightOri(BigDecimal vitaminSolQtyPerWeightOri) {
		this.vitaminSolQtyPerWeightOri = vitaminSolQtyPerWeightOri;
	}


	@Column(name="vitamin_solution_quantity")
	public BigDecimal getVitaminSolutionQuantity() {
		return this.vitaminSolutionQuantity;
	}

	public void setVitaminSolutionQuantity(BigDecimal vitaminSolutionQuantity) {
		this.vitaminSolutionQuantity = vitaminSolutionQuantity;
	}


	@Column(name="vitamin_solution_quantity_ori")
	public BigDecimal getVitaminSolutionQuantityOri() {
		return this.vitaminSolutionQuantityOri;
	}

	public void setVitaminSolutionQuantityOri(BigDecimal vitaminSolutionQuantityOri) {
		this.vitaminSolutionQuantityOri = vitaminSolutionQuantityOri;
	}


	@Column(name="volume_pnperkg")
	public BigDecimal getVolumePnperkg() {
		return this.volumePnperkg;
	}

	public void setVolumePnperkg(BigDecimal volumePnperkg) {
		this.volumePnperkg = volumePnperkg;
	}


	@Column(name="volume_pnperkg_ori")
	public BigDecimal getVolumePnperkgOri() {
		return this.volumePnperkgOri;
	}

	public void setVolumePnperkgOri(BigDecimal volumePnperkgOri) {
		this.volumePnperkgOri = volumePnperkgOri;
	}


	@Column(name="water_sol_qty_per_weight")
	public BigDecimal getWaterSolQtyPerWeight() {
		return this.waterSolQtyPerWeight;
	}

	public void setWaterSolQtyPerWeight(BigDecimal waterSolQtyPerWeight) {
		this.waterSolQtyPerWeight = waterSolQtyPerWeight;
	}


	@Column(name="water_sol_qty_per_weight_ori")
	public BigDecimal getWaterSolQtyPerWeightOri() {
		return this.waterSolQtyPerWeightOri;
	}

	public void setWaterSolQtyPerWeightOri(BigDecimal waterSolQtyPerWeightOri) {
		this.waterSolQtyPerWeightOri = waterSolQtyPerWeightOri;
	}


	@Column(name="water_soluble_quantity")
	public BigDecimal getWaterSolubleQuantity() {
		return this.waterSolubleQuantity;
	}

	public void setWaterSolubleQuantity(BigDecimal waterSolubleQuantity) {
		this.waterSolubleQuantity = waterSolubleQuantity;
	}


	@Column(name="water_soluble_quantity_ori")
	public BigDecimal getWaterSolubleQuantityOri() {
		return this.waterSolubleQuantityOri;
	}

	public void setWaterSolubleQuantityOri(BigDecimal waterSolubleQuantityOri) {
		this.waterSolubleQuantityOri = waterSolubleQuantityOri;
	}

	//bi-directional many-to-one association to PnNutritionalAssmntInt
	@OneToMany(mappedBy="pnOrderRegimenInt", cascade=CascadeType.ALL)
	@XmlElement
	@JsonManagedReference("PnNutritionalAssmntInt")
	public Set<PnNutritionalAssmntInt> getPnNutritionalAssmntInts() {
		return this.pnNutritionalAssmntInts;
	}

	public void setPnNutritionalAssmntInts(Set<PnNutritionalAssmntInt> pnNutritionalAssmntInts) {
		this.pnNutritionalAssmntInts = pnNutritionalAssmntInts;
	}


	//bi-directional many-to-one association to PnOrderTotalEnergyInt
	@OneToMany(mappedBy="pnOrderRegimenInt", cascade=CascadeType.ALL)
	@XmlElement
	@JsonManagedReference("PnOrderTotalEnergyInt")
	public Set<PnOrderTotalEnergyInt> getPnOrderTotalEnergyInts() {
		return this.pnOrderTotalEnergyInts;
	}

	public void setPnOrderTotalEnergyInts(Set<PnOrderTotalEnergyInt> pnOrderTotalEnergyInts) {
		this.pnOrderTotalEnergyInts = pnOrderTotalEnergyInts;
	}

	@ManyToOne
	@JoinColumn(name = "outsource_int_seqno")
	@XmlElement
	@JsonBackReference("outsource_PnOrderRegimenInt")
	public OutsourceOrderInt getOutsourceOrderInt() {
		return this.outsourceOrderInt;
	}


	public void setOutsourceOrderInt(OutsourceOrderInt outsourceOrderInt) {
		this.outsourceOrderInt = outsourceOrderInt;
	}

	@Column(name="send_flag")
	public String getSendFlag() {
		return this.sendFlag;
	}

	public void setSendFlag(String sendFlag) {
		this.sendFlag = sendFlag;
	}

	@Column(name="glutamin_energy")
	public BigDecimal getGlutaminEnergy() {
		return this.glutaminEnergy;
	}

	public void setGlutaminEnergy(BigDecimal glutaminEnergy) {
		this.glutaminEnergy = glutaminEnergy;
	}
	
	@Column(name="glutamin_energy_ori")
	public BigDecimal getGlutaminEnergyOri() {
		return this.glutaminEnergyOri;
	}

	public void setGlutaminEnergyOri(BigDecimal glutaminEnergyOri) {
		this.glutaminEnergyOri = glutaminEnergyOri;
	}
	
	@Column(name="glutamin_quantity")
	public BigDecimal getGlutaminQuantity() {
		return glutaminQuantity;
	}

	public void setGlutaminQuantity(BigDecimal glutaminQuantity) {
		this.glutaminQuantity = glutaminQuantity;
	}

	@Column(name="glutamin_quantity_ori")
	public BigDecimal getGlutaminQuantityOri() {
		return glutaminQuantityOri;
	}

	public void setGlutaminQuantityOri(BigDecimal glutaminQuantityOri) {
		this.glutaminQuantityOri = glutaminQuantityOri;
	}
	
	@Column(name="glutamin_weight_perkg")
	public BigDecimal getGlutaminWeightPerkg() {
		return this.glutaminWeightPerkg;
	}

	public void setGlutaminWeightPerkg(BigDecimal glutaminWeightPerkg) {
		this.glutaminWeightPerkg = glutaminWeightPerkg;
	}
	
	@Column(name="glutamin_weight_perkg_ori")
	public BigDecimal getGlutaminWeightPerkgOri() {
		return this.glutaminWeightPerkgOri;
	}

	public void setGlutaminWeightPerkgOri(BigDecimal glutaminWeightPerkgOri) {
		this.glutaminWeightPerkgOri = glutaminWeightPerkgOri;
	}
	
	@Column(name = "indication", precision = 8)
	public String getIndication() {
		return this.indication;
	}

	public void setIndication(String indication) {
		this.indication = indication;
	}
	
	@Column(name = "use_fluid_calculator")
	public String getUseFluidCalculator() {
		return this.useFluidCalculator;
	}

	public void setUseFluidCalculator(String useFluidCalculator) {
		this.useFluidCalculator = useFluidCalculator;
	}
	
	@Column(name="oral_feeding_perkg_ori")
	public BigDecimal getOralFeedingPerkgOri() {
		return this.oralFeedingPerkgOri; 
	}

	public void setOralFeedingPerkgOri(BigDecimal oralFeedingPerkgOri) {
		this.oralFeedingPerkgOri = oralFeedingPerkgOri;
	}
	
	@Column(name="oral_feeding_perkg")
	public BigDecimal getOralFeedingPerkg() {
		return this.oralFeedingPerkg;
	}

	public void setOralFeedingPerkg(BigDecimal OralFeedingPerkg) {
		this.oralFeedingPerkg = OralFeedingPerkg;
	}
	
	@Column(name="oral_feeding_ori")
	public BigDecimal getOralFeedingOri() {
		return this.oralFeedingOri;
	}

	public void setOralFeedingOri(BigDecimal oralFeedingOri) {
		this.oralFeedingOri = oralFeedingOri;
	}
	
	@Column(name="oral_feeding")
	public BigDecimal getOralFeeding() {
		return this.oralFeeding;
	}

	public void setOralFeeding(BigDecimal oralFeeding) {
		this.oralFeeding = oralFeeding;
	}
	
	@Column(name="tpn_volume_perkg_ori")
	public BigDecimal getTpnVolumePerkgOri() {
		return this.tpnVolumePerkgOri;
	}

	public void setTpnVolumePerkgOri(BigDecimal TpnVolumePerkgOri) {
		this.tpnVolumePerkgOri = TpnVolumePerkgOri;
	}
	
	@Column(name="tpn_volume_perkg")
	public BigDecimal getTpnVolumePerkg() {
		return this.tpnVolumePerkg;
	}

	public void setTpnVolumePerkg(BigDecimal TpnVolumePerkg) {
		this.tpnVolumePerkg = TpnVolumePerkg;
	}
	
	@Column(name="tpn_volume_ori")
	public BigDecimal getTpnVolumeOri() {
		return this.tpnVolumeOri;
	}

	public void setTpnVolumeOri(BigDecimal tpnVolumeOri) {
		this.tpnVolumeOri = tpnVolumeOri;
	}
	
	@Column(name="tpn_volume")
	public BigDecimal getTpnVolume() {
		return this.tpnVolume;
	}

	public void setTpnVolume(BigDecimal tpnVolume) {
		this.tpnVolume = tpnVolume;
	}
	
	 @Column(name = "verification_remarks")
	 public String getVerificationRemarks() {
	  return verificationRemarks;
	 }

	 public void setVerificationRemarks(String verificationRemarks) {
	  this.verificationRemarks = verificationRemarks;
	 }

	 @Column(name = "preparation_remarks")
	 public String getPreparationRemarks() {
	  return preparationRemarks;
	 }

	 public void setPreparationRemarks(String preparationRemarks) {
	  this.preparationRemarks = preparationRemarks;
	 }

	 @Column(name = "dispensing_remarks")
	 public String getDispensingRemarks() {
	  return dispensingRemarks;
	 }

	 public void setDispensingRemarks(String dispensingRemarks) {
	  this.dispensingRemarks = dispensingRemarks;
	 }
	 
	 @Column(name = "sodium_add", precision = 8)
		public BigDecimal getSodiumAdd() {
			return sodiumAdd;
		}

		public void setSodiumAdd(BigDecimal sodiumAdd) {
			this.sodiumAdd = sodiumAdd;
		}

		@Column(name = "sodium_add_ori", precision = 8)
		public BigDecimal getSodiumAddOri() {
			return sodiumAddOri;
		}

		public void setSodiumAddOri(BigDecimal sodiumAddOri) {
			this.sodiumAddOri = sodiumAddOri;
		}

		@Column(name = "potassium_add", precision = 8)
		public BigDecimal getPotassiumAdd() {
			return potassiumAdd;
		}

		public void setPotassiumAdd(BigDecimal potassiumAdd) {
			this.potassiumAdd = potassiumAdd;
		}

		@Column(name = "potassium_add_ori", precision = 8)
		public BigDecimal getPotassiumAddOri() {
			return potassiumAddOri;
		}

		public void setPotassiumAddOri(BigDecimal potassiumAddOri) {
			this.potassiumAddOri = potassiumAddOri;
		}

		@Column(name = "calcium_add", precision = 8)
		public BigDecimal getCalciumAdd() {
			return calciumAdd;
		}

		public void setCalciumAdd(BigDecimal calciumAdd) {
			this.calciumAdd = calciumAdd;
		}

		@Column(name = "calcium_add_ori", precision = 8)
		public BigDecimal getCalciumAddOri() {
			return calciumAddOri;
		}

		public void setCalciumAddOri(BigDecimal calciumAddOri) {
			this.calciumAddOri = calciumAddOri;
		}

		@Column(name = "magnesium_add", precision = 8)
		public BigDecimal getMagnesiumAdd() {
			return magnesiumAdd;
		}

		public void setMagnesiumAdd(BigDecimal magnesiumAdd) {
			this.magnesiumAdd = magnesiumAdd;
		}

		@Column(name = "magnesium_add_ori", precision = 8)
		public BigDecimal getMagnesiumAddOri() {
			return magnesiumAddOri;
		}

		public void setMagnesiumAddOri(BigDecimal magnesiumAddOri) {
			this.magnesiumAddOri = magnesiumAddOri;
		}

		@Column(name = "phosphate_add", precision = 8)
		public BigDecimal getPhosphateAdd() {
			return phosphateAdd;
		}

		public void setPhosphateAdd(BigDecimal phosphateAdd) {
			this.phosphateAdd = phosphateAdd;
		}

		@Column(name = "phosphate_add_ori", precision = 8)
		public BigDecimal getPhosphateAddOri() {
			return phosphateAddOri;
		}

		public void setPhosphateAddOri(BigDecimal phosphateAddOri) {
			this.phosphateAddOri = phosphateAddOri;
		}

		@Column(name = "acetate_add", precision = 8)
		public BigDecimal getAcetateAdd() {
			return acetateAdd;
		}

		public void setAcetateAdd(BigDecimal acetateAdd) {
			this.acetateAdd = acetateAdd;
		}

		@Column(name = "acetate_add_ori", precision = 8)
		public BigDecimal getAcetateAddOri() {
			return acetateAddOri;
		}

		public void setAcetateAddOri(BigDecimal acetateAddOri) {
			this.acetateAddOri = acetateAddOri;
		}

		@Column(name = "trace_elmnt_add", precision = 8)
		public BigDecimal getTraceElmntAdd() {
			return traceElmntAdd;
		}

		public void setTraceElmntAdd(BigDecimal traceElmntAdd) {
			this.traceElmntAdd = traceElmntAdd;
		}

		@Column(name = "trace_elmnt_add_ori", precision = 8)
		public BigDecimal getTraceElmntAddOri() {
			return traceElmntAddOri;
		}

		public void setTraceElmntAddOri(BigDecimal traceElmntAddOri) {
			this.traceElmntAddOri = traceElmntAddOri;
		}

		@Column(name = "glutamin_add", precision = 8)
		public BigDecimal getGlutaminAdd() {
			return glutaminAdd;
		}

		public void setGlutaminAdd(BigDecimal glutaminAdd) {
			this.glutaminAdd = glutaminAdd;
		}

		@Column(name = "glutamin_add_ori", precision = 8)
		public BigDecimal getGlutaminAddOri() {
			return glutaminAddOri;
		}

		public void setGlutaminAddOri(BigDecimal glutaminAddOri) {
			this.glutaminAddOri = glutaminAddOri;
		}

		@Column(name = "fat_soluble_add", precision = 8)
		public BigDecimal getFatSolubleAdd() {
			return fatSolubleAdd;
		}

		public void setFatSolubleAdd(BigDecimal fatSolubleAdd) {
			this.fatSolubleAdd = fatSolubleAdd;
		}

		@Column(name = "fat_soluble_add_ori", precision = 8)
		public BigDecimal getFatSolubleAddOri() {
			return fatSolubleAddOri;
		}

		public void setFatSolubleAddOri(BigDecimal fatSolubleAddOri) {
			this.fatSolubleAddOri = fatSolubleAddOri;
		}
		
		@Column(name = "water_soluble_add", precision = 8)
		public BigDecimal getWaterSolubleAdd() {
			return waterSolubleAdd;
		}

		public void setWaterSolubleAdd(BigDecimal waterSolubleAdd) {
			this.waterSolubleAdd = waterSolubleAdd;
		}

		@Column(name = "water_soluble_add_ori", precision = 8)
		public BigDecimal getWaterSolubleAddOri() {
			return waterSolubleAddOri;
		}

		public void setWaterSolubleAddOri(BigDecimal waterSolubleAddOri) {
			this.waterSolubleAddOri = waterSolubleAddOri;
		}

		@Column(name = "vit_solution_add", precision = 8)
		public BigDecimal getVitSolutionAdd() {
			return vitSolutionAdd;
		}

		public void setVitSolutionAdd(BigDecimal vitSolutionAdd) {
			this.vitSolutionAdd = vitSolutionAdd;
		}

		@Column(name = "vit_solution_add_ori", precision = 8)
		public BigDecimal getVitSolutionAddOri() {
			return vitSolutionAddOri;
		}

		public void setVitSolutionAddOri(BigDecimal vitSolutionAddOri) {
			this.vitSolutionAddOri = vitSolutionAddOri;
		}
	
}