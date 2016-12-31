package businesslogic.orderbl;

import java.time.LocalDate;
import java.util.Map;
import java.util.Map.Entry;

import factory.BLFactory;
import factory.DataFactory;
import po.OrderPO;
import po.RoomPO;
import vo.CalculationConditionVO;
import vo.CustomerVO;
import vo.RoomVO;

/**
 * 用来判断一个order是否符合各项生成条件的类，并返回相应判断信息
 * @author USER
 *
 */
public class ValidOrderJudger {

	private int roomID;
	private int customerID;
	private LocalDate checkInDate;
	private LocalDate checkOutDate;
	private int num;
	private Map<Integer,OrderPO> orderPOs;
	
	public ValidOrderJudger(CalculationConditionVO calculationConditionVO, Map<Integer,OrderPO> orderPOs ) {
		// TODO Auto-generated constructor stub
		this.roomID = calculationConditionVO.roomID;
		this.customerID = calculationConditionVO.customerID;
		this.checkInDate = calculationConditionVO.startDate;
		this.checkOutDate = calculationConditionVO.endDate;
		this.num = calculationConditionVO.roomNum;
		this.orderPOs = orderPOs;
	}
	
	public String judge(){
		if(! creditIsValid()){
			return "信用值小于0";
		}
		
		System.out.println(roomID + " " + customerID + " " + checkInDate + " " + checkOutDate + " " + num + " " + orderPOs.size() );
		
		if(roomNumIsValid()){
			return "房间充足";
		}
		else{
			return "房间不足";
		}
	}
	
	private boolean creditIsValid(){
		CustomerVO customerVO = BLFactory.getCustomerBLService().getCustomerInfo(customerID);
		
		if(customerVO.credit > 0){
			return true;
		}
		else{
			return false;
		}
	}
	
	private boolean roomNumIsValid(){
		RoomPO roomVO = DataFactory.getRoomDataService().getRoomPO(roomID);
		
		int maxRoomNum = roomVO.getRoomNum();
		System.out.println(maxRoomNum);
		
		for(LocalDate i = checkInDate; i.isBefore(checkOutDate); i = i.plusDays(1)){
			int usedRoomNum = 0;
			
			if(orderPOs.size()>0){
				for(Entry<Integer, OrderPO> entry: orderPOs.entrySet()){
					if(isUsed(entry.getValue(), roomVO) && inDateInterval(entry.getValue(), i)){
						usedRoomNum += entry.getValue().getRoomNum();
						System.out.println("order's room match the room to be booked");
					}
				}
				System.out.println(usedRoomNum);
				if(maxRoomNum - usedRoomNum < num){
					return false;
				}
			}
		}
		
		return num<=maxRoomNum;
	}
	
	/**
	 * 判断此订单的房型是否是该roomVO的房型
	 * @param orderPO
	 * @param roomVO
	 * @return
	 */
	private boolean isUsed(OrderPO orderPO ,RoomPO roomVO){
		return  orderPO.getHotelID() == roomVO.getHotelID() && orderPO.getRoomName().equals(roomVO.getRoomName()) &&
				( orderPO.getOrderState().equals("正常") || orderPO.getOrderState().equals("已执行未离店") );
	}
	
	/**
	 * 判断此订单的入住离店时间区间是否包含了该date
	 * @param po
	 * @param date
	 * @return
	 */
	private boolean inDateInterval(OrderPO po, LocalDate date){
		return (po.getCheckInDate().isBefore(date) || po.getCheckInDate().isEqual(date)) && po.getCheckOutDate().isAfter(date);
	}
	
}
