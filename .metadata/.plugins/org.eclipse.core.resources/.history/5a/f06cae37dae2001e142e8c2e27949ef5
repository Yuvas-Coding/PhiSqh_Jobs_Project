package my.com.cmg.iwp.maintenance.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final public class SecTyp implements Serializable {
	private static final long serialVersionUID = 5129871978459891412L;
	final public static List<SecTyp> ALLTYPES;
	final private static Map<Integer, SecTyp> STDID_MAP;
	final public static SecTyp EMPTY_SECTYP = new SecTyp(-1, "");

	static {
		List<SecTyp> result = new ArrayList<SecTyp>();

		result.add(new SecTyp(00, "Page"));
		result.add(new SecTyp(11, "Menu Category"));
		result.add(new SecTyp(12, "Menu Item"));
		result.add(new SecTyp(13, "Method"));
		result.add(new SecTyp(14, "DomainObject/Property"));
		result.add(new SecTyp(15, "Tab"));
		result.add(new SecTyp(16, "Component"));

		ALLTYPES = Collections.unmodifiableList(result);
		STDID_MAP = new HashMap<Integer, SecTyp>(result.size());

		for (SecTyp secTyp : result) {
			STDID_MAP.put(Integer.valueOf(secTyp.stpId), secTyp);
		}
	}

	public static SecTyp getTypById(int typ_id) {
		return STDID_MAP.get(Integer.valueOf(typ_id));
	}

	final private int stpId;
	final private String stpTypname;

	private SecTyp(int stpId, String stp_typname) {
		this.stpId = stpId;
		this.stpTypname = stp_typname;

	}

	public int getStpId() {
		return stpId;
	}

	public String getStpTypname() {
		return stpTypname;
	}

	static public List<SecTyp> getAllTypes() {
		return ALLTYPES;
	}

	@Override
	public int hashCode() {
		return stpId;
	}

	public boolean equals(SecTyp secTyp) {
		return getStpId() == secTyp.getStpId();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj instanceof SecTyp) {
			SecTyp secTyp = (SecTyp) obj;
			return equals(secTyp);
		}

		return false;
	}
}
