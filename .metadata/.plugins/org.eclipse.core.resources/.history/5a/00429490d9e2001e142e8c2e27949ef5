package my.com.cmg.iwp.maintenance.service;

import java.util.Date;
import java.util.List;

import my.com.cmg.iwp.maintenance.model.FulfillmentLog;
import my.com.cmg.iwp.maintenance.model.IntegrationBean;
import my.com.cmg.iwp.maintenance.model.ResultObject;

public interface FulfillmentLogService {
	public ResultObject getAllFulfillmentLogs(int start, int pageSize);
	public List<FulfillmentLog> getAllFulfillmentLogs();
	public List<FulfillmentLog> getFulfillmentByCreateDate(Date createDate);
	public List<IntegrationBean> findByCriteria(String dateFrom, String dateTo,String ptjCode);
}
