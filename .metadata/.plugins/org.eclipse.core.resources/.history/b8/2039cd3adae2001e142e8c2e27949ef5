package my.com.cmg.iwp.maintenance.service.impl;

import javax.management.Query;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.Supplier;
import my.com.cmg.iwp.maintenance.service.SupplierService;
@Service
public class SupplierServiceImpl implements SupplierService {

	private BasisNextidDaoImpl<Supplier> supplierDAO;

	public BasisNextidDaoImpl<Supplier> getSupplierDAO() {
		return supplierDAO;
	}

	public void setSupplierDAO(BasisNextidDaoImpl<Supplier> supplierDAO) {
		this.supplierDAO = supplierDAO;
	}

	@Override
	public Supplier getNewSupplier() {
		return new Supplier();
	}

	@Override
	public void saveOrUpdate(Supplier anSupplier) {
		getSupplierDAO().saveOrUpdate(anSupplier);
	}

	@Override
	public void delete(Supplier anSupplier) {
		getSupplierDAO().delete(anSupplier);
	}

	@Override
	public Supplier findBySupplierCode(String supCode) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Supplier.class);
		criteria.add(Restrictions.eq("supplierCode", supCode));
		return DataAccessUtils.uniqueResult(supplierDAO
				.findByCriteria(criteria));
	}

	@Override
	public String getSupplierNewCode() {
		Session session = getSupplierDAO().getSessionFactory().openSession();
		Query query = session.createSQLQuery( "SELECT T_SUPPLIER_CODE_SEQ.nextval from dual" );
		String seqNo = query.list().iterator().next().toString();
		session.close();
		String appendZeros = 6 - seqNo.length() > 0 ? (String.format("%"+(6 - seqNo.length())+"s", "").replace(' ', '0').toString()) : "";
		return ("SUPP"+appendZeros+seqNo);
	}
}
