package my.com.cmg.iwp.maintenance.service;

import java.util.List;
import java.util.Map;

import my.com.cmg.iwp.maintenance.model.NePContractInfo;

public interface NePContractInfoService {

	List<NePContractInfo> getContractInfoList();

	void saveOrUpdate(NePContractInfo nePContractInfo);
	
	List<NePContractInfo> findByProgram(Map<Object, Object> map);
}
