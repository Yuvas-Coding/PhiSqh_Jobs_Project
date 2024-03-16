package my.com.cmg.iwp.util;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.zkoss.spring.SpringUtil;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import my.com.cmg.iwp.backend.model.integration.IntegrationLog;
import my.com.cmg.iwp.integration.Acknowledgement;
import my.com.cmg.iwp.maintenance.model.DistributionFacList;
import my.com.cmg.iwp.maintenance.model.ExternalFacility;
import my.com.cmg.iwp.maintenance.model.RefCodes;
import my.com.cmg.iwp.maintenance.service.IntegrationLogService;
import my.com.cmg.iwp.maintenance.service.RefCodesService;
import my.com.cmg.iwp.webui.constant.RefCodeConstant;

public class RestUtil {

	public static final String APPL_CONTEXTROOT = "APPL_CONTEXTROOT";
	public static final String SLASH = "/";
	public static final String CDR_POST = "/rest/cdr/post";
	public static final String SDR_POST = "/rest/sdr/post";
	public static final String SDR_PERMIT_POST = "/rest/sdrPermit/post";
	public static final String SPUB_POST = "/rest/spub/post";
	public static final String SPUB_POST_NEW = "/rest/spubNew/post";
	public static final String INDENT_POST = "/rest/indent/post";
	public static final String ISSUE_POST = "/rest/issue/post";
	public static final String RETURN_POST = "/rest/return/post";
	public static final String PN_POST = "/rest/pn/post";
	public static final String NOTIFICATION_POST = "/rest/notification/post";
	public static final String TDM_POST = "/rest/tdm/post";
	public static final String RP_POST = "/rest/rp/post";
	public static final String HQ_CONTRACT_POST = "/rest/contract/post";
	public static final String PENALTY_POST = "/rest/penalty/post";
	public static final String PENALTY_VERIFICATION_POST = "/rest/verification/post";
	
	public static final String SPUB_CANCEL_OR_REGISTER_POST = "/rest/cancelOrRegisterSpub/post";
//	public static final String SPUB_CANCEL_OR_REGISTER_SCHEDULE_POST = "/rest/cancelOrRegisterSPUBScheule/post";
	public static final String SPUB_CANCEL_OR_REGISTER_SCHEDULE_POST =  "/rest/spubCancelOrRegister/post";
	public static final String ACKNOWLEDGEMENT_POST =  "/rest/acknowledgement/post";
	public static final String PENALTY_PAYMENT_POST = "/rest/penaltyPayment/post";
	public static final String PN_ORDEROUTSOURCE_REGISTER_FROM_IWP_POST = "/rest/PNOutsourceRegister/post";
	public static final String PN_ORDEROUTSOURCE_CANCEL_FROM_IWP_POST = "/rest/PNOutsourceCancel/post";
	
	
	public final static int PTJCODE = 0;
	public final static int FACTCODE = 1;

	public static String getUri(final RefCodesService refCodesService,
			final ExternalFacility facility, final String wsPath) {
		if (facility == null ||
				StringUtils.isEmpty(facility.getServerIp()) || StringUtils.isEmpty(facility.getServerPort())) {
			return null;
		}
		StringBuffer uri = new StringBuffer("http://")
		.append(facility.getServerIp()).append(StringUtils.isEmpty(facility.getServerPort()) ? "" : ":" + facility.getServerPort());
		RefCodes refCodes = refCodesService.getRefCodesByDomain(
				APPL_CONTEXTROOT).get(0);
		uri.append(SLASH).append(refCodes.getRcValue()).append(wsPath);
		return uri.toString();
	}


	public static String getUri(final RefCodesService refCodesService, final String ip,
			final String port, final String wsPath) {
		if (StringUtils.isEmpty(ip) || StringUtils.isEmpty(port)) {
			return null;
		}
		RefCodes refCodes = refCodesService.getRefCodesByDomain(
				APPL_CONTEXTROOT).get(0);
		StringBuffer uri = new StringBuffer("http://").append(ip).append(StringUtils.isEmpty(port) ? "" : ":" + port);
		uri.append(SLASH).append(refCodes.getRcValue()).append(wsPath);
		return uri.toString();
	}

