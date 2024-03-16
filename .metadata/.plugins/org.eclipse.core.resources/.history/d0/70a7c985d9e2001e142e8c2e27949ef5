package my.com.cmg.iwp.maintenance.model;

import java.math.BigDecimal;
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
@Table(name = "T_DO_DTL")
public class DoDtl implements java.io.Serializable {
	private static final long serialVersionUID = 3150376192729646138L;
	//private BigDecimal seqNo = new BigDecimal(Long.MIN_VALUE);
	private long seqNo = Long.MIN_VALUE;
	private String runNo;
	private String lampiranNo;
//	private String carrierCode;
	private String customerAccNo;
	private String lpoNo;
	private String customerRefNo;
	private String customerId;
//	private String salesmanCode;
//	private String termCode;
	private String itemCode;
	private String packageDesc;
	private String skuCode;
	private BigDecimal delQty;
	private String batchNo;
	private Date expDate;
	private Date doDate;
	private String sendToEp;
	private Date sendtoEpDate;
	private Date createDate;
	private String createBy;
	private Date lastUpdDate;
	private String lastUpdBy;
	private String itemDesc;
	private String status;
	private Long kkRcvQty;
	private Character kkRcvFlag;
	private Character localUpdateFlag;
	private Date manufacturingDate;
	private String manufacturerCode;
    private String manufacturerDesc;
    private String brandCode;
    private String brandName;
    private Date KKReceivedDate;
    private Character voidFlag;
    private Date voidDate;
	
	private PoHdr poHdr;
	private BigDecimal amount;
	@Transient
	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public DoDtl() {
	}

	public DoDtl(long seqNo, String runNo, String lampiranNo,
			String lpoNo, String itemCode, BigDecimal delQty) {
		this.seqNo = seqNo;
		this.runNo = runNo;
		this.lampiranNo = lampiranNo;
		this.lpoNo = lpoNo;
		this.itemCode = itemCode;
		this.delQty = delQty;
	}

	public DoDtl(long seqNo, String runNo, String lampiranNo,
			/*String carrierCode,*/ String customerAccNo, String lpoNo,
			String customerRefNo, String customerId, /*String salesmanCode,*/
			/*String termCode,*/ String itemCode, String packageDesc,
			String skuCode, BigDecimal delQty, String batchNo, Date expDate,
			Date doDate, String sendToEp, Date sendtoEpDate, Date createDate,
			String createBy, Date lastUpdDate, String lastUpdBy,
			String itemDesc, String status , Character localUpdateFlag , Date manufacturingDate , String manufacturerCode ,
            String manufacturerDesc , String brandCode , String brandName) {
		this.seqNo = seqNo;
		this.runNo = runNo;
		this.lampiranNo = lampiranNo;
//		this.carrierCode = carrierCode;
		this.customerAccNo = customerAccNo;
		this.lpoNo = lpoNo;
		this.customerRefNo = customerRefNo;
		this.customerId = customerId;
//		this.salesmanCode = salesmanCode;
//		this.termCode = termCode;
		this.itemCode = itemCode;
		this.packageDesc = packageDesc;
		this.skuCode = skuCode;
		this.delQty = delQty;
		this.batchNo = batchNo;
		this.expDate = expDate;
		this.doDate = doDate;
		this.sendToEp = sendToEp;
		this.sendtoEpDate = sendtoEpDate;
		this.createDate = createDate;
		this.createBy = createBy;
		this.lastUpdDate = lastUpdDate;
		this.lastUpdBy = lastUpdBy;
		this.itemDesc = itemDesc;
		this.status = status;
		this.localUpdateFlag = localUpdateFlag;
		this.manufacturingDate = manufacturingDate;
		this.manufacturerCode = manufacturerCode;
		this.manufacturerDesc = manufacturerDesc;
		this.brandCode = brandCode;
		this.brandName = brandName;
	}

	@Id
	@SequenceGenerator(name="T_DO_DTL_SEQ", sequenceName="T_DO_DTL_SEQ", allocationSize  = 1)
    @GeneratedValue(generator="T_DO_DTL_SEQ")
	@Column(name = "DO_SEQ_NO", unique = true, nullable = false)
	public long getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(long seqNo) {
		this.seqNo = seqNo;
	}
	
	
	@Column(name = "RUN_NO", nullable = false, length = 3)
	public String getRunNo() {
		return this.runNo;
	}	

	public void setRunNo(String runNo) {
		this.runNo = runNo;
	}

	@Column(name = "LAMPIRAN_NO", nullable = false, length = 15)
	public String getLampiranNo() {
		return this.lampiranNo;
	}

	public void setLampiranNo(String lampiranNo) {
		this.lampiranNo = lampiranNo;
	}

	/*@Column(name = "CARRIER_CODE", length = 4)
	public String getCarrierCode() {
		return this.carrierCode;
	}

	public void setCarrierCode(String carrierCode) {
		this.carrierCode = carrierCode;
	}*/

	@Column(name = "CUSTOMER_ACC_NO", length = 8)
	public String getCustomerAccNo() {
		return this.customerAccNo;
	}

	public void setCustomerAccNo(String customerAccNo) {
		this.customerAccNo = customerAccNo;
	}

	@Column(name = "LPO_NO", nullable = false, length = 22)
	public String getLpoNo() {
		return this.lpoNo;
	}

	public void setLpoNo(String lpoNo) {
		this.lpoNo = lpoNo;
	}

	@Column(name = "CUSTOMER_REF_NO", length = 8)
	public String getCustomerRefNo() {
		return this.customerRefNo;
	}

