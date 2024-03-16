package my.com.cmg.iwp.backend.service.inventory.penalty;

import java.util.List;

import my.com.cmg.iwp.backend.model.inventory.penalty.PenaltyBatch;

public interface PenaltyBatchService {
	
	public void saveOrUpdate(PenaltyBatch PenaltyBatch);
	
	public void saveOrUpdateAll(List<PenaltyBatch> PenaltyBatchs);
	
	public void delete(PenaltyBatch PenaltyBatch);
	
	public void deleteAll(List<PenaltyBatch> PenaltyBatchs);
	
	public List<PenaltyBatch> findByExample(PenaltyBatch PenaltyBatch);
	
	List<PenaltyBatch> verificationDtlbyitem (String Lpono,String facilityCode,String ptjCode,String transactionNo);
	
}
