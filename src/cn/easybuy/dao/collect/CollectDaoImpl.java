package cn.easybuy.dao.collect;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import cn.easybuy.dao.BaseDaoImpl;
import cn.easybuy.entity.Collect;
import cn.easybuy.entity.Product;
import cn.easybuy.utils.JdbcUtils;

/**
 *@author 刘东阳
 *@time：2017年8月24日上午10:11:15
 *
 */
public class CollectDaoImpl extends BaseDaoImpl <Collect> implements ICollectDao {

	

	@Override
	public List<Product> getByUser_id(int user_id) {
		int count=this.getCount(user_id);
		if(count<=6){
			count=0;
		}else
		{
			count=count-6;
		}
		String sql="select * from collect c,product p where p.id=c.product_id and c.user_id=? limit "+count+",6 ";
		try {
			return JdbcUtils.getQueryRunner().query(sql, new BeanListHandler<Product>(Product.class),user_id);
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		}
		
		
		
		
	
	public int getCount(int user_id){
		Connection con=null;
		
		con=JdbcUtils.getConnection();
		String sql="SELECT COUNT(*) FROM collect WHERE user_id=? ";
		try {
			Long count1 = JdbcUtils.getQueryRunner().query(sql, new ScalarHandler<Long>(),user_id);
			
			return count1.intValue();
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally
		{
			try {
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		
	}

	@Override
	public boolean add(Collect col) {
		return super.add(col);
		}
		
	

	public void delete(int user_id,int pro_id) {
		String sql="DELETE FROM collect  WHERE  user_id=? AND product_id=?";
		try {
			JdbcUtils.getQueryRunner().update(sql,user_id,pro_id);
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		}
		
		
	public List<Product> getUser_idByProduct(int product_id) {
		
		String sql="select * from collect c where  c.product_id=?";
		try {
			return JdbcUtils.getQueryRunner().query(sql, new BeanListHandler<Product>(Product.class),product_id);
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	 
	public Boolean isRepeat(int user_id,int pro_id){
		String sql="select * from collect c where  c.user_id=? and c.product_id=?";
		try {
			 Collect query = JdbcUtils.getQueryRunner().query(sql, new BeanHandler<Collect>(Collect.class),user_id,pro_id);
			 if(query==null){
				 return true;
			 }
			 else
				 return false;
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		}
		

	
	

}
