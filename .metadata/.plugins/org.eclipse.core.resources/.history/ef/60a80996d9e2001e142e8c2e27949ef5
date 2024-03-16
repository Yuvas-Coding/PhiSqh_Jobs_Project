package my.com.cmg.iwp.backend.model.integration.iv;

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

/**
 * The persistent class for the ph_iv_dose_frequency_int database table.
 * 
 */
@Entity
@Table(name = "t_iv_dose_frequency_int")
@XmlRootElement(name = "IvDoseFrequencyInt")
@JsonIgnoreProperties(ignoreUnknown=true)
public class IvDoseFrequencyInt implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long doseIntSeqno;
	private Date adminTime;
	private Long createdBy;
	private Date createdDate;
	private Integer dose;
	private String parameter1;
	private String parameter2;
	private BigDecimal parameter3;
	private BigDecimal parameter4;
	private Date parameter5;
	private Long updatedBy;
	private Date updatedDate;
	private OrderIvInt orderIvInt;

	public IvDoseFrequencyInt() {
	}

	@Id
	@SequenceGenerator(name = "PH_IV_DOSE_FREQUENCY_INT_DOSEINTSEQNO_GENERATOR", sequenceName = "t_iv_dose_frequency_int_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PH_IV_DOSE_FREQUENCY_INT_DOSEINTSEQNO_GENERATOR")
	@Column(name = "dose_int_seqno")
	public Long getDoseIntSeqno() {
		return this.doseIntSeqno;
	}

	public void setDoseIntSeqno(Long doseIntSeqno) {
		this.doseIntSeqno = doseIntSeqno;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "admin_time")
	public Date getAdminTime() {
		return this.adminTime;
	}

	public void setAdminTime(Date adminTime) {
		this.adminTime = adminTime;
	}

	@Column(name = "created_by")
	public Long getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date")
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Integer getDose() {
		return this.dose;
	}

	public void setDose(Integer dose) {
		this.dose = dose;
	}

	public String getParameter1() {
		return this.parameter1;
	}

	public void setParameter1(String parameter1) {
		this.parameter1 = parameter1;
	}

	public String getParameter2() {
		return this.parameter2;
	}

	public void setParameter2(String parameter2) {
		this.parameter2 = parameter2;
	}

	public BigDecimal getParameter3() {
		return this.parameter3;
	}

	public void setParameter3(BigDecimal parameter3) {
		this.parameter3 = parameter3;
	}

	public BigDecimal getParameter4() {
		return this.parameter4;
	}

	public void setParameter4(BigDecimal parameter4) {
		this.parameter4 = parameter4;
	}

	@Temporal(TemporalType.DATE)
	public Date getParameter5() {
		return this.parameter5;
	}

	public void setParameter5(Date parameter5) {
		this.parameter5 = parameter5;
	}

	@Column(name = "updated_by")
	public Long getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_date")
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	// bi-directional many-to-one association to OrderIvInt
	@ManyToOne
	@JoinColumn(name = "order_iv_int_seqno")
	@JsonBackReference
	public OrderIvInt getOrderIvInt() {
		return this.orderIvInt;
	}

	public void setOrderIvInt(OrderIvInt orderIvInt) {
		this.orderIvInt = orderIvInt;
	}

}