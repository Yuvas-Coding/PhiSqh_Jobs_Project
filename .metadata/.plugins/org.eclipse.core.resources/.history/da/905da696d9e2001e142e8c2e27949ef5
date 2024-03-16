package my.com.cmg.iwp.backend.model.integration.returns;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "t_return_inter_dtls_int")
@XmlRootElement(name = "ReturnInterDtlsInt")
@JsonIgnoreProperties(ignoreUnknown=true)
public class ReturnInterDtlsInt implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long rtdIntSeqno;
	private ReturnInterHdrsInt returnInterHdrsInt;
	private String rtdItemCode;
	private String rtdBatchNo;
	private Date rtdExpiryDate;
	private BigDecimal rtdGoodStk;
	private BigDecimal rtdReceiptQty;
	private BigDecimal rtdReturnQty;
	private BigDecimal rtdReplacedQty;
	private BigDecimal rtdUnitPrice;
	private Long createdBy;
	private Date createdDate;
	private Long updatedBy;
	private Date updatedDate;
	private String parameter1;
	private String parameter2;
	private BigDecimal parameter3;
	private BigDecimal parameter4;
	private Date parameter5;
				
	private String remarks;
	//private String itemCode;
	private BigDecimal rtdAmount;
	private String brandCode;
	private String rtdSku;
	
	
	@Id
	@SequenceGenerator(name="PH_RETURN_INTER_DTLS_INT_RTDINTSEQNO_GENERATOR", sequenceName="T_RETURN_INTER_DTLS_INT_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PH_RETURN_INTER_DTLS_INT_RTDINTSEQNO_GENERATOR")
	@Column(name="rtd_int_seqno")
	public Long getRtdIntSeqno() {
		return rtdIntSeqno;
	}
	public void setRtdIntSeqno(Long rtdIntSeqno) {
		this.rtdIntSeqno = rtdIntSeqno;
	}
	
	
	@ManyToOne
	@JoinColumn(name="rth_int_seqno")
    @JsonBackReference
	public ReturnInterHdrsInt getReturnInterHdrsInt() {
		return returnInterHdrsInt;
	}
	public void setReturnInterHdrsInt(ReturnInterHdrsInt returnInterHdrsInt) {
		this.returnInterHdrsInt = returnInterHdrsInt;
	}
	
	@Column(name="rtd_item_code")
	public String getRtdItemCode() {
		return rtdItemCode;
	}
	public void setRtdItemCode(String rtdItemCode) {
		this.rtdItemCode = rtdItemCode;
	}
	
	@Column(name="rtd_batch_no")
	public String getRtdBatchNo() {
		return rtdBatchNo;
	}
	public void setRtdBatchNo(String rtdBatchNo) {
		this.rtdBatchNo = rtdBatchNo;
	}
	
	@Column(name="rtd_expiry_date")
	public Date getRtdExpiryDate() {
		return rtdExpiryDate;
	}
	public void setRtdExpiryDate(Date rtdExpiryDate) {
		this.rtdExpiryDate = rtdExpiryDate;
	}
	
	@Column(name="rtd_good_stk")
	public BigDecimal getRtdGoodStk() {
		return rtdGoodStk;
	}
	public void setRtdGoodStk(BigDecimal rtdGoodStk) {
		this.rtdGoodStk = rtdGoodStk;
	}
	
	@Column(name="rtd_receipt_qty")
	public BigDecimal getRtdReceiptQty() {
		return rtdReceiptQty;
	}
	public void setRtdReceiptQty(BigDecimal rtdReceiptQty) {
		this.rtdReceiptQty = rtdReceiptQty;
	}
	
	@Column(name="rtd_return_qty")
	public BigDecimal getRtdReturnQty() {
		return rtdReturnQty;
	}
	public void setRtdReturnQty(BigDecimal rtdReturnQty) {
		this.rtdReturnQty = rtdReturnQty;
	}
	
	@Column(name="rtd_replaced_qty")
	public BigDecimal getRtdReplacedQty() {
		return rtdReplacedQty;
	}
	public void setRtdReplacedQty(BigDecimal rtdReplacedQty) {
		this.rtdReplacedQty = rtdReplacedQty;
	}
	
	@Column(name="rtd_unit_price")
	public BigDecimal getRtdUnitPrice() {
		return rtdUnitPrice;
	}
	public void setRtdUnitPrice(BigDecimal rtdUnitPrice) {
		this.rtdUnitPrice = rtdUnitPrice;
	}
	
	@Column(name="created_by")
	public Long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	
	@Temporal( TemporalType.TIMESTAMP)
	@Column(name="created_date")
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	@Column(name="updated_by")
	public Long getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	@Temporal( TemporalType.TIMESTAMP)
	@Column(name="updated_date")
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	@Column(name="parameter1")
	public String getParameter1() {
		return parameter1;
	}
	public void setParameter1(String parameter1) {
		this.parameter1 = parameter1;
	}
	
	@Column(name="parameter2")
	public String getParameter2() {
		return parameter2;
	}
	public void setParameter2(String parameter2) {
		this.parameter2 = parameter2;
	}
	
	@Column(name="parameter3")
	public BigDecimal getParameter3() {
		return parameter3;
	}
	public void setParameter3(BigDecimal parameter3) {
		this.parameter3 = parameter3;
	}
	
	@Column(name="parameter4")
	public BigDecimal getParameter4() {
		return parameter4;
	}
	public void setParameter4(BigDecimal parameter4) {
		this.parameter4 = parameter4;
	}
	
	@Temporal( TemporalType.DATE)
	@Column(name="parameter5")
	public Date getParameter5() {
		return parameter5;
	}
	public void setParameter5(Date parameter5) {
		this.parameter5 = parameter5;
	}
	
	@Column(name="remarks")
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
	@Column(name="rtd_amount")
	public BigDecimal getRtdAmount() {
		return rtdAmount;
	}
	public void setRtdAmount(BigDecimal rtdAmount) {
		this.rtdAmount = rtdAmount;
	}
	
	@Column(name="brand_code")
	public String getBrandCode() {
		return brandCode;
	}
	public void setBrandCode(String brandCode) {
		this.brandCode = brandCode;
	}
	
	@Column(name="rtd_sku")
	public String getRtdSku() {
		return rtdSku;
	}
	public void setRtdSku(String rtdSku) {
		this.rtdSku = rtdSku;
	}
	
	
	
}
