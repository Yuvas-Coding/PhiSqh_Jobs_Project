package my.com.cmg.iwp.maintenance.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import my.com.cmg.iwp.maintenance.model.ExternalFacility;
import my.com.cmg.iwp.maintenance.model.IntegrationBean;
import my.com.cmg.iwp.maintenance.model.PoHdr;
import my.com.cmg.iwp.webui.report.SummaryePintegrationBean;

public interface PoHdrService {

	List<PoHdr> getdel_to_code_from_po_hdr(Long delSeqNo);

	List<PoHdr> searchOrderAnalysisByCriteria(String lpoNo, String epoNo,
			ExternalFacility custMstr, String epoDateFrm, String epoDateT,
			String lpoDateFrm, String lpoDateT) throws Exception;

	List<PoHdr> getPOHdrsByFacility(String facilityCode);

	List<PoHdr> searchOrderStatasticsByCriteria(ExternalFacility custMstr,
			String epoDateFrm, String epoDateT, String searchOption,
			List<String> clinicCodes, List<String> hosCodes) throws Exception;
	
	List<IntegrationBean> getLPOApprovalCount(String dateFrom, String dateTo,String ptjCode);

	List<IntegrationBean> findByCriteria(String dateFrom,String dateTo,String ptjCode);

	List<PoHdr> findByLpoApprovedDate(Date integrationDate,String facilityCode);

	List<PoHdr> findOrderByPOStatus(Date integrationDate, String status);
	
	Integer getLPOApprovalLogCount(String dateFrom, String dateTo);

	Map<String,Integer> getPayNotificCount(String dateFrom, String dateTo);

	Map<String,Integer> getEPOInOutLogCount(String dateFrom, String dateTo);

	Map<String, Integer> getLPOInOutLogCount(String dateFrom, String dateTo);

	Map<String, Integer> getFullFillInOutCount(String dateFrom, String dateTo);

	Map<String, Integer> getInvoiceInOutCount(String dateFrom, String dateTo);

	Map<String, Integer> getPendingForPKDApprovalCount(String dateFrom, String dateTo);

	Map<String, Integer> getPKDApprovedCount(String dateFrom, String dateTo);
	
	PoHdr getPOHdrsByFacilityAndPurchaseOrderNo(String facilityCode,String purchaseOrderNo);

	String getShippingAddress(PoHdr poHdrHq);

	String getShipToCode(PoHdr poHdrHq);

	Date getLPOTransmittedDate(Date lpoDate, String facilityCode, Integer deliveryLeadTime) throws Exception;

	void saveOrUpdatePoHdr(PoHdr PoHdr);

	double getTotalOrderAmount(PoHdr poHdr);
	
	public List<SummaryePintegrationBean> getSummaryePintegration(Date dateFrom, Date dateTo);
	PoHdr getPoHdrByLpoNo(String lpoNo);

	PoHdr getPoHdrByLpoNo(Long poHdrSeqno);
}
