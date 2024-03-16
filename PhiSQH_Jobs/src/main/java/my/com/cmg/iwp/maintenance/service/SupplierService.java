package my.com.cmg.iwp.maintenance.service;

import my.com.cmg.iwp.maintenance.model.Supplier;

public interface SupplierService {

	Supplier getNewSupplier();

	void saveOrUpdate(Supplier anSupplier);

	void delete(Supplier anSupplier);

	Supplier findBySupplierCode(String value);

	String getSupplierNewCode();

}
