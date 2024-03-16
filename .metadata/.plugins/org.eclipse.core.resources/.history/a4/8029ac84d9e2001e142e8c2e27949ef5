package my.com.cmg.iwp.backend.service.integration.pn.impl;

import org.springframework.stereotype.Service;

import my.com.cmg.iwp.backend.model.integration.pn.PnNutritionalAssmntInt;
import my.com.cmg.iwp.backend.service.integration.pn.PnNutritionalAssmntIntService;
import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
@Service
public class PnNutritionalAssmntIntServiceImpl implements
		PnNutritionalAssmntIntService {

	private BasisNextidDaoImpl<PnNutritionalAssmntInt> pnNutritionalAssmntIntDAO;

	@Override
	public PnNutritionalAssmntInt findById(long id) {
		return getPnNutritionalAssmntIntDAO().get(PnNutritionalAssmntInt.class,
				id);
	}

	@Override
	public void saveOrUpdate(PnNutritionalAssmntInt pnNutritionalAssmntInt) {
		getPnNutritionalAssmntIntDAO().saveOrUpdate(pnNutritionalAssmntInt);
	}

	@Override
	public void save(PnNutritionalAssmntInt pnNutritionalAssmntInt) {
		getPnNutritionalAssmntIntDAO().save(pnNutritionalAssmntInt);
	}

	public BasisNextidDaoImpl<PnNutritionalAssmntInt> getPnNutritionalAssmntIntDAO() {
		return pnNutritionalAssmntIntDAO;
	}

	public void setPnNutritionalAssmntIntDAO(
			BasisNextidDaoImpl<PnNutritionalAssmntInt> pnNutritionalAssmntIntDAO) {
		this.pnNutritionalAssmntIntDAO = pnNutritionalAssmntIntDAO;
	}

}
