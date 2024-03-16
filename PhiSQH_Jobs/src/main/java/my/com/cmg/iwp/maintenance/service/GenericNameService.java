package my.com.cmg.iwp.maintenance.service;

import java.util.List;

import my.com.cmg.iwp.maintenance.model.AtcDetail;
import my.com.cmg.iwp.maintenance.model.GenericName;
import my.com.cmg.iwp.maintenance.model.ResultObject;

public interface GenericNameService {

	GenericName getNewGenericName();

	void delete(GenericName genericName);

	void saveOrUpdate(GenericName genericName);

	List<GenericName> getAllGenericName();

	AtcDetail getNewAtcDetail();

	List<GenericName> findByGenericDesc(String genericCode);

	ResultObject getAllGenericNameLikeText(String searchGenericCode,
			String searchGenericName, int start, int pageSize);

	GenericName findByGenericCode(String genericCode);

	boolean isNewGenericName(GenericName genericName);
	
	String getMimsMapping(GenericName genericName);
}
