package my.com.cmg.iwp.backend.model.integration.decorator;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import my.com.cmg.iwp.backend.model.integration.issue.IssueHdrsInt;

@XmlRootElement(name = "IssueHdrsIntList")
public class IssueHdrsIntList {

	private List<IssueHdrsInt> issueHdrsInts = new ArrayList<IssueHdrsInt>();

	public IssueHdrsIntList() {
	}

	public IssueHdrsIntList(List<IssueHdrsInt> issueHdrsInts) {
		super();
		this.issueHdrsInts = issueHdrsInts;
	}

	@XmlElement(name = "IssueHdrsInt")
	public List<IssueHdrsInt> getIssueHdrsInts() {
		return issueHdrsInts;
	}

	public void setIssueHdrsInts(List<IssueHdrsInt> issueHdrsInts) {
		this.issueHdrsInts = issueHdrsInts;
	}

}
