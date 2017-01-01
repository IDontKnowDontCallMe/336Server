package businesslogic.roombl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import businesslogicservice.roomblservice.RoomBLService;
import factory.BLFactory;
import factory.DataFactory;
import vo.RoomVO;

public class RoomBLTest {

	private static RoomBLService roomBLService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		DataFactory.initDataFactory();
		BLFactory.initBLFactory();
		roomBLService = BLFactory.getRoomBLService();
	}

	@Test
	public void testGetRoomTypeList1() {
		List<RoomVO> list = roomBLService.getRoomTypeList(200000001);
		
		assertEquals(4, list.size());
	}
	
	@Test
	public void testGetRoomTypeList2() {
		List<RoomVO> list = roomBLService.getRoomTypeList(200000002);
		
		assertEquals(2, list.size());
	}
	
	@Test
	public void testGetRoomTypeList3() {
		List<RoomVO> list = roomBLService.getRoomTypeList(200000003);
		
		assertEquals(2, list.size());
	}
	
	@Test
	public void testGetRoomTypeList4() {
		List<RoomVO> list = roomBLService.getRoomTypeList(200000004);
		
		assertEquals(2, list.size());
	}
	
	@Test
	public void testGetRoomType1() {
		RoomVO roomVo = roomBLService.getRoomType(300000001);
		
		assertEquals("单人房", roomVo.roomName);
	}
	
	@Test
	public void testGetRoomType2() {
		RoomVO roomVo = roomBLService.getRoomType(300000012);
		
		assertEquals("最便宜的单人房", roomVo.roomName);
	}
	
	@Test
	public void testGetRoomType3() {
		RoomVO roomVo = roomBLService.getRoomType(400000012);
		
		assertNull(roomVo);
	}

}
