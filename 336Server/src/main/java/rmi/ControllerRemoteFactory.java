package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.util.List;
import businesslogicservice.customerblservice.CustomerBLService;
import businesslogicservice.hotelblservice.HotelBLService;
import businesslogicservice.orderblservice.OrderBLService;
import businesslogicservice.promotionblservice.PromotionBLService;
import businesslogicservice.roomblservice.RoomBLService;
import businesslogicservice.userblservice.UserBLService;
import factory.BLFactory;
import vo.AreaVO;
import vo.CalculationConditionVO;
import vo.CommentVO;
import vo.CreditVO;
import vo.CustomerVO;
import vo.HotelPromotionVO;
import vo.HotelVO;
import vo.LevelVO;
import vo.OrderVO;
import vo.RoomVO;
import vo.SearchConditionVO;
import vo.WebMarketerVO;
import vo.WebPromotionVO;

public class ControllerRemoteFactory extends UnicastRemoteObject implements RemoteCustomerService, RemoteHotelBLService, RemoteOrderBLService, RemotePromotionBLService, RemoteRoomBLService, RemoteUserBLService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CustomerBLService customerBLService;
	private OrderBLService orderBLService;
	private HotelBLService hotelBLService;
	private PromotionBLService promotioniBLService;
	private RoomBLService roomBLService;
	private UserBLService userBLService;
	
	public ControllerRemoteFactory() throws RemoteException {
		customerBLService = BLFactory.getCustomerBLService();
		hotelBLService = BLFactory.getHotelBLService();
		promotioniBLService = BLFactory.getPromotionBLService();
		roomBLService = BLFactory.getRoomBLService();
		orderBLService = BLFactory.getOrderBLService();
		userBLService = BLFactory.getUserBLService();
	}


	@Override
	public List<CustomerVO> getCustomerList() throws RemoteException {
		// TODO Auto-generated method stub
		List<CustomerVO> list = userBLService.getCustomerList();
		return list;
	}

	@Override
	public boolean updateCustomer(CustomerVO customerVO) throws RemoteException {
		// TODO Auto-generated method stub
		boolean updateTag = userBLService.updateCustomer(customerVO);
		return updateTag;
	}

	@Override
	public List<HotelVO> getHotelList() throws RemoteException {
		// TODO Auto-generated method stub
		List<HotelVO> list = userBLService.getHotelList();
		return list;
	}

	@Override
	public boolean addHotel(HotelVO hotelVO) throws RemoteException {
		// TODO Auto-generated method stub
		boolean addTag = userBLService.addHotel(hotelVO);
		return addTag;
	}

	@Override
	public boolean updateHotelWorker(HotelVO hotelVO) throws RemoteException {
		// TODO Auto-generated method stub
		boolean updateTag = userBLService.updateHotelWorker(hotelVO);
		return updateTag;
	}

	@Override
	public List<WebMarketerVO> getWebMarketerList() throws RemoteException {
		// TODO Auto-generated method stub
		List<WebMarketerVO> list = userBLService.getWebMarketerList();
		return list;
	}

	@Override
	public boolean addWebMarketer(WebMarketerVO webMarketerVO) throws RemoteException {
		// TODO Auto-generated method stub
		boolean addTag = userBLService.addWebMarketer(webMarketerVO);
		return addTag;
	}

	@Override
	public boolean updateWebMarketer(WebMarketerVO webMarketerVO) throws RemoteException {
		// TODO Auto-generated method stub
		boolean updateTag = userBLService.updateWebMarketer(webMarketerVO);
		return updateTag;
	}

	@Override
	public boolean updateCreditOfCustomer(int customerID, int delta) {
		// TODO Auto-generated method stub
		boolean updateTag = userBLService.updateCreditOfCustomer(customerID, delta);
		return updateTag;
	}

	@Override
	public String login(int userID, String password) throws RemoteException {
		// TODO Auto-generated method stub
		String loginTag = userBLService.login(userID, password);
		return loginTag;
	}

	@Override
	public boolean addRoomType(int hotelID, RoomVO roomVO) throws RemoteException {
		// TODO Auto-generated method stub
		boolean addTag = roomBLService.addRoomType(hotelID, roomVO);
		return addTag;
	}

	@Override
	public List<RoomVO> getRoomTypeList(int hotelID) throws RemoteException {
		// TODO Auto-generated method stub
		List<RoomVO> list = roomBLService.getRoomTypeList(hotelID);
		return list;
	}

	@Override
	public RoomVO getRoomType(int roomID) {
		// TODO Auto-generated method stub
		RoomVO roomVO = roomBLService.getRoomType(roomID);
		return roomVO;
	}

	@Override
	public List<HotelPromotionVO> getHotelPromotionList(int hotelID) throws RemoteException {
		// TODO Auto-generated method stub
		List<HotelPromotionVO> list = promotioniBLService.getHotelPromotionList(hotelID);
		return list;
	}

	@Override
	public boolean addHotelPromotion(HotelPromotionVO hotelPromotionVO) throws RemoteException {
		// TODO Auto-generated method stub
		boolean addTag = promotioniBLService.addHotelPromotion(hotelPromotionVO);
		return addTag;
	}

	@Override
	public boolean updateHotelPromotion(HotelPromotionVO hotelPromotionVO) throws RemoteException {
		// TODO Auto-generated method stub
		boolean updateTag = promotioniBLService.updateHotelPromotion(hotelPromotionVO);
		return updateTag;
	}

	@Override
	public boolean deleteHotelPromotion(HotelPromotionVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		boolean deleteTag = promotioniBLService.deleteHotelPromotion(vo);
		return deleteTag;
	}

	@Override
	public List<WebPromotionVO> getWebPromotionList() throws RemoteException {
		// TODO Auto-generated method stub
		List<WebPromotionVO> list = promotioniBLService.getWebPromotionList();
		return list;
	}

	@Override
	public boolean addWebPromotion(WebPromotionVO webPromotionVO) throws RemoteException {
		// TODO Auto-generated method stub
		boolean addTag = promotioniBLService.addWebPromotion(webPromotionVO);
		return addTag;
	}

	@Override
	public boolean updateWebPromotion(WebPromotionVO webPromotionVO) throws RemoteException {
		// TODO Auto-generated method stub
		boolean updateTag = promotioniBLService.updateWebPromotion(webPromotionVO);
		return updateTag;
	}

	@Override
	public boolean deleteWebPromotion(WebPromotionVO webPromotionVO) throws RemoteException {
		// TODO Auto-generated method stub
		boolean deleteTag = promotioniBLService.deleteWebPromotion(webPromotionVO);
		return deleteTag;
	}

	@Override
	public int calculateOrder(CalculationConditionVO calculationConditionVO, CustomerVO customerVO) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int calculateLevel(int credit) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<OrderVO> getCustomerOrder(int customerID) throws RemoteException {
		// TODO Auto-generated method stub
		List<OrderVO> list = orderBLService.getCustomerOrder(customerID);
		return list;
	}

	@Override
	public List<OrderVO> getHotelOrder(int hotelID) throws RemoteException {
		// TODO Auto-generated method stub
		List<OrderVO> list = orderBLService.getHotelOrder(hotelID);
		return list;
	}

	@Override
	public List<OrderVO> getAbnormalOrdersOfToday() throws RemoteException {
		// TODO Auto-generated method stub
		List<OrderVO> list = orderBLService.getAbnormalOrdersOfToday();
		return list;
	}

	@Override
	public List<OrderVO> filterCustomerList(int customerID, String state) throws RemoteException {
		// TODO Auto-generated method stub
		List<OrderVO> list = orderBLService.filterCustomerList(customerID, state);
		return list;
	}

	@Override
	public List<OrderVO> filterHotelList(int hotelID, String state) throws RemoteException {
		// TODO Auto-generated method stub
		List<OrderVO> list = orderBLService.filterHotelList(hotelID, state);
		return list;
	}

	@Override
	public int calculateTotal(CalculationConditionVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		int total = orderBLService.calculateTotal(vo);
		return total;
	}

	@Override
	public String canBeProduced(CalculationConditionVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		String tag = orderBLService.canBeProduced(vo);
		return tag;
	}

	@Override
	public boolean produceOrder(OrderVO orderVO, CalculationConditionVO calculationConditionVO) throws RemoteException {
		// TODO Auto-generated method stub
		boolean produceTag = orderBLService.produceOrder(orderVO, calculationConditionVO);
		return produceTag;
	}

	@Override
	public boolean changeOrderState(int orderID, String state) throws RemoteException {
		// TODO Auto-generated method stub
		boolean changeTag = orderBLService.changeOrderState(orderID, state);
		return changeTag;
	}

	@Override
	public List<HotelVO> getHotelVOsOfArea(AreaVO areaVO, int customerID) throws RemoteException{
		// TODO Auto-generated method stub
		List<HotelVO> list = hotelBLService.getHotelVOsOfArea(areaVO, customerID);
		return list;
	}

	@Override
	public List<HotelVO> search(AreaVO areaVO, SearchConditionVO searchCondionVO) throws RemoteException{
		// TODO Auto-generated method stub
		List<HotelVO> list = hotelBLService.search(areaVO, searchCondionVO);
		return list;
	}

	@Override
	public List<HotelVO> sort(int customerID, String sortType) throws RemoteException{
		// TODO Auto-generated method stub
		List<HotelVO> list =hotelBLService.sort(customerID, sortType);
		return list;
	}

	@Override
	public List<RoomVO> getRoomListOfHotel(int hotelID) throws RemoteException{
		// TODO Auto-generated method stub
		List<RoomVO> list = hotelBLService.getRoomListOfHotel(hotelID);
		return list;
	}

	@Override
	public List<OrderVO> getOrderListOfHotel(int hotelID, int customerID) throws RemoteException{
		// TODO Auto-generated method stub
		List<OrderVO> list = hotelBLService.getOrderListOfHotel(hotelID, customerID);
		return list;
	}

	@Override
	public List<HotelVO> getBookedHotelList(int customerID) throws RemoteException{
		// TODO Auto-generated method stub
		List<HotelVO> list = hotelBLService.getBookedHotelList(customerID);
		return list;
	}

	@Override
	public List<CommentVO> getCommentList(int hotelID) throws RemoteException{
		// TODO Auto-generated method stub
		List<CommentVO> list = hotelBLService.getCommentList(hotelID);
		return list;
	}

	@Override
	public boolean updateSimpleHotelInfo(HotelVO hotelVO) throws RemoteException{
		// TODO Auto-generated method stub
		boolean updateTag = hotelBLService.updateSimpleHotelInfo(hotelVO);
		return updateTag;
	}

	@Override
	public boolean addComment(CommentVO commentVO) throws RemoteException{
		// TODO Auto-generated method stub
		boolean addTag = hotelBLService.addComment(commentVO);
		return addTag;
	}

	@Override
	public HotelVO getHotelInfo(int hotelID) throws RemoteException{
		// TODO Auto-generated method stub
		HotelVO hotelVO = hotelBLService.getHotelInfo(hotelID);
		return hotelVO;
	}

	@Override
	public boolean update(HotelVO hotelVO) throws RemoteException{
		// TODO Auto-generated method stub
		boolean addTag = hotelBLService.update(hotelVO);
		return addTag;
	}

	@Override
	public boolean delete(HotelVO hotelVO) throws RemoteException{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CustomerVO getCustomerInfo(int customerID) throws RemoteException{
		// TODO Auto-generated method stub
		CustomerVO customerVO = customerBLService.getCustomerInfo(customerID);
		return customerVO;
	}

	@Override
	public boolean updateCustomerInfo(CustomerVO customerVO) throws RemoteException{
		// TODO Auto-generated method stub
		boolean updateTag = customerBLService.updateCustomerInfo(customerVO);
		return updateTag;
	}

	@Override
	public List<CreditVO> getCreditList(int customerID) throws RemoteException{
		// TODO Auto-generated method stub
		List<CreditVO> list = customerBLService.getCreditList(customerID);
		return list;
	}

	@Override
	public boolean registerBirthVIP(int customerID, LocalDate birthday) throws RemoteException{
		// TODO Auto-generated method stub
		boolean registerTag = customerBLService.registerBirthVIP(customerID, birthday);
		return registerTag;
	}

	@Override
	public boolean registerCompanyVIP(int customerID, String companyName) throws RemoteException {
		// TODO Auto-generated method stub
		boolean registerTag = customerBLService.registerCompanyVIP(customerID, companyName);
		return registerTag;
	}


	@Override
	public boolean addCustomer(CustomerVO customervo) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public List<Integer> getBookedHotelidOf(int customerID) throws RemoteException{
		// TODO Auto-generated method stub
		return orderBLService.getBookedHotelidOf(customerID);
	}


	@Override
	public int getBookedTag(int customerID, int hotelID) throws RemoteException{
		// TODO Auto-generated method stub
		return orderBLService.getBookedTag(customerID, hotelID);
	}


	@Override
	public boolean updateLevelMethod(LevelVO levelVO) throws RemoteException {
		// TODO Auto-generated method stub
		boolean updateTag = promotioniBLService.updateLevelMethod(levelVO);
		return updateTag;
	}


	@Override
	public boolean updateLevelPromotion(LevelVO levelVO) throws RemoteException {
		// TODO Auto-generated method stub
		boolean updateTag = promotioniBLService.updateLevelPromotion(levelVO);
		return updateTag;
	}


	@Override
	public LevelVO getLevelMethod() throws RemoteException {
		// TODO Auto-generated method stub
		LevelVO levelVO = promotioniBLService.getLevelMethod();
		return levelVO;
	}


	@Override
	public LevelVO getLevelPromotion() throws RemoteException {
		// TODO Auto-generated method stub
		LevelVO levelVO = promotioniBLService.getLevelPromotion();
		return levelVO;
	}


	@Override
	public int getHotelIDbyOrderID(int orderID) throws RemoteException {
		// TODO Auto-generated method stub
		int hotelID = hotelBLService.getHotelIDbyOrderID(orderID);
		return hotelID;
	}


	@Override
	public int register(String customerName, String phoneNumber, String password) throws RemoteException {
		// TODO Auto-generated method stub
		int id = userBLService.register(customerName, phoneNumber, password);
		return id;
	}


	@Override
	public void survivalConfirm(int userID) throws RemoteException {
		// TODO Auto-generated method stub
		userBLService.survivalConfirm(userID);
	}


	@Override
	public byte[] getHotelImage(int hotelID) throws RemoteException {
		// TODO Auto-generated method stub
		byte[] imageData = hotelBLService.getHotelImage(hotelID);
		return imageData;
	}


	@Override
	public boolean saveHotelImage(int hotelID, byte[] imageData) throws RemoteException {
		// TODO Auto-generated method stub
		boolean saveResult = hotelBLService.saveHotelImage(hotelID, imageData);
		return saveResult;
	}


	@Override
	public void changePassword(int userID, String newPassword) throws RemoteException {
		// TODO Auto-generated method stub
		userBLService.changePassword(userID, newPassword);
	}

}
