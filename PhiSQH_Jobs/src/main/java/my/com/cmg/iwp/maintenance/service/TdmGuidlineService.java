package my.com.cmg.iwp.maintenance.service;

import java.util.Set;

import my.com.cmg.iwp.maintenance.model.TdmGuidline;

public interface TdmGuidlineService {

	TdmGuidline getNewTdmGuidline();

	void delete(TdmGuidline tdmGuidline);

	void saveOrUpdate(TdmGuidline tdmGuidline);

	Set<TdmGuidline> findGuidelinesByHdrSeqNo(long seqNo);

}