	public void setCustomerRefNo(String customerRefNo) {
		this.customerRefNo = customerRefNo;
	}

	@Column(name = "CUSTOMER_ID", length = 8)
	public String getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	/*@Column(name = "SALESMAN_CODE", length = 4)
	public String getSalesmanCode() {
		return this.salesmanCode;
	}

	public void setSalesmanCode(String salesmanCode) {
		this.salesmanCode = salesmanCode;
	}*/

//	@Column(name = "TERM_CODE", length = 3)
//	public String getTermCode() {
//		return this.termCode;
//	}
//
//	public void setTermCode(String termCode) {
//		this.termCode = termCode;
//	}

	@Column(name = "ITEM_CODE", nullable = false, length = 15)
	public String getItemCode() {
		return this.itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	@Column(name = "PACKAGE_DESC", length = 30)
	public String getPackageDesc() {
		return this.packageDesc;
	}

	public void setPackageDesc(String packageDesc) {
		this.packageDesc = packageDesc;
	}

	@Column(name = "SKU_CODE", length = 3)
	public String getSkuCode() {
		return this.skuCode;
	}

	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}

	@Column(name = "DEL_QTY", nullable = false, length = 9)
	public BigDecimal getDelQty() {
		return this.delQty;
	}

	public void setDelQty(BigDecimal delQty) {
		this.delQty = delQty;
	}

	@Column(name = "BATCH_NO", length = 12)
	public String getBatchNo() {
		return this.batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "EXP_DATE", length = 7)
	public Date getExpDate() {
		return this.expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DO_DATE", length = 7)
	public Date getDoDate() {
		return this.doDate;
	}

	public void setDoDate(Date doDate) {
		this.doDate = doDate;
	}

	@Column(name = "SEND_TO_EP", length = 1)
	public String getSendToEp() {
		return this.sendToEp;
	}

	public void setSendToEp(String sendToEp) {
		this.sendToEp = sendToEp;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "SENDTO_EP_DATE", length = 7)
	public Date getSendtoEpDate() {
		return this.sendtoEpDate;
	}

	public void setSendtoEpDate(Date sendtoEpDate) {
		this.sendtoEpDate = sendtoEpDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_DATE", length = 7)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name = "CREATED_BY", length = 20)
	public String getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATED_DATE", length = 7)
	public Date getLastUpdDate() {
		return this.lastUpdDate;
	}

	public void setLastUpdDate(Date lastUpdDate) {
		this.lastUpdDate = lastUpdDate;
	}

	@Column(name = "UPDATED_BY", length = 20)
	public String getLastUpdBy() {
		return this.lastUpdBy;
	}

	public void setLastUpdBy(String lastUpdBy) {
		this.lastUpdBy = lastUpdBy;
	}

	@Column(name = "ITEM_DESC", length = 100)
	public String getItemDesc() {
		return this.itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	@Column(name = "STATUS", length = 1)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PO_HDR_SEQNO")
	public PoHdr getPoHdr() {
		return poHdr;
	}

	public void setPoHdr(PoHdr poHdr) {
		this.poHdr = poHdr;
	}

	@Column(name="KK_RCV_QTY")
	public Long getKkRcvQty() {
		return kkRcvQty;
	}

	public void setKkRcvQty(Long kkRcvQty) {
		this.kkRcvQty = kkRcvQty;
	}
	
	@Column(name="KK_RCV_FLAG")
	public Character getKkRcvFlag() {
		return kkRcvFlag;
	}

	public void setKkRcvFlag(Character kkRcvFlag) {
		this.kkRcvFlag = kkRcvFlag;
	}
	
	@Column(name="LOCAL_UPDATE_FLAG")
	public Character getLocalUpdateFlag() {
		return localUpdateFlag;
	}

	public void setLocalUpdateFlag(Character localUpdateFlag) {
		this.localUpdateFlag = localUpdateFlag;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "MANUFACTURING_DATE", length = 7)
	public Date getManufacturingDate() {
		return manufacturingDate;
	}

	public void setManufacturingDate(Date manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}

	@Column(name = "MANU_CODE", length = 10)
	public String getManufacturerCode() {
		return manufacturerCode;
	}

	public void setManufacturerCode(String manufacturerCode) {
		this.manufacturerCode = manufacturerCode;
	}

	@Column(name = "MANU_DESC", length = 30)
	public String getManufacturerDesc() {
		return manufacturerDesc;
	}

	public void setManufacturerDesc(String manufacturerDesc) {
		this.manufacturerDesc = manufacturerDesc;
	}

	@Column(name = "BRD_CODE", length = 10)
	public String getBrandCode() {
		return brandCode;
	}
	
	public void setBrandCode(String brandCode) {
		this.brandCode = brandCode;
	}

	@Column(name = "BRD_NAME", length = 30)
	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	@Column(name="KK_RECEIVED_DATE")
	public Date getKKReceivedDate() {
		return KKReceivedDate;
	}

	public void setKKReceivedDate(Date kKReceivedDate) {
		KKReceivedDate = kKReceivedDate;
	}

	@Column(name = "void_flag")
	public Character getVoidFlag() {
		return voidFlag;
	}

	public void setVoidFlag(Character voidFlag) {
		this.voidFlag = voidFlag;
	}

	@Column(name = "void_date")
	public Date getVoidDate() {
		return voidDate;
	}

	public void setVoidDate(Date voidDate) {
		this.voidDate = voidDate;
	}	
}
