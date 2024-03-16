package my.com.cmg.iwp.maintenance.service;

import java.util.List;

import my.com.cmg.iwp.maintenance.model.AdminRoute;
import my.com.cmg.iwp.maintenance.model.Drug;
import my.com.cmg.iwp.maintenance.model.ResultObject;

public interface AdminRouteService {

	AdminRoute getNewAdminRoute();

	void delete(AdminRoute anAdminRoute);

	void saveOrUpdate(AdminRoute anAdminRoute);

	List<AdminRoute> getAllAdminRoutes();

	ResultObject getAllAdminRoutesLikeText(String searchText, int start,
			int pageSize);

	AdminRoute findByAdminRouteCode(String value);

	AdminRoute findByRouteCode(String routeCode);

	AdminRoute getAllAdminRoutes(Drug drug);

}
