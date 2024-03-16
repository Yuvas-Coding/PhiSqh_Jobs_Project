package my.com.cmg.iwp.backend.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Service;
import org.zkoss.spring.SpringUtil;

import com.googlecode.genericdao.search.Filter;

import my.com.cmg.iwp.UserWorkspace;
import my.com.cmg.iwp.backend.dao.impl.TaskListDAOImpl;
import my.com.cmg.iwp.backend.model.TaskLists;
import my.com.cmg.iwp.backend.service.TaskListService;
import my.com.cmg.iwp.common.util.HibernateSearchObject;
import my.com.cmg.iwp.maintenance.model.ExternalFacility;
import my.com.cmg.iwp.maintenance.model.RefCodes;
import my.com.cmg.iwp.maintenance.model.SecRole;
import my.com.cmg.iwp.maintenance.model.SecUser;
import my.com.cmg.iwp.maintenance.service.ExternalFacilityService;
import my.com.cmg.iwp.maintenance.service.RefCodesService;
import my.com.cmg.iwp.maintenance.service.UserService;
import my.com.cmg.iwp.webui.budget.InventoryConstant;
import my.com.cmg.iwp.webui.constant.HQConstants;
import my.com.cmg.iwp.webui.constant.RefCodeConstant;
import my.com.cmg.iwp.webui.inventory.penalty.PenaltyConstants;

/**
 * @author TAPAN KUMAR SABAT
 *
 */
@Service
public class TaskListServiceImpl implements TaskListService {

	private TaskListDAOImpl taskListDAO;
	private ExternalFacilityService externalFacilityService;

	@Override
	public void saveOrUpdate(TaskLists taskLists) {
		taskListDAO.saveOrUpdate(taskLists);
	}

	/*
	 * public HibernateSearchObject<TaskLists> displayTaskList(UserWorkspace
	 * userWorkspace, SecUser secUser){ HibernateSearchObject<TaskLists> taskList =
	 * new HibernateSearchObject<TaskLists>(TaskLists.class); // CREATE FILTER
	 * Filter taskListFilter = doTaskListFilter(userWorkspace,secUser);
	 * 
	 * STEP 3 :: ADD FILTER TO HIBERNATE SEARCH OBJECT
	 * 
	 * Filter filter1 = Filter.equal("tlTaskStatus",
	 * HQConstants.TASKLIST_STATUS_OPEN); Filter filter =
	 * Filter.and(taskListFilter,doAppendRightsFilter(userWorkspace),filter1);
	 * Filter kpkFilter=doappendFilterForKPK(userWorkspace,secUser); Filter
	 * roFilter=doappendFilterForRO();
	 * if(userWorkspace.isAllowed(InventoryConstant.KPK_APPROVAL))
	 * taskList.addFilter(Filter.or(filter,kpkFilter)); else
	 * taskList.addFilter(Filter.and(filter,Filter.notEqual("tlTrxType",
	 * InventoryConstant.KPK_TRX_TYPE))); taskList.addFilter(roFilter);
	 * taskList.addSortAsc("tlRecDateTime"); return taskList; }
	 */

