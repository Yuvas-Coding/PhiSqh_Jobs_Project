package my.com.cmg.iwp.maintenanceservice.fcSecService.fcSecServicelmpl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.fcSecurityModel.FcSecGroups;
import my.com.cmg.iwp.maintenance.model.fcSecurityModel.FcSecRolegroups;
import my.com.cmg.iwp.maintenance.model.fcSecurityModel.FcSecRoles;
import my.com.cmg.iwp.maintenance.service.fcSecService.FcSecRolegroupsService;

public class FcSecRolegroupsServiceImpl implements FcSecRolegroupsService {
	private BasisNextidDaoImpl<FcSecRolegroups> secRolegroupsDAO;
	private BasisNextidDaoImpl<FcSecGroups> secGroupsDAO;

	@Override
	public FcSecRolegroups getNewSecRolegroup() {
		return new FcSecRolegroups();
	}

	@Override
	public List<FcSecGroups> getGroupsByRole(FcSecRoles aRole) {

		DetachedCriteria criteria = DetachedCriteria.forClass(FcSecGroups.class);

		// Aliases are working only on properties
		criteria.createAlias("secRolegroups", "rg");
		criteria.add(Restrictions.eq("rg.secRole", aRole));

		return getsecGroupsDAO().findByCriteria(criteria);
	}

	@Override
	public List<FcSecRolegroups> getAllRolegroups() {
		return getsecRolegroupsDAO().loadAll(FcSecRolegroups.class);
	}

	@Override
	public FcSecRolegroups getRolegroupByRoleAndGroup(FcSecRoles aRole, FcSecGroups aGroup) {
		DetachedCriteria criteria = DetachedCriteria.forClass(FcSecRolegroups.class);
		criteria.add(Restrictions.eq("secRole", aRole));
		criteria.add(Restrictions.eq("secGroup", aGroup));

		return (FcSecRolegroups) DataAccessUtils.uniqueResult(getsecRolegroupsDAO().findByCriteria(criteria));

	}

	@Override
	public boolean isGroupInRole(FcSecGroups aGroup, FcSecRoles aRole) {
		DetachedCriteria criteria = DetachedCriteria.forClass(FcSecRolegroups.class);
		criteria.add(Restrictions.eq("secGroup", aGroup));
		criteria.add(Restrictions.eq("secRole", aRole));
		criteria.setProjection(Projections.rowCount());

		int count = DataAccessUtils.intResult(getsecRolegroupsDAO().findByCriteria(criteria));
		return count > 0;
	}

	@Override
	public int getCountAllSecRolegroups() {
		return DataAccessUtils.intResult(getsecRolegroupsDAO().find("select count(*) from SecRolegroup"));
	}

	public void setsecRolegroupsDAO(BasisNextidDaoImpl<FcSecRolegroups> secRolegroupsDAO) {
		this.secRolegroupsDAO = secRolegroupsDAO;
	}

	public BasisNextidDaoImpl<FcSecRolegroups> getsecRolegroupsDAO() {
		return secRolegroupsDAO;
	}

	public void setsecGroupsDAO(BasisNextidDaoImpl<FcSecGroups> secGroupsDAO) {
		this.secGroupsDAO = secGroupsDAO;
	}

	public BasisNextidDaoImpl<FcSecGroups> getsecGroupsDAO() {
		return secGroupsDAO;
	}

	@Override
	public void saveOrUpdate(FcSecRolegroups roleGroup) {
		getsecRolegroupsDAO().saveOrUpdate(roleGroup);
	}

	@Override
	public void delete(FcSecRolegroups roleGroup) {
		getsecRolegroupsDAO().delete(roleGroup);
	}

	/*
	 * @Override public List<SecRolegroup> getSecGroupBy(SecUser secUser){ Session session = getsecRolegroupsDAO().getSessionFactory().openSession(); String stringQuery = "select *" + "from sec_user u,sec_userrole r, sec_role sr,sec_rolegroup rg " + "where u.usr_id=r.usr_id " + "and r.rol_id=sr.rol_id " + "and sr.rol_id=rg.rol_id " + "and u.usr_id=:id "; List<SecRolegroup> secRolegroups = null; try
	 * { Query query = session.createSQLQuery(stringQuery) .addEntity(SecRolegroup.class) .setParameter("id", secUser.getId()); secRolegroups = query.list(); } catch (HibernateException e) { // TODO Auto-generated catch block e.printStackTrace(); } finally { session.close(); } return secRolegroups; }
	 */
}
