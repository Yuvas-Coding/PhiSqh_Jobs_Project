package my.com.cmg.iwp.maintenance.service.impl;

import java.awt.Component;
import java.awt.Window;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.Query;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;
import org.zkoss.spring.SpringUtil;
import org.zkoss.util.resource.Labels;
import org.zkoss.zk.ui.Executions;

import my.com.cmg.iwp.common.util.LazyInitializer;
import my.com.cmg.iwp.maintenance.dao.impl.PkdAuthorizationDAOImpl;
import my.com.cmg.iwp.maintenance.dao.impl.PoCfDAOImpl;
import my.com.cmg.iwp.maintenance.model.CBMaster;
import my.com.cmg.iwp.maintenance.model.ExternalFacility;
import my.com.cmg.iwp.maintenance.model.Item;
import my.com.cmg.iwp.maintenance.model.PoCfHdr;
import my.com.cmg.iwp.maintenance.model.PoDtl;
import my.com.cmg.iwp.maintenance.model.PoHdr;
import my.com.cmg.iwp.maintenance.model.RefCodes;
import my.com.cmg.iwp.maintenance.model.SecUser;
import my.com.cmg.iwp.maintenance.model.VoteCode;
import my.com.cmg.iwp.maintenance.service.ExternalFacilityService;
import my.com.cmg.iwp.maintenance.service.PkdAuthorizationService;
import my.com.cmg.iwp.maintenance.service.SecUserService;
import my.com.cmg.iwp.webui.constant.RefCodeConstant;
import my.com.cmg.iwp.webui.pkd.PurchaseOrderReportCallingClass;
import my.com.cmg.iwp.webui.util.DateUtil;
import my.com.cmg.phis.util.constant.InventoryConstants;
@Service
public class PkdAuthorizationServiceImpl implements PkdAuthorizationService {
	private PkdAuthorizationDAOImpl pkdAuthorizationDAO;
	private ExternalFacilityService externalFacilityService;
	private SecUserService secUserService;
	private PoCfDAOImpl poCfDAO; 

	/************ ACCESSORS and MUTATORS***********/
	public PkdAuthorizationDAOImpl getPkdAuthorizationDAO() { return pkdAuthorizationDAO; }
	public void setPkdAuthorizationDAO(PkdAuthorizationDAOImpl pkdAuthorizationDAO) { this.pkdAuthorizationDAO = pkdAuthorizationDAO; }
	public ExternalFacilityService getExternalFacilityService() { return externalFacilityService; }
	public void setExternalFacilityService(ExternalFacilityService externalFacilityService) { this.externalFacilityService = externalFacilityService; }
	public SecUserService getSecUserService() { return secUserService; }
	public void setSecUserService(SecUserService secUserService) { this.secUserService = secUserService; }
	
	public PoCfDAOImpl getPoCfDAO() {
		return poCfDAO;
	}
	public void setPoCfDAO(PoCfDAOImpl poCfDAO) {
		this.poCfDAO = poCfDAO;
	}
	/**********************************************/
	
