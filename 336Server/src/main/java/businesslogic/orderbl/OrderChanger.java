package businesslogic.orderbl;

import java.time.LocalDateTime;

import factory.BLFactory;
import data.factory.DataFactory;
import po.OrderPO;
import vo.CreditVO;

/**
 * 提供改变订单状态功能的类；包装了改变状态后相应要执行的后续动作
 * @author sjl
 *
 */
public class OrderChanger {

	private OrderPO orderPO;
	private String targetState;
	
	
	public OrderChanger(int orderID, String state) {
		// TODO Auto-generated constructor stub
		orderPO = DataFactory.getOrderDataService().getOrderInfo(orderID);
		targetState = state;
	}
	
	public OrderPO change(){
		
		if(orderPO.getOrderState().equals("正常")){
			switch (targetState) {
			
			case "已执行未离店":
				normalToExecuted();
				break;
				
			case "已撤销":
				normalToRevoked();
				break;
				
			case "异常":
				normalToAbnormal();
				break;

			default:
				break;
			}
			
			return orderPO;
		}
		else if(orderPO.getOrderState().equals("异常")){
			if(targetState.equals("已执行")){
				abnormalToExecuted();
			}
			else{
				abnormalToRevoked();
			}
			return orderPO;
		}
		else if(orderPO.getOrderState().equals("已执行未离店")){
			if(targetState.equals("已执行已离店")){
				executedToLeaving();
			}
			
			return orderPO;
		}
		if(orderPO.getOrderState().equals("已执行未离店") || orderPO.getOrderState().equals("已执行已离店")){
			executedToCommented();
			
			return orderPO;
		}
		else{
			return null;
		}
		
	}
	
	private void normalToExecuted(){
		orderPO.setExecutingDateTime(LocalDateTime.now());
		orderPO.setOrderState("已执行未离店");
		DataFactory.getOrderDataService().updateOrder(orderPO);
		
		CreditVO creditVO = new CreditVO(orderPO.getCustomerID(), LocalDateTime.now(), String.valueOf(orderPO.getOrderID()), "订单成功执行", orderPO.getTotal(), -1);
		
		BLFactory.getCustomerBLService().addCreditRecord(creditVO);
	}
	
	private void normalToRevoked(){
		orderPO.setRevokingDateTime(LocalDateTime.now());
		orderPO.setOrderState("已撤销");
		DataFactory.getOrderDataService().updateOrder(orderPO);
		
		if(LocalDateTime.now().plusHours(6).isAfter(LocalDateTime.of(orderPO.getCheckInDate(), orderPO.getLatestArrivingTime()))){
			CreditVO creditVO = new CreditVO(orderPO.getCustomerID(), LocalDateTime.now(), String.valueOf(orderPO.getOrderID()), "撤销不及6小时执行的订单", - orderPO.getTotal()/2, -1);
			
			BLFactory.getCustomerBLService().addCreditRecord(creditVO);
		}
	}
	
	private void normalToAbnormal(){
		orderPO.setOrderState("异常");
		DataFactory.getOrderDataService().updateOrder(orderPO);
		
		CreditVO creditVO = new CreditVO(orderPO.getCustomerID(), LocalDateTime.now(), String.valueOf(orderPO.getOrderID()), "订单异常未执行", - orderPO.getTotal(), -1);
		
		BLFactory.getCustomerBLService().addCreditRecord(creditVO);
	}
	
	private void abnormalToExecuted(){
		orderPO.setExecutingDateTime(LocalDateTime.now());
		orderPO.setOrderState("已执行未离店");
		DataFactory.getOrderDataService().updateOrder(orderPO);
		
		CreditVO creditVO = new CreditVO(orderPO.getCustomerID(), LocalDateTime.now(), String.valueOf(orderPO.getOrderID()), "延期入住", orderPO.getTotal(), -1);
		
		BLFactory.getCustomerBLService().addCreditRecord(creditVO);
	}
	
	private void abnormalToRevoked(){
		orderPO.setRevokingDateTime(LocalDateTime.now());
		orderPO.setOrderState("已撤销");
		DataFactory.getOrderDataService().updateOrder(orderPO);
		
		if(targetState.equals("一半")){
			CreditVO creditVO = new CreditVO(orderPO.getCustomerID(), LocalDateTime.now(), String.valueOf(orderPO.getOrderID()), "申诉成功恢复一半", orderPO.getTotal()/2, -1);
			
			BLFactory.getCustomerBLService().addCreditRecord(creditVO);
		}
		else if(targetState.equals("全部")){
			CreditVO creditVO = new CreditVO(orderPO.getCustomerID(), LocalDateTime.now(), String.valueOf(orderPO.getOrderID()), "申诉成功恢复全部", orderPO.getTotal(), -1);
			
			BLFactory.getCustomerBLService().addCreditRecord(creditVO);
		}
	}
	
	private void executedToLeaving(){
		orderPO.setOrderState("已执行已离店");
		orderPO.setLeavingDateTime(LocalDateTime.now());
		DataFactory.getOrderDataService().updateOrder(orderPO);
	}
	
	private void executedToCommented(){
		orderPO.setHasComment(true);
		DataFactory.getOrderDataService().updateOrder(orderPO);
	}
	
}
