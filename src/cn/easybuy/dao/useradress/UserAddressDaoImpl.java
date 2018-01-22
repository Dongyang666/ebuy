package cn.easybuy.dao.useradress;
import cn.easybuy.dao.BaseDaoImpl;
import cn.easybuy.entity.UserAddress;
import cn.easybuy.param.UserAddressParam;
import cn.easybuy.utils.EmptyUtils;
import cn.easybuy.utils.JdbcUtils;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 * Created by bdqn on 2016/5/12.
 */
public class UserAddressDaoImpl extends BaseDaoImpl<UserAddress> implements UserAddressDao {

  
	@Override
	public List<UserAddress> queryUserAddressList(UserAddressParam params) {
		StringBuffer sql=new StringBuffer("  select * from useraddress  where 1=1 ");
		if(EmptyUtils.isNotEmpty(params.getUserId())){
			sql.append(" and userId =  "+params.getUserId());
		}
		if(EmptyUtils.isNotEmpty(params.getAddress())){
			sql.append(" and address like  %'"+params.getAddress()+"'%");
		}
		if(EmptyUtils.isNotEmpty(params.getSort())){
			sql.append(" order by " + params.getSort()+" ");
		}
		if(params.isPage()){
			sql.append(" limit " + params.getStartIndex() + "," + params.getPageSize());
		}
		String sql1 = sql.toString();
		try {
			return JdbcUtils.getQueryRunner().query(sql1, new BeanListHandler<UserAddress>(UserAddress.class));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public boolean add(UserAddress userAddress) {
		
		return super.add(userAddress);
	}

	@Override
	public UserAddress getUserAddressById(Integer addressId) {
		return super.findById(addressId);
}
}
