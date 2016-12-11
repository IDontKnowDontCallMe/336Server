package businesslogic.hotelbl;

import java.util.List;

import vo.HotelVO;

public class HotelSorter {

	private SimpleComparator comparator;
	
	public HotelSorter(String sortTarget) {
		// TODO Auto-generated constructor stub
		switch (sortTarget) {
		case "价格从高至低":
			comparator = new BigPriceComparator();
			break;
		case "价格从低至高":
			comparator = new SmallPriceComparator();
			break;
		case "星级从高至低":
			comparator = new BigScoreComparator();
			break;
		case "星级从低至高":
			comparator = new SmallScoreComparator();
			break;
		case "评分从高至低":
			comparator = new BigCommentComparator();
			break;
		default:
			comparator = new SmallCommentComparator();
			break;
		}
	}
	
	public List<HotelVO> sort(List<HotelVO> hotelList){
		for(int i=hotelList.size()-1; i > 0; i--){
			for(int j=0; j<i; j++){
				if(comparator.compare(hotelList.get(j), hotelList.get(j+1)) < 0){
					HotelVO tempHotelVO = new HotelVO(hotelList.get(j));
					hotelList.set(j, hotelList.get(j+1));
					hotelList.set(j+1, tempHotelVO);
				}
			}
		}
		return hotelList;
	}
	
	public abstract class SimpleComparator{
		abstract public int compare(HotelVO vo1, HotelVO vo2);
	}
	
	public class BigPriceComparator extends SimpleComparator{
		@Override
		public int compare(HotelVO vo1, HotelVO vo2) {
			// TODO Auto-generated method stub
			return vo1.minPrice > vo2.minPrice? 1: (vo1.minPrice < vo2.minPrice? -1: 0);
		}
	}
	
	public class SmallPriceComparator extends SimpleComparator{
		@Override
		public int compare(HotelVO vo1, HotelVO vo2) {
			// TODO Auto-generated method stub
			return vo1.minPrice < vo2.minPrice? 1: (vo1.minPrice > vo2.minPrice? -1: 0);
		}
	}
	
	public class BigScoreComparator extends SimpleComparator{
		@Override
		public int compare(HotelVO vo1, HotelVO vo2) {
			// TODO Auto-generated method stub
			return vo1.score > vo2.score? 1: (vo1.score < vo2.score? -1: 0);
		}	
	}
	
	public class SmallScoreComparator extends SimpleComparator{
		@Override
		public int compare(HotelVO vo1, HotelVO vo2) {
			// TODO Auto-generated method stub
			return vo1.score < vo2.score? 1: (vo1.score  > vo2.score? -1: 0);
		}	
	}
	
	public class BigCommentComparator extends SimpleComparator{
		@Override
		public int compare(HotelVO vo1, HotelVO vo2) {
			// TODO Auto-generated method stub
			return vo1.commentScore > vo2.commentScore? 1: (vo1.commentScore < vo2.commentScore? -1: 0);
		}
	}
	
	public class SmallCommentComparator extends SimpleComparator{
		@Override
		public int compare(HotelVO vo1, HotelVO vo2) {
			// TODO Auto-generated method stub
			return vo1.commentScore < vo2.commentScore? 1: (vo1.commentScore > vo2.commentScore? -1: 0);
		}
	}
	
}
