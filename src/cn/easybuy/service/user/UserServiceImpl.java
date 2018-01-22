package cn.easybuy.service.user;
import java.util.List;

import cn.easybuy.dao.user.UserDao;
import cn.easybuy.dao.user.UserDaoImpl;
import cn.easybuy.entity.User;

public class UserServiceImpl implements UserService {
	
	//private Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	@Override
	public boolean add(User user){
		try {
			UserDao userDao = new UserDaoImpl();
		  return userDao.add(user);
		
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public boolean update(User user) {
		try {
			UserDao userDao = new UserDaoImpl();
			return userDao.update(user);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public boolean deleteUserById(Integer userId) {
		try {
			UserDao userDao = new UserDaoImpl();
			return userDao.deleteUserById(userId);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public User getUser(Integer userId, String loginName) {
		User user=null;
		try {
			UserDao userDao = new UserDaoImpl();
			user=userDao.getUser(userId,loginName);
		} catch (Exception e) {
			e.printStackTrace();
		}
			return user;
	}

	@Override
	public List<User> getUserList(Integer currentPageNo, Integer pageSize) {
		List<User> userList=null;
		try {
			UserDao userDao = new UserDaoImpl();
			userList=userDao.getUserList(currentPageNo,pageSize);
		} catch (Exception e) {
			e.printStackTrace();
		}
			return userList;
	}

	@Override
	public int count() {
		Integer count=null;
		try {
			UserDao userDao = new UserDaoImpl();
			count=userDao.count();
		} catch (Exception e) {
			e.printStackTrace();
		}
			return count;
	}
}
