package my.com.cmg.iwp.backend.service.inventory.penalty.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import my.com.cmg.iwp.backend.model.inventory.penalty.PenaltyDtl;
import my.com.cmg.iwp.backend.service.inventory.penalty.PenaltyDtlService;
import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
@Service
public class PenaltyDtlServiceImpl implements PenaltyDtlService{

	private BasisNextidDaoImpl<PenaltyDtl> penaltyDtlDAO;
	
	@Override
	public void saveOrUpdate(PenaltyDtl penaltyDtl) {
		getPenaltyDtlDAO().saveOrUpdate(penaltyDtl);
	}

	@Override
	public void saveOrUpdateAll(List<PenaltyDtl> penaltyDtls) {
		getPenaltyDtlDAO().saveOrUpdateAll(penaltyDtls);
	}

	@Override
	public void delete(PenaltyDtl penaltyDtl) {
		getPenaltyDtlDAO().delete(penaltyDtl);
	}

	@Override
	public void deleteAll(List<PenaltyDtl> penaltyDtls) {
		getPenaltyDtlDAO().deleteAll(penaltyDtls);
	}

	@Override
	public List<PenaltyDtl> findByExample(PenaltyDtl penaltyDtl) {
		return getPenaltyDtlDAO().findByExample(penaltyDtl);
	}

	public BasisNextidDaoImpl<PenaltyDtl> getPenaltyDtlDAO() {
		return penaltyDtlDAO;
	}

	public void setPenaltyDtlDAO(BasisNextidDaoImpl<PenaltyDtl> penaltyDtlDAO) {
		this.penaltyDtlDAO = penaltyDtlDAO;
	}
}
