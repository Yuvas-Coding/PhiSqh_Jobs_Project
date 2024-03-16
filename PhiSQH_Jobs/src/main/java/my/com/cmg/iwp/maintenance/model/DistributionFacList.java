package my.com.cmg.iwp.maintenance.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "T_DISTRIBUTION_FAC_LIST", uniqueConstraints = @UniqueConstraint(columnNames = {
		"DIST_SEQNO" }))

public class DistributionFacList {
	
	
	private Long distSeqno = Long.MIN_VALUE;
	private Long facilitySeqno;
	private String facilityCode;
	private String ptjCode;
	private String facilityName;
	private String serverIp;
	private String serverPort;
	private Date lastSyncDate;
	private Long facConnectivityStat;
	private Date createdDate;
	private Long facScheduleGrp;
	private Date lastDcSyncDate;
	private Long facSyncStat;
	private Character facSyncActive;
	private String facPingDisable;
	private Date lastServiceCallDate;
	private Long lastDistributeRecSeqno;
	
	@Id
	@Column(name = "dist_seqno", unique = true, nullable = false)
	@SequenceGenerator(name = "dist_seqno", sequenceName = "T_DISTRIBUTION_FAC_LIST_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dist_seqno")
	public Long getDistSeqno() {
		return distSeqno;
	}
	
	public void setDistSeqno(Long distSeqno) {
		this.distSeqno = distSeqno;
	}
	
	
	@Column(name = "facility_Seqno", nullable = false, length = 12)
	public Long getFacilitySeqno() {
		return facilitySeqno;
	}
	
	public void setFacilitySeqno(Long facilitySeqno) {
		this.facilitySeqno = facilitySeqno;
	}
	
	@Column(name = "facility_code", nullable = false, length = 12)
	public String getFacilityCode() {
		return facilityCode;
	}
	
	public void setFacilityCode(String facilityCode) {
		this.facilityCode = facilityCode;
	}
	
	@Column(name = "ptj_code", length = 20)
	public String getPtjCode() {
		return ptjCode;
	}
	
	public void setPtjCode(String ptjCode) {
		this.ptjCode = ptjCode;
	}
	
	@Column(name = "facility_name", nullable = false, length = 50)
	public String getFacilityName() {
		return facilityName;
	}
	
	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
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
	
	@Temporal(TemporalType.DATE)
	@Column(name = "last_sync_date")
	public Date getLastSyncDate() {
		return lastSyncDate;
	}
	
	public void setLastSyncDate(Date lastSyncDate) {
		this.lastSyncDate = lastSyncDate;
	}
	
	@Column(name = "fac_connectivity_status", length = 20)
	public Long getFacConnectivityStat() {
		return facConnectivityStat;
	}
	
	public void setFacConnectivityStat(Long facConnectivityStat) {
		this.facConnectivityStat = facConnectivityStat;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date")
	public Date getCreatedDate() {
		return createdDate;
	}
	
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	@Column(name = "fac_schedule_grp", length = 20)
	public Long getFacScheduleGrp() {
		return facScheduleGrp;
	}
	
	public void setFacScheduleGrp(Long facScheduleGrp) {
		this.facScheduleGrp = facScheduleGrp;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_dc_sync_date")
	public Date getLastDcSyncDate() {
		return lastDcSyncDate;
	}
	
	public void setLastDcSyncDate(Date lastDcSyncDate) {
		this.lastDcSyncDate = lastDcSyncDate;
	}
	
	@Column(name = "fac_sync_status", length = 10)
	public Long getFacSyncStat() {
		return facSyncStat;
	}
	
	public void setFacSyncStat(Long facSyncStat) {
		this.facSyncStat = facSyncStat;
	}
	
	@Column(name = "fac_sync_active", length = 1)
	public Character getFacSyncActive() {
		return facSyncActive;
	}
	
	public void setFacSyncActive(Character facSyncActive) {
		this.facSyncActive = facSyncActive;
	}
	
	@Column(name = "fac_ping_disabled", length = 1)
	public String getFacPingDisable() {
		return facPingDisable;
	}
	
	public void setFacPingDisable(String facPingDisable) {
		this.facPingDisable = facPingDisable;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_service_call_date")
	public Date getLastServiceCallDate() {
		return lastServiceCallDate;
	}
	
	public void setLastServiceCallDate(Date lastServiceCallDate) {
		this.lastServiceCallDate = lastServiceCallDate;
	}
	
	@Column(name = "last_distribute_rec_seqno", length = 20)
	public Long getLastDistributeRecSeqno() {
		return lastDistributeRecSeqno;
	}
	
	public void setLastDistributeRecSeqno(Long lastDistributeRecSeqno) {
		this.lastDistributeRecSeqno = lastDistributeRecSeqno;
	}


}
