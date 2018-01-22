package cn.easybuy.newtag;


import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import cn.easybuy.dao.product.ProductDao;
import cn.easybuy.dao.product.ProductDaoImpl;
import cn.easybuy.entity.Product;

public class FindProduct extends SimpleTagSupport{
	private int  productId;
	private String var;
	
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public void setVar(String var) {
		this.var = var;
	}
@Override
public void doTag() throws JspException, IOException {
	
	PageContext pageContext =(PageContext)this.getJspContext();

	ProductDao pd  = new ProductDaoImpl();
	Product p = pd.getProductById(productId);
	pageContext.setAttribute(var, p);
	this.getJspBody().invoke(null);
}
	

	
	
}
