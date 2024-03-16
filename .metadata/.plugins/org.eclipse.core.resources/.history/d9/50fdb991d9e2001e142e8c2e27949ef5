package my.com.cmg.iwp.maintenance.service;

import java.util.List;

import my.com.cmg.iwp.maintenance.model.InvoiceDtl;
import my.com.cmg.iwp.maintenance.model.ResultObject;

public interface InvoiceDtlService {
	public ResultObject getAllDetails(int start, int pageSize);

	public List<InvoiceDtl> getAllDetails();

	public InvoiceDtl getInvoiceDtlByCriteria(String lpoNo, String customerAccNo);
	
    public InvoiceDtl getNewInvoiceDtl();
	
	public void saveOrUpdate(InvoiceDtl anInvoiceDtl);
	
	public InvoiceDtl getInvoiceDtlName(long invoiceSeq);	
	
}
