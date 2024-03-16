package my.com.cmg.iwp.maintenance.service;

import my.com.cmg.iwp.maintenance.model.RegimenDrugDoseSch;

public interface RegimenDrugDoseSchService {

	RegimenDrugDoseSch getNewRegimenDrugDoseSch();

	void delete(RegimenDrugDoseSch anRegimenDrugDoseSch);

	void saveOrUpdate(RegimenDrugDoseSch anRegimenDrugDoseSch);

}
