package my.com.cmg.iwp.maintenance.service;

import java.util.List;

import my.com.cmg.iwp.maintenance.model.Brand;
import my.com.cmg.iwp.maintenance.model.Item;
import my.com.cmg.iwp.maintenance.model.ItemBrand;
import my.com.cmg.iwp.maintenance.model.Manufacturer;
import my.com.cmg.iwp.maintenance.model.SecUser;

public interface ItemBrandService {

	ItemBrand getNewItemBrand();

	void delete(ItemBrand anItemBrand);

	void saveOrUpdate(ItemBrand anItemBrand);

	List<ItemBrand> findByItem(Item item);

	List<ItemBrand> findByUniqueConstraint(Item item, Brand brand, Manufacturer manufacturer);

	List<ItemBrand> getDefaultItemBrand(Item item, ItemBrand itemBrand);

	ItemBrand getUnknownItemBrand(Item item, SecUser user);

	boolean isNewItemBrand(ItemBrand anItemBrand);

	boolean isUnknownItemBrand(String brandCode, String manufacturerCode);
}
