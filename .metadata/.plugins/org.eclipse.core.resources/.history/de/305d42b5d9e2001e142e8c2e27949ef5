package my.com.cmg.iwp.backend.service.inventory.penalty.impl;

import java.util.List;

import org.hibernate.FetchMode;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.backend.model.inventory.penalty.PenaltyBatch;
import my.com.cmg.iwp.backend.service.inventory.penalty.PenaltyBatchService;
import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
@Service
public class PenaltyBatchServiceImpl implements PenaltyBatchService{

	private BasisNextidDaoImpl<PenaltyBatch> penaltyBatchDAO;
	
	
	@Override
	public void saveOrUpdate(PenaltyBatch penaltyBatch) {
		getPenaltyBatchDAO().saveOrUpdate(penaltyBatch);
		
	}

	@Override
	public void saveOrUpdateAll(List<PenaltyBatch> penaltyBatchs) {
		getPenaltyBatchDAO().saveOrUpdateAll(penaltyBatchs);
		
	}

	@Override
	public void delete(PenaltyBatch penaltyBatch) {
		getPenaltyBatchDAO().delete(penaltyBatch);
	}

	@Override
	public void deleteAll(List<PenaltyBatch> penaltyBatchs) {
		getPenaltyBatchDAO().deleteAll(penaltyBatchs);
	}

	@Override
	public List<PenaltyBatch> findByExample(PenaltyBatch penaltyBatch) {
		return getPenaltyBatchDAO().findByExample(penaltyBatch);
	}

	public BasisNextidDaoImpl<PenaltyBatch> getPenaltyBatchDAO() {
		return penaltyBatchDAO;
	}

	public void setPenaltyBatchDAO(BasisNextidDaoImpl<PenaltyBatch> penaltyBatchDAO) {
		this.penaltyBatchDAO = penaltyBatchDAO;
	}
	
	@Override
	public List<PenaltyBatch> verificationDtlbyitem (String Lpono,String facilityCode,String ptjCode,String transactionNo){
		DetachedCriteria detachedCriteria= DetachedCriteria.forClass(PenaltyBatch.class);
		detachedCriteria.setFetchMode("penaltyItem", FetchMode.JOIN);
		detachedCriteria.setFetchMode("penaltyItem.penaltyDtl", FetchMode.JOIN);
		detachedCriteria.createAlias("penaltyItem.penaltyDtl.penaltyHdr", "penaltyHdr", CriteriaSpecification.LEFT_JOIN);
		detachedCriteria.add(Restrictions.eq("penaltyHdr.hospitalcode",facilityCode ));
		detachedCriteria.add(Restrictions.eq("penaltyHdr.ptjcode",ptjCode ));
		detachedCriteria.add(Restrictions.eq("penaltyHdr.lpoNo",Lpono ));
		detachedCriteria.add(Restrictions.eq("penaltyHdr.transactionNumber",transactionNo  ));
		return getPenaltyBatchDAO().findByCriteria(detachedCriteria);
		}
}
