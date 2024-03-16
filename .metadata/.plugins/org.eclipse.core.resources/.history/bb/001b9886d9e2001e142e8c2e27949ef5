package my.com.cmg.iwp.maintenance.model.his;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import my.com.cmg.iwp.maintenance.model.PoDtl;

@Entity
@Table(name = "T_EPO_HDR_STG")
public class EPOHdrStg implements java.io.Serializable {
	
	@Id
	@SequenceGenerator(name="T_EPO_HDR_STG_SEQNO_GENERATOR", sequenceName="T_EPO_HDR_STG_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="T_EPO_HDR_STG_SEQNO_GENERATOR")
	@Column(name = "EPO_HDR_SEQNO", nullable = false, precision = 22, scale = 0)
	private long epoHdrSeqno;
	
	@Column(name = "CUSTOMER_ID", nullable = false, length = 8)
	private String customerId;
	
	@Column(name = "CUSTOMER_REF_NO", nullable = false, length = 8)
	private String customerRefNo;
	
	@Column(name = "CUSTOMER_ACC_NO", nullable = false, length = 8)
	private String customerAccNo;
	
	@Column(name = "PTJ_CODE", nullable = false, length = 10)
	private String ptjCode;

	@Column(name = "CUSTOMER_NAME", length = 40)
	private String customerName;

	@Column(name = "REF_NO", length = 21)
	private String refNo;

	@Column(name = "SHIP_TO_CODE", length = 10)
	private String shipToCode;

	@Column(name = "ORDER_TYPE", length = 10)
	private String orderType;

	@Column(name = "ORDER_DATE", length = 7)
	private Date orderDate;

	@Column(name = "TOTAL_ORDER_AMOUNT", nullable = false, precision = 15, scale = 3)
	private BigDecimal totalOrderAmount;

	@Column(name = "LPO_DATE_TIME", length = 7)
	private Date lpoDateTime;

	@Column(name = "LPO_NO", length = 40)
	private String lpoNo;

	@Column(name = "LPO_APRVED_DATE", length = 7)
	private Date lpoAprvedDate;

	@Column(name = "LPO_AMOUNT", precision = 13)
	private BigDecimal lpoAmount;

	@Column(name = "FULFILLMENT_STATUS", length = 1)
	private String fulfillmentStatus;

	@Column(name = "FULFILLMENT_RECEIVED_DATE", length = 7)
	private Date fulfillmentReceivedDate;

	@Column(name = "PAYMENT_STATUS", length = 1)
	private String paymentStatus;

	@Column(name = "PAYMENT_RECEIVED_DATE", length = 7)
	private Date paymentReceivedDate;

	@Column(name = "INVOICE_STATUS", length = 1)
	private String invoiceStatus;

	@Column(name = "SEND_EP_FLAG", length = 1)
	private String sendEpFlag;

	@Column(name = "SEND_TO_EP_DATE", length = 7)
	private Date sendToEpDate;

	@Column(name = "ORDER_STATUS", length = 30)
	private String orderStatus;

	@Column(name = "CREATE_DATE", length = 7)
	private Date createDate;

	@Column(name = "CREATE_BY", length = 20)
	private String createBy;

	@Column(name = "LAST_UPD_DATE", length = 7)
	private Date lastUpdDate;

	@Column(name = "LAST_UPD_BY", length = 20)
	private String lastUpdBy;

	@Column(name = "UPDATE_LOCAL_FLAG", length = 1)
	private String updateLocalFlag;

	@Column(name = "SECURITY_TOKEN", length = 100)
	private String securityToken;

	@Column(name = "SIGNATURE", length = 256)
	private String signature;

	@Column(name = "PO_ACKNOWLEDGEMENT_FLAG", length = 1)
	private String poAcknowledgementFlag;

	@Column(name = "CANCELLATION_DATE", length = 7)
	private Date cancellationDate;

	@Column(name = "CANCELLATION_REMARKS", length = 2000)
	private String cancellationRemarks;

	@Column(name = "CANCELLATION_RECEIVED_DATE", length = 7)
	private Date cancellationReceivedDate;

	@Column(name = "REQ_NO", length = 100)
	private String reqNo;

	@Column(name = "PO_VERIFICATION_FLAG", length = 1)
	private Character poVerificationFlag;

	@Column(name = "PO_VERIFICATION_DATE", length = 7)
	private Date poVerificationDate;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "epoHdrStg" ,cascade=CascadeType.ALL)
    private Set<EPODtlStg> epoDtlStg = new HashSet<EPODtlStg>(0);

	public long getEpoHdrSeqno() {
		return epoHdrSeqno;
	}

