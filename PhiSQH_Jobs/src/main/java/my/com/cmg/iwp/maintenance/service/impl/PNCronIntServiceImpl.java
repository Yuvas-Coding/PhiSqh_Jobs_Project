package my.com.cmg.iwp.maintenance.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.backend.model.integration.PNCronInt;
import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.service.PNCronIntService;
@Service
public class PNCronIntServiceImpl implements PNCronIntService {
	private BasisNextidDaoImpl<PNCronInt> pnCronIntDAO;

	public BasisNextidDaoImpl<PNCronInt> getPnCronIntDAO() {
		return pnCronIntDAO;
	}

	public void setPnCronIntDAO(BasisNextidDaoImpl<PNCronInt> pnCronIntDAO) {
		this.pnCronIntDAO = pnCronIntDAO;
	}

	@Override
	public void saveOrUpdate(PNCronInt pnCronInt) {

		this.pnCronIntDAO.saveOrUpdate(pnCronInt);
	}

	@Override
	public PNCronInt getPNCronIntBySourceOutsourceNo(String sourceOutsourceNo) {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(PNCronInt.class);
		detachedCriteria.add(Restrictions.eq("sourceOutsourceNo",
				sourceOutsourceNo));
		return DataAccessUtils.uniqueResult(this.pnCronIntDAO
				.findByCriteria(detachedCriteria));
	}

	@Override
	public boolean isExist(String sourceOutsourceNo) {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(PNCronInt.class);
		detachedCriteria.add(Restrictions.eq("sourceOutsourceNo",
				sourceOutsourceNo));
		PNCronInt pnCronInt = DataAccessUtils.uniqueResult(this.pnCronIntDAO
				.findByCriteria(detachedCriteria));
		return pnCronInt != null;
	}

	@Override
	public List<PNCronInt> getPNCronInts(String sendFlag) {

		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(PNCronInt.class);
		detachedCriteria.add(Restrictions.eq("sendFlag", sendFlag));

		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return this.pnCronIntDAO.findByCriteria(detachedCriteria);

	}

}
