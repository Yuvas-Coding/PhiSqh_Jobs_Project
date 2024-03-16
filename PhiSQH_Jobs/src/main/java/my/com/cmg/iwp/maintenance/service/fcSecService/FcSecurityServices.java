/**
 * Copyright 2010 the original author or authors.
 * 
 * This file is part of Zksample2. http://zksample2.sourceforge.net/
 *
 * Zksample2 is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * Zksample2 is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Zksample2.  If not, see <http://www.gnu.org/licenses/gpl.html>.
 */
package my.com.cmg.iwp.maintenance.service.fcSecService;

import java.util.List;

import my.com.cmg.iwp.maintenance.model.fcSecurityModel.FcSecGrouprights;
import my.com.cmg.iwp.maintenance.model.fcSecurityModel.FcSecGroups;
import my.com.cmg.iwp.maintenance.model.fcSecurityModel.FcSecRights;
import my.com.cmg.iwp.maintenance.model.fcSecurityModel.FcSecRolegroups;
import my.com.cmg.iwp.maintenance.model.fcSecurityModel.FcSecRoles;
import my.com.cmg.iwp.maintenance.model.fcSecurityModel.FcSecTyp;

public interface FcSecurityServices {	

	/* +++++ Security: Roles +++++++ */
	public int getCountAllSecRole();

	public FcSecRoles getNewSecRole();

	public List<FcSecRoles> getAllRoles();

	public void saveOrUpdate(FcSecRoles role);

	public void delete(FcSecRoles role);

	/* +++++ Security: RoleGroups +++++++ */
	public int getCountAllSecRolegroup();

	public FcSecRolegroups getNewSecRolegroup();

	public void saveOrUpdate(FcSecRolegroups secRolegroup);

	public void delete(FcSecRolegroups roleGroup);

	public List<FcSecRolegroups> getAllRolegroups();

	public FcSecRolegroups getRolegroupByRoleAndGroup(FcSecRoles role, FcSecGroups group);

	public boolean isGroupInRole(FcSecGroups group, FcSecRoles role);

	/* +++++ Security: Groups +++++++ */

	public int getCountAllSecGroup();

	public List<FcSecGroups> getAllGroups();

	public FcSecGroups getNewSecGroup();

	public void saveOrUpdate(FcSecGroups secGroup);

	public void delete(FcSecGroups group);

	/* +++++ Security: Rights +++++++ */
	public int getCountAllSecRights();

	public FcSecRights getNewSecRight();

	public void delete(FcSecRights right);

	public void saveOrUpdate(FcSecRights right);

	/**
	 * Get all rights. The result can limited by the type.<br>
	 * <br>
	 * Int | Type <br>
	 * --------------------------<br>
	 * -1 | All (no filter) <br>
	 * 0 | Page <br>
	 * 1 | Menu Category <br>
	 * 2 | Menu Item <br>
	 * 3 | Method <br>
	 * 4 | DomainObject/Property <br>
	 * 5 | Tab <br>
	 * 6 | Components <br>
	 */
	public List<FcSecRights> getAllRights(int type);

	public List<FcSecRights> getAllRights(List<Integer> list);

	public boolean isRightinGroup(FcSecRights right, FcSecGroups group);

	/* +++++ Security: Grouprights +++++++ */

	public int getCountAllSecGroupright();

	public List<FcSecGrouprights> getAllGroupRights();

	public FcSecGrouprights getNewSecGroupright();

	public void delete(FcSecGrouprights groupRight);

	public void saveOrUpdate(FcSecGrouprights groupRight);

	/* +++++ Security: Security Typs +++++++ */
	public List<FcSecTyp> getAllTypes();

	public FcSecTyp getTypById(int typ_id);

	/* +++++++++++++++++++++++++++++++++++++++++++ */

	public FcSecGrouprights getGroupRightByGroupAndRight(FcSecGroups group, FcSecRights right);

	public List<FcSecRights> getRightsLikeRightName(String value);

	public List<FcSecRights> getRightsLikeRightNameAndType(String value, int type);

	public List<FcSecGroups> getGroupsLikeGroupName(String value);

	public List<FcSecRoles> getRolesLikeRoleName(String value);

	public List<FcSecRights> getGroupRightsByGroup(FcSecGroups group);

	public List<FcSecRights> getRightsLikeRightNameAndTypes(String value, List<Integer> list);

	List<FcSecGroups> getGroupsByRole(FcSecRoles aRole);

	List<FcSecRights> getRightsByGroupright(FcSecGrouprights secGroupright);

	FcSecRights getRightById(Long right_id);

	FcSecRoles getRoleById(Long role_Id);

	List<FcSecRights> getRightsByGroup(FcSecGroups group);

	FcSecGroups getSecGroupById(Long secGroup_id);

	FcSecGroups getGroupByGroupRight(FcSecGrouprights secGroupright);

	FcSecGroups getGroupByRolegroup(FcSecRolegroups secRolegroup);

	public List<FcSecRights> getAllRights();

	List<FcSecGroups> getGroupRightsByGroup(FcSecRights rights);

	List<FcSecRoles> getGroupRightsByGroup(FcSecRoles roles);

}
