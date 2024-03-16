package my.com.cmg.iwp.maintenance.service;

import java.util.List;

import my.com.cmg.iwp.maintenance.model.AdminRoute;
import my.com.cmg.iwp.maintenance.model.Drug;
import my.com.cmg.iwp.maintenance.model.DrugRoute;
import my.com.cmg.iwp.maintenance.model.ResultObject;

public interface DrugRouteService {

	DrugRoute getNewDrugRoute();

	void delete(DrugRoute anDrugRoute);

	void saveOrUpdate(DrugRoute anDrugRoute);

	List<DrugRoute> findByDrug(Drug drug);

	List<DrugRoute> getAllDrugRoutes();

	ResultObject getAllDrugRoutesLikeText(String drugCode, int start,
			int pageSize);

	DrugRoute findByDefaultDrugRoute(Drug drug, boolean defaultDrug);

	List<DrugRoute> getAllDrugRoutes(String drugCode);

	DrugRoute findDrugRouteByAdminRoute(Drug drug, AdminRoute adminRoute);

}
