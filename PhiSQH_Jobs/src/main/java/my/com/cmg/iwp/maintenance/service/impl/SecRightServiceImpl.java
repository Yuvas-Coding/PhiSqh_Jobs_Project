package my.com.cmg.iwp.maintenance.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.SecGroupright;
import my.com.cmg.iwp.maintenance.model.SecRight;
import my.com.cmg.iwp.maintenance.model.SecUser;
import my.com.cmg.iwp.maintenance.service.SecRightService;
@Service
public class SecRightServiceImpl implements SecRightService {
	private BasisNextidDaoImpl<SecRight> secRightDAO;

	@Override
	public SecRight getNewSecRight() {
		return new SecRight();
	}

	@Override
	public List<SecRight> getAllRights() {
		final DetachedCriteria criteria = DetachedCriteria
				.forClass(SecRight.class);
		criteria.addOrder(Order.asc("rigName"));

		return getSecRightDAO().findByCriteria(criteria);
	}

	/**
	 * Int | Type <br>
	 * --------------------------<br>
	 * -1 | All (no filter)<br>
	 * 0 | Page <br>
	 * 1 | Menu Category <br>
	 * 2 | Menu Item <br>
	 * 3 | Method <br>
	 * 4 | DomainObject/Property <br>
	 * 5 | Tab <br>
	 */

	@Override
	public List<SecRight> getAllRights(int type) {

		final DetachedCriteria criteria = DetachedCriteria
				.forClass(SecRight.class);
		criteria.addOrder(Order.asc("rigName"));

		if (type != -1) {
			criteria.add(Restrictions.eq("rigType", Integer.valueOf(type)));
			// criteria.add(Restrictions.or(Restrictions.eq("rigType", 2),
			// Restrictions.eq("rigType", 1)));
		}

		return getSecRightDAO().findByCriteria(criteria);
	}

	@Override
	public List<SecRight> getAllRights(List<Integer> aListOfRightTyps) {

		// DetachedCriteria criteria =
		// DetachedCriteria.forClass(SecRight.class);
		// criteria.addOrder(Order.asc("rigName"));

		List<SecRight> result = null; // init

		// check if value is '-1'. it means 'all', no filtering
		if (aListOfRightTyps.contains(Integer.valueOf(-1))) {
			return getAllRights(-1);
		}

		// check if only 1 type
		if (aListOfRightTyps.size() == 1) {
			final int i = aListOfRightTyps.get(0).intValue();
			return getAllRights(i);
		}

		// if more than one type than construct the hql query
		final String hqlFrom = " from SecRight as secRight where ";
		// get the first value
		String hqlWhere = " secRight.rigType = " + aListOfRightTyps.get(0);

		for (int i = 1; i < aListOfRightTyps.size(); i++) {
			hqlWhere = hqlWhere + " or secRight.rigType = "
					+ aListOfRightTyps.get(i);
		}

		final String hqlQuery = hqlFrom + hqlWhere;

		result = getSecRightDAO().find(hqlQuery);

		return result;

	}

	@Override
	public SecRight getRightById(Long right_id) {
		return getSecRightDAO().get(SecRight.class, right_id);
	}

	@Override
	public List<SecRight> getRightsByGroupright(SecGroupright secGroupright) {

		final DetachedCriteria criteria = DetachedCriteria
				.forClass(SecRight.class);
		// Aliases only for properties
		criteria.createAlias("secGrouprights", "gr");
		criteria.add(Restrictions.eq("gr.id",
				Long.valueOf(secGroupright.getId())));

		return getSecRightDAO().findByCriteria(criteria);

	}

	@Override
	public List<SecRight> getRightsByUser(SecUser user) {
		return getSecRightDAO().findByNamedQuery("allRightFromUserSqlQuery",
				Long.valueOf(user.getId()));
	}

