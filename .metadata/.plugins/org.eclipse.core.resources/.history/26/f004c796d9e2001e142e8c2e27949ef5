package my.com.cmg.iwp.backend.model.integration.spub;

import java.io.Serializable;
import java.sql.Timestamp;
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


/**
 * The persistent class for the ph_suborder_taper_stat_int database table.
 * 
 */
@Entity
@Table(name="t_subord_taper_stat_int")
@JsonIgnoreProperties(ignoreUnknown=true)
public class SuborderTaperStatInt implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long suborderTsIntSeqno;
	private Long createdBy;
	private Date createdDate;
	private Long dispensedQty;
	private String dosageUomCode;
	private String frequencyCode;
	private String givePerTime;
	private String hospitalId;
	private String medicineCode;
	private String medicineDesc;
	private String medicineRoute;
	private String medicineSite;
	private String medicineUnit;
	private String method;
	private Date orderEndDate;
	private Long orderQty;
	private String orderQtyUomCode;
	private Date orderStartDate;
	private Long quantity;
	private String remarks;
//	private Long spubDtlsSeqno;
	private Long updatedBy;
	private Date updatedDate;
	private Integer version;
	private SpubDtlsInt spubDtlsInt;

    public SuborderTaperStatInt() {
    }


	@Id
	@SequenceGenerator(name="PH_SUBORDER_TAPER_STAT_INT_SUBORDERTSINTSEQNO_GENERATOR", sequenceName="ph_subord_taper_stat_int", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PH_SUBORDER_TAPER_STAT_INT_SUBORDERTSINTSEQNO_GENERATOR")
	@Column(name="suborder_ts_int_seqno")
	public Long getSuborderTsIntSeqno() {
		return this.suborderTsIntSeqno;
	}

	public void setSuborderTsIntSeqno(Long suborderTsIntSeqno) {
		this.suborderTsIntSeqno = suborderTsIntSeqno;
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
		this.createdDate = (Timestamp) createdDate;
	}


	@Column(name="dispensed_qty")
	public Long getDispensedQty() {
		return this.dispensedQty;
	}

	public void setDispensedQty(Long dispensedQty) {
		this.dispensedQty = dispensedQty;
	}


	@Column(name="dosage_uom_code")
	public String getDosageUomCode() {
		return this.dosageUomCode;
	}

	public void setDosageUomCode(String dosageUomCode) {
		this.dosageUomCode = dosageUomCode;
	}


	@Column(name="frequency_code")
	public String getFrequencyCode() {
		return this.frequencyCode;
	}

	public void setFrequencyCode(String frequencyCode) {
		this.frequencyCode = frequencyCode;
	}


	@Column(name="give_per_time")
	public String getGivePerTime() {
		return this.givePerTime;
	}

	public void setGivePerTime(String givePerTime) {
		this.givePerTime = givePerTime;
	}


	@Column(name="hospital_id")
	public String getHospitalId() {
		return this.hospitalId;
	}

	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}


	@Column(name="medicine_code")
	public String getMedicineCode() {
		return this.medicineCode;
	}

	public void setMedicineCode(String medicineCode) {
		this.medicineCode = medicineCode;
	}


	@Column(name="medicine_desc")
	public String getMedicineDesc() {
		return this.medicineDesc;
	}

	public void setMedicineDesc(String medicineDesc) {
		this.medicineDesc = medicineDesc;
	}


	@Column(name="medicine_route")
	public String getMedicineRoute() {
		return this.medicineRoute;
	}

	public void setMedicineRoute(String medicineRoute) {
		this.medicineRoute = medicineRoute;
	}


	@Column(name="medicine_site")
	public String getMedicineSite() {
		return this.medicineSite;
	}

	public void setMedicineSite(String medicineSite) {
		this.medicineSite = medicineSite;
	}


	@Column(name="medicine_unit")
	public String getMedicineUnit() {
		return this.medicineUnit;
	}

	public void setMedicineUnit(String medicineUnit) {
		this.medicineUnit = medicineUnit;
	}


	public String getMethod() {
		return this.method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="order_end_date")
	public Date getOrderEndDate() {
		return this.orderEndDate;
	}

	public void setOrderEndDate(Date orderEndDate) {
		this.orderEndDate = orderEndDate;
	}


	@Column(name="order_qty")
	public Long getOrderQty() {
		return this.orderQty;
	}

	public void setOrderQty(Long orderQty) {
		this.orderQty = orderQty;
	}


	@Column(name="order_qty_uom_code")
	public String getOrderQtyUomCode() {
		return this.orderQtyUomCode;
	}

	public void setOrderQtyUomCode(String orderQtyUomCode) {
		this.orderQtyUomCode = orderQtyUomCode;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="order_start_date")
	public Date getOrderStartDate() {
		return this.orderStartDate;
	}

	public void setOrderStartDate(Date orderStartDate) {
		this.orderStartDate = orderStartDate;
	}


	public Long getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}


	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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


	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
	@ManyToOne
	@JoinColumn(name = "spub_dtls_seqno")
	@JsonBackReference("SuborderTaperStatInt")
	public SpubDtlsInt getSpubDtlsInt() {
		return spubDtlsInt;
	}


	public void setSpubDtlsInt(SpubDtlsInt spubDtlsInt) {
		this.spubDtlsInt = spubDtlsInt;
	}
}