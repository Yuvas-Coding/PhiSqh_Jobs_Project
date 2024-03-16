package my.com.cmg.iwp.backend.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import my.com.cmg.iwp.maintenance.model.SecRole;
import my.com.cmg.iwp.maintenance.model.SecUser;

/**
 * @author TAPAN KUMAR SABAT
 *
 */
@Entity
@Table(name = "t_task_lists", uniqueConstraints = @UniqueConstraint(columnNames = {"tl_task_no", "tl_trx_type", "tl_task_status", "tl_task_done" }))
public class TaskLists implements Serializable
{
	
	/**TaskLists HIBERNATE OBJECT Attribute Names**/
	public static final String H_TABLE_TASKLISTS = "TaskLists";
	public static final String D_TABLE_TASKLISTS = "t_task_lists";
	
	public static final String H_COL_TLSEQNO = "tlSeqNo";
	public static final String D_COL_TLSEQNO = "tl_seqno";
	
	public static final String H_COL_TLTASKNO = "tlTaskNo";
	public static final String D_COL_TLTASKNO = "tl_task_no";
	
	public static final String D_COL_TLDOCSEQNO = "tl_doc_seqno";
	public static final String H_COL_TLDOCSEQNO = "tlDocSeqNo";
	
	public static final String D_COL_TLRECDATETIME = "tl_rec_date_time";
	public static final String H_COL_TLRECDATETIME = "tlRecDateTime";
	
	public static final String D_COL_TLRECUSERID = "tl_rec_user_id";
	public static final String H_COL_TLRECUSERID = "tlRecUserId";
	
	public static final String D_COL_TLSENUSERID = "tl_sen_user_id";
	public static final String H_COL_TLSENUSERID = "tlSenUserId";
	
	public static final String D_COL_TLEVENTTYPE = "tl_event_type";
	public static final String H_COL_TLEVENTTYPE = "tlEventType";
	
	public static final String D_COL_TLSUBJECT = "tl_subject";
	public static final String H_COL_TLSUBJECT = "tlSubject";
	
	public static final String D_COL_TLTASKDONE = "tl_task_done";
	public static final String H_COL_TLTASKDONE = "tlTaskDone";
	
	public static final String D_COL_TLACKNOWLEDGE = "tl_acknowledge";
	public static final String H_COL_TLACKNOWLEDGE = "tlAcknowledge";
	
	public static final String D_COL_TLDOCNO = "tl_doc_no";
	public static final String H_COL_TLDOCNO = "tlDocNo";
	
	public static final String D_COL_TLTRANSACTIONTYPE = "tl_transaction_type";
	public static final String H_COL_TLTRANSACTIONTYPE = "tlTransactionType";
	
	public static final String D_COL_TLSTATUS = "tl_status";
	public static final String H_COL_TLSTATUS = "tlStatus";
	
	public static final String D_COL_TLSENTAPPROVALFLAG = "tl_sent_approval_flag";
	public static final String H_COL_TLSENTAPPROVALFLAG = "tlSentApprovalFlag";
	
	public static final String D_COL_TLTRXTYPE = "tl_trx_type";
	public static final String H_COL_TLTRXTYPE = "tlTrxType";
	
	public static final String D_COL_TLTRXSEQNO = "tl_trx_seqno";
	public static final String H_COL_TLTRXSEQNO = "tlTrxSeqNo";
	
	public static final String D_COL_TLTASKSTATUS = "tl_task_status";
	public static final String H_COL_TLTASKSTATUS = "tlTaskStatus";
	
	public static final String D_COL_TLURL = "tl_url";
	public static final String H_COL_TLURL = "tlURL";
	
	public static final String D_COL_TLFACILITYCODE = "tl_facility_code";
	public static final String H_COL_TLFACILITYCODE = "tlFacilityCode";
	
	public static final String D_COL_TLPTJCODE = "tl_ptj_code";
	public static final String H_COL_TLPTJCODE = "tlPTJCode";
	
