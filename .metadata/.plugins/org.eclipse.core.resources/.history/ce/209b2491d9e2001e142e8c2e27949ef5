package my.com.cmg.iwp.maintenance.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.FetchMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.zkoss.spring.SpringUtil;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.Brand;
import my.com.cmg.iwp.maintenance.model.Item;
import my.com.cmg.iwp.maintenance.model.ItemBrand;
import my.com.cmg.iwp.maintenance.model.Manufacturer;
import my.com.cmg.iwp.maintenance.model.SecUser;
import my.com.cmg.iwp.maintenance.service.BrandService;
import my.com.cmg.iwp.maintenance.service.ItemBrandService;
import my.com.cmg.iwp.maintenance.service.ItemService;
import my.com.cmg.iwp.maintenance.service.ManufacturerService;
import my.com.cmg.iwp.webui.constant.RefCodeConstant;
import my.com.cmg.iwp.webui.util.CommonUtil;
@Service
public class ItemBrandServiceImpl implements ItemBrandService {

	private BasisNextidDaoImpl<ItemBrand> itemBrandDAO;

	@Override
	public ItemBrand getNewItemBrand() {

		return new ItemBrand();
	}

	public void setItemBrandDAO(BasisNextidDaoImpl<ItemBrand> itemBrandDAO) {
		this.itemBrandDAO = itemBrandDAO;
	}

	public BasisNextidDaoImpl<ItemBrand> getItemBrandDAO() {
		return itemBrandDAO;
	}
	
	@Override
	public boolean isNewItemBrand(ItemBrand anItemBrand) {
		return anItemBrand.getItemBrdSeqno() == Long.MIN_VALUE;
	}

	@Override
	public void delete(ItemBrand anItemBrand) {

		itemBrandDAO.delete(anItemBrand);

	}

	@Override
	public void saveOrUpdate(ItemBrand anItemBrand) {

		itemBrandDAO.saveOrUpdate(anItemBrand);

	}

	@Override
	public List<ItemBrand> findByItem(Item item) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ItemBrand.class);
		detachedCriteria.setFetchMode("manufacturer", FetchMode.JOIN);
		detachedCriteria.add(Restrictions.eq("item", item));
//		detachedCriteria.add(Restrictions.eq("activeFlag", 'A'));
		return itemBrandDAO.findByCriteria(detachedCriteria); 
	}

	@Override
	public List<ItemBrand> findByUniqueConstraint(Item item, Brand brand, Manufacturer manufacturer) {

		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ItemBrand.class);
		detachedCriteria.setFetchMode("item", FetchMode.JOIN);
		detachedCriteria.setFetchMode("brand", FetchMode.JOIN);
		detachedCriteria.setFetchMode("manufacturer", FetchMode.JOIN);
		detachedCriteria.add(Restrictions.eq("item", item));
		detachedCriteria.add(Restrictions.eq("brand", brand));
		detachedCriteria.add(Restrictions.eq("manufacturer", manufacturer));
		detachedCriteria.add(Restrictions.eq("activeFlag", 'A'));
		return itemBrandDAO.findByCriteria(detachedCriteria);
	}

	@Override
	public List<ItemBrand> getDefaultItemBrand(Item item, ItemBrand itemBrand) {
		ItemService itemService = CommonUtil.getService("itemService");
		if(!itemService.isNewItem(item)) {
			DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ItemBrand.class);
			detachedCriteria.add(Restrictions.eq("item", item));
			detachedCriteria.add(Restrictions.eq("activeFlag", RefCodeConstant.ACTIVE_FLAG_TRUE));
			detachedCriteria.add(Restrictions.eq("defaultFlag", RefCodeConstant.BOOLEAN_TRUE));
			if(itemBrand!=null)
			detachedCriteria.add(Restrictions.ne("itemBrdSeqno", itemBrand.getItemBrdSeqno()));
			return itemBrandDAO.findByCriteria(detachedCriteria);
		} else {
			List<ItemBrand> list = new ArrayList<ItemBrand>();
			for(ItemBrand itemBrand1 : item.getItemBrands()) {
				if(RefCodeConstant.BOOLEAN_TRUE.equals(itemBrand1.getDefaultFlag())) {
					list.add(itemBrand1);
				}
			}
			return list;
		}
		
		
	}
	
	@Override
	public ItemBrand getUnknownItemBrand(Item item,SecUser user) {
		BrandService brandService = (BrandService)SpringUtil.getBean("brandService");
		ManufacturerService manufacturerService = (ManufacturerService)SpringUtil.getBean("manufacturerService");
		ItemBrand itemBrand = getNewItemBrand();
		itemBrand.setCreatedDate(new Date());
		itemBrand.setCreatedBy(user.getId());
		itemBrand.setUpdatedDate(new Date());
		itemBrand.setUpdatedBy(user.getId());
		itemBrand.setItem(item);
		itemBrand.setBrand(brandService.findByBrandCode("U075"));
		itemBrand.setManufacturer(manufacturerService.findByManufacturerCode("M0833"));
		itemBrand.setActiveFlag(RefCodeConstant.ACTIVE_FLAG_TRUE);
		return itemBrand;
	}
	
	
	@Override
	public boolean isUnknownItemBrand(String brandCode,String manufacturerCode) {
		return "U075".equals(brandCode) && "M0833".equals(manufacturerCode);
	}
}
