package my.com.cmg.iwp.maintenance.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.Query;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.DeliveredTo;
import my.com.cmg.iwp.maintenance.model.ExternalFacility;
import my.com.cmg.iwp.maintenance.model.IntegrationBean;
import my.com.cmg.iwp.maintenance.model.PoDtl;
import my.com.cmg.iwp.maintenance.model.PoHdr;
import my.com.cmg.iwp.maintenance.service.PoHdrService;
import my.com.cmg.iwp.util.ApplicationConstants;
import my.com.cmg.iwp.webui.report.SummaryePintegrationBean;
import my.com.cmg.iwp.webui.util.DateUtil;
@Service
public class PoHdrServiceImpl implements PoHdrService {
	private BasisNextidDaoImpl<PoHdr> poHdrDAO;

	@Override
	public List<PoHdr> getdel_to_code_from_po_hdr(Long delSeqNo) {
		String query = "select all po " + "from PoHdr po join fetch po.deliveredTo as dt " + "where dt.delToSeqno="
				+ delSeqNo;
		return poHdrDAO.find(query);
	}

	public BasisNextidDaoImpl<PoHdr> getPoHdrDAO() {
		return poHdrDAO;
	}

	public void setPoHdrDAO(BasisNextidDaoImpl<PoHdr> poHdrDAO) {
		this.poHdrDAO = poHdrDAO;
	}

	@Override
	public List<PoHdr> searchOrderAnalysisByCriteria(String lpoNo, String epoNo, ExternalFacility custMstr,
			String epoDateFrm, String epoDateT, String lpoDateFrm, String lpoDateT) throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");
		DetachedCriteria criteria = DetachedCriteria.forClass(PoHdr.class, "po");
		criteria.add(Restrictions.eq("po.facilityCode", custMstr.getFacilityCode().trim()));
		if (StringUtils.isNotEmpty(lpoNo)) {
			criteria.add(Restrictions.eq("po.lpoNo", lpoNo.trim()));
		}
		if (StringUtils.isNotEmpty(epoNo)) {
			criteria.add(Restrictions.eq("po.purchaseOrderNo", epoNo.trim()));
		}
		if (StringUtils.isNotEmpty(epoDateFrm)) {
			criteria.add(Restrictions.ge("po.orderDate", dateFormat.parse(epoDateFrm)));
		}
		if (StringUtils.isNotEmpty(epoDateT)) {
			criteria.add(Restrictions.le("po.orderDate", dateFormat.parse(epoDateT)));
		}
		if (StringUtils.isNotEmpty(lpoDateFrm)) {
			criteria.add(Restrictions.ge("po.lpoDate", dateFormat.parse(lpoDateFrm)));
		}
		if (StringUtils.isNotEmpty(lpoDateT)) {
			criteria.add(Restrictions.le("po.lpoDate", dateFormat.parse(lpoDateT)));
		}
		// criteria.setFetchMode("externalFacility", FetchMode.JOIN);
		criteria.setFetchMode("requestNoteLogs", FetchMode.JOIN);
		criteria.setFetchMode("fulFillmentLogs", FetchMode.JOIN);
		criteria.setFetchMode("invoiceLogs", FetchMode.JOIN);
		criteria.setFetchMode("paymentLogs", FetchMode.JOIN);
		criteria.setFetchMode("reqCancelLogs", FetchMode.JOIN);
		criteria.setFetchMode("poAckLogs", FetchMode.JOIN);
		criteria.setFetchMode("doDtls", FetchMode.JOIN);
		criteria.setFetchMode("poDtls", FetchMode.JOIN);
		criteria.setFetchMode("poCancelLogs", FetchMode.JOIN);
		criteria.setFetchMode("deliveredTo", FetchMode.JOIN);
		criteria.addOrder(Order.asc("po.facilityCode"));

