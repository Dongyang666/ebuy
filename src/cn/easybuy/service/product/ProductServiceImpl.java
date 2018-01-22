package cn.easybuy.service.product;
import java.util.List;

import cn.easybuy.dao.product.ProductDao;
import cn.easybuy.dao.product.ProductDaoImpl;
import cn.easybuy.entity.Product;
/**
 * 商品的业务类
 */
public class ProductServiceImpl implements ProductService {
	
	//private Logger logger = Logger.getLogger(ProductServiceImpl.class);
	
	@Override
	public boolean add(Product product) {
		try {
			ProductDao productDao = new ProductDaoImpl();
			return productDao.add(product);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		} 
	}

	@Override
	public boolean update(Product product) {
		try {
			ProductDao productDao = new ProductDaoImpl();
			return productDao.update(product);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		throw new RuntimeException();
		
	}

	@Override
	public boolean deleteProductById(Integer productId) {
		try {
			ProductDao productDao = new ProductDaoImpl();
			return productDao.deleteProductById(productId);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		throw new RuntimeException();
	}

	@Override
	public Product getProductById(Integer productId) {
		Product product=null;
		try {
			ProductDao productDao = new ProductDaoImpl();
			product=productDao.getProductById(productId);
		} catch (Exception e) {
			e.printStackTrace();
		} 
			return product;
		
	}

	@Override
	public List<Product> getProductList(Integer currentPageNo,Integer pageSize,String proName, Integer categoryId, Integer level) {
		List<Product> productList=null;
		try {
			ProductDao productDao = new ProductDaoImpl();
			productList=productDao.getProductList(currentPageNo,pageSize,proName,categoryId,level);
		} catch (Exception e) {
			e.printStackTrace();
		} 
			return productList;
		
	}

	@Override
	public int count(String proName,Integer categoryId, Integer level) {
		Integer count=0;
		try {
			ProductDao productDao = new ProductDaoImpl();
			count=productDao.queryProductCount(proName,categoryId,level);
		} catch (Exception e) {
			e.printStackTrace();
		} 
			
			return count;
		
	}

	@Override
	public boolean updateStock(Integer productId, Integer stock) {
		Integer count=0;
		try {
			ProductDao productDao = new ProductDaoImpl();
			count=productDao.updateStock(productId,stock);
		} catch (Exception e) {
			e.printStackTrace();
		} 
			return count>0;
		
	}
   
}
