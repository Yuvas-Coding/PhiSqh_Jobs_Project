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
package my.com.cmg.iwp.maintenanceservice.fcSecService.fcSecServicelmpl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.transaction.annotation.Transactional;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.fcSecurityModel.FcSecGrouprights;
import my.com.cmg.iwp.maintenance.model.fcSecurityModel.FcSecGroups;
import my.com.cmg.iwp.maintenance.model.fcSecurityModel.FcSecRights;
import my.com.cmg.iwp.maintenance.model.fcSecurityModel.FcSecRolegroups;
import my.com.cmg.iwp.maintenance.model.fcSecurityModel.FcSecRoles;
import my.com.cmg.iwp.maintenance.model.fcSecurityModel.FcSecTyp;
import my.com.cmg.iwp.maintenance.service.fcSecService.FcSecurityServices;

/**
 * Service implementation for methods that depends on <b>Security model</b> classes.<br>
 * 
 * @author bbruhns
 * @author sgerth
 */
public class FcSecurityServicesImpl implements FcSecurityServices {

	private BasisNextidDaoImpl<FcSecRoles> secRolesDAO;
	private BasisNextidDaoImpl<FcSecRolegroups> secRolegroupsDAO;
	private BasisNextidDaoImpl<FcSecGrouprights> secGrouprightsDAO;
	private BasisNextidDaoImpl<FcSecGroups> secGroupsDAO;
	private BasisNextidDaoImpl<FcSecRights> secRightsDAO;


	public BasisNextidDaoImpl<FcSecRoles> getsecRolesDAO() {
		return secRolesDAO;
	}

	public void setsecRolesDAO(BasisNextidDaoImpl<FcSecRoles> secRolesDAO) {
		this.secRolesDAO = secRolesDAO;
	}

	public BasisNextidDaoImpl<FcSecRolegroups> getsecRolegroupsDAO() {
		return secRolegroupsDAO;
	}

	public void setsecRolegroupsDAO(BasisNextidDaoImpl<FcSecRolegroups> secRolegroupsDAO) {
		this.secRolegroupsDAO = secRolegroupsDAO;
	}

	public BasisNextidDaoImpl<FcSecGrouprights> getsecGrouprightsDAO() {
		return secGrouprightsDAO;
	}

	public void setsecGrouprightsDAO(BasisNextidDaoImpl<FcSecGrouprights> secGrouprightsDAO) {
		this.secGrouprightsDAO = secGrouprightsDAO;
	}

	public BasisNextidDaoImpl<FcSecGroups> getsecGroupsDAO() {
		return secGroupsDAO;
	}

	public void setsecGroupsDAO(BasisNextidDaoImpl<FcSecGroups> secGroupsDAO) {
		this.secGroupsDAO = secGroupsDAO;
	}

	public BasisNextidDaoImpl<FcSecRights> getsecRightsDAO() {
		return secRightsDAO;
	}

	public void setsecRightsDAO(BasisNextidDaoImpl<FcSecRights> secRightsDAO) {
		this.secRightsDAO = secRightsDAO;
	}

	@Override
	public List<FcSecRoles> getAllRoles() {
		return secRolesDAO.loadAll(FcSecRoles.class);
	}

	@Override
	public void saveOrUpdate(FcSecRoles role) {
		// if (isNewSecRole(role)) {
		// long nextId=secRolesDAO.getNextidviewDAO().getNextId();
		// role.setId(nextId);
		// }
		secRolesDAO.saveOrUpdate(role);
	}

	@SuppressWarnings("unused")
	private boolean isNewSecRole(FcSecRoles role) {
		return role.getId() == Long.MIN_VALUE;
	}

	@Override
	public void delete(FcSecRoles role) {
		secRolesDAO.delete(role);
	}

	@Override
	public List<FcSecGroups> getAllGroups() {
		DetachedCriteria criteria = DetachedCriteria.forClass(FcSecGroups.class);
		criteria.addOrder(Order.asc("grpShortdescription"));

		return secGroupsDAO.findByCriteria(criteria);
	}

	@Override
	public List<FcSecRights> getAllRights(int type) {
		DetachedCriteria criteria = DetachedCriteria.forClass(FcSecRights.class);
		criteria.addOrder(Order.asc("rigName"));

		if (type != -1) {
			criteria.add(Restrictions.eq("rigType", Integer.valueOf(type)));
			// criteria.add(Restrictions.or(Restrictions.eq("rigType", 2),
			// Restrictions.eq("rigType", 1)));
		}

		return secRightsDAO.findByCriteria(criteria);
	}

