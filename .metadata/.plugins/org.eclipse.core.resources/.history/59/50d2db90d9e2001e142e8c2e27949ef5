package my.com.cmg.iwp.maintenance.service.impl;

import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.DrugExtemp;
import my.com.cmg.iwp.maintenance.service.DrugExtempService;
@Service
public class DrugExtempServiceImpl implements DrugExtempService {
	private BasisNextidDaoImpl<DrugExtemp> drugExtempDAO;

	@Override
	public DrugExtemp getNewDrugExtemp() {
		return new DrugExtemp();
	}

	@Override
	public void delete(DrugExtemp anDrugExtemp) {
		drugExtempDAO.delete(anDrugExtemp);

	}

	@Override
	public void saveOrUpdate(DrugExtemp anDrugExtemp) {
		drugExtempDAO.saveOrUpdate(anDrugExtemp);

	}

	public void setDrugExtempDAO(BasisNextidDaoImpl<DrugExtemp> drugExtempDAO) {
		this.drugExtempDAO = drugExtempDAO;
	}

	public BasisNextidDaoImpl<DrugExtemp> getDrugExtempDAO() {
		return drugExtempDAO;
	}

}
