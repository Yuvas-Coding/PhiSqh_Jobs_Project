package my.com.cmg.iwp.maintenance.service.impl;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.management.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.ApItemPrice;
import my.com.cmg.iwp.maintenance.model.Drug;
import my.com.cmg.iwp.maintenance.model.Item;
import my.com.cmg.iwp.maintenance.model.ItemInformation;
import my.com.cmg.iwp.maintenance.model.NonDrug;
import my.com.cmg.iwp.maintenance.model.Uom;
import my.com.cmg.iwp.maintenance.service.ItemService;
import my.com.cmg.iwp.webui.constant.RefCodeConstant;
@Service
public class ItemServiceImpl implements ItemService {

	private BasisNextidDaoImpl<Item> itemDAO;
	private BasisNextidDaoImpl<ItemInformation> itemInformationDAO;

	public BasisNextidDaoImpl<Item> getItemDAO() { return itemDAO; }
	public void setItemDAO(BasisNextidDaoImpl<Item> itemDAO) { this.itemDAO = itemDAO; }
	public void setItemInformationDAO(BasisNextidDaoImpl<ItemInformation> itemInformationDAO) { this.itemInformationDAO = itemInformationDAO; }
	public BasisNextidDaoImpl<ItemInformation> getItemInformationDAO() { return itemInformationDAO; }

	@Override
	public boolean isNewItem(Item anItem) {
		return anItem.getItemSeqno() == Long.MIN_VALUE;
	}
	
	@Override
	public Item getNewItem() {
		return new Item();
	}

	@Override
	public void delete(Item anItem) {
		itemDAO.delete(anItem);

	}

	@Override
	public void saveOrUpdate(Item anItem) {
		itemDAO.saveOrUpdate(anItem);

	}

	@Override
	public Collection<Item> getAllItems() {

		return itemDAO.loadAll(Item.class);
	}

