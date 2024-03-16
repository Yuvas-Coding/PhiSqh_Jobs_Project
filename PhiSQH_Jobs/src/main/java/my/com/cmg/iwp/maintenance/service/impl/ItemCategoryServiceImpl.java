package my.com.cmg.iwp.maintenance.service.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.ItemCategory;
import my.com.cmg.iwp.maintenance.service.ItemCategoryService;
@Service
public class ItemCategoryServiceImpl implements ItemCategoryService {

	private BasisNextidDaoImpl<ItemCategory> itemCategoryDAO;

	@Override
	public ItemCategory getNewItemCategory() {
		return new ItemCategory();
	}

	@Override
	public void delete(ItemCategory anItemCategory) {
		itemCategoryDAO.delete(anItemCategory);

	}

	@Override
	public void saveOrUpdate(ItemCategory anItemCategory) {
		itemCategoryDAO.saveOrUpdate(anItemCategory);

	}

	public void setItemCategoryDAO(
			BasisNextidDaoImpl<ItemCategory> itemCategoryDAO) {
		this.itemCategoryDAO = itemCategoryDAO;
	}

	public BasisNextidDaoImpl<ItemCategory> getItemCategoryDAO() {
		return itemCategoryDAO;
	}

	public ItemCategory findItemCategoryByCode(String itemCategoryCode) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(ItemCategory.class);
		criteria.add(Restrictions.eq("itmCatCode", itemCategoryCode));
		return DataAccessUtils.uniqueResult(itemCategoryDAO
				.findByCriteria(criteria));
	}

	@Override
	public ItemCategory findItemCategory(long queryString) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(ItemCategory.class);
		criteria.add(Restrictions.eq("itmCatSeqno", queryString));
		return DataAccessUtils.uniqueResult(itemCategoryDAO
				.findByCriteria(criteria));
	}

}
