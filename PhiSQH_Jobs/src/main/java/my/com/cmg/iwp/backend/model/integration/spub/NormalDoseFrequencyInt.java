package my.com.cmg.iwp.backend.model.integration.spub;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import my.com.cmg.iwp.webui.constant.RefCodeConstant;


/**
 * The persistent class for the ph_normal_dose_frequency_int database table.
 * 
 */
@Entity
@Table(name="t_normal_dose_freq_int")
@JsonIgnoreProperties(ignoreUnknown=true)
public class NormalDoseFrequencyInt implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long orderNormalIntSeqno;
	private Character activeFlag= RefCodeConstant.ACTIVE_FLAG_TRUE;
	private Date adminTime;
	private Long createdBy;
	private Date createdDate;
	private BigDecimal dose;
	private Long doseSeqno;
	private String parameter1;
	private String parameter2;
	private BigDecimal parameter3;
	private BigDecimal parameter4;
	private Date parameter5;
//	private Long spubDtlsSeqno;
	private SpubDtlsInt spubDtlsInt;
	private Long updatedBy;
	private Date updatedDate;

    public NormalDoseFrequencyInt() {
    }


	@Id
	@SequenceGenerator(name="PH_NORMAL_DOSE_FREQUENCY_INT_ORDERNORMALINTSEQNO_GENERATOR", sequenceName="T_NORMAL_DOSE_FREQ_INT_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PH_NORMAL_DOSE_FREQUENCY_INT_ORDERNORMALINTSEQNO_GENERATOR")
	@Column(name="order_normal_int_seqno")
	public Long getOrderNormalIntSeqno() {
		return this.orderNormalIntSeqno;
	}

	public void setOrderNormalIntSeqno(Long orderNormalIntSeqno) {
		this.orderNormalIntSeqno = orderNormalIntSeqno;
	}


	@Column(name="active_flag")
	public Character getActiveFlag() {
		return this.activeFlag;
	}

	public void setActiveFlag(Character activeFlag) {
		this.activeFlag = activeFlag;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="admin_time")
	public Date getAdminTime() {
		return this.adminTime;
	}

	public void setAdminTime(Date adminTime) {
		this.adminTime = adminTime;
	}


	@Column(name="created_by")
	public Long getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_date")
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}


	public BigDecimal getDose() {
		return this.dose;
	}

	public void setDose(BigDecimal dose) {
		this.dose = dose;
	}


	@Column(name="dose_seqno")
	public Long getDoseSeqno() {
		return this.doseSeqno;
	}

	public void setDoseSeqno(Long doseSeqno) {
		this.doseSeqno = doseSeqno;
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


    @Temporal( TemporalType.DATE)
	public Date getParameter5() {
		return this.parameter5;
	}

	public void setParameter5(Date parameter5) {
		this.parameter5 = parameter5;
	}


//	@Column(name="spub_dtls_seqno")
//	public Long getSpubDtlsSeqno() {
//		return this.spubDtlsSeqno;
//	}
//
//	public void setSpubDtlsSeqno(Long spubDtlsSeqno) {
//		this.spubDtlsSeqno = spubDtlsSeqno;
//	}


	@Column(name="updated_by")
	public Long getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_date")
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@ManyToOne
	@JoinColumn(name = "spub_dtls_seqno")
	@JsonBackReference("NormalDoseFrequencyInt")
	public SpubDtlsInt getSpubDtlsInt() {
		return spubDtlsInt;
	}


	public void setSpubDtlsInt(SpubDtlsInt spubDtlsInt) {
		this.spubDtlsInt = spubDtlsInt;
	}
}