package my.com.cmg.iwp.maintenance.service;

import java.util.List;

import my.com.cmg.iwp.backend.model.sdr.SpecialDrugAdditionalDoc;
import my.com.cmg.iwp.backend.model.sdr.SpecialDrugApproval;
import my.com.cmg.iwp.backend.model.sdr.SpecialDrugRequestOrder;
import my.com.cmg.iwp.backend.model.sdr.SpecialDrugRequestOrderArc;

public interface SpecialDrugRequestOrderService {

	void saveOrUpdate(SpecialDrugRequestOrder specialDrugRequestOrder);

	List<SpecialDrugRequestOrder> getAllSendRecord();
	
	String getBpf(String regStatus);

	SpecialDrugRequestOrder findByFacCodeHosReqNo(String facCode,
			String hosReqNo);

	SpecialDrugRequestOrder getSpecialDrugRequestByCode(String remarks);

	SpecialDrugRequestOrder findByFacCodePPFRegNo(String facCode,
			String ppfRegNo);

	SpecialDrugAdditionalDoc findByHosReqNoFacCodePtjCode(String hosRequestNo, String facCode, String ptjCode,
			long addDocSeqno);

	void saveOrUpdate(SpecialDrugAdditionalDoc SpecialDrugAdditionalDoc);

	List<SpecialDrugApproval> findByCategoryType(String category, String type);

	List<SpecialDrugApproval> getLisResultSpecialDrugApproval(String where);

	SpecialDrugRequestOrderArc getSpecialDrugRequestOrderARC(long seqno);

	void createSDRTasklist(SpecialDrugRequestOrder specialDrugRequestOrder);
}