	@Override
	public HibernateSearchObject<TaskLists> displayTaskList(UserWorkspace userWorkspace, SecUser secUser,
			ExternalFacility externalFacility, RefCodesService refcodeService, UserService userService) {
		boolean isHavingPKDAdminRole=false;
		HibernateSearchObject<TaskLists> taskList = new HibernateSearchObject<TaskLists>(TaskLists.class);
		// CREATE FILTER
		Filter taskListFilter = doTaskListFilter(userWorkspace, secUser, externalFacility);
		/*
		 * STEP 3 :: ADD FILTER TO HIBERNATE SEARCH OBJECT
		 */
		Filter filter1 = Filter.equal("tlTaskStatus", HQConstants.TASKLIST_STATUS_OPEN);
		Filter filter = Filter.and(taskListFilter, doAppendRightsFilter(userWorkspace), filter1);
		Filter kpkFilter = doappendFilterForKPK(userWorkspace, secUser, externalFacility, refcodeService, userService);
		
		RefCodes sdrSecretariat = refcodeService.getRefCodesListByDomain(RefCodeConstant.ROLE_SDR_SECRETARIAT).get(0);
		RefCodes sdrKetuaSeksyen = refcodeService.getRefCodesListByDomain(RefCodeConstant.ROLE_SDR_KETUA_SEKSYEN).get(0);
		RefCodes sdrTimbPengarah = refcodeService.getRefCodesListByDomain(RefCodeConstant.ROLE_SDR_TIMB_PENGARAH).get(0);
		RefCodes sdrPengarahAP = refcodeService.getRefCodesListByDomain(RefCodeConstant.ROLE_SDR_PENGARAH_AP).get(0);
		RefCodes sdrPKPF = refcodeService.getRefCodesListByDomain(RefCodeConstant.ROLE_SDR_PKPF).get(0);
		RefCodes sdrKPK = refcodeService.getRefCodesListByDomain(RefCodeConstant.ROLE_SDR_KPK).get(0);
		RefCodes refcodeStatus = new RefCodes();
		
		List<SecRole> userRole = userService.getRolesByUser(secUser);
		
		for (SecRole role : userRole) {
			if (role.getRolShortdescription().equalsIgnoreCase(sdrSecretariat.getRcValue())) {
				List<String> list = new ArrayList<String>();
				list.add("New Request");
				list.add("Pending to Print Permit");
				list.add("Send For Approval");
				kpkFilter = Filter.and(kpkFilter, Filter.in("tlStatus", list));
			}
			if (role.getRolShortdescription().equalsIgnoreCase(sdrKetuaSeksyen.getRcValue())) {
				refcodeStatus = refcodeService.getRefCodeByRcValue(RefCodeConstant.KPK_STATUS, RefCodeConstant.KPK_PKSR);
				kpkFilter = Filter.and(kpkFilter, Filter.equal("tlStatus", refcodeStatus.getRcDesc()));
			}
			if (role.getRolShortdescription().equalsIgnoreCase(sdrTimbPengarah.getRcValue())) {
				refcodeStatus = refcodeService.getRefCodeByRcValue(RefCodeConstant.KPK_STATUS, RefCodeConstant.KPK_PETP);
				kpkFilter = Filter.and(kpkFilter, Filter.equal("tlStatus", refcodeStatus.getRcDesc()));
			}
			if (role.getRolShortdescription().equalsIgnoreCase(sdrPengarahAP.getRcValue())) {
				refcodeStatus = refcodeService.getRefCodeByRcValue(RefCodeConstant.KPK_STATUS, RefCodeConstant.KPK_PPAP);
				kpkFilter = Filter.and(kpkFilter, Filter.equal("tlStatus", refcodeStatus.getRcDesc()));
			}
			if (role.getRolShortdescription().equalsIgnoreCase(sdrPKPF.getRcValue())) {
				refcodeStatus = refcodeService.getRefCodeByRcValue(RefCodeConstant.KPK_STATUS, RefCodeConstant.KPK_PPKPF);
				kpkFilter = Filter.and(kpkFilter, Filter.equal("tlStatus", refcodeStatus.getRcDesc()));
			}
			if (role.getRolShortdescription().equalsIgnoreCase(sdrKPK.getRcValue())) {
				refcodeStatus = refcodeService.getRefCodeByRcValue(RefCodeConstant.KPK_STATUS, RefCodeConstant.KPK_PKPK);
				kpkFilter = Filter.and(kpkFilter, Filter.equal("tlStatus", refcodeStatus.getRcDesc()));
			}
			if (role.getRolShortdescription().equalsIgnoreCase(RefCodeConstant.Role_DataMaster_Admin) || role.getRolShortdescription().equalsIgnoreCase(RefCodeConstant.Role_HQ_PKD_ROLE) ) {
				isHavingPKDAdminRole=true;
			}
		}
		kpkFilter = Filter.and(kpkFilter);
		//Filter roFilter = doappendFilterForRO();
		Filter roFilter = doappendFilterForRO(secUser, externalFacility);
		String[] pkdtransactiontypes={InventoryConstant.TL_TRX_TYPE_PO,InventoryConstant.TL_TRX_TYPE_PAYMENT,InventoryConstant.TL_PAYMENT_APPROVAL,
				InventoryConstant.TL_TRX_TYPE_BUDGET_ADJUSTMENT,InventoryConstant.TL_TRX_TYPE_BUDGET_ALLOCATION,InventoryConstant.TL_TRX_TYPE_BUDGET_DEDUCTION,InventoryConstant.TL_TRX_TYPE_BUDGET_VIREMENT};
		if(!isHavingPKDAdminRole)
		{
			taskList.addFilter(Filter.and(filter, Filter.notIn("tlTrxType", pkdtransactiontypes)));
		}
		if (userWorkspace.isAllowed(InventoryConstant.KPK_APPROVAL))
			taskList.addFilter(Filter.or(filter, kpkFilter));
		else
			taskList.addFilter(Filter.and(filter, Filter.notEqual("tlTrxType", InventoryConstant.KPK_TRX_TYPE)));
		taskList.addFilter(roFilter);

		if (externalFacility != null) {
			taskList.addFilter(Filter.equal("tlFacilityCode", externalFacility.getFacilityCode()));
		}

		taskList.addSortAsc("tlRecDateTime");
		return taskList;
	}

