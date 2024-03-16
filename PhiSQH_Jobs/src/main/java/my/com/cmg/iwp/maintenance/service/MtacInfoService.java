package my.com.cmg.iwp.maintenance.service;

import java.util.List;

import my.com.cmg.iwp.maintenance.model.MtacInfo;

public interface MtacInfoService {

	MtacInfo getNewMtacInfo();
	void delete(MtacInfo anMtacInfo);
	void saveOrUpdate(MtacInfo anMtacInfo);
	public MtacInfo getMtacInfoByMtacCode(String mtacCode);
	public List<MtacInfo> getAllMtacInfos();
	public List<MtacInfo> getActiveMtacInfos();
	MtacInfo findByMtacInfoCode(String value);
}
