package my.com.cmg.iwp.backend.model.inventory.reports.procurement;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="t_purchase_order_status_stg")
public class PurchaseOrderByStatusReportStg implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private long    purOrdStaSeqno;
	private String  FacilityName;
	private String  orderNo;
	private String  itemGroup;
	private String  itemPurchaseType;
	private String  requestType;
	private String  purLPONo;
	private Date    approvalDatetimeLPO;
	private String  supplierName;
	private String  statusPO;
	private String  paymentStatus;
	private String  receiveStatus;
	private BigDecimal  totalAmt;
	private long    createdBy;
	private Date    createdDate;
	public PurchaseOrderByStatusReportStg() {
	}



	public PurchaseOrderByStatusReportStg(long purOrdStaSeqno, String facilityName, String orderNo, String itemGroup,
			String itemPurchaseType, String requestType, String purLPONo, Date approvalDatetimeLPO, String supplierName,
			String statusPO, String paymentStatus, String receiveStatus, BigDecimal totalAmt, long createdBy,
			Date createdDate) {
		super();
		this.purOrdStaSeqno = purOrdStaSeqno;
		FacilityName = facilityName;
		this.orderNo = orderNo;
		this.itemGroup = itemGroup;
		this.itemPurchaseType = itemPurchaseType;
		this.requestType = requestType;
		this.purLPONo = purLPONo;
		this.approvalDatetimeLPO = approvalDatetimeLPO;
		this.supplierName = supplierName;
		this.statusPO = statusPO;
		this.paymentStatus = paymentStatus;
		this.receiveStatus = receiveStatus;
		this.totalAmt = totalAmt;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
	}



	@Id
	@Column(name = "pur_ord_seqno", unique = true, nullable = false)
	@SequenceGenerator(name = "t_pur_order_status_stg_seq", sequenceName = "t_pur_order_status_stg_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "t_pur_order_status_stg_seq")
	public long getPurOrdStaSeqno() {
		return purOrdStaSeqno;
	}
    @Column(name="order_no")
	public String getOrderNo() {
		return orderNo;
	}
    @Column(name="item_group")
	public String getItemGroup() {
		return itemGroup;
	}
    @Column(name="item_pur_type")
	public String getItemPurchaseType() {
		return itemPurchaseType;
	}
    @Column(name="request_type")
	public String getRequestType() {
		return requestType;
	}
 
    @Column(name="pur_lpo_no")
	public String getPurLPONo() {
		return purLPONo;
	}
    @Column(name="lpo_aprv_date")
	public Date getApprovalDatetimeLPO() {
		return approvalDatetimeLPO;
	}
    @Column(name="supl_name")
	public String getSupplierName() {
		return supplierName;
	}
    @Column(name="po_status")
	public String getStatusPO() {
		return statusPO;
	}
  
    @Column(name="paymnt_status")
	public String getPaymentStatus() {
		return paymentStatus;
	}
    @Column(name="recv_status")
	public String getReceiveStatus() {
		return receiveStatus;
	}
    @Column(name="toatl_amt" , precision = 15, scale = 4)
	public BigDecimal getTotalAmt() {
		return totalAmt;
	}
    @Column(name="created_by")
	public long getCreatedBy() {
		return createdBy;
	}
    @Column(name="created_date")
	public Date getCreatedDate() {
		return createdDate;
	}
    @Column(name="facility_name")
	public String getFacilityName() {
		return FacilityName;
	}

	public void setPurOrdStaSeqno(long purOrdStaSeqno) {
		this.purOrdStaSeqno = purOrdStaSeqno;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public void setItemGroup(String itemGroup) {
		this.itemGroup = itemGroup;
	}

	public void setItemPurchaseType(String itemPurchaseType) {
		this.itemPurchaseType = itemPurchaseType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}


	public void setPurLPONo(String purLPONo) {
		this.purLPONo = purLPONo;
	}

	public void setApprovalDatetimeLPO(Date approvalDatetimeLPO) {
		this.approvalDatetimeLPO = approvalDatetimeLPO;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	
	public void setStatusPO(String statusPO) {
		this.statusPO = statusPO;
	}


	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public void setReceiveStatus(String receiveStatus) {
		this.receiveStatus = receiveStatus;
	}

	public void setTotalAmt(BigDecimal totalAmt) {
		this.totalAmt = totalAmt;
	}

	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public void setFacilityName(String facilityName) {
		FacilityName = facilityName;
	}
	
	
}
