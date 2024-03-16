package my.com.cmg.iwp.maintenance.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.IntegrationBean;
import my.com.cmg.iwp.maintenance.model.RefCodes;
import my.com.cmg.iwp.maintenance.service.RefCodesService;
import my.com.cmg.iwp.util.ApplicationConstants;
import my.com.cmg.iwp.util.RefCodesUtils;
import my.com.cmg.iwp.webui.constant.RefCodeConstant;
@Service
public class RefCodesServiceImpl implements RefCodesService {
	
	private BasisNextidDaoImpl<RefCodes> refCodesDAO;
	RefCodesUtils refCodesUtils;
	
	public RefCodesUtils getRefCodesUtils() {
		return refCodesUtils;
	}

	public void setRefCodesUtils(RefCodesUtils refCodesUtils) {
		this.refCodesUtils = refCodesUtils;
	}

	public BasisNextidDaoImpl<RefCodes> getRefCodesDAO() {
		return refCodesDAO;
	}

	public void setRefCodesDAO(BasisNextidDaoImpl<RefCodes> refCodesDAO) {
		this.refCodesDAO = refCodesDAO;
	}

	@Override
	public List<RefCodes> getAllRefCodes() {
		DetachedCriteria criteria = DetachedCriteria.forClass(RefCodes.class);
		criteria.addOrder(Order.asc("rcDesc"));
		return getRefCodesDAO().findByCriteria(criteria);
	}

