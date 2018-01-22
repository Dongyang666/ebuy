package cn.easybuy.dao.order;
import java.util.List;


import cn.easybuy.dao.IBaseDao;
import cn.easybuy.entity.Orders;

/***
 * 订单处理的dao层
 * getRowCount
 * getRowList(Params params)
 * getById(Integer id)
 * addObject(Params params)
 */
public interface OrdersDao extends IBaseDao <Orders>{

	public boolean add(Orders orders) ;

	public boolean deleteById(Integer id);
	
	public Orders getOrdersById(Integer id) ;
	
	public List<Orders> getOrdersList(Integer userId,Integer currentPageNo,Integer pageSize) ;
	
	public Integer count(Integer userId);
	public int lastId();

}