	@Override
	public FcSecGroups getNewSecGroup() {
		return new FcSecGroups();
	}

	@Override
	public FcSecRights getNewSecRight() {
		return new FcSecRights();
	}

	@Override
	public FcSecRoles getNewSecRole() {
		return new FcSecRoles();
	}

	@Override
	public List<FcSecGrouprights> getAllGroupRights() {
		return secGrouprightsDAO.loadAll(FcSecGrouprights.class);
	}

	@Override
	public FcSecGrouprights getNewSecGroupright() {
		return new FcSecGrouprights();
	}

	@Override
	public FcSecRolegroups getNewSecRolegroup() {
		return new FcSecRolegroups();
	}

	@Override
	public List<FcSecRolegroups> getAllRolegroups() {
		return secRolegroupsDAO.loadAll(FcSecRolegroups.class);
	}

	@Override
	public List<FcSecTyp> getAllTypes() {
		return FcSecTyp.getAllTypes();
	}

	@Override
	public void delete(FcSecRights right) {
		secRightsDAO.delete(right);
	}

	@Override
	public boolean isRightinGroup(FcSecRights right, FcSecGroups group) {
		DetachedCriteria criteria = DetachedCriteria.forClass(FcSecGrouprights.class);
		criteria.add(Restrictions.eq("secGroup", group));
		criteria.add(Restrictions.eq("secRight", right));
		criteria.setProjection(Projections.rowCount());

		int count = DataAccessUtils.intResult(secGrouprightsDAO.findByCriteria(criteria));
		return count > 0;
	}

	@Transactional
	@Override
	public void saveOrUpdate(FcSecRights right) {
		// if (isNewSecRight(right)) {
		// long nextId=secRightsDAO.getNextidviewDAO().getNextId();
		// right.setId(nextId);
		// }
		secRightsDAO.saveOrUpdate(right);
	}

	@SuppressWarnings("unused")
	private boolean isNewSecRight(FcSecRights right) {
		return right.getId() == Long.MIN_VALUE;
	}

	@Override
	public FcSecTyp getTypById(int typ_id) {
		return FcSecTyp.getTypById(typ_id);
	}	

	@Override
	public void saveOrUpdate(FcSecRolegroups roleGroup) {
		// if (isNewSecRolegroup(roleGroup)) {
		// long nextId=secRolegroupsDAO.getNextidviewDAO().getNextId();
		// roleGroup.setId(nextId);
		// }
		secRolegroupsDAO.saveOrUpdate(roleGroup);
	}

	@SuppressWarnings("unused")
	private boolean isNewSecRolegroup(FcSecRolegroups roleGroup) {
		return roleGroup.getId() == Long.MIN_VALUE;
	}

	@Override
	public void saveOrUpdate(FcSecGroups group) {
		// if (isNewSecGroup(group)) {
		// long nextId=secGroupsDAO.getNextidviewDAO().getNextId();
		// group.setId(nextId);
		// }
		secGroupsDAO.saveOrUpdate(group);
	}

	@SuppressWarnings("unused")
	private boolean isNewSecGroup(FcSecGroups group) {
		return group.getId() == Long.MIN_VALUE;
	}

	@Override
	public void saveOrUpdate(FcSecGrouprights groupRight) {
		// if (isNewSecGroupright(groupRight)) {
		// long nextId=secGrouprightsDAO.getNextidviewDAO().getNextId();
		// groupRight.setId(nextId);
		// }
		secGrouprightsDAO.saveOrUpdate(groupRight);
	}

	@SuppressWarnings("unused")
	private boolean isNewSecGroupright(FcSecGrouprights groupRight) {
		return groupRight.getId() == Long.MIN_VALUE;
	}

	@Override
	public void delete(FcSecGrouprights groupRight) {
		secGrouprightsDAO.delete(groupRight);
	}

	@Override
	public FcSecGrouprights getGroupRightByGroupAndRight(FcSecGroups group, FcSecRights right) {
		DetachedCriteria criteria = DetachedCriteria.forClass(FcSecGrouprights.class);
		criteria.add(Restrictions.eq("secGroup", group));
		criteria.add(Restrictions.eq("secRight", right));

		return (FcSecGrouprights) DataAccessUtils.uniqueResult(secGrouprightsDAO.findByCriteria(criteria));
	}

