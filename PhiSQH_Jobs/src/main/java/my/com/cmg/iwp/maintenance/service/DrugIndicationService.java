package my.com.cmg.iwp.maintenance.service;

import java.util.List;

import my.com.cmg.iwp.maintenance.model.Drug;
import my.com.cmg.iwp.maintenance.model.DrugIndication;
import my.com.cmg.iwp.maintenance.model.Indication;
import my.com.cmg.iwp.maintenance.model.ResultObject;

public interface DrugIndicationService {

	DrugIndication getNewDrugIndication();

	void delete(DrugIndication anDrugIndication);

	void saveOrUpdate(DrugIndication anDrugIndication);

	ResultObject getAllDrugIndicationsLikeText(String drugCode, String text,
			int i, int pageSize);

	DrugIndication findDrugRouteByAdminRoute(Drug drug, Indication indication);

	List<DrugIndication> findDrugDrugIndicationByDrug(Drug drug);
}
