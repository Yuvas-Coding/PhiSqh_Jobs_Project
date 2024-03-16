package my.com.cmg.iwp.maintenance.adjustment.service;

import java.util.List;

import my.com.cmg.iwp.backend.model.TaskLists;
import my.com.cmg.iwp.maintenance.model.BudgetMovement;
import my.com.cmg.iwp.maintenance.model.CBMaster;
import my.com.cmg.iwp.maintenance.model.NePVote;
import my.com.cmg.iwp.maintenance.model.SecUser;
import my.com.cmg.iwp.maintenance.model.VoteCode;
import my.com.cmg.iwp.maintenance.model.adjustment.BudgetAdjDtl;
import my.com.cmg.iwp.maintenance.model.adjustment.BudgetAdjHdr;

public interface BudgetAdjustmentService {
	
	BudgetAdjHdr getNewBudgetAdjHdr();
	BudgetAdjDtl getNewBudgetAdjDtl();
	
	void saveOrUpdate(BudgetAdjHdr anBudgetAdjHdr);

	List<BudgetAdjHdr> getAllBudgetAdjHdrs();
	
	SecUser getSecUserFetches(SecUser secUser);
	
	boolean isUserTypeBudget(SecUser secUser);
	BudgetAdjHdr findBudgetTransferByExample(BudgetAdjHdr anAdjHdr, VoteCode code, int year);
	void populateTaskLists(TaskLists taskList, SecUser user, BudgetAdjHdr budgetAdjHdr, boolean isNewRecord);
	List<CBMaster> getCurrentBudgetMaster(VoteCode voteCode, Integer year, String budgetType, String facilityCode,
			String ptjCode,NePVote nePVote);
	List<CBMaster> checkLock(VoteCode voteCode, Integer financialYear, String budgetType, String facilityCodeFrom,
			String ptjCode);
	void acquireORreleaseLock(long voteSeqno, Integer year, String budgetType, String facilityCode,
			String ptjCode, String lockReleased);
	CBMaster getCBMaster(VoteCode voteCode, Integer year, String budgetType, String facilityCode,
			String ptjCode);
	double getUnitPriceByPOAndItem(long itemSeqno, long poHdrSeqno);
	void saveOrUpdate(CBMaster cbMaster);
	void saveOrUpdate(BudgetMovement budgetMovement);
	CBMaster getCurrentBudgetMaster(Long cbMasterSeqno);
	
	boolean getBudgetHdrByLpoAndStatus(String lpoNo,String facilityCode, String... status);
	
	List<String> getLponoListByBudgetAdjustment(String facilityCode,Integer year, int month);
	boolean checkVoteAvailableByLPO(String lpoNo, CBMaster cbMaster, String facilityCode);
	BudgetAdjHdr getBudgetAdjustmentForTaskList(BudgetAdjHdr anAdjHdr);
	

}
