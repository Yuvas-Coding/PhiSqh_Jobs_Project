package my.com.cmg.iwp.maintenance.service.fcSecService;

import java.util.List;

import my.com.cmg.iwp.maintenance.model.fcSecurityModel.FcSecGrouprights;
import my.com.cmg.iwp.maintenance.model.fcSecurityModel.FcSecGroups;
import my.com.cmg.iwp.maintenance.model.fcSecurityModel.FcSecRolegroups;

public interface FcSecGroupsService {

	FcSecGroups getNewSecGroup();

	FcSecGroups getSecGroupById(Long secGroup_id);

	FcSecGroups getGroupByGroupRight(FcSecGrouprights secGroupright);

	FcSecGroups getGroupByRolegroup(FcSecRolegroups secRolegroup);

	List<FcSecGroups> getGroupsLikeGroupName(String aGroupName);

	/* List<SecGroup> getGroupsByUser(SecUser aUser); */

	int getCountAllSecGroups();

	List<FcSecGroups> getAllGroups();

	void saveOrUpdate(FcSecGroups group);

	void delete(FcSecGroups group);

	FcSecGroups getSimilarGroupByGroupName(String value);

}
