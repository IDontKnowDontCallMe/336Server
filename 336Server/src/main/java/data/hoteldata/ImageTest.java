package data.hoteldata;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.scene.image.Image;

public class ImageTest {

	public static void main(String[] args){
		
		ImageTest  imageTest = new ImageTest();
		imageTest.startwrite();
		
	}
	
	public void startwrite(){
		
		byte[] imageData =null;
		try {
			FileInputStream fileInputStream = new FileInputStream(getClass().getResource("noPicture.png").getFile());
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			byte[] buf = new byte[1024];
			int numBytesRead = 0;
			while ((numBytesRead = fileInputStream.read(buf)) != -1) {
			output.write(buf, 0, numBytesRead);
			}
			imageData = output.toByteArray();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HotelDaoImpl hotelDaoImpl = new HotelDaoImpl();
		
		for(int i=200000001; i<200000019; i++){
			hotelDaoImpl.saveHotelImage(i, imageData);
		}
	}
	
	
	
}
