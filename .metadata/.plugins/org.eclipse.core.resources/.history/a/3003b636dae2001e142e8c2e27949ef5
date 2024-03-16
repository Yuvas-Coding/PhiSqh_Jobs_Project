package my.com.cmg.iwp.backend.model.integration.decorator;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import my.com.cmg.iwp.backend.model.integration.returns.ReturnInterHdrsInt;



@XmlRootElement(name="ReturnInterHdrsIntList")
public class ReturnInterHdrsIntList {

	private List<ReturnInterHdrsInt> returnInterHdrsInts = new ArrayList<ReturnInterHdrsInt>();

	public ReturnInterHdrsIntList() {

	}

	public ReturnInterHdrsIntList(List<ReturnInterHdrsInt> returnInterHdrsInts) {
		super();
		this.returnInterHdrsInts = returnInterHdrsInts;
	}

	@XmlElement(name="ReturnInterHdrsInt")
	public List<ReturnInterHdrsInt> getReturnInterHdrsInts() {
		return returnInterHdrsInts;
	}

	public void setReturnInterHdrsInts(List<ReturnInterHdrsInt> returnInterHdrsInts) {
		this.returnInterHdrsInts = returnInterHdrsInts;
	}


}
