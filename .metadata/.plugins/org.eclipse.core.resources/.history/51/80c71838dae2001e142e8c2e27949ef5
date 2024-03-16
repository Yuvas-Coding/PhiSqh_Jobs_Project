package my.com.cmg.iwp.maintenance.model;

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
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "T_VOTEOBJ_ACCOUNTS", uniqueConstraints = @UniqueConstraint(columnNames = {"akaun_seqno", "object_seqno" }))
public class VoteObjAccounts implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long objectAccSeqno = Long.MIN_VALUE;
	private Date createdDate;
	private Date updatedDate;
	/*private long akaun_seqno;*/
	/*private long object_seqno;*/
	private VoteObject voteObject;
	private NePGLAccount nePGLAccount;
	private long createdBy;
	private long updatedBy;
	private Character activeFlag = 'A';	
	
	public VoteObjAccounts()
	{
		
	}
	
	@Id
	@Column(name = "OBJACCOUNT_SEQNO")
	@SequenceGenerator(name = "OBJACCOUNT_SEQNO", sequenceName = "T_VOTE_OBJECTSACC_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OBJACCOUNT_SEQNO")
	public long getObjectAccSeqno() {
		return objectAccSeqno;
	}

	public void setObjectAccSeqno(long objectAccSeqno) {
		this.objectAccSeqno = objectAccSeqno;
	}

	@Column(name = "created_date")
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "updated_date")	
	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	/*@Column(name = "akaun_seqno")	
	public long getAkaun_seqno() {
		return akaun_seqno;
	}

	public void setAkaun_seqno(long akaun_seqno) {
		this.akaun_seqno = akaun_seqno;
	}
	
	@Column(name = "object_seqno")	
	public long getObject_seqno() {
		return object_seqno;
	}

	public void setObject_seqno(long object_seqno) {
		this.object_seqno = object_seqno;
	}*/

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "object_seqno", nullable = false)
	public VoteObject getVoteObject() {
		return voteObject;
	}

	public void setVoteObject(VoteObject voteObject) {
		this.voteObject = voteObject;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "akaun_seqno", nullable = false)
	public NePGLAccount getNePGLAccount() {
		return nePGLAccount;
	}

	public void setNePGLAccount(NePGLAccount nePGLAccount) {
		this.nePGLAccount = nePGLAccount;
	}

	@Column(name = "created_by", nullable = false)
	public long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "updated_by", nullable = false)
	public long getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(long updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	@Column(name = "active_flag")	
	public Character getActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(Character activeFlag) {
		this.activeFlag = activeFlag;
	}
}
