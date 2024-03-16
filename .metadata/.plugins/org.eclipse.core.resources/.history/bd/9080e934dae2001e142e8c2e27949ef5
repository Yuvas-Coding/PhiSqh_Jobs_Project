package my.com.cmg.iwp.backend.service.integration.spub.impl;

import org.springframework.stereotype.Service;

import my.com.cmg.iwp.backend.model.integration.spub.SpubAllergiesInt;
import my.com.cmg.iwp.backend.service.integration.spub.SpubAllergiesIntService;
import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
@Service
public class SpubAllergiesIntServiceImpl implements SpubAllergiesIntService {
	private BasisNextidDaoImpl<SpubAllergiesInt> spubAllergiesIntDAO;

	@Override
	public void refresh(SpubAllergiesInt spubAllergiesInt) {
		getSpubAllergiesIntDAO().refresh(spubAllergiesInt);
		getSpubAllergiesIntDAO().initialize(spubAllergiesInt);

	}

	@Override
	public void saveOrUpdate(SpubAllergiesInt spubAllergiesInt) {
		getSpubAllergiesIntDAO().saveOrUpdate(spubAllergiesInt);
	}

	public BasisNextidDaoImpl<SpubAllergiesInt> getSpubAllergiesIntDAO() {
		return spubAllergiesIntDAO;
	}

	public void setSpubAllergiesIntDAO(
			BasisNextidDaoImpl<SpubAllergiesInt> spubAllergiesIntDAO) {
		this.spubAllergiesIntDAO = spubAllergiesIntDAO;
	}
}
