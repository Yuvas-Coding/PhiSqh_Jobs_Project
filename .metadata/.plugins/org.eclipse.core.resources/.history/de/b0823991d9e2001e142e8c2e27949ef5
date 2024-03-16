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

import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.CountryCode;
import my.com.cmg.iwp.maintenance.model.Ip2Country;
import my.com.cmg.iwp.maintenance.model.LoginStatus;
import my.com.cmg.iwp.maintenance.model.SecLoginlog;
import my.com.cmg.iwp.maintenance.service.LoginLoggingService;

/**
 * EN: Service implementation for methods that depends on <b>logging the user
 * country</b>.<br>
 * DE: Service Methoden Implementierung betreffend <b>logging users Land</b>.<br>
 * 
 * @changes 11/24/2009: Added Ip2Country features. The ip data<br>
 *          can be get from a local table and updated later by calling<br>
 *          a method against the http://www.HostIP.info webservice.<br>
 *          for geological data.<br>
 *          Secondly the full ip geo-data become directly by calling <br>
 *          the webservice. But if the servvice is down. The login procedure<br>
 *          can be last about 5 min!!! <br>
 * 
 * @author bbruhns
 * @author sgerth
 * 
 */
@Service
public class LoginLoggingServiceImpl implements LoginLoggingService {

	private BasisNextidDaoImpl<SecLoginlog> secLoginlogDAO;
	private BasisNextidDaoImpl<Ip2Country> ip2CountryDAO;
	private BasisNextidDaoImpl<CountryCode> countryCodeDAO;

	public BasisNextidDaoImpl<CountryCode> getCountryCodeDAO() {
		return countryCodeDAO;
	}

	public void setCountryCodeDAO(BasisNextidDaoImpl<CountryCode> countryCodeDAO) {
		this.countryCodeDAO = countryCodeDAO;
	}

	public BasisNextidDaoImpl<SecLoginlog> getSecLoginlogDAO() {
		return this.secLoginlogDAO;
	}

	public void setSecLoginlogDAO(BasisNextidDaoImpl<SecLoginlog> secLoginlogDAO) {
		this.secLoginlogDAO = secLoginlogDAO;
	}

	/**
	 * default Constructor
	 */
	public LoginLoggingServiceImpl() {
	}

	public SecLoginlog getNewSecLoginlog() {
		return new SecLoginlog();
	}

	/*
	 * ++++++++++++++++++++++ Userlog +++++++++++++++++++++
	 */
	@Override
	public void delete(SecLoginlog secLoginlog) {
		getSecLoginlogDAO().delete(secLoginlog);
	}

	@Override
	public List<SecLoginlog> getAllLogs() {
		DetachedCriteria criteria = DetachedCriteria.forClass(SecLoginlog.class);
		criteria.addOrder(Order.desc("lglLogtime"));

		return getSecLoginlogDAO().findByCriteria(criteria);
	}

	@Override
	public List<SecLoginlog> getLogsByLoginname(String value) {
		DetachedCriteria criteria = DetachedCriteria.forClass(SecLoginlog.class);
		criteria.add(Restrictions.eq("lglLoginname", value));
		criteria.addOrder(Order.desc("lglLogtime"));

		return getSecLoginlogDAO().findByCriteria(criteria);
	}

	@Override
	public SecLoginlog getLoginlogById(long log_Id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(SecLoginlog.class);
		criteria.add(Restrictions.eq("id", Long.valueOf(log_Id)));
		criteria.addOrder(Order.desc("lglLogtime"));

		return (SecLoginlog) DataAccessUtils.uniqueResult(getSecLoginlogDAO().findByCriteria(criteria));
	}

	@Override
	public List<LoginStatus> getAllTypes() {
		return new LoginStatus().getAllTypes();
	}

