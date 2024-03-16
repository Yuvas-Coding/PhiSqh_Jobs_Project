package my.com.cmg.iwp.maintenance.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.SecGroup;
import my.com.cmg.iwp.maintenance.model.SecGroupright;
import my.com.cmg.iwp.maintenance.model.SecRolegroup;
import my.com.cmg.iwp.maintenance.model.SecUser;
import my.com.cmg.iwp.maintenance.service.SecGroupService;
@Service
public class SecGroupServiceImpl implements SecGroupService {
	private BasisNextidDaoImpl<SecGroup> secGroupDAO;

	@Override
	public SecGroup getNewSecGroup() {
		return new SecGroup();
	}

	@Override
	public List<SecGroup> getAllGroups() {
		DetachedCriteria criteria = DetachedCriteria.forClass(SecGroup.class);
		criteria.addOrder(Order.asc("grpShortdescription"));

		return getSecGroupDAO().findByCriteria(criteria);
	}

	@Override
	public SecGroup getSecGroupById(Long secGroup_id) {
		return getSecGroupDAO().get(SecGroup.class, secGroup_id);
	}

	@Override
	public SecGroup getGroupByGroupRight(SecGroupright secGroupright) {
		DetachedCriteria criteria = DetachedCriteria.forClass(SecGroup.class);
		// Aliases are working only on properties
		criteria.createAlias("secGrouprights", "gr");
		criteria.add(Restrictions.eq("gr.id",
				Long.valueOf(secGroupright.getId())));

		return (SecGroup) DataAccessUtils.uniqueResult(getSecGroupDAO()
				.findByCriteria(criteria));
	}

	@Override
	public SecGroup getGroupByRolegroup(SecRolegroup secRolegroup) {
		DetachedCriteria criteria = DetachedCriteria.forClass(SecGroup.class);
		// Aliases are working only on properties
		criteria.createAlias("secRolegroups", "rg");
		criteria.add(Restrictions.eq("rg.id",
				Long.valueOf(secRolegroup.getId())));

		return (SecGroup) DataAccessUtils.uniqueResult(getSecGroupDAO()
				.findByCriteria(criteria));
	}

	@Override
	public List<SecGroup> getGroupsByUser(SecUser aUser) {
		DetachedCriteria criteria = DetachedCriteria.forClass(SecGroup.class);
		// Aliases are working only on properties
		criteria.createAlias("secRolegroups", "rg");
		criteria.createAlias("secRoles", "rol");
		criteria.add(Restrictions.eq("rg.rol.secUser", aUser));

		return getSecGroupDAO().findByCriteria(criteria);
	}

	@Override
	public List<SecGroup> getGroupsLikeGroupName(String aGroupName) {
		DetachedCriteria criteria = DetachedCriteria.forClass(SecGroup.class);
		criteria.add(Restrictions.ilike("grpShortdescription", aGroupName,
				MatchMode.ANYWHERE));

		return getSecGroupDAO().findByCriteria(criteria);
	}

	@Override
	public int getCountAllSecGroups() {
		return DataAccessUtils.intResult(getSecGroupDAO().find(
				"select count(*) from SecGroup"));
	}

	public void setSecGroupDAO(BasisNextidDaoImpl<SecGroup> secGroupDAO) {
		this.secGroupDAO = secGroupDAO;
	}

	public BasisNextidDaoImpl<SecGroup> getSecGroupDAO() {
		return secGroupDAO;
	}

	@Override
	public void saveOrUpdate(SecGroup group) {
		getSecGroupDAO().saveOrUpdate(group);
	}

	@Override
	public void delete(SecGroup group) {
		getSecGroupDAO().delete(group);
	}

	@Override
	public SecGroup getSimilarGroupByGroupName(String value) {

		DetachedCriteria criteria = DetachedCriteria.forClass(SecGroup.class);
		criteria.add(Restrictions.eq("grpShortdescription", value).ignoreCase());
		return (SecGroup) DataAccessUtils.uniqueResult(getSecGroupDAO()
				.findByCriteria(criteria));
	}
}
