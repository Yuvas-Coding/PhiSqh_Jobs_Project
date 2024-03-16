package my.com.cmg.iwp.maintenance.service;

import java.util.List;

import my.com.cmg.iwp.maintenance.model.Drug;
import my.com.cmg.iwp.maintenance.model.Item;
import my.com.cmg.iwp.maintenance.model.RPSetupBrands;
import my.com.cmg.iwp.maintenance.model.RPSetupSOP;
import my.com.cmg.iwp.maintenance.model.RPSetupStrip;
import my.com.cmg.iwp.maintenance.model.RpSource;

public interface RpSourceService {

	RpSource getNewRpSource();

	List<RpSource> getSource();

	void delete(RpSource anRpSource);

	void saveOrUpdate(RpSource anRpSource);

	RpSource findByRpSourceSeqno(long seqNo);

	List<Drug> getRFDrugList();

	boolean checkitemPresence(Item item);

	RPSetupBrands getNewRPSetupBrands();

	boolean isNewRPSetupBrands(RPSetupBrands rpSetupBrands);

	RPSetupStrip getNewRPSetupStrip(RPSetupBrands rpSetupBrands);

	boolean isNewRPSetupStrip(RPSetupStrip rpSetupStrip2);

	RPSetupSOP getNewRPSetupSOP(RPSetupBrands rpSetupBrands);

	boolean isNewRPSetupSOP(RPSetupSOP rpSetupSOP);

	Integer getMaxRPSetupSOPSequenceNo(Long rpSetUpBrandsSeqNo);

	boolean isNewRpSource(RpSource rpSource);

	void inActiveRpSetUpBrands(RPSetupBrands rpSetupBrands);

	void inActiveRpSetupStrip(RPSetupStrip rpSetupStrip);

	void inActiveRpSetupSOP(RPSetupSOP rpSetupSOP);
}
