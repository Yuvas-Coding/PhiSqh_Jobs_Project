package my.com.cmg.iwp.maintenance.service.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.management.Query;

import org.hibernate.Session;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.FppDrugPrice;
import my.com.cmg.iwp.maintenance.service.FPPPriceService;
import my.com.cmg.iwp.webui.util.CommonUtil;

@Service
public class FPPPPriceServiceImpl implements FPPPriceService{

	private BasisNextidDaoImpl<FppDrugPrice> fppDrugPriceDAO;

	@Override
	public FppDrugPrice getNewFppDrugPrice() {
		return new FppDrugPrice();
	}

	@Override
	public void delete(FppDrugPrice anFppDrugPrice) {
		fppDrugPriceDAO.delete(anFppDrugPrice);
		
	}

	public BasisNextidDaoImpl<FppDrugPrice> getFppDrugPriceDAO() {
		return fppDrugPriceDAO;
	}

	public void setFppDrugPriceDAO(BasisNextidDaoImpl<FppDrugPrice> fppDrugPriceDAO) {
		this.fppDrugPriceDAO = fppDrugPriceDAO;
	}

	@Override
	public void saveOrUpdate(FppDrugPrice anFppDrugPrice) {
		fppDrugPriceDAO.saveOrUpdate(anFppDrugPrice);
		
	}
	
	@Override
	public String getPreviousFppDrugPrice(long drugSeqno){
		Session session = null;
		String value = "";
		
		try{
			session = fppDrugPriceDAO.getSessionFactory().openSession();
			Query query = session.createSQLQuery( "SELECT MAX(version_no) from t_fpp_drug_price where drug_seqno ="+drugSeqno );
			List list = query.list();
			value = list!=null && list.size() > 0 && list.get(0) !=null? list.get(0).toString():null;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			CommonUtil.closeSession(session);
		}
		return value;		
	}
	
	@Override
	public Long getEffectiveDrugPriceSeq(long drugSeqno){
		Session session = null;
		Long value = null;
		
		try{
			session = fppDrugPriceDAO.getSessionFactory().openSession();
			Query query = session.createSQLQuery( "SELECT MAX(FPP_DRUG_PRICE_SEQNO) "+
			" FROM T_FPP_DRUG_PRICE FDP INNER JOIN T_DRUGS DRUG ON FDP.DRUG_SEQNO=DRUG.DRUG_SEQNO "+
					"WHERE DRUG.DRUG_SEQNO ="+drugSeqno+" AND EFFECTIVE_DATE <= SYSDATE " );
			List list = query.list();
			value = (Long) (list!=null && list.size() > 0 && list.get(0) !=null? ((BigDecimal)list.get(0)).longValue():null);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			CommonUtil.closeSession(session);
		}
		return value;		
	}

}
