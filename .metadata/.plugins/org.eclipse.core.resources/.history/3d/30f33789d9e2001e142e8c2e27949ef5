package my.com.cmg.iwp.maintenance.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.DosageForm;
import my.com.cmg.iwp.maintenance.service.DosageFormService;
@Service
public class DosageFormServiceImpl implements DosageFormService {
	private BasisNextidDaoImpl<DosageForm> dosageFormDAO;

	@Override
	public DosageForm getNewDosageForm() {

		return new DosageForm();
	}

	public void setDosageFormDAO(BasisNextidDaoImpl<DosageForm> dosageFormDAO) {
		this.dosageFormDAO = dosageFormDAO;
	}

	public BasisNextidDaoImpl<DosageForm> getDosageFormDAO() {
		return dosageFormDAO;
	}

	@Override
	public void delete(DosageForm anDosageForm) {
		dosageFormDAO.delete(anDosageForm);

	}

	@Override
	public void saveOrUpdate(DosageForm anDosageForm) {
		dosageFormDAO.saveOrUpdate(anDosageForm);

	}

	@Override
	public List<DosageForm> getAllDosage() {
		DetachedCriteria criteria = DetachedCriteria.forClass(DosageForm.class);
		criteria.add(Restrictions.eq("activeFlag", 'A'));
		return dosageFormDAO.findByCriteria(criteria);
	}

	@Override
	public DosageForm getDosageFormbyDosageSeqno(long dosageSeqno) {

		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(DosageForm.class);
		detachedCriteria.add(Restrictions.eq("dosageSeqno", dosageSeqno));
		return DataAccessUtils.uniqueResult(dosageFormDAO
				.findByCriteria(detachedCriteria));
	}

	@Override
	public DosageForm getDosageFormbyDosageCode(String dosageCode) {

		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(DosageForm.class);
		detachedCriteria.add(Restrictions.ilike("dosageCode", dosageCode,
				MatchMode.EXACT));
		return DataAccessUtils.uniqueResult(dosageFormDAO
				.findByCriteria(detachedCriteria));
	}

}
