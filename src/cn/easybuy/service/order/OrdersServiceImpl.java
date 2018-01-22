package cn.easybuy.service.order;

import java.sql.Timestamp;
import java.util.*;

import cn.easybuy.dao.order.*;
import cn.easybuy.dao.orderdetail.OrderDetailDao;
import cn.easybuy.dao.orderdetail.OrderDetailDaoImpl;
import cn.easybuy.dao.product.ProductDao;
import cn.easybuy.dao.product.ProductDaoImpl;
import cn.easybuy.utils.*;
import cn.easybuy.entity.Orders;
import cn.easybuy.entity.OrderDetail;
import cn.easybuy.entity.User;

public class OrdersServiceImpl implements OrdersService {
	ProductDao productDao = new ProductDaoImpl();
    OrdersDao orderDao = new OrdersDaoImpl();
    OrderDetailDao orderDetailDao = new OrderDetailDaoImpl();

    /**
     * 结算购物车物品包含以下步骤：
     * 1.生成订单
     * 2.生成订单明细
     * 3.更新商品表，减库存
     * 注意加入事物的控制
     */

    @Override
    public Orders payShoppingCart(ShoppingCart cart, User user, String address) {
        Orders orders = new Orders();
        try {
            //增加订单
            orders.setUserId(user.getId());
            orders.setLoginName(user.getLoginName());
            orders.setUserAddress(address);
            orders.setCreateTime(new Timestamp(new Date().getTime()));
            orders.setCost(cart.getTotalCost());
            orders.setSerialNumber(StringUtils.randomUUID());
            orderDao.add(orders);
            int id=(orderDao).lastId();
            //增加订单对应的明细信息
            for (ShoppingCartItem item : cart.getItems()) {
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setOrderId(id);
                orderDetail.setCost(item.getCost());
                orderDetail.setQuantity(item.getQuantity());
                orderDetail.setProductId(item.getProduct().getId());
                orderDetailDao.add(orderDetail);
                //更新商品表的库存
                productDao.updateStock(item.getProduct().getId(), item.getQuantity());
            }
        } catch (Exception e) {
            e.printStackTrace();
            orders = null;
        } finally {
            try {
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return orders;
    }

    @Override
    public List<Orders> getOrdersList(Integer userId, Integer currentPageNo, Integer pageSize) {
        List<Orders> orderList = new ArrayList<Orders>();
        try {
            orderList = orderDao.getOrdersList(userId, currentPageNo, pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        } 
            return orderList;
       
    }

    @Override
    public int count(Integer userId) {
        Integer count=0;
        try {
            OrdersDao orderDao = new OrdersDaoImpl();
            count=orderDao.count(userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
		return count; 
        
    }

    /**
     * 调用dao接口：OrderDetailMapper的方法实现
     */
    @Override
    public List<OrderDetail> getOrderDetailList(Integer orderId) {
        List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
        try {
            orderDetailList = orderDetailDao.getOrderDetailList(orderId);
        } catch (Exception e) {
            e.printStackTrace();
        } 
            return orderDetailList;
    
    }
}
