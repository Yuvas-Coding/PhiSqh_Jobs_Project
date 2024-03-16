package my.com.cmg.iwp.maintenance.model.report.stg;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "t_sdr_report_stg")
public class SpecialDrugRequestStg implements java.io.Serializable {

	private long sessionId;
	private String drugName;
	private BigDecimal request;
	private BigDecimal quantity;
	private BigDecimal cost;
	private long sdrSeqno;
	private String sku;

	public SpecialDrugRequestStg() {
	}
	
	public SpecialDrugRequestStg(long sessionId, String drugName, BigDecimal request, BigDecimal quantity, BigDecimal cost, long sdrSeqno, String sku) {
		this.sessionId = sessionId;
		this.drugName = drugName;
		this.request = request;
		this.quantity = quantity;
		this.cost = cost;
		this.sdrSeqno = sdrSeqno;
		this.sku = sku;
	}

	@Column(name = "session_id", length = 50)
	public Long getSessionId() {
		return this.sessionId;
	}
	
	public void setSessionId(Long sessionId) {
		this.sessionId = sessionId;
	}
	
	@Column(name = "drug_name", length = 100)
	public String getDrugName() {
		return this.drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	@Column(name = "request")
	public BigDecimal getRequest() {
		return this.request;
	}

	public void setRequest(BigDecimal request) {
		this.request = request;
	}

	@Column(name = "total_qty")
	public BigDecimal getQuantity() {
		return this.quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	@Column(name = "total_cost")
	public BigDecimal getCost() {
		return this.cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	@Id
	@Column(name = "sdr_seqno", unique = true, nullable = false)
	public long getSdrSeqno() {
		return sdrSeqno;
	}

	public void setSdrSeqno(long sdrSeqno) {
		this.sdrSeqno = sdrSeqno;
	}

	@Column(name = "sku")
	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

}
