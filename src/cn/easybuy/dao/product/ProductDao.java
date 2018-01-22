package cn.easybuy.dao.product;

import java.util.List;

import cn.easybuy.dao.IBaseDao;
import cn.easybuy.entity.Product;

/**
 * 商品查询Dao
 *
 * deleteById(Integer id)
 * getById(Integer id)
 * getRowCount(params)
 * getRowList(params)
 *
 */
public interface ProductDao extends IBaseDao<Product> {

	Integer updateStock(Integer id, Integer quantity);
	
	public boolean add(Product product);

	public boolean update(Product product);
	
	public boolean deleteProductById(Integer id) ;
	
	public Product getProductById(Integer id);
	
	public List<Product> getProductList(Integer currentPageNo,Integer pageSize,String proName,Integer categoryId,Integer level);
	
	public int queryProductCount(String proName,Integer categoryId,Integer level);
}
