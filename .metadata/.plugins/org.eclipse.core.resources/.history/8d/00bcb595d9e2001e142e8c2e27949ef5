package my.com.cmg.iwp.backend.service.inventory.penalty;

import java.util.List;

import my.com.cmg.iwp.backend.model.inventory.penalty.PenaltyPayment;

public interface PenaltyPaymentService {
	
	public void saveOrUpdate(PenaltyPayment PenaltyPayment);
	
	public void saveOrUpdateAll(List<PenaltyPayment> PenaltyPayments);
	
	public void delete(PenaltyPayment PenaltyPayment);
	
	public void deleteAll(List<PenaltyPayment> PenaltyPayments);
	
	public List<PenaltyPayment> findByExample(PenaltyPayment PenaltyPayment);

	public List<PenaltyPayment> getPenaltyPaymentByExample(PenaltyPayment examplePenaltyPayment);

	public List<PenaltyPayment> getPenaltyPaymentHdrsToSync();

	public List<String> getPenaltyPaymentRejectList();
	
}
