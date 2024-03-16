package my.com.cmg.iwp.maintenance.service.impl;

import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.ApItemPrice;
import my.com.cmg.iwp.maintenance.service.ApItemPriceService;
@Service
public class ApItemPriceServiceImpl implements ApItemPriceService {

	private BasisNextidDaoImpl<ApItemPrice> apItemPriceDAO;

	public void setApItemPriceDAO(BasisNextidDaoImpl<ApItemPrice> apItemPriceDAO) {
		this.apItemPriceDAO = apItemPriceDAO;
	}

	public BasisNextidDaoImpl<ApItemPrice> getApItemPriceDAO() {
		return apItemPriceDAO;
	}

	@Override
	public ApItemPrice getNewApItemPrice() {

		return new ApItemPrice();
	}

	@Override
	public void delete(ApItemPrice anApItemPrice) {

		apItemPriceDAO.delete(anApItemPrice);

	}

	@Override
	public void saveOrUpdate(ApItemPrice anApItemPrice) {

		apItemPriceDAO.saveOrUpdate(anApItemPrice);

	}

}
