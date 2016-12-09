package businesslogic.promotionbl;

import java.io.Serializable;

import vo.LevelVO;

public interface LevelMethod extends Serializable{

	public int calculateLevel(int credit);
	
	public LevelVO toLevelVO();
	
}
