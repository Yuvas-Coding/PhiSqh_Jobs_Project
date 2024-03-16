package my.com.cmg.iwp.maintenance.service;

import my.com.cmg.iwp.backend.model.integration.IntegrationLog;


public interface IntegrationLogService {
	
	void saveOrUpdate(IntegrationLog anIntegrationLog);
}
