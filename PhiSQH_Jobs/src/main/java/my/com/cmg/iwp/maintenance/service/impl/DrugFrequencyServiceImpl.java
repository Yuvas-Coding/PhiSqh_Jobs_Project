package my.com.cmg.iwp.maintenance.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.Drug;
import my.com.cmg.iwp.maintenance.model.DrugFrequency;
import my.com.cmg.iwp.maintenance.model.Frequency;
import my.com.cmg.iwp.maintenance.model.ResultObject;
import my.com.cmg.iwp.maintenance.service.DrugFrequencyService;
import my.com.cmg.iwp.webui.constant.RefCodeConstant;
@Service
public class DrugFrequencyServiceImpl implements DrugFrequencyService {
	private BasisNextidDaoImpl<DrugFrequency> drugFrequencyDAO;

	@Override
	public DrugFrequency getNewDrugFrequency() {
		return new DrugFrequency();
	}

	@Override
	public void delete(DrugFrequency anDrugFrequency) {
		drugFrequencyDAO.delete(anDrugFrequency);

	}

	@Override
	public void saveOrUpdate(DrugFrequency anDrugFrequency) {
		drugFrequencyDAO.saveOrUpdate(anDrugFrequency);

	}

	public void setDrugFrequencyDAO(
			BasisNextidDaoImpl<DrugFrequency> drugFrequencyDAO) {
		this.drugFrequencyDAO = drugFrequencyDAO;
	}

	public BasisNextidDaoImpl<DrugFrequency> getDrugFrequencyDAO() {
		return drugFrequencyDAO;
	}

	@Override
	public ResultObject getAllDrugFrequenciesLikeText(String searchText,
			int start, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(DrugFrequency.class);

		if (!StringUtils.isEmpty(searchText)) {
			criteria.add(Restrictions.ilike("drugCode", searchText,
					MatchMode.ANYWHERE));
		}

		criteria.addOrder(Order.asc("drugCode"));

		int totalCount = getDrugFrequencyDAO().findByCriteria(criteria).size();

		List<DrugFrequency> list = getDrugFrequencyDAO().findByCriteria(
				criteria, start, pageSize);

		return new ResultObject(list, totalCount);
	}

	@Override
	public DrugFrequency findByDefaultDrugFreq(Drug drug,
			boolean defaultFrequencyYn) {

		DetachedCriteria criteria = DetachedCriteria
				.forClass(DrugFrequency.class);
		Criterion crit1 = Restrictions.eq("drug", drug);
		Criterion crit2 = Restrictions.eq("defaultFrequencyYn",
				defaultFrequencyYn);
		criteria.add(Restrictions.and(crit1, crit2));
		return DataAccessUtils.uniqueResult(drugFrequencyDAO
				.findByCriteria(criteria));
	}

	@Override
	public DrugFrequency findByDrugFreq(Drug drug, String freqDesc) {

		DetachedCriteria criteria = DetachedCriteria
				.forClass(DrugFrequency.class);

		Criterion crit1 = Restrictions.eq("drug", drug);
		Criterion crit2 = Restrictions.eq("desc", freqDesc);
		criteria.add(Restrictions.and(crit1, crit2));
		return DataAccessUtils.uniqueResult(drugFrequencyDAO
				.findByCriteria(criteria));
	}

	@Override
	public List<DrugFrequency> getAllListValueByFreqCode(String freqCode) {

		DetachedCriteria criteria = DetachedCriteria
				.forClass(DrugFrequency.class);
		criteria.createAlias("frequency", "freq");
		criteria.add(Restrictions.eq("freq.freqCode", freqCode));
		return drugFrequencyDAO.findByCriteria(criteria);
	}

	@Override
	public void deleteAll(List<DrugFrequency> drugFrequencies) {

		drugFrequencyDAO.deleteAll(drugFrequencies);

	}

	@Override
	public List<DrugFrequency> findDrugFreqByDrug(Drug drug) {

		DetachedCriteria criteria = DetachedCriteria
				.forClass(DrugFrequency.class);
		criteria.setFetchMode("frequency", FetchMode.JOIN);
		criteria.add(Restrictions.eq("drug", drug));

		return drugFrequencyDAO.findByCriteria(criteria);
	}

	@Override
	public DrugFrequency findDrugFreqByFrequency(Drug drug, Frequency frequency) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(DrugFrequency.class);
		criteria.setFetchMode("frequency", FetchMode.JOIN);
		Criterion crit1 = Restrictions.eq("drug", drug);
		Criterion crit2 = Restrictions.eq("frequency", frequency);
		criteria.add(Restrictions.and(crit1, crit2));
		return DataAccessUtils.uniqueResult(drugFrequencyDAO
				.findByCriteria(criteria));
	}

	@Override
	public List<DrugFrequency> getDrugFrequencyByDrug(Drug drug) {
		Session session = drugFrequencyDAO.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(DrugFrequency.class);
		if (drug != null) {
			criteria.add(Restrictions.eq("drug", drug));
			
		}
		criteria.setFetchMode("frequency", FetchMode.JOIN);
		criteria.add(Restrictions.ne("activeFlag",RefCodeConstant.ACTIVE_FLAG_FALSE));
		List<DrugFrequency> drugFrequencies = criteria.list();
		session.close();
		return drugFrequencies;
	}
	
	@Override
	public List<DrugFrequency> getDrugFrequencyByDrugCDR(Drug drug) {
		Session session = drugFrequencyDAO.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(DrugFrequency.class);
		if (drug != null) {
			criteria.add(Restrictions.eq("drug", drug));
			
		}
		criteria.add(Restrictions.eq("cdrYn", 'Y'));
		criteria.setFetchMode("frequency", FetchMode.JOIN);
		criteria.add(Restrictions.ne("activeFlag",RefCodeConstant.ACTIVE_FLAG_FALSE));
		List<DrugFrequency> drugFrequencies = criteria.list();
		session.close();
		return drugFrequencies;
	}
}
