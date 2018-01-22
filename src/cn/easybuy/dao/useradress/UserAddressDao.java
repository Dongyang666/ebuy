package cn.easybuy.dao.useradress;

import java.util.List;

import cn.easybuy.dao.IBaseDao;
import cn.easybuy.entity.UserAddress;
import cn.easybuy.param.UserAddressParam;

/**
 * addObject(UserAddress userAddress)
 * getRowList(params)
 */
public interface UserAddressDao extends IBaseDao<UserAddress> {
	
	public List<UserAddress> queryUserAddressList(UserAddressParam param);
	
	public boolean add(UserAddress userAddress);
	
	public UserAddress getUserAddressById(Integer addressId);

}
