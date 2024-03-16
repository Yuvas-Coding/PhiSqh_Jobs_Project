package my.com.cmg.iwp.maintenance.service.impl;

import java.util.List;

import org.hibernate.FetchMode;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.VoteSubActivity;
import my.com.cmg.iwp.maintenance.service.VoteSubActivityService;
@Service
public class VoteSubActivityServiceImpl implements VoteSubActivityService {
	private BasisNextidDaoImpl<VoteSubActivity> voteSubActivityDAO;

	@Override
	public VoteSubActivity getNewVoteSubActivity() {
		return new VoteSubActivity();
	}

	@Override
	public void delete(VoteSubActivity anVoteSubActivity) {
		voteSubActivityDAO.delete(anVoteSubActivity);

	}

	@Override
	public void saveOrUpdate(VoteSubActivity anVoteSubActivity) {
		voteSubActivityDAO.saveOrUpdate(anVoteSubActivity);

	}

	public void setVoteSubActivityDAO(
			BasisNextidDaoImpl<VoteSubActivity> voteSubActivityDAO) {
		this.voteSubActivityDAO = voteSubActivityDAO;
	}

	public BasisNextidDaoImpl<VoteSubActivity> getVoteSubActivityDAO() {
		return voteSubActivityDAO;
	}

	@Override
	public List<VoteSubActivity> getAllSubActivities() {

		return voteSubActivityDAO.loadAll(VoteSubActivity.class);
	}

	@Override
	public VoteSubActivity findByVoteSubActivityCode(
			String voteSubactivityCode, long voteActivitySeqNo) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(VoteSubActivity.class);
		criteria.setFetchMode("voteActivity", FetchMode.JOIN);
		Criterion criterion1 = Restrictions.eq("voteActivity.activitySeqno",
				voteActivitySeqNo);
		Criterion criterion2 = Restrictions.eq("subActivityCode",
				voteSubactivityCode);
		criteria.add(Restrictions.and(criterion1, criterion2));
		return DataAccessUtils.uniqueResult(voteSubActivityDAO
				.findByCriteria(criteria));
	}

	@Override
	public VoteSubActivity findByVoteSubActivityCode(String voteSubactivityCode) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(VoteSubActivity.class);
		criteria.add(Restrictions.eq("subActivityCode", voteSubactivityCode));
		return DataAccessUtils.uniqueResult(voteSubActivityDAO
				.findByCriteria(criteria));
	}

	@Override
	public VoteSubActivity getVoteSubActivity(String voteSubActivity_code) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(VoteSubActivity.class);
		criteria.add(Restrictions.eq("subActivityCode", voteSubActivity_code));
		return voteSubActivityDAO.findByCriteria(criteria).get(0);
	}

}
