package my.com.cmg.iwp.maintenance.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class OrderStatistic implements Serializable {
	private static final long serialVersionUID = 1L;
	private String customerId;
	private String customerName;
	private BigDecimal epoCount;
	private BigDecimal lpoCount;
	private BigDecimal lpoCanCount;
	private BigDecimal invCount;
	private BigDecimal doCount;
	private BigDecimal reqNoteCount;
	private String dateFrom;
	private String dateTo;
	private String selType;
	private String selHos;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Integer getEpoCount() {
		return epoCount.intValue();
	}

	public void setEpoCount(BigDecimal epoCount) {
		this.epoCount = epoCount;
	}

	public Integer getLpoCount() {
		return lpoCount.intValue();
	}

	public void setLpoCount(BigDecimal lpoCount) {
		this.lpoCount = lpoCount;
	}

	public Integer getLpoCanCount() {
		return lpoCanCount.intValue();
	}

	public void setLpoCanCount(BigDecimal lpoCanCount) {
		this.lpoCanCount = lpoCanCount;
	}

	public Integer getInvCount() {
		return invCount.intValue();
	}

	public void setInvCount(BigDecimal invCount) {
		this.invCount = invCount;
	}

	public Integer getDoCount() {
		return doCount.intValue();
	}

	public void setDoCount(BigDecimal doCount) {
		this.doCount = doCount;
	}

	public Integer getReqNoteCount() {
		return reqNoteCount.intValue();
	}

	public void setReqNoteCount(BigDecimal reqNoteCount) {
		this.reqNoteCount = reqNoteCount;
	}

	public String getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}

	public String getDateTo() {
		return dateTo;
	}

	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}

	public String getSelType() {
		return selType;
	}

	public void setSelType(String selType) {
		this.selType = selType;
	}

	public String getSelHos() {
		return selHos;
	}

	public void setSelHos(String selHos) {
		this.selHos = selHos;
	}
}
