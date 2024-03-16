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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import my.com.cmg.iwp.backend.model.integration.OutsourceOrderInt;


/**
 * The persistent class for the ph_pn_prep_cal_header_int database table.
 * 
 */
@Entity
@Table(name="t_pn_prep_cal_header_int")
@JsonIgnoreProperties(ignoreUnknown=true)
public class PnPrepCalHeaderInt implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long prepareCalHeaderIntSeqno;
	private BigDecimal acetatePerday;
	private BigDecimal asidAminoPerday;
	private BigDecimal calciumPerday;
	private Long createdBy;
	private Date createdDate;
	private BigDecimal energyReq;
	private BigDecimal fatSolPerday;
	private BigDecimal glucosePerday;
	private BigDecimal lipidOverageVol;
	private BigDecimal lipidPerday;
	private BigDecimal lipidVolReq;
	private BigDecimal magPerday;
	private Long outsourceIntSeqno;
	private BigDecimal overageVol;
	private String parameter1;
	private String parameter2;
	private BigDecimal parameter3;
	private BigDecimal parameter4;
	private Date parameter5;
	private BigDecimal phosPerday;
	private BigDecimal potassiumPerday;
	private String productCat;
	private BigDecimal sodiumPerday;
	private BigDecimal totalVolReq;
	private BigDecimal traceElementPerday;
	private Long updatedBy;
	private Date updatedDate;
	private BigDecimal vitaminSolPerday;
	private BigDecimal volWithoutLipid;
	private BigDecimal waterSolublePerday;
	private BigDecimal glutaminPerday;
	private OutsourceOrderInt outsourceOrderInt;

	private Set<PnPrepCalInt> pnPrepCalInts = new HashSet<PnPrepCalInt>();

	public PnPrepCalHeaderInt() {
	}


	@Id
	@SequenceGenerator(name="PH_PN_PREP_CAL_HEADER_INT_PREPARECALHEADERINTSEQNO_GENERATOR", sequenceName="t_pn_prep_cal_header_int_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PH_PN_PREP_CAL_HEADER_INT_PREPARECALHEADERINTSEQNO_GENERATOR")
	@Column(name="prepare_cal_header_int_seqno")
	@JsonIgnore
	public Long getPrepareCalHeaderIntSeqno() {
		return this.prepareCalHeaderIntSeqno;
	}

	public void setPrepareCalHeaderIntSeqno(Long prepareCalHeaderIntSeqno) {
		this.prepareCalHeaderIntSeqno = prepareCalHeaderIntSeqno;
	}


	@Column(name="acetate_perday")
	public BigDecimal getAcetatePerday() {
		return this.acetatePerday;
	}

	public void setAcetatePerday(BigDecimal acetatePerday) {
		this.acetatePerday = acetatePerday;
	}


	@Column(name="asid_amino_perday")
	public BigDecimal getAsidAminoPerday() {
		return this.asidAminoPerday;
	}

	public void setAsidAminoPerday(BigDecimal asidAminoPerday) {
		this.asidAminoPerday = asidAminoPerday;
	}


	@Column(name="calcium_perday")
	public BigDecimal getCalciumPerday() {
		return this.calciumPerday;
	}

	public void setCalciumPerday(BigDecimal calciumPerday) {
		this.calciumPerday = calciumPerday;
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


	@Column(name="energy_req")
	public BigDecimal getEnergyReq() {
		return this.energyReq;
	}

	public void setEnergyReq(BigDecimal energyReq) {
		this.energyReq = energyReq;
	}


	@Column(name="fat_sol_perday")
	public BigDecimal getFatSolPerday() {
		return this.fatSolPerday;
	}

	public void setFatSolPerday(BigDecimal fatSolPerday) {
		this.fatSolPerday = fatSolPerday;
	}


	@Column(name="glucose_perday")
	public BigDecimal getGlucosePerday() {
		return this.glucosePerday;
	}

	public void setGlucosePerday(BigDecimal glucosePerday) {
		this.glucosePerday = glucosePerday;
	}


	@Column(name="lipid_overage_vol")
	public BigDecimal getLipidOverageVol() {
		return this.lipidOverageVol;
	}

	public void setLipidOverageVol(BigDecimal lipidOverageVol) {
		this.lipidOverageVol = lipidOverageVol;
	}


	@Column(name="lipid_perday")
	public BigDecimal getLipidPerday() {
		return this.lipidPerday;
	}

	public void setLipidPerday(BigDecimal lipidPerday) {
		this.lipidPerday = lipidPerday;
	}


	@Column(name="lipid_vol_req")
	public BigDecimal getLipidVolReq() {
		return this.lipidVolReq;
	}

	public void setLipidVolReq(BigDecimal lipidVolReq) {
		this.lipidVolReq = lipidVolReq;
	}


	@Column(name="mag_perday")
	public BigDecimal getMagPerday() {
		return this.magPerday;
	}

	public void setMagPerday(BigDecimal magPerday) {
		this.magPerday = magPerday;
	}


	@Column(name="outsource_int_seqno", insertable=false, updatable=false)
	public Long getOutsourceIntSeqno() {
		return this.outsourceIntSeqno;
	}

	public void setOutsourceIntSeqno(Long outsourceIntSeqno) {
		this.outsourceIntSeqno = outsourceIntSeqno;
	}


	@Column(name="overage_vol")
	public BigDecimal getOverageVol() {
		return this.overageVol;
	}

	public void setOverageVol(BigDecimal overageVol) {
		this.overageVol = overageVol;
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


	@Column(name="phos_perday")
	public BigDecimal getPhosPerday() {
		return this.phosPerday;
	}

	public void setPhosPerday(BigDecimal phosPerday) {
		this.phosPerday = phosPerday;
	}


	@Column(name="potassium_perday")
	public BigDecimal getPotassiumPerday() {
		return this.potassiumPerday;
	}

	public void setPotassiumPerday(BigDecimal potassiumPerday) {
		this.potassiumPerday = potassiumPerday;
	}


	@Column(name="product_cat")
	public String getProductCat() {
		return this.productCat;
	}

	public void setProductCat(String productCat) {
		this.productCat = productCat;
	}


	@Column(name="sodium_perday")
	public BigDecimal getSodiumPerday() {
		return this.sodiumPerday;
	}

	public void setSodiumPerday(BigDecimal sodiumPerday) {
		this.sodiumPerday = sodiumPerday;
	}


	@Column(name="total_vol_req")
	public BigDecimal getTotalVolReq() {
		return this.totalVolReq;
	}

	public void setTotalVolReq(BigDecimal totalVolReq) {
		this.totalVolReq = totalVolReq;
	}


	@Column(name="trace_element_perday")
	public BigDecimal getTraceElementPerday() {
		return this.traceElementPerday;
	}

	public void setTraceElementPerday(BigDecimal traceElementPerday) {
		this.traceElementPerday = traceElementPerday;
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


	@Column(name="vitamin_sol_perday")
	public BigDecimal getVitaminSolPerday() {
		return this.vitaminSolPerday;
	}

	public void setVitaminSolPerday(BigDecimal vitaminSolPerday) {
		this.vitaminSolPerday = vitaminSolPerday;
	}


	@Column(name="vol_without_lipid")
	public BigDecimal getVolWithoutLipid() {
		return this.volWithoutLipid;
	}

	public void setVolWithoutLipid(BigDecimal volWithoutLipid) {
		this.volWithoutLipid = volWithoutLipid;
	}


	@Column(name="water_soluble_perday")
	public BigDecimal getWaterSolublePerday() {
		return this.waterSolublePerday;
	}

	public void setWaterSolublePerday(BigDecimal waterSolublePerday) {
		this.waterSolublePerday = waterSolublePerday;
	}

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="outsource_int_seqno", referencedColumnName="outsource_int_seqno")
	@JsonBackReference("PnPrepCalHeaderInt")
	public OutsourceOrderInt getOutsourceOrderInt() {
		return this.outsourceOrderInt;
	}


	public void setOutsourceOrderInt(OutsourceOrderInt outsourceOrderInt) {
		this.outsourceOrderInt = outsourceOrderInt;
	}

	@OneToMany(mappedBy="pnPrepCalHeaderInt",  cascade=CascadeType.ALL)
	@JsonManagedReference("PnPrepCalInt")
	public Set<PnPrepCalInt> getPnPrepCalInts() {
		return this.pnPrepCalInts;
	}


	public void setPnPrepCalInts(Set<PnPrepCalInt> pnPrepCalInts) {
		this.pnPrepCalInts = pnPrepCalInts;
	}
	
	@Column(name="glutamin_perday")
	public BigDecimal getGlutaminPerday() {
		
		return this.glutaminPerday;
	}

	public void setGlutaminPerday(BigDecimal glutaminPerday) {
		
		this.glutaminPerday = glutaminPerday;
	}
}