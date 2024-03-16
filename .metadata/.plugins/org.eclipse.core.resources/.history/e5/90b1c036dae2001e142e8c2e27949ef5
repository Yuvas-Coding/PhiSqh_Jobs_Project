package my.com.cmg.iwp.backend.model.integration.decorator;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import my.com.cmg.iwp.backend.model.integration.spub.SpubCorInt;

@XmlRootElement(name = "SpubCorIntList")
public class SpubCorIntList {
	private List<SpubCorInt> spubCorInts = new ArrayList<SpubCorInt>();

	public SpubCorIntList() {
		super();
	}

	public SpubCorIntList(List<SpubCorInt> spubCorInts) {
		super();
		this.spubCorInts = spubCorInts;
	}

	@XmlElement(name = "SpubCorInt")
	public List<SpubCorInt> getSpubCorInts() {
		return spubCorInts;
	}

	public void setSpubCorInts(List<SpubCorInt> spubCorInts) {
		this.spubCorInts = spubCorInts;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((spubCorInts == null) ? 0 : spubCorInts.hashCode());
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
		SpubCorIntList other = (SpubCorIntList) obj;
		if (spubCorInts == null) {
			if (other.spubCorInts != null)
				return false;
		} else if (!spubCorInts.equals(other.spubCorInts))
			return false;
		return true;
	}

}
