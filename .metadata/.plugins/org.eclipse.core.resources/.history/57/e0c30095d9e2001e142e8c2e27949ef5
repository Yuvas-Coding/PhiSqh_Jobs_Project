package my.com.cmg.iwp.backend.service.integration.spub.impl;

import org.springframework.stereotype.Service;

import my.com.cmg.iwp.backend.model.integration.spub.SpubDtlsInt;
import my.com.cmg.iwp.backend.service.integration.spub.SpubDtlsIntService;
import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;


@Service
public class SpubDtlsIntServiceImpl implements SpubDtlsIntService {
	private BasisNextidDaoImpl<SpubDtlsInt> spubDtlsIntDAO;

	public BasisNextidDaoImpl<SpubDtlsInt> getSpubDtlsIntDAO() {
		return spubDtlsIntDAO;
	}

	public void setSpubDtlsIntDAO(BasisNextidDaoImpl<SpubDtlsInt> spubDtlsIntDAO) {
		this.spubDtlsIntDAO = spubDtlsIntDAO;
	}

	@Override
	public void refresh(SpubDtlsInt spubDtlsInt) {
		spubDtlsIntDAO.refresh(spubDtlsInt);
		spubDtlsIntDAO.initialize(spubDtlsInt);

	}

	@Override
	public void saveOrUpdate(SpubDtlsInt spubDtlsInt) {
		spubDtlsIntDAO.saveOrUpdate(spubDtlsInt);
	}

}
