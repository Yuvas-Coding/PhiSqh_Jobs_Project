package my.com.cmg.iwp.backend.service.integration.spub;

import java.util.List;

import my.com.cmg.iwp.backend.model.integration.spub.SpubHdrsInt;

public interface SpubHdrsIntService {

	void refresh(SpubHdrsInt spubHdrsInt);

	void saveOrUpdate(SpubHdrsInt spubHdrsInt);

	List<SpubHdrsInt> getSpubHdrsInts(String sendFlag);

	void updateSpubHdrInt(String sendFlagValue, String factCode);
	
	boolean isNotExisted(String spubNo, String fromPtjCode, String fromFactCode);
	
	boolean isRegistered(String spubNo, String fromPtjCode, String fromFactCode);
	
	SpubHdrsInt getSpubBySpubNo(String spubNo);
	
}
