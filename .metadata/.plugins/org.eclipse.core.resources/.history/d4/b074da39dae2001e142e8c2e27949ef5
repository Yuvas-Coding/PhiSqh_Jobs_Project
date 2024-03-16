package my.com.cmg.iwp.maintenance.service.impl;

import java.util.Collection;
import java.util.List;

import org.hibernate.FetchMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.Frequency;
import my.com.cmg.iwp.maintenance.service.FrequencyService;
@Service
public class FrequencyServiceImpl implements FrequencyService {

	private BasisNextidDaoImpl<Frequency> frequencyDAO;

	public BasisNextidDaoImpl<Frequency> getFrequencyDAO() {
		return frequencyDAO;
	}

	public void setFrequencyDAO(BasisNextidDaoImpl<Frequency> frequencyDAO) {
		this.frequencyDAO = frequencyDAO;
	}
	
	@Override
	public boolean isNewFrequency(Frequency frequency) {
		return frequency.getFreqSeqno() == Long.MIN_VALUE;
	}
	

	@Override
	public Frequency getNewFrequency() {
		return new Frequency();
	}

	@Override
	public void delete(Frequency anFrequency) {
		frequencyDAO.delete(anFrequency);
	}

	@Override
	public void saveOrUpdate(Frequency anFrequency) {
		frequencyDAO.saveOrUpdate(anFrequency);
	}

	@Override
	public Collection<Frequency> getAllItems() {

		return frequencyDAO.loadAll(Frequency.class);
	}

	@Override
	public List<Frequency> getAllFrequencies() {
		return frequencyDAO.loadAll(Frequency.class);
	}

	@Override
	public Frequency getFrequencyInfo(String freqDesc) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Frequency.class);
		criteria.add(Restrictions.eq("freqDesc", freqDesc.trim()));
		return DataAccessUtils.uniqueResult(frequencyDAO
				.findByCriteria(criteria));
	}

	@Override
	public Frequency getFrequencybyFreqCode(String freqCode) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Frequency.class);
		criteria.add(Restrictions.ilike("freqCode", freqCode, MatchMode.EXACT));
		return DataAccessUtils.uniqueResult(frequencyDAO
				.findByCriteria(criteria));

	}

	@Override
	public Frequency getFreqBySeqno(Long freqSeqno) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Frequency.class);
		criteria.createCriteria("drugFrequencies").setFetchMode(
				"drugFrequencies", FetchMode.JOIN);
		criteria.createCriteria("drugFrequencies.frequency").setFetchMode(
				"drugFrequencies.frequency", FetchMode.JOIN);
		criteria.add(Restrictions.eq("freqSeqno", freqSeqno));
		return DataAccessUtils.uniqueResult(frequencyDAO
				.findByCriteria(criteria));
	}
	
	@Override
	public List<Frequency> getFrequencyByType(String freqType) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Frequency.class);
		criteria.add(Restrictions.eq("type", freqType.trim()));
		criteria.add(Restrictions.eq("activeFlag", 'A'));
		criteria.addOrder(Order.asc("freqDesc"));
		return frequencyDAO.findByCriteria(criteria);
	}
}
