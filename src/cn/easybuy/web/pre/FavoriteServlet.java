package cn.easybuy.web.pre;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.easybuy.dao.collect.CollectDaoImpl;
import cn.easybuy.entity.Collect;
import cn.easybuy.entity.Product;
import cn.easybuy.entity.User;
import cn.easybuy.service.product.ProductService;
import cn.easybuy.service.product.ProductServiceImpl;
import cn.easybuy.utils.ReturnResult;
import cn.easybuy.web.AbstractServlet;


@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/Favorite"}, name = "Favorite")
public class FavoriteServlet extends AbstractServlet {

	List<Product> rlist=null;
    private ProductService productService;

    public void init() throws ServletException {
        productService = new ProductServiceImpl();
        
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
    public Class getServletClass() {
        return FavoriteServlet.class;
    }

    /**
     * 跳转到历史记录
     *
     * @param request
     * @param response
     * @return
     */
    public String toFavoriteList(HttpServletRequest request, HttpServletResponse response)throws Exception {
    	List<Product> collect_list=null;
    	CollectDaoImpl con=new CollectDaoImpl();
    	HttpSession session = request.getSession();
        User user = (User) session.getAttribute("loginUser");
        if(user!=null){
         collect_list= con.getByUser_id(user.getId());
         Collections.reverse(collect_list);
         rlist=collect_list;
     	if(collect_list.size()<=7)
     	{
     		
     		request.setAttribute("Collect",collect_list);
     		
     	}
        }

        return "/pre/product/favoriteList";
    }

    /**
     * 添加到收藏
     *
     * @return
     */
    public  ReturnResult addFavorite(HttpServletRequest request, HttpServletResponse response)throws Exception {
        ReturnResult result = new ReturnResult();
        String id = request.getParameter("id");
        Product product = productService.getProductById(Integer.valueOf(id));
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("loginUser");
        CollectDaoImpl coll=new CollectDaoImpl();
        if(user!=null){
	    if(coll.isRepeat(user.getId(), product.getId()))
	     {
	       coll.add(new Collect(0, user.getId(), product.getId()));
	      }
        else
        {
        	coll.delete(user.getId(), product.getId());
        	coll.add(new Collect(0, user.getId(), product.getId()));
        }
	    result.returnSuccess();
      }
        else
        	result.returnFail("请登录");
		return result;
    }

   
}
