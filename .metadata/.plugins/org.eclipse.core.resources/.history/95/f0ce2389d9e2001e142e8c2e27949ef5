package my.com.cmg.iwp.maintenance.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.Discipline;
import my.com.cmg.iwp.maintenance.service.DisciplineService;

@Service
public class DisciplineServiceImpl implements DisciplineService {

	private BasisNextidDaoImpl<Discipline> disciplineDAO;

	public BasisNextidDaoImpl<Discipline> getDisciplineDAO() {
		return disciplineDAO;
	}

	public void setDisciplineDAO(BasisNextidDaoImpl<Discipline> disciplineDAO) {
		this.disciplineDAO = disciplineDAO;
	}

	@Override
	public void delete(Discipline anDiscipline) {
		disciplineDAO.delete(anDiscipline);

	}

	@Override
	public Discipline getNewDiscipline() {
		return new Discipline();
	}

	@Override
	public void saveOrUpdate(Discipline anDiscipline) {
		disciplineDAO.saveOrUpdate(anDiscipline);

	}

	@Override
	public List<Discipline> findByDisciplineCode(String disciplineCode) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Discipline.class);
		criteria.add(Restrictions.ilike("disciplineCode", disciplineCode, MatchMode.EXACT));
		return disciplineDAO.findByCriteria(criteria);
	}

	@Override
	public List<Discipline> getAllDiscipline() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Discipline.class);
		criteria.addOrder(Order.asc("disciplineName"));
		return disciplineDAO.findByCriteria(criteria);
	}

	@Override
	public Discipline getDisciplineBySeqNo(Long disciplineSeqno) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Discipline.class);
		criteria.add(Restrictions.eq("disciplineSeqno", disciplineSeqno));
		return (Discipline) DataAccessUtils.uniqueResult(disciplineDAO.findByCriteria(criteria));

	}

	@Override
	public List<Discipline> getAllActiveDiscipline() {
		return disciplineDAO.loadAll(Discipline.class);
	}

}
