package my.com.cmg.iwp.backend.model.integration.decorator;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

import my.com.cmg.iwp.backend.model.integration.hqcontract.HqContractHdrsInt;

public class HqContractHdrsIntList {

	private final List<HqContractHdrsInt> hqContractHdrsInts = new ArrayList<HqContractHdrsInt>();
	private final List<Long> seqnos = new ArrayList<Long>();
	
	@XmlElement(name = "HqContractHdrsInt")
	public List<HqContractHdrsInt> getHqContractHdrsInts() {
		return this.hqContractHdrsInts;
	}

	@JsonIgnore
	public List<Long> getSeqnos() {
		return this.seqnos;
	}

}
