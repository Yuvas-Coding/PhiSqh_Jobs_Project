package my.com.cmg.iwp.maintenance.service;

import java.util.List;

import my.com.cmg.iwp.maintenance.model.Subtopic;
import my.com.cmg.iwp.maintenance.model.Topic;

public interface SubtopicService {

	Subtopic getNewSubtopic();
	void delete(Subtopic anSubtopic);
	void saveOrUpdate(Subtopic anSubtopic);
	public List<Subtopic> getAllSubtopics();
	public List<Subtopic> getActiveSubtopics();
	Subtopic findBySubtopicCode(String subtopicCode);
	Subtopic findBySubtopicCode(String subtopicCode, Topic topic);
}
