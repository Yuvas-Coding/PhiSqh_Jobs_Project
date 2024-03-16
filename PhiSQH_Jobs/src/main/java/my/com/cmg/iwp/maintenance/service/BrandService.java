package my.com.cmg.iwp.maintenance.service;

import my.com.cmg.iwp.maintenance.model.Brand;
import my.com.cmg.iwp.maintenance.model.ResultObject;

public interface BrandService {

	Brand getNewBrand();

	void delete(Brand anBrand);

	void saveOrUpdate(Brand anBrand);

	Brand get(Class<Brand> class1, long brandSeqNo);

	String findbyBrandCode(String value);

	String findbyBrandName(String value);

	Brand findByBrandCode(String value);

	ResultObject getAllDrugsBrandNameLikeText(String searchBrandName,
			int start, int pageSize);

	Brand findByBrandName(String brandrName);
}
