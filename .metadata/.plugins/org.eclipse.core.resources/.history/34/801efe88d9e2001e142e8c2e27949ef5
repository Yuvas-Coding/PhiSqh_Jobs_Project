package my.com.cmg.iwp.maintenance.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.management.Query;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;
import org.zkoss.util.resource.Labels;

import my.com.cmg.iwp.backend.model.TaskLists;
import my.com.cmg.iwp.backend.service.TaskListService;
import my.com.cmg.iwp.maintenance.dao.impl.BudgetADTDAOImpl;
import my.com.cmg.iwp.maintenance.model.BudgetAllocationDeduction;
import my.com.cmg.iwp.maintenance.model.BudgetHistory;
import my.com.cmg.iwp.maintenance.model.BudgetMovement;
import my.com.cmg.iwp.maintenance.model.BudgetTransfer;
import my.com.cmg.iwp.maintenance.model.CBMaster;
import my.com.cmg.iwp.maintenance.model.ExternalFacility;
import my.com.cmg.iwp.maintenance.model.NePVote;
import my.com.cmg.iwp.maintenance.model.RefCodes;
import my.com.cmg.iwp.maintenance.model.SecRole;
import my.com.cmg.iwp.maintenance.model.SecUser;
import my.com.cmg.iwp.maintenance.model.VoteCode;
import my.com.cmg.iwp.maintenance.service.BudgetADTService;
import my.com.cmg.iwp.maintenance.service.ExternalFacilityService;
import my.com.cmg.iwp.maintenance.service.RefCodesService;
import my.com.cmg.iwp.maintenance.service.SecRoleService;
import my.com.cmg.iwp.webui.budget.InventoryConstant;
import my.com.cmg.iwp.webui.constant.HQConstants;
import my.com.cmg.iwp.webui.constant.RefCodeConstant;
import my.com.cmg.phis.util.constant.InventoryConstants;
@Service
public class BudgetADTServiceImpl implements BudgetADTService {
	private BudgetADTDAOImpl budgetADTdao;
	private RefCodesService refCodesService;
	private TaskListService taskListService;
	private SecRoleService secRoleService;
	private ExternalFacilityService externalFacilityService;

	@Override
	public List<ExternalFacility> getAllFacilityDetailsbyPtjCode(String facilityCode) {
		String query = "select all externalFacilityhaq "
				+ "from ExternalFacility externalFacilityhaq   "
				+ "where externalFacilityhaq.facilityCode=" + "'"
				+ facilityCode + "'";
		return budgetADTdao.find(query);
	}

	@Override
	public List<BudgetTransfer> getBudjetTransferdetailsbyPtjCode(String ptjCode) {
		String query = "select all budgetTransferDetailshq "
				+ " from BudgetTransfer budgetTransferDetailshq   "
				+ " join fetch budgetTransferDetailshq.externalFacility as ef"
				+ " where ef.facilityCode=" + "'" + ptjCode + "'";
		return budgetADTdao.find(query);
	}

