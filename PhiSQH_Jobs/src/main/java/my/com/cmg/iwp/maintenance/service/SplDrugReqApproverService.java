package my.com.cmg.iwp.maintenance.service;

import java.util.List;

import my.com.cmg.iwp.maintenance.model.SplDrugReqApprover;

public interface SplDrugReqApproverService {

	SplDrugReqApprover getNewSplDrugReqApprover();

	void saveOrUpdate(SplDrugReqApprover splDrugReqApprover);

	List getRecommendedByUser(String approverDomain);

	List getRecommendedByapproverValue(String approverValue);
}
