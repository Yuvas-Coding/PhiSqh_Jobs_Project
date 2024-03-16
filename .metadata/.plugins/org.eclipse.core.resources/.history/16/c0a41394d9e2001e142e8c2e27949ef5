package my.com.cmg.iwp.backend.service.drugInfo;

import java.util.List;

import my.com.cmg.iwp.backend.model.druglnfo.DiHdr;
import my.com.cmg.iwp.backend.model.druglnfo.EnquiryDetail;



public interface DrugInfoService {

	DiHdr getNewDiHdr();

	void saveOrUpdate(DiHdr anDiHdr);

	List<DiHdr> findDihdr(String query);

	List<DiHdr> getDihdr();

	DiHdr getDiHdr(long seqNo);

	DiHdr findDiHdrByDeptSeqNo(long deptSeqno);

	void saveOrUpdate(EnquiryDetail enquiryDetail);

	DiHdr getDiHdrByReqNo(String diNo);
}