package my.com.cmg.iwp.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;

import my.com.cmg.iwp.backend.util.CommonUtilities;
import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.RefCodes;
import my.com.cmg.iwp.webui.constant.RefCodeConstant;

/**
 * @author Tapan Kumar Sabat
 *
 */
public class RefCodesUtils {
	
	private transient static final Logger logger = Logger.getLogger(RefCodesUtils.class);
	private BasisNextidDaoImpl<RefCodes> refCodesDAO;
	private static final String SORT_COLUMN_RCVALUE = "rcValue";
	private static final String SORT_COLUMN_RCDESC = "rcDesc";
	private static final String SORT_COLUMN_RCSEQ = "rcSeq";
	private static final String SORT_COLUMN_PARAM = "paramter1";
	private static Date mapUpdatedDate; 
	
	/**
	 * @return
	 */
	public Map<String,Map<String,RefCodes>> getRefCodesMap() {
		long startTime = System.currentTimeMillis();
		System.gc();
		long freeMemory = Runtime.getRuntime().freeMemory();
		Map<String,Map<String,RefCodes>> refCodesMainMap = new HashMap<String, Map<String,RefCodes>>();
		DetachedCriteria criteria = DetachedCriteria.forClass(RefCodes.class);
		criteria.add(Restrictions.eq("rcStatus", RefCodeConstant.ACTIVE_FLAG_TRUE.toString()));
		criteria.addOrder(Order.asc("rcDomain"));
		List<RefCodes> refCodeList = getRefCodesDAO().findByCriteria(criteria);
		String domain = null;
		Map<String,RefCodes> refCodesInnerMap = new HashMap<String,RefCodes>(); 
		if(refCodeList != null) {
			RefCodes refCode = refCodeList.get(0);
			domain = refCode.getRcDomain();
			for(RefCodes refCodes : refCodeList) {
				if(refCodes.getRcDomain().equals(domain)) {
					refCodesInnerMap.put(refCodes.getRcValue(),refCodes);
				} else {
					refCodesMainMap.put(domain, refCodesInnerMap);
					refCodesInnerMap = new HashMap<String,RefCodes>();
					domain = refCodes.getRcDomain();
					refCodesInnerMap.put(refCodes.getRcValue(),refCodes);
				}
			}
			refCodesMainMap.put(domain, refCodesInnerMap);
		}
		setMapUpdatedDate(new Date());
		System.gc();
		logger.trace("Time Taken To Load RefCodes Map :: "+(System.currentTimeMillis() - startTime)+" milisec");
		//logger.trace("Size of RefCodes Map :: "+((Runtime.getRuntime().freeMemory() - freeMemory))+" bytes");
		return refCodesMainMap;
	}
	
	/**
	 * @param rcDomain
	 * @param rcValue
	 * @return
	 */
	public RefCodes getRefCodeByRcValue_REFMAP(String rcDomain, String rcValue) {
		RefCodes refCodes = null;
		Map<String,RefCodes> innerMap = null;
		if(rcDomain != null && rcValue != null) {
			if(MyApplicationContextAware.isRefCodesMapExists) {
				innerMap = MyApplicationContextAware.getRefCodesMap().get(rcDomain);
				if(innerMap == null || innerMap.get(rcValue) == null) {
					DetachedCriteria criteria = DetachedCriteria.forClass(RefCodes.class);
					Criterion criterion = Restrictions.eq("rcDomain", rcDomain);
					Criterion criterion2 = Restrictions.ilike("rcValue", rcValue.trim());
					criteria.add(Restrictions.and(criterion, criterion2));
					refCodes = DataAccessUtils.uniqueResult(getRefCodesDAO().findByCriteria(criteria));
					if(refCodes != null) CommonUtilities.loadRefCodesMap();
				} else {
					return innerMap.get(rcValue);
				}
			} else {
				DetachedCriteria criteria = DetachedCriteria.forClass(RefCodes.class);
				Criterion criterion = Restrictions.eq("rcDomain", rcDomain);
				Criterion criterion2 = Restrictions.ilike("rcValue", rcValue.trim());
				criteria.add(Restrictions.and(criterion, criterion2));
				refCodes = DataAccessUtils.uniqueResult(getRefCodesDAO().findByCriteria(criteria));
				if(refCodes != null) CommonUtilities.loadRefCodesMap();
			}
		}
		
		return refCodes;
	}
	
	/**
	 * @param rcDomain
	 * @param rcValues
	 * @return
	 */
	public List<RefCodes> getRefCodeByRcValues_REFMAP(String rcDomain, List<String> rcValues) {
		List<RefCodes> returnList = new ArrayList<RefCodes>();
		Map<String,RefCodes> innerMap = null;
		boolean notPresentInRefMap = false;
		if(rcDomain != null && rcValues != null) {
			if(MyApplicationContextAware.isRefCodesMapExists) {
				innerMap = MyApplicationContextAware.getRefCodesMap().get(rcDomain);
				
				for(String rcValue : rcValues) {
					if(innerMap.get(rcValue) != null) {
						returnList.add(innerMap.get(rcValue));
					} else {
						notPresentInRefMap = true;
						break;
					}
				}
				if(notPresentInRefMap) {
					DetachedCriteria criteria = DetachedCriteria.forClass(RefCodes.class);
					Criterion criterion = Restrictions.eq("rcDomain", rcDomain);
					Criterion criterion2 = Restrictions.in("rcValue", rcValues);
					criteria.add(Restrictions.and(criterion, criterion2));
					returnList = getRefCodesDAO().findByCriteria(criteria);
					if(returnList != null) CommonUtilities.loadRefCodesMap();
				}
			} else {
				DetachedCriteria criteria = DetachedCriteria.forClass(RefCodes.class);
				Criterion criterion = Restrictions.eq("rcDomain", rcDomain);
				Criterion criterion2 = Restrictions.in("rcValue", rcValues);
				criteria.add(Restrictions.and(criterion, criterion2));
				returnList = getRefCodesDAO().findByCriteria(criteria);
				if(returnList != null) CommonUtilities.loadRefCodesMap();
			}
		}
		return returnList;
	}
	
