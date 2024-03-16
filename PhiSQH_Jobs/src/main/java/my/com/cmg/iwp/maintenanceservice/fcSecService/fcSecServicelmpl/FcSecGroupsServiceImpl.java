package my.com.cmg.iwp.maintenanceservice.fcSecService.fcSecServicelmpl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.fcSecurityModel.FcSecGrouprights;
import my.com.cmg.iwp.maintenance.model.fcSecurityModel.FcSecGroups;
import my.com.cmg.iwp.maintenance.model.fcSecurityModel.FcSecRolegroups;
import my.com.cmg.iwp.maintenance.service.fcSecService.FcSecGroupsService;

public class FcSecGroupsServiceImpl implements FcSecGroupsService {
	private BasisNextidDaoImpl<FcSecGroups> secGroupsDAO;

	@Override
	public FcSecGroups getNewSecGroup() {
		return new FcSecGroups();
	}

	@Override
	public List<FcSecGroups> getAllGroups() {
		DetachedCriteria criteria = DetachedCriteria.forClass(FcSecGroups.class);
		criteria.addOrder(Order.asc("grpShortdescription"));

		return getsecGroupsDAO().findByCriteria(criteria);
	}

	@Override
	public FcSecGroups getSecGroupById(Long secGroup_id) {
		return getsecGroupsDAO().get(FcSecGroups.class, secGroup_id);
	}

	@Override
	public FcSecGroups getGroupByGroupRight(FcSecGrouprights secGroupright) {
		DetachedCriteria criteria = DetachedCriteria.forClass(FcSecGroups.class);
		// Aliases are working only on properties
		criteria.createAlias("secGrouprights", "gr");
		criteria.add(Restrictions.eq("gr.id", Long.valueOf(secGroupright.getId())));

		return (FcSecGroups) DataAccessUtils.uniqueResult(getsecGroupsDAO().findByCriteria(criteria));
	}

	@Override
	public FcSecGroups getGroupByRolegroup(FcSecRolegroups secRolegroup) {
		DetachedCriteria criteria = DetachedCriteria.forClass(FcSecGroups.class);
		// Aliases are working only on properties
		criteria.createAlias("secRolegroups", "rg");
		criteria.add(Restrictions.eq("rg.id", Long.valueOf(secRolegroup.getId())));

		return (FcSecGroups) DataAccessUtils.uniqueResult(getsecGroupsDAO().findByCriteria(criteria));
	}

	/*
	 * @Override public List<SecGroup> getGroupsByUser(SecUser aUser) { DetachedCriteria criteria = DetachedCriteria.forClass(SecGroup.class); // Aliases are working only on properties criteria.createAlias("secRolegroups", "rg"); criteria.createAlias("secRoles", "rol"); criteria.add(Restrictions.eq("rg.rol.secUser", aUser)); return getsecGroupsDAO().findByCriteria(criteria); }
	 */

	@Override
	public List<FcSecGroups> getGroupsLikeGroupName(String aGroupName) {
		DetachedCriteria criteria = DetachedCriteria.forClass(FcSecGroups.class);
		criteria.add(Restrictions.ilike("grpShortdescription", aGroupName, MatchMode.ANYWHERE));

		return getsecGroupsDAO().findByCriteria(criteria);
	}

	@Override
	public int getCountAllSecGroups() {
		return DataAccessUtils.intResult(getsecGroupsDAO().find("select count(*) from SecGroup"));
	}

	public void setsecGroupsDAO(BasisNextidDaoImpl<FcSecGroups> secGroupsDAO) {
		this.secGroupsDAO = secGroupsDAO;
	}

	public BasisNextidDaoImpl<FcSecGroups> getsecGroupsDAO() {
		return secGroupsDAO;
	}

	@Override
	public void saveOrUpdate(FcSecGroups group) {
		getsecGroupsDAO().saveOrUpdate(group);
	}

	@Override
	public void delete(FcSecGroups group) {
		getsecGroupsDAO().delete(group);
	}

	@Override
	public FcSecGroups getSimilarGroupByGroupName(String value) {

		DetachedCriteria criteria = DetachedCriteria.forClass(FcSecGroups.class);
		criteria.add(Restrictions.eq("grpShortdescription", value).ignoreCase());
		return (FcSecGroups) DataAccessUtils.uniqueResult(getsecGroupsDAO().findByCriteria(criteria));
	}
}
