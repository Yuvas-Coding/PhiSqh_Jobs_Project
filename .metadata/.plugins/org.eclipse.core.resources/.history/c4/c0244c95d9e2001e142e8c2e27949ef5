package my.com.cmg.iwp.backend.service.inventory.penalty.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.backend.model.inventory.penalty.PenaltyPayment;
import my.com.cmg.iwp.backend.service.inventory.penalty.PenaltyPaymentService;
import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.webui.inventory.penalty.PenaltyConstants;
@Service
public class PenaltyPaymentServiceImpl<R> implements  PenaltyPaymentService{

	private BasisNextidDaoImpl<PenaltyPayment> penaltyPaymentDAO;
	
	@Override
	public void saveOrUpdate(PenaltyPayment penaltyPayment) {
		getPenaltyPaymentDAO().saveOrUpdate(penaltyPayment);
	}

	@Override
	public void saveOrUpdateAll(List<PenaltyPayment> penaltyPayments) {
		getPenaltyPaymentDAO().saveOrUpdateAll(penaltyPayments);
	}

	@Override
	public void delete(PenaltyPayment penaltyPayment) {
		getPenaltyPaymentDAO().delete(penaltyPayment);
	}

	@Override
	public void deleteAll(List<PenaltyPayment> penaltyPayments) {
		getPenaltyPaymentDAO().deleteAll(penaltyPayments);
	}

	@Override
	public List<PenaltyPayment> findByExample(PenaltyPayment penaltyPayment) {
		return getPenaltyPaymentDAO().findByExample(penaltyPayment);
	}

	public BasisNextidDaoImpl<PenaltyPayment> getPenaltyPaymentDAO() {
		return penaltyPaymentDAO;
	}

	public void setPenaltyPaymentDAO(BasisNextidDaoImpl<PenaltyPayment> penaltyPaymentDAO) {
		this.penaltyPaymentDAO = penaltyPaymentDAO;
	}

	@Override
	public List<PenaltyPayment> getPenaltyPaymentByExample(PenaltyPayment examplePenaltyPayment) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(PenaltyPayment.class);
		if(examplePenaltyPayment.getPenaltyPaymentSeqno() > 0 ){
			detachedCriteria.add(Restrictions.eq("penaltyPaymentSeqno", examplePenaltyPayment.getPenaltyPaymentSeqno()));
		}
		if(examplePenaltyPayment.getVerifyHdrSeqno() != null && examplePenaltyPayment.getVerifyHdrSeqno() > 0){
			detachedCriteria.add(Restrictions.eq("verifyHdrSeqno", examplePenaltyPayment.getVerifyHdrSeqno()));
		}
		detachedCriteria.setFetchMode("penaltyVerificationHdr", FetchMode.JOIN);
		return getPenaltyPaymentDAO().findByCriteria(detachedCriteria);
	}

	@Override
	public List<PenaltyPayment> getPenaltyPaymentHdrsToSync() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(PenaltyPayment.class);
		detachedCriteria.add(Restrictions.in("status",new String[] {
				PenaltyConstants.PENALTY_HDR_STATUS_APPROVED, PenaltyConstants.PENALTY_HDR_STATUS_REJECTED }));
		detachedCriteria.setFetchMode("penaltyVerificationHdr", FetchMode.JOIN);
		detachedCriteria.setFetchMode("penaltyVerificationHdr.penaltyVerificationDtls", FetchMode.JOIN);
		detachedCriteria.setFetchMode("penaltyVerificationHdr.penaltyPayments", FetchMode.JOIN);
		detachedCriteria.setFetchMode("penaltyVerificationHdr.penaltyVerificationDtls.penaltyHdr", FetchMode.JOIN);
		detachedCriteria.setFetchMode("penaltyVerificationHdr.penaltyVerificationDtls.penaltyHdr.poHdr", FetchMode.JOIN);
		
		detachedCriteria.setFetchMode("penaltyVerificationHdr.penaltyVerificationDtls.penaltyHdr.penaltyDtls", FetchMode.JOIN);	
		detachedCriteria.setFetchMode("penaltyVerificationHdr.penaltyVerificationDtls.penaltyHdr.penaltyDtls.penaltyItems", FetchMode.JOIN);
		detachedCriteria.setFetchMode("penaltyVerificationHdr.penaltyVerificationDtls.penaltyHdr.penaltyDtls.penaltyItems.penaltyBatchs", FetchMode.JOIN);
		detachedCriteria.add(Restrictions.eq("sendFlag","N"));
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return  getPenaltyPaymentDAO().findByCriteria(detachedCriteria);
	}
	public List<String> getPenaltyPaymentRejectList() {
		String qry = "SELECT distinct(VERIFY_HDR_SEQNO) from T_PENALTY_PAYMENT where   VERIFY_HDR_SEQNO is not null and status in('0','1','2') " ;
		
		Session session = getPenaltyPaymentDAO().getSessionFactory().openSession();
		try {
			System.out.println(qry);
			org.hibernate.query.Query<R> query = session.createNativeQuery(qry.toString());
			return (List<String>) query.list();
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
