package my.com.cmg.iwp.backend.service.impl;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.management.Query;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Service;

import com.googlecode.genericdao.search.Filter;

import my.com.cmg.iwp.backend.service.IntegrationStatusDashboardListService;
import my.com.cmg.iwp.common.util.HibernateSearchObject;
import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.DoDtl;
import my.com.cmg.iwp.maintenance.model.FulFillInOutVW;
import my.com.cmg.iwp.maintenance.model.InvoiceInOutVW;
import my.com.cmg.iwp.maintenance.model.OrderDashboardBean;
import my.com.cmg.iwp.maintenance.model.PoHdr;
import my.com.cmg.iwp.maintenance.service.DoDtlService;
import my.com.cmg.iwp.maintenance.service.PoHdrService;
import my.com.cmg.iwp.maintenance.service.RefCodesService;
import my.com.cmg.iwp.util.ApplicationConstants;
import my.com.cmg.iwp.webui.constant.RefCodeConstant;
import my.com.cmg.iwp.webui.util.DateUtil;


@Service
public class IntegrationStatusDashboardListServiceImpl implements IntegrationStatusDashboardListService {

	private RefCodesService refCodesService;
	private PoHdrService poHdrService;
	private DoDtlService doDtlService;
	private BasisNextidDaoImpl generalDAO;
	
