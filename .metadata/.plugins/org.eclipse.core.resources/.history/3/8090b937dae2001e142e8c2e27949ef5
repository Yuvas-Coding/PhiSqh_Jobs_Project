package my.com.cmg.iwp.maintenance.service;

import java.util.List;

import my.com.cmg.iwp.maintenance.model.Frequency;
import my.com.cmg.iwp.maintenance.model.FrequencySchedule;
import my.com.cmg.iwp.maintenance.model.RegimenDays;

public interface FrequencyScheduleService {

	public FrequencySchedule getNewFrequencySchedule();

	public void delete(FrequencySchedule anFrequencySchedule);

	public void saveOrUpdate(FrequencySchedule anFrequencySchedule);

	List<FrequencySchedule> getAllListValueByFrequency(Frequency frequency);

	public void deleteAll(List<FrequencySchedule> anFrequencySchedule);

	FrequencySchedule getAllValueByFreqCode(String code);

	List<FrequencySchedule> getActiveValueByRegimensDays(RegimenDays regimensDays);

	public boolean isNewFrequencySchedule(FrequencySchedule frequencySchedule);
}
