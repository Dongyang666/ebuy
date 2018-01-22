package cn.easybuy.dao.productcategory;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.easybuy.dao.BaseDaoImpl;
import cn.easybuy.entity.ProductCategory;
import cn.easybuy.param.ProductCategoryParam;
import cn.easybuy.utils.EmptyUtils;
import cn.easybuy.utils.JdbcUtils;

public class ProductCategoryDaoImpl extends BaseDaoImpl <ProductCategory>implements ProductCategoryDao {	
	public ProductCategory mapToClass(Map<String,Object> map) throws Exception {
		ProductCategory productCategory = new ProductCategory();
		Object idObject=map.get("id");
		Object nameObject=map.get("name");
		Object parentIdObject=map.get("parentId");
		Object typeObject=map.get("type");
		Object iconClassObject=map.get("iconClass");
		Object parentNameObject=map.get("parentName");
		productCategory.setId(EmptyUtils.isEmpty(idObject)?null:(Integer)idObject);
		productCategory.setName(EmptyUtils.isEmpty(nameObject)?null:(String)nameObject);
		productCategory.setParentId(EmptyUtils.isEmpty(parentIdObject)?null:(Integer)parentIdObject);
		productCategory.setType(EmptyUtils.isEmpty(typeObject)?null:(Integer)typeObject);
		productCategory.setIconClass(EmptyUtils.isEmpty(iconClassObject)?null:(String)iconClassObject);
		productCategory.setParentName(EmptyUtils.isEmpty(parentNameObject)?null:(String)parentNameObject);
		return productCategory;
	}
	
	public List<ProductCategory> queryProductCategorylist(ProductCategoryParam params){
		//List<Object> paramsList=new ArrayList<Object>();
		StringBuffer sqlBuffer=new StringBuffer("SELECT epc1.*,epc2.name as parentName FROM productcategory epc1 LEFT JOIN productcategory epc2 ON epc1.parentId=epc2.id where 1=1 ");
		try{
			if(EmptyUtils.isNotEmpty(params.getName())){
				sqlBuffer.append(" and epc1.name like % '"+params.getName()+"'%");
				//paramsList.add("%"+params.getName()+"%");
			}
			if(EmptyUtils.isNotEmpty(params.getParentId())){
				sqlBuffer.append(" and epc1.parentId =  "+params.getParentId());
			//	paramsList.add(params.getParentId());
			}
			if(EmptyUtils.isNotEmpty(params.getType())){
				sqlBuffer.append(" and epc1.type = "+params.getType());
				//paramsList.add(params.getType());
			}
			if(params.isPage()){
				sqlBuffer.append(" limit  " + params.getStartIndex() + "," + params.getPageSize());
			}
			String sql=sqlBuffer.toString();
			return JdbcUtils.getQueryRunner().query(sql, new BeanListHandler<ProductCategory>(ProductCategory.class));
		}catch(Exception e){
			throw new RuntimeException();
		}


	}

	@Override
	public void deleteById(Integer id){
		super.delete(id);
	}

	public Integer queryProductCategoryCount(ProductCategoryParam params){
		StringBuffer sql=new StringBuffer("SELECT count(*) count FROM productcategory where 1=1 ");
		if(EmptyUtils.isNotEmpty(params.getName())){
			sql.append(" and name like % '"+params.getName()+"'% ");
		}
		if(EmptyUtils.isNotEmpty(params.getParentId())){
			sql.append(" and parentId = ? "+params.getParentId());
		}
		String sql1 =sql.toString();
		try {
			Long l= JdbcUtils.getQueryRunner().query(sql1, new ScalarHandler<Long>());
			return l.intValue();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	public ProductCategory queryProductCategoryById(Integer id){
		return super.findById(id);
	}
	
	public boolean add(ProductCategory productCategory)  {//新增用户信息
		return super.add(productCategory);
    }

	@Override
	public boolean update(ProductCategory productCategory) {

		return super.update(productCategory);
	}
	
	
}
