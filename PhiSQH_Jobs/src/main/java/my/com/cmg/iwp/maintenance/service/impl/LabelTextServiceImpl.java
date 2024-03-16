package my.com.cmg.iwp.maintenance.service.impl;

import java.util.Collection;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.LabelText;
import my.com.cmg.iwp.maintenance.service.LabelTextService;
@Service
public class LabelTextServiceImpl implements LabelTextService {
	private BasisNextidDaoImpl<LabelText> labelTextDAO;

	public BasisNextidDaoImpl<LabelText> getLabelTextDAO() {
		return labelTextDAO;
	}

	public void setLabelTextDAO(BasisNextidDaoImpl<LabelText> labelTextDAO) {
		this.labelTextDAO = labelTextDAO;
	}

	@Override
	public void delete(LabelText anLabelText) {
		// TODO Auto-generated method stub
		labelTextDAO.delete(anLabelText);
	}

	@Override
	public LabelText getNewLabelText() {
		// TODO Auto-generated method stub
		return new LabelText();
	}

	@Override
	public void saveOrUpdate(LabelText anLabelText) {

		labelTextDAO.saveOrUpdate(anLabelText);
	}

	@Override
	public Collection<LabelText> getAllLabelText() {

		return labelTextDAO.loadAll(LabelText.class);
	}

	@Override
	public List<LabelText> findlabelTextByRlabelCode(String code) {

		DetachedCriteria criteria = DetachedCriteria.forClass(LabelText.class);
		criteria.add(Restrictions.ilike("labelCode", code, MatchMode.EXACT));
		return labelTextDAO.findByCriteria(criteria);
	}
}