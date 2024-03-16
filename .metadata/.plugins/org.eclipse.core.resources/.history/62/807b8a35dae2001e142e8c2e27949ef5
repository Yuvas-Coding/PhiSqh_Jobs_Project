package my.com.cmg.iwp.backend.service.inventory.penalty.impl;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.backend.model.inventory.penalty.PenaltyVerificationDtl;
import my.com.cmg.iwp.backend.model.inventory.penalty.PenaltyVerificationHdr;
import my.com.cmg.iwp.backend.service.inventory.penalty.PenaltyVerificationService;
import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.webui.inventory.penalty.PenaltyConstants;

@Service
public class PenaltyVerificationServiceImpl implements PenaltyVerificationService {

	private BasisNextidDaoImpl<PenaltyVerificationHdr> penaltyVerificationHdrDAO;
	private BasisNextidDaoImpl<PenaltyVerificationDtl> penaltyVerificationDtlDAO;
	
	@Override
	public void saveOrUpdate(PenaltyVerificationHdr penaltyVerification) {
		getPenaltyVerificationHdrDAO().saveOrUpdate(penaltyVerification);
	}

	@Override
	public void saveOrUpdateAll(List<PenaltyVerificationHdr> penaltyVerifications) {
		getPenaltyVerificationHdrDAO().saveOrUpdateAll(penaltyVerifications);
	}

	@Override
	public void delete(PenaltyVerificationHdr penaltyVerification) {
		getPenaltyVerificationHdrDAO().delete(penaltyVerification);
	}

	@Override
	public void deleteAll(List<PenaltyVerificationHdr> penaltyVerifications) {
		getPenaltyVerificationHdrDAO().deleteAll(penaltyVerifications);
	}

	@Override
	public List<PenaltyVerificationHdr> findByExample( PenaltyVerificationHdr penaltyVerification) {
		return getPenaltyVerificationHdrDAO().findByExample(penaltyVerification);
	}

	public BasisNextidDaoImpl<PenaltyVerificationHdr> getPenaltyVerificationHdrDAO() {
		return penaltyVerificationHdrDAO;
	}

	public void setPenaltyVerificationHdrDAO(BasisNextidDaoImpl<PenaltyVerificationHdr> penaltyVerificationDAO) {
		this.penaltyVerificationHdrDAO = penaltyVerificationDAO;
	}

	public BasisNextidDaoImpl<PenaltyVerificationDtl> getPenaltyVerificationDtlDAO() {
		return penaltyVerificationDtlDAO;
	}

	public void setPenaltyVerificationDtlDAO(
			BasisNextidDaoImpl<PenaltyVerificationDtl> penaltyVerificationDtlDAO) {
		this.penaltyVerificationDtlDAO = penaltyVerificationDtlDAO;
	}

	@Override
	public List<PenaltyVerificationHdr> getPenaltyVerificationHdrByExample(PenaltyVerificationHdr penaltyVerificationHdr) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(PenaltyVerificationHdr.class);
		if(penaltyVerificationHdr.getVerifyHdrSeqno() > 0)
		detachedCriteria.add(Restrictions.eq("verifyHdrSeqno", penaltyVerificationHdr.getVerifyHdrSeqno()));

