package my.com.cmg.iwp.maintenanceservice.fcSecService.fcSecServicelmpl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.fcSecurityModel.FcSecGrouprights;
import my.com.cmg.iwp.maintenance.model.fcSecurityModel.FcSecGroups;
import my.com.cmg.iwp.maintenance.model.fcSecurityModel.FcSecRights;
import my.com.cmg.iwp.maintenance.service.fcSecService.FcSecGrouprightsService;

public class FcSecGrouprightsServiceImpl implements FcSecGrouprightsService {
	private BasisNextidDaoImpl<FcSecGrouprights> secGrouprightsDAO;
	private BasisNextidDaoImpl<FcSecRights> secRightsDAO;

	@Override
	public FcSecGrouprights getNewSecGroupright() {
		return new FcSecGrouprights();
	}

	@Override
	public List<FcSecRights> getRightsByGroup(FcSecGroups group) {

		DetachedCriteria criteria = DetachedCriteria.forClass(FcSecRights.class);
		// Aliases are working only on properties they build the JOINS
		criteria.createAlias("secGrouprights", "gr");
		criteria.add(Restrictions.eq("gr.secGroup", group));

		return getsecRightsDAO().findByCriteria(criteria);
	}

	@Override
	public List<FcSecGrouprights> getAllGroupRights() {
		return getsecGrouprightsDAO().loadAll(FcSecGrouprights.class);
	}

	@Override
	public boolean isRightInGroup(FcSecRights right, FcSecGroups group) {
		DetachedCriteria criteria = DetachedCriteria.forClass(FcSecGrouprights.class);
		criteria.add(Restrictions.eq("secGroup", group));
		criteria.add(Restrictions.eq("secRight", right));
		criteria.setProjection(Projections.rowCount());

		int count = DataAccessUtils.intResult(getsecGrouprightsDAO().findByCriteria(criteria));
		return count > 0;
	}

	@Override
	public FcSecGrouprights getGroupRightByGroupAndRight(FcSecGroups group, FcSecRights right) {

		DetachedCriteria criteria = DetachedCriteria.forClass(FcSecGrouprights.class);
		criteria.add(Restrictions.eq("secGroup", group));
		criteria.add(Restrictions.eq("secRight", right));

		return (FcSecGrouprights) DataAccessUtils.uniqueResult(getsecGrouprightsDAO().findByCriteria(criteria));
	}

	@Override
	public List<FcSecRights> getGroupRightsByGroup(FcSecGroups group) {

		DetachedCriteria criteria = DetachedCriteria.forClass(FcSecRights.class);
		// Aliases only for properties
		criteria.createAlias("secGrouprights", "gr");
		criteria.add(Restrictions.eq("gr.secGroup", group));

		return getsecRightsDAO().findByCriteria(criteria);

	}

	@Override
	public int getCountAllSecGrouprights() {
		return DataAccessUtils.intResult(getsecGrouprightsDAO().find("select count(*) from SecGroupright"));
	}

	public void setsecGrouprightsDAO(BasisNextidDaoImpl<FcSecGrouprights> secGrouprightsDAO) {
		this.secGrouprightsDAO = secGrouprightsDAO;
	}

	public BasisNextidDaoImpl<FcSecGrouprights> getsecGrouprightsDAO() {
		return secGrouprightsDAO;
	}

	public void setsecRightsDAO(BasisNextidDaoImpl<FcSecRights> secRightsDAO) {
		this.secRightsDAO = secRightsDAO;
	}

	public BasisNextidDaoImpl<FcSecRights> getsecRightsDAO() {
		return secRightsDAO;
	}

	@Override
	public void saveOrUpdate(FcSecGrouprights groupRight) {
		getsecGrouprightsDAO().saveOrUpdate(groupRight);
	}

	@Override
	public void delete(FcSecGrouprights groupRight) {
		getsecGrouprightsDAO().delete(groupRight);
	}
}
