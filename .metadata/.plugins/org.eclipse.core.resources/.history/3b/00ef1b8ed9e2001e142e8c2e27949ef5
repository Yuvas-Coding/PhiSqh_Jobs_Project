package my.com.cmg.iwp.backend.service.integration.cdr.impl;

import org.springframework.stereotype.Service;

import my.com.cmg.iwp.backend.model.integration.cdr.CdrNormalDrugsInt;
import my.com.cmg.iwp.backend.service.integration.cdr.CdrNormalDrugsIntService;
import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
@Service
public class CdrNormalDrugsIntServiceImpl implements CdrNormalDrugsIntService {
	private BasisNextidDaoImpl<CdrNormalDrugsInt> cdrNormalDrugsIntDAO;

	@Override
	public void refresh(CdrNormalDrugsInt orderCdrNormalDrugsInt) {
		getCdrNormalDrugsIntDAO().refresh(orderCdrNormalDrugsInt);
		getCdrNormalDrugsIntDAO().initialize(orderCdrNormalDrugsInt);
	}

	@Override
	public void saveOrUpdate(CdrNormalDrugsInt orderCdrNormalDrugsInt) {
		getCdrNormalDrugsIntDAO().saveOrUpdate(orderCdrNormalDrugsInt);
	}

	@Override
	public void save(CdrNormalDrugsInt orderCdrNormalDrugsInt) {
		getCdrNormalDrugsIntDAO().save(orderCdrNormalDrugsInt);
	}

	@Override
	public void findById(long id) {
		getCdrNormalDrugsIntDAO().get(CdrNormalDrugsInt.class, id);
	}

	public BasisNextidDaoImpl<CdrNormalDrugsInt> getCdrNormalDrugsIntDAO() {
		return cdrNormalDrugsIntDAO;
	}

	public void setCdrNormalDrugsIntDAO(
			BasisNextidDaoImpl<CdrNormalDrugsInt> cdrNormalDrugsIntDAO) {
		this.cdrNormalDrugsIntDAO = cdrNormalDrugsIntDAO;
	}

}
