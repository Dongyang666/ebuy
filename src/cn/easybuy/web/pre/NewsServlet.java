package cn.easybuy.web.pre;
import cn.easybuy.web.AbstractServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/News"}, name = "News")
public class NewsServlet extends AbstractServlet {

   
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
    public Class getServletClass() {
        return NewsServlet.class;
    }

    public String index(HttpServletRequest request, HttpServletResponse response)throws Exception{
        return "/pre/newsList";
    }

}
