package my.com.cmg.iwp.backend.service.inventory.penalty.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.backend.model.inventory.penalty.PenaltyHdr;
import my.com.cmg.iwp.backend.service.inventory.penalty.PenaltyHdrService;
import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.MyCalendar;
import my.com.cmg.iwp.maintenance.model.PenaltyIncident;
import my.com.cmg.iwp.maintenance.model.PenaltyIncidentCalDtls;
import my.com.cmg.iwp.maintenance.service.CalendarService;
import my.com.cmg.iwp.webui.constant.RefCodeConstant;
import my.com.cmg.iwp.webui.inventory.penalty.PenaltyConstants;

@Service
public class PenaltyHdrServiceImpl<R> implements PenaltyHdrService {

	private BasisNextidDaoImpl<PenaltyHdr> penaltyHdrDAO;
	private BasisNextidDaoImpl<PenaltyIncident> penaltyIncidentDAO;
	private BasisNextidDaoImpl<PenaltyIncidentCalDtls> penaltyIncidentCalDtlDAO;

	@Override
	public void saveOrUpdate(PenaltyHdr penaltyHdr) {
		getPenaltyHdrDAO().saveOrUpdate(penaltyHdr);
	}

	@Override
	public void saveOrUpdateAll(List<PenaltyHdr> penaltyHdrs) {
		getPenaltyHdrDAO().saveOrUpdateAll(penaltyHdrs);
	}

	@Override
	public void delete(PenaltyHdr penaltyHdr) {
		getPenaltyHdrDAO().delete(penaltyHdr);
	}

	@Override
	public void deleteAll(List<PenaltyHdr> penaltyHdrs) {
		getPenaltyHdrDAO().deleteAll(penaltyHdrs);
	}

	@Override
	public List<PenaltyHdr> findByExample(PenaltyHdr penaltyHdr) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(PenaltyHdr.class);
		detachedCriteria.add(Restrictions.eq("penHdrSeqno", penaltyHdr.getPenHdrSeqno()));
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return getPenaltyHdrDAO().findByCriteria(detachedCriteria);
	}
	
	@Override
	public List<PenaltyHdr> findByExampleForRenderer(PenaltyHdr penaltyHdr) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(PenaltyHdr.class);
		if( penaltyHdr.getPenHdrSeqno() > 0)
		detachedCriteria.add(Restrictions.eq("penHdrSeqno", penaltyHdr.getPenHdrSeqno()));
		if(penaltyHdr.getPtjcode() != null && !penaltyHdr.getPtjcode().isEmpty() )
			detachedCriteria.add(Restrictions.eq("ptjcode", penaltyHdr.getPtjcode()));
		if(penaltyHdr.getHospitalcode() != null && !penaltyHdr.getHospitalcode().isEmpty() )
			detachedCriteria.add(Restrictions.eq("hospitalcode", penaltyHdr.getHospitalcode()));
		if(penaltyHdr.getLpoNo() != null && !penaltyHdr.getLpoNo().isEmpty() )
			detachedCriteria.add(Restrictions.eq("lpoNo", penaltyHdr.getLpoNo()));
		if(penaltyHdr.getTransactionNumber() != null && !penaltyHdr.getTransactionNumber().isEmpty() )
			detachedCriteria.add(Restrictions.eq("transactionNumber", penaltyHdr.getTransactionNumber()));
		detachedCriteria.createAlias("penaltyIncident", "penaltyIncident", CriteriaSpecification.LEFT_JOIN);
		
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return getPenaltyHdrDAO().findByCriteria(detachedCriteria);
	}

	public BasisNextidDaoImpl<PenaltyHdr> getPenaltyHdrDAO() {
		return penaltyHdrDAO;
	}

	public void setPenaltyHdrDAO(BasisNextidDaoImpl<PenaltyHdr> penaltyHdrDAO) {
		this.penaltyHdrDAO = penaltyHdrDAO;
	}
	
	

	public BasisNextidDaoImpl<PenaltyIncidentCalDtls> getPenaltyIncidentCalDtlDAO() {
		return penaltyIncidentCalDtlDAO;
	}

	public void setPenaltyIncidentCalDtlDAO(BasisNextidDaoImpl<PenaltyIncidentCalDtls> penaltyIncidentCalDtlDAO) {
		this.penaltyIncidentCalDtlDAO = penaltyIncidentCalDtlDAO;
	}

	@Override
	public List<PenaltyIncident> getPenaltyIncidentByIncidentCode(String incidentCode) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(PenaltyIncident.class);
		detachedCriteria.add(Restrictions.eq("incidentCode",incidentCode));
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return getPenaltyIncidentDAO().findByCriteria(detachedCriteria);

	}

	@Override
	public PenaltyHdr getPenaltyByExampleForDialog(PenaltyHdr penaltyHdr) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(PenaltyHdr.class);
		detachedCriteria.add(Restrictions.eq("penHdrSeqno", penaltyHdr.getPenHdrSeqno()));
		detachedCriteria.setFetchMode("penaltyIncident", FetchMode.JOIN);
