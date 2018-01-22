package cn.easybuy.dao.order;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.easybuy.dao.BaseDaoImpl;
import cn.easybuy.entity.Orders;
import cn.easybuy.utils.EmptyUtils;
import cn.easybuy.utils.JdbcUtils;
import cn.easybuy.utils.Pager;
/**
 * 订单dao的实现类
 */
public class OrdersDaoImpl extends BaseDaoImpl<Orders> implements OrdersDao {
	/**
	 * 保存订单
	 * @param orders
	 * @return 
	 * @throws java.sql.SQLException
	 */
	
	public boolean add(Orders orders) {//保存订单
		return  super.add(orders);
		
		 
	}

	
	public boolean deleteById(Integer id) {
		return super.delete(id);
	}

	
	public Orders getOrdersById(Integer id) {
		return super.findById(id);
	}

	
	public List<Orders> getOrdersList(Integer userId,Integer currentPageNo,Integer pageSize) {
		StringBuffer sql=new StringBuffer(" select * from orders  where 1=1 ");
		if(EmptyUtils.isNotEmpty(userId)){
			sql.append(" and userId = "+userId);
		}
		int total = count(userId);
		Pager pager = new Pager(total, pageSize, currentPageNo);
		sql.append(" limit  " + (pager.getCurrentPage() - 1) * pager.getRowPerPage() + "," + pager.getRowPerPage());
		String sql1 =sql.toString();
		try {
			return JdbcUtils.getQueryRunner().query(sql1, new BeanListHandler<Orders>(Orders.class));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	
	public Integer count(Integer userId)  {
		StringBuffer sql=new StringBuffer(" select count(id) count from orders  where 1=1 ");
		if(EmptyUtils.isNotEmpty(userId)){
			sql.append(" and userId = "+userId);
		}
		String sql1=sql.toString();
		try {
			Long l= JdbcUtils.getQueryRunner().query(sql1, new ScalarHandler<Long>());
			return l.intValue();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
}
	public int lastId(){
		String sql="select max(id) from orders";
		Integer l;
		try {
			l = JdbcUtils.getQueryRunner().query(sql, new ScalarHandler<Integer>());
			return l.intValue();
		} catch (SQLException e) {
		}
		throw new RuntimeException();
	}
}
