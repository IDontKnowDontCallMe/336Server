package businesslogic.promotionbl;

import vo.LevelVO;

public class SimpleLevelMethod implements LevelMethod{

	private int creditDistance;
	
	public SimpleLevelMethod(LevelVO levelVO) {
		// TODO Auto-generated constructor stub
		this.creditDistance = levelVO.creditDistance;
	}
	
	@Override
	public int calculateLevel(int credit) {
		// TODO Auto-generated method stub
		if(credit <= 0){
			return 0;
		}
		else {
			return credit/creditDistance;
		}
	}

	
}
