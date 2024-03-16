package my.com.cmg.iwp.maintenance.model.adjustment;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import my.com.cmg.iwp.maintenance.model.GetterBaseEntity;

@Entity
@Table(name = "t_budget_adj_dtl")
public class BudgetAdjDtl extends GetterBaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long budgetAdjDtlSeqno;
	private Long budgetAdjSeqno;
	private String itemCode;
	private String itemDesc;
	private String packaging;
	private String pku;
	private Double unitPrice;
	private Long epApprovedQty;
	private Long receivedQty;
	private Double amount;
	private String ptjCode;
	private String facilityCodeFrom;
	private String facilityCodeTo;
	private Character refFlag;
	private BudgetAdjHdr budgetAdjHdr;
	
	@Id
	@Column(name = "budget_adj_dtl_seqno", unique = true, nullable = false)
	@SequenceGenerator(name = "t_budget_adj_dtl_seq", sequenceName = "t_budget_adj_dtl_seq", allocationSize = 1)
	@GeneratedValue(generator = "t_budget_adj_dtl_seq")
	
	public Long getBudgetAdjDtlSeqno() {
		return budgetAdjDtlSeqno;
	}

	public void setBudgetAdjDtlSeqno(Long budgetAdjDtlSeqno) {
		this.budgetAdjDtlSeqno = budgetAdjDtlSeqno;
	}
	
	@Column(name = "BUDGET_ADJ_SEQNO", insertable=false, updatable=false)
	public Long getBudgetAdjSeqno() {
		return budgetAdjSeqno;
	}

	public void setBudgetAdjSeqno(Long budgetAdjSeqno) {
		this.budgetAdjSeqno = budgetAdjSeqno;
	}

	@Column(name = "item_code")
	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	@Column(name = "item_desc")
	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	@Column(name = "packaging")
	public String getPackaging() {
		return packaging;
	}

	public void setPackaging(String packaging) {
		this.packaging = packaging;
	}

	@Column(name = "pku")
	public String getPku() {
		return pku;
	}

	public void setPku(String pku) {
		this.pku = pku;
	}

	@Column(name = "unit_price")
	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	@Column(name = "ep_approved_qty")
	public Long getEpApprovedQty() {
		return epApprovedQty;
	}

	public void setEpApprovedQty(Long epApprovedQty) {
		this.epApprovedQty = epApprovedQty;
	}

	@Column(name = "received_Qty")
	public Long getReceivedQty() {
		return receivedQty;
	}

	public void setReceivedQty(Long receivedQty) {
		this.receivedQty = receivedQty;
	}

	@Column(name = "amount")
	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	

	@Column(name = "source_ptj_code", nullable = false, length = 20)
	public String getPtjCode() {
		return ptjCode;
	}

	public void setPtjCode(String ptjCode) {
		this.ptjCode = ptjCode;
	}


	@Column(name = "facility_code", nullable = false, length = 20)
	public String getFacilityCodeFrom() {
		return facilityCodeFrom;
	}

	public void setFacilityCodeFrom(String facilityCodeFrom) {
		this.facilityCodeFrom = facilityCodeFrom;
	}

	@Column(name = "facility_codeTo", nullable = false, length = 20)
	public String getFacilityCodeTo() {
		return facilityCodeTo;
	}
	public void setFacilityCodeTo(String facilityCodeTo) {
		this.facilityCodeTo = facilityCodeTo;
	}
	

	@Column(name = "rej_flag")
	public Character getRefFlag() {
		return refFlag;
	}

	public void setRefFlag(Character refFlag) {
		this.refFlag = refFlag;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "BUDGET_ADJ_SEQNO")
	public BudgetAdjHdr getBudgetAdjHdr() {
		return budgetAdjHdr;
	}

	public void setBudgetAdjHdr(BudgetAdjHdr budgetAdjHdr) {
		this.budgetAdjHdr = budgetAdjHdr;
	}
}
