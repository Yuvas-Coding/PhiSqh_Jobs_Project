package my.com.cmg.iwp.maintenance.service.fcSecService;

import java.util.List;

import my.com.cmg.iwp.maintenance.model.fcSecurityModel.FcSecGroups;
import my.com.cmg.iwp.maintenance.model.fcSecurityModel.FcSecRolegroups;
import my.com.cmg.iwp.maintenance.model.fcSecurityModel.FcSecRoles;

/**/

public interface FcSecRolegroupsService {

	FcSecRolegroups getNewSecRolegroup();

	List<FcSecGroups> getGroupsByRole(FcSecRoles aRole);

	List<FcSecRolegroups> getAllRolegroups();

	FcSecRolegroups getRolegroupByRoleAndGroup(FcSecRoles aRole, FcSecGroups aGroup);

	boolean isGroupInRole(FcSecGroups aGroup, FcSecRoles aRole);

	int getCountAllSecRolegroups();

	void saveOrUpdate(FcSecRolegroups roleGroup);

	void delete(FcSecRolegroups roleGroup);

	/* List<SecRolegroup> getSecGroupBy(SecUser secUser); */

}
