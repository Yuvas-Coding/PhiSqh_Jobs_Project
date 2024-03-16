package my.com.cmg.iwp.maintenance.service;

import my.com.cmg.iwp.maintenance.model.ApItemPrice;

public interface ApItemPriceService {

	ApItemPrice getNewApItemPrice();

	void delete(ApItemPrice anApItemPrice);

	void saveOrUpdate(ApItemPrice anApItemPrice);

}
