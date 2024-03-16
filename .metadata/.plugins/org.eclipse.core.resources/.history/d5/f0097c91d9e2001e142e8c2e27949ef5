package my.com.cmg.iwp.maintenance.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.SecGroup;
import my.com.cmg.iwp.maintenance.model.SecGroupright;
import my.com.cmg.iwp.maintenance.model.SecRight;
import my.com.cmg.iwp.maintenance.service.SecGrouprightService;
@Service
public class SecGrouprightServiceImpl implements SecGrouprightService {
	private BasisNextidDaoImpl<SecGroupright> secGrouprightDAO;
	private BasisNextidDaoImpl<SecRight> secRightDAO;

	@Override
	public SecGroupright getNewSecGroupright() {
		return new SecGroupright();
	}

	@Override
	public List<SecRight> getRightsByGroup(SecGroup group) {

		DetachedCriteria criteria = DetachedCriteria.forClass(SecRight.class);
		// Aliases are working only on properties they build the JOINS
		criteria.createAlias("secGrouprights", "gr");
		criteria.add(Restrictions.eq("gr.secGroup", group));

		return getSecRightDAO().findByCriteria(criteria);
	}

	@Override
	public List<SecGroupright> getAllGroupRights() {
		return getSecGrouprightDAO().loadAll(SecGroupright.class);
	}

	@Override
	public boolean isRightInGroup(SecRight right, SecGroup group) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(SecGroupright.class);
		criteria.add(Restrictions.eq("secGroup", group));
		criteria.add(Restrictions.eq("secRight", right));
		criteria.setProjection(Projections.rowCount());

		int count = DataAccessUtils.intResult(getSecGrouprightDAO()
				.findByCriteria(criteria));
		return count > 0;
	}

	@Override
	public SecGroupright getGroupRightByGroupAndRight(SecGroup group,
			SecRight right) {

		DetachedCriteria criteria = DetachedCriteria
				.forClass(SecGroupright.class);
		criteria.add(Restrictions.eq("secGroup", group));
		criteria.add(Restrictions.eq("secRight", right));

		return (SecGroupright) DataAccessUtils
				.uniqueResult(getSecGrouprightDAO().findByCriteria(criteria));
	}

	@Override
	public List<SecRight> getGroupRightsByGroup(SecGroup group) {

		DetachedCriteria criteria = DetachedCriteria.forClass(SecRight.class);
		// Aliases only for properties
		criteria.createAlias("secGrouprights", "gr");
		criteria.add(Restrictions.eq("gr.secGroup", group));

		return getSecRightDAO().findByCriteria(criteria);

	}

	@Override
	public int getCountAllSecGrouprights() {
		return DataAccessUtils.intResult(getSecGrouprightDAO().find(
				"select count(*) from SecGroupright"));
	}

	public void setSecGrouprightDAO(
			BasisNextidDaoImpl<SecGroupright> secGrouprightDAO) {
		this.secGrouprightDAO = secGrouprightDAO;
	}

	public BasisNextidDaoImpl<SecGroupright> getSecGrouprightDAO() {
		return secGrouprightDAO;
	}

	public void setSecRightDAO(BasisNextidDaoImpl<SecRight> secRightDAO) {
		this.secRightDAO = secRightDAO;
	}

	public BasisNextidDaoImpl<SecRight> getSecRightDAO() {
		return secRightDAO;
	}

	@Override
	public void saveOrUpdate(SecGroupright groupRight) {
		getSecGrouprightDAO().saveOrUpdate(groupRight);
	}

	@Override
	public void delete(SecGroupright groupRight) {
		getSecGrouprightDAO().delete(groupRight);
	}
}
