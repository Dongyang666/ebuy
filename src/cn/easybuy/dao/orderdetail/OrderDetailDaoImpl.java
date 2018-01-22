package cn.easybuy.dao.orderdetail;
import cn.easybuy.dao.BaseDaoImpl;
import cn.easybuy.dao.product.ProductDao;
import cn.easybuy.entity.OrderDetail;
import cn.easybuy.param.OrderDetailParam;
import cn.easybuy.utils.EmptyUtils;
import cn.easybuy.utils.JdbcUtils;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

public class OrderDetailDaoImpl extends BaseDaoImpl<OrderDetail> implements OrderDetailDao{

    ProductDao productDao;
    public boolean add(OrderDetail detail)  {//保存订单详情
       return super. add(detail);
    }

	@Override
	public void deleteById(OrderDetail detail) {
		int id =detail.getId();
		super.delete(id);
	}

	@Override
	public OrderDetail getOrderDetailById(Integer id) {
		return super.findById(id);
	}

	@Override
	public List<OrderDetail> getOrderDetailList(Integer orderId)
	 {
		StringBuffer sql = new StringBuffer(" select * FROM orderdetail where 1=1 ");
		
		if(EmptyUtils.isNotEmpty(orderId)){
			sql.append(" and orderId="+orderId);
		}
		String sql1 = sql.toString();
		try {
			return JdbcUtils.getQueryRunner().query(sql1, new BeanListHandler<OrderDetail>(OrderDetail.class));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}

	}

	@Override
	public Integer queryOrderDetailCount(OrderDetailParam params)throws Exception {
		String sql = " select count(*) FROM orderdetail ";
		Long l= JdbcUtils.getQueryRunner().query(sql, new ScalarHandler<Long>());
		return l.intValue();

}
}
