package my.com.cmg.iwp.maintenanceservice.fcSecService.fcSecServicelmpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.fcSecurityModel.FcSecRoles;
import my.com.cmg.iwp.maintenance.service.fcSecService.FcSecRolesService;

public class FcSecRolesServiceImpl implements FcSecRolesService {
	private BasisNextidDaoImpl<FcSecRoles> secRolesDAO;

	@Override
	public FcSecRoles getNewSecRole() {
		return new FcSecRoles();
	}

	@Override
	public List<FcSecRoles> getAllRoles() {
		return getsecRolesDAO().loadAll(FcSecRoles.class);
	}

	/*
	 * @Override public List<SecRole> getRolesByUser(SecUser aUser) { DetachedCriteria criteria = DetachedCriteria.forClass(SecRole.class); // Aliases are working only on properties criteria.createAlias("secUserroles", "rol"); criteria.add(Restrictions.eq("rol.secUser", aUser)); return getsecRolesDAO().findByCriteria(criteria); }
	 */

	@Override
	public FcSecRoles getRoleById(Long role_Id) {
		return getsecRolesDAO().get(FcSecRoles.class, role_Id);
	}

	@Override
	public List<FcSecRoles> getRolesLikeRoleName(String aRoleName) {

		DetachedCriteria criteria = DetachedCriteria.forClass(FcSecRoles.class);
		criteria.add(Restrictions.ilike("rolShortdescription", aRoleName, MatchMode.ANYWHERE));

		return getsecRolesDAO().findByCriteria(criteria);
	}

	@Override
	public int getCountAllSecRoles() {
		return DataAccessUtils.intResult(getsecRolesDAO().find("select count(*) from SecRole"));
	}

	public void setsecRolesDAO(BasisNextidDaoImpl<FcSecRoles> secRolesDAO) {
		this.secRolesDAO = secRolesDAO;
	}

	public BasisNextidDaoImpl<FcSecRoles> getsecRolesDAO() {
		return secRolesDAO;
	}

	@Override
	public void saveOrUpdate(FcSecRoles role) {
		getsecRolesDAO().saveOrUpdate(role);
	}

	@Override
	public void delete(FcSecRoles role) {
		getsecRolesDAO().delete(role);
	}

	@Override
	public FcSecRoles getRoleByRoleGroup(String roleGroup) {
		Session session = getsecRolesDAO().getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(FcSecRoles.class);
		criteria.add(Restrictions.eq("rolShortdescription", roleGroup));
		FcSecRoles secRole = (FcSecRoles) criteria.uniqueResult();
		session.close();
		return secRole;
	}

	@Override
	public FcSecRoles getSimilarRoleByRoleName(String roleName) {
		Session session = getsecRolesDAO().getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(FcSecRoles.class);
		criteria.add(Restrictions.eq("rolShortdescription", roleName).ignoreCase());
		FcSecRoles secRole = (FcSecRoles) criteria.uniqueResult();
		session.close();
		return secRole;
	}

	/*
	 * @Override public List<SecRole> getRolesByUserAndRolShortDesc(SecUser user, String nurseSubmit, String pharmacistConfirm) { List<SecRole>list = new ArrayList<SecRole>(); // Session session = getsecRolesDAO().getSessionFactory().openSession(); DetachedCriteria criteria = DetachedCriteria .forClass(SecRole.class); Criterion crit1 = Restrictions.eq("rolShortdescription", nurseSubmit); Criterion
	 * crit2 = Restrictions.eq("rolShortdescription", pharmacistConfirm); criteria.add(Restrictions.or(crit1, crit2)); // SecRole secRole = (SecRole) criteria.uniqueResult(); // if(!list.contains(secRole)){ // list.add(secRole); // } // session.close(); // return list; criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY); return secRolesDAO.findByCriteria(criteria); }
	 */
}
