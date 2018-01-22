package cn.easybuy.dao.news;

import java.util.List;

import cn.easybuy.dao.IBaseDao;
import cn.easybuy.entity.News;
import cn.easybuy.param.NewsParams;

/**
 * 新闻的dao
 */
public interface NewsDao extends IBaseDao<News> {

	public List<News> queryNewsList(NewsParams params); 
	/**
	 * 查询新闻的数目
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public Integer queryNewsCount(NewsParams params);
	public boolean add(News news);
	public boolean update(News news) ;
	public boolean deleteById(Integer id);
	public News getNewsById(Integer id);
}
