package my.com.cmg.iwp.maintenance.service.impl;

import org.springframework.stereotype.Service;

import my.com.cmg.iwp.backend.model.integration.IntegrationLog;
import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.service.IntegrationLogService;
@Service
public class IntegrationLogServiceImpl implements IntegrationLogService {
	
	private BasisNextidDaoImpl<IntegrationLog> integrationLogDAO;

	public BasisNextidDaoImpl<IntegrationLog> getIntegrationLogDAO() {
		return integrationLogDAO;
	}

	public void setIntegrationLogDAO(
			BasisNextidDaoImpl<IntegrationLog> integrationLogDAO) {
		this.integrationLogDAO = integrationLogDAO;
	}

	@Override
	public void saveOrUpdate(IntegrationLog anIntegrationLog) {
		integrationLogDAO.saveOrUpdate(anIntegrationLog);
	}
}