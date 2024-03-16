package my.com.cmg.iwp.maintenance.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Pattern;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.Ip4Country;
import my.com.cmg.iwp.maintenance.service.Ip4CountryService;

/**
 * EN: Service implementation for methods that depends on <b>Ip4Country</b>.<br>
 * DE: Service Methoden Implementierung betreffend <b>Ip4Country</b>.<br>
 * 
 * @author Ong Eu Soon
 */

@Service
public class Ip4CountryServiceImpl implements Ip4CountryService, Serializable {

	private static final long serialVersionUID = 893318843695896685L;
	private final static Logger logger = Logger
			.getLogger(Ip4CountryServiceImpl.class);

	final private String updateUrl = "ftp://ftp.wayne.edu/hostip.info/csv/hip_ip4_country.csv";

	private BasisNextidDaoImpl<Ip4Country> ip4CountryDAO;

	public void setIp4CountryDAO(BasisNextidDaoImpl<Ip4Country> ip4CountryDAO) {
		this.ip4CountryDAO = ip4CountryDAO;
	}

	public BasisNextidDaoImpl<Ip4Country> getIp4CountryDAO() {
		return this.ip4CountryDAO;
	}

	@Override
	public Ip4Country getNewIp4Country() {
		return new Ip4Country();
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
		final byte[] bs = address.getAddress();
		return bs[0] * 16777216l + bs[1] * 65536 + bs[2] * 256 + bs[3];
	}

	@Override
	public Ip4Country getIp4Country(InetAddress address) {
		final Long lg = Long.valueOf(inetAddressToLong(address));
		return this.ip4CountryDAO.get(Ip4Country.class, lg);
	}

	public void saveOrUpdate(Ip4Country ip4Country) {
		getIp4CountryDAO().saveOrUpdate(ip4Country);
	}

	@Override
	public int importIP4CountryCSV() {
		try {

			// first, delete all records in the ip2Country table
			deleteAll();

			final URL url = new URL(this.updateUrl);
			final URLConnection conn = url.openConnection();
			final InputStream istream = conn.getInputStream();

			final BufferedReader in = new BufferedReader(new InputStreamReader(
					istream));
			try {
				final Pattern splitterPattern = Pattern.compile(",");
				int counter = 0;
				String aLine = null;
				while (null != (aLine = in.readLine())) {
					final String[] array = splitterPattern.split(aLine.trim());
					final long ip = Long.parseLong(array[0]);
					final long country = Long.parseLong(array[1]);

					final Ip4Country tmp = this.getNewIp4Country();
					tmp.setI4coCcdId(country);
					tmp.setI4coIp(ip);

					getIp4CountryDAO().saveOrUpdate(tmp);

					if (logger.isDebugEnabled() && ++counter % 100 == 0) {
						logger.debug("Aktueller Zaehler: " + counter);
					}
				}
			} finally {
				in.close();
				istream.close();
			}
			return getCountAllIp4Countries();

		} catch (final IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int getCountAllIp4Countries() {
		return DataAccessUtils.intResult(getIp4CountryDAO().find(
				"select count(*) from Ip4Country"));
	}

	@Override
	public void deleteAll() {
		String hqlQuery = "Delete from Ip4Country";
		getIp4CountryDAO().bulkUpdate(hqlQuery);
	}
}