	@Override
	public LoginStatus getTypById(int typ_id) {
		LoginStatus result = null;

		List<LoginStatus> list = getAllTypes();

		try {
			result = list.get(typ_id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return result;
	}

	@Override
	public List<SecLoginlog> getAllLogsForFailed() {
		DetachedCriteria criteria = DetachedCriteria.forClass(SecLoginlog.class);
		criteria.add(Restrictions.eq("lglStatusid", Integer.valueOf(0)));
		criteria.addOrder(Order.desc("lglLogtime"));

		return getSecLoginlogDAO().findByCriteria(criteria);
	}

	@Override
	public List<SecLoginlog> getAllLogsForSuccess() {
		DetachedCriteria criteria = DetachedCriteria.forClass(SecLoginlog.class);
		criteria.add(Restrictions.eq("lglStatusid", Integer.valueOf(1)));
		criteria.addOrder(Order.desc("lglLogtime"));

		return getSecLoginlogDAO().findByCriteria(criteria);
	}

	@Override
	public List<SecLoginlog> getLoginsPerHour(Date startDate) {
		String str1 = " SELECT hour(lgl_Logtime), count(*) from SecLoginlog ";
		String str2 = " WHERE lgl_Status_id = 1 ";
		String str3 = " GROUP BY hour(lgl_Logtime) ORDER BY hour(lgl_Logtime) ";
		String hqlStr = str1 + str2 + str3;

		return getSecLoginlogDAO().find(hqlStr);
	}

	@Override
	public List<SecLoginlog> getAllLogsNewTest() {

		final List<SecLoginlog> listSecLoginLog = getAllLogs();
		for (final SecLoginlog secLoginlog : listSecLoginLog) {

			// Fill with the related data for Ip2Country
			final Ip2Country ip2 = secLoginlog.getIp2Country();
			if (ip2 != null) {
				// Fill with the related data for CountryCode
				final CountryCode cc = ip2.getCountryCode();
				if (cc != null) {
				}

			}
		}

		return listSecLoginLog;
	}

	@Override
	public List<SecLoginlog> getAllLogsServerPushForSuccess() {
		final List<SecLoginlog> listSecLoginLog = getAllLogsForSuccess();

		for (final SecLoginlog secLoginlog : listSecLoginLog) {

			// Fill with the related data for Ip2Country
			final Ip2Country ip2 = secLoginlog.getIp2Country();
			if (ip2 != null) {
				// Fill with the related data for CountryCode
				final CountryCode cc = ip2.getCountryCode();
				if (cc != null) {
				}

			}
		}

		return listSecLoginLog;
	}

	@Override
	public List<SecLoginlog> getAllLogsServerPushForFailed() {
		final List<SecLoginlog> listSecLoginLog = getAllLogsForFailed();

		for (final SecLoginlog secLoginlog : listSecLoginLog) {

			// Fill with the related data for Ip2Country
			final Ip2Country ip2 = secLoginlog.getIp2Country();
			if (ip2 != null) {
				// Fill with the related data for CountryCode
				final CountryCode cc = ip2.getCountryCode();
				if (cc != null) {
				}

			}
		}

		return listSecLoginLog;
	}

	/**
	 * Saves the log data to the table.
	 * 
	 * @param userName
	 * @param clientAddress
	 * @param sessionId
	 * @param status
	 * @return
	 */
	@Override
	public SecLoginlog saveLog(String userName, String clientAddress, String sessionId, String browserType, int status) {
		SecLoginlog log = getNewSecLoginlog();

		log.setLglLoginname(userName);
		log.setLglSessionid(sessionId);
		log.setBrowserType(browserType);
		log.setLglIp(clientAddress);
		log.setLglLogtime(new Date());
		log.setLglStatusid(status);
		secLoginlogDAO.save(log);

		return log;
	}

	@Override
	public void update(SecLoginlog log) {
		this.secLoginlogDAO.update(log);
	}

	@Override
	public void saveOrUpdate(SecLoginlog secLoginlog) {
		getSecLoginlogDAO().saveOrUpdate(secLoginlog);
	}

	@Override
	public int getMaxSecLoginlogId() {
		return DataAccessUtils.intResult(getSecLoginlogDAO().find("select max(lglId) from SecLoginlog"));
	}

	@Override
	public int getTotalCountOfLogs() {
		return DataAccessUtils.intResult(getIp2CountryDAO().find("select count(*) from Ip2Country"));
	}

	@Override
	public int deleteLocalIPs() {
		String str1 = " DELETE FROM SecLoginlog WHERE ";
		String str2 = " lglIp = '127.0.0.1' OR ";
		String str3 = " lglIp = '0:0:0:0:0:0:0:1' ";
		String hqlStr = str1 + str2 + str3;

		int recCount = getSecLoginlogDAO().bulkUpdate(hqlStr);

		return recCount;
	}

	@Override
	public int getCountAllSecLoginlogs() {
		return DataAccessUtils.intResult(getSecLoginlogDAO().find("select count(*) from SecLoginlog"));
	}

	public void setIp2CountryDAO(BasisNextidDaoImpl<Ip2Country> ip2CountryDAO) {
		this.ip2CountryDAO = ip2CountryDAO;
	}

	public BasisNextidDaoImpl<Ip2Country> getIp2CountryDAO() {
		return ip2CountryDAO;
	}
	
}