	public void setEpoHdrSeqno(long epoHdrSeqno) {
		this.epoHdrSeqno = epoHdrSeqno;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerRefNo() {
		return customerRefNo;
	}

	public void setCustomerRefNo(String customerRefNo) {
		this.customerRefNo = customerRefNo;
	}

	public String getCustomerAccNo() {
		return customerAccNo;
	}

	public void setCustomerAccNo(String customerAccNo) {
		this.customerAccNo = customerAccNo;
	}

	public String getPtjCode() {
		return ptjCode;
	}

	public void setPtjCode(String ptjCode) {
		this.ptjCode = ptjCode;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getRefNo() {
		return refNo;
	}

	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

	public String getShipToCode() {
		return shipToCode;
	}

	public void setShipToCode(String shipToCode) {
		this.shipToCode = shipToCode;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public BigDecimal getTotalOrderAmount() {
		return totalOrderAmount;
	}

	public void setTotalOrderAmount(BigDecimal totalOrderAmount) {
		this.totalOrderAmount = totalOrderAmount;
	}

	public Date getLpoDateTime() {
		return lpoDateTime;
	}

	public void setLpoDateTime(Date lpoDateTime) {
		this.lpoDateTime = lpoDateTime;
	}

	public String getLpoNo() {
		return lpoNo;
	}

	public void setLpoNo(String lpoNo) {
		this.lpoNo = lpoNo;
	}

	public Date getLpoAprvedDate() {
		return lpoAprvedDate;
	}

	public void setLpoAprvedDate(Date lpoAprvedDate) {
		this.lpoAprvedDate = lpoAprvedDate;
	}

	public BigDecimal getLpoAmount() {
		return lpoAmount;
	}

	public void setLpoAmount(BigDecimal lpoAmount) {
		this.lpoAmount = lpoAmount;
	}

	public String getFulfillmentStatus() {
		return fulfillmentStatus;
	}

	public void setFulfillmentStatus(String fulfillmentStatus) {
		this.fulfillmentStatus = fulfillmentStatus;
	}

	public Date getFulfillmentReceivedDate() {
		return fulfillmentReceivedDate;
	}

	public void setFulfillmentReceivedDate(Date fulfillmentReceivedDate) {
		this.fulfillmentReceivedDate = fulfillmentReceivedDate;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public Date getPaymentReceivedDate() {
		return paymentReceivedDate;
	}

	public void setPaymentReceivedDate(Date paymentReceivedDate) {
		this.paymentReceivedDate = paymentReceivedDate;
	}

	public String getInvoiceStatus() {
		return invoiceStatus;
	}

	public void setInvoiceStatus(String invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
	}

	public String getSendEpFlag() {
		return sendEpFlag;
	}

	public void setSendEpFlag(String sendEpFlag) {
		this.sendEpFlag = sendEpFlag;
	}

	public Date getSendToEpDate() {
		return sendToEpDate;
	}

	public void setSendToEpDate(Date sendToEpDate) {
		this.sendToEpDate = sendToEpDate;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getLastUpdDate() {
		return lastUpdDate;
	}

	public void setLastUpdDate(Date lastUpdDate) {
		this.lastUpdDate = lastUpdDate;
	}

	public String getLastUpdBy() {
		return lastUpdBy;
	}

	public void setLastUpdBy(String lastUpdBy) {
		this.lastUpdBy = lastUpdBy;
	}

	public String getUpdateLocalFlag() {
		return updateLocalFlag;
	}

	public void setUpdateLocalFlag(String updateLocalFlag) {
		this.updateLocalFlag = updateLocalFlag;
	}

	public String getSecurityToken() {
		return securityToken;
	}

	public void setSecurityToken(String securityToken) {
		this.securityToken = securityToken;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getPoAcknowledgementFlag() {
		return poAcknowledgementFlag;
	}

	public void setPoAcknowledgementFlag(String poAcknowledgementFlag) {
		this.poAcknowledgementFlag = poAcknowledgementFlag;
	}

	public Date getCancellationDate() {
		return cancellationDate;
	}

	public void setCancellationDate(Date cancellationDate) {
		this.cancellationDate = cancellationDate;
	}

	public String getCancellationRemarks() {
		return cancellationRemarks;
	}

	public void setCancellationRemarks(String cancellationRemarks) {
		this.cancellationRemarks = cancellationRemarks;
	}

	public Date getCancellationReceivedDate() {
		return cancellationReceivedDate;
	}

	public void setCancellationReceivedDate(Date cancellationReceivedDate) {
		this.cancellationReceivedDate = cancellationReceivedDate;
	}

	public String getReqNo() {
		return reqNo;
	}

	public void setReqNo(String reqNo) {
		this.reqNo = reqNo;
	}

	public Character getPoVerificationFlag() {
		return poVerificationFlag;
	}

	public void setPoVerificationFlag(Character poVerificationFlag) {
		this.poVerificationFlag = poVerificationFlag;
	}

	public Date getPoVerificationDate() {
		return poVerificationDate;
	}

	public void setPoVerificationDate(Date poVerificationDate) {
		this.poVerificationDate = poVerificationDate;
	}

	public Set<EPODtlStg> getEpoDtlStg() {
		return epoDtlStg;
	}

	public void setEpoDtlStg(Set<EPODtlStg> epoDtlStg) {
		this.epoDtlStg = epoDtlStg;
	}
}
