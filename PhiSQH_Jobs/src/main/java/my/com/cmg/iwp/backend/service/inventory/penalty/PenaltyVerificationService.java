package my.com.cmg.iwp.backend.service.inventory.penalty;

import java.util.List;

import my.com.cmg.iwp.backend.model.inventory.penalty.PenaltyVerificationHdr;

public interface PenaltyVerificationService {
	
	public void saveOrUpdate(PenaltyVerificationHdr PenaltyVerification);
	
	public void saveOrUpdateAll(List<PenaltyVerificationHdr> PenaltyVerifications);
	
	public void delete(PenaltyVerificationHdr PenaltyVerification);
	
	public void deleteAll(List<PenaltyVerificationHdr> PenaltyVerifications);
	
	public List<PenaltyVerificationHdr> findByExample(PenaltyVerificationHdr PenaltyVerification);

	public List<PenaltyVerificationHdr> getPenaltyVerificationHdrByExample(PenaltyVerificationHdr penaltyVerificationHdr);
	
	public List<String> getFacilityCode();
	
	public Long getDimUserID();
	
	public List<PenaltyVerificationHdr> getPenaltyVerificationHdrsToSync();
	
	public List<String> getPenaltyVerificationRejectList(String ptjCode);
	
	public List<String> getPenaltyVerificationTrxRejList(String ptjCode);
	
}
