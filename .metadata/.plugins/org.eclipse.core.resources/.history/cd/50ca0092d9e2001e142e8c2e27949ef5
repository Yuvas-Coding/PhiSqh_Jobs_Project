package my.com.cmg.iwp.maintenance.service;

import java.io.Serializable;
import java.util.List;

import my.com.cmg.iwp.maintenance.model.PenaltyIncident;
import my.com.cmg.iwp.maintenance.model.PenaltySection;

public interface PenaltyService extends Serializable {
	public PenaltySection getNewPenaltySection();

	public void saveOrUpdateSection(PenaltySection penaltySectionList);

	public PenaltyIncident getNewPenaltyIncident();

	public void saveOrUpdateIncident(PenaltyIncident penaltyIncidentList);

	void delete(PenaltySection penaltySectionList);

	void delete(PenaltyIncident penaltyIncident);

	List<PenaltyIncident> getPenaltyIncidentwithSection(Long seqNo);

	void deletePenaltyincident(PenaltyIncident penaltyIncident);

	List<PenaltySection> getSectionforIncidentEdit(Long seqno);

	List<PenaltySection> getPenaltySection(String sectionCode);
	
	public List<PenaltyIncident> getPenaltyIncidents();
	
	public List<PenaltyIncident> getPenaltyIncidentByCode(String incidentCode);
}