	private Filter doappendFilterForRO(SecUser secUser, ExternalFacility extFac) {
		Filter returnfilter = Filter.or(new Filter());
		List<String> authFilterList = getAuthorizationReqRecords(secUser, extFac);
		if (!authFilterList.isEmpty())
			returnfilter.add(Filter.notIn("tlTaskNo", authFilterList));
		return returnfilter;
	}

	private Filter doappendFilterForKPK(UserWorkspace userWorkspace, SecUser secUser, ExternalFacility extFac, RefCodesService refcodeService, UserService userService) {
		Filter returnfilter = Filter.or(new Filter());
		List<String> FilterList = getAuthorizationKPKRecords(secUser, extFac, refcodeService, userService);
		if (!FilterList.isEmpty())
			returnfilter.add(Filter.in("tlTaskNo", FilterList));
		return returnfilter;
	}

	/**
	 * Added Filter by button rights for appropriate transactions
	 * 
	 * @param userWorkspace
	 * @param taskList
	 */
	private Filter doAppendRightsFilter(UserWorkspace userWorkspace) {
		Map<String, String> rightTransactionTypeMap = new HashMap<String, String>();
		rightTransactionTypeMap.put(PenaltyConstants.PENALTY_APPROVAL_RIGHT,
				PenaltyConstants.PENALTY_APPROVAL_TRANSACTION);
//		rightTransactionTypeMap.put(PenaltyConstants.PENALTY_VERIFICATION_CREATION_RIGHT, PenaltyConstants.PENALTY_VERIFICATION_CREATION_TRANSACTION);
		rightTransactionTypeMap.put(PenaltyConstants.PENALTY_VERIFICATION_VERIFY_RIGHT,
				PenaltyConstants.PENALTY_VERIFICATION_VERIFY_TRANSACTION);
		rightTransactionTypeMap.put(PenaltyConstants.PENALTY_PAYMENT_CREATION_RIGHT,
				PenaltyConstants.PENALTY_PAYMENT_CREATION_TRANSACTION);
		rightTransactionTypeMap.put(PenaltyConstants.PENALTY_PAYMENT_APPROVE_RIGHT,
				PenaltyConstants.PENALTY_PAYMENT_APPROVAL_TRANSACTION);
		Set<String> keys = rightTransactionTypeMap.keySet();
		Filter returnfilter = Filter.or(new Filter());
		for (String key : keys) {
			System.out.println("KEY ::::::::::::::::::: " + key + "    ::::::::::::: Right Present :::::::::"
					+ userWorkspace.isAllowed(key));
			if (!userWorkspace.isAllowed(key)) {
				returnfilter.add(Filter.notEqual("tlTrxType", rightTransactionTypeMap.get(key)));
			}
		}
		return returnfilter;
	}

