package my.com.cmg.iwp.backend.model.integration.cdr;

import java.io.Serializable;
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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The persistent class for the ph_cdr_dispensing_int database table.
 * 
 */
@Entity
@Table(name="t_cdr_dispensing_int")
@JsonIgnoreProperties(ignoreUnknown=true)
public class CdrDispensingInt implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long dispenseCdrIntSeqno;
	private String below0cyn;
	private Long createdBy;
	private Date createdDate;
	private String dispDiluentDrugCode;
	private BigDecimal dispDiluentOrderQty;
	private String dispDosageCdrUom;
	private String dispDrugCode;
	private String dispDrugQtyUomAbbreviation;
	private Integer dispDuration;
	private Date dispEndDateTime;
	private String dispFreqCode;
	private Integer dispInfusionOverHour;
	private Integer dispInfusionOverMiniute;
	private BigDecimal dispInfusionRate;
	private String dispInfusionRateUnit;
	private BigDecimal dispQtyDiluent;
	private BigDecimal dispQtyDrug;
	private String dispRouteCode;
	private Date dispStartDateTime;
	private BigDecimal dispTotalDose;
	private BigDecimal dispTotalDrugQty;
	private BigDecimal dispTotalFluidVolume;
	private String dispensedUomAbbr;
	private String dispensingRemarks;
	private BigDecimal drugOrderQty;
	private String holdRemarks;
	private Integer noOfDose;
	private String parameter1;
	private String parameter2;
	private BigDecimal parameter3;
	private BigDecimal parameter4;
	private Date parameter5;
	private String prepInstruction;
	private String preparationRemarks;
	private String prepareAdmixtureYn;
	private String protectlightyn;
	private String reconsFluid;
	private String refrigerateyn;
	private String roomtemptyn;
	private String supervisedBy;
	private Long updatedBy;
	private Date updatedDate;
	private String verificationRemarks;
	private CdrDrugsInt cdrDrugsInt;

	public CdrDispensingInt() {
	}

	public CdrDispensingInt(Long dispenseCdrIntSeqno) {
		super();
		this.dispenseCdrIntSeqno = dispenseCdrIntSeqno;
	}

	@Id
	@SequenceGenerator(name="PH_CDR_DISPENSING_INT_DISPENSECDRINTSEQNO_GENERATOR", sequenceName="t_cdr_dispensing_int_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PH_CDR_DISPENSING_INT_DISPENSECDRINTSEQNO_GENERATOR")
	@Column(name="dispense_cdr_int_seqno")
	@JsonIgnore
	public Long getDispenseCdrIntSeqno() {
		return this.dispenseCdrIntSeqno;
	}

	public void setDispenseCdrIntSeqno(Long dispenseCdrIntSeqno) {
		this.dispenseCdrIntSeqno = dispenseCdrIntSeqno;
	}


	public String getBelow0cyn() {
		return this.below0cyn;
	}

	public void setBelow0cyn(String below0cyn) {
		this.below0cyn = below0cyn;
	}


	@Column(name="created_by")
	public Long getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}


	@Column(name="created_date")
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}


	@Column(name="disp_diluent_drug_code")
	public String getDispDiluentDrugCode() {
		return this.dispDiluentDrugCode;
	}

	public void setDispDiluentDrugCode(String dispDiluentDrugCode) {
		this.dispDiluentDrugCode = dispDiluentDrugCode;
	}


	@Column(name="disp_diluent_order_qty")
	public BigDecimal getDispDiluentOrderQty() {
		return this.dispDiluentOrderQty;
	}

	public void setDispDiluentOrderQty(BigDecimal dispDiluentOrderQty) {
		this.dispDiluentOrderQty = dispDiluentOrderQty;
	}


	@Column(name="disp_dosage_cdr_uom")
	public String getDispDosageCdrUom() {
		return this.dispDosageCdrUom;
	}

	public void setDispDosageCdrUom(String dispDosageCdrUom) {
		this.dispDosageCdrUom = dispDosageCdrUom;
	}


	@Column(name="disp_drug_code")
	public String getDispDrugCode() {
		return this.dispDrugCode;
	}

	public void setDispDrugCode(String dispDrugCode) {
		this.dispDrugCode = dispDrugCode;
	}


	@Column(name="disp_drug_qty_uom_abbreviation")
	public String getDispDrugQtyUomAbbreviation() {
		return this.dispDrugQtyUomAbbreviation;
	}

	public void setDispDrugQtyUomAbbreviation(String dispDrugQtyUomAbbreviation) {
		this.dispDrugQtyUomAbbreviation = dispDrugQtyUomAbbreviation;
	}


	@Column(name="disp_duration")
	public Integer getDispDuration() {
		return this.dispDuration;
	}

	public void setDispDuration(Integer dispDuration) {
		this.dispDuration = dispDuration;
	}


	@Column(name="disp_end_date_time")
	public Date getDispEndDateTime() {
		return this.dispEndDateTime;
	}

	public void setDispEndDateTime(Date dispEndDateTime) {
		this.dispEndDateTime = dispEndDateTime;
	}


	@Column(name="disp_freq_code")
	public String getDispFreqCode() {
		return this.dispFreqCode;
	}

	public void setDispFreqCode(String dispFreqCode) {
		this.dispFreqCode = dispFreqCode;
	}


	@Column(name="disp_infusion_over_hour")
	public Integer getDispInfusionOverHour() {
		return this.dispInfusionOverHour;
	}

	public void setDispInfusionOverHour(Integer dispInfusionOverHour) {
		this.dispInfusionOverHour = dispInfusionOverHour;
	}


	@Column(name="disp_infusion_over_miniute")
	public Integer getDispInfusionOverMiniute() {
		return this.dispInfusionOverMiniute;
	}

	public void setDispInfusionOverMiniute(Integer dispInfusionOverMiniute) {
		this.dispInfusionOverMiniute = dispInfusionOverMiniute;
	}


	@Column(name="disp_infusion_rate")
	public BigDecimal getDispInfusionRate() {
		return this.dispInfusionRate;
	}

	public void setDispInfusionRate(BigDecimal dispInfusionRate) {
		this.dispInfusionRate = dispInfusionRate;
	}


	@Column(name="disp_infusion_rate_unit")
	public String getDispInfusionRateUnit() {
		return this.dispInfusionRateUnit;
	}

	public void setDispInfusionRateUnit(String dispInfusionRateUnit) {
		this.dispInfusionRateUnit = dispInfusionRateUnit;
	}


	@Column(name="disp_qty_diluent")
	public BigDecimal getDispQtyDiluent() {
		return this.dispQtyDiluent;
	}

	public void setDispQtyDiluent(BigDecimal dispQtyDiluent) {
		this.dispQtyDiluent = dispQtyDiluent;
	}


	@Column(name="disp_qty_drug")
	public BigDecimal getDispQtyDrug() {
		return this.dispQtyDrug;
	}

	public void setDispQtyDrug(BigDecimal dispQtyDrug) {
		this.dispQtyDrug = dispQtyDrug;
	}


	@Column(name="disp_route_code")
	public String getDispRouteCode() {
		return this.dispRouteCode;
	}

	public void setDispRouteCode(String dispRouteCode) {
		this.dispRouteCode = dispRouteCode;
	}


	@Column(name="disp_start_date_time")
	public Date getDispStartDateTime() {
		return this.dispStartDateTime;
	}

	public void setDispStartDateTime(Date dispStartDateTime) {
		this.dispStartDateTime = dispStartDateTime;
	}


	@Column(name="disp_total_dose")
	public BigDecimal getDispTotalDose() {
		return this.dispTotalDose;
	}

	public void setDispTotalDose(BigDecimal dispTotalDose) {
		this.dispTotalDose = dispTotalDose;
	}


	@Column(name="disp_total_drug_qty")
	public BigDecimal getDispTotalDrugQty() {
		return this.dispTotalDrugQty;
	}

	public void setDispTotalDrugQty(BigDecimal dispTotalDrugQty) {
		this.dispTotalDrugQty = dispTotalDrugQty;
	}


	@Column(name="disp_total_fluid_volume")
	public BigDecimal getDispTotalFluidVolume() {
		return this.dispTotalFluidVolume;
	}

	public void setDispTotalFluidVolume(BigDecimal dispTotalFluidVolume) {
		this.dispTotalFluidVolume = dispTotalFluidVolume;
	}


	@Column(name="dispensed_uom_abbr")
	public String getDispensedUomAbbr() {
		return this.dispensedUomAbbr;
	}

	public void setDispensedUomAbbr(String dispensedUomAbbr) {
		this.dispensedUomAbbr = dispensedUomAbbr;
	}


	@Column(name="dispensing_remarks")
	public String getDispensingRemarks() {
		return this.dispensingRemarks;
	}

	public void setDispensingRemarks(String dispensingRemarks) {
		this.dispensingRemarks = dispensingRemarks;
	}


	@Column(name="drug_order_qty")
	public BigDecimal getDrugOrderQty() {
		return this.drugOrderQty;
	}

	public void setDrugOrderQty(BigDecimal drugOrderQty) {
		this.drugOrderQty = drugOrderQty;
	}


	@Column(name="hold_remarks")
	public String getHoldRemarks() {
		return this.holdRemarks;
	}

	public void setHoldRemarks(String holdRemarks) {
		this.holdRemarks = holdRemarks;
	}


	@Column(name="no_of_dose")
	public Integer getNoOfDose() {
		return this.noOfDose;
	}

	public void setNoOfDose(Integer noOfDose) {
		this.noOfDose = noOfDose;
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


	@Column(name="prep_instruction")
	public String getPrepInstruction() {
		return this.prepInstruction;
	}

	public void setPrepInstruction(String prepInstruction) {
		this.prepInstruction = prepInstruction;
	}


	@Column(name="preparation_remarks")
	public String getPreparationRemarks() {
		return this.preparationRemarks;
	}

	public void setPreparationRemarks(String preparationRemarks) {
		this.preparationRemarks = preparationRemarks;
	}


	@Column(name="prepare_admixture_yn")
	public String getPrepareAdmixtureYn() {
		return this.prepareAdmixtureYn;
	}

	public void setPrepareAdmixtureYn(String prepareAdmixtureYn) {
		this.prepareAdmixtureYn = prepareAdmixtureYn;
	}


	public String getProtectlightyn() {
		return this.protectlightyn;
	}

	public void setProtectlightyn(String protectlightyn) {
		this.protectlightyn = protectlightyn;
	}


	@Column(name="recons_fluid")
	public String getReconsFluid() {
		return this.reconsFluid;
	}

	public void setReconsFluid(String reconsFluid) {
		this.reconsFluid = reconsFluid;
	}


	public String getRefrigerateyn() {
		return this.refrigerateyn;
	}

	public void setRefrigerateyn(String refrigerateyn) {
		this.refrigerateyn = refrigerateyn;
	}


	public String getRoomtemptyn() {
		return this.roomtemptyn;
	}

	public void setRoomtemptyn(String roomtemptyn) {
		this.roomtemptyn = roomtemptyn;
	}


	@Column(name="supervised_by")
	public String getSupervisedBy() {
		return this.supervisedBy;
	}

	public void setSupervisedBy(String supervisedBy) {
		this.supervisedBy = supervisedBy;
	}


	@Column(name="updated_by")
	public Long getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}


	@Column(name="updated_date")
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}


	@Column(name="verification_remarks")
	public String getVerificationRemarks() {
		return this.verificationRemarks;
	}

	public void setVerificationRemarks(String verificationRemarks) {
		this.verificationRemarks = verificationRemarks;
	}


	//bi-directional many-to-one association to CdrDrugsInt
	@ManyToOne
	@JoinColumn(name="cdr_drug_int_seqno")
	@JsonBackReference("CdrDispensingInt")
	public CdrDrugsInt getCdrDrugsInt() {
		return this.cdrDrugsInt;
	}

	public void setCdrDrugsInt(CdrDrugsInt cdrDrugsInt) {
		this.cdrDrugsInt = cdrDrugsInt;
	}

}