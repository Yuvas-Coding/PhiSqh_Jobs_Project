package my.com.cmg.iwp.maintenance.service;

import java.util.Date;

import my.com.cmg.iwp.maintenance.model.Item;
import my.com.cmg.iwp.maintenance.model.SecUser;
import my.com.cmg.iwp.maintenance.model.his.EPOHdrStg;

public interface EPOHdrStgService {

	void saveOrUpdateEPOPoHdrStg(EPOHdrStg epoHdrStg);

	Item getItem(String itemCode);

	Date getLPOTransmittedDate(Date lpoDate, String facilityCode, Integer deliveryLeadTime) throws Exception;

	SecUser getSecUserFetches(SecUser secUser);
}
