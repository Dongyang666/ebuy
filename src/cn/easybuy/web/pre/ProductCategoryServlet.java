package cn.easybuy.web.pre;
import cn.easybuy.web.AbstractServlet;

import javax.servlet.annotation.WebServlet;


@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/productCategory"},name = "productCategory")
public class ProductCategoryServlet extends AbstractServlet{

   
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
    public Class getServletClass() {
        return ProductCategoryServlet.class;
    }
}