	/**
	 * Added Filter by button rights for appropriate transactions
	 * 
	 * @param userWorkspace
	 * @param taskList
	 */
	private Filter doTaskListFilter(UserWorkspace userWorkspace, SecUser secUser) {
		Filter returnfilter = Filter.or(new Filter());

		/*
		 * STEP 1 :: ADDING DEFAULT FILTER
		 */
		Filter taskListFilter = Filter.notEqual("tlTaskStatus", HQConstants.TASKLIST_STATUS_CLOSE);

		/*
		 * STEP 2 :: VERIFY THE USER WITH SPECIFIC - Facility Code - PTJCode
		 */
		List<ExternalFacility> extFacilityList = getExternalFacilityService()
				.getFacilityCodebySeqNo(secUser.getFacilitySeqno());
		if (extFacilityList != null && extFacilityList.size() > 0) {
			ExternalFacility externalFacility = extFacilityList.get(0);
			if (RefCodeConstant.USER_TYPE_PKD.equals(secUser.getUsrType())) {
				returnfilter.add(Filter.and(taskListFilter, Filter.equal("tlPTJCode", externalFacility.getPtjCode())));
			} else if (RefCodeConstant.USER_TYPE_KK.equals(secUser.getUsrType())) {
				returnfilter.add(
						Filter.and(taskListFilter, Filter.equal("tlFacilityCode", externalFacility.getFacilityCode()),
								Filter.equal("tlPTJCode", externalFacility.getPtjCode())));
			} else if (RefCodeConstant.USER_TYPE_HOSPITAL.equals(secUser.getUsrType())) {
				returnfilter.add(
						Filter.and(taskListFilter, Filter.equal("tlFacilityCode", externalFacility.getFacilityCode()),
								Filter.equal("tlPTJCode", externalFacility.getPtjCode())));
			} else if (RefCodeConstant.USR_TYPE_HQ.equals(secUser.getUsrType())) {
				// returnfilter.add(taskListFilter);
				returnfilter.add(
						Filter.and(taskListFilter, Filter.equal("tlFacilityCode", externalFacility.getFacilityCode()),
								Filter.equal("tlPTJCode", externalFacility.getPtjCode())));
			} else {
				returnfilter.add(
						Filter.and(taskListFilter, Filter.equal("tlFacilityCode", externalFacility.getFacilityCode()),
								Filter.equal("tlPTJCode", externalFacility.getPtjCode())));
			}
		}
		return returnfilter;
	}

	private Filter doTaskListFilter(UserWorkspace userWorkspace, SecUser secUser, ExternalFacility extFac) {
		Filter returnfilter = Filter.or(new Filter());

		/*
		 * STEP 1 :: ADDING DEFAULT FILTER
		 */
		Filter taskListFilter = Filter.notEqual("tlTaskStatus", HQConstants.TASKLIST_STATUS_CLOSE);

		/*
		 * STEP 2 :: VERIFY THE USER WITH SPECIFIC - Facility Code - PTJCode
		 */
		List<ExternalFacility> extFacilityList = getExternalFacilityService()
				.getFacilityCodebySeqNo(secUser.getFacilitySeqno());
		if (extFacilityList != null && extFacilityList.size() > 0) {
			ExternalFacility externalFacility = extFacilityList.get(0);
			if (RefCodeConstant.USER_TYPE_PKD.equals(secUser.getUsrType())) {
				returnfilter.add(Filter.and(taskListFilter, Filter.equal("tlPTJCode", externalFacility.getPtjCode())));
			} else if (RefCodeConstant.USER_TYPE_KK.equals(secUser.getUsrType())) {
				returnfilter.add(
						Filter.and(taskListFilter, Filter.equal("tlFacilityCode", externalFacility.getFacilityCode()),
								Filter.equal("tlPTJCode", externalFacility.getPtjCode())));
			} else if (RefCodeConstant.USER_TYPE_HOSPITAL.equals(secUser.getUsrType())) {
				returnfilter.add(
						Filter.and(taskListFilter, Filter.equal("tlFacilityCode", externalFacility.getFacilityCode()),
								Filter.equal("tlPTJCode", externalFacility.getPtjCode())));
			} else if (RefCodeConstant.USR_TYPE_HQ.equals(secUser.getUsrType())) {
				// returnfilter.add(taskListFilter);
				returnfilter.add(
						Filter.and(taskListFilter, Filter.equal("tlFacilityCode", extFac.getFacilityCode()),
								Filter.equal("tlPTJCode", extFac.getPtjCode())));
			} else {
				returnfilter.add(
						Filter.and(taskListFilter, Filter.equal("tlFacilityCode", externalFacility.getFacilityCode()),
								Filter.equal("tlPTJCode", externalFacility.getPtjCode())));
			}
		}
		return returnfilter;
	}

	@Override
	public TaskLists getTaskListsByTlSeqno(long tlSequenceNo) {
		DetachedCriteria criteria = DetachedCriteria.forClass(TaskLists.class);
		criteria.add(Restrictions.eq("tlSeqNo", tlSequenceNo));
		criteria.addOrder(Order.asc("tlRecDateTime"));
		return DataAccessUtils.uniqueResult(taskListDAO.findByCriteria(criteria));
	}

