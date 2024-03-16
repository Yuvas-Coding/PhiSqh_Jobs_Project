package my.com.cmg.iwp.maintenance.service;

import java.util.List;

import my.com.cmg.iwp.maintenance.model.PoDtl;

public interface PoDtlService {

	List<PoDtl> getAllItemByPoHdrSeqNo(Long example);

}
