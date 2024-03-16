package my.com.cmg.iwp.backend.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import my.com.cmg.iwp.common.util.HibernateSearchObject;
import my.com.cmg.iwp.maintenance.model.OrderDashboardBean;

public interface IntegrationStatusDashboardListService {
	
	List<OrderDashboardBean> getIWPIntegrationBeanList(String intDateFrom, String intDateTo);
	String[] getIntegrationDates(Date dateFrom, Date dateTo);
	HibernateSearchObject getOrderDashboardDialogList(Map<String,Object> paramMap,String facilityCode);
	List<Object> getDistributionList(String string, String string2);
	List<Object> getExternalRequestList(String string, String string2);
}
