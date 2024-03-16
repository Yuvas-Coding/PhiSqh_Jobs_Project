package my.com.cmg.iwp.maintenance.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.Drug;
import my.com.cmg.iwp.maintenance.model.DrugIndication;
import my.com.cmg.iwp.maintenance.model.Indication;
import my.com.cmg.iwp.maintenance.model.ResultObject;
import my.com.cmg.iwp.maintenance.service.DrugIndicationService;
@Service
public class DrugIndicationServiceImpl implements DrugIndicationService {

	private BasisNextidDaoImpl<DrugIndication> drugIndicationDAO;

	@Override
	public DrugIndication getNewDrugIndication() {

		return new DrugIndication();
	}

	public void setDrugIndicationDAO(
			BasisNextidDaoImpl<DrugIndication> drugIndicationDAO) {
		this.drugIndicationDAO = drugIndicationDAO;
	}

	public BasisNextidDaoImpl<DrugIndication> getDrugIndicationDAO() {
		return drugIndicationDAO;
	}

	@Override
	public void delete(DrugIndication anDrugIndication) {
		drugIndicationDAO.delete(anDrugIndication);
	}

	@Override
	public void saveOrUpdate(DrugIndication anDrugIndication) {
		drugIndicationDAO.saveOrUpdate(anDrugIndication);
	}

	@Override
	public ResultObject getAllDrugIndicationsLikeText(String drugCode,
			String searchText, int start, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(DrugIndication.class);

		if (!StringUtils.isEmpty(drugCode)) {
			criteria.add(Restrictions.eq("drugCode", drugCode));
		}

		if (!StringUtils.isEmpty(searchText)) {
			criteria.createAlias("indication", "indication");
			criteria.add(Restrictions.ilike("indication.indicationDesc",
					searchText, MatchMode.ANYWHERE));
		}

		criteria.addOrder(Order.asc("indicationCode"));

		int totalCount = getDrugIndicationDAO().findByCriteria(criteria).size();

		List<DrugIndication> list = getDrugIndicationDAO().findByCriteria(
				criteria, start, pageSize);

		return new ResultObject(list, totalCount);
	}

	@Override
	public DrugIndication findDrugRouteByAdminRoute(Drug drug,
			Indication indication) {

		DetachedCriteria criteria = DetachedCriteria
				.forClass(DrugIndication.class);
		Criterion crit1 = Restrictions.eq("drug", drug);
		Criterion crit2 = Restrictions.eq("indication", indication);
		criteria.add(Restrictions.and(crit1, crit2));
		return DataAccessUtils.uniqueResult(drugIndicationDAO
				.findByCriteria(criteria));

	}

	@Override
	public List<DrugIndication> findDrugDrugIndicationByDrug(Drug drug) {

		DetachedCriteria criteria = DetachedCriteria
				.forClass(DrugIndication.class);
		Criterion crit1 = Restrictions.eq("drug", drug);
		criteria.setFetchMode("indication", FetchMode.JOIN);
		criteria.add(crit1);
		return drugIndicationDAO.findByCriteria(criteria);

	}
}
