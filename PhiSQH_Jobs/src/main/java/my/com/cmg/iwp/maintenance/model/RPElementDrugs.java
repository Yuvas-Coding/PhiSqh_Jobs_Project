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

@Entity
@Table(name = "t_rp_element_drugs")
public class RPElementDrugs implements java.io.Serializable {
	
	private static final long serialVersionUID = 5451073573592681360L;
	private long elementDrugSeqno = Long.MIN_VALUE;
	private RpElement rpElement;
	private Drug drug;
	private String parameter1;
	private String parameter2;
	private BigDecimal parameter3;
	private BigDecimal parameter4;
	private Date parameter5;
	private Character activeFlag = 'A';
	private long createdBy;
	private Date createdDate;
	private long updatedBy;
	private Date updatedDate;

	public RPElementDrugs() {
		
	}
	
	@Id
	@Column(name = "element_drug_seqno", unique = true, nullable = false)
	@SequenceGenerator(name = "elementDrugSEQ", sequenceName = "T_RP_ELEMENT_DRUGS_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "elementDrugSEQ")
	public long getElementDrugSeqno() { return elementDrugSeqno; }
	public void setElementDrugSeqno(long elementDrugSeqno) { this.elementDrugSeqno = elementDrugSeqno; }
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "element_seqno", nullable = false)
	public RpElement getRpElement() { return rpElement; }
	public void setRpElement(RpElement rpElement) { this.rpElement = rpElement; }	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "drug_seqno", nullable = false)
	public Drug getDrug() { return drug; }
	public void setDrug(Drug drug) { this.drug = drug; }
	
	@Column(name = "parameter1", length = 100)
	public String getParameter1() { return parameter1; }
	public void setParameter1(String parameter1) { this.parameter1 = parameter1; }

	@Column(name = "parameter2", length = 100)
	public String getParameter2() { return parameter2; }
	public void setParameter2(String parameter2) { this.parameter2 = parameter2; }

	@Column(name = "parameter3", length = 100)
	public BigDecimal getParameter3() { return parameter3; }
	public void setParameter3(BigDecimal parameter3) { this.parameter3 = parameter3; }

	@Column(name = "parameter4", length = 100)
	public BigDecimal getParameter4() { return parameter4; }
	public void setParameter4(BigDecimal parameter4) { this.parameter4 = parameter4; }

	@Column(name = "parameter5")
	public Date getParameter5() { return parameter5; }
	public void setParameter5(Date parameter5) { this.parameter5 = parameter5; }

	@Column(name = "active_flag")
	public Character getActiveFlag() { return activeFlag; }
	public void setActiveFlag(Character activeFlag) { this.activeFlag = activeFlag; }

	@Column(name = "created_by")
	public long getCreatedBy() { return createdBy; }
	public void setCreatedBy(long createdBy) { this.createdBy = createdBy; }

	@Column(name = "created_date")
	public Date getCreatedDate() { return createdDate; }
	public void setCreatedDate(Date createdDate) { this.createdDate = createdDate; }

	@Column(name = "updated_by")
	public long getUpdatedBy() { return updatedBy; }
	public void setUpdatedBy(long updatedBy) { this.updatedBy = updatedBy; }

	@Column(name = "updated_date")
	public Date getUpdatedDate() { return updatedDate; }
	public void setUpdatedDate(Date updatedDate) { this.updatedDate = updatedDate; }
}