	@Override
	public FcSecRolegroups getRolegroupByRoleAndGroup(FcSecRoles role, FcSecGroups group) {
		DetachedCriteria criteria = DetachedCriteria.forClass(FcSecRolegroups.class);
		criteria.add(Restrictions.eq("secRole", role));
		criteria.add(Restrictions.eq("secGroup", group));

		return (FcSecRolegroups) DataAccessUtils.uniqueResult(secRolegroupsDAO.findByCriteria(criteria));
	}

	@Override
	public void delete(FcSecRolegroups roleGroup) {
		secRolegroupsDAO.delete(roleGroup);
	}

	@Override
	public boolean isGroupInRole(FcSecGroups group, FcSecRoles role) {
		DetachedCriteria criteria = DetachedCriteria.forClass(FcSecRolegroups.class);
		criteria.add(Restrictions.eq("secGroup", group));
		criteria.add(Restrictions.eq("secRole", role));
		criteria.setProjection(Projections.rowCount());

		int count = DataAccessUtils.intResult(secRolegroupsDAO.findByCriteria(criteria));
		return count > 0;
	}

	@Override
	public List<FcSecRights> getAllRights(List<Integer> list) {
		// DetachedCriteria criteria =
		// DetachedCriteria.forClass(SecRight.class);
		// criteria.addOrder(Order.asc("rigName"));

		List<FcSecRights> result = null; // init

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

		result = secRightsDAO.find(hqlQuery);

		return result;
	}

	@Override
	public List<FcSecRights> getRightsLikeRightName(String aRightName) {
		DetachedCriteria criteria = DetachedCriteria.forClass(FcSecRights.class);
		criteria.add(Restrictions.ilike("rigName", aRightName, MatchMode.ANYWHERE));

		return secRightsDAO.findByCriteria(criteria);
	}

	@Override
	public List<FcSecRights> getRightsLikeRightNameAndType(String aRightName, int aRightType) {
		// check if the empty right is selected. This right is only for visual
		// behavior.
		if (aRightType == -1) {
			return getRightsLikeRightName(aRightName);
		}

		DetachedCriteria criteria = DetachedCriteria.forClass(FcSecRights.class);
		criteria.add(Restrictions.and(Restrictions.ilike("rigName", aRightName, MatchMode.ANYWHERE), Restrictions.eq("rigType", Integer.valueOf(aRightType))));

		return secRightsDAO.findByCriteria(criteria);
	}

	@Override
	public List<FcSecGroups> getGroupsLikeGroupName(String aGroupName) {
		DetachedCriteria criteria = DetachedCriteria.forClass(FcSecGroups.class);
		criteria.add(Restrictions.ilike("grpShortdescription", aGroupName, MatchMode.ANYWHERE));

		return secGroupsDAO.findByCriteria(criteria);
	}

	@Override
	public List<FcSecRoles> getRolesLikeRoleName(String aRoleName) {
		DetachedCriteria criteria = DetachedCriteria.forClass(FcSecRoles.class);
		criteria.add(Restrictions.ilike("rolShortdescription", aRoleName, MatchMode.ANYWHERE));

		return secRolesDAO.findByCriteria(criteria);
	}

	@Override
	public void delete(FcSecGroups group) {
		secGroupsDAO.delete(group);
	}

	@Override
	public List<FcSecRights> getGroupRightsByGroup(FcSecGroups group) {
		DetachedCriteria criteria = DetachedCriteria.forClass(FcSecRights.class);
		// Aliases only for properties
		criteria.createAlias("secGrouprights", "gr");
		criteria.add(Restrictions.eq("gr.secGroup", group));

		return secRightsDAO.findByCriteria(criteria);
	}
	
	@Override
	public List<FcSecGroups> getGroupRightsByGroup(FcSecRights rights) {
		DetachedCriteria criteria = DetachedCriteria.forClass(FcSecGroups.class);
		// Aliases only for properties
		criteria.createAlias("secGrouprights", "gr");
		criteria.add(Restrictions.eq("gr.secRight", rights));

		return secGroupsDAO.findByCriteria(criteria);
	}
	
	@Override
	public List<FcSecRoles> getGroupRightsByGroup(FcSecRoles roles) {
		DetachedCriteria criteria = DetachedCriteria.forClass(FcSecRoles.class);
		// Aliases only for properties
		criteria.createAlias("secRolegroups", "gr");
		criteria.add(Restrictions.eq("gr.secRole", roles));

		return secRolesDAO.findByCriteria(criteria);
	}

