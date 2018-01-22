package cn.easybuy.dao.collect;

import java.util.List;

import cn.easybuy.dao.IBaseDao;
import cn.easybuy.entity.Collect;
import cn.easybuy.entity.Product;

/**
 *@author 刘东阳
 *@time：2017年8月24日上午10:06:22
 *
 */
public interface ICollectDao extends IBaseDao<Collect>{
	//通过用户id查询收藏商品返回集合
	public List<Product> getByUser_id(int user_id);
	//添加收藏信息
	public boolean add(Collect col);
	//删除收藏信息
	public void delete(int user_id,int pro_id);

}
