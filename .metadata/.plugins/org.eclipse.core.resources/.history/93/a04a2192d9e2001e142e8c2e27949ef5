package my.com.cmg.iwp.maintenance.service;

import java.util.List;

import my.com.cmg.iwp.maintenance.model.Regimen;
import my.com.cmg.iwp.maintenance.model.RegimenDrug;
import my.com.cmg.iwp.maintenance.model.ResultObject;

public interface RegimenDrugService {

	void delete(RegimenDrug anRegimenDrug);

	void saveOrUpdate(RegimenDrug anRegimenDrug);

	RegimenDrug getNewRegimenDrug();

	ResultObject getRegimensDrugNameInfusionLikeText(String searchRegimenCode,
			String searchRegimenname, int start, int pageSize);

	RegimenDrug findByDrugSeqNo(long drugSeqno);

	List<RegimenDrug> getRegimenDrugByRegimen(Regimen regimen);

}
