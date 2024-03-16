package my.com.cmg.iwp.maintenance.service;

import java.util.List;

import my.com.cmg.iwp.maintenance.model.Drug;
import my.com.cmg.iwp.maintenance.model.RpElement;
import my.com.cmg.iwp.maintenance.model.SecUser;

public interface RpElementService {

	RpElement getNewRpElement();

	RpElement getRpElementByElement(String element);

	void delete(RpElement RpElement);

	void saveOrUpdate(RpElement RpElement);

	public List<RpElement> getAllRpElements();

	void addRpElementDrugs(RpElement rpElement, Drug drug, SecUser user);

}
