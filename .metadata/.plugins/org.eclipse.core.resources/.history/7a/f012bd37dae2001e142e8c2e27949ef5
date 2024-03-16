package my.com.cmg.iwp.maintenance.service.fcSecService;

import java.util.List;

import my.com.cmg.iwp.maintenance.model.fcSecurityModel.FcSecGrouprights;
import my.com.cmg.iwp.maintenance.model.fcSecurityModel.FcSecRights;

/**/

public interface FcSecRightsService {

	FcSecRights getNewSecRight();

	List<FcSecRights> getAllRights();

	List<FcSecRights> getAllRights(int type);

	List<FcSecRights> getAllRights(List<Integer> aListOfRightTyps);

	FcSecRights getRightById(Long right_id);

	List<FcSecRights> getRightsByGroupright(FcSecGrouprights secGroupright);

	/* List<SecRight> getRightsByUser(SecUser user); */

	List<FcSecRights> getRightsLikeRightName(String aRightName);

	List<FcSecRights> getRightsLikeRightNameAndTypes(String aRightName, List<Integer> listOfRightTyps);

	List<FcSecRights> getRightsLikeRightNameAndType(String aRightName, int aRightType);

	int getCountAllSecRights();

	void delete(FcSecRights right);

	void saveOrUpdate(FcSecRights right);

	FcSecRights getSimilarRightByRightName(String value);

	/* boolean isRightPresent(SecUser user, String rightName); */

}
