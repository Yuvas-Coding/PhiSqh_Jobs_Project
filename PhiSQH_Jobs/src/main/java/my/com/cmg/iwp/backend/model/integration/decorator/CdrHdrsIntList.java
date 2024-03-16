package my.com.cmg.iwp.backend.model.integration.decorator;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import my.com.cmg.iwp.backend.model.integration.cdr.CdrHdrInt;

@XmlRootElement(name = "CdrHdrsIntList")
public class CdrHdrsIntList {
	private List<CdrHdrInt> cdrHdrInts = new ArrayList<CdrHdrInt>();

	public CdrHdrsIntList() {
		super();
	}

	public CdrHdrsIntList(List<CdrHdrInt> aCdrHdrInts) {
		super();
		this.cdrHdrInts = aCdrHdrInts;
	}

	@XmlElement(name = "CdrHdrInt")
	public List<CdrHdrInt> getCdrHdrInts() {
		return cdrHdrInts;
	}

	public void setCdrHdrInts(List<CdrHdrInt> cdrHdrInts) {
		this.cdrHdrInts = cdrHdrInts;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((cdrHdrInts == null) ? 0 : cdrHdrInts.hashCode());
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
		CdrHdrsIntList other = (CdrHdrsIntList) obj;
		if (cdrHdrInts == null) {
			if (other.cdrHdrInts != null)
				return false;
		} else if (!cdrHdrInts.equals(other.cdrHdrInts))
			return false;
		return true;
	}
}
