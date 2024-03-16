package my.com.cmg.iwp.maintenance.service;

import java.util.Date;
import java.util.List;

import my.com.cmg.iwp.maintenance.model.IntegrationBean;
import my.com.cmg.iwp.maintenance.model.PaymentLog;
import my.com.cmg.iwp.maintenance.model.ResultObject;

public interface PaymentLogService {
	public ResultObject getAllPaymentLogs(int start, int pageSize);

	public List<PaymentLog> getAllPaymentLogs();

	public List<PaymentLog> getPaymentLogByCreateDate(Date createDate);

	List<IntegrationBean> findByCriteria(String dateFrom, String dateTo,String ptjCode);
}