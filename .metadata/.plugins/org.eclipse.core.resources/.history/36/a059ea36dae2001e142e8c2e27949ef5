package my.com.cmg.iwp.backend.service.integration.cdr.impl;

import org.springframework.stereotype.Service;

import my.com.cmg.iwp.backend.model.integration.cdr.CdrDoseFrequencyInt;
import my.com.cmg.iwp.backend.service.integration.cdr.CdrDoseFrequencyIntService;
import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
@Service
public class CdrDoseFrequencyIntServiceImpl implements
		CdrDoseFrequencyIntService {
	private BasisNextidDaoImpl<CdrDoseFrequencyInt> cdrDoseFrequencyIntDAO;

	@Override
	public void refresh(CdrDoseFrequencyInt cdrDoseFrequencyInt) {
		getCdrDoseFrequencyIntDAO().refresh(cdrDoseFrequencyInt);
		getCdrDoseFrequencyIntDAO().initialize(cdrDoseFrequencyInt);
	}

	@Override
	public void saveOrUpdate(CdrDoseFrequencyInt cdrDoseFrequencyInt) {
		getCdrDoseFrequencyIntDAO().saveOrUpdate(cdrDoseFrequencyInt);
	}

	@Override
	public void save(CdrDoseFrequencyInt cdrDoseFrequencyInt) {
		getCdrDoseFrequencyIntDAO().save(cdrDoseFrequencyInt);
	}

	@Override
	public void findById(long id) {
		getCdrDoseFrequencyIntDAO().get(CdrDoseFrequencyInt.class, id);
	}

	public BasisNextidDaoImpl<CdrDoseFrequencyInt> getCdrDoseFrequencyIntDAO() {
		return cdrDoseFrequencyIntDAO;
	}

	public void setCdrDoseFrequencyIntDAO(
			BasisNextidDaoImpl<CdrDoseFrequencyInt> cdrDoseFrequencyIntDAO) {
		this.cdrDoseFrequencyIntDAO = cdrDoseFrequencyIntDAO;
	}

}
