package my.com.cmg.iwp.backend.service.integration.spub.impl;

import org.springframework.stereotype.Service;

import my.com.cmg.iwp.backend.model.integration.spub.SpubDiagnosisInt;
import my.com.cmg.iwp.backend.service.integration.spub.SpubDiagnosisIntService;
import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;


@Service
public class SpubDiagnosisIntServiceImpl implements SpubDiagnosisIntService {
	private BasisNextidDaoImpl<SpubDiagnosisInt> spubDiagnosisIntDAO;

	@Override
	public void refresh(SpubDiagnosisInt spubDiagnosisInt) {
		getSpubDiagnosisIntDAO().refresh(spubDiagnosisInt);
		getSpubDiagnosisIntDAO().initialize(spubDiagnosisInt);

	}

	@Override
	public void saveOrUpdate(SpubDiagnosisInt spubDiagnosisInt) {
		getSpubDiagnosisIntDAO().saveOrUpdate(spubDiagnosisInt);
	}

	public BasisNextidDaoImpl<SpubDiagnosisInt> getSpubDiagnosisIntDAO() {
		return spubDiagnosisIntDAO;
	}

	public void setSpubDiagnosisIntDAO(
			BasisNextidDaoImpl<SpubDiagnosisInt> spubDiagnosisIntDAO) {
		this.spubDiagnosisIntDAO = spubDiagnosisIntDAO;
	}

}
