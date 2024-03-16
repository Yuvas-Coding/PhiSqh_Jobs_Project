package my.com.cmg.iwp.maintenance.service;

import java.util.List;

import my.com.cmg.iwp.maintenance.model.Drug;
import my.com.cmg.iwp.maintenance.model.LinkRpharmaScan;

public interface LinkRpharmaScanService {

	void delete(LinkRpharmaScan anLinkRpharmaScan);

	LinkRpharmaScan getNewLinkRpharmaScan();

	void saveOrUpdate(LinkRpharmaScan anLinkRpharmaScan);

	List getAllLinkRpharmaScanByQuery();

	List<LinkRpharmaScan> getAllLinkRpharmaScan();

	List getLinkRpharmaScanByTypeOfScan(String typeOfScan);

	LinkRpharmaScan findbyTypeOfScan(String typeOfScan);

	List<LinkRpharmaScan> findAllByTypeOfScan(String typeOfScan);

	LinkRpharmaScan findbyTypeOfScanAndDrug(String typeOfScan, Drug drug);

}
