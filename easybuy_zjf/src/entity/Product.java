package entity;

public class Product {
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	private int id;//商品id
	private String name;//商品名
	private String description;//商品描述
	private float price;//商品价格
	private int stock;//商品库存
	private int categoryLevel1Id;//一级分类
	private int categoryLevel2Id;//二级分类
	private int categoryLevel3Id;//三级分类
	private String fileName;//上传文件名
	private int isDelete;//1为删除，2为未删除
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public int getCategoryLevel1Id() {
		return categoryLevel1Id;
	}
	public void setCategoryLevel1Id(int categoryLevel1Id) {
		this.categoryLevel1Id = categoryLevel1Id;
	}
	public int getCategoryLevel2Id() {
		return categoryLevel2Id;
	}
	public void setCategoryLevel2Id(int categoryLevel2Id) {
		this.categoryLevel2Id = categoryLevel2Id;
	}
	public int getCategoryLevel3Id() {
		return categoryLevel3Id;
	}
	public void setCategoryLevel3Id(int categoryLevel3Id) {
		this.categoryLevel3Id = categoryLevel3Id;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	
	
}
