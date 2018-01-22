package cn.easybuy.service.user;

import cn.easybuy.dao.useradress.UserAddressDao;
import cn.easybuy.dao.useradress.UserAddressDaoImpl;
import cn.easybuy.entity.UserAddress;
import cn.easybuy.param.UserAddressParam;
import java.util.List;


public class UserAddressServiceImpl implements UserAddressService {
	UserAddressDao userAddressDao = new UserAddressDaoImpl();
    /**
     * 查询用户地址列表
     *
     * @param id
     * @return
     * @throws Exception
     */
    public List<UserAddress> queryUserAdressList(Integer id) throws Exception{
        List<UserAddress> userAddressList = null;
        try {
            UserAddressParam params = new UserAddressParam();
            params.setUserId(id);
            userAddressList = userAddressDao.queryUserAddressList(params);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
        }
        return userAddressList;
    }
    /**
     * 添加用户地址
     *
     * @param id
     * @param address
     * @return 
     * @return
     */
    public boolean addUserAddress(UserAddress userAddress ) {
     //  Integer userAddressId = null;
        try {
           // UserAddress userAddress=new UserAddress();
           // userAddress.setUserId(id);
           // userAddress.setAddress(address);
           // userAddress.setRemark(remark);
           return  userAddressDao.add(userAddress);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
       // return userAddressId;
    }

    @Override
    public UserAddress getUserAddressById(Integer id) {
        UserAddress userAddress= null;
        try {
            userAddress = (UserAddress) userAddressDao.getUserAddressById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
            return  userAddress;
    }
}
