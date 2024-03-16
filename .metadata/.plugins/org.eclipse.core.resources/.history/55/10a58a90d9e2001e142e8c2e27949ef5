package my.com.cmg.iwp.maintenance.service;

import java.util.List;

import my.com.cmg.iwp.maintenance.model.FormulationHeader;
import my.com.cmg.iwp.maintenance.model.FormulationMaterial;
import my.com.cmg.iwp.maintenance.model.Item;

public interface FormulationMaterialService {

	void saveOrUpdate(FormulationMaterial formulationHeader);

	void delete(FormulationMaterial formulationHeader);

	FormulationMaterial findFormulationMaterial(
			FormulationHeader formulationHeader, Item materialItem);

	List<FormulationMaterial> findAllIngredients(FormulationHeader formulationHeader,
			String galenicalIngredient);

}
