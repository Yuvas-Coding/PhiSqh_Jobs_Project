package my.com.cmg.iwp.maintenance.adjustment.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.management.Query;

import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.backend.model.TaskLists;
import my.com.cmg.iwp.backend.service.TaskListService;
import my.com.cmg.iwp.maintenance.adjustment.service.BudgetAdjustmentService;
import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.BudgetMovement;
import my.com.cmg.iwp.maintenance.model.CBMaster;
import my.com.cmg.iwp.maintenance.model.ExternalFacility;
import my.com.cmg.iwp.maintenance.model.NePVote;
import my.com.cmg.iwp.maintenance.model.RefCodes;
import my.com.cmg.iwp.maintenance.model.SecRole;
import my.com.cmg.iwp.maintenance.model.SecUser;
import my.com.cmg.iwp.maintenance.model.VoteCode;
import my.com.cmg.iwp.maintenance.model.adjustment.BudgetAdjDtl;
import my.com.cmg.iwp.maintenance.model.adjustment.BudgetAdjHdr;
import my.com.cmg.iwp.maintenance.service.BudgetADTService;
import my.com.cmg.iwp.maintenance.service.ExternalFacilityService;
import my.com.cmg.iwp.maintenance.service.RefCodesService;
import my.com.cmg.iwp.maintenance.service.SecRoleService;
import my.com.cmg.iwp.maintenance.service.SecUserService;
import my.com.cmg.iwp.webui.budget.InventoryConstant;
import my.com.cmg.iwp.webui.constant.HQConstants;
import my.com.cmg.iwp.webui.constant.RefCodeConstant;
import my.com.cmg.phis.util.constant.InventoryConstants;
@Service
public class BudgetAdjustmentServiceImpl implements BudgetAdjustmentService {
	
	private BasisNextidDaoImpl<BudgetAdjHdr> budgetAdjustmentHdrDAO;
	private BasisNextidDaoImpl<BudgetAdjDtl> budgetAdjustmentDtlDAO;
	private SecUserService secUserService;
	private TaskListService taskListService;
	private RefCodesService refCodesService;
	private SecRoleService secRoleService;
	private ExternalFacilityService externalFacilityService;
	private BudgetADTService budgetADTService;
	private BasisNextidDaoImpl<BudgetMovement> movementHqDAOImpl;
	
	public BasisNextidDaoImpl<BudgetAdjHdr> getBudgetAdjustmentHdrDAO() {
		return budgetAdjustmentHdrDAO;
	}
	public void setBudgetAdjustmentHdrDAO(BasisNextidDaoImpl<BudgetAdjHdr> budgetAdjustmentHdrDAO) {
		this.budgetAdjustmentHdrDAO = budgetAdjustmentHdrDAO;
	}
	public BasisNextidDaoImpl<BudgetAdjDtl> getBudgetAdjustmentDtlDAO() {
		return budgetAdjustmentDtlDAO;
	}
	public void setBudgetAdjustmentDtlDAO(BasisNextidDaoImpl<BudgetAdjDtl> budgetAdjustmentDtlDAO) {
		this.budgetAdjustmentDtlDAO = budgetAdjustmentDtlDAO;
	}
	
	public SecUserService getSecUserService() {
		return secUserService;
	}

	public void setSecUserService(SecUserService secUserService) {
		this.secUserService = secUserService;
	}
	
	public TaskListService getTaskListService() {
		return taskListService;
	}

	public void setTaskListService(TaskListService taskListService) {
		this.taskListService = taskListService;
	}
	
	public RefCodesService getRefCodesService() {
		return refCodesService;
	}

	public void setRefCodesService(RefCodesService refCodesService) {
		this.refCodesService = refCodesService;
	}

	public SecRoleService getSecRoleService() {
		return secRoleService;
	}

	public void setSecRoleService(SecRoleService secRoleService) {
		this.secRoleService = secRoleService;
	}

	public ExternalFacilityService getExternalFacilityService() {
		return externalFacilityService;
	}

	public void setExternalFacilityService(ExternalFacilityService externalFacilityService) {
		this.externalFacilityService = externalFacilityService;
	}
	
	public BudgetADTService getBudgetADTService() {
		return budgetADTService;
	}
	public void setBudgetADTService(BudgetADTService budgetADTService) {
		this.budgetADTService = budgetADTService;
	}	

	public BasisNextidDaoImpl<BudgetMovement> getMovementHqDAOImpl() {
		return movementHqDAOImpl;
	}
	public void setMovementHqDAOImpl(BasisNextidDaoImpl<BudgetMovement> movementHqDAOImpl) {
		this.movementHqDAOImpl = movementHqDAOImpl;
	}

