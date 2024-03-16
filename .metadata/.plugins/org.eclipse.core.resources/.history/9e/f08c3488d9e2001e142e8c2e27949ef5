/**
 * Copyright 2010 the original author or authors.
 * 
 * This file is part of Zksample2. http://zksample2.sourceforge.net/
 *
 * Zksample2 is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * Zksample2 is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Zksample2.  If not, see <http://www.gnu.org/licenses/gpl.html>.
 */
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * EN: Model class for <b>SecLoginlog</b>.<br>
 * DE: Model Klasse fuer <b>Login Log</b>.<br>
 * 
 * @author bbruhns
 * @author sgerth
 */
@Entity
@Table(name = "t_sec_loginlog")
public class SecLoginlog implements java.io.Serializable {

	private static final long serialVersionUID = -2628240632347849393L;

	private long id = Long.MIN_VALUE;
	private Ip2Country ip2Country;
	private String lglLoginname;
	private Date lglLogtime;
	private String lglSessionid;
	private String lglIp;
	private String browserType;
	private int lglStatusid;
	private int version;

	public SecLoginlog() {
	}

	public SecLoginlog(long id, String lglLoginname, Date lglLogin,
			int lglStatusid) {
		this.setId(id);
		this.lglLoginname = lglLoginname;
		this.lglLogtime = lglLogin;
		this.lglStatusid = lglStatusid;
	}

	public SecLoginlog(long id, String lglLoginname, Date lglLogtime,
			String lglSessionid, String lglIp, int lglStatusid,
			String browserType) {
		this.setId(id);
		this.lglLoginname = lglLoginname;
		this.lglLogtime = lglLogtime;
		this.lglSessionid = lglSessionid;
		this.lglIp = lglIp;
		this.lglStatusid = lglStatusid;
		this.setBrowserType(browserType);
	}

	public void setId(long id) {
		this.id = id;
	}

	@Id
	@Column(name = "lgl_id", unique = true, nullable = false)
	@SequenceGenerator(name = "loginSEQ", sequenceName = "t_sec_loginlog_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "loginSEQ")
	public long getId() {
		return id;
	}

	public void setIp2Country(Ip2Country ip2Country) {
		this.ip2Country = ip2Country;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "i2c_id")
	public Ip2Country getIp2Country() {
		return ip2Country;
	}

	@Column(name = "lgl_loginname", nullable = false, length = 50)
	public String getLglLoginname() {
		return this.lglLoginname;
	}

	public void setLglLoginname(String lglLoginname) {
		this.lglLoginname = lglLoginname;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "lgl_logtime", nullable = false, length = 29)
	public Date getLglLogtime() {
		return this.lglLogtime;
	}

	public void setLglLogtime(Date lglLogtime) {
		this.lglLogtime = lglLogtime;
	}

	@Column(name = "lgl_sessionid", length = 50)
	public String getLglSessionid() {
		return this.lglSessionid;
	}

	public void setLglSessionid(String lglSessionid) {
		this.lglSessionid = lglSessionid;
	}

	@Column(name = "lgl_ip", length = 19)
	public String getLglIp() {
		return this.lglIp;
	}

	public void setLglIp(String lglIp) {
		this.lglIp = lglIp;
	}

	@Column(name = "lgl_status_id", nullable = false)
	public int getLglStatusid() {
		return this.lglStatusid;
	}

	public void setLglStatusid(int lglStatusid) {
		this.lglStatusid = lglStatusid;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Version
	@Column(name = "version", nullable = false)
	public int getVersion() {
		return version;
	}

	public void setBrowserType(String browserType) {
		this.browserType = browserType;
	}

	@Column(name = "lgl_browsertype", length = 50)
	public String getBrowserType() {
		return browserType;
	}

	@Override
	public int hashCode() {
		return Long.valueOf(getId()).hashCode();
	}

	public boolean equals(SecLoginlog secLoginlog) {
		return getId() == secLoginlog.getId();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj instanceof SecLoginlog) {
			SecLoginlog secLoginlog = (SecLoginlog) obj;
			return equals(secLoginlog);
		}

		return false;
	}

	public String toString() {
		return new ToStringBuilder(this).append("id", getId()).toString();
	}

}
