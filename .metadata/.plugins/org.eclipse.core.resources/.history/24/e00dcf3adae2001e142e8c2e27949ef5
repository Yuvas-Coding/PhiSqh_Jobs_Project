package my.com.cmg.iwp.maintenance.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import my.com.cmg.iwp.webui.constant.RefCodeConstant;

import org.codehaus.jackson.annotate.JsonIgnore;

@MappedSuperclass
public class GetterBaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String parameter1;
	private String parameter2;
	private BigDecimal parameter3;
	private BigDecimal parameter4;
	private Date parameter5;
	private Character activeFlag = RefCodeConstant.ACTIVE_FLAG_TRUE;
	private Long createdBy;
	private Date createdDate;
	private Long updatedBy;
	private Date updatedDate;
	private SecUser createdUser;
	private SecUser updatedUser;

	public GetterBaseEntity() {
		Date currentDate = new Date();
		this.createdDate = currentDate;
		this.updatedDate = currentDate;
	}
	
	@Column(name = "parameter1", length = 100)
	public String getParameter1() {
		return parameter1;
	}

	public void setParameter1(String parameter1) {
		this.parameter1 = parameter1;
	}
	@Column(name = "parameter2", length = 100)
	public String getParameter2() {
		return parameter2;
	}

	public void setParameter2(String parameter2) {
		this.parameter2 = parameter2;
	}

	@Column(name = "parameter3", precision = 8, scale = 4)
	public BigDecimal getParameter3() {
		return parameter3;
	}

	public void setParameter3(BigDecimal parameter3) {
		this.parameter3 = parameter3;
	}

	@Column(name = "parameter4", precision = 8, scale = 4)
	public BigDecimal getParameter4() {
		return parameter4;
	}

	public void setParameter4(BigDecimal parameter4) {
		this.parameter4 = parameter4;
	}


	@Temporal(TemporalType.DATE)
	@Column(name = "parameter5", length = 13)
	public Date getParameter5() {
		return parameter5;
	}

	public void setParameter5(Date parameter5) {
		this.parameter5 = parameter5;
	}


	@Column(name = "ACTIVE_FLAG")
	public Character getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(Character activeFlag) {
		this.activeFlag = activeFlag;
	}


	@Column(name = "CREATED_BY", nullable = false)
	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE", nullable = false, length = 29)
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}


	@Column(name = "UPDATED_BY", nullable = false)
	public Long getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATED_DATE", nullable = false, length = 29)
	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CREATED_BY", insertable = false, updatable = false)
	@JsonIgnore
	public SecUser getCreatedUser() {
		return this.createdUser;
	}

	public void setCreatedUser(SecUser createdUser) {
		this.createdUser = createdUser;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UPDATED_BY", insertable = false, updatable = false)
	@JsonIgnore
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

	@PrePersist
	protected void onCreate() {
		updatedDate = createdDate = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		updatedDate = new Date();
	}
}