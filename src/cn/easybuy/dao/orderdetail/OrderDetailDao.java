package cn.easybuy.dao.orderdetail;
import cn.easybuy.dao.IBaseDao;
import cn.easybuy.entity.OrderDetail;
import cn.easybuy.param.OrderDetailParam;
import java.util.List;

/**
 * 订单详细
 */
public interface OrderDetailDao extends IBaseDao<OrderDetail> {

    public boolean add(OrderDetail detail);

	public void deleteById(OrderDetail detail);
	
	public OrderDetail getOrderDetailById(Integer id); 
	
	public List<OrderDetail> getOrderDetailList(Integer orderId);
	
	public Integer queryOrderDetailCount(OrderDetailParam params)throws Exception; 
}
