package my.com.cmg.iwp.backend.model.integration.penalty;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import my.com.cmg.iwp.webui.constant.RefCodeConstant;

@XmlRootElement(name="PenaltyBatchClass")
@JsonIgnoreProperties(ignoreUnknown=true)
public class PenaltyBatchClass {
	private String batchNo;
	private Date batchExpDate;
	private Long qtyPku;
	private Double unitPrice;
	private Long recommendedDelayDays;
	private Long realDelayDays;
	private Double recommendedPenaltyAmt;
	private Double realPenaltyAmt;
	private Long rejectQty;
	private String remarks;
	
	private Double proposedPenaltyAmt;
	private Character minPayFlag = RefCodeConstant.BOOLEAN_TRUE;

	public String getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	public Date getBatchExpDate() {
		return batchExpDate;
	}
	public void setBatchExpDate(Date batchExpDate) {
		this.batchExpDate = batchExpDate;
	}
	public Long getQtyPku() {
		return qtyPku;
	}
	public void setQtyPku(Long qtyPku) {
		this.qtyPku = qtyPku;
	}
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Long getRecommendedDelayDays() {
		return recommendedDelayDays;
	}
	public void setRecommendedDelayDays(Long recommendedDelayDays) {
		this.recommendedDelayDays = recommendedDelayDays;
	}
	public Long getRealDelayDays() {
		return realDelayDays;
	}
	public void setRealDelayDays(Long realDelayDays) {
		this.realDelayDays = realDelayDays;
	}
	public Double getRecommendedPenaltyAmt() {
		return recommendedPenaltyAmt;
	}
	public void setRecommendedPenaltyAmt(Double recommendedPenaltyAmt) {
		this.recommendedPenaltyAmt = recommendedPenaltyAmt;
	}
	public Double getRealPenaltyAmt() {
		return realPenaltyAmt;
	}
	public void setRealPenaltyAmt(Double realPenaltyAmt) {
		this.realPenaltyAmt = realPenaltyAmt;
	}
	public Long getRejectQty() {
		return rejectQty;
	}
	public void setRejectQty(Long rejectQty) {
		this.rejectQty = rejectQty;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}		
	public Double getProposedPenaltyAmt() {
		return proposedPenaltyAmt;
	}
	public void setProposedPenaltyAmt(Double proposedPenaltyAmt) {
		this.proposedPenaltyAmt = proposedPenaltyAmt;
	}
	public Character getMinPayFlag() {
		return minPayFlag;
	}
	public void setMinPayFlag(Character minPayFlag) {
		this.minPayFlag = minPayFlag;
	}
}
