package my.com.cmg.iwp.maintenance.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.AdminRoute;
import my.com.cmg.iwp.maintenance.model.Drug;
import my.com.cmg.iwp.maintenance.model.DrugRoute;
import my.com.cmg.iwp.maintenance.model.ResultObject;
import my.com.cmg.iwp.maintenance.service.AdminRouteService;

@Service
public class AdminRouteServiceImpl implements AdminRouteService {

	private BasisNextidDaoImpl<AdminRoute> adminRouteDAO;

	@Override
	public AdminRoute getNewAdminRoute() {
		AdminRoute adminRoute = new AdminRoute();
		adminRoute.setRouteSeqno(Long.MIN_VALUE);
		return adminRoute;
	}

	@Override
	public void delete(AdminRoute anAdminRoute) {
		adminRouteDAO.delete(anAdminRoute);

	}

	@Override
	public void saveOrUpdate(AdminRoute anAdminRoute) {
		adminRouteDAO.saveOrUpdate(anAdminRoute);

	}

	public void setAdminRouteDAO(BasisNextidDaoImpl<AdminRoute> adminRouteDAO) {
		this.adminRouteDAO = adminRouteDAO;
	}

	public BasisNextidDaoImpl<AdminRoute> getAdminRouteDAO() {
		return adminRouteDAO;
	}

	@Override
	public List<AdminRoute> getAllAdminRoutes() {
		DetachedCriteria criteria = DetachedCriteria.forClass(AdminRoute.class);
		criteria.add(Restrictions.eq("activeFlag", 'A'));
		return adminRouteDAO.findByCriteria(criteria);
	}

	@Override
	public ResultObject getAllAdminRoutesLikeText(String text, int start,
			int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(AdminRoute.class);
		if (!StringUtils.isEmpty(text)) {
			criteria.add(Restrictions.ilike("routeDesc", text,
					MatchMode.ANYWHERE));
		}

		criteria.addOrder(Order.asc("routeDesc"));

		int totalCount = getAdminRouteDAO().findByCriteria(criteria).size();

		List<AdminRoute> list = getAdminRouteDAO().findByCriteria(criteria,
				start, pageSize);

		return new ResultObject(list, totalCount);
	}

	@Override
	public AdminRoute findByAdminRouteCode(String routeCode) {
		DetachedCriteria criteria = DetachedCriteria.forClass(AdminRoute.class);
		criteria.add(Restrictions.eq("routeCode", routeCode));
		return DataAccessUtils.uniqueResult(adminRouteDAO
				.findByCriteria(criteria));
	}

	@Override
	public AdminRoute findByRouteCode(String routeCode) {
		DetachedCriteria criteria = DetachedCriteria.forClass(AdminRoute.class);
		criteria.add(Restrictions.ilike("routeCode", routeCode));
		return DataAccessUtils.uniqueResult(adminRouteDAO
				.findByCriteria(criteria));
	}

	@Override
	public AdminRoute getAllAdminRoutes(Drug drug) {
		AdminRoute adminRoute = null;
		Session session = adminRouteDAO.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(DrugRoute.class);
		criteria.createCriteria("drug").add(
				Restrictions.eq("drugSeqno", drug.getDrugSeqno()));
		List<DrugRoute> drugRoutes = criteria.list();
		if (drugRoutes.size() > 0) {
			DrugRoute drugRoute = drugRoutes.get(0);
			adminRoute = drugRoute.getAdminRoute();
		} else {
			adminRoute = null;
		}
		session.close();
		return adminRoute;
	}
}
