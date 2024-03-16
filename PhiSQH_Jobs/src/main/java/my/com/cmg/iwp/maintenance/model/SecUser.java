package my.com.cmg.iwp.maintenance.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name = "T_SEC_USER", uniqueConstraints = @UniqueConstraint(columnNames = "USR_LOGINNAME"))
public class SecUser implements java.io.Serializable {

	private static final long serialVersionUID = -8443234918260997954L;

	private long id = Long.MIN_VALUE;
	private String usrLoginname;
	private String usrPassword;
	private String usrName;
	private String usrEmail;
	private Character usrEnabled = 'Y';
	private Character usrAccountnonexpired = 'Y';
	private Character usrCredentialsnonexpired = 'Y';
	private Character usrAccountnonlocked = 'Y';
	private String createdBy;
	private Date createdDate;
	private String updatedBy;
	private Date updatedDate;
	private String usrDesignation;
	private String usrRemarks;
	private String usrSuperior;
	private String usrContact;
	private Date usrValidFrom;
	private Date usrValidTo;
	private String usrType;
	private Long facilitySeqno;
	
	private Set<SecUserrole> secUserroles = new HashSet<SecUserrole>(0);
	private ExternalFacility externalFacility;

	private Long loginAttemptTotal;
	private Character activationFlag;
	private Character loginFlag;
	private Date activationDatetime;
	private Character tempPasswordFlag;
	
	public SecUser() {
	}

	public SecUser(long id, String usrLoginname, String usrPassword,
			Character usrEnabled, Character usrAccountnonexpired,
			Character usrCredentialsnonexpired, Character usrAccountnonlocked) {
		this.setId(id);
		this.usrLoginname = usrLoginname;
		this.usrPassword = usrPassword;
		this.usrEnabled = usrEnabled;
		this.usrAccountnonexpired = usrAccountnonexpired;
		this.usrCredentialsnonexpired = usrCredentialsnonexpired;
		this.usrAccountnonlocked = usrAccountnonlocked;
	}

	public SecUser(long id, String usrLoginname, String usrPassword,
			String usrName, String usrEmail, Character usrEnabled,
			Character usrAccountnonexpired, Character usrCredentialsnonexpired,
			Character usrAccountnonlocked, Set<SecUserrole> secUserroles) {
		this.setId(id);
		this.usrLoginname = usrLoginname;
		this.usrPassword = usrPassword;
		this.usrName = usrName;
		this.usrEmail = usrEmail;
		this.usrEnabled = usrEnabled;
		this.usrAccountnonexpired = usrAccountnonexpired;
		this.usrCredentialsnonexpired = usrCredentialsnonexpired;
		this.usrAccountnonlocked = usrAccountnonlocked;
		this.secUserroles = secUserroles;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Id
	@Column(name = "usr_seq", unique = true, nullable = false)
	@SequenceGenerator(name = "userSEQ", sequenceName = "T_SEC_USER_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userSEQ")
	public long getId() {
		return id;
	}

	@Column(name = "usr_loginname", unique = true, nullable = false, length = 50)
	public String getUsrLoginname() {
		return this.usrLoginname;
	}

	public void setUsrLoginname(String usrLoginname) {
		this.usrLoginname = usrLoginname;
	}

	@Column(name = "usr_password", nullable = false, length = 50)
	public String getUsrPassword() {
		return this.usrPassword;
	}

	public void setUsrPassword(String usrPassword) {
		this.usrPassword = usrPassword;
	}

	@Column(name = "usr_name", length = 50)
	public String getUsrName() {
		return this.usrName;
	}

	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}

	@Column(name = "usr_email", length = 200)
	public String getUsrEmail() {
		return this.usrEmail;
	}

	public void setUsrEmail(String usrEmail) {
		this.usrEmail = usrEmail;
	}

	@Column(name = "usr_enabled", nullable = false)
	public Character getUsrEnabled() {
		return this.usrEnabled;
	}

	public void setUsrEnabled(Character usrEnabled) {
		this.usrEnabled = usrEnabled;
	}

	@Column(name = "usr_accountnonexpired", nullable = false)
	public Character getUsrAccountnonexpired() {
		return this.usrAccountnonexpired;
	}

	public void setUsrAccountnonexpired(Character usrAccountnonexpired) {
		this.usrAccountnonexpired = usrAccountnonexpired;
	}

	@Column(name = "usr_credentialsnonexpired", nullable = false)
	public Character getUsrCredentialsnonexpired() {
		return this.usrCredentialsnonexpired;
	}