	public static final String H_COL_ACTIVEFLAG = "activeFlag";
	public static final String D_COL_ACTIVEFLAG = "active_flag";
	
	
	@Id
	@SequenceGenerator(name="t_task_list_seq", sequenceName="t_task_lists_seq", allocationSize = 1)
	@GeneratedValue(generator="t_task_list_seq")
	@Column(name = "tl_seqno" ,nullable = false, length = 38)
	private Long tlSeqNo;
	
	@Column(name = "tl_task_no", nullable = false, length = 25)
	private String tlTaskNo;
	
	@Column(name = "tl_doc_seqno" ,nullable = false, length = 38)
	private Long tlDocSeqNo;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "tl_rec_date_time" , nullable = false, length = 29)
	private Date tlRecDateTime;
	
	@Column(name = "tl_rec_user_id" ,length = 15)
	private String tlRecUserId;
	
	@Column(name = "tl_sen_user_id" ,length = 15)
	private String tlSenUserId;
	
	@Column(name = "tl_event_type" ,length = 35)
	private String tlEventType;
	
	@Column(name = "tl_subject" ,length = 80)
	private String tlSubject;
	
	@Column(name = "tl_task_done" ,nullable = false, length = 1)
	private Character tlTaskDone;
	
	@Column(name = "tl_acknowledge" , nullable = false, length = 1)
	private Character tlAcknowledge;
	
	@Column(name = "tl_doc_no" ,length = 25)
	private String tlDocNo;
	
	@Column(name = "tl_transaction_type" ,length = 38)
	private String tlTransactionType;
	
	@Column(name = "tl_status" ,length = 200)
	private String tlStatus;
	
	@Column(name = "tl_sent_approval_flag" ,length = 1)
	private Character tlSentApprovalFlag;
	
	@Column(name = "tl_trx_type" ,length = 50)
	private String tlTrxType;
	
	@Column(name = "tl_trx_seqno" ,length = 38)
	private Long tlTrxSeqNo;
	
	@Column(name = "tl_task_status" ,length = 20)
	private String tlTaskStatus;
	
	@Column(name = "tl_url" ,length = 200)
	private String tlURL;
	
	@Column(name = "tl_facility_code", nullable = false, length = 10)
	private String tlFacilityCode;
	
	@Column(name = "tl_ptj_code", length = 20)
	private String tlPTJCode;
	
	@Column(name="tl_rec_role_id")
	private Long tlRecRoleId;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tl_rec_role_id", referencedColumnName="rol_id", insertable=false, updatable=false)
	private SecRole recRole;
	
	@Column(name="active_flag" ,nullable = false, length =1)
	private String activeFlag;
	
	@Column(name="parameter1" ,length =100)
	private String parameter1;
	
	@Column(name="parameter2" ,length =100)
	private String parameter2;
	
	@Column(name="parameter3" , precision = 8, scale = 4)
	private String parameter3;
	
	@Column(name="parameter4" , precision = 8, scale = 4)
	private String parameter4;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "parameter5", length = 13)
	private Date parameter5;
	
	@ManyToOne()
	@JoinColumn(name = "created_by")
	private SecUser createdBy;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", nullable = false, length = 29)
	private Date createdDate;
	
	@Column(name="updated_by")
	private Long updatedBy;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_date", nullable = false, length = 29)
	private Date updatedDate;	
	
	/**
	 * CONSTRUCTORS 
	 */
	public TaskLists() {
		super();
	}

	/**
	 * 
	 * ACCESSORS AND MUTATORS
	 * 
	 */
	public Long getTlSeqNo() {
		return tlSeqNo;
	}

	public void setTlSeqNo(Long tlSeqNo) {
		this.tlSeqNo = tlSeqNo;
	}

	public String getTlTaskNo() {
		return tlTaskNo;
	}

	public void setTlTaskNo(String tlTaskNo) {
		this.tlTaskNo = tlTaskNo;
	}

	public Long getTlDocSeqNo() {
		return tlDocSeqNo;
	}

	public void setTlDocSeqNo(Long tlDocSeqNo) {
		this.tlDocSeqNo = tlDocSeqNo;
	}

	public Date getTlRecDateTime() {
		return tlRecDateTime;
	}

	public void setTlRecDateTime(Date tlRecDateTime) {
		this.tlRecDateTime = tlRecDateTime;
	}

	public String getTlRecUserId() {
		return tlRecUserId;
	}

	public void setTlRecUserId(String tlRecUserId) {
		this.tlRecUserId = tlRecUserId;
	}

	public String getTlSenUserId() {
		return tlSenUserId;
	}

	public void setTlSenUserId(String tlSenUserId) {
		this.tlSenUserId = tlSenUserId;
	}

	public String getTlEventType() {
		return tlEventType;
	}

	public void setTlEventType(String tlEventType) {
		this.tlEventType = tlEventType;
	}

	public String getTlSubject() {
		return tlSubject;
	}

	public void setTlSubject(String tlSubject) {
		this.tlSubject = tlSubject;
	}

	public Character getTlTaskDone() {
		return tlTaskDone;
	}

	public void setTlTaskDone(Character tlTaskDone) {
		this.tlTaskDone = tlTaskDone;
	}

	public Character getTlAcknowledge() {
		return tlAcknowledge;
	}

	public void setTlAcknowledge(Character tlAcknowledge) {
		this.tlAcknowledge = tlAcknowledge;
	}

	public String getTlDocNo() {
		return tlDocNo;
	}

	public void setTlDocNo(String tlDocNo) {
		this.tlDocNo = tlDocNo;
	}

	public String getTlTransactionType() {
		return tlTransactionType;
	}

	public void setTlTransactionType(String tlTransactionType) {
		this.tlTransactionType = tlTransactionType;
	}

	public String getTlStatus() {
		return tlStatus;
	}

	public void setTlStatus(String tlStatus) {
		this.tlStatus = tlStatus;
	}

	public Character getTlSentApprovalFlag() {
		return tlSentApprovalFlag;
	}

	public void setTlSentApprovalFlag(Character tlSentApprovalFlag) {
		this.tlSentApprovalFlag = tlSentApprovalFlag;
	}

	public String getTlTrxType() {
		return tlTrxType;
	}

	public void setTlTrxType(String tlTrxType) {
		this.tlTrxType = tlTrxType;
	}

	public Long getTlTrxSeqNo() {
		return tlTrxSeqNo;
	}

	public void setTlTrxSeqNo(Long tlTrxSeqNo) {
		this.tlTrxSeqNo = tlTrxSeqNo;
	}

	public String getTlTaskStatus() {
		return tlTaskStatus;
	}

	public void setTlTaskStatus(String tlTaskStatus) {
		this.tlTaskStatus = tlTaskStatus;
	}

	public String getTlURL() {
		return tlURL;
	}

	public void setTlURL(String tlURL) {
		this.tlURL = tlURL;
	}

	public String getTlFacilityCode() {
		return tlFacilityCode;
	}

	public void setTlFacilityCode(String tlFacilityCode) {
		this.tlFacilityCode = tlFacilityCode;
	}

	public String getTlPTJCode() {
		return tlPTJCode;
	}

	public void setTlPTJCode(String tlPTJCode) {
		this.tlPTJCode = tlPTJCode;
	}

	public Long getTlRecRoleId() {
		return tlRecRoleId;
	}

	public void setTlRecRoleId(Long tlRecRoleId) {
		this.tlRecRoleId = tlRecRoleId;
	}

	public SecRole getRecRole() {
		return recRole;
	}

	public void setRecRole(SecRole recRole) {
		this.recRole = recRole;
	}

	public String getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
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

	public String getParameter3() {
		return parameter3;
	}

	public void setParameter3(String parameter3) {
		this.parameter3 = parameter3;
	}

	public String getParameter4() {
		return parameter4;
	}

	public void setParameter4(String parameter4) {
		this.parameter4 = parameter4;
	}

	public Date getParameter5() {
		return parameter5;
	}

	public void setParameter5(Date parameter5) {
		this.parameter5 = parameter5;
	}

	public SecUser getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(SecUser createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Long getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
}
