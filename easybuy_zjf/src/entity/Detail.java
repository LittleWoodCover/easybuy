package entity;


/**
 * ���������
 * @author LENOVO
 *
 */

public class Detail {
	public Detail() {
		super();
		// TODO Auto-generated constructor stub
	}
	private int id;//���
	private int orderId;//�������
	private int productId;//��ƷId
	private int quantity;//��������
	private float cost;//�۸�
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
