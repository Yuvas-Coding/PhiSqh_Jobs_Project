package my.com.cmg.iwp.maintenance.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.concurrent.ConcurrentException;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.common.util.LazyInitializer;
import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.AtcDetail;
import my.com.cmg.iwp.maintenance.model.GenericName;
import my.com.cmg.iwp.maintenance.model.GenericNameAtc;
import my.com.cmg.iwp.maintenance.service.AtcDetailService;
@Service
public class AtcDetailServiceImpl implements AtcDetailService {

	private BasisNextidDaoImpl<AtcDetail> atcDetailDAO;

	@Override
	public AtcDetail getNewAtcDetail() {
		return new AtcDetail();
	}

	@Override
	public void delete(AtcDetail anAtcDetail) {
		atcDetailDAO.delete(anAtcDetail);

	}

	@Override
	public void saveOrUpdate(AtcDetail anAtcDetail) {
		atcDetailDAO.saveOrUpdate(anAtcDetail);

	}

	public void setAtcDetailDAO(BasisNextidDaoImpl<AtcDetail> atcDetailDAO) {
		this.atcDetailDAO = atcDetailDAO;
	}

	public BasisNextidDaoImpl<AtcDetail> getAtcDetailDAO() {
		return atcDetailDAO;
	}

	@Override
	public List<AtcDetail> getAllAtcDetailList() {

		return atcDetailDAO.loadAll(AtcDetail.class);
	}

	@Override
	public List<AtcDetail> findATCbyCodeLevel(String code, int level) {
		DetachedCriteria criteria = DetachedCriteria.forClass(AtcDetail.class);
		Criterion crit1 = Restrictions.like("atcCode", code, MatchMode.START);
		Criterion crit2 = Restrictions.eq("atcLevel", level);
		criteria.add(Restrictions.and(crit1, crit2));
		List<AtcDetail> list = atcDetailDAO.findByCriteria(criteria);
		return list;
	}

	@Override
	public List<AtcDetail> findATCbyLevel(int atcLevel) {
		DetachedCriteria criteria = DetachedCriteria.forClass(AtcDetail.class);
		criteria.add(Restrictions.eq("atcLevel", atcLevel));
		List<AtcDetail> list = atcDetailDAO.findByCriteria(criteria);
		return list;
	}

	@Override
	public AtcDetail getAtcDetail(String atcCode) {
		DetachedCriteria criteria = DetachedCriteria.forClass(AtcDetail.class);
		criteria.add(Restrictions.eq("atcCode", atcCode));
		return DataAccessUtils.uniqueResult(atcDetailDAO
				.findByCriteria(criteria));
	}

	@Override
	public List<AtcDetail> findATCbyCodeLevel5(String code, int level) {
		DetachedCriteria criteria = DetachedCriteria.forClass(AtcDetail.class);
		Criterion crit1 = Restrictions.eq("atcCode", code);
		Criterion crit2 = Restrictions.eq("atcLevel", level);
		criteria.add(Restrictions.and(crit1, crit2));
		List<AtcDetail> list = atcDetailDAO.findByCriteria(criteria);
		return list;
	}

	@Override
	public AtcDetail getAtcDetailByCodeLevel(String atcCode, int level) {

		DetachedCriteria criteria = DetachedCriteria.forClass(AtcDetail.class);
		Criterion crit1 = Restrictions.eq("atcCode", atcCode);
		Criterion crit2 = Restrictions.eq("atcLevel", level);
		criteria.add(Restrictions.and(crit1, crit2));
		return DataAccessUtils.uniqueResult(atcDetailDAO
				.findByCriteria(criteria));
	}

	@Override
	public List<AtcDetail> findByAtcDetailCode(String atcCode) {
		DetachedCriteria criteria = DetachedCriteria.forClass(AtcDetail.class);
		criteria.add(Restrictions.ilike("atcCode", atcCode, MatchMode.EXACT));
		return atcDetailDAO.findByCriteria(criteria);
	}

	@Override
	public List<AtcDetail> getAllAtcDetailList(GenericName genericName) {
		Session session = atcDetailDAO.getSessionFactory().openSession();
		List<AtcDetail> atcDetails = new ArrayList<AtcDetail>(0);
		Criteria criteria = session.createCriteria(GenericNameAtc.class);
		criteria.createCriteria("genericName").add(
				Restrictions.eq("genericSeqno", genericName.getGenericSeqno()));
		List<GenericNameAtc> genericNameAtcs = criteria.list();
		LazyInitializer<GenericNameAtc> initializer = new LazyInitializer<GenericNameAtc>() {
			
			@Override
			protected GenericNameAtc initialize() throws ConcurrentException {
				// TODO Auto-generated method stub
				return null;
			}
		};
		for (Iterator iterator = genericNameAtcs.iterator(); iterator.hasNext();) {
			GenericNameAtc genericNameAtc = (GenericNameAtc) iterator.next();
			genericNameAtc = initializer.join(genericNameAtc, "atcDetail");
			atcDetails.add(genericNameAtc.getAtcDetail());
		}
		session.close();
		return atcDetails;
	}
	
	@Override
	public List<AtcDetail> findLevel5AtcDetailByCode(String atcCode) {
		DetachedCriteria criteria = DetachedCriteria.forClass(AtcDetail.class);
		//criteria.add(Restrictions.ilike("atcCode", atcCode, MatchMode.EXACT));
		Criterion crit1 = Restrictions.like("atcCode", atcCode, MatchMode.START);
		Criterion crit2 = Restrictions.eq("atcLevel", 5);
		criteria.add(Restrictions.and(crit1, crit2));
		return atcDetailDAO.findByCriteria(criteria);
	}
	
	@Override
	public List<AtcDetail> findLevel5AtcDetailByCode(String atcCode, List<Long> atcSeq) {
		DetachedCriteria criteria = DetachedCriteria.forClass(AtcDetail.class);
		//criteria.add(Restrictions.ilike("atcCode", atcCode, MatchMode.EXACT));
		Criterion crit1 = Restrictions.like("atcCode", atcCode, MatchMode.START);
		Criterion crit2 = Restrictions.eq("atcLevel", 5);
		if(atcSeq.size() > 0 && !atcSeq.isEmpty())
			criteria.add(Restrictions.not(Restrictions.in("atcSeqno", atcSeq)));
		
		criteria.add(Restrictions.and(crit1, crit2));
		return atcDetailDAO.findByCriteria(criteria);
	}
}
