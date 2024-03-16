package my.com.cmg.iwp.maintenance.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.SecRole;
import my.com.cmg.iwp.maintenance.model.SecUser;
import my.com.cmg.iwp.maintenance.model.SecUserrole;
import my.com.cmg.iwp.maintenance.service.SecUserroleService;
@Service
public class SecUserroleServiceImpl implements SecUserroleService {
	BasisNextidDaoImpl<SecUserrole> secUserroleDAO;

	public BasisNextidDaoImpl<SecUserrole> getSecUserroleDAO() {
		return secUserroleDAO;
	}

	public void setSecUserroleDAO(BasisNextidDaoImpl<SecUserrole> secUserroleDAO) {
		this.secUserroleDAO = secUserroleDAO;
	}

	@Override
	public SecUserrole getNewSecUserrole() {
		return new SecUserrole();
	}

	@Override
	public List<SecUserrole> getAllUserRoles() {
		return getSecUserroleDAO().loadAll(SecUserrole.class);
	}

	@Override
	public SecUserrole getUserroleByUserAndRole(SecUser aUser, SecRole aRole) {

		DetachedCriteria criteria = DetachedCriteria
				.forClass(SecUserrole.class);
		criteria.add(Restrictions.eq("secRole", aRole));
		criteria.add(Restrictions.eq("secUser", aUser));

		return (SecUserrole) DataAccessUtils.uniqueResult(getSecUserroleDAO()
				.findByCriteria(criteria));
	}

	@Override
	public boolean isUserInRole(SecUser aUser, SecRole aRole) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(SecUserrole.class);
		criteria.add(Restrictions.eq("secUser", aUser));
		criteria.add(Restrictions.eq("secRole", aRole));
		criteria.setProjection(Projections.rowCount());

		int count = DataAccessUtils.intResult(getSecUserroleDAO()
				.findByCriteria(criteria));
		return count > 0;
	}

	@Override
	public int getCountAllSecUserroles() {
		return DataAccessUtils.intResult(getSecUserroleDAO().find(
				"select count(*) from SecUserrole"));
	}

	@Override
	public void saveOrUpdate(SecUserrole userRole) {
		getSecUserroleDAO().saveOrUpdate(userRole);
	}

	@Override
	public void delete(SecUserrole userRole) {
		getSecUserroleDAO().delete(userRole);
	}
}
