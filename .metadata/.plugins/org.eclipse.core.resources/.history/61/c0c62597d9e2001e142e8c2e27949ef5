package my.com.cmg.iwp.backend.service.integration.impl;

import org.springframework.stereotype.Service;

import my.com.cmg.iwp.backend.model.integration.OutsourceOrderInt;
import my.com.cmg.iwp.backend.model.integration.iv.IvDoseFrequencyInt;
import my.com.cmg.iwp.backend.model.integration.iv.IvHdrInt;
import my.com.cmg.iwp.backend.model.integration.iv.OrderIvInt;
import my.com.cmg.iwp.backend.service.integration.ExternalOrderIntService;
import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
@Service
public class ExternalOrderIntServiceImpl implements ExternalOrderIntService {

	private BasisNextidDaoImpl<OutsourceOrderInt> outsourceOrderIntDAO;
	private BasisNextidDaoImpl<IvHdrInt> ivHdrIntDAO;
	private BasisNextidDaoImpl<IvDoseFrequencyInt> ivDoseFrequencyIntDAO;
	private BasisNextidDaoImpl<OrderIvInt> orderIvIntDAO;

	@Override
	public void saveOrUpdate(OutsourceOrderInt outsourceOrderInt) {
		outsourceOrderIntDAO.saveOrUpdate(outsourceOrderInt);
	}

	@Override
	public void saveOrUpdate(IvHdrInt ivHdrInt) {
		ivHdrIntDAO.saveOrUpdate(ivHdrInt);
	}

	@Override
	public void saveOrUpdate(OrderIvInt orderIvInt) {
		orderIvIntDAO.saveOrUpdate(orderIvInt);
	}

	@Override
	public void saveOrUpdate(IvDoseFrequencyInt ivDoseFrequencyInt) {
		ivDoseFrequencyIntDAO.saveOrUpdate(ivDoseFrequencyInt);
	}

	public BasisNextidDaoImpl<OutsourceOrderInt> getOutsourceOrderIntDAO() {
		return outsourceOrderIntDAO;
	}

	public void setOutsourceOrderIntDAO(
			BasisNextidDaoImpl<OutsourceOrderInt> outsourceOrderIntDAO) {
		this.outsourceOrderIntDAO = outsourceOrderIntDAO;
	}

	public BasisNextidDaoImpl<IvHdrInt> getIvHdrIntDAO() {
		return ivHdrIntDAO;
	}

	public void setIvHdrIntDAO(BasisNextidDaoImpl<IvHdrInt> ivHdrIntDAO) {
		this.ivHdrIntDAO = ivHdrIntDAO;
	}

	public BasisNextidDaoImpl<IvDoseFrequencyInt> getIvDoseFrequencyIntDAO() {
		return ivDoseFrequencyIntDAO;
	}

	public void setIvDoseFrequencyIntDAO(
			BasisNextidDaoImpl<IvDoseFrequencyInt> ivDoseFrequencyIntDAO) {
		this.ivDoseFrequencyIntDAO = ivDoseFrequencyIntDAO;
	}

	public BasisNextidDaoImpl<OrderIvInt> getOrderIvIntDAO() {
		return orderIvIntDAO;
	}

	public void setOrderIvIntDAO(BasisNextidDaoImpl<OrderIvInt> orderIvIntDAO) {
		this.orderIvIntDAO = orderIvIntDAO;
	}

}
