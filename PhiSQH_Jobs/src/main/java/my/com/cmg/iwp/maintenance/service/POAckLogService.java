package my.com.cmg.iwp.maintenance.service;

import java.util.Date;
import java.util.List;

import my.com.cmg.iwp.maintenance.model.IntegrationBean;
import my.com.cmg.iwp.maintenance.model.POAckLog;
import my.com.cmg.iwp.maintenance.model.ResultObject;

public interface POAckLogService {
	public ResultObject getAllItems(int start, int pageSize);
	public List<POAckLog> getAllItems();
	public List<POAckLog> getItemsByCriteria(Date createDate);
	public List<IntegrationBean> findByCriteria(String dateFrom,String dateTo,String ptjCode);
}
