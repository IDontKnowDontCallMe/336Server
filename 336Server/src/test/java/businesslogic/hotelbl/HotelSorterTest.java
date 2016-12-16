package businesslogic.hotelbl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import businesslogic.hotelbl.HotelSorter;
import vo.HotelVO;

public class HotelSorterTest {

	HotelSorter hotelSorter1 = new HotelSorter("价格从高至低");
	HotelSorter hotelSorter2 = new HotelSorter("星级从高至低");
	HotelSorter hotelSorter3 = new HotelSorter("评分从高至低");
	
	List<HotelVO> list;

	@Before
	public void setUp() throws Exception {
		list = new ArrayList<HotelVO>();
		HotelVO vo1 = new HotelVO(1, "1", null, null, null, null, null, 1, 1, null, null, 100, -1);
		HotelVO vo2 = new HotelVO(2, "2", null, null, null, null, null, 5, 2.2, null, null, 600, -1);
		HotelVO vo3 = new HotelVO(3, "3", null, null, null, null, null, 2, 3.5, null, null, 300, -1);
		HotelVO vo4 = new HotelVO(4, "4", null, null, null, null, null, 3, 3.0, null, null, 400, -1);
		HotelVO vo5 = new HotelVO(5, "5", null, null, null, null, null, 1, 4.8, null, null, 200, -1);
		HotelVO vo6 = new HotelVO(6, "6", null, null, null, null, null, 4, 4.1, null, null, 666, -1);
		HotelVO vo7 = new HotelVO(7, "7", null, null, null, null, null, 5, 2.1, null, null, 450, -1);
		list.add(vo1);
		list.add(vo2);
		list.add(vo3);
		list.add(vo4);
		list.add(vo5);
		list.add(vo6);
		list.add(vo7);
	}

	@Test
	public void testSort1() {
		
		int[] expectation = {6,2,7,4,3,5,1};
		
		List<HotelVO> resultList = hotelSorter1.sort(list);
		
		int[] result = {resultList.get(0).hotelID,resultList.get(1).hotelID,resultList.get(2).hotelID,resultList.get(3).hotelID,resultList.get(4).hotelID,
							resultList.get(5).hotelID,resultList.get(6).hotelID};
		
		assertArrayEquals(expectation, result);
		
	}
	
	@Test
	public void testSort2() {
		
		int[] expectation = {2,7,6,4,3,1,5};
		
		List<HotelVO> resultList = hotelSorter2.sort(list);
		
		int[] result = {resultList.get(0).hotelID,resultList.get(1).hotelID,resultList.get(2).hotelID,resultList.get(3).hotelID,resultList.get(4).hotelID,
							resultList.get(5).hotelID,resultList.get(6).hotelID};
		
		assertArrayEquals(expectation, result);
		
	}
	
	@Test
	public void testSort3() {
		
		int[] expectation = {5,6,3,4,2,7,1};
		
		List<HotelVO> resultList = hotelSorter3.sort(list);
		
		int[] result = {resultList.get(0).hotelID,resultList.get(1).hotelID,resultList.get(2).hotelID,resultList.get(3).hotelID,resultList.get(4).hotelID,
							resultList.get(5).hotelID,resultList.get(6).hotelID};
		
		assertArrayEquals(expectation, result);
		
		
	}

}
