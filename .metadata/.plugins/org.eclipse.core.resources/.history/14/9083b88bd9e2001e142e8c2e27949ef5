package my.com.cmg.iwp.maintenance.service.impl;

import java.util.Collection;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.VoteActivity;
import my.com.cmg.iwp.maintenance.service.VoteActivityService;
@Service
public class VoteActivityServiceImpl implements VoteActivityService {
	private BasisNextidDaoImpl<VoteActivity> voteActivityDAO;

	public BasisNextidDaoImpl<VoteActivity> getVoteActivityDAO() {
		return voteActivityDAO;
	}

	public void setVoteActivityDAO(
			BasisNextidDaoImpl<VoteActivity> voteActivityDAO) {
		this.voteActivityDAO = voteActivityDAO;
	}

	@Override
	public void delete(VoteActivity anVoteActivity) {
		// TODO Auto-generated method stub
		voteActivityDAO.delete(anVoteActivity);
	}

	@Override
	public VoteActivity getNewVoteActivity() {
		// TODO Auto-generated method stub
		return new VoteActivity();
	}

	@Override
	public void saveOrUpdate(VoteActivity anVoteActivity) {

		voteActivityDAO.saveOrUpdate(anVoteActivity);
	}

	@Override
	public Collection<VoteActivity> getAllVoteActivity() {

		return voteActivityDAO.loadAll(VoteActivity.class);
	}

	@Override
	public VoteActivity getVoteactivity(String voteActivityCode) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(VoteActivity.class);
		criteria.add(Restrictions.eq("activityCode", voteActivityCode));
		return voteActivityDAO.findByCriteria(criteria).get(0);
	}

	@Override
	public VoteActivity findByVoteActivityCode(String voteActivityCode) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(VoteActivity.class);
		criteria.add(Restrictions.eq("activityCode", voteActivityCode));
		return DataAccessUtils.uniqueResult(voteActivityDAO
				.findByCriteria(criteria));
	}
}
