package my.com.cmg.iwp.backend.model.integration.returns;

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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
@Table(name="t_return_inter_hdrs_int")
@XmlRootElement(name="ReturnInterHdrsInt")
@JsonIgnoreProperties(ignoreUnknown=true)
public class ReturnInterHdrsInt implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private long rthIntSeqno;
	private String rthReturnNo;
	private String fromFacilityCode;
	private String fromPtjCode;
	private String toFacilityCode;
	private String toPtjCode;
	private String issueNo;
	private Date rthReturnDate;
	
	private Long createdBy;
	private Date createdDate;
	
	private Character rthAgainst;
	private String rthNoteNo;
	private String rthGoodsCond;
	private Character rthReason;
	private String rthRemarks;
	private String rthRejectReason;
	
	private Long updatedBy;
	private Date updatedDate;
	
	private BigDecimal rthTotalAmt;
	private int rthNoOfItems;
	private Character rthStatus;
	
	
	private String parameter1;
	private String parameter2;
	private BigDecimal parameter3;
	private BigDecimal parameter4;
	private Date parameter5;
	
	private Character rthNoteSent;
	private Character rthNotePrinted;
	private String returnType;
	private String notificationNumber;
	
	private String rthFromUnitCode;
	private String rthToUnitCode;
	
	private String sendFlag;
	private String status;
	private String itemGroup;
	private String itemSubgroupCode;
	private Set<ReturnInterDtlsInt> returnInterDtlInt=  new HashSet<ReturnInterDtlsInt>(0);
	private String uomType;
	
	@Id
	@SequenceGenerator(name="PH_RETURN_INTER_HDRS_INT_RTHINTSEQNO_GENERATOR", sequenceName="T_RETURN_INTER_HDRS_INT_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PH_RETURN_INTER_HDRS_INT_RTHINTSEQNO_GENERATOR")
	@Column(name="rth_int_seqno")
	public long getRthIntSeqno() {
		return rthIntSeqno;
	}
	
	public void setRthIntSeqno(long rthIntSeqno) {
		this.rthIntSeqno = rthIntSeqno;
	}
	
	@Column(name="rth_return_no")
	public String getRthReturnNo() {
		return rthReturnNo;
	}
	public void setRthReturnNo(String rthReturnNo) {
		this.rthReturnNo = rthReturnNo;
	}
	
	@Column(name="from_facility_code")
	public String getFromFacilityCode() {
		return fromFacilityCode;
	}
	public void setFromFacilityCode(String fromFacilityCode) {
		this.fromFacilityCode = fromFacilityCode;
	}
	@Column(name="from_ptj_code")
	public String getFromPtjCode() {
		return fromPtjCode;
	}
	public void setFromPtjCode(String fromPtjCode) {
		this.fromPtjCode = fromPtjCode;
	}
	
	@Column(name="to_facility_code")
	public String getToFacilityCode() {
		return toFacilityCode;
	}
	public void setToFacilityCode(String toFacilityCode) {
		this.toFacilityCode = toFacilityCode;
	}
	
	@Column(name="to_ptj_code")
	public String getToPtjCode() {
		return toPtjCode;
	}
	public void setToPtjCode(String toPtjCode) {
		this.toPtjCode = toPtjCode;
	}
	
	@Column(name="issue_no")
	public String getIssueNo() {
		return issueNo;
	}
	public void setIssueNo(String issueNo) {
		this.issueNo = issueNo;
	}
	
	@Column(name="rth_return_date")
	public Date getRthReturnDate() {
		return rthReturnDate;
	}
	public void setRthReturnDate(Date rthReturnDate) {
		this.rthReturnDate = rthReturnDate;
	}
	
	
	@Column(name="created_by")
	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name="created_date")
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name="rth_against")
	public Character getRthAgainst() {
		return rthAgainst;
	}
	public void setRthAgainst(Character rthAgainst) {
		this.rthAgainst = rthAgainst;
	}
	
	@Column(name="rth_note_no")
	public String getRthNoteNo() {
		return rthNoteNo;
	}
	public void setRthNoteNo(String rthNoteNo) {
		this.rthNoteNo = rthNoteNo;
	}
	
	@Column(name="rth_goods_cond")
	public String getRthGoodsCond() {
		return rthGoodsCond;
	}
	public void setRthGoodsCond(String rthGoodsCond) {
		this.rthGoodsCond = rthGoodsCond;
	}
	
	@Column(name="rth_reason")
	public Character getRthReason() {
		return rthReason;
	}
	public void setRthReason(Character rthReason) {
		this.rthReason = rthReason;
	}
	
	@Column(name="rth_remarks")
	public String getRthRemarks() {
		return rthRemarks;
	}
	public void setRthRemarks(String rthRemarks) {
		this.rthRemarks = rthRemarks;
	}
	
	@Column(name="rth_reject_reason")
	public String getRthRejectReason() {
		return rthRejectReason;
	}
	public void setRthRejectReason(String rthRejectReason) {
		this.rthRejectReason = rthRejectReason;
	}
	
	
	@Column(name="updated_by")
	public Long getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Column(name="updated_date")
	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Column(name="rth_total_amt")
	public BigDecimal getRthTotalAmt() {
		return rthTotalAmt;
	}
	public void setRthTotalAmt(BigDecimal rthTotalAmt) {
		this.rthTotalAmt = rthTotalAmt;
	}
	
	@Column(name="rth_no_of_items")
	public int getRthNoOfItems() {
		return rthNoOfItems;
	}
	public void setRthNoOfItems(int rthNoOfItems) {
		this.rthNoOfItems = rthNoOfItems;
	}
	
	@Column(name="rth_status")
	public Character getRthStatus() {
		return rthStatus;
	}
	public void setRthStatus(Character rthStatus) {
		this.rthStatus = rthStatus;
	}
	
	
	
	public String getParameter1() {
		return parameter1;
	}

	public void setParameter1(String parameter1) {
		this.parameter1 = parameter1;
	}

	public String getParameter2() {
		return parameter2;
	}

	public void setParameter2(String parameter2) {
		this.parameter2 = parameter2;
	}

	public BigDecimal getParameter3() {
		return parameter3;
	}

	public void setParameter3(BigDecimal parameter3) {
		this.parameter3 = parameter3;
	}

	public BigDecimal getParameter4() {
		return parameter4;
	}

	public void setParameter4(BigDecimal parameter4) {
		this.parameter4 = parameter4;
	}

	public Date getParameter5() {
		return parameter5;
	}

	public void setParameter5(Date parameter5) {
		this.parameter5 = parameter5;
	}

	@Column(name="rth_note_sent")
	public Character getRthNoteSent() {
		return rthNoteSent;
	}
	public void setRthNoteSent(Character rthNoteSent) {
		this.rthNoteSent = rthNoteSent;
	}
	
	@Column(name="rth_note_printed")
	public Character getRthNotePrinted() {
		return rthNotePrinted;
	}
	public void setRthNotePrinted(Character rthNotePrinted) {
		this.rthNotePrinted = rthNotePrinted;
	}
	
	@Column(name="return_type")
	public String getReturnType() {
		return returnType;
	}
	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}
	
	@Column(name="notification_number")
	public String getNotificationNumber() {
		return notificationNumber;
	}
	public void setNotificationNumber(String notificationNumber) {
		this.notificationNumber = notificationNumber;
	}
	
	@Column(name="rth_from_unit_code")
	public String getRthFromUnitCode() {
		return rthFromUnitCode;
	}
	public void setRthFromUnitCode(String rthFromUnitCode) {
		this.rthFromUnitCode = rthFromUnitCode;
	}
	
	@Column(name="rth_to_unit_code")
	public String getRthToUnitCode() {
		return rthToUnitCode;
	}
	public void setRthToUnitCode(String rthToUnitCode) {
		this.rthToUnitCode = rthToUnitCode;
	}
	
	
	@Column(name="send_flag")
	public String getSendFlag() {
		return sendFlag;
	}

	public void setSendFlag(String sendFlag) {
		this.sendFlag = sendFlag;
	}

	@Column(name="status")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Column(name="item_group")
	public String getItemGroup() {
		return itemGroup;
	}
	public void setItemGroup(String itemGroup) {
		this.itemGroup = itemGroup;
	}

	@Column(name="item_subgroup_code")
	public String getItemSubgroupCode() {
		return itemSubgroupCode;
	}

	public void setItemSubgroupCode(String itemSubgroupCode) {
		this.itemSubgroupCode = itemSubgroupCode;
	}

	@OneToMany(mappedBy="returnInterHdrsInt")
	@XmlElement
	@JsonManagedReference
	public Set<ReturnInterDtlsInt> getReturnInterDtlInt() {
		return returnInterDtlInt;
	}

	public void setReturnInterDtlInt(Set<ReturnInterDtlsInt> returnInterDtlInt) {
		this.returnInterDtlInt = returnInterDtlInt;
	}

	@Column(name="uom_type")
	public String getUomType() {
		return uomType;
	}

	public void setUomType(String uomType) {
		this.uomType = uomType;
	}
	
	
}
