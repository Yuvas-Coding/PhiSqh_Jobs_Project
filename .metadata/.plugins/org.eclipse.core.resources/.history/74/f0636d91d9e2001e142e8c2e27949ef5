package my.com.cmg.iwp.maintenance.service.impl;

import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.RegimenDrugDoseSch;
import my.com.cmg.iwp.maintenance.service.RegimenDrugDoseSchService;
@Service
public class RegimenDrugDoseSchServiceImpl implements RegimenDrugDoseSchService {
	private BasisNextidDaoImpl<RegimenDrugDoseSch> RegimenDrugDoseSchDAO;

	@Override
	public RegimenDrugDoseSch getNewRegimenDrugDoseSch() {
		return new RegimenDrugDoseSch();
	}

	@Override
	public void delete(RegimenDrugDoseSch anRegimenDrugDoseSch) {
		RegimenDrugDoseSchDAO.delete(anRegimenDrugDoseSch);

	}

	@Override
	public void saveOrUpdate(RegimenDrugDoseSch anRegimenDrugDoseSch) {
		RegimenDrugDoseSchDAO.saveOrUpdate(anRegimenDrugDoseSch);

	}

	public void setRegimenDrugDoseSchDAO(
			BasisNextidDaoImpl<RegimenDrugDoseSch> regimenDrugDoseSchDAO) {
		RegimenDrugDoseSchDAO = regimenDrugDoseSchDAO;
	}

	public BasisNextidDaoImpl<RegimenDrugDoseSch> getRegimenDrugDoseSchDAO() {
		return RegimenDrugDoseSchDAO;
	}

}
