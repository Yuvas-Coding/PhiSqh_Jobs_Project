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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.FetchMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.Language;
import my.com.cmg.iwp.maintenance.model.SecGroup;
import my.com.cmg.iwp.maintenance.model.SecGroupright;
import my.com.cmg.iwp.maintenance.model.SecRight;
import my.com.cmg.iwp.maintenance.model.SecRole;
import my.com.cmg.iwp.maintenance.model.SecRolegroup;
import my.com.cmg.iwp.maintenance.model.SecUser;
import my.com.cmg.iwp.maintenance.model.SecUserrole;
import my.com.cmg.iwp.maintenance.service.UserService;
import my.com.cmg.iwp.webui.constant.RefCodeConstant;
@Service
public class UserServiceImpl implements UserService {
	private BasisNextidDaoImpl<SecUser> userDAO;
	private BasisNextidDaoImpl<SecUserrole> secUserroleDAO;
	private BasisNextidDaoImpl<SecRole> secRoleDAO;
	private BasisNextidDaoImpl<SecRolegroup> secRolegroupDAO;
	private BasisNextidDaoImpl<SecGroupright> secGrouprightDAO;
	private BasisNextidDaoImpl<SecGroup> secGroupDAO;
	private BasisNextidDaoImpl<SecRight> secRightDAO;
	private static final List<Language> LANGUAGES;
	
	static {
		List<Language> languages = new ArrayList<Language>(3);
		languages.add(new Language(0, "", ""));
		languages.add(new Language(1, "de_DE", "german"));
		languages.add(new Language(2, "en_EN", "english"));

		LANGUAGES = Collections.unmodifiableList(languages);

	}
	
	public void setUserDAO(BasisNextidDaoImpl<SecUser>userDAO){this.userDAO=userDAO;}
	public BasisNextidDaoImpl<SecUser>getUserDAO(){return userDAO;}
	public void setSecUserroleDAO(BasisNextidDaoImpl<SecUserrole>secUserroleDAO){this.secUserroleDAO=secUserroleDAO;}
	public BasisNextidDaoImpl<SecUserrole>getSecUserroleDAO(){return secUserroleDAO;}
	public void setSecRoleDAO(BasisNextidDaoImpl<SecRole>secRoleDAO){this.secRoleDAO=secRoleDAO;}
	public BasisNextidDaoImpl<SecRole>getSecRoleDAO(){return secRoleDAO;}
	public void setSecRolegroupDAO(BasisNextidDaoImpl<SecRolegroup>secRolegroupDAO){this.secRolegroupDAO=secRolegroupDAO;}
	public BasisNextidDaoImpl<SecRolegroup>getSecRolegroupDAO(){return secRolegroupDAO;}
	public void setSecGrouprightDAO(BasisNextidDaoImpl<SecGroupright>secGrouprightDAO){this.secGrouprightDAO=secGrouprightDAO;}
	public BasisNextidDaoImpl<SecGroupright>getSecGrouprightDAO(){return secGrouprightDAO;}
	public void setSecGroupDAO(BasisNextidDaoImpl<SecGroup>secGroupDAO){this.secGroupDAO=secGroupDAO;}
	public BasisNextidDaoImpl<SecGroup>getSecGroupDAO(){return secGroupDAO;}
	public void setSecRightDAO(BasisNextidDaoImpl<SecRight>secRightDAO){this.secRightDAO=secRightDAO;}
	public BasisNextidDaoImpl<SecRight>getSecRightDAO(){return secRightDAO;}

	@Override
	public void saveOrUpdate(SecUser user) {
		userDAO.saveOrUpdate(user);
	}

	@Override
	public void delete(SecUser user) {
		userDAO.delete(user);
	}

	@Override
	public SecUser getUserByLoginname(final String userName) {
		DetachedCriteria criteria = DetachedCriteria.forClass(SecUser.class);
		criteria.add(Restrictions.eq("usrLoginname", userName));
		return (SecUser) DataAccessUtils.uniqueResult(userDAO
				.findByCriteria(criteria));
	}
	
	@Override
	public SecUser getUserByUserName(final String userName) {
		DetachedCriteria criteria = DetachedCriteria.forClass(SecUser.class);
		criteria.add(Restrictions.eq("usrName", userName));
		List<SecUser> users = userDAO.findByCriteria(criteria);
		return null != users && !users.isEmpty() ? users.get(0) : null;
	}

	@Override
	public List<SecRole> getRolesByUser(SecUser aUser) {
		DetachedCriteria criteria = DetachedCriteria.forClass(SecRole.class);

		// Aliases are working only on properties
		criteria.createAlias("secUserroles", "rol");
		criteria.add(Restrictions.eq("rol.secUser", aUser));

		return secRoleDAO.findByCriteria(criteria);
	}

	@Override
	public List<SecRole> getAllRoles() {
		return secRoleDAO.loadAll(SecRole.class);
	}

	@Override
	public List<SecGroup> getGroupsByUser(SecUser user) {

		DetachedCriteria criteria = DetachedCriteria.forClass(SecGroup.class);
		// Aliases are working only on properties
		criteria.createAlias("secRolegroups", "rg");
		criteria.createAlias("secRoles", "rol");
		criteria.add(Restrictions.eq("rg.rol.secUser", user));

		return secGroupDAO.findByCriteria(criteria);
	}