		detachedCriteria.createAlias("verifyByUser", "verifyByUser", CriteriaSpecification.LEFT_JOIN);
		detachedCriteria.createAlias("createdUser", "createdUser", CriteriaSpecification.LEFT_JOIN);
		detachedCriteria.createAlias("updatedUser", "updatedUser", CriteriaSpecification.LEFT_JOIN);
		detachedCriteria.createAlias("penaltyVerificationDtls", "penaltyVerificationDtl", CriteriaSpecification.LEFT_JOIN)
		.createAlias("penaltyVerificationDtl.penaltyHdr", "penaltyHdr", CriteriaSpecification.LEFT_JOIN)
		.createAlias("penaltyHdr.penaltyIncident", "penaltyIncident", CriteriaSpecification.LEFT_JOIN);
		return getPenaltyVerificationHdrDAO().findByCriteria(detachedCriteria);
	}
	
	public List<String> getFacilityCode() {
		String qry = "select  facility_code from t_external_facilities  where  facility_type='HOS' ";
		Session session = getPenaltyVerificationHdrDAO().getSessionFactory().openSession();
		try {
			System.out.println(qry);
			NativeQuery query = session.createNativeQuery(qry.toString());
			Object object = query.list().iterator().next();
			System.out.println("--- " + object.getClass());
			return query.list();
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return null;
	}
	
	public Long getDimUserID(){
		String qry = "select USR_SEQ from T_SEC_USER where USR_LOGINNAME =  '"+PenaltyConstants.DMI_USER_LOGINNAME+"' ";
		Session session = getPenaltyVerificationHdrDAO().getSessionFactory().openSession();
		org.hibernate.query.Query query = session.createNativeQuery(qry.toString());
		Long dimUserSeqno = query.uniqueResult() != null ? ((BigDecimal) query.uniqueResult()).longValue() : null;
		session.close();
		return dimUserSeqno;
		
	}
	
	@Override 
	public List<PenaltyVerificationHdr> getPenaltyVerificationHdrsToSync(){
			DetachedCriteria detachedCriteria = DetachedCriteria.forClass(PenaltyVerificationHdr.class);
			detachedCriteria.add(Restrictions.in("status",new String[] {
					PenaltyConstants.PENALTY_HDR_STATUS_APPROVED, PenaltyConstants.PENALTY_HDR_STATUS_REJECTED }));
			detachedCriteria.setFetchMode("penaltyVerificationDtls", FetchMode.JOIN);
			detachedCriteria.setFetchMode("penaltyVerificationDtls.penaltyHdr", FetchMode.JOIN);
			detachedCriteria.setFetchMode("penaltyVerificationDtls.penaltyHdr.poHdr", FetchMode.JOIN);
			detachedCriteria.setFetchMode("penaltyVerificationDtls.penaltyHdr.penaltyDtls", FetchMode.JOIN);	
			detachedCriteria.setFetchMode("penaltyVerificationDtls.penaltyHdr.penaltyDtls.penaltyItems", FetchMode.JOIN);
			detachedCriteria.setFetchMode("penaltyVerificationDtls.penaltyHdr.penaltyDtls.penaltyItems.penaltyBatchs", FetchMode.JOIN);
			detachedCriteria.setFetchMode("penaltyPayments", FetchMode.JOIN);
			detachedCriteria.add(Restrictions.eq("sendFlag","N"));
			detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			return  getPenaltyVerificationHdrDAO().findByCriteria(detachedCriteria);
	}
	
	@Override
	public List<String> getPenaltyVerificationRejectList(String ptjCode) {
		//String qry = "SELECT  T_LPO_NO FROM T_PENALTY_VERIFICATION_HDR  WHERE T_STATUS ='3'" ; //  AND  T_PTJ_CODE='"+ptjCode+"' ";
		String qry = "select distinct (lpo_no) from t_penalty_hdr penaltyhdr  "
				+ " left join T_PENALTY_VERIFICATION_HDR vhdr on penaltyhdr.lpo_no=vhdr.t_lpo_no  "
				+ " where( used_for_vefiried='N' or T_STATUS ='3' )and    penaltyhdr.lpo_no is not null   "; 
		Session session = getPenaltyVerificationHdrDAO().getSessionFactory().openSession();
		try {
			System.out.println(qry);
			org.hibernate.query.Query query = session.createNativeQuery(qry.toString());
			return query.list();
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return null;
	}

	@Override
	public List<String> getPenaltyVerificationTrxRejList(String ptjCode) {
		String qry = "SELECT  T_TRANSACTION_NUMBER FROM T_PENALTY_VERIFICATION_HDR  WHERE T_STATUS='3' "; // AND  T_PTJ_CODE='"+ ptjCode + "' ";
		Session session = getPenaltyVerificationHdrDAO().getSessionFactory().openSession();
		try {
			System.out.println(qry);
			org.hibernate.query.Query query = session.createNativeQuery(qry.toString());
			return query.list();
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return null;
	}
}
