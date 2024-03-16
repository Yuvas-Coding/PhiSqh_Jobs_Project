package my.com.cmg.iwp.maintenance.service;

import java.util.List;

import my.com.cmg.iwp.maintenance.model.Uom;

public interface UomService {

	Uom getNewUom();

	void delete(Uom anUom);

	void saveOrUpdate(Uom anUom);

	List<Uom> getAllUomAbbreviation();

	Uom getPackagingByUomAbb(String uomAbb);

	Uom getPackagingByUomSeqNo(Uom uom);

	Uom getUomByDesc(String desc);

	List<Uom> getUomBySeqNo(Uom strengthUom, Uom quantityUom);

	Uom getUomByUomSeqNo(long uomSeqno);

	List<Uom> getSpecificUomAbbreviation(String value);

	List<Uom> getAllUomAbbreviationBySort();

}
