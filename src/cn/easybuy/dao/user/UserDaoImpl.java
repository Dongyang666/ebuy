package cn.easybuy.dao.user;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.easybuy.dao.BaseDaoImpl;
import cn.easybuy.entity.User;
import cn.easybuy.utils.EmptyUtils;
import cn.easybuy.utils.JdbcUtils;
import cn.easybuy.utils.Pager;

/**
 * 用户dao
 */
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

    /**
     * 保存用户
     *
     * @param user
     * @throws java.sql.SQLException
     */
    public boolean add(User user){//新增用户信息
    	return super.add(user);
    }

    //更新用户信息
    public boolean update(User user) {
		return super.update(user);
		
    }

    public boolean deleteUserById(int id) {
		return super.delete(id);
	}

	@Override
	public List<User> getUserList(Integer currentPageNo,Integer pageSize) {
		StringBuffer sql =new StringBuffer("select id,loginName,password,userName,sex,identityCode,email,mobile,type from user where 1=1 ");
		try {
			int total = count();
			Pager pager = new Pager(total, pageSize, currentPageNo);
			sql.append(" limit  " + (pager.getCurrentPage() - 1) * pager.getRowPerPage() + "," + pager.getRowPerPage());
			String sql1 = sql.toString();
			return JdbcUtils.getQueryRunner().query(sql1, new BeanListHandler<User>(User.class));
	       }
		catch(Exception e){
		    throw new RuntimeException();
	       }
	}
	
	public Integer count()  {
		String sql=new String(" select count(*) count from user where 1=1 ");
		try {
			Long l= JdbcUtils.getQueryRunner().query(sql, new ScalarHandler<Long>());
			return l.intValue();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@Override
	public User getUser(Integer id,String loginName) {
		StringBuffer sql=new StringBuffer("  select * from user where 1=1  ");

		if(EmptyUtils.isNotEmpty(id)){
			sql.append(" and id= "+id);
			//paramsList.add(id);
		}

		if(EmptyUtils.isNotEmpty(loginName)){
			sql.append("and loginName= '"+loginName+"'");
			//paramsList.add(loginName);
		}
		try {
			return JdbcUtils.getQueryRunner().query(sql.toString(),new BeanHandler<User>(User.class));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} 
	}

}