	@Override
	public BudgetAdjHdr getNewBudgetAdjHdr() {
		return new BudgetAdjHdr();
	}
	
	@Override
	public BudgetAdjDtl getNewBudgetAdjDtl() {
		return new BudgetAdjDtl();
	}
	
	
	@Override
	public void saveOrUpdate(BudgetAdjHdr anBudgetAdjHdr) {
		getBudgetAdjustmentHdrDAO().saveOrUpdate(anBudgetAdjHdr);	
	}
	
	@Override
	public List<BudgetAdjHdr> getAllBudgetAdjHdrs() {
		DetachedCriteria criteria = DetachedCriteria.forClass(BudgetAdjHdr.class);
		criteria.setFetchMode("budgetAdjDtls", FetchMode.JOIN);
		return getBudgetAdjustmentHdrDAO().findByCriteria(criteria);
	}

	@Override
	public SecUser getSecUserFetches(SecUser secUser) {
		return getSecUserService().getSecUserFetches(secUser);
	}
	
	@Override
	public boolean isUserTypeBudget(SecUser secUser) {
		return getSecUserService().isUserTypeBudget(secUser);
	}
	
	@Override
	public BudgetAdjHdr findBudgetTransferByExample(BudgetAdjHdr anAdjHdr, VoteCode code, int year) {
		DetachedCriteria criteria = DetachedCriteria.forClass(BudgetAdjHdr.class);
		criteria.setFetchMode("budgetAdjDtls", FetchMode.JOIN);
		criteria.add(Restrictions.eq("financialYear", year));
		criteria.add(Restrictions.eq("adjustmentNo", anAdjHdr.getAdjustmentNo()));
		List<BudgetAdjHdr>  hdrs = getBudgetAdjustmentHdrDAO().findByCriteria(criteria);
		return (null !=hdrs && !hdrs.isEmpty() ) ? hdrs.iterator().next() : null;
				
	}
	@Override
	public void populateTaskLists(TaskLists taskLists, SecUser user, BudgetAdjHdr budgetAdjHdr, boolean isNewRecord) {

		if (taskLists != null) {
			if (isNewRecord) {
				isNewRecord = true;
				taskLists.setTlTrxType(HQConstants.BUDGET_ADT_TRX_TYPE_ADJUST);
				taskLists.setTlDocSeqNo(budgetAdjHdr.getBudgetAdjSeqno());
				taskLists.setTlTaskNo(budgetAdjHdr.getAdjustmentNo());
				taskLists.setTlDocNo(budgetAdjHdr.getAdjustmentNo());
				taskLists.setTlTrxSeqNo(budgetAdjHdr.getBudgetAdjSeqno());
			} else {
				taskLists.setTlStatus(budgetAdjHdr.getTransactionStatus());
				taskLists.setTlTaskStatus(HQConstants.TASKLIST_STATUS_CLOSE);
				taskLists.setTlSentApprovalFlag(RefCodeConstant.BOOLEAN_TRUE);
				RefCodes refcode = getRefCodesService().getRefCodeByRcValue(InventoryConstants.LABLES.BUDGET_STATUS,budgetAdjHdr.getTransactionStatus());
				taskLists.setTlSubject(refcode.getRcDesc());
				taskLists.setTlTaskDone(InventoryConstant.TASK_DONE_YES);
				taskLists.setUpdatedDate(new Date());
				taskLists.setUpdatedBy(user.getId());
			}

			if (isNewRecord) {
				taskLists.setTlStatus(getRefCodesService().getRefCodeByRcValue(InventoryConstants.LABLES.BUDGET_STATUS,InventoryConstants.BUDGET_STATUS.PENDING_FOR_APPROVAL).getRcDesc());
				taskLists.setTlTransactionType(2188 + "");
				taskLists.setTlSubject(getRefCodesService().getRefCodeByRcValue(InventoryConstants.LABLES.BUDGET_STATUS,InventoryConstants.BUDGET_STATUS.PENDING_FOR_APPROVAL).getRcDesc());
				taskLists.setTlTaskStatus(HQConstants.TASKLIST_STATUS_OPEN);
				taskLists.setTlAcknowledge(InventoryConstant.TASK_ACKNOWLEDGE_YES.charValue());
				taskLists.setActiveFlag(RefCodeConstant.ACTIVE_FLAG_TRUE.toString());
				taskLists.setTlTaskDone(InventoryConstant.TASK_DONE_NO == null ? InventoryConstant.TASK_ACTIVE_NO.charValue() : InventoryConstant.TASK_DONE_NO.charValue());
				taskLists.setTlURL("/pages/budget/adjustment/budgetAdjustmentDialog.zul");
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
	public CBMaster getCurrentBudgetMaster(Long cbMasterSeqno) {
		
		return budgetADTService.getCbMasterBySeqno(cbMasterSeqno);
	}
	@Override
	public List<CBMaster> checkLock(VoteCode voteCode, Integer financialYear, String budgetType,
			String facilityCodeFrom, String ptjCode) {
		return budgetADTService.checkLock(voteCode, financialYear, budgetType, facilityCodeFrom, ptjCode);
	}
	@Override
	public void acquireORreleaseLock(long voteSeqno, Integer year, String budgetType, String facilityCode,
			String ptjCode, String lockReleased) {
		budgetADTService.acquireORreleaseLock(voteSeqno, year, budgetType, facilityCode, ptjCode, lockReleased);		
	}
	@Override
	public CBMaster getCBMaster(VoteCode voteCode, Integer year, String budgetType, String facilityCode,
			String ptjCode) {
		return budgetADTService.getCBMaster(voteCode, year, budgetType, facilityCode, ptjCode);
	}
	
	@Override
	public List<CBMaster> getCurrentBudgetMaster(VoteCode voteCode, Integer year,String budgetType, String facilityCode, String ptjCode,NePVote nePVote) {
		List<CBMaster> cbMasterList=new ArrayList<CBMaster>();
		CBMaster cbMaster =budgetADTService.getCBMaster(voteCode.getVoteCode(), year, budgetType, facilityCode, ptjCode,nePVote);
		cbMasterList.add(cbMaster);
		return cbMasterList;
	}
	
	@Override
	public double getUnitPriceByPOAndItem(long itemSeqno, long poHdrSeqno) {
		double unitpriceList = 0l; 
		
		String str =" select unit_price from t_po_dtl where item_seqno =  " + itemSeqno +" and po_hdr_seqno = " + poHdrSeqno;
		SessionFactory sessionFactory = getBudgetAdjustmentHdrDAO().getSessionFactory();
		Session session = sessionFactory.openSession();
		List objectArrayList = session.createSQLQuery(str).list();
		for (Object objects : objectArrayList) {
			unitpriceList = ((BigDecimal) objects).doubleValue();
		}
		session.close();
		return unitpriceList;
	
	}
	
	@Override
	public void saveOrUpdate(CBMaster cbMaster) {
		getBudgetADTService().saveOrUpdateCurrentBudgetMaster(cbMaster);
	}
	
	@Override
	public void saveOrUpdate(BudgetMovement budgetMovement) {
		getBudgetADTService().saveOrUpdateBudgetMovement(budgetMovement);
	}
	
	@Override
	public boolean getBudgetHdrByLpoAndStatus(String lpoNo, String facilityCode, String... status) {
		List<String> str = new ArrayList<String>();
		boolean isAvailable=false;
		Session session = null;
		try {
			session = getBudgetAdjustmentHdrDAO().getSessionFactory().openSession();
			StringBuilder query=new StringBuilder();

			query.append(" select   case when (sum(paymentcount)>(sum(adjcount)+sum(adjcountForApprove))) then 'Y' else 'N' end  from (select count(distinct CB_MSTR_SEQNO) as paymentcount,0 as adjcount"
					+ " ,0 as adjcountForApprove from t_PAYMENTS pay   inner  join t_PAYMENT_DTL payDtl "
					+ " on payDtl.PAYMENT_SEQNO=pay.PAYMENT_SEQNO  where  LPO_NO='"+lpoNo+"' and pay.FACILITY_CODE = '"+facilityCode+"' "
					+ " and pay.STATUS='APPROVED' "
					+ " union all "
					+ " select 0 as paymentcount,count(distinct HDR.BUDGET_ADJ_SEQNO) as adjcount,0 as adjcountForApprove from T_BUDGET_ADJ_HDR HDR  "
					+ " where HDR.LPO_NO='"+lpoNo+"' and HDR.FACILITY_CODE = '"+facilityCode+"' and"
					+ "  HDR.TRANSACTION_STATUS in ('PFA','Open')  "
					+ " union all  select 0 as paymentcount,0,count(distinct HDR.BUDGET_ADJ_SEQNO) as adjcountForApprove from "
					+ " T_BUDGET_ADJ_HDR HDR where HDR.LPO_NO='"+lpoNo+"' and HDR.FACILITY_CODE = '"+facilityCode+"' "
					+ " and  HDR.TRANSACTION_STATUS in ('Approved')) ");
			Character returnValue = null;
			Query result=session.createSQLQuery(query.toString());
			if (result.uniqueResult() != null) {
				returnValue =  (Character) result.uniqueResult();
			} 
			if(returnValue.equals('N'))
				isAvailable=true;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return isAvailable;
				
	}
	@Override
	public List<String> getLponoListByBudgetAdjustment(String facilityCode,Integer year,int month) {
		List<String> str = new ArrayList<String>();
		Session session = null;
		try {
			session = getBudgetAdjustmentHdrDAO().getSessionFactory().openSession();
			/*String query ="  select distinct HDR.LPO_NO from T_BUDGET_ADJ_HDR HDR "
					+ " inner join t_budget_adj_dtl DTL  on HDR.BUDGET_ADJ_SEQNO=DTL.BUDGET_ADJ_SEQNO"
					+ " inner join T_PAYMENTS pay on pay.LPO_NO=hdr.LPO_NO "
					+ " inner join T_PAYMENT_DTL payDtl on payDtl.PAYMENT_SEQNO=pay.PAYMENT_SEQNO "
					+ " and payDtl.CB_MSTR_SEQNO=HDR.ADJ_FROM_SEQNO "
					+ " where TRANSACTION_STATUS='Approved' and  HDR.FACILITY_CODE = '"+facilityCode+"' ";*/
			String query=" select lpono from ( select  sum(paymentcount) as pay,sum(adjcount) adj,lpono"
					+ " from (select count(distinct CB_MSTR_SEQNO) as paymentcount,0 as adjcount,pay.LPO_NO as lpono"
					+ " from t_PAYMENTS pay   inner  join t_PAYMENT_DTL payDtl "
					+ " on payDtl.PAYMENT_SEQNO=pay.PAYMENT_SEQNO  where   pay.FACILITY_CODE =  '"+facilityCode+"' "
					+ " and pay.STATUS='APPROVED' and EXTRACT(MONTH FROM pay.updated_date)='"+month+"' and financial_year='"+year+"' group by pay.LPO_NO "
					+ " union all "
					+ " select 0 as paymentcount,count(distinct HDR.BUDGET_ADJ_SEQNO) as adjcount,hdr.LPO_NO as lpono  "
					+ " from T_BUDGET_ADJ_HDR HDR  where   HDR.FACILITY_CODE =  '"+facilityCode+"' and"
					+ " HDR.TRANSACTION_STATUS in ('Approved') and EXTRACT(MONTH FROM HDR.updated_date)='"+month+"' and finacial_year='"+year+"' group by hdr.LPO_NO ) group by lpono) where pay>adj ";
	
			List objectArrayList = session.createSQLQuery(query).list();
			if (objectArrayList != null) {
				return objectArrayList;
			} else {
				return null;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return str;
	}
	@Override
	public boolean checkVoteAvailableByLPO(String lpoNo, CBMaster cbmasterSeq,
			String facilityCode) {
		DetachedCriteria criteria = DetachedCriteria.forClass(BudgetAdjHdr.class);
		criteria.add(Restrictions.eq("lpoNo", lpoNo));
		criteria.add(Restrictions.ne("transactionStatus",InventoryConstant.BUDGET_STATUS_RCVALUE_CANCELLED));
		criteria.add(Restrictions.ne("transactionStatus",InventoryConstants.BUDGET_STATUS.REJECT));
		if(facilityCode!=null)
			criteria.add(Restrictions.eq("facilityCodeFrom", facilityCode));
		criteria.add(Restrictions.eq("adjFromSeqno", cbmasterSeq));
		List<BudgetAdjHdr>  hdrs = getBudgetAdjustmentHdrDAO().findByCriteria(criteria);
		return hdrs.size()>0?true:false;
	}
	
	
	@Override
	public BudgetAdjHdr getBudgetAdjustmentForTaskList(BudgetAdjHdr anAdjHdr) {
		DetachedCriteria criteria = DetachedCriteria.forClass(BudgetAdjHdr.class);
		criteria.setFetchMode("budgetAdjDtls", FetchMode.JOIN);
		criteria.add(Restrictions.eq("adjustmentNo", anAdjHdr.getAdjustmentNo()));
		List<BudgetAdjHdr>  hdrs = getBudgetAdjustmentHdrDAO().findByCriteria(criteria);
		return (null !=hdrs && !hdrs.isEmpty() ) ? hdrs.iterator().next() : null;
				
	}
}


