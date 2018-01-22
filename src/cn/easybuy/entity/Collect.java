package cn.easybuy.entity;
/**
 *@author 刘东阳
 *@time：2017年8月24日上午10:03:50
 *
 */
public class Collect {
	private int id;
	private int user_id;
	private int  product_id;
	public Collect() {
		
	}
	public Collect(int id, int user_id, int product_id) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.product_id = product_id;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the user_id
	 */
	public int getUser_id() {
		return user_id;
	}
	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	/**
	 * @return the product_id
	 */
	public int getProduct_id() {
		return product_id;
	}
	/**
	 * @param product_id the product_id to set
	 */
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	@Override
	public String toString() {
		return "Collect [id=" + id + ", user_id=" + user_id + ", product_id="
				+ product_id + "]";
	}
	

}
