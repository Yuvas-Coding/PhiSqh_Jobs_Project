package my.com.cmg.iwp.maintenance.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.SecGroup;
import my.com.cmg.iwp.maintenance.model.SecRole;
import my.com.cmg.iwp.maintenance.model.SecRolegroup;
import my.com.cmg.iwp.maintenance.service.SecRolegroupService;
@Service
public class SecRolegroupServiceImpl implements SecRolegroupService {
	private BasisNextidDaoImpl<SecRolegroup> secRolegroupDAO;
	private BasisNextidDaoImpl<SecGroup> secGroupDAO;

	@Override
	public SecRolegroup getNewSecRolegroup() {
		return new SecRolegroup();
	}

	@Override
	public List<SecGroup> getGroupsByRole(SecRole aRole) {

		DetachedCriteria criteria = DetachedCriteria.forClass(SecGroup.class);

		// Aliases are working only on properties
		criteria.createAlias("secRolegroups", "rg");
		criteria.add(Restrictions.eq("rg.secRole", aRole));

		return getSecGroupDAO().findByCriteria(criteria);
	}

	@Override
	public List<SecRolegroup> getAllRolegroups() {
		return getSecRolegroupDAO().loadAll(SecRolegroup.class);
	}

	@Override
	public SecRolegroup getRolegroupByRoleAndGroup(SecRole aRole,
			SecGroup aGroup) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(SecRolegroup.class);
		criteria.add(Restrictions.eq("secRole", aRole));
		criteria.add(Restrictions.eq("secGroup", aGroup));

		return (SecRolegroup) DataAccessUtils.uniqueResult(getSecRolegroupDAO()
				.findByCriteria(criteria));

	}

	@Override
	public boolean isGroupInRole(SecGroup aGroup, SecRole aRole) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(SecRolegroup.class);
		criteria.add(Restrictions.eq("secGroup", aGroup));
		criteria.add(Restrictions.eq("secRole", aRole));
		criteria.setProjection(Projections.rowCount());

		int count = DataAccessUtils.intResult(getSecRolegroupDAO()
				.findByCriteria(criteria));
		return count > 0;
	}

	@Override
	public int getCountAllSecRolegroups() {
		return DataAccessUtils.intResult(getSecRolegroupDAO().find(
				"select count(*) from SecRolegroup"));
	}

	public void setSecRolegroupDAO(
			BasisNextidDaoImpl<SecRolegroup> secRolegroupDAO) {
		this.secRolegroupDAO = secRolegroupDAO;
	}

	public BasisNextidDaoImpl<SecRolegroup> getSecRolegroupDAO() {
		return secRolegroupDAO;
	}

	public void setSecGroupDAO(BasisNextidDaoImpl<SecGroup> secGroupDAO) {
		this.secGroupDAO = secGroupDAO;
	}

	public BasisNextidDaoImpl<SecGroup> getSecGroupDAO() {
		return secGroupDAO;
	}

	@Override
	public void saveOrUpdate(SecRolegroup roleGroup) {
		getSecRolegroupDAO().saveOrUpdate(roleGroup);
	}

	@Override
	public void delete(SecRolegroup roleGroup) {
		getSecRolegroupDAO().delete(roleGroup);
	}
}
