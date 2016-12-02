package data.userdata;

import java.util.List;

import po.HotelPO;

public interface HotelDao {
	
	public List<HotelPO> getHotelList();

	public HotelPO getHotel(int hotelID);

	public boolean deleteHotel(int hotelID);

	public boolean insertHotel(HotelPO po);
	
}