	public List<IntegrationBean> findIntegrationByCriteria(String intType,
			String dateFrom, String dateTo) {
		String sql = null;
		boolean statusFlag = false;
		String integrationType = "";
		
		/*if (ApplicationConstants.CATALOGUE_ITEM.equals(intType)) {
			sql = "SELECT COUNT(distinct CREATE_DATE) as noOfTransactions, TRUNC(CREATE_DATE) AS integrationDate, EP_STATUS as status FROM T_ITEM_EP_LOG ";
			statusFlag = true;
			integrationType = "Item Catalogue Creation";
		} else*/ if (ApplicationConstants.REQ_NOTE.equals(intType)) {
			sql = "SELECT COUNT(CREATE_DATE) as noOfTransactions, TRUNC(CREATE_DATE) AS integrationDate, 'Y' as status FROM T_REQ_NOTE_LOG ";
			integrationType = "Request Note Creation";
		} else if (ApplicationConstants.LPO_APPROVAL.equals(intType)) {
			sql = "SELECT COUNT(CREATED_DATE) as noOfTransactions, max(LPO_DATE) AS integrationDate, 'Y' as status FROM T_PO_HDR ";
			integrationType = "LPO Approval";
		} else if (ApplicationConstants.LPO_ACK.equals(intType)) {
			sql = "SELECT COUNT(CREATE_DATE) as noOfTransactions, TRUNC(CREATE_DATE) AS integrationDate, STATUS as status FROM T_PO_ACK_LOG ";
			statusFlag = true;
			integrationType = "PO Acknowledgement";
		} else if (ApplicationConstants.REQC_CANC.equals(intType)) {
			sql = "SELECT COUNT(CREATE_DATE) as noOfTransactions, TRUNC(CREATE_DATE) AS integrationDate,  STATUS as status FROM T_REQ_CANCEL_LOG ";
			statusFlag = true;
			integrationType = "Requisition Cancellation";
		} else if (ApplicationConstants.LPO_CANCEL.equals(intType)) {
			sql = "SELECT COUNT(CREATE_DATE) as noOfTransactions, TRUNC(CREATE_DATE) AS integrationDate, 'Y' AS status FROM T_PO_CANCEL_LOG ";
			integrationType = "LPO Cancellation";
		} else if (ApplicationConstants.DO_CREATION.equals(intType)) {
			sql = "SELECT COUNT(CREATE_DATE) as noOfTransactions, TRUNC(CREATE_DATE) AS integrationDate,  STATUS as status FROM T_DO_LOG ";
			statusFlag = true;
			integrationType = "Delivery Order Creation";
		} else if (ApplicationConstants.FULFILLMENT_NOTIFICATION
				.equals(intType)) {
			sql = "SELECT COUNT(CREATE_DATE) as noOfTransactions, TRUNC(CREATE_DATE) AS integrationDate, 'Y' AS status FROM T_FULFILMNT_LOG ";
			integrationType = "Fulfillment Notification";
		} else if (ApplicationConstants.INVOICE_CREATION.equals(intType)) {
			sql = "SELECT COUNT(CREATE_DATE) as noOfTransactions, TRUNC(CREATE_DATE) AS integrationDate, STATUS as status FROM T_INVOICE_LOG ";
			statusFlag = true;
			integrationType = "Invoice Creation";
		} else if (ApplicationConstants.PAYMENT_NOTIFICATION.equals(intType)) {
			sql = "SELECT COUNT(CREATE_DATE) as noOfTransactions, TRUNC(CREATE_DATE) AS integrationDate, 'Y' AS status FROM T_PMNT_NOTIFICATION_LOG ";
			integrationType = "Payment Notification";
		} else if (ApplicationConstants.PO_VERIFICATION.equals(intType)) {
			sql = "SELECT COUNT(CREATED_DATE) as noOfTransactions, TRUNC(PO_VERFICATION_DATE) AS integrationDate, 'Y' as status FROM T_PO_HDR ";
			integrationType = "PO Verification";
		}
		
		if (dateFrom.trim().length() > 0 && dateTo.trim().length() > 0) {
			if (ApplicationConstants.LPO_APPROVAL.equals(intType)) {
				sql = sql
						+ " WHERE TRUNC(LPO_DATE) >= TO_DATE('"
						+ dateFrom
						+ "', 'YYYY-MM-DD') AND TRUNC(LPO_DATE) <= TO_DATE('"
						+ dateTo + "', 'YYYY-MM-DD')";

				sql = sql + " AND LPO_DATE IS NOT NULL ";
			} else if (ApplicationConstants.PO_VERIFICATION.equals(intType)) {
				sql = sql
						+ " WHERE TRUNC(PO_VERFICATION_DATE) >= TO_DATE('"
						+ dateFrom
						+ "', 'YYYY-MM-DD') AND TRUNC(PO_VERFICATION_DATE) <= TO_DATE('"
						+ dateTo + "', 'YYYY-MM-DD')";

				sql = sql + " AND PO_VERFICATION_DATE IS NOT NULL ";
			} else {
				sql = sql
						+ " WHERE TRUNC(CREATE_DATE) >= TO_DATE('"
						+ dateFrom
						+ "', 'YYYY-MM-DD') AND TRUNC(CREATE_DATE) <= TO_DATE('"
						+ dateTo + "', 'YYYY-MM-DD')";
			}

		} else if (dateFrom.trim().length() > 0 && dateTo.trim().length() == 0) {
			if (ApplicationConstants.LPO_APPROVAL.equals(intType)) {
				sql = sql + " WHERE TRUNC(LPO_DATE) >= TO_DATE('"
						+ dateFrom + "', 'YYYY-MM-DD')";
				sql = sql + " AND LPO_DATE IS NOT NULL ";
			} else if (ApplicationConstants.PO_VERIFICATION.equals(intType)) {
				sql = sql + " WHERE TRUNC(PO_VERFICATION_DATE) >= TO_DATE('"
						+ dateFrom + "', 'YYYY-MM-DD')";
				sql = sql + " AND PO_VERFICATION_DATE IS NOT NULL ";
			} else {
				sql = sql + " WHERE TRUNC(CREATE_DATE) >= TO_DATE('" + dateFrom
						+ "', 'YYYY-MM-DD')";
			}
		} else if (dateFrom.trim().length() == 0 && dateTo.trim().length() > 0) {
			if (ApplicationConstants.LPO_APPROVAL.equals(intType)) {
				sql = sql + " WHERE TRUNC(LPO_DATE) <= TO_DATE('"
						+ dateTo + "', 'YYYY-MM-DD')";
				sql = sql + " AND LPO_DATE IS NOT NULL ";
			} else if (ApplicationConstants.PO_VERIFICATION.equals(intType)) {
				sql = sql + " WHERE TRUNC(PO_VERFICATION_DATE) <= TO_DATE('"
						+ dateTo + "', 'YYYY-MM-DD')";
				sql = sql + " AND PO_VERFICATION_DATE IS NOT NULL ";
			} else {
				sql = sql + " WHERE TRUNC(CREATE_DATE) <= TO_DATE('" + dateTo
						+ "', 'YYYY-MM-DD')";
			}
		} else if (ApplicationConstants.LPO_APPROVAL.equals(intType)) {
			sql = sql + " WHERE LPO_DATE IS NOT NULL ";
		} else if (ApplicationConstants.PO_VERIFICATION.equals(intType)) {
			sql = sql + " WHERE PO_VERFICATION_DATE IS NOT NULL ";
		}

		if (statusFlag && ApplicationConstants.CATALOGUE_ITEM.equals(intType)) {
			sql = sql
					+ " GROUP BY TRUNC(CREATE_DATE), EP_STATUS ORDER BY TRUNC(CREATE_DATE) DESC ";
		} else if (ApplicationConstants.LPO_APPROVAL.equals(intType)) {
			sql = sql
					+ " GROUP BY TRUNC(LPO_DATE) ORDER BY TRUNC(LPO_DATE) DESC ";
		} else if (ApplicationConstants.PO_VERIFICATION.equals(intType)) {
			sql = sql
					+ " GROUP BY TRUNC(PO_VERFICATION_DATE) ORDER BY TRUNC(PO_VERFICATION_DATE) DESC ";
		} else if (statusFlag) {
			sql = sql
					+ " GROUP BY TRUNC(CREATE_DATE), STATUS ORDER BY TRUNC(CREATE_DATE) DESC ";
		} else {
			sql = sql
					+ " GROUP BY TRUNC(CREATE_DATE) ORDER BY TRUNC(CREATE_DATE) DESC ";
		}
		
		System.out.println("SQL : " + sql);
		Session session = refCodesDAO.getSessionFactory().openSession(); 
		List resultList = session
				.createSQLQuery(sql)
				.addScalar("noOfTransactions")
				.addScalar("integrationDate")
				.addScalar("status")
				.setResultTransformer(
						Transformers.aliasToBean(IntegrationBean.class)).list();
		List<IntegrationBean> inteDets = new ArrayList<IntegrationBean>();
		for (int i = 0; i < resultList.size(); i++) {
			inteDets.add((IntegrationBean) resultList.get(i));
			inteDets.get(i).setIntegrationType(integrationType);
			inteDets.get(i).setIntType(intType);
		}
		session.close();
		return inteDets;
	}

