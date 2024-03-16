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
package my.com.cmg.iwp.maintenance.service.impl;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.ZipInputStream;

import org.apache.commons.lang3.ArrayUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.prefs.CsvPreference;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.IpToCountry;
import my.com.cmg.iwp.maintenance.service.IpToCountryService;

/**
 * EN: Service implementation for methods that depends on <b>IpToCountry</b>.<br>
 * DE: Service Methoden Implementierung betreffend <b>IpToCountry</b>.<br>
 * 
 * @author bbruhns
 * @author sgerth
 */
@Service
public class IpToCountryServiceImpl implements IpToCountryService, Serializable {

	private static final long serialVersionUID = 893318843695896685L;
	private final static Logger logger = Logger
			.getLogger(IpToCountryServiceImpl.class);

	final private String updateUrl = "http://ip-to-country.webhosting.info/downloads/ip-to-country.csv.zip";

	final private String[] stringNameMapping = { "ipcIpFrom", "ipcIpTo",
			"ipcCountryCode2", "ipcCountryCode3", "ipcCountryName" };

	private BasisNextidDaoImpl<IpToCountry> ipToCountryDAO;

	public void setIpToCountryDAO(BasisNextidDaoImpl<IpToCountry> ipToCountryDAO) {
		this.ipToCountryDAO = ipToCountryDAO;
	}

	public BasisNextidDaoImpl<IpToCountry> getIpToCountryDAO() {
		return this.ipToCountryDAO;
	}

	/**
	 * Converts an ip-address to a long value.<br>
	 * 
	 * @param address
	 * @return
	 */
	private static long inetAddressToLong(InetAddress address) {
		if (address.isAnyLocalAddress())
			return 0l;

		final byte[] bs;
		if (address instanceof Inet4Address) {
			bs = address.getAddress();
		} else if (address instanceof Inet6Address) {
			if (((Inet6Address) address).isIPv4CompatibleAddress()) {
				// take the last 4 digits
				bs = ArrayUtils.subarray(address.getAddress(), 12, 16);
			} else {
				throw new RuntimeException("IPv6 not supported!");
			}
		} else {
			throw new RuntimeException();
		}

		return bs[0] * 16777216l + bs[1] * 65536 + bs[2] * 256 + bs[3];
	}

	@Override
	public IpToCountry getIpToCountry(InetAddress address) {
		final Long lg = Long.valueOf(inetAddressToLong(address));
		return this.getCountry(lg);
	}

	@Override
	public void saveOrUpdate(IpToCountry ipToCountry) {
		getIpToCountryDAO().saveOrUpdate(ipToCountry);
	}

	@Override
	public int importIP2CountryCSV() {
		try {

			// first, delete all records in the ip2Country table
			deleteAll();

			final URL url = new URL(this.updateUrl);
			final URLConnection conn = url.openConnection();
			final InputStream istream = conn.getInputStream();

			final ZipInputStream zipInputStream = new ZipInputStream(
					new BufferedInputStream(istream));

			zipInputStream.getNextEntry();

			final BufferedReader in = new BufferedReader(new InputStreamReader(
					zipInputStream));

			final CsvBeanReader csvb = new CsvBeanReader(in,
					CsvPreference.STANDARD_PREFERENCE);

			// List<IpToCountry> list = new ArrayList<IpToCountry>();

			IpToCountry tmp = null;
			int id = 1;
			while (null != (tmp = csvb.read(IpToCountry.class,
					this.stringNameMapping))) {
				tmp.setId(id++);
				getIpToCountryDAO().saveOrUpdate(tmp);

			}
			// close the stream !!!
			in.close();

			return getCountAllIpToCountries();

		} catch (final IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int getCountAllIpToCountries() {
		return DataAccessUtils.intResult(getIpToCountryDAO().find(
				"select count(*) from IpToCountry"));
	}

	@Override
	public IpToCountry getNewIpToCountry() {
		return new IpToCountry();
	}

	@Override
	public void deleteAll() {
		String hqlQuery = "Delete from IpToCountry";
		getIpToCountryDAO().bulkUpdate(hqlQuery);
	}

	@Override
	public IpToCountry getCountry(Long ipNumber) {

		IpToCountry result = null;

		DetachedCriteria criteria = DetachedCriteria
				.forClass(IpToCountry.class);
		criteria.add(Restrictions.lt("ipcIpFrom", ipNumber));
		criteria.add(Restrictions.gt("ipcIpTo", ipNumber));

		result = (IpToCountry) DataAccessUtils.uniqueResult(getIpToCountryDAO()
				.findByCriteria(criteria));

		return result;

	}

	public static Logger getLogger() {
		return logger;
	}
}
