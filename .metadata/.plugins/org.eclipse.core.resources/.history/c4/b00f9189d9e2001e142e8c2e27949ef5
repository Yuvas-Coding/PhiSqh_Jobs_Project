package my.com.cmg.iwp.maintenance.service.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.ItemCatalog;
import my.com.cmg.iwp.maintenance.model.ResultObject;
import my.com.cmg.iwp.maintenance.service.ItemCatalogService;
@Service
public class ItemCatalogServiceImpl implements ItemCatalogService {
	
	private BasisNextidDaoImpl<ItemCatalog> itemCatalogDAO;
	
	public BasisNextidDaoImpl<ItemCatalog> getItemCatalogDAO() {
		return itemCatalogDAO;
	}

	public void setItemCatalogDAO(BasisNextidDaoImpl<ItemCatalog> itemCatalogDAO) {
		this.itemCatalogDAO = itemCatalogDAO;
	}

	@Override
	public ResultObject getAllItems(int start, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(ItemCatalog.class);
		criteria.addOrder(Order.asc("itemCode"));
		int totalCount = getItemCatalogDAO().findByCriteria(criteria).size();
		List<ItemCatalog> list = getItemCatalogDAO().findByCriteria(criteria, start, pageSize);
		return new ResultObject(list, totalCount);
	}

	@Override
	public List<ItemCatalog> getAllItems() {
		return getItemCatalogDAO().loadAll(ItemCatalog.class);
	}

	@Override
	public List<ItemCatalog> getItemsByCriteria(Date createDate, String status) {
		DetachedCriteria criteria = DetachedCriteria.forClass(ItemCatalog.class);
		criteria.addOrder(Order.asc("itemCode"));
		criteria.add(Restrictions.eq("createDate", createDate));
		if (null != status && status.trim().length() > 0 && status.equalsIgnoreCase("null") == false) {
			criteria.add(Restrictions.ilike("epStatus", "%"+status+"%"));
		}
		return getItemCatalogDAO().findByCriteria(criteria);
	}

}
