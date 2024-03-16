package my.com.cmg.iwp.maintenance.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.DeliveredTo;
import my.com.cmg.iwp.maintenance.service.DeliveredToService;

@Service
public class DeliveredToServiceImpl implements DeliveredToService {
	private BasisNextidDaoImpl<DeliveredTo> deliveredToDAO;

	@Override
	public DeliveredTo getNewDeliveredTo() {
		return new DeliveredTo();
	}

	@Override
	public void delete(DeliveredTo anDeliveredTo) {
		deliveredToDAO.delete(anDeliveredTo);
	}

	@Override
	public void saveOrUpdate(DeliveredTo anDeliveredTo) {
		deliveredToDAO.saveOrUpdate(anDeliveredTo);
	}

	public void setDeliveredToDAO(BasisNextidDaoImpl<DeliveredTo> deliveredToDAO) {
		this.deliveredToDAO = deliveredToDAO;
	}

	public BasisNextidDaoImpl<DeliveredTo> getDeliveredToDAO() {
		return deliveredToDAO;
	}

	@Override
	public List<DeliveredTo> getAllDeliveredTo() {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(DeliveredTo.class);
		criteria.addOrder(Order.desc("delToSeqno"));
		return deliveredToDAO.findByCriteria(criteria);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getDeliveredToCodeById(String code) {

		return deliveredToDAO.find(code);
	}

	@Override
	public DeliveredTo getFacilityDeliveredTo(String deliverySiteTo) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(DeliveredTo.class);
		criteria.add(Restrictions.eq("delToCode", deliverySiteTo));
		return deliveredToDAO.findByCriteria(criteria).get(0);
	}

	@Override
	public DeliveredTo findByDeliveryToCode(String deliveryToCode) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(DeliveredTo.class);
		criteria.add(Restrictions.eq("delToCode", deliveryToCode));
		return DataAccessUtils.uniqueResult(deliveredToDAO
				.findByCriteria(criteria));
	}
	
	@Override
	public DeliveredTo findBySeqNo(Long delToSeqno) {
		DetachedCriteria criteria = DetachedCriteria.forClass(DeliveredTo.class);
		criteria.add(Restrictions.eq("delToSeqno", delToSeqno));
		return DataAccessUtils.uniqueResult(deliveredToDAO.findByCriteria(criteria));
	}

	@Override
	public List<DeliveredTo> getDeliveredToCodeByPtj(String ptjCode) {
		DetachedCriteria criteria = DetachedCriteria.forClass(DeliveredTo.class);
		criteria.add(Restrictions.eq("ptjCode", ptjCode));
		criteria.add(Restrictions.eq("activeFlag", 'A'));
		return  deliveredToDAO.findByCriteria(criteria);
	}
}