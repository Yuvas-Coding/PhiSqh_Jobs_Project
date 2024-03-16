package my.com.cmg.iwp.maintenance.service.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.VoteObjAccounts;
import my.com.cmg.iwp.maintenance.model.VoteObject;
import my.com.cmg.iwp.maintenance.service.VoteObjectService;
@Service
public class VoteObjectServiceImpl implements VoteObjectService {
	private BasisNextidDaoImpl<VoteObject> voteObjectDAO;
	private BasisNextidDaoImpl generalDAO;

	public BasisNextidDaoImpl<VoteObject> getVoteObjectDAO() {
		return voteObjectDAO;
	}

	public void setVoteObjectDAO(BasisNextidDaoImpl<VoteObject> voteObjectDAO) {
		this.voteObjectDAO = voteObjectDAO;
	}
	
	public BasisNextidDaoImpl getGeneralDAO() {
		return generalDAO;
	}

	public void setGeneralDAO(BasisNextidDaoImpl generalDAO) {
		this.generalDAO = generalDAO;
	}

	@Override
	public void saveOrUpdate(VoteObject anVoteObject) {
		// TODO Auto-generated method stub
		voteObjectDAO.saveOrUpdate(anVoteObject);

	}

	@Override
	public void delete(VoteObject anVoteObject) {
		// TODO Auto-generated method stub
		voteObjectDAO.delete(anVoteObject);

	}

	@Override
	public VoteObject getNewVoteObject() {
		// TODO Auto-generated method stub
		return new VoteObject();
	}

	@Override
	public VoteObject getVoteObject(String Obj_code) {
		DetachedCriteria criteria = DetachedCriteria.forClass(VoteObject.class);
		criteria.add(Restrictions.eq("objectCode", Obj_code));
		return voteObjectDAO.findByCriteria(criteria).get(0);
	}

	@Override
	public VoteObject findByVoteObjectCode(String objCode) {
		DetachedCriteria criteria = DetachedCriteria.forClass(VoteObject.class);
		criteria.add(Restrictions.eq("objectCode", objCode));
		return DataAccessUtils.uniqueResult(voteObjectDAO
				.findByCriteria(criteria));
	}

	@Override
	public void saveOrUpdate(VoteObjAccounts voteObjAccounts) {
		generalDAO.saveOrUpdate(voteObjAccounts);
		
	}

}
