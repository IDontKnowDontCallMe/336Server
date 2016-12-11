package businesslogic.promotionbl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import factory.DataFactory;
import vo.CalculationConditionVO;
import vo.CustomerVO;
import vo.WebPromotionVO;

public class WebPromotionImpl {

	private Map<String, WebPromotionType> webPromotionCache;
	
	public WebPromotionImpl() {
		// TODO Auto-generated constructor stub
		webPromotionCache = DataFactory.getPromotionDataService().getAllWebPromotionObject();
	}
	
	public double getDiscount(CalculationConditionVO calculationConditionVO, LocalDate checkInDate, CustomerVO customerVO){
		double result = 1;
		if(webPromotionCache==null || webPromotionCache.size()<1) return 1.0;
		for(Entry<String, WebPromotionType> entry: webPromotionCache.entrySet()){
			double temp = entry.getValue().calculateDiscount(calculationConditionVO, checkInDate, customerVO);
			if(temp<result){
				result = temp;
			}
		}
		
		return result;
	}

	public List<WebPromotionVO> getWebPromotionList() {
		
		List<WebPromotionVO> list = new ArrayList<WebPromotionVO>();
		
		for(Entry<String, WebPromotionType> entry: webPromotionCache.entrySet()){
			list.add(entry.getValue().toWebPromotionVO());
		}
		
		return list;
	}

	public boolean addWebPromotion(WebPromotionVO webPromotionVO) {
		WebPromotionType webPromotionType = WebPromotionFactory.creatWebPromotion(webPromotionVO);
		
		if(webPromotionType==null){
			return false;
		}
		
		if(webPromotionCache.containsKey(webPromotionVO.promotionType)){
			return false;
		}
		
		webPromotionCache.put(webPromotionVO.promotionType, webPromotionType);
		
		DataFactory.getPromotionDataService().writeWebPromotionObject(webPromotionType);
		
		return true;
	}

	public boolean updateWebPromotion(WebPromotionVO vo) {
		
		if(!webPromotionCache.containsKey(vo.promotionType)){
			return false;
		}
		
		WebPromotionType webPromotionType = WebPromotionFactory.creatWebPromotion(vo);
		webPromotionCache.replace(vo.promotionType, webPromotionType);
		
		DataFactory.getPromotionDataService().deleteWebPromotionObject(vo.promotionType);
		DataFactory.getPromotionDataService().writeWebPromotionObject(webPromotionType);
		
		return true;
	}

	public boolean deleteWebPromotion(WebPromotionVO vo) {
		
		if(!webPromotionCache.containsKey(vo.promotionType)){
			return false;
		}
		
		webPromotionCache.remove(vo.promotionType);
		DataFactory.getPromotionDataService().deleteWebPromotionObject(vo.promotionType);
		
		return true;
	}

	
}
