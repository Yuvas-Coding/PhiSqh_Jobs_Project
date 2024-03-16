package my.com.cmg.iwp.maintenance.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;
import org.zkoss.spring.SpringUtil;

import com.googlecode.genericdao.search.Filter;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.DistributionFacList;
import my.com.cmg.iwp.maintenance.model.ExternalFacility;
import my.com.cmg.iwp.maintenance.model.RefCodes;
import my.com.cmg.iwp.maintenance.service.ExternalFacilityService;
import my.com.cmg.iwp.maintenance.service.RefCodesService;
import my.com.cmg.iwp.webui.constant.RefCodeConstant;

@Service
public class ExternalFacilityServiceImpl implements ExternalFacilityService {

	private BasisNextidDaoImpl<ExternalFacility> externalFDaoImpl;
	private RefCodesService refCodesService;
	private BasisNextidDaoImpl<DistributionFacList> distributionFacilityDAO;


	public RefCodesService getRefCodesService() {
		return refCodesService;
	}

	public void setRefCodesService(RefCodesService refCodesService) {
		this.refCodesService = refCodesService;
	}
	
	public BasisNextidDaoImpl<DistributionFacList> getDistributionFacilityDAO() {
		return distributionFacilityDAO;
	}

	public void setDistributionFacilityDAO(BasisNextidDaoImpl<DistributionFacList> distributionFacilityDAO) {
		this.distributionFacilityDAO = distributionFacilityDAO;
	}

	public BasisNextidDaoImpl<ExternalFacility> getExternalFDaoImpl() {
		return externalFDaoImpl;
	}

	public void setExternalFDaoImpl(
			BasisNextidDaoImpl<ExternalFacility> externalFDaoImpl) {
		this.externalFDaoImpl = externalFDaoImpl;
	}

	@Override
	public ExternalFacility getNewExternalFacility() {
		// TODO Auto-generated method stub
		return new ExternalFacility();
	}

	@Override
	public void delete(ExternalFacility anExternalFacility) {
		externalFDaoImpl.delete(anExternalFacility);

	}

	@Override
	public void saveOrUpdate(ExternalFacility anExternalFacility) {
		externalFDaoImpl.saveOrUpdate(anExternalFacility);

	}

