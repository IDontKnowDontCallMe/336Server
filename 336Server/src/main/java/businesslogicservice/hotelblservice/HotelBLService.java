package businesslogicservice.hotelblservice;

import java.util.List;

import vo.AreaVO;
import vo.CommentVO;
import vo.HotelVO;
import vo.OrderVO;
import vo.RoomVO;
import vo.SearchConditionVO;

/**
 * HotelBL模块提供的接口
 * @author tx
 *
 */
public interface HotelBLService {

	/**
	 * 获得某地区（城市-商圈）的酒店列表
	 * @param areaVO
	 * @param customerID
	 * @return 该地区的所有酒店的列表
	 */
	public List<HotelVO> getHotelVOsOfArea(AreaVO areaVO, int customerID);

	/**
	 * 搜索酒店
	 * @param areaVO
	 * @param searchCondionVO 搜索的限定条件
	 * @return 该地区的符合搜索条件的酒店的列表
	 */
	public List<HotelVO> search(AreaVO areaVO,SearchConditionVO searchCondionVO) ;
	
	/**
	 * 对搜索结果进行排序
	 * @param customerID 
	 * @param sortType 指示排序的标准，有：“价格从高至低”；“价格从低至高”；“评分从高至低”；“评分从低至高”；“星级从高至低”；“星级从低至高”
	 * @return 经排序的酒店列表
	 */
	public List<HotelVO> sort(int customerID, String sortType) ;
	
	/**
	 * 获得某酒店的房型列表
	 * @param hotelID
	 * @return 某酒店的房型列表
	 */
	public List<RoomVO>   getRoomListOfHotel(int hotelID) ;
	
	/**
	 * 获得该客户在该酒店预订过的订单
	 * @param hotelID
	 * @param customerID
	 * @return 该客户在该酒店预订过的订单
	 */
	public List<OrderVO> getOrderListOfHotel(int hotelID, int customerID);
	
	/**
	 * 获得该客户预定过的酒店的列表
	 * @param customerID
	 * @return 该客户预定过的酒店的列表
	 */
	public List<HotelVO> getBookedHotelList(int customerID);
	
	/**
	 * 获得该酒店的评价列表
	 * @param hotelID
	 * @return 该酒店的评价列表
	 */
	public List<CommentVO> getCommentList(int hotelID) ;
	
	/**
	 * 更新该酒店的基本信息
	 * @param hotelVO
	 * @return 更新成功返回true，否则返回false
	 */
	public boolean updateSimpleHotelInfo(HotelVO hotelVO) ;
	
	/**
	 * 添加酒店评论
	 * @param commentVO
	 * @return 添加成功返回true，否则返回false
	 */
	public boolean addComment(CommentVO commentVO) ;

	/**
	 * 获得酒店的信息
	 * @param hotelID
	 * @return 酒店的信息
	 */
	public HotelVO getHotelInfo(int hotelID) ;
	
	/**
	 * 获得订单对应的酒店的ID
	 * @param orderID
	 * @return 订单对应的酒店的ID
	 */
	public int getHotelIDbyOrderID(int orderID);

	/**
	 * 更新该酒店的基本信息
	 * @param hotelVO
	 * @return 更新成功返回true，否则返回false
	 */
	public boolean update(HotelVO hotelVO) ;

	public boolean delete(HotelVO hotelVO);
	
	/**
	 * 获得该酒店的图片的字节流
	 * @param hotelID
	 * @return 该酒店的图片的字节流
	 */
	public byte[] getHotelImage(int hotelID);
	
	/**
	 * 保存、更新酒店的图片
	 * @param hotelID
	 * @param imageData
	 * @return 更新成功返回true，否则返回false
	 */
	public boolean saveHotelImage(int hotelID, byte[] imageData);
	
}
