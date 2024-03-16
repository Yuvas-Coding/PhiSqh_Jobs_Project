package my.com.cmg.iwp.backend.model.integration.issue;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * The persistent class for the ph_issue_hdrs_int database table.
 * 
 */
@Entity
@Table(name = "t_issue_hdrs_int")
@XmlRootElement(name = "IssueHdrsInt")
@JsonIgnoreProperties(ignoreUnknown=true)
public class IssueHdrsInt implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long imhIntSeqno;
	private String extInhNo;
	private Long approvedBy;
	private Date approvedDate;
	private Long createdBy;
	private Date createdDate;
	private String editLabelFlag;
	private String fromFacilityCode;
	private String fromPtjCode;
	private String issueNo;
	private Date issueNoteCreatedDate;
	private String issueNoteNo;
	private String issueTo;
	private String issueType;
	private String issuerUnitCode;
	private String itemGroup;
	private String itemSubgroupCode;
	private Integer noOfItems;
	private String parameter1;
	private String parameter2;
	private BigDecimal parameter3;
	private BigDecimal parameter4;
	private Date parameter5;
	private String remarks;
	private Date requestDate;
	private String requestStatus;
	private String requestedBy;
	private String requestedExtCode;
	private String requestedUnitCode;
	private String status;
	private String toFacilityCode;
	private String toPtjCode;
	private BigDecimal totalAmt;
	private Long updatedBy;
	private Date updatedDate;
	private String sendFlag;
	private String indentCategory;
	private String indenterUnit;
	private String issuerUnit;
	private String issuerName;
	private Set<IssueDtlsInt> issueDtlsInts = new HashSet<IssueDtlsInt>(0);

	private String issuerDepartment;
	private String issuerDesignation;
	
	private String uomType;
	public IssueHdrsInt() {
	}

	@Id
	@SequenceGenerator(name = "PH_ISSUE_HDRS_INT_IMHINTSEQNO_GENERATOR", sequenceName = "t_issue_hdrs_int_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PH_ISSUE_HDRS_INT_IMHINTSEQNO_GENERATOR")
	@Column(name = "imh_int_seqno")
	public Long getImhIntSeqno() {
		return this.imhIntSeqno;
	}

	public void setImhIntSeqno(Long imhIntSeqno) {
		this.imhIntSeqno = imhIntSeqno;
	}

	@Column(name = "approved_by")
	public Long getApprovedBy() {
		return this.approvedBy;
	}

	public void setApprovedBy(Long approvedBy) {
		this.approvedBy = approvedBy;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "approved_date")
	public Date getApprovedDate() {
		return this.approvedDate;
	}

	public void setApprovedDate(Date approvedDate) {
		this.approvedDate = approvedDate;
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

	@Column(name = "edit_label_flag")
	public String getEditLabelFlag() {
		return this.editLabelFlag;
	}

	public void setEditLabelFlag(String editLabelFlag) {
		this.editLabelFlag = editLabelFlag;
	}

	@Column(name = "from_facility_code")
	public String getFromFacilityCode() {
		return this.fromFacilityCode;
	}

	public void setFromFacilityCode(String fromFacilityCode) {
		this.fromFacilityCode = fromFacilityCode;
	}

	@Column(name = "from_ptj_code")
	public String getFromPtjCode() {
		return this.fromPtjCode;
	}

	public void setFromPtjCode(String fromPtjCode) {
		this.fromPtjCode = fromPtjCode;
	}

	@Column(name = "issue_no")
	public String getIssueNo() {
		return this.issueNo;
	}

	public void setIssueNo(String issueNo) {
		this.issueNo = issueNo;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "issue_note_created_date")
	public Date getIssueNoteCreatedDate() {
		return this.issueNoteCreatedDate;
	}

	public void setIssueNoteCreatedDate(Date issueNoteCreatedDate) {
		this.issueNoteCreatedDate = issueNoteCreatedDate;
	}

	@Column(name = "issue_note_no")
	public String getIssueNoteNo() {
		return this.issueNoteNo;
	}

	public void setIssueNoteNo(String issueNoteNo) {
		this.issueNoteNo = issueNoteNo;
	}

	@Column(name = "issue_to")
	public String getIssueTo() {
		return this.issueTo;
	}

	public void setIssueTo(String issueTo) {
		this.issueTo = issueTo;
	}

	@Column(name = "issue_type")
	public String getIssueType() {
		return this.issueType;
	}

	public void setIssueType(String issueType) {
		this.issueType = issueType;
	}

	@Column(name = "issuer_unit_code")
	public String getIssuerUnitCode() {
		return this.issuerUnitCode;
	}

	public void setIssuerUnitCode(String issuerUnitCode) {
		this.issuerUnitCode = issuerUnitCode;
	}

	@Column(name = "item_group")
	public String getItemGroup() {
		return this.itemGroup;
	}

	public void setItemGroup(String itemGroup) {
		this.itemGroup = itemGroup;
	}

	@Column(name = "item_subgroup_code")
	public String getItemSubgroupCode() {
		return this.itemSubgroupCode;
	}

	public void setItemSubgroupCode(String itemSubgroupCode) {
		this.itemSubgroupCode = itemSubgroupCode;
	}

	@Column(name = "no_of_items")
	public Integer getNoOfItems() {
		return this.noOfItems;
	}

	public void setNoOfItems(Integer noOfItems) {
		this.noOfItems = noOfItems;
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

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "request_date")
	public Date getRequestDate() {
		return this.requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	@Column(name = "request_status")
	public String getRequestStatus() {
		return this.requestStatus;
	}

	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}

	@Column(name = "requested_by")
	public String getRequestedBy() {
		return this.requestedBy;
	}

	public void setRequestedBy(String requestedBy) {
		this.requestedBy = requestedBy;
	}

	@Column(name = "requested_ext_code")
	public String getRequestedExtCode() {
		return this.requestedExtCode;
	}

	public void setRequestedExtCode(String requestedExtCode) {
		this.requestedExtCode = requestedExtCode;
	}

	@Column(name = "requested_unit_code")
	public String getRequestedUnitCode() {
		return this.requestedUnitCode;
	}

	public void setRequestedUnitCode(String requestedUnitCode) {
		this.requestedUnitCode = requestedUnitCode;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "to_facility_code")
	public String getToFacilityCode() {
		return this.toFacilityCode;
	}

	public void setToFacilityCode(String toFacilityCode) {
		this.toFacilityCode = toFacilityCode;
	}

	@Column(name = "to_ptj_code")
	public String getToPtjCode() {
		return this.toPtjCode;
	}

	public void setToPtjCode(String toPtjCode) {
		this.toPtjCode = toPtjCode;
	}

	@Column(name = "total_amt")
	public BigDecimal getTotalAmt() {
		return this.totalAmt;
	}

	public void setTotalAmt(BigDecimal totalAmt) {
		this.totalAmt = totalAmt;
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

	// bi-directional many-to-one association to IssueDtlsInt
	@JsonManagedReference
	@OneToMany(mappedBy = "issueHdrsInt")
	@XmlElement
	public Set<IssueDtlsInt> getIssueDtlsInts() {
		return this.issueDtlsInts;
	}

	public void setIssueDtlsInts(Set<IssueDtlsInt> issueDtlsInts) {
		this.issueDtlsInts = issueDtlsInts;
	}

	@Column(name = "ext_inh_no", nullable = false)
	public String getExtInhNo() {
		return this.extInhNo;
	}

	public void setExtInhNo(String extInhNo) {
		this.extInhNo = extInhNo;
	}

	@Column(name = "send_flag")
	public String getSendFlag() {
		return sendFlag;
	}

	public void setSendFlag(String sendFlag) {
		this.sendFlag = sendFlag;
	}
	
	@Column(name = "indent_category")
	public String getIndentCategory() {
		return indentCategory;
	}

	public void setIndentCategory(String indentCategory) {
		this.indentCategory = indentCategory;
	}
	
	
	@Column(name = "indenter_unit")
	public String getIndenterUnit() {
		return indenterUnit;
	}

	public void setIndenterUnit(String indenterUnit) {
		this.indenterUnit = indenterUnit;
	}

	@Column(name = "issuer_unit")
	public String getIssuerUnit() {
		return issuerUnit;
	}

	public void setIssuerUnit(String issuerUnit) {
		this.issuerUnit = issuerUnit;
	}
	
	@Column(name = "issuer_name")
	public String getIssuerName() {
		return issuerName;
	}

	public void setIssuerName(String issuerName) {
		this.issuerName = issuerName;
	}
	
	@Column(name ="issuer_department")
	public String getIssuerDepartment() {
		return issuerDepartment;
	}

	public void setIssuerDepartment(String issuerDepartment) {
		this.issuerDepartment = issuerDepartment;
	}

	@Column(name ="issuer_designation")
	public String getIssuerDesignation() {
		return issuerDesignation;
	}

	public void setIssuerDesignation(String issuerDesignation) {
		this.issuerDesignation = issuerDesignation;
	}

	/**
	 * @return the uomType
	 */
	@Column(name = "uom_type", length = 20)
	public String getUomType() {
		return uomType;
	}

	/**
	 * @param uomType the uomType to set
	 */
	public void setUomType(String uomType) {
		this.uomType = uomType;
	}
	
	
}
