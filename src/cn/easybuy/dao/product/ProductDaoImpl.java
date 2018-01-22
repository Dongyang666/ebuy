package cn.easybuy.dao.product;

import java.util.List;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import cn.easybuy.dao.BaseDaoImpl;
import cn.easybuy.dao.product.ProductDao;
import cn.easybuy.entity.Product;
import cn.easybuy.utils.EmptyUtils;
import cn.easybuy.utils.JdbcUtils;
import cn.easybuy.utils.Pager;

public class ProductDaoImpl extends BaseDaoImpl<Product> implements ProductDao {
    public Integer updateStock(Integer id, Integer quantity) {
        	String sql = " update product set stock=? where id=? ";
        	try {
        return JdbcUtils.getQueryRunner().update(sql, quantity,id);
        	}catch(Exception e)
        	{
        		throw new RuntimeException();
        	}
    }

	@Override
	public boolean add(Product product) {
		return super.add(product);
	}

	@Override
	public boolean update(Product product) {
		return super.update(product);
	}

	@Override
	public boolean deleteProductById(Integer id)  {
		return super.delete(id);
	}

	@Override
	public Product getProductById(Integer id) {
		return super.findById(id);
	}

	@Override
	public List<Product> getProductList(Integer currentPageNo,Integer pageSize,String proName,Integer categoryId,Integer level) {
		StringBuffer sql=new StringBuffer("  select id,name,description,price,stock,categoryLevel1Id,categoryLevel2Id,categoryLevel3Id,fileName from product  where 1=1 ");
		try {
			if(EmptyUtils.isNotEmpty(proName)){
				sql.append(" and name like '%"+proName+"%'");
			}

			if(EmptyUtils.isNotEmpty(categoryId)){
				sql.append(" and (categoryLevel1Id = "+categoryId+" or categoryLevel2Id = "+categoryId+" or categoryLevel3Id="+categoryId+")");
			}
			int total = queryProductCount(proName,categoryId,level);
			Pager pager = new Pager(total, pageSize, currentPageNo);
			sql.append(" limit  " + (pager.getCurrentPage() - 1) * pager.getRowPerPage() + "," + pager.getRowPerPage());
			String sql1 =sql.toString();
		return JdbcUtils.getQueryRunner().query(sql1, new BeanListHandler<Product>(Product.class));
		}catch(Exception e){
			throw new RuntimeException();
		}
	}

	
	@Override
	public int queryProductCount(String proName,Integer categoryId,Integer level)  {
		StringBuffer sql=new StringBuffer("  select count(*) count from product where 1=1 ");
		if(EmptyUtils.isNotEmpty(proName)){
			sql.append(" and name like '%"+proName+"%'");
		}

		if(EmptyUtils.isNotEmpty(categoryId)){
			sql.append("and categoryLevel1Id ="+ categoryId +" or categoryLevel2Id="+categoryId +" or categoryLevel3Id="+categoryId );
		}
		try {
			Long l= JdbcUtils.getQueryRunner().query(sql.toString(), new ScalarHandler<Long>());
			return l.intValue();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	
}
