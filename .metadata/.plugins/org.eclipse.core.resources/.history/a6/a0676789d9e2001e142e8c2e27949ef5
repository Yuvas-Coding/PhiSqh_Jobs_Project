package my.com.cmg.iwp.maintenance.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.FormulationMaterialDAOImpl;
import my.com.cmg.iwp.maintenance.model.FormulationHeader;
import my.com.cmg.iwp.maintenance.model.FormulationMaterial;
import my.com.cmg.iwp.maintenance.model.Item;
import my.com.cmg.iwp.maintenance.service.FormulationMaterialService;

@Service
public class FormulationMaterialServiceImpl implements FormulationMaterialService{

	private FormulationMaterialDAOImpl formulationMaterialDAOImpl;
	
	public FormulationMaterialDAOImpl getFormulationMaterialDAOImpl() {
		return formulationMaterialDAOImpl;
	}

	public void setFormulationMaterialDAOImpl(
			FormulationMaterialDAOImpl formulationMaterialDAOImpl) {
		this.formulationMaterialDAOImpl = formulationMaterialDAOImpl;
	}

	@Override
	public void saveOrUpdate(FormulationMaterial formulationMaterial) {
		formulationMaterialDAOImpl.saveOrUpdate(formulationMaterial);
	}

	@Override
	public void delete(FormulationMaterial formulationMaterial) {
		formulationMaterialDAOImpl.delete(formulationMaterial);
		
	}

	@Override
	public FormulationMaterial findFormulationMaterial(
			FormulationHeader formulationHeader, Item materialItem) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(FormulationMaterial.class);
		criteria.add(Restrictions.eq("materialItem", materialItem));
		criteria.add(Restrictions.eq("formulationHeader", formulationHeader));
		criteria.setFetchMode("materialItem", FetchMode.JOIN);
		criteria.setFetchMode("formulationHeader", FetchMode.JOIN);
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return DataAccessUtils.uniqueResult(formulationMaterialDAOImpl
				.findByCriteria(criteria));
	}

	@Override
	public List<FormulationMaterial> findAllIngredients(
			FormulationHeader formulationHeader, String typeOfMaterials) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(FormulationMaterial.class);
		criteria.add(Restrictions.eq("formulationHeader", formulationHeader));
		criteria.add(Restrictions.eq("typeOfMaterials", typeOfMaterials));
		criteria.setFetchMode("materialItem", FetchMode.JOIN);
		criteria.setFetchMode("formulationHeader", FetchMode.JOIN);
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return formulationMaterialDAOImpl.findByCriteria(criteria);
	}
	

}
