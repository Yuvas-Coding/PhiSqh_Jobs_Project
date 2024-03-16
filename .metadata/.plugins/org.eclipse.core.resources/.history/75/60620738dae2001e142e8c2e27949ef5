package my.com.cmg.iwp.maintenance.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.Frequency;
import my.com.cmg.iwp.maintenance.model.FrequencySchedule;
import my.com.cmg.iwp.maintenance.model.RegimenDays;
import my.com.cmg.iwp.maintenance.service.FrequencyScheduleService;
import my.com.cmg.iwp.webui.constant.RefCodeConstant;
@Service
public class FrequencyScheduleServiceImpl implements FrequencyScheduleService {

	private BasisNextidDaoImpl<FrequencySchedule> frequencyScheduleDAO;

	public void setFrequencyScheduleDAO(
			BasisNextidDaoImpl<FrequencySchedule> frequencyScheduleDAO) {
		this.frequencyScheduleDAO = frequencyScheduleDAO;
	}

	public BasisNextidDaoImpl<FrequencySchedule> getFrequencyScheduleDAO() {
		return frequencyScheduleDAO;
	}
	
	@Override
	public boolean isNewFrequencySchedule(FrequencySchedule frequencySchedule) {
		return frequencySchedule.getScheduleSeqno() == Long.MIN_VALUE;
	}

	@Override
	public FrequencySchedule getNewFrequencySchedule() {

		return new FrequencySchedule();
	}

	@Override
	public void delete(FrequencySchedule anFrequencySchedule) {

		frequencyScheduleDAO.delete(anFrequencySchedule);

	}

	@Override
	public void saveOrUpdate(FrequencySchedule anFrequencySchedule) {

		frequencyScheduleDAO.saveOrUpdate(anFrequencySchedule);

	}

	public List<FrequencySchedule> getAllListValueByFrequency(
			Frequency frequency) {

		DetachedCriteria criteria = DetachedCriteria
				.forClass(FrequencySchedule.class);
		criteria.setFetchMode("frequency", FetchMode.JOIN);
		criteria.add(Restrictions.eq("frequency", frequency));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

		return frequencyScheduleDAO.findByCriteria(criteria);
	}

	@Override
	public void deleteAll(List<FrequencySchedule> anFrequencySchedule) {

		frequencyScheduleDAO.deleteAll(anFrequencySchedule);

	}

	@Override
	public FrequencySchedule getAllValueByFreqCode(String code) {

		DetachedCriteria criteria = DetachedCriteria
				.forClass(FrequencySchedule.class);
		criteria.createAlias("frequency", "freq");
		criteria.add(Restrictions.eq("frequency", code));
		List<FrequencySchedule> list = frequencyScheduleDAO
				.findByCriteria(criteria);
		return DataAccessUtils.uniqueResult(list);
	}
	
	@Override
	public List<FrequencySchedule> getActiveValueByRegimensDays(RegimenDays regimensDays) {
		List<FrequencySchedule> freqSchedules = new ArrayList<FrequencySchedule>();
		for(FrequencySchedule freqSch : regimensDays.getFrequencySchedules()) {
			if(RefCodeConstant.ACTIVE_FLAG_TRUE.equals(freqSch.getActiveFlag())) freqSchedules.add(freqSch);
		}
		return freqSchedules;
	}

}
