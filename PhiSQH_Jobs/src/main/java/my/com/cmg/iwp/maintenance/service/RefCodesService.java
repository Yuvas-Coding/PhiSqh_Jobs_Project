package my.com.cmg.iwp.maintenance.service;

import java.util.List;

import my.com.cmg.iwp.maintenance.model.IntegrationBean;
import my.com.cmg.iwp.maintenance.model.RefCodes;


public interface RefCodesService {
	
	public List<RefCodes> getAllRefCodes();

	public List<IntegrationBean> findIntegrationByCriteria(String intType,
			String dateFrom, String dateTo);

	RefCodes getNewRefCode();

	void delete(RefCodes anRefCode);

	void saveOrUpdate(RefCodes anRefCode);

	List<RefCodes> getDesc(String domain);

	List<RefCodes> getRefCodesByDomain(String domain);

	RefCodes getRefCodeByRcDesc(String domain, String rcDesc);

	RefCodes getRefCodeByRcValue(String domain, String rcValue);
	
	RefCodes getRefCodeByRcValueIgnoreCaseSensitive(String domain, String rcValue);

	List<RefCodes> getDescOrderbySeqNo(String domain);

	List<RefCodes> getAllRefCode();

	List<RefCodes> getRefCodesByDomain(String domain, String[] orderBy);

	List<RefCodes> getRefCodesByDomainException(String holidayType,
			String weekend);

	List<RefCodes> getAscOrderbySeqNo(String domain);

	List<RefCodes> getTdmCalculators(String domain, List<String> list);
	
	List<RefCodes> getDistinctRefCode();

	List<String> getRefCodeDomainList(String domainName);

	List<RefCodes> getRefCodesByDomainAndParamter1(String domain, String paramter1);
	List<RefCodes> getRefCodesByDomainAndParamter1Sort(String domain, boolean order);

	List<RefCodes> getRefCodesByValues(String domain, List<String> list);

	List<RefCodes> getAscOrderbySeqNo(String domain, String sortProperty);

	List<RefCodes> getRefCodesListByDomain(String domain);

	List<String> getRefCodeValuesForRcDesc(String domainName, String rcDesc);
}
