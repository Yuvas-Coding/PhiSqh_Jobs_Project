package my.com.cmg.iwp.maintenance.service;

import java.math.BigDecimal;
import java.util.List;

import my.com.cmg.iwp.maintenance.model.CBMaster;
import my.com.cmg.iwp.maintenance.model.DoDtl;
import my.com.cmg.iwp.maintenance.model.Item;
import my.com.cmg.iwp.maintenance.model.Payment;
import my.com.cmg.iwp.maintenance.model.PaymentByVotecode;
import my.com.cmg.iwp.maintenance.model.PaymentDtl;
import my.com.cmg.iwp.maintenance.model.PoCfHdr;
import my.com.cmg.iwp.maintenance.model.PoDtl;
import my.com.cmg.iwp.maintenance.model.PoHdr;
import my.com.cmg.iwp.maintenance.model.SecUser;
import my.com.cmg.iwp.maintenance.model.Supplier;
import my.com.cmg.iwp.maintenance.model.VoteCode;

public interface PaymentService {
	
	public Payment getNewPayment();
	
	void saveOrUpdate(Payment anPayment);
	
	void delete(Payment anPayment);

	public boolean isNew(Payment anPayment);
	
	public List<PoDtl> findPodtl(String quary);

	public List<DoDtl> findDoDetail(String quary);

	public List<PoDtl> getPoHdrObject(PoDtl podtl);
	
	public List<Payment> getPaymentObject(Payment payment);

	public List<PoHdr> getPohdr(PoHdr pohdr);

	public List<PaymentByVotecode> getpaymentByVotecode(PaymentByVotecode paymentByVotecode);

	public List<Payment> getPayment(Payment payment);

	public void savepoHdr(PoHdr poHdr);

	public SecUser getSecUser(SecUser secUser);

	public Payment getPaymentforTaskList(String tlTaskNo);

	public PoHdr getPoFromPayment(Long paymentSeqno);
	
	public List<CBMaster> getCurrentBudgetMaster(VoteCode voteCode,BigDecimal financialYear);
	
	void saveOrUpdate(CBMaster budgetMaster);

	public List<VoteCode> getvotecode(VoteCode voteCode);

	public void saveOrUpdate(VoteCode voteCodemaster);

	public PaymentDtl getPaymentDtl(PaymentDtl paymentDtl);

	public DoDtl getDoDetailbyDoseqNo(Long doNo);
	
	public List<VoteCode> getvotecodebyCode(String voteCode);

	public List<Supplier> getsupplierByCode(String supplier_code);

	public List<DoDtl> getDoDtlBylpoNo(String lpoNo,Item item);

	public PoDtl getpoDetail(PoHdr poHdr, Item item);

	public Payment getPaymentForTaskList(Long paymentSeqno);

	public List<Payment> getPaymentsByLPONoAndStatus(String lpoNo, String facilityCode, String... status);

	public List<Payment> getLPOdtlsBypayment(boolean isHqUser, String ptjCode, String lpono);
	
	public Double getLpoAmountFromPoHdrBack(long paymentSeqno);

	boolean createDO(String doXML);

	CBMaster getNewCurrentBudgetMaster(long oldCbMsterSeqno);

	PoCfHdr getCarryForwardRecord(String lpoNo, String facilityCode);
	
	CBMaster getCurrentBudgetMaster(long oldCbMsterSeqno);
	
	public List<Payment> getPaymentsByInvoiceNoAndStatus(String invoiceNo);

}
