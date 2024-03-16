package my.com.cmg.iwp.maintenance.service;

import java.util.List;

import my.com.cmg.iwp.maintenance.model.Reason;

public interface ReasonService {

	Reason getNewReason();

	void delete(Reason anReason);

	void saveOrUpdate(Reason anReason);

	List<Reason> getAllOrderHoldReasons();

	List<Reason> getAllReasonsByType(String type);

	Reason findByReasonCode(String value);

	Reason findByReasonDesc(String desc, String reasonType);

	Reason findByReasonSeqno(long seqno);

}
