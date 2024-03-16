package my.com.cmg.iwp.maintenance.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.management.Query;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.ItemEPLog;
import my.com.cmg.iwp.maintenance.model.ResultObject;
import my.com.cmg.iwp.maintenance.service.ItemEPLogService;
@Service
public class ItemEPLogServiceImpl implements ItemEPLogService {

	private BasisNextidDaoImpl<ItemEPLog> itemEPLogDAO;

	public BasisNextidDaoImpl<ItemEPLog> getItemEPLogDAO() {
		return itemEPLogDAO;
	}

	public void setItemEPLogDAO(BasisNextidDaoImpl<ItemEPLog> itemEPLogDAO) {
		this.itemEPLogDAO = itemEPLogDAO;
	}

	@Override
	public ResultObject getAllItems(int start, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(ItemEPLog.class);
		criteria.addOrder(Order.asc("itemCode"));
		int totalCount = getItemEPLogDAO().findByCriteria(criteria).size();
		List<ItemEPLog> list = getItemEPLogDAO().findByCriteria(criteria,
				start, pageSize);
		return new ResultObject(list, totalCount);
	}

	@Override
	public List<ItemEPLog> getAllItems() {
		return getItemEPLogDAO().loadAll(ItemEPLog.class);
	}

	@Override
	public List<ItemEPLog> getItemsByCriteria1(Date dateFrom, Date dateTo) {
		DetachedCriteria criteria = DetachedCriteria.forClass(ItemEPLog.class);
		criteria.addOrder(Order.asc("itemCode"));
		if (null != dateFrom) {
			criteria.add(Restrictions.ge("createDate", dateFrom));
		}
		if (null != dateTo) {
			criteria.add(Restrictions.le("createDate", dateTo));
		}
		return getItemEPLogDAO().findByCriteria(criteria);

	}

	@Override
	public List<ItemEPLog> getItemsByCriteria(String dateFrom, String dateTo,String ptjCode) {
		String query = "select count(createDate) as count, trunc(createDate) as "
				+ "createDate, epStatus as status FROM ItemEPLog WHERE 1=1 ";
		if (null != dateFrom) query += " and createDate >= TO_DATE('" + dateFrom+"','yyyy-mm-dd HH24:MI:SS')";
		if (null != dateTo) query += " and createDate <= TO_DATE('" + dateTo+"','yyyy-mm-dd HH24:MI:SS')";
		if(ptjCode != null) query += " and ptjCode = " + ptjCode;
		query += " group by trunc(createDate), "
				+ "epStatus order by trunc(createDate) desc";
		List<ItemEPLog> itemLogs = new ArrayList<ItemEPLog>();
		Session session = null;		
		try {
			session = getItemEPLogDAO().getSessionFactory().openSession();
			Query que = session.createQuery(query);
			List<Object[]> list = que.list();			
			SimpleDateFormat dateFormat = new SimpleDateFormat(
					"yyyy-MM-dd");
			for (int i = 0; i < list.size(); i++) {
				Object[] objs = list.get(i);
				ItemEPLog log = new ItemEPLog();
				log.setCount(Long.parseLong(objs[0].toString()));
				log.setCreateDate(dateFormat.parse(objs[1].toString()));
				if (null != objs[2]) {
					log.setStatus(objs[2].toString());
				} else {
					log.setStatus("N");
				}
				System.out.println(objs[1].toString());
				itemLogs.add(log);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return itemLogs;
	}
}