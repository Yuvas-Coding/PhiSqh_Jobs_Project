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

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.SysCountryCode;
import my.com.cmg.iwp.maintenance.service.SysCountryCodeService;

/**
 * Service implementation for methods that depends on <b>SysCountryCode
 * model</b> class.<br>
 */
@Service
public class SysCountryCodeServiceImpl implements SysCountryCodeService {

	private BasisNextidDaoImpl<SysCountryCode> sysCountryCodeDAO;

	@Override
	public SysCountryCode getNewCountryCode() {
		return new SysCountryCode();
	}

	@Override
	public void delete(SysCountryCode sysCountryCode) {
		sysCountryCodeDAO.delete(sysCountryCode);
	}

	@Override
	public List<SysCountryCode> getAllCountryCodes() {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(SysCountryCode.class);
		criteria.addOrder(Order.asc("ccdName"));

		return sysCountryCodeDAO.findByCriteria(criteria);
	}

	@Override
	public void saveOrUpdate(SysCountryCode countryCode) {
		sysCountryCodeDAO.saveOrUpdate(countryCode);
	}

	@Override
	public SysCountryCode getCountryCodeById(Long ccd_Id) {
		return sysCountryCodeDAO.get(SysCountryCode.class, ccd_Id);
	}

	@Override
	public SysCountryCode getCountryCodeByCode2(String code2) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(SysCountryCode.class);
		criteria.add(Restrictions.eq("ccdCode2", code2));

		return (SysCountryCode) DataAccessUtils.uniqueResult(sysCountryCodeDAO
				.findByCriteria(criteria));
	}

	@Override
	public int getCountAllSysCountrycode() {
		return DataAccessUtils.intResult(sysCountryCodeDAO
				.find("select count(*) from SysCountryCode"));
	}

	public void setSysCountryCodeDAO(
			BasisNextidDaoImpl<SysCountryCode> sysCountryCodeDAO) {
		this.sysCountryCodeDAO = sysCountryCodeDAO;
	}

	public BasisNextidDaoImpl<SysCountryCode> getSysCountryCodeDAO() {
		return sysCountryCodeDAO;
	}

}
