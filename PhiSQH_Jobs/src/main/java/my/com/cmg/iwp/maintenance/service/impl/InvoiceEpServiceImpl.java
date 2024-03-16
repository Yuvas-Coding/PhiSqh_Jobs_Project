package my.com.cmg.iwp.maintenance.service.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.InvoiceEp;
import my.com.cmg.iwp.maintenance.service.InvoiceEpService;
@Service
public class InvoiceEpServiceImpl implements InvoiceEpService, Serializable {
	private static final long serialVersionUID = 1L;
	
	private BasisNextidDaoImpl<InvoiceEp> invoiceEPDAOImpl;

	public BasisNextidDaoImpl<InvoiceEp> getInvoiceEPDAOImpl() {
		return invoiceEPDAOImpl;
	}

	public void setInvoiceEPDAOImpl(BasisNextidDaoImpl<InvoiceEp> invoiceEPDAOImpl) {
		this.invoiceEPDAOImpl = invoiceEPDAOImpl;
	}

	@Override
	public void saveOrUpdate(InvoiceEp invoiceEp) {
		getInvoiceEPDAOImpl().saveOrUpdate(invoiceEp);
		
	}

	@Override
	public List<InvoiceEp> getInvoiceByLPONo(String lpoNo, String facilityCode) {
		if(lpoNo!=null && !lpoNo.isEmpty() && lpoNo.contains("'"))
			lpoNo=lpoNo.replace("'", "''");
		DetachedCriteria criteria = DetachedCriteria.forClass(InvoiceEp.class);
		System.err.println("LPO No "+lpoNo);
		criteria.add(Restrictions.like("contractOrderNo", "%"+lpoNo.trim()+"%"));
//		return getInvoiceEPDAOImpl().findByCriteria(criteria);
		return getInvoiceEPDAOImpl().find("from InvoiceEp where CONTRACT_ORDER_NO='" + lpoNo.trim() + "' and facility_code ='"+facilityCode+"'");
	}

}
