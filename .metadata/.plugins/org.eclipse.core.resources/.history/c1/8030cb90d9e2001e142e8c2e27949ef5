/**
 * Copyright 2010 the original author or authors.
 * 
 * This file is part of Zksample2. http://zksample2.sourceforge.net/
 * 
 * Zksample2 is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * Zksample2 is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * Zksample2. If not, see <http://www.gnu.org/licenses/gpl.html>.
 */
package my.com.cmg.iwp.maintenance.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.CountryCode;
import my.com.cmg.iwp.maintenance.service.CountryCodeService;

/**
 * EN: Service implementation for methods that depends on <b>CountryCodes</b>.<br>
 * DE: Service Methoden Implementierung betreffend <b>Laendercodes</b>.<br>
 * 
 * @author bbruhns
 * @author sgerth
 */
@Service
public class CountryCodeServiceImpl implements CountryCodeService {

	private BasisNextidDaoImpl<CountryCode> countryCodeDAO;

	public BasisNextidDaoImpl<CountryCode> getCountryCodeDAO() {
		return countryCodeDAO;
	}

	public void setCountryCodeDAO(BasisNextidDaoImpl<CountryCode> countryCodeDAO) {
		this.countryCodeDAO = countryCodeDAO;
	}

	@Override
	public CountryCode getNewCountryCode() {
		return new CountryCode();
	}

	@Override
	public void delete(CountryCode sysCountryCode) {
		getCountryCodeDAO().delete(sysCountryCode);
	}

	@Override
	public List<CountryCode> getAllCountryCodes() {
		DetachedCriteria criteria = DetachedCriteria.forClass(CountryCode.class);
		criteria.add(Restrictions.isNotNull("isoCountryCode"));
		criteria.addOrder(Order.asc("ccdName"));
		return getCountryCodeDAO().findByCriteria(criteria);
	}

	public List<CountryCode> getAllIsoCountryCode() {
		return getCountryCodeDAO().find("from CountryCode where isoCountryCode is not null order by ccdName");
	}
	
	@Override
	public void saveOrUpdate(CountryCode countryCode) {
		getCountryCodeDAO().saveOrUpdate(countryCode);
	}

	@Override
	public CountryCode getCountryCodeById(long id) {
		return getCountryCodeDAO().get(CountryCode.class, id);
	}

	@Override
	public CountryCode getCountryCodeByCode2(String code2) {
		DetachedCriteria criteria = DetachedCriteria.forClass(CountryCode.class);
		criteria.add(Restrictions.eq("isoCountryCode", code2));

		return (CountryCode) DataAccessUtils.uniqueResult(getCountryCodeDAO().findByCriteria(criteria));
	}

	@Override
	public int getCountAllCountryCodes() {
		return DataAccessUtils.intResult(getCountryCodeDAO().find("select count(*) from CountryCode"));
	}

	@Override
	public CountryCode getCountryCodeByName(String countryName) {
		DetachedCriteria criteria = DetachedCriteria.forClass(CountryCode.class);
		criteria.add(Restrictions.ilike("isoCountryName", countryName, MatchMode.EXACT));

		return (CountryCode) DataAccessUtils.uniqueResult(getCountryCodeDAO().findByCriteria(criteria));
	}

}
