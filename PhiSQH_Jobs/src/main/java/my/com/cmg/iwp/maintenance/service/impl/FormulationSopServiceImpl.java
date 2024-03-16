package my.com.cmg.iwp.maintenance.service.impl;

import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.FormulationSopDAOImpl;
import my.com.cmg.iwp.maintenance.model.FormulationSop;
import my.com.cmg.iwp.maintenance.service.FormulationSopService;

@Service
public class FormulationSopServiceImpl implements FormulationSopService{

	private FormulationSopDAOImpl formulationSopDAOImpl;

	public FormulationSopDAOImpl getFormulationSopDAOImpl() {
		return formulationSopDAOImpl;
	}

	public void setFormulationSopDAOImpl(FormulationSopDAOImpl formulationSopDAOImpl) {
		this.formulationSopDAOImpl = formulationSopDAOImpl;
	}

	@Override
	public void saveOrUpdate(FormulationSop formulationSop) {
		formulationSopDAOImpl.saveOrUpdate(formulationSop);
	}

	@Override
	public void delete(FormulationSop formulationSop) {
		formulationSopDAOImpl.delete(formulationSop);
	}



}