	@Override
	public ExternalFacility findByFacilityCode(String facilityCode) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(ExternalFacility.class);
		criteria.add(Restrictions.eq("facilityCode", facilityCode));
		return DataAccessUtils.uniqueResult(externalFDaoImpl
				.findByCriteria(criteria));

	}

	public ExternalFacility findByFacilityPrefixAndFacilityCode(
			String facilityPrefix, String facilityCode) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(ExternalFacility.class);
		criteria.add(Restrictions.eq("facilityCode", facilityCode));
		criteria.add(Restrictions.eq("facilityPrefix", facilityPrefix));
		return DataAccessUtils.uniqueResult(externalFDaoImpl
				.findByCriteria(criteria));
	}

	@Override
	public ExternalFacility findBySeqNo(long facilitySeqno) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(ExternalFacility.class);
		criteria.add(Restrictions.eq("facilitySeqno", facilitySeqno));
		return DataAccessUtils.uniqueResult(externalFDaoImpl
				.findByCriteria(criteria));

	}

	@Override
	public List<ExternalFacility> getExternalFacilities() {
		// TODO Auto-generated method stub
		return externalFDaoImpl.find("from ExternalFacility where activeFlag="
				+ "'" + "A" + "'");
	}

	@Override
	public List<ExternalFacility> getExternalFacilityCode() {
		return externalFDaoImpl
				.find("from ExternalFacility where facilityCode like '%'");
	}
	
	@Override
	public List<ExternalFacility> getFacilityCodebySeqNo(Long seqNo) {
		return externalFDaoImpl
				.find("from ExternalFacility where facilitySeqno=" + seqNo);
	}
	
	@Override
	public List<ExternalFacility> getFacilityCodesbyPtjCode(String ptjCode,String facilityType, ExternalFacility externalFacility) {
		StringBuilder query = new StringBuilder( "from ExternalFacility where ptjCode = '" + ptjCode + "' and activeFlag = 'A'" );
		if(facilityType != null) {
			query.append(" and facilityList = '"+facilityType+"' ");
		}else if(facilityType == null){
			query.append(" and facilityList in ('"+RefCodeConstant.FACILITY_CATEGORY_PKD+"','"+RefCodeConstant.FACILITY_CATEGORY_KK+"','"+RefCodeConstant.FACILITY_CATEGORY_MUSN_PBFN+"') ");
		}
		if(externalFacility != null && !isFaciltyTypeBudget(externalFacility) /*&& !CommonUtil.toBoolean(externalFacility.getHosMaintainanceAllowYn())*/){
			query.append(" and facilityCode <> '"+externalFacility.getFacilityCode()+"' ");
		}
		query.append(" order by yepLastRunDate desc");
		return externalFDaoImpl.find(query.toString());

	}
	
	@Override
	public List<ExternalFacility> getFacilityCodesbyPtjCode(String ptjCode,String facilityType, ExternalFacility externalFacility,List<String> facilityTypeListNot) {
		StringBuilder query = new StringBuilder( "from ExternalFacility where ptjCode = '" + ptjCode + "' and activeFlag = 'A' " );
		if(facilityType != null) {
			query.append(" and facilityList = '"+facilityType+"' ");
		}
		/*if(facilityTypeListNot!=null && !facilityTypeListNot.isEmpty()){
			query.append(" and facilityList not in ("+facilityTypeListNot+") ");
		}*/
		if(externalFacility != null && !isFaciltyTypeBudget(externalFacility) ){
			query.append(" and facilityCode <> '"+externalFacility.getFacilityCode()+"' ");
		}
		query.append(" order by yepLastRunDate desc");
		return externalFDaoImpl.find(query.toString());

	}
	
	@Override
	public List<ExternalFacility> getExternalFacilitySeqNobyFacilityCode(
			String s) {
		String query = "from ExternalFacility where facilityCode=\'" + s + "\'";
		return externalFDaoImpl.find(query);
	}
	
	/**
	 * public List<ExternalFacility> findAllRequesterUnit(String query) { return
	 * externalFDaoImpl.find(query);
	 * 
	 * }
	 **/

	@Override
	public List<ExternalFacility> getExternalFacilitySearchList(
			String facilityCode) {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(ExternalFacility.class);
		if (facilityCode != null) {
			detachedCriteria.add(Restrictions.eq("activeFlag", 'A'));
			detachedCriteria.addOrder(Order.desc("createdDate"));
			detachedCriteria.setFetchMode("epoapproval", FetchMode.LAZY);
			detachedCriteria.add(Restrictions.ilike("facilityCode", "%"
					+ facilityCode + "%"));
			detachedCriteria
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		}
		return externalFDaoImpl.findByCriteria(detachedCriteria);
	}

	@Override
	public ExternalFacility getExternalFacilitySearchByFacilityCode(String facilityCode) {
		DetachedCriteria criteria = DetachedCriteria.forClass(ExternalFacility.class).add(Restrictions.sqlRestriction("rownum <= 1"));
		criteria.add(Restrictions.eq("facilityCode", facilityCode));
		return DataAccessUtils.uniqueResult(externalFDaoImpl.findByCriteria(criteria));
	}

	@Override
	public ExternalFacility getExternalFacilitySearchByFacilityPrefix(
			String facilityPrefix) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(ExternalFacility.class).add(Restrictions.sqlRestriction("rownum <= 1"));
		criteria.add(Restrictions.eq("facilityPrefix", facilityPrefix));
		return DataAccessUtils.uniqueResult(externalFDaoImpl
				.findByCriteria(criteria));
	}

	public List findAllRequesterUnit(String query) {
		return externalFDaoImpl.find(query);

	}

	@Override
	public ExternalFacility findByFacilityPrefixAndPtjCode(
			String facilityPrefix, String ptjCode) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(ExternalFacility.class);
		criteria.add(Restrictions.eq("ptjCode", ptjCode));
		criteria.add(Restrictions.eq("facilityPrefix", facilityPrefix));
		return DataAccessUtils.uniqueResult(externalFDaoImpl
				.findByCriteria(criteria));
	}

	@Override
	public ExternalFacility findByFactCodeAndPtjCode(String factCode,
			String ptjCode) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(ExternalFacility.class);
		criteria.add(Restrictions.eq("ptjCode", ptjCode));
		criteria.add(Restrictions.eq("facilityCode", factCode));
		criteria.add(Restrictions.eq("activeFlag",RefCodeConstant.ACTIVE_FLAG_TRUE));
		return DataAccessUtils.uniqueResult(externalFDaoImpl
				.findByCriteria(criteria));
	}

	@Override
	public List<ExternalFacility> getAllTExternalFacilitiesLikeText(
			String searchCode, String searchDesc) {

		DetachedCriteria criteria = DetachedCriteria
				.forClass(ExternalFacility.class);

		if (!StringUtils.isEmpty(searchCode)) {
			criteria.add(Restrictions.ilike("facilityCode", searchCode,
					MatchMode.ANYWHERE));
		}

		if (!StringUtils.isEmpty(searchDesc)) {
			criteria.add(Restrictions.ilike("facilityName", searchDesc,
					MatchMode.ANYWHERE));
		}

		return externalFDaoImpl.findByCriteria(criteria);

	}
	
	@Override
	public List<ExternalFacility> getAllTExternalFacilities(String... type) {
		DetachedCriteria criteria = DetachedCriteria.forClass(ExternalFacility.class);
		criteria.add(Restrictions.in("facilityList", type));
		criteria.add(Restrictions.eq("activeFlag", RefCodeConstant.ACTIVE_FLAG_TRUE));
		return externalFDaoImpl.findByCriteria(criteria);
	}

	@Override
	public ExternalFacility findByPTJCode(String ptjCode) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(ExternalFacility.class);
		criteria.add(Restrictions.eq("ptjCode", ptjCode));
		return DataAccessUtils.uniqueResult(externalFDaoImpl
				.findByCriteria(criteria));
	}
	
	@Override
	public List<ExternalFacility> getAllTExternalFacilitiesbyPTJCode(String... ptjCode) {
		DetachedCriteria criteria = DetachedCriteria.forClass(ExternalFacility.class);
		criteria.add(Restrictions.in("ptjCode", ptjCode));
		criteria.add(Restrictions.eq("activeFlag", RefCodeConstant.ACTIVE_FLAG_TRUE));
		return externalFDaoImpl.findByCriteria(criteria);
	}
	@Override
	public List<ExternalFacility> getAllTExternalFacilitiesbyState(String... state) {
		DetachedCriteria criteria = DetachedCriteria.forClass(ExternalFacility.class);
		criteria.add(Restrictions.in("state", state));
		criteria.add(Restrictions.eq("activeFlag", RefCodeConstant.ACTIVE_FLAG_TRUE));
		return externalFDaoImpl.findByCriteria(criteria);
	}

	@Override
	public List<String> getPtjCodesCodesbyJkn(String jkn) {
		List<String> str = new ArrayList<String>();
		Session session = null;
		try {
			session = getExternalFDaoImpl().getSessionFactory().openSession();
			String query=" select  distinct ptj_code from t_external_facilities where jkn='"+jkn+"' ";
			List objectArrayList = session.createSQLQuery(query).list();
			if (objectArrayList != null) {
				return objectArrayList;
			} else {
				return null;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return str;
		
	}
	
	
	@Override
	public ExternalFacility findByPTJCodeAndFacilityType(String ptjCode) {
		DetachedCriteria criteria = DetachedCriteria.forClass(ExternalFacility.class);
		criteria.add(Restrictions.eq("ptjCode", ptjCode));
		criteria.add(Restrictions.eq("facilityList", "PKD"));
		criteria.add(Restrictions.eq("activeFlag", 'A'));
		return DataAccessUtils.uniqueResult(externalFDaoImpl.findByCriteria(criteria));
	}
	
	@Override
	public ExternalFacility findByPTJCodeAndFacilityCode(String ptjCode, String facilityCode) {
		DetachedCriteria criteria = DetachedCriteria.forClass(ExternalFacility.class);
		criteria.add(Restrictions.eq("ptjCode", ptjCode));
		criteria.add(Restrictions.eq("facilityCode", facilityCode)); 
		criteria.add(Restrictions.eq("facilityList", "PKD"));
		//criteria.add(Restrictions.eq("activeFlag", 'A'));
		return DataAccessUtils.uniqueResult(externalFDaoImpl.findByCriteria(criteria));
	}
	
	@Override
	public Filter getFacilityFilterForUser(String userType, ExternalFacility externalFacility) {
		if(RefCodeConstant.USER_TYPE_PKD.equals(userType)) {
			return Filter.equal("ptjCode", externalFacility.getPtjCode());
		}
		if(RefCodeConstant.USER_TYPE_KK.equals(userType) || RefCodeConstant.USER_TYPE_HOSPITAL.equals(userType) || userType == null) {
			return Filter.equal("facilityCode", externalFacility.getFacilityCode());
		}
		return null;
	}
	
	@Override
	public boolean isFacilityPKDorKK(String facilityCode,String ptjCode) {
		boolean isFacilityPKDorKK = false;
		String facilityType = this.findByFactCodeAndPtjCode(facilityCode,ptjCode).getFacilityList();
		isFacilityPKDorKK = RefCodeConstant.FACILITY_CATEGORY_PKD.equals(facilityType) 
							||RefCodeConstant.FACILITY_CATEGORY_KK.equals(facilityType);
		return isFacilityPKDorKK;
	}
	
	@Override
	public List<ExternalFacility> getFilteredExternalFacilities(String facilityCode,String state,List<String> type,ArrayList<String> facilityseq) {
		DetachedCriteria criteria = DetachedCriteria.forClass(ExternalFacility.class);
		criteria.add(Restrictions.in("facilityList", type));
		if(facilityCode != null && !facilityCode.isEmpty()) criteria.add(Restrictions.eq("facilityCode", facilityCode));
		if(state != null && !state.isEmpty()) criteria.add(Restrictions.eq("state", state));
		criteria.add(Restrictions.eq("activeFlag", RefCodeConstant.ACTIVE_FLAG_TRUE));
		if(facilityseq!=null && !facilityseq.isEmpty()){
			criteria.add(Restrictions.ne("facilityCode", facilityCode));
		}
		return externalFDaoImpl.findByCriteria(criteria);
	}

	@Override
	public ExternalFacility getExternalFacilitySearchByFacilityCodeAndPtjCode(String facilityCode, String ptjCode) {
		DetachedCriteria criteria = DetachedCriteria.forClass(ExternalFacility.class);
		criteria.add(Restrictions.eq("ptjCode", ptjCode));
		criteria.add(Restrictions.eq("facilityCode", facilityCode));
		criteria.add(Restrictions.eq("activeFlag", RefCodeConstant.ACTIVE_FLAG_TRUE));
		List<ExternalFacility> externalFacilities = externalFDaoImpl.findByCriteria(criteria);
		return externalFacilities.get(0);
	}

	@Override
	public List<ExternalFacility> getFacilityCodesbyPtjCode(String ptjCode,
			String facilityType, String usrType) {
		if(facilityType == null) {
			if(usrType !=null && !usrType.isEmpty() && RefCodeConstant.USR_TYPE_HQ.equals(usrType)
					){
				return externalFDaoImpl
				.find("from ExternalFacility where activeFlag = 'A' ");
			}else{
				
				DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ExternalFacility.class);
				List<String> facilityList = new ArrayList<String>();
				List<RefCodes> allowedUsers = refCodesService.getRefCodesByDomain(RefCodeConstant.BUDGET_MOVEMENT_FAC_TYPE);
				for (RefCodes refCode : allowedUsers) {
					facilityList.add(refCode.getRcValue().trim());
				}
				detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
				detachedCriteria.add(Restrictions.eq("activeFlag", RefCodeConstant.ACTIVE_FLAG_TRUE));
				detachedCriteria.add(Restrictions.eq("ptjCode", ptjCode));
				detachedCriteria.add(Restrictions.in("facilityList", facilityList));
				return externalFDaoImpl.findByCriteria(detachedCriteria);
			}
			
		} else {
			return externalFDaoImpl
					.find("from ExternalFacility where ptjCode = '" + ptjCode + "' and facilityList = '"+facilityType+"' and activeFlag = 'A' ");
		}
	}

	@Override
	public boolean isFaciltyTypeBudget(ExternalFacility externalFacility) {
		RefCodesService refCodesService = (RefCodesService) SpringUtil.getBean("refCodesService");
		List<RefCodes> allowedUsers = refCodesService.getRefCodesByDomain(RefCodeConstant.BUDGET_MOVEMENT_FAC_TYPE);
		for(RefCodes refCodes : allowedUsers) {
			if(refCodes.getRcValue().equals(externalFacility.getFacilityList())) return true;
		}
		return false;
	}

	@Override
	public ExternalFacility findByFacilityName(
			String facilityName) {

		DetachedCriteria criteria = DetachedCriteria.forClass(ExternalFacility.class);

		if (!StringUtils.isEmpty(facilityName)) {
			criteria.add(Restrictions.ilike("facilityName", facilityName,
					MatchMode.ANYWHERE));
		}
		List<ExternalFacility> data = externalFDaoImpl.findByCriteria(criteria);
		if (null != data && !data.isEmpty()) {
			return data.get(0);
		} else {
			return null;
		}
	} 

	@Override
	public List<ExternalFacility> getFacilityCodesbyFacType(String ptjCode, String facilityType) {

		StringBuilder query = new StringBuilder( "from ExternalFacility where ptjCode = '" + ptjCode + "' and activeFlag = 'A'" );
		if(facilityType != null) {
			query.append(" and facilityList = '"+facilityType+"' ");
		}
		
		query.append(" order by yepLastRunDate desc");
		return externalFDaoImpl.find(query.toString());
	}
	
	@Override
	public DistributionFacList getDistributionFacListByFacSeqNo(long facilitySeqNo) {
		DetachedCriteria criteria = DetachedCriteria.forClass(DistributionFacList.class);
		criteria.add(Restrictions.eq("facilitySeqno", facilitySeqNo));
		List <DistributionFacList> listDistributionFacList = distributionFacilityDAO.findByCriteria(criteria);
		return listDistributionFacList != null && listDistributionFacList.size() > 0 ? listDistributionFacList.get(0) : null ;
		
	}

	@Override
	public List<ExternalFacility> findbyCriteria(DetachedCriteria criteria) {
		return getExternalFDaoImpl().findByCriteria(criteria);
	}
	
	@Override
	public DistributionFacList getDistributionFacListByFacCode(String facilityCode) {
		DetachedCriteria criteria = DetachedCriteria.forClass(DistributionFacList.class);
		criteria.add(Restrictions.eq("facilityCode", facilityCode));
		List <DistributionFacList> listDistributionFacList = distributionFacilityDAO.findByCriteria(criteria);
		return listDistributionFacList != null && listDistributionFacList.size() > 0 ? listDistributionFacList.get(0) : null ;
		
	}	
	
	@Override
	public List<ExternalFacility> getFilteredExternalFacilities(String facilityCode,String state,List<String> type,ArrayList<String> facilityseq,Character isMOHFac) {
		DetachedCriteria criteria = DetachedCriteria.forClass(ExternalFacility.class);
		criteria.add(Restrictions.in("facilityList", type));
		if(facilityCode != null && !facilityCode.isEmpty()) criteria.add(Restrictions.eq("facilityCode", facilityCode));
		if(state != null && !state.isEmpty()) criteria.add(Restrictions.eq("state", state));
		criteria.add(Restrictions.eq("activeFlag", RefCodeConstant.ACTIVE_FLAG_TRUE));
		if(facilityseq!=null && !facilityseq.isEmpty()){
			criteria.add(Restrictions.ne("facilityCode", facilityCode));
		}
			criteria.add(Restrictions.eq("mohFacility", isMOHFac));
		return externalFDaoImpl.findByCriteria(criteria);
	}
	
}