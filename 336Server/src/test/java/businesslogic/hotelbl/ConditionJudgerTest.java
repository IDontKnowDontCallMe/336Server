package businesslogic.hotel;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import vo.SearchConditionVO;

public class ConditionJudgerTest {



	@Test
	public void test1() {
		SearchConditionVO searchConditionVO = new SearchConditionVO(100000001, "", false, 1, true, 150, 300, false, null, null, 1, false, 0, false, 1, false, true);
	}

}