	public static String getUri(final String phisAppContextPath,
			final ExternalFacility facility, final String wsPath) {
		if (facility == null || StringUtils.isEmpty(facility.getServerIp()) || StringUtils.isEmpty(facility.getServerPort())) {
			return null;
		}
		StringBuffer uri = new StringBuffer("http://")
		.append(facility.getServerIp()).append(StringUtils.isEmpty(facility.getServerPort()) ? "" : ":" + facility.getServerPort());
		uri.append(SLASH).append(phisAppContextPath).append(wsPath);
		return uri.toString();
	}

	public static String getUri(final String phisAppContextPath, final String ip,
			final String port, final String wsPath) {
		if (StringUtils.isEmpty(ip) || StringUtils.isEmpty(port)) {
			return null;
		}
		StringBuffer uri = new StringBuffer("http://").append(ip).append(StringUtils.isEmpty(port) ? "" : ":" + port);
		uri.append(SLASH).append(phisAppContextPath).append(wsPath);
		return uri.toString();
	}

//	public static boolean ping(final String host) throws Exception {
//		if (StringUtils.isEmpty(host)) {
//			return false;
//		}
//		InetAddress inetAddress = InetAddress.getByName(host);
//		if (inetAddress.isReachable(5000)) {
//			return true;
//		} else {
//			return false;
//		}
//	}

	public static boolean ping(final String host, DistributionFacList distFacBean) throws Exception {
		
		System.out.println(" >>>>>>>>>>>>>>>>>>>>>>>> Inside ping Method <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");		
		
		if (StringUtils.isEmpty(host)) {
			return false;
		}
		
		int facPort = 8080;
		
		if (distFacBean != null) {
			facPort = Integer.parseInt(distFacBean.getServerPort());
			
			//Always Return True if T_DISTRIBUTION_FAC_LIST.FAC_PING_DISABLED = 'Y' To Byepass Ping
			if (distFacBean.getFacPingDisable().equals("Y")) 
			{
				System.out.println("Host Ping Disabled Facility: " + distFacBean.getFacilityCode());
				return true;  
			}
			
		}
		
		SocketAddress sockaddr = new InetSocketAddress(host,facPort);
		Socket socket = new Socket();
		boolean online = true;
		try {
			
			System.out.println("Host Ping With Socket : " + distFacBean.getFacilityCode() + " :: "+ host + " Port : " + facPort);
			
			socket.connect(sockaddr, 5000);
			
		}catch (IOException IOException) {
			online = false;
		}
		finally
		{
			socket.close();
		}
		
		return online;
	}	
	
	 public static boolean isReachable(final String host, String facilityCode, Map<String, String> notReachableFacilities, DistributionFacList distFacBean) throws Exception{

		System.out.println(" >>>>>>>>>>>>>>>>>>>>>>>> Inside isReachable Method <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");		 
		 
	   if(notReachableFacilities.containsKey(facilityCode)){
		    if(notReachableFacilities.get(facilityCode).equals(RefCodeConstant.BOOLEAN_YES)){
		    	return true;
		    }else{
		    	return false;
		    }
		}else{
	       if(ping(host, distFacBean)){
	    	   notReachableFacilities.put(facilityCode, RefCodeConstant.BOOLEAN_YES);
	    	   return true;
		    }else{
		    	notReachableFacilities.put(facilityCode, RefCodeConstant.BOOLEAN_NO);
		    	return false;
		    }
		}
		   
	 }
	
