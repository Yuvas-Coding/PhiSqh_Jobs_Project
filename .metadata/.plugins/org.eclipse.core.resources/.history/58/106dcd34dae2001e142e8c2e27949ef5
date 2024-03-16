package my.com.cmg.iwp.maintenance.model.report.stg;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "t_drug_non_drug_stg")
public class ItemGroupStg implements java.io.Serializable {

	private String drugCode;
	private String drugName;
	private String itemCode;
	private String itemDesc;
	private String itemType;
	private String subClass;
	private String drugCat;
	private String sku;
	private String pku;
	private String packagingDesc;
	private String drugStatus;
	private String itemStatus;
	private Date createdDate;
	private Date updatedDate;
	private Long sessionId;
	private long drugNondrugSeqno;

	public ItemGroupStg() {
	}
	
	public ItemGroupStg(long drugNondrugSeqno) {
		this.drugNondrugSeqno = drugNondrugSeqno;
	}
	
	public ItemGroupStg(String drugCode, String drugName, String itemCode, String itemDesc, String itemType, 
			String subClass, String drugCat, String sku, String pku, String packagingDesc, String drugStatus, 
			String itemStatus, Date createdDate, Date updatedDate, long sessionId, long drugNondrugSeqno) {
		this.drugCode = drugCode;
		this.drugName = drugName;
		this.itemCode = itemCode;
		this.itemDesc = itemDesc;
		this.itemType = itemType;
		this.subClass = subClass;
		this.drugCat = drugCat;
		this.sku = sku;
		this.pku = pku;
		this.packagingDesc = packagingDesc;
		this.drugStatus = drugStatus;
		this.itemStatus = itemStatus;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.sessionId = sessionId;
		this.drugNondrugSeqno = drugNondrugSeqno;
	}

	@Column(name = "drug_code", length = 20)
	public String getDrugCode() {
		return this.drugCode;
	}

	public void setDrugCode(String drugCode) {
		this.drugCode = drugCode;
	}

	@Column(name = "drug_name", length = 100)
	public String getDrugName() {
		return this.drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	@Column(name = "item_code", length = 20)
	public String getItemCode() {
		return this.itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	@Column(name = "item_desc", length = 100)
	public String getItemDesc() {
		return this.itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	@Column(name = "item_type", length = 5)
	public String getItemType() {
		return this.itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	@Column(name = "subgroup_desc", length = 30)
	public String getSubClass() {
		return this.subClass;
	}

	public void setSubClass(String subClass) {
		this.subClass = subClass;
	}

	@Column(name = "drug_cat", length = 10)
	public String getDrugCat() {
		return this.drugCat;
	}

	public void setDrugCat(String drugCat) {
		this.drugCat = drugCat;
	}

	@Column(name = "sku", length = 15)
	public String getSku() {
		return this.sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	@Column(name = "pku", length = 15)
	public String getPku() {
		return this.pku;
	}

	public void setPku(String pku) {
		this.pku = pku;
	}

	@Column(name = "item_packaging", length = 100)
	public String getPackagingDesc() {
		return this.packagingDesc;
	}

	public void setPackagingDesc(String packagingDesc) {
		this.packagingDesc = packagingDesc;
	}

	@Column(name = "drug_status", length = 10)
	public String getDrugStatus() {
		return this.drugStatus;
	}

	public void setDrugStatus(String drugStatus) {
		this.drugStatus = drugStatus;
	}

	@Column(name = "item_status", length = 10)
	public String getItemStatus() {
		return this.itemStatus;
	}

	public void setItemStatus(String itemStatus) {
		this.itemStatus = itemStatus;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", length = 13)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_date", length = 13)
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Column(name = "session_id", length = 50)
	public Long getSessionId() {
		return this.sessionId;
	}
	
	public void setSessionId(Long sessionId) {
		this.sessionId = sessionId;
	}

	@Id
	@Column(name = "drug_nondrug_seqno", unique = true, nullable = false)
	public Long getDrugNondrugSeqno() {
		return this.drugNondrugSeqno;
	}
	
	public void setDrugNondrugSeqno(Long drugNondrugSeqno) {
		this.drugNondrugSeqno = drugNondrugSeqno;
	}

}
