package my.com.cmg.iwp.maintenance.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * ExternalFacility generated by hbm2java
 */
@Entity
@Table(name = "t_external_facilities", uniqueConstraints = @UniqueConstraint(columnNames = {
		"facility_prefix", "facility_code" }))
public class ExternalFacility implements java.io.Serializable,
		Comparable<ExternalFacility> {
	private static final long serialVersionUID = 7297859424475480217L;
	private long facilitySeqno = Long.MIN_VALUE;
	private String facilityPrefix;
	private String facilityCode;
	private String facilityName;
	private String incharge;
	private String facilityList;
	private Character pkdYn = 'N';
	private String province;
	private String parameter1;
	private String parameter2;
	private BigDecimal parameter3;
	private BigDecimal parameter4;
	private Date parameter5;
	private Character activeFlag = 'A';
	private long createdBy;
	private Date createdDate;
	private long updatedBy;
	private Date updatedDate;
	private String ptjCode;
	private String ptjName;

	private String hostName;
	private String serverIp;
	private String serverPort;

	// Address Columns added here
	private String contactPerson;
	private String address1;
	private String address2;
	private String address3;
	private String city;
	private String state;
	private String postcode;
	private String country;
	private String organisationName;
	private String homePhone;
	private String mobilePhone;
	private String officePhone;
	private String fax;
	private String email;
	private String jkn;
	private String accountNo;
	private Character mohFacility = 'Y';
	private Character queueActive = 'N';
	private Character yepSchedule;
	private Date yepScheduleDate;
	private Date yepLastRunDate;
	private Date yepSyncDate;
	private Character yepSyncYN;
	private Character yepExecYN;
	private String hospitalType;
	private String fcICurFinCyc;
	private Character budgetMaintainanceAllowYn = 'N';
//	private Character hosMaintainanceAllowYn = 'N';
	
	private String implementationType;
	private Character instituteFlag = 'N';
	
	// private Set<PoHdr> poHdr=new HashSet<PoHdr>();
	private Set<SecUser> secUsers = new HashSet<SecUser>();

	public ExternalFacility() {
	}

	public ExternalFacility(long facilitySeqno, String facilityPrefix,
			String facilityCode, String facilityName, String incharge,
			String facilityList, String province, long createdBy,
			Date createdDate, long updatedBy, Date updatedDate) {
		this.facilitySeqno = facilitySeqno;
		this.facilityPrefix = facilityPrefix;
		this.facilityCode = facilityCode;
		this.facilityName = facilityName;
		this.incharge = incharge;
		this.facilityList = facilityList;
		this.province = province;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
	}

	public ExternalFacility(long facilitySeqno, String facilityPrefix,
			String facilityCode, String facilityName, String province,
			String hosIncharge, String hosList, Character pkdYn,
			String parameter1, String parameter2, BigDecimal parameter3,
			BigDecimal parameter4, Date parameter5, Character activeFlag,
			long createdBy, Date createdDate, long updatedBy, Date updatedDate, String hospitalType) {
		this.facilitySeqno = facilitySeqno;

		this.pkdYn = pkdYn;
		this.facilityPrefix = facilityPrefix;
		this.facilityCode = facilityCode;
		this.facilityName = facilityName;
		this.province = province;
		this.incharge = hosIncharge;
		this.facilityList = hosList;
		this.parameter1 = parameter1;
		this.parameter2 = parameter2;
		this.parameter3 = parameter3;
		this.parameter4 = parameter4;
		this.parameter5 = parameter5;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.activeFlag = activeFlag;
		this.hospitalType = hospitalType;
	}

	@Id
	@Column(name = "facility_seqno", unique = true, nullable = false)
	@SequenceGenerator(name = "facility_seqno", sequenceName = "t_external_facilities_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "facility_seqno")
	public long getFacilitySeqno() {
		return this.facilitySeqno;
	}

	public void setFacilitySeqno(long facilitySeqno) {
		this.facilitySeqno = facilitySeqno;
	}

	@Column(name = "facility_prefix", nullable = false, length = 12)
	public String getFacilityPrefix() {
		return this.facilityPrefix;
	}

	public void setFacilityPrefix(String facilityPrefix) {
		this.facilityPrefix = facilityPrefix;
	}

	@Column(name = "facility_code", nullable = false, length = 10)
	public String getFacilityCode() {
		return this.facilityCode;
	}

	public void setFacilityCode(String hosCode) {
		this.facilityCode = hosCode;
	}

	@Column(name = "facility_name", nullable = false, length = 50)
	public String getFacilityName() {
		return this.facilityName;
	}

	public void setFacilityName(String hosName) {
		this.facilityName = hosName;
	}

	@Column(name = "pkd_yn")
	public Character getPkdYn() {
		return this.pkdYn;
	}

	public void setPkdYn(Character pkdYn) {
		this.pkdYn = pkdYn;
	}

	@Column(name = "province", length = 30)
	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
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

	@Column(name = "created_by", nullable = false, length = 10)
	public long getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(long createdBy) {
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

	@Column(name = "updated_by", nullable = false, length = 10)
	public long getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(long updatedBy) {
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

	@Column(name = "incharge", nullable = true, length = 30)
	public String getIncharge() {
		return this.incharge;
	}

	public void setIncharge(String hosIncharge) {
		this.incharge = hosIncharge;
	}

	@Column(name = "facility_type", nullable = false, length = 30)
	public String getFacilityList() {
		return this.facilityList;
	}

	public void setFacilityList(String hosList) {
		this.facilityList = hosList;
	}

	@Override
	public int compareTo(ExternalFacility o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Column(name = "ptj_code", length = 20)
	public String getPtjCode() {
		return ptjCode;
	}

	public void setPtjCode(String ptjCode) {
		this.ptjCode = ptjCode;
	}

	@Column(name = "host_name", length = 50)
	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	@Column(name = "server_ip", length = 25)
	public String getServerIp() {
		return serverIp;
	}

	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
	}

	@Column(name = "server_port", length = 5)
	public String getServerPort() {
		return serverPort;
	}

	public void setServerPort(String serverPort) {
		this.serverPort = serverPort;
	}

	// Added Address columns here

	@Column(name = "contact_person", length = 250)
	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	@Column(name = "address1", length = 100)
	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	@Column(name = "address2", length = 100)
	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	@Column(name = "address3", length = 100)
	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	@Column(name = "city", length = 100)
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "state", length = 20)
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "postcode", length = 10)
	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	@Column(name = "country", length = 48)
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name = "organisation_name", length = 200)
	public String getOrganisationName() {
		return organisationName;
	}

	public void setOrganisationName(String organisationName) {
		this.organisationName = organisationName;
	}

	@Column(name = "home_phone", length = 20)
	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	@Column(name = "mobile_phone", length = 20)
	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	@Column(name = "office_phone", length = 20)
	public String getOfficePhone() {
		return officePhone;
	}

	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}

	@Column(name = "fax", length = 20)
	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	@Column(name = "email", length = 50)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "ptj_name", length = 50)
	public String getPtjName() {
		return ptjName;
	}

	public void setPtjName(String ptjName) {
		this.ptjName = ptjName;
	}

	public void setJkn(String jkn) {
		this.jkn = jkn;
	}

	@Column(name = "jkn", length = 20)
	public String getJkn() {
		return jkn;
	}

	/*
	 * @OneToMany(fetch = FetchType.LAZY, mappedBy = "externalFacility") public
	 * Set<PoHdr> getPoHdr() { return poHdr; }
	 * 
	 * public void setPoHdrHq(Set<PoHdr> poHdr) { this.poHdr = poHdr; }
	 */
	@Column(name = "account_no", length = 100)
	public String getAccountNo() {
		return this.accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public void setMohFacility(Character mohFacility) {
		this.mohFacility = mohFacility;
	}

	@Column(name = "moh_facility")
	public Character getMohFacility() {
		return mohFacility;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "externalFacility", cascade = CascadeType.ALL)
	public Set<SecUser> getSecUsers() {
		return secUsers;
	}

	public void setSecUsers(Set<SecUser> secUsers) {
		this.secUsers = secUsers;
	}

	public void setHospitalType(String hospitalType) {
		this.hospitalType = hospitalType;
	}

	@Column(name = "hospital_type")
	public String getHospitalType() {
		return hospitalType;
	}

	@Column(name= "IS_QUEUE_ACTIVE") 
	public Character getQueueActive() {
		return queueActive;
	}

	public void setQueueActive(Character queueActive) {
		this.queueActive = queueActive;
	}
	
	@Column(name = "fc_i_cur_fin_cyc", length = 4)
	public String getFcICurFinCyc() {
		return this.fcICurFinCyc;
	}

	public void setFcICurFinCyc(String fcICurFinCyc) {
		this.fcICurFinCyc = fcICurFinCyc;
	}

	@Column(name= "YEP_SCHEDULE")
	public Character getYepSchedule() {
		return yepSchedule;
	}

	public void setYepSchedule(Character yepSchedule) {
		this.yepSchedule = yepSchedule;
	}

	@Column(name= "YEP_SCHEDULE_DATE")
	public Date getYepScheduleDate() {
		return yepScheduleDate;
	}

	public void setYepScheduleDate(Date yepScheduleDate) {
		this.yepScheduleDate = yepScheduleDate;
	}

	@Column(name= "YEP_LAST_RUN_DATE")
	public Date getYepLastRunDate() {
		return yepLastRunDate;
	}

	public void setYepLastRunDate(Date yepLastRunDate) {
		this.yepLastRunDate = yepLastRunDate;
	}

	@Column(name= "YEP_SYNC_YN")
	public Character getYepSyncYN() {
		return yepSyncYN;
	}

	public void setYepSyncYN(Character yepSyncYN) {
		this.yepSyncYN = yepSyncYN;
	}

	@Column(name= "YEP_EXEC_YN")
	public Character getYepExecYN() {
		return yepExecYN;
	}

	public void setYepExecYN(Character yepExecYN) {
		this.yepExecYN = yepExecYN;
	}

	@Column(name= "YEP_SYNC_DATE")
	public Date getYepSyncDate() {
		return yepSyncDate;
	}

	public void setYepSyncDate(Date yepSyncDate) {
		this.yepSyncDate = yepSyncDate;
	}

	@Column(name = "BUDGET_MAINTANANCE_ALLOW_YN")
	public Character getBudgetMaintainanceAllowYn() {
		return budgetMaintainanceAllowYn;
	}

	public void setBudgetMaintainanceAllowYn(Character isBudgetMaintainanceAllow) {
		this.budgetMaintainanceAllowYn = isBudgetMaintainanceAllow;
	}
	
	@Column(name = "implementation_type")
	public String getImplementationType() {
		return implementationType;
	}

	public void setImplementationType(String implementationType) {
		this.implementationType = implementationType;
	}

	/*@Column(name = "HOS_MAINTANANCE_ALLOW_YN")
	public Character getHosMaintainanceAllowYn() {
		return hosMaintainanceAllowYn;
	}

	public void setHosMaintainanceAllowYn(Character hosMaintainanceAllowYn) {
		this.hosMaintainanceAllowYn = hosMaintainanceAllowYn;
	}*/
	


	@Column(name="institute_flag")
	public Character getInstituteFlag() {
		return instituteFlag;
	}

	public void setInstituteFlag(Character instituteFlag) {
		this.instituteFlag = instituteFlag;
	}
	
}