	@Override
	public List<ExternalFacility> findAllClinicNameAndId() {
		DetachedCriteria criteria = DetachedCriteria
		.forClass(ExternalFacility.class);
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		criteria.addOrder(Order.asc("facilityCode"));
		return pkdAuthorizationDAO.findByCriteria(criteria);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PoHdr> getPoHdrList() {
		// String query =
		// "from PoHdr as poHdr join fetch poHdr.poDtls as poDtls "
		// + "join fetch poDtls.item as item "
		// // + "join fetch item.itemBatch "
		// + "join fetch poHdr.deliveredTo as deliveredTo";
		//
		// System.out.println("query ----------- >> "+query);
		// return pkdAuthorizationDAO.find(query);

		DetachedCriteria detachedCriteria = DetachedCriteria
		.forClass(PoHdr.class);
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		detachedCriteria.setFetchMode("poDtls", FetchMode.JOIN);
		detachedCriteria.setFetchMode("poDtls.item", FetchMode.JOIN);
		detachedCriteria.setFetchMode("deliveredTo", FetchMode.JOIN);
		return pkdAuthorizationDAO.findByCriteria(detachedCriteria);

	}

	@SuppressWarnings("unchecked")
	@Override
	public void saveOrUpdate(PoDtl PoDtl) {
		pkdAuthorizationDAO.saveOrUpdate(PoDtl);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void saveOrUpdatePoHdr(PoHdr PoHdr) {
		pkdAuthorizationDAO.saveOrUpdate(PoHdr);
	}

	@Override
	public List<PoDtl> getPodtlList(Long seqno) {
		String query = "from PoDtl as PoDtl "
			+ "join fetch PoDtl.poHdr as PoHdr "
			// + "join fetch PoDtl.itemBrand as itemBrand "
			+ "join fetch PoDtl.item as item "
			// + "join fetch item.itemBatchs "
			+ "where PoHdr.PoHdrSeqno=" + seqno;

		System.out.println("query === >>" + query);
		return pkdAuthorizationDAO.find(query);
	}

	@Override
	public List<ExternalFacility> getFacilityListasPerPTJCode(String ptjCode) {
		String query = "select all ef from ExternalFacility ef where ef.ptjCode="
			+ "'" + ptjCode + "'";
		return pkdAuthorizationDAO.find(query);

		/*
		 * String query = "select distinct(facilityCode) from ExternalFacility";
		 * System.out.println("query ----------- >> "+query); return
		 * pkdApprovalDAO.find(query);
		 */
	}

	public List<ExternalFacility> getFacilityListasPerFacilityCode(
			String facilityCode) {
		String query = "select all ef from ExternalFacility ef where ef.facilityCode="
			+ "'" + facilityCode + "'";
		return pkdAuthorizationDAO.find(query);

		/*
		 * String query = "select distinct(facilityCode) from ExternalFacility";
		 * System.out.println("query ----------- >> "+query); return
		 * pkdApprovalDAO.find(query);
		 */
	}

	@Override
	public List<ExternalFacility> getCLNListByPtjCode(String ptjCode) {
		// TODO Auto-generated method stub
		DetachedCriteria detachedCriteria = DetachedCriteria
		.forClass(ExternalFacility.class);
		List<String> facilityList = new ArrayList<String>();
		facilityList.add(RefCodeConstant.FACILITY_CATEGORY_KK);
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		detachedCriteria.add(Restrictions.eq("activeFlag", RefCodeConstant.ACTIVE_FLAG_TRUE));
		detachedCriteria.add(Restrictions.eq("ptjCode", ptjCode));
		detachedCriteria.add(Restrictions.in("facilityList", facilityList));
		return pkdAuthorizationDAO.findByCriteria(detachedCriteria);
	}
	@Override
	public List<ExternalFacility> getCLNListByPtjCode(String ptjCode,
			String usrType) {

		DetachedCriteria detachedCriteria = DetachedCriteria
		.forClass(ExternalFacility.class);
		List<String> facilityList = new ArrayList<String>();
		facilityList.add(RefCodeConstant.FACILITY_CATEGORY_KK);
		facilityList.add(RefCodeConstant.FACILITY_CATEGORY_PKD);
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		detachedCriteria.add(Restrictions.eq("activeFlag", RefCodeConstant.ACTIVE_FLAG_TRUE));
		if(!RefCodeConstant.USR_TYPE_HQ.equals(usrType)) {
			detachedCriteria.add(Restrictions.eq("ptjCode", ptjCode));
		}
		detachedCriteria.add(Restrictions.in("facilityList", facilityList));
		return pkdAuthorizationDAO.findByCriteria(detachedCriteria);
		
	}
	
	@Override
	public List<PoHdr> getPoHdrListForFacility(List<ExternalFacility> listExternalFacility, String... status) {
		List<String> facilityCodeList = new ArrayList<String>();
		for (ExternalFacility externalFacility : listExternalFacility) {
			facilityCodeList.add(externalFacility.getFacilityCode());
		}
		if(null != listExternalFacility && listExternalFacility.size() > 0)
		{
			DetachedCriteria detachedCriteria = DetachedCriteria
			.forClass(PoHdr.class);
			detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			detachedCriteria.add(Restrictions.in("orderStatus", status));
			detachedCriteria.setFetchMode("poDtls", FetchMode.JOIN);
			detachedCriteria.setFetchMode("poDtls.item", FetchMode.JOIN);
			detachedCriteria.setFetchMode("deliveredTo", FetchMode.JOIN);
			detachedCriteria.add(Restrictions.in("facilityCode", facilityCodeList));
			detachedCriteria.addOrder(Order.desc("purchaseOrderNo"));
			return pkdAuthorizationDAO.findByCriteria(detachedCriteria);
		}
		else
			return new ArrayList<PoHdr>(0);

	}
	
	@Override
	public List<PoHdr> getPoHdrListForFacilityForAuthorizationOffline(List<ExternalFacility> listExternalFacility,
			ExternalFacility currentFacility, String orderNo, Date orderDate,boolean isOfflineRequest,String itemgroup,String financialYear) {
		List<String> facilityCodeList = new ArrayList<String>();
		for (ExternalFacility externalFacility : listExternalFacility) {
			facilityCodeList.add(externalFacility.getFacilityCode());
		}
		if(null != listExternalFacility && listExternalFacility.size() > 0) {
			DetachedCriteria detachedCriteria = DetachedCriteria.forClass(PoHdr.class);
			detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			Criterion criterion1;
			if(isOfflineRequest)
			{
			Criterion Criterion = Restrictions.and(Restrictions.eq("purchaseOrderType",RefCodeConstant.PO_REQUEST_TYPE_APPL),Restrictions.eq("applOfflineYn",RefCodeConstant.BOOLEAN_YES));
			detachedCriteria.add(Criterion);
			}
			else
			{
			criterion1 = Restrictions.or(Restrictions.eq("purchaseOrderType", RefCodeConstant.PO_REQUEST_TYPE_CONTRACT), Restrictions.eq("purchaseOrderType", RefCodeConstant.PO_REQUEST_TYPE_LP));
			Criterion criterion2 = Restrictions.and(Restrictions.eq("orderStatus", InventoryConstants.PO_STATUS.PO_STATUS_EP_APPROVED),criterion1);
			Criterion contractCriterion = Restrictions.and(criterion2,Restrictions.or(Restrictions.eq("pkdSyncFlag", RefCodeConstant.BOOLEAN_NO), Restrictions.eq("isAuthRequired", RefCodeConstant.BOOLEAN_TRUE)));
			detachedCriteria.add(Restrictions.or(Restrictions.eq("orderStatus", InventoryConstants.PO_STATUS.PO_STATUS_SEND_PKD_APPROVED),contractCriterion));
			}
			if (null != orderNo && orderNo.trim().length() > 0) {
				System.out.println("orderNo "+orderNo);
				detachedCriteria.add(Restrictions.ilike("purchaseOrderNo", "%"+orderNo+"%"));
			}
			if(!itemgroup.equals("All")){
				detachedCriteria.add(Restrictions.eq("itemGroup", itemgroup.equals("DRUG")?"D":"N"));
			}
			if (null != orderDate) {
				detachedCriteria.add(Restrictions.ge("createdDate", DateUtil.getFormattedDateFrom(orderDate)));
				detachedCriteria.add(Restrictions.le("createdDate", DateUtil.getFormattedDateTo(orderDate)));
			}
			detachedCriteria.add(Restrictions.eq("financialYear", financialYear));
			detachedCriteria.add(Restrictions.in("facilityCode", facilityCodeList));
			if(!isOfflineRequest)
				detachedCriteria.add(Restrictions.and(Restrictions.eq("purchaseOrderType",RefCodeConstant.PO_REQUEST_TYPE_APPL),Restrictions.eq("applOfflineYn",RefCodeConstant.BOOLEAN_NO)));

			detachedCriteria.addOrder(Order.desc("createdDate"));
			detachedCriteria.addOrder(Order.desc("purchaseOrderNo"));
			return pkdAuthorizationDAO.findByCriteria(detachedCriteria);
		} else
			return new ArrayList<PoHdr>(0);

	}
	
	@Override
	public List<PoHdr> getPoHdrListForFacilityForAuthorization(List<ExternalFacility> listExternalFacility,
			ExternalFacility currentFacility, String orderNo, Date orderDate,boolean isOfflineRequest, String financialYear , String itemgroup ) {
		List<String> facilityCodeList = new ArrayList<String>();
		for (ExternalFacility externalFacility : listExternalFacility) {
			facilityCodeList.add(externalFacility.getFacilityCode());
		}
		if(null != listExternalFacility && listExternalFacility.size() > 0) {
			DetachedCriteria detachedCriteria = DetachedCriteria.forClass(PoHdr.class);
			detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			Criterion criterion1;
			if(isOfflineRequest)
			{
			Criterion Criterion = Restrictions.and(Restrictions.eq("purchaseOrderType",RefCodeConstant.PO_REQUEST_TYPE_APPL),Restrictions.eq("applOfflineYn",RefCodeConstant.BOOLEAN_YES));
			detachedCriteria.add(Criterion);
			}
			else
			{
			criterion1 = Restrictions.or(Restrictions.eq("purchaseOrderType", RefCodeConstant.PO_REQUEST_TYPE_CONTRACT), Restrictions.eq("purchaseOrderType", RefCodeConstant.PO_REQUEST_TYPE_LP));
			Criterion criterion2 = Restrictions.and(Restrictions.eq("orderStatus", InventoryConstants.PO_STATUS.PO_STATUS_EP_APPROVED),criterion1);
			Criterion contractCriterion = Restrictions.and(criterion2,Restrictions.or(Restrictions.eq("pkdSyncFlag", RefCodeConstant.BOOLEAN_NO), Restrictions.eq("isAuthRequired", RefCodeConstant.BOOLEAN_TRUE)));
			detachedCriteria.add(Restrictions.or(Restrictions.eq("orderStatus", InventoryConstants.PO_STATUS.PO_STATUS_SEND_PKD_APPROVED),contractCriterion));
			}
			if (null != orderNo && orderNo.trim().length() > 0) {
				System.out.println("orderNo "+orderNo);
				detachedCriteria.add(Restrictions.ilike("purchaseOrderNo", "%"+orderNo+"%"));
			}
			if (null != orderDate) {
				detachedCriteria.add(Restrictions.ge("createdDate", DateUtil.getFormattedDateFrom(orderDate)));
				detachedCriteria.add(Restrictions.le("createdDate", DateUtil.getFormattedDateTo(orderDate)));
			}
			detachedCriteria.add(Restrictions.eq("financialYear", financialYear));
			detachedCriteria.add(Restrictions.in("facilityCode", facilityCodeList));
			
			if(!itemgroup.equals("All")){
				detachedCriteria.add(Restrictions.eq("itemGroup", itemgroup.equals("DRUG")?"D":"N"));
			}
			if(!isOfflineRequest)
			{
				Criterion purchasecredieria=Restrictions.and(Restrictions.eq("purchaseOrderType",RefCodeConstant.PO_REQUEST_TYPE_APPL),Restrictions.eq("applOfflineYn",RefCodeConstant.BOOLEAN_NO));
				detachedCriteria.add(Restrictions.or(Restrictions.in("purchaseOrderType", new String[] {RefCodeConstant.PO_REQUEST_TYPE_LP,RefCodeConstant.PO_REQUEST_TYPE_CONTRACT}),purchasecredieria));
				//detachedCriteria.add(Restrictions.and(Restrictions.eq("purchaseOrderType",RefCodeConstant.PO_REQUEST_TYPE_APPL),Restrictions.eq("applOfflineYn",RefCodeConstant.BOOLEAN_NO)));
			}
			detachedCriteria.addOrder(Order.desc("createdDate"));
			detachedCriteria.addOrder(Order.desc("purchaseOrderNo"));
			return pkdAuthorizationDAO.findByCriteria(detachedCriteria);
		} else
			return new ArrayList<PoHdr>(0);

	}

	@Override
	public SecUser getSecUserFetches(SecUser secUser) {
		return getSecUserService().getSecUserFetches(secUser);
	}

	@Override
	public String getRefCodeDescription(String rcDomain, String rcValue) {
		DetachedCriteria detachedCriteria = DetachedCriteria
		.forClass(RefCodes.class);
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		detachedCriteria.add(Restrictions.eq("rcDomain", rcDomain));
		detachedCriteria.add(Restrictions.eq("rcValue", rcValue));
		List<RefCodes> refCodes = pkdAuthorizationDAO
		.findByCriteria(detachedCriteria);
		if (null != refCodes && refCodes.size() > 0) {
			RefCodes refCode = refCodes.iterator().next();
			return refCode.getRcDesc();
		} else
			return null;
	}
	
	@Override
	public void printReport(PoHdr poHdrHq){
        SimpleDateFormat sdf=new SimpleDateFormat(Labels.getLabel("format.date"));
        if (null != poHdrHq && poHdrHq.getPoHdrSeqno() > 0)
        {
            List<PurchaseOrderReportCallingClass> reportCallingClassList = new ArrayList<PurchaseOrderReportCallingClass>();
            ExternalFacilityService externalFacilityService = SpringUtil.getBean("externalFacilityService", ExternalFacilityService.class);
            ExternalFacility facilityDetail = externalFacilityService.getExternalFacilitySearchByFacilityCode(poHdrHq.getFacility_code());
            List<PoDtl> poDtlList = new ArrayList<PoDtl>(0);
            if (poHdrHq.getPoDtls() != null)
            {
                poDtlList.addAll(poHdrHq.getPoDtls());
            }																					                
 
            for(PoDtl poDtl : poDtlList)
            {
            	PurchaseOrderReportCallingClass reportCallingClass1 = new PurchaseOrderReportCallingClass();
            	if(poDtl != null)
            	{
            		reportCallingClass1.setPoDtl(poDtl);
            		
            		if (poDtl.getVotecode()!= null) {
                    	VoteCode voteCode = new VoteCode();
                    	voteCode.setVoteCode(poDtl.getVotecode());
                        reportCallingClass1.setVoteCode(voteCode);
                    }
            		
            		if (poDtl.getItem() != null) {
                    	Item item = poDtl.getItem();
                    	item = (Item) new LazyInitializer().join(item, "drug","nonDrug");
                        reportCallingClass1.setItem(item);
                        if (item.getDrug() != null) {
                            reportCallingClass1.setDrug(item.getDrug());
                        }
                        if (item.getNonDrug() != null) {
                            reportCallingClass1.setNondrug(item.getNonDrug());
                        }
                    }
            		
            		reportCallingClass1.setFacilityDetail(facilityDetail);
            		reportCallingClassList.add(reportCallingClass1);
            	}
            }
            
            Map<Object, Object> params = new HashMap<Object, Object>();
            String imagepath = "../../images/logo1.jpg";
            params.put("purchaseOrderType", poHdrHq.getPurchaseOrderType() != null ? poHdrHq.getPurchaseOrderType() : "");
            params.put("listParam", reportCallingClassList);
            params.put("imagepathlogo", imagepath);
            params.put("jawatan", "");
            params.put("userunit", "");
            params.put("jabatan", "");
            params.put("reportTitle", "Request Order Authorization Report");
            params.put("nama", poHdrHq.getCreatedBy());
            params.put("tarikh1",sdf.format(poHdrHq.getCreatedDate()));
            params.put("status", (poHdrHq.getOrderStatus().equals(InventoryConstants.PO_STATUS.PO_STATUS_PKD_REJECTED) ? getRefCodeDescription(InventoryConstants.LABLES.PO_STATUS,InventoryConstants.PO_STATUS.PO_STATUS_PKD_REJECTED) : poHdrHq.getOrderStatus()));


            final String reportPath = "/WEB-INF/reports/order/Report-PO.jasper";
            Component comp = Executions.createComponents("/WEB-INF/reports/reportZul.zul", null, params);
            comp.setAttribute("REPORT_PATH", reportPath);
            comp.setAttribute("PARAMETERS_MAP", params);
            comp.setAttribute("BEANLIST", reportCallingClassList);
            if (comp instanceof Window) {
                ((Window) comp).doModal();
            }
        }
	}

	@Override
	public List<ExternalFacility> getFacilityList_PTJCode_FacilityCode(
			String ptjCode, String facilityCode) {
		String query = "SELECT all ef FROM ExternalFacility ef "
			+" where "
			+" ef.ptjCode= '" + ptjCode + "' " +
			"  AND  ef.facilityCode = '" + facilityCode + "'";
		return pkdAuthorizationDAO.find(query);
	}
	
	@Override
	public double getTotalOrderAmount(PoHdr poHdr) {
		double totalOrderAmt = 0.0000;
		for(PoDtl poDtl : poHdr.getPoDtls()) {
			totalOrderAmt = totalOrderAmt + poDtl.getAmount().doubleValue();
		}
		return totalOrderAmt;
	}
	
	@Override
	public VoteCode isVoteCodeInValid(PoHdr poHdr) {
		for(PoDtl poDtl : poHdr.getPoDtls()) {
			if(poDtl.getCbMaster()==null){
				return null;
			}
				
			if(isNull(poDtl,poDtl.getCbMaster(),poDtl.getCbMaster().getVoteCode()) && !RefCodeConstant.STATUS_VALUE_ACTIVEC.equals(poDtl.getCbMaster().getVoteCode().getActiveFlag())) {
				return poDtl.getCbMaster().getVoteCode();
			}
		}
		return null;
	}
	
	private boolean isNull(Object... object) {
	for (Object obj : object) {
		if(obj == null) return false;
	}
	return true;
	}
	@Override
	public boolean isUserTypeBudget(SecUser secUser) {
		return getSecUserService().isUserTypeBudget(secUser);
	}
	
	
	@Override
	public List<PoHdr> getPoHdrListForHospital(List<ExternalFacility> listExternalFacility,ExternalFacility currentFacility) {

		List<String> facilityCodeList = new ArrayList<String>();
		for (ExternalFacility externalFacility : listExternalFacility) {
			facilityCodeList.add(externalFacility.getFacilityCode());
		}
		if(null != listExternalFacility && listExternalFacility.size() > 0) {
			
			int year = Calendar.getInstance().get(Calendar.YEAR);
			
			DetachedCriteria detachedCriteria = DetachedCriteria.forClass(PoHdr.class);
			detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			detachedCriteria.add(Restrictions.eq("purchaseOrderType", RefCodeConstant.PO_REQUEST_TYPE_APPL));
			detachedCriteria.add(Restrictions.eq("epoSendToEp", RefCodeConstant.BOOLEAN_NO));
			detachedCriteria.add(Restrictions.eq("orderStatus", InventoryConstants.PO_STATUS.PO_STATUS_SEND_EP_APPROVED));
			detachedCriteria.add(Restrictions.eq("financialYear", Integer.toString(year)));
			detachedCriteria.add(Restrictions.in("facilityCode", facilityCodeList));
			detachedCriteria.addOrder(Order.desc("createdDate"));
			detachedCriteria.addOrder(Order.desc("purchaseOrderNo"));
			return pkdAuthorizationDAO.findByCriteria(detachedCriteria);
		}
		else
			return new ArrayList<PoHdr>(0);		
		
		
	}
	
	@Override
	public List<PoHdr> getPoHdrListForOfflineEP(List<ExternalFacility> listExternalFacility,ExternalFacility currentFacility, String epoStatus, String orderNo, String lpoNo, Date orderDate) {

		List<String> facilityCodeList = new ArrayList<String>();
		for (ExternalFacility externalFacility : listExternalFacility) {
			facilityCodeList.add(externalFacility.getFacilityCode());
		}
		if(null != listExternalFacility && listExternalFacility.size() > 0) {
			
			int year = Calendar.getInstance().get(Calendar.YEAR);
			
			DetachedCriteria detachedCriteria = DetachedCriteria.forClass(PoHdr.class);
			detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			detachedCriteria.add(Restrictions.eq("purchaseOrderType", RefCodeConstant.PO_REQUEST_TYPE_APPL));
//			detachedCriteria.add(Restrictions.eq("epoSendToEp", RefCodeConstant.BOOLEAN_NO));
			
			if (epoStatus.equalsIgnoreCase("All"))
			{
				
				List<String> epostatusList = new ArrayList<String>();
				epostatusList.add(InventoryConstants.PO_STATUS.PO_STATUS_SEND_EP_APPROVED);
				epostatusList.add(InventoryConstants.PO_STATUS.PO_STATUS_EP_APPROVED);				
				
				detachedCriteria.add(Restrictions.in("orderStatus", epostatusList));	
			}
			else
			{
				detachedCriteria.add(Restrictions.eq("orderStatus", epoStatus));				
			}
			
			if (null != orderNo && !orderNo.trim().isEmpty()) 
				detachedCriteria.add(Restrictions.eq("purchaseOrderNo", orderNo));
			
			if (null != lpoNo && !lpoNo.trim().isEmpty()) 
				detachedCriteria.add(Restrictions.eq("lpoNo", lpoNo));			
			
			if(null != orderDate)
			{
				
				Date startDate = DateUtil.startDate(orderDate);
				orderDate.setHours(23);
				orderDate.setMinutes(59);
				orderDate.setSeconds(59);
				
				System.out.println("Start Date ----> " + startDate  );
				
				System.out.println("End Date ----> " + orderDate  );
				
				detachedCriteria.add(Restrictions.between("orderDate", startDate, orderDate));
				
			}
			
			detachedCriteria.add(Restrictions.eq("financialYear", Integer.toString(year)));
			detachedCriteria.add(Restrictions.in("facilityCode", facilityCodeList));
			detachedCriteria.addOrder(Order.desc("createdDate"));
			detachedCriteria.addOrder(Order.desc("purchaseOrderNo"));
			return pkdAuthorizationDAO.findByCriteria(detachedCriteria);
		}
		else
			return new ArrayList<PoHdr>(0);		
		
		
	}	
	
	@Override
	public PoHdr getPoForTaskList(long poSeqNo) {
		DetachedCriteria criteria = DetachedCriteria.forClass(PoHdr.class);
		criteria.add(Restrictions.eq("poHdrSeqno", poSeqNo));
		PoHdr poHdr = (PoHdr) DataAccessUtils.uniqueResult(pkdAuthorizationDAO.findByCriteria(criteria));
		return poHdr;
	}
	

	
	@Override
	public Long previousApprovedQty(long itemSeqno, String financilYear, String facilityCode, long poHdrSeqno) {
		String query = "from PoDtl as PoDtl "
				+ "join fetch PoDtl.poHdr as PoHdr "
				// + "join fetch PoDtl.itemBrand as itemBrand "
				+ "join fetch PoDtl.item as item "
				// + "join fetch item.itemBatchs "
				+ "where PoHdr.poHdrSeqno<>" + poHdrSeqno + " and item.itemSeqno = " +itemSeqno
				 + " and PoHdr.financialYear='"+financilYear+"' and PoHdr.facilityCode='"+facilityCode+"'"
				 		+ " order by PoDtl.poDtlSeqno desc";

			System.out.println("query === >>" + query);
		List<PoDtl> poDtls = pkdAuthorizationDAO.find(query);
		System.err.println("PO Dtls : "+poDtls.size());
		if (null!= poDtls && !poDtls.isEmpty()) {
			System.err.println(poDtls.get(0).getApprovedQty()); 
			return poDtls.get(0).getApprovedQty();
		} else
			return null;
	}
	
	@Override
	public boolean isLPOAlreadyExists(String lpoNo, String orderNo,String facilitycode) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(PoHdr.class);
		detachedCriteria.add(Restrictions.eq("lpoNo", lpoNo));
		//detachedCriteria.add(Restrictions.ne("purchaseOrderNo", orderNo));
		detachedCriteria.add(Restrictions.eq("facilityCode",facilitycode ));
		List<PoHdr> hdrs = pkdAuthorizationDAO.findByCriteria(detachedCriteria);
		return hdrs.size() > 0;
	}
	@Override
	public List<Long> findPOByYearAndNonePayment(String fcICurFinCyc, String facilityCode) {
		List<Long> seqList = new ArrayList<Long>();
		String query = " SELECT distinct hdr.po_hdr_seqno FROM  t_vote_codes v "
				+ " inner join t_current_budget_master cbs on cbs.vote_seqno = v.vote_seqno "
				+ " inner join t_po_dtl dtl on dtl.cb_mstr_seqno = cbs.cb_mstr_seqno "
				+ " inner join t_po_hdr hdr on hdr.po_hdr_seqno = dtl.po_hdr_seqno and hdr.payment_done = 'N' "
				+ " WHERE (hdr.financial_year ="+fcICurFinCyc+" ) and hdr.order_status = 'eP_APPROVED' and hdr.facility_code='"+facilityCode+"' "
				+ " and hdr.lpo_no not in (select lpo_no from t_payments where financial_year = "+Integer.parseInt(fcICurFinCyc)+" and status in ('PFA','OPEN','Approved') and facility_code='"+facilityCode+"') "
				/*+ " and v.carry_forward ='N' "*/;
		Session session = null;
		try {
			session = pkdAuthorizationDAO.getSessionFactory().openSession();
			seqList = session.createSQLQuery(query).list();			
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return seqList;
	}
	
	@Override
	public List<String> findLPOFromPOCarryForward(String financialYear, String facilityCode) {
		List<String> seqList = new ArrayList<String>();
		String query = " SELECT distinct lpo_no from t_po_cf where order_status not in ('CANC') "
				+ " and financial_year='"+financialYear+"' and facility_code='"+facilityCode+"'";
		Session session = null;
		try {
			session = pkdAuthorizationDAO.getSessionFactory().openSession();
			seqList = session.createSQLQuery(query).list();			
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return seqList;
	}

	@Override
	public String getForwardTransactionNo(String financialYear) {
		String carryNo = "PC";
		Session session = null;
		try {
			session = pkdAuthorizationDAO.getSessionFactory().openSession();
			List objectArrayList = session.createSQLQuery("select T_VOTE_FORWARD_TRX_SEQNO.nextval  as seq_no from dual").list();	
			Long SeqNo = 0l;
			if (objectArrayList != null) {
				SeqNo =  Long.parseLong(objectArrayList.get(0).toString());
			} 
			session.close();
			String Year = "";
			Year = financialYear.substring(2);
			String moduleCodeNo =String.format("%05d", SeqNo);
			carryNo = (carryNo+Year+ moduleCodeNo);
		}catch(Exception e){e.printStackTrace();}
		return carryNo;
	}

	@Override
	public void saveOrUpdate(PoCfHdr poCfHdr) {
		getPoCfDAO().saveOrUpdate(poCfHdr);
	}

	@Override
	public List<PoCfHdr> findByLpoNo(String lpoNo) {
		DetachedCriteria criteria= DetachedCriteria.forClass(PoCfHdr.class);
		criteria.setFetchMode("poCfDtls", FetchMode.JOIN);
		criteria.add(Restrictions.eq("lpoNo", lpoNo));
		criteria.add(Restrictions.ne("orderStatus", "CAN"));
		return getPoCfDAO().findByCriteria(criteria);
	}

	@Override
	public CBMaster getBudgetMaster(String budgetType, VoteCode voteCode, int financialYear) {
		DetachedCriteria criteria = DetachedCriteria.forClass(CBMaster.class);
		criteria.add(Restrictions.eqOrIsNull("budgetType", budgetType));
		criteria.add(Restrictions.eq("voteCode", voteCode));
		criteria.add(Restrictions.eq("financialYear", financialYear));
		List<CBMaster> cbMasters = pkdAuthorizationDAO.findByCriteria(criteria);
		return null != cbMasters && !cbMasters.isEmpty() ? cbMasters.get(0) : null;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void updateBudgetForCarryForward(CBMaster anCBMaster, Double amount, 
			String transactionNo, String fcICode, String fcIPtjcode) {
			Session session = null;
			try {
			session = pkdAuthorizationDAO.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			Query query = session.createSQLQuery("UPDATE T_CURRENT_BUDGET_MASTER SET CURRENT_LIABILITY_AMOUNT = T_CURRENT_BUDGET_MASTER.CURRENT_LIABILITY_AMOUNT + "+amount+","
							+ "  UPDATED_DATE = SYSDATE ,  CURRENT_ACTUAL_AMOUNT = T_CURRENT_BUDGET_MASTER.CURRENT_ACTUAL_AMOUNT-"+amount 
							+ "  WHERE CB_MSTR_SEQNO = " +anCBMaster.getCbMstrSeqno());			
			query.executeUpdate();
			double pendingamount=anCBMaster.getCurrentPendingAmount();
			double liabilityAmount=anCBMaster.getCurrentLiabilityAmount()+amount;
			double blanceAmount= anCBMaster.getCurrentActualAmount()-amount;
			Query movementInsert = session.createSQLQuery("Insert into T_BUDGET_MOVEMENT (BUDGET_MOVEMENT_SEQNO,PENDING_AMOUNT,SOURCE_PTJ_CODE,LIABILITY_AMOUNT,"
					+ " UTILISED_AMOUNT,BALANCE,ACTIVE_FLAG,PARAMETER1,PARAMETER2,PARAMETER3,PARAMETER4,PARAMETER5,CREATED_BY,CREATED_DATE,UPDATED_BY,UPDATED_DATE,TRANSACTION_TYPE,"
					+ " TRANSACTION_NUMBER,VOTE_SEQNO,FACILITY_CODE,TRANSACTION_AMOUNT,WARRANT_TYPE,BUDGET_TYPE,FINANCIAL_YEAR,CB_MSTR_SEQNO) values "
					+ " (T_BUDGET_MOVEMENT_SEQ.nextval,'"+pendingamount+"','"+fcIPtjcode+"','"+liabilityAmount+"',0,'"+blanceAmount+"','A',null,null,null,null,null,2,SYSDATE,2,SYSDATE,'PO_FWD',"
					+ "'"+transactionNo+"','"+anCBMaster.getVoteSeqno()+"','"+fcICode+"','"+amount+"',null,'"+anCBMaster.getBudgetType()+"',"
					+ "'"+anCBMaster.getFinancialYear()+"','"+anCBMaster.getCbMstrSeqno()+"' ) ");
			movementInsert.executeUpdate();
			tx.commit();
			session.close();
		}catch (Exception e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void updateOriginalPODetails(CBMaster anCBMaster, Item item, long usrID, String lpoNo, String facilityCode, String ptjCode) {
		Session session = null;
		try {
			session = pkdAuthorizationDAO.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			Query query = session.createSQLQuery("UPDATE T_PO_DTL SET CB_MSTR_SEQNO = "+anCBMaster.getCbMstrSeqno()+",VOTE_CODE='"+anCBMaster.getVoteCode().getVoteCode()+"'"
					+ " ,budget_Type='"+anCBMaster.getBudgetType()+"' ,NEP_VOTE_CODE_SEQNO="+anCBMaster.getVoteCode().getNePVote().getVoteSeqno() + ", UPDATED_DATE=SYSDATE, UPDATED_BY="+usrID+" WHERE PO_HDR_SEQNO IN (SELECT PO_HDR_SEQNO FROM "
							+ " T_PO_HDR WHERE LPO_NO='"+lpoNo+"' AND FACILITY_CODE='"+facilityCode+"' AND PTJ_CODE ='"+ptjCode+"') AND ITEM_SEQNO = " + item.getItemSeqno());
			query.executeUpdate();
			tx.commit();
			session.close();
		}catch (Exception e) {
			e.printStackTrace();
		}		
	}
	

	@Override
	public List<PoCfHdr> getPoCarryForwardList(List<ExternalFacility> listExternalFacility,ExternalFacility currentFacility, String lpoNo, String transactionNo,
			String year, String status, String purchasetype,String clinicID) {
		List<String> facilityCodeList = new ArrayList<String>();
		for (ExternalFacility externalFacility : listExternalFacility) {
			facilityCodeList.add(externalFacility.getFacilityCode());
		}
		if(null != listExternalFacility && listExternalFacility.size() > 0) {
			DetachedCriteria detachedCriteria = DetachedCriteria.forClass(PoCfHdr.class);
			detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			detachedCriteria.setFetchMode("poCfDtls", FetchMode.JOIN);
			detachedCriteria.setFetchMode("supplier", FetchMode.JOIN);
			detachedCriteria.setFetchMode("deliveredTo", FetchMode.JOIN);
			if(purchasetype!=null && !StringUtils.isEmpty(purchasetype))
			detachedCriteria.add(Restrictions.eq("purchaseOrderType",purchasetype));
			if(status!=null && !StringUtils.isEmpty(status) && !status.equals("All"))
				detachedCriteria.add(Restrictions.eq("orderStatus",status));
			if (null != transactionNo && transactionNo.trim().length() > 0) {
				detachedCriteria.add(Restrictions.eq("transactionNo",transactionNo));
			}
			if (!StringUtils.isEmpty(clinicID) && clinicID!=null) {
				detachedCriteria.add(Restrictions.eq("facilityCode",clinicID));
			} else {
				detachedCriteria.add(Restrictions.in("facilityCode", facilityCodeList));
			}
			detachedCriteria.add(Restrictions.eq("financialYear", year));
			detachedCriteria.addOrder(Order.desc("createdDate"));
			detachedCriteria.addOrder(Order.desc("purchaseOrderNo"));
			return pkdAuthorizationDAO.findByCriteria(detachedCriteria);
		} else
			return new ArrayList<PoCfHdr>(0);

	}
	
	
	@Override
	public List<Object>  getCountDetailsForDrugRegistryPrint(Long userId)
	{
		StringBuffer queryStr = new StringBuffer();
		Session session = null;
		try {
			queryStr.append("select sum(totalIngredientCount),sum(totalDrugCount),sum(totalNonDrugCount),sum(totalPrintCard),sum(totalNotPrintCard),"
					+ " sum(totalConfirmedCount),sum(totalSuspectedCount) from "
					+ " (select count(generic_desc) AS totalIngredientCount,count(drug_allergy_nonmoh) AS totalDrugCount,"
					+ " count(allergen_others) AS totalNonDrugCount,"
					+ " case when print_flag='Y' then count(print_flag) else 0 end AS totalPrintCard,"
					+ " case when print_flag='N' then count(print_flag) else 0 end AS totalNotPrintCard,"
					+ " case when allergy_status='Confirmed' then count(allergy_status) else 0 end AS totalConfirmedCount,"
					+ " case when allergy_status='Suspected' then count(allergy_status) else 0 end AS totalSuspectedCount"
					+ " from T_DRUG_ALLERGY_REPORT_STG where created_by="+userId+" group by generic_desc,drug_allergy_nonmoh,print_flag,"
					+ " allergen_others,allergy_status)T ");
			session = pkdAuthorizationDAO.getSessionFactory().openSession();
			System.out.println(queryStr.toString());
			Query que = session.createSQLQuery(queryStr.toString());
			return que.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
	
}

