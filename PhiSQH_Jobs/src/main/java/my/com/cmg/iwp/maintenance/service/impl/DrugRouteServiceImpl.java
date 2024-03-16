package my.com.cmg.iwp.maintenance.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.AdminRoute;
import my.com.cmg.iwp.maintenance.model.Drug;
import my.com.cmg.iwp.maintenance.model.DrugRoute;
import my.com.cmg.iwp.maintenance.model.ResultObject;
import my.com.cmg.iwp.maintenance.service.DrugRouteService;
@Service
public class DrugRouteServiceImpl implements DrugRouteService {
	private BasisNextidDaoImpl<DrugRoute> drugRouteDAO;

	@Override
	public DrugRoute getNewDrugRoute() {
		return new DrugRoute();
	}

	@Override
	public void delete(DrugRoute anDrugRoute) {
		drugRouteDAO.delete(anDrugRoute);

	}

	@Override
	public void saveOrUpdate(DrugRoute anDrugRoute) {
		drugRouteDAO.saveOrUpdate(anDrugRoute);

	}

	public void setDrugRouteDAO(BasisNextidDaoImpl<DrugRoute> drugRouteDAO) {
		this.drugRouteDAO = drugRouteDAO;
	}

	public BasisNextidDaoImpl<DrugRoute> getDrugRouteDAO() {
		return drugRouteDAO;
	}

	@Override
	public List<DrugRoute> findByDrug(Drug drug) {
		DetachedCriteria criteria = DetachedCriteria.forClass(DrugRoute.class);
		criteria.add(Restrictions.eq("drug", drug));
		criteria.setFetchMode("adminRoute", FetchMode.JOIN);
		return drugRouteDAO.findByCriteria(criteria);
	}

	@Override
	public List<DrugRoute> getAllDrugRoutes() {
		return drugRouteDAO.loadAll(DrugRoute.class);
	}

	@Override
	public ResultObject getAllDrugRoutesLikeText(String drugCode, int start,
			int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(DrugRoute.class);

		if (!StringUtils.isEmpty(drugCode)) {
			criteria.add(Restrictions.ilike("drugCode", drugCode,
					MatchMode.ANYWHERE));
		}

		int totalCount = getDrugRouteDAO().findByCriteria(criteria).size();

		List<DrugRoute> list = getDrugRouteDAO().findByCriteria(criteria,
				start, pageSize);

		return new ResultObject(list, totalCount);
	}

	@Override
	public DrugRoute findByDefaultDrugRoute(Drug drug, boolean defaultDrug) {

		DetachedCriteria criteria = DetachedCriteria.forClass(DrugRoute.class);
		Criterion crit1 = Restrictions.eq("drug", drug);
		Criterion crit2 = Restrictions.eq("defaultRouteYn", defaultDrug);
		criteria.add(Restrictions.and(crit1, crit2));
		return DataAccessUtils.uniqueResult(drugRouteDAO
				.findByCriteria(criteria));

	}

	public List<DrugRoute> getAllDrugRoutes(String drugCode) {
		DetachedCriteria criteria = DetachedCriteria.forClass(DrugRoute.class);
		criteria.setFetchMode("drug", FetchMode.JOIN);
		criteria.add(Restrictions.eq("drug.drugSeqno", drugCode));
		return drugRouteDAO.findByCriteria(criteria);

	}

	@Override
	public DrugRoute findDrugRouteByAdminRoute(Drug drug, AdminRoute adminRoute) {

		DetachedCriteria criteria = DetachedCriteria.forClass(DrugRoute.class);
		criteria.setFetchMode("adminRoute", FetchMode.JOIN);
		Criterion crit1 = Restrictions.eq("drug", drug);
		Criterion crit2 = Restrictions.eq("adminRoute", adminRoute);
		criteria.add(Restrictions.and(crit1, crit2));
		return DataAccessUtils.uniqueResult(drugRouteDAO
				.findByCriteria(criteria));

	}

}
