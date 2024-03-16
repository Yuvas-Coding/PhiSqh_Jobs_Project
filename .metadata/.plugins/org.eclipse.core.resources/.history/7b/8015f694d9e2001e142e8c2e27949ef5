package my.com.cmg.iwp.backend.service.integration.spub.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.backend.model.integration.spub.SpubCorInt;
import my.com.cmg.iwp.backend.service.integration.spub.SpubCorIntService;
import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;


@Service
public class SpubCorIntServiceImpl implements SpubCorIntService {
	
	private BasisNextidDaoImpl<SpubCorInt> spubCorIntDAO;
	

	public BasisNextidDaoImpl<SpubCorInt> getSpubCorIntDAO() {
		return this.spubCorIntDAO;
	}

	public void setSpubCorIntDAO(BasisNextidDaoImpl<SpubCorInt> spubCorIntDAO) {
		this.spubCorIntDAO = spubCorIntDAO;
	}


	@Override
	public void saveOrUpdate(SpubCorInt spubCorInt) {
		
		this.spubCorIntDAO.saveOrUpdate(spubCorInt);
	}
	
	@Override
	public SpubCorInt getSpubCorIntBySpubNo(String spubNo) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SpubCorInt.class);
		detachedCriteria.add(Restrictions.eq("spubNo", spubNo));
		return DataAccessUtils.uniqueResult(this.spubCorIntDAO.findByCriteria(detachedCriteria));
	}
	
	@Override
	public boolean isExist(String spubNo) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SpubCorInt.class);
		detachedCriteria.add(Restrictions.eq("spubNo", spubNo));
		SpubCorInt spubCorInt = DataAccessUtils.uniqueResult(this.spubCorIntDAO.findByCriteria(detachedCriteria));
		return spubCorInt != null;
	}
	
	@Override
	public List<SpubCorInt> getSpubCorInts(String sendFlag) {

		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(SpubCorInt.class);
		detachedCriteria.add(Restrictions.eq("sendFlag", sendFlag));
		
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return this.spubCorIntDAO.findByCriteria(detachedCriteria);

	}
}
