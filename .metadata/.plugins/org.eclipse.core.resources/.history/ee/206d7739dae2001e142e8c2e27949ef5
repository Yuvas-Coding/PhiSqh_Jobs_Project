package my.com.cmg.iwp.maintenance.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_ORDERLINE_STATUS")
public class OrderLineStatus implements Serializable {
	private static final long serialVersionUID = 1L;
	private BigDecimal ordLineSeq;
	private String facilityCode;
	private String ptjCode;
	private String purchaseOrderNo;
	private String lpoNo;
	private String shipToCode;
	private String itemCode;
	private String lineNo;
	private Integer quantity;
	private String status;
	private Date createDate;
	private String createBy;
	private Date lastUpdDate;
	private String lastUpdBy;
	private Date lpoDate;
	private String pku;
	
	public OrderLineStatus() {

	}

	public OrderLineStatus(BigDecimal ordLineSeq) {
		this.ordLineSeq = ordLineSeq;
	}

	public OrderLineStatus(BigDecimal ordLineSeq, String ptjCode,
			String purchaseOrderNo, String facilityCode, String lpoNo, String shipToCode,
			String itemCode, String lineNo, Integer quantity, String status,
			Date createDate, String createBy, Date lastUpdDate, String lastUpdBy) {
		this.ordLineSeq = ordLineSeq;
		this.ptjCode = ptjCode;
		this.purchaseOrderNo = purchaseOrderNo;
		this.facilityCode = facilityCode;
		this.lpoNo = lpoNo;
		this.shipToCode = shipToCode;
		this.itemCode = itemCode;
		this.lineNo = lineNo;
		this.quantity = quantity;
		this.status = status;
		this.createDate = createDate;
		this.createBy = createBy;
		this.lastUpdDate = lastUpdDate;
		this.lastUpdBy = lastUpdBy;
	}

	@Id
	@Column(name="ORD_LINE_SEQ", nullable=false)
	public BigDecimal getOrdLineSeq() {
		return ordLineSeq;
	}

	public void setOrdLineSeq(BigDecimal ordLineSeq) {
		this.ordLineSeq = ordLineSeq;
	}
	
	@Column(name="LPO_NO")
	public String getLpoNo() {
		return lpoNo;
	}

	public void setLpoNo(String lpoNo) {
		this.lpoNo = lpoNo;
	}

	@Column(name="SHIP_TO_CODE", nullable=false)
	public String getShipToCode() {
		return shipToCode;
	}

	public void setShipToCode(String shipToCode) {
		this.shipToCode = shipToCode;
	}

	@Column(name="ITEM_CODE", nullable=false)
	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	@Column(name="LINE_NO", nullable=false)
	public String getLineNo() {
		return lineNo;
	}

	public void setLineNo(String lineNo) {
		this.lineNo = lineNo;
	}

	@Column(name="QUANTITY")
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Column(name="STATUS", nullable=false)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name="CREATE_DATE")
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name="CREATE_BY")
	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	@Column(name="LAST_UPD_DATE")
	public Date getLastUpdDate() {
		return lastUpdDate;
	}

	public void setLastUpdDate(Date lastUpdDate) {
		this.lastUpdDate = lastUpdDate;
	}

	@Column(name="LAST_UPD_BY")
	public String getLastUpdBy() {
		return lastUpdBy;
	}

	public void setLastUpdBy(String lastUpdBy) {
		this.lastUpdBy = lastUpdBy;
	}	

	@Column(name="FACILITY_CODE", nullable=false)
	public String getFacilityCode() {
		return facilityCode;
	}

	public void setFacilityCode(String facilityCode) {
		this.facilityCode = facilityCode;
	}

	@Column(name="PTJ_CODE", nullable=false)
	public String getPtjCode() {
		return ptjCode;
	}

	public void setPtjCode(String ptjCode) {
		this.ptjCode = ptjCode;
	}

	@Column(name="PURCHASE_ORDER_NO", nullable=false)
	public String getPurchaseOrderNo() {
		return purchaseOrderNo;
	}

	public void setPurchaseOrderNo(String purchaseOrderNo) {
		this.purchaseOrderNo = purchaseOrderNo;
	}

	@Column(name="LPO_DATE")
	public Date getLpoDate() {
		return lpoDate;
	}

	public void setLpoDate(Date lpoDate) {
		this.lpoDate = lpoDate;
	}
	
	@Column(name="PKU")
	public String getPku() {
		return pku;
	}

	public void setPku(String pku) {
		this.pku = pku;
	}
}