package my.com.cmg.iwp.maintenance.service;

import java.util.List;
import java.util.Map;

import my.com.cmg.iwp.maintenance.model.DoDtl;
import my.com.cmg.iwp.maintenance.model.PoHdr;
import my.com.cmg.iwp.maintenance.model.ResultObject;

public interface DoDtlService {
	public ResultObject getAllDoDetails(int start, int pageSize);
	public List<DoDtl> getAllDetails();
	public DoDtl getDoDtlByCriteria(String lpoNo);
	public List<DoDtl> findByItemCode(String itemCode, String lpoNo,
			String facilityCode, String ptjCode, String purchaseOrderNo, String facility_type);
	public List<DoDtl> getDistinctDo(String lpoNo, String itemCode,
			Character kkRcvFlag);
	
	public String statusPOSendToEP(String lpoNo,String facilityCode, String ptjCode);
	Map<String, Integer> getDOInOutLogCount(String dateFrom, String dateTo);
	double getTotalOrderAmount(PoHdr poHdr, String facility_type);
	
	public DoDtl getNewDoDtl();
	
	public void saveOrUpdate(DoDtl anDoDtl);
	
	public DoDtl findByDoNo(String value);
}
