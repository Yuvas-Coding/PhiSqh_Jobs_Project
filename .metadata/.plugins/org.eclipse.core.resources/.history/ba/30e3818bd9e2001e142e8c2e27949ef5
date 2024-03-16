package my.com.cmg.iwp.maintenance.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.Drug;
import my.com.cmg.iwp.maintenance.model.Regimen;
import my.com.cmg.iwp.maintenance.model.RegimenDrug;
import my.com.cmg.iwp.maintenance.model.ResultObject;
import my.com.cmg.iwp.maintenance.service.RegimenDrugService;
@Service
public class RegimenDrugServiceImpl implements RegimenDrugService {
	private BasisNextidDaoImpl<RegimenDrug> RegimenDrugDAO;

	@Override
	public RegimenDrug getNewRegimenDrug() {
		return new RegimenDrug();
	}

	@Override
	public void delete(RegimenDrug anRegimenDrug) {
		RegimenDrugDAO.delete(anRegimenDrug);

	}

	@Override
	public void saveOrUpdate(RegimenDrug anRegimenDrug) {
		RegimenDrugDAO.saveOrUpdate(anRegimenDrug);

	}

	public void setRegimenDrugDAO(BasisNextidDaoImpl<RegimenDrug> regimenDrugDAO) {
		RegimenDrugDAO = regimenDrugDAO;
	}

	public BasisNextidDaoImpl<RegimenDrug> getRegimenDrugDAO() {
		return RegimenDrugDAO;
	}

	@Override
	public ResultObject getRegimensDrugNameInfusionLikeText(
			String searchRegimenCode, String searchRegimenname, int start,
			int pageSize) {

		DetachedCriteria criteria = DetachedCriteria.forClass(Drug.class);
		criteria.add(Restrictions.not(Restrictions.eq("drugName",
				searchRegimenname)));

		criteria.addOrder(Order.asc("drugName"));

		int totalCount = getRegimenDrugDAO().findByCriteria(criteria).size();

		List<RegimenDrug> list = getRegimenDrugDAO().findByCriteria(criteria,
				start, pageSize);

		return new ResultObject(list, totalCount);
	}

	@Override
	public RegimenDrug findByDrugSeqNo(long drugSeqno) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(RegimenDrug.class);
		criteria.add(Restrictions.eq("drug.drugSeqno", drugSeqno));
		return DataAccessUtils.uniqueResult(RegimenDrugDAO
				.findByCriteria(criteria));
	}

	@Override
	public List<RegimenDrug> getRegimenDrugByRegimen(Regimen regimen) {
		Session session = RegimenDrugDAO.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(RegimenDrug.class);
		criteria.add(Restrictions.eq("regimen", regimen));
		criteria.add(Restrictions.eq("activeFlag", 'A'));
		criteria.setFetchMode("drugRoute", FetchMode.JOIN);
		criteria.setFetchMode("frequency", FetchMode.JOIN);
		List<RegimenDrug> regimenDrugs = criteria.list();
		session.close();
		return regimenDrugs;
	}
}
