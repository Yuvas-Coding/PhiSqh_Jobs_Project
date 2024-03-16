package my.com.cmg.iwp.maintenance.service.impl;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.Uom;
import my.com.cmg.iwp.maintenance.service.UomService;
import my.com.cmg.iwp.webui.constant.RefCodeConstant;
@Service
public class UomServiceImpl implements UomService {

	private BasisNextidDaoImpl<Uom> uomDAO;

	@Override
	public Uom getNewUom() {
		return new Uom();
	}

	@Override
	public void delete(Uom anUom) {
		uomDAO.delete(anUom);

	}

	@Override
	public void saveOrUpdate(Uom anUom) {
		uomDAO.saveOrUpdate(anUom);

	}

	public void setUomDAO(BasisNextidDaoImpl<Uom> uomDAO) {
		this.uomDAO = uomDAO;
	}

	public BasisNextidDaoImpl<Uom> getUomDAO() {
		return uomDAO;
	}

	@Override
	public List<Uom> getAllUomAbbreviation() {

		DetachedCriteria criteria = DetachedCriteria.forClass(Uom.class);
		criteria.add(Restrictions.eq("activeFlag", RefCodeConstant.ACTIVE_FLAG_TRUE));
		return uomDAO.findByCriteria(criteria);
	}

	@Override
	public Uom getPackagingByUomAbb(String uomAbb) {

		DetachedCriteria criteria = DetachedCriteria.forClass(Uom.class);
		criteria.add(Restrictions.eq("uomAbbreviation", uomAbb));
		return DataAccessUtils.uniqueResult(uomDAO.findByCriteria(criteria));
	}

	@Override
	public Uom getPackagingByUomSeqNo(Uom uom) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Uom.class);
		criteria.add(Restrictions.eq("uomSeqno", uom.getUomSeqno()));
		return DataAccessUtils.uniqueResult(uomDAO.findByCriteria(criteria));
	}

	@Override
	public Uom getUomByDesc(String desc) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Uom.class);
		criteria.add(Restrictions.eq("uomDesc", desc));
		return DataAccessUtils.uniqueResult(uomDAO.findByCriteria(criteria));
	}

	@Override
	public List<Uom> getUomBySeqNo(Uom strengthUom, Uom quantityUom) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Uom.class);
		Criterion crit1 = Restrictions
				.eq("uomSeqno", strengthUom.getUomSeqno());
		Criterion crit2 = Restrictions
				.eq("uomSeqno", quantityUom.getUomSeqno());
		criteria.add(Restrictions.or(crit1, crit2));
		return uomDAO.findByCriteria(criteria);
	}

	@Override
	public Uom getUomByUomSeqNo(long uomSeqno) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Uom.class);
		criteria.add(Restrictions.eq("uomSeqno", uomSeqno));
		return DataAccessUtils.uniqueResult(uomDAO.findByCriteria(criteria));
	}

	@Override
	public List<Uom> getSpecificUomAbbreviation(String value) {

		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(Uom.class);

		detachedCriteria.add(Restrictions.ilike("uomAbbreviation", value,
				MatchMode.EXACT));

		return uomDAO.findByCriteria(detachedCriteria);
	}
	
	@Override
	public List<Uom> getAllUomAbbreviationBySort() {

		DetachedCriteria criteria = DetachedCriteria.forClass(Uom.class);
		criteria.add(Restrictions.eq("activeFlag", RefCodeConstant.ACTIVE_FLAG_TRUE));
		criteria.addOrder(Order.asc("uomDesc"));
		return uomDAO.findByCriteria(criteria);
	}

}
