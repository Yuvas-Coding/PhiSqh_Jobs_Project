package my.com.cmg.iwp.maintenance.service;

import java.util.List;

import my.com.cmg.iwp.maintenance.model.Discipline;
import my.com.cmg.iwp.maintenance.model.SubDiscipline;

public interface SubDisciplineService {

	void delete(SubDiscipline anSubDiscipline);

	SubDiscipline getNewSubDiscipline();

	void saveOrUpdate(SubDiscipline anSubDiscipline);

	SubDiscipline findBySubDisciplineCode(String subDisciplineCode,
			Discipline discipline);

	List<SubDiscipline> findAllSubDiscplineByDiciplineCode(Discipline discipline);

	SubDiscipline findSubDisciplineBySeqNo(long disciplineSeqno);

	List<SubDiscipline> getAllSubDiscipline();
}