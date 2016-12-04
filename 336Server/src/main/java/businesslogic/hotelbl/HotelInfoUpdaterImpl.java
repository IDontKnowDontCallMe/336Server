package businesslogic.hotelbl;

import java.util.HashMap;
import java.util.Map;

import businesslogic.userbl.HotelInfoUpdater;
import factory.DataFactory;
import po.HotelPO;
import vo.HotelVO;

public class HotelInfoUpdaterImpl {

	public boolean updateSimpleInfo(HotelVO hotelVO){
		HotelPO hotelPO = DataFactory.getHotelDataService().getHotelInfo(hotelVO.hotelID);
		
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
	
	
}
