package my.com.cmg.iwp.maintenance.service;

import my.com.cmg.iwp.maintenance.model.HqConfig;

public interface HQConfigService {

	HqConfig getHQConfig();
	
	void saveOrUpdate(HqConfig hqConfig);
	
	boolean isepNextGenActive();

}
