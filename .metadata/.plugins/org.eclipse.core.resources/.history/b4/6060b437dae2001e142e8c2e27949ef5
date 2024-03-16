package my.com.cmg.iwp.maintenance.service;

import java.util.Date;
import java.util.List;

import my.com.cmg.iwp.maintenance.model.RequestNoteLog;
import my.com.cmg.iwp.maintenance.model.ResultObject;

public interface ReqNoteLogService {
	public ResultObject getAllRequestLogs(int start, int pageSize);

	public List<RequestNoteLog> getAllRequestLogs();

	public List<RequestNoteLog> getRequestByCustomer(String customerId,
			String customerRefNo, String customerAccNo);

	public List<RequestNoteLog> getRequestByCreateDate(Date createDate);

	public List<RequestNoteLog> findByCriteria(String integrationDateFrom,String integrationDateTo,String ptjCode);
}
