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

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.SecGroup;
import my.com.cmg.iwp.maintenance.model.SecGroupright;
import my.com.cmg.iwp.maintenance.model.SecRight;
import my.com.cmg.iwp.maintenance.model.SecRole;
import my.com.cmg.iwp.maintenance.model.SecRolegroup;
import my.com.cmg.iwp.maintenance.model.SecTyp;
import my.com.cmg.iwp.maintenance.model.SecUser;
import my.com.cmg.iwp.maintenance.model.SecUserrole;
import my.com.cmg.iwp.maintenance.service.SecurityService;
import my.com.cmg.iwp.webui.constant.RefCodeConstant;

/**
 * Service implementation for methods that depends on <b>Security model</b>
 * classes.<br>
 * 
 * @author bbruhns
 * @author sgerth
 */
@Service
public class SecurityServiceImpl implements SecurityService {

	private BasisNextidDaoImpl<SecUser> userDAO;
	private BasisNextidDaoImpl<SecUserrole> secUserroleDAO;
	private BasisNextidDaoImpl<SecRole> secRoleDAO;
	private BasisNextidDaoImpl<SecRolegroup> secRolegroupDAO;
	private BasisNextidDaoImpl<SecGroupright> secGrouprightDAO;
	private BasisNextidDaoImpl<SecGroup> secGroupDAO;
	private BasisNextidDaoImpl<SecRight> secRightDAO;

	public BasisNextidDaoImpl<SecUser> getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(BasisNextidDaoImpl<SecUser> userDAO) {
		this.userDAO = userDAO;
	}

	public BasisNextidDaoImpl<SecUserrole> getSecUserroleDAO() {
		return secUserroleDAO;
	}

	public void setSecUserroleDAO(BasisNextidDaoImpl<SecUserrole> secUserroleDAO) {
		this.secUserroleDAO = secUserroleDAO;
	}

	public BasisNextidDaoImpl<SecRole> getSecRoleDAO() {
		return secRoleDAO;
	}

	public void setSecRoleDAO(BasisNextidDaoImpl<SecRole> secRoleDAO) {
		this.secRoleDAO = secRoleDAO;
	}

	public BasisNextidDaoImpl<SecRolegroup> getSecRolegroupDAO() {
		return secRolegroupDAO;
	}

	public void setSecRolegroupDAO(
			BasisNextidDaoImpl<SecRolegroup> secRolegroupDAO) {
		this.secRolegroupDAO = secRolegroupDAO;
	}

	public BasisNextidDaoImpl<SecGroupright> getSecGrouprightDAO() {
		return secGrouprightDAO;
	}

	public void setSecGrouprightDAO(
			BasisNextidDaoImpl<SecGroupright> secGrouprightDAO) {
		this.secGrouprightDAO = secGrouprightDAO;
	}

	public BasisNextidDaoImpl<SecGroup> getSecGroupDAO() {
		return secGroupDAO;
	}

	public void setSecGroupDAO(BasisNextidDaoImpl<SecGroup> secGroupDAO) {
		this.secGroupDAO = secGroupDAO;
	}

	public BasisNextidDaoImpl<SecRight> getSecRightDAO() {
		return secRightDAO;
	}

	public void setSecRightDAO(BasisNextidDaoImpl<SecRight> secRightDAO) {
		this.secRightDAO = secRightDAO;
	}

	@Override
	public List<SecRole> getAllRoles() {
		return secRoleDAO.loadAll(SecRole.class);
	}
	
	@Override
	public List<SecRole> getActiveRolesByRoleDesc(String rolLongdescription) {
		DetachedCriteria criteria = DetachedCriteria.forClass(SecRole.class);
		criteria.add(Restrictions.eq("activeFlag", RefCodeConstant.ACTIVE_FLAG_TRUE));
		if(StringUtils.trimToNull(rolLongdescription) != null)
			criteria.add(Restrictions.ilike("rolLongdescription", "%" + rolLongdescription + "%"));
		criteria.addOrder(Order.asc("rolLongdescription"));
		return secRoleDAO.findByCriteria(criteria);
	}	

