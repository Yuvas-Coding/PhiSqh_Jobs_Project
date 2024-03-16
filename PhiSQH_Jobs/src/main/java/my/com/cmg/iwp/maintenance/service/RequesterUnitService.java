package my.com.cmg.iwp.maintenance.service;

import my.com.cmg.iwp.maintenance.model.RequesterGroup;
import my.com.cmg.iwp.maintenance.model.RequesterUnit;
import my.com.cmg.iwp.maintenance.model.ResultObject;

public interface RequesterUnitService {

	RequesterUnit getNewRequesterUnit();

	RequesterUnit getRequesterUnit(String Unit_code);

	RequesterUnit getRequesterUnitGroup(String Unit_group);

	void delete(RequesterUnit anRequesterUnit);

	void saveOrUpdate(RequesterUnit anRequesterUnit);

	ResultObject getAllRequesterUnitLikeText(String txtUnitCode,
			String txtDesc, int start, int pageSize);

	RequesterUnit getRequesterUnitBySeqNo(long rqstrSeqno);

	RequesterUnit getAllRequesterUnitBySeq_desc(long reqSeqNo, String reqDesc);

	RequesterGroup getRequesterGroupByUnitSeqno(long rqstrSeqno);

	RequesterUnit getRequesterUnitByUnitName(String unitName);

}