	@Override
	public List<OrderDashboardBean> getIWPIntegrationBeanList(String dateFrom, String dateTo) {
		List<OrderDashboardBean> ordBeanList = new ArrayList<OrderDashboardBean>();
		OrderDashboardBean ordBean = null;
		
		/*Note :: Do not change the Order in which Method is called*/
		Map<String,Integer> returnMap = null;
		
		returnMap = getPoHdrService().getEPOInOutLogCount(dateFrom, dateTo);
		if(returnMap != null) {
			ordBean = new OrderDashboardBean();
			ordBean.setIntegrationType(getRefCodesService().getRefCodeByRcValue(ApplicationConstants.ORD_INT_PHASE, RefCodeConstant.ORD_INT_PHASE_EPO_IN).getRcDesc());
			ordBean.setOrdCountAPPL(returnMap.get(ApplicationConstants.ORD_INT_PHASE_APPL_EPO_IN));
			ordBean.setOrdCountLP(returnMap.get(ApplicationConstants.ORD_INT_PHASE_LP_EPO_IN));
			ordBean.setOrdCountContract(returnMap.get(ApplicationConstants.ORD_INT_PHASE_CONTRACT_EPO_IN));
			ordBean.setIntegrationTypeValue(RefCodeConstant.ORD_INT_PHASE_EPO_IN);
			ordBeanList.add(ordBean);
			
			
			ordBean = new OrderDashboardBean();
			ordBean.setIntegrationType(getRefCodesService().getRefCodeByRcValue(ApplicationConstants.ORD_INT_PHASE, RefCodeConstant.ORD_INT_PHASE_EPO_OUT).getRcDesc());
			ordBean.setOrdCountAPPL(returnMap.get(ApplicationConstants.ORD_INT_PHASE_APPL_EPO_OUT));
			ordBean.setOrdCountLP(returnMap.get(ApplicationConstants.ORD_INT_PHASE_LP_EPO_OUT));
			ordBean.setOrdCountContract(returnMap.get(ApplicationConstants.ORD_INT_PHASE_CONTRACT_EPO_OUT));
			ordBean.setIntegrationTypeValue(RefCodeConstant.ORD_INT_PHASE_EPO_OUT);
			ordBeanList.add(ordBean);
		}
		
		returnMap = getPoHdrService().getLPOInOutLogCount(dateFrom, dateTo);
		if(returnMap != null) {
			ordBean = new OrderDashboardBean();
			ordBean.setIntegrationType(getRefCodesService().getRefCodeByRcValue(ApplicationConstants.ORD_INT_PHASE, RefCodeConstant.ORD_INT_PHASE_LPO_IN).getRcDesc());
			ordBean.setOrdCountAPPL(returnMap.get(ApplicationConstants.ORD_INT_PHASE_APPL_LPO_IN));
			ordBean.setOrdCountLP(returnMap.get(ApplicationConstants.ORD_INT_PHASE_LP_LPO_IN));
			ordBean.setOrdCountContract(returnMap.get(ApplicationConstants.ORD_INT_PHASE_CONTRACT_LPO_IN));
			ordBean.setIntegrationTypeValue(RefCodeConstant.ORD_INT_PHASE_LPO_IN);
			ordBeanList.add(ordBean);
			
			
			ordBean = new OrderDashboardBean();
			ordBean.setIntegrationType(getRefCodesService().getRefCodeByRcValue(ApplicationConstants.ORD_INT_PHASE, RefCodeConstant.ORD_INT_PHASE_LPO_OUT).getRcDesc());
			ordBean.setOrdCountAPPL(returnMap.get(ApplicationConstants.ORD_INT_PHASE_APPL_LPO_OUT));
			ordBean.setOrdCountLP(returnMap.get(ApplicationConstants.ORD_INT_PHASE_LP_LPO_OUT));
			ordBean.setOrdCountContract(returnMap.get(ApplicationConstants.ORD_INT_PHASE_CONTRACT_LPO_OUT));
			ordBean.setIntegrationTypeValue(RefCodeConstant.ORD_INT_PHASE_LPO_OUT);
			ordBeanList.add(ordBean);
		}
		
		returnMap = getDoDtlService().getDOInOutLogCount(dateFrom, dateTo);
		if(returnMap != null) {
			ordBean = new OrderDashboardBean();
			ordBean.setIntegrationType(getRefCodesService().getRefCodeByRcValue(ApplicationConstants.ORD_INT_PHASE, RefCodeConstant.ORD_INT_PHASE_DO_IN).getRcDesc());
			ordBean.setOrdCountAPPL(returnMap.get(ApplicationConstants.ORD_INT_PHASE_APPL_DO_IN));
			ordBean.setOrdCountLP(returnMap.get(ApplicationConstants.ORD_INT_PHASE_LP_DO_IN));
			ordBean.setOrdCountContract(returnMap.get(ApplicationConstants.ORD_INT_PHASE_CONTRACT_DO_IN));
			ordBean.setIntegrationTypeValue(RefCodeConstant.ORD_INT_PHASE_DO_IN);
			ordBeanList.add(ordBean);
			
			
			ordBean = new OrderDashboardBean();
			ordBean.setIntegrationType(getRefCodesService().getRefCodeByRcValue(ApplicationConstants.ORD_INT_PHASE, RefCodeConstant.ORD_INT_PHASE_DO_SENT).getRcDesc());
			ordBean.setOrdCountAPPL(returnMap.get(ApplicationConstants.ORD_INT_PHASE_APPL_DO_OUT));
			ordBean.setOrdCountLP(returnMap.get(ApplicationConstants.ORD_INT_PHASE_LP_DO_OUT));
			ordBean.setOrdCountContract(returnMap.get(ApplicationConstants.ORD_INT_PHASE_CONTRACT_DO_OUT));
			ordBean.setIntegrationTypeValue(RefCodeConstant.ORD_INT_PHASE_DO_SENT);
			ordBeanList.add(ordBean);
		}
		
		returnMap = getPoHdrService().getFullFillInOutCount(dateFrom, dateTo);
		if(returnMap != null) {
			ordBean = new OrderDashboardBean();
			ordBean.setIntegrationType(getRefCodesService().getRefCodeByRcValue(ApplicationConstants.ORD_INT_PHASE, RefCodeConstant.ORD_INT_PHASE_FULFILL_IN).getRcDesc());
			ordBean.setOrdCountAPPL(returnMap.get(ApplicationConstants.ORD_INT_PHASE_APPL_FULFIL_IN));
			ordBean.setOrdCountLP(returnMap.get(ApplicationConstants.ORD_INT_PHASE_LP_FULFIL_IN));
			ordBean.setOrdCountContract(returnMap.get(ApplicationConstants.ORD_INT_PHASE_CONTRACT_FULFIL_IN));
			ordBean.setIntegrationTypeValue(RefCodeConstant.ORD_INT_PHASE_FULFILL_IN);
			ordBeanList.add(ordBean);
			
			
			ordBean = new OrderDashboardBean();
			ordBean.setIntegrationType(getRefCodesService().getRefCodeByRcValue(ApplicationConstants.ORD_INT_PHASE, RefCodeConstant.ORD_INT_PHASE_FULFILL_OUT).getRcDesc());
			ordBean.setOrdCountAPPL(returnMap.get(ApplicationConstants.ORD_INT_PHASE_APPL_FULFIL_OUT));
			ordBean.setOrdCountLP(returnMap.get(ApplicationConstants.ORD_INT_PHASE_LP_FULFIL_OUT));
			ordBean.setOrdCountContract(returnMap.get(ApplicationConstants.ORD_INT_PHASE_CONTRACT_FULFIL_OUT));
			ordBean.setIntegrationTypeValue(RefCodeConstant.ORD_INT_PHASE_FULFILL_OUT);
			ordBeanList.add(ordBean);
		}
		
		returnMap = getPoHdrService().getInvoiceInOutCount(dateFrom, dateTo);
		if(returnMap != null) {
			ordBean = new OrderDashboardBean();
			ordBean.setIntegrationType(getRefCodesService().getRefCodeByRcValue(ApplicationConstants.ORD_INT_PHASE, RefCodeConstant.ORD_INT_PHASE_INVOICE_IN).getRcDesc());
			ordBean.setOrdCountAPPL(returnMap.get(ApplicationConstants.ORD_INT_PHASE_APPL_INVO_IN));
			ordBean.setOrdCountLP(returnMap.get(ApplicationConstants.ORD_INT_PHASE_LP_INVO_IN));
			ordBean.setOrdCountContract(returnMap.get(ApplicationConstants.ORD_INT_PHASE_CONTRACT_INVO_IN));
			ordBean.setIntegrationTypeValue(RefCodeConstant.ORD_INT_PHASE_INVOICE_IN);
			ordBeanList.add(ordBean);
			
			
			ordBean = new OrderDashboardBean();
			ordBean.setIntegrationType(getRefCodesService().getRefCodeByRcValue(ApplicationConstants.ORD_INT_PHASE, RefCodeConstant.ORD_INT_PHASE_INVOICE_OUT).getRcDesc());
			ordBean.setOrdCountAPPL(returnMap.get(ApplicationConstants.ORD_INT_PHASE_APPL_INVO_OUT));
			ordBean.setOrdCountLP(returnMap.get(ApplicationConstants.ORD_INT_PHASE_LP_INVO_OUT));
			ordBean.setOrdCountContract(returnMap.get(ApplicationConstants.ORD_INT_PHASE_CONTRACT_INVO_OUT));
			ordBean.setIntegrationTypeValue(RefCodeConstant.ORD_INT_PHASE_INVOICE_OUT);
			ordBeanList.add(ordBean);
		}
		
		returnMap = getPoHdrService().getPayNotificCount(dateFrom, dateTo);
		if(returnMap != null) {
			ordBean = new OrderDashboardBean();
			ordBean.setIntegrationType(getRefCodesService().getRefCodeByRcValue(ApplicationConstants.ORD_INT_PHASE, RefCodeConstant.ORD_INT_PHASE_PAY_NOTIFC).getRcDesc());
			ordBean.setOrdCountAPPL(returnMap.get(ApplicationConstants.ORD_INT_PHASE_APPL_PAY_NOTIFC));
			ordBean.setOrdCountLP(returnMap.get(ApplicationConstants.ORD_INT_PHASE_LP_PAY_NOTIFC));
			ordBean.setOrdCountContract(returnMap.get(ApplicationConstants.ORD_INT_PHASE_CONTRACT_PAY_NOTIFC));
			ordBean.setIntegrationTypeValue(RefCodeConstant.ORD_INT_PHASE_PAY_NOTIFC);
			ordBeanList.add(ordBean);
		}
		
		returnMap = getPoHdrService().getPendingForPKDApprovalCount(dateFrom, dateTo);
		if(returnMap != null) {
			ordBean = new OrderDashboardBean();
			ordBean.setIntegrationType("EPO In (To PKD)");
			ordBean.setOrdCountAPPL(returnMap.get(ApplicationConstants.ORD_INT_PHASE_APPL_EPO_IN));
			ordBean.setOrdCountLP(returnMap.get(ApplicationConstants.ORD_INT_PHASE_LP_EPO_IN));
			ordBean.setOrdCountContract(returnMap.get(ApplicationConstants.ORD_INT_PHASE_CONTRACT_EPO_IN));
			ordBean.setIntegrationTypeValue(RefCodeConstant.ORD_INT_PHASE_LPO_IN_PKD);
			ordBeanList.add(ordBean);
		}
		
		/*returnMap = getPoHdrService().getPKDApprovedCount(dateFrom, dateTo);
		if(returnMap != null) {
			ordBean = new OrderDashboardBean();
			ordBean.setIntegrationType("EPO Out From PKD (To eP)");
			ordBean.setOrdCountAPPL(returnMap.get(ApplicationConstants.ORD_INT_PHASE_APPL_EPO_OUT));
			ordBean.setOrdCountLP(returnMap.get(ApplicationConstants.ORD_INT_PHASE_LP_EPO_OUT));
			ordBean.setOrdCountContract(returnMap.get(ApplicationConstants.ORD_INT_PHASE_CONTRACT_EPO_OUT));
			ordBeanList.add(ordBean);
		}*/
		
		return ordBeanList;
	}
	
