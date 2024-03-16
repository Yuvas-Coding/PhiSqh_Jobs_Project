package my.com.cmg.iwp.maintenance.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="T_ITEM_EP_LOG")
public class ItemEPLog implements Serializable {
	private static final long serialVersionUID = 1L;

    public ItemEPLog() {
    }
    
    private Long epLogSeq;
    private String itemCode;
    private String itemDesc;
    private String packaging;
    private Double wUnitPrice;
    private Double eUnitPrice;
    private String pku;
    private String itemGroup;
    private String itemStatus;
    private String status;
    private String tenderRefNo;
    private Date createDate;
    private Character epStatus;
    private long count;

    @Id
    @Column(name="EP_LOG_SEQ", nullable=false)
    public Long getEpLogSeq() {
		return epLogSeq;
	}
	public void setEpLogSeq(Long epLogSeq) {
		this.epLogSeq = epLogSeq;
	}
	@Column(name="item_code")
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	
	@Column(name="item_desc")
	public String getItemDesc() {
		return itemDesc;
	}
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	
	@Column(name="package_description")
	public String getPackaging() {
		return packaging;
	}
	public void setPackaging(String packaging) {
		this.packaging = packaging;
	}
	
	@Column(name="w_unit_price")
	public Double getwUnitPrice() {
		return wUnitPrice;
	}
	public void setwUnitPrice(Double wUnitPrice) {
		this.wUnitPrice = wUnitPrice;
	}
	
	@Column(name="e_unit_price")
	public Double geteUnitPrice() {
		return eUnitPrice;
	}
	public void seteUnitPrice(Double eUnitPrice) {
		this.eUnitPrice = eUnitPrice;
	}
	
	@Column(name="pku_code")
	public String getPku() {
		return pku;
	}
	public void setPku(String pku) {
		this.pku = pku;
	}
	
	@Column(name="item_group")
	public String getItemGroup() {
		return itemGroup;
	}
	public void setItemGroup(String itemGroup) {
		this.itemGroup = itemGroup;
	}
	
	@Column(name="item_status")
	public String getItemStatus() {
		return itemStatus;
	}
	public void setItemStatus(String itemStatus) {
		this.itemStatus = itemStatus;
	}
	
	@Column(name="status")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Column(name="tender_ref_no")
	public String getTenderRefNo() {
		return tenderRefNo;
	}
	public void setTenderRefNo(String tenderRefNo) {
		this.tenderRefNo = tenderRefNo;
	}
	
	@Column(name="create_date")
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	@Column(name="ep_status")
	public Character getEpStatus() {
		return epStatus;
	}
	public void setEpStatus(Character epStatus) {
		this.epStatus = epStatus;
	}
	
	@Transient
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
}