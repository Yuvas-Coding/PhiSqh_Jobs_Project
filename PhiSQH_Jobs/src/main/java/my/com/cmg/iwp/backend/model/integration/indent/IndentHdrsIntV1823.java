package my.com.cmg.iwp.backend.model.integration.indent;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;



/**
 * The persistent class for the ph_indent_hdrs_int database table.
 * 
 */
@Entity
@XmlRootElement(name = "IndentHdrsInt")
@JsonIgnoreProperties(ignoreUnknown=true)
public class IndentHdrsIntV1823 implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long indentHdrsSeqno;
	private String approvalRemarks;
	private String approvalStatus;
	private Long approvedBy;
	private Date approvedDate;
	private Long createdBy;
	private Date createdDate;
	private Date dateFrom;
	private Date dateTo;
	private String fromFacilityCode;
	private String fromPtjCode;
	private String fromUnitCode;
	private Long indentBy;
	private Date indentDate;
	private String indentSent;
	private String indentStatus;
	private String indentType;
	private String indenterUnitCode;
	private String indenterUnitName;
	private String itemGroup;
	private Integer noOfItems;
	private String parameter1;
	private String parameter2;
	private BigDecimal parameter3;
	private BigDecimal parameter4;
	private Date parameter5;
	private Long pendingQty;
	private String remarks;
	private String requestIndentType;
	private String sendApprovalFlag;
	private String sendFlag;
	private String subItemGroup;
	private String toExtUnitCode;
	private String toFacilityCode;
	private String toPtjCode;
	private Long updatedBy;
	private Date updatedDate;
	private String urgent;
	private String urgentFlag;
	private String extInhNo;
	private String updateFlag;
	private List<IndentDtlsIntV1823> indentDtlsInts = new ArrayList<IndentDtlsIntV1823>();
	private String indentCategory;
	private String indenterName;
	private String indenterUnit;
	
	private String indenterDepartment;
	private String indenterDesignation;
	private String rejectRemark;
	
	public IndentHdrsIntV1823() {
	}

	@Id
	@SequenceGenerator(name = "PH_INDENT_HDRS_INT_INDENTHDRSSEQNO_GENERATOR", sequenceName = "t_indent_hdrs_int_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PH_INDENT_HDRS_INT_INDENTHDRSSEQNO_GENERATOR")
	@Column(name = "indent_hdrs_seqno", unique = true, nullable = false)
	public Long getIndentHdrsSeqno() {
		return this.indentHdrsSeqno;
	}

	public void setIndentHdrsSeqno(Long indentHdrsSeqno) {
		this.indentHdrsSeqno = indentHdrsSeqno;
	}

	@Column(name = "approval_remarks", length = 50)
	public String getApprovalRemarks() {
		return this.approvalRemarks;
	}

	public void setApprovalRemarks(String approvalRemarks) {
		this.approvalRemarks = approvalRemarks;
	}

	@Column(name = "approval_status", length = 20)
	public String getApprovalStatus() {
		return this.approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	@Column(name = "approved_by")
	public Long getApprovedBy() {
		return this.approvedBy;
	}

	public void setApprovedBy(Long approvedBy) {
		this.approvedBy = approvedBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "approved_date")
	public Date getApprovedDate() {
		return this.approvedDate;
	}

	public void setApprovedDate(Date approvedDate) {
		this.approvedDate = approvedDate;
	}

	@Column(name = "created_by", nullable = false)
	public Long getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", nullable = false)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "date_from")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDateFrom() {
		return this.dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	@Column(name = "date_to")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDateTo() {
		return this.dateTo;
	}

	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}

	@Column(name = "from_facility_code", length = 12)
	public String getFromFacilityCode() {
		return this.fromFacilityCode;
	}

	public void setFromFacilityCode(String fromFacilityCode) {
		this.fromFacilityCode = fromFacilityCode;
	}

	@Column(name = "from_ptj_code", length = 20)
	public String getFromPtjCode() {
		return this.fromPtjCode;
	}

	public void setFromPtjCode(String fromPtjCode) {
		this.fromPtjCode = fromPtjCode;
	}

	@Column(name = "from_unit_code", length = 10)
	public String getFromUnitCode() {
		return this.fromUnitCode;
	}

	public void setFromUnitCode(String fromUnitCode) {
		this.fromUnitCode = fromUnitCode;
	}

	@Column(name = "indent_by")
	public Long getIndentBy() {
		return this.indentBy;
	}

	public void setIndentBy(Long indentBy) {
		this.indentBy = indentBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "indent_date")
	public Date getIndentDate() {
		return this.indentDate;
	}

	public void setIndentDate(Date indentDate) {
		this.indentDate = indentDate;
	}

	@Column(name = "indent_sent", length = 20)
	public String getIndentSent() {
		return this.indentSent;
	}

	public void setIndentSent(String indentSent) {
		this.indentSent = indentSent;
	}

	@Column(name = "indent_status", length = 20)
	public String getIndentStatus() {
		return this.indentStatus;
	}

	public void setIndentStatus(String indentStatus) {
		this.indentStatus = indentStatus;
	}

	@Column(name = "indent_type", nullable = false, length = 1)
	public String getIndentType() {
		return this.indentType;
	}

	public void setIndentType(String indentType) {
		this.indentType = indentType;
	}

	@Column(name = "indenter_unit_code", length = 20)
	public String getIndenterUnitCode() {
		return this.indenterUnitCode;
	}

	public void setIndenterUnitCode(String indenterUnitCode) {
		this.indenterUnitCode = indenterUnitCode;
	}

	@Column(name = "indenter_unit_name", length = 100)
	public String getIndenterUnitName() {
		return this.indenterUnitName;
	}

	public void setIndenterUnitName(String indenterUnitName) {
		this.indenterUnitName = indenterUnitName;
	}

	@Column(name = "item_group", length = 20)
	public String getItemGroup() {
		return this.itemGroup;
	}

	public void setItemGroup(String itemGroup) {
		this.itemGroup = itemGroup;
	}

	@Column(name = "no_of_items")
	public Integer getNoOfItems() {
		return this.noOfItems;
	}

	public void setNoOfItems(Integer noOfItems) {
		this.noOfItems = noOfItems;
	}

	@Column(length = 100)
	public String getParameter1() {
		return this.parameter1;
	}

	public void setParameter1(String parameter1) {
		this.parameter1 = parameter1;
	}

	@Column(length = 100)
	public String getParameter2() {
		return this.parameter2;
	}

	public void setParameter2(String parameter2) {
		this.parameter2 = parameter2;
	}

	@Column(precision = 8, scale = 4)
	public BigDecimal getParameter3() {
		return this.parameter3;
	}

	public void setParameter3(BigDecimal parameter3) {
		this.parameter3 = parameter3;
	}

	@Column(precision = 8, scale = 4)
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

	@Column(name = "pending_qty")
	public Long getPendingQty() {
		return this.pendingQty;
	}

	public void setPendingQty(Long pendingQty) {
		this.pendingQty = pendingQty;
	}

	@Column(length = 80)
	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Column(name = "request_indent_type", length = 20)
	public String getRequestIndentType() {
		return this.requestIndentType;
	}

	public void setRequestIndentType(String requestIndentType) {
		this.requestIndentType = requestIndentType;
	}

	@Column(name = "send_approval_flag")
	public String getSendApprovalFlag() {
		return this.sendApprovalFlag;
	}

	public void setSendApprovalFlag(String sendApprovalFlag) {
		this.sendApprovalFlag = sendApprovalFlag;
	}

	@Column(name = "send_flag")
	public String getSendFlag() {
		return this.sendFlag;
	}

	public void setSendFlag(String sendFlag) {
		this.sendFlag = sendFlag;
	}

	@Column(name = "sub_item_group", length = 20)
	public String getSubItemGroup() {
		return this.subItemGroup;
	}

	public void setSubItemGroup(String subItemGroup) {
		this.subItemGroup = subItemGroup;
	}

	@Column(name = "to_ext_unit_code", length = 10)
	public String getToExtUnitCode() {
		return this.toExtUnitCode;
	}

	public void setToExtUnitCode(String toExtUnitCode) {
		this.toExtUnitCode = toExtUnitCode;
	}

	@Column(name = "to_facility_code", length = 12)
	public String getToFacilityCode() {
		return this.toFacilityCode;
	}

	public void setToFacilityCode(String toFacilityCode) {
		this.toFacilityCode = toFacilityCode;
	}

	@Column(name = "to_ptj_code", length = 20)
	public String getToPtjCode() {
		return this.toPtjCode;
	}

	public void setToPtjCode(String toPtjCode) {
		this.toPtjCode = toPtjCode;
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

	public String getUrgent() {
		return this.urgent;
	}

	public void setUrgent(String urgent) {
		this.urgent = urgent;
	}

	@Column(name = "urgent_flag")
	public String getUrgentFlag() {
		return this.urgentFlag;
	}

	public void setUrgentFlag(String urgentFlag) {
		this.urgentFlag = urgentFlag;
	}

	// bi-directional many-to-one association to IndentDtlsInt
	@OneToMany(mappedBy = "indentHdrsInt")
	@XmlElement
	@JsonManagedReference
	public List<IndentDtlsIntV1823> getIndentDtlsInts() {
		return this.indentDtlsInts;
	}

	public void setIndentDtlsInts(List<IndentDtlsIntV1823> indentDtlsInts) {
		this.indentDtlsInts = indentDtlsInts;
	}

	@Column(name = "ext_inh_no", nullable = false)
	public String getExtInhNo() {
		return this.extInhNo;
	}

	public void setExtInhNo(String extInhNo) {
		this.extInhNo = extInhNo;
	}

	@Column(name="update_flag")
	public String getUpdateFlag() {
		return this.updateFlag;
	}

	public void setUpdateFlag(String updateFlag) {
		this.updateFlag = updateFlag;
	}

	@Column(name = "indent_category")
	public String getIndentCategory() {
		return indentCategory;
	}

	public void setIndentCategory(String indentCategory) {
		this.indentCategory = indentCategory;
	}
	
	@Column(name = "indenter_name")
	public String getIndenterName() {
		return indenterName;
	}

	public void setIndenterName(String indenterName) {
		this.indenterName = indenterName;
	}
	
	@Column(name ="indenter_unit")
	public String getIndenterUnit() {
		return indenterUnit;
	}

	public void setIndenterUnit(String indenterUnit) {
		this.indenterUnit = indenterUnit;
	}
	
	@Column(name ="indenter_department")
	public String getIndenterDepartment() {
		return indenterDepartment;
	}

	public void setIndenterDepartment(String indenterDepartment) {
		this.indenterDepartment = indenterDepartment;
	}

	@Column(name ="indenter_designation")
	public String getIndenterDesignation() {
		return indenterDesignation;
	}

	public void setIndenterDesignation(String indenterDesignation) {
		this.indenterDesignation = indenterDesignation;
	}
	
	@Column(name = "reject_remark", length = 500)
	public String getRejectRemark() {
	    return rejectRemark;
	}

	public void setRejectRemark(String rejectRemark) {
	    this.rejectRemark = rejectRemark;
	}
}