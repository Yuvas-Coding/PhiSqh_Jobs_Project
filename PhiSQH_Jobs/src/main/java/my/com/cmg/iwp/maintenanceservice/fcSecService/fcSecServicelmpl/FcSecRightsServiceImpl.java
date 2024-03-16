package my.com.cmg.iwp.maintenanceservice.fcSecService.fcSecServicelmpl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.fcSecurityModel.FcSecGrouprights;
import my.com.cmg.iwp.maintenance.model.fcSecurityModel.FcSecRights;
import my.com.cmg.iwp.maintenance.service.fcSecService.FcSecRightsService;

public class FcSecRightsServiceImpl implements FcSecRightsService {
	private BasisNextidDaoImpl<FcSecRights> secRightsDAO;

	@Override
	public FcSecRights getNewSecRight() {
		return new FcSecRights();
	}

	@Override
	public List<FcSecRights> getAllRights() {
		final DetachedCriteria criteria = DetachedCriteria.forClass(FcSecRights.class);
		criteria.addOrder(Order.asc("rigName"));

		return getsecRightsDAO().findByCriteria(criteria);
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
	public List<FcSecRights> getAllRights(int type) {

		final DetachedCriteria criteria = DetachedCriteria.forClass(FcSecRights.class);
		criteria.addOrder(Order.asc("rigName"));

		if (type != -1) {
			criteria.add(Restrictions.eq("rigType", Integer.valueOf(type)));
			// criteria.add(Restrictions.or(Restrictions.eq("rigType", 2),
			// Restrictions.eq("rigType", 1)));
		}

		return getsecRightsDAO().findByCriteria(criteria);
	}

	@Override
	public List<FcSecRights> getAllRights(List<Integer> aListOfRightTyps) {

		// DetachedCriteria criteria =
		// DetachedCriteria.forClass(SecRight.class);
		// criteria.addOrder(Order.asc("rigName"));

		List<FcSecRights> result = null; // init

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
			hqlWhere = hqlWhere + " or secRight.rigType = " + aListOfRightTyps.get(i);
		}

		final String hqlQuery = hqlFrom + hqlWhere;

		result = getsecRightsDAO().find(hqlQuery);

		return result;

	}

	@Override
	public FcSecRights getRightById(Long right_id) {
		return getsecRightsDAO().get(FcSecRights.class, right_id);
	}

	@Override
	public List<FcSecRights> getRightsByGroupright(FcSecGrouprights secGroupright) {

		final DetachedCriteria criteria = DetachedCriteria.forClass(FcSecRights.class);
		// Aliases only for properties
		criteria.createAlias("secGrouprights", "gr");
		criteria.add(Restrictions.eq("gr.id", Long.valueOf(secGroupright.getId())));

		return getsecRightsDAO().findByCriteria(criteria);

	}

	/*
	 * @Override public List<SecRight> getRightsByUser(SecUser user) { return getsecRightsDAO().findByNamedQuery("allRightFromUserSqlQuery", Long.valueOf(user.getId())); }
	 */

	@Override
	public List<FcSecRights> getRightsLikeRightName(String aRightName) {

		final DetachedCriteria criteria = DetachedCriteria.forClass(FcSecRights.class);
		criteria.add(Restrictions.ilike("rigName", aRightName, MatchMode.ANYWHERE));

		return getsecRightsDAO().findByCriteria(criteria);
	}

	@Override
	public List<FcSecRights> getRightsLikeRightNameAndType(String aRightName, int aRightType) {

		// check if the empty right is selected. This right is only for visual
		// behavior.
		if (aRightType == -1) {
			return getRightsLikeRightName(aRightName);
		}

		final DetachedCriteria criteria = DetachedCriteria.forClass(FcSecRights.class);
		criteria.add(Restrictions.and(Restrictions.ilike("rigName", aRightName, MatchMode.ANYWHERE), Restrictions.eq("rigType", Integer.valueOf(aRightType))));

		return getsecRightsDAO().findByCriteria(criteria);
	}

	@Override
	public List<FcSecRights> getRightsLikeRightNameAndTypes(String aRightName, List<Integer> listOfRightTyps) {

		final DetachedCriteria criteria = DetachedCriteria.forClass(FcSecRights.class);
		criteria.addOrder(Order.asc("rigName"));

		List<FcSecRights> result = null; // init

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

					return getsecRightsDAO().find(hqlQuery);
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
			hqlWhere = hqlWhere + " or secRight.rigType = " + listOfRightTyps.get(i);
		}

		String hqlQuery = hqlFrom + hqlWhere;

		if (!aRightName.isEmpty()) {
			// add the right name
			hqlAdd = " and secRight.rigName like '%" + aRightName + "%'";
			hqlQuery = hqlQuery + hqlAdd;
		}

		// System.out.println(hqlQuery);

		result = getsecRightsDAO().find(hqlQuery);

		return result;
	}

	@Override
	public int getCountAllSecRights() {
		return DataAccessUtils.intResult(getsecRightsDAO().find("select count(*) from SecRight"));
	}

	public void setsecRightsDAO(BasisNextidDaoImpl<FcSecRights> secRightsDAO) {
		this.secRightsDAO = secRightsDAO;
	}

	public BasisNextidDaoImpl<FcSecRights> getsecRightsDAO() {
		return secRightsDAO;
	}

	@Override
	public void delete(FcSecRights right) {
		getsecRightsDAO().delete(right);
	}

	@Override
	public void saveOrUpdate(FcSecRights right) {
		getsecRightsDAO().saveOrUpdate(right);
	}

	@Override
	public FcSecRights getSimilarRightByRightName(String value) {

		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(FcSecRights.class);
		detachedCriteria.add(Restrictions.eq("rigName", value).ignoreCase());
		return DataAccessUtils.uniqueResult(secRightsDAO.findByCriteria(detachedCriteria));
	}

	/*
	 * @Override public boolean isRightPresent(SecUser user, String rightName){ DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SecRight.class); detachedCriteria.add(Restrictions.eq("rigName", rightName).ignoreCase()); detachedCriteria.createAlias("secGrouprights", "sgr", CriteriaSpecification.LEFT_JOIN) .createAlias("sgr.secGroup","sg", CriteriaSpecification.LEFT_JOIN)
	 * .createAlias("sg.secRolegroups","srg", CriteriaSpecification.LEFT_JOIN) .createAlias("srg.secRole","sr", CriteriaSpecification.LEFT_JOIN) .createAlias("sr.secUserroles","sur", CriteriaSpecification.LEFT_JOIN) .createAlias( "sur.secUser", "su", CriteriaSpecification.LEFT_JOIN); detachedCriteria.add(Restrictions.eq("su.id", user.getId())); return
	 * secRightsDAO.findByCriteria(detachedCriteria).isEmpty(); }
	 */
}