	@Override
	public List<FcSecRights> getRightsLikeRightNameAndTypes(String aRightName, List<Integer> list) {
		DetachedCriteria criteria = DetachedCriteria.forClass(FcSecRights.class);
		criteria.addOrder(Order.asc("rigName"));

		List<FcSecRights> result = null; // init

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

					return secRightsDAO.find(hqlQuery);
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

		result = secRightsDAO.find(hqlQuery);

		return result;
	}

	@Override
	public int getCountAllSecGroup() {
		return DataAccessUtils.intResult(secGroupsDAO.find("select count(*) from SecGroup"));
	}

	@Override
	public int getCountAllSecGroupright() {
		return DataAccessUtils.intResult(secGrouprightsDAO.find("select count(*) from SecGroupright"));
	}

	@Override
	public int getCountAllSecRights() {
		return DataAccessUtils.intResult(secRightsDAO.find("select count(*) from SecRight"));
	}

	@Override
	public int getCountAllSecRole() {
		return DataAccessUtils.intResult(secRolesDAO.find("select count(*) from SecRole"));
	}

	@Override
	public int getCountAllSecRolegroup() {
		return DataAccessUtils.intResult(secRolegroupsDAO.find("select count(*) from SecRolegroup"));
	}	

	@Override
	public List<FcSecGroups> getGroupsByRole(FcSecRoles aRole) {

		DetachedCriteria criteria = DetachedCriteria.forClass(FcSecGroups.class);

		// Aliases are working only on properties
		criteria.createAlias("secRolegroups", "rg");
		criteria.add(Restrictions.eq("rg.secRole", aRole));

		return secGroupsDAO.findByCriteria(criteria);
	}

	@Override
	public List<FcSecRights> getRightsByGroupright(FcSecGrouprights secGroupright) {

		DetachedCriteria criteria = DetachedCriteria.forClass(FcSecRights.class);
		// Aliases only for properties
		criteria.createAlias("secGrouprights", "gr");
		criteria.add(Restrictions.eq("gr.id", Long.valueOf(secGroupright.getId())));

		return secRightsDAO.findByCriteria(criteria);

	}

	@Override
	public FcSecRights getRightById(Long right_id) {
		return secRightsDAO.get(FcSecRights.class, right_id);
	}

	@Override
	public FcSecRoles getRoleById(Long role_Id) {
		return secRolesDAO.get(FcSecRoles.class, role_Id);
	}

	@Override
	public List<FcSecRights> getRightsByGroup(FcSecGroups group) {

		DetachedCriteria criteria = DetachedCriteria.forClass(FcSecRights.class);
		// Aliases are working only on properties they build the JOINS
		criteria.createAlias("secGrouprights", "gr");
		criteria.add(Restrictions.eq("gr.secGroup", group));

		return secRightsDAO.findByCriteria(criteria);
	}

	@Override
	public FcSecGroups getSecGroupById(Long secGroup_id) {
		return (FcSecGroups) secGroupsDAO.get(FcSecGroups.class, secGroup_id);
	}

	@Override
	public FcSecGroups getGroupByGroupRight(FcSecGrouprights secGroupright) {
		DetachedCriteria criteria = DetachedCriteria.forClass(FcSecGroups.class);
		// Aliases are working only on properties
		criteria.createAlias("secGrouprights", "gr");
		criteria.add(Restrictions.eq("gr.id", Long.valueOf(secGroupright.getId())));

		return (FcSecGroups) DataAccessUtils.uniqueResult(secGroupsDAO.findByCriteria(criteria));
	}

	@Override
	public FcSecGroups getGroupByRolegroup(FcSecRolegroups secRolegroup) {
		DetachedCriteria criteria = DetachedCriteria.forClass(FcSecGroups.class);
		// Aliases are working only on properties
		criteria.createAlias("secRolegroups", "rg");
		criteria.add(Restrictions.eq("rg.id", Long.valueOf(secRolegroup.getId())));

		return (FcSecGroups) DataAccessUtils.uniqueResult(secGroupsDAO.findByCriteria(criteria));
	}

	@Override
	public List<FcSecRights> getAllRights() {
		return secRightsDAO.loadAll(FcSecRights.class);
	}

}
