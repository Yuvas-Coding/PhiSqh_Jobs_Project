package my.com.cmg.iwp.maintenance.service;

import my.com.cmg.iwp.maintenance.model.PTJCode;

public interface ptjCodeService {

	PTJCode getNewPtjCode();

	void delete(PTJCode anPTJCode);

	void saveOrUpdate(PTJCode anPTJCode);

	PTJCode findPtjCodeByCode(String ptjCode);

	PTJCode findPtjCode(long queryString);

}