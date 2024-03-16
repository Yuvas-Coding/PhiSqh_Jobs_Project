package my.com.cmg.iwp.maintenance.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "T_CONTRACT_ITEM_QTY")
public class ContractItemQty implements java.io.Serializable {

	private static final long serialVersionUID = -1407223637309824089L;
	
	private Long hqContractItemQtySeqNo;
	private String itemCode;
	private String itemDesc;
	private String brdCode;
	private Long quantity = 0L;
	private Date createDate;
	private Date updateDate;
	private long updateBy;
	private long createBy;
	private ContractHdr hqContractHdr;
	private Item item;
	private Long remainingQty;
	
	public ContractItemQty() {
	}
	
	@Transient
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	
	public ContractItemQty(Long hqContractItemQtySeqNo, String itemCode,
			Long quantity, Date createDate, Date updateDate, long updateBy,
			long createBy, ContractHdr hqContractHdr) {
		this.hqContractItemQtySeqNo = hqContractItemQtySeqNo;
		this.itemCode = itemCode;
		this.quantity = quantity;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.updateBy = updateBy;
		this.createBy = createBy;
		this.hqContractHdr = hqContractHdr;
	}

	@Id
	@Column(name = "contract_item_qty_seqno", unique = true, nullable = false)
	@SequenceGenerator(name="contractItem_seqno", sequenceName="T_CONTRACT_ITEM_QTY_SEQ", allocationSize = 1)
	@GeneratedValue(generator="contractItem_seqno")
	public Long getHqContractItemQtySeqNo() {
		return hqContractItemQtySeqNo;
	}
	
	public void setHqContractItemQtySeqNo(Long hqContractItemQtySeqNo) {
		this.hqContractItemQtySeqNo = hqContractItemQtySeqNo;
	}
	
	@Column(name="item_code",length=20)
	public String getItemCode() {
		return itemCode;
	}
	
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	
	@Column(name = "item_desc", length = 100)
	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	
	@Column(name = "brd_code", nullable = false, length = 10)
	public String getBrdCode() {
		return this.brdCode;
	}

	public void setBrdCode(String brdCode) {
		this.brdCode = brdCode;
	}	
	
	@Column(name="qty")
	public Long getQuantity() {
		return quantity;
	}
	
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", nullable = false, length = 29)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_date", nullable = false, length = 29)
	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Column(name = "updated_by", nullable = false)
	public long getUpdateBy() {
		return this.updateBy;
	}

	public void setUpdateBy(long updateBy) {
		this.updateBy = updateBy;
	}

	@Column(name = "created_by", nullable = false)
	public long getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(long createBy) {
		this.createBy = createBy;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hdr_seqno")
	public ContractHdr getHqContractHdr() {
		return hqContractHdr;
	}
	
	public void setHqContractHdr(ContractHdr hqContractHdr) {
		this.hqContractHdr = hqContractHdr;
	}

	
	public void setRemainingQty(Long remainingqty) {
		this.remainingQty = remainingqty;
	}
	
	@Column(name = "remaining_qty")
	public Long getRemainingQty() {
		return this.remainingQty;
	}

}
