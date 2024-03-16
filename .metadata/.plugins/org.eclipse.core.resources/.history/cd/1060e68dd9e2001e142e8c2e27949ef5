package my.com.cmg.iwp.backend.model.sdr;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_SPL_DRUG_REQUEST_ARC_INT")
public class SpecialDrugRequestOrderArc implements Serializable{
	
	
	private long sdrOrderSeqno;
	private String hosRequestNo;
	private String hospitalName;
	private Date requestDate;
	private String bpfRegisterNo;
	private byte[] pbkdAttachment1;
	private byte[] pbkdAttachment2;
	private byte[] pbkdAttachment3;
	private byte[] pbkdAttachment4;
	private byte[] pbkdAttachment5;
	private byte[] kpkAttachment;
	private byte[] cpoAttachment;
	private String attachment1Name;
	private String attachment2Name;
	private String attachment3Name;
	private String attachment4Name;
	private String attachment5Name;
	private String approvalattachment_name;
	private String kpkattachment_name;
	
	
	public SpecialDrugRequestOrderArc() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SpecialDrugRequestOrderArc(long sdrOrderSeqno, String hosRequestNo, String hospitalName, Date requestDate,
			String bpfRegisterNo, byte[] pbkdAttachment1, byte[] pbkdAttachment2, byte[] pbkdAttachment3,
			byte[] pbkdAttachment4, byte[] pbkdAttachment5, byte[] kpkAttachment, byte[] cpoAttachment,
			String attachment1Name, String attachment2Name, String attachment3Name, String attachment4Name,
			String attachment5Name, String approvalattachment_name, String kpkattachment_name) {
		this.sdrOrderSeqno = sdrOrderSeqno;
		this.hosRequestNo = hosRequestNo;
		this.hospitalName = hospitalName;
		this.requestDate = requestDate;
		this.bpfRegisterNo = bpfRegisterNo;
		this.pbkdAttachment1 = pbkdAttachment1;
		this.pbkdAttachment2 = pbkdAttachment2;
		this.pbkdAttachment3 = pbkdAttachment3;
		this.pbkdAttachment4 = pbkdAttachment4;
		this.pbkdAttachment5 = pbkdAttachment5;
		this.kpkAttachment = kpkAttachment;
		this.cpoAttachment = cpoAttachment;
		this.attachment1Name = attachment1Name;
		this.attachment2Name = attachment2Name;
		this.attachment3Name = attachment3Name;
		this.attachment4Name = attachment4Name;
		this.attachment5Name = attachment5Name;
		this.approvalattachment_name = approvalattachment_name;
		this.kpkattachment_name = kpkattachment_name;
	}

	@Id
	@Column(name = "SDR_ORDER_SEQNO")
	public long getSdrOrderSeqno() {
		return sdrOrderSeqno;
	}

	public void setSdrOrderSeqno(long sdrOrderSeqno) {
		this.sdrOrderSeqno = sdrOrderSeqno;
	}

	@Column(name = "HOS_REQUEST_NO")
	public String getHosRequestNo() {
		return hosRequestNo;
	}

	public void setHosRequestNo(String hosRequestNo) {
		this.hosRequestNo = hosRequestNo;
	}

	@Column(name = "HOSPITAL_NAME")
	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "REQUEST_DATE")
	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	@Column(name = "BPF_REGISTER_NO")
	public String getBpfRegisterNo() {
		return bpfRegisterNo;
	}

	public void setBpfRegisterNo(String bpfRegisterNo) {
		this.bpfRegisterNo = bpfRegisterNo;
	}

	@Column(name = "PBKD_ATTACHMENT1")
	public byte[] getPbkdAttachment1() {
		return pbkdAttachment1;
	}

	public void setPbkdAttachment1(byte[] pbkdAttachment1) {
		this.pbkdAttachment1 = pbkdAttachment1;
	}

	@Column(name = "PBKD_ATTACHMENT2")
	public byte[] getPbkdAttachment2() {
		return pbkdAttachment2;
	}

	public void setPbkdAttachment2(byte[] pbkdAttachment2) {
		this.pbkdAttachment2 = pbkdAttachment2;
	}

	@Column(name = "PBKD_ATTACHMENT3")
	public byte[] getPbkdAttachment3() {
		return pbkdAttachment3;
	}

	public void setPbkdAttachment3(byte[] pbkdAttachment3) {
		this.pbkdAttachment3 = pbkdAttachment3;
	}

	@Column(name = "PBKD_ATTACHMENT4")
	public byte[] getPbkdAttachment4() {
		return pbkdAttachment4;
	}

	public void setPbkdAttachment4(byte[] pbkdAttachment4) {
		this.pbkdAttachment4 = pbkdAttachment4;
	}

	@Column(name = "PBKD_ATTACHMENT5")
	public byte[] getPbkdAttachment5() {
		return pbkdAttachment5;
	}

	public void setPbkdAttachment5(byte[] pbkdAttachment5) {
		this.pbkdAttachment5 = pbkdAttachment5;
	}

	@Column(name = "KPK_ATTACHMENT")
	public byte[] getKpkAttachment() {
		return kpkAttachment;
	}

	public void setKpkAttachment(byte[] kpkAttachment) {
		this.kpkAttachment = kpkAttachment;
	}

	@Column(name = "CPO_ATTACHMENT")
	public byte[] getCpoAttachment() {
		return cpoAttachment;
	}

	public void setCpoAttachment(byte[] cpoAttachment) {
		this.cpoAttachment = cpoAttachment;
	}

	@Column(name="ATTACHMENT1_NAME")
	public String getAttachment1Name() {
		return attachment1Name;
	}

	public void setAttachment1Name(String attachment1Name) {
		this.attachment1Name = attachment1Name;
	}

	@Column(name="ATTACHMENT2_NAME")
	public String getAttachment2Name() {
		return attachment2Name;
	}

	public void setAttachment2Name(String attachment2Name) {
		this.attachment2Name = attachment2Name;
	}

	@Column(name="ATTACHMENT3_NAME")
	public String getAttachment3Name() {
		return attachment3Name;
	}

	public void setAttachment3Name(String attachment3Name) {
		this.attachment3Name = attachment3Name;
	}

	@Column(name="ATTACHMENT4_NAME")
	public String getAttachment4Name() {
		return attachment4Name;
	}

	public void setAttachment4Name(String attachment4Name) {
		this.attachment4Name = attachment4Name;
	}

	@Column(name="ATTACHMENT5_NAME")
	public String getAttachment5Name() {
		return attachment5Name;
	}

	public void setAttachment5Name(String attachment5Name) {
		this.attachment5Name = attachment5Name;
	}
	@Column(name="APPROVALATTACHMENT_NAME")
	public String getApprovalattachment_name() {
		return approvalattachment_name;
	}

	public void setApprovalattachment_name(String approvalattachment_name) {
		this.approvalattachment_name = approvalattachment_name;
	}

	@Column(name="KPKATTACHMENT_NAME")
	public String getKpkattachment_name() {
		return kpkattachment_name;
	}

	public void setKpkattachment_name(String kpkattachment_name) {
		this.kpkattachment_name = kpkattachment_name;
	}	
	
}
