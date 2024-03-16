package my.com.cmg.iwp.maintenance.service;

import my.com.cmg.iwp.maintenance.model.VoteObjAccounts;
import my.com.cmg.iwp.maintenance.model.VoteObject;

public interface VoteObjectService {

	void delete(VoteObject anVoteObject);

	void saveOrUpdate(VoteObject anVoteObject);

	VoteObject getNewVoteObject();

	VoteObject getVoteObject(String voteObjectCode);

	VoteObject findByVoteObjectCode(String objCode);
	
	void saveOrUpdate(VoteObjAccounts voteObjAccounts);

}
