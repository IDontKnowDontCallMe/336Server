package businesslogic.hotelbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;

import factory.BLFactory;
import factory.DataFactory;
import po.CommentPO;
import po.HotelPO;
import vo.CommentVO;
import vo.HotelVO;
import vo.OrderVO;
import vo.RoomVO;

public class HotelDetailInfoImpl {

	
	//private HashMap<Integer, List<RoomVO>> roomListCache;
	//private Queue<Integer> hotelIDQueue;
	//private static final int maxCache = 220;
	//private static final int cleanTimes = 10;
	public HotelVO getHotelInfo(int hotelID){
		HotelPO hotelPO = DataFactory.getHotelDataService().getHotelInfo(hotelID);
		HotelVO hotelVO = new HotelVO(hotelPO.getHotelID(), hotelPO.getHotelName(), hotelPO.getCity(), hotelPO.getBusinessCircle(), hotelPO.getAddress(), hotelPO.getIntroduction(), hotelPO.getService(), hotelPO.getScore(), hotelPO.getCommentScore(), hotelPO.getWorkerName(), hotelPO.getPhoneNumber(), -1, -1);
		return hotelVO;
	}

	public List<RoomVO> getRoomListOfHotel(int hotelID) {
		List<RoomVO> result = null;
		
		result = BLFactory.getRoomBLService().getRoomTypeList(hotelID);
		
		return result;
	}


	public List<OrderVO> getOrderListOfHotel(int hotelID, int customerID) {
		List<OrderVO> result = BLFactory.getOrderBLService().getOrderListOfHotel(hotelID, customerID);
		return result;
	}


	public List<CommentVO> getCommentList(int hotelID) {
		List<CommentVO> result = new ArrayList<CommentVO>();
		List<CommentPO> commentPOs = DataFactory.getHotelDataService().getCommentListOf(hotelID);
		
		for(CommentPO po: commentPOs){
			CommentVO vo = new CommentVO(po.getHotelID(), po.getNameOfHotel(), po.getNameOfRoom(), po.getCustomerID(), po.getComment(), po.getScore(), po.getProducingDateTime());
			result.add(vo);
		}
		
		return result;
		
	}

	/************
	
	private void loadToRoomListCache(int hotelID){
		try {
			if(roomListCache.size() > maxCache){
				cleanSomeRoomListCache();
			}
			
			List<RoomVO> result = BLFactory.getRoomBLService().getRoomTypeList(hotelID);
			roomListCache.put(hotelID, result);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void cleanSomeRoomListCache(){
		for(int i=0; i < cleanTimes; i++){
			roomListCache.remove(hotelIDQueue.poll());
		}
	}
	
	
	************/
}
