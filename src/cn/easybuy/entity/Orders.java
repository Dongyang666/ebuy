package cn.easybuy.entity;

import java.sql.Timestamp;

public class Orders  {

	private Integer id;//ID
	
	private Integer userId;//用户id
	private String loginName;//登录名称
	private String userAddress;//收货地址
	private Timestamp createTime;//创建时间
	private Float cost;//订单总计价格
	private String serialNumber;//订单号
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime =   createTime;
	}

	public Float getCost() {
		return cost;
	}

	public void setCost(Float cost) {
		this.cost = cost;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	@Override
	public int hashCode() {		
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Orders){
			if(((Orders)obj).id==id){
				return true;
			}			
		}	
		return false;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", userId=" + userId + ", loginName="
				+ loginName + ", userAddress=" + userAddress + ", createTime="
				+ createTime + ", cost=" + cost + ", serialNumber="
				+ serialNumber + "]";
	}
	
}
