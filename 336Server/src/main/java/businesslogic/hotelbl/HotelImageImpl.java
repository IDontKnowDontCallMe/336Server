package businesslogic.hotelbl;

import factory.DataFactory;

public class HotelImageImpl {
	
	public byte[] getHotelImage(int hotelID){
		
		byte[] result = DataFactory.getHotelDataService().getHotelImage(hotelID);
		
		return result;
	}
	
	public boolean saveHotelImage(int hotelID, byte[] imageData){
		
		return DataFactory.getHotelDataService().saveHotelImage(hotelID, imageData);
	}

}
