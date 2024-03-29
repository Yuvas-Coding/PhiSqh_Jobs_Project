// default package
// Generated Jul 16, 2012 2:26:41 PM by Hibernate Tools 3.4.0.CR1
package my.com.cmg.iwp.maintenance.model;
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


/**
 * PhFormulationMaterials generated by hbm2java
 */
@Entity
@Table(name = "t_formulation_materials")
public class FormulationMaterial implements java.io.Serializable, Comparable<FormulationMaterial> {

	private long formulaMatSeqno;
	private FormulationHeader formulationHeader;
	private Integer seqNo;
	private Item materialItem;
	private String typeOfMaterials;
	private BigDecimal qty;
	private Uom qtyUom;
	private String descSuffix;
	private String remarks;
	private String parameter1;
	private String parameter2;
	private BigDecimal parameter3;
	private BigDecimal parameter4;
	private Date parameter5;

	private Character activeFlag = 'A';
	private Long createdBy;
	private Date createdDate;
	private Long updatedBy;
	private Date updatedDate;

	public FormulationMaterial() {
	}

	public FormulationMaterial(long formulaMatSeqno,
			FormulationHeader phFormulationHeader, Long createdBy,
			Date createdDate, Long updatedBy, Date updatedDate) {
		this.formulaMatSeqno = formulaMatSeqno;
		this.formulationHeader = phFormulationHeader;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
	}

	public FormulationMaterial(long formulaMatSeqno,
			FormulationHeader phFormulationHeader, 
			Integer seqNo, 
			String typeOfMaterials, BigDecimal qty, Uom qtyUom,
			String remarks, String parameter1, String parameter2,
			BigDecimal parameter3, BigDecimal parameter4, Date parameter5,
			Character activeFlag, Long createdBy, Date createdDate,
			Long updatedBy, Date updatedDate) {
		this.formulaMatSeqno = formulaMatSeqno;
		this.formulationHeader = phFormulationHeader;
		this.seqNo = seqNo;
		this.typeOfMaterials = typeOfMaterials;
		this.qty = qty;
		this.qtyUom = qtyUom;
		this.remarks = remarks;
		this.parameter1 = parameter1;
		this.parameter2 = parameter2;
		this.parameter3 = parameter3;
		this.parameter4 = parameter4;
		this.parameter5 = parameter5;
		this.activeFlag = activeFlag;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
	}

	@Id
	@Column(name = "formula_mat_seqno", unique = true, nullable = false)
	@SequenceGenerator(name = "formulationMaterialSeqGen", sequenceName = "t_formulation_materials_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "formulationMaterialSeqGen")
	public long getFormulaMatSeqno() {
		return this.formulaMatSeqno;
	}

	public void setFormulaMatSeqno(long formulaMatSeqno) {
		this.formulaMatSeqno = formulaMatSeqno;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "formula_seqno", nullable = false)
	public FormulationHeader getFormulationHeader() {
		return formulationHeader;
	}

	public void setFormulationHeader(FormulationHeader formulationHeader) {
		this.formulationHeader = formulationHeader;
	}
	
	@Column(name = "seq_no")
	public Integer getSeqNo() {
		return this.seqNo;
	}

	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
	}
	
	@ManyToOne
	@JoinColumn(name="material_item")
	public Item getMaterialItem() {
		return materialItem;
	}

	public void setMaterialItem(Item materialItem) {
		this.materialItem = materialItem;
	}

	@Column(name = "type_of_materials", length = 1)
	public String getTypeOfMaterials() {
		return this.typeOfMaterials;
	}

	public void setTypeOfMaterials(String typeOfMaterials) {
		this.typeOfMaterials = typeOfMaterials;
	}
	
	@Column(name = "qty", precision = 9)
	public BigDecimal getQty() {
		return this.qty;
	}

	public void setQty(BigDecimal qty) {
		this.qty = qty;
	}
	
	@ManyToOne
	@JoinColumn(name = "uom")
	public Uom getQtyUom() {
		return this.qtyUom;
	}

	public void setQtyUom(Uom qtyUom) {
		this.qtyUom = qtyUom;
	}
	
	@Column(name="desc_suffix")
	public String getDescSuffix() {
		return descSuffix;
	}

	public void setDescSuffix(String descSuffix) {
		this.descSuffix = descSuffix;
	}
	
	@Column(name = "remarks", length = 50)
	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	@Column(name = "parameter1", length = 100)
	public String getParameter1() {
		return this.parameter1;
	}

	public void setParameter1(String parameter1) {
		this.parameter1 = parameter1;
	}

	@Column(name = "parameter2", length = 100)
	public String getParameter2() {
		return this.parameter2;
	}

	public void setParameter2(String parameter2) {
		this.parameter2 = parameter2;
	}

	@Column(name = "parameter3", precision = 8, scale = 4)
	public BigDecimal getParameter3() {
		return this.parameter3;
	}

	public void setParameter3(BigDecimal parameter3) {
		this.parameter3 = parameter3;
	}

	@Column(name = "parameter4", precision = 8, scale = 4)
	public BigDecimal getParameter4() {
		return this.parameter4;
	}

	public void setParameter4(BigDecimal parameter4) {
		this.parameter4 = parameter4;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "parameter5", length = 13)
	public Date getParameter5() {
		return this.parameter5;
	}

	public void setParameter5(Date parameter5) {
		this.parameter5 = parameter5;
	}

	@Column(name = "active_flag")
	public Character getActiveFlag() {
		return this.activeFlag;
	}

	public void setActiveFlag(Character activeFlag) {
		this.activeFlag = activeFlag;
	}

	@Column(name = "created_by", nullable = false)
	public Long getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", nullable = false, length = 29)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "updated_by", nullable = false)
	public Long getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_date", nullable = false, length = 29)
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public int compareTo(FormulationMaterial formulationMaterial) {
		if(formulationMaterial==null || this==null){
			return -1;
		}
		return this.getSeqNo().compareTo(formulationMaterial.getSeqNo());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
	        return true;
	    if (obj == null)
	        return false;
	    if (!(obj instanceof FormulationSop))
	        return false;
	    FormulationMaterial other = (FormulationMaterial) obj;
	    if (getFormulaMatSeqno() == 0) {
	        if (other.getFormulaMatSeqno() != 0)
	            return false;
	    } else if (!(getFormulaMatSeqno()+"").equals(other.getFormulaMatSeqno()+""))
	        return false;
	    return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
	    int result = 1;
	    result = prime * result + ((getFormulaMatSeqno() == 0) ? 0 : Integer.valueOf(""+getFormulaMatSeqno()));
	    return result;
	}
}
