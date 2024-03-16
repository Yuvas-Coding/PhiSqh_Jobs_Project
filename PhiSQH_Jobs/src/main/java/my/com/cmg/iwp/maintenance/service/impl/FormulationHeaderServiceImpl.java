package my.com.cmg.iwp.maintenance.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.FormulationHeaderDAOImpl;
import my.com.cmg.iwp.maintenance.model.FormulationHeader;
import my.com.cmg.iwp.maintenance.service.FormulationHeaderService;

@Service
public class FormulationHeaderServiceImpl implements FormulationHeaderService{

	private FormulationHeaderDAOImpl formulationHeaderDAOImpl;
	
	public FormulationHeaderDAOImpl getFormulationHeaderDAOImpl() {
		return formulationHeaderDAOImpl;
	}

	public void setFormulationHeaderDAOImpl(
			FormulationHeaderDAOImpl formulationHeaderDAOImpl) {
		this.formulationHeaderDAOImpl = formulationHeaderDAOImpl;
	}

	@Override
	public void saveOrUpdate(FormulationHeader formulationHeader) {
		formulationHeaderDAOImpl.saveOrUpdate(formulationHeader);		
	}
	
	@Override
	public void delete(FormulationHeader formulationHeader) {
		formulationHeaderDAOImpl.delete(formulationHeader);
		
	}
	
	@Override
	public List<FormulationHeader> getFormulationHeader() {
		Session session = formulationHeaderDAOImpl.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(FormulationHeader.class);
		
		List<FormulationHeader> formulationHeaders = criteria.list();
		session.close();
		return formulationHeaders;
	}

}
