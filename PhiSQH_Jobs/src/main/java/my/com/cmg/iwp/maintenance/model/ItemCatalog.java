package my.com.cmg.iwp.maintenance.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;

@Entity
@Table(name="T_CATALOG_ITEM_LOG")
public class ItemCatalog implements Serializable {
	private static final long serialVersionUID = 1L;
	private BigDecimal catSeqNo;
	private String itemCode;
	private String itemDesc;
	private String packDesc;
	private BigDecimal wUnitPrice;
	private BigDecimal eUnitPrice;
	private String pku;
	private String itemGroup;
	private Integer minOrdQty;
	private String itemStatus;
	private String status;
	private String tenderRfNo;
	private Date createDate;
	private String epStatus;
	public ItemCatalog() {
		
	}
	
	public ItemCatalog(BigDecimal catSeqNo) {
		this.catSeqNo = catSeqNo;
	}
	public ItemCatalog(BigDecimal catSeqNo, String itemCode,
			String itemDesc, String packDesc, BigDecimal wUnitPrice, BigDecimal eUnitPrice, 
			String pku, String itemGroup, Integer minOrdQty, String itemStatus, String status, 
			String tenderRefNo, Date createDate, String epStatus) {
		this.catSeqNo = catSeqNo;
		this.itemCode = itemCode;
		this.itemDesc = itemDesc;
		this.packDesc = packDesc;
		this.wUnitPrice = wUnitPrice;
		this.eUnitPrice  = eUnitPrice;
		this.pku = pku;
		this.itemGroup = itemGroup;
		this.minOrdQty = minOrdQty;
		this.itemStatus = itemStatus;
		this.status = status;
		this.tenderRfNo = tenderRefNo;
		this.createDate = createDate;
		this.epStatus = epStatus;
	}
	
	@Id
	@Column(name="CAT_SEQ_NO", unique = true, nullable = false, length = 15)
	public BigDecimal getCatSeqNo() {
		return catSeqNo;
	}

	public void setCatSeqNo(BigDecimal catSeqNo) {
		this.catSeqNo = catSeqNo;
	}

	@Column(name="ITEM_CODE")
	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	@Column(name="ITEM_DESC")
	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	@Column(name="PACKAGE_DESCRIPTION")
	public String getPackDesc() {
		return packDesc;
	}

	public void setPackDesc(String packDesc) {
		this.packDesc = packDesc;
	}

	@Column(name="W_UNIT_PRICE")
	public BigDecimal getWUnitPrice() {
		return wUnitPrice;
	}

	public void setWUnitPrice(BigDecimal wUnitPrice) {
		this.wUnitPrice = wUnitPrice;
	}

	@Column(name="E_UNIT_PRICE")
	public BigDecimal getEUnitPrice() {
		return eUnitPrice;
	}

	public void setEUnitPrice(BigDecimal eUnitPrice) {
		this.eUnitPrice = eUnitPrice;
	}

	@Column(name="PKU_CODE")
	public String getPku() {
		return pku;
	}

	public void setPku(String pku) {
		this.pku = pku;
	}

	@Column(name="ITEM_GROUP")
	public String getItemGroup() {
		return itemGroup;
	}

	public void setItemGroup(String itemGroup) {
		this.itemGroup = itemGroup;
	}

	@Column(name="MINIMUM_ORDER_QUANTITY")
	public Integer getMinOrdQty() {
		return minOrdQty;
	}

	public void setMinOrdQty(Integer minOrdQty) {
		this.minOrdQty = minOrdQty;
	}

	@Column(name="ITEM_STATUS")
	public String getItemStatus() {
		return itemStatus;
	}

	public void setItemStatus(String itemStatus) {
		this.itemStatus = itemStatus;
	}

	@Column(name="STATUS")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name="TENDER_REF_NO")
	public String getTenderRfNo() {
		return tenderRfNo;
	}

	public void setTenderRfNo(String tenderRfNo) {
		this.tenderRfNo = tenderRfNo;
	}

	@Column(name="CREATE_DATE")
	@Formula(value="trunc(CREATE_DATE)")
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name="EP_STATUS")
	public String getEpStatus() {
		return epStatus;
	}

	public void setEpStatus(String epStatus) {
		this.epStatus = epStatus;
	}	  
}
