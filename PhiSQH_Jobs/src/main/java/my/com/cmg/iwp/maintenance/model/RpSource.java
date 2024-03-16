package my.com.cmg.iwp.maintenance.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import my.com.cmg.iwp.webui.constant.RefCodeConstant;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "t_rp_source")
public class RpSource implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "rpsourceSEQ", sequenceName = "t_rp_source_seq", allocationSize = 1)
	@GeneratedValue(generator = "rpsourceSEQ")
	@Column(name = "rp_source_seqno", unique = true, nullable = false)
	private long rpSourceSeqno = Long.MIN_VALUE;
	
	@Column(name = "rp_item_type", length = 20)
	private String rpItemType;
	
	@Column(name="default_yn") 
	private Character defaultYN = RefCodeConstant.BOOLEAN_FALSE;

	@Column(name = "item_group")
	private String itemGroup;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "item_seqno")
	private Item item;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rp_drug_seqno")
	private Drug rpDrug;

	@Column(name = "PARAMETER1")
	private String parameter1;
	
	@Column(name = "PARAMETER2")
	private String parameter2;
	
	@Column(name = "PARAMETER3")
	private BigDecimal parameter3;
	
	@Column(name = "PARAMETER4")
	private BigDecimal parameter4;
	
	@Column(name = "PARAMETER5")
	private Date parameter5;
	
	@Column(name = "ACTIVE_FLAG")
	private Character activeFlag = 'A';
	
	@Column(name = "CREATED_BY")
	private long createdBy;
	
	@Column(name = "CREATED_DATE")
	private Date createdDate;
	
	@Column(name = "UPDATED_BY")
	private long updatedBy;
	
	@Column(name = "UPDATED_DATE")
	private Date updatedDate;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "rpSource")
	@Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	private Set<RPSetupBrands> rpSetupBrands = new HashSet<RPSetupBrands>(0);

	public RpSource() {
		
	}

	public RpSource(long rpSourceSeqno, String rpItemType) {
		this.rpSourceSeqno = rpSourceSeqno;
		this.rpItemType = rpItemType;
	}

	public long getRpSourceSeqno() { return this.rpSourceSeqno; }
	public void setRpSourceSeqno(long rpSourceSeqno) { this.rpSourceSeqno = rpSourceSeqno; }

	public String getRpItemType() { return this.rpItemType; }
	public void setRpItemType(String rpItemType) { this.rpItemType = rpItemType; }

	public Item getItem() { return item; }
	public void setItem(Item itemSeqno) { this.item = itemSeqno; }
	
	public Character getDefaultYN() { return defaultYN; }
	public void setDefaultYN(Character defaultYN) { this.defaultYN = defaultYN; }

	public String getItemGroup() { return itemGroup; }
	public void setItemGroup(String itemGroup) { this.itemGroup = itemGroup; }

	public Drug getRpDrug() { return rpDrug; }
	public void setRpDrug(Drug rpDrug) { this.rpDrug = rpDrug; }

	public Set<RPSetupBrands> getRpSetupBrands() { return rpSetupBrands; }
	public void setRpSetupBrands(Set<RPSetupBrands> rpSetupBrands) { this.rpSetupBrands = rpSetupBrands; }

	public String getParameter1() {return parameter1;}
	public void setParameter1(String parameter1) {this.parameter1 = parameter1;}

	public String getParameter2() {return parameter2;}
	public void setParameter2(String parameter2) {this.parameter2 = parameter2;}

	public BigDecimal getParameter3() {return parameter3;}
	public void setParameter3(BigDecimal parameter3) {this.parameter3 = parameter3;}

	public BigDecimal getParameter4() {return parameter4;}
	public void setParameter4(BigDecimal parameter4) {this.parameter4 = parameter4;}

	public Date getParameter5() {return parameter5;}
	public void setParameter5(Date parameter5) {this.parameter5 = parameter5;}

	public Character getActiveFlag() {return activeFlag;}
	public void setActiveFlag(Character activeFlag) {this.activeFlag = activeFlag;}

	public long getCreatedBy() {return createdBy;}
	public void setCreatedBy(long createdBy) {this.createdBy = createdBy;}

	public Date getCreatedDate() {return createdDate;}
	public void setCreatedDate(Date createdDate) {this.createdDate = createdDate;}

	public long getUpdatedBy() {return updatedBy;}
	public void setUpdatedBy(long updatedBy) {this.updatedBy = updatedBy;}

	public Date getUpdatedDate() {return updatedDate;}
	public void setUpdatedDate(Date updatedDate) {this.updatedDate = updatedDate;}


	
}