//		detachedCriteria.setFetchMode("createdUser", FetchMode.JOIN);
		
		detachedCriteria.createAlias("penaltyDtls", "penaltyDtl", CriteriaSpecification.LEFT_JOIN)
		.createAlias("penaltyDtl.penaltyItems", "penaltyItem", CriteriaSpecification.LEFT_JOIN)
		.createAlias("penaltyItem.penaltyBatchs", "penaltyBatch", CriteriaSpecification.LEFT_JOIN)
		.createAlias("poHdr", "poHdr", CriteriaSpecification.LEFT_JOIN)
		.createAlias("poHdr.poDtls", "poDtls", CriteriaSpecification.LEFT_JOIN);
		
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return getPenaltyHdrDAO().findByCriteria(detachedCriteria).get(0);
	}
	
	public BasisNextidDaoImpl<PenaltyIncident> getPenaltyIncidentDAO() {
		return penaltyIncidentDAO;
	}

	public void setPenaltyIncidentDAO(
			BasisNextidDaoImpl<PenaltyIncident> penaltyIncidentDAO) {
		this.penaltyIncidentDAO = penaltyIncidentDAO;
	}

	@Override
	public PenaltyHdr getPenaltyByTransportationRefNo(String transRefNo) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(PenaltyHdr.class);
		detachedCriteria.add(Restrictions.eq("transportationInfo", transRefNo));
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return !getPenaltyHdrDAO().findByCriteria(detachedCriteria).isEmpty() ? getPenaltyHdrDAO().findByCriteria(detachedCriteria).get(0):null;
	}

	@Override
	public List<PenaltyHdr> getPeanltyHdrsToSync() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(PenaltyHdr.class);
	/*	detachedCriteria.add(Restrictions.eq("status", PenaltyConstants.PENALTY_HDR_STATUS_APPROVED));*/
		detachedCriteria.add(Restrictions.in("status",new String[] {
				PenaltyConstants.PENALTY_HDR_STATUS_APPROVED, PenaltyConstants.PENALTY_HDR_STATUS_REJECTED }));
		detachedCriteria.setFetchMode("penaltyDtls", FetchMode.JOIN);
		detachedCriteria.add(Restrictions.eq("sentToFacility", RefCodeConstant.BOOLEAN_FALSE));
		detachedCriteria.setFetchMode("penaltyDtls.penaltyItems", FetchMode.JOIN);
		detachedCriteria.setFetchMode("penaltyDtls.penaltyItems.penaltyBatchs", FetchMode.JOIN);
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return getPenaltyHdrDAO().findByCriteria(detachedCriteria);
	}
	
	@Override
	public long getIntervalByWorkingDays(Date date1, Date date2, String statecode,CalendarService calendarService) {
		List<MyCalendar> myCalanderList =   calendarService.getCalendarsByStateCode1(date1,date2,statecode);
		return !myCalanderList.isEmpty()?myCalanderList.size():0;
	}
	
	@Override
	public Date getDeliveryDueDateFromPoHdrBack(long poHdrSeqno) {		
		Session session = getPenaltyHdrDAO().getSessionFactory().openSession();
		Date date_ = null;
		try {
			org.hibernate.query.Query<R> query = session.createNativeQuery("SELECT CASE WHEN DELIVERY_DUE_DATE IS NOT NULL THEN DELIVERY_DUE_DATE ELSE (SELECT DELIVERY_DUE_DATE FROM T_PO_HDR WHERE PO_HDR_SEQNO='"+poHdrSeqno+"') END AS DELIVERY_DUE_DATE FROM T_PO_HDR_BACK WHERE PO_HDR_SEQNO='"+poHdrSeqno+"' ");				
			List list = query.list();
			date_ = list!=null && list.size() > 0 && list.get(0) !=null?(Date) list.get(0):null;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return date_;
	}

	@Override
	public PenaltyIncidentCalDtls getPenaltyIncidentDtlsByFormulaCode(String formulaCode) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(PenaltyIncidentCalDtls.class);
		detachedCriteria.setFetchMode("penaltyIncident", FetchMode.JOIN);
		detachedCriteria.add(Restrictions.eq("formulaCode", formulaCode));
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return !getPenaltyIncidentCalDtlDAO().findByCriteria(detachedCriteria).isEmpty() ? getPenaltyIncidentCalDtlDAO().findByCriteria(detachedCriteria).get(0):null;
	}

	@Override
	public void PenaltyHdrSentToFacilityFlagUpdate(String transactionNumber) {
		 String query = new String();
		  Transaction txn = null;
		  query += "  update t_penalty_hdr set send_to_facility='"+RefCodeConstant.BOOLEAN_TRUE+"' where transaction_number='"+transactionNumber+"' ";
		  try {
			  SessionFactory sessionFactory = penaltyHdrDAO.getSessionFactory();
				Session session = sessionFactory.openSession();
				txn = session.beginTransaction();
				session.createNativeQuery(query).executeUpdate();
				txn.commit();
				session.close();
		  } catch (Exception e) {
		   e.printStackTrace();
		  }
		
	}
	
	@Override
	public Double getProposedAmt(long Seqno) {
		Double proposedAmt= 0d;
		String query = "  select bat.proposed_penalty_amt from t_penalty_batch bat  "
				+ "left join t_penalty_item itm on bat.p_item_seqno = itm.p_item_seqno   "
				+ "left join t_penalty_dtl dtl on itm.p_dtl_seqno = dtl.p_dtl_seqno  "
				+ "left join t_penalty_hdr hdr on dtl.p_hdr_seqno = hdr.p_hdr_seqno  "
				+ "left join t_penalty_verification_dtl  vdtl on vdtl.p_hdr_seqno  =hdr.p_hdr_seqno   "
				+ "left join t_penalty_verification_hdr  vhdr on  vhdr.t_penalty_verify_seqno = vdtl.t_penalty_verify_seqno  "
				+ "where vdtl.t_penalty_verify_dtl_seqno=  '" + Seqno 
				+ "' ";
		Session session = null;
		try {
			session = getPenaltyHdrDAO().getSessionFactory().openSession();
			org.hibernate.query.Query<R> result = session.createNativeQuery(query);	
			List list = result.list();
			proposedAmt =  (null != list && list.size() > 0 && null != list.iterator().next()  
					?  Double.parseDouble(((Object) list.iterator().next()).toString()) : 0);
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return proposedAmt;
	}	
	
	@Override
	public List<PenaltyHdr> findForRenderer(PenaltyHdr penaltyHdr) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(PenaltyHdr.class);
		if (penaltyHdr.getPenHdrSeqno() > 0)
			detachedCriteria.add(Restrictions.eq("penHdrSeqno", penaltyHdr.getPenHdrSeqno()));
		if (penaltyHdr.getPtjcode() != null && !penaltyHdr.getPtjcode().isEmpty())
			detachedCriteria.add(Restrictions.eq("ptjcode", penaltyHdr.getPtjcode()));
		if (penaltyHdr.getHospitalcode() != null && !penaltyHdr.getHospitalcode().isEmpty())
			detachedCriteria.add(Restrictions.eq("hospitalcode", penaltyHdr.getHospitalcode()));
		if (penaltyHdr.getLpoNo() != null && !penaltyHdr.getLpoNo().isEmpty())
			detachedCriteria.add(Restrictions.eq("lpoNo", penaltyHdr.getLpoNo()));
		if (penaltyHdr.getTransactionNumber() != null && !penaltyHdr.getTransactionNumber().isEmpty())
			detachedCriteria.add(Restrictions.eq("transactionNumber", penaltyHdr.getTransactionNumber()));
		detachedCriteria.createAlias("penaltyIncident", "penaltyIncident", CriteriaSpecification.LEFT_JOIN);

		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return getPenaltyHdrDAO().findByCriteria(detachedCriteria);
	}
}
