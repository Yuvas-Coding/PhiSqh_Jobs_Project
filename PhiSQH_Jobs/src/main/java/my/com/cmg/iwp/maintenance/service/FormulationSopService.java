package my.com.cmg.iwp.maintenance.service;

import my.com.cmg.iwp.maintenance.model.FormulationSop;


public interface FormulationSopService {

	void saveOrUpdate(FormulationSop formulationHeader);

	void delete(FormulationSop formulationHeader);

}
