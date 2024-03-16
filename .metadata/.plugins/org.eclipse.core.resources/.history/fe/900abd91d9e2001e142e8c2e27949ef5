package my.com.cmg.iwp.maintenance.service;

import java.util.Date;
import java.util.List;

import my.com.cmg.iwp.maintenance.model.IntegrationBean;
import my.com.cmg.iwp.maintenance.model.InvoiceLog;
import my.com.cmg.iwp.maintenance.model.ResultObject;

public interface InvoiceLogService {
	public ResultObject getAllInvoiceLogs(int start, int pageSize);
	public List<InvoiceLog> getAllInvoiceLogs();
	public List<InvoiceLog> getInvoiceLogByCreateDate(Date createDate);
	List<IntegrationBean> findByCriteria(String dateFrom, String dateTo,String ptjCode);
}
