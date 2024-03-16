package my.com.cmg.iwp.maintenance.service;

import java.math.BigDecimal;
import java.util.List;

import my.com.cmg.iwp.maintenance.model.ExternalFacility;
import my.com.cmg.iwp.maintenance.model.VoteCode;


public interface VoteCodeService {
	VoteCode getNewFunction();

	void delete(VoteCode anFunction);

	void saveOrUpdate(VoteCode anFunction);

	VoteCode getNewVoteCode();

	VoteCode getVoteName(long voteSeqNo);

	VoteCode findByVoteCode(String voteCode, String facilityCode);

	VoteCode findByVoteCodes(String voteCode, String facilityCode, String minitrydept, String votecodestatus);
	
	VoteCode findByExternalFaclity(ExternalFacility externalFacility);

	VoteCode findByVoteCodeAllStatus(String voteCode, String facilityCode);
	List<BigDecimal> getVoteSeqNobyItemGroup(String itemGroup, String facCode,
			String ptjcode, long itemseq);
}