	/*
	 * Gets the rights for a specified user.<br> (non-Javadoc)
	 * 
	 * @see
	 * my.com.cmg.iwp.backend.service.UserService#getRightsByUser(my.com.cmg
	 * .phis .backend .model.SecUser)
	 */

	@Override
	public List<SecRight> getRightsByUser(SecUser user) {
		return secRightDAO.findByNamedQuery("allRightFromUserSqlQuery",
				Long.valueOf(user.getId()));
	}

	@Override
	public List<Language> getAllLanguages() {
		return LANGUAGES;
	}

	@Override
	public Language getLanguageById(final int lan_id) {
		return (Language) CollectionUtils.find(LANGUAGES, new Predicate() {
			public boolean evaluate(Object object) {
				return lan_id == ((Language) object).getId();
			}
		});
	}

	@Override
	public Language getLanguageByLocale(final String lanLocale) {
		return (Language) CollectionUtils.find(LANGUAGES, new Predicate() {
			@Override
			public boolean evaluate(Object object) {
				return StringUtils.equals(lanLocale,
						((Language) object).getLanLocale());
			}
		});
	}

	@Override
	public int getCountAllSecUser() {
		return DataAccessUtils.intResult(userDAO
				.find("select count(*) from SecUser"));
	}

	@Override
	public SecUser getNewUser() {
		return new SecUser();
	}

	@Override
	public SecUser getUserByID(final Long usr_id) {
		return userDAO.get(SecUser.class, usr_id);
	}

	@Override
	public SecUser getUserByFiluserNr(String usr_nr) {
		DetachedCriteria criteria = DetachedCriteria.forClass(SecUser.class);
		criteria.add(Restrictions.eq("usrNr", usr_nr));

		return (SecUser) DataAccessUtils.uniqueResult(userDAO
				.findByCriteria(criteria));
	}

	@Override
	public SecUser getUserByNameAndPassword(final String userName,
			final String userPassword) {
		DetachedCriteria criteria = DetachedCriteria.forClass(SecUser.class);
		criteria.add(Restrictions.eq("usrLoginname", userName));
		criteria.add(Restrictions.eq("usrPassword", userPassword));

		return (SecUser) DataAccessUtils.uniqueResult(userDAO
				.findByCriteria(criteria));
	}

	@Override
	public List<SecUser> getAllUsers() {
		return userDAO.loadAll(SecUser.class);
	}

	@Override
	public List<SecUser> getUsersLikeLoginname(String value) {
		DetachedCriteria criteria = DetachedCriteria.forClass(SecUser.class);
		criteria.add(Restrictions.like("usrLoginname", value,
				MatchMode.ANYWHERE));

		return userDAO.findByCriteria(criteria);
	}

	@Override
	public List<SecUser> getUsersLikeLastname(String value) {
		DetachedCriteria criteria = DetachedCriteria.forClass(SecUser.class);
		criteria.add(Restrictions
				.like("usrLastname", value, MatchMode.ANYWHERE));

		return userDAO.findByCriteria(criteria);
	}

	@Override
	public List<SecUser> getUsersLikeEmail(String email) {
		DetachedCriteria criteria = DetachedCriteria.forClass(SecUser.class);
		criteria.add(Restrictions.like("usrEmail", email, MatchMode.ANYWHERE));

		return userDAO.findByCriteria(criteria);
	}
	
	@Override
	public boolean isFacilityUser(SecUser secUser) {
		List<String> facUserTypes = new ArrayList<String>();
		facUserTypes.add(RefCodeConstant.USER_TYPE_HOSPITAL);
		facUserTypes.add(RefCodeConstant.USER_TYPE_KK);
		return (facUserTypes.contains(secUser.getUsrType()));
	}
	
	@Override
	public List<SecUser> getUserDetailByEmail(String usrEmail) {
		DetachedCriteria criteria = DetachedCriteria.forClass(SecUser.class);
		criteria.add(Restrictions.eq("usrEmail", usrEmail));
		criteria.setFetchMode("userDetail", FetchMode.JOIN);
		return userDAO.findByCriteria(criteria);
	}
	
	@Override
	public void createUserRoleManageProfile(SecUser secUser, SecUserrole secUserRole) {
		String role = "MANAGE_PROFILE";
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SecRole.class);
		detachedCriteria.add(Restrictions.ilike("rolShortdescription", role));
		SecRole secRole = DataAccessUtils.uniqueResult(secRoleDAO.findByCriteria(detachedCriteria));

		DetachedCriteria userCriteria = DetachedCriteria.forClass(SecUser.class);
		userCriteria.add(Restrictions.eq("usrLoginname", secUser.getUsrLoginname()));
		secUser = DataAccessUtils.uniqueResult(userDAO.findByCriteria(userCriteria));

		secUserRole.setSecRole(secRole);
		secUserRole.setSecUser(secUser);
		secUserroleDAO.save(secUserRole);
	}

	@Override
	public List<SecRole> getRolesByUserForSdr(SecUser aUser, List<String> listSdrRole) {
		DetachedCriteria criteria = DetachedCriteria.forClass(SecRole.class);

		// Aliases are working only on properties
		criteria.createAlias("secUserroles", "rol");
		criteria.add(Restrictions.eq("rol.secUser", aUser));
		criteria.add(Restrictions.in("rolShortdescription", listSdrRole));
		//System.out.println("******* criteria : " + criteria.toString());

		return secRoleDAO.findByCriteria(criteria);
	}
}
