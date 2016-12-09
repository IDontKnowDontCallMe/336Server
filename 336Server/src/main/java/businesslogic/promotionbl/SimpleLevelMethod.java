package businesslogic.promotionbl;

import vo.LevelVO;

public class SimpleLevelMethod implements LevelMethod{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int creditDistance;
	private int maxLevel;
	
	public SimpleLevelMethod(LevelVO levelVO) {
		// TODO Auto-generated constructor stub
		this.creditDistance = levelVO.creditDistance;
		this.maxLevel = levelVO.maxLevel;
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

	@Override
	public LevelVO toLevelVO() {
		// TODO Auto-generated method stub
		return new LevelVO(creditDistance, maxLevel, -1);
	}

	
}
