package my.com.cmg.iwp.maintenance.model.report.stg;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import my.com.cmg.iwp.maintenance.model.ExternalFacility;

@Entity
@Table(name = "t_ytd_purchase_by_item_stg")
public class YtdPurchaseByItemStg implements java.io.Serializable {

	private long ytdPbiStgSeqno;
	private String itemCode;
	private String itemDesc;
	private String sessionId;
	private BigDecimal amount;
	private Date purchaseDate;
	private Long createdBy;
	private ExternalFacility externalFacility;

	
	

	public YtdPurchaseByItemStg() {
	}

	public YtdPurchaseByItemStg(long ytdPbiStgSeqno) {
		this.ytdPbiStgSeqno = ytdPbiStgSeqno;
	}

	public YtdPurchaseByItemStg(long ytdPbiStgSeqno, String itemCode,
			String itemDesc, String sessionId, BigDecimal amount,
			Date purchaseDate, Long createdBy) {
		this.ytdPbiStgSeqno = ytdPbiStgSeqno;
		this.itemCode = itemCode;
		this.itemDesc = itemDesc;
		this.sessionId = sessionId;
		this.amount = amount;
		this.purchaseDate = purchaseDate;
		this.createdBy = createdBy;
	}

	@Id
	@Column(name = "ytd_pbi_stg_seqno", unique = true, nullable = false)
	public long getYtdPbiStgSeqno() {
		return this.ytdPbiStgSeqno;
	}

	public void setYtdPbiStgSeqno(long ytdPbiStgSeqno) {
		this.ytdPbiStgSeqno = ytdPbiStgSeqno;
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

	@Column(name = "session_id", length = 50)
	public String getSessionId() {
		return this.sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	@Column(name = "amount", precision = 15, scale = 4)
	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "purchase_date", length = 29)
	public Date getPurchaseDate() {
		return this.purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	@Column(name = "created_by")
	public Long getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "facility_seqno")
	public ExternalFacility getExternalFacility() {
		return externalFacility;
	}

	public void setExternalFacility(ExternalFacility externalFacility) {
		this.externalFacility = externalFacility;
	}
}
