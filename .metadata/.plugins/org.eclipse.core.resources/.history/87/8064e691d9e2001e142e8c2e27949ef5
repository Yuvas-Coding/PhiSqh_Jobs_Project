package my.com.cmg.iwp.maintenance.service;

import java.util.List;
import java.util.Map;

import my.com.cmg.iwp.maintenance.model.NePVote;


public interface NePVoteService {
	
	List<NePVote> getVoteList();

	void saveOrUpdate(NePVote nePVote);
	
	List<NePVote> findByVote(Map<Object, Object> map);
	
	List<NePVote> getActiveAllowVoteList();

	List<NePVote> findActiveAllowByList(List<NePVote> nePProjectList);
	
	NePVote getNewNePVote();

	List<NePVote> getDefaultNepVote();

	boolean getdefaultvlue();
}
