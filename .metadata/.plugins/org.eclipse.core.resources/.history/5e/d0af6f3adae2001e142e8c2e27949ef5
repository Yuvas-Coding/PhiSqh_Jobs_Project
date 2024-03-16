package my.com.cmg.iwp.maintenance.service;

import java.util.List;

import my.com.cmg.iwp.backend.model.TaskLists;
import my.com.cmg.iwp.maintenance.model.BudgetAllocationDeduction;
import my.com.cmg.iwp.maintenance.model.BudgetHistory;
import my.com.cmg.iwp.maintenance.model.BudgetMovement;
import my.com.cmg.iwp.maintenance.model.BudgetTransfer;
import my.com.cmg.iwp.maintenance.model.CBMaster;
import my.com.cmg.iwp.maintenance.model.ExternalFacility;
import my.com.cmg.iwp.maintenance.model.NePVote;
import my.com.cmg.iwp.maintenance.model.SecUser;
import my.com.cmg.iwp.maintenance.model.VoteCode;

public interface BudgetADTService {

	List<BudgetAllocationDeduction> findBudgetAllocationDeductionByExample(int year);

	List<BudgetTransfer> findBudgetTransferByExample(int year);

	List<BudgetAllocationDeduction> findBudgetAllocationDeductionByExample(BudgetAllocationDeduction soBudgetAllocationDeduction,int year);
			

	List<BudgetTransfer> findBudgetTransferByExample(BudgetTransfer soBudgetTransferhq,int year);

	CBMaster getNewCurrentBudgetMasterhq();

	List<ExternalFacility> getAllFacilityDetailsbyPtjCode(String facilityCode);

	List<BudgetTransfer> getBudjetTransferdetailsbyPtjCode(String ptjCode);

	List<ExternalFacility> findAllRequesterUnit();

	CBMaster getNewCurrentBudgetMaster();

	VoteCode getVoteCodeSeqNo(String votecode);

	void saveOrUpdatevotecode(VoteCode voteCode);

	void saveOrUpdateBudgetAllocation(
			BudgetAllocationDeduction allocationDeduction);

	List<BudgetMovement> findBudgetMovement(long voteSeqno);

	void saveOrUpdateBudgetMovement(BudgetMovement budgetMovementHq);

	void saveOrUpdateBudgetTransfer(BudgetTransfer budgettransferHq);

	List<BudgetAllocationDeduction> findBudgetAllocationDeductionByExampleWarrantType(
			String string, int year);

	List<CBMaster> findCurrentBudgetMasterByExampleBudgetType(String label, int year);

	void saveOrUpdateCurrentBudgetMaster(CBMaster currentBudgetMasterHq);

	List<ExternalFacility> getAllFacilityDetails(String ptjCode);

	public List<ExternalFacility> getFacilityNameByCode(String facilityCode);
	
	List<ExternalFacility> getAllFacilityDetailsForSave(String facilityCode);

	List<BudgetAllocationDeduction> getBudgetAllocationDeductionHqByClinic(
			String facilityCode, int year);

	List<BudgetAllocationDeduction> findBudgetAllocationDeductionByClinic(
			String facilityCode, int year);

	List<BudgetTransfer> findBudgetTransferByClinic(String facilityCode, int year);

	List<BudgetAllocationDeduction> findBudgetAllocationDeductionByExample1(
			BudgetAllocationDeduction soBudgetAllocationDeduction,
			VoteCode voteCode, String facilityCode, int year);

	List<BudgetTransfer> findBudgetTransferByExample1(
			BudgetTransfer soBudgetTransferhq, VoteCode voteCode,
			String facilityCode, int year);

	List<CBMaster> findByFacilityCode(BudgetAllocationDeduction allocationDeduction, VoteCode voteCodehq, int year);
	
	CBMaster findByCriteria(String facilityCode, VoteCode voteCode, Integer financialYear,String budgetType);

	List<BudgetAllocationDeduction> findBudgetAllocationDeductionByExample(BudgetAllocationDeduction allocationDeduction, VoteCode voteCodehq, int year);
	List<BudgetAllocationDeduction> findBudgetAllocationDeductionforStatus(BudgetAllocationDeduction allocationDeduction, VoteCode voteCodehq, int year);
	SecUser getUser(SecUser user);

	List<BudgetTransfer> findBudgetTransferByExample(BudgetTransfer soBudgetTransfer, VoteCode soVoteCode, int year);

	CBMaster getCBMaster(VoteCode voteCode,Integer year,String budgetType,String facilityCode,String ptjCode) ;
	
	void populateTaskLists(TaskLists taskLists,SecUser secUser,Object objectADT,boolean isNewRecord);

	CBMaster getCBMaster(String votecode, Integer financialYear, String budgetType, String facilityCode,String ptjCode, NePVote nePVote);
	
	boolean checkForUniqueWarrantNo(BudgetAllocationDeduction soBudgetAllocationDeduction, int year);

	List<BudgetAllocationDeduction> getWarrantAmt(CBMaster cbMaster,String warrantType, Integer year);
	
	List<Double> getAdditionalAmt(long voteSeqno, int financialYear,String budgetType);

	BudgetHistory getBudgetHistory(String voteCode, int year, String budgetType);

	Object getBudgetAllocationDeductionBySeqNo(Long allocationDeductSeqNo);

	Object getBudgetTransferBySeqNo(Long transferSeqNo);

	void updateOtherAllocation(BudgetAllocationDeduction allocationDeductionhq, CBMaster currentBudgetMasterHq);

	int getCBMasterWithBudgetMovement(long voteSeqno, Integer integer, String refCodeDesc, String string, String string2);
	
	List<CBMaster> checkLock(VoteCode voteCode, Integer year,
			String budgetType, String facilityCode, String ptjCode);

	void acquireORreleaseLock(long voteSeqNo, Integer year, String budgetType,
			String facilityCode, String ptjCode, String lockValue);

	List<CBMaster> getCurrentBudgetMaster(VoteCode voteCode, Integer year, String budgetType, String facilityCode,
			String ptjCode);

	List getCBMasterSeqnoByFacility(Integer financialYear, String facilityCode);

	List getCBMasterSeqnoByFacilitys(int financialYear, String facilityCode);

	CBMaster getCbMasterBySeqno(Long cbSeqno);

	ExternalFacility getExternalFacilityByFacilityCode(String facilityCode);

	List getAllCBMasterByBdgtMovement(Integer financialYear, String facilityCode);
	
	List<BudgetAllocationDeduction> findBudgetAllocationDeduction(BudgetAllocationDeduction allocationDeduction, VoteCode voteCodehq, int year);
	
	List<BudgetTransfer> findBudgetTransfer(BudgetTransfer soBudgetTransfer, VoteCode soVoteCode, int year);

	CBMaster getCBMasterByVote(VoteCode voteCode, Integer year,
			String budgetType, String facilityCode, String ptjCode);

	BudgetTransfer getBudgetTransferByTransferNo(String transferNo);


}
