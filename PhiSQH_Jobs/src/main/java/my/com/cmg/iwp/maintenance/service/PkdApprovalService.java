package my.com.cmg.iwp.maintenance.service;

import java.util.List;

import my.com.cmg.iwp.maintenance.model.ExternalFacility;
import my.com.cmg.iwp.maintenance.model.PoHdr;
import my.com.cmg.iwp.maintenance.model.RefCodes;
import my.com.cmg.iwp.maintenance.model.SecUser;

public interface PkdApprovalService {
	List<ExternalFacility> getListForClinicName();

	List<PoHdr> getPkdApprovalPoHdrHqList();

	List<ExternalFacility> getFacilityListasPerPTJCode(String ptjCode);
	
	public String getRefCodeDescription(String rcDomain, String rcValue);
	
	public List<RefCodes> getRefCodeDescription(String rcDomain);
	
	public SecUser getPoHdrUser(String userId);
}
