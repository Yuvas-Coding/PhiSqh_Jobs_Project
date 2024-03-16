package my.com.cmg.iwp.maintenance.service.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.Item;
import my.com.cmg.iwp.maintenance.model.SecUser;
import my.com.cmg.iwp.maintenance.model.his.EPOHdrStg;
import my.com.cmg.iwp.maintenance.service.EPOHdrStgService;
import my.com.cmg.iwp.maintenance.service.ItemService;
import my.com.cmg.iwp.maintenance.service.PoHdrService;
import my.com.cmg.iwp.maintenance.service.SecUserService;
@Service
public class EPOHdrStgServiceImpl implements EPOHdrStgService {
	
	private BasisNextidDaoImpl epoHdrStgDAO;
	private ItemService itemService;
	private PoHdrService poHdrService;
	private SecUserService secUserService;

	/*ACCESSORS AND MUTATORS*/
	public BasisNextidDaoImpl<EPOHdrStg> getEpoHdrStgDAO() { return epoHdrStgDAO; }
	public void setEpoHdrStgDAO(BasisNextidDaoImpl<EPOHdrStg> epoHdrStgDAO) { this.epoHdrStgDAO = epoHdrStgDAO; }
	public ItemService getItemService() { return itemService; }
	public void setItemService(ItemService itemService) { this.itemService = itemService; }
	public PoHdrService getPoHdrService() { return poHdrService; }
	public void setPoHdrService(PoHdrService poHdrService) { this.poHdrService = poHdrService; }
	public SecUserService getSecUserService() { return secUserService; }
	public void setSecUserService(SecUserService secUserService) { this.secUserService = secUserService; }
	
	@Override
	public void saveOrUpdateEPOPoHdrStg(EPOHdrStg epoHdrStg) {
		getEpoHdrStgDAO().saveOrUpdate(epoHdrStg);
	}
	
	@Override
	public Item getItem(String itemCode) {
		return getItemService().findByItemCode(itemCode);
	}
	
	@Override
    public Date getLPOTransmittedDate(Date lpoDate,String facilityCode,Integer deliveryLeadTime) throws Exception {
		return getPoHdrService().getLPOTransmittedDate(lpoDate, facilityCode, deliveryLeadTime);
	}
	
	@Override
	public SecUser getSecUserFetches(SecUser secUser) {
		return getSecUserService().getSecUserFetches(secUser);
	}
}
