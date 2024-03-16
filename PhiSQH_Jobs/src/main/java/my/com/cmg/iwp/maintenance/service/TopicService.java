package my.com.cmg.iwp.maintenance.service;

import java.util.List;

import my.com.cmg.iwp.maintenance.model.Topic;

public interface TopicService {

	Topic getNewTopic();
	void delete(Topic anTopic);
	void saveOrUpdate(Topic anTopic);
	public List<Topic> getAllTopics();
	public List<Topic> getActiveTopics();
	List<Topic> findByTopicCode(String value);
}
