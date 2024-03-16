package my.com.cmg.iwp.maintenance.service.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.OrderLineStatus;
import my.com.cmg.iwp.maintenance.model.ResultObject;
import my.com.cmg.iwp.maintenance.service.OrderLineStsService;
@Service
public class OrderLineStsServiceImpl implements OrderLineStsService,
		Serializable {

	private static final long serialVersionUID = 1L;

	private BasisNextidDaoImpl<OrderLineStatus> orderLineStsDAO;

	public BasisNextidDaoImpl<OrderLineStatus> getOrderLineStsDAO() {
		return orderLineStsDAO;
	}

	public void setOrderLineStsDAO(
			BasisNextidDaoImpl<OrderLineStatus> orderLineStsDAO) {
		this.orderLineStsDAO = orderLineStsDAO;
	}

	@Override
	public ResultObject getAllOrderLines(int start, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(OrderLineStatus.class);
		criteria.addOrder(Order.asc("customerAccNo"));
		int totalCnt = getOrderLineStsDAO().findByCriteria(criteria).size();
		List<OrderLineStatus> list = getOrderLineStsDAO().findByCriteria(
				criteria, start, pageSize);
		return new ResultObject(list, totalCnt);
	}

	@Override
	public List<OrderLineStatus> getAllOrderLines() {
		return getOrderLineStsDAO().loadAll(OrderLineStatus.class);
	}

	@Override
	public List<OrderLineStatus> getOrderLineStsByCriteria(String customerAccNo,
			String customerRefNo, String itemCode) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(OrderLineStatus.class);
		criteria.add(Restrictions.eq("customerAccNo", customerAccNo));
		criteria.add(Restrictions.eq("customerRefNo", customerRefNo));
		criteria.add(Restrictions.eq("itemCode", itemCode));
		return getOrderLineStsDAO().findByCriteria(criteria);
	}

}
