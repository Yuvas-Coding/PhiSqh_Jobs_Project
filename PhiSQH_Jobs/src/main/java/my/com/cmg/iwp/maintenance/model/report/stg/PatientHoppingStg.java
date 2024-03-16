package my.com.cmg.iwp.maintenance.model.report.stg;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "t_patient_hopping_stg")
public class PatientHoppingStg implements java.io.Serializable {
	private long patientHoppingSeqno;
	private String patientName;
	private String patientIdNo;
	private String patientMrn;
	private String facilityName;
	private Date orderDate;
	private String orderType;
	private String drugName;
	private Date dispensedDate;
	private String dispQtyUom;
	private long createdBy;

	public PatientHoppingStg() {

	}
	
	@Id
	@Column(name = "patient_hopping_seqno", unique = true, nullable = false)
	public long getPatientHoppingSeqno() {
		return patientHoppingSeqno;
	}
	
	public void setPatientHoppingSeqno(long patientHoppingSeqno) {
		this.patientHoppingSeqno = patientHoppingSeqno;
	}

	@Column(name = "patient_name", length = 130)
	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	@Column(name = "patient_idno", length = 25)
	public String getPatientIdNo() {
		return patientIdNo;
	}

	public void setPatientIdNo(String patientIdNo) {
		this.patientIdNo = patientIdNo;
	}

	@Column(name = "patient_mrn", length = 20)
	public String getPatientMrn() {
		return patientMrn;
	}

	public void setPatientMrn(String patientMrn) {
		this.patientMrn = patientMrn;
	}

	@Column(name = "facility_name", length = 50)
	public String getFacilityName() {
		return facilityName;
	}

	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "order_date", nullable = false, length = 29)
	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	@Column(name = "order_type", length = 500)
	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	@Column(name = "drug_name", length = 250)
	public String getDrugName() {
		return drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dispense_date", nullable = false, length = 29)
	public Date getDispensedDate() {
		return dispensedDate;
	}

	public void setDispensedDate(Date dispensedDate) {
		this.dispensedDate = dispensedDate;
	}

	@Column(name = "disp_qty_uom", length = 50)
	public String getDispQtyUom() {
		return dispQtyUom;
	}

	public void setDispQtyUom(String dispQtyUom) {
		this.dispQtyUom = dispQtyUom;
	}
	

	@Column(name = "created_by", nullable = false)
	public long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}

}
