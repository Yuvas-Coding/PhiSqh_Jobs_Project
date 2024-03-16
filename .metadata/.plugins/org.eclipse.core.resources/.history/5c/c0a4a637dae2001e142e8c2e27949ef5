package my.com.cmg.iwp.backend.service;

import java.util.List;

import my.com.cmg.iwp.UserWorkspace;
import my.com.cmg.iwp.backend.model.TaskLists;
import my.com.cmg.iwp.common.util.HibernateSearchObject;
import my.com.cmg.iwp.maintenance.model.ExternalFacility;
import my.com.cmg.iwp.maintenance.model.SecUser;
import my.com.cmg.iwp.maintenance.service.RefCodesService;
import my.com.cmg.iwp.maintenance.service.UserService;

/**
 * @author Tapan Kumar Sabat
 *
 */
public interface TaskListService {
	//public HibernateSearchObject<TaskLists> displayTaskList(UserWorkspace userWorkspace,SecUser secUser);
	//public HibernateSearchObject<TaskLists> displayTaskList(UserWorkspace userWorkspace,SecUser secUser, ExternalFacility externalFaility);
	public TaskLists getTaskListsByTlSeqno(long tlSequenceNo);
	public TaskLists getTaskListsByTxSeqnoAndStatus(long txSequenceNo,String tlTaskStatus);
	public TaskLists getTaskListsByTxSeqnoAndStatus(long txSequenceNo, String tlTaskStatus, String txType);
	public void saveOrUpdate(TaskLists taskLists);
	
	public TaskLists getTaskList(String tlTaskNo, String tlTrxType, String tlTaskStatus, Character tlTaskDone);
	//public List<String> getAuthorizationReqRecords() ;
	//List<String> getAuthorizationKPKRecords(SecUser secUser);
	public TaskLists getTaskListForEPurchase(String tlTaskNo, String tlTrxType, String tlTaskStatus, Character tlTaskDone,String facilityCode,String ptjCode);
	//List<String> getAuthorizationKPKRecords(SecUser secUser, ExternalFacility extFacility);
	public List<String> getAuthorizationReqRecords(SecUser secUser, ExternalFacility extFacility) ;
	public TaskLists getTaskListSdr(String tlTaskNo, String tlTrxType, String tlTaskStatus, Character tlTaskDone, String tlStatus);
	List<String> getAuthorizationKPKRecords(SecUser secUser, ExternalFacility extFacility,
			RefCodesService refcodeService, UserService userService);
	HibernateSearchObject<TaskLists> displayTaskList(UserWorkspace userWorkspace, SecUser secUser,
			ExternalFacility externalFacility, RefCodesService refcodeService, UserService userService);
	TaskLists getTaskListNew(String tlTaskNo, String tlTrxType, String tlTaskStatus, Character tlTaskDone);
}
