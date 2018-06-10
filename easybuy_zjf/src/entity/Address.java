package entity;

import java.util.Date;

/**
 * 地址类
 * @author LENOVO
 *
 */
public class Address {
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	private int id;//自动编号，数据库的主键
	private String address;//地址
	private Date createTime;//创建时间
	private int userId;//用户的ID
	private int isDefault;//是否为默认
	private int remark;//备注
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getIsDefault() {
		return isDefault;
	}
	public void setIsDefault(int isDefault) {
		this.isDefault = isDefault;
	}
	public int getRemark() {
		return remark;
	}
	public void setRemark(int remark) {
		this.remark = remark;
	}
	
}
