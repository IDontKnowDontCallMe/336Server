package businesslogic.hotelbl;

import java.util.List;

import factory.BLFactory;
import factory.DataFactory;
import po.CommentPO;
import po.HotelPO;
import vo.CommentVO;
import vo.HotelVO;

public class HotelCommentImpl {


	public boolean addComment(CommentVO commentVO) {
		CommentPO commentPO = new CommentPO(commentVO.hotelID, commentVO.hotelName, commentVO.roomName, commentVO.comment, commentVO.score,  commentVO.produingDateTime, commentVO.customerID);
		
		double commentScore = commentVO.score;
		int num = 1;
		List<CommentVO> commentList = BLFactory.getHotelBLService().getCommentList(commentVO.hotelID);
		
		if(commentList.size()>0){
			for(CommentVO vo : commentList){
				commentScore += vo.score;
				num++;
			}
		}
		
		commentScore = commentScore/num;
		
		HotelPO hotelPO = DataFactory.getHotelDataService().getHotelInfo(commentVO.hotelID);
		hotelPO.setCommentScore(commentScore);
		DataFactory.getHotelDataService().updateHotel(hotelPO);
		
	
		
		return DataFactory.getHotelDataService().addComment(commentPO);
	}

	public HotelVO getHotelInfoForWorker(int hotelID) {
		HotelPO hotelPO = DataFactory.getHotelDataService().getHotelInfo(hotelID);
		HotelVO hotelVO = new HotelVO(hotelPO.getHotelID(), hotelPO.getHotelName(), hotelPO.getCity(), hotelPO.getBusinessCircle(), hotelPO.getAddress(), hotelPO.getIntroduction(), hotelPO.getService(), hotelPO.getScore(), hotelPO.getCommentScore(), hotelPO.getWorkerName(), hotelPO.getPhoneNumber(), -1, -1);
		return hotelVO;
	}
	
}
