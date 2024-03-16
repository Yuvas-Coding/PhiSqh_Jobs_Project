package my.com.cmg.iwp.backend.service.integration.spub.impl;

import org.springframework.stereotype.Service;

import my.com.cmg.iwp.backend.model.integration.spub.SpubAlternateInt;
import my.com.cmg.iwp.backend.service.integration.spub.SpubAlternateIntService;
import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;

@Service
public class SpubAlternateIntServiceImpl implements SpubAlternateIntService{
	BasisNextidDaoImpl<SpubAlternateInt> genericUtilDAO;

	public BasisNextidDaoImpl<SpubAlternateInt> getGenericUtilDAO() {
		return genericUtilDAO;
	}

	public void setGenericUtilDAO(
			BasisNextidDaoImpl<SpubAlternateInt> genericUtilDAO) {
		this.genericUtilDAO = genericUtilDAO;
	}
	
	@Override
	public void saveOrUpdate(SpubAlternateInt spubAlternateInt) {
		getGenericUtilDAO().saveOrUpdate(spubAlternateInt);
	}

	@Override
	public void create(SpubAlternateInt spubAlternateInt) {
		getGenericUtilDAO().save(spubAlternateInt);
	}
	
}
