package cn.easybuy.dao.user;

import java.util.List;
import cn.easybuy.dao.IBaseDao;
import cn.easybuy.entity.User;

/***
 * UserDao 用户业务的dao层
 * 从父类继承下的被使用的方法
 * User getById(userId);
 * Integer userDao.getRowCount(params);
 * List<User> userDao.getRowList(params);
 */
public interface UserDao extends IBaseDao<User> {

	boolean add(User user);//新增用户信息

	boolean update(User user);//更新用户信息

	public boolean deleteUserById(int id) ;
	
	public List<User> getUserList(Integer currentPageNo,Integer pageSize);
	
	public Integer count() ;
	
	public User getUser(Integer id,String loginName);
}