		return poHdrDAO.findByCriteria(criteria);
	}

	@Override
	public List<PoHdr> searchOrderStatasticsByCriteria(ExternalFacility custMstr, String epoDateFrm, String epoDateT,
			String searchOption, List<String> clinicCodes, List<String> hosCodes) throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");
		DetachedCriteria criteria = DetachedCriteria.forClass(PoHdr.class, "po");
		if (null != custMstr) {
			criteria.add(Restrictions.eq("po.facilityCode", custMstr.getFacilityCode().trim()));
		} else if (searchOption.equalsIgnoreCase("Hos")) {
			criteria.add(Restrictions.in("po.facilityCode", hosCodes));
		} else if (searchOption.equalsIgnoreCase("Cli")) {
			criteria.add(Restrictions.in("po.facilityCode", clinicCodes));
		}

		if (StringUtils.isNotEmpty(epoDateFrm)) {
			criteria.add(Restrictions.ge("po.orderDate", dateFormat.parse(epoDateFrm)));
		}
		if (StringUtils.isNotEmpty(epoDateT)) {
			criteria.add(Restrictions.le("po.orderDate", dateFormat.parse(epoDateT)));
		}

		// criteria.setFetchMode("externalFacility", FetchMode.JOIN);
		criteria.setFetchMode("requestNoteLogs", FetchMode.JOIN);
		criteria.setFetchMode("fulFillmentLogs", FetchMode.JOIN);
		criteria.setFetchMode("invoiceLogs", FetchMode.JOIN);
		criteria.setFetchMode("paymentLogs", FetchMode.JOIN);
		criteria.setFetchMode("reqCancelLogs", FetchMode.JOIN);
		criteria.setFetchMode("poAckLogs", FetchMode.JOIN);
		criteria.setFetchMode("doDtls", FetchMode.JOIN);
		criteria.setFetchMode("poDtls", FetchMode.JOIN);
		criteria.setFetchMode("poCancelLogs", FetchMode.JOIN);
		criteria.setFetchMode("deliveredTo", FetchMode.JOIN);
		criteria.addOrder(Order.asc("po.facilityCode"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

		return poHdrDAO.findByCriteria(criteria);
	}

	@Override
	public List<PoHdr> getPOHdrsByFacility(String facilityCode) {
		String query = "select all po from PoHdr po " + " join fetch po.externalFacility as ef "
				+ " where ef.facilityCode='" + facilityCode + "'";
		return poHdrDAO.find(query);
	}

	@Override
	public PoHdr getPOHdrsByFacilityAndPurchaseOrderNo(String facilityCode, String purchaseOrderNo) {
		DetachedCriteria criteria = DetachedCriteria.forClass(PoHdr.class, "po");
		criteria.add(Restrictions.eq("po.facilityCode", facilityCode));
		criteria.add(Restrictions.eq("po.purchaseOrderNo", purchaseOrderNo));
		return DataAccessUtils.uniqueResult(getPoHdrDAO().findByCriteria(criteria));
	}

	@Override
	public List<IntegrationBean> getLPOApprovalCount(String dateFrom, String dateTo, String ptjCode) {
		/*
		 * String sql
		 * ="select count(createdDate) as noOfTransactions, max(lpoDate) AS lpoDate, "
		 * +
		 * " 'Y' as orderStatus, facilityCode from PoHdr where lpoDate is not null "
		 * ; if (null != dateFrom) sql += " and lpoDate >= TO_DATE('" +
		 * dateFrom+"','yyyy-mm-dd HH24:MI:SS')"; if (null != dateTo) sql +=
		 * " and lpoDate <= TO_DATE('" + dateTo+"','yyyy-mm-dd HH24:MI:SS')";
		 * if(ptjCode != null) sql += " and ptjCode = '" + ptjCode+"'"; sql +=
		 * " group by trunc(lpoDate), facilityCode " +
		 * " order by trunc(lpoDate) desc";
		 */
		String sql = "select extFac.facility_Name,count(poHdr.created_Date) as noOfTransactions, max(poHdr.lpo_Date) AS lpoDate, 'Y' as status,poHdr.FACILITY_CODE"
				+ " from t_po_hdr poHdr inner join T_EXTERNAL_FACILITIES extFac on extFac.facility_Code=poHdr.facility_Code"
				+ " where poHdr.lpo_Date is not null and extFac.SERVER_IP IS NOT NULL";
		if (null != dateFrom)
			sql += " and poHdr.lpo_Date >= TO_DATE('" + dateFrom + "','yyyy-mm-dd HH24:MI:SS')";
		if (null != dateTo)
			sql += " and poHdr.lpo_Date <= TO_DATE('" + dateTo + "','yyyy-mm-dd HH24:MI:SS')";
		if (ptjCode != null)
			sql += " and poHdr.PTJ_CODE = '" + ptjCode + "'";
		sql += " group by poHdr.lpo_Date,poHdr.created_Date,poHdr.FACILITY_CODE,extFac.facility_Name order by poHdr.created_Date desc";
		List<IntegrationBean> itemLogs = new ArrayList<IntegrationBean>();
		Session session = null;
		try {
			session = poHdrDAO.getSessionFactory().openSession();
			Query que = session.createSQLQuery(sql);
			List<Object[]> list = que.list();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			for (int i = 0; i < list.size(); i++) {
				Object[] objs = list.get(i);
				IntegrationBean log = new IntegrationBean();
				log.setNoOfTransactions(new BigDecimal(Long.parseLong(objs[0 + 1].toString())));
				log.setIntegrationDate(dateFormat.parse(objs[1 + 1].toString()));
				if (null != objs[2 + 1]) {
					log.setStatus(objs[2 + 1].toString());
				} else {
					log.setStatus("N");
				}
				log.setIntegrationType("LPO Approval");
				log.setIntType(ApplicationConstants.LPO_APPROVAL);
				/*
				 * String sqlFacility =
				 * "select facilityName from ExternalFacility " +
				 * " where facilityCode = '"+objs[3].toString()+"'" ; Query
				 * query = session.createQuery(sqlFacility); List<String> list1
				 * = query.list(); for (int j = 0; j < list1.size(); j++) {
				 * //Object[] objs1 = list1.get(j);
				 * log.setFacilityName(list1.get(j).toString());
				 * log.setFacilityCode(objs[3].toString()); }
				 */
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

	@Override
	public List<IntegrationBean> findByCriteria(String dateFrom, String dateTo, String ptjCode) {
		/*
		 * String sql =
		 * "select count(createdDate) as noOfTransactions, trunc(poVerficationDate) as "
		 * +
		 * " integrationDate, 'Y' as status, facilityCode from PoHdr where poVerficationDate is not null "
		 * ; if (null != dateFrom) sql += " and poVerficationDate >= TO_DATE('"
		 * + dateFrom+"','yyyy-mm-dd HH24:MI:SS')"; if (null != dateTo) sql +=
		 * " and poVerficationDate <= TO_DATE('" +
		 * dateTo+"','yyyy-mm-dd HH24:MI:SS')"; if(ptjCode != null) sql +=
		 * " and ptjCode = '" + ptjCode+"'"; sql +=
		 * " group by trunc(poVerficationDate), facilityCode  " +
		 * " order by trunc(poVerficationDate) desc";
		 */
		String sql = "select extFac.facility_Name,count(poHdr.created_Date) as noOfTransactions,trunc(poHdr.PO_VERFICATION_DATE) as integrationDate,'Y' as status,"
				+ "poHdr.FACILITY_CODE from t_po_hdr poHdr inner join T_EXTERNAL_FACILITIES extFac on extFac.facility_Code=poHdr.facility_Code"
				+ " where poHdr.PO_VERFICATION_DATE is not null and extFac.SERVER_IP IS NOT NULL";
		if (null != dateFrom)
			sql += " and poHdr.PO_VERFICATION_DATE >= TO_DATE('" + dateFrom + "','yyyy-mm-dd HH24:MI:SS')";
		if (null != dateTo)
			sql += " and poHdr.PO_VERFICATION_DATE <= TO_DATE('" + dateTo + "','yyyy-mm-dd HH24:MI:SS')";
		if (ptjCode != null)
			sql += " and poHdr.ptj_Code = '" + ptjCode + "'";
		sql += " group by poHdr.PO_VERFICATION_DATE,poHdr.created_Date,poHdr.FACILITY_CODE,extFac.facility_Name order by poHdr.created_Date desc";
		List<IntegrationBean> itemLogs = new ArrayList<IntegrationBean>();
		Session session = null;
		try {
			session = poHdrDAO.getSessionFactory().openSession();
			Query que = session.createSQLQuery(sql);
			List<Object[]> list = que.list();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			for (int i = 0; i < list.size(); i++) {
				Object[] objs = list.get(i);
				IntegrationBean log = new IntegrationBean();
				log.setNoOfTransactions(new BigDecimal(Long.parseLong(objs[0 + 1].toString())));
				log.setIntegrationDate(dateFormat.parse(objs[1 + 1].toString()));
				if (null != objs[2 + 1]) {
					log.setStatus(objs[2 + 1].toString());
				} else {
					log.setStatus("N");
				}
				log.setIntegrationType("PO Verification");
				log.setIntType(ApplicationConstants.PO_VERIFICATION);
				/*
				 * log.setFacilityCode(objs[3].toString()); String sqlFacility =
				 * "select facilityName from ExternalFacility " +
				 * " where facilityCode = '"+objs[3].toString()+"'" ; Query
				 * query = session.createQuery(sqlFacility); List<String> list1
				 * = query.list(); for (int j = 0; j < list1.size(); j++) {
				 * //Object[] objs1 = list1.get(j);
				 * log.setFacilityName(list1.get(j).toString()); }
				 */
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

	@Override
	public List<PoHdr> findByLpoApprovedDate(Date integrationDate, String facilityCode) {
		DetachedCriteria criteria = DetachedCriteria.forClass(PoHdr.class);
		java.sql.Date dt = new java.sql.Date(integrationDate.getTime());
		criteria.add(Restrictions.eq("facilityCode", facilityCode));
		criteria.add(Restrictions.sqlRestriction("trunc(lpo_date)=to_date('" + dt + "','yyyy-mm-dd')"));
		return getPoHdrDAO().findByCriteria(criteria);
	}

	@Override
	public List<PoHdr> findOrderByPOStatus(Date integrationDate, String status) {
		DetachedCriteria criteria = DetachedCriteria.forClass(PoHdr.class);
		criteria.add(Restrictions.eq("poVerficationDate", integrationDate));
		criteria.add(Restrictions.eq("poVerficationFlag", status));
		return getPoHdrDAO().findByCriteria(criteria);
	}

	@Override
	public Integer getLPOApprovalLogCount(String dateFrom, String dateTo) {
		String query = "SELECT count(CREATED_DATE) as count " + "	FROM T_PO_HDR WHERE LPO_DATE IS NOT NULL ";
		if (null != dateFrom)
			query += " and trunc(CREATED_DATE) >= trunc(TO_DATE('" + dateFrom + "','YYYY-MM-DD HH24:MI:SS'))";
		if (null != dateTo)
			query += " and trunc(CREATED_DATE) <= trunc(TO_DATE('" + dateTo + "','YYYY-MM-DD HH24:MI:SS'))";

		Session session = null;
		try {
			session = getPoHdrDAO().getSessionFactory().openSession();
			Query que = session.createSQLQuery(query);
			List<Object> list = que.list();
			if (list != null) {
				Object obj = list.get(0);
				if (obj != null)
					((BigDecimal) obj).intValue();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return 0;
	}

	@Override
	public Map<String, Integer> getEPOInOutLogCount(String dateFrom, String dateTo) {
		Map<String, Integer> returnMap = null;
		StringBuffer queryStr = new StringBuffer();

		queryStr.append(" SELECT ");
		queryStr.append(" SUM(TT.APPL_EPO_IN)AS APPL_EPO_IN, ");
		queryStr.append(" SUM(TT.LP_EPO_IN)AS LP_EPO_IN, ");
		queryStr.append(" SUM(TT.CONTRACT_EPO_IN)AS CONTRACT_EPO_IN,");
		queryStr.append(" SUM(TT.APPL_EPO_OUT)AS APPL_EPO_OUT, ");
		queryStr.append(" SUM(TT.LP_EPO_OUT)AS LP_EPO_OUT, ");
		queryStr.append(" SUM(TT.CONTRACT_EPO_OUT)AS CONTRACT_EPO_OUT ");
		queryStr.append(" FROM ");
		queryStr.append(" ( ");
		queryStr.append("	SELECT ");
		queryStr.append(
				"	CASE WHEN PURCHASE_ORDER_TYPE = 'APPL' THEN COUNT(PO_HDR_SEQNO) ELSE 0 END AS APPL_EPO_IN, ");
		queryStr.append("	CASE WHEN PURCHASE_ORDER_TYPE = 'LP' THEN COUNT(PO_HDR_SEQNO) ELSE 0 END AS LP_EPO_IN, ");
		queryStr.append(
				"	CASE WHEN PURCHASE_ORDER_TYPE = 'Contract' THEN COUNT(PO_HDR_SEQNO) ELSE 0 END AS CONTRACT_EPO_IN, ");
		queryStr.append("	0 AS APPL_EPO_OUT, ");
		queryStr.append("	0 AS LP_EPO_OUT, ");
		queryStr.append("	0 AS CONTRACT_EPO_OUT ");
		queryStr.append("	FROM T_PO_HDR ");
		queryStr.append("	WHERE 1 = 1 ");
		queryStr.append("	AND CREATED_DATE between to_date('" + dateFrom + "','YYYY-MM-DD') and  to_date('" + dateTo +"','YYYY-MM-DD')");
		/*if (dateFrom != null)
			queryStr.append("	AND TO_DATE(TRUNC(CREATED_DATE),'DD/MM/RRRR')>= TO_DATE(TRUNC(TO_DATE('" + dateFrom
					+ "','YYYY-MM-DD HH24:MI:SS')),'DD/MM/RRRR') ");
		else
			queryStr.append(
					"	AND TO_DATE(TRUNC(CREATED_DATE),'DD/MM/RRRR')>= TO_DATE(TRUNC(TO_DATE(SYSDATE,'YYYY-MM-DD HH24:MI:SS')),'DD/MM/RRRR') ");
		if (dateTo != null)
			queryStr.append("	AND TO_DATE(TRUNC(CREATED_DATE),'DD/MM/RRRR')<= TO_DATE(TRUNC(TO_DATE('" + dateTo
					+ "','YYYY-MM-DD HH24:MI:SS')),'DD/MM/RRRR') ");
		else
			queryStr.append(
					"	AND TO_DATE(TRUNC(CREATED_DATE),'DD/MM/RRRR')<= TO_DATE(TRUNC(TO_DATE(SYSDATE,'YYYY-MM-DD HH24:MI:SS')),'DD/MM/RRRR') ");*/
		queryStr.append("	GROUP BY PURCHASE_ORDER_TYPE ");

		queryStr.append("	UNION ALL ");

		queryStr.append(" 	SELECT  ");
		queryStr.append("	0 AS APPL_EPO_IN, ");
		queryStr.append("	0 AS LP_EPO_IN, ");
		queryStr.append("	0 AS CONTRACT_EPO_IN, ");
		queryStr.append(
				"	CASE WHEN PURCHASE_ORDER_TYPE = 'APPL' THEN COUNT(PO_HDR_SEQNO) ELSE 0 END AS APPL_EPO_OUT, ");
		queryStr.append("	0 AS LP_EPO_OUT, ");
		queryStr.append("	0 AS CONTRACT_EPO_OUT ");
		queryStr.append("	FROM T_PO_HDR ");
		queryStr.append("	WHERE EPO_SEND_TO_EP = 'Y' ");
		queryStr.append("	AND CREATED_DATE between to_date('" + dateFrom + "','YYYY-MM-DD') and  to_date('" + dateTo +"','YYYY-MM-DD')");
		/*if (dateFrom != null)
			queryStr.append("	AND TO_DATE(TRUNC(CREATED_DATE),'DD/MM/RRRR')>= TO_DATE(TRUNC(TO_DATE('" + dateFrom
					+ "','YYYY-MM-DD HH24:MI:SS')),'DD/MM/RRRR') ");
		if (dateTo != null)
			queryStr.append("	AND TO_DATE(TRUNC(CREATED_DATE),'DD/MM/RRRR')<= TO_DATE(TRUNC(TO_DATE('" + dateTo
					+ "','YYYY-MM-DD HH24:MI:SS')),'DD/MM/RRRR') ");*/
		queryStr.append("	GROUP BY PURCHASE_ORDER_TYPE ");
		queryStr.append(" )TT ");

		Session session = null;
		try {
			session = getPoHdrDAO().getSessionFactory().openSession();
			Query que = session.createSQLQuery(queryStr.toString());
			List<Object> list = que.list();
			returnMap = new HashMap<String, Integer>();
			if (list != null && list.size() > 0) {
				Object[] objArr = (Object[]) list.get(0);
				if (objArr != null) {
					returnMap.put(ApplicationConstants.ORD_INT_PHASE_APPL_EPO_IN,
							objArr[0] != null ? Integer.valueOf(objArr[0].toString()) : 0);
					returnMap.put(ApplicationConstants.ORD_INT_PHASE_LP_EPO_IN,
							objArr[1] != null ? Integer.valueOf(objArr[1].toString()) : 0);
					returnMap.put(ApplicationConstants.ORD_INT_PHASE_CONTRACT_EPO_IN,
							objArr[2] != null ? Integer.valueOf(objArr[2].toString()) : 0);
					returnMap.put(ApplicationConstants.ORD_INT_PHASE_APPL_EPO_OUT,
							objArr[3] != null ? Integer.valueOf(objArr[3].toString()) : 0);
					returnMap.put(ApplicationConstants.ORD_INT_PHASE_LP_EPO_OUT,
							objArr[4] != null ? Integer.valueOf(objArr[4].toString()) : 0);
					returnMap.put(ApplicationConstants.ORD_INT_PHASE_CONTRACT_EPO_OUT,
							objArr[5] != null ? Integer.valueOf(objArr[5].toString()) : 0);
				} else {
					returnMap.put(ApplicationConstants.ORD_INT_PHASE_APPL_EPO_IN, 0);
					returnMap.put(ApplicationConstants.ORD_INT_PHASE_LP_EPO_IN, 0);
					returnMap.put(ApplicationConstants.ORD_INT_PHASE_CONTRACT_EPO_IN, 0);
					returnMap.put(ApplicationConstants.ORD_INT_PHASE_APPL_EPO_OUT, 0);
					returnMap.put(ApplicationConstants.ORD_INT_PHASE_LP_EPO_OUT, 0);
					returnMap.put(ApplicationConstants.ORD_INT_PHASE_CONTRACT_EPO_OUT, 0);
				}
			} else {
				returnMap.put(ApplicationConstants.ORD_INT_PHASE_APPL_EPO_IN, 0);
				returnMap.put(ApplicationConstants.ORD_INT_PHASE_LP_EPO_IN, 0);
				returnMap.put(ApplicationConstants.ORD_INT_PHASE_CONTRACT_EPO_IN, 0);
				returnMap.put(ApplicationConstants.ORD_INT_PHASE_APPL_EPO_OUT, 0);
				returnMap.put(ApplicationConstants.ORD_INT_PHASE_LP_EPO_OUT, 0);
				returnMap.put(ApplicationConstants.ORD_INT_PHASE_CONTRACT_EPO_OUT, 0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return returnMap;
	}

	@Override
	public Map<String, Integer> getLPOInOutLogCount(String dateFrom, String dateTo) {
		Map<String, Integer> returnMap = null;
		StringBuffer queryStr = new StringBuffer();

		queryStr.append(" SELECT ");
		queryStr.append(" SUM(TT.APPL_LPO_IN)AS APPL_LPO_IN, ");
		queryStr.append(" SUM(TT.LP_LPO_IN)AS LP_LPO_IN, ");
		queryStr.append(" SUM(TT.CONTRACT_LPO_IN)AS CONTRACT_LPO_IN,");
		queryStr.append(" SUM(TT.APPL_LPO_OUT)AS APPL_LPO_OUT, ");
		queryStr.append(" SUM(TT.LP_LPO_OUT)AS LP_LPO_OUT, ");
		queryStr.append(" SUM(TT.CONTRACT_LPO_OUT)AS CONTRACT_LPO_OUT ");
		queryStr.append(" FROM ");
		queryStr.append(" ( ");
		queryStr.append("	SELECT ");
		queryStr.append(
				"	CASE WHEN PURCHASE_ORDER_TYPE = 'APPL' THEN COUNT(PO_HDR_SEQNO) ELSE 0 END AS APPL_LPO_IN, ");
		queryStr.append("	0 AS LP_LPO_IN, ");
		queryStr.append("	0 AS CONTRACT_LPO_IN, ");
		queryStr.append("	0 AS APPL_LPO_OUT, ");
		queryStr.append("	0 AS LP_LPO_OUT, ");
		queryStr.append("	0 AS CONTRACT_LPO_OUT ");
		queryStr.append("	FROM T_PO_HDR ");
		queryStr.append("	WHERE LPO_NO IS NOT NULL ");
		queryStr.append("	AND LPO_DATE between to_date('" + dateFrom + "','YYYY-MM-DD') and  to_date('" + dateTo +"','YYYY-MM-DD')");
		/*if (dateFrom != null)
			queryStr.append("	AND TO_DATE(TRUNC(LPO_DATE),'DD/MM/RRRR')>= TO_DATE(TRUNC(TO_DATE('" + dateFrom
					+ "','YYYY-MM-DD HH24:MI:SS')),'DD/MM/RRRR') ");
		if (dateTo != null)
			queryStr.append("	AND TO_DATE(TRUNC(LPO_DATE),'DD/MM/RRRR')<= TO_DATE(TRUNC(TO_DATE('" + dateTo
					+ "','YYYY-MM-DD HH24:MI:SS')),'DD/MM/RRRR') ");*/
		queryStr.append("	GROUP BY PURCHASE_ORDER_TYPE ");

		queryStr.append("	UNION ALL ");

		queryStr.append(" 	SELECT  ");
		queryStr.append("	0 AS APPL_LPO_IN, ");
		queryStr.append("	0 AS LP_LPO_IN, ");
		queryStr.append("	0 AS CONTRACT_LPO_IN, ");
		queryStr.append(
				"	CASE WHEN PURCHASE_ORDER_TYPE = 'APPL' THEN COUNT(PO_HDR_SEQNO) ELSE 0 END AS APPL_LPO_OUT, ");
		queryStr.append("	0 AS LP_LPO_OUT, ");
		queryStr.append(
				"	CASE WHEN PURCHASE_ORDER_TYPE = 'Contract' THEN COUNT(PO_HDR_SEQNO) ELSE 0 END AS CONTRACT_LPO_OUT ");
		queryStr.append("	FROM T_PO_HDR ");
		queryStr.append("	WHERE SEND_TO_PIERS_DATE_TIME IS NOT NULL ");
		queryStr.append("	AND LPO_DATE between to_date('" + dateFrom + "','YYYY-MM-DD') and  to_date('" + dateTo +"','YYYY-MM-DD')");
		/*if (dateFrom != null)
			queryStr.append("	AND TO_DATE(TRUNC(LPO_DATE),'DD/MM/RRRR')>= TO_DATE(TRUNC(TO_DATE('" + dateFrom
					+ "','YYYY-MM-DD HH24:MI:SS')),'DD/MM/RRRR') ");
		if (dateTo != null)
			queryStr.append("	AND TO_DATE(TRUNC(LPO_DATE),'DD/MM/RRRR')<= TO_DATE(TRUNC(TO_DATE('" + dateTo
					+ "','YYYY-MM-DD HH24:MI:SS')),'DD/MM/RRRR') ");*/
		queryStr.append("	GROUP BY PURCHASE_ORDER_TYPE ");
		queryStr.append(" )TT ");

		Session session = null;
		try {
			session = getPoHdrDAO().getSessionFactory().openSession();
			Query que = session.createSQLQuery(queryStr.toString());
			List<Object> list = que.list();
			returnMap = new HashMap<String, Integer>();
			if (list != null && list.size() > 0) {
				Object[] objArr = (Object[]) list.get(0);
				if (objArr != null) {
					returnMap.put(ApplicationConstants.ORD_INT_PHASE_APPL_LPO_IN,
							objArr[0] != null ? Integer.valueOf(objArr[0].toString()) : 0);
					returnMap.put(ApplicationConstants.ORD_INT_PHASE_LP_LPO_IN,
							objArr[1] != null ? Integer.valueOf(objArr[1].toString()) : 0);
					returnMap.put(ApplicationConstants.ORD_INT_PHASE_CONTRACT_LPO_IN,
							objArr[2] != null ? Integer.valueOf(objArr[2].toString()) : 0);
					returnMap.put(ApplicationConstants.ORD_INT_PHASE_APPL_LPO_OUT,
							objArr[3] != null ? Integer.valueOf(objArr[3].toString()) : 0);
					returnMap.put(ApplicationConstants.ORD_INT_PHASE_LP_LPO_OUT,
							objArr[4] != null ? Integer.valueOf(objArr[4].toString()) : 0);
					returnMap.put(ApplicationConstants.ORD_INT_PHASE_CONTRACT_LPO_OUT,
							objArr[5] != null ? Integer.valueOf(objArr[5].toString()) : 0);
				} else {
					returnMap.put(ApplicationConstants.ORD_INT_PHASE_APPL_LPO_IN, 0);
					returnMap.put(ApplicationConstants.ORD_INT_PHASE_LP_LPO_IN, 0);
					returnMap.put(ApplicationConstants.ORD_INT_PHASE_CONTRACT_LPO_IN, 0);
					returnMap.put(ApplicationConstants.ORD_INT_PHASE_APPL_LPO_OUT, 0);
					returnMap.put(ApplicationConstants.ORD_INT_PHASE_LP_LPO_OUT, 0);
					returnMap.put(ApplicationConstants.ORD_INT_PHASE_CONTRACT_LPO_OUT, 0);
				}
			} else {
				returnMap.put(ApplicationConstants.ORD_INT_PHASE_APPL_LPO_IN, 0);
				returnMap.put(ApplicationConstants.ORD_INT_PHASE_LP_LPO_IN, 0);
				returnMap.put(ApplicationConstants.ORD_INT_PHASE_CONTRACT_LPO_IN, 0);
				returnMap.put(ApplicationConstants.ORD_INT_PHASE_APPL_LPO_OUT, 0);
				returnMap.put(ApplicationConstants.ORD_INT_PHASE_LP_LPO_OUT, 0);
				returnMap.put(ApplicationConstants.ORD_INT_PHASE_CONTRACT_LPO_OUT, 0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return returnMap;
	}

	@Override
	public Map<String, Integer> getFullFillInOutCount(String dateFrom, String dateTo) {
		Map<String, Integer> returnMap = null;
		StringBuffer queryStr = new StringBuffer();

		queryStr.append(" SELECT ");
		queryStr.append(" SUM(TT.APPL_FULFIL_IN)AS APPL_FULFIL_IN, ");
		queryStr.append(" SUM(TT.APPL_FULFIL_OUT)AS APPL_FULFIL_OUT ");
		queryStr.append(" FROM ");
		queryStr.append(" ( ");
		queryStr.append("	SELECT ");
		queryStr.append("	COUNT(po_hdr.PO_HDR_SEQNO) AS APPL_FULFIL_IN, ");
		queryStr.append("	0 AS APPL_FULFIL_OUT ");
		queryStr.append("	FROM T_PO_HDR po_hdr ");
		queryStr.append("	JOIN T_FULFILMNT_LOG log ON log.PO_HDR_SEQNO = po_hdr.PO_HDR_SEQNO ");
		queryStr.append("	WHERE po_hdr.RCVD_FLFILMNT_FRM_EP = 'Y'  ");
		queryStr.append("	AND po_hdr.PURCHASE_ORDER_TYPE = 'APPL'  ");
		/*if (dateFrom != null)
			queryStr.append("	AND TO_DATE(TRUNC(log.CREATE_DATE),'DD/MM/RRRR')>= TO_DATE(TRUNC(TO_DATE('" + dateFrom
					+ "','YYYY-MM-DD HH24:MI:SS')),'DD/MM/RRRR') ");
		if (dateTo != null)
			queryStr.append("	AND TO_DATE(TRUNC(log.CREATE_DATE),'DD/MM/RRRR')<= TO_DATE(TRUNC(TO_DATE('" + dateTo
					+ "','YYYY-MM-DD HH24:MI:SS')),'DD/MM/RRRR') ");*/
		queryStr.append("	AND log.CREATE_DATE between to_date('" + dateFrom + "','YYYY-MM-DD') and  to_date('" + dateTo +"','YYYY-MM-DD')");
		queryStr.append("	GROUP BY po_hdr.PURCHASE_ORDER_TYPE ");

		queryStr.append("	UNION ALL ");

		queryStr.append(" 	SELECT  ");
		queryStr.append("	0 AS APPL_FULFIL_IN, ");
		queryStr.append("	COUNT(po_hdr.PO_HDR_SEQNO) AS APPL_FULFIL_OUT ");
		queryStr.append("	FROM T_PO_HDR po_hdr ");
		queryStr.append("	JOIN T_FULFILMNT_LOG log ON log.PO_HDR_SEQNO = po_hdr.PO_HDR_SEQNO ");
		queryStr.append("	WHERE po_hdr.FULFLMNT_SYNC_FLAG = 'Y' ");
		queryStr.append("	AND po_hdr.PURCHASE_ORDER_TYPE = 'APPL'  ");
		queryStr.append("	AND log.CREATE_DATE between to_date('" + dateFrom + "','YYYY-MM-DD') and  to_date('" + dateTo +"','YYYY-MM-DD')");
		
		/*if (dateFrom != null)
			queryStr.append("	AND TO_DATE(TRUNC(log.CREATE_DATE),'DD/MM/RRRR')>= TO_DATE(TRUNC(TO_DATE('" + dateFrom
					+ "','YYYY-MM-DD HH24:MI:SS')),'DD/MM/RRRR') ");
		if (dateTo != null)
			queryStr.append("	AND TO_DATE(TRUNC(log.CREATE_DATE),'DD/MM/RRRR')<= TO_DATE(TRUNC(TO_DATE('" + dateTo
					+ "','YYYY-MM-DD HH24:MI:SS')),'DD/MM/RRRR') ");*/
		queryStr.append("	GROUP BY po_hdr.PURCHASE_ORDER_TYPE ");
		queryStr.append(" )TT ");

		Session session = null;
		try {
			session = getPoHdrDAO().getSessionFactory().openSession();
			Query que = session.createSQLQuery(queryStr.toString());
			List<Object> list = que.list();
			returnMap = new HashMap<String, Integer>();
			if (list != null && list.size() > 0) {
				Object[] objArr = (Object[]) list.get(0);
				if (objArr != null) {
					returnMap.put(ApplicationConstants.ORD_INT_PHASE_APPL_FULFIL_IN,
							objArr[0] != null ? Integer.valueOf(objArr[0].toString()) : 0);
					returnMap.put(ApplicationConstants.ORD_INT_PHASE_APPL_FULFIL_OUT,
							objArr[1] != null ? Integer.valueOf(objArr[1].toString()) : 0);
				} else {
					returnMap.put(ApplicationConstants.ORD_INT_PHASE_APPL_FULFIL_IN, 0);
					returnMap.put(ApplicationConstants.ORD_INT_PHASE_APPL_FULFIL_OUT, 0);
				}
				returnMap.put(ApplicationConstants.ORD_INT_PHASE_LP_FULFIL_IN, 0);
				returnMap.put(ApplicationConstants.ORD_INT_PHASE_CONTRACT_FULFIL_IN, 0);
				returnMap.put(ApplicationConstants.ORD_INT_PHASE_LP_FULFIL_OUT, 0);
				returnMap.put(ApplicationConstants.ORD_INT_PHASE_CONTRACT_FULFIL_OUT, 0);
			} else {
				returnMap.put(ApplicationConstants.ORD_INT_PHASE_APPL_FULFIL_IN, 0);
				returnMap.put(ApplicationConstants.ORD_INT_PHASE_APPL_FULFIL_OUT, 0);
				returnMap.put(ApplicationConstants.ORD_INT_PHASE_LP_FULFIL_IN, 0);
				returnMap.put(ApplicationConstants.ORD_INT_PHASE_CONTRACT_FULFIL_IN, 0);
				returnMap.put(ApplicationConstants.ORD_INT_PHASE_LP_FULFIL_OUT, 0);
				returnMap.put(ApplicationConstants.ORD_INT_PHASE_CONTRACT_FULFIL_OUT, 0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return returnMap;
	}

	@Override
	public Map<String, Integer> getInvoiceInOutCount(String dateFrom, String dateTo) {
		Map<String, Integer> returnMap = null;
		StringBuffer queryStr = new StringBuffer();

		queryStr.append(" SELECT ");
		queryStr.append(" SUM(TT.APPL_INVO_IN)AS APPL_INVO_IN, ");
		queryStr.append(" SUM(TT.APPL_INVO_OUT)AS APPL_INVO_OUT ");
		queryStr.append(" FROM ");
		queryStr.append(" ( ");
		queryStr.append("	SELECT ");
		queryStr.append("	COUNT(po_hdr.PO_HDR_SEQNO) AS APPL_INVO_IN, ");
		queryStr.append("	0 AS APPL_INVO_OUT ");
		queryStr.append("	FROM T_PO_HDR po_hdr ");
		queryStr.append("	JOIN T_INVOICE_LOG log ON log.PO_HDR_SEQNO = po_hdr.PO_HDR_SEQNO ");
		queryStr.append("	WHERE 1=1 ");
		queryStr.append("	AND po_hdr.PURCHASE_ORDER_TYPE = 'APPL'  ");
		queryStr.append("	AND log.CREATE_DATE between to_date('" + dateFrom + "','YYYY-MM-DD') and  to_date('" + dateTo +"','YYYY-MM-DD')");
		/*if (dateFrom != null)
			queryStr.append("	AND TO_DATE(TRUNC(log.CREATE_DATE),'DD/MM/RRRR')>= TO_DATE(TRUNC(TO_DATE('" + dateFrom
					+ "','YYYY-MM-DD HH24:MI:SS')),'DD/MM/RRRR') ");
		if (dateTo != null)
			queryStr.append("	AND TO_DATE(TRUNC(log.CREATE_DATE),'DD/MM/RRRR')<= TO_DATE(TRUNC(TO_DATE('" + dateTo
					+ "','YYYY-MM-DD HH24:MI:SS')),'DD/MM/RRRR') ");*/
		queryStr.append("	GROUP BY po_hdr.PURCHASE_ORDER_TYPE ");

		queryStr.append("	UNION ALL ");

		queryStr.append(" 	SELECT  ");
		queryStr.append("	0 AS APPL_INVO_IN, ");
		queryStr.append("	COUNT(po_hdr.PO_HDR_SEQNO) AS APPL_INVO_OUT ");
		queryStr.append("	FROM T_PO_HDR po_hdr ");
		queryStr.append("	JOIN T_INVOICE_LOG log ON log.PO_HDR_SEQNO = po_hdr.PO_HDR_SEQNO ");
		queryStr.append("	WHERE po_hdr.INVOICE_SEND_TO_EP = 'Y' ");
		queryStr.append("	AND po_hdr.PURCHASE_ORDER_TYPE = 'APPL'  ");
//		if (dateFrom != null)
		queryStr.append("	AND log.CREATE_DATE between to_date('" + dateFrom + "','YYYY-MM-DD') and  to_date('" + dateTo +"','YYYY-MM-DD')");
		/*if (dateTo != null)
			queryStr.append("	AND log.CREATE_DATE),'DD/MM/RRRR')<= TO_DATE(TRUNC(TO_DATE('" + dateTo + "','YYYY-MM-DD HH24:MI:SS')),'DD/MM/RRRR') ");*/
		queryStr.append("	GROUP BY po_hdr.PURCHASE_ORDER_TYPE ");
		queryStr.append(" )TT ");

		Session session = null;
		try {
			session = getPoHdrDAO().getSessionFactory().openSession();
			Query que = session.createSQLQuery(queryStr.toString());
			List<Object> list = que.list();
			returnMap = new HashMap<String, Integer>();
			if (list != null && list.size() > 0) {
				Object[] objArr = (Object[]) list.get(0);
				if (objArr != null) {
					returnMap.put(ApplicationConstants.ORD_INT_PHASE_APPL_INVO_IN,
							objArr[0] != null ? Integer.valueOf(objArr[0].toString()) : 0);
					returnMap.put(ApplicationConstants.ORD_INT_PHASE_APPL_INVO_OUT,
							objArr[1] != null ? Integer.valueOf(objArr[1].toString()) : 0);
				} else {
					returnMap.put(ApplicationConstants.ORD_INT_PHASE_APPL_INVO_IN, 0);
					returnMap.put(ApplicationConstants.ORD_INT_PHASE_APPL_INVO_OUT, 0);
				}
				returnMap.put(ApplicationConstants.ORD_INT_PHASE_LP_INVO_IN, 0);
				returnMap.put(ApplicationConstants.ORD_INT_PHASE_CONTRACT_INVO_IN, 0);
				returnMap.put(ApplicationConstants.ORD_INT_PHASE_LP_INVO_OUT, 0);
				returnMap.put(ApplicationConstants.ORD_INT_PHASE_CONTRACT_INVO_OUT, 0);
			} else {
				returnMap.put(ApplicationConstants.ORD_INT_PHASE_APPL_INVO_IN, 0);
				returnMap.put(ApplicationConstants.ORD_INT_PHASE_APPL_INVO_OUT, 0);
				returnMap.put(ApplicationConstants.ORD_INT_PHASE_LP_INVO_IN, 0);
				returnMap.put(ApplicationConstants.ORD_INT_PHASE_CONTRACT_INVO_IN, 0);
				returnMap.put(ApplicationConstants.ORD_INT_PHASE_LP_INVO_OUT, 0);
				returnMap.put(ApplicationConstants.ORD_INT_PHASE_CONTRACT_INVO_OUT, 0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return returnMap;
	}

	@Override
	public Map<String, Integer> getPayNotificCount(String dateFrom, String dateTo) {
		Map<String, Integer> returnMap = null;
		StringBuffer queryStr = new StringBuffer();

		queryStr.append(" SELECT ");
		queryStr.append(" SUM(TT.APPL_PAY_NOTIFC) AS APPL_PAY_NOTIFC ");
		queryStr.append(" FROM ");
		queryStr.append(" ( ");
		queryStr.append("	SELECT ");
		queryStr.append("	COUNT(po_hdr.PO_HDR_SEQNO) AS APPL_PAY_NOTIFC ");
		queryStr.append("	FROM T_PO_HDR po_hdr ");
		queryStr.append("	JOIN T_PMNT_NOTIFICATION_LOG log ON log.PO_HDR_SEQNO = po_hdr.PO_HDR_SEQNO ");
		queryStr.append("	WHERE PAYMENT_STATUS = 'Y' ");
		queryStr.append("	AND po_hdr.PURCHASE_ORDER_TYPE = 'APPL'  ");
		queryStr.append("	AND log.CREATE_DATE between to_date('" + dateFrom + "','YYYY-MM-DD') and  to_date('" + dateTo +"','YYYY-MM-DD')");
		/*if (dateFrom != null)
			queryStr.append("	AND TO_DATE(TRUNC(log.CREATE_DATE),'DD/MM/RRRR')>= TO_DATE(TRUNC(TO_DATE('" + dateFrom
					+ "','YYYY-MM-DD HH24:MI:SS')),'DD/MM/RRRR') ");
		if (dateTo != null)
			queryStr.append("	AND TO_DATE(TRUNC(log.CREATE_DATE),'DD/MM/RRRR')<= TO_DATE(TRUNC(TO_DATE('" + dateTo
					+ "','YYYY-MM-DD HH24:MI:SS')),'DD/MM/RRRR') ");*/
		queryStr.append("	GROUP BY po_hdr.PURCHASE_ORDER_TYPE ");
		queryStr.append(" )TT ");

		Session session = null;
		try {
			session = getPoHdrDAO().getSessionFactory().openSession();
			Query que = session.createSQLQuery(queryStr.toString());
			List<Object> list = que.list();
			returnMap = new HashMap<String, Integer>();
			if (list != null && list.size() > 0) {
				Object objArr = (Object) list.get(0);
				if (objArr != null) {
					returnMap.put(ApplicationConstants.ORD_INT_PHASE_APPL_PAY_NOTIFC,
							objArr != null ? Integer.valueOf(objArr.toString()) : 0);
				} else {
					returnMap.put(ApplicationConstants.ORD_INT_PHASE_APPL_PAY_NOTIFC, 0);
				}
				returnMap.put(ApplicationConstants.ORD_INT_PHASE_LP_PAY_NOTIFC, 0);
				returnMap.put(ApplicationConstants.ORD_INT_PHASE_CONTRACT_PAY_NOTIFC, 0);
			} else {
				returnMap.put(ApplicationConstants.ORD_INT_PHASE_APPL_PAY_NOTIFC, 0);
				returnMap.put(ApplicationConstants.ORD_INT_PHASE_LP_PAY_NOTIFC, 0);
				returnMap.put(ApplicationConstants.ORD_INT_PHASE_CONTRACT_PAY_NOTIFC, 0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return returnMap;
	}

	@Override
	public Map<String, Integer> getPendingForPKDApprovalCount(String dateFrom, String dateTo) {
		Map<String, Integer> returnMap = null;
		StringBuffer queryStr = new StringBuffer();

		queryStr.append(" SELECT ");
		queryStr.append(" SUM(TT.APPL_EPO_IN) AS APPL_EPO_IN, ");
		queryStr.append(" SUM(TT.LP_EPO_IN) AS LP_EPO_IN, ");
		queryStr.append(" SUM(TT.CONTRACT_EPO_IN) AS CONTRACT_EPO_IN ");
		queryStr.append(" FROM ");
		queryStr.append(" ( ");
		queryStr.append("	SELECT ");
		queryStr.append(
				"	CASE WHEN ph_hdr.PURCHASE_ORDER_TYPE = 'APPL' THEN COUNT(PO_HDR_SEQNO) ELSE 0 END AS APPL_EPO_IN, ");
		queryStr.append(
				"	CASE WHEN ph_hdr.PURCHASE_ORDER_TYPE = 'LP' THEN COUNT(PO_HDR_SEQNO) ELSE 0 END AS LP_EPO_IN, ");
		queryStr.append(
				"	CASE WHEN ph_hdr.PURCHASE_ORDER_TYPE = 'Contract' THEN COUNT(PO_HDR_SEQNO) ELSE 0 END AS CONTRACT_EPO_IN ");
		queryStr.append("	FROM T_PO_HDR ph_hdr");
		queryStr.append(
				"	JOIN T_EXTERNAL_FACILITIES ext_fac ON ext_fac.FACILITY_CODE = ph_hdr.FACILITY_CODE AND ext_fac.FACILITY_TYPE = 'KK' ");
		queryStr.append("	WHERE 1=1 ");
		queryStr.append("	AND ph_hdr.CREATED_DATE between to_date('" + dateFrom + "','YYYY-MM-DD') and  to_date('" + dateTo +"','YYYY-MM-DD')");
		/*if (dateFrom != null)
			queryStr.append("	AND TO_DATE(TRUNC(ph_hdr.CREATED_DATE),'DD/MM/RRRR')>= TO_DATE(TRUNC(TO_DATE('"
					+ dateFrom + "','YYYY-MM-DD HH24:MI:SS')),'DD/MM/RRRR') ");
		if (dateTo != null)
			queryStr.append("	AND TO_DATE(TRUNC(ph_hdr.CREATED_DATE),'DD/MM/RRRR')<= TO_DATE(TRUNC(TO_DATE('" + dateTo
					+ "','YYYY-MM-DD HH24:MI:SS')),'DD/MM/RRRR') ");*/
		queryStr.append("	AND ph_hdr.ORDER_STATUS = 'PAP' ");
		queryStr.append("	GROUP BY ph_hdr.PURCHASE_ORDER_TYPE ");
		queryStr.append(" )TT ");

		Session session = null;
		try {
			session = getPoHdrDAO().getSessionFactory().openSession();
			Query que = session.createSQLQuery(queryStr.toString());
			List<Object> list = que.list();
			returnMap = new HashMap<String, Integer>();
			if (list != null && list.size() > 0) {
				Object[] objArr = (Object[]) list.get(0);
				if (objArr != null) {
					returnMap.put(ApplicationConstants.ORD_INT_PHASE_APPL_EPO_IN,
							objArr[0] != null ? Integer.valueOf(objArr[0].toString()) : 0);
					returnMap.put(ApplicationConstants.ORD_INT_PHASE_LP_EPO_IN,
							objArr[1] != null ? Integer.valueOf(objArr[1].toString()) : 0);
					returnMap.put(ApplicationConstants.ORD_INT_PHASE_CONTRACT_EPO_IN,
							objArr[2] != null ? Integer.valueOf(objArr[2].toString()) : 0);
				} else {
					returnMap.put(ApplicationConstants.ORD_INT_PHASE_APPL_EPO_IN, 0);
					returnMap.put(ApplicationConstants.ORD_INT_PHASE_LP_EPO_IN, 0);
					returnMap.put(ApplicationConstants.ORD_INT_PHASE_CONTRACT_EPO_IN, 0);
				}
			} else {
				returnMap.put(ApplicationConstants.ORD_INT_PHASE_APPL_EPO_IN, 0);
				returnMap.put(ApplicationConstants.ORD_INT_PHASE_LP_EPO_IN, 0);
				returnMap.put(ApplicationConstants.ORD_INT_PHASE_CONTRACT_EPO_IN, 0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return returnMap;
	}

	@Override
	public Map<String, Integer> getPKDApprovedCount(String dateFrom, String dateTo) {
		Map<String, Integer> returnMap = null;
		StringBuffer queryStr = new StringBuffer();

		queryStr.append(" SELECT ");
		queryStr.append(" SUM(TT.APPL_EPO_OUT) AS APPL_EPO_OUT, ");
		queryStr.append(" SUM(TT.LP_EPO_OUT) AS LP_EPO_OUT, ");
		queryStr.append(" SUM(TT.CONTRACT_EPO_OUT) AS CONTRACT_EPO_OUT ");
		queryStr.append(" FROM ");
		queryStr.append(" ( ");
		queryStr.append("	SELECT ");
		queryStr.append(
				"	CASE WHEN ph_hdr.PURCHASE_ORDER_TYPE = 'APPL' THEN COUNT(PO_HDR_SEQNO) ELSE 0 END AS APPL_EPO_OUT, ");
		queryStr.append(
				"	CASE WHEN ph_hdr.PURCHASE_ORDER_TYPE = 'LP' THEN COUNT(PO_HDR_SEQNO) ELSE 0 END AS LP_EPO_OUT, ");
		queryStr.append(
				"	CASE WHEN ph_hdr.PURCHASE_ORDER_TYPE = 'Contract' THEN COUNT(PO_HDR_SEQNO) ELSE 0 END AS CONTRACT_EPO_OUT ");
		queryStr.append("	FROM T_PO_HDR ph_hdr");
		queryStr.append(
				"	JOIN T_EXTERNAL_FACILITIES ext_fac ON ext_fac.FACILITY_CODE = ph_hdr.FACILITY_CODE AND ext_fac.FACILITY_TYPE = 'KK' ");
		queryStr.append("	WHERE 1=1 ");
		queryStr.append("	AND ph_hdr.CREATED_DATE between to_date('" + dateFrom + "','YYYY-MM-DD') and  to_date('" + dateTo +"','YYYY-MM-DD')");
		
		/*if (dateFrom != null)
			queryStr.append("	AND TO_DATE(TRUNC(ph_hdr.CREATED_DATE),'DD/MM/RRRR')>= TO_DATE(TRUNC(TO_DATE('"
					+ dateFrom + "','YYYY-MM-DD HH24:MI:SS')),'DD/MM/RRRR') ");
		if (dateTo != null)
			queryStr.append("	AND TO_DATE(TRUNC(ph_hdr.CREATED_DATE),'DD/MM/RRRR')<= TO_DATE(TRUNC(TO_DATE('" + dateTo
					+ "','YYYY-MM-DD HH24:MI:SS')),'DD/MM/RRRR') ");*/
		queryStr.append("	AND ph_hdr.ORDER_STATUS NOT IN ('PKDR','PAP') ");
		queryStr.append("	GROUP BY ph_hdr.PURCHASE_ORDER_TYPE ");
		queryStr.append(" )TT ");

		Session session = null;
		try {
			session = getPoHdrDAO().getSessionFactory().openSession();
			Query que = session.createSQLQuery(queryStr.toString());
			List<Object> list = que.list();
			returnMap = new HashMap<String, Integer>();
			if (list != null && list.size() > 0) {
				Object[] objArr = (Object[]) list.get(0);
				if (objArr != null) {
					returnMap.put(ApplicationConstants.ORD_INT_PHASE_APPL_EPO_OUT,
							objArr[0] != null ? Integer.valueOf(objArr[0].toString()) : 0);
					returnMap.put(ApplicationConstants.ORD_INT_PHASE_LP_EPO_OUT,
							objArr[1] != null ? Integer.valueOf(objArr[1].toString()) : 0);
					returnMap.put(ApplicationConstants.ORD_INT_PHASE_CONTRACT_EPO_OUT,
							objArr[2] != null ? Integer.valueOf(objArr[2].toString()) : 0);
				} else {
					returnMap.put(ApplicationConstants.ORD_INT_PHASE_APPL_EPO_OUT, 0);
					returnMap.put(ApplicationConstants.ORD_INT_PHASE_LP_EPO_OUT, 0);
					returnMap.put(ApplicationConstants.ORD_INT_PHASE_CONTRACT_EPO_OUT, 0);
				}
			} else {
				returnMap.put(ApplicationConstants.ORD_INT_PHASE_APPL_EPO_OUT, 0);
				returnMap.put(ApplicationConstants.ORD_INT_PHASE_LP_EPO_OUT, 0);
				returnMap.put(ApplicationConstants.ORD_INT_PHASE_CONTRACT_EPO_OUT, 0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return returnMap;
	}

	@Override
	public String getShippingAddress(PoHdr poHdrHq) {
		String shippingAddress = "";
		DeliveredTo deliveredTosHq = poHdrHq.getDeliveredTo();
		if (deliveredTosHq != null) {

			String address1 = deliveredTosHq.getAddress1();
			String address2 = deliveredTosHq.getAddress2();
			String address3 = deliveredTosHq.getAddress3();
			if (address1 != null && address1.trim().length() > 0) {
				shippingAddress = address1;
			}
			System.out.println("shippingAddress1 --- >> " + shippingAddress);
			if (address2 != null && address2.trim().length() > 0) {
				shippingAddress = shippingAddress + "-" + address2;
			}
			System.out.println("shippingAddress2 --- >> " + shippingAddress);
			if (address3 != null && address3.trim().length() > 0) {
				shippingAddress = shippingAddress + "-" + address3;
			}
			System.out.println("shippingAddress3 --- >> " + shippingAddress);
		}

		return shippingAddress;
	}

	@Override
	public String getShipToCode(PoHdr poHdrHq) {
		String shipToCode = "";
		DeliveredTo deliveredTosHq = poHdrHq.getDeliveredTo();
		if (deliveredTosHq != null) {
			if (deliveredTosHq.getDelToCode() != null && deliveredTosHq.getDelToCode().trim().length() > 0) {
				shipToCode = deliveredTosHq.getDelToCode();
			}
		}
		return shipToCode;
	}

	@Override
	public Date getLPOTransmittedDate(Date lpoDate, String facilityCode, Integer deliveryLeadTime) throws Exception {
		Session session = getPoHdrDAO().getSessionFactory().openSession();
		Date date_ = null;
		try {
			Query query = session.createSQLQuery("SELECT getholidaycount(TO_DATE('"
					+ DateUtil.getFormattedDate(lpoDate, DateUtil.DATE_FORMAT_STR_3) + "','yyyy-mm-dd HH24:MI:SS'),'"
					+ facilityCode + "','" + deliveryLeadTime + "') FROM dual ");
			Object data = query.uniqueResult();
			Object obj = data;
			Integer holidayCount = Integer.parseInt(obj.toString());
			date_ = DateUtil.increaseDate(lpoDate, holidayCount);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}
		return date_;
	}

	@Override
	public void saveOrUpdatePoHdr(PoHdr PoHdr) {
		getPoHdrDAO().saveOrUpdate(PoHdr);
	}

	@Override
	public double getTotalOrderAmount(PoHdr poHdr) {
		double totalOrderAmt = 0.0000;
		if (poHdr.getLpoNo() != null) {
			for (PoDtl epoDtl : poHdr.getPoDtls()) {
				totalOrderAmt = totalOrderAmt + (epoDtl.getUnitPrice().doubleValue() * epoDtl.getEpApprovedQty());
			}
		} else {
			for (PoDtl epoDtl : poHdr.getPoDtls()) {
				totalOrderAmt = totalOrderAmt + (epoDtl.getUnitPrice().doubleValue() * epoDtl.getApprovedQty());
			}
		}
		return totalOrderAmt;
	}
	@Override
	public List<SummaryePintegrationBean> getSummaryePintegration(Date dateFrom, Date dateTo){
		
		StringBuffer sb = new StringBuffer();
		sb.append("select a.integration_date, sum(a.epo_facility), sum(a.epo_facility_amount), ");
		sb.append("sum(a.epo_send_ep), sum(a.epo_fail_ep), sum(a.epo_pending_ep), sum(a.epo_pending_ep_amount), ");
		sb.append("sum(a.ep_reject_internal), sum(a.ep_reject), sum(a.lpo_cancellation), ");
		sb.append("max(a.lpo_date_before), sum(a.lpo_before), sum(a.lpo_amount_before), ");
		sb.append("max(a.lpo_date_after), sum(a.lpo_after), sum(a.lpo_amount_after), ");
		sb.append("sum(a.lpo_send_newpiwp), sum(a.replacement_order) ");
		sb.append("from (");
		sb.append("select trunc(created_date) as integration_date, count(purchase_order_no) as epo_facility, sum(total_order_amount) as epo_facility_amount, ");
		sb.append("0 as epo_send_ep, 0 as epo_fail_ep, 0 as epo_pending_ep, 0 as epo_pending_ep_amount, ");
		sb.append("0 as ep_reject_internal, 0 as ep_reject, 0 as lpo_cancellation, ");
		sb.append("null as lpo_date_before, 0 as lpo_before, 0 as lpo_amount_before, ");
		sb.append("null as lpo_date_after, 0 as lpo_after, 0 as lpo_amount_after, ");
		sb.append("0 as lpo_send_newpiwp, 0 as replacement_order ");
		sb.append("from t_po_hdr where purchase_order_type = 'APPL' ");
		sb.append("and trunc(created_date) >= to_date('" + (new SimpleDateFormat("dd/MM/yyyy").format(dateFrom)) + "','dd/MM/yyyy') ");
		sb.append("and trunc(created_date) <= to_date('" + (new SimpleDateFormat("dd/MM/yyyy").format(dateTo)) + "','dd/MM/yyyy') ");
		sb.append("group by trunc(created_date) ");
		sb.append("union all ");
		sb.append("select trunc(epo_sentto_ep_date) as integration_date, 0 as epo_facility, 0 as epo_facility_amount, ");
		sb.append("count(purchase_order_no) as epo_send_ep, 0 as epo_fail_ep, 0 as epo_pending_ep, 0 as epo_pending_ep_amount, ");
		sb.append("0 as ep_reject_internal, 0 as ep_reject, 0 as lpo_cancellation, ");
		sb.append("null as lpo_date_before, 0 as lpo_before, 0 as lpo_amount_before, ");
		sb.append("null as lpo_date_after, 0 as lpo_after, 0 as lpo_amount_after, ");
		sb.append("0 as lpo_send_newpiwp, 0 as replacement_order ");
		sb.append("from t_po_hdr where purchase_order_type = 'APPL' and req_no is not null ");
		sb.append("and epo_send_to_ep = 'Y' ");
		sb.append("and trunc(epo_sentto_ep_date) >= to_date('" + (new SimpleDateFormat("dd/MM/yyyy").format(dateFrom)) + "','dd/MM/yyyy') ");
		sb.append("and trunc(epo_sentto_ep_date) <= to_date('" + (new SimpleDateFormat("dd/MM/yyyy").format(dateTo)) + "','dd/MM/yyyy') ");
		sb.append("group by trunc(epo_sentto_ep_date) ");
		sb.append("union all ");
		sb.append("select trunc(epo_sentto_ep_date) as integration_date, 0 as epo_facility, 0 as epo_facility_amount, ");
		sb.append("0 as epo_send_ep, count(purchase_order_no) as epo_fail_ep, 0 as epo_pending_ep, 0 as epo_pending_ep_amount, ");
		sb.append("0 as ep_reject_internal, 0 as ep_reject, 0 as lpo_cancellation, ");
		sb.append("null as lpo_date_before, 0 as lpo_before, 0 as lpo_amount_before, ");
		sb.append("null as lpo_date_after, 0 as lpo_after, 0 as lpo_amount_after, ");
		sb.append("0 as lpo_send_newpiwp, 0 as replacement_order ");
		sb.append("from t_po_hdr where purchase_order_type = 'APPL' and req_no is null ");
		sb.append("and epo_send_to_ep = 'N' and ep_reject_remarks is not null ");
		sb.append("and trunc(epo_sentto_ep_date) >= to_date('" + (new SimpleDateFormat("dd/MM/yyyy").format(dateFrom)) + "','dd/MM/yyyy') ");
		sb.append("and trunc(epo_sentto_ep_date) <= to_date('" + (new SimpleDateFormat("dd/MM/yyyy").format(dateTo)) + "','dd/MM/yyyy') ");
		sb.append("group by trunc(epo_sentto_ep_date) ");
		sb.append("union all ");
		sb.append("select trunc(epo_sentto_ep_date) as integration_date, 0 as epo_facility, 0 as epo_facility_amount, ");
		sb.append("0 as epo_send_ep, 0 as epo_fail_ep, count(purchase_order_no) as epo_pending_ep, sum(total_order_amount) as epo_pending_ep_amount, ");
		sb.append("0 as ep_reject_internal, 0 as ep_reject, 0 as lpo_cancellation, ");
		sb.append("null as lpo_date_before, 0 as lpo_before, 0 as lpo_amount_before, ");
		sb.append("null as lpo_date_after, 0 as lpo_after, 0 as lpo_amount_after, ");
		sb.append("0 as lpo_send_newpiwp, 0 as replacement_order ");
		sb.append("from t_po_hdr where order_status = 'SF_eP_APPROVAL' and purchase_order_type = 'APPL' ");
		sb.append("and req_no is not null and epo_send_to_ep = 'Y' ");
		sb.append("and trunc(epo_sentto_ep_date) >= to_date('" + (new SimpleDateFormat("dd/MM/yyyy").format(dateFrom)) + "','dd/MM/yyyy') ");
		sb.append("and trunc(epo_sentto_ep_date) <= to_date('" + (new SimpleDateFormat("dd/MM/yyyy").format(dateTo)) + "','dd/MM/yyyy') ");
		sb.append("group by trunc(epo_sentto_ep_date) ");
		sb.append("union all ");
		sb.append("select trunc(cancellation_date) as integration_date, 0 as epo_facility, 0 as epo_facility_amount, ");
		sb.append("0 as epo_send_ep, 0 as epo_fail_ep, 0 as epo_pending_ep, 0 as epo_pending_ep_amount, ");
		sb.append("count(purchase_order_no) as ep_reject_internal, 0 as ep_reject, 0 as lpo_cancellation, ");
		sb.append("null as lpo_date_before, 0 as lpo_before, 0 as lpo_amount_before, ");
		sb.append("null as lpo_date_after, 0 as lpo_after, 0 as lpo_amount_after, ");
		sb.append("0 as lpo_send_newpiwp, 0 as replacement_order ");
		sb.append("from t_po_hdr where purchase_order_type = 'APPL' ");
		sb.append("and order_status = 'eP_REJECTED' and cancellation_remarks is not null ");
		sb.append("and cancellation_remarks = 'ePO Failed to Sync to eP' ");
		sb.append("and trunc(cancellation_date) >= to_date('" + (new SimpleDateFormat("dd/MM/yyyy").format(dateFrom)) + "','dd/MM/yyyy') ");
		sb.append("and trunc(cancellation_date) <= to_date('" + (new SimpleDateFormat("dd/MM/yyyy").format(dateTo)) + "','dd/MM/yyyy') ");
		sb.append("group by trunc(cancellation_date) ");
		sb.append("union all ");
		sb.append("select trunc(cancellation_date) as integration_date, 0 as epo_facility, 0 as epo_facility_amount, ");
		sb.append("0 as epo_send_ep, 0 as epo_fail_ep, 0 as epo_pending_ep, 0 as epo_pending_ep_amount, ");
		sb.append("0 as ep_reject_internal, count(purchase_order_no) as ep_reject, 0 as lpo_cancellation, ");
		sb.append("null as lpo_date_before, 0 as lpo_before, 0 as lpo_amount_before, ");
		sb.append("null as lpo_date_after, 0 as lpo_after, 0 as lpo_amount_after, ");
		sb.append("0 as lpo_send_newpiwp, 0 as replacement_order ");
		sb.append("from t_po_hdr where purchase_order_type = 'APPL' ");
		sb.append("and order_status = 'eP_REJECTED' and cancellation_remarks is not null ");
		sb.append("and cancellation_remarks != 'ePO Failed to Sync to eP' ");
		sb.append("and trunc(cancellation_date) >= to_date('" + (new SimpleDateFormat("dd/MM/yyyy").format(dateFrom)) + "','dd/MM/yyyy') ");
		sb.append("and trunc(cancellation_date) <= to_date('" + (new SimpleDateFormat("dd/MM/yyyy").format(dateTo)) + "','dd/MM/yyyy') ");
		sb.append("group by trunc(cancellation_date) ");
		sb.append("union all ");
		sb.append("select trunc(cancellation_date) as integration_date, 0 as epo_facility, 0 as epo_facility_amount, ");
		sb.append("0 as epo_send_ep, 0 as epo_fail_ep, 0 as epo_pending_ep, 0 as epo_pending_ep_amount, ");
		sb.append("0 as ep_reject_internal, 0 as ep_reject, count(purchase_order_no) as lpo_cancellation, ");
		sb.append("null as lpo_date_before, 0 as lpo_before, 0 as lpo_amount_before, ");
		sb.append("null as lpo_date_after, 0 as lpo_after, 0 as lpo_amount_after, ");
		sb.append("0 as lpo_send_newpiwp, 0 as replacement_order ");
		sb.append("from t_po_hdr where purchase_order_type = 'APPL' ");
		sb.append("and order_status = 'eP_CANCEL' and cancellation_remarks is not null ");
		sb.append("and trunc(cancellation_date) >= to_date('" + (new SimpleDateFormat("dd/MM/yyyy").format(dateFrom)) + "','dd/MM/yyyy') ");
		sb.append("and trunc(cancellation_date) <= to_date('" + (new SimpleDateFormat("dd/MM/yyyy").format(dateTo)) + "','dd/MM/yyyy') ");
		sb.append("group by trunc(cancellation_date) ");
		sb.append("union all ");
		sb.append("select trunc(lpo_transmitted_date) as integration_date, 0 as epo_facility, 0 as epo_facility_amount, ");
		sb.append("0 as epo_send_ep, 0 as epo_fail_ep, 0 as epo_pending_ep, 0 as epo_pending_ep_amount, ");
		sb.append("0 as ep_reject_internal, 0 as ep_reject, 0 as lpo_cancellation, ");
		sb.append("trunc(lpo_date) as lpo_date_before, count(purchase_order_no) as lpo_before, sum(lpo_amount) as lpo_amount_before, ");
		sb.append("null as lpo_date_after, 0 as lpo_after, 0 as lpo_amount_after, ");
		sb.append("0 as lpo_send_newpiwp, 0 as replacement_order ");
		sb.append("from t_po_hdr where purchase_order_type = 'APPL' ");
		sb.append("and order_status = 'eP_APPROVED' and lpo_no is not null ");
		sb.append("and to_char(lpo_transmitted_date,'HH24') < 14 ");
		sb.append("and trunc(lpo_transmitted_date) >= to_date('" + (new SimpleDateFormat("dd/MM/yyyy").format(dateFrom)) + "','dd/MM/yyyy') ");
		sb.append("and trunc(lpo_transmitted_date) <= to_date('" + (new SimpleDateFormat("dd/MM/yyyy").format(dateTo)) + "','dd/MM/yyyy') ");
		sb.append("group by trunc(lpo_transmitted_date), trunc(lpo_date)" );
		sb.append("union all ");
		sb.append("select trunc(lpo_transmitted_date) as integration_date, 0 as epo_facility, 0 as epo_facility_amount, ");
		sb.append("0 as epo_send_ep, 0 as epo_fail_ep, 0 as epo_pending_ep, 0 as epo_pending_ep_amount, ");
		sb.append("0 as ep_reject_internal, 0 as e_preject, 0 as lpo_cancellation, ");
		sb.append("null as lpo_date_before, 0 as lpo_before, 0 as lpo_amount_before, ");
		sb.append("trunc(lpo_date) as lpo_date_after, count(purchase_order_no) as lpo_after, sum(lpo_amount) as lpo_amount_after, ");
		sb.append("0 as lpo_send_newpiwp, 0 as replacement_order ");
		sb.append("from t_po_hdr where purchase_order_type = 'APPL' ");
		sb.append("and order_status = 'eP_APPROVED' and lpo_no is not null ");
		sb.append("and to_char(lpo_transmitted_date,'HH24') >= 14 ");
		sb.append("and trunc(lpo_transmitted_date) >= to_date('" + (new SimpleDateFormat("dd/MM/yyyy").format(dateFrom)) + "','dd/MM/yyyy') ");
		sb.append("and trunc(lpo_transmitted_date) <= to_date('" + (new SimpleDateFormat("dd/MM/yyyy").format(dateTo)) + "','dd/MM/yyyy') ");
		sb.append("group by trunc(lpo_transmitted_date), trunc(lpo_date) ");
		sb.append("union all ");
		sb.append("select trunc(send_to_piers_date_time) as integration_date, 0 as epo_facility, 0 as epo_facility_amount, ");
		sb.append("0 as epo_send_ep, 0 as epo_fail_ep, 0 as epo_pending_ep, 0 as epo_pending_ep_amount, ");
		sb.append("0 as ep_reject_internal, 0 as ep_reject, 0 as lpo_cancellation, ");
		sb.append("null as lpo_date_before, 0 as lpo_before, 0 as lpo_amount_before, ");
		sb.append("null as lpo_date_after, 0 as lpo_after, 0 as lpo_amount_after, ");
		sb.append("count(purchase_order_no) as lpo_send_newpiwp, 0 as replacement_order ");
		sb.append("from t_po_hdr where purchase_order_type = 'APPL' ");
		sb.append("and trunc(send_to_piers_date_time) >= to_date('" + (new SimpleDateFormat("dd/MM/yyyy").format(dateFrom)) + "','dd/MM/yyyy') ");
		sb.append("and trunc(send_to_piers_date_time) <= to_date('" + (new SimpleDateFormat("dd/MM/yyyy").format(dateTo)) + "','dd/MM/yyyy') ");
		sb.append("group by trunc(send_to_piers_date_time) ");
		sb.append("union all ");
		sb.append("select trunc(created_date) as integration_date, 0 as epo_facility, 0 as epo_facility_amount, ");
		sb.append("0 as epo_send_ep, 0 as epo_fail_ep, 0 as epo_pending_ep, 0 as epo_pending_ep_amount, ");
		sb.append("0 as ep_reject_internal, 0 as ep_reject, 0 as lpo_cancellation, ");
		sb.append("null as lpo_date_before, 0 as lpo_before, 0 as lpo_amount_before, ");
		sb.append("null as lpo_date_after, 0 as lpo_after, 0 as lpo_amount_after, ");
		sb.append("0 as lpo_send_newpiwp, count(purchase_order_no) as replecment_order ");
		sb.append("from t_po_hdr where purchase_order_type = 'RPY' ");
		sb.append("and trunc(created_date) >= to_date('" + (new SimpleDateFormat("dd/MM/yyyy").format(dateFrom)) + "','dd/MM/yyyy') ");
		sb.append("and trunc(created_date) <= to_date('" + (new SimpleDateFormat("dd/MM/yyyy").format(dateTo)) + "','dd/MM/yyyy') ");
		sb.append("group by trunc(created_date)");
		sb.append(")a group by a.integration_date ");
		sb.append("order by a.integration_date asc");
		
		List<SummaryePintegrationBean> summaryePInt = new ArrayList<SummaryePintegrationBean>();
		Session session = null;
		try{
			session = getPoHdrDAO().getSessionFactory().openSession();
			Query que = session.createSQLQuery(sb.toString());
			List<Object[]> list = que.list();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");	
			for (int i = 0; i < list.size(); i++) {
				Object[] objs = list.get(i);
				SummaryePintegrationBean sumePint = new SummaryePintegrationBean();
				sumePint.setIntegrationDate(dateFormat.parse(objs[0].toString()));
				sumePint.setEpoFacility(new BigDecimal(Long.parseLong(objs[1].toString())));
				sumePint.setEpoFacilityAmount(new BigDecimal(objs[2].toString()));
				sumePint.setEpoSendeP(new BigDecimal(Long.parseLong(objs[3].toString())));
				sumePint.setEpoFaileP(new BigDecimal(Long.parseLong(objs[4].toString())));
				sumePint.setEpoPendingeP(new BigDecimal(Long.parseLong(objs[5].toString())));
				sumePint.setEpoPendingePAmount(new BigDecimal(objs[6].toString()));
				sumePint.setePRejectInternal(new BigDecimal(Long.parseLong(objs[7].toString())));
				sumePint.setePReject(new BigDecimal(Long.parseLong(objs[8].toString())));
				sumePint.setLpoCancellation(new BigDecimal(Long.parseLong(objs[9].toString())));
				if(objs[10]!=null && !"".equals(objs[10]))
					sumePint.setLpoDateBefore(dateFormat.parse(objs[10].toString()));
				sumePint.setLpoBefore(new BigDecimal(Long.parseLong(objs[11].toString())));
				sumePint.setLpoAmountBefore(new BigDecimal(objs[12].toString()));
				if(objs[13]!=null && !"".equals(objs[13]))
					sumePint.setLpoDateAfter(dateFormat.parse(objs[13].toString()));
				sumePint.setLpoAfter(new BigDecimal(Long.parseLong(objs[14].toString())));
				sumePint.setLpoAmountAfter(new BigDecimal(objs[15].toString()));
				sumePint.setLpoSendNewpiwp(new BigDecimal(Long.parseLong(objs[16].toString())));
				sumePint.setReplamentOrder(new BigDecimal(Long.parseLong(objs[17].toString())));
				summaryePInt.add(sumePint);
			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return summaryePInt;
		
	}
	@Override
	public PoHdr getPoHdrByLpoNo(String lpoNo) {
		DetachedCriteria criteria = DetachedCriteria.forClass(PoHdr.class);
		criteria.add(Restrictions.eq("lpoNo", lpoNo));
		List<PoHdr> poHdrs = poHdrDAO.findByCriteria(criteria);
		if (poHdrs.size() > 0)
			return poHdrs.get(0);
		else
			return null;
	}
	
	

	@Override
	public PoHdr getPoHdrByLpoNo(Long poHdrSeqno) {
		DetachedCriteria criteria = DetachedCriteria.forClass(PoHdr.class);
		criteria.setFetchMode("poDtls", FetchMode.JOIN);
		criteria.setFetchMode("poDtls.item", FetchMode.JOIN);
		criteria.add(Restrictions.eq("poHdrSeqno", poHdrSeqno));
		List<PoHdr> poHdrs = poHdrDAO.findByCriteria(criteria);
		if (poHdrs.size() > 0)
			return poHdrs.get(0);
		else
			return null;
	}
}