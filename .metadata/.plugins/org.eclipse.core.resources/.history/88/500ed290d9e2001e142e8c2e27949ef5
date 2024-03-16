package my.com.cmg.iwp.maintenance.service.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.Department;
import my.com.cmg.iwp.maintenance.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService, Serializable {
	private static final long serialVersionUID = 1L;
	private BasisNextidDaoImpl<Department> departmentDAO;

	@Override
	public Department getNewDepartment() {
		Department anDepartment = new Department();
		new Department().setDeptSeqno(Long.MIN_VALUE);
		return anDepartment;
	}

	@Override
	public Department getDepartment(String Dept_code) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Department.class);
		criteria.add(Restrictions.eq("deptCode", Dept_code));
		return departmentDAO.findByCriteria(criteria).get(0);
	}

	@Override
	public void delete(Department anDepartment) {

		departmentDAO.delete(anDepartment);
	}

	@Override
	public void saveOrUpdate(Department anDepartment) {
		departmentDAO.saveOrUpdate(anDepartment);
	}

	public void setDepartmentDAO(BasisNextidDaoImpl<Department> departmentDAO) {
		this.departmentDAO = departmentDAO;
	}

	public BasisNextidDaoImpl<Department> getDepartmentDAO() {
		return departmentDAO;
	}

	@Override
	public List<Department> getAllDepartments() {

		DetachedCriteria criteria = DetachedCriteria.forClass(Department.class);
		criteria.addOrder(Order.asc("deptCode"));
		return departmentDAO.findByCriteria(criteria);
	}

	@Override
	public List findDeptCode(String query) {
		
		return departmentDAO.find(query);
	}

	@Override
	public Department findByDepartmentCode(String deptCode) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Department.class);
		criteria.add(Restrictions.ilike("deptCode", deptCode, MatchMode.EXACT));
		return DataAccessUtils.uniqueResult(departmentDAO
				.findByCriteria(criteria));
	}

	public Department getDepartmentDetail(String deptCode) {
		Department department = (Department) departmentDAO
				.find("from Department where deptSeqno=" + deptCode).iterator()
				.next();
		return department;
	}

	@Override
	public List getCmbDepart() {
		return departmentDAO.find("from Department");
	}

	public List<Department> getDept(String deptCode) {
		return departmentDAO.find("from Department where deptCode=" + deptCode);
	}
	
	@Override
	public Department findByID(Long deptSeqno) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Department.class);
		criteria.add(Restrictions.eq("deptSeqno", deptSeqno));
		return DataAccessUtils.uniqueResult(departmentDAO
				.findByCriteria(criteria));
	}
	
	

}
