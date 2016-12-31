package businesslogic.hotelbl;

import java.util.List;

import businesslogicservice.orderblservice.OrderBLService;
import factory.BLFactory;
import vo.CalculationConditionVO;
import vo.HotelVO;
import vo.RoomVO;
import vo.SearchConditionVO;

/**
 * 负责判断一个酒店是否符合客户的当前搜索条件的类
 * @author sjl
 *
 */
public class ConditionJudger {

	private SearchConditionVO searchConditionVO;
	private boolean hasLimit;
	public ConditionJudger(SearchConditionVO searchConditionVO) {
		// TODO Auto-generated constructor stub
		this.searchConditionVO = searchConditionVO;
		hasLimit = !searchConditionVO.hotelName.equals("") ||
				searchConditionVO.hasBookedLimit ||
				searchConditionVO.hasRoomTypeLimit ||
				searchConditionVO.hasDateLimit || 
				searchConditionVO.hasPriceLimit ||
				searchConditionVO.hasScoreLimit ||
				 searchConditionVO.hasCommentScoreLimit;
	}
	
	public boolean satisfyWith(HotelVO hotelVO){
		if(searchConditionVO.isInteractive){
			return interactiveJudge(hotelVO);
		}
		else{
			return uninteractiveJudge(hotelVO);
		}
	}
	
	/**
	 * 搜索条件起联合作用时，用此方法判断
	 * @param hotelVO
	 * @return 判断结果
	 */
	private boolean interactiveJudge(HotelVO hotelVO) {
		if(!hasLimit){
			return true;
		}
		
		return satisfyWithBookedLimit(hotelVO) && satisfyWithNameLimit(hotelVO) && satisfyWithRoomTypeLimit(hotelVO) &&
				satisfyWithDateLimit(hotelVO) && satisfyWithPriceLimit(hotelVO) && satisfyWithScoreLimit(hotelVO) && satisfyWithCommentLimit(hotelVO);
	}
	
	/**
	 * 搜索条件不起联合作用时，用此方法判断
	 * @param hotelVO
	 * @return 判断结果
	 */ 
	private boolean uninteractiveJudge(HotelVO hotelVO){
		if(!hasLimit){
			return true;
		}
				
		return ( !searchConditionVO.hotelName.equals("") && satisfyWithNameLimit(hotelVO) ) || 
			   ( searchConditionVO.hasBookedLimit && satisfyWithBookedLimit(hotelVO) ) || 
			   ( searchConditionVO.hasRoomTypeLimit && satisfyWithRoomTypeLimit(hotelVO) ) ||
			   ( searchConditionVO.hasDateLimit && satisfyWithDateLimit(hotelVO) ) || 
			   ( searchConditionVO.hasPriceLimit && satisfyWithPriceLimit(hotelVO) ) || 
			   ( searchConditionVO.hasScoreLimit && satisfyWithScoreLimit(hotelVO) ) || 
			   ( searchConditionVO.hasCommentScoreLimit && satisfyWithCommentLimit(hotelVO) ) ;
	}
	
	/**
	 * 判断酒店是否符合房间类型限制
	 * @param hotelVO
	 * @return
	 */
	private boolean satisfyWithRoomTypeLimit(HotelVO hotelVO){
		if(!searchConditionVO.hasRoomTypeLimit){
			return true;
		}
		
		List<RoomVO> roomList = null;
		roomList = BLFactory.getRoomBLService().getRoomTypeList(hotelVO.hotelID);
		
		if(roomList.size()<1) return false;
		
		for(RoomVO roomVO: roomList){
			if(searchConditionVO.peopleNumOfRoom <= roomVO.maxNumOfPeople){
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * 
	 * 判断酒店是否符合价格限制
	 * @param hotelVO
	 * @return
	 */
	private boolean satisfyWithPriceLimit(HotelVO hotelVO){
		if(!searchConditionVO.hasPriceLimit){
			return true;
		}
		
		List<RoomVO> roomList = null;
		roomList = BLFactory.getRoomBLService().getRoomTypeList(hotelVO.hotelID);
		
		for(RoomVO roomVO: roomList){
			if(searchConditionVO.minPrice<=roomVO.price && searchConditionVO.maxPrice >= roomVO.price){
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * 判断酒店是否符合入住时间限制
	 * @param hotelVO
	 * @return
	 */
	private boolean satisfyWithDateLimit(HotelVO hotelVO){
		if(!searchConditionVO.hasDateLimit){
			return true;
		}
		
		OrderBLService orderBLService = BLFactory.getOrderBLService();
		List<RoomVO> roomList = null;
		roomList = BLFactory.getRoomBLService().getRoomTypeList(hotelVO.hotelID);


		for(RoomVO roomVO: roomList){
			String tag = orderBLService.canBeProduced(new CalculationConditionVO(hotelVO.hotelID, roomVO.roomID, 23333, 
				searchConditionVO.checkInDate, searchConditionVO.checkOutDate, searchConditionVO.roomNum, 0, false, null, null));
			if(tag.equals("房间充足")){
				return true;
			}
		}
		
		return false;
		
	}
	
	/**
	 * 判断酒店是否符合评分限制
	 * @param hotelVO
	 * @return
	 */
	private boolean satisfyWithScoreLimit(HotelVO hotelVO){
		if(!searchConditionVO.hasScoreLimit){
			return true;
		}
		
		return searchConditionVO.minScore <= hotelVO.score;
	}
	
	private boolean satisfyWithCommentLimit(HotelVO hotelVO){
		if(!searchConditionVO.hasCommentScoreLimit){
			return true;
		}
		
		return searchConditionVO.minCommentScore <= hotelVO.commentScore;
	}
	
	private boolean satisfyWithBookedLimit(HotelVO hotelVO){
		if(!searchConditionVO.hasBookedLimit){
			return true;
		}
		
		if(hotelVO.bookedTag > 0){
			return true;
		}
		else{
			return false;
		}
	}
	
	private boolean satisfyWithNameLimit(HotelVO hotelVO){
		if(searchConditionVO.hotelName.equals("")){
			return true;
		}
		
		String[] keyword = searchConditionVO.hotelName.split(" ");
		
		for(String word: keyword){
			if (word.equals("")) {
				continue;
			}
			
			if(hotelVO.hotelName.contains(word)){
				return true;
			}
		}
		
		return false;
	}
	
}
