package data.userdata;

import java.util.List;

import po.WebMarketerPO;

public interface WebMarketerDao {

	public boolean insertWebMarketer(WebMarketerPO po);

	public List<WebMarketerPO> getWebMarketerList();

	public boolean deleteWebMarketer(int webMarketerID);
	
}
