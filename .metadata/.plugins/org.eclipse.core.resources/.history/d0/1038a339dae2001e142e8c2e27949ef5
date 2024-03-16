package my.com.cmg.iwp.maintenance.service;

import java.util.Date;
import java.util.List;

import my.com.cmg.iwp.maintenance.model.DoLog;
import my.com.cmg.iwp.maintenance.model.IntegrationBean;
import my.com.cmg.iwp.maintenance.model.ResultObject;

public interface DoLogService {
	public ResultObject getAllRequestLogs(int start, int pageSize);
	public List<DoLog> getAllDoLogs();
	public List<DoLog> getDoByCreateDate(Date createDate);
	public List<IntegrationBean> findByCriteria(String dateFrom, String dateTo,String ptjCode);
}
