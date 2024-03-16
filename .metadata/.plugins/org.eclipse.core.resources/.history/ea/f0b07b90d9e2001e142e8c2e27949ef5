package my.com.cmg.iwp.maintenance.service.fcSecService;

import java.util.List;

import my.com.cmg.iwp.maintenance.model.fcSecurityModel.FcSecGrouprights;
import my.com.cmg.iwp.maintenance.model.fcSecurityModel.FcSecGroups;
import my.com.cmg.iwp.maintenance.model.fcSecurityModel.FcSecRights;

public interface FcSecGrouprightsService {

	FcSecGrouprights getNewSecGroupright();

	List<FcSecRights> getRightsByGroup(FcSecGroups group);

	List<FcSecGrouprights> getAllGroupRights();

	boolean isRightInGroup(FcSecRights right, FcSecGroups group);

	FcSecGrouprights getGroupRightByGroupAndRight(FcSecGroups group, FcSecRights right);

	List<FcSecRights> getGroupRightsByGroup(FcSecGroups group);

	int getCountAllSecGrouprights();

	void saveOrUpdate(FcSecGrouprights groupRight);

	void delete(FcSecGrouprights groupRight);

}
