package my.com.cmg.iwp.maintenance.service.impl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.Query;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.DoDtl;
import my.com.cmg.iwp.maintenance.model.PoDtl;
import my.com.cmg.iwp.maintenance.model.PoHdr;
import my.com.cmg.iwp.maintenance.model.ResultObject;
import my.com.cmg.iwp.maintenance.service.DoDtlService;
import my.com.cmg.iwp.util.ApplicationConstants;
import my.com.cmg.iwp.webui.constant.RefCodeConstant;
import my.com.cmg.phis.util.constant.InventoryConstants;

/**
 * @author PC
 *
 */
@Service
public class DoDtlServiceImpl implements DoDtlService, Serializable {
	private static final long serialVersionUID = 1L;
	
	private BasisNextidDaoImpl<DoDtl> doDtlDAO;

	public BasisNextidDaoImpl<DoDtl> getDoDtlDAO() {
		return doDtlDAO;
	}

	public void setDoDtlDAO(BasisNextidDaoImpl<DoDtl> doDtlDAO) {
		this.doDtlDAO = doDtlDAO;
	}

	@Override
	public ResultObject getAllDoDetails(int start, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(DoDtl.class);
		criteria.addOrder(Order.asc("seqNo"));
		int totalCount = getDoDtlDAO().findByCriteria(criteria).size();
		List<DoDtl> list = getDoDtlDAO().findByCriteria(criteria, start, pageSize);
		return new ResultObject(list, totalCount);
	}

	@Override
	public List<DoDtl> getAllDetails() {
		DetachedCriteria criteria = DetachedCriteria.forClass(DoDtl.class);
		criteria.addOrder(Order.asc("seqNo"));
		return getDoDtlDAO().findByCriteria(criteria);
	}

