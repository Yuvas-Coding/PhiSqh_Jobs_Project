package my.com.cmg.iwp.maintenance.service;

import java.util.List;

import my.com.cmg.iwp.maintenance.model.AtcDetail;
import my.com.cmg.iwp.maintenance.model.GenericName;

public interface AtcDetailService {

	AtcDetail getNewAtcDetail();

	void delete(AtcDetail anAtcDetail);

	void saveOrUpdate(AtcDetail anAtcDetail);

	List<AtcDetail> getAllAtcDetailList();

	List<AtcDetail> findATCbyCodeLevel(String code, int level);

	List<AtcDetail> findATCbyLevel(int atcLevel);

	AtcDetail getAtcDetail(String atcCode);

	List<AtcDetail> findATCbyCodeLevel5(String code, int level);

	AtcDetail getAtcDetailByCodeLevel(String atcCode, int level);

	List<AtcDetail> findByAtcDetailCode(String atcCode);

	List<AtcDetail> getAllAtcDetailList(GenericName genericName);
	
	public List<AtcDetail> findLevel5AtcDetailByCode(String atcCode);

	List<AtcDetail> findLevel5AtcDetailByCode(String atcCode, List<Long> atcSeq);
}
