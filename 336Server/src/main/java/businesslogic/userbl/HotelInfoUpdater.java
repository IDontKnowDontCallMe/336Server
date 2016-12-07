package businesslogic.userbl;

import vo.HotelVO;

public interface HotelInfoUpdater {

	public boolean updateWorkerInfo(HotelVO hotelVO);
	
	public boolean addHotel(HotelVO hotelVO);
	
}
