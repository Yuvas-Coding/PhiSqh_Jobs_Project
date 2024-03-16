package my.com.cmg.iwp.maintenance.service;

import java.util.List;

import my.com.cmg.iwp.maintenance.model.OrderLineStatus;
import my.com.cmg.iwp.maintenance.model.ResultObject;

public interface OrderLineStsService {
	public ResultObject getAllOrderLines(int start, int pageSize);

	public List<OrderLineStatus> getAllOrderLines();

	public List<OrderLineStatus> getOrderLineStsByCriteria(String customerAccNo,
			String customerRefNo, String itemCode);
}