	@Override
	public void saveOrUpdate(SecRole role) {
		// if (isNewSecRole(role)) {
		// long nextId=secRoleDAO.getNextidviewDAO().getNextId();
		// role.setId(nextId);
		// }
		secRoleDAO.saveOrUpdate(role);
	}

	@SuppressWarnings("unused")
	private boolean isNewSecRole(SecRole role) {
		return role.getId() == Long.MIN_VALUE;
	}

	@Override
	public void delete(SecRole role) {
		secRoleDAO.delete(role);
	}

	@Override
	public List<SecGroup> getAllGroups() {
		DetachedCriteria criteria = DetachedCriteria.forClass(SecGroup.class);
		criteria.addOrder(Order.asc("grpShortdescription"));

		return secGroupDAO.findByCriteria(criteria);
	}

	@Override
	public List<SecRight> getAllRights(int type) {
		DetachedCriteria criteria = DetachedCriteria.forClass(SecRight.class);
		criteria.addOrder(Order.asc("rigName"));

		if (type != -1) {
			criteria.add(Restrictions.eq("rigType", Integer.valueOf(type)));
			// criteria.add(Restrictions.or(Restrictions.eq("rigType", 2),
			// Restrictions.eq("rigType", 1)));
		}

		return secRightDAO.findByCriteria(criteria);
	}

	@Override
	public SecGroup getNewSecGroup() {
		return new SecGroup();
	}

	@Override
	public SecRight getNewSecRight() {
		return new SecRight();
	}

	@Override
	public SecRole getNewSecRole() {
		return new SecRole();
	}

	@Override
	public List<SecGroupright> getAllGroupRights() {
		return secGrouprightDAO.loadAll(SecGroupright.class);
	}

	@Override
	public SecGroupright getNewSecGroupright() {
		return new SecGroupright();
	}

	@Override
	public List<SecUserrole> getAllUserRoles() {
		return secUserroleDAO.loadAll(SecUserrole.class);
	}

	@Override
	public SecUserrole getNewSecUserrole() {
		return new SecUserrole();
	}

	@Override
	public SecRolegroup getNewSecRolegroup() {
		return new SecRolegroup();
	}

	@Override
	public List<SecRolegroup> getAllRolegroups() {
		return secRolegroupDAO.loadAll(SecRolegroup.class);
	}

	@Override
	public List<SecTyp> getAllTypes() {
		return SecTyp.getAllTypes();
	}

	@Override
	public void delete(SecRight right) {
		secRightDAO.delete(right);
	}

	@Override
	public boolean isRightinGroup(SecRight right, SecGroup group) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(SecGroupright.class);
		criteria.add(Restrictions.eq("secGroup", group));
		criteria.add(Restrictions.eq("secRight", right));
		criteria.setProjection(Projections.rowCount());

