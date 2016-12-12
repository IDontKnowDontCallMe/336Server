package businesslogic.promotionbl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import factory.DataFactory;
import vo.CalculationConditionVO;
import vo.CustomerVO;
import vo.HotelPromotionVO;

public class HotelPromotionImpl {

	private Map<Integer, Map<String, HotelPromotionType>> hotelPromotionCache;
	
	public HotelPromotionImpl() {
		// TODO Auto-generated constructor stub
		hotelPromotionCache = DataFactory.getPromotionDataService().getAllHotelPromotion();
	}

	public double getDiscount(CalculationConditionVO calculationConditionVO, LocalDate checkInDate, CustomerVO customerVO){
		double result = 1;
		int hotelID = calculationConditionVO.hotelID;
		if(!hotelPromotionCache.containsKey(hotelID)){
			loadPromotionFromData(hotelID);
		}
		
		if(hotelPromotionCache.get(hotelID)==null || hotelPromotionCache.get(hotelID).size() < 1){
			return 1;
		}
		
		for(Entry<String, HotelPromotionType> entry: hotelPromotionCache.get(hotelID).entrySet()){
			double temp = entry.getValue().calculateDiscount(calculationConditionVO, checkInDate, customerVO);
			if(temp<result) result = temp;
		}
		return result;
	}
	
	public List<HotelPromotionVO> getHotelPromotionList(int hotelID) {
		if(!hotelPromotionCache.containsKey(hotelID)){
			loadPromotionFromData(hotelID);
		}
		
		List<HotelPromotionVO> list = new ArrayList<HotelPromotionVO>();
		
		for(Entry<String, HotelPromotionType> entry: hotelPromotionCache.get(hotelID).entrySet()){
			list.add(entry.getValue().toHotelPromotionVO());
		}
		
		return list;
	}

	public boolean addHotelPromotion(HotelPromotionVO vo) {
		if(!hotelPromotionCache.containsKey(vo.hotelID)){
			loadPromotionFromData(vo.hotelID);
		}
		
		if(hotelPromotionCache.get(vo.hotelID).containsKey(vo.promotionType)){
			return false;
		}
		
		HotelPromotionType hotelPromotionType = HotelPromotionFactory.creatHotelPromotion(vo);
		
		if(hotelPromotionType==null){
			return false;
		}
		
		hotelPromotionCache.get(vo.hotelID).put(vo.promotionType, hotelPromotionType);
		
		DataFactory.getPromotionDataService().writeHotelPromotionObject(vo.hotelID, hotelPromotionType);
		
		return true;
	}

	public boolean updateHotelPromotion(HotelPromotionVO vo) {
		if(!hotelPromotionCache.containsKey(vo.hotelID)){
			loadPromotionFromData(vo.hotelID);
		}
		
		if(!hotelPromotionCache.get(vo.hotelID).containsKey(vo.promotionType)){
			return false;
		}
		
		HotelPromotionType hotelPromotionType = HotelPromotionFactory.creatHotelPromotion(vo);
		
		if(hotelPromotionType==null){
			return false;
		}
		
		
		hotelPromotionCache.get(vo.hotelID).replace(vo.promotionType, hotelPromotionType);
		DataFactory.getPromotionDataService().deleteHotelPromotionObject(vo.hotelID, vo.promotionType);
		DataFactory.getPromotionDataService().writeHotelPromotionObject(vo.hotelID, hotelPromotionType);
		
		return true;
	}

	public boolean deleteHotelPromotion(HotelPromotionVO vo) {
		
		if(DataFactory.getPromotionDataService().deleteHotelPromotionObject(vo.hotelID, vo.promotionType)){
			hotelPromotionCache.get(vo.hotelID).remove(vo.promotionType);
			return true;
		}
		
		
		
		return false;
	}

	private void loadPromotionFromData(int hotelID){
		if(!hotelPromotionCache.containsKey(hotelID)){
			Map<String, HotelPromotionType> map = DataFactory.getPromotionDataService().getHotelPromotionObject(hotelID);
			hotelPromotionCache.put(hotelID, map);
		}
	}

}
