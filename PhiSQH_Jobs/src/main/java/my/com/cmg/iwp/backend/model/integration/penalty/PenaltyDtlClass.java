package my.com.cmg.iwp.backend.model.integration.penalty;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="PenaltyDtlClass")
public class PenaltyDtlClass {
	private String doNo;
	private Double doAmount;
	Set<PenaltyItemClass> penaltyItems = new HashSet<PenaltyItemClass>(0);

	public String getDoNo() {
		return doNo;
	}
	public void setDoNo(String doNo) {
		this.doNo = doNo;
	}
	public Double getDoAmount() {
		return doAmount;
	}
	public void setDoAmount(Double doAmount) {
		this.doAmount = doAmount;
	}
	public Set<PenaltyItemClass> getPenaltyItems() {
		return penaltyItems;
	}
	public void setPenaltyItems(Set<PenaltyItemClass> penaltyItems) {
		this.penaltyItems = penaltyItems;
	}
	
	
}
