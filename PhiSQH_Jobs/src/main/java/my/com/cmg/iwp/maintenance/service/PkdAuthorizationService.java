package my.com.cmg.iwp.maintenance.service;

import java.util.Date;
import java.util.List;

import my.com.cmg.iwp.maintenance.model.CBMaster;
import my.com.cmg.iwp.maintenance.model.ExternalFacility;
import my.com.cmg.iwp.maintenance.model.Item;
import my.com.cmg.iwp.maintenance.model.PoCfHdr;
import my.com.cmg.iwp.maintenance.model.PoDtl;
import my.com.cmg.iwp.maintenance.model.PoHdr;
import my.com.cmg.iwp.maintenance.model.SecUser;
import my.com.cmg.iwp.maintenance.model.VoteCode;

public interface PkdAuthorizationService {
	List<ExternalFacility> findAllClinicNameAndId();

	List<PoHdr> getPoHdrList();

	void saveOrUpdate(PoDtl PoDtl);

	void saveOrUpdatePoHdr(PoHdr PoHdr);

	List<PoDtl> getPodtlList(Long seqno);

	List<ExternalFacility> getFacilityListasPerPTJCode(String ptjCode);

	List<ExternalFacility> getFacilityListasPerFacilityCode(String facilityCode);

	List<ExternalFacility> getCLNListByPtjCode(String ptjCode);

	List<PoHdr> getPoHdrListForFacility(List<ExternalFacility> listExternalFacility, String... status);

	SecUser getSecUserFetches(SecUser secUser);

	String getRefCodeDescription(String rcDomain, String rcValue);
	
	void printReport(PoHdr poHdrHq);
	
	List<ExternalFacility> getFacilityList_PTJCode_FacilityCode(String ptjCode,String facilityCode);
	
	List<PoHdr> getPoHdrListForFacilityForAuthorizationOffline(List<ExternalFacility> listExternalFacility,ExternalFacility externalFacility, String orderNo, Date orderDate,
			boolean isOfflineRequest, String itemgroup,String financialYear);

	double getTotalOrderAmount(PoHdr poHdr);

	VoteCode isVoteCodeInValid(PoHdr poHdr);

	List<ExternalFacility> getCLNListByPtjCode(String ptjCode, String usrType);

	boolean isUserTypeBudget(SecUser secUser);
	
	
	List<PoHdr> getPoHdrListForHospital(List<ExternalFacility> listExternalFacility,ExternalFacility externalFacility);
	
	List<PoHdr> getPoHdrListForOfflineEP(List<ExternalFacility> listExternalFacility, ExternalFacility externalFacility,
			String epoStatus, String orderNo, String lpoNo, Date orderDate);

	PoHdr getPoForTaskList(long poSeqNo);

	Long previousApprovedQty(long itemSeqno, String financilYear, String facilityCode,long poHdrSeqno);

	boolean isLPOAlreadyExists(String lpoNo, String orderNo,
			String facilitycode);

	List<PoHdr> getPoHdrListForFacilityForAuthorization(List<ExternalFacility> listExternalFacility,
			ExternalFacility currentFacility, String orderNo, Date orderDate, boolean isOfflineRequest,
			String financialYear, String itemgroup);

	List<Long> findPOByYearAndNonePayment(String fcICurFinCyc, String facilityCode);

	String getForwardTransactionNo(String financialYear);

	void saveOrUpdate(PoCfHdr poCfHdr);

	List<PoCfHdr> findByLpoNo(String lpoNo);

	CBMaster getBudgetMaster(String budgetType, VoteCode voteCode, int financialYear);

	void updateBudgetForCarryForward(CBMaster anCBMaster, Double amount, String transactionNo, String fcICode,
			String fcIPtjcode);

	void updateOriginalPODetails(CBMaster anCBMaster, Item item, long usrID, String lpoNo, String facilityCode, String ptjCode);

	List<String> findLPOFromPOCarryForward(String financialYear, String facilityCode);

	List<PoCfHdr> getPoCarryForwardList(
			List<ExternalFacility> listExternalFacility,ExternalFacility externalFacility, String lpoNo,
			String transactionNo, String selectedItem, String selectedItem2,String value, String text);

	List<Object> getCountDetailsForDrugRegistryPrint(Long userId);
	
}