	@Override
	public RefCodes getNewRefCode() {

		return new RefCodes();
	}

	public void setRefCodeDAO(BasisNextidDaoImpl<RefCodes> refCodeDAO) {
		this.refCodesDAO = refCodeDAO;
	}

	public BasisNextidDaoImpl<RefCodes> getRefCodeDAO() {
		return refCodesDAO;
	}

	@Override
	public void delete(RefCodes anRefCode) {
		refCodesDAO.delete(anRefCode);
	}

	@Override
	public void saveOrUpdate(RefCodes anRefCode) {
		refCodesDAO.saveOrUpdate(anRefCode);
	}

	@Override
	public List<RefCodes> getDesc(String domain) {
		return getRefCodesUtils().getRefCodeByRcDomain_REFMAP(domain,"rcDesc",true);
	}

	@Override
	public List<RefCodes> getRefCodesByDomain(String domain) {
		return getRefCodesUtils().getRefCodeByRcDomain_REFMAP(domain,"rcDesc",true);
	}

	@Override
	public List<RefCodes> getRefCodesByDomainAndParamter1(String domain,String paramter1) {
		DetachedCriteria criteria = DetachedCriteria.forClass(RefCodes.class);
		criteria.add(Restrictions.eq("rcDomain", domain));
		criteria.add(Restrictions.eq("paramter1", paramter1));
		criteria.addOrder(Order.asc("rcDesc"));
		return refCodesDAO.findByCriteria(criteria);
	}
	
	@Override
	public List<RefCodes> getRefCodesListByDomain(String domain) {
		DetachedCriteria criteria = DetachedCriteria.forClass(RefCodes.class);
		criteria.add(Restrictions.eq("rcDomain", domain));
		criteria.addOrder(Order.asc("rcDesc"));
		return refCodesDAO.findByCriteria(criteria);
	}
	
	@Override
	public RefCodes getRefCodeByRcDesc(String domain, String rcDesc) {

		DetachedCriteria criteria = DetachedCriteria.forClass(RefCodes.class);
		Criterion criterion = Restrictions.eq("rcDomain", domain);
		Criterion criterion2 = Restrictions.eq("rcDesc", rcDesc);
		criteria.add(Restrictions.and(criterion, criterion2));
		return DataAccessUtils.uniqueResult(refCodesDAO
				.findByCriteria(criteria));
	}

	@Override
	public RefCodes getRefCodeByRcValue(String domain, String rcValue) {
		return getRefCodesUtils().getRefCodeByRcValue_REFMAP(domain,rcValue);
	}

	@Override
	public List<RefCodes> getDescOrderbySeqNo(String domain) {
		return getRefCodesUtils().getRefCodeByRcDomain_REFMAP(domain,"rcSeq",false);
	}

	@Override
	public List<RefCodes> getAllRefCode() {
		return refCodesDAO.loadAll(RefCodes.class);
	}

	public List<RefCodes> getRefCodesByDomain(String domain, String[] orderBy) {
		DetachedCriteria criteria = DetachedCriteria.forClass(RefCodes.class);
		criteria.add(Restrictions.eq("rcDomain", domain));
		if (orderBy != null) {
			criteria.addOrder((RefCodeConstant.ORDER_SEQUENCE_ASCENDING
					.equalsIgnoreCase(orderBy[0]) ? Order.asc(orderBy[1])
					: Order.desc(orderBy[1])));
		} else {
			criteria.addOrder(Order.asc("rcDesc"));
		}
		return refCodesDAO.findByCriteria(criteria);
	}

