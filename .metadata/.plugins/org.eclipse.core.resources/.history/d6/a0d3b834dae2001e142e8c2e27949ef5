package my.com.cmg.iwp.backend.service.integration.tdm;

import java.util.List;

import my.com.cmg.iwp.backend.model.integration.tdm.SamplingDetailsInt;
import my.com.cmg.iwp.backend.model.integration.tdm.TdmOrderInt;

public interface TdmOrderIntService {

	void saveOrUpdate(TdmOrderInt tdmOrderInt);

	TdmOrderInt findTDMOrderByID(long id);
	
	void saveOrUpdate(SamplingDetailsInt samplingDetailsInt);

	SamplingDetailsInt findSamplingDetailByID(long id);
	
	List<TdmOrderInt> getTdmOrderInts(String status);
	
	void updateTdmOrderInt(List<Long> seqnos, String sendFlag);

	void save(SamplingDetailsInt samplingDetailsInt);

	void save(TdmOrderInt tdmOrderInt);

	boolean isNotExisted(String tdmNo, String fromPtjCode, String fromFacilityCode);

	TdmOrderInt getTdmOrderIntByTdmNo(String tdmNo, String fromPtjCode, String fromFacilityCode);
	
}
