package my.com.cmg.iwp.maintenance.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.ItemSubgroup;
import my.com.cmg.iwp.maintenance.service.ItemSubgroupService;
import my.com.cmg.iwp.webui.constant.RefCodeConstant;
@Service
public class ItemSubgroupServiceImpl implements ItemSubgroupService {

	private BasisNextidDaoImpl<ItemSubgroup> itemSubgroupDAO;

	public void setItemSubgroupDAO(
			BasisNextidDaoImpl<ItemSubgroup> itemSubgroupDAO) {
		this.itemSubgroupDAO = itemSubgroupDAO;
	}

	public BasisNextidDaoImpl<ItemSubgroup> getItemSubgroupDAO() {
		return itemSubgroupDAO;
	}

	@Override
	public ItemSubgroup getNewItemSubgroup() {
		// TODO Auto-generated method stub
		return new ItemSubgroup();
	}

	@Override
	public void saveOrUpdate(ItemSubgroup anItemSubgroup) {
		// TODO Auto-generated method stub
		itemSubgroupDAO.saveOrUpdate(anItemSubgroup);
	}

	@Override
	public void delete(ItemSubgroup anItemSubgroup) {
		// TODO Auto-generated method stub
		itemSubgroupDAO.delete(anItemSubgroup);

	}

	@Override
	public List<ItemSubgroup> getSubgroupDesc() {
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria
				.forClass(ItemSubgroup.class);
		criteria.add(Restrictions.eq("itmGroupCode", "N"));
		criteria.addOrder(Order.asc("subgroupDesc"));
		return itemSubgroupDAO.findByCriteria(criteria);
	}

	@Override
	public boolean isItemSubgroupIsExists(String itmSubgroupCode) {
		Session session = itemSubgroupDAO.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(ItemSubgroup.class);
		criteria.add(Restrictions.eq("itmSubgroupCode", itmSubgroupCode));
		List list = criteria.list();
		session.close();
		if (list.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<ItemSubgroup> getActiveItemSubGroups(String itemGroupCode) {
		Session session = itemSubgroupDAO.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(ItemSubgroup.class);
		criteria.add(Restrictions.eq("activeFlag", "A"));
		if (itemGroupCode != null) {
			criteria.add(Restrictions.eq("itmGroupCode", itemGroupCode));
		} else {
			return new ArrayList<ItemSubgroup>();
		}
		@SuppressWarnings("unchecked")
		List<ItemSubgroup> list = criteria.list();
		session.close();
		return list;
	}

	@Override
	public ItemSubgroup getItemSubGroup(long itmSubgroupSeqno) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(ItemSubgroup.class);
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		criteria.add(Restrictions.eq("itmSubgroupSeqno", itmSubgroupSeqno));
		criteria.setFetchMode("itmSubgroupSeqno", FetchMode.JOIN);
		return DataAccessUtils.uniqueResult(itemSubgroupDAO
				.findByCriteria(criteria));
	}

	@Override
	public ItemSubgroup getItemSubGroupByCode(String itmSubgroupCode) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(ItemSubgroup.class);
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		criteria.add(Restrictions.eq("itmSubgroupCode", itmSubgroupCode));
		criteria.setFetchMode("itmSubgroupCode", FetchMode.JOIN);
		return DataAccessUtils.uniqueResult(itemSubgroupDAO
				.findByCriteria(criteria));
	}

	@Override
	public List<ItemSubgroup> getActiveItemSubGroups() {
		Session session = itemSubgroupDAO.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(ItemSubgroup.class);
		criteria.add(Restrictions.eq("activeFlag", 'A'));
		criteria.addOrder(Order.asc("subgroupDesc"));
		List<ItemSubgroup> list = criteria.list();
		session.close();
		return list;
	}

	@Override
	public List<ItemSubgroup> getActiveItemSubGroupsFrDrug() {
		Session session = itemSubgroupDAO.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(ItemSubgroup.class);
		criteria.add(Restrictions.eq("activeFlag", "A"));
		criteria.add(Restrictions.eq("itmGroupCode", "D"));
		List<ItemSubgroup> list = criteria.list();
		session.close();
		return list;
	}

	@Override
	public List<ItemSubgroup> getSubGroupForItemGroup(String drug,
			String nondrug) {
		Session session = itemSubgroupDAO.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(ItemSubgroup.class);
		if (null != drug)
			criteria.add(Restrictions.eq("itmGroupCode", drug));
		else if (null != nondrug)
			criteria.add(Restrictions.eq("itmGroupCode", nondrug));
		criteria.add(Restrictions.eq("activeFlag", RefCodeConstant.ACTIVE_FLAG_TRUE));
		List<ItemSubgroup> list = criteria.list();
		session.close();
		return list;
	}
	
	public List<ItemSubgroup> getSubGroupForItemGroup(String itemGroup) {
		Session session = itemSubgroupDAO.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(ItemSubgroup.class);
		criteria.add(Restrictions.eq("itmGroupCode", itemGroup));
		criteria.add(Restrictions.eq("activeFlag", RefCodeConstant.ACTIVE_FLAG_TRUE));
		List<ItemSubgroup> list = criteria.list();
		session.close();
		return list;
	}
}
