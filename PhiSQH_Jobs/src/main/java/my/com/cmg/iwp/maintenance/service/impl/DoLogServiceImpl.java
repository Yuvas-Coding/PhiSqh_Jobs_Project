package my.com.cmg.iwp.maintenance.service.impl;

import java.math.BigDecimal;
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
import my.com.cmg.iwp.maintenance.model.DoLog;
import my.com.cmg.iwp.maintenance.model.IntegrationBean;
import my.com.cmg.iwp.maintenance.model.ResultObject;
import my.com.cmg.iwp.maintenance.service.DoLogService;
import my.com.cmg.iwp.util.ApplicationConstants;
@Service
public class DoLogServiceImpl implements DoLogService {

	private BasisNextidDaoImpl<DoLog> doLogDAO;

	public BasisNextidDaoImpl<DoLog> getDoLogDAO() {
		return doLogDAO;
	}

	public void setDoLogDAO(BasisNextidDaoImpl<DoLog> doLogDAO) {
		this.doLogDAO = doLogDAO;
	}

	@Override
	public ResultObject getAllRequestLogs(int start, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(DoLog.class);
		criteria.addOrder(Order.asc("seqNo"));
		int totalCount = getDoLogDAO().findByCriteria(criteria).size();
		List<DoLog> list = getDoLogDAO().findByCriteria(criteria, start,
				pageSize);
		return new ResultObject(list, totalCount);
	}

	@Override
	public List<DoLog> getAllDoLogs() {
		DetachedCriteria criteria = DetachedCriteria.forClass(DoLog.class);
		criteria.addOrder(Order.asc("seqNo"));
		return getDoLogDAO().findByCriteria(criteria);
	}

	@Override
	public List<DoLog> getDoByCreateDate(Date createDate) {
		DetachedCriteria criteria = DetachedCriteria.forClass(DoLog.class);
		criteria.add(Restrictions.eq("createDate", createDate));
		return getDoLogDAO().findByCriteria(criteria);
	}

	@Override
	public List<IntegrationBean> findByCriteria(String dateFrom,String dateTo,String ptjCode) {
		/*String sql = "select count(createDate) as noOfTransactions, trunc(createDate) as "
				+ " integrationDate, status as status, lpoNo, lampironNo from DoLog where 1 = 1 ";
		if (null != dateFrom) sql += " and createDate >= TO_DATE('" + dateFrom+"','yyyy-mm-dd HH24:MI:SS')";
		if (null != dateTo) sql += " and createDate <= TO_DATE('" + dateTo+"','yyyy-mm-dd HH24:MI:SS')";
		if(ptjCode != null) sql += " and ptjCode = " + ptjCode;
		sql += " group by trunc(createDate), status, lpoNo, lampironNo  "
				+ " order by trunc(createDate) desc";*/
		String sql = "select extFac.facility_Name, data.noOfTransactions, data.integrationDate, data.status  from ( select count(create_Date) as noOfTransactions, trunc(create_Date) as "
				+ " integrationDate, status as status, lpo_No, lampiran_No from T_DO_LOG where 1 = 1 ";
		if (null != dateFrom) sql += " and create_Date >= TO_DATE('" + dateFrom+"','yyyy-mm-dd HH24:MI:SS')";
		if (null != dateTo) sql += " and create_Date <= TO_DATE('" + dateTo+"','yyyy-mm-dd HH24:MI:SS')";
		if(ptjCode != null) sql += " and ptj_Code = " + ptjCode;
		sql += " group by trunc(create_Date), status, lpo_No, lampiran_No  "
				+ "  )  data inner join t_Do_Dtl DoDtl on DoDtl.lpo_No=data.lpo_No and DoDtl.lampiran_No=data.lampiran_No inner join T_EXTERNAL_FACILITIES extFac on extFac.facility_Code=DoDtl.customer_Id where extFac.SERVER_IP IS NOT NULL order by data.integrationDate desc";
		List<IntegrationBean> itemLogs = new ArrayList<IntegrationBean>();
		Session session = null;
		try {
			session = getDoLogDAO().getSessionFactory().openSession();
			Query que = session.createSQLQuery(sql);
			List<Object[]> list = que.list();
			SimpleDateFormat dateFormat = new SimpleDateFormat(
					"yyyy-MM-dd");
			for (int i = 0; i < list.size(); i++) {
				Object[] objs = list.get(i);
				IntegrationBean log = new IntegrationBean();
				log.setNoOfTransactions(new BigDecimal(Long.parseLong(objs[0+1]
						.toString())));
				log.setIntegrationDate(dateFormat.parse(objs[1+1].toString()));
				if (null != objs[2+1]) {
					log.setStatus(objs[2+1].toString());
				} else {
					log.setStatus("N");
				}
				log.setIntegrationType("Delivery Order Creation");
				log.setIntType(ApplicationConstants.DO_CREATION);
				log.setFacilityName(objs[0].toString());
				/*String doQuery ="select customerId from DoDtl where lpoNo = '" 
					+ objs[3].toString() +"' and lampiranNo = '"+objs[4].toString() + "'";
				Query doQ = session.createQuery(doQuery);
				List<String> listDo = doQ.list();
				for (int k = 0; k < listDo.size(); k++) {				
					String sqlFacility = "select facilityName from ExternalFacility " +
						" where facilityCode = '"+listDo.get(k).toString()+"'" ;
					Query query = session.createQuery(sqlFacility);
					List<String> list1 = query.list();
					for (int j = 0; j < list1.size(); j++) {
						//Object[] objs1 = list1.get(j);
						log.setFacilityName(list1.get(j).toString());
					}
				}*/
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
