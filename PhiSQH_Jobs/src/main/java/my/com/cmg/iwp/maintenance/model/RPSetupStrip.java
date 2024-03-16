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

import my.com.cmg.iwp.webui.constant.RefCodeConstant;

@Entity
@Table(name = "t_rp_setup_strip")
public class RPSetupStrip implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="T_RP_SETUP_STRIP_SEQNO_GENERATOR", sequenceName="t_rp_setup_strip_seq", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="T_RP_SETUP_STRIP_SEQNO_GENERATOR")
	@Column(name="RP_SETUP_STRIP_SEQNO")
	private Long rpSetupStripSeqno = Long.MIN_VALUE;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rp_setup_brnd_seqno")
	private RPSetupBrands rpSetupBrands;
	
	@Column(name="strip1_yn") 
	private Character strip1YN = 'N';
	
	@Column(name="strip2_yn") 
	private Character strip2YN = 'N';
	
	@Column(name = "portion1", length = 20) 
	private String portion1;
	
	@Column(name = "portion2", length = 20) 
	private String portion2;
	
	@Column(name = "rp_setup_method", length = 20)  
	private String method;
	
	@Column(name = "free_pertech", length = 20)  
	private String freePertech;
	
	@Column(name = "tc_reduce", length = 20) 
	private String tcReduce;
	
	@Column(name = "radio_chemical", length = 20) 
	private String radioChemical;
	
	@Column(name="default_yn") 
	private Character defaultYN = RefCodeConstant.BOOLEAN_FALSE;
	
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
	
	public Long getRpSetupStripSeqno() { return rpSetupStripSeqno; }
	public void setRpSetupStripSeqno(Long rpSetupStripSeqno) { this.rpSetupStripSeqno = rpSetupStripSeqno; }
	
	public RPSetupBrands getRpSetupBrands() { return rpSetupBrands; }
	public void setRpSetupBrands(RPSetupBrands rpSetupBrands) { this.rpSetupBrands = rpSetupBrands; }
	
	public Character getStrip1YN() { return strip1YN; }
	public void setStrip1YN(Character strip1yn) { strip1YN = strip1yn; }
	
	public Character getStrip2YN() { return strip2YN; }
	public void setStrip2YN(Character strip2yn) { strip2YN = strip2yn; }

	public String getPortion1() { return portion1; }
	public void setPortion1(String portion1) { this.portion1 = portion1; }
	
	public String getPortion2() { return portion2; }
	public void setPortion2(String portion2) { this.portion2 = portion2; }
	
	public String getMethod() { return method; }
	public void setMethod(String method) { this.method = method; }
	
	public String getFreePertech() { return freePertech; }
	public void setFreePertech(String freePertech) { this.freePertech = freePertech; }
	
	public String getTcReduce() { return tcReduce; }
	public void setTcReduce(String tcReduce) { this.tcReduce = tcReduce; }
	
	public String getRadioChemical() { return radioChemical; }
	public void setRadioChemical(String radioChemical) { this.radioChemical = radioChemical; }
	
	public Character getDefaultYN() { return defaultYN; }
	public void setDefaultYN(Character defaultYN) { this.defaultYN = defaultYN; }
	
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
