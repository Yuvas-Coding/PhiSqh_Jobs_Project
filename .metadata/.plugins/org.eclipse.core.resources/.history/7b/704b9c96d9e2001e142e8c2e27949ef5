package my.com.cmg.iwp.backend.model.integration.pn;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The persistent class for the ph_pn_order_total_energy_int database table.
 * 
 */
@Entity
@Table(name = "T_PN_ORDER_TTL_ENRGY_INT")
@XmlRootElement(name = "PnOrderTotalEnergyInt")
@JsonIgnoreProperties(ignoreUnknown=true)
public class PnOrderTotalEnergyInt implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long energyIntSeqno;
	private String activityFactor;
	private String activityFactorValue;
	private BigDecimal actualBodyWeight;
	private BigDecimal adjustedBodyWeight;
	private BigDecimal bodyTemperature;
	private BigDecimal bodyWeight;
	private String bodyWeightType;
	private BigDecimal burnSurfaceArea;
	private BigDecimal caloricIntake;
	private Long createdBy;
	private Date createdDate;
	private BigDecimal energyToBeProvided;
	private BigDecimal idealBodyWeight;
	private String includeStress;
	private String maintenanceValue;
	private String parameter1;
	private String parameter2;
	private BigDecimal parameter3;
	private BigDecimal parameter4;
	private Date parameter5;
	private BigDecimal planToProvide;
	private String pnCalculator;
	private BigDecimal postBurnDays;
	private Long regimenIntSeqno;
	private String stressFactor;
	private BigDecimal toProvide;
	private BigDecimal totalEnergyCalculated;
	private Long updatedBy;
	private Date updatedDate;

	private PnOrderRegimenInt pnOrderRegimenInt;

	public PnOrderTotalEnergyInt() {
	}

	@Id
	@SequenceGenerator(name = "PH_PN_ORDER_TOTAL_ENERGY_INT_ENERGYSEQNO_GENERATOR", sequenceName = "T_PN_ORDER_TTL_ENRGY_INT_SEQ", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PH_PN_ORDER_TOTAL_ENERGY_INT_ENERGYSEQNO_GENERATOR")
	@Column(name = "energy_int_seqno")
	@JsonIgnore
	public Long getEnergyIntSeqno() {
		return this.energyIntSeqno;
	}

	public void setEnergyIntSeqno(Long energyIntSeqno) {
		this.energyIntSeqno = energyIntSeqno;
	}

	@Column(name="activity_factor")
	public String getActivityFactor() {
		return this.activityFactor;
	}

	public void setActivityFactor(String activityFactor) {
		this.activityFactor = activityFactor;
	}


	@Column(name="activity_factor_value")
	public String getActivityFactorValue() {
		return this.activityFactorValue;
	}

	public void setActivityFactorValue(String activityFactorValue) {
		this.activityFactorValue = activityFactorValue;
	}


	@Column(name="actual_body_weight")
	public BigDecimal getActualBodyWeight() {
		return this.actualBodyWeight;
	}

	public void setActualBodyWeight(BigDecimal actualBodyWeight) {
		this.actualBodyWeight = actualBodyWeight;
	}


	@Column(name="adjusted_body_weight")
	public BigDecimal getAdjustedBodyWeight() {
		return this.adjustedBodyWeight;
	}

	public void setAdjustedBodyWeight(BigDecimal adjustedBodyWeight) {
		this.adjustedBodyWeight = adjustedBodyWeight;
	}


	@Column(name="body_temperature")
	public BigDecimal getBodyTemperature() {
		return this.bodyTemperature;
	}

	public void setBodyTemperature(BigDecimal bodyTemperature) {
		this.bodyTemperature = bodyTemperature;
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


	@Column(name="burn_surface_area")
	public BigDecimal getBurnSurfaceArea() {
		return this.burnSurfaceArea;
	}

	public void setBurnSurfaceArea(BigDecimal burnSurfaceArea) {
		this.burnSurfaceArea = burnSurfaceArea;
	}


	@Column(name="caloric_intake")
	public BigDecimal getCaloricIntake() {
		return this.caloricIntake;
	}

	public void setCaloricIntake(BigDecimal caloricIntake) {
		this.caloricIntake = caloricIntake;
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


	@Column(name="energy_to_be_provided")
	public BigDecimal getEnergyToBeProvided() {
		return this.energyToBeProvided;
	}

	public void setEnergyToBeProvided(BigDecimal energyToBeProvided) {
		this.energyToBeProvided = energyToBeProvided;
	}


	@Column(name="ideal_body_weight")
	public BigDecimal getIdealBodyWeight() {
		return this.idealBodyWeight;
	}

	public void setIdealBodyWeight(BigDecimal idealBodyWeight) {
		this.idealBodyWeight = idealBodyWeight;
	}


	@Column(name="include_stress")
	public String getIncludeStress() {
		return this.includeStress;
	}

	public void setIncludeStress(String includeStress) {
		this.includeStress = includeStress;
	}


	@Column(name="maintenance_value")
	public String getMaintenanceValue() {
		return this.maintenanceValue;
	}

	public void setMaintenanceValue(String maintenanceValue) {
		this.maintenanceValue = maintenanceValue;
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


	@Column(name="plan_to_provide")
	public BigDecimal getPlanToProvide() {
		return this.planToProvide;
	}

	public void setPlanToProvide(BigDecimal planToProvide) {
		this.planToProvide = planToProvide;
	}


	@Column(name="pn_calculator")
	public String getPnCalculator() {
		return this.pnCalculator;
	}

	public void setPnCalculator(String pnCalculator) {
		this.pnCalculator = pnCalculator;
	}


	@Column(name="post_burn_days")
	public BigDecimal getPostBurnDays() {
		return this.postBurnDays;
	}

	public void setPostBurnDays(BigDecimal postBurnDays) {
		this.postBurnDays = postBurnDays;
	}


	@Column(name="regimen_int_seqno", insertable=false, updatable=false)
	public Long getRegimenIntSeqno() {
		return this.regimenIntSeqno;
	}

	public void setRegimenIntSeqno(Long regimenIntSeqno) {
		this.regimenIntSeqno = regimenIntSeqno;
	}


	@Column(name="stress_factor")
	public String getStressFactor() {
		return this.stressFactor;
	}

	public void setStressFactor(String stressFactor) {
		this.stressFactor = stressFactor;
	}


	@Column(name="to_provide")
	public BigDecimal getToProvide() {
		return this.toProvide;
	}

	public void setToProvide(BigDecimal toProvide) {
		this.toProvide = toProvide;
	}


	@Column(name="total_energy_calculated")
	public BigDecimal getTotalEnergyCalculated() {
		return this.totalEnergyCalculated;
	}

	public void setTotalEnergyCalculated(BigDecimal totalEnergyCalculated) {
		this.totalEnergyCalculated = totalEnergyCalculated;
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

	//bi-directional many-to-one association to PnOrderRegimenInt
	@ManyToOne
	@JoinColumn(name="regimen_int_seqno")
	@JsonBackReference("PnOrderTotalEnergyInt")
	public PnOrderRegimenInt getPnOrderRegimenInt() {
		return this.pnOrderRegimenInt;
	}

	public void setPnOrderRegimenInt(PnOrderRegimenInt pnOrderRegimenInt) {
		this.pnOrderRegimenInt = pnOrderRegimenInt;
	}
}