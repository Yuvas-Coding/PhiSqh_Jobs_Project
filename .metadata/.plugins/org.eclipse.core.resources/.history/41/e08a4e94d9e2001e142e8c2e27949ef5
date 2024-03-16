package my.com.cmg.iwp.backend.service.integration.indent;

import java.util.List;

import my.com.cmg.iwp.backend.model.integration.indent.IndentDtlsInt;
import my.com.cmg.iwp.backend.model.integration.indent.IndentHdrsInt;
import my.com.cmg.iwp.backend.model.integration.indent.SpubPatientInfoInt;

public interface IndentIntService {
	void saveOrUpdate(IndentHdrsInt indentHdrsInt);

	void saveOrUpdate(IndentDtlsInt indentDtlsInt);

	List<IndentHdrsInt> getAllSendIndent();

	void updateIndentHdrsInt(String sendFlagValue, String ptjCode,
			String factCode);

	void updateSendFlag(String sendFlagValue, String ptjCode, String factCode);
	
	void saveOrUpdate(SpubPatientInfoInt spubPatientInfoInt);

	List<SpubPatientInfoInt> getSpubPatientInfoByDtl(IndentDtlsInt indentDtlsInt);
}
