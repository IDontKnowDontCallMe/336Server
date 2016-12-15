package businesslogic.hotelbl;

import java.util.List;

import businesslogicservice.orderblservice.OrderBLService;
import factory.BLFactory;
import vo.CalculationConditionVO;
import vo.HotelVO;
import vo.RoomVO;
import vo.SearchConditionVO;

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
	
	private boolean interactiveJudge(HotelVO hotelVO) {
		if(!hasLimit){
			return true;
		}
		
		return satisfyWithBookedLimit(hotelVO) && satisfyWithNameLimit(hotelVO) && satisfyWithRoomTypeLimit(hotelVO) &&
				satisfyWithDateLimit(hotelVO) && satisfyWithPriceLimit(hotelVO) && satisfyWithScoreLimit(hotelVO) && satisfyWithCommentLimit(hotelVO);
	}
	
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
