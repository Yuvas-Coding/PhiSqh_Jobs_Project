package my.com.cmg.iwp.maintenance.service.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.ConstituentsReferenceRange;
import my.com.cmg.iwp.maintenance.service.ConstituentsReferenceRangeService;


@Service
public class ConstituentsReferenceRangeServiceImpl implements
		ConstituentsReferenceRangeService {

	private BasisNextidDaoImpl<ConstituentsReferenceRange> constituentsReferenceRangeDAO;

	public BasisNextidDaoImpl<ConstituentsReferenceRange> getConstituentsReferenceRangeDAO() {
		return constituentsReferenceRangeDAO;
	}

	public void setConstituentsReferenceRangeDAO(
			BasisNextidDaoImpl<ConstituentsReferenceRange> constituentsReferenceRangeDAO) {
		this.constituentsReferenceRangeDAO = constituentsReferenceRangeDAO;
	}

	@Override
	public ConstituentsReferenceRange getNewConstituentsReferenceRange() {
		return new ConstituentsReferenceRange();
	}

	@Override
	public void delete(ConstituentsReferenceRange constituentsReferenceRange) {
		constituentsReferenceRangeDAO.delete(constituentsReferenceRange);
	}

	@Override
	public void saveOrUpdate(
			ConstituentsReferenceRange constituentsReferenceRange) {
		constituentsReferenceRangeDAO.saveOrUpdate(constituentsReferenceRange);
	}

	@Override
	public ConstituentsReferenceRange findBySeqNo(long seqNo) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(ConstituentsReferenceRange.class);
		criteria.add(Restrictions.eq("referRgeSeqno", seqNo));
		return DataAccessUtils.uniqueResult(constituentsReferenceRangeDAO
				.findByCriteria(criteria));
	}

	@Override
	public ConstituentsReferenceRange findByAgeGroup(String ageGroup) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(ConstituentsReferenceRange.class);
		criteria.add(Restrictions.eq("ageGroup", ageGroup));
		return DataAccessUtils.uniqueResult(constituentsReferenceRangeDAO
				.findByCriteria(criteria));
	}

}
