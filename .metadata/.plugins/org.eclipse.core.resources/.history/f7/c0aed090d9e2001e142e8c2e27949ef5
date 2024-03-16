package my.com.cmg.iwp.maintenance.service.impl;

import java.io.Serializable;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.DepartmentDiscipline;
import my.com.cmg.iwp.maintenance.service.DepartmentDisciplineService;

@Service
public class DepartmentDisciplineServiceImpl implements
		DepartmentDisciplineService, Serializable {
	private static final long serialVersionUID = 5052729410770759165L;
	private BasisNextidDaoImpl<DepartmentDiscipline> departmentDisciplineDAO;

	public void setDepartmentDisciplineDAO(
			BasisNextidDaoImpl<DepartmentDiscipline> departmentDisciplineDAO) {
		this.departmentDisciplineDAO = departmentDisciplineDAO;
	}

	public BasisNextidDaoImpl<DepartmentDiscipline> getDepartmentDisciplineDAO() {
		return departmentDisciplineDAO;
	}

	@Override
	public DepartmentDiscipline getDepartmentDiscipline() {

		return new DepartmentDiscipline();
	}

	@Override
	public void delete(DepartmentDiscipline anDepartmentDiscipline) {

		departmentDisciplineDAO.delete(anDepartmentDiscipline);

	}

	@Override
	public void saveOrUpdate(DepartmentDiscipline anDepartmentDiscipline) {

		departmentDisciplineDAO.saveOrUpdate(anDepartmentDiscipline);

	}

	@Override
	public DepartmentDiscipline findByID(Long seqno) {

		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(DepartmentDiscipline.class);
		detachedCriteria.add(Restrictions.eq("deptDispSeqno", seqno));
		return DataAccessUtils.uniqueResult(departmentDisciplineDAO
				.findByCriteria(detachedCriteria));
	}

	@Override
	public DepartmentDiscipline findByDepartmentDisciplineSeqNo(
			long disciplineSeqno, long deptSeqno) {

		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(DepartmentDiscipline.class);
		Criterion criterion1 = Restrictions.eq("disciplineSeqno",
				disciplineSeqno);
		Criterion criterion2 = Restrictions.eq("deptSeqNo", deptSeqno);
		detachedCriteria.add(Restrictions.and(criterion1, criterion2));
		return DataAccessUtils.uniqueResult(departmentDisciplineDAO
				.findByCriteria(detachedCriteria));
	}

}
