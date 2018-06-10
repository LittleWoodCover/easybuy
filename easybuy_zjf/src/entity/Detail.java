package entity;


/**
 * 订单详情表
 * @author LENOVO
 *
 */

public class Detail {
	public Detail() {
		super();
		// TODO Auto-generated constructor stub
	}
	private int id;//编号
	private int orderId;//订单编号
	private int productId;//产品Id
	private int quantity;//订单数量
	private float cost;//价格
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	
	
	
}
