package my.com.cmg.iwp.maintenance.service.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BudgetMovementHqDAOImpl;
import my.com.cmg.iwp.maintenance.dao.impl.VoteCodeDAOImpl;
import my.com.cmg.iwp.maintenance.dao.impl.VoteObjectDAOImpl;
import my.com.cmg.iwp.maintenance.dao.impl.VoteSummaryDAOImpl;
import my.com.cmg.iwp.maintenance.model.BudgetMovement;
import my.com.cmg.iwp.maintenance.model.VoteCode;
import my.com.cmg.iwp.maintenance.model.VoteObject;
import my.com.cmg.iwp.maintenance.service.VoteSummaryService;
@Service
public class VoteSummaryServiceImpl implements VoteSummaryService {
	
	private VoteSummaryDAOImpl voteSummaryDAOImpl;
	private VoteCodeDAOImpl voteCodeDAOImpl;
	private BudgetMovementHqDAOImpl movementHqDAOImpl;
	private VoteObjectDAOImpl voteObjectDAO;
	
	public VoteObjectDAOImpl getVoteObjectDAO() {
		return voteObjectDAO;
	}

	public void setVoteObjectDAO(VoteObjectDAOImpl voteObjectDAO) {
		this.voteObjectDAO = voteObjectDAO;
	}

	@Override
	public List<VoteCode> getVoteCode() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(VoteCode.class);
		return voteCodeDAOImpl.findByCriteria(detachedCriteria);
	}

	@Override
	public List<BudgetMovement> getBudgetmovement(long voteSeqNo,Date currentYearStartDate) {
		
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(BudgetMovement.class);
		detachedCriteria.add(Restrictions.eq("voteSeqno", voteSeqNo));
		detachedCriteria.add(Restrictions.ge("updatedDate",currentYearStartDate));
		detachedCriteria.addOrder(Order.desc("updatedDate"));
		return movementHqDAOImpl.findByCriteria(detachedCriteria);
	}

	@Override
	public List<VoteCode> getVoteCode(long voteSeqNo) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(VoteCode.class);
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		detachedCriteria.add(Restrictions.eq("voteSeqno", Long.valueOf(voteSeqNo)));
		return voteCodeDAOImpl.findByCriteria(detachedCriteria);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BudgetMovement> getBudgetmovement(Date currentYearStartDate) {		
		Session session = voteSummaryDAOImpl.getSessionFactory().openSession();
		String query =  " select vote_seqno,sum(pending_amount) as pending_amount_total,"
					+ "	sum(liability_amount) as liability_amount_total,"
					+ " sum(utilised_amount) as utilised_amount_total,( select bd1.balance from t_budget_movement bd1 where bd1.vote_seqno= ph_budget_movement.vote_seqno order by updated_date DESC limit 1)as balance"
					+ " from t_budget_movement"
					+ " where updated_date >='"+currentYearStartDate+"'"
					+ " group by vote_seqno order by ph_budget_movement.vote_seqno";
					
		System.out.println("---------------------------->"+query);
		List<BudgetMovement> listBudgetMovement = session.createSQLQuery(query).list();
		session.close();
		return listBudgetMovement;
	}
	
	@SuppressWarnings("rawtypes")
	public List getVoteObjectNoList(String string,String string2) {

		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(VoteObject.class);
		detachedCriteria.add(Restrictions.eq("activeFlag", true));
		if(string!=null){
			detachedCriteria.add(Restrictions.ilike("objectDesc", "%"+string+"%"));
		}
		if(string2!=null){
			detachedCriteria.add(Restrictions.ilike("objectCode", "%"+string2+"%"));
		}
		return voteObjectDAO.findByCriteria(detachedCriteria);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<VoteCode> getVoteCodeList(String value) {
		Session sessionBudget = voteSummaryDAOImpl.getSessionFactory().openSession();

		Criteria recExtHdrObjD	= sessionBudget.createCriteria(VoteCode.class);
		recExtHdrObjD.add(Restrictions.ilike("voteObjectCode", "%"+value+"%"));
		
		List<VoteCode> voteCodeList =recExtHdrObjD.list();
		sessionBudget.close();
		
		return voteCodeList;
	}

	public VoteCodeDAOImpl getVoteCodeDAOImpl() {
		return voteCodeDAOImpl;
	}

	public void setVoteCodeDAOImpl(VoteCodeDAOImpl voteCodeDAOImpl) {
		this.voteCodeDAOImpl = voteCodeDAOImpl;
	}

	public BudgetMovementHqDAOImpl getMovementHqDAOImpl() {
		return movementHqDAOImpl;
	}

	public void setMovementHqDAOImpl(BudgetMovementHqDAOImpl movementHqDAOImpl) {
		this.movementHqDAOImpl = movementHqDAOImpl;
	}

	public VoteSummaryDAOImpl getVoteSummaryDAOImpl() {
		return voteSummaryDAOImpl;
	}

	public void setVoteSummaryDAOImpl(VoteSummaryDAOImpl voteSummaryDAOImpl) {
		this.voteSummaryDAOImpl = voteSummaryDAOImpl;
	}

	
	
}