	public static void submit(Acknowledgement acknowledgement, IntegrationLogService integrationLogService
			, RestTemplate restTemplate, ExternalFacility externalFacility, RefCodesService refCodesService){
		
		HttpEntity<Acknowledgement> httpAcknowledgementEntity = new HttpEntity<Acknowledgement>(acknowledgement);
		List<RefCodes> listRefCodes = refCodesService.getRefCodesByDomain(RestUtil.APPL_CONTEXTROOT);
		String applContext =null;
		if(listRefCodes!=null && listRefCodes.size() > 0){
			RefCodes refCodes = listRefCodes.get(0);
			applContext = refCodes.getRcValue();
		}
		
		IntegrationLog integrationLog = new IntegrationLog();
		
		if(applContext == null){
			String remark = "APPLICATION CONTEXT NOT FOUND IN REF CODES:" +(acknowledgement.getEntityName()!=null ? acknowledgement.getEntityName() :"")+
					" Pimary Key: "+(acknowledgement.getPrimaryKeyColumnName()!=null? acknowledgement.getPrimaryKeyColumnName() :"")+" values : "
							+ ""+(acknowledgement.getPrimaryKeyValues()!=null? acknowledgement.getPrimaryKeyValues():"");
			insertIntegrationLog(integrationLog, "ACK", RefCodeConstant.RECEIVED_REQUEST, acknowledgement.getPrimaryKeyValues().size(), "", remark, 2,integrationLogService);
			return;
		}
		String uri = RestUtil.getUri(applContext, externalFacility, RestUtil.ACKNOWLEDGEMENT_POST);

	
		String remark = "Received Request Table:" +(acknowledgement.getEntityName()!=null ? acknowledgement.getEntityName() :"")+
				" Pimary Key: "+(acknowledgement.getPrimaryKeyColumnName()!=null? acknowledgement.getPrimaryKeyColumnName() :"")+" values : "
						+ ""+(acknowledgement.getPrimaryKeyValues()!=null? acknowledgement.getPrimaryKeyValues():"");
		
		remark = remark.length() > 500 ? remark.substring(0,499) :remark; 
		insertIntegrationLog(integrationLog, "ACK", RefCodeConstant.RECEIVED_REQUEST, acknowledgement.getPrimaryKeyValues().size(), "", remark, 2,integrationLogService);

//		Local testing Url
		//uri = "http://10.1.25.139:8080/iphis_BaseMerged/rest/acknowledgement/post";
		System.out.println(uri);
		System.err.println(uri);
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			System.out.println("==========********==========>sdrJson string:  " + mapper.writeValueAsString(acknowledgement));
			if (uri != null && uri.trim().length() > 0) {
				ResponseEntity<Integer> httpRequest = restTemplate.postForEntity(uri, httpAcknowledgementEntity, Integer.class);
				if(httpRequest.getStatusCode() == HttpStatus.OK)
				{
					updateIntegrationLog(integrationLog, my.com.cmg.iwp.webui.constant.RefCodeConstant.SENT_ACKNOWLEDGEMENT, "", remark, integrationLogService);
				}
				else
				{
					updateIntegrationLog(integrationLog, my.com.cmg.iwp.webui.constant.RefCodeConstant.SENT_ACKNOWLEDGEMENT, "", remark, integrationLogService);
				}
			}
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		} catch (HttpClientErrorException e){
			e.printStackTrace();
			return;
		}
//		FacilityDetailService facilityDetailService = SpringApplicationContext.getBean("facilityDetailService");
//		RestTemplate restTemplate =  new RestTemplate();
		
		
		
		return;
		
	}
	
	public static void updateIntegrationLog(IntegrationLog integrationLog, String status, String errorMsg, String remarks, IntegrationLogService integrationLogService) {
		integrationLog.setStatus(status);
		integrationLog.setErrorMsg(errorMsg);
		integrationLog.setRemarks(remarks);
		integrationLog.setEndDate(new Date());
		integrationLogService.saveOrUpdate(integrationLog);
	}

	public static void insertIntegrationLog(IntegrationLog integrationLog, String moduleCode, String status, int recordCount, String errorMsg, String remarks, int createdBy, IntegrationLogService integrationLogService){
		integrationLog.setModuleCode(moduleCode);
		integrationLog.setStatus(status);
		integrationLog.setStartDate(new Date());
		integrationLog.setRecordCount(recordCount);
		integrationLog.setErrorMsg(errorMsg);
		integrationLog.setRemarks(remarks);
		integrationLog.setCreatedBy(createdBy);
		integrationLog.setCreatedDate(new Date());
		integrationLogService.saveOrUpdate(integrationLog);
	}
	
public static RestTemplate getRestTemplate() {
		
//		RestTemplate restTemplate = SpringApplicationContext.getBean("restTemplate");
		RestTemplate restTemplate = (RestTemplate) SpringUtil.getBean("restTemplate");
		
		return restTemplate;
	}
	
	

}
