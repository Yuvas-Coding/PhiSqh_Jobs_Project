package my.com.cmg.iwp.maintenance.model;

import java.math.BigDecimal;
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
import javax.persistence.Transient;

@Entity
@Table(name = "T_LOGIN_ACTIVATION")
public class LoginActivation implements java.io.Serializable {
	
	private static final long serialVersionUID = 1004598051442645164L;
	private Long activationSeqno;
	private String activationId;
	private Long usrId;
	private String usrLoginname;
	private String email;
	private Date activationDatetime;
	private String tempPassword;
	private String passwordType;private String parameter1;
	private String parameter2;
	private BigDecimal parameter3;
	private BigDecimal parameter4;
	private Date parameter5;
	private Character activeFlag = 'A';
	private Long createdBy;
	private Date createdDate;
	private SecUser createdUser;
	private Long updatedBy;
	private Date updatedDate;
	private SecUser updatedUser;
	
	public LoginActivation() {		
	}
	
	public LoginActivation(Long activationSeqno, String activationId, Long usrId, String usrLoginname, String email,
			Date activationDatetime, String tempPassword, String passwordType) {
		this.activationSeqno = activationSeqno;
		this.activationId = activationId;
		this.usrId = usrId;
		this.usrLoginname = usrLoginname;
		this.email = email;
		this.activationDatetime = activationDatetime;
		this.tempPassword = tempPassword;
		this.passwordType = passwordType;
	}
	
	@Id
	@Column(name = "activation_seqno", unique = true, nullable = false)
	@SequenceGenerator(name = "activationSeq", sequenceName = "T_activation_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "activationSeq")
	public Long getActivationSeqno() {
		return activationSeqno;
	}
	public void setActivationSeqno(Long activationSeqno) {
		this.activationSeqno = activationSeqno;
	}
	
	@Column(name = "activation_id")
	public String getActivationId() {
		return activationId;
	}
	public void setActivationId(String activationId) {
		this.activationId = activationId;
	}
	
	@Column(name = "usr_id")
	public Long getUsrId() {
		return usrId;
	}
	public void setUsrId(Long usrId) {
		this.usrId = usrId;
	}
	
	@Column(name = "usr_loginname")
	public String getUsrLoginname() {
		return usrLoginname;
	}
	public void setUsrLoginname(String usrLoginname) {
		this.usrLoginname = usrLoginname;
	}
	
	@Column(name = "email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "activation_datetime")
	public Date getActivationDatetime() {
		return activationDatetime;
	}
	public void setActivationDatetime(Date activationDatetime) {
		this.activationDatetime = activationDatetime;
	}
	
	@Column(name = "temp_password")
	public String getTempPassword() {
		return tempPassword;
	}
	public void setTempPassword(String tempPassword) {
		this.tempPassword = tempPassword;
	}
	
	@Column(name = "password_type")
	public String getPasswordType() {
		return passwordType;
	}
	public void setPasswordType(String passwordType) {
		this.passwordType = passwordType;
	}
	@Column(name = "parameter1", length = 100)
	public String getParameter1() {
		return this.parameter1;
	}

	public void setParameter1(String parameter1) {
		this.parameter1 = parameter1;
	}

	@Column(name = "parameter2", length = 100)
	public String getParameter2() {
		return this.parameter2;
	}

	public void setParameter2(String parameter2) {
		this.parameter2 = parameter2;
	}

	@Column(name = "parameter3", precision = 8, scale = 4)
	public BigDecimal getParameter3() {
		return this.parameter3;
	}

	public void setParameter3(BigDecimal parameter3) {
		this.parameter3 = parameter3;
	}

	@Column(name = "parameter4", precision = 8, scale = 4)
	public BigDecimal getParameter4() {
		return this.parameter4;
	}

	public void setParameter4(BigDecimal parameter4) {
		this.parameter4 = parameter4;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "parameter5", length = 13)
	public Date getParameter5() {
		return this.parameter5;
	}

	public void setParameter5(Date parameter5) {
		this.parameter5 = parameter5;
	}

	@Column(name = "active_flag")
	public Character getActiveFlag() {
		return this.activeFlag;
	}

	public void setActiveFlag(Character activeFlag) {
		this.activeFlag = activeFlag;
	}

	@Column(name = "created_by", nullable = false)
	public Long getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", nullable = false, length = 29)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "created_by", insertable = false, updatable = false)
	public SecUser getCreatedUser() {
		return this.createdUser;
	}

	public void setCreatedUser(SecUser createdUser) {
		this.createdUser = createdUser;
	}

	@Column(name = "updated_by", nullable = false)
	public Long getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_date", nullable = false, length = 29)
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "updated_by", insertable = false, updatable = false)
	public SecUser getUpdatedUser() {
		return this.updatedUser;
	}

	public void setUpdatedUser(SecUser updatedUser) {
		this.updatedUser = updatedUser;
	}

	@Transient
	public Object getLogDeatil() {
		return this;
	}
}
