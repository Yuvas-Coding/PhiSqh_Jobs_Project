package my.com.cmg.iwp.maintenance.service;

import java.util.Date;
import java.util.List;

import my.com.cmg.iwp.maintenance.model.ItemCatalog;
import my.com.cmg.iwp.maintenance.model.ResultObject;

public interface ItemCatalogService {
	public ResultObject getAllItems(int start, int pageSize);
	public List<ItemCatalog> getAllItems();
	public List<ItemCatalog> getItemsByCriteria(Date createDate, String status);
}