		int count = DataAccessUtils.intResult(secGrouprightDAO
				.findByCriteria(criteria));
		return count > 0;
	}

	@Transactional
	@Override
	public void saveOrUpdate(SecRight right) {
		// if (isNewSecRight(right)) {
		// long nextId=secRightDAO.getNextidviewDAO().getNextId();
		// right.setId(nextId);
		// }
		secRightDAO.saveOrUpdate(right);
	}

	@SuppressWarnings("unused")
	private boolean isNewSecRight(SecRight right) {
		return right.getId() == Long.MIN_VALUE;
	}

	@Override
	public SecTyp getTypById(int typ_id) {
		return SecTyp.getTypById(typ_id);
	}

	@Override
	public void saveOrUpdate(SecUserrole userRole) {
		// if (isNewSecUserrole(userRole)) {
		// long nextId=secUserroleDAO.getNextidviewDAO().getNextId();
		// userRole.setId(nextId);
		// }
		secUserroleDAO.saveOrUpdate(userRole);
	}

	@SuppressWarnings("unused")
	private boolean isNewSecUserrole(SecUserrole userRole) {
		return userRole.getId() == Long.MIN_VALUE;
	}

	@Override
	public void saveOrUpdate(SecRolegroup roleGroup) {
		// if (isNewSecRolegroup(roleGroup)) {
		// long nextId=secRolegroupDAO.getNextidviewDAO().getNextId();
		// roleGroup.setId(nextId);
		// }
		secRolegroupDAO.saveOrUpdate(roleGroup);
	}

	@SuppressWarnings("unused")
	private boolean isNewSecRolegroup(SecRolegroup roleGroup) {
		return roleGroup.getId() == Long.MIN_VALUE;
	}

	@Override
	public void saveOrUpdate(SecGroup group) {
		// if (isNewSecGroup(group)) {
		// long nextId=secGroupDAO.getNextidviewDAO().getNextId();
		// group.setId(nextId);
		// }
		secGroupDAO.saveOrUpdate(group);
	}

	@SuppressWarnings("unused")
	private boolean isNewSecGroup(SecGroup group) {
		return group.getId() == Long.MIN_VALUE;
	}

	@Override
	public void saveOrUpdate(SecGroupright groupRight) {
		// if (isNewSecGroupright(groupRight)) {
		// long nextId=secGrouprightDAO.getNextidviewDAO().getNextId();
		// groupRight.setId(nextId);
		// }
		secGrouprightDAO.saveOrUpdate(groupRight);
	}

	@SuppressWarnings("unused")
	private boolean isNewSecGroupright(SecGroupright groupRight) {
		return groupRight.getId() == Long.MIN_VALUE;
	}

	@Override
	public void delete(SecGroupright groupRight) {
		secGrouprightDAO.delete(groupRight);
	}

	@Override
	public SecGroupright getGroupRightByGroupAndRight(SecGroup group,
			SecRight right) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(SecGroupright.class);
		criteria.add(Restrictions.eq("secGroup", group));
		criteria.add(Restrictions.eq("secRight", right));

		return (SecGroupright) DataAccessUtils.uniqueResult(secGrouprightDAO
				.findByCriteria(criteria));
	}

	@Override
	public SecRolegroup getRolegroupByRoleAndGroup(SecRole role, SecGroup group) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(SecRolegroup.class);
		criteria.add(Restrictions.eq("secRole", role));
		criteria.add(Restrictions.eq("secGroup", group));

		return (SecRolegroup) DataAccessUtils.uniqueResult(secRolegroupDAO
				.findByCriteria(criteria));
	}

	@Override
	public void delete(SecRolegroup roleGroup) {
		secRolegroupDAO.delete(roleGroup);
	}

	@Override
	public boolean isGroupInRole(SecGroup group, SecRole role) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(SecRolegroup.class);
		criteria.add(Restrictions.eq("secGroup", group));
		criteria.add(Restrictions.eq("secRole", role));
		criteria.setProjection(Projections.rowCount());

		int count = DataAccessUtils.intResult(secRolegroupDAO
				.findByCriteria(criteria));
		return count > 0;
	}

	@Override
	public SecUserrole getUserroleByUserAndRole(SecUser user, SecRole role) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(SecUserrole.class);
		criteria.add(Restrictions.eq("secRole", role));
		criteria.add(Restrictions.eq("secUser", user));

		return (SecUserrole) DataAccessUtils.uniqueResult(secUserroleDAO
				.findByCriteria(criteria));
	}

	@Override
	public void delete(SecUserrole userRole) {
		secUserroleDAO.delete(userRole);
	}

	@Override
	public boolean isUserInRole(SecUser user, SecRole role) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(SecUserrole.class);
		criteria.add(Restrictions.eq("secUser", user));
		criteria.add(Restrictions.eq("secRole", role));
		criteria.setProjection(Projections.rowCount());

		int count = DataAccessUtils.intResult(secUserroleDAO
				.findByCriteria(criteria));
		return count > 0;

	}

	@Override
	public List<SecRight> getAllRights(List<Integer> list) {
		// DetachedCriteria criteria =
		// DetachedCriteria.forClass(SecRight.class);
		// criteria.addOrder(Order.asc("rigName"));

		List<SecRight> result = null; // init

		// check if value is '-1'. it means 'all', no filtering
		if (list.contains(Integer.valueOf(-1))) {
			return getAllRights(-1);
		}

		// check if only 1 type
		if (list.size() == 1) {
			int i = list.get(0).intValue();
			return getAllRights(i);
		}

		// if more than one type than construct the hql query
		String hqlFrom = " from SecRight as secRight where ";
		// get the first value
		String hqlWhere = " secRight.rigType = " + list.get(0);

		for (int i = 1; i < list.size(); i++) {
			hqlWhere = hqlWhere + " or secRight.rigType = " + list.get(i);
		}

		String hqlQuery = hqlFrom + hqlWhere;

		result = secRightDAO.find(hqlQuery);

		return result;
	}

	@Override
	public List<SecRight> getRightsLikeRightName(String aRightName) {
		DetachedCriteria criteria = DetachedCriteria.forClass(SecRight.class);
		criteria.add(Restrictions.ilike("rigName", aRightName,
				MatchMode.ANYWHERE));

		return secRightDAO.findByCriteria(criteria);
	}

	@Override
	public List<SecRight> getRightsLikeRightNameAndType(String aRightName,
			int aRightType) {
		// check if the empty right is selected. This right is only for visual
		// behavior.
		if (aRightType == -1) {
			return getRightsLikeRightName(aRightName);
		}

		DetachedCriteria criteria = DetachedCriteria.forClass(SecRight.class);
		criteria.add(Restrictions.and(
				Restrictions.ilike("rigName", aRightName, MatchMode.ANYWHERE),
				Restrictions.eq("rigType", Integer.valueOf(aRightType))));

		return secRightDAO.findByCriteria(criteria);
	}

	@Override
	public List<SecGroup> getGroupsLikeGroupName(String aGroupName) {
		DetachedCriteria criteria = DetachedCriteria.forClass(SecGroup.class);
		criteria.add(Restrictions.ilike("grpShortdescription", aGroupName,
				MatchMode.ANYWHERE));

		return secGroupDAO.findByCriteria(criteria);
	}

	@Override
	public List<SecRole> getRolesLikeRoleName(String aRoleName) {
		DetachedCriteria criteria = DetachedCriteria.forClass(SecRole.class);
		criteria.add(Restrictions.ilike("rolShortdescription", aRoleName,
				MatchMode.ANYWHERE));

		return secRoleDAO.findByCriteria(criteria);
	}

	@Override
	public void delete(SecGroup group) {
		secGroupDAO.delete(group);
	}

	@Override
	public List<SecRight> getGroupRightsByGroup(SecGroup group) {
		DetachedCriteria criteria = DetachedCriteria.forClass(SecRight.class);
		// Aliases only for properties
		criteria.createAlias("secGrouprights", "gr");
		criteria.add(Restrictions.eq("gr.secGroup", group));

		return secRightDAO.findByCriteria(criteria);
	}

	@Override
	public List<SecRight> getRightsLikeRightNameAndTypes(String aRightName,
			List<Integer> list) {
		DetachedCriteria criteria = DetachedCriteria.forClass(SecRight.class);
		criteria.addOrder(Order.asc("rigName"));

		List<SecRight> result = null; // init

		String hqlFrom = "";
		String hqlWhere = "";
		String hqlAdd = "";

		// check if value is '-1'. it means 'all', no filtering
		// only if value is empty
		for (Integer integer : list) {
			if (integer.equals(new Integer(-1))) {
				if (aRightName.isEmpty()) {
					return getAllRights(integer.intValue());
				} else if (!aRightName.isEmpty()) {

					hqlFrom = " from SecRight as secRight where ";
					hqlWhere = " secRight.rigName like '%" + aRightName + "%'";
					String hqlQuery = hqlFrom + hqlWhere;

					System.out.println(hqlQuery);

					return secRightDAO.find(hqlQuery);
				}
			}
		}

		// check if only 1 type and value is empty
		if (list.size() == 1) {
			int i = list.get(0).intValue();
			if (aRightName.isEmpty()) {
				return getAllRights(i);
			}
		}

		// if more than one type than construct the hql query
		hqlFrom = " from SecRight as secRight where ";
		// get the first value
		hqlWhere = " secRight.rigType = " + list.get(0);

		for (int i = 1; i < list.size(); i++) {
			hqlWhere = hqlWhere + " or secRight.rigType = " + list.get(i);
		}

		String hqlQuery = hqlFrom + hqlWhere;

		if (!aRightName.isEmpty()) {
			// add the right name
			hqlAdd = " and secRight.rigName like '%" + aRightName + "%'";
			hqlQuery = hqlQuery + hqlAdd;
		}

		System.out.println(hqlQuery);

		result = secRightDAO.find(hqlQuery);

		return result;
	}

	@Override
	public int getCountAllSecGroup() {
		return DataAccessUtils.intResult(secGroupDAO
				.find("select count(*) from SecGroup"));
	}

	@Override
	public int getCountAllSecGroupright() {
		return DataAccessUtils.intResult(secGrouprightDAO
				.find("select count(*) from SecGroupright"));
	}

	@Override
	public int getCountAllSecRights() {
		return DataAccessUtils.intResult(secRightDAO
				.find("select count(*) from SecRight"));
	}

	@Override
	public int getCountAllSecRole() {
		return DataAccessUtils.intResult(secRoleDAO
				.find("select count(*) from SecRole"));
	}

	@Override
	public int getCountAllSecRolegroup() {
		return DataAccessUtils.intResult(secRolegroupDAO
				.find("select count(*) from SecRolegroup"));
	}

	@Override
	public int getCountAllSecUserrole() {
		return DataAccessUtils.intResult(secUserroleDAO
				.find("select count(*) from SecUserrole"));
	}

	@Override
	public List<SecGroup> getGroupsByRole(SecRole aRole) {

		DetachedCriteria criteria = DetachedCriteria.forClass(SecGroup.class);

		// Aliases are working only on properties
		criteria.createAlias("secRolegroups", "rg");
		criteria.add(Restrictions.eq("rg.secRole", aRole));

		return secGroupDAO.findByCriteria(criteria);
	}

	@Override
	public List<SecRight> getRightsByGroupright(SecGroupright secGroupright) {

		DetachedCriteria criteria = DetachedCriteria.forClass(SecRight.class);
		// Aliases only for properties
		criteria.createAlias("secGrouprights", "gr");
		criteria.add(Restrictions.eq("gr.id",
				Long.valueOf(secGroupright.getId())));

		return secRightDAO.findByCriteria(criteria);

	}

	@Override
	public SecRight getRightById(Long right_id) {
		return secRightDAO.get(SecRight.class, right_id);
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
	public SecRole getRoleById(Long role_Id) {
		return secRoleDAO.get(SecRole.class, role_Id);
	}

	@Override
	public List<SecRight> getRightsByGroup(SecGroup group) {

		DetachedCriteria criteria = DetachedCriteria.forClass(SecRight.class);
		// Aliases are working only on properties they build the JOINS
		criteria.createAlias("secGrouprights", "gr");
		criteria.add(Restrictions.eq("gr.secGroup", group));

		return secRightDAO.findByCriteria(criteria);
	}

	@Override
	public SecGroup getSecGroupById(Long secGroup_id) {
		return (SecGroup) secGroupDAO.get(SecGroup.class, secGroup_id);
	}

	@Override
	public SecGroup getGroupByGroupRight(SecGroupright secGroupright) {
		DetachedCriteria criteria = DetachedCriteria.forClass(SecGroup.class);
		// Aliases are working only on properties
		criteria.createAlias("secGrouprights", "gr");
		criteria.add(Restrictions.eq("gr.id",
				Long.valueOf(secGroupright.getId())));

		return (SecGroup) DataAccessUtils.uniqueResult(secGroupDAO
				.findByCriteria(criteria));
	}

	@Override
	public SecGroup getGroupByRolegroup(SecRolegroup secRolegroup) {
		DetachedCriteria criteria = DetachedCriteria.forClass(SecGroup.class);
		// Aliases are working only on properties
		criteria.createAlias("secRolegroups", "rg");
		criteria.add(Restrictions.eq("rg.id",
				Long.valueOf(secRolegroup.getId())));

		return (SecGroup) DataAccessUtils.uniqueResult(secGroupDAO
				.findByCriteria(criteria));
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

	@Override
	public List<SecRight> getAllRights() {
		return secRightDAO.loadAll(SecRight.class);
	}

}
