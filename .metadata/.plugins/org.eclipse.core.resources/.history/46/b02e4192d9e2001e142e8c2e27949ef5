package my.com.cmg.iwp.maintenance.service;

import java.util.List;

import my.com.cmg.iwp.maintenance.model.SecGroup;
import my.com.cmg.iwp.maintenance.model.SecRole;
import my.com.cmg.iwp.maintenance.model.SecRolegroup;

public interface SecRolegroupService {

	SecRolegroup getNewSecRolegroup();

	List<SecGroup> getGroupsByRole(SecRole aRole);

	List<SecRolegroup> getAllRolegroups();

	SecRolegroup getRolegroupByRoleAndGroup(SecRole aRole, SecGroup aGroup);

	boolean isGroupInRole(SecGroup aGroup, SecRole aRole);

	int getCountAllSecRolegroups();

	void saveOrUpdate(SecRolegroup roleGroup);

	void delete(SecRolegroup roleGroup);

}
