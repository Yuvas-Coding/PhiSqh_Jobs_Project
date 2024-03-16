package my.com.cmg.iwp.backend.model.sdr;

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

import my.com.cmg.iwp.maintenance.model.GetterBaseEntity;

@Entity
@Table(name = "t_spl_drug_additional_doc_int")

public class SpecialDrugAdditionalDoc extends GetterBaseEntity{

	private Long addDocIntSeqno = Long.MIN_VALUE;
	private Long addDocSeqno;
	private String hosRequestNo;
	private String title;
	private String description;
	private byte[] attachment;
	private String attachmentName;
	private String facilityCode;
	private String ptjCode;
	private String createdFullname;
	private SpecialDrugRequestOrder specialDrugRequestOrder;
	
	@Id
	@Column(name = "add_doc_int_seqno", unique = true, nullable = false, precision = 38, scale = 0)
	@SequenceGenerator(name = "addDocIntSeqno", sequenceName = "t_sdr_add_doc_int_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "addDocIntSeqno")
	public Long getAddDocIntSeqno() {
		return addDocIntSeqno;
	}
	public void setAddDocIntSeqno(Long addDocIntSeqno) {
		this.addDocIntSeqno = addDocIntSeqno;
	}
	
	@Column(name = "title")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Column(name = "description")
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name = "attachment")
	public byte[] getAttachment() {
		return attachment;
	}
	public void setAttachment(byte[] attachment) {
		this.attachment = attachment;
	}
	
	@Column(name = "attachment_name")
	public String getAttachmentName() {
		return attachmentName;
	}
	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}
	
	@Column(name = "hos_request_no")
	public String getHosRequestNo() {
		return hosRequestNo;
	}
	public void setHosRequestNo(String hosRequestNo) {
		this.hosRequestNo = hosRequestNo;
	}
	
	@Column(name = "facility_code")
	public String getFacilityCode() {
		return facilityCode;
	}
	public void setFacilityCode(String facilityCode) {
		this.facilityCode = facilityCode;
	}

	@Column(name  = "ptj_code")
	public String getPtjCode() {
		return ptjCode;
	}
	public void setPtjCode(String ptjCode) {
		this.ptjCode = ptjCode;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SDR_ORDER_SEQNO", nullable = false)
	public SpecialDrugRequestOrder getSpecialDrugRequestOrder() {
		return specialDrugRequestOrder;
	}
	public void setSpecialDrugRequestOrder(SpecialDrugRequestOrder specialDrugRequestOrder) {
		this.specialDrugRequestOrder = specialDrugRequestOrder;
	}
	
	@Column(name = "add_doc_seqno")
	public Long getAddDocSeqno() {
		return addDocSeqno;
	}
	public void setAddDocSeqno(Long addDocSeqno) {
		this.addDocSeqno = addDocSeqno;
	}
	@Column(name = "created_fullname")
	public String getCreatedFullname() {
		return createdFullname;
	}
	public void setCreatedFullname(String createdFullname) {
		this.createdFullname = createdFullname;
	}
}
