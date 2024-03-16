package my.com.cmg.iwp.backend.service.integration.pn.impl;

import org.springframework.stereotype.Service;

import my.com.cmg.iwp.backend.model.integration.pn.PnOrderTotalEnergyInt;
import my.com.cmg.iwp.backend.service.integration.pn.PnOrderTotalEnergyIntService;
import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
@Service
public class PnOrderTotalEnergyIntServiceImpl implements
		PnOrderTotalEnergyIntService {

	private BasisNextidDaoImpl<PnOrderTotalEnergyInt> pnOrderTotalEnergyIntDAO;

	@Override
	public PnOrderTotalEnergyInt findById(long id) {
		return getPnOrderTotalEnergyIntDAO().get(PnOrderTotalEnergyInt.class,
				id);
	}

	@Override
	public void saveOrUpdate(PnOrderTotalEnergyInt pnOrderTotalEnergyInt) {
		getPnOrderTotalEnergyIntDAO().saveOrUpdate(pnOrderTotalEnergyInt);
	}

	@Override
	public void save(PnOrderTotalEnergyInt pnOrderTotalEnergyInt) {
		getPnOrderTotalEnergyIntDAO().save(pnOrderTotalEnergyInt);
	}

	public BasisNextidDaoImpl<PnOrderTotalEnergyInt> getPnOrderTotalEnergyIntDAO() {
		return pnOrderTotalEnergyIntDAO;
	}

	public void setPnOrderTotalEnergyIntDAO(
			BasisNextidDaoImpl<PnOrderTotalEnergyInt> pnOrderTotalEnergyIntDAO) {
		this.pnOrderTotalEnergyIntDAO = pnOrderTotalEnergyIntDAO;
	}

}
