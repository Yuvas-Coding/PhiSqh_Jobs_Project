package my.com.cmg.iwp.maintenance.service.impl;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.Discipline;
import my.com.cmg.iwp.maintenance.model.SubDiscipline;
import my.com.cmg.iwp.maintenance.service.SubDisciplineService;
@Service
public class SubDisciplineServiceImpl implements SubDisciplineService {

	private BasisNextidDaoImpl<SubDiscipline> subDisciplineDAO;

	public void setSubDisciplineDAO(BasisNextidDaoImpl<SubDiscipline> subDisciplineDAO) {
		this.subDisciplineDAO = subDisciplineDAO;
	}

	public BasisNextidDaoImpl<SubDiscipline> getSubDisciplineDAO() {
		return subDisciplineDAO;
	}

	@Override
	public void delete(SubDiscipline anSubDiscipline) {
		subDisciplineDAO.delete(anSubDiscipline);
	}

	@Override
	public SubDiscipline getNewSubDiscipline() {
		return new SubDiscipline();
	}

	@Override
	public void saveOrUpdate(SubDiscipline anSubDiscipline) {
		subDisciplineDAO.saveOrUpdate(anSubDiscipline);
	}

	@Override
	public SubDiscipline findBySubDisciplineCode(String subDisciplineCode, Discipline discipline) {
		DetachedCriteria criteria = DetachedCriteria.forClass(SubDiscipline.class);
		Criterion criterion1 = Restrictions.eq("subdisciplineCode", subDisciplineCode);
		Criterion criterion2 = Restrictions.eq("discipline", discipline);
		criteria.add(Restrictions.and(criterion1, criterion2));
		return DataAccessUtils.uniqueResult(subDisciplineDAO.findByCriteria(criteria));
	}

	@Override
	public List<SubDiscipline> findAllSubDiscplineByDiciplineCode(Discipline discipline) {
		DetachedCriteria criteria = DetachedCriteria.forClass(SubDiscipline.class);
		criteria.add(Restrictions.eq("discipline", discipline));
		criteria.addOrder(Order.asc("subdisciplineName"));
		return subDisciplineDAO.findByCriteria(criteria);
	}

	@Override
	public SubDiscipline findSubDisciplineBySeqNo(long disciplineSeqno) {

		DetachedCriteria criteria = DetachedCriteria.forClass(SubDiscipline.class);
		criteria.add(Restrictions.eq("subdisciplineSeqno", disciplineSeqno));
		return DataAccessUtils.uniqueResult(subDisciplineDAO.findByCriteria(criteria));
	}

	@Override
	public List<SubDiscipline> getAllSubDiscipline() {

		return subDisciplineDAO.loadAll(SubDiscipline.class);
	}

}