	@Override
	public String[] getIntegrationDates(Date dateFrom, Date dateTo) {
		String[] returnDate = new String[2];
		
		/**Default Date Case**/
		if(dateFrom == null && dateTo == null) {
			Calendar defaultCal = Calendar.getInstance(TimeZone.getDefault());
			defaultCal.add(Calendar.DATE, -7);
			dateFrom = defaultCal.getTime();
			dateTo = Calendar.getInstance(TimeZone.getDefault()).getTime();
			/*int datDiff_1 = defaultCal.get(Calendar.DAY_OF_WEEK);
			if(defaultCal.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
	        	datDiff_1 = 0;
	        } else if(defaultCal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
	        	datDiff_1 = 1;
	        } else {
	        	datDiff_1 = datDiff_1+1;
	        }
			
			defaultCal.add(Calendar.DATE, datDiff_1*-1);
	        dateFrom = defaultCal.getTime();
	        defaultCal.add(Calendar.DATE, defaultCal.get(Calendar.DAY_OF_WEEK));
	        dateTo = defaultCal.getTime();*/
	        
			returnDate[0] = DateUtil.getFormattedDateFrom2(dateFrom);
	        returnDate[1] = DateUtil.getFormattedDateTo2(dateTo);
		}
		
		if(dateFrom != null) {
			returnDate[0] = DateUtil.getFormattedDateFrom2(dateFrom);
		}
		
		if(dateTo != null) {
			returnDate[1] = DateUtil.getFormattedDateTo2(dateTo);
		}
        
		return returnDate;
	}
	