	@Override
	public DoDtl getDoDtlByCriteria(String lpoNo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public DoDtl getNewDoDtl() {
		// TODO Auto-generated method stub
		return new DoDtl();
	}
	
	@Override
	public void saveOrUpdate(DoDtl anDoDtl) {
		// TODO Auto-generated method stub
		 getDoDtlDAO().saveOrUpdate(anDoDtl);

	}
	
	@Override
	public DoDtl findByDoNo(String doNo) {
		DetachedCriteria criteria = DetachedCriteria.forClass(DoDtl.class);
		criteria.add(Restrictions.eq("lampiranNo", doNo));
		return DataAccessUtils.uniqueResult(getDoDtlDAO().findByCriteria(criteria));
	}

	@Override
	public List<DoDtl> findByItemCode(String itemCode, String lpoNo,
			String facilityCode, String ptjCode, String purchaseOrderNo,String facility_type) {
		DetachedCriteria criteria = DetachedCriteria.forClass(DoDtl.class);
		criteria.addOrder(Order.asc("lampiranNo"));
		criteria.add(Restrictions.eq("itemCode", itemCode));
		if(facility_type!=null && facility_type.equals("KK")){
			criteria.add(Restrictions.eq("kkRcvFlag", RefCodeConstant.BOOLEAN_TRUE));
		}
		criteria.add(Restrictions.eq("lpoNo", lpoNo));
		criteria.add(Restrictions.eq("customerId", facilityCode));
		criteria.add(Restrictions.eq("customerAccNo", ptjCode));
		criteria.add(Restrictions.eq("customerRefNo", purchaseOrderNo)); 
		return getDoDtlDAO().findByCriteria(criteria);
	}

	@Override
	public List<DoDtl> getDistinctDo(String lpoNo, String itemCode, Character kkRcvFlag) {
		Session session = getDoDtlDAO().getSessionFactory().openSession();
		List<DoDtl> doDtls = new ArrayList<DoDtl>(0);
		List<Object[]> objects = session.createSQLQuery("SELECT DISTINCT LAMPIRAN_NO, TRUNC(DO_DATE,'DD'), TRUNC(UPDATED_DATE,'DD') FROM T_DO_DTL WHERE LPO_NO='"+lpoNo+"' AND "
				+ "ITEM_CODE='"+itemCode+"' AND KK_RCV_FLAG='"+kkRcvFlag+"'").list();
		session.close();
		for (Object[] objectArray : objects) {
			DoDtl doDtl = xTransformArrayToDoDtl(objectArray);
			doDtls.add(doDtl);
		}
		return doDtls;
	}
	
	private DoDtl xTransformArrayToDoDtl(Object[] objectArray){	
		DoDtl doDtl = new DoDtl();		
		doDtl.setLampiranNo(objectArray[0].toString());
		doDtl.setDoDate((Date)objectArray[1]);
		doDtl.setLastUpdDate((Date)objectArray[2]);
		return doDtl;
	}
	
	@Override
	public String statusPOSendToEP(String lpoNo,String facilityCode, String ptjCode) {
		String status = "";
		Session session = getDoDtlDAO().getSessionFactory().openSession();
		String queryStr = "SELECT count(DO_SEQ_NO) "
					+" FROM T_DO_DTL " 
					+" WHERE SEND_TO_EP = 'Y' AND SENDTO_EP_DATE IS NOT NULL " 
					+" AND LPO_NO = :lpoNo AND CUSTOMER_ID = :facilityCode AND CUSTOMER_ACC_NO = :ptjCode ";
		Query query = session.createSQLQuery(queryStr);
		query.setString("lpoNo", lpoNo);
		query.setString("facilityCode", facilityCode);
		query.setString("ptjCode", ptjCode);
		
		List<Object> list = query.list();
		session.close();
		for (Object objectArr : list) {
			if(objectArr != null && Integer.parseInt(objectArr.toString()) > 0) {
				status = InventoryConstants.PO_STATUS.PO_STATUS_EP_APPROVED;
				break;
			}
		}
		return status;
	}
	
	@Override
	public Map<String,Integer> getDOInOutLogCount(String dateFrom, String dateTo) {
		Map<String,Integer> returnMap = null;
		StringBuffer queryStr = new StringBuffer();
		
		queryStr.append(" SELECT ");
		queryStr.append(" SUM(TT.APPL_DO_IN)AS APPL_DO_IN, ");
		queryStr.append(" SUM(TT.LP_DO_IN)AS LP_DO_IN, ");
		queryStr.append(" SUM(TT.CONTRACT_DO_IN)AS CONTRACT_DO_IN,");
		queryStr.append(" SUM(TT.APPL_DO_OUT)AS APPL_DO_OUT, ");
		queryStr.append(" SUM(TT.LP_DO_OUT)AS LP_DO_OUT, ");
		queryStr.append(" SUM(TT.CONTRACT_DO_OUT)AS CONTRACT_DO_OUT ");
		queryStr.append(" FROM ");
		queryStr.append(" ( ");
		queryStr.append("	SELECT "); 
		queryStr.append("	CASE WHEN po_hdr.PURCHASE_ORDER_TYPE = 'APPL' THEN COUNT(do_dtl.PO_HDR_SEQNO) ELSE 0 END AS APPL_DO_IN, ");
		queryStr.append("	0 AS LP_DO_IN, ");
		queryStr.append("	CASE WHEN po_hdr.PURCHASE_ORDER_TYPE = 'Contract' THEN COUNT(do_dtl.PO_HDR_SEQNO) ELSE 0 END AS CONTRACT_DO_IN, ");
		queryStr.append("	0 AS APPL_DO_OUT, ");
		queryStr.append("	0 AS LP_DO_OUT, ");
		queryStr.append("	0 AS CONTRACT_DO_OUT ");
		queryStr.append("	FROM T_DO_DTL do_dtl ");
		queryStr.append("	JOIN T_PO_HDR po_hdr ON po_hdr.PO_HDR_SEQNO = do_dtl.PO_HDR_SEQNO ");
		queryStr.append("	WHERE 1=1 ");
		queryStr.append("	AND do_dtl.CREATED_DATE between to_date('" + dateFrom + "','YYYY-MM-DD') and  to_date('" + dateTo +"','YYYY-MM-DD')");
		/*if(dateFrom!=null)
		queryStr.append("	AND TO_DATE(TRUNC(do_dtl.CREATED_DATE),'DD/MM/RRRR')>= TO_DATE(TRUNC(TO_DATE('" + dateFrom+"','YYYY-MM-DD HH24:MI:SS')),'DD/MM/RRRR') ");
		if(dateTo!=null)
		queryStr.append("	AND TO_DATE(TRUNC(do_dtl.CREATED_DATE),'DD/MM/RRRR')<= TO_DATE(TRUNC(TO_DATE('" + dateTo+"','YYYY-MM-DD HH24:MI:SS')),'DD/MM/RRRR') ");*/
		queryStr.append("	GROUP BY po_hdr.PURCHASE_ORDER_TYPE ");

		queryStr.append("	UNION ALL ");

		queryStr.append(" 	SELECT  ");
		queryStr.append("	0 AS APPL_DO_IN, ");
		queryStr.append("	0 AS LP_DO_IN, ");
		queryStr.append("	0 AS CONTRACT_DO_IN, ");
		queryStr.append("	CASE WHEN po_hdr.PURCHASE_ORDER_TYPE = 'APPL' THEN COUNT(do_dtl.PO_HDR_SEQNO) ELSE 0 END AS APPL_DO_OUT, ");
		queryStr.append("	0 AS LP_DO_OUT, ");
		queryStr.append("	0 AS CONTRACT_DO_OUT ");
		queryStr.append("	FROM T_DO_DTL do_dtl ");
		queryStr.append("	JOIN T_PO_HDR po_hdr ON po_hdr.PO_HDR_SEQNO = do_dtl.PO_HDR_SEQNO ");
		queryStr.append("	WHERE SEND_TO_EP = 'Y' "); 
		queryStr.append("	AND do_dtl.SENDTO_EP_DATE IS NOT NULL ");
		queryStr.append("	AND do_dtl.CREATED_DATE between to_date('" + dateFrom + "','YYYY-MM-DD') and  to_date('" + dateTo +"','YYYY-MM-DD')");
		/*if(dateFrom!=null)
		queryStr.append("	AND TO_DATE(TRUNC(do_dtl.CREATED_DATE),'DD/MM/RRRR')>= TO_DATE(TRUNC(TO_DATE('" + dateFrom+"','YYYY-MM-DD HH24:MI:SS')),'DD/MM/RRRR') ");
		if(dateTo!=null)
		queryStr.append("	AND TO_DATE(TRUNC(do_dtl.CREATED_DATE),'DD/MM/RRRR')<= TO_DATE(TRUNC(TO_DATE('" + dateTo+"','YYYY-MM-DD HH24:MI:SS')),'DD/MM/RRRR') ");*/
		queryStr.append("	GROUP BY po_hdr.PURCHASE_ORDER_TYPE ");
		queryStr.append(" )TT ");
		
		Session session = null;		
		try {
			session = getDoDtlDAO().getSessionFactory().openSession();
			Query que = session.createSQLQuery(queryStr.toString());
			List<Object> list = que.list();
			returnMap = new HashMap<String, Integer>();
			if(list != null && list.size() > 0) {
				Object[] objArr = (Object[]) list.get(0);
				if(objArr != null) {
					returnMap.put(ApplicationConstants.ORD_INT_PHASE_APPL_DO_IN, objArr[0] != null ? Integer.valueOf(objArr[0].toString()) : 0);
					returnMap.put(ApplicationConstants.ORD_INT_PHASE_LP_DO_IN, objArr[1] != null ? Integer.valueOf(objArr[1].toString()) : 0);
					returnMap.put(ApplicationConstants.ORD_INT_PHASE_CONTRACT_DO_IN, objArr[2] != null ? Integer.valueOf(objArr[2].toString()) : 0);
					returnMap.put(ApplicationConstants.ORD_INT_PHASE_APPL_DO_OUT, objArr[3] != null ? Integer.valueOf(objArr[3].toString()) : 0);
					returnMap.put(ApplicationConstants.ORD_INT_PHASE_LP_DO_OUT, objArr[4] != null ? Integer.valueOf(objArr[4].toString()) : 0);
					returnMap.put(ApplicationConstants.ORD_INT_PHASE_CONTRACT_DO_OUT, objArr[5] != null ? Integer.valueOf(objArr[5].toString()) : 0);
				} else {
					returnMap.put(ApplicationConstants.ORD_INT_PHASE_APPL_DO_IN, 0);
					returnMap.put(ApplicationConstants.ORD_INT_PHASE_LP_DO_IN, 0);
					returnMap.put(ApplicationConstants.ORD_INT_PHASE_CONTRACT_DO_IN, 0);
					returnMap.put(ApplicationConstants.ORD_INT_PHASE_APPL_DO_OUT, 0);
					returnMap.put(ApplicationConstants.ORD_INT_PHASE_LP_DO_OUT, 0);
					returnMap.put(ApplicationConstants.ORD_INT_PHASE_CONTRACT_DO_OUT, 0);
				}
			} else {
				returnMap.put(ApplicationConstants.ORD_INT_PHASE_APPL_DO_IN, 0);
				returnMap.put(ApplicationConstants.ORD_INT_PHASE_LP_DO_IN, 0);
				returnMap.put(ApplicationConstants.ORD_INT_PHASE_CONTRACT_DO_IN, 0);
				returnMap.put(ApplicationConstants.ORD_INT_PHASE_APPL_DO_OUT, 0);
				returnMap.put(ApplicationConstants.ORD_INT_PHASE_LP_DO_OUT, 0);
				returnMap.put(ApplicationConstants.ORD_INT_PHASE_CONTRACT_DO_OUT, 0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return returnMap;
	}
	
	@Override
	public double getTotalOrderAmount(PoHdr poHdr,String facility_type) {
		double totalOrderAMT = 0.0;
		for(PoDtl poDtl : poHdr.getPoDtls()) {
			List<DoDtl> doDtls = this.findByItemCode(poDtl.getItem().getItemCode(), poHdr.getLpoNo(), poHdr.getFacilityCode(),poHdr.getPtjCode(), poHdr.getPurchaseOrderNo(),facility_type);
			
			BigDecimal ordQTY = new BigDecimal(0.0);
			for(DoDtl doDTL : doDtls){
				ordQTY = ordQTY.add(doDTL.getDelQty());
			}
	        totalOrderAMT = totalOrderAMT + (poDtl.getUnitPrice().doubleValue() * ordQTY.longValue());
		}
		return totalOrderAMT;
	}
}
