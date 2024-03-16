package my.com.cmg.iwp.maintenance.model;

// Generated 19 Mar, 2012 1:13:49 PM by Hibernate Tools 3.4.0.CR1

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
import javax.persistence.UniqueConstraint;

/**
 * Regimen generated by hbm2java
 */
@Entity
@Table(name = "t_regimens", uniqueConstraints = @UniqueConstraint(columnNames = "rgm_code"))
public class Regimen implements java.io.Serializable , Comparable<Regimen> {
	private static final long serialVersionUID = -1338283135078800949L;
	private long rgmSeqno;
	private String rgmCode;
	private String rgmDesc;
	private Integer cycleDuration;
	private Integer noOfCycle;
	private RegimenCategory regimenCategory;
	private String remarks;
	private String parameter1;
	private String parameter2;
	private BigDecimal parameter3;
	private BigDecimal parameter4;
	private Date parameter5;
	private Character activeFlag = 'A';
	private Date createdDate;
	private Long createdBy;
	private Date updatedDate;
	private Long updatedBy;
	private Set<RegimenDrug> regimenDrugs = new HashSet<RegimenDrug>(0);

	public Regimen() {
	}

	public Regimen(long rgmSeqno, String rgmCode, String rgmDesc,
			Long createdBy, Date createdDate, Long updatedBy, Date updatedDate) {
		this.rgmSeqno = rgmSeqno;
		this.rgmCode = rgmCode;
		this.rgmDesc = rgmDesc;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
	}

	public Regimen(long rgmSeqno, String rgmCode, String rgmDesc,
			Integer cycleDuration, RegimenCategory regimenCategory,
			Integer nocycle, Long createdBy, Date createdDate, Long updatedBy,
			Date updatedDate) {
		super();
		this.rgmSeqno = rgmSeqno;
		this.rgmCode = rgmCode;
		this.rgmDesc = rgmDesc;
		this.cycleDuration = cycleDuration;
		this.regimenCategory = regimenCategory;
		this.noOfCycle = nocycle;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
	}

	@Id
	@Column(name = "rgm_seqno", unique = true, nullable = false)
	@SequenceGenerator(name = "rgm_seqno", sequenceName = "t_regimens_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rgm_seqno")
	public long getRgmSeqno() {
		return this.rgmSeqno;
	}

	public void setRgmSeqno(long rgmSeqno) {
		this.rgmSeqno = rgmSeqno;
	}

	@Column(name = "rgm_code", unique = true, nullable = false, length = 10)
	public String getRgmCode() {
		return this.rgmCode;
	}

	public void setRgmCode(String rgmCode) {
		this.rgmCode = rgmCode;
	}

	@Column(name = "rgm_desc", nullable = false, length = 30)
	public String getRgmDesc() {
		return this.rgmDesc;
	}

	public void setRgmDesc(String rgmDesc) {
		this.rgmDesc = rgmDesc;
	}

	@Column(name = "cycle_duration", nullable = true, length = 20)
	public Integer getCycleDuration() {
		return cycleDuration;
	}

	public void setCycleDuration(Integer cycleDuration) {
		this.cycleDuration = cycleDuration;
	}

	@Column(name = "no_of_cycle")
	public Integer getNoOfcycle() {
		return noOfCycle;
	}

	public void setNoOfcycle(Integer nocycle) {
		noOfCycle = nocycle;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rgm_category_seqno")
	public RegimenCategory getRegimenCategory() {
		return regimenCategory;
	}

	public void setRegimenCategory(RegimenCategory regimenCategory) {
		this.regimenCategory = regimenCategory;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getParameter1() {
		return parameter1;
	}

	public void setParameter1(String parameter1) {
		this.parameter1 = parameter1;
	}

	public String getParameter2() {
		return parameter2;
	}

	public void setParameter2(String parameter2) {
		this.parameter2 = parameter2;
	}

	public BigDecimal getParameter3() {
		return parameter3;
	}

	public void setParameter3(BigDecimal parameter3) {
		this.parameter3 = parameter3;
	}

	public BigDecimal getParameter4() {
		return parameter4;
	}

	public void setParameter4(BigDecimal parameter4) {
		this.parameter4 = parameter4;
	}

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

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", nullable = false, length = 29)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "created_by", nullable = false)
	public Long getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_date", length = 29)
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Column(name = "updated_by")
	public Long getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	@OneToMany(mappedBy = "regimen", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public Set<RegimenDrug> getRegimenDrugs() {
		return regimenDrugs;
	}

	public void setRegimenDrugs(Set<RegimenDrug> regimenDrugs) {
		this.regimenDrugs = regimenDrugs;
	}
	
	@Override
	public int compareTo(Regimen o) {
		return 0;
	}

}
