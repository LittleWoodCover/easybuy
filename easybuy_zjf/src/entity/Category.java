package entity;


/**
 * ��Ʒ����
 * @author LENOVO
 *
 */
public class Category {
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	private Integer id;//��Ʒ�����ţ�
	private String name;
	private Integer parentId;//������
	private String parentName;//���ּ�����
	private Integer type;//1��1�����࣬2��2�����࣬3:3������
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	
}	