	@Override
	public List<BudgetAllocationDeduction> findBudgetAllocationDeductionByExample(int year) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(BudgetAllocationDeduction.class);
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		detachedCriteria.setFetchMode("currentBudgetMasterHq", FetchMode.JOIN);
		detachedCriteria.setFetchMode("currentBudgetMasterHq.voteCode",FetchMode.JOIN);
		detachedCriteria.add(Restrictions.eq("financialYear", year));
		detachedCriteria.addOrder(Property.forName("createdDate").desc());
		return budgetADTdao.findByCriteria(detachedCriteria);
	}

	@Override
	public List<BudgetTransfer> findBudgetTransferByExample(int year) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(BudgetTransfer.class);
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		detachedCriteria.setFetchMode("currentBudgetMasterByTransferFromSeqno",FetchMode.JOIN);
		detachedCriteria.setFetchMode("currentBudgetMasterByTransferFromSeqno.voteCode",FetchMode.JOIN);
		detachedCriteria.setFetchMode("currentBudgetMasterByTransferToSeqno",FetchMode.JOIN);
		detachedCriteria.setFetchMode("currentBudgetMasterByTransferToSeqno.voteCode",FetchMode.JOIN);
		detachedCriteria.add(Restrictions.eq("financialYear", year));
		detachedCriteria.addOrder(Property.forName("createdDate").desc());
		return budgetADTdao.findByCriteria(detachedCriteria);
	}

	@Override
	public List<BudgetAllocationDeduction> findBudgetAllocationDeductionByExample(BudgetAllocationDeduction soBudgetAllocationDeduction, int year) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(BudgetAllocationDeduction.class);
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		detachedCriteria.setFetchMode("currentBudgetMasterHq", FetchMode.JOIN);
		detachedCriteria.setFetchMode("currentBudgetMasterHq.voteCode",FetchMode.JOIN);

		if (soBudgetAllocationDeduction.getFacilityCode() != null) detachedCriteria.add(Restrictions.eq("facilityCode",soBudgetAllocationDeduction.getFacilityCode()));
		if (soBudgetAllocationDeduction.getWarrantNo() != null) detachedCriteria.add(Restrictions.eq("warrantNo",soBudgetAllocationDeduction.getWarrantNo()));
		if (soBudgetAllocationDeduction.getReferenceNo() != null) detachedCriteria.add(Restrictions.eq("referenceNo",soBudgetAllocationDeduction.getReferenceNo()));
		if (soBudgetAllocationDeduction.getTransactionType() != null && !soBudgetAllocationDeduction.getTransactionType().equals(InventoryConstant.listCombobox_TransactionType_All)) detachedCriteria.add(Restrictions.eq("transactionType",soBudgetAllocationDeduction.getTransactionType()));
		
		if (soBudgetAllocationDeduction.getAllocationDeductionNo() != null) detachedCriteria.add(Restrictions.ilike("allocationDeductionNo","%"+ soBudgetAllocationDeduction.getAllocationDeductionNo() + "%"));
		if (soBudgetAllocationDeduction.getVoteCode() != null && soBudgetAllocationDeduction.getVoteCode().getVoteSeqno() > 0) detachedCriteria.add(Restrictions.eq("voteCode",soBudgetAllocationDeduction.getVoteCode()));
		detachedCriteria.add(Restrictions.eq("financialYear",(soBudgetAllocationDeduction.getFinancialYear() != null ? soBudgetAllocationDeduction.getFinancialYear() : year)));
		
		if (soBudgetAllocationDeduction.getTransactionStatus() != null) detachedCriteria.add(Restrictions.eq("transactionStatus",soBudgetAllocationDeduction.getTransactionStatus()));
		if (soBudgetAllocationDeduction.getWarrantNo() != null && soBudgetAllocationDeduction.getWarrantType() != null && soBudgetAllocationDeduction.getAllocationDeductionNo() == null) {
			if (soBudgetAllocationDeduction.getWarrantType().equals("First")) {
				soBudgetAllocationDeduction.setWarrantType("Additional");
				detachedCriteria.add(Restrictions.eq("warrantType", soBudgetAllocationDeduction.getWarrantType()));
				detachedCriteria.add(Restrictions.eq("warrantNo",soBudgetAllocationDeduction.getWarrantNo()));
				soBudgetAllocationDeduction.setWarrantType("First");
			} else if (soBudgetAllocationDeduction.getWarrantType().equals("Additional")) {
				soBudgetAllocationDeduction.setWarrantType("First");
				detachedCriteria.add(Restrictions.eq("warrantType",soBudgetAllocationDeduction.getWarrantType()));
				detachedCriteria.add(Restrictions.eq("warrantNo",soBudgetAllocationDeduction.getWarrantNo()));
				soBudgetAllocationDeduction.setWarrantType("Additional");
			}
		}
		detachedCriteria.addOrder(Property.forName("createdDate").desc());
		return budgetADTdao.findByCriteria(detachedCriteria);
	}
	
	@Override
	public boolean checkForUniqueWarrantNo(BudgetAllocationDeduction soBudgetAllocationDeduction, int year) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(BudgetAllocationDeduction.class);
		String allocationDedNo = soBudgetAllocationDeduction.getAllocationDeductionNo();
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		detachedCriteria.setProjection(Projections.property("allocationDeductionNo"));
		detachedCriteria.setFetchMode("currentBudgetMasterHq", FetchMode.JOIN);
		detachedCriteria.setFetchMode("currentBudgetMasterHq.voteCode",FetchMode.JOIN);

		detachedCriteria.add(Restrictions.eq("facilityCode",soBudgetAllocationDeduction.getFacilityCode()));
		detachedCriteria.add(Restrictions.eq("warrantNo",soBudgetAllocationDeduction.getWarrantNo()));
		detachedCriteria.add(Restrictions.eq("voteCode",soBudgetAllocationDeduction.getVoteCode()));
		detachedCriteria.add(Restrictions.eq("budgetType",soBudgetAllocationDeduction.getBudgetType()));
		detachedCriteria.add(Restrictions.eq("financialYear",(soBudgetAllocationDeduction.getFinancialYear() != null ? soBudgetAllocationDeduction.getFinancialYear() : year)));
		detachedCriteria.add(Restrictions.not(Restrictions.eq("transactionStatus", InventoryConstants.BUDGET_STATUS.REJECT)));
		detachedCriteria.add(Restrictions.not(Restrictions.eq("transactionStatus", InventoryConstants.BUDGET_STATUS.CANCELLED)));
		if (allocationDedNo != null) detachedCriteria.add(Restrictions.eq("allocationDeductionNo",allocationDedNo));
		//if (soBudgetAllocationDeduction.getReferenceNo() != null) detachedCriteria.add(Restrictions.eq("referenceNo",soBudgetAllocationDeduction.getReferenceNo()));
		//if (soBudgetAllocationDeduction.getTransactionType() != null && !soBudgetAllocationDeduction.getTransactionType().equals(InventoryConstant.listCombobox_TransactionType_All)) detachedCriteria.add(Restrictions.eq("transactionType",soBudgetAllocationDeduction.getTransactionType()));
		
		//List<BudgetAllocationDeduction> bdgtAllDedList =  DataAccessUtils.uniqueResult(budgetADTdao.findByCriteria(detachedCriteria));
		List<BudgetAllocationDeduction> bdgtAllDedList =  budgetADTdao.findByCriteria(detachedCriteria);
		
		if(bdgtAllDedList != null && bdgtAllDedList.size() > 0) {
			if(allocationDedNo != null && bdgtAllDedList.size() == 1) return false;
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<BudgetTransfer> findBudgetTransferByExample(BudgetTransfer soBudgetTransferhq, int year) {

		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(BudgetTransfer.class);
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		detachedCriteria.setFetchMode("currentBudgetMasterByTransferFromSeqno",FetchMode.JOIN);
		detachedCriteria.setFetchMode("currentBudgetMasterByTransferFromSeqno.voteCode",FetchMode.JOIN);
		detachedCriteria.setFetchMode("currentBudgetMasterByTransferToSeqno",FetchMode.JOIN);
		detachedCriteria.setFetchMode("currentBudgetMasterByTransferToSeqno.voteCode",FetchMode.JOIN);
		detachedCriteria.add(Restrictions.eq("financialYear", year));

		if (soBudgetTransferhq.getFacilityCodeFrom() != null) detachedCriteria.add(Restrictions.eq("facilityCode",soBudgetTransferhq.getFacilityCodeFrom()));
		if (soBudgetTransferhq.getReferenceNo() != null) detachedCriteria.add(Restrictions.eq("referenceNo", soBudgetTransferhq.getReferenceNo()));
		if (soBudgetTransferhq.getTransferNo() != null) detachedCriteria.add(Restrictions.ilike("transferNo", "%" + soBudgetTransferhq.getTransferNo() + "%"));
		if (soBudgetTransferhq.getTransactionStatus() != null) detachedCriteria.add(Restrictions.ilike("transactionStatus", "%" + soBudgetTransferhq.getTransactionStatus() + "%"));
		if (soBudgetTransferhq.getVoteCode() != null) detachedCriteria.add(Restrictions.eq("voteCode", soBudgetTransferhq.getVoteCode()));
		
		detachedCriteria.addOrder(Property.forName("createdDate").desc());
		return budgetADTdao.findByCriteria(detachedCriteria);
	}

	@Override
	public CBMaster getNewCurrentBudgetMaster() { return new CBMaster(); }

	@Override
	public List<ExternalFacility> findAllRequesterUnit() {
		DetachedCriteria criteria = DetachedCriteria.forClass(ExternalFacility.class);
		criteria.setFetchMode("externalFacility", FetchMode.JOIN);
		criteria.addOrder(Order.asc("facilityCode"));
		return budgetADTdao.findByCriteria(criteria);
	}

	@Override
	public CBMaster getNewCurrentBudgetMasterhq() { 
		return new CBMaster(); 
	}

	@Override
	public VoteCode getVoteCodeSeqNo(String votecode) {
		VoteCode vCode = (VoteCode) budgetADTdao.find("from VoteCode where voteCode=" + "\'" + votecode + "\'").iterator().next();
		return vCode;
	}

	@Override
	public void saveOrUpdatevotecode(VoteCode voteCode) {
		budgetADTdao.saveOrUpdate(voteCode);
	}

	@Override
	public void saveOrUpdateBudgetAllocation(
			BudgetAllocationDeduction allocationDeduction) {
		budgetADTdao.saveOrUpdate(allocationDeduction);
	}

	@Override
	public List<BudgetMovement> findBudgetMovement(long voteSeqno) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(BudgetMovement.class);
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		detachedCriteria.add(Restrictions.eq("voteSeqno", voteSeqno));
		return budgetADTdao.findByCriteria(detachedCriteria);
	}

	@Override
	public void saveOrUpdateBudgetMovement(BudgetMovement budgetMovementHq) {
		budgetADTdao.saveOrUpdate(budgetMovementHq);
	}

	@Override
	public void saveOrUpdateBudgetTransfer(BudgetTransfer budgettransferHq) {
		budgetADTdao.saveOrUpdate(budgettransferHq);
	}

	@Override
	public List<BudgetAllocationDeduction> findBudgetAllocationDeductionByExampleWarrantType(
			String string, int year) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(BudgetAllocationDeduction.class);
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		detachedCriteria.setFetchMode("externalFacility", FetchMode.JOIN);
		detachedCriteria.setFetchMode("currentBudgetMasterHq", FetchMode.JOIN);
		detachedCriteria.setFetchMode("currentBudgetMasterHq.voteCode",FetchMode.JOIN);
		detachedCriteria.add(Restrictions.eq("financialYear", year));
		detachedCriteria.add(Restrictions.eq("warrantType", string));
		return budgetADTdao.findByCriteria(detachedCriteria);
	}

	@Override
	public List<CBMaster> findCurrentBudgetMasterByExampleBudgetType(String label, int year) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(CBMaster.class);
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		detachedCriteria.setFetchMode("externalFacility", FetchMode.JOIN);
		detachedCriteria.setFetchMode("voteCode", FetchMode.JOIN);
		detachedCriteria.add(Restrictions.eq("financialYear", year));
		detachedCriteria.add(Restrictions.eq("budgetType", label));
		return budgetADTdao.findByCriteria(detachedCriteria);
	}

	@Override
	public void saveOrUpdateCurrentBudgetMaster(CBMaster currentBudgetMasterHq) {
		budgetADTdao.saveOrUpdate(currentBudgetMasterHq);
	}

	@Override
	public List<ExternalFacility> getAllFacilityDetails(String facilityCode) {
		String query = "select distinct externalFacilityhaq "
				+ "from ExternalFacility externalFacilityhaq   "
				+ "where externalFacilityhaq.facilityCode=" + "'"
				+ facilityCode + "'";
		return budgetADTdao.find(query);
	}

	@Override
	public List<ExternalFacility> getAllFacilityDetailsForSave(String facilityCode) {
		String query = "select distinct externalFacilityhaq "
				+ "from ExternalFacility externalFacilityhaq   "
				+ "where externalFacilityhaq.facilityCode=" + "'"
				+ facilityCode + "'";
		return budgetADTdao.find(query);
	}

	@Override
	public List<BudgetAllocationDeduction> getBudgetAllocationDeductionHqByClinic(String facilityCode, int year) {
		String query = "select all budgetAllocationDeductionhq "
				+ " from BudgetAllocationDeduction budgetAllocationDeductionhq"
				+ " join fetch budgetAllocationDeductionhq.externalFacility as ef"
				+ " where ef.facilityCode=" + "'" + facilityCode + "'"
				+ "and budgetAllocationDeductionhq.financialYear=" + "'" + year
				+ "'";
		return budgetADTdao.find(query);
	}

	@Override
	public List<BudgetAllocationDeduction> findBudgetAllocationDeductionByClinic(String facilityCode, int year) {
		Date startDate = new Date();
		startDate.setMonth(1);
		startDate.setDate(1);

		Date endDate = new Date();
		endDate.setMonth(12);
		endDate.setDate(31);
		String query = "select all budgetAllocationDeductionhq"
				+ " from BudgetAllocationDeduction budgetAllocationDeductionhq"
				+ " join fetch budgetAllocationDeductionhq.currentBudgetMasterHq"
				+ " where budgetAllocationDeductionhq.facilityCode=" + "'"
				+ facilityCode + "'"
				+ "and budgetAllocationDeductionhq.financialYear=" + "'" + year
				+ "'"
		// + " and budgetAllocationDeductionhq.createdDate between " + "'"
		// + startDate + "'" + " and " + "'" + endDate + "'";
		;
		return budgetADTdao.find(query);

	}

	@Override
	public List<BudgetTransfer> findBudgetTransferByClinic(String facilityCode,int year) {
		Date startDate = new Date();
		startDate.setMonth(1);
		startDate.setDate(1);

		Date endDate = new Date();
		endDate.setMonth(12);
		endDate.setDate(31);
		String query = "select all budgetTransfer"
				+ " from BudgetTransfer budgetTransfer"
				+ " join fetch budgetTransfer.currentBudgetMasterByTransferFromSeqno as cbmf"
				+ " join fetch cbmf.voteCode as voteCode"
				+ " join fetch budgetTransfer.currentBudgetMasterByTransferToSeqno as cbmt"
				+ " join fetch cbmt.voteCode as voteCode"
				+ " where budgetTransfer.facilityCode=" + "'" + facilityCode
				+ "'" + "and cbmf.financialYear=" + "'" + year + "'"
		// + " and budgetTransfer.createdDate between " + "'"
		// + startDate + "'" + " and " + "'" + endDate + "'";
		;
		return budgetADTdao.find(query);
	}

	@Override
	public List<BudgetAllocationDeduction> findBudgetAllocationDeductionByExample1(BudgetAllocationDeduction soBudgetAllocationDeduction,VoteCode voteCode, String facilityCode, int year) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(BudgetAllocationDeduction.class, "bdt");
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		detachedCriteria.setFetchMode("currentBudgetMasterHq", FetchMode.JOIN);
		detachedCriteria.setFetchMode("currentBudgetMasterHq.voteCode",FetchMode.JOIN);
		detachedCriteria.setFetchMode("externalFacility", FetchMode.JOIN);
		detachedCriteria.createCriteria("externalFacility").add(Restrictions.eq("facilityCode", facilityCode));
		if (soBudgetAllocationDeduction.getWarrantNo() != null) detachedCriteria.add(Restrictions.eq("warrantNo",soBudgetAllocationDeduction.getWarrantNo()));
		if (soBudgetAllocationDeduction.getReferenceNo() != null) detachedCriteria.add(Restrictions.eq("referenceNo",soBudgetAllocationDeduction.getReferenceNo()));
		if (soBudgetAllocationDeduction.getTransactionType() != null) detachedCriteria.add(Restrictions.eq("transactionType",soBudgetAllocationDeduction.getTransactionType()));
		

		if (soBudgetAllocationDeduction.getAllocationDeductionNo() != null) detachedCriteria.add(Restrictions.ilike("allocationDeductionNo","%"+ soBudgetAllocationDeduction.getAllocationDeductionNo() + "%"));
		if (voteCode.getVoteCode() != null && soBudgetAllocationDeduction.getWarrantType() == null) {
			detachedCriteria.createAlias("bdt.currentBudgetMasterHq.voteCode","thechild");
			detachedCriteria.add(Restrictions.eq("thechild.voteCode",voteCode.getVoteCode()));
		}

		if (soBudgetAllocationDeduction.getCurrentBudgetMasterHq() != null) {
			detachedCriteria.createAlias("bdt.currentBudgetMasterHq","thechildcurrentBM");

			// if(soBudgetAllocationDeduction.getTransactionType().equals(InventoryConstant.listCombobox_TransactionType_Allocation.charAt(0))){
			detachedCriteria.add(Restrictions.eq("financialYear",soBudgetAllocationDeduction.getCurrentBudgetMasterHq().getFinancialYear() != null ? soBudgetAllocationDeduction.getCurrentBudgetMasterHq().getFinancialYear() : year));
			
			/*
			 * if (soBudgetAllocationDeduction.getCurrentBudgetMasterHq()
			 * .getTransactionStatus() != null) {
			 * detachedCriteria.add(Restrictions.eq(
			 * "thechildcurrentBM.transactionStatus",
			 * soBudgetAllocationDeduction.getCurrentBudgetMasterHq()
			 * .getTransactionStatus())); }
			 */
		}

		if (soBudgetAllocationDeduction.getWarrantNo() != null && soBudgetAllocationDeduction.getWarrantType() != null && soBudgetAllocationDeduction.getAllocationDeductionNo() == null) {

			if (soBudgetAllocationDeduction.getWarrantType().equals("First")) {
				soBudgetAllocationDeduction.setWarrantType("Additional");
				detachedCriteria.add(Restrictions.eq("warrantType",soBudgetAllocationDeduction.getWarrantType()));
				detachedCriteria.add(Restrictions.eq("warrantNo",soBudgetAllocationDeduction.getWarrantNo()));
				soBudgetAllocationDeduction.setWarrantType("First");
			} else if (soBudgetAllocationDeduction.getWarrantType().equals("Additional")) {
				soBudgetAllocationDeduction.setWarrantType("First");
				detachedCriteria.add(Restrictions.eq("warrantType",soBudgetAllocationDeduction.getWarrantType()));
				detachedCriteria.add(Restrictions.eq("warrantNo",soBudgetAllocationDeduction.getWarrantNo()));
				soBudgetAllocationDeduction.setWarrantType("Additional");
			}
		}

		if (soBudgetAllocationDeduction.getWarrantType() != null && voteCode.getVoteCode() != null) {
			if (soBudgetAllocationDeduction.getWarrantType().equals("First") || soBudgetAllocationDeduction.getWarrantType().equals("Additional")) {
				detachedCriteria.add(Restrictions.eq("warrantType", "First"));
				detachedCriteria.createAlias("bdt.currentBudgetMasterHq.voteCode", "thechild");
				detachedCriteria.add(Restrictions.eq("thechild.voteCode",voteCode.getVoteCode()));
			}
		}

		detachedCriteria.addOrder(Property.forName("createdDate").desc());

		return budgetADTdao.findByCriteria(detachedCriteria);
	}

	@Override
	public List<BudgetTransfer> findBudgetTransferByExample1(BudgetTransfer soBudgetTransferhq, VoteCode voteCode,String facilityCode, int year) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(BudgetTransfer.class, "btf");
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		detachedCriteria.setFetchMode("currentBudgetMasterByTransferFromSeqno",FetchMode.JOIN);
		detachedCriteria.setFetchMode("currentBudgetMasterByTransferFromSeqno.voteCode",FetchMode.JOIN);
		detachedCriteria.setFetchMode("currentBudgetMasterByTransferToSeqno",FetchMode.JOIN);
		detachedCriteria.setFetchMode("currentBudgetMasterByTransferToSeqno.voteCode",FetchMode.JOIN);
		detachedCriteria.setFetchMode("externalFacility", FetchMode.JOIN);
		detachedCriteria.createCriteria("externalFacility").add(Restrictions.eq("facilityCode", facilityCode));
		
		if (soBudgetTransferhq.getReferenceNo() != null) detachedCriteria.add(Restrictions.eq("referenceNo",soBudgetTransferhq.getReferenceNo()));
		if (soBudgetTransferhq.getTransferNo() != null) detachedCriteria.add(Restrictions.ilike("transferNo", "%"+ soBudgetTransferhq.getTransferNo() + "%"));
		
		if (voteCode.getVoteCode() != null || voteCode.getVoteName() != null) {
			detachedCriteria.createAlias("btf.currentBudgetMasterByTransferFromSeqno.voteCode","thechild1");
			detachedCriteria.add(Restrictions.eq("thechild1.voteCode",voteCode.getVoteCode()));
			detachedCriteria.createAlias("btf.currentBudgetMasterByTransferToSeqno.voteCode","thechild2");
			detachedCriteria.add(Restrictions.eq("thechild1.voteCode",voteCode.getVoteCode()));
		}

		detachedCriteria.add(Restrictions.eq("financialYear", year));

		if (soBudgetTransferhq.getCurrentBudgetMasterByTransferFromSeqno() != null) {
			detachedCriteria.createAlias("btf.currentBudgetMasterByTransferFromSeqno","thechildcurrentBM");

			/*
			 * if
			 * (soBudgetTransferhq.getCurrentBudgetMasterByTransferFromSeqno()
			 * .getTransactionStatus() != null) {
			 * detachedCriteria.add(Restrictions.eq(
			 * "thechildcurrentBM.transactionStatus", soBudgetTransferhq
			 * .getCurrentBudgetMasterByTransferFromSeqno()
			 * .getTransactionStatus())); }
			 */
		}

		detachedCriteria.addOrder(Property.forName("createdDate").desc());
		return budgetADTdao.findByCriteria(detachedCriteria);
	}

	@Override
	public List<ExternalFacility> getFacilityNameByCode(String facilityCode) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ExternalFacility.class);
		detachedCriteria.add(Restrictions.eq("facilityCode", facilityCode));
		detachedCriteria.setResultTransformer(DetachedCriteria.DISTINCT_ROOT_ENTITY);
		return budgetADTdao.findByCriteria(detachedCriteria);
	}

	@Override
	public List<CBMaster> findByFacilityCode(BudgetAllocationDeduction allocationDeduction, VoteCode voteCodehq,int year) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(CBMaster.class);
		detachedCriteria.setResultTransformer(DetachedCriteria.DISTINCT_ROOT_ENTITY);
		detachedCriteria.add(Restrictions.eq("facilityCode",allocationDeduction.getFacilityCode()));
		if (voteCodehq != null) detachedCriteria.add(Restrictions.eq("voteCode", voteCodehq));
		detachedCriteria.add(Restrictions.eq("financialYear",allocationDeduction.getFinancialYear()));
		return budgetADTdao.findByCriteria(detachedCriteria);
	}

	@Override
	public CBMaster findByCriteria(String facilityCode, VoteCode voteCode,Integer financialYear, String budgetType) {
		DetachedCriteria criteria = DetachedCriteria.forClass(CBMaster.class);
		criteria.setResultTransformer(DetachedCriteria.DISTINCT_ROOT_ENTITY);
		criteria.add(Restrictions.eq("voteCode", voteCode));
		if (financialYear != null) criteria.add(Restrictions.eq("financialYear", financialYear));
		if (facilityCode != null) criteria.add(Restrictions.eq("facilityCode", facilityCode));
		criteria.add(Restrictions.eq("budgetType", budgetType));
		return (CBMaster) DataAccessUtils.uniqueResult(getBudgetADTdao().findByCriteria(criteria));
	}

	@Override
	public List<BudgetAllocationDeduction> findBudgetAllocationDeductionByExample(BudgetAllocationDeduction soBudgetAllocationDeduction,VoteCode voteCode, int year) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(BudgetAllocationDeduction.class, "bdt");
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		detachedCriteria.setFetchMode("voteCode", FetchMode.JOIN);
		detachedCriteria.setFetchMode("currentBudgetMasterHq", FetchMode.JOIN);
		detachedCriteria.setFetchMode("currentBudgetMasterHq.voteCode",FetchMode.JOIN);

		if (soBudgetAllocationDeduction.getFacilityCode() != null) detachedCriteria.add(Restrictions.ilike("facilityCode", "%"+ soBudgetAllocationDeduction.getFacilityCode() + "%"));
		if (soBudgetAllocationDeduction.getWarrantNo() != null) detachedCriteria.add(Restrictions.ilike("warrantNo", "%"+ soBudgetAllocationDeduction.getWarrantNo() + "%"));
		if (soBudgetAllocationDeduction.getReferenceNo() != null) detachedCriteria.add(Restrictions.ilike("referenceNo", "%"+ soBudgetAllocationDeduction.getReferenceNo() + "%"));
		if (soBudgetAllocationDeduction.getTransactionType() != null) detachedCriteria.add(Restrictions.eq("transactionType", soBudgetAllocationDeduction.getTransactionType()));
		

		if (soBudgetAllocationDeduction.getAllocationDeductionNo() != null) detachedCriteria.add(Restrictions.ilike("allocationDeductionNo", "%"+ soBudgetAllocationDeduction.getAllocationDeductionNo() + "%"));
		if (soBudgetAllocationDeduction.getBudgetType() != null) detachedCriteria.add(Restrictions.eq("budgetType", soBudgetAllocationDeduction.getBudgetType()));
		

		if (voteCode.getVoteCode() != null && soBudgetAllocationDeduction.getWarrantType() == null) {
			detachedCriteria.createAlias("bdt.voteCode", "thechild");
			detachedCriteria.add(Restrictions.eq("thechild.voteCode",voteCode.getVoteCode()));
		}

		detachedCriteria.add(soBudgetAllocationDeduction.getFinancialYear() != null ? Restrictions.eq("financialYear", soBudgetAllocationDeduction.getFinancialYear()) : Restrictions.eq("financialYear", year));
		

		if (soBudgetAllocationDeduction.getTransactionStatus() != null) detachedCriteria.add(Restrictions.eq("transactionStatus",soBudgetAllocationDeduction.getTransactionStatus()));

		if (soBudgetAllocationDeduction.getWarrantNo() != null && soBudgetAllocationDeduction.getWarrantType() != null && soBudgetAllocationDeduction.getAllocationDeductionNo() == null) {
			if (soBudgetAllocationDeduction.getWarrantType().equals("First")) {
				soBudgetAllocationDeduction.setWarrantType("Additional");
				detachedCriteria.add(Restrictions.eq("warrantType",soBudgetAllocationDeduction.getWarrantType()));
				detachedCriteria.add(Restrictions.eq("warrantNo",soBudgetAllocationDeduction.getWarrantNo()));
				soBudgetAllocationDeduction.setWarrantType("First");
			} else if (soBudgetAllocationDeduction.getWarrantType().equals("Additional")) {
				soBudgetAllocationDeduction.setWarrantType("First");
				detachedCriteria.add(Restrictions.eq("warrantType",soBudgetAllocationDeduction.getWarrantType()));
				detachedCriteria.add(Restrictions.eq("warrantNo",soBudgetAllocationDeduction.getWarrantNo()));
				soBudgetAllocationDeduction.setWarrantType("Additional");
			}
		}

		if (voteCode.getVoteCode() != null) {
			if (soBudgetAllocationDeduction.getWarrantType() != null) 
				if (soBudgetAllocationDeduction.getWarrantType() .equals("First") || soBudgetAllocationDeduction.getWarrantType().equals("Additional")) {
					detachedCriteria.createAlias("bdt.voteCode", "thechild");
					detachedCriteria.add(Restrictions.eq("thechild.voteCode",voteCode.getVoteCode()));
					detachedCriteria.add(Restrictions.or(Restrictions.eq("warrantType", "First"),Restrictions.eq("warrantType", "Additional")));
				}
		}

		detachedCriteria.add(Restrictions.eq("activeFlag", 'A'));
		detachedCriteria.addOrder(Property.forName("createdDate").desc());
		return budgetADTdao.findByCriteria(detachedCriteria);
	}

	/* (non-Javadoc)
	 * @see my.com.cmg.iwp.maintenance.service.BudgetADTService#findBudgetAllocationDeductionforStatus(my.com.cmg.iwp.maintenance.model.BudgetAllocationDeduction, my.com.cmg.iwp.maintenance.model.VoteCode, int)
	 */
	public List<BudgetAllocationDeduction> findBudgetAllocationDeductionforStatus(BudgetAllocationDeduction soBudgetAllocationDeduction,VoteCode voteCodehq, int year) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(BudgetAllocationDeduction.class, "bdt");
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		detachedCriteria.setFetchMode("voteCode", FetchMode.JOIN);
		detachedCriteria.setFetchMode("currentBudgetMasterHq", FetchMode.JOIN);
		detachedCriteria.setFetchMode("currentBudgetMasterHq.voteCode",FetchMode.JOIN);
		detachedCriteria.add(Restrictions.eq("financialYear",soBudgetAllocationDeduction.getFinancialYear()));
		detachedCriteria.add(Restrictions.ne("transactionStatus",InventoryConstant.BUDGET_STATUS_RCVALUE_REJECTED));

		if (voteCodehq.getVoteCode() != null) {
			if (soBudgetAllocationDeduction.getWarrantType() != null)
				if (soBudgetAllocationDeduction.getWarrantType().equals("First") || soBudgetAllocationDeduction.getWarrantType().equals("Additional")) {
					detachedCriteria.createAlias("bdt.voteCode", "thechild");
					detachedCriteria.add(Restrictions.eq("thechild.voteCode",voteCodehq.getVoteCode()));
					detachedCriteria.add(Restrictions.eq("warrantType", "First"));
				}
		}
		return budgetADTdao.findByCriteria(detachedCriteria);
	}

	@Override
	public SecUser getUser(SecUser user) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SecUser.class, "secUser");
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		detachedCriteria.add(Restrictions.eq("id", user.getId()));
		detachedCriteria.createAlias("secUserroles", "secUserrole",CriteriaSpecification.LEFT_JOIN).createAlias("secUserrole.secRole", "secRole",CriteriaSpecification.LEFT_JOIN);

		// detachedCriteria.setFetchMode("secUserroles", FetchMode.JOIN);
		// detachedCriteria.createAlias("secUserroles","thechild");
		// detachedCriteria.setFetchMode("thechild.secRole", FetchMode.JOIN);

		// DetachedCriteria detachedCriteriaSecRole =
		// detachedCriteria.createCriteria("secUserroles");
		// detachedCriteriaSecRole.setFetchMode("secRole", FetchMode.JOIN);
		return (SecUser) budgetADTdao.findByCriteria(detachedCriteria).iterator().next();
	}

	@Override
	public List<BudgetTransfer> findBudgetTransferByExample(BudgetTransfer soBudgetTransfer, VoteCode voteCode, int year) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(BudgetTransfer.class, "btf");
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		detachedCriteria.setFetchMode("voteCode", FetchMode.JOIN);
		detachedCriteria.setFetchMode("toVoteCode", FetchMode.JOIN);
		detachedCriteria.setFetchMode("currentBudgetMasterByTransferFromSeqno",FetchMode.JOIN);
		detachedCriteria.setFetchMode("currentBudgetMasterByTransferFromSeqno.voteCode",FetchMode.JOIN);
		detachedCriteria.setFetchMode("currentBudgetMasterByTransferToSeqno",FetchMode.JOIN);
		detachedCriteria.setFetchMode("currentBudgetMasterByTransferToSeqno.voteCode",FetchMode.JOIN);

		if (soBudgetTransfer.getFacilityCodeFrom() != null) detachedCriteria.add(Restrictions.or(Restrictions.ilike("facilityCodeFrom", "%"+ soBudgetTransfer.getFacilityCodeFrom()+ "%"),Restrictions.ilike("facilityCodeTo", "%"+ soBudgetTransfer.getFacilityCodeFrom()+ "%")));
		if (soBudgetTransfer.getReferenceNo() != null) detachedCriteria.add(Restrictions.ilike("referenceNo", "%"+ soBudgetTransfer.getReferenceNo() + "%"));
		if (soBudgetTransfer.getTransferNo() != null) detachedCriteria.add(Restrictions.ilike("transferNo", "%"+ soBudgetTransfer.getTransferNo() + "%"));
		if (voteCode.getVoteCode() != null || voteCode.getVoteName() != null) {
			detachedCriteria.createAlias("btf.voteCode", "thechild1");
			detachedCriteria.createAlias("btf.toVoteCode", "thechild2");
			detachedCriteria.add(Restrictions.or(Restrictions.eq("thechild1.voteCode",voteCode.getVoteCode()),Restrictions.eq("thechild2.voteCode",voteCode.getVoteCode())));
		}

		if (soBudgetTransfer.getTransactionStatus() != null) detachedCriteria.add(Restrictions.eq("transactionStatus",soBudgetTransfer.getTransactionStatus()));
		if (soBudgetTransfer.getBudgetType() != null) detachedCriteria.createCriteria("currentBudgetMasterByTransferFromSeqno").add(Restrictions.eq("budgetType",soBudgetTransfer.getBudgetType()));
		

		detachedCriteria.add(soBudgetTransfer.getFinancialYear() != null ? Restrictions.eq("financialYear", soBudgetTransfer.getFinancialYear()) : Restrictions.eq("financialYear", year));
		detachedCriteria.add(Restrictions.eq("activeFlag", 'A'));
		detachedCriteria.addOrder(Property.forName("createdDate").desc());
		return budgetADTdao.findByCriteria(detachedCriteria);
	}

	@SuppressWarnings("unchecked")
	@Override
	public CBMaster getCBMaster(VoteCode voteCode, Integer year,String budgetType, String facilityCode, String ptjCode) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(CBMaster.class);
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		if (year != null) detachedCriteria.add(Restrictions.eq("financialYear", year));
		detachedCriteria.add(Restrictions.eq("voteCode", voteCode));
		detachedCriteria.add(Restrictions.eq("budgetType", budgetType));
		detachedCriteria.add(Restrictions.eq("facilityCode", facilityCode));
		detachedCriteria.add(Restrictions.eq("ptjCode", ptjCode));
		List<CBMaster> list = budgetADTdao.findByCriteria(detachedCriteria);
		return (list.size() > 0 ? list.iterator().next() : null);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public int getCBMasterWithBudgetMovement(long voteseqno, Integer year,String budgetType, String facilityCode, String ptjCode){
		Session session =getBudgetADTdao().getSessionFactory().openSession();
		Query query = session.createSQLQuery("select count(*) from t_budget_movement bgt where "
				+ "bgt.vote_seqno="+voteseqno+" and bgt.budget_type='"+budgetType+"' and bgt.financial_year="+year+" "
				+ "and bgt.source_ptj_code= '"+ptjCode+"' and warrant_type='First' and bgt.facility_code='"+facilityCode+"' ");
		List<Object> list = query.list();
		BigDecimal newValue = (BigDecimal) list.get(0);
		session.close();
		return newValue.intValue();
	}

	@Override
	public void populateTaskLists(TaskLists taskLists, SecUser user,Object objectADT, boolean isNewRecord) {
		if (taskLists != null) {
			if (objectADT instanceof BudgetAllocationDeduction) {
				BudgetAllocationDeduction allocationDeduction = (BudgetAllocationDeduction) objectADT;
				if (isNewRecord) {
					// IN CASE OF NEW CREATE
					taskLists.setTlTrxType(InventoryConstant.listCombobox_TransactionType_Allocation.equals(allocationDeduction.getTransactionType()) ? HQConstants.BUDGET_ADT_TRX_TYPE_ALLOCATION : HQConstants.BUDGET_ADT_TRX_TYPE_DEDUCT);
					taskLists.setTlDocSeqNo(allocationDeduction.getBudgetAllocationDeductionSeqno());
					taskLists.setTlTaskNo(allocationDeduction.getAllocationDeductionNo());
					taskLists.setTlDocNo(allocationDeduction.getAllocationDeductionNo());
					taskLists.setTlTrxSeqNo(allocationDeduction.getBudgetAllocationDeductionSeqno());
				} else {
					taskLists.setTlStatus(allocationDeduction.getTransactionStatus());
					taskLists.setTlTaskStatus(HQConstants.TASKLIST_STATUS_CLOSE);
					taskLists.setTlSentApprovalFlag(RefCodeConstant.BOOLEAN_TRUE);
					RefCodes refcode = getRefCodesService().getRefCodeByRcValue(InventoryConstants.LABLES.BUDGET_STATUS,allocationDeduction.getTransactionStatus());
					taskLists.setTlSubject(refcode.getRcDesc());
					taskLists.setTlTaskDone(InventoryConstant.TASK_DONE_YES);
					taskLists.setUpdatedDate(new Date());
					taskLists.setUpdatedBy(user.getId());
				}
			} else if (objectADT instanceof BudgetTransfer) {
				BudgetTransfer budgetTransfer = (BudgetTransfer) objectADT;
				if (isNewRecord) {
					// IN CASE OF NEW CREATE
					isNewRecord = true;
					taskLists.setTlTrxType(HQConstants.BUDGET_ADT_TRX_TYPE_VIREMENT);
					taskLists.setTlDocSeqNo(budgetTransfer.getBudgetTransferSeqno());
					taskLists.setTlTaskNo(budgetTransfer.getTransferNo());
					taskLists.setTlDocNo(budgetTransfer.getTransferNo());
					taskLists.setTlTrxSeqNo(budgetTransfer.getBudgetTransferSeqno());
				} else {
					taskLists.setTlStatus(budgetTransfer.getTransactionStatus());
					taskLists.setTlTaskStatus(HQConstants.TASKLIST_STATUS_CLOSE);
					taskLists.setTlSentApprovalFlag(RefCodeConstant.BOOLEAN_TRUE);
					RefCodes refcode = getRefCodesService().getRefCodeByRcValue(InventoryConstants.LABLES.BUDGET_STATUS,budgetTransfer.getTransactionStatus());
					taskLists.setTlSubject(refcode.getRcDesc());
					taskLists.setTlTaskDone(InventoryConstant.TASK_DONE_YES);
					taskLists.setUpdatedDate(new Date());
					taskLists.setUpdatedBy(user.getId());
				}
			}

			if (isNewRecord) {
				taskLists.setTlStatus(getRefCodesService().getRefCodeByRcValue(InventoryConstants.LABLES.BUDGET_STATUS,InventoryConstants.BUDGET_STATUS.PENDING_FOR_APPROVAL).getRcDesc());
				taskLists.setTlTransactionType(2188 + "");
				taskLists.setTlSubject(getRefCodesService().getRefCodeByRcValue(InventoryConstants.LABLES.BUDGET_STATUS,InventoryConstants.BUDGET_STATUS.PENDING_FOR_APPROVAL).getRcDesc());
				taskLists.setTlTaskStatus(HQConstants.TASKLIST_STATUS_OPEN);
				taskLists.setTlAcknowledge(InventoryConstant.TASK_ACKNOWLEDGE_YES.charValue());
				taskLists.setActiveFlag(RefCodeConstant.ACTIVE_FLAG_TRUE.toString());
				taskLists.setTlTaskDone(InventoryConstant.TASK_DONE_NO == null ? InventoryConstant.TASK_ACTIVE_NO.charValue() : InventoryConstant.TASK_DONE_NO.charValue());
				taskLists.setTlURL(Labels.getLabel("budgetADTDialogFilePath"));
				taskLists.setTlRecDateTime(new Date());
				taskLists.setTlSentApprovalFlag(RefCodeConstant.BOOLEAN_TRUE);
				taskLists.setTlEventType(getRefCodesService().getRefCodeByRcValue(InventoryConstants.LABLES.BUDGET_STATUS,InventoryConstants.BUDGET_STATUS.PENDING_FOR_APPROVAL).getRcDesc());
				taskLists.setTlSenUserId(String.valueOf(user.getId()));
				taskLists.setCreatedBy(user);
				taskLists.setCreatedDate(new Date());
				taskLists.setUpdatedBy(user.getId());
				taskLists.setUpdatedDate(new Date());
				SecRole secRole = getSecRoleService().getSimilarRoleByRoleName(HQConstants.PKD_CREATE);
				if(secRole!=null)
				taskLists.setTlRecRoleId(secRole.getId());
				List<ExternalFacility> list = getExternalFacilityService().getFacilityCodebySeqNo(user.getFacilitySeqno());
				if (list != null && list.size() > 0) {
					taskLists.setTlPTJCode(list.get(0).getPtjCode());
					taskLists.setTlFacilityCode(list.get(0).getFacilityCode());
				}
			}

			getTaskListService().saveOrUpdate(taskLists);
		}
	}

	@Override
	public CBMaster getCBMaster(String votecode, Integer financialYear,String budgetType, String facilityCode, String ptjCode,NePVote nePVote) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(CBMaster.class);
		detachedCriteria.setFetchMode("voteCode", FetchMode.JOIN);
		detachedCriteria.setFetchMode("voteCode.nePVote", FetchMode.JOIN);
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		detachedCriteria.add(Restrictions.eq("financialYear", financialYear));
		
		detachedCriteria.createCriteria("voteCode").add(Restrictions.eq("voteCode", votecode));
		detachedCriteria.add(Restrictions.eq("budgetType", budgetType));
		detachedCriteria.add(Restrictions.eq("facilityCode", facilityCode));
		detachedCriteria.add(Restrictions.eq("ptjCode", ptjCode));
		if(nePVote!=null){
			detachedCriteria.createCriteria("voteCode.nePVote").add(Restrictions.eq("voteSeqno", nePVote.getVoteSeqno()));
		}
		List<CBMaster> list = budgetADTdao.findByCriteria(detachedCriteria);
		return list.size() > 0  ? list.iterator().next() : null;
	}
	
	@SuppressWarnings({ "unchecked" })
	@Override
	public List<BudgetAllocationDeduction> getWarrantAmt(CBMaster cbMaster, String warrantType, Integer year) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(BudgetAllocationDeduction.class, "btd");
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		detachedCriteria.add(Restrictions.eq("financialYear",year));
		detachedCriteria.add(Restrictions.eq("currentBudgetMasterHq", cbMaster));
		detachedCriteria.add(Restrictions.eq("transactionStatus", InventoryConstants.BUDGET_STATUS.APPROVED));
		detachedCriteria.add(Restrictions.eq("warrantType", warrantType));
		
		return budgetADTdao.findByCriteria(detachedCriteria);
	}
	
	@Override
	public List<Double> getAdditionalAmt(long voteSeqno, int financialYear,String budgetType) {
	List<Double> additionAmtList = new ArrayList<Double>(); 
	// Modified by Ilango on 23.09.16 
		/*String str = "select (case when tot_all is not null then tot_all else 0 end + case when tot_in is not null then tot_in else 0 end) - (case when tot_ded is not null then tot_ded else 0 end + case when tot_out is not null then tot_out else 0 end) additional" +
				" from (select sum(ad.allocation_deduction_amount) tot_all, sum(ibt.TRANSFER_AMOUNT) tot_in, sum(dd.allocation_deduction_amount) tot_ded , sum(obt.TRANSFER_AMOUNT) tot_out, v.vote_code " +
				" from t_current_budget_master cbm " +
				" left join t_vote_codes v on v.vote_seqno = cbm.vote_seqno " +
				" left join t_budget_allocation_deduction ad on ad.cb_mstr_seqno = cbm.cb_mstr_seqno and ad.TRANSACTION_TYPE = 'Allocation' and ad.transaction_status = 'Approved' and ad.warrant_type = 'Additional' " +
				" left join t_budget_allocation_deduction dd on dd.cb_mstr_seqno = cbm.cb_mstr_seqno and dd.TRANSACTION_TYPE <> 'Allocation' and dd.transaction_status = 'Approved' " +
				" left join t_budget_transfer ibt on ibt.transfer_to_seqno = cbm.cb_mstr_seqno  and ibt.transaction_status = 'Approved' " +
				" left join t_budget_transfer obt on obt.transfer_from_seqno = cbm.cb_mstr_seqno  and obt.transaction_status = 'Approved' " +
				" where cbm.vote_seqno= "+voteSeqno+" and cbm.financial_year = "+financialYear+" group by v.vote_code, v.facility_code ) tab";*/
		String str = "select (sum(tot_all) + sum(tot_in)) - (sum(tot_ded) + sum(tot_out)) additional " +
				" from (select sum(ad.allocation_deduction_amount)tot_all, 0 tot_in, 0 tot_ded ,0 tot_out, cbm.vote_seqno" +
				" from t_current_budget_master cbm" +
				" left join t_budget_allocation_deduction ad on ad.cb_mstr_seqno = cbm.cb_mstr_seqno and ad.TRANSACTION_TYPE = 'Allocation' and ad.transaction_status = 'Approved' and ad.warrant_type = 'Additional'" +
				" where cbm.vote_seqno= "+ voteSeqno +" and cbm.financial_year = "+financialYear+" and cbm.budget_type ='"+budgetType+"'group by cbm.vote_seqno " +
				" union all " +
				" select 0 tot_all, sum(ibt.TRANSFER_AMOUNT) tot_in, 0 tot_ded ,0 tot_out, cbm.vote_seqno " +
				" from t_current_budget_master cbm" +
				" left join t_budget_transfer ibt on ibt.transfer_to_seqno = cbm.cb_mstr_seqno  and ibt.transaction_status = 'Approved'" +
				" where cbm.vote_seqno= "+ voteSeqno +" and cbm.financial_year = "+financialYear+" and cbm.budget_type ='"+budgetType+"'group by cbm.vote_seqno" +
				" union all" +
				" select 0 tot_all, 0 tot_in, sum(dd.allocation_deduction_amount) tot_ded ,0 tot_out, cbm.vote_seqno" +
				" from t_current_budget_master cbm" +
				" left join t_budget_allocation_deduction dd on dd.cb_mstr_seqno = cbm.cb_mstr_seqno and dd.TRANSACTION_TYPE <> 'Allocation' and dd.transaction_status = 'Approved'" +
				" where cbm.vote_seqno= "+ voteSeqno +" and cbm.financial_year = "+financialYear+" and cbm.budget_type ='"+budgetType+"'group by cbm.vote_seqno" +
				" union all" +
				" select 0 tot_all, 0 tot_in, 0 tot_ded ,sum(obt.TRANSFER_AMOUNT) tot_out, cbm.vote_seqno" +
				" from t_current_budget_master cbm" +
				" left join t_budget_transfer obt on obt.transfer_from_seqno = cbm.cb_mstr_seqno  and obt.transaction_status = 'Approved'" +
				" where cbm.vote_seqno= "+ voteSeqno +"and cbm.financial_year = "+financialYear+" and cbm.budget_type ='"+budgetType+"' group by cbm.vote_seqno) tab group by vote_seqno";
		System.out.println("QRY=== "+str);
		//String strQry=qry.toString();
		SessionFactory sessionFactory = budgetADTdao.getSessionFactory();
		Session session = sessionFactory.openSession();
		List objectArrayList = session.createSQLQuery(str).list();
		for (Object objects : objectArrayList) {
			additionAmtList.add(((BigDecimal) objects).doubleValue());
		}
		session.close();
		//sessionFactory.close();
		return additionAmtList;
	}
	
	@Override
	public BudgetHistory getBudgetHistory(String voteCode, int year, String budgetType) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(BudgetHistory.class, "bh");
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		detachedCriteria.setFetchMode("voteCode", FetchMode.JOIN);
		if (budgetType != null && !budgetType.isEmpty()) detachedCriteria.add(Restrictions.eq("budgetType", budgetType));
		detachedCriteria.add(Restrictions.eq("financialYear", new BigDecimal(year-1)));
		if (voteCode != null) {
			detachedCriteria.createAlias("bh.voteCode", "thechild");
			detachedCriteria.add(Restrictions.eq("thechild.voteCode", voteCode));
		}
		List<BudgetHistory> list = getBudgetADTdao().findByCriteria(detachedCriteria);
		
		return (list != null && list.size() > 0 ? (BudgetHistory)list.iterator().next() : null);
	}
	
	@Override
	public BudgetAllocationDeduction getBudgetAllocationDeductionBySeqNo(Long seqno) {
		DetachedCriteria criteria = DetachedCriteria.forClass(BudgetAllocationDeduction.class);
		criteria.add(Restrictions.eq("budgetAllocationDeductionSeqno", seqno));
		return (BudgetAllocationDeduction) DataAccessUtils.uniqueResult(budgetADTdao.findByCriteria(criteria));
	}
	
	@Override
	public BudgetTransfer getBudgetTransferBySeqNo(Long seqno) {
		DetachedCriteria criteria = DetachedCriteria.forClass(BudgetTransfer.class);
		criteria.add(Restrictions.eq("budgetTransferSeqno", seqno));
		return (BudgetTransfer) DataAccessUtils.uniqueResult(budgetADTdao.findByCriteria(criteria));
	}
	
	@Override
	public BudgetTransfer getBudgetTransferByTransferNo(String transferNo) {
		DetachedCriteria criteria = DetachedCriteria.forClass(BudgetTransfer.class);
		criteria.add(Restrictions.eq("transferNo", transferNo));
		return (BudgetTransfer) DataAccessUtils.uniqueResult(budgetADTdao.findByCriteria(criteria));
	}
	
	@Override
	public void updateOtherAllocation(BudgetAllocationDeduction allocationDeduction, CBMaster cbMaster) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(BudgetAllocationDeduction.class);
		detachedCriteria.add(Restrictions.eq("budgetType",cbMaster.getBudgetType()));
		detachedCriteria.add(Restrictions.eq("voteCode",cbMaster.getVoteCode()));
		detachedCriteria.add(Restrictions.eq("financialYear",allocationDeduction.getFinancialYear()));
		detachedCriteria.add(Restrictions.eq("facilityCode",allocationDeduction.getFacilityCode()));
		detachedCriteria.add(Restrictions.eq("ptj_Code",allocationDeduction.getPtj_Code()));
		detachedCriteria.add(Restrictions.ne("allocationDeductionNo",allocationDeduction.getAllocationDeductionNo()));
		detachedCriteria.add(Restrictions.isNull("currentBudgetMasterHq"));
		List<BudgetAllocationDeduction> bdgtAllDedList =  getBudgetADTdao().findByCriteria(detachedCriteria);
		for(BudgetAllocationDeduction budgetAllocationDeduction : bdgtAllDedList) {
			budgetAllocationDeduction.setCurrentBalance(cbMaster.getCurrentActualAmount());
			budgetAllocationDeduction.setNewBalance(budgetAllocationDeduction.getAllocationDeductionAmount()+cbMaster.getCurrentActualAmount());
			budgetAllocationDeduction.setCurrentBudgetMasterHq(cbMaster);
			budgetAllocationDeduction.setWarrantType(InventoryConstant.Radio_BudgetDialog_Additional_value);
			getBudgetADTdao().saveOrUpdate(budgetAllocationDeduction);
		}
	}
	
	
	@Override
	public List<CBMaster> checkLock(VoteCode voteCode, Integer year,String budgetType, String facilityCode, String ptjCode) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(CBMaster.class);
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		detachedCriteria.add(Restrictions.eq("voteCode", voteCode));
		detachedCriteria.add(Restrictions.eq("financialYear", year));
		detachedCriteria.add(Restrictions.eq("budgetType", budgetType));
		detachedCriteria.add(Restrictions.eq("facilityCode", facilityCode));
		detachedCriteria.add(Restrictions.eq("ptjCode", ptjCode));
		detachedCriteria.add(Restrictions.eq("parameter2", RefCodeConstant.LOCK_ACQUIRED));
		return budgetADTdao.findByCriteria(detachedCriteria);
	}
	
	@Override
	public List<CBMaster> getCurrentBudgetMaster(VoteCode voteCode, Integer year,String budgetType, String facilityCode, String ptjCode) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(CBMaster.class);
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		detachedCriteria.add(Restrictions.eq("voteCode", voteCode));
		detachedCriteria.add(Restrictions.eq("financialYear", year));
		if(budgetType!=null)
		detachedCriteria.add(Restrictions.eq("budgetType", budgetType));
		detachedCriteria.add(Restrictions.eq("facilityCode", facilityCode));
		detachedCriteria.add(Restrictions.eq("ptjCode", ptjCode));
		return budgetADTdao.findByCriteria(detachedCriteria);
	}
	
	
	@Override
	 public void acquireORreleaseLock(long voteSeqNo,Integer year,String budgetType, String facilityCode, String ptjCode,String lockValue) {
	  String query = new String();
	  Transaction txn = null;
	  query += "  update t_current_budget_master set parameter2='"+lockValue+"' where vote_seqno="+voteSeqNo+" and budget_type='"+budgetType+"' and "
	  		+ "financial_year="+year+" and source_ptj_code= '"+ptjCode+"' and facility_code='"+facilityCode+"' ";
	  try {
		  SessionFactory sessionFactory = budgetADTdao.getSessionFactory();
			Session session = sessionFactory.openSession();
			txn = session.beginTransaction();
			session.createSQLQuery(query).executeUpdate();
			txn.commit();
			session.close();
	  } catch (Exception e) {
	   e.printStackTrace();
	  }
	 }
	
	@Override
	public List getCBMasterSeqnoByFacility(Integer financialYear, String facilityCode) {
		List<Long> cbmastrSeqnoList=new ArrayList<Long>();
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(CBMaster.class);
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		detachedCriteria.add(Restrictions.eq("financialYear", financialYear));
		detachedCriteria.add(Restrictions.eq("facilityCode", facilityCode));
		detachedCriteria.createAlias("budgetAllocationDeductionshq", "bdgt", CriteriaSpecification.INNER_JOIN);
		List<CBMaster> list = budgetADTdao.findByCriteria(detachedCriteria);
		for(CBMaster cbMaster:list)
		{
			cbmastrSeqnoList.add(cbMaster.getCbMstrSeqno());
		}
		return cbmastrSeqnoList;
		
	}
	/** ACCESSORS AND MUTATORS **/
	public RefCodesService getRefCodesService() { return refCodesService; }
	public void setRefCodesService(RefCodesService refCodesService) { this.refCodesService = refCodesService; }
	public TaskListService getTaskListService() { return taskListService; }
	public void setTaskListService(TaskListService taskListService) { this.taskListService = taskListService; }
	public SecRoleService getSecRoleService() { return secRoleService; }
	public void setSecRoleService(SecRoleService secRoleService) { this.secRoleService = secRoleService; }
	public ExternalFacilityService getExternalFacilityService() { return externalFacilityService; }
	public void setExternalFacilityService(ExternalFacilityService externalFacilityService) { this.externalFacilityService = externalFacilityService; }
	public BudgetADTDAOImpl getBudgetADTdao() { return budgetADTdao; }
	public void setBudgetADTdao(BudgetADTDAOImpl budgetADTdao) { this.budgetADTdao = budgetADTdao; }

	@Override
	public List getCBMasterSeqnoByFacilitys(int financialYear,
			String facilityCode) {
		List cbmastrSeqnoList = new ArrayList(); 
		
		String str ="select cbm.CB_MSTR_SEQNO from T_CURRENT_BUDGET_MASTER cbm "
				+ "inner join T_BUDGET_ALLOCATION_DEDUCTION bad on cbm.CB_MSTR_SEQNO=bad.CB_MSTR_SEQNO"
				+ " where cbm.financial_year='"+financialYear+"' and cbm.facility_code='"+facilityCode+"'"
				+ " union all "
				+ " select cbm.CB_MSTR_SEQNO from T_CURRENT_BUDGET_MASTER cbm "
				+ " inner join t_budget_transfer bt on (cbm.CB_MSTR_SEQNO=bt.transfer_from_seqno or  cbm.CB_MSTR_SEQNO=bt.transfer_to_seqno) "
				+ " where cbm.financial_year='"+financialYear+"' and cbm.facility_code='"+facilityCode+"'" ;
		SessionFactory sessionFactory = budgetADTdao.getSessionFactory();
		Session session = sessionFactory.openSession();
		List objectArrayList = session.createSQLQuery(str).list();
		for (Object objects : objectArrayList) {
			cbmastrSeqnoList.add(((BigDecimal) objects).doubleValue());
		}
		session.close();
		//sessionFactory.close();
		return cbmastrSeqnoList;
	
	}

	@Override
	public CBMaster getCbMasterBySeqno(Long cbSeqno)
	{
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(CBMaster.class);
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		detachedCriteria.add(Restrictions.eq("cbMstrSeqno", cbSeqno));
		List<CBMaster> list = budgetADTdao.findByCriteria(detachedCriteria);
		return list.size() > 0  ? list.iterator().next() : null;
	}
	
	@Override
	public ExternalFacility getExternalFacilityByFacilityCode (String facilityCode) {
		return getExternalFacilityService().findByFacilityCode(facilityCode);
	}
	
	
	@Override
	public List getAllCBMasterByBdgtMovement(Integer financialYear, String facilityCode) {
		String sql = "select distinct bdgetMvment.cb_mstr_seqno from t_budget_movement bdgetMvment"
				+ " where financial_year ='"+financialYear+"'  and bdgetMvment.FACILITY_CODE ='"+facilityCode+"' ";
		Session session = null;
		try {
			session = budgetADTdao.getSessionFactory().openSession();
			List objectArrayList = session.createSQLQuery(sql).list();
			if (objectArrayList != null) {
				return objectArrayList;
			} else {
				return null;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return null;
	}
	
	@Override
	public List<BudgetAllocationDeduction> findBudgetAllocationDeduction(BudgetAllocationDeduction soBudgetAllocationDeduction,VoteCode voteCode, int year) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(BudgetAllocationDeduction.class, "bdt");
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		detachedCriteria.setFetchMode("voteCode", FetchMode.JOIN);
		detachedCriteria.setFetchMode("currentBudgetMasterHq", FetchMode.JOIN);
		detachedCriteria.setFetchMode("currentBudgetMasterHq.voteCode",FetchMode.JOIN);

		if (soBudgetAllocationDeduction.getFacilityCode() != null) detachedCriteria.add(Restrictions.ilike("facilityCode", "%"+ soBudgetAllocationDeduction.getFacilityCode() + "%"));
		if (soBudgetAllocationDeduction.getWarrantNo() != null) detachedCriteria.add(Restrictions.ilike("warrantNo", "%"+ soBudgetAllocationDeduction.getWarrantNo() + "%"));
		if (soBudgetAllocationDeduction.getReferenceNo() != null) detachedCriteria.add(Restrictions.ilike("referenceNo", "%"+ soBudgetAllocationDeduction.getReferenceNo() + "%"));
		if (soBudgetAllocationDeduction.getTransactionType() != null) detachedCriteria.add(Restrictions.eq("transactionType", soBudgetAllocationDeduction.getTransactionType()));
		

		if (soBudgetAllocationDeduction.getAllocationDeductionNo() != null) detachedCriteria.add(Restrictions.ilike("allocationDeductionNo", "%"+ soBudgetAllocationDeduction.getAllocationDeductionNo() + "%"));
		if (soBudgetAllocationDeduction.getBudgetType() != null) detachedCriteria.add(Restrictions.eq("budgetType", soBudgetAllocationDeduction.getBudgetType()));
		

		if (voteCode.getVoteCode() != null && soBudgetAllocationDeduction.getWarrantType() == null) {
			detachedCriteria.createAlias("bdt.voteCode", "thechild");
			detachedCriteria.add(Restrictions.eq("thechild.voteCode",voteCode.getVoteCode()));
		}
		detachedCriteria.add(soBudgetAllocationDeduction.getFinancialYear() != null ? Restrictions.eq("financialYear", soBudgetAllocationDeduction.getFinancialYear()) : Restrictions.eq("financialYear", year));
		if (soBudgetAllocationDeduction.getWarrantNo() != null && soBudgetAllocationDeduction.getWarrantType() != null && soBudgetAllocationDeduction.getAllocationDeductionNo() == null) {
			if (soBudgetAllocationDeduction.getWarrantType().equals("First")) {
				soBudgetAllocationDeduction.setWarrantType("Additional");
				detachedCriteria.add(Restrictions.eq("warrantType",soBudgetAllocationDeduction.getWarrantType()));
				detachedCriteria.add(Restrictions.eq("warrantNo",soBudgetAllocationDeduction.getWarrantNo()));
				soBudgetAllocationDeduction.setWarrantType("First");
			} else if (soBudgetAllocationDeduction.getWarrantType().equals("Additional")) {
				soBudgetAllocationDeduction.setWarrantType("First");
				detachedCriteria.add(Restrictions.eq("warrantType",soBudgetAllocationDeduction.getWarrantType()));
				detachedCriteria.add(Restrictions.eq("warrantNo",soBudgetAllocationDeduction.getWarrantNo()));
				soBudgetAllocationDeduction.setWarrantType("Additional");
			}
		}

		if (voteCode.getVoteCode() != null) {
			if (soBudgetAllocationDeduction.getWarrantType() != null) 
				if (soBudgetAllocationDeduction.getWarrantType() .equals("First") || soBudgetAllocationDeduction.getWarrantType().equals("Additional")) {
					detachedCriteria.createAlias("bdt.voteCode", "thechild");
					detachedCriteria.add(Restrictions.eq("thechild.voteCode",voteCode.getVoteCode()));
					detachedCriteria.add(Restrictions.or(Restrictions.eq("warrantType", "First"),Restrictions.eq("warrantType", "Additional")));
				}
		}

		detachedCriteria.add(Restrictions.eq("activeFlag", 'A'));
		detachedCriteria.addOrder(Property.forName("createdDate").desc());
		return budgetADTdao.findByCriteria(detachedCriteria);
	}
	
	@Override
	public List<BudgetTransfer> findBudgetTransfer(BudgetTransfer soBudgetTransfer, VoteCode voteCode, int year) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(BudgetTransfer.class, "btf");
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		detachedCriteria.setFetchMode("voteCode", FetchMode.JOIN);
		detachedCriteria.setFetchMode("toVoteCode", FetchMode.JOIN);
		detachedCriteria.setFetchMode("currentBudgetMasterByTransferFromSeqno",FetchMode.JOIN);
		detachedCriteria.setFetchMode("currentBudgetMasterByTransferFromSeqno.voteCode",FetchMode.JOIN);
		detachedCriteria.setFetchMode("currentBudgetMasterByTransferToSeqno",FetchMode.JOIN);
		detachedCriteria.setFetchMode("currentBudgetMasterByTransferToSeqno.voteCode",FetchMode.JOIN);

		if (soBudgetTransfer.getFacilityCodeFrom() != null) detachedCriteria.add(Restrictions.or(Restrictions.ilike("facilityCodeFrom", "%"+ soBudgetTransfer.getFacilityCodeFrom()+ "%"),Restrictions.ilike("facilityCodeTo", "%"+ soBudgetTransfer.getFacilityCodeFrom()+ "%")));
		if (soBudgetTransfer.getReferenceNo() != null) detachedCriteria.add(Restrictions.ilike("referenceNo", "%"+ soBudgetTransfer.getReferenceNo() + "%"));
		if (soBudgetTransfer.getTransferNo() != null) detachedCriteria.add(Restrictions.ilike("transferNo", "%"+ soBudgetTransfer.getTransferNo() + "%"));
		if (voteCode.getVoteCode() != null || voteCode.getVoteName() != null) {
			detachedCriteria.createAlias("btf.voteCode", "thechild1");
			detachedCriteria.createAlias("btf.toVoteCode", "thechild2");
			detachedCriteria.add(Restrictions.or(Restrictions.eq("thechild1.voteCode",voteCode.getVoteCode()),Restrictions.eq("thechild2.voteCode",voteCode.getVoteCode())));
		}
		if (soBudgetTransfer.getBudgetType() != null) detachedCriteria.createCriteria("currentBudgetMasterByTransferFromSeqno").add(Restrictions.eq("budgetType",soBudgetTransfer.getBudgetType()));
		detachedCriteria.add(soBudgetTransfer.getFinancialYear() != null ? Restrictions.eq("financialYear", soBudgetTransfer.getFinancialYear()) : Restrictions.eq("financialYear", year));
		detachedCriteria.add(Restrictions.eq("activeFlag", 'A'));
		detachedCriteria.addOrder(Property.forName("createdDate").desc());
		return budgetADTdao.findByCriteria(detachedCriteria);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public CBMaster getCBMasterByVote(VoteCode voteCode, Integer year,String budgetType, String facilityCode, String ptjCode) {
		
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(CBMaster.class, "cbm");
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		if (voteCode.getVoteSeqno() > 0) {
			detachedCriteria.add(Restrictions.eq("financialYear", year));
			detachedCriteria.createAlias("cbm.voteCode", "thechild");
			detachedCriteria.add(Restrictions.eq("thechild.voteSeqno", voteCode.getVoteSeqno()));
			detachedCriteria.add(Restrictions.eq("budgetType", budgetType));
			detachedCriteria.add(Restrictions.eq("facilityCode", facilityCode));
			detachedCriteria.add(Restrictions.eq("ptjCode", ptjCode));
		}
		List<CBMaster> list = budgetADTdao.findByCriteria(detachedCriteria);
		return (list.size() > 0 ? list.iterator().next() : null);
	}
	
}