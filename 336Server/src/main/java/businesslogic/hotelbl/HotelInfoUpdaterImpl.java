package businesslogic.hotelbl;

import factory.DataFactory;
import po.HotelPO;
import vo.HotelVO;

public class HotelInfoUpdaterImpl {

	public boolean updateSimpleInfo(HotelVO hotelVO){
		HotelPO hotelPO = DataFactory.getHotelDataService().getHotelInfo(hotelVO.hotelID);
		hotelPO.setHotelName(hotelVO.hotelName);
		hotelPO.setAddress(hotelVO.address);
		hotelPO.setScore(hotelVO.score);
		hotelPO.setIntroduction(hotelVO.introduction);
		hotelPO.setService(hotelVO.service);
		
		boolean updateTag =  DataFactory.getHotelDataService().updateHotel(hotelPO);
		
		if(updateTag){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean updateWorkerInfo(HotelVO hotelVO){
		HotelPO hotelPO = DataFactory.getHotelDataService().getHotelInfo(hotelVO.hotelID);
		
		hotelPO.setWorkerName(hotelVO.workerName);
		
		boolean updateTag =  DataFactory.getHotelDataService().updateWorker(hotelPO);
		
		if(updateTag){
			return true;
		}
		else{
			return false;
		}
		
	}
	
	public boolean addHotel(HotelVO hotelVO){
		int hotelID = DataFactory.getHotelDataService().getHotelNum() + 200000001;
		HotelPO hotelPO = new HotelPO(hotelID, hotelVO.hotelName, hotelVO.city, hotelVO.businessCircle, null, null, null, hotelVO.workerName, hotelVO.phoneNumber, 1, 0, -1, -1);
		return DataFactory.getHotelDataService().addHotel(hotelPO);
	}
	
	
}
