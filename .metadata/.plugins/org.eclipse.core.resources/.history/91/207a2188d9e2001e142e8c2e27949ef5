package my.com.cmg.iwp.maintenance.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "t_rp_element")
public class RpElement implements java.io.Serializable {

	private static final long serialVersionUID = 5451073573592681360L;
	private long elementSeqno = Long.MIN_VALUE;
	private String element;
	private BigDecimal halfLife;
	private String halfLifeUnit;
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
	private Set<RPElementDrugs> rpElementDrugs;

	public RpElement() {
	}

	public RpElement(long elementSeqno, String element, long createdBy,
			Date createdDate, long updatedBy, Date updatedDate) {
		this.elementSeqno = elementSeqno;
		this.element = element;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
	}

	public RpElement(long elementSeqno, String element, BigDecimal halfLife,
			String halfLifeUnit, String parameter1, String parameter2,
			BigDecimal parameter3, BigDecimal parameter4, Date parameter5,
			Character activeFlag, long createdBy, Date createdDate,
			long updatedBy, Date updatedDate) {
		super();
		this.elementSeqno = elementSeqno;
		this.element = element;
		this.halfLife = halfLife;
		this.halfLifeUnit = halfLifeUnit;
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
	@Column(name = "element_seqno", unique = true, nullable = false)
	@SequenceGenerator(name = "elementSEQ", sequenceName = "t_rp_element_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "elementSEQ")
	public long getElementSeqno() {
		return elementSeqno;
	}

	public void setElementSeqno(long elementSeqno) {
		this.elementSeqno = elementSeqno;
	}

	@Column(name = "element", length = 50)
	public String getElement() {
		return element;
	}

	public void setElement(String element) {
		this.element = element;
	}

	@Column(name = "half_life")
	public BigDecimal getHalfLife() {
		return halfLife;
	}

	public void setHalfLife(BigDecimal halfLife) {
		this.halfLife = halfLife;
	}

	@Column(name = "half_life_unit", length = 20)
	public String getHalfLifeUnit() {
		return halfLifeUnit;
	}

	public void setHalfLifeUnit(String halfLifeUnit) {
		this.halfLifeUnit = halfLifeUnit;
	}

	@Column(name = "parameter1", length = 100)
	public String getParameter1() {
		return parameter1;
	}

	public void setParameter1(String parameter1) {
		this.parameter1 = parameter1;
	}

	@Column(name = "parameter2", length = 100)
	public String getParameter2() {
		return parameter2;
	}

	public void setParameter2(String parameter2) {
		this.parameter2 = parameter2;
	}

	@Column(name = "parameter3", length = 100)
	public BigDecimal getParameter3() {
		return parameter3;
	}

	public void setParameter3(BigDecimal parameter3) {
		this.parameter3 = parameter3;
	}

	@Column(name = "parameter4", length = 100)
	public BigDecimal getParameter4() {
		return parameter4;
	}

	public void setParameter4(BigDecimal parameter4) {
		this.parameter4 = parameter4;
	}

	@Column(name = "parameter5")
	public Date getParameter5() {
		return parameter5;
	}

	public void setParameter5(Date parameter5) {
		this.parameter5 = parameter5;
	}

	@Column(name = "active_flag")
	public Character getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(Character activeFlag) {
		this.activeFlag = activeFlag;
	}

	@Column(name = "created_by")
	public long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "created_date")
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "updated_by")
	public long getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(long updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Column(name = "updated_date")
	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "rpElement")
	@Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	public Set<RPElementDrugs> getRpElementDrugs() { return rpElementDrugs; }
	public void setRpElementDrugs(Set<RPElementDrugs> rpElementDrugs) { this.rpElementDrugs = rpElementDrugs; }
}