	@Override
	public List<Item> getItems(String parameter) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Item.class);
		criteria.add(Restrictions.eq("itemMdcCode", parameter));
		return itemDAO.findByCriteria(criteria);
	}

	@Override
	public Item findByItemCode(String itemCode) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Item.class);
		criteria.add(Restrictions.eq("itemCode", itemCode));
		return DataAccessUtils.uniqueResult(itemDAO.findByCriteria(criteria));
	}
	
	@Override
	public boolean findByItemDetails(Drug drug, NonDrug nonDrug, Long conversionFactor, String itemType, Uom pkuUom) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Item.class);
		if (drug != null)
			criteria.add(Restrictions.eq("drug", drug));
		if (nonDrug != null)
			criteria.add(Restrictions.eq("nonDrug", nonDrug));
		criteria.add(Restrictions.eq("conversionFactor", conversionFactor));
		criteria.add(Restrictions.eq("pkuUom", pkuUom));
		criteria.add(Restrictions.eq("itemType", itemType));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		if (itemDAO.findByCriteria(criteria).size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void refresh(Item item) {
		itemDAO.refresh(item);
		itemDAO.initialize(item);
	}

	@Override
	public Item getItem(long itemSeqNo) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Item.class);
		criteria.add(Restrictions.eq("itemSeqno", itemSeqNo));
		List<Item> items = itemDAO.findByCriteria(criteria);
		return items.isEmpty() ? null : items.get(0);
	}
	
	@Override
	public Item getItem(String itemCode) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Item.class);
		criteria.add(Restrictions.eq("itemCode", itemCode));
		List<Item> items = itemDAO.findByCriteria(criteria);
		return items.isEmpty() ? null : items.get(0);
	}

	@Override
	public List<Item> findItemType(Long drugSeqno) {

		DetachedCriteria criteria = DetachedCriteria.forClass(Item.class);
		criteria.add(Restrictions.eq("drugSeqno", drugSeqno));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return itemDAO.findByCriteria(criteria);

	}

	@Override
	public List<Item> findItemTypeByNonDrug(Long nonDrugSeqNo) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Item.class);
		criteria.add(Restrictions.eq("nonDrugSeqno", nonDrugSeqNo));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return itemDAO.findByCriteria(criteria);
	}

	@Override
	public List<Item> findItemByDrug(Drug drug) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Item.class);
		criteria.add(Restrictions.eq("drug", drug));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return itemDAO.findByCriteria(criteria);
	}

	@Override
	public ItemInformation getItemInformation(Item item) {

		DetachedCriteria criteria = DetachedCriteria.forClass(ItemInformation.class);
		criteria.add(Restrictions.eq("item", item));
		return DataAccessUtils.uniqueResult(itemInformationDAO.findByCriteria(criteria));
	}

	@Override
	public Integer getPackagingSizeNo(String nonDrugCode) throws SQLException {
		
		/*DataSource ds = (DataSource) SpringUtil.getBean("dataSource");
		Connection con = null;
		con = DataSourceUtils.doGetConnection(ds);*/
		Session session = getItemDAO().getSessionFactory().openSession();
		
		String query = " select case when max_number is null then 1 else max_number end as max_number from (  "
				+ "select TO_NUMBER(max(substr(item_code , length(item_code)-1, 2)))+1 as max_number "
		+ " from t_items " + " where item_group ='N' and item_code like '" + nonDrugCode  + "%' ) ";
		Query query1 = session.createSQLQuery(query.toString());
		Integer seq = Integer.parseInt(query1.list().iterator().next().toString());
		session.close();
		return seq;

	}
	
	@Override
	public boolean isDuplicateApItemPrice(ApItemPrice apItemPrice, Date fromDate, Date toDate, List<ApItemPrice> apItemPrices) {
		if(isNewApItemPrice(apItemPrice)) {
			for (ApItemPrice anApItemPrice : apItemPrices) {
				if (apItemPrice.getPriceCode().equals(anApItemPrice.getPriceCode())) {
					// deMorgan's law
					// (StartA <= EndB) and (EndA >= StartB)
					Date startA = fromDate;
					Date endB = anApItemPrice.getEffectiveDateTo();
					if ((startA.compareTo(endB) <= 0)) {
						return true;
					}
				}
			}
		} else {
			for (ApItemPrice anApItemPrice : apItemPrices) {
				if (apItemPrice.getPriceCode().equals(anApItemPrice.getPriceCode())
						&& apItemPrice.getItmPriceSeqno() != anApItemPrice.getItmPriceSeqno()) {
					// deMorgan's law
					// (StartA <= EndB) and (EndA >= StartB)
					Date startA = fromDate;
					Date endA = toDate;
					Date startB = anApItemPrice.getEffectiveDateFrom();
					Date endB = anApItemPrice.getEffectiveDateTo();
					if (endA.compareTo(endB) <=0) {
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	@Override
	public ApItemPrice getNewApItemPrice(Item item) {
		ApItemPrice apItemPrice = new ApItemPrice();
		apItemPrice.setActiveFlag(RefCodeConstant.ACTIVE_FLAG_TRUE);
		apItemPrice.setItem(item);
		return apItemPrice;
	}
	
	@Override
	public boolean isNewApItemPrice(ApItemPrice apItemPrice) {
		return apItemPrice.getItmPriceSeqno() == Long.MIN_VALUE;
	}
	
	@Override
	public Item findByItemDetails(Long drugSeqno, Long nonDrug, Long conversionFactor, String itemType, Uom pkuUom) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Item.class);
		if (drugSeqno != null)
			criteria.add(Restrictions.eq("drugSeqno", drugSeqno));
		if (nonDrug != null)
			criteria.add(Restrictions.eq("nonDrugSeqno", nonDrug));
		criteria.add(Restrictions.eq("conversionFactor", conversionFactor));
		criteria.add(Restrictions.eq("pkuUom", pkuUom));
		criteria.add(Restrictions.eq("itemType", itemType));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<Item> items = itemDAO.findByCriteria(criteria);
		return null != items && !items.isEmpty() ? items.get(0) : null;
	}
	
	@Override
	public Item getPrepackItem(String itemCode) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Item.class);
		criteria.add(Restrictions.like("itemCode", itemCode+"%"));
		criteria.addOrder(Order.desc("itemCode"));
		List<Item> items = itemDAO.findByCriteria(criteria);
		return items.isEmpty() ? null : items.get(0);
	}
}