package cn.easybuy.utils;

import cn.easybuy.entity.Orders;
import cn.easybuy.entity.OrderDetail;
import java.util.List;


public class OrderVo {
    private Orders orders;
    private List<OrderDetail> orderDetailList;

    public Orders getOrder() {
        return orders;
    }

    public void setOrder(Orders orders) {
        this.orders = orders;
    }

    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }
}
