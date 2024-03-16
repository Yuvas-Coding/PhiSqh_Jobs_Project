package my.com.cmg.iwp.backend.model.integration.decorator;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import my.com.cmg.iwp.backend.model.integration.indent.IndentHdrsInt;

@XmlRootElement(name = "IndentHdrsIntList")
public class IndentHdrsIntList {
	private List<IndentHdrsInt> indentHdrsInt = new ArrayList<IndentHdrsInt>();

	public IndentHdrsIntList() {
		super();
	}

	public IndentHdrsIntList(List<IndentHdrsInt> indentHdrsInt) {
		super();
		this.indentHdrsInt = indentHdrsInt;
	}

	@XmlElement(name = "IndentHdrsInt")
	public List<IndentHdrsInt> getIndentHdrsInt() {
		return indentHdrsInt;
	}

	public void setIndentHdrsInt(List<IndentHdrsInt> indentHdrsInt) {
		this.indentHdrsInt = indentHdrsInt;
	}
}