	public void setUsrCredentialsnonexpired(Character usrCredentialsnonexpired) {
		this.usrCredentialsnonexpired = usrCredentialsnonexpired;
	}

	@Column(name = "usr_accountnonlocked", nullable = false)
	public Character getUsrAccountnonlocked() {
		return this.usrAccountnonlocked;
	}

	public void setUsrAccountnonlocked(Character usrAccountnonlocked) {
		this.usrAccountnonlocked = usrAccountnonlocked;
	}

	@Column(name = "create_by")
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "create_date")
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "lst_upd_by")
	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Column(name = "lst_upd_date")
	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Column(name = "usr_designation")
	public String getUsrDesignation() {
		return usrDesignation;
	}

	public void setUsrDesignation(String usrDesignation) {
		this.usrDesignation = usrDesignation;
	}

	@Column(name = "usr_remarks")
	public String getUsrRemarks() {
		return usrRemarks;
	}

	public void setUsrRemarks(String usrRemarks) {
		this.usrRemarks = usrRemarks;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "secUser")
	public Set<SecUserrole> getSecUserroles() {
		return this.secUserroles;
	}

	public void setSecUserroles(Set<SecUserrole> secUserroles) {
		this.secUserroles = secUserroles;
	}

	@Override
	public int hashCode() {
		return Long.valueOf(getId()).hashCode();
	}

	public boolean equals(SecUser secUser) {
		return getId() == secUser.getId();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj instanceof SecUser) {
			SecUser secUser = (SecUser) obj;
			return equals(secUser);
		}

		return false;
	}

	public String toString() {
		return new ToStringBuilder(this).append("id", getId()).toString();
	}

	@Column(name = "usr_superior", length = 30)
	public String getUsrSuperior() {
		return this.usrSuperior;
	}

	public void setUsrSuperior(String usrSuperior) {
		this.usrSuperior = usrSuperior;
	}

	@Column(name = "usr_contact", length = 20)
	public String getUsrContact() {
		return this.usrContact;
	}

	public void setUsrContact(String usrContact) {
		this.usrContact = usrContact;
	}

	@Column(name = "usr_valid_from", nullable = false, length = 29)
	public Date getUsrValidFrom() {
		return usrValidFrom;
	}

	public void setUsrValidFrom(Date usrValidFrom) {
		this.usrValidFrom = usrValidFrom;
	}

	@Column(name = "usr_valid_to", nullable = false, length = 29)
	public Date getUsrValidTo() {
		return usrValidTo;
	}

	public void setUsrValidTo(Date usrValidTo) {
		this.usrValidTo = usrValidTo;
	}

	@Column(name = "usr_type", nullable = false)
	public String getUsrType() {
		return usrType;
	}

	public void setUsrType(String usrType) {
		this.usrType = usrType;
	}

	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "FACILITY_SEQNO", nullable = true)
	@JoinColumn(name = "facility_seqno", nullable = true, insertable=true, updatable=true)
	public ExternalFacility getExternalFacility() {
		return externalFacility;
	}

	public void setExternalFacility(ExternalFacility externalFacility) {
		this.externalFacility = externalFacility;
	}

	@Column(name = "facility_seqno", nullable=false,insertable=false, updatable=false)
	public Long getFacilitySeqno() {
		return facilitySeqno;
	}

	public void setFacilitySeqno(Long facilitySeqno) {
		this.facilitySeqno = facilitySeqno;
	}

	@Column(name = "LOGIN_ATTEMPT_TOTAL")
	public Long getLoginAttemptTotal() {
		return loginAttemptTotal;
	}

	public void setLoginAttemptTotal(Long loginAttemptTotal) {
		this.loginAttemptTotal = loginAttemptTotal;
	}

	@Column(name = "ACTIVATION_FLAG")
	public Character getActivationFlag() {
		return activationFlag;
	}

	public void setActivationFlag(Character activationFlag) {
		this.activationFlag = activationFlag;
	}

	@Column(name = "LOGIN_FLAG")
	public Character getLoginFlag() {
		return loginFlag;
	}

	public void setLoginFlag(Character loginFlag) {
		this.loginFlag = loginFlag;
	}

	@Column(name = "ACTIVATION_DATETIME")
	public Date getActivationDatetime() {
		return activationDatetime;
	}

	public void setActivationDatetime(Date activationDatetime) {
		this.activationDatetime = activationDatetime;
	}

	@Column(name = "TMP_PASS_FLAG")
	public Character getTempPasswordFlag() {
		return tempPasswordFlag;
	}

	public void setTempPasswordFlag(Character tempPasswordFlag) {
		this.tempPasswordFlag = tempPasswordFlag;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}