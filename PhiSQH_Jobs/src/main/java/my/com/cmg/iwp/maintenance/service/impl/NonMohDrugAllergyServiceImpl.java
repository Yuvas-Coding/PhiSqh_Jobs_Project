package my.com.cmg.iwp.maintenance.service.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.Department;
import my.com.cmg.iwp.maintenance.model.NonMohDrugAllergy;
import my.com.cmg.iwp.maintenance.service.NonMohDrugAllergyService;
@Service
public class NonMohDrugAllergyServiceImpl implements NonMohDrugAllergyService, Serializable {
	private static final long serialVersionUID = 1L;
	private BasisNextidDaoImpl<NonMohDrugAllergy> nonMohDrugAllergyDAO;

	@Override
	public NonMohDrugAllergy getNewNonMohDrugAllergy() {
		NonMohDrugAllergy anNonMohDrugAllergy = new NonMohDrugAllergy();
		new Department().setDeptSeqno(Long.MIN_VALUE);
		return anNonMohDrugAllergy;
	}

	@Override
	public void delete(NonMohDrugAllergy anNonMohDrugAllergy) {

		nonMohDrugAllergyDAO.delete(anNonMohDrugAllergy);
	}

	@Override
	public void saveOrUpdate(NonMohDrugAllergy anNonMohDrugAllergy) {		
		nonMohDrugAllergyDAO.saveOrUpdate(anNonMohDrugAllergy);
		if(anNonMohDrugAllergy.getAllergenCode()==null||anNonMohDrugAllergy.getAllergenCode().isEmpty()){
			anNonMohDrugAllergy.setAllergenCode(Long.toString(anNonMohDrugAllergy.getNonmohAllergySeqNo()));
			nonMohDrugAllergyDAO.saveOrUpdate(anNonMohDrugAllergy);
		}
	}

	public void setNonMohDrugAllergyDAO(BasisNextidDaoImpl<NonMohDrugAllergy> nonMohDrugAllergyDAO) {
		this.nonMohDrugAllergyDAO = nonMohDrugAllergyDAO;
	}

	public BasisNextidDaoImpl<NonMohDrugAllergy> getNonMohDrugAllergyDAO() {
		return nonMohDrugAllergyDAO;
	}

	@Override
	public List<NonMohDrugAllergy> getAllNonMohDrugAllergy() {

		DetachedCriteria criteria = DetachedCriteria.forClass(NonMohDrugAllergy.class);
		criteria.addOrder(Order.asc("allergenCode"));
		return nonMohDrugAllergyDAO.findByCriteria(criteria);
	}

	
	
	

}
