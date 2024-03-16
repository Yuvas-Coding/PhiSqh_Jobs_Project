package my.com.cmg.iwp.maintenance.service;

import java.util.List;

import my.com.cmg.iwp.maintenance.model.SecGroup;
import my.com.cmg.iwp.maintenance.model.SecGroupright;
import my.com.cmg.iwp.maintenance.model.SecRight;

public interface SecGrouprightService {

	SecGroupright getNewSecGroupright();

	List<SecRight> getRightsByGroup(SecGroup group);

	List<SecGroupright> getAllGroupRights();

	boolean isRightInGroup(SecRight right, SecGroup group);

	SecGroupright getGroupRightByGroupAndRight(SecGroup group, SecRight right);

	List<SecRight> getGroupRightsByGroup(SecGroup group);

	int getCountAllSecGrouprights();

	void saveOrUpdate(SecGroupright groupRight);

	void delete(SecGroupright groupRight);

}