	@Override
	public List<SecRight> getRightsLikeRightName(String aRightName) {

		final DetachedCriteria criteria = DetachedCriteria
				.forClass(SecRight.class);
		criteria.add(Restrictions.ilike("rigName", aRightName,
				MatchMode.ANYWHERE));

		return getSecRightDAO().findByCriteria(criteria);
	}

	@Override
	public List<SecRight> getRightsLikeRightNameAndType(String aRightName,
			int aRightType) {

		// check if the empty right is selected. This right is only for visual
		// behavior.
		if (aRightType == -1) {
			return getRightsLikeRightName(aRightName);
		}

		final DetachedCriteria criteria = DetachedCriteria
				.forClass(SecRight.class);
		criteria.add(Restrictions.and(
				Restrictions.ilike("rigName", aRightName, MatchMode.ANYWHERE),
				Restrictions.eq("rigType", Integer.valueOf(aRightType))));

		return getSecRightDAO().findByCriteria(criteria);
	}

	@Override
	public List<SecRight> getRightsLikeRightNameAndTypes(String aRightName,
			List<Integer> listOfRightTyps) {

		final DetachedCriteria criteria = DetachedCriteria
				.forClass(SecRight.class);
		criteria.addOrder(Order.asc("rigName"));

		List<SecRight> result = null; // init

		String hqlFrom = "";
		String hqlWhere = "";
		String hqlAdd = "";

		// check if value is '-1'. it means 'all', no filtering
		// only if value is empty
		for (final Integer integer : listOfRightTyps) {
			if (integer.equals(new Integer(-1))) {
				if (aRightName.isEmpty()) {
					return getAllRights(integer.intValue());
				} else if (!aRightName.isEmpty()) {

					hqlFrom = " from SecRight as secRight where ";
					hqlWhere = " secRight.rigName like '%" + aRightName + "%'";
					final String hqlQuery = hqlFrom + hqlWhere;

					// System.out.println(hqlQuery);

					return getSecRightDAO().find(hqlQuery);
				}
			}
		}

		// check if only 1 type and value is empty
		if (listOfRightTyps.size() == 1) {
			final int i = listOfRightTyps.get(0).intValue();
			if (aRightName.isEmpty()) {
				return getAllRights(i);
			}
		}

		// if more than one type than construct the hql query
		hqlFrom = " from SecRight as secRight where ";
		// get the first value
		hqlWhere = " secRight.rigType = " + listOfRightTyps.get(0);

		for (int i = 1; i < listOfRightTyps.size(); i++) {
			hqlWhere = hqlWhere + " or secRight.rigType = "
					+ listOfRightTyps.get(i);
		}

		String hqlQuery = hqlFrom + hqlWhere;

		if (!aRightName.isEmpty()) {
			// add the right name
			hqlAdd = " and secRight.rigName like '%" + aRightName + "%'";
			hqlQuery = hqlQuery + hqlAdd;
		}

		// System.out.println(hqlQuery);

		result = getSecRightDAO().find(hqlQuery);

		return result;
	}

	@Override
	public int getCountAllSecRights() {
		return DataAccessUtils.intResult(getSecRightDAO().find(
				"select count(*) from SecRight"));
	}

	public void setSecRightDAO(BasisNextidDaoImpl<SecRight> secRightDAO) {
		this.secRightDAO = secRightDAO;
	}

	public BasisNextidDaoImpl<SecRight> getSecRightDAO() {
		return secRightDAO;
	}

	@Override
	public void delete(SecRight right) {
		getSecRightDAO().delete(right);
	}

	@Override
	public void saveOrUpdate(SecRight right) {
		getSecRightDAO().saveOrUpdate(right);
	}

	@Override
	public SecRight getSimilarRightByRightName(String value) {

		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(SecRight.class);
		detachedCriteria.add(Restrictions.eq("rigName", value).ignoreCase());
		return DataAccessUtils.uniqueResult(secRightDAO
				.findByCriteria(detachedCriteria));
	}
}
