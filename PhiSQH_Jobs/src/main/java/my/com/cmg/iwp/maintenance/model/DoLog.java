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
@Table(name="T_DO_LOG")
public class DoLog implements Serializable {
	private static final long serialVersionUID = 1L;
	private BigDecimal seqNo;
	private String lpoNo;
	private String lampironNo;
	private String skuCode;
	private BigDecimal quantity;
	private String remark;
	private String delAdd;
	private Date createDate;
	private String itemCode;
	private String status;	
	
	public DoLog() {
	}

	public DoLog(BigDecimal seqNo) {
		this.seqNo = seqNo;
	}
	
	public DoLog(BigDecimal seqNo, String lpoNo, String lampironNo,
			String skuCode, BigDecimal quantity, String remark, String delAdd,
			Date createDate, String itemCode, String status) {
		this.seqNo = seqNo;
		this.lpoNo = lpoNo;
		this.lampironNo = lampironNo;
		this.skuCode = skuCode;
		this.quantity = quantity;
		this.remark = remark;
		this.delAdd = delAdd;
		this.createDate = createDate;
		this.itemCode = itemCode;
		this.status = status;
	}
	
	@Id
	@Column(name="SEQ_NO", unique=true, nullable=false)
	public BigDecimal getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(BigDecimal seqNo) {
		this.seqNo = seqNo;
	}

	@Column(name="LPO_NO")
	public String getLpoNo() {
		return lpoNo;
	}

	public void setLpoNo(String lpoNo) {
		this.lpoNo = lpoNo;
	}

	@Column(name="LAMPIRAN_NO")
	public String getLampironNo() {
		return lampironNo;
	}

	public void setLampironNo(String lampironNo) {
		this.lampironNo = lampironNo;
	}

	@Column(name="SKU_CODE")
	public String getSkuCode() {
		return skuCode;
	}

	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}

	@Column(name="QUANTITY")
	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	@Column(name="REMARK")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name="DELADD")
	public String getDelAdd() {
		return delAdd;
	}

	public void setDelAdd(String delAdd) {
		this.delAdd = delAdd;
	}

	@Column(name="CREATE_DATE")
	@Formula(value="trunc(CREATE_DATE)")
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name="ITEM_CODE")
	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	@Column(name="STATUS")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}