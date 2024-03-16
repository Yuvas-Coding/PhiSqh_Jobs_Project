package my.com.cmg.iwp.backend.service.integration.issue;

import java.util.List;

import my.com.cmg.iwp.backend.model.integration.issue.IssueBatchesInt;
import my.com.cmg.iwp.backend.model.integration.issue.IssueDtlsInt;
import my.com.cmg.iwp.backend.model.integration.issue.IssueHdrsInt;
import my.com.cmg.iwp.backend.model.integration.issue.RejectIssueDtlsInt;
import my.com.cmg.iwp.backend.model.integration.issue.RejectIssueHdrsInt;
import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;

public interface IssueIntegrationService {
	void save(IssueHdrsInt issueHdrsInt);

	void save(IssueDtlsInt issueDtlsInt);

	void save(IssueBatchesInt issueBatchesInt);

	List<IssueHdrsInt> getAllSendIssue();

	BasisNextidDaoImpl<IssueHdrsInt> getIssueHdrsIntDAO();

	void updateSendFlag(String sendFlagValue, String ptjCode, String factCode);
	void save(RejectIssueHdrsInt issueHdrsInt);

	void save(RejectIssueDtlsInt rejectIssueDtlsInt);

	boolean issueavailable(IssueHdrsInt issueHdrsInt);
	
}
