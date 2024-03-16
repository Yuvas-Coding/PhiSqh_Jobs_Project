package my.com.cmg.iwp.maintenance.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.SecRole;
import my.com.cmg.iwp.maintenance.model.SecUser;
import my.com.cmg.iwp.maintenance.service.SecRoleService;
@Service
public class SecRoleServiceImpl implements SecRoleService {
	private BasisNextidDaoImpl<SecRole> secRoleDAO;

	@Override
	public SecRole getNewSecRole() {
		return new SecRole();
	}

	@Override
	public List<SecRole> getAllRoles() {
		return getSecRoleDAO().loadAll(SecRole.class);
	}

	@Override
	public List<SecRole> getRolesByUser(SecUser aUser) {
		DetachedCriteria criteria = DetachedCriteria.forClass(SecRole.class);

		// Aliases are working only on properties
		criteria.createAlias("secUserroles", "rol");
		criteria.add(Restrictions.eq("rol.secUser", aUser));

		return getSecRoleDAO().findByCriteria(criteria);
	}

	@Override
	public SecRole getRoleById(Long role_Id) {
		return getSecRoleDAO().get(SecRole.class, role_Id);
	}

	@Override
	public List<SecRole> getRolesLikeRoleName(String aRoleName) {

		DetachedCriteria criteria = DetachedCriteria.forClass(SecRole.class);
		criteria.add(Restrictions.ilike("rolShortdescription", aRoleName,
				MatchMode.ANYWHERE));

		return getSecRoleDAO().findByCriteria(criteria);
	}

	@Override
	public int getCountAllSecRoles() {
		return DataAccessUtils.intResult(getSecRoleDAO().find(
				"select count(*) from SecRole"));
	}

	public void setSecRoleDAO(BasisNextidDaoImpl<SecRole> secRoleDAO) {
		this.secRoleDAO = secRoleDAO;
	}

	public BasisNextidDaoImpl<SecRole> getSecRoleDAO() {
		return secRoleDAO;
	}

	@Override
	public void saveOrUpdate(SecRole role) {
		getSecRoleDAO().saveOrUpdate(role);
	}

	@Override
	public void delete(SecRole role) {
		getSecRoleDAO().delete(role);
	}

	@Override
	public SecRole getSimilarRoleByRoleName(String roleName) {
		Session session = getSecRoleDAO().getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(SecRole.class);
		criteria.add(Restrictions.eq("rolShortdescription", roleName)
				.ignoreCase());
		SecRole secRole = (SecRole) criteria.uniqueResult();
		session.close();
		return secRole;
	}

	@Override
	public SecRole getRoleByRoleGroup(String roleGroup) {
		Session session = getSecRoleDAO().getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(SecRole.class);
		criteria.add(Restrictions.eq("rolShortdescription", roleGroup));
		SecRole secRole = (SecRole) criteria.uniqueResult();
		session.close();
		return secRole;
	}
}
