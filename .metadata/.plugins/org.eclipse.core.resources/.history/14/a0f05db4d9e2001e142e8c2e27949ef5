package my.com.cmg.iwp.maintenance.model.report.stg;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "phispat.t_patients_summary")
public class PatientSummary implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	private long patinetSummarySeq;
	private String patientName;
	private String patientIdNo;
	
	@Id
	@Column(name = "patinet_summary_seq", unique = true, nullable = false)
	public long getPatinetSummarySeq() {
		return patinetSummarySeq;
	}
	
	public void setPatinetSummarySeq(long patinetSummarySeq) {
		this.patinetSummarySeq = patinetSummarySeq;
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
	
}
