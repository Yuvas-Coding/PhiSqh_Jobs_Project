package my.com.cmg.iwp.backend.service.integration.spub.impl;

import org.springframework.stereotype.Service;

import my.com.cmg.iwp.backend.model.integration.spub.NormalDoseFreqAlternateInt;
import my.com.cmg.iwp.backend.model.integration.spub.NormalDoseFrequencyInt;
import my.com.cmg.iwp.backend.service.integration.spub.NormalDoseFrequencyIntService;
import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;


/**
 *
 *@author DavidLeow
 *
 */
@Service
public class NormalDoseFrequencyIntServiceImpl implements NormalDoseFrequencyIntService {
	
	BasisNextidDaoImpl<NormalDoseFrequencyInt> genericUtilDAO;
	
	BasisNextidDaoImpl<NormalDoseFreqAlternateInt> genericUtilFreqDAO;

	public BasisNextidDaoImpl<NormalDoseFrequencyInt> getGenericUtilDAO() {
		return genericUtilDAO;
	}

	public void setGenericUtilDAO(
			BasisNextidDaoImpl<NormalDoseFrequencyInt> genericUtilDAO) {
		this.genericUtilDAO = genericUtilDAO;
	}
	
	@Override
	public void saveOrUpdate(NormalDoseFrequencyInt normalDoseFrequencyInt) {
		getGenericUtilDAO().saveOrUpdate(normalDoseFrequencyInt);
	}

	@Override
	public void create(NormalDoseFrequencyInt normalDoseFrequencyInt) {
		getGenericUtilDAO().save(normalDoseFrequencyInt);
	}
	
	@Override
	public void create(NormalDoseFreqAlternateInt normalDoseFreqAlternateInt) {
		getGenericUtilFreqDAO().save(normalDoseFreqAlternateInt);
	}

	public BasisNextidDaoImpl<NormalDoseFreqAlternateInt> getGenericUtilFreqDAO() {
		return genericUtilFreqDAO;
	}

	public void setGenericUtilFreqDAO(BasisNextidDaoImpl<NormalDoseFreqAlternateInt> genericUtilFreqDAO) {
		this.genericUtilFreqDAO = genericUtilFreqDAO;
	}
}
