package my.com.cmg.iwp.maintenance.service;

import java.util.List;

import my.com.cmg.iwp.maintenance.model.SecGroupright;
import my.com.cmg.iwp.maintenance.model.SecRight;
import my.com.cmg.iwp.maintenance.model.SecUser;

public interface SecRightService {

	SecRight getNewSecRight();

	List<SecRight> getAllRights();

	List<SecRight> getAllRights(int type);

	List<SecRight> getAllRights(List<Integer> aListOfRightTyps);

	SecRight getRightById(Long right_id);

	List<SecRight> getRightsByGroupright(SecGroupright secGroupright);

	List<SecRight> getRightsByUser(SecUser user);

	List<SecRight> getRightsLikeRightName(String aRightName);

	List<SecRight> getRightsLikeRightNameAndTypes(String aRightName,
			List<Integer> listOfRightTyps);

	List<SecRight> getRightsLikeRightNameAndType(String aRightName,
			int aRightType);

	int getCountAllSecRights();

	void delete(SecRight right);

	void saveOrUpdate(SecRight right);

	SecRight getSimilarRightByRightName(String value);

}