	@Override
	public TaskLists getTaskListsByTxSeqnoAndStatus(long txSequenceNo, String tlTaskStatus) {
		DetachedCriteria criteria = DetachedCriteria.forClass(TaskLists.class);
		criteria.add(Restrictions.eq("tlTrxSeqno", txSequenceNo));
		criteria.add(Restrictions.eq("tlTaskStatus", tlTaskStatus));

		criteria.addOrder(Order.asc("tlRecDateTime"));
		List<TaskLists> tlist = taskListDAO.findByCriteria(criteria);

		return (tlist.size() > 0 ? tlist.get(0) : null);
	}

	@Override
	public TaskLists getTaskListsByTxSeqnoAndStatus(long txSequenceNo, String tlTaskStatus, String txType) {
		DetachedCriteria criteria = DetachedCriteria.forClass(TaskLists.class);
		criteria.add(Restrictions.eq(TaskLists.H_COL_TLTRXSEQNO, txSequenceNo));
		criteria.add(Restrictions.eq(TaskLists.H_COL_TLTASKSTATUS, tlTaskStatus));
		criteria.add(Restrictions.eq(TaskLists.H_COL_TLTRXTYPE, txType));
		criteria.addOrder(Order.asc(TaskLists.H_COL_TLRECDATETIME));
		List<TaskLists> tlist = taskListDAO.findByCriteria(criteria);

		return (tlist != null && tlist.size() > 0 ? tlist.get(0) : null);
	}

	//
	public TaskListDAOImpl getTaskListDAO() {
		return taskListDAO;
	}

	public void setTaskListDAO(TaskListDAOImpl taskListDAO) {
		this.taskListDAO = taskListDAO;
	}

	public ExternalFacilityService getExternalFacilityService() {
		return externalFacilityService;
	}

	public void setExternalFacilityService(ExternalFacilityService externalFacilityService) {
		this.externalFacilityService = externalFacilityService;
	}

	@Override
	public TaskLists getTaskList(String tlTaskNo, String tlTrxType, String tlTaskStatus, Character tlTaskDone) {
		DetachedCriteria criteria = DetachedCriteria.forClass(TaskLists.class);
		criteria.add(Restrictions.eq("tlTaskNo", tlTaskNo));
		criteria.add(Restrictions.eq("tlTrxType", tlTrxType));
		criteria.add(Restrictions.eq("tlTaskStatus", tlTaskStatus));
		criteria.add(Restrictions.eq("tlTaskDone", tlTaskDone));
		return DataAccessUtils.uniqueResult(taskListDAO.findByCriteria(criteria));
	}
	
	@Override
	public TaskLists getTaskListNew(String tlTaskNo, String tlTrxType, String tlTaskStatus, Character tlTaskDone) {
		DetachedCriteria criteria = DetachedCriteria.forClass(TaskLists.class);
		criteria.add(Restrictions.eq("tlTaskNo", tlTaskNo));
		criteria.add(Restrictions.eq("tlTrxType", tlTrxType));
		return DataAccessUtils.uniqueResult(taskListDAO.findByCriteria(criteria));
	}

	@Override
	public TaskLists getTaskListForEPurchase(String tlTaskNo, String tlTrxType, String tlTaskStatus,
			Character tlTaskDone, String facilityCode, String ptjCode) {
		DetachedCriteria criteria = DetachedCriteria.forClass(TaskLists.class);
		criteria.add(Restrictions.eq("tlTaskNo", tlTaskNo));
		criteria.add(Restrictions.eq("tlTrxType", tlTrxType));
		criteria.add(Restrictions.eq("tlTaskStatus", tlTaskStatus));
		criteria.add(Restrictions.eq("tlTaskDone", tlTaskDone));
		if (facilityCode != null && !facilityCode.isEmpty())
			criteria.add(Restrictions.eq("tlFacilityCode", facilityCode));
		if (ptjCode != null && !ptjCode.isEmpty())
			criteria.add(Restrictions.eq("tlPTJCode", ptjCode));
		return DataAccessUtils.uniqueResult(taskListDAO.findByCriteria(criteria));
	}

