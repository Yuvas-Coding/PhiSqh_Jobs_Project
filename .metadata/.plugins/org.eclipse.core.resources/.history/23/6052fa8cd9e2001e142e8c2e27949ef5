package my.com.cmg.iwp.backend.model.integration.pn;

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
 * The persistent class for the ph_pn_prep_cal_int database table.
 * 
 */
@Entity
@Table(name="t_pn_prep_cal_int")
@JsonIgnoreProperties(ignoreUnknown=true)
public class PnPrepCalInt implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long pnPrepareCalIntSeqno;
	private BigDecimal acetateAcetateQty;
	private BigDecimal acetateAllocatedQty;
	private String acetateDrugCode;
	private BigDecimal acetateOrderQty;
	private BigDecimal acetateOsmo;
	private BigDecimal acetateSodiumQty;
	private BigDecimal acetateVol;
	private String aminoAcidDrugCode;
	private BigDecimal aminoAcidOsmo;
	private BigDecimal aminoAcidVol;
	private Integer aminoAllocatedQty;
	private BigDecimal aminoAminoQty;
	private Integer aminoOrderQty;
	private BigDecimal asidAminoCal;
	private BigDecimal calCalQty;
	private BigDecimal calOsmo;
	private Integer calciumAllocatedQty;
	private String calciumDrugCode;
	private Integer calciumOrderQty;
	private BigDecimal calciumVol;
	private Long createdBy;
	private Date createdDate;
	private Integer fatSolAllocatedQty;
	private Integer fatSolOrderQty;
	private String fatSolubleDrugCode;
	private BigDecimal fatSolubleOsmo;
	private BigDecimal fatSolubleVol;
	private BigDecimal glucodeVol;
	private Integer glucoseAllocatedQty;
	private BigDecimal glucoseCal;
	private String glucoseDrugCode;
	private BigDecimal glucoseGlucoseQty;
	private Integer glucoseOrderQty;
	private BigDecimal glucoseOsmo;
	private Integer lipidAllocatedQty;
	private BigDecimal lipidCal;
	private String lipidDrugCode;
	private BigDecimal lipidLipidQty;
	private Integer lipidOrderQty;
	private BigDecimal lipidOsmo;
	private BigDecimal lipidVol;
	private Integer magAllocatedQty;
	private String magDrugCode;
	private BigDecimal magMagQty;
	private Integer magOrderQty;
	private BigDecimal magOsmo;
	private BigDecimal magVol;
	private String parameter1;
	private String parameter2;
	private BigDecimal parameter3;
	private BigDecimal parameter4;
	private Date parameter5;
	private Integer phosAllocatedQty;
	private String phosDrugCode;
	private Integer phosOrderQty;
	private BigDecimal phosOsmo;
	private BigDecimal phosPhosQty;
	private BigDecimal phosPotaQty;
	private BigDecimal phosSodiumQty;
	private BigDecimal phosVol;
	private BigDecimal potaAcetateQty;
	private Integer potaAllocatedQty;
	private BigDecimal potaChlorideQty;
	private String potaDrugCode;
	private Integer potaOrderQty;
	private BigDecimal potaOsmo;
	private BigDecimal potaPotaQty;
	private BigDecimal potaVol;
	private Long prepareCalHeaderIntSeqno;
	private BigDecimal sodiumAcetateQty;
	private Integer sodiumAllocatedQty;
	private BigDecimal sodiumChlorideQty;
	private String sodiumDrugCode;
	private Integer sodiumOrderQty;
	private BigDecimal sodiumOsmo;
	private BigDecimal sodiumSodiumQty;
	private BigDecimal sodiumVol;
	private BigDecimal totalAcetateQty;
	private BigDecimal totalAminoQty;
	private BigDecimal totalCalQty;
	private BigDecimal totalChlorideQty;
	private BigDecimal totalGlucoseQty;
	private BigDecimal totalLipidQty;
	private BigDecimal totalLipidSyringeQty;
	private BigDecimal totalMagQty;
	private BigDecimal totalPhosQty;
	private BigDecimal totalPotaQty;
	private BigDecimal totalPrepareCal;
	private BigDecimal totalPrepareLipidCal;
	private BigDecimal totalPrepareLipidOsmo;
	private BigDecimal totalPrepareLipidVol;
	private BigDecimal totalPrepareOsmo;
	private BigDecimal totalPrepareVol;
	private BigDecimal totalSodiumQty;
	private Integer traceAllocatedQty;
	private String traceElementDrugCode;
	private Integer traceElementOrderQty;
	private BigDecimal traceElementOsmo;
	private BigDecimal traceElementVol;
	private Long updatedBy;
	private Date updatedDate;
	private Integer vitSolAllocatedQty;
	private Integer vitSolOrderQty;
	private String vitaminSolDrugCode;
	private BigDecimal vitaminSolOsmo;
	private BigDecimal vitaminSolVol;
	private Integer watAllocatedQty;
	private Integer watOrderQty;
	private Integer watSolAllocatedQty;
	private Integer watSolOrderQty;
	private String waterDrugCode;
	private BigDecimal waterSolOsmo;
	private String waterSolubleDrugCode;
	private BigDecimal waterSolubleOsmo;
	private BigDecimal waterSolubleVol;
	private BigDecimal waterVol;
	
	private String glutaminDrugCode;
	private BigDecimal glutaminVol;
	private BigDecimal glutaminOsmo;
	private Integer glutaminAllocatedQty;
	private BigDecimal totalGlutaminQty;
	private Integer glutaminOrderQty;
	private BigDecimal glutaminCal;
	private BigDecimal totalPrepareGlutaminCal;

	private PnPrepCalHeaderInt pnPrepCalHeaderInt;

	public PnPrepCalInt() {
	}


	@Id
	@SequenceGenerator(name="PH_PN_PREP_CAL_INT_PNPREPARECALINTSEQNO_GENERATOR", sequenceName="T_PN_PREP_CAL_INT_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PH_PN_PREP_CAL_INT_PNPREPARECALINTSEQNO_GENERATOR")
	@Column(name="pn_prepare_cal_int_seqno")
	@JsonIgnore
	public Long getPnPrepareCalIntSeqno() {
		return this.pnPrepareCalIntSeqno;
	}

	public void setPnPrepareCalIntSeqno(Long pnPrepareCalIntSeqno) {
		this.pnPrepareCalIntSeqno = pnPrepareCalIntSeqno;
	}


	@Column(name="acetate_acetate_qty")
	public BigDecimal getAcetateAcetateQty() {
		return this.acetateAcetateQty;
	}

	public void setAcetateAcetateQty(BigDecimal acetateAcetateQty) {
		this.acetateAcetateQty = acetateAcetateQty;
	}


	@Column(name="acetate_allocated_qty")
	public BigDecimal getAcetateAllocatedQty() {
		return this.acetateAllocatedQty;
	}

	public void setAcetateAllocatedQty(BigDecimal acetateAllocatedQty) {
		this.acetateAllocatedQty = acetateAllocatedQty;
	}


	@Column(name="acetate_drug_code")
	public String getAcetateDrugCode() {
		return this.acetateDrugCode;
	}

	public void setAcetateDrugCode(String acetateDrugCode) {
		this.acetateDrugCode = acetateDrugCode;
	}


	@Column(name="acetate_order_qty")
	public BigDecimal getAcetateOrderQty() {
		return this.acetateOrderQty;
	}

	public void setAcetateOrderQty(BigDecimal acetateOrderQty) {
		this.acetateOrderQty = acetateOrderQty;
	}


	@Column(name="acetate_osmo")
	public BigDecimal getAcetateOsmo() {
		return this.acetateOsmo;
	}

	public void setAcetateOsmo(BigDecimal acetateOsmo) {
		this.acetateOsmo = acetateOsmo;
	}


	@Column(name="acetate_sodium_qty")
	public BigDecimal getAcetateSodiumQty() {
		return this.acetateSodiumQty;
	}

	public void setAcetateSodiumQty(BigDecimal acetateSodiumQty) {
		this.acetateSodiumQty = acetateSodiumQty;
	}


	@Column(name="acetate_vol")
	public BigDecimal getAcetateVol() {
		return this.acetateVol;
	}

	public void setAcetateVol(BigDecimal acetateVol) {
		this.acetateVol = acetateVol;
	}


	@Column(name="amino_acid_drug_code")
	public String getAminoAcidDrugCode() {
		return this.aminoAcidDrugCode;
	}

	public void setAminoAcidDrugCode(String aminoAcidDrugCode) {
		this.aminoAcidDrugCode = aminoAcidDrugCode;
	}


	@Column(name="amino_acid_osmo")
	public BigDecimal getAminoAcidOsmo() {
		return this.aminoAcidOsmo;
	}

	public void setAminoAcidOsmo(BigDecimal aminoAcidOsmo) {
		this.aminoAcidOsmo = aminoAcidOsmo;
	}


	@Column(name="amino_acid_vol")
	public BigDecimal getAminoAcidVol() {
		return this.aminoAcidVol;
	}

	public void setAminoAcidVol(BigDecimal aminoAcidVol) {
		this.aminoAcidVol = aminoAcidVol;
	}


	@Column(name="amino_allocated_qty")
	public Integer getAminoAllocatedQty() {
		return this.aminoAllocatedQty;
	}

	public void setAminoAllocatedQty(Integer aminoAllocatedQty) {
		this.aminoAllocatedQty = aminoAllocatedQty;
	}


	@Column(name="amino_amino_qty")
	public BigDecimal getAminoAminoQty() {
		return this.aminoAminoQty;
	}

	public void setAminoAminoQty(BigDecimal aminoAminoQty) {
		this.aminoAminoQty = aminoAminoQty;
	}


	@Column(name="amino_order_qty")
	public Integer getAminoOrderQty() {
		return this.aminoOrderQty;
	}

	public void setAminoOrderQty(Integer aminoOrderQty) {
		this.aminoOrderQty = aminoOrderQty;
	}


	@Column(name="asid_amino_cal")
	public BigDecimal getAsidAminoCal() {
		return this.asidAminoCal;
	}

	public void setAsidAminoCal(BigDecimal asidAminoCal) {
		this.asidAminoCal = asidAminoCal;
	}


	@Column(name="cal_cal_qty")
	public BigDecimal getCalCalQty() {
		return this.calCalQty;
	}

	public void setCalCalQty(BigDecimal calCalQty) {
		this.calCalQty = calCalQty;
	}


	@Column(name="cal_osmo")
	public BigDecimal getCalOsmo() {
		return this.calOsmo;
	}

	public void setCalOsmo(BigDecimal calOsmo) {
		this.calOsmo = calOsmo;
	}


	@Column(name="calcium_allocated_qty")
	public Integer getCalciumAllocatedQty() {
		return this.calciumAllocatedQty;
	}

	public void setCalciumAllocatedQty(Integer calciumAllocatedQty) {
		this.calciumAllocatedQty = calciumAllocatedQty;
	}


	@Column(name="calcium_drug_code")
	public String getCalciumDrugCode() {
		return this.calciumDrugCode;
	}

	public void setCalciumDrugCode(String calciumDrugCode) {
		this.calciumDrugCode = calciumDrugCode;
	}


	@Column(name="calcium_order_qty")
	public Integer getCalciumOrderQty() {
		return this.calciumOrderQty;
	}

	public void setCalciumOrderQty(Integer calciumOrderQty) {
		this.calciumOrderQty = calciumOrderQty;
	}


	@Column(name="calcium_vol")
	public BigDecimal getCalciumVol() {
		return this.calciumVol;
	}

	public void setCalciumVol(BigDecimal calciumVol) {
		this.calciumVol = calciumVol;
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


	@Column(name="fat_sol_allocated_qty")
	public Integer getFatSolAllocatedQty() {
		return this.fatSolAllocatedQty;
	}

	public void setFatSolAllocatedQty(Integer fatSolAllocatedQty) {
		this.fatSolAllocatedQty = fatSolAllocatedQty;
	}


	@Column(name="fat_sol_order_qty")
	public Integer getFatSolOrderQty() {
		return this.fatSolOrderQty;
	}

	public void setFatSolOrderQty(Integer fatSolOrderQty) {
		this.fatSolOrderQty = fatSolOrderQty;
	}


	@Column(name="fat_soluble_drug_code")
	public String getFatSolubleDrugCode() {
		return this.fatSolubleDrugCode;
	}

	public void setFatSolubleDrugCode(String fatSolubleDrugCode) {
		this.fatSolubleDrugCode = fatSolubleDrugCode;
	}


	@Column(name="fat_soluble_osmo")
	public BigDecimal getFatSolubleOsmo() {
		return this.fatSolubleOsmo;
	}

	public void setFatSolubleOsmo(BigDecimal fatSolubleOsmo) {
		this.fatSolubleOsmo = fatSolubleOsmo;
	}


	@Column(name="fat_soluble_vol")
	public BigDecimal getFatSolubleVol() {
		return this.fatSolubleVol;
	}

	public void setFatSolubleVol(BigDecimal fatSolubleVol) {
		this.fatSolubleVol = fatSolubleVol;
	}


	@Column(name="glucode_vol")
	public BigDecimal getGlucodeVol() {
		return this.glucodeVol;
	}

	public void setGlucodeVol(BigDecimal glucodeVol) {
		this.glucodeVol = glucodeVol;
	}


	@Column(name="glucose_allocated_qty")
	public Integer getGlucoseAllocatedQty() {
		return this.glucoseAllocatedQty;
	}

	public void setGlucoseAllocatedQty(Integer glucoseAllocatedQty) {
		this.glucoseAllocatedQty = glucoseAllocatedQty;
	}


	@Column(name="glucose_cal")
	public BigDecimal getGlucoseCal() {
		return this.glucoseCal;
	}

	public void setGlucoseCal(BigDecimal glucoseCal) {
		this.glucoseCal = glucoseCal;
	}


	@Column(name="glucose_drug_code")
	public String getGlucoseDrugCode() {
		return this.glucoseDrugCode;
	}

	public void setGlucoseDrugCode(String glucoseDrugCode) {
		this.glucoseDrugCode = glucoseDrugCode;
	}


	@Column(name="glucose_glucose_qty")
	public BigDecimal getGlucoseGlucoseQty() {
		return this.glucoseGlucoseQty;
	}

	public void setGlucoseGlucoseQty(BigDecimal glucoseGlucoseQty) {
		this.glucoseGlucoseQty = glucoseGlucoseQty;
	}


	@Column(name="glucose_order_qty")
	public Integer getGlucoseOrderQty() {
		return this.glucoseOrderQty;
	}

	public void setGlucoseOrderQty(Integer glucoseOrderQty) {
		this.glucoseOrderQty = glucoseOrderQty;
	}


	@Column(name="glucose_osmo")
	public BigDecimal getGlucoseOsmo() {
		return this.glucoseOsmo;
	}

	public void setGlucoseOsmo(BigDecimal glucoseOsmo) {
		this.glucoseOsmo = glucoseOsmo;
	}


	@Column(name="lipid_allocated_qty")
	public Integer getLipidAllocatedQty() {
		return this.lipidAllocatedQty;
	}

	public void setLipidAllocatedQty(Integer lipidAllocatedQty) {
		this.lipidAllocatedQty = lipidAllocatedQty;
	}


	@Column(name="lipid_cal")
	public BigDecimal getLipidCal() {
		return this.lipidCal;
	}

	public void setLipidCal(BigDecimal lipidCal) {
		this.lipidCal = lipidCal;
	}


	@Column(name="lipid_drug_code")
	public String getLipidDrugCode() {
		return this.lipidDrugCode;
	}

	public void setLipidDrugCode(String lipidDrugCode) {
		this.lipidDrugCode = lipidDrugCode;
	}


	@Column(name="lipid_lipid_qty")
	public BigDecimal getLipidLipidQty() {
		return this.lipidLipidQty;
	}

	public void setLipidLipidQty(BigDecimal lipidLipidQty) {
		this.lipidLipidQty = lipidLipidQty;
	}


	@Column(name="lipid_order_qty")
	public Integer getLipidOrderQty() {
		return this.lipidOrderQty;
	}

	public void setLipidOrderQty(Integer lipidOrderQty) {
		this.lipidOrderQty = lipidOrderQty;
	}


	@Column(name="lipid_osmo")
	public BigDecimal getLipidOsmo() {
		return this.lipidOsmo;
	}

	public void setLipidOsmo(BigDecimal lipidOsmo) {
		this.lipidOsmo = lipidOsmo;
	}


	@Column(name="lipid_vol")
	public BigDecimal getLipidVol() {
		return this.lipidVol;
	}

	public void setLipidVol(BigDecimal lipidVol) {
		this.lipidVol = lipidVol;
	}


	@Column(name="mag_allocated_qty")
	public Integer getMagAllocatedQty() {
		return this.magAllocatedQty;
	}

	public void setMagAllocatedQty(Integer magAllocatedQty) {
		this.magAllocatedQty = magAllocatedQty;
	}


	@Column(name="mag_drug_code")
	public String getMagDrugCode() {
		return this.magDrugCode;
	}

	public void setMagDrugCode(String magDrugCode) {
		this.magDrugCode = magDrugCode;
	}


	@Column(name="mag_mag_qty")
	public BigDecimal getMagMagQty() {
		return this.magMagQty;
	}

	public void setMagMagQty(BigDecimal magMagQty) {
		this.magMagQty = magMagQty;
	}


	@Column(name="mag_order_qty")
	public Integer getMagOrderQty() {
		return this.magOrderQty;
	}

	public void setMagOrderQty(Integer magOrderQty) {
		this.magOrderQty = magOrderQty;
	}


	@Column(name="mag_osmo")
	public BigDecimal getMagOsmo() {
		return this.magOsmo;
	}

	public void setMagOsmo(BigDecimal magOsmo) {
		this.magOsmo = magOsmo;
	}


	@Column(name="mag_vol")
	public BigDecimal getMagVol() {
		return this.magVol;
	}

	public void setMagVol(BigDecimal magVol) {
		this.magVol = magVol;
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


	@Column(name="phos_allocated_qty")
	public Integer getPhosAllocatedQty() {
		return this.phosAllocatedQty;
	}

	public void setPhosAllocatedQty(Integer phosAllocatedQty) {
		this.phosAllocatedQty = phosAllocatedQty;
	}


	@Column(name="phos_drug_code")
	public String getPhosDrugCode() {
		return this.phosDrugCode;
	}

	public void setPhosDrugCode(String phosDrugCode) {
		this.phosDrugCode = phosDrugCode;
	}


	@Column(name="phos_order_qty")
	public Integer getPhosOrderQty() {
		return this.phosOrderQty;
	}

	public void setPhosOrderQty(Integer phosOrderQty) {
		this.phosOrderQty = phosOrderQty;
	}


	@Column(name="phos_osmo")
	public BigDecimal getPhosOsmo() {
		return this.phosOsmo;
	}

	public void setPhosOsmo(BigDecimal phosOsmo) {
		this.phosOsmo = phosOsmo;
	}


	@Column(name="phos_phos_qty")
	public BigDecimal getPhosPhosQty() {
		return this.phosPhosQty;
	}

	public void setPhosPhosQty(BigDecimal phosPhosQty) {
		this.phosPhosQty = phosPhosQty;
	}


	@Column(name="phos_pota_qty")
	public BigDecimal getPhosPotaQty() {
		return this.phosPotaQty;
	}

	public void setPhosPotaQty(BigDecimal phosPotaQty) {
		this.phosPotaQty = phosPotaQty;
	}


	@Column(name="phos_sodium_qty")
	public BigDecimal getPhosSodiumQty() {
		return this.phosSodiumQty;
	}

	public void setPhosSodiumQty(BigDecimal phosSodiumQty) {
		this.phosSodiumQty = phosSodiumQty;
	}


	@Column(name="phos_vol")
	public BigDecimal getPhosVol() {
		return this.phosVol;
	}

	public void setPhosVol(BigDecimal phosVol) {
		this.phosVol = phosVol;
	}


	@Column(name="pota_acetate_qty")
	public BigDecimal getPotaAcetateQty() {
		return this.potaAcetateQty;
	}

	public void setPotaAcetateQty(BigDecimal potaAcetateQty) {
		this.potaAcetateQty = potaAcetateQty;
	}


	@Column(name="pota_allocated_qty")
	public Integer getPotaAllocatedQty() {
		return this.potaAllocatedQty;
	}

	public void setPotaAllocatedQty(Integer potaAllocatedQty) {
		this.potaAllocatedQty = potaAllocatedQty;
	}


	@Column(name="pota_chloride_qty")
	public BigDecimal getPotaChlorideQty() {
		return this.potaChlorideQty;
	}

	public void setPotaChlorideQty(BigDecimal potaChlorideQty) {
		this.potaChlorideQty = potaChlorideQty;
	}


	@Column(name="pota_drug_code")
	public String getPotaDrugCode() {
		return this.potaDrugCode;
	}

	public void setPotaDrugCode(String potaDrugCode) {
		this.potaDrugCode = potaDrugCode;
	}


	@Column(name="pota_order_qty")
	public Integer getPotaOrderQty() {
		return this.potaOrderQty;
	}

	public void setPotaOrderQty(Integer potaOrderQty) {
		this.potaOrderQty = potaOrderQty;
	}


	@Column(name="pota_osmo")
	public BigDecimal getPotaOsmo() {
		return this.potaOsmo;
	}

	public void setPotaOsmo(BigDecimal potaOsmo) {
		this.potaOsmo = potaOsmo;
	}


	@Column(name="pota_pota_qty")
	public BigDecimal getPotaPotaQty() {
		return this.potaPotaQty;
	}

	public void setPotaPotaQty(BigDecimal potaPotaQty) {
		this.potaPotaQty = potaPotaQty;
	}


	@Column(name="pota_vol")
	public BigDecimal getPotaVol() {
		return this.potaVol;
	}

	public void setPotaVol(BigDecimal potaVol) {
		this.potaVol = potaVol;
	}


	@Column(name="prepare_cal_header_int_seqno", insertable=false, updatable=false)
	public Long getPrepareCalHeaderIntSeqno() {
		return this.prepareCalHeaderIntSeqno;
	}

	public void setPrepareCalHeaderIntSeqno(Long prepareCalHeaderIntSeqno) {
		this.prepareCalHeaderIntSeqno = prepareCalHeaderIntSeqno;
	}


	@Column(name="sodium_acetate_qty")
	public BigDecimal getSodiumAcetateQty() {
		return this.sodiumAcetateQty;
	}

	public void setSodiumAcetateQty(BigDecimal sodiumAcetateQty) {
		this.sodiumAcetateQty = sodiumAcetateQty;
	}


	@Column(name="sodium_allocated_qty")
	public Integer getSodiumAllocatedQty() {
		return this.sodiumAllocatedQty;
	}

	public void setSodiumAllocatedQty(Integer sodiumAllocatedQty) {
		this.sodiumAllocatedQty = sodiumAllocatedQty;
	}


	@Column(name="sodium_chloride_qty")
	public BigDecimal getSodiumChlorideQty() {
		return this.sodiumChlorideQty;
	}

	public void setSodiumChlorideQty(BigDecimal sodiumChlorideQty) {
		this.sodiumChlorideQty = sodiumChlorideQty;
	}


	@Column(name="sodium_drug_code")
	public String getSodiumDrugCode() {
		return this.sodiumDrugCode;
	}

	public void setSodiumDrugCode(String sodiumDrugCode) {
		this.sodiumDrugCode = sodiumDrugCode;
	}


	@Column(name="sodium_order_qty")
	public Integer getSodiumOrderQty() {
		return this.sodiumOrderQty;
	}

	public void setSodiumOrderQty(Integer sodiumOrderQty) {
		this.sodiumOrderQty = sodiumOrderQty;
	}


	@Column(name="sodium_osmo")
	public BigDecimal getSodiumOsmo() {
		return this.sodiumOsmo;
	}

	public void setSodiumOsmo(BigDecimal sodiumOsmo) {
		this.sodiumOsmo = sodiumOsmo;
	}


	@Column(name="sodium_sodium_qty")
	public BigDecimal getSodiumSodiumQty() {
		return this.sodiumSodiumQty;
	}

	public void setSodiumSodiumQty(BigDecimal sodiumSodiumQty) {
		this.sodiumSodiumQty = sodiumSodiumQty;
	}


	@Column(name="sodium_vol")
	public BigDecimal getSodiumVol() {
		return this.sodiumVol;
	}

	public void setSodiumVol(BigDecimal sodiumVol) {
		this.sodiumVol = sodiumVol;
	}


	@Column(name="total_acetate_qty")
	public BigDecimal getTotalAcetateQty() {
		return this.totalAcetateQty;
	}

	public void setTotalAcetateQty(BigDecimal totalAcetateQty) {
		this.totalAcetateQty = totalAcetateQty;
	}


	@Column(name="total_amino_qty")
	public BigDecimal getTotalAminoQty() {
		return this.totalAminoQty;
	}

	public void setTotalAminoQty(BigDecimal totalAminoQty) {
		this.totalAminoQty = totalAminoQty;
	}


	@Column(name="total_cal_qty")
	public BigDecimal getTotalCalQty() {
		return this.totalCalQty;
	}

	public void setTotalCalQty(BigDecimal totalCalQty) {
		this.totalCalQty = totalCalQty;
	}


	@Column(name="total_chloride_qty")
	public BigDecimal getTotalChlorideQty() {
		return this.totalChlorideQty;
	}

	public void setTotalChlorideQty(BigDecimal totalChlorideQty) {
		this.totalChlorideQty = totalChlorideQty;
	}


	@Column(name="total_glucose_qty")
	public BigDecimal getTotalGlucoseQty() {
		return this.totalGlucoseQty;
	}

	public void setTotalGlucoseQty(BigDecimal totalGlucoseQty) {
		this.totalGlucoseQty = totalGlucoseQty;
	}


	@Column(name="total_lipid_qty")
	public BigDecimal getTotalLipidQty() {
		return this.totalLipidQty;
	}

	public void setTotalLipidQty(BigDecimal totalLipidQty) {
		this.totalLipidQty = totalLipidQty;
	}


	@Column(name="total_lipid_syringe_qty")
	public BigDecimal getTotalLipidSyringeQty() {
		return this.totalLipidSyringeQty;
	}

	public void setTotalLipidSyringeQty(BigDecimal totalLipidSyringeQty) {
		this.totalLipidSyringeQty = totalLipidSyringeQty;
	}


	@Column(name="total_mag_qty")
	public BigDecimal getTotalMagQty() {
		return this.totalMagQty;
	}

	public void setTotalMagQty(BigDecimal totalMagQty) {
		this.totalMagQty = totalMagQty;
	}


	@Column(name="total_phos_qty")
	public BigDecimal getTotalPhosQty() {
		return this.totalPhosQty;
	}

	public void setTotalPhosQty(BigDecimal totalPhosQty) {
		this.totalPhosQty = totalPhosQty;
	}


	@Column(name="total_pota_qty")
	public BigDecimal getTotalPotaQty() {
		return this.totalPotaQty;
	}

	public void setTotalPotaQty(BigDecimal totalPotaQty) {
		this.totalPotaQty = totalPotaQty;
	}


	@Column(name="total_prepare_cal")
	public BigDecimal getTotalPrepareCal() {
		return this.totalPrepareCal;
	}

	public void setTotalPrepareCal(BigDecimal totalPrepareCal) {
		this.totalPrepareCal = totalPrepareCal;
	}


	@Column(name="total_prepare_lipid_cal")
	public BigDecimal getTotalPrepareLipidCal() {
		return this.totalPrepareLipidCal;
	}

	public void setTotalPrepareLipidCal(BigDecimal totalPrepareLipidCal) {
		this.totalPrepareLipidCal = totalPrepareLipidCal;
	}


	@Column(name="total_prepare_lipid_osmo")
	public BigDecimal getTotalPrepareLipidOsmo() {
		return this.totalPrepareLipidOsmo;
	}

	public void setTotalPrepareLipidOsmo(BigDecimal totalPrepareLipidOsmo) {
		this.totalPrepareLipidOsmo = totalPrepareLipidOsmo;
	}


	@Column(name="total_prepare_lipid_vol")
	public BigDecimal getTotalPrepareLipidVol() {
		return this.totalPrepareLipidVol;
	}

	public void setTotalPrepareLipidVol(BigDecimal totalPrepareLipidVol) {
		this.totalPrepareLipidVol = totalPrepareLipidVol;
	}


	@Column(name="total_prepare_osmo")
	public BigDecimal getTotalPrepareOsmo() {
		return this.totalPrepareOsmo;
	}

	public void setTotalPrepareOsmo(BigDecimal totalPrepareOsmo) {
		this.totalPrepareOsmo = totalPrepareOsmo;
	}


	@Column(name="total_prepare_vol")
	public BigDecimal getTotalPrepareVol() {
		return this.totalPrepareVol;
	}

	public void setTotalPrepareVol(BigDecimal totalPrepareVol) {
		this.totalPrepareVol = totalPrepareVol;
	}


	@Column(name="total_sodium_qty")
	public BigDecimal getTotalSodiumQty() {
		return this.totalSodiumQty;
	}

	public void setTotalSodiumQty(BigDecimal totalSodiumQty) {
		this.totalSodiumQty = totalSodiumQty;
	}


	@Column(name="trace_allocated_qty")
	public Integer getTraceAllocatedQty() {
		return this.traceAllocatedQty;
	}

	public void setTraceAllocatedQty(Integer traceAllocatedQty) {
		this.traceAllocatedQty = traceAllocatedQty;
	}


	@Column(name="trace_element_drug_code")
	public String getTraceElementDrugCode() {
		return this.traceElementDrugCode;
	}

	public void setTraceElementDrugCode(String traceElementDrugCode) {
		this.traceElementDrugCode = traceElementDrugCode;
	}


	@Column(name="trace_element_order_qty")
	public Integer getTraceElementOrderQty() {
		return this.traceElementOrderQty;
	}

	public void setTraceElementOrderQty(Integer traceElementOrderQty) {
		this.traceElementOrderQty = traceElementOrderQty;
	}


	@Column(name="trace_element_osmo")
	public BigDecimal getTraceElementOsmo() {
		return this.traceElementOsmo;
	}

	public void setTraceElementOsmo(BigDecimal traceElementOsmo) {
		this.traceElementOsmo = traceElementOsmo;
	}


	@Column(name="trace_element_vol")
	public BigDecimal getTraceElementVol() {
		return this.traceElementVol;
	}

	public void setTraceElementVol(BigDecimal traceElementVol) {
		this.traceElementVol = traceElementVol;
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


	@Column(name="vit_sol_allocated_qty")
	public Integer getVitSolAllocatedQty() {
		return this.vitSolAllocatedQty;
	}

	public void setVitSolAllocatedQty(Integer vitSolAllocatedQty) {
		this.vitSolAllocatedQty = vitSolAllocatedQty;
	}


	@Column(name="vit_sol_order_qty")
	public Integer getVitSolOrderQty() {
		return this.vitSolOrderQty;
	}

	public void setVitSolOrderQty(Integer vitSolOrderQty) {
		this.vitSolOrderQty = vitSolOrderQty;
	}


	@Column(name="vitamin_sol_drug_code")
	public String getVitaminSolDrugCode() {
		return this.vitaminSolDrugCode;
	}

	public void setVitaminSolDrugCode(String vitaminSolDrugCode) {
		this.vitaminSolDrugCode = vitaminSolDrugCode;
	}


	@Column(name="vitamin_sol_osmo")
	public BigDecimal getVitaminSolOsmo() {
		return this.vitaminSolOsmo;
	}

	public void setVitaminSolOsmo(BigDecimal vitaminSolOsmo) {
		this.vitaminSolOsmo = vitaminSolOsmo;
	}


	@Column(name="vitamin_sol_vol")
	public BigDecimal getVitaminSolVol() {
		return this.vitaminSolVol;
	}

	public void setVitaminSolVol(BigDecimal vitaminSolVol) {
		this.vitaminSolVol = vitaminSolVol;
	}


	@Column(name="wat_allocated_qty")
	public Integer getWatAllocatedQty() {
		return this.watAllocatedQty;
	}

	public void setWatAllocatedQty(Integer watAllocatedQty) {
		this.watAllocatedQty = watAllocatedQty;
	}


	@Column(name="wat_order_qty")
	public Integer getWatOrderQty() {
		return this.watOrderQty;
	}

	public void setWatOrderQty(Integer watOrderQty) {
		this.watOrderQty = watOrderQty;
	}


	@Column(name="wat_sol_allocated_qty")
	public Integer getWatSolAllocatedQty() {
		return this.watSolAllocatedQty;
	}

	public void setWatSolAllocatedQty(Integer watSolAllocatedQty) {
		this.watSolAllocatedQty = watSolAllocatedQty;
	}


	@Column(name="wat_sol_order_qty")
	public Integer getWatSolOrderQty() {
		return this.watSolOrderQty;
	}

	public void setWatSolOrderQty(Integer watSolOrderQty) {
		this.watSolOrderQty = watSolOrderQty;
	}


	@Column(name="water_drug_code")
	public String getWaterDrugCode() {
		return this.waterDrugCode;
	}

	public void setWaterDrugCode(String waterDrugCode) {
		this.waterDrugCode = waterDrugCode;
	}


	@Column(name="water_sol_osmo")
	public BigDecimal getWaterSolOsmo() {
		return this.waterSolOsmo;
	}

	public void setWaterSolOsmo(BigDecimal waterSolOsmo) {
		this.waterSolOsmo = waterSolOsmo;
	}


	@Column(name="water_soluble_drug_code")
	public String getWaterSolubleDrugCode() {
		return this.waterSolubleDrugCode;
	}

	public void setWaterSolubleDrugCode(String waterSolubleDrugCode) {
		this.waterSolubleDrugCode = waterSolubleDrugCode;
	}


	@Column(name="water_soluble_osmo")
	public BigDecimal getWaterSolubleOsmo() {
		return this.waterSolubleOsmo;
	}

	public void setWaterSolubleOsmo(BigDecimal waterSolubleOsmo) {
		this.waterSolubleOsmo = waterSolubleOsmo;
	}


	@Column(name="water_soluble_vol")
	public BigDecimal getWaterSolubleVol() {
		return this.waterSolubleVol;
	}

	public void setWaterSolubleVol(BigDecimal waterSolubleVol) {
		this.waterSolubleVol = waterSolubleVol;
	}


	@Column(name="water_vol")
	public BigDecimal getWaterVol() {
		return this.waterVol;
	}

	public void setWaterVol(BigDecimal waterVol) {
		this.waterVol = waterVol;
	}

	@ManyToOne
	@JoinColumn(name="prepare_cal_header_int_seqno", referencedColumnName="prepare_cal_header_int_seqno")
	@JsonBackReference("PnPrepCalInt")
	public PnPrepCalHeaderInt getPnPrepCalHeaderInt() {
		return this.pnPrepCalHeaderInt;
	}

	public void setPnPrepCalHeaderInt(PnPrepCalHeaderInt pnPrepCalHeaderInt) {
		this.pnPrepCalHeaderInt = pnPrepCalHeaderInt;
	}
	
	@Column(name="glutamin_drug_code")
	public String getGlutaminDrugCode() {
		
		return this.glutaminDrugCode;
	}

	public void setGlutaminDrugCode(String glutaminDrugCode) {
		this.glutaminDrugCode = glutaminDrugCode;
	}
	
	@Column(name="glutamin_vol")
	public BigDecimal getGlutaminVol() {
		return this.glutaminVol;
	}

	public void setglutaminVol(BigDecimal glutaminVol) {
		this.glutaminVol = glutaminVol;
	}
	
	@Column(name="glutamin_osmo")
	public BigDecimal getGlutaminOsmo() {
		return this.glutaminOsmo;
	}

	public void setGlutaminOsmo(BigDecimal glutaminOsmo) {
		this.glutaminOsmo = glutaminOsmo;
	}
	
	@Column(name="glutamin_allocated_qty")
	public Integer getGlutaminAllocatedQty() {
		return this.glutaminAllocatedQty;
	}

	public void setGlutaminAllocatedQty(Integer glutaminAllocatedQty) {
		this.glutaminAllocatedQty = glutaminAllocatedQty;
	}
	
	@Column(name="total_glutamin_qty")
	public BigDecimal getTotalGlutaminQty() {
		return this.totalGlutaminQty;
	}

	public void setTotalGlutaminQty(BigDecimal totalGlutaminQty) {
		this.totalGlutaminQty = totalGlutaminQty;
	}
	
	@Column(name="glutamin_order_qty")
	public Integer getGlutaminOrderQty() {
		return this.glutaminOrderQty;
	}

	public void setGlutaminOrderQty(Integer glutaminOrderQty) {
		this.glutaminOrderQty = glutaminOrderQty;
	}
	
	@Column(name="glutamin_cal")
	public BigDecimal getGlutaminCal() {
		return this.glutaminCal;
	}

	public void setGlutaminCal(BigDecimal glutaminCal) {
		this.glutaminCal = glutaminCal;
	}
	
	@Column(name="total_prepare_glutamin_cal")
	public BigDecimal getTotalPrepareGlutaminCal() {
		return this.totalPrepareGlutaminCal;
	}

	public void setTotalPrepareGlutaminCal(BigDecimal totalPrepareGlutaminCal) {
		this.totalPrepareGlutaminCal = totalPrepareGlutaminCal;
	}
}