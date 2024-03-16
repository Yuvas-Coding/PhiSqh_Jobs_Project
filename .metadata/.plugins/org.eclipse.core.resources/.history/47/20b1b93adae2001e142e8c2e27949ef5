package my.com.cmg.iwp.maintenance.service;

import java.util.Date;
import java.util.List;

import my.com.cmg.iwp.maintenance.model.IntegrationBean;
import my.com.cmg.iwp.maintenance.model.PoCancelLog;
import my.com.cmg.iwp.maintenance.model.ResultObject;

public interface PoCancelLogService {
	public ResultObject getAllRequestLogs(int start, int pageSize);
	public List<PoCancelLog> getAllPOCancelLogs();
	public List<PoCancelLog> getPoCancelByCreateDate(Date createDate);
	public List<IntegrationBean> findByCriteria(String dateFrom, String dateTo,String ptjCode);
}
