package my.com.cmg.iwp.backend.model.integration.decorator;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import my.com.cmg.iwp.backend.model.integration.OutsourceOrderInt;

@XmlRootElement(name = "OutsourceOrderIntList")
@JsonIgnoreProperties(ignoreUnknown=true)
public class OutsourceOrderIntList {
	private List<OutsourceOrderInt> outsourceOrderInts = new ArrayList<OutsourceOrderInt>();

	public OutsourceOrderIntList() {
		super();
	}

	public OutsourceOrderIntList(List<OutsourceOrderInt> anOutsourceOrderInts) {
		super();
		this.outsourceOrderInts = anOutsourceOrderInts;
	}

	@XmlElement(name = "OutsourceOrderInt")
	public List<OutsourceOrderInt> getOutsourceOrderInts() {
		return outsourceOrderInts;
	}

	public void setOutsourceOrderInts(List<OutsourceOrderInt> outsourceOrderInts) {
		this.outsourceOrderInts = outsourceOrderInts;
	}
}
