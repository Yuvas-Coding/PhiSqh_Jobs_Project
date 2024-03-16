package my.com.cmg.iwp.maintenance.service;

import java.util.List;

import my.com.cmg.iwp.maintenance.model.Regimen;
import my.com.cmg.iwp.maintenance.model.ResultObject;

public interface RegimenService {

	Regimen getNewRegimen();

	void delete(Regimen anRegimen);

	void saveOrUpdate(Regimen anRegimen);

	List<Regimen> getAllRegimen();

	Regimen findByRegimenCode(String regimenCode);

	ResultObject getRegimensNameInfusionLikeText(String searchRegimenCode,
			String searchRegimenName, String searchCategory, int start,
			int pageSize);
	
	List<Regimen> getRegimenByRgmCode(String rgmCode);	

	Regimen getRegimenByRrmSeqNo(long rgmSeqno);
}
