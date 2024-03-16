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
 * The persistent class for the ph_pn_nutritional_assmnt_int database table.
 * 
 */
@Entity
@Table(name = "T_PN_NUTRITIONL_ASMNT_INT")
@XmlRootElement(name = "PnNutritionalAssmntInt")
@JsonIgnoreProperties(ignoreUnknown=true)
public class PnNutritionalAssmntInt implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long assmntIntSeqno;
	private String changeHistory;
	private Long createdBy;
	private Date createdDate;
	private String dietary;
	private Integer duration;
	private String dysfunctionNote;
	private String foodIntakeAsr;
	private String foodIntakeCtr;
	private BigDecimal fsImpairedScore;
	private String fsImpairedStatus;
	private BigDecimal fsSevereDeseaseScore;
	private String fsSevereDeseaseStatus;
	private BigDecimal fsTotalScore;
	private String functionalCapacity;
	private String functionalCapacityAsr;
	private String functionalCapacityCtr;
	private String gastroDiarrhea;
	private String gastroLossAppetite;
	private String gastroNausea;
	private String gastroSptnAsr;
	private String gastroSptnCtr;
	private String gastroVomitting;
	private BigDecimal lossHistory;
	private String nrsQ1;
	private String nrsQ2;
	private String nrsQ3;
	private String nrsQ4;
	private String nutritionalAssmntNo;
	private String parameter1;
	private String parameter2;
	private BigDecimal parameter3;
	private BigDecimal parameter4;
	private Date parameter5;
	private String peAnkleOedemaAsr;
	private String peAnkleOedemaCtr;
	private String peAscitesAsr;
	private String peAscitesCtr;
	private String peLossFatAsr;
	private String peLossFatCtr;
	private String peMuscleWastingAsr;
	private String peMuscleWastingCtr;
	private String peSacralOedemaAsr;
	private String peSacralOedemaCtr;
	private Integer physicalAnkleEdema;
	private Integer physicalAscites;
	private Integer physicalLossFat;
	private Integer physicalLossMass;
	private Integer physicalSacralEdema;
	private String realtionToNutritionAsr;
	private Long regimenIntSeqno;
	private String relationToNutritionCtr;
	private String sgaGrade;
	private String sgaScore;
	private String typeOfChange;
	private Long updatedBy;
	private Date updatedDate;
	private BigDecimal weightHistoy;
	private String weightLossAsr;
	private String weightLossCtr;

	private PnOrderRegimenInt pnOrderRegimenInt;

	public PnNutritionalAssmntInt() {
	}

	@Id
	@SequenceGenerator(name = "PH_PN_NUTRITIONAL_ASSMNT_INT_ASSMNTINTSEQNO_GENERATOR", sequenceName = "T_PN_NUTRITIONL_ASMNT_INT_SEQ", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PH_PN_NUTRITIONAL_ASSMNT_INT_ASSMNTINTSEQNO_GENERATOR")
	@Column(name = "assmnt_int_seqno")
	@JsonIgnore
	public Long getAssmntIntSeqno() {
		return this.assmntIntSeqno;
	}

	public void setAssmntIntSeqno(Long assmntIntSeqno) {
		this.assmntIntSeqno = assmntIntSeqno;
	}

	@Column(name="change_history")
	public String getChangeHistory() {
		return this.changeHistory;
	}

	public void setChangeHistory(String changeHistory) {
		this.changeHistory = changeHistory;
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


	public String getDietary() {
		return this.dietary;
	}

	public void setDietary(String dietary) {
		this.dietary = dietary;
	}


	public Integer getDuration() {
		return this.duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}


	@Column(name="dysfunction_note")
	public String getDysfunctionNote() {
		return this.dysfunctionNote;
	}

	public void setDysfunctionNote(String dysfunctionNote) {
		this.dysfunctionNote = dysfunctionNote;
	}


	@Column(name="food_intake_asr")
	public String getFoodIntakeAsr() {
		return this.foodIntakeAsr;
	}

	public void setFoodIntakeAsr(String foodIntakeAsr) {
		this.foodIntakeAsr = foodIntakeAsr;
	}


	@Column(name="food_intake_ctr")
	public String getFoodIntakeCtr() {
		return this.foodIntakeCtr;
	}

	public void setFoodIntakeCtr(String foodIntakeCtr) {
		this.foodIntakeCtr = foodIntakeCtr;
	}


	@Column(name="fs_impaired_score")
	public BigDecimal getFsImpairedScore() {
		return this.fsImpairedScore;
	}

	public void setFsImpairedScore(BigDecimal fsImpairedScore) {
		this.fsImpairedScore = fsImpairedScore;
	}


	@Column(name="fs_impaired_status")
	public String getFsImpairedStatus() {
		return this.fsImpairedStatus;
	}

	public void setFsImpairedStatus(String fsImpairedStatus) {
		this.fsImpairedStatus = fsImpairedStatus;
	}


	@Column(name="fs_severe_desease_score")
	public BigDecimal getFsSevereDeseaseScore() {
		return this.fsSevereDeseaseScore;
	}

	public void setFsSevereDeseaseScore(BigDecimal fsSevereDeseaseScore) {
		this.fsSevereDeseaseScore = fsSevereDeseaseScore;
	}


	@Column(name="fs_severe_desease_status")
	public String getFsSevereDeseaseStatus() {
		return this.fsSevereDeseaseStatus;
	}

	public void setFsSevereDeseaseStatus(String fsSevereDeseaseStatus) {
		this.fsSevereDeseaseStatus = fsSevereDeseaseStatus;
	}


	@Column(name="fs_total_score")
	public BigDecimal getFsTotalScore() {
		return this.fsTotalScore;
	}

	public void setFsTotalScore(BigDecimal fsTotalScore) {
		this.fsTotalScore = fsTotalScore;
	}


	@Column(name="functional_capacity")
	public String getFunctionalCapacity() {
		return this.functionalCapacity;
	}

	public void setFunctionalCapacity(String functionalCapacity) {
		this.functionalCapacity = functionalCapacity;
	}


	@Column(name="functional_capacity_asr")
	public String getFunctionalCapacityAsr() {
		return this.functionalCapacityAsr;
	}

	public void setFunctionalCapacityAsr(String functionalCapacityAsr) {
		this.functionalCapacityAsr = functionalCapacityAsr;
	}


	@Column(name="functional_capacity_ctr")
	public String getFunctionalCapacityCtr() {
		return this.functionalCapacityCtr;
	}

	public void setFunctionalCapacityCtr(String functionalCapacityCtr) {
		this.functionalCapacityCtr = functionalCapacityCtr;
	}


	@Column(name="gastro_diarrhea")
	public String getGastroDiarrhea() {
		return this.gastroDiarrhea;
	}

	public void setGastroDiarrhea(String gastroDiarrhea) {
		this.gastroDiarrhea = gastroDiarrhea;
	}


	@Column(name="gastro_loss_appetite")
	public String getGastroLossAppetite() {
		return this.gastroLossAppetite;
	}

	public void setGastroLossAppetite(String gastroLossAppetite) {
		this.gastroLossAppetite = gastroLossAppetite;
	}


	@Column(name="gastro_nausea")
	public String getGastroNausea() {
		return this.gastroNausea;
	}

	public void setGastroNausea(String gastroNausea) {
		this.gastroNausea = gastroNausea;
	}


	@Column(name="gastro_sptn_asr")
	public String getGastroSptnAsr() {
		return this.gastroSptnAsr;
	}

	public void setGastroSptnAsr(String gastroSptnAsr) {
		this.gastroSptnAsr = gastroSptnAsr;
	}


	@Column(name="gastro_sptn_ctr")
	public String getGastroSptnCtr() {
		return this.gastroSptnCtr;
	}

	public void setGastroSptnCtr(String gastroSptnCtr) {
		this.gastroSptnCtr = gastroSptnCtr;
	}


	@Column(name="gastro_vomitting")
	public String getGastroVomitting() {
		return this.gastroVomitting;
	}

	public void setGastroVomitting(String gastroVomitting) {
		this.gastroVomitting = gastroVomitting;
	}


	@Column(name="loss_history")
	public BigDecimal getLossHistory() {
		return this.lossHistory;
	}

	public void setLossHistory(BigDecimal lossHistory) {
		this.lossHistory = lossHistory;
	}


	@Column(name="nrs_q1")
	public String getNrsQ1() {
		return this.nrsQ1;
	}

	public void setNrsQ1(String nrsQ1) {
		this.nrsQ1 = nrsQ1;
	}


	@Column(name="nrs_q2")
	public String getNrsQ2() {
		return this.nrsQ2;
	}

	public void setNrsQ2(String nrsQ2) {
		this.nrsQ2 = nrsQ2;
	}


	@Column(name="nrs_q3")
	public String getNrsQ3() {
		return this.nrsQ3;
	}

	public void setNrsQ3(String nrsQ3) {
		this.nrsQ3 = nrsQ3;
	}


	@Column(name="nrs_q4")
	public String getNrsQ4() {
		return this.nrsQ4;
	}

	public void setNrsQ4(String nrsQ4) {
		this.nrsQ4 = nrsQ4;
	}


	@Column(name="nutritional_assmnt_no")
	public String getNutritionalAssmntNo() {
		return this.nutritionalAssmntNo;
	}

	public void setNutritionalAssmntNo(String nutritionalAssmntNo) {
		this.nutritionalAssmntNo = nutritionalAssmntNo;
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


	@Column(name="pe_ankle_oedema_asr")
	public String getPeAnkleOedemaAsr() {
		return this.peAnkleOedemaAsr;
	}

	public void setPeAnkleOedemaAsr(String peAnkleOedemaAsr) {
		this.peAnkleOedemaAsr = peAnkleOedemaAsr;
	}


	@Column(name="pe_ankle_oedema_ctr")
	public String getPeAnkleOedemaCtr() {
		return this.peAnkleOedemaCtr;
	}

	public void setPeAnkleOedemaCtr(String peAnkleOedemaCtr) {
		this.peAnkleOedemaCtr = peAnkleOedemaCtr;
	}


	@Column(name="pe_ascites_asr")
	public String getPeAscitesAsr() {
		return this.peAscitesAsr;
	}

	public void setPeAscitesAsr(String peAscitesAsr) {
		this.peAscitesAsr = peAscitesAsr;
	}


	@Column(name="pe_ascites_ctr")
	public String getPeAscitesCtr() {
		return this.peAscitesCtr;
	}

	public void setPeAscitesCtr(String peAscitesCtr) {
		this.peAscitesCtr = peAscitesCtr;
	}


	@Column(name="pe_loss_fat_asr")
	public String getPeLossFatAsr() {
		return this.peLossFatAsr;
	}

	public void setPeLossFatAsr(String peLossFatAsr) {
		this.peLossFatAsr = peLossFatAsr;
	}


	@Column(name="pe_loss_fat_ctr")
	public String getPeLossFatCtr() {
		return this.peLossFatCtr;
	}

	public void setPeLossFatCtr(String peLossFatCtr) {
		this.peLossFatCtr = peLossFatCtr;
	}


	@Column(name="pe_muscle_wasting_asr")
	public String getPeMuscleWastingAsr() {
		return this.peMuscleWastingAsr;
	}

	public void setPeMuscleWastingAsr(String peMuscleWastingAsr) {
		this.peMuscleWastingAsr = peMuscleWastingAsr;
	}


	@Column(name="pe_muscle_wasting_ctr")
	public String getPeMuscleWastingCtr() {
		return this.peMuscleWastingCtr;
	}

	public void setPeMuscleWastingCtr(String peMuscleWastingCtr) {
		this.peMuscleWastingCtr = peMuscleWastingCtr;
	}


	@Column(name="pe_sacral_oedema_asr")
	public String getPeSacralOedemaAsr() {
		return this.peSacralOedemaAsr;
	}

	public void setPeSacralOedemaAsr(String peSacralOedemaAsr) {
		this.peSacralOedemaAsr = peSacralOedemaAsr;
	}


	@Column(name="pe_sacral_oedema_ctr")
	public String getPeSacralOedemaCtr() {
		return this.peSacralOedemaCtr;
	}

	public void setPeSacralOedemaCtr(String peSacralOedemaCtr) {
		this.peSacralOedemaCtr = peSacralOedemaCtr;
	}


	@Column(name="physical_ankle_edema")
	public Integer getPhysicalAnkleEdema() {
		return this.physicalAnkleEdema;
	}

	public void setPhysicalAnkleEdema(Integer physicalAnkleEdema) {
		this.physicalAnkleEdema = physicalAnkleEdema;
	}


	@Column(name="physical_ascites")
	public Integer getPhysicalAscites() {
		return this.physicalAscites;
	}

	public void setPhysicalAscites(Integer physicalAscites) {
		this.physicalAscites = physicalAscites;
	}


	@Column(name="physical_loss_fat")
	public Integer getPhysicalLossFat() {
		return this.physicalLossFat;
	}

	public void setPhysicalLossFat(Integer physicalLossFat) {
		this.physicalLossFat = physicalLossFat;
	}


	@Column(name="physical_loss_mass")
	public Integer getPhysicalLossMass() {
		return this.physicalLossMass;
	}

	public void setPhysicalLossMass(Integer physicalLossMass) {
		this.physicalLossMass = physicalLossMass;
	}


	@Column(name="physical_sacral_edema")
	public Integer getPhysicalSacralEdema() {
		return this.physicalSacralEdema;
	}

	public void setPhysicalSacralEdema(Integer physicalSacralEdema) {
		this.physicalSacralEdema = physicalSacralEdema;
	}


	@Column(name="realtion_to_nutrition_asr")
	public String getRealtionToNutritionAsr() {
		return this.realtionToNutritionAsr;
	}

	public void setRealtionToNutritionAsr(String realtionToNutritionAsr) {
		this.realtionToNutritionAsr = realtionToNutritionAsr;
	}


	@Column(name="regimen_int_seqno", insertable=false, updatable=false)
	public Long getRegimenIntSeqno() {
		return this.regimenIntSeqno;
	}

	public void setRegimenIntSeqno(Long regimenIntSeqno) {
		this.regimenIntSeqno = regimenIntSeqno;
	}


	@Column(name="relation_to_nutrition_ctr")
	public String getRelationToNutritionCtr() {
		return this.relationToNutritionCtr;
	}

	public void setRelationToNutritionCtr(String relationToNutritionCtr) {
		this.relationToNutritionCtr = relationToNutritionCtr;
	}


	@Column(name="sga_grade")
	public String getSgaGrade() {
		return this.sgaGrade;
	}

	public void setSgaGrade(String sgaGrade) {
		this.sgaGrade = sgaGrade;
	}


	@Column(name="sga_score")
	public String getSgaScore() {
		return this.sgaScore;
	}

	public void setSgaScore(String sgaScore) {
		this.sgaScore = sgaScore;
	}


	@Column(name="type_of_change")
	public String getTypeOfChange() {
		return this.typeOfChange;
	}

	public void setTypeOfChange(String typeOfChange) {
		this.typeOfChange = typeOfChange;
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


	@Column(name="weight_histoy")
	public BigDecimal getWeightHistoy() {
		return this.weightHistoy;
	}

	public void setWeightHistoy(BigDecimal weightHistoy) {
		this.weightHistoy = weightHistoy;
	}


	@Column(name="weight_loss_asr")
	public String getWeightLossAsr() {
		return this.weightLossAsr;
	}

	public void setWeightLossAsr(String weightLossAsr) {
		this.weightLossAsr = weightLossAsr;
	}


	@Column(name="weight_loss_ctr")
	public String getWeightLossCtr() {
		return this.weightLossCtr;
	}

	public void setWeightLossCtr(String weightLossCtr) {
		this.weightLossCtr = weightLossCtr;
	}

	//bi-directional many-to-one association to PnOrderRegimenInt
	@ManyToOne
	@JoinColumn(name="regimen_int_seqno")
	@JsonBackReference("PnNutritionalAssmntInt")
	public PnOrderRegimenInt getPnOrderRegimenInt() {
		return this.pnOrderRegimenInt;
	}

	public void setPnOrderRegimenInt(PnOrderRegimenInt pnOrderRegimenInt) {
		this.pnOrderRegimenInt = pnOrderRegimenInt;
	}
}