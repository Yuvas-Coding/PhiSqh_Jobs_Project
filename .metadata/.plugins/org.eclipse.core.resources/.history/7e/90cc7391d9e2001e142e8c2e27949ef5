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
import my.com.cmg.iwp.maintenance.model.RequestNoteLog;
import my.com.cmg.iwp.maintenance.model.ResultObject;
import my.com.cmg.iwp.maintenance.service.ReqNoteLogService;
@Service
public class ReqNoteLogServiceImpl implements ReqNoteLogService {

	private BasisNextidDaoImpl<RequestNoteLog> reqNoteLogDAO;

	public BasisNextidDaoImpl<RequestNoteLog> getReqNoteLogDAO() {
		return reqNoteLogDAO;
	}

	public void setReqNoteLogDAO(
			BasisNextidDaoImpl<RequestNoteLog> reqNoteLogDAO) {
		this.reqNoteLogDAO = reqNoteLogDAO;
	}

	@Override
	public ResultObject getAllRequestLogs(int start, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(RequestNoteLog.class);
		criteria.addOrder(Order.asc("reqNoteSeq"));
		int totalCount = getReqNoteLogDAO().findByCriteria(criteria).size();
		List<RequestNoteLog> list = getReqNoteLogDAO().findByCriteria(criteria,
				start, pageSize);
		return new ResultObject(list, totalCount);
	}

	@Override
	public List<RequestNoteLog> getAllRequestLogs() {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(RequestNoteLog.class);
		criteria.addOrder(Order.asc("reqNoteSeq"));
		return getReqNoteLogDAO().findByCriteria(criteria);
	}

	@Override
	public List<RequestNoteLog> getRequestByCustomer(String customerId,
			String customerRefNo, String customerAccNo) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(RequestNoteLog.class);
		criteria.add(Restrictions.eq("customerId", customerId));
		criteria.add(Restrictions.eq("customerRefNo", customerRefNo));
		criteria.add(Restrictions.eq("customerAccNo", customerAccNo));
		return getReqNoteLogDAO().findByCriteria(criteria);
	}

	@Override
	public List<RequestNoteLog> getRequestByCreateDate(Date createDate) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(RequestNoteLog.class);
		criteria.add(Restrictions.eq("createDate", createDate));
		return getReqNoteLogDAO().findByCriteria(criteria);
	}

	@Override
	public List<RequestNoteLog> findByCriteria(String dateFrom,String dateTo,String ptjCode) {
		String query = "select count(createDate) as count, trunc(createDate) as "
				+ "createDate, 'Y' as status, facilityCode FROM RequestNoteLog WHERE 1=1  ";
		if (null != dateFrom) query += " and createDate >= TO_DATE('" + dateFrom+"','yyyy-mm-dd HH24:MI:SS')";
		if (null != dateTo) query += " and createDate <= TO_DATE('" + dateTo+"','yyyy-mm-dd HH24:MI:SS')";
		if(ptjCode != null) query += " and ptjCode = '" + ptjCode+"'";
		query += " group by trunc(createDate), facilityCode "
				+ " order by trunc(createDate) desc";
		List<RequestNoteLog> reqNoteLogs = new ArrayList<RequestNoteLog>();
		Session session = null;		
		try {
			session = getReqNoteLogDAO().getSessionFactory().openSession();
			Query que = session.createQuery(query);
			List<Object[]> list = que.list();			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			for (int i = 0; i < list.size(); i++) {
				Object[] objs = list.get(i);
				RequestNoteLog log = new RequestNoteLog();
				log.setCount(Long.parseLong(objs[0].toString()));
				log.setCreateDate(dateFormat.parse(objs[1].toString()));
				if (null != objs[2]) {
					log.setStatus(objs[2].toString());
				} else {
					log.setStatus("N");
				}
				log.setFacilityCode(objs[3].toString());
				reqNoteLogs.add(log);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return reqNoteLogs;
	}
}