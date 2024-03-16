package my.com.cmg.iwp.backend.service.inventory.penalty;

import java.util.Date;
import java.util.List;

import my.com.cmg.iwp.backend.model.inventory.penalty.PenaltyHdr;
import my.com.cmg.iwp.maintenance.model.PenaltyIncident;
import my.com.cmg.iwp.maintenance.model.PenaltyIncidentCalDtls;
import my.com.cmg.iwp.maintenance.service.CalendarService;


public interface PenaltyHdrService {
	
	public void saveOrUpdate(PenaltyHdr penaltyHdr);
	
	public void saveOrUpdateAll(List<PenaltyHdr> penaltyHdrs);
	
	public void delete(PenaltyHdr penaltyHdr);
	
	public void deleteAll(List<PenaltyHdr> penaltyHdrs);
	
	public List<PenaltyHdr> findByExample(PenaltyHdr penaltyHdr);

	public List<PenaltyIncident> getPenaltyIncidentByIncidentCode(String incidentCode);

	public PenaltyHdr getPenaltyByExampleForDialog(PenaltyHdr penaltyHdr);

	public PenaltyHdr getPenaltyByTransportationRefNo(String transRefNo);

	List<PenaltyHdr> findByExampleForRenderer(PenaltyHdr penaltyHdr);

	public List<PenaltyHdr> getPeanltyHdrsToSync();
	
	public long getIntervalByWorkingDays(Date date1, Date date2, String statecode,CalendarService calendarService);
	
	Date getDeliveryDueDateFromPoHdrBack(long poHdrSeqno);
	
	public PenaltyIncidentCalDtls getPenaltyIncidentDtlsByFormulaCode(String formulaCode);
	
	public void PenaltyHdrSentToFacilityFlagUpdate(String transactionNumber);
	
	public Double getProposedAmt(long Seqno);
	
	List<PenaltyHdr> findForRenderer(PenaltyHdr penaltyHdr);
	
}
