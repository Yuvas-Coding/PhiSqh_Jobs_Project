package my.com.cmg.iwp.maintenance.service;

import my.com.cmg.iwp.maintenance.model.FppDrugPrice;

public interface FPPPriceService {
	FppDrugPrice getNewFppDrugPrice();

	void delete(FppDrugPrice anFppDrugPrice);

	void saveOrUpdate(FppDrugPrice anFppDrugPrice);

	String getPreviousFppDrugPrice(long drugSeqno);

	Long getEffectiveDrugPriceSeq(long drugSeqno);
}
