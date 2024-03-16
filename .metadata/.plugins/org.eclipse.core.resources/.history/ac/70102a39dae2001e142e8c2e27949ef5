package my.com.cmg.iwp.maintenance.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

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

import org.hibernate.annotations.Cascade;

import my.com.cmg.iwp.webui.constant.RefCodeConstant;

@Entity
@Table(name = "t_rp_setup_brands")
public class RPSetupBrands extends BaseEntity implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="T_RP_SETUP_BRND_SEQNO_GENERATOR", sequenceName="T_RP_SETUP_BRANDS_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="T_RP_SETUP_BRND_SEQNO_GENERATOR")
	@Column(name="rp_setup_brnd_seqno")
	private long rpSetupBrndSeqno = Long.MIN_VALUE;
	
	@Column(name = "incu_period")
	private Integer incuPeriod;
	
	@Column(name = "storage_condition", length = 20)
	private String storageCondition;
	
	@Column(name = "rc_purity")
	private Integer rcPurity;
	
	@Column(name = "min_volume")
	private BigDecimal minVolume;
	
	@Column(name = "max_volume")
	private BigDecimal maxVolume;
	
	@Column(name = "min_activity_qty")
	private BigDecimal minActivityQTY;
	
	@Column(name = "min_activity_str")
	private BigDecimal minActivitySTR;
	
	@Column(name = "max_activity_qty")
	private BigDecimal maxActivityQTY;
	
	@Column(name = "max_activity_str")
	private BigDecimal maxActivitySTR;
	
	@Column(name = "ph_applicable_yn", length = 1)
	private Character phApplicableYN = RefCodeConstant.BOOLEAN_FALSE;
	
	@Column(name = "incu_period_uom", length = 20)
	private String incuPeriodUOM;
	
	@Column(name = "expiry")
	private Integer expiry;
	
	@Column(name = "expiry_uom", length = 20)
	private String expiryUOM;
	
	@Column(name = "min_ph")
	private BigDecimal minPH;
	
	@Column(name = "max_ph")
	private BigDecimal maxPH;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rp_source_seqno")
	private RpSource rpSource;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "item_brd_seqno")
	private ItemBrand itemBrand;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "rpSetupBrands")
	@Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	private Set<RPSetupStrip> rpSetupStrips = new HashSet<RPSetupStrip>(0);
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "rpSetupBrands")
	@Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	private Set<RPSetupSOP> rpSetupSOPs = new HashSet<RPSetupSOP>(0);
	
	public long getRpSetupBrndSeqno() { return rpSetupBrndSeqno; }
	public void setRpSetupBrndSeqno(long rpSetupBrndSeqno) { this.rpSetupBrndSeqno = rpSetupBrndSeqno; }
	
	public RpSource getRpSource() { return rpSource; }
	public void setRpSource(RpSource rpSource) { this.rpSource = rpSource; }
	
	public ItemBrand getItemBrand() { return itemBrand; }
	public void setItemBrand(ItemBrand itemBrand) { this.itemBrand = itemBrand; }
	
	public Set<RPSetupStrip> getRpSetupStrips() { return rpSetupStrips; }
	public void setRpSetupStrips(Set<RPSetupStrip> rpSetupStrips) { this.rpSetupStrips = rpSetupStrips; }
	
	public Set<RPSetupSOP> getRpSetupSOPs() { return rpSetupSOPs; }
	public void setRpSetupSOPs(Set<RPSetupSOP> rpSetupSOPs) { this.rpSetupSOPs = rpSetupSOPs; }
	
	public Integer getIncuPeriod(){return incuPeriod;}
	public void setIncuPeriod(Integer incuPeriod){this.incuPeriod=incuPeriod;}
	
	public String getStorageCondition(){return storageCondition;}
	public void setStorageCondition(String storageCondition){this.storageCondition=storageCondition;}
	
	public Integer getRcPurity(){return rcPurity;}
	public void setRcPurity(Integer rcPurity){this.rcPurity=rcPurity;}
	
	public BigDecimal getMinVolume(){return minVolume;}
	public void setMinVolume(BigDecimal minVolume){this.minVolume=minVolume;}
	
	public BigDecimal getMaxVolume(){return maxVolume;}
	public void setMaxVolume(BigDecimal maxVolume){this.maxVolume=maxVolume;}
	
	public BigDecimal getMinActivityQTY(){return minActivityQTY;}
	public void setMinActivityQTY(BigDecimal minActivityQTY){this.minActivityQTY=minActivityQTY;}
	
	public BigDecimal getMinActivitySTR(){return minActivitySTR;}
	public void setMinActivitySTR(BigDecimal minActivitySTR){this.minActivitySTR=minActivitySTR;}
	
	public BigDecimal getMaxActivityQTY(){return maxActivityQTY;}
	public void setMaxActivityQTY(BigDecimal maxActivityQTY){this.maxActivityQTY=maxActivityQTY;}
	
	public BigDecimal getMaxActivitySTR(){return maxActivitySTR;}
	public void setMaxActivitySTR(BigDecimal maxActivitySTR){this.maxActivitySTR=maxActivitySTR;}
	
	public Character getPhApplicableYN(){return phApplicableYN;}
	public void setPhApplicableYN(Character phApplicableYN){this.phApplicableYN=phApplicableYN;}
	
	public String getIncuPeriodUOM(){return incuPeriodUOM;}
	public void setIncuPeriodUOM(String incuPeriodUOM){this.incuPeriodUOM=incuPeriodUOM;}
	
	public Integer getExpiry(){return expiry;}
	public void setExpiry(Integer expiry){this.expiry=expiry;}
	
	public String getExpiryUOM(){return expiryUOM;}
	public void setExpiryUOM(String expiryUOM){this.expiryUOM=expiryUOM;}
	
	public BigDecimal getMinPH(){return minPH;}
	public void setMinPH(BigDecimal minPH){this.minPH=minPH;}
	
	public BigDecimal getMaxPH(){return maxPH;}
	public void setMaxPH(BigDecimal maxPH){this.maxPH=maxPH;}
}
