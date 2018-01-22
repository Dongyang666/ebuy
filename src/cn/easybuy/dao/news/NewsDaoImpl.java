package cn.easybuy.dao.news;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.easybuy.dao.BaseDaoImpl;
import cn.easybuy.entity.News;
import cn.easybuy.param.NewsParams;
import cn.easybuy.utils.EmptyUtils;
import cn.easybuy.utils.JdbcUtils;

public class NewsDaoImpl extends BaseDaoImpl<News> implements NewsDao {

	@Override
	public boolean add(News news) {// 保存新闻
		return super.add(news);
	}
	@Override
	public boolean update(News news)  {
		return super.update(news);// 更新新闻
		
	}
	@Override
	public boolean deleteById(Integer id)  {
		return super.delete(id);
	}
	@Override
	public News getNewsById(Integer id) {
		return super.findById(id);
	}

	@Override
	public List<News> queryNewsList(NewsParams params) {
		StringBuffer sqlbu=new StringBuffer(" select id,title,content,createTime FROM news where 1=1 ");
		if(EmptyUtils.isNotEmpty(params.getTitle())){
			sqlbu.append(" and title like ? "+params.getTitle());
			//paramsList.add(params.getTitle());
		}
		if(EmptyUtils.isNotEmpty(params.getSort())){
			sqlbu.append(" order by " + params.getSort()+" ");
		}
		if(params.isPage()){
			sqlbu.append(" limit  " + params.getStartIndex() + "," + params.getPageSize());
		}
		String sql = sqlbu.toString();
		try {
			return JdbcUtils.getQueryRunner().query(sql, new BeanListHandler<News>(News.class));
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
	
	@Override
	public Integer queryNewsCount(NewsParams params) {
		StringBuffer sql=new StringBuffer(" select count(*) as count FROM news where 1=1 ");
		if(EmptyUtils.isNotEmpty(params.getTitle())){
			sql.append(" and title like ? "+params.getTitle());
		}
		String sql1 =sql .toString();
		try {
			Long l= JdbcUtils.getQueryRunner().query(sql1, new ScalarHandler<Long>());
			return l.intValue();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		

	}	
}
