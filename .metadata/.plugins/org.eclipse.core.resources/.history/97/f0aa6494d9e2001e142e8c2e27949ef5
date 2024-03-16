package my.com.cmg.iwp.backend.service.integration.returns;

import java.util.List;

import my.com.cmg.iwp.backend.model.integration.returns.ReturnInterDtlsInt;
import my.com.cmg.iwp.backend.model.integration.returns.ReturnInterHdrsInt;
import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;


public interface ReturnIntegrationService {
	
	void save(ReturnInterHdrsInt returnInterHdrsInt);

	void save(ReturnInterDtlsInt returnInterDtlsInt);

	List<ReturnInterHdrsInt> getAllSendReturn();

	BasisNextidDaoImpl<ReturnInterHdrsInt> getReturnInterHdrsIntDAO();

	void updateSendFlag(String sendFlagValue, String ptjCode, String factCode);
	
}
