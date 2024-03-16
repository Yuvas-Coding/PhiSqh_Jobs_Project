package my.com.cmg.iwp.backend.model.integration.penalty;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

import my.com.cmg.iwp.webui.constant.RefCodeConstant;

@XmlRootElement(name="PenaltyItemClass")
public class PenaltyItemClass {
	private String itemCode;
	private String itemName;
	private String brandCode;
	private String brandName;
	private char essentialFlag = RefCodeConstant.BOOLEAN_FALSE;
	private Long usageStock;
	private Long minStock;
	private Long actualStock;
	private char penaltyFlag = RefCodeConstant.BOOLEAN_FALSE;
	private Double penaltyAmount;
	private String itemRemarks;
	Set<PenaltyBatchClass> penaltyBatchs = new HashSet<PenaltyBatchClass>(0) ;
	




	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getBrandCode() {
		return brandCode;
	}
	public void setBrandCode(String brandCode) {
		this.brandCode = brandCode;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public char getEssentialFlag() {
		return essentialFlag;
	}
	public void setEssentialFlag(char essentialFlag) {
		this.essentialFlag = essentialFlag;
	}
	public Long getUsageStock() {
		return usageStock;
	}
	public void setUsageStock(Long usageStock) {
		this.usageStock = usageStock;
	}
	public Long getMinStock() {
		return minStock;
	}
	public void setMinStock(Long minStock) {
		this.minStock = minStock;
	}
	public Long getActualStock() {
		return actualStock;
	}
	public void setActualStock(Long actualStock) {
		this.actualStock = actualStock;
	}
	public char getPenaltyFlag() {
		return penaltyFlag;
	}
	public void setPenaltyFlag(char penaltyFlag) {
		this.penaltyFlag = penaltyFlag;
	}
	public Double getPenaltyAmount() {
		return penaltyAmount;
	}
	public void setPenaltyAmount(Double penaltyAmount) {
		this.penaltyAmount = penaltyAmount;
	}
	public String getItemRemarks() {
		return itemRemarks;
	}
	public void setItemRemarks(String itemRemarks) {
		this.itemRemarks = itemRemarks;
	}
	public Set<PenaltyBatchClass> getPenaltyBatchs() {
		return penaltyBatchs;
	}
	public void setPenaltyBatchs(Set<PenaltyBatchClass> penaltyBatchs) {
		this.penaltyBatchs = penaltyBatchs;
	}
}