	@Override
	public HibernateSearchObject getOrderDashboardDialogList(Map<String,Object> paramMap,String facilityCode) {
		String moduleName = paramMap.get(ApplicationConstants.MODULE_NAME).toString();
		String orderType = paramMap.get(ApplicationConstants.ORDER_TYPE).toString();
		String[] dateRange = (String[]) paramMap.get(ApplicationConstants.DATE_RANGE);
		
		String methodName = moduleName.replaceAll("_", "").toLowerCase();
		Date dateFrm = DateUtil.getFormattedDate(dateRange[0],DateUtil.DATE_FORMAT_STR_3) ;
		Date dateTo = DateUtil.getFormattedDate(dateRange[1],DateUtil.DATE_FORMAT_STR_3) ;
		
		Class[] parameterTypes = {Date.class,Date.class,String.class,String.class};
		Object [] actualParameter = {dateFrm,dateTo,orderType,facilityCode};
		
		return (HibernateSearchObject<Object>) callMethod(getClass().getName(),methodName,parameterTypes,actualParameter);
	}
	
	public Object callMethod(String className, String methodName,Class[] parameterTypes,Object[] actualParameter) {
		try {
			Class object = Class.forName(className);
			Method method = object.getMethod(methodName, parameterTypes);

			Object returnObj = method.invoke(object.newInstance(), actualParameter);
			return returnObj;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public HibernateSearchObject<PoHdr> epoin(Date dateFrm, Date dateTo, String purchaseOrderType, String facilityCode) {
		HibernateSearchObject<PoHdr> hibSearchObj = new HibernateSearchObject<PoHdr>(PoHdr.class);
		hibSearchObj.addFilter(Filter.greaterOrEqual("createdDate",dateFrm));
		hibSearchObj.addFilter(Filter.lessOrEqual("createdDate",dateTo));
		hibSearchObj.addFilter(Filter.equal("purchaseOrderType", purchaseOrderType));
		if(facilityCode != null) hibSearchObj.addFilter(Filter.equal("facilityCode", facilityCode));
		return hibSearchObj;
	}
	
	public HibernateSearchObject<PoHdr> epoout(Date dateFrm, Date dateTo, String purchaseOrderType, String facilityCode) {
		HibernateSearchObject<PoHdr> hibSearchObj = new HibernateSearchObject<PoHdr>(PoHdr.class);
		hibSearchObj.addFilter(Filter.greaterOrEqual("createdDate",dateFrm));
		hibSearchObj.addFilter(Filter.lessOrEqual("createdDate",dateTo));
		hibSearchObj.addFilter(Filter.equal("epoSendToEp", "Y"));
		hibSearchObj.addFilter(Filter.equal("purchaseOrderType", purchaseOrderType));
		if(facilityCode != null) hibSearchObj.addFilter(Filter.equal("facilityCode", facilityCode));
		return hibSearchObj;
	}
	
	public HibernateSearchObject<PoHdr> lpoin(Date dateFrm, Date dateTo, String purchaseOrderType, String facilityCode) {
		HibernateSearchObject<PoHdr> hibSearchObj = new HibernateSearchObject<PoHdr>(PoHdr.class);
		hibSearchObj.addFilter(Filter.greaterOrEqual("lpoDate",dateFrm));
		hibSearchObj.addFilter(Filter.lessOrEqual("lpoDate",dateTo));
		hibSearchObj.addFilter(Filter.isNotNull("lpoNo"));
		hibSearchObj.addFilter(Filter.equal("purchaseOrderType", purchaseOrderType));
		if(facilityCode != null) hibSearchObj.addFilter(Filter.equal("facilityCode", facilityCode));
		return hibSearchObj;
	}
	
	public HibernateSearchObject<PoHdr> lpoout(Date dateFrm, Date dateTo, String purchaseOrderType, String facilityCode) {
		HibernateSearchObject<PoHdr> hibSearchObj = new HibernateSearchObject<PoHdr>(PoHdr.class);
		hibSearchObj.addFilter(Filter.greaterOrEqual("lpoDate",dateFrm));
		hibSearchObj.addFilter(Filter.lessOrEqual("lpoDate",dateTo));
		hibSearchObj.addFilter(Filter.isNotNull("sendToPiersDateTime"));
		hibSearchObj.addFilter(Filter.equal("purchaseOrderType", purchaseOrderType));
		if(facilityCode != null) hibSearchObj.addFilter(Filter.equal("facilityCode", facilityCode));
		return hibSearchObj;
	}
	
	public HibernateSearchObject<DoDtl> doin(Date dateFrm, Date dateTo, String purchaseOrderType, String facilityCode) {
		HibernateSearchObject<DoDtl> hibSearchObj = new HibernateSearchObject<DoDtl>(DoDtl.class);
		hibSearchObj.addFetch("poHdr");
		hibSearchObj.addFilter(new Filter("createDate",dateFrm,Filter.OP_GREATER_OR_EQUAL));
		hibSearchObj.addFilter(new Filter("createDate",dateTo,Filter.OP_LESS_OR_EQUAL));
		hibSearchObj.addFilter(Filter.equal("poHdr.purchaseOrderType", purchaseOrderType));
		if(facilityCode != null) hibSearchObj.addFilter(Filter.equal("poHdr.facilityCode", facilityCode));
		return hibSearchObj;
	}
	
	public HibernateSearchObject<DoDtl> dosent(Date dateFrm, Date dateTo, String purchaseOrderType, String facilityCode) {
		HibernateSearchObject<DoDtl> hibSearchObj = new HibernateSearchObject<DoDtl>(DoDtl.class);
		hibSearchObj.addFetch("poHdr");
		hibSearchObj.addFilter(new Filter("createDate",dateFrm,Filter.OP_GREATER_OR_EQUAL));
		hibSearchObj.addFilter(new Filter("createDate",dateTo,Filter.OP_LESS_OR_EQUAL));
		hibSearchObj.addFilter(Filter.equal("poHdr.purchaseOrderType", purchaseOrderType));
		hibSearchObj.addFilter(Filter.equal("sendToEp","Y"));
		hibSearchObj.addFilter(Filter.isNotNull("sendtoEpDate"));
		if(facilityCode != null) hibSearchObj.addFilter(Filter.equal("poHdr.facilityCode", facilityCode));
		return hibSearchObj;
	}
		
	public HibernateSearchObject<FulFillInOutVW> fulfillin(Date dateFrm, Date dateTo, String purchaseOrderType, String facilityCode) {
		HibernateSearchObject<FulFillInOutVW> hibSearchObj = new HibernateSearchObject<FulFillInOutVW>(FulFillInOutVW.class);
		hibSearchObj.addFilter(Filter.greaterOrEqual("createdDate",dateFrm));
		hibSearchObj.addFilter(Filter.lessOrEqual("createdDate",dateTo));
		hibSearchObj.addFilter(Filter.equal("purchaseOrderType", purchaseOrderType));
		if(facilityCode != null) hibSearchObj.addFilter(Filter.equal("facilityCode", facilityCode));
		return hibSearchObj;
	}
	
	public HibernateSearchObject<FulFillInOutVW> fulfillout(Date dateFrm, Date dateTo, String purchaseOrderType, String facilityCode) {
		HibernateSearchObject<FulFillInOutVW> hibSearchObj = new HibernateSearchObject<FulFillInOutVW>(FulFillInOutVW.class);
		hibSearchObj.addFilter(Filter.greaterOrEqual("createdDate",dateFrm));
		hibSearchObj.addFilter(Filter.lessOrEqual("createdDate",dateTo));
		hibSearchObj.addFilter(Filter.equal("purchaseOrderType", purchaseOrderType));
		hibSearchObj.addFilter(Filter.equal("fulfillSyncFlag", "Y"));
		if(facilityCode != null) hibSearchObj.addFilter(Filter.equal("facilityCode", facilityCode));
		return hibSearchObj;
	}
	
	public HibernateSearchObject<InvoiceInOutVW> invoicein(Date dateFrm, Date dateTo, String purchaseOrderType, String facilityCode) {
		HibernateSearchObject<InvoiceInOutVW> hibSearchObj = new HibernateSearchObject<InvoiceInOutVW>(InvoiceInOutVW.class);
		hibSearchObj.addFilter(Filter.greaterOrEqual("createdDate",dateFrm));
		hibSearchObj.addFilter(Filter.lessOrEqual("createdDate",dateTo));
		hibSearchObj.addFilter(Filter.equal("purchaseOrderType", purchaseOrderType));
		if(facilityCode != null) hibSearchObj.addFilter(Filter.equal("facilityCode", facilityCode));
		return hibSearchObj;
	}
	
	public HibernateSearchObject<InvoiceInOutVW> invoiceout(Date dateFrm, Date dateTo, String purchaseOrderType, String facilityCode) {
		HibernateSearchObject<InvoiceInOutVW> hibSearchObj = new HibernateSearchObject<InvoiceInOutVW>(InvoiceInOutVW.class);
		hibSearchObj.addFilter(Filter.greaterOrEqual("createdDate",dateFrm));
		hibSearchObj.addFilter(Filter.lessOrEqual("createdDate",dateTo));
		hibSearchObj.addFilter(Filter.equal("purchaseOrderType", purchaseOrderType));
		hibSearchObj.addFilter(Filter.equal("invoiceSendToEP", "Y"));
		
		if(facilityCode != null) hibSearchObj.addFilter(Filter.equal("facilityCode", facilityCode));
		return hibSearchObj;
	}
	
	public HibernateSearchObject<PoHdr> lpoinpkd(Date dateFrm, Date dateTo, String purchaseOrderType, String facilityCode) {
		HibernateSearchObject<PoHdr> hibSearchObj = new HibernateSearchObject<PoHdr>(PoHdr.class);
		hibSearchObj.addFilter(Filter.greaterOrEqual("createdDate",dateFrm));
		hibSearchObj.addFilter(Filter.lessOrEqual("createdDate",dateTo));
		hibSearchObj.addFilter(Filter.equal("purchaseOrderType", purchaseOrderType));
		hibSearchObj.addFilter(Filter.equal("orderStatus", "PAP"));
		if(facilityCode != null) hibSearchObj.addFilter(Filter.equal("facilityCode", facilityCode));
		return hibSearchObj;
	}
	
	public HibernateSearchObject<PoHdr> paynotifc(Date dateFrm, Date dateTo, String purchaseOrderType, String facilityCode) {
		HibernateSearchObject<PoHdr> hibSearchObj = new HibernateSearchObject<PoHdr>(PoHdr.class);
		hibSearchObj.addFilter(Filter.greaterOrEqual("createdDate",dateFrm));
		hibSearchObj.addFilter(Filter.lessOrEqual("createdDate",dateTo));
		hibSearchObj.addFilter(Filter.equal("purchaseOrderType", purchaseOrderType));
		hibSearchObj.addFilter(Filter.equal("paymentStatus", "Y"));
		if(facilityCode != null) hibSearchObj.addFilter(Filter.equal("facilityCode", facilityCode));
		return hibSearchObj;
	}
	
	@Override
	public List<Object> getDistributionList(String dateFrom, String dateTo) {
		StringBuffer queryStr = new StringBuffer();
		Session session = null;
		
		queryStr.append(" SELECT '' AS FACILITY_CODE,");
		queryStr.append(" vlog.AL_TABLE_NAME AS TABLE_NAME,");
		queryStr.append(" COUNT(DISTINCT(vlog.AL_PRIMARY_KEY_VAL)) AS COUNT");
		queryStr.append(" FROM T_AUDIT_LOG vlog");
		queryStr.append(" JOIN T_MASTER_RELEASE_MAPPING map ON map.MRM_SOURCE_TABLE_NAME = vlog.AL_TABLE_NAME");
		queryStr.append(" WHERE 1=1 ");
		if(dateFrom!=null)
		queryStr.append(" AND TO_DATE(TRUNC(vlog.AL_CREATE_DATE),'DD/MM/RRRR')>= TO_DATE(TRUNC(TO_DATE('" + dateFrom+"','YYYY-MM-DD HH24:MI:SS')),'DD/MM/RRRR')"); 	
		if(dateTo!=null)
		queryStr.append(" AND TO_DATE(TRUNC(vlog.AL_CREATE_DATE),'DD/MM/RRRR')<= TO_DATE(TRUNC(TO_DATE('" + dateTo+"','YYYY-MM-DD HH24:MI:SS')),'DD/MM/RRRR')");
		queryStr.append(" GROUP BY vlog.AL_TABLE_NAME");
		
		queryStr.append(" UNION ALL ");

		queryStr.append(" SELECT '' AS FACILITY_CODE,");
		queryStr.append(" vlog.AL_TABLE_NAME AS TABLE_NAME,");
		queryStr.append(" COUNT(DISTINCT(vlog.AL_PRIMARY_KEY_VAL)) AS COUNT");
		queryStr.append(" FROM T_ITEM_AUDIT_LOG vlog");
		queryStr.append(" JOIN T_ITEM_RELEASE_MAPPING map ON map.IRM_SOURCE_TABLE_NAME = vlog.AL_TABLE_NAME");
		queryStr.append(" WHERE 1=1 "); 
		if(dateFrom!=null)
		queryStr.append(" AND TO_DATE(TRUNC(vlog.AL_CREATE_DATE),'DD/MM/RRRR')>= TO_DATE(TRUNC(TO_DATE('" + dateFrom+"','YYYY-MM-DD HH24:MI:SS')),'DD/MM/RRRR')"); 	
		if(dateTo!=null)
		queryStr.append(" AND TO_DATE(TRUNC(vlog.AL_CREATE_DATE),'DD/MM/RRRR')<= TO_DATE(TRUNC(TO_DATE('" + dateTo+"','YYYY-MM-DD HH24:MI:SS')),'DD/MM/RRRR')");
		queryStr.append(" GROUP BY vlog.AL_TABLE_NAME ");
		
		queryStr.append(" UNION ALL ");

		queryStr.append(" SELECT vlog.AL_FACILITY_CODE AS FACILITY_CODE");
		queryStr.append(" ,vlog.AL_TABLE_NAME AS TABLE_NAME");
		queryStr.append(" ,COUNT(DISTINCT(vlog.AL_PRIMARY_KEY_VAL)) AS COUNT");
		queryStr.append(" FROM T_VOTE_AUDIT_LOG vlog");
		queryStr.append(" JOIN T_VOTE_RELEASE_MAPPING map ON map.VRM_SOURCE_TABLE_NAME = vlog.AL_TABLE_NAME");
		queryStr.append(" JOIN T_EXTERNAL_FACILITIES fac ON vlog.AL_FACILITY_CODE = fac.FACILITY_CODE");
		queryStr.append(" WHERE 1=1 "); 	
		if(dateFrom!=null)
		queryStr.append(" AND TO_DATE(TRUNC(vlog.AL_CREATE_DATE),'DD/MM/RRRR')>= TO_DATE(TRUNC(TO_DATE('" + dateFrom+"','YYYY-MM-DD HH24:MI:SS')),'DD/MM/RRRR')"); 	
		if(dateTo!=null)
		queryStr.append(" AND TO_DATE(TRUNC(vlog.AL_CREATE_DATE),'DD/MM/RRRR')<= TO_DATE(TRUNC(TO_DATE('" + dateTo+"','YYYY-MM-DD HH24:MI:SS')),'DD/MM/RRRR')");
		queryStr.append(" GROUP BY vlog.AL_FACILITY_CODE,vlog.AL_TABLE_NAME ");
		
		try {
			session = getGeneralDAO().getSessionFactory().openSession();
			System.out.println(queryStr.toString());
			NativeQuery que = session.createSQLQuery(queryStr.toString());
			return que.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<Object> getExternalRequestList(String dateFrom, String dateTo) {
		StringBuffer queryStr = new StringBuffer();
		Session session = null;
		
		//--INDENT
		queryStr.append(" SELECT 'INDENT' AS MODULE_NAME , COUNT(EXT_INH_NO) AS COUNT ");
		queryStr.append(" FROM T_INDENT_HDRS_INT INT ");
		queryStr.append(" WHERE 1=1 ");
		if(dateFrom!=null)
		queryStr.append(" AND TO_DATE(TRUNC(INT.CREATED_DATE),'DD/MM/RRRR' )>= TO_DATE(TRUNC(TO_DATE('" + dateFrom+"','YYYY-MM-DD HH24:MI:SS')),'DD/MM/RRRR') ");
		if(dateTo!=null)
		queryStr.append(" AND TO_DATE(TRUNC(INT.CREATED_DATE),'DD/MM/RRRR' )<= TO_DATE(TRUNC(TO_DATE('" + dateTo+"','YYYY-MM-DD HH24:MI:SS')),'DD/MM/RRRR') ");
		
		queryStr.append(" UNION ALL ");

		//--ISSUE
		queryStr.append(" SELECT 'ISSUE' AS MODULE_NAME , COUNT(IMH_INT_SEQNO) AS COUNT ");
		queryStr.append(" FROM T_ISSUE_HDRS_INT INT ");
		queryStr.append(" WHERE 1=1 ");
		if(dateFrom!=null)
		queryStr.append(" AND TO_DATE(TRUNC(INT.CREATED_DATE),'DD/MM/RRRR' )>= TO_DATE(TRUNC(TO_DATE('" + dateFrom+"','YYYY-MM-DD HH24:MI:SS')),'DD/MM/RRRR') ");
		if(dateTo!=null)
		queryStr.append(" AND TO_DATE(TRUNC(INT.CREATED_DATE),'DD/MM/RRRR' )<= TO_DATE(TRUNC(TO_DATE('" + dateTo+"','YYYY-MM-DD HH24:MI:SS')),'DD/MM/RRRR') ");

		queryStr.append(" UNION ALL ");
		
		//--PN
		queryStr.append(" SELECT 'PN' AS MODULE_NAME , COUNT(REGIMEN_INT_SEQNO) AS COUNT ");
		queryStr.append(" FROM T_PN_ORDER_REGIMEN_INT INT ");
		queryStr.append(" WHERE 1=1 ");
		if(dateFrom!=null)
		queryStr.append(" AND TO_DATE(TRUNC(INT.CREATED_DATE),'DD/MM/RRRR' )>= TO_DATE(TRUNC(TO_DATE('" + dateFrom+"','YYYY-MM-DD HH24:MI:SS')),'DD/MM/RRRR') ");
		if(dateTo!=null)
		queryStr.append(" AND TO_DATE(TRUNC(INT.CREATED_DATE),'DD/MM/RRRR' )<= TO_DATE(TRUNC(TO_DATE('" + dateTo+"','YYYY-MM-DD HH24:MI:SS')),'DD/MM/RRRR') ");

		queryStr.append(" UNION ALL ");
		
		//--CDR
		queryStr.append(" SELECT 'CDR' AS MODULE_NAME , COUNT(CDR_HDR_SEQNO) AS COUNT ");
		queryStr.append(" FROM T_CDR_HDR_INT INT ");
		queryStr.append(" WHERE 1=1 ");
		if(dateFrom!=null)
		queryStr.append(" AND TO_DATE(TRUNC(INT.CREATED_DATE),'DD/MM/RRRR' )>= TO_DATE(TRUNC(TO_DATE('" + dateFrom+"','YYYY-MM-DD HH24:MI:SS')),'DD/MM/RRRR') ");
		if(dateTo!=null)
		queryStr.append(" AND TO_DATE(TRUNC(INT.CREATED_DATE),'DD/MM/RRRR' )<= TO_DATE(TRUNC(TO_DATE('" + dateTo+"','YYYY-MM-DD HH24:MI:SS')),'DD/MM/RRRR') ");

		queryStr.append(" UNION ALL ");
		
		//--IV
		queryStr.append(" SELECT 'IV' AS MODULE_NAME , COUNT(IV_HDR_INT_SEQNO) AS COUNT ");
		queryStr.append(" FROM T_IV_HDR_INT INT ");
		queryStr.append(" WHERE 1=1 ");
		if(dateFrom!=null)
		queryStr.append(" AND TO_DATE(TRUNC(INT.CREATED_DATE),'DD/MM/RRRR' )>= TO_DATE(TRUNC(TO_DATE('" + dateFrom+"','YYYY-MM-DD HH24:MI:SS')),'DD/MM/RRRR') ");
		if(dateTo!=null)
		queryStr.append(" AND TO_DATE(TRUNC(INT.CREATED_DATE),'DD/MM/RRRR' )<= TO_DATE(TRUNC(TO_DATE('" + dateTo+"','YYYY-MM-DD HH24:MI:SS')),'DD/MM/RRRR') ");

		queryStr.append(" UNION ALL ");
		
		//--SPUB
		queryStr.append(" SELECT 'SPUB' AS MODULE_NAME , COUNT(SPUB_HDR_SEQNO) AS COUNT ");
		queryStr.append(" FROM T_SPUB_HDRS_INT INT ");
		queryStr.append(" WHERE 1=1 ");
		if(dateFrom!=null)
		queryStr.append(" AND TO_DATE(TRUNC(INT.CREATED_DATE),'DD/MM/RRRR' )>= TO_DATE(TRUNC(TO_DATE('" + dateFrom+"','YYYY-MM-DD HH24:MI:SS')),'DD/MM/RRRR') ");
		if(dateTo!=null)
		queryStr.append(" AND TO_DATE(TRUNC(INT.CREATED_DATE),'DD/MM/RRRR' )<= TO_DATE(TRUNC(TO_DATE('" + dateTo+"','YYYY-MM-DD HH24:MI:SS')),'DD/MM/RRRR') ");

		queryStr.append(" UNION ALL ");
		
		//--TDM
		queryStr.append(" SELECT 'TDM' AS MODULE_NAME , COUNT(TDM_ORDER_INT_SEQNO) AS COUNT ");
		queryStr.append(" FROM T_TDM_ORDER_INT INT ");
		queryStr.append(" WHERE 1=1 ");
		if(dateFrom!=null)
		queryStr.append(" AND TO_DATE(TRUNC(INT.CREATED_DATE),'DD/MM/RRRR' )>= TO_DATE(TRUNC(TO_DATE('" + dateFrom+"','YYYY-MM-DD HH24:MI:SS')),'DD/MM/RRRR') ");
		if(dateTo!=null)
		queryStr.append(" AND TO_DATE(TRUNC(INT.CREATED_DATE),'DD/MM/RRRR' )<= TO_DATE(TRUNC(TO_DATE('" + dateTo+"','YYYY-MM-DD HH24:MI:SS')),'DD/MM/RRRR') ");

		queryStr.append(" UNION ALL ");
		
		//--RP
		queryStr.append(" SELECT 'RADIO PHARMA' AS MODULE_NAME , COUNT(ORDER_RP_SEQNO) AS COUNT ");
		queryStr.append(" FROM T_ORDER_RP_INT INT ");
		queryStr.append(" WHERE 1=1 ");
		if(dateFrom!=null)
		queryStr.append(" AND TO_DATE(TRUNC(INT.CREATED_DATE),'DD/MM/RRRR' )>= TO_DATE(TRUNC(TO_DATE('" + dateFrom+"','YYYY-MM-DD HH24:MI:SS')),'DD/MM/RRRR') ");
		if(dateTo!=null)
		queryStr.append(" AND TO_DATE(TRUNC(INT.CREATED_DATE),'DD/MM/RRRR' )<= TO_DATE(TRUNC(TO_DATE('" + dateTo+"','YYYY-MM-DD HH24:MI:SS')),'DD/MM/RRRR') ");

		queryStr.append(" UNION ALL ");
		
		//--SPECIAL Drug
		queryStr.append(" SELECT 'SPECIAL DRUG' AS MODULE_NAME , COUNT(SDR_ORDER_SEQNO) AS COUNT ");
		queryStr.append(" FROM T_SPL_DRUG_REQUEST_INT INT ");
		queryStr.append(" WHERE 1=1 ");
		if(dateFrom!=null)
		queryStr.append(" AND TO_DATE(TRUNC(INT.CREATED_DATE),'DD/MM/RRRR' )>= TO_DATE(TRUNC(TO_DATE('" + dateFrom+"','YYYY-MM-DD HH24:MI:SS')),'DD/MM/RRRR') ");
		if(dateTo!=null)
		queryStr.append(" AND TO_DATE(TRUNC(INT.CREATED_DATE),'DD/MM/RRRR' )<= TO_DATE(TRUNC(TO_DATE('" + dateTo+"','YYYY-MM-DD HH24:MI:SS')),'DD/MM/RRRR') ");

		try {
			session = getGeneralDAO().getSessionFactory().openSession();
			NativeQuery que = session.createSQLQuery(queryStr.toString());
			return que.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
	
	/* Services */
	public RefCodesService getRefCodesService() { return refCodesService; }
	public void setRefCodesService(RefCodesService refCodesService) { this.refCodesService = refCodesService; }
	public PoHdrService getPoHdrService() { return poHdrService; }
	public void setPoHdrService(PoHdrService poHdrService) { this.poHdrService = poHdrService; }
	public DoDtlService getDoDtlService() { return doDtlService; }
	public void setDoDtlService(DoDtlService doDtlService) { this.doDtlService = doDtlService; }
	public BasisNextidDaoImpl getGeneralDAO() { return generalDAO; }
	public void setGeneralDAO(BasisNextidDaoImpl generalDAO) { this.generalDAO = generalDAO; }
}