	@Override
	public List<RefCodes> getAscOrderbySeqNo(String domain) {
		return getRefCodesUtils().getRefCodeByRcDomain_REFMAP(domain,"rcSeq",true);
	}
	
	@Override
	public List<RefCodes> getAscOrderbySeqNo(String domain, String sortProperty) {
		return getRefCodesUtils().getRefCodeByRcDomain_REFMAP(domain,sortProperty,true);
	}

	@Override
	public List<RefCodes> getRefCodesByDomainException(String holidayType,
			String weekend) {

		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(RefCodes.class);
		detachedCriteria.add(Restrictions.ne("rcValue", weekend));
		detachedCriteria.add(Restrictions.eq("rcDomain", holidayType));
		return refCodesDAO.findByCriteria(detachedCriteria);
	}
	
	@Override
	public List<RefCodes> getTdmCalculators(String domain, List<String> list) {
		DetachedCriteria criteria = DetachedCriteria.forClass(RefCodes.class);
		criteria.add(Restrictions.eq("rcDomain", domain));
		if(list.size()>0)
		criteria.add(Restrictions.not(Restrictions.in("rcValue", list)));
		criteria.addOrder(Order.asc("rcSeq"));
		return refCodesDAO.findByCriteria(criteria);
	}
	
	
	@Override
	public List<RefCodes> getDistinctRefCode() {
		DetachedCriteria criteria = DetachedCriteria.forClass(RefCodes.class);
		criteria.addOrder(Order.asc("rcDomain"));
//		criteria.setProjection(Projections.distinct(Projections.property("rcDomain")));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return refCodesDAO.findByCriteria(criteria);
	}

	@Override
	public List<String> getRefCodeDomainList(String domainName) {
		List<String> domainList = new ArrayList<String>();
		String qry = "";
		if (domainName.trim().isEmpty()) {
			qry = "select distinct (rc_domain) from t_ref_codes order by  rc_domain asc";
		} else {
			qry = "select distinct (rc_domain) from t_ref_codes where upper(rc_domain) like '%"
					+ domainName.toUpperCase() + "%' order by  rc_domain asc";
		}
		// System.out.println("QRY=== "+qry);
		SessionFactory sessionFactory = refCodesDAO.getSessionFactory();

		Session session = sessionFactory.openSession();

		List objectArrayList = session.createSQLQuery(qry).list();
		// System.out.println("objectArrayList == "+objectArrayList.getClass());

		session.close();

		for (Object objects : objectArrayList) {
			// System.out.println(objects.getClass());
			domainList.add((String) objects);
		}
		return domainList;
	}
	
	@Override
	public List<String> getRefCodeValuesForRcDesc(String domainName, String rcDesc) {
		List<String> domainList = new ArrayList<String>();
		String qry = "select distinct (rc_value) from t_ref_codes  where rc_domain = '" + domainName + "' and upper(rc_desc) like upper('%" + rcDesc + "%')";
		SessionFactory sessionFactory = refCodesDAO.getSessionFactory();
		Session session = sessionFactory.openSession();
		List objectArrayList = session.createSQLQuery(qry).list();
		session.close();
		for (Object objects : objectArrayList) {
			domainList.add((String) objects);
		}
		return domainList;
	}

	@Override
	public RefCodes getRefCodeByRcValueIgnoreCaseSensitive(String domain, String rcValue) {

		DetachedCriteria criteria = DetachedCriteria.forClass(RefCodes.class);
		Criterion criterion = Restrictions.eq("rcDomain", domain);
		Criterion criterion2 = Restrictions.ilike("rcValue", rcValue.trim());
		criteria.add(Restrictions.and(criterion, criterion2));
		return DataAccessUtils
				.uniqueResult(refCodesDAO.findByCriteria(criteria));
	}
	
	@Override
	public List<RefCodes> getRefCodesByValues(String rcDomain, List<String> rcValues) {
		return getRefCodesUtils().getRefCodeByRcValues_REFMAP(rcDomain, rcValues);
	}

	@Override
	public List<RefCodes> getRefCodesByDomainAndParamter1Sort(String domain,
			boolean order) {
		DetachedCriteria criteria = DetachedCriteria.forClass(RefCodes.class);
		criteria.add(Restrictions.eq("rcDomain", domain));
		if(order)
		criteria.addOrder(Order.desc("paramter1"));
		else
		criteria.addOrder(Order.asc("paramter1"));
		return refCodesDAO.findByCriteria(criteria);
	}
	
}