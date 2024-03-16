package my.com.cmg.iwp.backend.model.integration.decorator;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import my.com.cmg.iwp.backend.model.integration.spub.SpubHdrsInt;

@XmlRootElement(name = "SpubHdrIntList")
@JsonIgnoreProperties(ignoreUnknown=true)
public class OutsourceOrderInt {
	private List<SpubHdrsInt> spubHdrsInts = new ArrayList<SpubHdrsInt>();

	public OutsourceOrderInt() {
		super();
	}

	public OutsourceOrderInt(List<SpubHdrsInt> spubHdrsInts) {
		super();
		this.spubHdrsInts = spubHdrsInts;
	}

	@XmlElement(name = "SpubHdrsInt")
	public List<SpubHdrsInt> getSpubHdrsInts() {
		return spubHdrsInts;
	}

	public void setSpubHdrsInts(List<SpubHdrsInt> spubHdrsInts) {
		this.spubHdrsInts = spubHdrsInts;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((spubHdrsInts == null) ? 0 : spubHdrsInts.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OutsourceOrderInt other = (OutsourceOrderInt) obj;
		if (spubHdrsInts == null) {
			if (other.spubHdrsInts != null)
				return false;
		} else if (!spubHdrsInts.equals(other.spubHdrsInts))
			return false;
		return true;
	}

}
