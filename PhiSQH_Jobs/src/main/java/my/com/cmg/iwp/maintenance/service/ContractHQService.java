package my.com.cmg.iwp.maintenance.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import my.com.cmg.iwp.maintenance.model.Brand;
import my.com.cmg.iwp.maintenance.model.ContractDtl;
import my.com.cmg.iwp.maintenance.model.ContractFacility;
import my.com.cmg.iwp.maintenance.model.ContractHdr;
import my.com.cmg.iwp.maintenance.model.ContractItemQty;
import my.com.cmg.iwp.maintenance.model.Drug;
import my.com.cmg.iwp.maintenance.model.ExternalFacility;
import my.com.cmg.iwp.maintenance.model.Item;
import my.com.cmg.iwp.maintenance.model.ItemSubgroup;
import my.com.cmg.iwp.maintenance.model.NonDrug;
import my.com.cmg.iwp.maintenance.model.RefCodes;
import my.com.cmg.iwp.maintenance.model.SecUser;
import my.com.cmg.iwp.maintenance.model.Supplier;

public interface ContractHQService {

	void saveOrUpdateContractHQ(ContractHdr contractHdr);

	List<Item> getItemDetails(String type, String itemGroup, Drug drug, NonDrug nonDrug);

	List<Item>  getItemDetailsByCriteria(String itemGroup, Drug drug, NonDrug nonDrug, String itemCode,String itemDesc,String type);

	List<ContractHdr> getHQContractHdrList(String itemcode,ContractHdr hdr);

	List<ContractHdr> getContractHQHdr(ContractHdr hqContractHdrs);

	Item getItem(Item item);

	Item getItemFromItemCode(String itemCode);

	Item getItemFromItemSeq(long itemSeqNo);

	List<ItemSubgroup> getDrugSubGroup();

	List<ItemSubgroup> getNonDrugSubGroup();

	List<RefCodes> getContractStatus(String contractHqStatus,
			String contractStatus);

	void saveOrupdate(ContractDtl hqContractDtl);

	List<ContractDtl> getContractDtlfordelete(Long seqno);

	List<ContractHdr> getContractHdrListByDrugCode(String drugCode);

	List<ContractHdr> getContractHdrListByDrugName(String drugName);

	List<ContractHdr> getContractHdrListwithDrugDetails(Long seqno);

	List<ContractHdr> findRecords(String kkmContract, String supplierName, String status, Drug drug, NonDrug nondrug, Date StartDate, Date EndDate);

	List<ExternalFacility> getExternalFacility(String facilityType, String state);

	List<ContractDtl> getActiveItem(ContractHdr hqContractHdrs);

	List<ContractDtl> checkSupplier(ContractHdr hqContractHdr,
			Supplier supplier);

	List<ContractDtl> checkActiveItem(ContractHdr hqContractHdr);

	int totalAllocatedQty(ContractHdr hqContractHdr);

	List<ContractHdr> checkUniqueContractNo(String trim);

	List<Item> getDefaultItemsFromDrug(Drug drug);

	List<Item> getDefaultItemsFromNonDrug(NonDrug nonDrug);

	int totalAdditionalQty(ContractHdr hqContractHdr);

	List<ItemSubgroup> getItemSubgroup(String drugDbValue);

	List<ExternalFacility> getAllFacilityName();

	RefCodes getRefCodeByRcValue(String domain, String rcValue);

	List<ExternalFacility> getAllFacilityName(String facilityDesc, String facilityCode, String state, String type);

	List<ContractHdr> getHdrList(String contractNo);

	SecUser getSecUserFromLoginName(String loginId);

	String getStateNameFromStateCode(String facilityState);

	String getFacilityNameFromFacilityCode(String facilityCode);

	Supplier getSupplierFromSupplierCode(long supplierSeqNo);

	Brand getBrand(long BrandSeqNo);

	ContractItemQty getHqContractItemQty(ContractItemQty contractItemQty);

	ContractDtl getContractDtl(ContractDtl contractDtl);

	ContractFacility getContractFacility(ContractFacility contractFacility);

	ContractHdr findBySeqno(Long hqHdrSeqno);

	List<ContractFacility> findContractFacility(String activeFlag);

	void updateContract(List<Long> seqnos, String sendFlag);
	
	Brand getBrandByBrandCode(String brandCode);
	
	Long getNewRevisedNumber(ContractHdr contractHdr);
	
	int effectiveStartDateEndDateCheckForContractItem(final String contractNo,final Long revisedNo,final Long itemSeqNo,String startDate,String endDate, ContractHdr contractHdr);

	ContractHdr getContractHdr(String contractNo, Integer revision);
	
	ContractHdr getContractHdrByContractNoAndRevision(String contractNo,long revision);

	ContractFacility getNewContractFacility(ContractHdr contractHdr,String itemCode,SecUser secUser,ExternalFacility externalFacility);
	
	ContractHdr addAllFacilities(ContractHdr contractHdr, String itemCode, SecUser secUser,List<ExternalFacility> externalFacilities,BigDecimal quantity);

	List<ExternalFacility> getFilteredExternalFacilitiesForContract(String facilityCode, String state, String facType, ArrayList<String> facilityseq, Character isMohFac);
	
	List<String> getContractFacilityCategories();

	boolean checkFacilityType(String facilityCode, String facilityType);

	List<ContractFacility> getcontractFacilitiesByContractHdr(
			ContractHdr contractHdr);

	Map<String, Long> getItemAllocatedQty(Long hdrSeqno, String facSeqnos);

	ContractHdr getContractFacilityDtlList(ContractHdr hdr);

	void deleteContractFacilityDetails(List<String> deletedfinalContractFacilities, Long hqHdrSeqno);
	void deleteContractPenaltyDetails(String formulacode, Long hqHdrSeqno);

	ContractHdr getcontract(Item items);
	
	

}
