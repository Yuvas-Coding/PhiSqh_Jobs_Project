package my.com.cmg.iwp.maintenance.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name = "t_spl_drug_req_approvers")
public class SplDrugReqApprover {
	
private static final long serialVersionUID = 1L;
private long approverSeq = Long.MIN_VALUE;
private String approverDomain;
private String approverValue;
private String status;
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
private SplDrugReqApproverImages approverImages;

public SplDrugReqApprover() {
} 

@Id
@Column(name = "spl_drug_req_approvers_seq", unique = true, nullable = false)
@SequenceGenerator(name = "spl_drug_req_approvers_seq", sequenceName = "t_spl_drug_req_approvers_seq", allocationSize = 1)
@GeneratedValue(generator = "spl_drug_req_approvers_seq", strategy = GenerationType.SEQUENCE)
public long getApproverSeq() {
	return approverSeq;
}

public void setApproverSeq(long approverSeq) {
	this.approverSeq = approverSeq;
}

@Column(name = "approver_domain", nullable = false)
public String getApproverDomain() {
	return approverDomain;
}
public void setApproverDomain(String approverDomain) {
	this.approverDomain = approverDomain;
}

@Column(name = "approver_value", nullable = false)
public String getApproverValue() {
	return approverValue;
}

public void setApproverValue(String approverValue) {
	this.approverValue = approverValue;
}

@Column(name = "status", nullable = false)
public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
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
public long getCreatedBy() {
	return this.createdBy;
}

public void setCreatedBy(long createBy) {
	this.createdBy = createBy;
}

@Temporal(TemporalType.TIMESTAMP)
@Column(name = "created_date", nullable = false, length = 29)
public Date getCreatedDate() {
	return this.createdDate;
}

public void setCreatedDate(Date createDate) {
	this.createdDate = createDate;
}

@Column(name = "updated_by", nullable = false)
public long getUpdatedBy() {
	return this.updatedBy;
}

public void setUpdatedBy(long updateBy) {
	this.updatedBy = updateBy;
}

@Temporal(TemporalType.TIMESTAMP)
@Column(name = "updated_date", nullable = false, length = 29)
public Date getUpdatedDate() {
	return this.updatedDate;
}

public void setUpdatedDate(Date updateDate) {
	this.updatedDate = updateDate;
}

@OneToOne(fetch = FetchType.LAZY, mappedBy = "drugReqApprover", cascade = CascadeType.ALL)
public SplDrugReqApproverImages getApproverImages() {
	return approverImages;
}

public void setApproverImages(SplDrugReqApproverImages approverImages) {
	this.approverImages = approverImages;
}


}
