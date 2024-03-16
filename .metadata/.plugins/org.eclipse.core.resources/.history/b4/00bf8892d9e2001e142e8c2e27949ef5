package my.com.cmg.iwp.maintenance.service;

import java.util.Date;
import java.util.List;

import my.com.cmg.iwp.maintenance.model.BudgetMovement;
import my.com.cmg.iwp.maintenance.model.VoteCode;

public interface VoteSummaryService {
	
	List<VoteCode> getVoteCode();
	List<VoteCode> getVoteCode(long voteSeqNo);
	List<BudgetMovement> getBudgetmovement(Date currentYearStartDate);
	List<BudgetMovement> getBudgetmovement(long voteSeqNo,Date currentYearStartDate);

	@SuppressWarnings("rawtypes")
	List getVoteObjectNoList(String string, String string2);
	List<VoteCode> getVoteCodeList(String value);

}
