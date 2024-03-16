package my.com.cmg.iwp.backend.service.integration.cdr.impl;

import org.springframework.stereotype.Service;

import my.com.cmg.iwp.backend.model.integration.cdr.CdrInfusionDrugsInt;
import my.com.cmg.iwp.backend.service.integration.cdr.CdrInfusionDrugsIntService;
import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
@Service
public class CdrInfusionDrugsIntServiceImpl implements
		CdrInfusionDrugsIntService {
	private BasisNextidDaoImpl<CdrInfusionDrugsInt> cdrInfusionDrugsIntDAO;

	@Override
	public void refresh(CdrInfusionDrugsInt cdrInfusionDrugsInt) {
		getCdrInfusionDrugsIntDAO().refresh(cdrInfusionDrugsInt);
		getCdrInfusionDrugsIntDAO().initialize(cdrInfusionDrugsInt);
	}

	@Override
	public void saveOrUpdate(CdrInfusionDrugsInt cdrInfusionDrugsInt) {
		getCdrInfusionDrugsIntDAO().saveOrUpdate(cdrInfusionDrugsInt);
	}

	@Override
	public void save(CdrInfusionDrugsInt cdrInfusionDrugsInt) {
		getCdrInfusionDrugsIntDAO().save(cdrInfusionDrugsInt);
	}

	@Override
	public void findById(long id) {
		getCdrInfusionDrugsIntDAO().get(CdrInfusionDrugsInt.class, id);
	}

	public BasisNextidDaoImpl<CdrInfusionDrugsInt> getCdrInfusionDrugsIntDAO() {
		return cdrInfusionDrugsIntDAO;
	}

	public void setCdrInfusionDrugsIntDAO(
			BasisNextidDaoImpl<CdrInfusionDrugsInt> cdrInfusionDrugsIntDAO) {
		this.cdrInfusionDrugsIntDAO = cdrInfusionDrugsIntDAO;
	}

}
