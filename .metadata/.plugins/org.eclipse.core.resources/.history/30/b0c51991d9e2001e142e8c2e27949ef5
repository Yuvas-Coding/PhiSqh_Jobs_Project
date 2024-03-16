package my.com.cmg.iwp.maintenance.service.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.InvoiceDtl;
import my.com.cmg.iwp.maintenance.model.ResultObject;
import my.com.cmg.iwp.maintenance.service.InvoiceDtlService;
@Service
public class InvoiceDtlServiceImpl implements InvoiceDtlService, Serializable {
	private static final long serialVersionUID = 1L;
	private BasisNextidDaoImpl<InvoiceDtl> invoiceDAO;

	public BasisNextidDaoImpl<InvoiceDtl> getInvoiceDAO() {
		return invoiceDAO;
	}

	public void setInvoiceDAO(BasisNextidDaoImpl<InvoiceDtl> invoiceDAO) {
		this.invoiceDAO = invoiceDAO;
	}

	@Override
	public ResultObject getAllDetails(int start, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(InvoiceDtl.class);
		criteria.addOrder(Order.asc("lpoNo"));
		int totalCount = getInvoiceDAO().findByCriteria(criteria).size();
		List<InvoiceDtl> list = getInvoiceDAO().findByCriteria(criteria, start,
				pageSize);
		return new ResultObject(list, totalCount);
	}
	
	@Override
	public InvoiceDtl getNewInvoiceDtl() {
		// TODO Auto-generated method stub
		return new InvoiceDtl();
	}
	
	@Override
	public void saveOrUpdate(InvoiceDtl anInvoiceDtl) {
		// TODO Auto-generated method stub
		getInvoiceDAO().saveOrUpdate(anInvoiceDtl);

	}
	
	@Override
	public InvoiceDtl getInvoiceDtlName(long invoiceSeq) {

		DetachedCriteria criteria = DetachedCriteria.forClass(InvoiceDtl.class);
		criteria.add(Restrictions.eq("invoiceSeq", invoiceSeq));
		return DataAccessUtils.uniqueResult(getInvoiceDAO().findByCriteria(criteria));

	}	

	@Override
	public List<InvoiceDtl> getAllDetails() {
		// DetachedCriteria criteria =
		// DetachedCriteria.forClass(InvoiceDtl.class);
		// criteria.addOrder(Order.asc("lpoNo"));
		// return getInvoiceDAO().findByCriteria(criteria);
		return getInvoiceDAO().loadAll(InvoiceDtl.class);
	}

	@Override
	public InvoiceDtl getInvoiceDtlByCriteria(String lpoNo, String customerAccNo) {
		DetachedCriteria criteria = DetachedCriteria.forClass(InvoiceDtl.class);
		criteria.add(Restrictions.eq("lpoNo", lpoNo));
		criteria.add(Restrictions.eq("ptjCode", customerAccNo));
		List<InvoiceDtl> invoiceDtls = getInvoiceDAO().findByCriteria(criteria);
		if (null != invoiceDtls && ! invoiceDtls.isEmpty()) 
			return invoiceDtls.get(0);
		else 
			return null;
	}
}