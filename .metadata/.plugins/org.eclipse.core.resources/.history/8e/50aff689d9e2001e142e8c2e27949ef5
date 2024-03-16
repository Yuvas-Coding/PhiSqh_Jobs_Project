package my.com.cmg.iwp.maintenance.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.PenaltyIncident;
import my.com.cmg.iwp.maintenance.model.PenaltySection;
import my.com.cmg.iwp.maintenance.service.PenaltyService;
import my.com.cmg.iwp.webui.constant.RefCodeConstant;
@Service
public class PenaltyServiceImpl implements PenaltyService {
	private static final long serialVersionUID = 1L;
	private BasisNextidDaoImpl penaltySectionDAO;
	private BasisNextidDaoImpl penaltyIncidentDAO;

	public BasisNextidDaoImpl getPenaltySectionDAO() {
		return penaltySectionDAO;
	}

	public void setPenaltySectionDAO(
			BasisNextidDaoImpl<PenaltySection> penaltySectionDAO) {
		this.penaltySectionDAO = penaltySectionDAO;
	}

	public BasisNextidDaoImpl getPenaltyIncidentDAO() {
		return penaltyIncidentDAO;
	}

	public void setPenaltyIncidentDAO(
			BasisNextidDaoImpl<PenaltyIncident> penaltyIncidentDAO) {
		this.penaltyIncidentDAO = penaltyIncidentDAO;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public PenaltySection getNewPenaltySection() {
		return new PenaltySection();
	}

	@Override
	public void saveOrUpdateSection(PenaltySection anPenaltySection) {
		penaltySectionDAO.saveOrUpdate(anPenaltySection);
	}

	@Override
	public PenaltyIncident getNewPenaltyIncident() {
		return new PenaltyIncident();
	}

	@Override
	public void saveOrUpdateIncident(PenaltyIncident anPenaltyIncident) {
		penaltyIncidentDAO.saveOrUpdate(anPenaltyIncident);
	}

	@Override
	public void delete(PenaltySection penaltySectionList) {
		// TODO Auto-generated method stub
		penaltySectionDAO.delete(penaltySectionList);

	}

	@Override
	public void delete(PenaltyIncident penaltyIncident) {
		// TODO Auto-generated method stub
		penaltySectionDAO.delete(penaltyIncident);
	}

	@Override
	public List<PenaltyIncident> getPenaltyIncidentwithSection(Long seqNo) {
		String query = "select all pI " + "from PenaltyIncident pI "
				+ " join fetch pI.penaltySection" + " where pI.incidentSeqno="
				+ seqNo;
		return penaltyIncidentDAO.find(query);
	}

	@Override
	public void deletePenaltyincident(PenaltyIncident penaltyIncident) {
		penaltyIncidentDAO.delete(penaltyIncident);
	}

	@Override
	public List<PenaltySection> getSectionforIncidentEdit(Long seqno) {
		String query = "select all pS "
				+ "from PenaltySection pS join fetch pS.penaltyIncidents as pI "
				+ " where pI.incidentSeqno=" + seqno;
		return penaltySectionDAO.find(query);
	}
	
	

	@Override
	public List<PenaltySection> getPenaltySection(String sectionCode) {
		String query = "select all pS " + "from PenaltySection pS "
				+ " where pS.sectionCode=" + "'" + sectionCode + "'";
		return penaltySectionDAO.find(query);
	}
	
	@Override
	public List<PenaltyIncident> getPenaltyIncidents() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(PenaltyIncident.class);
		detachedCriteria.add(Restrictions.eq("activeFlag",RefCodeConstant.ACTIVE_FLAG_TRUE));
		return penaltyIncidentDAO.findByCriteria(detachedCriteria);
	}
	
	@Override
	public List<PenaltyIncident> getPenaltyIncidentByCode(String incidentCode) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(PenaltyIncident.class);
		detachedCriteria.add(Restrictions.eq("activeFlag",RefCodeConstant.ACTIVE_FLAG_TRUE));
		detachedCriteria.add(Restrictions.eq("incidentCode",incidentCode));
		detachedCriteria.setResultTransformer(DetachedCriteria.DISTINCT_ROOT_ENTITY);
		return penaltyIncidentDAO.findByCriteria(detachedCriteria);
	}
}
