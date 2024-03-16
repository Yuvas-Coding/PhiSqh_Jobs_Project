package my.com.cmg.iwp.maintenance.model.report.stg;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="t_po_item_summary_stg")
public class LpoSummaryByItemStg implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long poSummarySeqno;
	private String epoNo;
    @Temporal(TemporalType.DATE)
	private Date epoDate;
	private String purchaseType;
	private String lpoNo;
	private String itemDisc;
	private String itemCode;
	private String pku;
	private Long approvedQty;
	private Long ePApprovedQty;
	private String facilityName;
	private Long createdBy;
	
	public LpoSummaryByItemStg() {
	}
	

	public LpoSummaryByItemStg(Long poSummarySeqno, String epoNo, Date epoDate, String purchaseType, String lpoNo,
			String itemDisc, String itemCode, String pku, Long approvedQty, Long ePApprovedQty, String facilityName,
			Long createdBy) {
		super();
		this.poSummarySeqno = poSummarySeqno;
		this.epoNo = epoNo;
		this.epoDate = epoDate;
		this.purchaseType = purchaseType;
		this.lpoNo = lpoNo;
		this.itemDisc = itemDisc;
		this.itemCode = itemCode;
		this.pku = pku;
		this.approvedQty = approvedQty;
		this.ePApprovedQty = ePApprovedQty;
		this.facilityName = facilityName;
		this.createdBy = createdBy;
	}
	@Id
	@Column(name="po_summary_seqno", unique = true, nullable = false)
	@SequenceGenerator(name = "t_po_item_summary_stg_seq", sequenceName = "t_po_item_summary_stg_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "t_po_item_summary_stg_seq")
	public Long getPoSummarySeqno() {
		return poSummarySeqno;
	}

	public void setPoSummarySeqno(Long poSummarySeqno) {
		this.poSummarySeqno = poSummarySeqno;
	}
	@Column(name="purchase_type")
	public String getPurchaseType() {
		return purchaseType;
	}

	public void setPurchaseType(String purchaseType) {
		this.purchaseType = purchaseType;
	}
	@Column(name="item_name")
	public String getItemDisc() {
		return itemDisc;
	}
	public void setItemDisc(String itemDisc) {
		this.itemDisc = itemDisc;
	}
	@Column(name="item_code")
	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	@Column(name="pku")
	public String getPku() {
		return pku;
	}
	public void setPku(String pku) {
		this.pku = pku;
	}
	@Column(name="approved_qty")
	public Long getApprovedQty() {
		return approvedQty;
	}
	public void setApprovedQty(Long approvedQty) {
		this.approvedQty = approvedQty;
	}

	@Column(name="ep_approved_qty")
	public Long getePApprovedQty() {
		return ePApprovedQty;
	}

	public void setePApprovedQty(Long ePApprovedQty) {
		this.ePApprovedQty = ePApprovedQty;
	}
	@Column(name="facility_name")
	public String getFacilityName() {
		return facilityName;
	}

	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}
	@Column(name="created_by")
	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name="epo_no")
	public String getEpoNo() {
		return epoNo;
	}


	public void setEpoNo(String epoNo) {
		this.epoNo = epoNo;
	}

	@Column(name="epo_date")
	public Date getEpoDate() {
		return epoDate;
	}


	public void setEpoDate(Date epoDate) {
		this.epoDate = epoDate;
	}

	@Column(name="lpo_no")
	public String getLpoNo() {
		return lpoNo;
	}


	public void setLpoNo(String lpoNo) {
		this.lpoNo = lpoNo;
	}
	
	
	
}
