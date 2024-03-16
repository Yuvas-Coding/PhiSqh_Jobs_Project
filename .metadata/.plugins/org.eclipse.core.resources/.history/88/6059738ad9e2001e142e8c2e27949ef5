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
import my.com.cmg.iwp.maintenance.model.IntegrationBean;
import my.com.cmg.iwp.maintenance.model.PoCancelLog;
import my.com.cmg.iwp.maintenance.model.ResultObject;
import my.com.cmg.iwp.maintenance.service.PoCancelLogService;
import my.com.cmg.iwp.util.ApplicationConstants;
@Service
public class PoCancelLogServiceImpl implements PoCancelLogService {
	private BasisNextidDaoImpl<PoCancelLog> poCancelLogDAO;

	public BasisNextidDaoImpl<PoCancelLog> getPoCancelLogDAO() {
		return poCancelLogDAO;
	}

	public void setPoCancelLogDAO(BasisNextidDaoImpl<PoCancelLog> poCancelLogDAO) {
		this.poCancelLogDAO = poCancelLogDAO;
	}

	@Override
	public ResultObject getAllRequestLogs(int start, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(PoCancelLog.class);
		criteria.addOrder(Order.asc("poSeqNo"));
		int totalCount = getPoCancelLogDAO().findByCriteria(criteria).size();
		List<PoCancelLog> list = getPoCancelLogDAO().findByCriteria(criteria,
				start, pageSize);
		return new ResultObject(list, totalCount);
	}

	@Override
	public List<PoCancelLog> getAllPOCancelLogs() {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(PoCancelLog.class);
		criteria.addOrder(Order.asc("poSeqNo"));
		return getPoCancelLogDAO().findByCriteria(criteria);
	}

	@Override
	public List<PoCancelLog> getPoCancelByCreateDate(Date createDate) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(PoCancelLog.class);
		criteria.add(Restrictions.eq("createDate", createDate));
		return getPoCancelLogDAO().findByCriteria(criteria);
	}

	@Override
	public List<IntegrationBean> findByCriteria(String dateFrom,String dateTo,String ptjCode)  {
		/*String sql = "select count(createDate) as noOfTransactions, trunc(createDate) as "
				+ " integrationDate, 'Y' as status, poHdr.facilityCode from PoCancelLog where 1 = 1 ";
		if (null != dateFrom) sql += " and createDate >= TO_DATE('" + dateFrom+"','yyyy-mm-dd HH24:MI:SS')";
		if (null != dateTo) sql += " and createDate <= TO_DATE('" + dateTo+"','yyyy-mm-dd HH24:MI:SS')";
		if(ptjCode != null) sql += " and poHdr.ptjCode = '" + ptjCode+"'";
		sql += " group by trunc(createDate), poHdr.facilityCode  "
				+ " order by trunc(createDate) desc";*/
		String sql = "select extFac.facility_Name,data.noOfTransactions,data.integrationDate,data.status, poHdr.FACILITY_CODE " +
				" from ( select count(create_Date) as noOfTransactions, trunc(create_Date) as integrationDate, 'Y' as status, PO_HDR_SEQNO from" +
				" T_PO_CANCEL_LOG where 1 = 1" ;
		if (null != dateFrom) sql += " and create_Date >= TO_DATE('" + dateFrom+"','yyyy-mm-dd HH24:MI:SS')";
		if (null != dateTo) sql += " and create_Date <= TO_DATE('" + dateTo+"','yyyy-mm-dd HH24:MI:SS')";
		if(ptjCode != null) sql += " and poHdr.ptj_Code = '" + ptjCode+"'";
		sql += 	" group by trunc(create_Date), PO_HDR_SEQNO  order by trunc(create_Date) desc) data inner join t_po_hdr poHdr on " +
				" poHdr.PO_HDR_SEQNO=data.PO_HDR_SEQNO " +
				" inner join T_EXTERNAL_FACILITIES extFac on extFac.facility_Code=poHdr.FACILITY_CODE where extFac.SERVER_IP IS NOT NULL  group by  poHdr.FACILITY_CODE,extFac.facility_Name," +
				" data.noOfTransactions,data.integrationDate,data.status  order by data.integrationDate desc";
		List<IntegrationBean> itemLogs = new ArrayList<IntegrationBean>();
		Session session = null;
		try {
			session = getPoCancelLogDAO().getSessionFactory().openSession();
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
				log.setIntegrationType("LPO Cancellation");
				log.setIntType(ApplicationConstants.LPO_CANCEL);

				/*String sqlFacility = "select facilityName from ExternalFacility " +
					" where facilityCode = '"+objs[3].toString()+"'" ;
				Query query = session.createQuery(sqlFacility);
				List<String> list1 = query.list();
				for (int j = 0; j < list1.size(); j++) {
					//Object[] objs1 = list1.get(j);
					log.setFacilityName(list1.get(j).toString());
				}*/
				log.setFacilityName(objs[0].toString());
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