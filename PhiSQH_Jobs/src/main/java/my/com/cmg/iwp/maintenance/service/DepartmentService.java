package my.com.cmg.iwp.maintenance.service;

import java.util.List;

import my.com.cmg.iwp.maintenance.model.Department;


public interface DepartmentService {

	Department getNewDepartment();

	void delete(Department anDepartment);

	void saveOrUpdate(Department anDepartment);
	
	Department getDepartment(String Dept_code);
	
	List<Department> getAllDepartments();
	
	Department findByDepartmentCode(String departmentCode);
	
	List findDeptCode(String query);
	
	Department getDepartmentDetail(String deptCode);
	
	List getCmbDepart();
	
	List getDept(String deptCode);

	Department findByID(Long deptSeqno);
}