	/**
	 * @param rcDomain
	 * @param propertyName
	 * @param isASC
	 * @return
	 */
	public List<RefCodes> getRefCodeByRcDomain_REFMAP(String rcDomain,String propertyName,boolean isASC) {
		List<RefCodes> returnList = null;
		Map<String,RefCodes> innerMap = null;
		if(MyApplicationContextAware.isRefCodesMapExists) {
			innerMap = MyApplicationContextAware.getRefCodesMap().get(rcDomain);
			if(innerMap == null || innerMap.values() == null) {
				DetachedCriteria criteria = DetachedCriteria.forClass(RefCodes.class);
				criteria.add(Restrictions.eq("rcDomain", rcDomain));
				criteria.add(Restrictions.eq("rcStatus", "A"));
				if(propertyName != null) {
					criteria.addOrder(isASC ? Order.asc(propertyName) : Order.desc(propertyName));
				}
				returnList = getRefCodesDAO().findByCriteria(criteria);
				if(returnList != null) CommonUtilities.loadRefCodesMap();
			} else {
				returnList = new ArrayList<RefCodes>(innerMap.values());
				if(propertyName != null) sortList(returnList,propertyName);
				return returnList;
			}
		} else {
			DetachedCriteria criteria = DetachedCriteria.forClass(RefCodes.class);
			criteria.add(Restrictions.eq("rcDomain", rcDomain));
			criteria.add(Restrictions.eq("rcStatus", "A"));
			if(propertyName != null) {
				criteria.addOrder(isASC ? Order.asc(propertyName) : Order.desc(propertyName));
			}
			returnList = getRefCodesDAO().findByCriteria(criteria);
			if(returnList != null) CommonUtilities.loadRefCodesMap();
		}
		return returnList;
	}
	
	/**
	 * @param list
	 * @param propertyName
	 */
	private void sortList(List<RefCodes> list, String propertyName) {
		if(SORT_COLUMN_RCVALUE.equals(propertyName)) {
			Collections.sort(list,new CompareRefCodesByRCVALUE());
		} else if(SORT_COLUMN_RCDESC.equals(propertyName)) {
			Collections.sort(list,new CompareRefCodesByRCDESC());
		} else if(SORT_COLUMN_RCSEQ.equals(propertyName)) {
			Collections.sort(list,new CompareRefCodesByRCSEQ());
		} else if(SORT_COLUMN_PARAM.equalsIgnoreCase(propertyName)) {
			Collections.sort(list, new CompareRefCodesByParameter1());
		}
	}
	
	/*COMPARATOR CLASSES*/
	/**
	 * 1. Compare by RCSEQ
	 */
	class CompareRefCodesByRCSEQ implements Comparator<RefCodes> {
		@Override
		public int compare(RefCodes refCodes1, RefCodes refCodes2) {
			return Long.valueOf(refCodes1.getRcSeq()).compareTo(Long.valueOf(refCodes2.getRcSeq()));
		}
	}

	/**
	 * 2. Compare by RCVALUE
	 */
	class CompareRefCodesByRCVALUE implements Comparator<RefCodes> {
		@Override
		public int compare(RefCodes refCodes1, RefCodes refCodes2) {
			return refCodes1.getRcValue().compareTo(refCodes2.getRcValue());
		}
	}
	
	/**
	 * 3. Compare by RCDESC
	 */
	class CompareRefCodesByRCDESC implements Comparator<RefCodes> {
		@Override
		public int compare(RefCodes refCodes1, RefCodes refCodes2) {
			return refCodes1.getRcDesc().compareTo(refCodes2.getRcDesc());
		}
	}
	
	/**
	 * 4. Compare by PARAMETER1
	 */
	class CompareRefCodesByParameter1 implements Comparator<RefCodes> {
		@Override
		public int compare(RefCodes refCodes1, RefCodes refCodes2) {
			return refCodes1.getParamter1().compareTo(refCodes2.getParamter1());
		}
	}

	/*ACCESSORS AND MUTATORS*/
	public BasisNextidDaoImpl<RefCodes> getRefCodesDAO() { return refCodesDAO; }
	public void setRefCodesDAO(BasisNextidDaoImpl<RefCodes> refCodesDAO) { this.refCodesDAO = refCodesDAO; }
	public static Date getMapUpdatedDate() { return mapUpdatedDate; }
	public static void setMapUpdatedDate(Date mapUpdatedDate) { RefCodesUtils.mapUpdatedDate = mapUpdatedDate; }
}
