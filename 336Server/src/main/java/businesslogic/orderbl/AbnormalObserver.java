package businesslogic.orderbl;

import java.util.List;

import po.OrderPO;

public interface AbnormalObserver {

	public void update(List<OrderPO> changedOrderPO);
	
}
