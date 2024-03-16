package my.com.cmg.iwp.maintenance.service;

import java.util.Date;
import java.util.List;

import my.com.cmg.iwp.maintenance.model.AdminRoute;
import my.com.cmg.iwp.maintenance.model.AtcDetail;
import my.com.cmg.iwp.maintenance.model.DosageForm;
import my.com.cmg.iwp.maintenance.model.Drug;
import my.com.cmg.iwp.maintenance.model.DrugRoute;
import my.com.cmg.iwp.maintenance.model.GenericName;
import my.com.cmg.iwp.maintenance.model.ResultObject;

public interface DrugService {

	Drug getNewDrug();

	void delete(Drug anDrug);

	void saveOrUpdate(Drug anDrug);

	Drug findByDrugCode(String drugCode);
	
	ResultObject getAllDrugsATCLikeText(String searchLevel1,
			String searchLevel2, String searchLevel3, String searchLevel4,
			String searchLevel5, int start, int pageSize);

	ResultObject getAllDrugsGenericNameLikeText(String searchGenericName,
			String searchAdminRoute, String searchDosageForm, int start,
			int pageSize);
	ResultObject getAllDrugsGenericNameLikeText(String searchGenericName,  int start, int pageSize);

	ResultObject getAllDrugsDrugNameLikeText(String text, int start,
			int pageSize);

	ResultObject getAllDrugsIVFluidLikeText(String drugCode, String drugName,
			boolean IVFluid, int start, int pageSize);

	ResultObject getAllDrugsDrugNameLikeText(String textDrugName,
			String textCategory, String textFormulary, int start, int pageSize);

	List<Drug> getAllDrugs();

	ResultObject getAllDrugsDrugNameInfusionLikeText(String searchDrugCode,
			String searchDrugName, int start, int pageSize);

	public Drug findByFluidDrug(boolean ivFluidYn, boolean ivDrugYn);

	ResultObject getDrugsDrugNameInfusionLikeText(boolean ivFluidYn,
			boolean ivDrugYn, int start, int pageSize);

	ResultObject getAllAlternateDrugsLikeAtcCode(String atcCode, String requestedDrug, int start,
			int pageSize);

	List<Drug> findLikeATC(String atcCode);
	
	List<Drug> getAllDrugsFromDate(Date date);
	
	ResultObject getAlternateDrugsLikeGenericName(String genericName, String requestedDrug, int start,
			int pageSize);
	
	List<Drug> getAlternateDrugs(GenericName genericName, Drug drug);	
	
	List<Drug> getDrugsByCriteria(DosageForm dosageForm, AdminRoute adminRoute, String genericName);
	
	List<Drug> getDrugsByDrugNameAndCategory(String drugName , String drugCategory);
	
	List<Drug> getDrugsByAtcDetail(AtcDetail atcDetail, Integer level);
	
	Drug getDrug(long drugSeqno);

	List<Drug> getDrugsHavingGenericName(GenericName genericName);
	
	void refresh(Drug anDrug);

	boolean isDrugDangerous(String drugSchedule);
	
	List<Drug> getDrugsIlikeName(String drugName);
	List<Drug> getDrugTdmDrugs(String drugCode,String drugName);

	List<Drug> getDiluentDrugs(List<Long> drugSeqno);

	Drug findByDrugSeqno(long drugSeqno);

	List<Drug> getDrugsHavingGenericNameAndDrugRoute(GenericName genericName, DrugRoute drugRoute);

	List<Drug> getDrugsListByStatus();

	List<Drug> getAlternateDrugsForPn(Drug drug);
}