	@Override
	public List<String> getAuthorizationReqRecords(SecUser secUser, ExternalFacility extFacility) {
		DataSource ds = (DataSource) SpringUtil.getBean("dataSource");
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<String> taskNoList = new ArrayList<String>();
		try {
			List<ExternalFacility> extFacilityList = getExternalFacilityService()
					.getFacilityCodebySeqNo(secUser.getFacilitySeqno());
			con = DataSourceUtils.doGetConnection(ds);
			StringBuffer query = new StringBuffer();
			query.append(" SELECT TL_TASK_NO FROM T_TASK_LISTS TASKLIST "
					+ " INNER JOIN T_PO_HDR POHDR ON TASKLIST.TL_TASK_NO=POHDR.LPO_NO WHERE POHDR.IS_AUTH_REQUIRED='"
					+ InventoryConstant.YES + "' " + " AND TASKLIST.TL_TASK_STATUS='"
					+ InventoryConstant.TASK_STATUS_OPEN + "' AND TL_TRX_TYPE='" + InventoryConstant.TL_TRX_TYPE_PAYMENT + "' ");
			if (extFacilityList != null && extFacilityList.size() > 0) {
				ExternalFacility externalFacility = extFacilityList.get(0);
				if (RefCodeConstant.USER_TYPE_PKD.equals(secUser.getUsrType())) {
					query.append(" and tl_ptj_code = '" + externalFacility.getPtjCode() + "' ");
				} else if (RefCodeConstant.USER_TYPE_KK.equals(secUser.getUsrType()) || RefCodeConstant.USER_TYPE_HOSPITAL.equals(secUser.getUsrType())) {
					query.append(" and tl_ptj_code = '" + externalFacility.getPtjCode() + "' and tl_facility_code = '" + externalFacility.getFacilityCode() + "' ");
				} else if (RefCodeConstant.USR_TYPE_HQ.equals(secUser.getUsrType())) {
					query.append(" and tl_ptj_code = '" + extFacility.getPtjCode() + "' and tl_facility_code = '" + extFacility.getFacilityCode() + "' ");
				} else {
					query.append(" and tl_ptj_code = '" + externalFacility.getPtjCode() + "' and tl_facility_code = '" + externalFacility.getFacilityCode() + "' ");
				}
			}
			ps = con.prepareStatement(query.toString());
			rs = ps.executeQuery();
			while (rs.next()) {
				String taskNo = rs.getString("TL_TASK_NO");
				taskNoList.add(taskNo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return taskNoList;

	}

	@Override
	public List<String> getAuthorizationKPKRecords(SecUser secUser, ExternalFacility extFacility, RefCodesService refcodeService, UserService userService) {
		DataSource ds = (DataSource) SpringUtil.getBean("dataSource");
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<String> taskNoList = new ArrayList<String>();
		try {
			List<ExternalFacility> extFacilityList = getExternalFacilityService()
					.getFacilityCodebySeqNo(secUser.getFacilitySeqno());
			con = DataSourceUtils.doGetConnection(ds);
			StringBuffer query = new StringBuffer();
			query.append(" SELECT TL_TASK_NO FROM T_TASK_LISTS TASKLIST"
					+ " INNER JOIN T_SPL_DRUG_REQUEST_INT SDR ON TASKLIST.TL_TASK_NO=SDR.BPF_REGISTER_NO"
					+ "  WHERE  TASKLIST.TL_TASK_STATUS='" + InventoryConstant.TASK_STATUS_OPEN + "'"
					/*+ " AND TL_TRX_TYPE='" + InventoryConstant.KPK_TRX_TYPE + "'");*/
					+ " AND TL_TRX_TYPE in ('Special Approval Medicine')" );
			if (extFacilityList != null && extFacilityList.size() > 0) {
				ExternalFacility externalFacility = extFacilityList.get(0);
				if (RefCodeConstant.USER_TYPE_PKD.equals(secUser.getUsrType())) {
					query.append(" and tl_ptj_code='" + externalFacility.getPtjCode() + "' ");
				} else if (RefCodeConstant.USER_TYPE_KK.equals(secUser.getUsrType())
						|| RefCodeConstant.USER_TYPE_HOSPITAL.equals(secUser.getUsrType())) {
					query.append(" and tl_ptj_code='" + externalFacility.getPtjCode() + "' and tl_facility_code='"
							+ externalFacility.getFacilityCode() + "' ");
				} else if (RefCodeConstant.USR_TYPE_HQ.equals(secUser.getUsrType())) {
					query.append(" and tl_ptj_code='" + extFacility.getPtjCode() + "' and tl_facility_code='" 
						+ extFacility.getFacilityCode() + "'  ");
				} else {
					query.append(" and tl_ptj_code='" + externalFacility.getPtjCode() + "' and tl_facility_code='"
							+ externalFacility.getFacilityCode() + "' ");
				}
			}
			
			RefCodes sdrSecretariat = refcodeService.getRefCodesListByDomain(RefCodeConstant.ROLE_SDR_SECRETARIAT).get(0);
			RefCodes sdrKetuaSeksyen = refcodeService.getRefCodesListByDomain(RefCodeConstant.ROLE_SDR_KETUA_SEKSYEN).get(0);
			RefCodes sdrTimbPengarah = refcodeService.getRefCodesListByDomain(RefCodeConstant.ROLE_SDR_TIMB_PENGARAH).get(0);
			RefCodes sdrPengarahAP = refcodeService.getRefCodesListByDomain(RefCodeConstant.ROLE_SDR_PENGARAH_AP).get(0);
			RefCodes sdrPKPF = refcodeService.getRefCodesListByDomain(RefCodeConstant.ROLE_SDR_PKPF).get(0);
			RefCodes sdrKPK = refcodeService.getRefCodesListByDomain(RefCodeConstant.ROLE_SDR_KPK).get(0);
			List<String> listSdrRole = new ArrayList<String>();
			listSdrRole.add(sdrSecretariat.getRcValue());
			listSdrRole.add(sdrKetuaSeksyen.getRcValue());
			listSdrRole.add(sdrTimbPengarah.getRcValue());
			listSdrRole.add(sdrPengarahAP.getRcValue());
			listSdrRole.add(sdrPKPF.getRcValue());
			listSdrRole.add(sdrKPK.getRcValue());
			
			List<SecRole> userRoles = userService.getRolesByUserForSdr(secUser, listSdrRole);
			if (userRoles != null) {
				for (SecRole role : userRoles) {
					if (role.getRolShortdescription().equalsIgnoreCase(sdrSecretariat.getRcValue())) {
					query.append(" and tl_status in ('New Request','Pending to Print Permit','Send For Approval') ");
					}
					if (role.getRolShortdescription().equalsIgnoreCase(sdrKetuaSeksyen.getRcValue())) {
						query.append(" and tl_status = 'Pending Ketua Seksyen Recommendation' ");
					}
					if (role.getRolShortdescription().equalsIgnoreCase(sdrTimbPengarah.getRcValue())) {
						query.append(" and tl_status = 'Pending Endorsement by TP' ");
					}
					if (role.getRolShortdescription().equalsIgnoreCase(sdrPengarahAP.getRcValue())) {
						query.append(" and tl_status = 'Pending Pengarah A&P Approval' ");
					}
					if (role.getRolShortdescription().equalsIgnoreCase(sdrPKPF.getRcValue())) {
						query.append(" and tl_status = 'Pending PKPF Approval' ");
					}
					if (role.getRolShortdescription().equalsIgnoreCase(sdrKPK.getRcValue())) {
						query.append(" and tl_status = 'Pending KPK Approval' ");
					}
				}
			}
			System.out.println("------------------ query SDR : " + query.toString());
			ps = con.prepareStatement(query.toString());
			rs = ps.executeQuery();
			while (rs.next()) {
				String taskNo = rs.getString("TL_TASK_NO");
				taskNoList.add(taskNo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(null != rs)rs.close();
				if(null != ps)ps.close();
				if(null != con)con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return taskNoList;

	}

	@Override
	public TaskLists getTaskListSdr(String tlTaskNo, String tlTrxType, String tlTaskStatus, Character tlTaskDone, String tlStatus) {
		DetachedCriteria criteria = DetachedCriteria.forClass(TaskLists.class);
		criteria.add(Restrictions.eq("tlTaskNo", tlTaskNo));
		criteria.add(Restrictions.eq("tlTrxType", tlTrxType));
		criteria.add(Restrictions.eq("tlTaskStatus", tlTaskStatus));
		criteria.add(Restrictions.eq("tlTaskDone", tlTaskDone));
		criteria.add(Restrictions.eq("tlStatus", tlStatus));
		return DataAccessUtils.uniqueResult(taskListDAO.findByCriteria(criteria));
	}
}