package my.com.cmg.iwp.maintenance.service;

import java.util.Date;
import java.util.List;

import my.com.cmg.iwp.maintenance.model.IntegrationBean;
import my.com.cmg.iwp.maintenance.model.ReqCancelLog;
import my.com.cmg.iwp.maintenance.model.ResultObject;

public interface ReqCancelLogService {
	public ResultObject getAllRequestLogs(int start, int pageSize);
	public List<ReqCancelLog> getAllRequestLogs();
	public List<ReqCancelLog> getRequestByCreateDate(Date createDate);
	public List<IntegrationBean> findByCriteria(String dateFrom, String dateTo,String ptjCode);
}
