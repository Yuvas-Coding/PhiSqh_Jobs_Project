package my.com.cmg.iwp.maintenance.service;

import java.util.List;

import my.com.cmg.iwp.backend.model.integration.OutsourceOrderInt;
import my.com.cmg.iwp.backend.model.integration.PatientAllergiesInt;
import my.com.cmg.iwp.backend.model.integration.PatientDiagnosisInt;
import my.com.cmg.iwp.backend.model.integration.PatientInt;
import my.com.cmg.iwp.backend.model.integration.rp.OrderRpInt;
import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;

public interface OutsourceOrderIntService {

	void saveOrUpdate(OutsourceOrderInt outsourceOrderInt);

	void save(OutsourceOrderInt outsourceOrderInt);

	OutsourceOrderInt findByID(long id);

	BasisNextidDaoImpl<OutsourceOrderInt> getOutsourceOrderIntDAO();
	
	void save(PatientInt patientInt);
	
	void save(OrderRpInt orderRpInt);
	
	void save(PatientAllergiesInt patientAllergiesInt);
	
	void save(PatientDiagnosisInt patientDiagnosisInt);
	
	List<OutsourceOrderInt> getOutsourceOrderInt(String orderType, String sendFlag);
	
	void updateOutsourceOrderInt(List<Long> seqnos, String sendFlag);
	
	boolean isExists(OutsourceOrderInt outsourceOrderInt);
	
	OutsourceOrderInt findBySourceOutsourceNo(String sourceOutsourceNo);
	
}
