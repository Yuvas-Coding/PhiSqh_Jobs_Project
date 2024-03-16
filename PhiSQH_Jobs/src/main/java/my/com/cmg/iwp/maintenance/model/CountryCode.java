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

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * EN: Model class for <b>SysCountryCode</b>.<br>
 * DE: Model Klasse fuer <b>SysCountryCode</b>.<br>
 * 
 * @author bbruhns
 * @author sgerth
 */
@Entity
@Table(name = "t_sys_countrycode", uniqueConstraints = @UniqueConstraint(columnNames = "ccd_code2"))
public class CountryCode implements Serializable {

	private static final long serialVersionUID = 5133361434867930930L;

	private long id = Long.MIN_VALUE;
	private int version;
	private String ccdName;
	private String ccdCode2;
	private String isoCountryName;
	private String isoCountryCode;
	private Set<Ip2Country> ip2Countries = new HashSet<Ip2Country>();

	public CountryCode() {
	}

	public CountryCode(long id, String ccdCode2, String ccdName,
			String isoCountryCode, String isoCountryName) {
		this.setId(id);
		this.ccdCode2 = ccdCode2;
		this.ccdName = ccdName;
		this.isoCountryCode = isoCountryCode;
		this.isoCountryName = isoCountryName;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Id
	@Column(name = "ccd_id", unique = true, nullable = false)
	@SequenceGenerator(name = "countrySEQ", sequenceName = "t_sys_countrycode_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "countrySEQ")
	public long getId() {
		return id;
	}

	public void setCcdCode2(String ccdCode2) {
		this.ccdCode2 = ccdCode2;
	}

	@Column(name = "ccd_code2", unique = true, nullable = false, length = 2)
	public String getCcdCode2() {
		return ccdCode2;
	}

	public void setCcdName(String ccdName) {
		this.ccdName = ccdName;
	}

	@Column(name = "ccd_name", length = 48)
	public String getCcdName() {
		return ccdName;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Version
	@Column(name = "version")
	public int getVersion() {
		return version;
	}

	public void setIp2Countries(Set<Ip2Country> ip2Countries) {
		this.ip2Countries = ip2Countries;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "countryCode")
	public Set<Ip2Country> getIp2Countries() {
		return ip2Countries;
	}

	@Override
	public int hashCode() {
		return Long.valueOf(getId()).hashCode();
	}

	public boolean equals(CountryCode sysCountryCode) {
		return getId() == sysCountryCode.getId();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj instanceof CountryCode) {
			CountryCode sysCountryCode = (CountryCode) obj;
			return equals(sysCountryCode);
		}

		return false;
	}

	public String toString() {
		return new ToStringBuilder(this).append("id", getId()).toString();
	}

	@Column(name = "iso_country_name", length = 100)
	public String getIsoCountryName() {
		return isoCountryName;
	}

	public void setIsoCountryName(String isoCountryName) {
		this.isoCountryName = isoCountryName;
	}

	@Column(name = "iso_country_code", length = 5)
	public String getIsoCountryCode() {
		return isoCountryCode;
	}

	public void setIsoCountryCode(String isoCountryCode) {
		this.isoCountryCode = isoCountryCode;
	}

}
