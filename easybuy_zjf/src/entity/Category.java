package entity;


/**
 * 商品分类
 * @author LENOVO
 *
 */
public class Category {
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	private Integer id;//商品分类标号，
	private String name;
	private Integer parentId;//父分类
	private String parentName;//父分级名称
	private Integer type;//1：1级分类，2：2级分类，3:3级分类
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
