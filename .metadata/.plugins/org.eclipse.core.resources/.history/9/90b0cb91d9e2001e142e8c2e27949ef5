package my.com.cmg.iwp.maintenance.service;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import my.com.cmg.iwp.maintenance.model.ApItemPrice;
import my.com.cmg.iwp.maintenance.model.Drug;
import my.com.cmg.iwp.maintenance.model.Item;
import my.com.cmg.iwp.maintenance.model.ItemInformation;
import my.com.cmg.iwp.maintenance.model.NonDrug;
import my.com.cmg.iwp.maintenance.model.Uom;

public interface ItemService {

	Item getNewItem();

	void delete(Item anItem);

	void saveOrUpdate(Item anItem);

	Collection<Item> getAllItems();

	List<Item> getItems(String parameter);

	Item findByItemCode(String itemCode);

	void refresh(Item item);

	Item getItem(long itemSeqNo);

	List<Item> findItemType(Long drugSeqno);

	List<Item> findItemTypeByNonDrug(Long nonDrugSeqNo);

	List<Item> findItemByDrug(Drug drug);

	ItemInformation getItemInformation(Item item);

	Integer getPackagingSizeNo(String itemCode) throws SQLException;
	
	boolean isNewItem(Item anItem);

	Item getItem(String itemCode);

	boolean isDuplicateApItemPrice(ApItemPrice apItemPrice, Date fromDate, Date toDate, List<ApItemPrice> apItemPrices);
	
	boolean isNewApItemPrice(ApItemPrice apItemPrice);

	ApItemPrice getNewApItemPrice(Item item);

	boolean findByItemDetails(Drug drug, NonDrug nonDrug, Long conversionFactor, String itemType, Uom pkuUom);

	Item findByItemDetails(Long drugSeqno, Long nonDrug,
			Long conversionFactor, String itemType, Uom pkuUom);

	Item getPrepackItem(String itemCode);
}
