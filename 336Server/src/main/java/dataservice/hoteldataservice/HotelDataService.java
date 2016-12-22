package dataservice.hoteldataservice;

import java.util.List;
import java.util.Map;

import po.CommentPO;
import po.HotelPO;

/**
 * HotelData模块的接口
 * @author sjl
 *
 */

/**
 * @author USER
 *
 */
public interface HotelDataService {
	
	/**
	 * 根据city和businessCircle的值获得酒店信息的记录
	 * @param city
	 * @param businessCircle
	 * @return 一个包含符合条件的map，key是hotelID，value是对应一条的酒店信息记录
	 */
	public Map<Integer,HotelPO> getHotelListOfArea(String city, String businessCircle);
	
	/**
	 * 根据hotelID获得一条酒店信息的记录
	 * @param hotelID
	 * @return 一条酒店信息的记录
	 */
	public HotelPO getHotelInfo(int hotelID);
	
	/**
	 * 更新一个酒店工作人员的信息
	 * @param hotelPO
	 * @return 更新成功返回true，否则返回false
	 */
	public boolean updateWorker(HotelPO hotelPO);
	
	/**
	 * 更新一条酒店信息记录
	 * @param hotelPO
	 * @return 更新成功返回true，否则返回fasle
	 */
	public boolean updateHotel(HotelPO hotelPO);
	
	/**
	 * 添加一条酒店评论记录
	 * @param CommentPO
	 * @return 添加成功返回true，否则返回false
	 */
	public boolean addComment(CommentPO po);
	
	/**
	 * 获得一个酒店的评论的
	 * @param hotelID
	 * @return 包含该酒店的所有评论的列表
	 */
	public List<CommentPO> getCommentListOf(int hotelID);
	
	/**
	 * 添加一条酒店信息的记录
	 * @param hotelPO
	 * @return 添加成返回true，否则返回false
	 */
	public boolean addHotel(HotelPO hotelPO);
	
	/**
	 * 
	 * @return 酒店表中的记录的数量
	 */
	public int getHotelNum();
	
	/**
	 * @param hotelID
	 * @return 该酒店的图片文件的字节流
	 */
	public byte[] getHotelImage(int hotelID);
	
	/**
	 * @param hotelID
	 * @param imageDate 图片文件的字节流	
	 * @return 更新成功返回true，否则返回false
	 */
	public boolean saveHotelImage(int hotelID, byte[] imageDate);

}
