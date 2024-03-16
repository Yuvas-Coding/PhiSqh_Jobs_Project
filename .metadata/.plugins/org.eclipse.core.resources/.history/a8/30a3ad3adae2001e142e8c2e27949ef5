package my.com.cmg.iwp.maintenance.service;

import java.util.List;

import my.com.cmg.iwp.maintenance.model.SecGroup;
import my.com.cmg.iwp.maintenance.model.SecGroupright;
import my.com.cmg.iwp.maintenance.model.SecRolegroup;
import my.com.cmg.iwp.maintenance.model.SecUser;

public interface SecGroupService {

	SecGroup getNewSecGroup();

	SecGroup getSecGroupById(Long secGroup_id);

	SecGroup getGroupByGroupRight(SecGroupright secGroupright);

	SecGroup getGroupByRolegroup(SecRolegroup secRolegroup);

	List<SecGroup> getGroupsLikeGroupName(String aGroupName);

	List<SecGroup> getGroupsByUser(SecUser aUser);

	int getCountAllSecGroups();

	List<SecGroup> getAllGroups();

	void saveOrUpdate(SecGroup group);

	void delete(SecGroup group);

	SecGroup getSimilarGroupByGroupName(String value);
}
