package my.com.cmg.iwp.maintenance.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.DrugIndication;
import my.com.cmg.iwp.maintenance.model.Indication;
import my.com.cmg.iwp.maintenance.service.IndicationService;
@Service
public class IndicationServiceImpl implements IndicationService {

	private BasisNextidDaoImpl indicationDAO;

	@Override
	public Indication getNewIndication() {

		return new Indication();
	}

	public void setIndicationDAO(BasisNextidDaoImpl indicationDAO) {
		this.indicationDAO = indicationDAO;
	}

	public BasisNextidDaoImpl getIndicationDAO() {
		return indicationDAO;
	}

	@Override
	public void delete(Indication anIndication) {
		indicationDAO.delete(anIndication);
	}

	@Override
	public void saveOrUpdate(Indication anIndication) {
		indicationDAO.saveOrUpdate(anIndication);
	}

	@Override
	public Indication findByIndicationCode(String indicationCode) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Indication.class);
		criteria.add(Restrictions
				.ilike("code", indicationCode, MatchMode.EXACT));
		return (Indication) DataAccessUtils.uniqueResult(indicationDAO
				.findByCriteria(criteria));
	}

	@Override
	public Indication findByIndicationSeqno(long seqNo) {
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria.forClass(Indication.class);
		criteria.add(Restrictions.eq("indicationSeqno", seqNo));
		return (Indication) DataAccessUtils.uniqueResult(indicationDAO
				.findByCriteria(criteria));
	}
	
	@Override
	public 	List<DrugIndication> getDrugIndications(Indication indication){
		DetachedCriteria criteria = DetachedCriteria.forClass(DrugIndication.class);
		criteria.add(Restrictions.eq("indication", indication));
		return indicationDAO.findByCriteria(criteria);

	}
}
