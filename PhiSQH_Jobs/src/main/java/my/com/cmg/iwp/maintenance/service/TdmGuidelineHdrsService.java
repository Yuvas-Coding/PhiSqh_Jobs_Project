package my.com.cmg.iwp.maintenance.service;

import my.com.cmg.iwp.maintenance.model.TdmGuidelineHdrs;

public interface TdmGuidelineHdrsService {

	TdmGuidelineHdrs getNewTdmGuidelineHdrs();

	void delete(TdmGuidelineHdrs tdmGuidelineHdrs);

	void saveOrUpdate(TdmGuidelineHdrs tdmGuidelineHdrs);

	TdmGuidelineHdrs findBySeqNo(long seqNo);

	TdmGuidelineHdrs findByGuidelineSeqNo(long seqNo);

}
