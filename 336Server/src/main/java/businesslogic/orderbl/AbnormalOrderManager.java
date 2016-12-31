package businesslogic.orderbl;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Timer;
import java.util.TimerTask;

import factory.BLFactory;
import factory.DataFactory;
import po.OrderPO;
import vo.CustomerVO;
import vo.OrderVO;

/**
 * 负责初始化、定时更新异常订单的类；也提供实时根据订单变化而改变的功能
 * @author sjl
 *
 */
public class AbnormalOrderManager implements AbnormalSubject{

	private Timer iniTimer;
	private Timer updateAbnormalTimer;
	private Map<Integer,OrderPO> todayAbnormal;
	private AbnormalObserver observer;
	
	public AbnormalOrderManager() {
		// TODO Auto-generated constructor stub
		observer = null;
		init();
		
		updateAbnormalTimer = new Timer(true);
		int hour = LocalTime.now().getHour() + 1;
		LocalDateTime nextHour = LocalDateTime.now().withHour(hour%24).withMinute(2);
		updateAbnormalTimer.schedule(new getNewAbnormalOrderTask(), Timestamp.valueOf(nextHour), 1000*60*60);
		
		iniTimer = new Timer(true);
		LocalDateTime tomorrow = LocalDateTime.now().plusDays(1).withHour(0).withMinute(1);
		iniTimer.schedule(new InitAbnormalManagerTask() , Timestamp.valueOf(tomorrow),1000*60*60*24);
	}
	
	private void init(){
		todayAbnormal = DataFactory.getOrderDataService().initAbnormalOrdersOfToday();
	}
	
	public List<OrderVO> getAbnormalList(){
		List<OrderVO> list = new ArrayList<>();
		
		if(todayAbnormal.size()>0){
			for(Entry<Integer, OrderPO> entry: todayAbnormal.entrySet()){
				CustomerVO customerVO = BLFactory.getCustomerBLService().getCustomerInfo(entry.getValue().getCustomerID());
				
				OrderVO vo = new OrderVO(entry.getValue().getOrderID(), customerVO.customerName, customerVO.customerID, customerVO.phoneNumber, entry.getValue().getProducingDateTime(), 
						entry.getValue().getHotelName(),  entry.getValue().getRoomName(), entry.getValue().getRoomNum(), entry.getValue().getPeopleNum(), entry.getValue().getHasChildren(), entry.getValue().getCheckInDate(), entry.getValue().getLatestArrivingTime(),
						entry.getValue().getCheckOutDate(), entry.getValue().getTotal(), entry.getValue().getOrderState(),entry.getValue().getHasComment());
				list.add(vo);
			}
		}
		return list;
	}
	
	public void removeRecoverdOrder(int orderID){
		if(todayAbnormal.containsKey(orderID)){
			todayAbnormal.remove(orderID);
		}
	}
	
	@Override
	public void addObserver(AbnormalObserver observer) {
		// TODO Auto-generated method stub
		this.observer = observer;
	}

	/**
	 * 初始化当日的异常订单，用于日期+1天时
	 * @author USER
	 *
	 */
	public class InitAbnormalManagerTask extends TimerTask{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("InitAbnormalManagerTask run");
			init();
		}
		
	}
	
	/**
	 * 从数据库中读新的被置为异常的订单
	 * @author USER
	 *
	 */
	public class getNewAbnormalOrderTask extends TimerTask{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("getNewAbnormalOrderTask run");
			List<OrderPO> list = DataFactory.getOrderDataService().getUnhandledAbnormalOrders();
			if(list.size()>0){
				List<OrderPO> poList = new ArrayList<OrderPO>();
				for(OrderPO orderPO: list){
					todayAbnormal.put(orderPO.getOrderID(), orderPO);
					poList.add(orderPO);
				}
				
				if(observer!=null){
					observer.update(poList);
				}
			}
		}
		
	}
	
}
