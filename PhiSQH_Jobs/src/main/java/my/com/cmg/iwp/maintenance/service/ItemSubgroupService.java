package my.com.cmg.iwp.maintenance.service;

import java.util.List;

import my.com.cmg.iwp.maintenance.model.ItemSubgroup;

public interface ItemSubgroupService {

	ItemSubgroup getNewItemSubgroup();

	void saveOrUpdate(ItemSubgroup anItemSubgroup);

	void delete(ItemSubgroup anItemSubgroup);

	List<ItemSubgroup> getSubgroupDesc();

	boolean isItemSubgroupIsExists(String value);

	ItemSubgroup getItemSubGroup(long itmSubgroupSeqno);

	List<ItemSubgroup> getActiveItemSubGroups(String itemGroupCode);

	ItemSubgroup getItemSubGroupByCode(String itmSubgroupCode);

	List<ItemSubgroup> getActiveItemSubGroups();

	List<ItemSubgroup> getSubGroupForItemGroup(String drug, String nondrug);

	List<ItemSubgroup> getActiveItemSubGroupsFrDrug();

	List<ItemSubgroup> getSubGroupForItemGroup(String itemTypeDrug);
}
