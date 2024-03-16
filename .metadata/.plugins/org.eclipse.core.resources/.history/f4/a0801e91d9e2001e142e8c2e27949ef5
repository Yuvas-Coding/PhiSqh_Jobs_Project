package my.com.cmg.iwp.maintenance.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.Ip2Country;
import my.com.cmg.iwp.maintenance.model.IpLocator;
import my.com.cmg.iwp.maintenance.service.Ip2CountryService;

/**
 * EN: Service implementation for methods that depends on <b>Ip2Country</b>.<br>
 * DE: Service Methoden Implementierung betreffend <b>Ip2Country</b>.<br>
 * 
 */
@Service
public class Ip2CountryServiceImpl implements Ip2CountryService, Serializable {

	private static final long serialVersionUID = 893318843695896685L;

	private BasisNextidDaoImpl<Ip2Country> ip2CountryDAO;

	public void setIp2CountryDAO(BasisNextidDaoImpl<Ip2Country> ip2CountryDAO) {
		this.ip2CountryDAO = ip2CountryDAO;
	}

	public BasisNextidDaoImpl<Ip2Country> getIp2CountryDAO() {
		return ip2CountryDAO;
	}

	public void saveOrUpdate(Ip2Country ip2Country) {
		getIp2CountryDAO().saveOrUpdate(ip2Country);

	}

	@Override
	public IpLocator hostIpLookUpIp(String ip) {
		// TODO how we can catch a timeout and get the ip-data later
		try {
			IpLocator ipl = IpLocator.locate(ip);
			if (ipl.getCountry().length() > 0) {
				return ipl;
			}
			return null;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Ip2Country getNewIp2Country() {
		return new Ip2Country();
	}

	@Override
	public List<Ip2Country> getAll() {
		return getIp2CountryDAO().loadAll(Ip2Country.class);
	}

	@Override
	public int getCountAllIp2Countries() {
		return DataAccessUtils.intResult(getIp2CountryDAO().find(
				"select count(*) from Ip2Country"));
	}

	@Override
	public void deleteAll() {
		String hqlQuery = "Delete from Ip2Country";
		getIp2CountryDAO().bulkUpdate(hqlQuery);
	}

}
