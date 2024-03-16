package my.com.cmg.iwp.maintenance.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.Reason;
import my.com.cmg.iwp.maintenance.service.ReasonService;
import my.com.cmg.iwp.webui.maintenance.reason.ReasonDialogCtrl;
@Service
public class ReasonServiceImpl implements ReasonService {

	private BasisNextidDaoImpl<Reason> reasonDAO;

	public BasisNextidDaoImpl<Reason> getReasonDAO() {
		return reasonDAO;
	}

	public void setReasonDAO(BasisNextidDaoImpl<Reason> reasonDAO) {
		this.reasonDAO = reasonDAO;
	}

	@Override
	public Reason getNewReason() {
		return new Reason();
	}

	@Override
	public void delete(Reason anReason) {
		reasonDAO.delete(anReason);

	}

	@Override
	public void saveOrUpdate(Reason anReason) {
		reasonDAO.saveOrUpdate(anReason);

	}

	@Override
	public List<Reason> getAllOrderHoldReasons() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Reason.class);
		criteria.add(Restrictions.eq("reasonType", ReasonDialogCtrl.HOLD));
		return reasonDAO.findByCriteria(criteria);
	}

	@Override
	public List<Reason> getAllReasonsByType(String type) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Reason.class);
		criteria.add(Restrictions.eq("reasonType", type));
		criteria.addOrder(Order.asc("reasonCode"));
		return reasonDAO.findByCriteria(criteria);
	}

	@Override
	public Reason findByReasonCode(String reasonCode) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Reason.class);
		criteria.add(Restrictions.eq("reasonCode", reasonCode));
		return DataAccessUtils.uniqueResult(reasonDAO.findByCriteria(criteria));
	}

	@Override
	public Reason findByReasonDesc(String desc, String reasonType) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Reason.class);
		criteria.add(Restrictions.eq("reasonDesc", desc));
		criteria.add(Restrictions.eq("reasonType", reasonType));
		return DataAccessUtils.uniqueResult(reasonDAO.findByCriteria(criteria));
	}

	@Override
	public Reason findByReasonSeqno(long seqno) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Reason.class);
		criteria.add(Restrictions.eq("reasonSeqno", seqno));
		return DataAccessUtils.uniqueResult(reasonDAO.findByCriteria(criteria));
	}
}