package cn.easybuy.service.news;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.easybuy.dao.news.NewsDao;
import cn.easybuy.dao.news.NewsDaoImpl;
import cn.easybuy.entity.News;
import cn.easybuy.param.NewsParams;

/**
 *
 */
public class NewsServiceImpl implements NewsService {
	NewsDao newsDao = new NewsDaoImpl();
	
	public void deleteNews(String id) {// 删除新闻
		try {
			newsDao.deleteById(Integer.parseInt(id));
		}catch(Exception e){
		    new RuntimeException();
		}
		}

	public News findNewsById(String id) {// 根据ID获取新闻
		News news = null;
		try {
			NewsDao newsDao = new NewsDaoImpl();
			news = newsDao.getNewsById(Integer.parseInt(id));
		} catch (Exception e) {
			new RuntimeException();
			e.printStackTrace();
		}
		return news;
	}

	public void addNews(News news) {// 保存新闻
		try {
			NewsDao newsDao = new NewsDaoImpl();
			newsDao.add(news);
		} catch (Exception e) {
			e.printStackTrace();
			new RuntimeException();
		} 
	}

	public void updateNews(News news) {// 更新留言
		try {
			NewsDao newsDao = new NewsDaoImpl();
			newsDao.update(news);
		} catch (Exception e) {
			e.printStackTrace();
			new RuntimeException();
		} 
	}

	
	public List<News> queryNewsPageList(NewsParams param) throws SQLException {
		List<News> newsList=new ArrayList<News>();
		NewsDao newsDao =null;
		try {
			newsDao= new NewsDaoImpl();
			newsList=newsDao.queryNewsList(param);
		} catch (Exception e) {
			e.printStackTrace();
			new RuntimeException();
		} 
		return newsList;
	}
	
	@Override
	public List<News> queryNewsList(NewsParams param) {
		List<News> newsList=new ArrayList<News>();
		try {
			NewsDao newsDao = new NewsDaoImpl();
			newsList=newsDao.queryNewsList(param);
		} catch (Exception e) {
			e.printStackTrace();
			new RuntimeException();
		} 
		return newsList;
	}

	@Override
	public Integer queryNewsCount(NewsParams param) {
		Integer count=0;
		try {
			NewsDao newsDao = new NewsDaoImpl();
			count=newsDao.queryNewsCount(param);
		} catch (Exception e) {
			e.printStackTrace();
			new RuntimeException();
		} 
		return count;
	}

}
