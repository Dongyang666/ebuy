package cn.easybuy.newtag;


import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import cn.easybuy.dao.orderdetail.OrderDetailDao;
import cn.easybuy.dao.orderdetail.OrderDetailDaoImpl;
import cn.easybuy.entity.OrderDetail;

public class GetOrderDetailList extends SimpleTagSupport{
	private int  orderId;
	private String var;
	
	
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public void setVar(String var) {
		this.var = var;
	}

   @Override
	public void doTag() throws JspException, IOException{
	   
		PageContext pageContext =(PageContext)this.getJspContext();
		OrderDetailDao od = new OrderDetailDaoImpl();
		List<OrderDetail> list = od.getOrderDetailList(orderId);
		pageContext.setAttribute(var, list);
		this.getJspBody().invoke(null);
	}

	
	
}
