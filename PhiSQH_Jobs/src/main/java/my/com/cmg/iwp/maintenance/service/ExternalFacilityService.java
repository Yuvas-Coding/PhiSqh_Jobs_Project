package my.com.cmg.iwp.maintenance.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.googlecode.genericdao.search.Filter;

import my.com.cmg.iwp.maintenance.model.DistributionFacList;
import my.com.cmg.iwp.maintenance.model.ExternalFacility;

public interface ExternalFacilityService {

	ExternalFacility getNewExternalFacility();

	void delete(ExternalFacility anExternalFacility);

	void saveOrUpdate(ExternalFacility anExternalFacility);

	ExternalFacility findByFacilityCode(String facilityCode);

	ExternalFacility findByPTJCode(String ptjCode);

	ExternalFacility findBySeqNo(long hosSeqno);

	List<ExternalFacility> getExternalFacilities();

	List<ExternalFacility> getExternalFacilityCode();

	public List<ExternalFacility> findAllRequesterUnit(String query);

	List<ExternalFacility> getExternalFacilitySeqNobyFacilityCode(String s);
	
	List<ExternalFacility> getFacilityCodebySeqNo(Long seqNo);

	List<ExternalFacility> getExternalFacilitySearchList(String facilityCode);

	ExternalFacility findByFacilityPrefixAndFacilityCode(String facilityPrefix, String facilityCode);

	ExternalFacility getExternalFacilitySearchByFacilityCode(String facilityCode);

	ExternalFacility getExternalFacilitySearchByFacilityPrefix(String facilityPrefix);

	ExternalFacility findByFacilityPrefixAndPtjCode(String facilityPrefix,
			String ptjCode);

	ExternalFacility findByFactCodeAndPtjCode(String factCode, String ptjCode);

	List<ExternalFacility> getAllTExternalFacilitiesLikeText(String searchCode,
			String searchDesc);
	
	List<ExternalFacility> getFacilityCodesbyPtjCode(String ptjCode,String facilityType,ExternalFacility externalFacility);
	
	public ExternalFacility findByPTJCodeAndFacilityType(String ptjcode);
	
	public ExternalFacility findByPTJCodeAndFacilityCode(String ptjcode, String facilityCode);
	
	Filter getFacilityFilterForUser(String userType, ExternalFacility externalFacility);

	boolean isFacilityPKDorKK(String facilityCode, String ptjCode);

	List<ExternalFacility> getAllTExternalFacilities(String... type);

	List<ExternalFacility> getFilteredExternalFacilities(String facilityCode, String state, List<String> type, ArrayList<String> facilityseq);

	ExternalFacility getExternalFacilitySearchByFacilityCodeAndPtjCode( String hospitalCode, String ptjCode);

	List<ExternalFacility> getFacilityCodesbyPtjCode(String ptjCode,String facilityType, String usrType);
	
	boolean isFaciltyTypeBudget(ExternalFacility externalFacility);
	
	public List<ExternalFacility> getFacilityCodesbyPtjCode(String ptjCode,String facilityType, ExternalFacility externalFacility,List<String> facilityTypeListNot);
	
	public List<String> getPtjCodesCodesbyJkn(String jkn);

	ExternalFacility findByFacilityName(String facilityName);
	
	List<ExternalFacility> getFacilityCodesbyFacType(String ptjCode,String facilityType);

	List<ExternalFacility> getAllTExternalFacilitiesbyPTJCode(String... ptjCode);
	
	List<ExternalFacility> getAllTExternalFacilitiesbyState(String... state);
	
	DistributionFacList getDistributionFacListByFacSeqNo(long facilitySeqNo);

	List<ExternalFacility> findbyCriteria(DetachedCriteria criteria);

	DistributionFacList getDistributionFacListByFacCode(String facilityCode);

	List<ExternalFacility> getFilteredExternalFacilities(String facilityCode,
			String state, List<String> type, ArrayList<String> facilityseq,
			Character isMOHFac);
}