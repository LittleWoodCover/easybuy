package entity;

import java.util.Date;

/**
 * ��ַ��
 * @author LENOVO
 *
 */
public class Address {
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	private int id;//�Զ���ţ����ݿ������
	private String address;//��ַ
	private Date createTime;//����ʱ��
	private int userId;//�û���ID
	private int isDefault;//�Ƿ�ΪĬ��
	private int remark;//��ע
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
